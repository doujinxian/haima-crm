package com.haima.crm.common;

import java.io.Serializable;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by jige0727 on 2017/3/21.
 * 获取全局的context
 */
@Component
public class AppContextHelper implements Serializable, ApplicationContextAware {
	private static final long serialVersionUID = 2993435050104322043L;
	public static ApplicationContext appContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }
}
