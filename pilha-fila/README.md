### Estruturas básicas
1. Uma classe ArrayQueue, contendo uma implementação completa de uma estrutura do
tipo Fila que utilize apenas arrays.
a. O tamanho inicial padrão do array deve ser 5.
b. A implementação deve garantir que o usuário possa utilizar a estrutura tendo mais
do que 5 elementos (sem que seja necessário que o usuário gerencie isso).
c. A implementação do método dequeue() deve garantir que o custo seja O(1), ou
seja, constante.
2. Uma classe LinkedQueue, contendo uma implementação completa de uma estrutura do
tipo Fila que utilize como estrutura base alguma das classes de Lista Encadeada que
implementamos em aula.
3. Uma classe ArrayStack, contendo uma implementação completa de uma estrutura do tipo
Pilha que utilize apenas arrays.
a. O tamanho inicial padrão do array deve ser 5.
b. A implementação deve garantir que o usuário possa utilizar a estrutura tendo mais
do que 5 elementos (sem que seja necessário que o usuário gerencie isso).
4. Uma classe LinkedStack, contendo uma implementação completa de uma estrutura do
tipo Pilha que utilize como estrutura base alguma das classes de Lista Encadeada que
implementamos em aula.
5. O método toString() deve ser implementado para todas as classes.

### Classe Utils.java e implemente os métodos a seguir:
1. Método QueueTAD clone(QueueTAD f). Este método deve receber como parâmetro uma
fila e retornar uma cópia da fila, mas a fila “original” não deve ter seu conteúdo alterado.
2. Método void copiaParaFila(QueueTAD f, StackTAD p), que copia os elementos da pilha
para a fila, recebidas como parâmetro, mas que ao final mantém a pilha com os
mesmos elementos originais, na mesma ordem.
3. Método ListTAD concatenaFilas(QueueTAD f1, QueueTAD f2), que recebe duas filas
como parâmetro e retorna uma lista contendo os elementos das duas filas. Ao final, ambas
filas devem estar com o seu conteúdo original, ou seja, as filas não devem ser alteradas.
4. Método boolean ehPalindromo(int n), que recebe um inteiro e retorna true se for um
número palíndromo ou false caso não seja. Um número palíndromo é um número que se
mantém o mesmo lido da esquerda para direita e da direita para esquerda. Ex: 121, 24242,
51715 são número palíndromos, 123, 2462, 51517 não são.
Dica: Você pode utilizar o método Integer.toString() para converter um inteiro para uma
String e lidar com cada dígito individualmente.
