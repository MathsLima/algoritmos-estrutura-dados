Analise a implementação da classe ListArray e no método main chame os métodos
implementados para entende r a sua utilização.A seguir, realize os seguintes
exercícios:

1. Implemente o método public void clear() para a classe ListArray. Este método
deverá esvaziar completamente a lista e deixá-la com tamanho padrão.

2. Implemente o método public boolean isEmpty(), que deverá verificar se a lista
está vazia ou não e retornar um booleano true caso esteja, ou false, caso não
esteja vazia.

3. Implemente o método public int indexOf (int elem) para a classe ListArray.
Este método deverá retornar a posição na qual está armazenado o valor
passado por parâmetro. Analise a complexidade do método e acrescente a
notação O como comentário no código fonte junto da assinatura do método.

4. Implemente o método public boolean remove(int elem), que deverá procurar e
remover o primeiro elemento com valor elem do array. O método deverá retornar
true/false para indicar se conseguiu ou não encontrar o valor. Analise a
complexidade do método e acrescente a notação O como comentário no código
fonte junto da assinatura do método.

5. Acrescente na classe ListArray o seguinte método: public void reverse(). Este
método deve inverter o conteúdo da lista. Teste a sua implementação para este
método na classe App. Analise a complexidade do método e acrescente a
notação O como comentário no código fonte junto da assinatura do método.

6. Acrescente na classe ListArray o seguinte método: int countOccurrences(int
element), que conta o número de ocorrências do elemento passado como
parâmetro na lista, retornando este valor. Analise a complexidade do método e
acrescente a notação O como comentário no código fonte junto da assinatura do
método.

7. Acrescente na classe ListArray um método que faça uma inserção ordenada dos
elementos na lista (do menor para o maior). A assinatura deste método deve
ser: public void addIncreasingOrder(int element). Teste a sua implementação
para este método no método main instanciando uma nova lista e acrescentando
os elementos usando apenas este método. Analise a complexidade do método e
acrescente a notação O como comentário no código fonte junto da assinatura do
método. Observação: a lista só ficará garantidamente ordenada se os elementos
forem inseridos através da chamada deste método.

8. Implemente um método na classe ListArray que percorre a lista e retira os
elementos repetidos, deixando apenas uma ocorrência de cada elemento. A
assinatura deste método deve ser: public void unique(). Teste a sua
implementação para este método na classe App. Analise a complexidade do
método e acrescente a notação O como comentário no código fonte junto da
assinatura do método.

9. Implemente uma classe HighScores que mantém as dez maiores pontuações de
um jogo. Esta classe deve armazenar as pontuações em uma ListArray e deve
ter métodos para:
1. inserir um novo valor de pontuação
2. listar as pontuações já inseridas
Importante: se ainda não houver dez pontuações armazenadas, qualquer
pontuação pode ser inserida; se já houver dez pontuações, uma nova pontuação
será inserida somente se ela for maior que uma das pontuações armazenadas;
as pontuações devem ser mantidas em ordem na lista (da maior para a menor).
No método main da classe App instancie a classe HighScores, adicione
diferentes pontuações e teste se a classe implementada está funcionando
corretamente. Obs: neste exercício a classe ListArray não deve ser alterada.
Use os métodos implementados nos exercícios 5 e 7 para manter as pontuações
ordenadas corretamente.

10. Implemente um método que recebe por parâmetro dois ListArray e retorna um
terceiro ListArray que contém os elementos resultantes da intersecção das duas
listas recebidas por parâmetro. Ou seja, a lista retornada deve conter uma cópia
dos elementos que aparecem simultaneamente nas duas listas recebidas por
parâmetro. Analise a complexidade do método e acrescente a notação O como
comentário no código fonte junto da assinatura do método.

11. Instancie duas listas de inteiros (ListArray), e acrescente alguns elementos em
cada uma, mantendo-as ordenadas (use o método implementado no exercício
4). Depois escreva um método que recebe estas duas listas por parâmetro e
retorna uma terceira lista com todos os elementos das duas listas recebidas em
ordem crescente. Por exemplo, passando por parâmetro L1 = {3, 5, 8, 13, 19} e
L2 = {1, 4, 6, 9, 15}, o resultado deve ser L3 = {1, 3, 4, 5, 6, 8, 9, 13, 15, 1