package com.haima.crm.dao;

import java.util.List;

import com.haima.crm.dto.CarQueryDto;
import com.haima.crm.dto.CustomerCarDto;
import com.haima.crm.vo.CarInfoVo;
import com.haima.crm.vo.CrmCustomerCarVo;

/**
 * @author lushaozhong
 * @email fengying9814@163.com
 * @date 2017-04-15 19:52
 */
public interface CrmCustomerCarQueryDao extends BaseDao<CrmCustomerCarVo> {
    List<CustomerCarDto> queryCustomerCarList(CrmCustomerCarVo t);
    int queryCustomerCarTotal(CrmCustomerCarVo t);
	List<CarInfoVo> queryCarInfoList(CarQueryDto carQueryDTO);
	int queryCarInfoListTotal(CarQueryDto carQueryDTO);
}
