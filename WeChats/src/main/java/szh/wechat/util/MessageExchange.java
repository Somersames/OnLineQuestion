package szh.wechat.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import szh.wechat.entity.Message;

import com.thoughtworks.xstream.XStream;

public class MessageExchange {
	public static Map exchange(InputStream in) throws DocumentException, IOException {
		Map<String, String> xmltoMap = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		Document doc = reader.read(in);
		Element element = doc.getRootElement();
		List<Element> list = element.elements();
		for (Element e : list) {
			xmltoMap.put(e.getName(), e.getText());
		}
		in.close();
		return xmltoMap;
	}
	public static String messagetoxml(Message message)
	{
		XStream xStream =new XStream();
		xStream.alias("xml",message.getClass());
		return  xStream.toXML(message);
	}
}
