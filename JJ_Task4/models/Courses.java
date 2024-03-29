package JavaJunior.JJ_Task4.models;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "courses")
public class Courses {

    private static final String[] titles = new String[]{"Математика",
            "Физика", "Алгебра",
            "Геометрия", "Теория относительности",
            "Психология", "Астрономия",
            "Высшая математика", "Искусствоведение"};

    private static final Random random = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;

    public static Courses create() {
        return
                new Courses(titles[random.nextInt(titles.length)],
                        random.nextInt(100) + 1);
    }

    public Courses(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Courses(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public void updateTitle() {
        title = titles[random.nextInt(titles.length)];
    }

    public void updateDuration() {
        duration = random.nextInt(100) + 100;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
