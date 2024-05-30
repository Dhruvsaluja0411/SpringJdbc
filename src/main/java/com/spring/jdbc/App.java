package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My program started" );
        // spring JDBC -> JdbcTemplate object
        
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao std = context.getBean("studentDao",StudentDao.class);
          //INSERT
//        Student student = new Student();
//        student.setCity("Luknow");
//        student.setId(3);
//        student.setName("Akash");
//        int rows = std.insert(student);
//        System.out.println("The number of rows inserted... "+rows);
        
          //UPDATE
//        Student student = new Student();
//        student.setCity("Guwahati");
//        student.setId(1);
//        student.setName("Dhruv Saluja");
//        int rows = std.change(student);
//        System.out.println("The number of rows updated... "+rows);
//        context.close();
        
          //DELETE
//        Student student = new Student();
//        student.setId(1);
//        int rows = std.delete(student);
//        System.out.println("The number of rows deleted... "+rows);
//        context.close();
        
//        Student student = std.getStudent(3);
//        System.out.println("Student Id: " + student.getId());
//        System.out.println("Student Name: " + student.getName());
//        System.out.println("Student City: " + student.getCity());
        
        List<Student> students = std.getAllStudent();
        for(Student student: students)
        {
            System.out.println("Student Id: " + student.getId());
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student City: " + student.getCity());
        }
    }
}
