package com.doj.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtil {
	static ObjectMapper mapper = new ObjectMapper();
	
	public static String toJson(Object object) {
		String json = null;
		try {
			mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			json = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	public static String getTrue() {
		String json = null;
		try {
			json = mapper.writeValueAsString(true);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	public static String getFalse() {
		String json = null;
		try {
			json = mapper.writeValueAsString(false);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
}
