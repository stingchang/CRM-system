package com.spring.one_on_one_bidirection.one_on_one;

import com.spring.one_on_one_bidirection.one_on_one.entity.Instructor;
import com.spring.one_on_one_bidirection.one_on_one.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {
        CreateDemo.create();
    }

    public static void create() {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Instructor inst = new Instructor("Sting", "Chang", "sting@gmail.com");
            InstructorDetail instDetail = new InstructorDetail(
                    "https://www.youtube.com/watch?v=PFw83-39KWU", "programming");



            inst.setInstructorDetail(instDetail);

            // This will also save InstructorDetail object because of CascadeType.all
            session.save(inst);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
