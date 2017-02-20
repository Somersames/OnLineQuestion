package szh.wechat.controll;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import szh.wechat.service.UserService;

@Controller
public class UserController {
	@Resource
	UserService userService;
	@RequestMapping("login")
public ModelAndView userLogin(HttpServletRequest request,HttpServletResponse response,
		@RequestParam(value="username" ,required=true) String username,
		@RequestParam(value="password" ,required=true) String password)
{
		 ModelAndView modelAndView =new ModelAndView();
		 HttpSession session =request.getSession();
		 Map<String, Object> map =new HashMap<String, Object>();
		 map.put("username", username);
		 map.put("password", password);
		 if(userService.checkUser(map)!=null)
		 {
			 session.setAttribute("username", username);
			 return new ModelAndView("redirect:/exercise");
		 }else {
			return new ModelAndView("error");
		}
	
}
	@RequestMapping("enter")
	public String enter()
	{
		return "login";
	}
}
