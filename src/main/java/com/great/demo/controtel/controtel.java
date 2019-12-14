package com.great.demo.controtel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.great.demo.javabean.*;
import com.great.demo.server.Server1;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Controller
public class controtel
{
	@Resource
	private Server1 server1;
	@RequestMapping("/Tex.action")
	public ModelAndView test2(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("jsp/Login");
		return modelAndView;
	}
	@RequestMapping("/Login.action")
	public ModelAndView test3(String username, String password, HttpSession httpSession){

		ModelAndView modelAndView=new ModelAndView();
		Userinf userinf=server1.Login(username,password);
		if (userinf==null){

			modelAndView.setViewName("jsp/Login");
			System.out.println(222);
		}else
		{
			Map<String,List<Menutable2>> list5=server1.selmenu(username);
			httpSession.setAttribute("username",username);
			modelAndView.addObject("menumap",list5);
			modelAndView.setViewName("jsp/backstage");
			System.out.println(333);
		}
		return modelAndView;
	}
	@RequestMapping("/userlist.action")
	public  ModelAndView modelAndView(){
		System.out.println("999999999");
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("jsp/userlist");
		return modelAndView;
	}444
	@RequestMapping(value = "Table.action")
	@ResponseBody
	public ALLDATA alldata(@RequestParam("limit") int limit, int page, String id ){
		List<FileUser> list=server1.seluser(limit,page,id);
		ALLDATA alldata=new ALLDATA();
		int count=server1.selnumber();
		alldata.setData(list);
		alldata.setCode(0);
		alldata.setMsg("");
		alldata.setCount(new BigDecimal(count));
		return alldata;
	}
	@RequestMapping(value = "Tablefile.action")
	@ResponseBody
	public ALLDATA tablefile(@RequestParam("limit") int limit, int page, String id){
		ALLDATA alldata=new ALLDATA();
		List<Yeshu> list=server1.seluser2(limit,page,id);
		int count=server1.selnumber2();
		alldata.setData(list);
		alldata.setCode(0);
		alldata.setMsg("");
		alldata.setCount(new BigDecimal(count));
		return alldata;
	}

	@RequestMapping("add.action")
	@ResponseBody
	public  FileUser add1(String name){
		FileUser res=new FileUser();
		server1.adduser(name);
		res.setID(1);
		return res;
	}
	@RequestMapping("dele.action")
	@ResponseBody
	public  int dele(String msg1){
		int flay=server1.deleid(msg1);
		int msg;
		if (flay>0){
			msg=200;
		}
		else {
			msg=300;
		}
		System.out.println(66666);
		return msg;
	}

	@RequestMapping("upload.action")
	@ResponseBody
	public Map<String,Object> uploadfile(MultipartFile file,HttpSession httpSession){
		Map map = new HashMap<String,Object>();
		System.out.println(file.getOriginalFilename());
		try
		{
			file.transferTo(new File("D:/shangchuan/"+file.getOriginalFilename()));
			String username=httpSession.getAttribute("username").toString();
			int flay=server1.addfile(username,file.getOriginalFilename());
			if (flay>0){
				map.put("msg","ok");
				map.put("code",200);
			}else {
				map.put("msg","error");
				map.put("code",0);
			}

		} catch (IOException e)
		{
			map.put("msg","error");
			map.put("code",0);
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping("addrole.action")
	@ResponseBody
	public String  selmenu(String msg1,String msg2){
		String msg5="修改成功";
		System.out.println(msg1);
		System.out.println(msg2);
		int userid=Integer.parseInt(msg2);
		System.out.println(userid);
		server1.delemenu(userid);
		Gson g=new Gson();
		List<MenuTable> list=g.fromJson(msg1,new TypeToken<List<MenuTable>>() {}.getType());
		if (list.size()>0){
			for (int i=0;i<list.size();i++){
				System.out.println("一级菜单"+list.get(i).getId());
				server1.addmenu(userid,list.get(i).getId());
				for (int j=0;j<list.get(i).getChildren().size();j++){
					server1.addmenu(userid,list.get(i).getChildren().get(j).getId());
				}
			}
		}
		return  msg5;
	}
	@RequestMapping("menutable.action")
	@ResponseBody
	public List<MenuTable> selallmenu(){
		List<MenuTable> list1= server1.selallmenu();
	return list1;
	}

}

