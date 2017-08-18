package com.spring.one_on_one;

import com.spring.one_on_one.entity.Instructor;
import com.spring.one_on_one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {
        DeleteDemo.delete();
    }

    public static void delete() {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();


            Instructor instructor = session.get(Instructor.class, 3);
            // This will also save InstructorDetail object because of CascadeType.all
            session.delete(instructor);

            // won't delete instructorDetail
            // session.createQuery("delete from Instructor where id=3").executeUpdate();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
