package com.great.demo.javabean;

public class LIANCHA
{
	private int UID;
	private  String UNAME;
	private  int USERID;
	private int MENUID;

	public LIANCHA()
	{
	}

	public LIANCHA(int USERID,int MENUID,int UID, String UNAME)
	{
		this.UID = UID;
		this.UNAME = UNAME;
		this.MENUID=MENUID;
		this.USERID=USERID;
	}

	public int getUSERID()
	{
		return USERID;
	}

	public void setUSERID(int USERID)
	{
		this.USERID = USERID;
	}

	public int getMENUID()
	{
		return MENUID;
	}

	public void setMENUID(int MENUID)
	{
		this.MENUID = MENUID;
	}

	public int getUID()
	{
		return UID;
	}

	public void setUID(int UID)
	{
		this.UID = UID;
	}

	public String getUNAME()
	{
		return UNAME;
	}

	public void setUNAME(String UNAME)
	{
		this.UNAME = UNAME;
	}
}
