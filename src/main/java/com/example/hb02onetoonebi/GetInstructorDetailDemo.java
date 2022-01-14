package com.example.hb02onetoonebi;

import org.hibernate.Session;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();

            int theId = 7;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);
            System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());


           // tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
