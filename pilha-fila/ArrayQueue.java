    public class ArrayQueue implements QueueTAD{
    
        private static final Integer TAM_DEFAULT = 5;
        private Integer[] data;
        private int count,start;
    
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
            start = 0;
        }
    
        /**
         * Método interno para modificar a capacidade do array.
         * Custo é O(n)
         * @param newCapacity
         */
        private void setCapacity(int newCapacity) {
            if (newCapacity != data.length) {
            Integer[] newData = new Integer[newCapacity];
            for (int i = 0; i < count; i++) {
                newData[i] = data[(start + i) % data.length];
                }
            data = newData;
            start = 0; 
            }
        }

    
        /**
         * Adiciona um elemento no final da fila.
         * @param element
         */
        @Override
        public void enqueue(int item) {
            if (count == data.length) {
                setCapacity(data.length * 2);
            }
            data[(start + count) % data.length] = item;
            count++;
        }
    
        /**
         * Remove o elemento no início da fila e retorna ele.
         * @return O elemento que estava no início da fila.
         */
        @Override
        public int dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("Fila vazia");
            }
            int aux = data[start];
            start = (start + 1) % data.length;
            count--;
            return aux;
        }
    
        /**
         * @return O tamanho da fila.
        */
        @Override
        public int size(){
            return count;
        }
    
        /**
         * @return true se a fila estiver vazia, false caso contrário.
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
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[ ");
            int comeco = start; 
            for (int i = 0; i < count; i++) {
                sb.append(data[comeco]).append(" ");
                comeco = (comeco + 1) % data.length; 
            }
            sb.append("]");
            return sb.toString();
        }
    }