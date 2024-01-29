package JavaJunior.JJ_Task4.task_number_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import JavaJunior.JJ_Task4.models.Student;

public class Program {
  
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Создание сессии
        Session session = sessionFactory.getCurrentSession();

        try
        {
            // Начало транзакции
            session.beginTransaction();

            // Создание объекта
            Student student = Student.create();


            // Сохранение объекта в базе данных
            session.save(student);
            System.out.println("Object student save successfully");

            // Чтение объекта из базы данных
            Student retrievedStudent = session.get(Student.class, student.getId());
            System.out.println("Object student retrieved successfully");
            System.out.println("Retrieved student object: " + retrievedStudent);

            // Обновление объекта
            retrievedStudent.updateName();
            retrievedStudent.updateAge();
            session.update(retrievedStudent);
            System.out.println("Object student update successfully");

            // Удаление объекта
            //session.delete(retrievedStudent);
            //System.out.println("Object student delete successfully");

            session.getTransaction().commit();
            System.out.println("Transaction commit successfully");
        }
        finally {
            // Закрытие фабрики сессий
            sessionFactory.close();
        }

    }

}
