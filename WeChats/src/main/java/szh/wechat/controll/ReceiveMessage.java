package szh.wechat.controll;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.Test;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import szh.wechat.entity.Message;
import szh.wechat.util.CheckUtil;
import szh.wechat.util.MessageExchange;

@Controller
@RequestMapping("/")
public class ReceiveMessage {
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public void index(HttpServletRequest request,HttpServletResponse response,PrintWriter out) {
		String signature=request.getParameter("signature");
		String timestamp=request.getParameter("timestamp");
		String nonce=request.getParameter("nonce");
		String echostr=request.getParameter("echostr");
		if(CheckUtil.checkutil(signature, timestamp, nonce))
		{
			out.print(echostr);
		}
		out.close();
	}
	@RequestMapping(value="/hello",method=RequestMethod.POST)
	public  void getindex(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		InputStream in =request.getInputStream();
		try {
			Map<String, String> map =MessageExchange.exchange(in);
			String ToUserName =map.get("ToUserName");
			String FromUserName =map.get("FromUserName");
			String CreateTime =map.get("CreateTime");
			String MsgType =map.get("MsgType");
			String Content =map.get("Content");
			String MsgId =map.get("MsgId");
			String messagecontentString =null;
			if(MsgType.equals("text"))
			{
				Message message =new Message();
				message.setFromUserName(ToUserName);
				message.setToUserName(FromUserName);
				message.setMsgType("text");
				message.setContent("您刚发送的消息是"+Content);
				message.setCreateTime(new Date().getTime());
				messagecontentString=MessageExchange.messagetoxml(message);
			}
			out.print(messagecontentString);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
