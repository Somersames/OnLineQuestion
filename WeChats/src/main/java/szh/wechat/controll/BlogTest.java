package szh.wechat.controll;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
public class BlogTest {
	@RequestMapping("/index")
	public ModelAndView blog() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
}
