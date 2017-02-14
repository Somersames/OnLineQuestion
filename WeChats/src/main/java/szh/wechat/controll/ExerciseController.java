package szh.wechat.controll;

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

import szh.wechat.pojo.Exercise;
import szh.wechat.service.ExerciseService;
import szh.wechat.util.PageBean;
@Controller
@RequestMapping("/")
public class ExerciseController {
	@Resource
	ExerciseService exerciseService;
	
	@RequestMapping("/exercise")
	public ModelAndView GetAllExercise(HttpServletRequest request,
		@RequestParam(value="page",required=false)String page,
		@RequestParam(value="types" ,required=false) String types
		)
	{
		//获取url里面的page参数以及向要显示的题目数
		Map<String, Object> typemap = new HashMap<String, Object>();
		System.out.println(types);
		typemap.put("type", types);
		ModelAndView modelAndView =new ModelAndView();
		Map<String, Object> map =new HashMap<String, Object>();
		//数据库总记录数
		int total= exerciseService.GetCountExercise(typemap);
		System.out.println(total+"总数");
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
		System.out.println(start);
		if(total<2)
		{
			map.put("end",total);
		}else {
			map.put("end",offset);
		}
		map.put("start", start);
		String url= request.getServletPath();
		List<Exercise> list =exerciseService.GetLimitExercise(map);
		modelAndView.addObject("exercise_list",list);
		modelAndView.addObject("type",types);
		modelAndView.addObject("pagecode",PageBean.page(request.getContextPath()+"/exercise", total, offset, Integer.parseInt(page),"types="+types));
		modelAndView.setViewName("index3");
		return modelAndView;
	}
}
