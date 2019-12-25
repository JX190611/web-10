package com.great.demo.dao;

import com.great.demo.javabean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SelAll
{
/*	public  int setnumber();
	public List<FileUser> finID(int ID);*/
	public Userinf selname5(Userinf userinf);
	public List <FileUser> selalluser(Yeshu yeshu);
	public List <Yeshu> selalluser2(Yeshu yeshu);
	public  int selallnumber();
	public  int selallnumber2();
	public  int addusername(FileUser fileUser);
	public  int delid(String ID);
	public  int delerole(int USERID);
	public  int addmenu(int USERID,int MENUID );
	public List<MenuTable> selallmenu();
	public List<Menutable2> selmenu(String ID);
	public  int addfile(@Param("ADDTIOME") String ADDTIOME,@Param("ADDNAME")  String ADDNAME,@Param("FILENAME")  String FILENAME);
	public  List<Yeshu> selfasttime();
	public List<CardPort> selall();

}


