package szh.wechat.event;

import org.springframework.context.ApplicationEvent;

public class WeChatEvent extends ApplicationEvent{
	public WeChatEvent(Object source,String content,String user,String date) {
		super(source);
		this.content=content;
		this.user=user;
		this.date=date;
	}
	private String content;
	private String user;
	private String date;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
