package com.cofire.console.controller.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.common.constant.CodeEnum;
import com.cofire.common.result.Result;
import com.cofire.common.result.SystemUtil;
import com.cofire.common.utils.bean.BeanUtil;
import com.cofire.console.common.CurrentUserUtil;
import com.cofire.console.config.log.BussinessLog;
import com.cofire.console.service.sytem.IUserService;
import com.cofire.dao.model.custom.Menu;
import com.cofire.dao.model.custom.UserDetailModel;
import com.cofire.dao.model.system.SysUser;

/**
 * @author ly
 * @version V1.0
 * @ClassName: BaseController
 * @Description:基础controller
 * @date 2019年12月4日
 */
@RestController
@RequestMapping
public class BaseController {
    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);
    @Autowired
    private IUserService userService;

    @BussinessLog(value = "获取用户菜单", value = "获取用户菜单2")
    @RequestMapping("/getUserDetail")
    public Result getUserDetail(HttpServletRequest request) {
        logger.info("正在获取用户菜单");
        Result result = new Result();
        UserDetailModel<SysUser, Menu> userDetail = new UserDetailModel<SysUser, Menu>();
        try {
            List<Menu> menus = new ArrayList<>();
            SysUser user = CurrentUserUtil.getCurrentUser();
            String userId = user.getUserId();
            logger.info("当前登录用户的id：" + userId);
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
                        menu.setId(par.get("id"));
                        menu.setName(par.get("name"));
                        menu.setUrl(par.get("url"));
                        menu.setIcon(par.get("icon"));
                        List<Menu> childs = new ArrayList<>();
                        List<Map<String, String>> childrens = parentMap.get(par.get("id"));
                        if (CollectionUtils.isNotEmpty(childrens)) {
                            for (Map<String, String> child : childrens) {
                                Menu subMenu = new Menu();
                                subMenu.setId(child.get("id"));
                                subMenu.setName(child.get("name"));
                                subMenu.setUrl(child.get("url"));
                                subMenu.setIcon(child.get("icon"));
                                subMenu.setParentId(child.get("parentId"));
                                childs.add(subMenu);
                            }
                        }
                        if (CollectionUtils.isNotEmpty(childs)) {
                            menu.setSubMenu(childs);
                        } else {
                            menu.setSubMenu("");
                        }
                        menus.add(menu);
                    }
                }
            }
            userDetail.setUser(user);
            userDetail.setMenuList(menus);
            userDetail.setDictList(SystemUtil.getDictGroupMap());
            result.setSuccess(true);
            result.setData(userDetail);
        } catch (Exception e) {
            logger.error("获取用户信息异常：" + e);
            result.setMessage("服务器忙!请稍后再试");
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
