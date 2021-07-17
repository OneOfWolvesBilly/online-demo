package io.github.oneofwolvesbilly.onlinedemo.service;

import io.github.oneofwolvesbilly.onlinedemo.util.HttpURLConnectionUtil;

public class BaseService {

	protected String doGet(String url) {
		
		return HttpURLConnectionUtil.doGet(url);
	}
	
}
