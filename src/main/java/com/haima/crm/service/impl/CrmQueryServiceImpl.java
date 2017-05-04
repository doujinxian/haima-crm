package com.haima.crm.service.impl;

import com.haima.crm.dao.ComplaintStatisticsDao;
import com.haima.crm.dao.CrmCustomerCarQueryDao;
import com.haima.crm.dto.CarQueryDto;
import com.haima.crm.dto.CustomerCarDto;
import com.haima.crm.service.CrmQueryService;
import com.haima.crm.vo.CarInfoVo;
import com.haima.crm.vo.CrmCustomerCarVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lushaozhong
 * @version 1.0
 * @date 2017-04-15 22:01
 */
@Service("CrmQueryService")
public class CrmQueryServiceImpl implements CrmQueryService {
	@Autowired
	private CrmCustomerCarQueryDao crmCustomerCarQueryDao;

	@Override
	public List<CustomerCarDto> queryCustomerCarList(CrmCustomerCarVo crmCustomerCarVo) {
		return crmCustomerCarQueryDao.queryCustomerCarList(crmCustomerCarVo);
	}

	@Override
	public int queryCustomerCarTotal(CrmCustomerCarVo crmCustomerCarVo) {
		return crmCustomerCarQueryDao.queryCustomerCarTotal(crmCustomerCarVo);
	}

	@Override
	public List<CarInfoVo> queryCarInfoList(CarQueryDto carQueryDTO) {
		return crmCustomerCarQueryDao.queryCarInfoList(carQueryDTO);
	}

	@Override
	public int queryCarInfoListTotal(CarQueryDto carQueryDTO) {
		return crmCustomerCarQueryDao.queryCarInfoListTotal(carQueryDTO);
	}
}
