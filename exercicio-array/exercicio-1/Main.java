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
        System.out.println(minhaLista.get(2));
        
        System.out.println("Item 1 - Limpa a Lista");
        // minhaLista.clear();
        
        System.out.println("\n");
        System.out.println("Item 2 - Verifica se lista esta vazia");
        System.out.println(minhaLista.isEmpty());
        
        System.out.println("\n");
        System.out.println("Item 3 - Retorna a posiçao do elemento");
        System.out.println(minhaLista.indexOf(1));
        
        System.out.println("\n");
        System.out.println("Item 6 - Ocorrencia de elemento");
        System.out.println(minhaLista.countOccurrences(2));
    }
}
