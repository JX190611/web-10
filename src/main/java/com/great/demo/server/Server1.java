package com.great.demo.server;


import com.great.demo.dao.SelAll;

import com.great.demo.javabean.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Server1
{
	@Resource
	private SelAll selAll;
	@Transactional
	//登录
	 public Userinf Login (String name, String psw){
	 	Userinf userinf=new Userinf();
	 	userinf.setUSERNAME(name);
	 	userinf.setUSERPSW(psw);
		Userinf userinf1=selAll.selname5(userinf);
	 	return this.selAll.selname5(userinf);
	 }
	// 查询总条数
	 public int selnumber(){
		return  this.selAll.selallnumber();
	 }
	public int selnumber2(){
		return  this.selAll.selallnumber2();
	}
	 //分页查询
	 public List<FileUser> seluser(int limit, int page, String where){
		 int fast=0;
		 int last=10;
		if (page>1){
			fast=fast+10;
			last=last+10;
		}
		 Yeshu yeshu=new Yeshu();
		 yeshu.setPage(fast);
		 yeshu.setLimit(last);
		 if (where!=null&&where.length()>0){
			 yeshu.setId(where);
		 }
		 else {
			 yeshu.setId("");
		 }
		return  this.selAll.selalluser(yeshu);
	 }
	public List<Yeshu> seluser2(int limit, int page, String where){
		int fast=0;
		int last=10;
		if (page>1){
			fast=fast+10;
			last=last+10;
		}
		Yeshu yeshu=new Yeshu();
		yeshu.setPage(fast);
		yeshu.setLimit(last);
		if (where!=null&&where.length()>0){
			yeshu.setId(where);
		}
		else {
			yeshu.setId("");
		}
		return  this.selAll.selalluser2(yeshu);
	}
	 //增加人员
	public   int adduser(String name){
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		FileUser user=new FileUser();
		user.setUSERNAME(name);
		user.setADDTIME(date.format(formatter));
		return this.selAll.addusername(user);
	}
	//删除一行数据
	public int deleid(String ID){
		return selAll.delid(ID);
	}
	//删除权限
	public int delemenu(int USERID){

		return  selAll.delerole(USERID);
	}
	public int addmenu(int USERID,int MENUID ){
		return  selAll.addmenu(USERID,MENUID);
	}
	public List<MenuTable> selallmenu(){
		return selAll.selallmenu();
	}
	/*查询菜单*/
	public  Map<String,List<Menutable2>> selmenu(String ID){
		List<Menutable2> menuTables=selAll.selmenu(ID);
		Map<String,List<Menutable2>> map=new HashMap<>();
		for (Menutable2 menu:menuTables){
			if (map.containsKey(menu.getParentname())){
				List<Menutable2> valuelist=map.get(menu.getParentname());
				valuelist.add(menu);
			}
			else{
				List<Menutable2> valuelist=new ArrayList<>();
				valuelist.add(menu);
				map.put(menu.getParentname(),valuelist);
			}
		}
		return  map;
	}
	public int addfile(String ADDNAME,String FILENAME){
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return  selAll.addfile(date.format(formatter),ADDNAME,FILENAME);
	}

	public  List<Yeshu> selfasttime(){
		return  selAll.selfasttime();
	}
	public  List<CardPort> selall(){return  selAll.selall();}

}
