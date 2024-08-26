import java.util.ArrayList;

public class Utils
{
    public static QueueTAD clone(QueueTAD fila){
        QueueTAD novafila = new LinkedQueue();
        QueueTAD aux = new LinkedQueue();
        while(!fila.isEmpty()){
            int element = fila.dequeue();
            novafila.enqueue(element);
            aux.enqueue(element);
        }
        while(!aux.isEmpty()){
            fila.enqueue(aux.dequeue());
        }
        return novafila;
    }
    public static void copiaParaFila(QueueTAD fila, StackTAD pilha){
        StackTAD aux = new LinkedStack();
        while(!pilha.isEmpty()){
            int element = pilha.pop();
            fila.enqueue(element);
            aux.push(element);
        }
        while(!aux.isEmpty()){
            pilha.push(aux.pop());
        }
    }    
    public static ArrayList<Integer> concatenaPilhas(QueueTAD fila1, QueueTAD fila2) {
        ArrayList<Integer> listaConcatenada = new ArrayList<>();
        QueueTAD aux = new LinkedQueue();
        
        while (!fila1.isEmpty()) {
            int element = fila1.dequeue();
            listaConcatenada.add(element);
            aux.enqueue(element);
        }
        while (!aux.isEmpty()) {
            fila1.enqueue(aux.dequeue());
        }
        while (!fila2.isEmpty()) {
            int element = fila2.dequeue();
            listaConcatenada.add(element);
            aux.enqueue(element);
        }
        while (!aux.isEmpty()) {
            fila2.enqueue(aux.dequeue());
        }
    
        return listaConcatenada;
    }
    public static boolean ehPalindromo(int n) {
        String numero = Integer.toString(n);
        int i = 0;
        int j = numero.length()-1;
        while (i < numero.length()/2) {
            if (numero.charAt(i) != numero.charAt(j)) {
                return false;
            }
            j--;
            i++;
        }
        return true;
    }

}
