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
        
        StackTAD pilhaLS3 = new ArrayStack();
        QueueTAD filaLQ3 = new LinkedQueue();
        System.out.println("\n\n\nPilha vazia adicionando 4,5,6,7 na ordem");
        pilhaLS3.push(4);
        pilhaLS3.push(5);
        pilhaLS3.push(6);
        pilhaLS3.push(7);
        Utils.copiaParaFila(filaLQ3,pilhaLS3);
        System.out.println(pilhaLS3.toString()+ " - Pilha Original");
        System.out.println(filaLQ3.toString() + " - Fila copiada");
        
        
        System.out.println("\n\n\nFilas vazias adicionando 8,9,10,11 na ordem e 12,13,14,15 na ordem");
        QueueTAD filaLQ4 = new LinkedQueue();
        QueueTAD filaLQ5 = new LinkedQueue();
        filaLQ4.enqueue(8);
        filaLQ4.enqueue(9);
        filaLQ4.enqueue(10);
        filaLQ4.enqueue(11);
        filaLQ5.enqueue(12);
        filaLQ5.enqueue(13);
        filaLQ5.enqueue(14);
        filaLQ5.enqueue(15);
        System.out.println("Elementos concatenados: " + Utils.concatenaPilhas(filaLQ4, filaLQ5));
        System.out.println(filaLQ4.toString()+ " - Fila1 Original");
        System.out.println(filaLQ5.toString()+ " - Fila2 Original\n\n\n");
        
        int n1 = 11234211;
        int n2 = 123404321;
        System.out.println(n1 + " ehPalindromo = " + Utils.ehPalindromo(n1));
        System.out.println(n2 + " ehPalindromo = " + Utils.ehPalindromo(n2));
        
    }
}
