package szh.wechat.junit;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import szh.wechat.pojo.Examination;
import szh.wechat.pojo.Exercise;
import szh.wechat.service.ExerciseService;
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
		map.put("start", 2);
		map.put("end", 1);
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
		map.put("examination_name","java");
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
}
