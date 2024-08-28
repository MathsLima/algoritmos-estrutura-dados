import java.util.Random;

public class HeapsortTest {
    public static void main(String args[]) {

        int MAX = 1000000;
        Random r = new Random();
       
        long clock;
        for (int tam=100000; tam<=MAX; tam+=50000) {
            int[] data = new int[MAX];
            data[0] = 0;
            for(int i=1; i<tam; i++)
            data[i] = r.nextInt(tam*10);

        // int[] data2 = {0, 5, 32, 44, 4, 48, 38, 78, 35, 37};
        // MaxHeap my = new MaxHeap(data2);
            MaxHeap my = new MaxHeap(data);
        // my.print();
           // System.out.println();
            long start = System.nanoTime();
            my.zeraOp();
            my.sort();
            long end = System.nanoTime();
            clock = (end-start);
            //System.out.printf("Tempo para ordenar %d elementos: %d ns\n", MAX, clock);
            //System.out.printf("%d;%d\n",tam,clock);
            System.out.printf("%d;%d\n",tam,my.getOp());
            
            //my.print();
    }
}
}

