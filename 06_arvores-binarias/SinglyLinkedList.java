public class SinglyLinkedList implements ListTAD
{

    private Node head;
    private Node tail;
    private int count;

    private class Node {
        public int element;
        public Node next;

        public Node(int element) {
            this.element = element;
            this.next = null;
        }
    }

    public SinglyLinkedList() {
        head = null;
        tail = null;
        count = 0;
        // clear();
    }
    //Custo constate! O(1)
    @Override
    public void add(int element) {
        Node n = new Node(element);
        if (count != 0) // lista já tem elems?
            tail.next = n;
        else
            head = n; // não, este é o primeiro
        tail = n;
        count++;
    }
    //Pior caso quando o index é a última posição
    //Custo O(n)
    @Override
    public void add(int index, int element) {
        if ((index < 0) || (index > count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Node n = new Node(element);
        if (index == 0) { // inserção no início?
            n.next = head;
            head = n;
        } else {
            Node ant = null;
            Node target = head;
            for (int pos = 0; pos < index; pos++) {
                ant = target;
                target = target.next;
            }
            ant.next = n;
            n.next = target;
        }
        count++;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * 
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    @Override
    public int get(int index) { //Custo O(n)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Node ptr = head;
        for (int pos = 0; pos < index; pos++)
            ptr = ptr.next;
        return ptr.element;
    }

    /**
     * Substitui o elemento armazenado em uma determinada posicao da lista pelo
     * elemento passado por parametro, retornando o elemento que foi substituido.
     * 
     * @param index   a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    @Override
    public int set(int index, int element) { //Custo O(n)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Node ptr = head;
        for (int pos = 0; pos < index; pos++)
            ptr = ptr.next;
        int temp = ptr.element; // salva o valor armazenado lá...
        ptr.element = element;
        return temp; // ...e retorna ele
    }

    @Override
    public boolean remove(int element) {
        int pos = indexOf(element); //Custo O(n)
        if (pos == -1)
            return false; // não existe na lista
        removeByIndex(pos); //Custo O(n)
        return true;
    }
    //Custo O(n)
    @Override
    public int removeByIndex(int index) {
        Node aux = head;
        // Se for o início, basta avançar o head
        if (index == 0) {
            head = head.next;
        } else {
            Node prev = head;
            aux = head.next;
            for (int pos = 1; pos < index; pos++) {
                prev = aux;
                aux = aux.next;
            }
            // Remove o elemento
            prev.next = aux.next;
            // Se for o final da lista,
            // ajusta o tail
            if (index == count - 1)
                tail = prev;
        }
        count--;
        // Se a lista ficar vazia (count==0),
        // garante que o tail também será NULL
        if (count == 0)
            tail = null;
        return aux.element;
    }

    @Override //Custo O(1)
    public boolean isEmpty() {
        return count == 0;
    }

    @Override //Custo O(1)
    public int size() {
        return count;
    }

    @Override //indexOf tem custo O(n), então O(n)
    public boolean contains(int element) {
        return indexOf(element) != -1;
    }

    @Override //Custo O(n)
    public int indexOf(int element) {
        Node ptr = head;
        for (int pos = 0; pos < count; pos++) {
            if (ptr.element == element)
                return pos;
            ptr = ptr.next;
        }
        return -1; // não encontrou
    }

    @Override //Custo O(1)
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Retorna o conteúdo da lista como uma string
     * 
     * @return uma string com os elementos da lista
     */
    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder("[ ");
        Node ptr = head;
        while (ptr != null) {
            aux = aux.append(ptr.element).append(" ");
            ptr = ptr.next; // avança para o próximo nodo
        }
        aux.append("]");
        return aux.toString();
    }

    //Custo é O(n)
    public int contaOcorrencias(int element)
    {
        int total = 0;
        Node atual = head;
        while(atual != null)
        {
            if(atual.element == element)
                total++;
            atual = atual.next;
        }
        return total;
    }
    //Custo O(n)
    public int[] subList(int from, int to)
    {
        if(from > to || from < 0 || from > count-2 || to > count)
            throw new IndexOutOfBoundsException(); //Fora dos indices

        int[] subLista = new int[to-from];

        int i = 0;
        Node atual = head;
        while(atual != null) //Chega na posição da lista que inicia
        {
            if(i == from)
                break;
            atual = atual.next;
            i++;
        }

        int arrayIndex = 0;

        while(atual != null) //Preenche o array a partir de from até to
        {
            subLista[arrayIndex] = atual.element;
            atual = atual.next;
            arrayIndex++;
            i++;
            if(i == to)
                break;
        }
        return subLista;
    }

    //Custo O(n)
    public void reverse()
    {
        Node ant = null;
        Node atual = head;
        Node prox = null;

        while(atual != null)
        {
            prox = atual.next;
            atual.next = ant;
            ant = atual;
            atual = prox;
        }

        tail = head;
        head = ant;
    }

    public void recursiveReverse()
    {
        tail = head;
        head = recursiveReverseAux(head);
    }

    public Node recursiveReverseAux(Node head)
    {
        //Ideia básica é separar a lista em 2
        //Na cabeça e no "resto" da lista
        if(head == null || head.next == null)
            return head;
        
        Node resto = recursiveReverseAux(head.next);
        head.next.next = head; //O próximo do próximo será eu mesmo!

        head.next = null; //O meu próximo agora é nulo, porque inverteu!

        return resto;
    }
}