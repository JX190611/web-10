package com.great.demo.javabean;

import java.util.List;

public class MenuTable
{
	private String title;
	private int id;
	private String link;
	private List<MenuTable> children;
	public MenuTable()
	{
	}

	public MenuTable(String link,String title, int id, List<MenuTable> children)
	{
		this.link=link;
		this.title = title;
		this.id = id;
		this.children = children;

	}



	public String getLink()
	{
		return link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}

	public String gettitle()
	{
		return title;
	}

	public void settitle(String title)
	{
		this.title = title;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public List<MenuTable> getChildren()
	{
		return children;
	}

	public void setChildren(List<MenuTable> children)
	{
		this.children = children;
	}
}
