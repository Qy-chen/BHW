package com.bingsum.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Liu,Wenzhao
 *
 */
public class NumberUtil {
	public static final BigDecimal ONE = new BigDecimal(1);
	public static final BigDecimal HUNDRED = new BigDecimal(100);
	public static final BigDecimal TEN_THOUSAND = new BigDecimal(10000);

	public static String divide100HalfDown(double number, int scale) {
		return new BigDecimal(number).divide(HUNDRED, scale, RoundingMode.HALF_DOWN).toString();
	}

	public static String divide100HalfDown(BigDecimal number, int scale) {
		return number.divide(HUNDRED, scale, RoundingMode.HALF_DOWN).toString();
	}

	/**
	 * 将单位分化成元
	 * 
	 * @param number
	 *            :分
	 * @param scale
	 *            :小数点后的位数
	 * @return
	 */
	public static String divide100(String number, int scale) {
		if (StringUtils.isEmpty(number))
			return number;
		return new BigDecimal(number).divide(HUNDRED, scale, RoundingMode.HALF_UP).toString();
	}

	public static String divide100(BigDecimal number, int scale) {
		return number.divide(HUNDRED, scale, RoundingMode.HALF_UP).toString();
	}

	public static String divide100(float number, int scale) {
		return new BigDecimal(number).divide(HUNDRED, scale, RoundingMode.HALF_UP).toString();
	}

	public static String divide100(double number, int scale) {
		return new BigDecimal(number).divide(HUNDRED, scale, RoundingMode.HALF_UP).toString();
	}

	public static String divide100(long number, int scale) {
		return new BigDecimal(number).divide(HUNDRED, scale, RoundingMode.HALF_UP).toString();
	}

	public static String divide10000(double number, int scale) {
		return new BigDecimal(number).divide(TEN_THOUSAND, scale, RoundingMode.HALF_UP).toString();
	}

	public static String divide10000(long number, int scale) {
		return new BigDecimal(number).divide(TEN_THOUSAND, scale, RoundingMode.HALF_UP).toString();
	}

	public static String divide10000(BigDecimal number, int scale) {
		return number.divide(TEN_THOUSAND, scale, RoundingMode.HALF_UP).toString();
	}

	public static String divide10000(String number, int scale) {
		return new BigDecimal(number).divide(TEN_THOUSAND, scale, RoundingMode.HALF_UP).toString();
	}

	public static String divide1(BigDecimal number, int scale) {
		return number.divide(ONE, scale, RoundingMode.HALF_UP).toString();
	}

	public static String divide1(String number, int scale) {
		return new BigDecimal(number).divide(ONE, scale, RoundingMode.HALF_UP).toString();
	}

	public static String divide1(double number, int scale) {
		return new BigDecimal(number).divide(ONE, scale, RoundingMode.HALF_UP).toString();
	}

	public static Double fixed(double number, int scale) {
		return new BigDecimal(number).divide(ONE, scale, RoundingMode.HALF_UP).doubleValue();
	}

	/**
	 * 
	 * Description: 元 转 厘
	 * 
	 * @author: LiuWenzhao
	 * @version: 2013-10-12 下午01:46:32
	 */
	public static String multiply10000(String number) {
		BigDecimal bd = new BigDecimal(number).multiply(TEN_THOUSAND);
		return divide1(bd, 0);
	}

	/**
	 * 将单位元转化成为单位分,结果不带小数
	 * 
	 * @param yuan
	 * @return
	 */
	public static String multiply100(String number) {
		BigDecimal bd = new BigDecimal(number).multiply(HUNDRED);
		return divide1(bd, 0);
	}

	public static String multiply100(long number) {
		BigDecimal bd = new BigDecimal(number).multiply(HUNDRED);
		return divide1(bd, 0);
	}

	public static String multiply100(double number) {
		BigDecimal bd = new BigDecimal(number).multiply(HUNDRED);
		return divide1(bd, 0);
	}

	public static String clearZero(String number) {
		if (StringUtils.isEmpty(number))
			return number;
		return Double.toString(Double.parseDouble(number));
	}
}
