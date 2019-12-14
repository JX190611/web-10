package com.great.demo.javabean;

import java.math.BigDecimal;

public class FileUser
{
	private  int ID;
	private  String USERNAME;
	private  String ADDTIME;
	private int INTEGRAL;
	private int OUTNUMBER;
	private int INNUMBER;
	private  String USERTYPE;
	private  int ALLNUMBER;
	private Userinf USER;
	private LIANCHA lian;
	private  int count;
	public FileUser()
	{

	}

	public FileUser(int count,LIANCHA lian, Userinf USER, int ID, String USERNAME, String ADDTIME, int INTEGRAL, int OUTNUMBER, int INNUMBER, String USERTYPE, int ALLNUMBER)
	{
		this.ID = ID;
		this.USERNAME = USERNAME;
		this.ADDTIME = ADDTIME;
		this.INTEGRAL = INTEGRAL;
		this.OUTNUMBER = OUTNUMBER;
		this.INNUMBER = INNUMBER;
		this.USERTYPE = USERTYPE;
		this.ALLNUMBER=ALLNUMBER;
		this.USER=USER;
		this.lian=lian;
		this.count=count;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	public LIANCHA getLian()
	{
		return lian;
	}

	public void setLian(LIANCHA lian)
	{
		this.lian = lian;
	}

	public Userinf getUSER()
	{
		return USER;
	}

	public void setUSER(Userinf USER)
	{
		this.USER = USER;
	}

	public int getALLNUMBER()
	{
		return ALLNUMBER;
	}

	public void setALLNUMBER(int ALLNUMBER)
	{
		this.ALLNUMBER = ALLNUMBER;
	}

	public int getID()
	{
		return ID;
	}

	public void setID(int ID)
	{
		this.ID = ID;
	}

	public String getUSERNAME()
	{
		return USERNAME;
	}

	public void setUSERNAME(String USERNAME)
	{
		this.USERNAME = USERNAME;
	}

	public String getADDTIME()
	{
		return ADDTIME;
	}

	public void setADDTIME(String ADDTIME)
	{
		this.ADDTIME = ADDTIME;
	}

	public int getINTEGRAL()
	{
		return INTEGRAL;
	}

	public void setINTEGRAL(int INTEGRAL)
	{
		this.INTEGRAL = INTEGRAL;
	}

	public int getOUTNUMBER()
	{
		return OUTNUMBER;
	}

	public void setOUTNUMBER(int OUTNUMBER)
	{
		this.OUTNUMBER = OUTNUMBER;
	}

	public int getINNUMBER()
	{
		return INNUMBER;
	}

	public void setINNUMBER(int INNUMBER)
	{
		this.INNUMBER = INNUMBER;
	}

	public String getUSERTYPE()
	{
		return USERTYPE;
	}

	public void setUSERTYPE(String USERTYPE)
	{
		this.USERTYPE = USERTYPE;
	}
}
