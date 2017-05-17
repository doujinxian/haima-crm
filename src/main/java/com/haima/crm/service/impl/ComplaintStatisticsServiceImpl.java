package com.haima.crm.service.impl;

import com.haima.crm.constants.StatisticsTypeConfig;
import com.haima.crm.dao.ComplaintStatisticsDao;
import com.haima.crm.entity.ComplaintStatistics;
import com.haima.crm.entity.ComplaintStatisticsSatisfaction;
import com.haima.crm.service.ComplaintStatisticsService;
import com.haima.crm.vo.ComplaintStatisticsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author lushaozhong
 * @email fengying9814@163.com
 * @date 2017-04-08 19:47
 */
@Service("complaintStatisticsService")
public class ComplaintStatisticsServiceImpl implements ComplaintStatisticsService {
    @Autowired
    private ComplaintStatisticsDao complaintStatisticsDao;

    @Override
    public List<ComplaintStatistics> queryAnalysisList(ComplaintStatisticsVo complaintStatisticsVo) {
        List<ComplaintStatistics>  complaintStatisticses= complaintStatisticsDao.queryAnalysisList(complaintStatisticsVo);
        return complaintStatisticses;
    }

    @Override
    public int queryAnalysisTotal(ComplaintStatisticsVo complaintStatisticsVo) {
        return complaintStatisticsDao.queryAnalysisTotal(complaintStatisticsVo);
    }

    @Override
    public List<ComplaintStatisticsSatisfaction> querySatisfactionList(ComplaintStatisticsVo complaintStatisticsVo) {
        List<ComplaintStatisticsSatisfaction>  complaintStatisticsSatisfactiones= complaintStatisticsDao.querySatisfactionList(complaintStatisticsVo);
        return complaintStatisticsSatisfactiones;
    }

    @Override
    public int querySatisfactionTotal(ComplaintStatisticsVo complaintStatisticsVo) {
    	return complaintStatisticsDao.querySatisfactionTotal(complaintStatisticsVo);
    }

}
