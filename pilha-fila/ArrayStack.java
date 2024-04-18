public class ArrayStack implements StackTAD
{
    private static final int TAM_DEFAULT = 5;
    private Integer[] data;
    private int count;
    
    public ArrayStack(){
        this(TAM_DEFAULT);
    }
    
    public ArrayStack(int tam){
        if (tam <= 0) {
            tam = TAM_DEFAULT;
        }
        data = new Integer[tam];
        count = 0;
    }
    
    /**
     * Método interno para modificar a capacidade do array.
     * @param newCapacity
     */
    private void setCapacity(int newCapacity) {
        if (newCapacity != data.length) {
            int min = 0;
            Integer[] newData = new Integer[newCapacity];
            if (data.length < newCapacity) {
                min = data.length;
            } else {
                min = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }
    
    /**
     * Adiciona elemento no topo da pilha.
     * @param element
     */
    @Override
    public void push(int element){
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }

    /**
     * Remove o elemento do topo da pilha.
     * @return O elemento que se encontrava no topo da pilha.
     */
    @Override
    public int pop(){
        if(isEmpty()) throw new IllegalStateException("Pilha Vazia");
        count--;
        return data[count];
    }

    /**
     * @return O tamanho da pilha.
     */
    @Override
    public int size(){
        return count;
    }

    /**
     * @return true se a pilha estiver vazia, false caso contrário.
     */
    @Override
    public boolean isEmpty(){
        if(this.count > 0)
            return false;
        else
            return true;
    }

    /**
     * Remove todos elementos da pilha.
     */
    @Override
    public void clear(){
        this.count = 0;
        this.data = new Integer[TAM_DEFAULT];
    }

    /**
     * Retorna o elemento do topo da pilha, sem removê-lo.
     * @return O elemento presente no topo da pilha.
     */
    @Override
    public int top(){
        if(isEmpty()) throw new IllegalStateException("Pilha Vazia");
        return data[count-1];
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int pos = 0; pos < count; pos++)
            sb.append(data[pos]).append(" ");
        sb.append("]");
        return sb.toString();
    }
    
}
