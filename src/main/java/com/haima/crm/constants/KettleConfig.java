package com.haima.crm.constants;

import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author lushaozhong
 * @email fengying9814@163.com
 * @date 2017-05-21 16:26
 */
public class KettleConfig {
    private static Map<String,String> msgs;
    private static Map<String,Map<String,String>> msgCache = new HashMap<String,Map<String,String>>();

    private KettleConfig() {
        throw new AssertionError();
    }

    static{
        msgs = new HashMap<String, String>();
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("kettle");
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
