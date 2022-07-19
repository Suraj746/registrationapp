package com.training.registrationap.model;

public class ResponseInfo {
	public String msg;
	public String status;
	public ResponseInfo() {
		super();
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ResponseInfo(String msg, String status) {
		super();
		this.msg = msg;
		this.status = status;
	}

}
