package com.haima.crm.controller;

import com.haima.crm.constants.KettleConfig;
import com.haima.crm.entity.CrmEtlParameter;
import com.haima.crm.service.CrmEtlService;
import com.haima.crm.utils.Result;
import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
import org.pentaho.di.repository.Repository;
import org.pentaho.di.repository.RepositoryDirectoryInterface;
import org.pentaho.di.repository.kdr.KettleDatabaseRepository;
import org.pentaho.di.repository.kdr.KettleDatabaseRepositoryMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author lushaozhong
 * @version 1.0
 * @date 2017-05-21 15:45
 */

@ApiIgnore
@Controller
@RequestMapping("ccms/etl")
public class CrmEtlController extends BaseController {

    /*@Autowired
    private HttpServletRequest request;*/

    @Autowired
    private CrmEtlService crmEtlService;

    /**
     * job启动
     */
    @ResponseBody
    @RequestMapping("/job/start")
    public Result jobStart(HttpServletRequest request) throws Exception {
        Job job = null;
        ServletContext ac = request.getSession().getServletContext();
        job = (Job) ac.getAttribute("autoJob");
        if(job!=null&&!job.isStopped()){
            return Result.error("JOB已经启动");
        }else{
            job = getRepositoryAutoJob();
            ac.setAttribute("autoJob", job);
            job.start();
            /*job.waitUntilFinished();
            if (job.getErrors() > 0) {
                throw new RuntimeException(
                        "There were errors during transformation execution.");
            }*/
            return Result.ok("JOB启动成功");
        }
    }

    /**
     * job停止
     */
    @ResponseBody
    @RequestMapping("/job/stop")
    public Result jobStop(HttpServletRequest request) {
        Job job = null;
        ServletContext ac = request.getSession().getServletContext();
        job = (Job) ac.getAttribute("autoJob");
        if(job!=null){
            job.stopAll();
            return Result.ok("JOB停止成功");
        }else{
            return Result.error("JOB未启动");
        }
    }

    /**
     * job状态
     */
    @ResponseBody
    @RequestMapping("/job/status")
    public Result jobStatus(HttpServletRequest request) throws Exception {
        Job job = null;
        ServletContext ac = request.getSession().getServletContext();
        job = (Job) ac.getAttribute("autoJob");
        if(job!=null&&!job.isStopped()){
            return Result.ok("JOB已经启动");
        }else{
            return Result.error("JOB未启动");
        }
    }

    /**
     * job停止
     */
    @ResponseBody
    @RequestMapping("/job/parameter/get")
    public Result selectImpParameter(){
        String jobName =  KettleConfig.getMsg("AutoJobName");
        CrmEtlParameter crmEtlParameter = crmEtlService.getEtlParameter(jobName);
        return Result.ok().put("crmEtlParameter", crmEtlParameter);
    }

    private Job getRepositoryAutoJob() throws KettleException {
        String jobName = KettleConfig.getMsg("AutoJobName");
        String serverIP = KettleConfig.getMsg("ServerIP");
        String serverPort = KettleConfig.getMsg("ServerPort");
        String dataBase = KettleConfig.getMsg("DataBase");
        String dataBaseAccess = KettleConfig.getMsg("DataBaseAccess");
        String dataBaseName = KettleConfig.getMsg("DataBaseName");
        String dbUserName = KettleConfig.getMsg("DBUserName");
        String dbPassWord = KettleConfig.getMsg("DBPassWord");
        String repositoryName = KettleConfig.getMsg("RepositoryName");
        String repositoryUserName = KettleConfig.getMsg("RepositoryUserName");
        String repositoryPassWord = KettleConfig.getMsg("RepositoryPassWord");
        KettleEnvironment.init();
        DatabaseMeta dataMeta = new DatabaseMeta(repositoryName,dataBase,dataBaseAccess,serverIP,dataBaseName,serverPort,dbUserName,dbPassWord);
        KettleDatabaseRepositoryMeta repInfo = new KettleDatabaseRepositoryMeta();
        repInfo.setConnection(dataMeta);
        KettleDatabaseRepository rep = new KettleDatabaseRepository();
        rep.init(repInfo);
        rep.connect(repositoryUserName, repositoryPassWord);//连接资源库
        RepositoryDirectoryInterface dir = rep.loadRepositoryDirectoryTree();
        JobMeta jobMeta = ((Repository)rep).loadJob(jobName, dir, null, null);
        Job job = new Job(rep, jobMeta);
        return job;
    }
}
