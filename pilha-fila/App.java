public class App {
    public static void main(String[] args) {
        QueueTAD filaLQ = new LinkedQueue();
        System.out.println("\nFila vazia adicionando 0,1,2,3 na ordem");
        filaLQ.enqueue(0);
        filaLQ.enqueue(1);
        filaLQ.enqueue(2);
        filaLQ.enqueue(3);
        System.out.println(filaLQ.toString());
        System.out.println(filaLQ.head() + " - Cabeça da fila");
        System.out.println(filaLQ.size() + " - Tamanho da fila");
        System.out.println(filaLQ.isEmpty() + " - isEmpty?");
        System.out.println(filaLQ.dequeue() + " - Elemento removido");
        System.out.println(filaLQ.toString());
        System.out.println(filaLQ.dequeue() + " - Elemento removido");
        System.out.println(filaLQ.toString());
        System.out.println("Limpando a lista - clear()");
        filaLQ.clear();
        System.out.println(filaLQ.isEmpty() + " - isEmpty?");
        System.out.println(filaLQ.toString());
        
        QueueTAD filaAQ = new ArrayQueue();
        System.out.println("\nFila vazia adicionando 0,1,2,3 na ordem");
        filaAQ.enqueue(0);
        filaAQ.enqueue(1);
        filaAQ.enqueue(2);
        filaAQ.enqueue(3);
        System.out.println(filaAQ.toString());
        System.out.println(filaAQ.head() + " - Cabeça da fila");
        System.out.println(filaAQ.size() + " - Tamanho da fila");
        System.out.println(filaAQ.isEmpty() + " - isEmpty?");
        System.out.println(filaAQ.dequeue() + " - Elemento removido");
        System.out.println(filaAQ.toString());
        System.out.println(filaAQ.dequeue() + " - Elemento removido");
        System.out.println(filaAQ.toString());
        System.out.println("Limpando a lista - clear()");
        filaAQ.clear();
        System.out.println(filaAQ.isEmpty() + " - isEmpty?");
        System.out.println(filaAQ.toString());
        
        StackTAD pilhaLS = new LinkedStack();
        System.out.println("\n\n\nPilha vazia adicionando 0,1,2,3 na ordem");
        pilhaLS.push(0);
        pilhaLS.push(1);
        pilhaLS.push(2);
        pilhaLS.push(3);
        System.out.println(pilhaLS.toString());
        System.out.println(pilhaLS.top() + " - Topo da pilha");
        System.out.println(pilhaLS.size() + " - Tamanho da pilha");
        System.out.println(pilhaLS.isEmpty() + " - isEmpty?");
        System.out.println(pilhaLS.pop() + " - Elemento removido");
        System.out.println(pilhaLS.toString());
        System.out.println(pilhaLS.pop() + " - Elemento removido");
        System.out.println(pilhaLS.toString());
        System.out.println("Limpando a lista - clear()");
        pilhaLS.clear();
        System.out.println(pilhaLS.isEmpty() + " - isEmpty?");
        System.out.println(pilhaLS.toString());
        
        StackTAD pilhaAS = new ArrayStack();
        System.out.println("\n\n\nPilha vazia adicionando 0,1,2,3 na ordem");
        pilhaAS.push(0);
        pilhaAS.push(1);
        pilhaAS.push(2);
        pilhaAS.push(3);
        System.out.println(pilhaAS.toString());
        System.out.println(pilhaAS.top() + " - Topo da pilha");
        System.out.println(pilhaAS.size() + " - Tamanho da pilha");
        System.out.println(pilhaAS.isEmpty() + " - isEmpty?");
        System.out.println(pilhaAS.pop() + " - Elemento removido");
        System.out.println(pilhaAS.toString());
        System.out.println(pilhaAS.pop() + " - Elemento removido");
        System.out.println(pilhaAS.toString());
        System.out.println("Limpando a lista - clear()");
        pilhaAS.clear();
        System.out.println(pilhaAS.isEmpty() + " - isEmpty?");
        System.out.println(pilhaAS.toString());
        
        
        QueueTAD filaLQ2 = new LinkedQueue();
        System.out.println("\nFila vazia adicionando 4,5,6,7 na ordem");
        filaLQ2.enqueue(4);
        filaLQ2.enqueue(5);
        filaLQ2.enqueue(6);
        filaLQ2.enqueue(7);
        System.out.println(Utils.clone(filaLQ2).toString() + " - Clone da fila");
        System.out.println(filaLQ2.toString()+ " - Fila Original");
    }
}
