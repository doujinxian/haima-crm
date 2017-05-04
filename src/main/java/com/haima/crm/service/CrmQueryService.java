package com.haima.crm.service;

import com.haima.crm.dto.CarQueryDto;
import com.haima.crm.dto.CustomerCarDto;
import com.haima.crm.vo.CarInfoVo;
import com.haima.crm.vo.CrmCustomerCarVo;

import java.util.List;

/**
 * @author lushaozhong
 * @version 1.0
 * @date 2017-04-15 22:01
 */
public interface CrmQueryService {
    List<CustomerCarDto> queryCustomerCarList(CrmCustomerCarVo crmCustomerCarVo);

    int queryCustomerCarTotal(CrmCustomerCarVo crmCustomerCarVo);

	List<CarInfoVo> queryCarInfoList(CarQueryDto carQueryDTO);

	int queryCarInfoListTotal(CarQueryDto carQueryDTO);
}
