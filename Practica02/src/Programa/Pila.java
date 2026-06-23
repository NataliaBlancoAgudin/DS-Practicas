package Programa;

public class Pila {

    private static int[] pila = new int[32];
    private static int sp = 0;

    private static int ip = 0;


    public void push(int valor) {
        pila[sp] = valor;
        sp++;
    }

    public int pop() {
        sp--;
        return pila[sp];
    }
}
