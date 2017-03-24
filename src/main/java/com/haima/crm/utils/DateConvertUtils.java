package com.haima.crm.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class DateConvertUtils extends DateUtils {

	public static final String FORMAT_DATE_19 = "yyyy-MM-dd HH:mm:ss";

	public static final String FORMAT_DATE_10_SLASH = "yyyy/MM/dd";

	public static final String DATE_FORMAT_SSS = "yyyy-MM-dd HH:mm:ss:SSS";

	public static final String DF_TO_DAY = "yyyy-MM-dd";

	public static final String DF_TO_DAY_2 = "yyyyMMdd";

	public static final String DF_TO_DAY_6 = "yyMMdd";
	public static final String DATE_FORMAT_SSS_Num = "yyyyMMddHHmmssSSS";
	public static final String FORMAT_DATE_MM_DD_1 = "MM.dd";

	/**
	 * 日期格式化
	 * 
	 * @param pattern
	 * @param date
	 * @return
	 */
	public static String formatDate(String pattern, Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static Date formatDate(String pattern, String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 默认格式化当前日期
	 * 
	 * @param pattern
	 * @return
	 */
	public static String formatDate(String pattern) {
		return formatDate(pattern, new Date());
	}

	public static String formatDate(Date date, String pattern) {
		return formatDate(pattern, date);
	}

	public static String formateDate19(Date date) {
		return formatDate(FORMAT_DATE_19, date);
	}

	public static Date formateDate19(String dateStr) {
		return formatDate(FORMAT_DATE_19, dateStr);
	}

	/**
	 * 取得一个月的开始时间
	 * 
	 * @param date
	 * @return yyyy-MM-dd hh:mm:ss
	 */
	public static Date getMonthStart(Date date) {
		Date monthStart = null;
		if (date != null) {
			Calendar nowDate = Calendar.getInstance();
			nowDate.setTime(date);
			monthStart = DateUtils.truncate(nowDate.getTime(), Calendar.MONTH);
		}
		return monthStart;
	}

	/**
	 * 取得一个月的结束时间+1天
	 * 
	 * @param date
	 * @return yyyy-MM-dd hh:mm:ss
	 */
	public static Date getMonthEnd(Date date) {
		Date monthEnd = null;
		if (date != null) {
			Calendar nowDate = Calendar.getInstance();
			nowDate.setTime(date);
			Date startMonth = DateUtils.truncate(nowDate.getTime(),
					Calendar.MONTH);
			monthEnd = DateUtils.addMonths(startMonth, 1);
		}
		return monthEnd;
	}

	/**
	 * 取得上一个月的开始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getPreMonthStart(Date date) {
		return getMonthStart(DateUtils.addMonths(date, -1));
	}

	/**
	 * 取得前一个月的结束时间+1天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getPreMonthEnd(Date date) {
		return getMonthEnd(DateUtils.addMonths(date, -1));
	}

	/**
	 * date1 日期是否大于date2日期，比较精度到日期
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean after(Date date1, Date date2) {
		if (date1 == null)
			return false;
		if (date2 == null)
			return true;
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		cal1.set(Calendar.HOUR_OF_DAY, 0);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.SECOND, 0);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		cal2.set(Calendar.HOUR_OF_DAY, 0);
		cal2.set(Calendar.MINUTE, 0);
		cal2.set(Calendar.SECOND, 0);
		return cal1.after(cal2);
	}

	public static String timeStamp2Date(String timestampString, String formats) {
		Long timestamp = Long.parseLong(timestampString) * 1000;
		String date = new java.text.SimpleDateFormat(formats)
				.format(new java.util.Date(timestamp));
		return date;
	}

	public static void main(String[] a) {
		System.out.println(formatDate("yyyy/M/d"));
	}

	public static String format(Date createDate, String formatDate) {

		return null;
	}

	public static Date parse(String value, String formatDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatDate);
		Date date = null;
		try {
			date = sdf.parse(value);
		} catch (ParseException e) {
			return null;
		}
		return date;
	}

	/**
	 * @param time
	 * @return
	 */
	public static String getToDayDate(long time) {
		DateFormat fmt = createDateFmt(DF_TO_DAY);
		return fmt.format(new Date(time));
	}

	public static String getToDayDate2(long time) {
		DateFormat fmt = createDateFmt(DF_TO_DAY_2);
		return fmt.format(new Date(time));
	}

	public static String getToDayDate6(long time) {
		DateFormat fmt = createDateFmt(DF_TO_DAY_6);
		return fmt.format(new Date(time));
	}

	private static DateFormat createDateFmt(String datefmt) {
		DateFormat fmt = new SimpleDateFormat(datefmt);
		return fmt;
	}

	/**
	 * 将结束时间设置为23:59:59
	 * 
	 * @param date
	 * @return
	 */
	public static Date setEndDate(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.HOUR, 23);
		ca.set(Calendar.MINUTE, 59);
		ca.set(Calendar.SECOND, 59);
		return ca.getTime();
	}

	public static Date setStartDate(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.HOUR, 0);
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		return ca.getTime();
	}

}
