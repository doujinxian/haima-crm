package com.haima.crm.service;

import com.haima.crm.dto.CustomerCarDTO;
import com.haima.crm.vo.CrmCustomerCarVo;

import java.util.List;

/**
 * @author lushaozhong
 * @version 1.0
 * @date 2017-04-15 22:01
 */
public interface CrmQueryService {
    List<CustomerCarDTO> queryCustomerCarList(CrmCustomerCarVo crmCustomerCarVo);

    int queryCustomerCarTotal(CrmCustomerCarVo crmCustomerCarVo);
}
