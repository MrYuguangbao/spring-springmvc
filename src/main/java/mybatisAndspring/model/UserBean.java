package mybatisAndspring.model;

import lombok.Data;

import java.util.Date;

/**
 * @author admin
 * @date 2020/3/28 15:42
 */
@Data
public class UserBean {

    private Integer id;
    private String userName;
    private Date birthday;
    private String sex;
    private String mobile;
    private String email;
    private String note;

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
