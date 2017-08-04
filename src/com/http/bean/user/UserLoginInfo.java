package com.http.bean.user;

public class UserLoginInfo {

	private String mMsg;//用户登反馈信息描述
	private String mErrorCode;//登录反馈信息码

	public String getMsg() {
		return mMsg;
	}

	public void setMsg(String pMsg) {
		mMsg = pMsg;
	}

	public String getErrorCode() {
		return mErrorCode;
	}

	public void setErrorCode(String pErrorCode) {
		mErrorCode = pErrorCode;
	}
}
