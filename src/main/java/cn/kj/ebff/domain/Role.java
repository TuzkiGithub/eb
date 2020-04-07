package cn.kj.ebff.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.domain
 * User: 25414
 * Date: 2020/4/5
 * Time: 13:35
 * Description:角色实体类
 */
@Data
@Accessors(chain = true)
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "id")
    private Long id;

    private String name;

    private String desc;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String created_date;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String modify_date;

}
