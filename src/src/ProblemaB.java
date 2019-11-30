import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemaB {



    public ProblemaB() {
        readInput();
    }

    public void readInput() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
        int arrsize  = Integer.parseInt(sc.nextLine().trim());

            ArrayList<Pair> pairs= new ArrayList<>();
            for (int i = 0; i <arrsize ; i++) {
                String[] content= sc.nextLine().split(" ");
                Pair t= new Pair(i,Integer.parseInt(content[1]),Integer.parseInt(content[2]));
            }
            sortDecreasinY(pairs);
            filterIncreasingX(pairs);
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
    }

    /**
     * Metodo que selecciona las tuplas que se encientran en orden ascendente, priorizando lamas larga
     * Complejidad Temporal : O(nlogn)
     */
    private void filterIncreasingX(ArrayList<Pair> pairs) {
        LongestIncreasingSubsequence((Pair[]) pairs.toArray(),pairs.size());
    }

    // Binary search
    static int GetCeilIndex(Pair arr[], int T[], int l, int r, Pair key) {

        while (r - l > 1) {

            int m = l + (r - l) / 2;
            if (arr[T[m]].x >= key.x)
                r = m;
            else
                l = m;
        }

        return r;
    }

    static int LongestIncreasingSubsequence(Pair arr[], int n) {

        // Add boundary case, when array n is zero
        // Depend on smart pointers

        int tailIndices[] = new int[n];

        // Initialized with 0
        Arrays.fill(tailIndices, 0);

        int prevIndices[] = new int[n];

        // initialized with -1
        Arrays.fill(prevIndices, -1);

        // it will always point to empty
        // location
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i].x < arr[tailIndices[0]].x)

                // new smallest value
                tailIndices[0] = i;

            else if (arr[i].x > arr[tailIndices[len - 1]].x) {

                // arr[i] wants to extend
                // largest subsequence
                prevIndices[i] = tailIndices[len - 1];
                tailIndices[len++] = i;
            } else {

                // arr[i] wants to be a potential
                // condidate of future subsequence
                // It will replace ceil value in
                // tailIndices
                int pos = GetCeilIndex(arr, tailIndices, -1, len - 1, arr[i]);

                prevIndices[i] = tailIndices[pos - 1];
                tailIndices[pos] = i;
            }
        }
        System.out.println(len);

        for (int i = tailIndices[len - 1]; i >= 0; i = prevIndices[i])
            System.out.print(arr[i] + " ");

        System.out.println();

        return len;
    }


    public static  void main(String[] args){
        ProblemaB b = new ProblemaB();
    }

    static class Pair {

        public int x;

        public int y;

        public int index;

        public Pair(int pindex,int px, int py) {
            x = px;
            y = py;
            index=pindex;
        }


    }
}
