package vip.corejava.service.impl;


import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vip.corejava.entity.User;
import vip.corejava.service.UserService;
import vip.corejava.mapper.UserMapper;
import java.time.LocalDateTime;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

/**
* 通用 serviceImpl 代码生成器
*
* @author xiao
*/
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private UserService that;

    @Override
    @Transactional
    public int save(User user) {
         return userMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int updateById(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User selectById(Long id) {
       return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Long id) {
        User user = new User();
        user.setId(id).setIsDeleted((byte) 1).setUpdatedAt(LocalDateTime.now());
        return userMapper.updateByPrimaryKeySelective(user);
    }


    @Override
    public int countByExample(Example example) {
        return userMapper.selectCountByExample(example);
    }

    @Override
    public List<User> selectByExample(Example example, RowBounds rowBounds) {
        return userMapper.selectByExampleAndRowBounds(example,rowBounds);
    }
}




