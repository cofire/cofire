package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.QtzJobLog;

/**
 * @author ly
 * @version V1.0
 * @ClassName: IJobLogService
 * @Description:定时任务日志
 * @date 2019年12月4日
 */
public interface IJobLogService {

    /**
     * 定时任务日志查询
     *
     * @param paramItem
     * @param jobLog
     * @return
     */
    Result query(ParamItem paramItem, QtzJobLog jobLog);
}
