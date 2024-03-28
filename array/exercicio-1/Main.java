public class Main
{
    public static void main(String[] args) {
        ListArray minhaLista = new ListArray();
        minhaLista.add(1024);
        minhaLista.add(2);
        minhaLista.add(40);
        minhaLista.add(28);
        minhaLista.add(56);
        minhaLista.add(2);
         
        System.out.println("\f");
        System.out.println("Item 0 - Lista inical");
        System.out.println(minhaLista);
        
        System.out.println("Item 1 - Limpa a Lista");
        //minhaLista.clear();
        
        System.out.println("\n");
        System.out.println("Item 2 - Verifica se lista esta vazia");
        System.out.println(minhaLista.isEmpty());
        
        System.out.println("\n");
        System.out.println("Item 3 - Retorna a posiçao do elemento");
        System.out.println(minhaLista.indexOf(2));
        
        System.out.println("\n");
        System.out.println("Item 4 - Remove ");
        System.out.println(minhaLista.remove(3));
        
        System.out.println("\n");
        System.out.println("Item 5 - Array reverso");
        minhaLista.reverse();
        for(int i=0; i<minhaLista.size(); i++){
            System.out.println(minhaLista.get(i));
        }

        System.out.println("\n");
        System.out.println("Item 6 - Ocorrencia de elementos");
        System.out.println(minhaLista.countOccurrences(2));
        
        System.out.println("\n");
        System.out.println("Item 8 - Retira elemento repetido");
        minhaLista.unique();
        System.out.println(minhaLista);
        
        System.out.println("\n");
        System.out.println("Item 9 - Troca elem pelo indice e retorna o que saiu");
        minhaLista.set(0, 64);
        System.out.println(minhaLista);
        
        System.out.println("\n");
        System.out.println("Item 9 - Retorna se elemento esta na lista");
        System.out.println(minhaLista.contains(40));
        
        
        ////////////////////////////////////////////////////////////////////
        ListArray minhaLista2 = new ListArray();
        minhaLista2.add(25);
        minhaLista2.add(7);
        minhaLista2.add(50);

        System.out.println("\n");
        System.out.println("Item 7 - Insere elemento na posicao");
        minhaLista2.addIncreasingOrder(10);
        System.out.println(minhaLista2);
        
        
        ////////////////////////////////////////////////////////////////////
        ListArray minhaLista3 = new ListArray();
        minhaLista3.add(3);
        minhaLista3.add(5);
        minhaLista3.add(8);
        minhaLista3.add(13);
        minhaLista3.add(19);
        
        ListArray minhaLista4 = new ListArray();
        minhaLista4.add(1);
        minhaLista4.add(4);
        minhaLista4.add(6);
        minhaLista4.add(9);
        minhaLista4.add(15);
        
        System.out.println("\n");
        System.out.println("Item 11 - Intersecçao de duas listas");
        ListArray terceiraLista = ListArray.terceiraLista(minhaLista3, minhaLista4);
        System.out.println(terceiraLista);
    }
}
