package mybatisAndspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: admin
 * @Description: 控制器
 * @BelongsProject: spring-test
 * @BelongsPackage: mybatisAndspring.controller
 * @CreateTime: 2021-05-20 23:08:08
 */
@Controller
@RequestMapping("/my")
public class MyController {

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		// 设置视图的逻辑名称
		mv.setViewName("index");
		return mv;
	}


}
