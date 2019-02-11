package com.bingsum.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;


public class DateHelper {
	// 设置有效日期默认的结尾日期
	public static final Date DEFAULT_MAX_DATE = StringToDate("2099-12-31", "yyyy-MM-dd");

	public static Date StringToDateAll(String s) {
		if (StringUtils.isEmpty(s)) {
			return null;
		}
		if (s.contains(":")) {
			return StringToDate(s);
		}
		if (s.contains("-")) {
			return StrToDate(s);
		}
		return null;
	}

	public static Date StringToDate(String date) {
		Date time = new Date();
		if (StringUtils.isBlank(date))
			return time;
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			time = formatDate.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}

	/**
	 * String转Date
	 */
	public static Date StringToDate(String date, String datePatter) {
		Date time = new Date();
		if (StringUtils.isEmpty(date))
			return null;
		SimpleDateFormat formatDate = new SimpleDateFormat(datePatter);
		try {
			time = formatDate.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}

	public static Date StringToDateThrowE(String date, String datePatter) throws ParseException {
		Date time = new Date();
		if (StringUtils.isEmpty(date))
			return null;
		SimpleDateFormat formatDate = new SimpleDateFormat(datePatter);
		time = formatDate.parse(date);
		return time;
	}

	public static String dateToString(Date date, String datePatter) {
		Date time = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat(datePatter);
		String str = formatDate.format(date);
		try {
			time = formatDate.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatDate.format(time);
	}

	public static String dateToString(Date date) {
		Date time = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = formatDate.format(date);
		try {
			time = formatDate.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatDate.format(time);
	}

	public static Date dateToString(String date, String datePatter) {
		Date time = new Date();
		if (StringUtils.isBlank(date))
			return time;
		SimpleDateFormat formatDate = new SimpleDateFormat(datePatter);
		try {
			String str = formatDate.format(date);
			time = formatDate.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}

	public static Date getPervDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		return date;
	}

	public static Date getNextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		date = calendar.getTime();
		return date;
	}

	public static Date StrToDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 两个时间之间相差分钟
	 * 
	 * @param one 时间参数 1：
	 * @param two 时间参数 2：
	 * @return 相差分钟
	 */
	public static long getDistanceMinus(String str1, String str2) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date one;
		Date two;
		long days = 0;
		try {
			one = df.parse(str1);
			two = df.parse(str2);
			long time1 = one.getTime();
			long time2 = two.getTime();
			long diff;
			if (time1 < time2) {
				diff = time2 - time1;
			} else {
				diff = time1 - time2;
			}
			days = diff / (1000 * 60);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return days;
	}

	public static int duringDays(Date d1, Date d2) {
		return differentDays(d1, d2) + 1;
	}

	/**
	 * date2比date1多的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int differentDays(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		int day1 = cal1.get(Calendar.DAY_OF_YEAR);
		int day2 = cal2.get(Calendar.DAY_OF_YEAR);

		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		if (year1 != year2) // 同一年
		{
			int timeDistance = 0;
			for (int i = year1; i < year2; i++) {
				if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) // 闰年
				{
					timeDistance += 366;
				} else // 不是闰年
				{
					timeDistance += 365;
				}
			}

			return timeDistance + (day2 - day1);
		} else // 不同年
		{
			return day2 - day1;
		}
	}

	public static long differentHours(Date date1, Date date2) {
		long t1 = date1.getTime();
		long t2 = date2.getTime();
		return ((t2 - t1) / (60 * 60 * 1000));
	}

	public static int getField(Date date, int field) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(field);
	}

	public static int getAgeByBirthday(String birthdayStr) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = df.parse(birthdayStr);
		Calendar cal = Calendar.getInstance();
		if (cal.getTimeInMillis() < birthday.getTime()) {
			return 0;
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthday);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
		int age = yearNow - yearBirth;
		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				// monthNow==monthBirth
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				// monthNow>monthBirth
				age--;
			}
		}
		return age;
	}

	/**
	 * 日期转星期
	 * 
	 * @param datetime
	 * @return
	 */
	public static String dateToWeek(String datetime) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		// 获得一个日历
		Date datet = null;
		try {
			datet = f.parse(datetime);
			cal.setTime(datet);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		// 指示一个星期中的某天。
		if (w < 0)
			w = 0;
		return weekDays[w];
	}
	
	public static String addDay(String date, int diff) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		Date datet = null;
		try {
			datet = sf.parse(date);
			cal.setTime(datet);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.add(Calendar.DATE, diff);
		return sf.format(cal.getTime());
	}
}
