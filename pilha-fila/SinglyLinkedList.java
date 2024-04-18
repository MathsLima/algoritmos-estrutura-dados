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

    @Override
    public void addFirst(int e) {
        this.add(0, e);
    }

    @Override
    public int set(int index, int element) {
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
    public int get(int index) { 
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Node ptr = head;
        for (int pos = 0; pos < index; pos++)
            ptr = ptr.next;
        return ptr.element;
    }

    @Override
    public int getFirst() {
        return this.get(0);
    }

    @Override
    public int getLast() {
        return this.get(count-1);
    }

    @Override
    public boolean remove(int element) {
        int pos = indexOf(element); 
        if (pos == -1)
            return false; // não existe na lista
        removeByIndex(pos); //Custo O(n)
        return true;
    }
  
    @Override
    public int removeByIndex(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
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

    @Override
    public int removeFirst() {
        return this.removeByIndex(0);
    }
    @Override
    public int removeLast() {
        return this.removeByIndex(count-1);
    }

    @Override 
    public boolean isEmpty() {
        return count == 0;
    }


    @Override 
    public boolean contains(int element) {
        return indexOf(element) != -1;
    }

    @Override 
    public int indexOf(int element) {
        Node ptr = head;
        for (int pos = 0; pos < count; pos++) {
            if (ptr.element == element)
                return pos;
            ptr = ptr.next;
        }
        return -1; // não encontrou
    }

    @Override 
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    @Override 
    public int size() {
        return count;
    }

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
}