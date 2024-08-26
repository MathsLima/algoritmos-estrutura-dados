/**
 * Classe que implementa uma lista linear usando arranjo.
 * @author Isabel H. Manssour, Luan Garcia
 */

public class ListArray implements ListTAD{

    private static final int TAM_DEFAULT = 10;
    private Integer[] data;
    private int count;

    /**
     * Construtor da lista.
     */
    public ListArray() {
        this(TAM_DEFAULT);
    }

    /**
     * Construtor da lista.
     * @param tam tamanho inicial a ser alocado para data[]
     */
    public ListArray(int tam) {
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

 

    @Override
    public void add(int element) {
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }


    @Override
    public void add(int index, int element)
    {
        if ((index < 0) || (index > count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }

        if(count == data.length)
            setCapacity(data.length*2);
        for(int i = count; i > index; i--)
        {
            data[i] = data[i-1];
        }
        data[index] = element;
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

        int aux = data[index];
        data[index] = element;
        return aux;
    }

    @Override
    public int get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        return data[index];
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
    public boolean remove(int element)
    {
        int index = indexOf(element);
        if(index >= 0)
        {
            for(int i = index; i < count-1; i++) //count-1 porque se for o último elemento não substituímos!
            {
                data[i] = data[i+1];
            }
            count--;
            return true;
        }
        return false;
    }

    @Override
    public int removeByIndex(int index) {
        int element = get(index);
        remove(get(index));
        return element;
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
        if(this.count > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean contains(int element) {
       
        for(int i = 0; i < count; i++)
            if(data[i].equals(element))
                return true;
        
        return false;
    }

    @Override
    public int indexOf(int element)
    {
        int index = -1;
        for(int i = 0; i < this.count; i++)
        {
            if(data[i].equals(element))
            {
                index = i;
                break;
            }
        }
        return index;
    }


    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        this.count = 0;
        this.data = new Integer[TAM_DEFAULT];
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
