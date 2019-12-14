package com.great.demo.javabean;

import java.math.BigDecimal;

public class Userinf
{
	private BigDecimal USERID;
	private  String USERNAME;
	private  String USERPSW;

	public Userinf()
	{
	}

	public Userinf( BigDecimal USERID, String USERNAME, String USERPSW)
	{
		this.USERID = USERID;
		this.USERNAME = USERNAME;
		this.USERPSW = USERPSW;

	}



	public BigDecimal getUSERID()
	{
		return USERID;
	}

	public void setUSERID(BigDecimal USERID)
	{
		this.USERID = USERID;
	}

	public String getUSERNAME()
	{
		return USERNAME;
	}

	public void setUSERNAME(String USERNAME)
	{
		this.USERNAME = USERNAME;
	}

	public String getUSERPSW()
	{
		return USERPSW;
	}

	public void setUSERPSW(String USERPSW)
	{
		this.USERPSW = USERPSW;
	}
}
