public class App {
    public static void main(String[] args) {
        /*
         * Remova os comentarios abaixo para chamar metodos que testam
         * as inplementacoes.
         * Os testes não são exaustivos e podem existir erros que os
         * testes não pegam!
         */
        //testeListArray();
        //testeHighScores();
        //testeMergeLists();
    }

    public static void testeListArray()
    {
        ListArray lista = new ListArray();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        
        System.out.println(lista);
       
        System.out.println("Elemento armazenado na "
                + "primeira posicao da lista: " +lista.get(0));
        System.out.println("Tentando remover elemento 9: " + lista.remove(9));
        System.out.println(lista);
        System.out.println("Adicionando o elemento 5 no indice 2, elemento aterior era: " + lista.set(2, 5));
        System.out.println(lista);
        System.out.println("Lista contem elemento 0? " + lista.contains(0));
        lista.reverse();
        System.out.println("Lista depois do reverse: " + lista);
        lista.add(9);
        System.out.println("Após adicionar elemento 9: " + lista);
        lista.reverse();
        System.out.println("Revertendo a lista novamente: " + lista);
        System.out.println("Quantas ocorrencias do elemento 2: " + lista.countOccurrences(2));
        lista.add(2);
        System.out.println("Adicionando outro elemento 2: " + lista);
        System.out.println("Quantas ocorrencias do elemento 2: " + lista.countOccurrences(2));
        lista.unique();
        System.out.println("Lista apos chamada do metodo unique: " + lista);
    }

    public static void testeHighScores()
    {
        HighScores scores = new HighScores();

        scores.addScore(10);
        scores.addScore(5);
        scores.addScore(30);

        System.out.println("Apos adicionar scores 10, 5, 30: ");
        scores.listScores();

        scores.addScore(50);
        scores.addScore(80);
        scores.addScore(91);
        scores.addScore(12);
        scores.addScore(1);
        scores.addScore(71);
        scores.addScore(20);

        System.out.println("Apos adicionar mais 7 scores (50, 80, 91, 12, 1, 71, 20): ");
        scores.listScores();

        System.out.println("Adicionando score 2 com lista já cheia:");
        scores.addScore(2);
        scores.listScores();
        System.out.println("Adicionando score 13 com lista já cheia:");
        scores.addScore(13);
        scores.listScores();
        System.out.println("Adicionando score 1 com lista já cheia:");
        scores.addScore(1);
        scores.listScores();
    }

    public static void testeMergeLists()
    {
        ListArray lista = new ListArray();
        ListArray lista2 = new ListArray();
        lista.add(80);
        lista.add(4);
        lista.add(27);
        lista.add(8);
        lista.add(5);
        lista.add(35);
        lista.add(65);
        lista.add(1);

        lista2.add(80);
        lista2.add(4);
        lista2.add(27);
        lista2.add(8);
        lista2.add(5);
        lista2.add(35);
        lista2.add(65);
        lista2.add(1);

        System.out.println("Lista 1: " + lista);
        System.out.println("Lista 2: " + lista2);
        System.out.println("Interseccao: " + mergeList(lista, lista2));
        System.out.println("Uniao em ordem: " + mergeList2(lista, lista2));
        lista2.add(2);
        lista2.add(47);
        lista2.add(270);
        lista2.add(48);
        lista2.add(53);
        lista2.add(325);
        lista2.add(657);
        lista2.add(10);
        System.out.println("Lista 1: " + lista);
        System.out.println("Lista 2: " + lista2);
        System.out.println("Interseccao: " + mergeList(lista, lista2));
        System.out.println("Uniao em ordem: " + mergeList2(lista, lista2));
    }
    /**
     * Recebe dois ListArray diferentes e retorna um novo list array com
     * os elementos presentes nas duas listas passadas como parâmetro
     * Custo deste método é O(n²), pois para cada elemento de uma lista
     * precisa percorrer toda outra lista para verificar se ela
     * contém o elemento.
     * 
     * @param list1 
     * @param list2
     * @return novo ListArray com a intersecção entre as duas listas
     */
    public static ListArray mergeList(ListArray list1, ListArray list2)
    {
        ListArray newList;

        if(list1.size() > list2.size())
        {
            list1.unique(); //Custo de tornar a lista única é O(n²)
            newList = new ListArray(list1.size());
            for(int i = 0; i < list1.size();i++) //Custo de percorrer toda a lista é O(n)
            {
                if(list2.contains(list1.get(i))) //Custo de contains é O(n)
                    newList.add(list1.get(i));
            }

        }else
        {
            list2.unique();
            newList = new ListArray(list2.size());
            for(int i = 0; i < list2.size();i++)
            {
                if(list1.contains(list2.get(i)))
                    newList.add(list2.get(i));
            }
        }
        return newList;
    }

    /**
     * Recebe dois ListArray e retorna uma única lista com todos elementos em ordem crescente
     * Custo deste método é O(n²), pois utiliza o método addIncreasingOrder que possui custo O(n)
     * @param list1
     * @param list2
     * @return nova ListArray contendo os elementos das duas listas em ordem crescente
     */
    public static ListArray mergeList2(ListArray list1, ListArray list2)
    {
        int list1Size = list1.size();
        int list2Size = list2.size();
        ListArray newList = new ListArray(list1Size+list2Size);
        
        for(int i = 0; i < list1Size; i++)
        {
            newList.addIncreasingOrder(list1.get(i)); //Custo O(n)
        }

        for(int i = 0; i < list2Size; i++)
        {
            newList.addIncreasingOrder(list2.get(i)); //Custo O(n)
        }

        return newList;
    }

}
