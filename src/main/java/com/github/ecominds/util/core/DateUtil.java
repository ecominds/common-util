/**
 * @author	: Rajiv Kumar
 * @project	: common-util
 * @since	: 0.0.1
 * @date	: 07-Jan-2023
 */
package com.github.ecominds.util.core;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * Date related utility methods
 */
public final class DateUtil {
	
	public static OffsetDateTime gmtTime() {
		return OffsetDateTime.now(ZoneOffset.UTC);
	}

	public static Instant gmtInstant() {
		return gmtTime().toInstant();
	}
	
	public static long gmtMillis() {
		return gmtInstant().toEpochMilli();
	}
	
	public static LocalDate localDate() {
		return gmtTime().toLocalDate();
	}
	
	public static LocalTime localTime() {
		return gmtTime().toLocalTime();
	}
	
	public static LocalDateTime localDateTime() {
		return gmtTime().toLocalDateTime();
	}
	
	private static final String UI_DATE_FORMAT = "MM/dd/yyyy";
	private static final SimpleDateFormat ui_date_formatter = 
			new SimpleDateFormat(UI_DATE_FORMAT);
	
	public static String formatToUIDate(long millis) {
		return ui_date_formatter.format(new Date(millis));
	}
}