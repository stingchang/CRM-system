package com.spring.one_on_one_bidirection.one_on_one;

import com.spring.one_on_one_bidirection.one_on_one.entity.Instructor;
import com.spring.one_on_one_bidirection.one_on_one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

    public static void main(String[] args) {
        GetInstructorDetailDemo.delete();
    }

    public static void delete() {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {

            // start a transaction
            session.beginTransaction();

            // get the instructor detail object
            int theId = 2999;
            InstructorDetail tempInstructorDetail =
                    session.get(InstructorDetail.class, theId);

            // print the instructor detail
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);

            // print  the associated instructor
            System.out.println("the associated instructor: " +
                    tempInstructorDetail.getInstructor());

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            // handle connection leak issue
            session.close();

            factory.close();
        }
    }
}
