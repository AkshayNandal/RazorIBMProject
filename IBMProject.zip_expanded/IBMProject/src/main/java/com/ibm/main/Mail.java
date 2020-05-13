package com.ibm.main;

public interface Mail {
	public void send(String toAddress,String subject,String content)throws Exception;
}
