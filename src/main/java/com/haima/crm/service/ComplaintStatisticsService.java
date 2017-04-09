package com.haima.crm.service;

import com.haima.crm.entity.Complaint;
import com.haima.crm.entity.ComplaintStatistics;
import com.haima.crm.entity.ComplaintStatisticsSatisfaction;
import com.haima.crm.vo.ComplaintStatisticsVo;

import java.util.List;

/**
 * 记录投诉信息
 *
 * @author lushaozhong
 * @email fengying9814@163.com
 * @date 2017-04-08 15:05:14
 */
public interface ComplaintStatisticsService {
    List<ComplaintStatistics> queryAnalysisList(ComplaintStatisticsVo complaintStatisticsVo);

    int queryAnalysisTotal(ComplaintStatisticsVo complaintStatisticsVo);

    List<ComplaintStatisticsSatisfaction> querySatisfactionList(ComplaintStatisticsVo complaintStatisticsVo);

    int querySatisfactionTotal(ComplaintStatisticsVo complaintStatisticsVo);
}
