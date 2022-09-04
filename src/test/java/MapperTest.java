import com.kuang.dao.BooksMapper;
import com.kuang.dao.TypeMapper;
import com.kuang.pojo.Books;
import com.kuang.pojo.Type;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author xxx
 * @version 1.0
 * @Description 测试dao层的工作
 * 推荐Spring的项目可以使用Spring的单元测试，可以自动注入我们需要的组件
 * 1、导入SpringTest的单元测试模块
 * 2、然后在测试类上添加@ContextConfiguration的注解来指定Spring配置文件的位置
 * 3、直接Autowired要使用的组件即可
 * @RunWith注解指定运行单元测试的时候使用哪个单元测试模块
 *
 * @date 2022/9/4 11:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    TypeMapper typeMapper;

    @Autowired
    BooksMapper booksMapper;
    @Autowired
    SqlSession sqlSession;
    /**
     * 测试种类TypeMapper工作
     */
    @Test
    public  void testCRUD(){
        System.out.println(typeMapper);
        //非Spring型的测试
        /*//1、创建SpringIOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2、从容器中获取Mapper
        Type bean = ioc.getBean(Type.class);*/
        //1、插入几个书籍种类
        //2、生成书籍信息、非批量操作模式
        /*for(int i =0;i<200;i++){
            String uid = UUID.randomUUID().toString().substring(0, 5)+i;
            booksMapper.insertSelective(new Books(null,uid,i,"测试数据",1));
        }*/
        //3、生成书籍信息，批量操作模式
        for(int i =0;i<200;i++){
            String uid = UUID.randomUUID().toString().substring(0, 5)+i;
            BooksMapper mapper = sqlSession.getMapper(BooksMapper.class);
            mapper.insertSelective(new Books(null,uid,i,"测试数据",1));
        }
    }
}
