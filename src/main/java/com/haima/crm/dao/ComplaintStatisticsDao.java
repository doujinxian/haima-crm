package com.haima.crm.dao;

import com.haima.crm.entity.ComplaintStatistics;
import com.haima.crm.entity.ComplaintStatisticsSatisfaction;
import com.haima.crm.vo.ComplaintStatisticsVo;

import java.util.List;

/**
 * @author lushaozhong
 * @email fengying9814@163.com
 * @date 2017-04-08 19:52
 */
public interface ComplaintStatisticsDao extends BaseDao<ComplaintStatisticsVo> {
    List<ComplaintStatistics> queryAnalysisList(ComplaintStatisticsVo t);
    int queryAnalysisTotal(ComplaintStatisticsVo t);

    List<ComplaintStatisticsSatisfaction> querySatisfactionList(ComplaintStatisticsVo t);
    int querySatisfactionTotal(ComplaintStatisticsVo t);
}
