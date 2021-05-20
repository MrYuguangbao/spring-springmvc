package springmvc;

import com.springtest.mybatis.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@Controller
@RequestMapping("/my")
public class MyController {

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");//视图逻辑名
        return mv;
    }

    public static void main(String[] args) {
        User user = new User();
        Integer i = 1;
        Integer j = new Integer(1);
        System.out.println(i.hashCode());
        System.out.println(j.hashCode());

    }
}
