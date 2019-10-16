package com.cofire.console.controller.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.common.constant.CodeEnum;
import com.cofire.common.constant.Constants;
import com.cofire.common.result.Result;
import com.cofire.common.result.SystemUtil;
import com.cofire.common.utils.bean.BeanUtil;
import com.cofire.console.config.log.BussinessLog;
import com.cofire.console.service.sytem.IUserService;
import com.cofire.dao.model.custom.Menu;
import com.cofire.dao.model.custom.UserDetailModel;
import com.cofire.dao.model.system.SysUser;

@RestController
@RequestMapping
public class BaseController {
    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);
    @Autowired
    private IUserService userService;

    @BussinessLog("获取用户菜单")
    @RequestMapping("/getUserDetail")
    public Result getUserDetail(HttpServletRequest request) {
        logger.info("正在获取用户菜单");
        Result result = new Result();
        UserDetailModel<Menu> userDetail = new UserDetailModel<Menu>();
        try {
            List<Menu> menus = new ArrayList<>(); // 菜单
            Menu nav = new Menu();
            nav.setText("导航");
            nav.setHeading(true);

            Session session = SecurityUtils.getSubject().getSession();
            SysUser user = (SysUser) session.getAttribute(Constants.SESSION_USER_INFO);
            String userId = user.getUserId();
            logger.info("当前登录用户的id：" + userId);
            logger.info("当前登录用户的权限：" + session.getAttribute(Constants.SESSION_USER_PERMISSION));
            userDetail.setUserId(userId);
            userDetail.setUserName(user.getUserName());
            List<Map<String, String>> dataList = userService.getUserResource(userId);
            List<Map<String, String>> parent = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(dataList)) {
                for (Map<String, String> map : dataList) {
                    if (map.get("leaf").equals("0")) {
                        parent.add(map);
                    }
                }
                dataList.removeAll(parent);
                @SuppressWarnings("unchecked")
                Map<String, List<Map<String, String>>> parentMap = BeanUtil.groupBeanList(dataList, "parentId");
                if (CollectionUtils.isNotEmpty(parent)) {
                    for (Map<String, String> par : parent) {
                        Menu menu = new Menu();
                        menu.setData(par.get("id"));
                        menu.setText(par.get("text"));
                        menu.setLink(par.get("url"));
                        List<Menu> childs = new ArrayList<>();
                        List<Map<String, String>> childrens = parentMap.get(par.get("id"));
                        if (CollectionUtils.isNotEmpty(childrens)) {
                            for (Map<String, String> child : childrens) {
                                Menu ch = new Menu();
                                ch.setData(child.get("id"));
                                ch.setText(child.get("text"));
                                ch.setLink(child.get("url"));
                                childs.add(ch);
                            }
                        }
                        if (CollectionUtils.isNotEmpty(childs)) {
                            menu.setSubmenu(childs);
                        } else {
                            menu.setSubmenu("");
                        }
                        menus.add(menu);
                    }
                }
            }
            // 公共设置
            HashMap<String, String> commonMap = new HashMap<>();
            userDetail.setCommon(commonMap);
            userDetail.setMenuList(menus);
            result.setSuccess(true);
            result.setData(userDetail);
        } catch (Exception e) {
            logger.error("获取用户信息异常：" + e);
            result.setMessage("服务器忙!!请稍后再试");
            result.setSuccess(false);
        }
        return result;
    }

    @BussinessLog("获取数据字典")
    @RequestMapping("/getDictByGroup")
    public Result getDictByGroup(String groupCode) {
        Result result = new Result(CodeEnum.E_500);
        if (StringUtils.isEmpty(groupCode)) {

            return result;
        }
        List<Map<String, String>> dictList = SystemUtil.getDictList(groupCode);
        result.setData(dictList);
        result.setSuccess(true, CodeEnum.E_200);
        return result;
    }
}
