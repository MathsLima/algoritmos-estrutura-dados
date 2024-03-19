/**
 * Classe que implementa uma lista linear usando arranjo.
 * @author Isabel H. Manssour
 */

public class ListArray {

    // Atributos
    private static final int TAM_DEFAULT = 10; //tamanho padrão do arrauy
    private Integer[] data; 
    private int count; //guarda o num de elementos 

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
        data = new Integer[tam]; //cria o array data com o tamanho default
        count = 0;
    }

    /**
     * Retorna o numero de elementos armazenados na lista.
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Adiciona um elemento ao final da lista.
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) { 
        if (count == data.length) { //se o num de elem é = ao tamanho do array data, o array vai estar cheio
            setCapacity(data.length * 2); //setCapacity é chamado para aumentar o tamanho do array em 2 vezes
        }
        data[count] = element; //atribui element para nas posições do array, no final da lista
        count++; //acrescenta o contador indicando que tem elemento na lista 
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int get(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        return data[index]; //retorna o elemento do indice especifico da lista 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int pos = 0; pos < count; pos++)
            sb.append(data[pos]).append(" ");
        sb.append("]");
        return sb.toString();
    }

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
     * percorre os elementos do array data e define os elementos como null
     * redefine o contador para 0 para que a lista vazia
     * cria o novo array de acordo com o tamanho default setado anteriormente
     */
    public void clear() {
        for (int i = 0; i < count; i++){
            data[i] = null;
        }
        count = 0;
        data = new Integer[TAM_DEFAULT];
    }

    /**
     * Retorna true se a lista nao contem elementos.
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() {
        if(count == 0){
            return true;
        } else{
            return false;
        }
    }
   
    /**
     * Retorna a posição na qual está armazenado o valor passado por parâmetro.
     * 
     * A complexidade deste método é O(?) <-- Preencha
     * @param element O elemento a ser procurado
     * @return A posição do elemento na lista ou -1 caso não esteja na lista.
     */
    public int indexOf(Integer element)
    {
        for (int i=0; i < count; i++){
            if(data[i] == element){
                return i;
            }
        }
        return -1;
    }

    
    
    /**
     * Procura e remove o primeiro elemento com valor passado como 
     * parâmetro no array.
     * 
     * A complexidade deste método é O(?) <-- Preencha
     * @param element o elemento a ser removido
     * @return true caso tenha sido removido, false caso não tenha removido
     */
    public boolean remove(Integer element)
    {
        return false;
    }

    /**
     * Substitui o elemento armazenado em uma determinada posicao da lista pelo
     * elemento passado por parametro, retornando o elemento que foi substituido.
     * 
     * A complexidade deste método é O(?) <-- Preencha
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int set(int index, Integer element) {
       // Implemente este metodo
        return -1;
    }

    /**
     * Procura pelo elemento passado por parametro na lista e retorna true se a 
     * lista contem este elemento.
     * 
     * A complexidade deste método é O(?) <-- Preencha
     * @param element o elemento a ser procurado
     * @return true se a lista contem o elemento passado por parametro
     */
    public boolean contains(Integer element) {
       // Implemente este metodo
        return false;
    }

    /**
     * Inverte a ordem do conteúdo da lista
     * elemento na posição esquerda atribuido na variavel, atribui este elemento
     * na direita e depois na variavel
     * 
     * A complexidade deste método é O(?) <-- Preencha
     */
    public void reverse()
    {
        /*
        int esquerda = 0; //primeiro elemento
        int direita = count - 1; //pega o tamanho do vetor
        
        while (esquerda < direita){
            Integer variavel = data[esquerda];
            data[esquerda] = data[direita];
            data[direita] = variavel;
            
            esquerda++;
            direita++;
        }*/
    }

    /**
     * Conta o número de ocorrências do elemento passado como parâmetro na lista, retornando este valor.
     * 
     * A complexidade deste método é O(?) <-- Preencha
     * @param element o elemento que será contado
     * @return número de vezes que o elemento ocorre na lista
     * 
     */
    public int countOccurrences(Integer element)
    {
        int ocorrencia = 0;
        for (int i=0; i < count; i++){
            if(data[i] == element){
                ocorrencia++;
            }
        }
        return ocorrencia;
    }

    /**
     * Insere um elemento na lista de forma ordenada (do menor elemento para o maior). 
     * 
     * A complexidade deste método é O(?) <-- Preencha
     * @param element
     * 
     */
    public void addIncreasingOrder(Integer element)
    {
        //Implemente este método
    }

    /**
     * Percorre a lista e retira os elementos repetidos,
     * deixando apenas uma ocorrência de cada elemento
     * 
     * A complexidade deste método é O(?) <-- Preencha
     */
    public void unique()
    {
        //Implemente este método
    }

}
