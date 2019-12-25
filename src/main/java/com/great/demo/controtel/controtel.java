package com.great.demo.controtel;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.OrderDetail;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePageMergePayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.great.demo.javabean.*;
import com.great.demo.server.Server1;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.core.OrderComparator;
import org.springframework.core.annotation.Order;
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
	private final String APP_ID = "2016101500691629";
	private final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCABdJiDrmB+yNopGt36G2MOB+G/3bgXCEh8j7M51HXGp7I5gbAP6a7nFll/gjGKBNHo7t3Tj5jsMQe1FRu/N2mSAbYTadDZqj8OxJz3PF03yuEylH+oX6XfvHbnbkDGzOTfBoVKBMaDH2i0ZRbaquvkJlC0Ja7Oj/Uptdwj7GfB3K2vhrhL7Vse5Y1a48mAESt3PHfxQsen0AIreeL1Iw4NUHttxwXDCw32lvuE1Vn+VN34tiYHj+OzZtreQZyWVXWFQgBCrkvbv+PPdrmTVXxKBq83uBNgzKG4WFBX+a6KbzjtUWZLRxKXtJ2wXAp/ldxg+7XIeDSuq+bcBoxo7SfAgMBAAECggEACqBxFjKis2dlSQpc4VcpwLnn5AzQkU8UcPzquZd586ECDSsK5GpkLK6NvSmZENnCv++XYA/enefOX8DAQXY779GKv+myOKYM4OMGZRex80GTGzKwG7LMD0c6TECLWvanEVb700XAUCk5RIqhBfWUyr31+tXVrTTol35B49YJqGmW6UUopZCzHaxl6wS2aO6GrMu0Igpca3oxLt1/wBgLam7hJJPJoMa4JUu1VL4hHYUFBn4TU/U+hCxgAwrT//UiLw1f/xbGjDIWSzZ4LSZ9Ptbk0M7L7EkRmtQdAXCrK+/idxvcT8TkFGbxWv8TeBTh3Yg7m07T3b5MAUIwuqKmAQKBgQDm5X0CwmehR+F79RB3QzPygDmNRdEfX87IY/WzxBmFFA9xw+XuWW5l3ykReib7+ZZ5xAjqH5uf2FurQY7sdh2uO3f7EJyt6hNl9eSHCxGxej1VHjy0ScmzyKWmRb0kb/n6HxS6z4SLaG9+/DpGsM28GwUTF20iFn2k4MFbYmaMDQKBgQCN8RAQFg8zFxJndI+7YpDbbwg+TrrFEhRjpAdThFocG2GA8R1PaISCBC6ILDsh6xXuPj8dz3KyF9CcnVt216l7vIQ/jXnTadh4mL+RbV3J3F6NiiJTZh/+j0gpZ2pyo0QqWEhJfM1HaPIRIOhdFuode6raE4tfRezFesR8szicWwKBgQDLHc5fAw2Ov2EIXojhoWitR0dZk7VnWCzb87NNNJEOlJsRhTdb+ag4TZwfF8n7l5BcBauh6bRJZVcezEkikrWBdCcT4YUzKNtvsmQauA4Uhmg13KeiIdciJLw0DN1alHbfJUBjJfJ/gJu0pcXOMfKKK2rHZLBIcGiPBniSH3n+cQKBgGSKLNuIFIoWvJWFLc4IGh0kP42KzKaMkN6nL/1LUVx5VI41u5IksT864Q7ZbaUv1F/lvWVLLK3TSpO0rjW2urkHphEyD+ndHlUFtSO4eOdj7aGKB5hVTTJNoUqakv7SgJUR5VoQSYNcZaIWUiCl+3yYvUMs9tqsN/MFa6n8dIvjAoGAKiauA/RiuFC0X3DG6iSop+aKu4DphXjhRnI5OVYy9LyBMRyvrbv9jxQZEgGmxY+GKXPGvleoCMhS2ysYmskr4tkWD4pCciLvjr0r+yitJYbuHRcm2Oag/BkwXmzLanl9qZgI1Buemeke+WAS2nOtpugUrJYWMrMpmzt6772TPKs=";
	private final String CHARSET = "UTF-8";
	private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAha2r3Gm7CkYjFTW7u4XH5wWoUJHjXWc/U5mjx06G2i9ZW/iILZ1xCNRuEBPPh/9dn2fPD+dPREF+0Uf5+i1K9lzBw82mPuhukQpUjEbFIXX69iT4KEmO/Yh1X12G2tsuoPf6knUtYeIyOkSZkE+vx3zClpDtCpL2/u1fBDd2dLnVkhZJ0lGVaAjEVBeAi5agbJX24W1bNlw7boD5PqmELU4KwsB2p7MUy0VGJlRr1lYxcisPIWU0QpVen7/f3lwmGG+nLSA/AjwOAR9ZGcs57v87L+ppEOyQteEchFzh+/nF86geuCYaIr8cbQBc3SBavvyp88CY6EBjh4fwfNeceQIDAQAB";
	//这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
	private final String GATEWAY_URL ="https://openapi.alipaydev.com/gateway.do";
	private final String FORMAT = "JSON";
	//签名方式
	private final String SIGN_TYPE = "RSA2";
	//支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
	private final String NOTIFY_URL = "http://公网地址/notifyUrl";
	//支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
	private final String RETURN_URL = "http://localhost:8081/springpoot/alipayNotifyNotice.action";
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
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("jsp/userlist");
		return modelAndView;
	}
	//555
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
	@RequestMapping("selmoney.action")
	@ResponseBody
	public   String selmoney(String minute){
		int minte1=Integer.parseInt(minute);
		String money="";
		List<Yeshu> list1=server1.selfasttime();
		int fasttime=Integer.parseInt(list1.get(0).getCARDTIME());
		int twotime=Integer.parseInt(list1.get(1).getCARDTIME());
		int threetime=Integer.parseInt(list1.get(2).getCARDTIME());
		int lasttime=Integer.parseInt(list1.get(3).getCARDTIME());
		int fastmoney=list1.get(1).getEXCEEDMONEY();
		int nextmoney=list1.get(2).getEXCEEDMONEY();
		int money3=list1.get(2).getMONEY();
		int money4=list1.get(1).getMONEY();
		int money5=list1.get(0).getMONEY();
		int money6=list1.get(3).getMONEY();
		if (fasttime>=minte1){
		String money2=String.valueOf(money5);
		return money2;
		}
		else if (fasttime<minte1&&minte1<=twotime){
			String money2=String.valueOf(money4);
			return money2;
		}
		else if (twotime<minte1&&minte1<=threetime){
			int chaoguo=minte1-twotime;
			double allmoney= ((double) fastmoney/60.00)*chaoguo+money4;
			String result = String.format("%.2f", allmoney);
			return result;
		}
		else if (threetime<minte1&&minte1<=lasttime){
			int chaoguo=minte1-threetime;
			double allmoney1= ((double) nextmoney/60.00)*chaoguo+money3;
			String result = String.format("%.2f", allmoney1);
			return result;
		}
		else {
			String result1=String.valueOf(money6);
			return result1;
		}

	}
	@RequestMapping("alipay.action")
	public  void zhifubao(String time,HttpServletResponse httpResponse,String type) throws IOException {
		//实例化客户端,填入所需参数
		System.out.println(type);
		System.out.println(time);
		AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
		AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
		//在公共参数中设置回跳和通知地址
		request.setReturnUrl(RETURN_URL);
		request.setNotifyUrl(NOTIFY_URL);
		//根据订单编号,查询订单相关信息
	/*	Order order = payService.selectById(orderId);
		//商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = order.getOrderId().toString();
		//付款金额，必填
		String total_amount = order.getOrderPrice().toString();
		//订单名称，必填
		String subject = order.getOrderName();*/
		//商品描述，可空
		String body = "";
		request.setBizContent("{\"out_trade_no\":\""+ 19 +"\","
				+ "\"total_amount\":\""+ 5 +"\","
				+ "\"subject\":\""+ "会员缴费" +"\","
				+ "\"body\":\""+ body +"\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		String form = "";
		try {
			form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		httpResponse.setContentType("text/html;charset=" + CHARSET);
		httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
		httpResponse.getWriter().flush();
		httpResponse.getWriter().close();
	}
	/**
	 * @Description: 支付宝异步 通知页面
	 */
	@RequestMapping(value = "alipayNotifyNotice.action")
	@ResponseBody
	public ModelAndView alipayNotifyNotice(HttpServletRequest request, HttpServletRequest response) throws Exception {
		ModelAndView modelAndView=new ModelAndView();
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			/*valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");*/
			params.put(name, valueStr);
		}
		//调用SDK验证签名
		boolean signVerified = AlipaySignature.rsaCheckV1(params, Alipayconfig.ALIPAY_PUBLIC_KEY, Alipayconfig.CHARSET, Alipayconfig.SIGN_TYPE);

		//——请在这里编写您的程序（以下代码仅作参考）——

   /* 实际验证过程建议商户务必添加以下校验：
   1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
   2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
   3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
   4、验证app_id是否为该商户本身。
   */
		//验证成功
		if(signVerified) {
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			//交易状态
		/*	String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");*/
			//付款金额
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

			/*if(trade_status.equals("TRADE_FINISHED")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序

				//注意： 尚自习的订单没有退款功能, 这个条件判断是进不来的, 所以此处不必写代码
				//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			}*//*else if (trade_status.equals("TRADE_SUCCESS")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序

				//注意：
				//付款完成后，支付宝系统发送该交易状态通知

				// 修改叮当状态，改为 支付成功，已付款; 同时新增支付流水
				*//*orderService.updateOrderStatus(out_trade_no, trade_no, total_amount);

				Order order = orderService.getOrderById(out_trade_no);
				Product product = productService.getProductById(order.getProductId());

				log.info("********************** 支付成功(支付宝异步通知) **********************");
				log.info("* 订单号: {}", out_trade_no);
				log.info("* 支付宝交易号: {}", trade_no);
				log.info("* 实付金额: {}", total_amount);
				log.info("* 购买产品: {}", product.getName());
				log.info("***************************************************************");*//*
			}*/
			/*log.info("支付成功...");*/
			System.out.println("支付成功");
			modelAndView.addObject("out_trade_no",out_trade_no);
			modelAndView.addObject("trade_no",trade_no);
			modelAndView.addObject("total_amount",total_amount);
			modelAndView.setViewName("jsp/alipaySuccess");
		}else {//验证失败
			/*log.info("支付, 验签失败...");*/
			System.out.println("支付失败");
		}
		return modelAndView;
	}
	@RequestMapping("SelCare.action")
	@ResponseBody
	public  ALLDATA selall(){
		List<CardPort> list=server1.selall();
		ALLDATA alldata=new ALLDATA();
		alldata.setCode(0);
		alldata.setMsg("");
		alldata.setCount(new BigDecimal(10));
		alldata.setData(list);
		return  alldata;
	}


}



