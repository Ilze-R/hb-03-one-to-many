package com.example.hb02onetoonebi;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreateInstructorDemo {

    public static void main(String[] args) {
        SpringApplication.run(CreateInstructorDemo.class, args);

        //Instructor tempInstructor = new Instructor("Beatrise", "Cerina", "cerina@inbox.lv");
        //InstructorDetail tempInstructorDetail = new InstructorDetail("www.floristika.com/youtube", "gardening");

        //Instructor tempInstructor = new Instructor("Bob", "Wills", "bobby@inbox.lv");
        //InstructorDetail tempInstructorDetail = new InstructorDetail("www.gaming.com/youtube", "board games");

        Instructor tempInstructor = new Instructor("Deniss", "Denisovics", "ddvics@gmail.lv");
        InstructorDetail tempInstructorDetail = new InstructorDetail("www.historynews.com/youtube", "books");

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tempInstructor.setInstructorDetail(tempInstructorDetail);
            session.beginTransaction();

            System.out.println("Saving the instructor: " + tempInstructor);

            session.save(tempInstructor);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
