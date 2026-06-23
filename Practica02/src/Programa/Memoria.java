package Programa;

public class Memoria {

    private static int[] memoria = new int[1024];

    public int getValor(int dir){
        return memoria[dir];
    }

    public void setValor(int dir, int valor){
        memoria[dir] = valor;
    }
}
