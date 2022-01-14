package com.example.hb02onetoonebi;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreateCoursesDemo {

    public static void main(String[] args) {
        SpringApplication.run(CreateCoursesDemo.class, args);

        //Instructor tempInstructor = new Instructor("Deniss", "Denisdfovics", "ddvics@gmail.lv");
        //InstructorDetail tempInstructorDetail = new InstructorDetail("www.histordcynews.com/youtube", "books");

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();

           int theId = 1;
           Instructor tempInstructor = session.get(Instructor.class, theId);

           Course tempCourse1 = new Course("Gardening - Beginners quide");
           Course tempCourse2 = new Course("How to clean Your home");

           tempInstructor.add(tempCourse1);
           tempInstructor.add(tempCourse2);

           session.save(tempCourse1);
           session.save(tempCourse2);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
