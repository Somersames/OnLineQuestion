package szh.wechat.junit;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import szh.wechat.pojo.Examination;
import szh.wechat.pojo.Exercise;
import szh.wechat.pojo.JsonTest;
import szh.wechat.service.ExaminationService;
import szh.wechat.service.ExerciseService;
import szh.wechat.service.JsonTestService;
import szh.wechat.serviceimpl.ExaminationServiceImpl;

public class Exam_junit {
	@Test
	public void junit()
	{
		//查询考题试卷类别
		ClassPathXmlApplicationContext xml = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
		ExaminationServiceImpl examinationServiceImpl =(ExaminationServiceImpl) xml.getBean("examinationServiceImpl");
		List<Examination> list=examinationServiceImpl.GetAllExam();
		for(Examination s:list)
		{
			System.out.println(s);
			System.out.println(s.getExam_people());
		}
	}
	@Test
	public void GetAllExercise()
	{
		ClassPathXmlApplicationContext xml =new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
		ExerciseService exerciseService =(ExerciseService) xml.getBean("exerciseServiceImpl");
		List<Exercise> list1=exerciseService.GetAllExercise();
		for(Exercise e:list1)
		{
			System.out.println(e.getExercise_id());
			System.out.println(e.getExercise_title());
			System.out.println(e.getExercise_content());
		}
	}
	@Test
	public void GetLImitExercise()
	{
		ClassPathXmlApplicationContext xml =new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
		ExerciseService exerciseService =(ExerciseService)xml.getBean("exerciseServiceImpl");
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("type", "jquery");
		map.put("start", 0);
		map.put("end", 2);
		List<Exercise> list=exerciseService.GetLimitExercise(map);
		for(Exercise e:list)
		{
			System.out.println(e.getExercise_id());
			System.out.println(e.getExercise_title());
			System.out.println(e.getExercise_content());
		}
	}
	@Test
	public void GetExaminationType()
	{
		ClassPathXmlApplicationContext xml =new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
		ExerciseService exerciseService =(ExerciseService)xml.getBean("exerciseServiceImpl");
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("examination_name","jquery");
//		map.put("examination_id", 1);
		List<Exercise> list =exerciseService.GetExaminationType(map);
		for(Exercise e:list)
		{
			System.out.println(e.getExercise_id());
			System.out.println(e.getExercise_title());
			System.out.println(e.getExercise_content());
		}
	}
	
	@Test
	public void GetCountExercise()
	{
		ClassPathXmlApplicationContext xml =new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
		ExerciseService exerciseService =(ExerciseService)xml.getBean("exerciseServiceImpl");
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("type", "jquery");
		int i= exerciseService.GetCountExercise(map);
		System.out.println(i);
	}
	@Test
	public void mathtest()
	{
		int i=(int) Math.ceil(5%3);
		System.out.println(5%3);
		System.out.println(i);
	}
	@Test
	public void jsonToString()
	{
		String string="{'A': 'STRING','B': 'INT','C': 'c','D': 'd'}";
		JSONObject jsonObject = new JSONObject(string);
		Map<String, Object> map =new HashMap<String, Object>();
		Map<String, Object> map1 =jsonObject.toMap();
		System.out.println(map1.get("A"));
//		map.put("A", jsonObject.get("A"));
//		map.put("B", jsonObject.get("B"));
//		System.out.println(map.get("A"));
	}
	@Test
	public void jsonTestTest()
	{
		String string="{'A': 'STRING','B': 'INT','C': 'c','D': 'd'}";
		ClassPathXmlApplicationContext xml =new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
		JsonTestService jsonTestService =(JsonTestService) xml.getBean("jsonTestServiceImpl");
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("name", string);
		map.put("id", "2");
		jsonTestService.saveJsonTest(map);
	}
	@Test
	public  void getJsonTest()
	{
//		WebApplicationContext wac =org.springframework.web.context.ContextLoader.getCurrentWebApplicationContext();
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("id", "2");
		ClassPathXmlApplicationContext xml =new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
		JsonTestService jsonTestService =(JsonTestService) xml.getBean("jsonTestServiceImpl");
//		JsonTestService jsonTestService=(JsonTestService) wac.getBean("jsonTestServiceImpl");
		JsonTest jsonTest=jsonTestService.getJsonTest(map);
		System.out.println(jsonTest.getJson_name());
		JSONObject jsonObject = new JSONObject(jsonTest.getJson_name());
		Map<String, Object> map1 =new HashMap<String, Object>();
		map1.put("A", jsonObject.get("A"));
		map1.put("B", jsonObject.get("B"));
		System.out.println(map1.get("A"));
	}
	//测试更新点击次数方法是否正确
	@Test
	public  void  testupdate()
	{
		ClassPathXmlApplicationContext classPathXmlApplicationContext =new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
		ExaminationService examinationService =(ExaminationService)classPathXmlApplicationContext.getBean("examinationServiceImpl");
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("exam_hit", 3);
		map.put("exam_commenthit", 3);
		map.put("exam_id", 1);
		examinationService.updateExanhit(map);
	}
}

