package com.springtest.springel;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 19:57
 */
@Data
@Component("elvo")
public class ELVO {

    @Value("#{8}")
    private int id;
    @Value("#{'jordan'}")
    private String name;
}
