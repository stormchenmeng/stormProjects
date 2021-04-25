import com.wind.dao.EmployeeDao;
import com.wind.entity.EmployeeEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class EmployeeTest {

    public static void main(String[] args) {

        //加载MyBatis配置文件
        InputStream inputStream = EmployeeTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取实现接口的代理对象
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        EmployeeEntity employeeEntity = employeeDao.queryEmployeeById(1);
        System.out.println(employeeEntity);

        //关闭资源
        sqlSession.close();
    }
}