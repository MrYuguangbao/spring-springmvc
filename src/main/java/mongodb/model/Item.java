package mongodb.model;

import lombok.Data;

/**
 * @author admin
 * @date 2020/6/3 15:35
 */
@Data
public class Item {

    private Long id;
    private Order order;
    private String product;
    private double price;
    private int quantity;

}
