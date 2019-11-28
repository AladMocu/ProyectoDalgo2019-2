import java.awt.*;
import java.util.Scanner;

public class ProblemaC {

    private  Point[] points;

    public ProblemaC()
    {
        Scanner sc = new Scanner(System.in);
        String work;
        int dominio,lados,px,py;
        while (sc.hasNext())
        {
            work=sc.nextLine();
            if(work.equals("0 0 0 0"))
            {
                break;
            }
            String[] current= work.split(" ");
            Point tested= new Point(current[2],current[3]);
            int points= Integer.parseInt(current[1]);
            String[] coords= sc.nextLine().split(" ");
            String x,y;
            for (int i = 0; i < points ;) {
                x=coords[i];
                i++;
                y=coords[i];
                i++;
                Point p= new Point(x,y);
            }

        }
        sc.close();
    }


    public static void main(String[] args) {

        ProblemaC problem = new ProblemaC();
    }

    public void contains(Point test) {
        int i;
        int j;
        boolean result = false;
        for (i = 0, j = points.length - 1; i < points.length; j = i++) {
            if ((points[i].y > test.y) != (points[j].y > test.y) &&  (test.x < (points[j].x - points[i].x) * (test.y - points[i].y) / (points[j].y-points[i].y) + points[i].x)) {
                result = !result;
            }
        }
        if(result)
        {
            System.out.println(1);
        }
        else
        {
            System.out.println(-1);
        }
    }


    public static class Point {
          double x;
          double y;

          public Point(String corx, String cory)
          {
              x=Integer.parseInt(corx);
              y=Integer.parseInt(cory);
          }
    }
}
