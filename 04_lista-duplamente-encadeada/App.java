
public class App {
        public static void main(String[] args) {
                ListTAD lista = new DoublyLinkedList();

                //*****Testando adições*****
                lista.add(2);
                lista.add(4);
                lista.add(6);
                lista.add(8);
                lista.add(10);
                lista.add(12);

                System.out.println(lista);

                System.out.println("Adicionando 1 na primeira posicao com add() pelo indice");
                lista.add(0, 1);

                System.out.println(lista);

                System.out.println("Adicionando 87 na primeira posicao com addFirst()");
                lista.addFirst(87);

                System.out.println(lista);
                /*
                System.out.println("Tentando adicionar em indice fora da lista");
                lista.add(lista.size()+1, 0);;
                System.out.println(lista);
                */

                System.out.println("Posicao do elemento 8:" + lista.indexOf(8));
                System.out.println("Posicao do elemento 22:" + lista.indexOf(22));
                System.out.println("Existe o elemento 22? " + lista.contains(22));

                //*****Testando acessos*****
                System.out.println("Elemento armazenado na "
                                + "primeira posicao da lista: " + lista.get(0));

                System.out.println("Elemento armazenado na "
                                + "quarta posicao da lista: " + lista.get(3));
                
                System.out.println("Elemento armazenado na "
                                + "ultima posicao da lista: " + lista.get(lista.size()-1));
                /*
                System.out.println("Tentando pegar elemento fora do índice da lista: "
                                +  lista.get(lista.size()));
                */

                //*****Testando atualizações*****
                System.out.println();
                System.out.println("Alterando o terceiro elemento para 30");
                lista.set(2, 30);
                System.out.println(lista);

                /*
                System.out.println();
                System.out.println("Alterando elemento fora do índice para 50");
                lista.set(lista.size(), 50);
                System.out.println(lista);
                */

                System.out.println();
                System.out.println("Inserindo o elemento 7 na quinta posicao");
                lista.add(4, 7);
                System.out.println(lista);

                System.out.println();
                System.out.println("Inserindo o 11 na última posicao");
                lista.add(lista.size(), 11);
                System.out.println(lista);

                //*****Testando remoções*****
                int elem = lista.removeByIndex(0);
                System.out.println();
                System.out.println("Removendo o primeiro");
                System.out.println("removido: " + elem);
                System.out.println(lista);

                elem = lista.removeFirst();
                System.out.println();
                System.out.println("Removendo o primeiro com removeFirst()");
                System.out.println("removido: " + elem);
                System.out.println(lista);

                System.out.println();
                elem = lista.removeByIndex(4);
                System.out.println("Removendo o quinto elemento");
                System.out.println("removido: " + elem);
                System.out.println(lista);

                System.out.println();
                elem = lista.removeByIndex(lista.size() - 1);
                System.out.println("Removendo o ultimo elemento");
                System.out.println("removido: " + elem);
                System.out.println(lista);

                System.out.println();
                elem = lista.removeLast();
                System.out.println("Removendo o ultimo elemento com removeLast()");
                System.out.println("removido: " + elem);
                System.out.println(lista);

                /*
                System.out.println();
                System.out.println("Tentando remover elemento fora do indice:");
                lista.removeByIndex(lista.size());
                System.out.println(lista);
                */
        }
}
