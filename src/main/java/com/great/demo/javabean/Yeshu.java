package com.great.demo.javabean;

public class Yeshu
{
	private int page;
	private  int limit;
	private String id;
	private String ADDTIME;
	private String ADDNAME;
	private String FILENAME;
	private  String CARDTIME;
	private int  CAREID;
	private int  MONEY;
	private int  EXCEEDMONEY;

	public Yeshu()
	{
	}

	public Yeshu(int  MONEY,int  EXCEEDMONEY,int  CAREID,String CARDTIME,String FILENAME,String ADDNAME,String ADDTIME,int page, int limit,String id)
	{
		this.page = page;
		this.limit = limit;
		this.id=id;
		this.ADDNAME=ADDNAME;
		this.CARDTIME=CARDTIME;
		this.MONEY=MONEY;
		this.EXCEEDMONEY=EXCEEDMONEY;
		this.CAREID=CAREID;

	}

	public int getCAREID()
	{
		return CAREID;
	}

	public void setCAREID(int CAREID)
	{
		this.CAREID = CAREID;
	}

	public int getMONEY()
	{
		return MONEY;
	}

	public void setMONEY(int MONEY)
	{
		this.MONEY = MONEY;
	}

	public int getEXCEEDMONEY()
	{
		return EXCEEDMONEY;
	}

	public void setEXCEEDMONEY(int EXCEEDMONEY)
	{
		this.EXCEEDMONEY = EXCEEDMONEY;
	}

	public String getCARDTIME()
	{
		return CARDTIME;
	}

	public void setCARDTIME(String CARDTIME)
	{
		this.CARDTIME = CARDTIME;
	}

	public String getADDTIME()
	{
		return ADDTIME;
	}

	public void setADDTIME(String ADDTIME)
	{
		this.ADDTIME = ADDTIME;
	}

	public String getADDNAME()
	{
		return ADDNAME;
	}

	public void setADDNAME(String ADDNAME)
	{
		this.ADDNAME = ADDNAME;
	}

	public String getFILENAME()
	{
		return FILENAME;
	}

	public void setFILENAME(String FILENAME)
	{
		this.FILENAME = FILENAME;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public int getPage()
	{
		return page;
	}

	public void setPage(int page)
	{
		this.page = page;
	}

	public int getLimit()
	{
		return limit;
	}

	public void setLimit(int limit)
	{
		this.limit = limit;
	}
}
