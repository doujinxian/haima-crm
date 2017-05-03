package com.haima.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haima.crm.constants.StatisticsTypeConfig;
import com.haima.crm.entity.ComplaintStatistics;
import com.haima.crm.entity.ComplaintStatisticsSatisfaction;
import com.haima.crm.service.ComplaintStatisticsService;
import com.haima.crm.utils.PageUtils;
import com.haima.crm.utils.Result;
import com.haima.crm.vo.ComplaintStatisticsVo;

/**
 * 记录投诉信息
 *
 * @author lushaozhong
 * @email fengying9814@163.com
 * @date 2017-04-08 14:15:12
 */
@Controller
@RequestMapping("ccms/complaint/statistics")
public class ComplaintStatisticsController extends BaseController{
    @Autowired
    private ComplaintStatisticsService complaintStatisticsService;

    /**
     * 统计分析列表
     */
    @ResponseBody
    @RequestMapping("/analysis/list")
    public Result analysisList(@RequestBody ComplaintStatisticsVo complaintStatisticsVo) {
        if(StringUtils.isEmpty(complaintStatisticsVo.getStatisticsType())){
            return Result.error("statisticsType不能为空!");
        }
        //根据统计类型获取对应统计表中的字段
        String statisticsType = StatisticsTypeConfig.getMsg(complaintStatisticsVo.getStatisticsType());
        if(StringUtils.isEmpty(statisticsType)){
            return Result.error("statisticsType不存在!");
        }
        //将统计类型装换成投诉表字段
        complaintStatisticsVo.setStatisticsType(statisticsType);
        // 查询列表数据
        List<ComplaintStatistics> complaintList = complaintStatisticsService.queryAnalysisList(complaintStatisticsVo);
        int total = complaintStatisticsService.queryAnalysisTotal(complaintStatisticsVo);
        PageUtils pageUtil = new PageUtils(complaintList, total, complaintStatisticsVo.getLimit(), complaintStatisticsVo.getPage());

        return Result.ok().put("page", pageUtil);
    }

    /**
     * 统计分析列表
     */
    @ResponseBody
    @RequestMapping("/satisfaction/list")
    public Result satisfactionList(@RequestBody ComplaintStatisticsVo complaintStatisticsVo) {
        if(StringUtils.isEmpty(complaintStatisticsVo.getStatisticsType())){
            return Result.error("statisticsType不能为空!");
        }
        //根据统计类型获取对应统计表中的字段
        String statisticsType = StatisticsTypeConfig.getMsg(complaintStatisticsVo.getStatisticsType());
        if(StringUtils.isEmpty(statisticsType)){
            return Result.error("statisticsType不存在!");
        }
        //将统计类型装换成投诉表字段
        complaintStatisticsVo.setStatisticsType(statisticsType);
        // 查询列表数据
        List<ComplaintStatisticsSatisfaction> complaintList = complaintStatisticsService.querySatisfactionList(complaintStatisticsVo);
        int total = complaintStatisticsService.querySatisfactionTotal(complaintStatisticsVo);
        PageUtils pageUtil = new PageUtils(complaintList, total, complaintStatisticsVo.getLimit(), complaintStatisticsVo.getPage());

        return Result.ok().put("page", pageUtil);
    }
}
