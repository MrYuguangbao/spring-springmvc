package mybatisAndspring.model;

import lombok.Data;

import java.util.Date;

/**
 * @author admin
 * @date 2020/3/28 15:42
 */
@Data
public class RoleBean {

    private Integer id;
    private String roleName;
    private Date createDate;
    private String note;

    @Override
    public String toString() {
        return "RoleBean{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", createDate=" + createDate +
                ", note='" + note + '\'' +
                '}';
    }
}
