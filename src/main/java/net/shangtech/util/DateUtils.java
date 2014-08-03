package net.shangtech.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 日期时间工具类
 * @author songxh
 * @createtime 2014-8-3上午08:54:23
 */
public class DateUtils {
	public static String format(Date date, String pattern){
		if(date == null)
			return "";
		if(StringUtils.isBlank(pattern)){
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}
	public static String format(Date date){
		if(date == null){
			return "";
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
	public static Date parse(String dateStr){
		if(StringUtils.isBlank(dateStr))
			return null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}