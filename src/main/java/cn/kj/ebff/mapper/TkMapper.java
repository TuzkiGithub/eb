package cn.kj.ebff.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.mapper
 * User: 25414
 * Date: 2020/4/5
 * Time: 13:51
 * Description:
 */
public interface TkMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
