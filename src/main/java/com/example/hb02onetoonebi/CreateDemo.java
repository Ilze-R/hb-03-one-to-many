package com.example.hb02onetoonebi;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreateDemo {

    public static void main(String[] args) {
        SpringApplication.run(CreateDemo.class, args);

        //Instructor tempInstructor = new Instructor("Beatrise", "Cerina", "cerina@inbox.lv");
        //InstructorDetail tempInstructorDetail = new InstructorDetail("www.floristika.com/youtube", "gardening");

        //Instructor tempInstructor = new Instructor("Bob", "Wills", "bobby@inbox.lv");
        //InstructorDetail tempInstructorDetail = new InstructorDetail("www.gaming.com/youtube", "board games");

        Instructor tempInstructor = new Instructor("Robert", "Lake", "robby@gmail.lv");
        InstructorDetail tempInstructorDetail = new InstructorDetail("www.racing.com/youtube", "cars");

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tempInstructor.setInstructorDetail(tempInstructorDetail);
            session.beginTransaction();
            System.out.println("Saving instructor: " + tempInstructor);
            //this will also save the details object
            //because of CascadeType.ALL
            session.save(tempInstructor);
            //session.save(tempInstructorDetail);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
