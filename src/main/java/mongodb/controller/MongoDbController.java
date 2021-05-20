package mongodb.controller;

import mongodb.model.Item;
import mongodb.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * @author admin
 * @date 2020/6/3 17:07
 */
@Controller
public class MongoDbController {

    /*@Autowired
    private MongoTemplate template;*/

    @RequestMapping("/saveorder")
    public Order saveOrder(){
        Order order = new Order();
        order.setCustomer("顾客");
        order.setType("消费订单");
        Collection<Item> items = new LinkedHashSet<>();
        for (int i = 0; i < 3; i++) {
            Item item = new Item();
            item.setPrice(2.0*10+2);
            item.setProduct("product-"+i);
            item.setQuantity(i);
            item.setOrder(order);
            items.add(item);
        }
        order.setItems(items);
        //template.save(order,"orderobj");
        System.out.println("保存订单数据成功！");
        return order;
    }


}
