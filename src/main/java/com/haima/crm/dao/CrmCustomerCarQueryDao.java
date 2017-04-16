package com.haima.crm.dao;

import com.haima.crm.dto.CustomerCarDTO;
import com.haima.crm.entity.ComplaintStatistics;
import com.haima.crm.entity.ComplaintStatisticsSatisfaction;
import com.haima.crm.vo.ComplaintStatisticsVo;
import com.haima.crm.vo.CrmCustomerCarVo;

import java.util.List;

/**
 * @author lushaozhong
 * @email fengying9814@163.com
 * @date 2017-04-15 19:52
 */
public interface CrmCustomerCarQueryDao extends BaseDao<CrmCustomerCarVo> {
    List<CustomerCarDTO> queryCustomerCarList(CrmCustomerCarVo t);
    int queryCustomerCarTotal(CrmCustomerCarVo t);
}
