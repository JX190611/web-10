package com.great.demo.javabean;

public class Yeshu
{
	private int page;
	private  int limit;
	private String id;
	private String ADDTIME;
	private String ADDNAME;
	private String FILENAME;

	public Yeshu()
	{
	}

	public Yeshu(String FILENAME,String ADDNAME,String ADDTIME,int page, int limit,String id)
	{
		this.page = page;
		this.limit = limit;
		this.id=id;
		this.ADDNAME=ADDNAME;

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
