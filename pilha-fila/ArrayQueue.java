public class ArrayQueue implements QueueTAD{

    private static final Integer TAM_DEFAULT = 5;
    private Integer[] data;
    private int count;

    /**
     * Construtor da lista.
     */
    public ArrayQueue() {
        this(TAM_DEFAULT);
    }

    /**
     * Construtor da lista.
     * @param tam tamanho inicial a ser alocado para data[]
     */
    public ArrayQueue(int tam) {
        if (tam <= 0) {
            tam = TAM_DEFAULT;
        }
        data = new Integer[tam];
        count = 0;
    }

    /**
     * Método interno para modificar a capacidade do array.
     * Custo é O(n)
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int pos = 0; pos < count; pos++)
            sb.append(data[pos]).append(" ");
        sb.append("]");
        return sb.toString();
    }


    ///////////////////////////////

    /**
     * Adiciona um elemento no final da fila.
     * @param element
     */
    @Override
    public void enqueue(int element){
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }


    /**
     * Remove o elemento no início da fila e retorna ele.
     * @return O elemento que estava no início da fila.
     */
    @Override
    public int dequeue(){
        if(isEmpty()) throw new IllegalStateException("Lista Vazia");
        int aux = data[0];
        for(int i = 0; i < count-1; i++){
            data[i] = data[i+1];
        }
        count--;
        return aux;
    }

    /**
     * @return O tamanho da fila.
     FINALIZADO
     */
    @Override
    public int size(){
        return count;
    }

    /**
     * @return true se a fila estiver vazia, false caso contrário.
     FINALIZADO
     */
    @Override
    public boolean isEmpty(){
        if(this.count > 0)
            return false;
        else
            return true;
    }

    /**
     * Remove todos elementos da fila.
     FINALIZADO
     */
    @Override
    public void clear(){
        this.count = 0;
        this.data = new Integer[TAM_DEFAULT];
    }

    /**
     * Retorna o elemento no início da fila, sem removê-lo.
     * @return O primeiro elemento da fila.
     */
    @Override
    public int head(){
        if(isEmpty()) throw new IllegalStateException("Lista Vazia");
        return data[0];
    }
}