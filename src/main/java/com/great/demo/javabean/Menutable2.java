package com.great.demo.javabean;

public class Menutable2
{
	private String  parentname;
	private  String chindname;
	private String link;

	public Menutable2()
	{
	}

	public Menutable2(String parentname, String chindname, String link)
	{
		this.parentname = parentname;
		this.chindname = chindname;
		this.link = link;
	}

	public String getParentname()
	{
		return parentname;
	}

	public void setParentname(String parentname)
	{
		this.parentname = parentname;
	}

	public String getChindname()
	{
		return chindname;
	}

	public void setChindname(String chindname)
	{
		this.chindname = chindname;
	}

	public String getLink()
	{
		return link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}
}
