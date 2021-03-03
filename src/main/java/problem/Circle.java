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

    public boolean isInside(Point p){
        double x = p.x, y = p.y;
        double x0 = p0.x, y0=p0.y;
        if((x-x0)*(x-x0) + (y-y0)*(y-y0)<=R*R) return true;
        else return false;
    }

    //Рисование точки через класс Figures
    void render(GL2 gl, Color color, boolean filled) {
        Figures.renderCircle(gl,p0,R,color,filled);
    }
}



