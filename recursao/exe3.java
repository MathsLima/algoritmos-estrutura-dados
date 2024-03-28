/*Escreva um método que some todos elementos inteiros de um vetor. */

public class exe3 {

    public static int somaElemVetor(int[] vetor, int index){
        if (index == vetor.length){
            return 0;
        } else {
            return vetor[index] + somaElemVetor(vetor, index+1);
        }
    }

    public static void main(String[] args){
        int[] vetor = {1,2,3,4,5};
        int resultadoSoma = somaElemVetor(vetor, 0);
        System.out.println(resultadoSoma);
    }
}
