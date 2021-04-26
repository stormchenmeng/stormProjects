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

        EmployeeEntity entity = new EmployeeEntity();
        entity.setName("林青霞");
        entity.setGender("女");
        entity.setEmail("30@qq.com");
        int insertEmployee = employeeDao.insertEmployee(entity);
        System.out.println("insertEmployee=" + insertEmployee);

        int deleteEmployee = employeeDao.deleteEmployee(8);
        System.out.println("deleteEmployee =" + deleteEmployee);

        entity.setId(8);
        entity.setName("张娜拉");
        entity.setEmail("31@qq.com");
        int updateEmployee = employeeDao.updateEmployee(entity);
        System.out.println("updateEmployee=" + updateEmployee);

        EmployeeEntity employeeEntity = employeeDao.queryEmployeeById(1);
        System.out.println("employeeEntity=" + employeeEntity.toString());

        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
    }
}