package vip.corejava.service;


import java.util.List;
import vip.corejava.entity.User;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;


/**
* 通用 service 代码生成器
*
* @author xiao
*/
public interface UserService{

    int save(User user);

    int updateById(User user);

    User selectById(Long id);

    int deleteById(Long id);

    int countByExample(Example example);

    List<User> selectByExample(Example example, RowBounds rowBounds);
}




