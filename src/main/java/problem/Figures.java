package problem;

import javax.media.opengl.GL2;

import static javax.media.opengl.GL.*;

public class Figures{


    public static void renderPoint(GL2 gl, Point p, double W, Color color){
        double
                r=color.R/255,
                g=color.G/255,
                b=color.B/255;
        gl.glColor3d(r,g,b); //делаем цвет

        double x = p.x/20, y = p.y/20; //делаем нормальные координаты (20 максимум)


        gl.glPointSize((float) W);
        gl.glBegin(GL_POINTS);
        gl.glVertex2d(x,y);
        gl.glEnd();
    }

    public static void renderLine(GL2 gl, Point p1, Point p2, double W, Color color){
        double
                r=color.R/255,
                g=color.G/255,
                b=color.B/255;
        gl.glColor3d(r,g,b); //делаем цвет

        double x1 = p1.x/20, y1 = p1.y/20;
        double x2 = p2.x/20, y2 = p2.y/20;
        //делаем нормальные координаты (20 максимум)


        gl.glLineWidth((float) W);
        gl.glBegin(GL_LINES);
        gl.glVertex2d(x1,y1);
        gl.glVertex2d(x2,y2);
        gl.glEnd();
    }

    public static void renderTriangle(GL2 gl, Point p1, Point p2, Point p3, Color color, boolean filled){
        double
                r=color.R/255,
                g=color.G/255,
                b=color.B/255;
        gl.glColor3d(r,g,b); //делаем цвет

        double x1 = p1.x/20, y1 = p1.y/20;
        double x2 = p2.x/20, y2 = p2.y/20;
        double x3 = p3.x/20, y3 = p3.y/20;
        //делаем нормальные координаты (20 максимум)
        if(!filled){
        gl.glBegin(GL_LINE_STRIP);
        gl.glVertex2d(x1,y1);
        gl.glVertex2d(x2,y2);
        gl.glVertex2d(x3,y3);
        gl.glVertex2d(x1,y1);
        gl.glEnd();}
    else{
            gl.glBegin(GL_TRIANGLES);
            gl.glVertex2d(x1,y1);
            gl.glVertex2d(x2,y2);
            gl.glVertex2d(x3,y3);
            gl.glEnd();
        }
    }
}