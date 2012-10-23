package com.eatj.s43.igorribeirolima.simuladordehomebroker.util;

import java.util.Observer;

import org.apache.http.protocol.HttpContext;

public interface Login extends Observer {
	HttpContext getHttpContext();
	boolean isLogado( String strHtml );
}
