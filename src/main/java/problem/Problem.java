package problem;

import javax.media.opengl.GL2;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Класс задачи
 */
public class Problem {
    /**
     * текст задачи
     */
    public static final String PROBLEM_TEXT = "ПОСТАНОВКА ЗАДАЧИ:\n" +
            "Задано множество окружностей и множество прямоугольников.\n" +
            "Найти такую пару прямоугольник-окружность, что фигура, \n" +
            "находящаяся внутри прямоугольника и окружности, \n" +
            "имеет максимальную площадь. Выделить найденные \n" +
            "прямоугольник и окружность, контур фигуры и \n" +
            "внутреннее пространство фигуры.\n";

    /**
     * заголовок окна
     */
    public static final String PROBLEM_CAPTION = "ИТОГОВЫЙ ПРОЕКТ УЧЕНИКА 10-7 БОРИСЕНКО НИКОЛАЯ";

    /**
     * путь к файлу
     */
    private static final String FILE_NAME = "points.txt";

    /**
     * список точек
     */
    private ArrayList<Point> points;

    /**
     * Конструктор класса задачи
     */
    public Problem() {
        points = new ArrayList<>();
    }

    /**
     * Добавить точку
     *
     * @param x      координата X точки
     * @param y      координата Y точки
     */
    public void addPoint(double x, double y, int setVal) {
        Point point = new Point(x, y);
        points.add(point);
    }

    //Решить задачу
    public void solve() {
        //
    }

    //Загрузить задачу из файла
    public void loadFromFile() {
        points.clear();
        try {
            File file = new File(FILE_NAME);
            Scanner sc = new Scanner(file);
            // пока в файле есть непрочитанные строки
            while (sc.hasNextLine()) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                int setVal = sc.nextInt();
                sc.nextLine();
                Point point = new Point(x, y);
                points.add(point);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка чтения из файла: " + ex);
        }
    }


    //Сохранить задачу в файл
    public void saveToFile() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME));
            for (Point point : points) {
                out.printf("%.2f %.2f %d\n", point.x, point.y);
            }
            out.close();
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл: " + ex);
        }
    }

    //Очистить задачу
    public void clear() {
        points.clear();
    }

    public void render(GL2 gl) {

        //данные для дебага
        Point p = new Point(3.1, 4);
        Point p1 = new Point(6, 3);

        Color white = new Color(255,255,255);
        //нарисовать координатные оси
        Point LEFTX = new Point(-20, 0),
                RIGHTX = new Point(20, 0),
                UPY = new Point(0, 20),
                DOWNY = new Point(0, -20);
        Figures.renderLine(gl, LEFTX, RIGHTX, 2, new Color(255,255,255));
        Figures.renderLine(gl, UPY, DOWNY, 2, new Color(255,255,255));
        Figures.renderTriangle(gl, new Point(19,1), new Point(20,0), new Point(19,-1),new Color(255,255,255),true);
        Figures.renderTriangle(gl, new Point(1,19), new Point(0,20), new Point(-1,19), new Color(255,255,255),true);
        //нарисовать координатные оси

        Quad q = new Quad(new Point(3,4), new Point(5,-2), new Point(9,7));
        q.render(gl,white,false);

        Circle c = new Circle(new Point(5,3),new Point(-8,14));
        c.render(gl,new Color(255, 100,0),false);

        p1.render(gl,2, white);
        p.render(gl,2,white);

        System.out.println(q.isInside(p));
        System.out.println(q.isInside(p1));
    }
}
