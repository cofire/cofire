package com.cofire.console.service.sytem;

import com.cofire.common.result.ParamItem;
import com.cofire.common.result.Result;
import com.cofire.dao.model.system.QtzJob;

public interface IJobService {

    Result query(ParamItem paramItem, QtzJob job);

    Result add(QtzJob job);

    Result upadte(QtzJob job);

    Result delete(QtzJob job);
}
