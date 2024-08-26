import java.util.NoSuchElementException;

public class BinarySearchTreeOfInteger {

    private static final class Node {

        public Node parent;
        public Node left;
        public Node right;
        public Integer element;

        public Node(Integer element) {
            parent = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    // Atributos        
    private int count; //contagem do número de nodos
    private Node root; //referência para o nodo raiz

    public BinarySearchTreeOfInteger() {
        count = 0;
        root = null;
    }

    public void clear() {
        count = 0;
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public int size() {
        return count;
    }

    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    public void add(Integer element) {
        root = addAux(root, element, null);
        count++;
    }
    
    private Node addAux(Node n, Integer e, Node parent) {
        if (n == null) { // insere
            Node aux = new Node(e);
            aux.parent = parent;
            return aux;
        }
        // Senao insere na subarvore da esq ou da dir
        if (n.element <= e) {
            n.right = addAux(n.right, e, n);
        }
        else {
            n.left = addAux(n.left, e, n);
        }
        return n;
    }

    public Integer getLeft(Integer element) {
        Node aux = searchNodeRef(element, root);
        if(aux!=null)
            if(aux.left!=null)
                return aux.left.element;
        return null;
    }

    public Integer getRight(Integer element) {
        Node aux = searchNodeRef(element, root);
        if(aux.right!=null)
            return aux.right.element;
        throw new NoSuchElementException();
    }

    public Integer getParent(Integer element) {
        Node aux = searchNodeRef(element, root);
        if(aux!=null)
            if(aux.parent!=null)
                return aux.parent.element;

        throw new NoSuchElementException();
    }

    public SinglyLinkedList positionsPre() {
        SinglyLinkedList res = new SinglyLinkedList();
        positionsPreAux(root, res);
        return res;
    }

    private void positionsPreAux(Node n, SinglyLinkedList res) {
        if (n != null) {
            res.add(n.element); //Visita o nodo
            positionsPreAux(n.left, res); //Visita a subárvore da esquerda
            positionsPreAux(n.right, res); //Visita a subárvore da direita
        }
    }

    public SinglyLinkedList positionsPos() {
        SinglyLinkedList res = new SinglyLinkedList();
        positionsPosAux(root, res);
        return res;
    }

    private void positionsPosAux(Node n, SinglyLinkedList res) {
        if (n != null) {
            positionsPosAux(n.left, res); //Visita a subárvore da esquerda
            positionsPosAux(n.right, res); //Visita a subárvore da direita
            res.add(n.element); //Visita o nodo
        }
    }

    public SinglyLinkedList positionsCentral() {
        SinglyLinkedList res = new SinglyLinkedList();
        positionsCentralAux(root, res);
        return res;
    }

    private void positionsCentralAux(Node n, SinglyLinkedList res) {
        if (n != null) {
            positionsCentralAux(n.left, res); //Visita a subárvore da esquerda
            res.add(n.element); //Visita o nodo
            positionsCentralAux(n.right, res); //Visita a subárvore da direita
        }
    }

    public SinglyLinkedList positionsWidth() {
        Queue<Node> fila = new Queue<>();
        Node atual = null;
        SinglyLinkedList res = new SinglyLinkedList();
        if (root != null) {
            fila.enqueue(root);
            while (!fila.isEmpty()) {
                atual = fila.dequeue();
                if (atual.left != null) {
                    fila.enqueue(atual.left);
                }
                if (atual.right != null) {
                    fila.enqueue(atual.right);
                }
                res.add(atual.element);
            }
        }
        return res;
    }

    public boolean contains(Integer element) {
        Node aux = searchNodeRef(element, root);
        return (aux!=null);
    }

    private Node searchNodeRef(Integer element, Node n) {
        if (element == null || n == null)
            return null;
        int c = n.element.compareTo(element);
        if (c==0)
            return n;
        if (c > 0) {
            return searchNodeRef(element, n.left);
        }
        else {
            return searchNodeRef(element, n.right);
        }
    }

    public boolean remove(Integer element) {
        // Se arvore vazia
        if (element == null || root==null)
            return false;
        
        Node aux = searchNodeRef(element, root);
        if (aux == null) { // se nao encontrou element
            return false;
        }
        
        remove(aux);    // chama metodo que faz a remocao
        count--;        // atualiza o count
        return true;    // return true
    }
    
    private void remove(Node n) {
        Node parent = n.parent;
        if (n.left == null && n.right == null) { // se remocao de nodo folha
            if (root == n) { // se remocao da raiz
                root = null;
                return;
            }
            if (parent.left == n)
                parent.left = null;
            else
                parent.right = null;
        }
        else if (n.left == null && n.right != null) { // tem apenas um filho a direita
            if (root == n) { // se remocao da raiz que tem só um filho a direita
                root = root.right;
                root.parent = null;
                return;
            }
            if (parent.left == n)
                parent.left = n.right;
            else
                parent.right = n.right;
            n.right.parent = parent;
        }
        else if (n.left != null && n.right == null) { // tem apenas um filho a esquerda
            if (root == n) { // se remocao da raiz que tem só um filho a esquerda
                root = root.left;
                root.parent = null;
                return;
            }
            if (parent.left == n)
                parent.left = n.left;
            else
                parent.right = n.left;
            n.left.parent = parent;            
        }
        else { // tem dois filhos (esq,dir)
            // pega a refencia para o nodo que contem o menor elemento do lado direito
            Node menor = smallest(n.right);
            n.element = menor.element;
            remove(menor);
        }
    }

    /**
     * Retorna o menor elemento da arvore.
     * @return o menor elemento
     */
    public Integer getSmallest() {
        Node n = smallest(root);
        if (n==null)
            return null;
        else
            return n.element;
    }


    //Recebe um nodo e procura o menor elemento a partir dele
    private Node smallest(Node n) {
        if (n.left == null){
            return n;
        }
        return smallest(n.left);

    }

    public Integer getGreatest()
    {
        Node n = greatest(root);
        if (n==null)
            return null;
        else
            return n.element;
    }

    //Recebe um nodo e procura o maior elemento a partir dele
    private Node greatest(Node n) {
        if (n.right == null){
            return n;
        }
        return smallest(n.right);
    }

    public boolean isExternal(int element) {
        Node aux = searchNodeRef(element, root);
        if(aux.left == null && aux.right == null) {
            return true;
        }
        return false;
    }

    public boolean isInternal(int element) {
        Node aux = searchNodeRef(element, root);
        if(aux.left != null || aux.right != null) {
            return true;
        }
        return false;
    }

    /**
     * gera uma lista a partir da arvore
     * usa um metodo para percorrer a lista e insere no metodo
     * arvore lista.
     */
    private void geraLista(Node n, SinglyLinkedList res) {
        if (n != null) {
            geraLista(n.left, res);
            res.add(n.element);
            geraLista(n.right, res);
        }
    }

    public SinglyLinkedList arvoreLista() {
        SinglyLinkedList lista = new SinglyLinkedList();
        geraLista(this.root, lista);
        return lista;
    }



    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes online do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline 
    
    private void GeraConexoesDOT(Node nodo) {
        if (nodo == null) {
            return;
        }

        GeraConexoesDOT(nodo.left);
        //   "nodeA":esq -> "nodeB" [color="0.650 0.700 0.700"]
        if (nodo.left != null) {
            System.out.println("\"node" + nodo.element + "\":esq -> \"node" + nodo.left.element + "\" " + "\n");
        }

        GeraConexoesDOT(nodo.right);
        //   "nodeA":dir -> "nodeB";
        if (nodo.right != null) {
            System.out.println("\"node" + nodo.element + "\":dir -> \"node" + nodo.right.element + "\" " + "\n");
        }
        //"[label = " << nodo->hDir << "]" <<endl;
    }

    private void GeraNodosDOT(Node nodo) {
        if (nodo == null) {
            return;
        }
        GeraNodosDOT(nodo.left);
        //node10[label = "<esq> | 10 | <dir> "];
        System.out.println("node" + nodo.element + "[label = \"<esq> | " + nodo.element + " | <dir> \"]" + "\n");
        GeraNodosDOT(nodo.right);
    }

    public void GeraConexoesDOT() {
        GeraConexoesDOT(root);
    }

    public void GeraNodosDOT() {
        GeraNodosDOT(root);
    }

 
    public void GeraDOT() {
        System.out.println("digraph g { \nnode [shape = record,height=.1];\n" + "\n");

        GeraNodosDOT();
        System.out.println("");
        GeraConexoesDOT(root);
        System.out.println("}" + "\n");
    }
}
