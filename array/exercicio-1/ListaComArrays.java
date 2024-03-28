 public class ListaComArrays {
    
    int[] lista;
    int size;
    private int capacidadePadrao = 5;

    public ListaComArrays(int tamanhoLista){
        this.size = 0; //lista ainda esta vazia
        this.lista = new int[tamanhoLista];
    }

    public ListaComArrays(){
        this.size = 0;
        this.lista = new int[capacidadePadrao];
    }

    //metodo para inserir valores
    public void add(int elemento){
        //verifica o tamanho
        if(size < lista.length){
            lista[size] = elemento;
            size++;
        } else{
            System.out.println("lista cheia, nao é possivel adicionar");
        }
    }

    public void remove(int indice){
        if (indice<size){
            for(int i=indice; i<=size-1;i++)
            lista[i] = lista[i+1];
        }
        size--;
    }

    public int getElemennt(int indice){
        if (indice <= size){
            return lista[indice];
       } else{
        return -1;
       }
    }

    public char[] isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
}
