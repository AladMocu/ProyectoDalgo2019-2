import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemaB {



    public ProblemaB() {
        readInput();
    }

    /**
     * Lectura de STDIN
     */
    public void readInput() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {

        int arrsize  = Integer.parseInt(sc.nextLine().trim());
            /**
             * Terminacion de ejecucion
             */
        if(arrsize==0)
        {
            return;
        }

            ArrayList<Pair> pairs= new ArrayList<>();
            /**
             * Creacion de lista de parejas de datos
             */
            for (int i = 0; i <arrsize ; i++) {
                String[] content= sc.nextLine().split(" ");
                Pair t= new Pair(i+1,Integer.parseInt(content[1]),Integer.parseInt(content[2]));
                pairs.add(t);
            }
            /**
             * Se ordenan las listas de parejas de datos
             */
            sortDecreasinY(pairs);

        }
        sc.close();
    }

    /**
     * Metodo que se encarga de ordenar decendientemente la lista de tuplas basada en el parametro y
     * Complejidad Temporal: O(nlogn)
     */
    private void sortDecreasinY(ArrayList<Pair> pairs) {
        pairs.sort((o1, o2) -> {
            return o1.y <= o2.y ? 1 : -1;
        });
        filterIncreasingX(pairs);
    }

    /**
     * Metodo que selecciona las tuplas que se encientran en orden ascendente, priorizando lamas larga
     * Complejidad Temporal : O(nlogn)
     */
    private void filterIncreasingX(ArrayList<Pair> pairs) {
        LongestIncreasingSubsequence( pairs.toArray(new Pair[pairs.size()]),pairs.size());
    }

    static int GetCeilIndex(Pair arr[], int T[], int l, int r, Pair key)
    {

        while (r - l > 1) {

            int m = l + (r - l) / 2;
            if (arr[T[m]].x >= key.x)
                r = m;
            else
                l = m;
        }

        return r;
    }


    /**
     * Metodo que obtiene la subsecuencia mas larga de manera acendente haciendo uso de n busquedas binarias,
     * remplazando los valores en caso de menor inicial
     */
    static int LongestIncreasingSubsequence(Pair arr[], int n)
    {



        int tailIndices[] = new int[n];

        // se inicializa en 0
        Arrays.fill(tailIndices, 0);

        int prevIndices[] = new int[n];

        Arrays.fill(prevIndices, -1);


        int len = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i].x < arr[tailIndices[0]].x)

                // nuevo valor mas pequeño
                tailIndices[0] = i;

            else if (arr[i].x >= arr[tailIndices[len - 1]].x) {

                // arr[i] sugiere aumentar la subsequencia mas larga
                prevIndices[i] = tailIndices[len - 1];
                tailIndices[len++] = i;
            }
            else {

                // arr[i] sugiere ser un candidato de futura subsequencia
                // Asi se remplasara el valor mas alto en los indices de la cola
                int pos = GetCeilIndex(arr, tailIndices, -1, len - 1, arr[i]);

                prevIndices[i] = tailIndices[pos - 1];
                tailIndices[pos] = i;
            }
        }


        /**
         * Caso especial
         */
        if(len==1||len==0)
        {
            System.out.println(0);
            System.out.println("*");
            return len;
        }
        System.out.println(len);
        ArrayList<Integer> tempArray= new ArrayList<>();


        /**
         * Lectura de la lista de indices
         */
        for (int i = tailIndices[len - 1]; i >= 0; i = prevIndices[i])
            tempArray.add(0,arr[i].index);


        /**
         * Salida a STDOUT de los datos
         */
        for (Integer t:tempArray) {
            System.out.print(t+" ");
        }
        System.out.println();

        return len;
    }


    public static  void main(String[] args){
        ProblemaB b = new ProblemaB();
    }

    /**
     * Clase auxiliar que representa una pareja de datos
     */
    static class Pair {

        public int x;

        public int y;

        public int index;

        public Pair(int pindex,int px, int py) {
            x = px;
            y = py;
            index=pindex;
        }
        public String toString()
        {
            return index+":{"+x+","+y+"}";
        }


    }
}
