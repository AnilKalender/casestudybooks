package com.books.model;

public class ResponseModel {

	private int result;
	private String errorText;
	private Object data;

	public ResponseModel() {

	}

	public ResponseModel(int result, String errorText, Object data) {
		super();
		this.result = result;
		this.errorText = errorText;
		this.data = data;
	}
	
	public ResponseModel(int result, String errorText) {
		super();
		this.result = result;
		this.errorText = errorText;
	}

	@Override
	public String toString() {
		return "OutputModel [result=" + result + ", errorText=" + errorText + "]";
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public static ResponseModel createSuccessResponse() {

		return new ResponseModel(1, "", "The Request Was Successful.");
	}

	public static ResponseModel createSuccessResponseWithData(Object data) {

		return new ResponseModel(1, "", data);
	}

	public static ResponseModel createErrorResponseWithData(String errorMessage) {
		return new ResponseModel(0, errorMessage);
	}
}