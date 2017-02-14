package szh.wechat.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class WeChatNotify implements ApplicationListener {

	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		if (event instanceof WeChatEvent) {
			WeChatEvent weChatEvent = (WeChatEvent) event;
			System.out.println("接收的内容时" + weChatEvent.getContent());
			System.out.println("接收的人是" + weChatEvent.getUser());
			System.out.println("接收的日期" + weChatEvent.getDate());
		} else {
			System.out.println("容器本身" + event);
		}
	}

}
