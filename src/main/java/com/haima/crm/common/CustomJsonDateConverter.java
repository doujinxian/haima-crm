package com.haima.crm.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;

/**
 * 自定义统一日期格式，若有日期需要特殊的格式，需要在getter方法上加上 @JsonFormat(pattern="yyyy-MM-dd",timezone= "GMT+8")
 * 
 * @author jinxian.dou
 * @date 2016年11月15日 下午5:01:52
 */
public class CustomJsonDateConverter extends ObjectMapper {
	public CustomJsonDateConverter() {
		CustomSerializerFactory factory = new CustomSerializerFactory();
		factory.addGenericMapping(Date.class, new JsonSerializer<Date>() {
			@Override
			public void serialize(Date value, JsonGenerator jsonGenerator, SerializerProvider provider)
					throws IOException {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				jsonGenerator.writeString(sdf.format(value));
			}
		});
		//设置默认日期格式
		this.setSerializerFactory(factory);
		//过滤值为null的字段
		this.setSerializationInclusion(org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL);
	}
}