import java.util.Scanner;

public class ProblemaA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while (sc.hasNext())
        {
            str = sc.nextLine();
        }
        sc.close();
    }
    /**
     * Para resolver este problema usaremos la mejor implementacion conocida para el subarreglo recurrente mas largo conocida hasta el momento:
     *  suffix tree , la cual tiene complejidad tanto temporal como espacial de n
     */
}
