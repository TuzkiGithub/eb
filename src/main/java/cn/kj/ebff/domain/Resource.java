package cn.kj.ebff.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.domain
 * User: 25414
 * Date: 2020/4/5
 * Time: 15:18
 * Description:资源实体表
 */
@Data
@Accessors(chain = true)
@Table(name = "resource")
public class Resource {

    private Long id;

    private Long pid;

    private String name;

    private String perms;

    private String desc;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String created_date;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String modify_date;
}
