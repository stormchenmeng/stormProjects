import com.wind.controller.StudentController;
import com.wind.entity.StudentEntity;
import com.wind.service.StudentService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

public class StudentControllerTest extends BaseTest {
    @Resource
    private StudentService studentService;

    @Resource
    private StudentController studentController;

    @Test
    public void studentControllerTest() {
        List<StudentEntity> entities = studentController.findAll();
        System.out.println(entities);
    }


    @Test
    public void findAllStudentTest() {
        List<StudentEntity> entities = studentService.findAllStudent();
        System.out.println(entities);
    }

    @Test
    public void findStudentByIdTest() {
        int id = 1;
        StudentEntity entity = studentService.findStudentById(id);
        System.out.println(entity);
    }

    @Test
    public void insertStudentTest() {
        int count = 0;
        for (int i = 1; i < 3; i++) {
            StudentEntity entity = new StudentEntity();
            entity.setName("周星驰" + i);
            entity.setClassId(i);
            count = count + studentService.insertStudent(entity);
        }
        System.out.println(count);
    }

    @Test
    public void deleteStudentTest() {
        int count = 0;
        for (int i = 7; i < 13; i++) {
            count = count + studentService.deleteStudent(i);
        }
        System.out.println(count);
    }

    @Test
    public void updateStudentTest() {
        int count = 0;
        for (int i = 7; i < 13; i++) {
            StudentEntity entity = new StudentEntity();
            entity.setId(i);
            entity.setClassId(i - 6);
            entity.setName("周星驰" + "-" + "周润发" + (i - 6));
            count = count + studentService.updateStudent(entity);
        }
        System.out.println(count);
    }
}
