package szh.wechat.controll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import szh.wechat.util.JsonUtil;
@Controller
@RequestMapping("wechat")
@ResponseBody
public class ExerciseAjax {
	@RequestMapping("/ajax")
	public void ajax(String title,String content,HttpServletRequest request,HttpServletResponse response,@RequestParam(value="dataes",required=false) String dataes) throws Exception
	{
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
//		System.out.println(title);
//	    System.out.println(content);
		PrintWriter printWriter =response.getWriter();
		String contents= request.getParameter("dataes");
		System.out.println(contents+"ddd");
		System.out.println(request.getContextPath());
		System.out.println(dataes);
		Map<String, Object>  mapjson= JsonUtil.JsonToMap(s);
		System.out.println(mapjson.get("title"));
		System.out.println(mapjson.get("content"));
		if(mapjson.get("title").equals("1"))
		{
			printWriter.print("data");
		}else {
			printWriter.print("msg");
		}
	}
	public static String convertStreamToString(InputStream is) {      
	    StringBuilder sb = new StringBuilder();      
	    String line = null;      
	    try {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(is));      		
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
