package cn.kj.ebff.domain; /**
 * Created with IntelliJ IDEA.
 * Package: PACKAGE_NAME
 * cn.zz.model.User: 25414
 * Date: 2019/9/4
 * Time: 14:47
 * Description:用户实体类
 */

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Accessors(chain = true)
@Table(name = "account")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "id")
    private Long id;

    private String name;

    private String password;

    private String phone;

    private String email;

    private Short status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String created_date;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String modify_date;


}