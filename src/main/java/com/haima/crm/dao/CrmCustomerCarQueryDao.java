package com.haima.crm.dao;

import java.util.List;

import com.haima.crm.dto.CustomerCarDTO;
import com.haima.crm.vo.CrmCustomerCarVo;

/**
 * @author lushaozhong
 * @email fengying9814@163.com
 * @date 2017-04-15 19:52
 */
public interface CrmCustomerCarQueryDao extends BaseDao<CrmCustomerCarVo> {
    List<CustomerCarDTO> queryCustomerCarList(CrmCustomerCarVo t);
    int queryCustomerCarTotal(CrmCustomerCarVo t);
}
