package com.example.hb02onetoonebi;

import org.hibernate.Session;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();

            int theId = 9;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);
            System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

            // tempInstructor.setInstructorDetail(tempInstructorDetail);

            //to delete only Instructor data - remove the associated object reference
            //break bi-derectional link
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
            session.delete(tempInstructorDetail);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
