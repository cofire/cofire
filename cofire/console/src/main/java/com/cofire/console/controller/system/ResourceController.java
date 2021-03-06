package com.cofire.console.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cofire.common.constant.CodeEnum;
import com.cofire.common.constant.Constants;
import com.cofire.common.result.Result;
import com.cofire.console.config.log.BussinessLog;
import com.cofire.console.service.sytem.IResourceService;
import com.cofire.dao.model.system.SysResource;

/**
 * @author ly
 * @version V1.0
 * @ClassName: ResourceController
 * @Description:菜单
 * @date 2019年12月4日
 */
@RestController
@RequestMapping(value = "/console/resource")
public class ResourceController extends SystemBaseController {

    @Autowired
    private IResourceService resourceService;

    @BussinessLog("查询菜单信息")
    @RequestMapping(value = "/query", method = {RequestMethod.POST})
    public Result queryResource() {
        return resourceService.query();
    }

    @BussinessLog(value = "保存菜单信息", operation = Constants.OPERATION_SAVE)
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Result saveResource(String operation, SysResource resource) {
        Result result = new Result();
        result.setSuccess(false, CodeEnum.E_400);
        if (Constants.OPERATION_ADD.equalsIgnoreCase(operation)) {
            return resourceService.add(resource);
        }
        if (Constants.OPERATION_UPDATE.equalsIgnoreCase(operation)) {
            return resourceService.update(resource);
        }
        return result;
    }

    @BussinessLog(value = "删除菜单信息", operation = Constants.OPERATION_DELETE)
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public Result deleteResource(SysResource resource) {
        return resourceService.delete(resource);
    }

}
