package szh.wechat.controll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import szh.wechat.pojo.Examination;
import szh.wechat.service.ExaminationService;

@Controller
@RequestMapping("/")
public class IndexController {
	@Resource
	ExaminationService examinationService;
	@RequestMapping("/")
	public ModelAndView GetIndex() {
		ModelAndView modelAndView=new ModelAndView();
		List<Examination> list =examinationService.GetAllExam();
		modelAndView.addObject("examlist",list);
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
