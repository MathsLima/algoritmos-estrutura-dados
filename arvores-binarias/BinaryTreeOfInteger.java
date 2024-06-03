
import java.util.NoSuchElementException;


/**
 * Classe de arvore binaria de numeros inteiros.
 *
 * @author Isabel H. Manssour
 * @author Luan Fonseca Garcia
 */

public class BinaryTreeOfInteger {

    private static final class Node {

        public Node parent;
        public Node left;
        public Node right;
        private Integer element;

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

    // Metodos
    public BinaryTreeOfInteger() {
        count = 0;
        root = null;
    }

    /**
     * Remove todos os elementos da arvore.
     */
    public void clear() {
        count = 0;
        root = null;
    }

    /**
     * Verifica se a arvore esta vazia ou nao.
     *
     * @return true se arvore vazia e false caso contrario.
     */
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * Retorna o total de elementos da arvore.
     *
     * @return total de elementos
     */
    public int size() {
        return count;
    }

    /**
     * Retorna o elemento armazenado na raiz da arvore.
     *
     * @throws EmptyTreeException se arvore vazia.
     * @return elemento da raiz.
     */
    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    /**
     * Retorna o elemento pai do elemento passado por parâmetro.
     *
     * @param element
     * @return pai de element
     */
    public Integer getParent(Integer element) {
        Node n = this.searchNodeRef(element, root);
        if (n == null) {
            return null;
        } else if (n.parent==null) {
            return null;
        }else {
            return n.parent.element;
        }
    }

    /**
     * Altera o elemento da raiz da árvore.
     *
     * @param element a ser colocado na raiz da árvore.
     */
    public void setRoot(Integer element) {
         // Implementar
    }

    /**
     * Insere o elemento como raiz da arvore, se a arvore estiver vazia.
     * @param element a ser inserido.
     * @return true se for feita a insercao, e false caso a arvore nao estiver
     * vazia e a insercao não for feita.
     */
    public boolean addRoot(Integer element) {
        if (root != null) // se a arvore nao estiver vazia
            return false;
        root = new Node(element);
        count++;
        return true;
    }

    /**
     * Insere element a esquerda de parentElement. Se não encontrar parent,
     * ou se parent já tiver um filho à esquerda, element não é
     * inserido.
     *
     * @param element a ser inserido
     * @param parentElement pai do elemento a ser inserido
     * @return true se foi feita a inserção, e false caso contrário.
     */
    public boolean addLeft(Integer element, Integer parentElement) {
        // Primeiro procura por parentElement
        Node aux = searchNodeRef(parentElement,root);
        
        // Se nao encontrou parentElement
        if (aux == null)
            return false;
        // Se parentElement ja tem filho a esquerda
        if (aux.left != null)
            return false;
        
       // Senão, insere element
       Node n = new Node(element); // primeiro cria o nodo
       n.parent = aux; // faz o novo nodo apontar para o pai
       aux.left = n;// faz o pai apontar para o filho
       count++; // atualiza count
       return true;
    }

    /**
     * Insere element a direita de parentElement. Se nao encontrar father,
     * ou se father ja tiver um filho a direita, element nao e´ 
     * inserido.
     *
     * @param element a ser inserido
     * @param parentElement pai do elemento a ser inserido
     * @return true se foi feita a inserção, e false caso contrario.
     */
    public boolean addRight(Integer element, Integer parentElement) {
        // Primeiro procura por parentElement
        Node aux = searchNodeRef(parentElement,root);
        
        // Se nao encontrou parentElement
        if (aux == null)
            return false;
        // Se parentElement ja tem filho a direita
        if (aux.right != null)
            return false;
        
       // Senao, insere element
       Node n = new Node(element); // primeiro cria o nodo
       n.parent = aux; // faz o novo nodo apontar para o pai
       aux.right = n;// faz o pai apontar para o filho
       count++; // atualiza count
       return true;
    }

    /**
     * Verifica se element esta ou nao armazenado na arvore.
     *
     * @param element
     * @return true se element estiver na arvore, false caso contrario.
     */
    public boolean contains(Integer element) {
        Node nAux = searchNodeRef(element, root);
        return (nAux != null);
    }

    // Metodo privado que procura por element a partir de target
    // e retorna a referencia para o nodo no qual element esta
    // armazenado. Retorna null se nao encontrar element.
    private Node searchNodeRef(Integer element, Node target) {
        if ( target == null)
            return null;
        // Visita a "raiz"
        if (element.equals(target.element))
            return target; // se achou element na "raiz"
        
        // Visita subarvore da esquerda
        Node aux = searchNodeRef(element, target.left);
        
        // Se nao encontrou, visita a subarvore da direita
        if (aux == null)
              aux = searchNodeRef(element, target.right);
        
        return aux;
    }

    /**
     * Remove um galho da arvore a partir do elemento recebido por parametro.
     *
     * @param element raiz da subarvore a ser removida.
     * @return true se for feita a remocao.
     */
    public boolean removeBranch(Integer element) {
        if (root == null)  // se arvore vazia    
            return false;
        
        // Se remocao a partir da raiz
        if (element.equals(root.element)) {
            // arvore fica vazia
            root = null;
            count = 0;
            return true;
        }
        
        // Procura por element
        Node aux = searchNodeRef(element, root);
        
        if (aux == null) // se nao achou element
            return false;
        
        // Se achou element, faz a remocao
        Node parent = aux.parent;
        if (aux == parent.left) // se for filho a esq
            parent.left = null;
        else // se for filho a dir
            parent.right = null;
        count = count - countNodes(aux);
        aux.parent = null; // opcional
        return true;
    }

    // Conta o numero de nodos a partir de "n"
    private int countNodes(Node n) {
        if (n==null)
            return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    /**
     * Troca um elemento da arvore pelo elemento passado por parametro.
     *
     * @param old elemento a ser encontrado para ser substituido.
     * @param element elemento a ser colocado no lugar de old.
     * @return true se fez a troca, false caso contrario.
     */
    public boolean set(Integer old, Integer element) {
        // Implementar
        return false;
    }

    /**
     * Retorna true se element esta armazenado em um nodo externo.
     *
     * @param element
     * @return true se element esta em um nodo externo.
     */
    public boolean isExternal(Integer element) {
        // Implementar
        return false;
    }

    /**
     * Retorna true se element esta armazenado em um nodo interno.
     *
     * @param element
     * @return true se element esta em um nodo interno.
     */
    public boolean isInternal(Integer element) {
        // Implementar
        return false;
    }

    /**
     * Retorna true se element tem um filho a esquerda.
     *
     * @param element
     * @return true se element tem um filho a esquerda, false caso contrario.
     */
    public boolean hasLeft(Integer element) {
        // Implementar
        return false;
    }

    /**
     * Retorna true se element tem um filho a direita.
     *
     * @param element
     * @return true se element tem um filho a direita, false caso contrario.
     */
    public boolean hasRight(Integer element) {
        // Implementar
        return false;
    }

    /**
     * Retorna o filho a esquerda de element.
     *
     * @param element
     * @return o filho a esquerda, ou null se nao tiver filho a esquerda.
     */
    public Integer getLeft(Integer element) {
        // Implementar
        return null;
    }

    /**
     * Retorna o filho a direita de element.
     *
     * @param element
     * @return o filho a direita, ou null se nao tiver filho a direita.
     */
    public Integer getRight(Integer element) {
        // Implementar
        return null;
    }

    /**
     * Retorna uma lista com todos os elementos da arvore na ordem do
     * caminhamento pre-fixado.
     *
     * @return lista com todos os elementos da arvore.
     */
    public SinglyLinkedList positionsPre() {
       // Implementar
       return null;
    }

    /**
     * Retorna uma lista com todos os elementos da arvore na ordem do
     * caminhamento pos-fixado.
     *
     * @return lista com todos os elementos da arvore.
     */
    public SinglyLinkedList positionsPos() {
        SinglyLinkedList lista = new SinglyLinkedList();
        positionsPosAux(root, lista);
        return lista;
    }
    private void positionsPosAux(Node n, SinglyLinkedList lista) {
        if (n != null) {
            positionsPosAux(n.left,lista); // percorre subarvore da esq
            positionsPosAux(n.right,lista); // percorre subarvore da dir
            lista.add(n.element); // visita raiz
        }
    }

    /**
     * Retorna uma lista com todos os elementos da arvore na ordem do
     * caminhamento central.
     *
     * @return lista com todos os elementos da arvore.
     */
    public SinglyLinkedList positionsCentral() {
        SinglyLinkedList lista = new SinglyLinkedList();
        positionsCentralAux(root, lista);
        return lista;
    }

    private void positionsCentralAux(Node n, SinglyLinkedList lista) {
        // Implementar
    }

    /**
     * Retorna uma lista com todos os elementos da arvore na ordem do
     * caminhamento em largura (por niveis).
     *
     * @return lista com todos os elementos da arvore.
     */
    public SinglyLinkedList positionsWidth() {
        SinglyLinkedList lista = new SinglyLinkedList();
        if (root != null) {
            Queue<Node> fila = new Queue<>();
            // Coloca a raiz na fila
            fila.enqueue(root);
            
            // Enquanto a fila nao estiver vazia
            while (!fila.isEmpty()) {
                // Tira o nodo da fila
                Node n = fila.dequeue();
                // Coloca o elemento do nodo na lista
                lista.add(n.element);
                // Coloca os filhos do nodo na fila
                if (n.left != null)
                    fila.enqueue(n.left);
                if (n.right != null)
                    fila.enqueue(n.right);                
            }
        }
        return lista;
    }


    public int height() {
        // Implementar
        return -1;
    }

    public int level(Integer element) {
        Node n = this.searchNodeRef(element, root);
        if (n == null) {
            throw new NoSuchElementException();
        } else {
            int cont = 0;
            while (n != root) {
                n = n.parent;
                cont++;
            }
            return cont;
        }
    }

   public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node n) {
        int res = 0;
        if (n != null) {
            if ((n.left == null) && (n.right == null)) {
                res = 1;
            } else {
                res = countLeaves(n.left) + countLeaves(n.right);
            }
        }
        return res;
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
