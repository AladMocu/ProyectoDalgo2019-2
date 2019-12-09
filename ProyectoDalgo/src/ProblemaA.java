import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemaA {

    /**
     * Arreglo donde se guardaran los sufijos generados
     */
    private Suffix[] suffixes;

    /**
     * Creacion de la lista de sufijos a partir de la entrada inicial
     */
    public ProblemaA(NumberString text) {
        int n = text.length();
        this.suffixes = new Suffix[n];
        for (int i = 0; i < n; i++)
        {
            suffixes[i] = new Suffix(text, i);
        }
        Arrays.sort(suffixes);
    }

    /**
     * Clase que representa un sufijo
     */
    private static class Suffix implements Comparable<Suffix> {
        private final NumberString text;
        private final int index;

        private Suffix(NumberString text, int index) {
            this.text = text;
            this.index = index;
        }

        /**
         * @return longitud de el sufijo almacenado en este nodo
         */
        private int length() {
            return text.length() - index;
        }
        private int charAt(int i) {
            return text.numberAt(index + i);
        }


        /**
         * compraracion entre sufijos, ordenadanolos lexicograficamente
         * @param that
         * @return
         */
        public int compareTo(Suffix that) {
            if (this == that) return 0;
            int n = Math.min(this.length(), that.length());
            for (int i = 0; i < n; i++) {
                if (this.charAt(i) < that.charAt(i)) return -1;
                if (this.charAt(i) > that.charAt(i)) return +1;
            }
            return this.length() - that.length();
        }

        public NumberString toNumberString() {
            return text.subNumberString(index);
        }
    }

    /**
     * Retorna la longitud de el prefijo comun de el  <em>i</em> avo sufijo mas pequeño y el  iaco-1 sufijo mas pequeño
     */
    public int lcp(int i) {
        if (i < 1 || i >= suffixes.length) throw new IllegalArgumentException();
        return lcpSuffix(suffixes[i], suffixes[i-1]);
    }

    /**
     * Metodo auxiliar que calcula el LCP entre 2 suficos adyacentes
     * @param s
     * @param t
     * @return
     */
    private static int lcpSuffix(Suffix s, Suffix t) {
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) return i;
        }
        return n;
    }


    /**
     * Metodo que se encarga de la lectura de la STDIN
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext())
        {
            int size=Integer.parseInt(sc.nextLine().trim());
            if(size==0)
            {
                return;
            }
            String[] toWork= sc.nextLine().split(" ");
            ArrayList<Integer> temp= new ArrayList<>();
            for (int i = 0; i <toWork.length; i++) {
               temp.add(Integer.parseInt(toWork[i]));
            }
            Work(new NumberString(temp));
        }


    }

    /**
     * Metodo que calcula la maxima longitud de arreglo recurrente, haciendo uso de un Suffix Array y su respectivo LCP,
     * entendiendo que el valor maximo de dichho LCP representa de igualmanera el subarreglo recurrente mas largo por definicion de LCP
     */
    public static void Work(NumberString s)
    {
        //solicitud de crear arbol de suficos con indice de terminacion de linea '#'
        ProblemaA suffix = new ProblemaA(s);
        int lcpMax=0;
        for (int i = 1; i < s.length(); i++) {
            int lcpTemp=suffix.lcp(i);
            if(lcpTemp>lcpMax)
            {
                lcpMax=lcpTemp;
            }
        }
        System.out.println(lcpMax);
    }


    public static class NumberString
    {
        ArrayList<Integer> numbers;
        
        public NumberString(ArrayList<Integer> pNumbers)
        {
            this.numbers=pNumbers;
        }

        public Integer numberAt(int i)
        {
            return numbers.get(i);
        }
        public NumberString subNumberString(int i)
        {
            return new NumberString((ArrayList<Integer>) numbers.subList(i,numbers.size()-1));
        }

        public int length()
        {
            return numbers.size();
        }
    }

}