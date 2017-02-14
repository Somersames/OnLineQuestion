package szh.wechat.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EventTest {
	public static void main(String args[])
	{
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("ApplicationContext.xml");
		WeChatEvent weChatEvent =new WeChatEvent("hello", "这是测试", "ss", "2016");
		applicationContext.publishEvent(weChatEvent);
	}
}