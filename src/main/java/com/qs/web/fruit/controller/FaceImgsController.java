package com.qs.web.fruit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qs.web.fruit.model.CarInfo;

@Controller
public class FaceImgsController {

	@RequestMapping(value="getCarList.do")
	public ModelAndView getCars() {
		ModelAndView mv=new ModelAndView();
		
		List<CarInfo> cars=new ArrayList<CarInfo>();
		CarInfo c1=new CarInfo();
		c1.setCarAge(2);
		c1.setName("宝马X6");
		c1.setPath("宝马x6很酷，我喜欢[1.jpg]不错的哦");
		cars.add(c1);
		
		CarInfo c2=new CarInfo();
		c2.setCarAge(2);
		c2.setName("奥迪A6");
		c2.setPath("魔幻汽车[2.jpg]你喜欢吗");
		cars.add(c2);
		mv.addObject("cars", cars);
		mv.setViewName("face_imgs");
		return mv;
	}
}
