package szh.wechat.util;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Test;


public class JsonUtil {
	public static Map<String, Object> JsonToMap(String s) {
		System.out.println(s);
		JSONObject jsonObject = new JSONObject(s);
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("title", jsonObject.get("title"));
		map.put("content", jsonObject.get("content"));
		return map;
	}
	@Test
	public void pr()
	{
		String s="{'dataes':{'title':2,content: 'aaa'}}";
		Map<String,Object> map=JsonUtil.JsonToMap(s);
		System.out.println(map.get("title"));
	}
}
