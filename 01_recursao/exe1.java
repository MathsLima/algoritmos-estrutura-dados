/*Escreva um metodo que calcula x elevado na y (onde x e y sao inteiros).
Considere que x e y são parametros do metodo.
*/
import java.util.*;

public class exe1 {
    public int x;
    public int y;

    //construtor
    public exe1(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int gety(){
        return y;
    }

    public double calculo(int x, int y){
        if (y == 0){
            return 1;
        } else{
            return x * calculo(x, y - 1);
        }
    }
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Digite X: ");
        int x = input.nextInt(); 

        System.out.print("Digite Y: ");
        int y = input.nextInt();

        //cria o objeto 
        exe1 exercicio1 = new exe1(x, y);

       double conta = exercicio1.calculo(x, y);

       System.out.println(conta);

    }
}