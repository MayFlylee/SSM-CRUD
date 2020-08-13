import com.mayfly.crud.bean.Department;
import com.mayfly.crud.bean.Employee;
import com.mayfly.crud.dao.DepartmentMapper;

import com.mayfly.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/*
 * 1.导入SpringTest模块
 * 2.@ContextConfiguration指定的Spring配置文件的位置
 * 3.直接autowired要使用的组件即可
 * */
/*单元测试的注解*/
@RunWith(SpringJUnit4ClassRunner.class)

/*Spring自带的测试*/
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})


public class TestDemo {

    /*测试数据库连接*/
    @Test
    public void test1() {

    }

    /*测试myabtis逆向工程*/
    @Test
    public void test2() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("src/main/resources/mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    /*测试dao层的工作*/
    /*不适用Spring-test*/
    @Test
    public void test3() {
        /*这里建议使用SpringTest进行测试*/
        //1、创建SpringIOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2、从容器中获取mapper
        DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
        //3，打印获取的对象
        System.out.println(bean);
        /*结果*/
        /*
         * org.apache.ibatis.binding.MapperProxy@7b84fcf8
         * */
    }

    /*使用Spring-test测试dao层*/
    //自动注入
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;


    @Test
    public void test4() {
        System.out.println(departmentMapper);

        /*插入几个部门*/
        // departmentMapper.insertSelective(new Department(null, "开发部"));
        //  departmentMapper.insertSelective(new Department(null, "测试部"));

        /*生成员工*/
      //  employeeMapper.insertSelective(new Employee(null, "Jerry", "M", "Jerry@qq.com", 1));

    }
    /*批量插入员工信息*/
    //获取批量操作的对象,使用sqlSession对象保存连接状态
   /* @Autowired
    SqlSession sqlSession;
    @Test
    public void test5(){
        System.out.println(departmentMapper);
        //批量插入员工，使用sqlSession
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i <= 1000; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
            mapper.insertSelective(new Employee(null, uid, "M", uid + "@qq.com", 1));
        }
        System.out.println("批量插入完成");
    }*/
}
