package JavaJunior.JJ_Task4;

public class Program {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // Создание сессии
        Session session = sessionFactory.getCurrentSession();

        try {
            // Начало транзакции
            session.beginTransaction();

            // Создание объекта
            Course course = Course.create();

          // Сохранение объекта в базе данных
            session.save(course);
            System.out.println("Object course save successfully");

            // Чтение объекта из базы данных
            Course retrievedStudent = session.get(Course.class, course.getId());
            System.out.println("Object course retrieved successfully");
            System.out.println("Retrieved course object: " + retrievedStudent);

            // Обновление объекта
            retrievedStudent.updateTitle();
            retrievedStudent.updateDuration();
            session.update(retrievedStudent);
            System.out.println("Object course update successfully");

            session.getTransaction().commit();
            System.out.println("Transaction commit successfully");
        } finally {
            // Закрытие фабрики сессий
            sessionFactory.close();
        }
    }
}
