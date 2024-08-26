/*Escreva um método que inverta os elementos de um vetor.*/

import java.util.Random;

public class exe2 {
    
    public static void inverteVetor(int[] vetor, int inicio, int fim){
        if (inicio < fim){
            int temp = vetor[inicio];
            vetor[inicio] = vetor[fim];
            vetor[fim] = temp;
 
            inverteVetor(vetor, inicio + 1, fim -1);
        }
    }      

    public static void main(String[] args){
        int []vetor = new int[10];
        Random numeRandom = new Random();

        for(int i=0; i<10; i++){
            vetor[i] = numeRandom.nextInt(100);
        }
        
        System.out.println("Vetor inicial");

        for(int elemento : vetor){
            System.out.print(elemento + " ");
        }

        System.out.println("\n");

        inverteVetor(vetor, 0, vetor.length-1);

        System.out.println("Vetor invertido");

        for(int elemento : vetor){
            System.out.print(elemento + " ");
        }
    }
}

