package test;

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
import vip.corejava.service.UserService;

import java.util.List;

@SpringBootTest(classes = ApplicationMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class ServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void saveTest() {
        User u = new User();
        u.setName("xiao").setMobile("15270488647");
        int z = userService.save(u);
        log.info(z + "==========" + u);
    }

    @Test
    public void t1() {
        User user = userService.selectById(1l);
        log.info(user + "-----");
    }

    private Example createExample(){
        Example example = new Example(User.class);
        example.orderBy("id").desc();
        return example;
    }
    @Test
    public void t3() {
        int count = userService.countByExample(createExample());
        log.info("......>>"+count);
        PageRowBounds page = new PageRowBounds(0, 10);
        page.setCount(false);
        List<User> dataList = userService.selectByExample(createExample(), page);
        log.info("......>"+dataList);
    }
}
