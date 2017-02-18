package szh.wechat.controll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import szh.wechat.service.ExerciseService;
import szh.wechat.util.JsonUtil;
@Controller
@RequestMapping("wechat")
@ResponseBody
public class ExerciseAjax {
	@Resource
	ExerciseService exerciseService;
	
	@RequestMapping("/ajax")
	public void ajax(String title,String content,HttpServletRequest request,HttpServletResponse response,@RequestParam(value="dataes",required=false) String dataes) throws Exception
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		InputStream in =request.getInputStream();
		Map<String, String[]> map=request.getParameterMap();
		Enumeration emEnumeration=request.getParameterNames();
		while(emEnumeration.hasMoreElements())
		{
			System.out.println(emEnumeration.nextElement());
			System.out.println("<br/>xiayige ");
		}
		System.out.println(map.keySet());
		String s=convertStreamToString(in);
		System.out.println(s+"zheshi inputstream");
		PrintWriter printWriter =response.getWriter();
		String contents= request.getParameter("dataes");
		System.out.println(contents+"ddd");
		System.out.println(request.getContextPath());
		System.out.println(dataes);
		Map<String, Object>  mapjson= JsonUtil.JsonToMap(s);
		System.out.println(mapjson.get("title"));
		System.out.println(mapjson.get("content"));
		String answere =exerciseService.getRightAnswere(Integer.parseInt((String) mapjson.get("title")));
		if(answere.equals(mapjson.get("content")))
		{
			System.out.println(answere+"查询出来的answere");
			printWriter.print("回答正确");
		}else {
			System.out.println(answere+"查询出来的answere");
			printWriter.print("回答错误");
		}
	}
	public static String convertStreamToString(InputStream is) {      
	    StringBuilder sb = new StringBuilder();
	    
	    String line = null;      
	    try {
	    	InputStreamReader inputStreamReader =new InputStreamReader(is, "utf-8");
	        BufferedReader reader = new BufferedReader(inputStreamReader);      		
	        while ((line = reader.readLine()) != null) {      
	            sb.append(line);      
	        }   
	    } catch (IOException e) {
	        e.printStackTrace();      
	    } finally {      
	        try {
	            is.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return sb.toString();      
	}
}
