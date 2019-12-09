import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemaC {


    public ProblemaC() {
        Scanner sc = new Scanner(System.in);
        String work;
        while (sc.hasNext()) {
            work = sc.nextLine();
            if (work.equals("0 0 0 0")) {
                break;
            }
            String[] current = work.split(" ");

            Point tested = new Point(current[2], current[3]);
            int points = Integer.parseInt(current[1]);

            String[] coords = sc.nextLine().split(" ");

            String x, y;
            ArrayList<Point> polygon=new ArrayList<>();

            for (int i = 0,j=0; i < points;i++ ) {
                x = coords[j];
                j++;
                y = coords[j];
                j++;
                Point p = new Point(x, y);
                polygon.add(p);
            }

            contains(polygon.toArray(new Point[points]),tested);

        }
        sc.close();
    }


    public static void main(String[] args) {

        ProblemaC problem = new ProblemaC();
    }

    public void contains(Point[] points,Point test) {

        int i;
        int j;
        boolean result = false;
        for (i = 0, j = points.length - 1; i < points.length; j = i++) {
            if ((points[i].y > test.y) != (points[j].y > test.y) && (test.x < (points[j].x - points[i].x) * (test.y - points[i].y) / (points[j].y - points[i].y) + points[i].x)) {
                result = !result;
            }
        }
        if (result) {
            inline(test,points);
        } else {
            System.out.println(-1);
        }
    }

    public void inline(Point test,Point[] polygon)
    {
        for (int i = 1; i < polygon.length; i++) {
            double tempDist=distToSegmentSquared(test,polygon[i],polygon[i-1]);
            if (tempDist==0)
            {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }



    static double sqr(double x) {
        return x * x;
    }
    static double dist2(Point v, Point w) {
        return sqr(v.x - w.x) + sqr(v.y - w.y);
    }
    static double distToSegmentSquared(Point p, Point v, Point w) {
        double l2 = dist2(v, w);
        if (l2 == 0) return dist2(p, v);
        double t = ((p.x - v.x) * (w.x - v.x) + (p.y - v.y) * (w.y - v.y)) / l2;
        if (t < 0) return dist2(p, v);
        if (t > 1) return dist2(p, w);
        return dist2(p, new Point(
                v.x + t * (w.x - v.x),
                v.y + t * (w.y - v.y)
        ));
    }



    public static class Point {
          double x;
          double y;

          public Point(String corx, String cory)
          {
              x=Integer.parseInt(corx);
              y=Integer.parseInt(cory);
          }

        public Point(double px, double py) {
              x=px;
              y=py;
        }


        public String toString() {
            return "("+x+","+y+")";
        }
    }
}
