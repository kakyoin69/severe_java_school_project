package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
public class Quad {
    //точки вершин
    Point p1,p2,p3,p4;

    //длины сторон
    double a,b;


    Quad(Point p1, Point p2, Point pA) {
        this.p1 = p1;
        this.p2 = p2;
        double d1,d2;
        d1 = pA.distanceTo(p1);
        d2 = pA.distanceTo(p2);
        a = Math.sqrt(d1*d1+d2*d2);

        Line line = new Line(p1,p2);
        Line line_parallel = line.parallelLine(pA);
        Line line_perped1 = line.perpendicularLine(p1);
        Line line_perped2 = line.perpendicularLine(p2);

        p3 = line_parallel.intersection(line_perped2);
        p4 = line_parallel.intersection(line_perped1);
    }

    //Рисование точки через класс Figures
    void render(GL2 gl, Color color, boolean filled) {
        Figures.renderQuad(gl,p1,p2,p3,p4,color,filled);
    }

    //Получить строковое представление точки



}
