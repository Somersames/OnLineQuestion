package szh.wechat.controll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import szh.wechat.pojo.Answere;
import szh.wechat.pojo.Exercise;
import szh.wechat.service.AnswereService;
import szh.wechat.service.ExaminationService;
import szh.wechat.service.ExerciseService;
import szh.wechat.util.AnswereUtil;
import szh.wechat.util.PageBean;
@Controller
@RequestMapping("/")
public class ExerciseController {
	@Resource
	ExerciseService exerciseService;
	@Resource
	AnswereService answereService;
	@Resource
	ExaminationService examinationService;
	@RequestMapping("/exercise")
	public ModelAndView GetAllExercise(HttpServletRequest request,
		@RequestParam(value="page",required=false)String page,
		@RequestParam(value="types" ,required=false) String types,
		@RequestParam(value="click" ,required=false) String click
		)
	{
		if(click!=null)
		{
			Map<String, Object> maphit =new HashMap<String, Object>();
			maphit.put("exam_hit", Integer.parseInt(click)+1);
			maphit.put("exam_name", types);
			examinationService.updateExanhit(maphit);
		}
		//获取url里面的page参数以及向要显示的题目数
		Map<String, Object> typemap = new HashMap<String, Object>();
		typemap.put("type", types);
		ModelAndView modelAndView =new ModelAndView();
		Map<String, Object> map =new HashMap<String, Object>();
		//数据库总记录数
		int total= exerciseService.GetCountExercise(typemap);
		//每页显示数量
		int offset=2;
 		int start=0;
		if(page!=null && Integer.parseInt(page)>1)
		{
			int temp=Integer.parseInt(page)-1;
			start=temp*offset;
		}
		else {
			page="1";
		}
		if(total<2)
		{
			map.put("end",total);
		}else {
			map.put("end",offset);
		}
		map.put("start", start);
		map.put("type", types);
		String url= request.getServletPath();
		List<Exercise> list =exerciseService.GetLimitExercise(map);
		Map<Object, Object> answeremap =new HashMap<Object, Object>();
		//获取答案
		List<String> listanswere =answereService.getLimitAnswere(map);
		List<Map<String, Object>> testlist =new ArrayList<Map<String,Object>>();
		testlist=AnswereUtil.convertJsonListToListMapJson(listanswere);
		for(int i=0;i<testlist.size();i++)
		{
			System.out.println(testlist.get(i));
		}
		//答案获取结束
		modelAndView.addObject("answere",testlist);
		modelAndView.addObject("exercise_list",list);
		modelAndView.addObject("type",types);
		modelAndView.addObject("pagecode",PageBean.page(request.getContextPath()+"/exercise", total, offset, Integer.parseInt(page),"types="+types));
		modelAndView.setViewName("index3");
		return modelAndView;
	}
}
