package io.github.oneofwolvesbilly.onlinedemo.response;

public class BaseResponse <T>{

	private String returnCode;
	
	private T result;

	public BaseResponse() {
		super();
	}

	public BaseResponse(String returnCode, T t2) {
		super();
		this.returnCode = returnCode;
		this.result = t2;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	
}
