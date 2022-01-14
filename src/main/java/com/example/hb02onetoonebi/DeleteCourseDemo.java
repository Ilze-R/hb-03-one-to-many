package com.example.hb02onetoonebi;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeleteCourseDemo {

    public static void main(String[] args) {
        SpringApplication.run(DeleteCourseDemo.class, args);

        //Instructor tempInstructor = new Instructor("Deniss", "Denisovics", "d.vics@gmail.com");
        //InstructorDetail tempInstructorDetail = new InstructorDetail("www.history-news.com/youtube", "books");

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();

            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);

            System.out.println("Deleting course: " + tempCourse);

            session.delete(tempCourse);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
