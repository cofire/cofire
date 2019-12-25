package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.QtzJob;

/**
 * 定时任务
 *
 * @author ly
 * @version V1.0
 * @ClassName: IJobService
 * @Description:
 * @date 2019年12月4日
 */
public interface IJobService {
    /**
     * 定时任务查询
     *
     * @param paramItem
     * @param job
     * @return
     */
    Result query(ParamItem paramItem, QtzJob job);

    /**
     * 定时任务新增
     *
     * @param job
     * @return
     */
    Result add(QtzJob job);

    /**
     * 定时任务更新
     *
     * @param job
     * @return
     */
    Result update(QtzJob job);

    /**
     * 定时任务删除
     *
     * @param job
     * @return
     */
    Result delete(QtzJob job);
}
