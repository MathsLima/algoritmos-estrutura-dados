public class LinkedStack implements StackTAD
{
    SinglyLinkedList list = new SinglyLinkedList();
    
    public LinkedStack()
    {
    }

    /**
     * Adiciona elemento no topo da pilha.
     * @param element
     */
    @Override
    public void push(int element){
        list.add(element);
     }

    /**
     * Remove o elemento do topo da pilha.
     * @return O elemento que se encontrava no topo da pilha.
     */
    @Override
    public int pop(){
        if(isEmpty()) throw new IllegalStateException("Lista Vazia");
        int element = list.get(list.size()-1);
        list.removeByIndex(list.size()-1);
        return element;
    }

    /**
     * @return O tamanho da pilha.
     */
    @Override
    public int size(){
        return list.size();
    }

    /**
     * @return true se a pilha estiver vazia, false caso contrário.
     */
    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    /**
     * Remove todos elementos da pilha.
     */
    @Override
    public void clear(){
        list.clear();
    }

    /**
     * Retorna o elemento do topo da pilha, sem removê-lo.
     * @return O elemento presente no topo da pilha.
     */
    @Override
    public int top(){
        if(isEmpty()) throw new IllegalStateException("Pilha Vazia");
        return list.get(list.size()-1);
    }
    
    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder("|---|\n");
        for (int i=this.size()-1 ; i>=0 ; i--) {
            aux = aux.append("| ").append(list.get(i)).append(" |\n");
        }
        aux.append("|---|");
        return aux.toString();
    }
    
}
