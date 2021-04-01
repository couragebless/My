package com.rain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rain.domain.Meetting;
import com.rain.service.RainService;

@Controller
public class MeetController {
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	
	// 如果在目录下输入为空，则跳转到指定链接
	@RequestMapping(value="/meet/")
	 public ModelAndView index2(ModelAndView mv){
		mv.setViewName("meet/list");
		return mv;
	}
	// 如果在目录下输入任何不存在的参数，则跳转到list
	@RequestMapping(value="/meet/{formName}")
	 public String index2(@PathVariable String formName){
//		return formName;
		String blank = "/meet/list";
		return blank;
	}
	
	@RequestMapping(value="/meet/list",method=RequestMethod.GET)
	 public String index(Model model,String content){
//		System.out.println("4234");
		List<Meetting> meet_list = rainservice.findAllMeet();
		if (content!=null){
			meet_list = rainservice.findAllMeet(content);
		}
		
		model.addAttribute("list",meet_list);
//		for(Dept attribute : dept_list) {
//			  System.out.println(attribute.getName());
//			}
		return "meet/list";
	}
	@RequestMapping(value="/meet/add",method=RequestMethod.GET)
	 public String add(Model model,Integer id){
//		System.out.println(id);
		if(id!=null){
			Meetting meetting = rainservice.get_meet_info(id);
			model.addAttribute("meetting",meetting);
//			System.out.println(dept.getName());
		}
		return "/meet/add";
	}
	@RequestMapping(value="/meet/add",method=RequestMethod.POST)
	 public ModelAndView add(ModelAndView mv,@ModelAttribute Meetting meetting ,Integer id){
		System.out.println(id);
//		System.out.println(dept.getId());
		if(id!=null){
			rainservice.update_meet_info(meetting);
			System.out.println(meetting.getId());
		}else{
			rainservice.addMeet(meetting);
		}
//		System.out.println(dept.getName());
		mv.setViewName("redirect:/meet/list");
		return mv;
	}
	@RequestMapping(value="/meet/delete",method=RequestMethod.GET)
	 public void delete(Integer id){
		System.out.println(id);
		if(id!=null){
			rainservice.delete_meet_info(id);
		}
	}
}
