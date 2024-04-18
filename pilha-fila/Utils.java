public class Utils
{
    public static QueueTAD clone(QueueTAD pilha){
        QueueTAD novaPilha = new LinkedQueue();
        QueueTAD aux = new LinkedQueue();
        while(!pilha.isEmpty()){
            int element = pilha.dequeue();
            novaPilha.enqueue(element);
            aux.enqueue(element);
        }
        while(!aux.isEmpty()){
            pilha.enqueue(aux.dequeue());
        }
        return novaPilha;
    }
}
