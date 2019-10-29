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

@RestController
public class ResourceController extends SystemBaseController {

    @Autowired
    private IResourceService resourceService;

    @BussinessLog("查询菜单信息")
    @RequestMapping(value = "/resource/query", method = { RequestMethod.POST })
    public Result queryResource() {
        return resourceService.query();
    }

    @BussinessLog("保存菜单信息")
    @RequestMapping(value = "/resource/save", method = { RequestMethod.POST })
    public Result saveResource(String saveFlag, SysResource resource) {
        Result result = new Result();
        result.setSuccess(false, CodeEnum.E_400);
        if (Constants.FLAG_ADD.equalsIgnoreCase(saveFlag)) {
            return resourceService.add(resource);
        }
        if (Constants.FLAG_UPDATE.equalsIgnoreCase(saveFlag)) {
            return resourceService.upadte(resource);
        }
        return result;
    }

    @BussinessLog("删除菜单信息")
    @RequestMapping(value = "/resource/delete", method = { RequestMethod.POST })
    public Result deleteResource(SysResource resource) {
        return resourceService.delete(resource);
    }

}
