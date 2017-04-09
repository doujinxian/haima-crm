package com.haima.crm.constants;

import org.apache.commons.logging.LogFactory;

import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author lushaozhong
 * @email fengying9814@163.com
 * @date 2017-04-08 16:26
 */
public class StatisticsTypeConfig {
    private static Map<String,String> msgs;
    private static Map<String,Map<String,String>> msgCache = new HashMap<String,Map<String,String>>();

    private StatisticsTypeConfig() {
        throw new AssertionError();
    }

    static{
        msgs = new HashMap<String, String>();
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("statistics_type_config");
            Enumeration<String> keys = bundle.getKeys();

            while(keys.hasMoreElements()){
                String key = keys.nextElement();
                msgs.put(key, bundle.getString(key));

                /*if(log.isDebugEnabled())
                    log.debug("init one msg key:"+key+";msg:"+bundle.getString(key));*/
            }

        } catch (Exception e) {
            e.printStackTrace();
            //log.error("msg init fail!",e);
        }
    }

    public static String getMsg(String code){
        if(code==null||code.isEmpty())
            return null;
        return msgs.get(code);
    }

    public static String getMsg(String code,Object ... params){
        String pattern = getMsg(code);
        String msg = MessageFormat.format(pattern, params);
        return msg;
    }
}
