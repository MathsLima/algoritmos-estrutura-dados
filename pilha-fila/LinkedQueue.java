public class LinkedQueue implements QueueTAD 
{
    SinglyLinkedList list = new SinglyLinkedList();
    
    public LinkedQueue()
    {
    }
        
    /**
     * Adiciona um elemento no final da fila.
     * @param element
     */
    @Override
    public void enqueue(int element){
        list.add(element);
     }

    /**
     * Remove o elemento no início da fila e retorna ele.
     * @return O elemento que estava no início da fila.
     */
    @Override
    public int dequeue(){
        if(isEmpty()) throw new IllegalStateException("Lista Vazia");
        int element = list.get(0);
        list.removeByIndex(0);
        return element;
    }

    /**
     * @return O tamanho da fila.
     */
    @Override
    public int size(){
        return list.size();
    }

    /**
     * @return true se a fila estiver vazia, false caso contrário.
     */
    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    /**
     * Remove todos elementos da fila.
     */
    @Override
    public void clear(){
        list.clear();
    }

    /**
     * Retorna o elemento no início da fila, sem removê-lo.
     * @return O primeiro elemento da fila.
     */
    @Override
    public int head(){
        if(isEmpty()) throw new IllegalStateException("Lista Vazia");
        return list.get(0);
    }
    
    @Override
    public String toString() {
    return list.toString();
    }
}
