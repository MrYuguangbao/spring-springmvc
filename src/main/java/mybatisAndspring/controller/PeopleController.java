package mybatisAndspring.controller;

import mybatisAndspring.model.People;
import mybatisAndspring.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author admin
 * @date 2020/3/28 15:53
 */

@Controller
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @RequestMapping("/query")
    @ResponseBody
    public List<People> query(){
        List<People> people = peopleService.queryPeople();
        System.out.println("查询完成！");
        return people;
    }


}
