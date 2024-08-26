
public class App {
    public static void main(String[] args) {
        BinarySearchTreeOfInteger b = new BinarySearchTreeOfInteger();
        b.add(15);
        b.add(23);
        b.add(9);
        b.add(11);
        b.add(2);
        b.add(20);
        b.add(38);
      /*  b.remove(15);
        b.remove(23);
        b.remove(11);
        b.remove(9);*/
        
        System.out.println("20 esta na arvore? " + b.contains(20));
        System.out.println("9 esta na arvore? " + b.contains(9));
        System.out.println("66 esta na arvore? " + b.contains(66));
        
        //System.out.println("Menor elemento da arvore: " + b.getSmallest());
        
        System.out.println("---------------------");
        b.GeraDOT();

        System.out.println("Menor valor da arvore: " + b.getSmallest());
        System.out.println("Maior valor da arvore: " + b.getGreatest());

        //arvore em lista
        SinglyLinkedList s = b.arvoreLista();
        System.out.println("Arvore convertida em Lista");
        System.out.println(s);
     }
}
