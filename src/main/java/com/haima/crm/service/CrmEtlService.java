package com.haima.crm.service;

import com.haima.crm.entity.CrmEtlParameter;

/**
 * @author lushaozhong
 * @version 1.0
 * @date 2017-05-21 18:10
 */
public interface CrmEtlService {

    CrmEtlParameter getEtlParameter(String jobName);

    CrmEtlParameter updateEtlParameter(CrmEtlParameter crmEtlParameter);
}
