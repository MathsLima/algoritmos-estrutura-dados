/**
 * Classe que implementa uma lista linear usando arranjo.
 * @author Isabel H. Manssour, Luan Garcia
 */

public class ListArray {

    // Atributos
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
     * Retorna o numero de elementos armazenados na lista.
     * Custo é O(1)
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Adiciona um elemento ao final da lista.
     * Custo é O(1) CASO NÃO PRECISE AUMENTAR O ARRAY
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) {
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }

    /**
     * Adiciona um elemento na posicao passada como parametro.
     * Custo é O(n)
     * @param index
     * @param element
     */
    public void add(int index, Integer element)
    {
        if(index >= 0 && index <= count)
        {
            if(count == data.length)
                setCapacity(data.length*2);
            for(int i = count; i > index; i--)
            {
                data[i] = data[i-1];
            }
            data[index] = element;
            count++;
        }
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * Custo é O(1)
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        return data[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int pos = 0; pos < count; pos++)
            sb.append(data[pos]).append(" ");
        sb.append("]");
        return sb.toString();
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

    ////////////////////////////////////////////
    /*MÉTODOS PARA SEREM IMPLEMENTADOS COMEÇAM AQUI */

    /**
     * Esvazia a lista.
     * Custo é O(1) - constante.
     */
    public void clear() {
        this.count = 0;
        this.data = new Integer[TAM_DEFAULT];
    }

    /**
     * Retorna true se a lista nao contem elementos.
     * Custo O(1) - constante
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() {
        if(this.count > 0)
            return true;
        else
            return false;
    }

    /**
     * Retorna a posição na qual está armazenado o valor passado por parâmetro.
     * 
     * A complexidade deste método é O(n) no pior caso
     * O pior caso é quando precisamos percorrer todo vetor
     * Ou o elemento está na última posição
     * Ou o elemento não está na lista
     * @param element O elemento a ser procurado
     * @return A posição do elemento na lista ou -1 caso não esteja na lista.
     */
    public int indexOf(Integer element)
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

    /**
     * Procura e remove o primeiro elemento com valor passado como 
     * parâmetro no array.
     * 
     * A complexidade deste método é O(n)
     * O custo do método indexOf é O(n), porém só é chamado uma vez
     * Se o elemento a ser removido estiver na posição 0,
     * então o array inteiro será percorrido
     * @param element o elemento a ser removido
     * @return true caso tenha sido removido, false caso não tenha removido
     */
    public boolean remove(Integer element)
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

    /**
     * Substitui o elemento armazenado em uma determinada posicao da lista pelo
     * elemento passado por parametro, retornando o elemento que foi substituido.
     * 
     * A complexidade deste método é O(1) - Constante
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int set(int index, Integer element) {
        
        if(index > 0 && index < count)
        {
            int aux = data[index];
            data[index] = element;
            return aux;
        }

        return -1;
    }

    /**
     * Procura pelo elemento passado por parametro na lista e retorna true se a 
	 * lista contem este elemento.
     * 
     * A complexidade deste método é O(n)
     * Pior caso é quando o elemento estiver na última posição
     * ou não estiver na lista
     * @param element o elemento a ser procurado
     * @return true se a lista contem o elemento passado por parametro
     */
    public boolean contains(Integer element) {
       
        for(int i = 0; i < count; i++)
            if(data[i].equals(element))
                return true;
        
        return false;
    }

    /**
     * Inverte a ordem do conteúdo da lista
     * 
     * A complexidade deste método é O(n)
     * Na prática, o laço sempre será executado
     * n/2 vezes, mas como desconsideramos as constantes,
     * temos que o custo é O(n).
     */
    public void reverse()
    {
        for(int i = 0; i < count/2;i++)
        {
            int aux = data[count-i-1];
            data[count-i-1] = data[i];
            data[i] = aux;
        }
    }

    /**
     * Conta o número de ocorrências do elemento passado como parâmetro na lista, retornando este valor.
     * 
     * A complexidade deste método é O(n) (e também Theta e Omega n)
     * 
     * @param element o elemento que será contado
     * @return número de vezes que o elemento ocorre na lista
     * 
     */
    public int countOccurrences(Integer element)
    {
        int totalOcorrencias = 0;

        for(int i = 0; i < count; i++)
        {
            if(data[i].equals(element))
                totalOcorrencias++;
        }

        return totalOcorrencias;
    }

    /**
     * Insere um elemento na lista de forma ordenada (do menor elemento para o maior). 
     * 
     * A complexidade deste método é O(n)
     * @param element
     * 
     */
    public void addIncreasingOrder(Integer element)
    {
        for(int i = 0; i<count;i++)
        {
            if(element<data[i])
            {
                add(i,element);
                return;
            }
        }
        add(element);
       
    }

    /**
     * Percorre a lista e retira os elementos repetidos,
     * deixando apenas uma ocorrência de cada elemento
     * 
     * A complexidade deste método é O(n²) 
     */
    public void unique()
    {
        for(int i = 0; i < count; i++)
        {
            int elemento = data[i];
            for(int repetidos = countOccurrences(elemento); repetidos > 1; repetidos--) //countOccurrences é O(n)
            {
                remove(elemento); //Remove é O(n)
            }
        }
    }

}
