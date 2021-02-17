package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

/**
 * Класс точки
 */
public class Point {
    //x - координата точки
    double x;
    //y - координата точки
    double y;

    /**
     * Конструктор точки
     *
     * @param x         координата
     * @param y         координата y
     */

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point point) {
        double d = Math.sqrt((x - point.x) * (x - point.x) + (y - point.y) * (y - point.y));
        return d;
    }

    //Рисование точки через класс Figures
    void render(GL2 gl, double W, Color color) {
        Figures.renderPoint(gl,this, W, color);
    }

    //Получить строковое представление точки
    @Override
    public String toString() {
        return "Точка с координатами: {" + x + "," + y + "}";
    }
}
