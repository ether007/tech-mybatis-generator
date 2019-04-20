package test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageRowBounds;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.entity.Example;
import vip.corejava.ApplicationMain;
import vip.corejava.entity.User;
import vip.corejava.mapper.UserMapper;

import java.util.List;

@SpringBootTest(classes = ApplicationMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    private Example createExample(){
        Example example = new Example(User.class);
        example.orderBy("id").desc();
        return example;
    }
    @Test
    public void saveTest() {
        PageRowBounds page = new PageRowBounds(10, 10);
        page.setCount(false);
        List<User> z = userMapper.selectByExampleAndRowBounds(createExample(), page);
        Page<User> data = (Page<User>) z;
        log.info(data.toString());
    }

    @Test
    public void selectCount() {
        int count = userMapper.selectCountByExample(createExample());
        log.info("total:" + count);
    }
}
