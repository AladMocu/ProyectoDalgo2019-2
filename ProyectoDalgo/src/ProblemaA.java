import java.util.Arrays;
import java.util.Scanner;

public class ProblemaA {

    private Suffix[] suffixes;
    public ProblemaA(String text) {
        int n = text.length();
        this.suffixes = new Suffix[n];
        for (int i = 0; i < n; i++)
            suffixes[i] = new Suffix(text, i);
        Arrays.sort(suffixes);
    }

    private static class Suffix implements Comparable<Suffix> {
        private final String text;
        private final int index;

        private Suffix(String text, int index) {
            this.text = text;
            this.index = index;
        }
        private int length() {
            return text.length() - index;
        }
        private char charAt(int i) {
            return text.charAt(index + i);
        }

        public int compareTo(Suffix that) {
            if (this == that) return 0;  // optimization
            int n = Math.min(this.length(), that.length());
            for (int i = 0; i < n; i++) {
                if (this.charAt(i) < that.charAt(i)) return -1;
                if (this.charAt(i) > that.charAt(i)) return +1;
            }
            return this.length() - that.length();
        }

        public String toString() {
            return text.substring(index);
        }
    }

    /**
     * Returns the length of the longest common prefix of the <em>i</em>th
     * smallest suffix and the <em>i</em>-1st smallest suffix
     */
    public int lcp(int i) {
        if (i < 1 || i >= suffixes.length) throw new IllegalArgumentException();
        return lcpSuffix(suffixes[i], suffixes[i-1]);
    }

    private static int lcpSuffix(Suffix s, Suffix t) {
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) return i;
        }
        return n;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext())
        {
            int size=Integer.parseInt(sc.nextLine().trim());
            if(size==0)
            {
                return;
            }
            String toWork= sc.nextLine();
            Work(toWork.replaceAll(" ",""));
        }


    }

    public static void Work(String s)
    {
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

}