package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
public class Circle {
    //точка центра
    Point p0;

    //радиус
    double R;


    Circle(Point p0, Point pIn) {
        this.p0 = p0;
        this.R = p0.distanceTo(pIn);

    }

    //Рисование точки через класс Figures
    void render(GL2 gl, Color color, boolean filled) {
        Figures.renderCircle(gl,p0,R,color,filled);
    }
}



