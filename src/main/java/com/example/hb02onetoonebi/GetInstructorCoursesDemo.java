package com.example.hb02onetoonebi;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GetInstructorCoursesDemo {

    public static void main(String[] args) {
        SpringApplication.run(GetInstructorCoursesDemo.class, args);

        //Instructor tempInstructor = new Instructor("Deniss", "Denisdfovics", "ddvics@gmail.lv");
        //InstructorDetail tempInstructorDetail = new InstructorDetail("www.histordcynews.com/youtube", "books");

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();

           int theId = 1;
           Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("Instructor: " + tempInstructor);

            System.out.println("Courses: " + tempInstructor.getCourses());

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
