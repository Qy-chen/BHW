package com.bingsum.util;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Json与bean互转类，gson的转换效率最高
 * 
 * @author LiuXianTing
 *
 */
public class JsonBeanSwaps {

	private static GsonBuilder gsonBuilder = new GsonBuilder();

	public static Gson instanceGson(){
		gsonBuilder.registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter());
		Gson gson = gsonBuilder.create();
		return gson;
	}
	/**
	 * 将bean转成json
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		gsonBuilder.registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter());
		Gson gson = gsonBuilder.create();
		return gson.toJson(obj);
	}

	/**
	 * 将json的string字符串转成bean
	 * 
	 * @param jsonString
	 * @param clazz
	 * @return
	 * @return
	 */
	public static <T> T toBean(String jsonString, Class<T> clazz, Object object) {
		gsonBuilder.registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter());
		gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		Gson gson = gsonBuilder.create();
		return (T) gson.fromJson(jsonString, clazz);
	}

	/**
	 * 将json的string字符串转成bean
	 * 
	 * @param jsonString
	 * @param clazz
	 * @return
	 * @return
	 */
	public static <T> T toBean(String jsonString, Class<T> clazz) {
		gsonBuilder.registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter());
		gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		Gson gson = gsonBuilder.create();
		return (T) gson.fromJson(jsonString, clazz);
	}
}

class TimestampTypeAdapter implements JsonSerializer<Timestamp>, JsonDeserializer<Timestamp> {
	private final DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public JsonElement serialize(Timestamp ts, Type t, JsonSerializationContext jsc) {
		String dfString = format.format(new Date(ts.getTime()));
		return new JsonPrimitive(dfString);
	}

	public Timestamp deserialize(JsonElement json, Type t, JsonDeserializationContext jsc) throws JsonParseException {

		if (!(json instanceof JsonPrimitive)) {
			try {
				GsonBuilder gsonBuilder = new GsonBuilder();
				Gson gson = gsonBuilder.create();
				JsonDateSerializer jds = gson.fromJson(json.toString(), JsonDateSerializer.class);
				return new Timestamp(jds.getTime());
			} catch (Exception e) {
				throw new JsonParseException(e);
			}
		}

		try {
			Date date = format.parse(json.getAsString());
			return new Timestamp(date.getTime());
		} catch (ParseException e) {
			throw new JsonParseException(e);
		}
	}
}

