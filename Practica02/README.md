# Sesión 2. Intérprete

En esta sesión se trabaja con un proyecto de un intérprete de un lenguaje similar al ensamblador. En el directorio files encontrarás dos programas que se pueden utilizar en el intérprete:
- *fibonacci.txt* pide un número **n** por consola e imprime los primeros **n** números que conforman la [Sucesión de Fibonacci](https://es.wikipedia.org/wiki/Sucesión_de_Fibonacci).
- *factorial.txt* pide también un número **n** por consola y calcula el factorial de ese número.

El código entregado ya funciona, pero hay que tratar de mejorar el diseño.

---
## Solución

> **Patrón Command**

Podemos observar que este proyecto tiene toda la funcionalidad en la clase `main.main.Main`. Esto supone un mal diseño porque si 
en un futuro queremos cambiar alguna instrucción, o añadir  alguna, deberemos de modificar esta clase (no cumple el 
principio de Abierto/Cerrado ni el de Responsabilidad Única):
<details>
<summary>Código main.main.Main</summary>

```java
public class Main {
    private static List<String[]> instrucciones = new ArrayList<String[]>();
    private static int ip = 0;

    private static int[] memoria = new int[1024];

    private static int[] pila = new int[32];
    private static int sp = 0;

    private static Scanner console = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        BufferedReader fichero = new BufferedReader(new FileReader("files/factorial.txt"));
        // BufferedReader fichero = new BufferedReader(new FileReader("files/fibonacci.txt"));

        String linea;
        while ((linea = fichero.readLine()) != null)
            cargaInstruccion(linea);
        fichero.close();

        ejecutaPrograma();
    }

    // $ Cargar programa --------------------------------
    private static void cargaInstruccion(String linea) {
        if (linea.trim().length() == 0)
            return;

        String[] palabras = linea.split(" ");
        instrucciones.add(palabras);
    }

    // $ Métodos Auxiliares --------------------------------
    private static void push(int valor) {
        pila[sp] = valor;
        sp++;
    }

    private static int pop() {
        sp--;
        return pila[sp];
    }

    // $ Motor de Ejecución --------------------------------
    private static void ejecutaPrograma() {
        while (ip < instrucciones.size()) {
            String[] instruccion = instrucciones.get(ip);

            if (instruccion[0].equals("push")) {
                push(Integer.parseInt(instruccion[1]));
                ip++;
            } else if (instruccion[0].equals("add")) {
                push(pop() + pop());
                ip++;
            } else if (instruccion[0].equals("sub")) {
                int b = pop();
                int a = pop();
                push(a - b);
                ip++;
            } else if (instruccion[0].equals("mul")) {
                push(pop() * pop());
                ip++;
            } else if (instruccion[0].equals("jmp")) {
                ip = Integer.parseInt(instruccion[1]);
            } else if (instruccion[0].equals("jmpg")) {
                int b = pop();
                int a = pop();
                if (a > b)
                    ip = Integer.parseInt(instruccion[1]);
                else
                    ip++;
            } else if (instruccion[0].equals("load")) {
                int direccion = pop();
                push(memoria[direccion]);
                ip++;
            } else if (instruccion[0].equals("store")) {
                int valor = pop();
                int direccion = pop();
                memoria[direccion] = valor;
                ip++;
            } else if (instruccion[0].equals("input")) {
                System.out.println("Escriba un entero:");
                push(console.nextInt());
                ip++;
            } else if (instruccion[0].equals("output")) {
                System.out.println(pop());
                ip++;
            }
        }
    }
}
```
</details>

Para arreglar esto, deberemos de pasar toda esta responsabilidad a otra clase que llamaremos `Program`:
<details>
<summary>Código Program</summary>

```java
public class Programa {
    private static List<String[]> instrucciones = new ArrayList<String[]>();
    private static int ip = 0;

    private static int[] memoria = new int[1024];

    private static int[] pila = new int[32];
    private static int sp = 0;

    private static Scanner console = new Scanner(System.in);

    private String nombreFichero;

    public Programa(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    public void ejecutarPrograma() throws Exception {
        BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

        String linea;
        while ((linea = fichero.readLine()) != null)
            cargaInstruccion(linea);
        fichero.close();

        ejecutaPrograma();
    }


    // $ Cargar programa --------------------------------
    private static void cargaInstruccion(String linea) {
        if (linea.trim().length() == 0)
            return;

        String[] palabras = linea.split(" ");
        instrucciones.add(palabras);
    }

    // $ Métodos Auxiliares --------------------------------
    private static void push(int valor) {
        pila[sp] = valor;
        sp++;
    }

    private static int pop() {
        sp--;
        return pila[sp];
    }

    // $ Motor de Ejecución --------------------------------
    private static void ejecutaPrograma() {
        while (ip < instrucciones.size()) {
            String[] instruccion = instrucciones.get(ip);

            if (instruccion[0].equals("push")) {
                push(Integer.parseInt(instruccion[1]));
                ip++;
            } else if (instruccion[0].equals("add")) {
                push(pop() + pop());
                ip++;
            } else if (instruccion[0].equals("sub")) {
                int b = pop();
                int a = pop();
                push(a - b);
                ip++;
            } else if (instruccion[0].equals("mul")) {
                push(pop() * pop());
                ip++;
            } else if (instruccion[0].equals("jmp")) {
                ip = Integer.parseInt(instruccion[1]);
            } else if (instruccion[0].equals("jmpg")) {
                int b = pop();
                int a = pop();
                if (a > b)
                    ip = Integer.parseInt(instruccion[1]);
                else
                    ip++;
            } else if (instruccion[0].equals("load")) {
                int direccion = pop();
                push(memoria[direccion]);
                ip++;
            } else if (instruccion[0].equals("store")) {
                int valor = pop();
                int direccion = pop();
                memoria[direccion] = valor;
                ip++;
            } else if (instruccion[0].equals("input")) {
                System.out.println("Escriba un entero:");
                push(console.nextInt());
                ip++;
            } else if (instruccion[0].equals("output")) {
                System.out.println(pop());
                ip++;
            }
        }
    }
}
```
</details>

Y el main.main.Main nos quedará muchisimo más limpio:
<details>
<summary>Código main.main.Main</summary>

```java
public class Main {

    public static void main(String[] args) throws Exception {
        Programa.Programa programa = new Programa.Programa("files/factorial.txt");
        programa.ejecutarPrograma();
    }
}
```
</details>

Haciendo esto podemos pensar que solo hemos pasado toda la implementación de una clase a otra, pero hemos ganado mucho:
ahora el ``main.main.Main`` no se tiene que preocupar de como se gestiona la pila, solo le pasa al constructor del Programa.Programa el fichero
que quiere que se ejecuta y ordena que se ejecute.    

Vamos ahora a mejorar el código de `Programa.Programa`: podemos ver que tenemos el mismo problema de antes: tenemos todo en una
misma clase. Podemos observar que ``Programa.Programa`` tiene tanto las responsabilidades de una Programa.Pila como de la Programa.Memoria; por lo que
vamos a separarlo en dos clases: ``Programa.Pila`` y `Programa.Memoria`:

```java
public class Pila {

    private static int[] pila = new int[32];
    private static int sp = 0;


    public void push(int valor) {
        pila[sp] = valor;
        sp++;
    }

    public int pop() {
        sp--;
        return pila[sp];
    }
}
```

```java
public class Memoria {

    private static int[] memoria = new int[1024];

    public int getValor(int dir){
        return memoria[dir];
    }

    public void setValor(int dir, int valor){
        memoria[dir] = valor;
    }
}
```

Y nuestro ``Programa.Programa`` quedaría así:
<details>
<summary>Código Programa.Programa</summary>

```java
public class Programa {
    private static List<String[]> instrucciones = new ArrayList<String[]>();
    private static int ip = 0;

    private static Scanner console = new Scanner(System.in);

    private String nombreFichero;

    private static Memoria memoria;
    private static Pila pila;

    public Programa(
    String nombreFichero)

    {
        this.nombreFichero = nombreFichero;
    }

    public void ejecutarPrograma() throws Exception {
        BufferedReader fichero = new BufferedReader(new FileReader(nombreFichero));

        String linea;
        while ((linea = fichero.readLine()) != null)
            cargaInstruccion(linea);
        fichero.close();

        ejecutaPrograma();
    }


    // $ Cargar programa --------------------------------
    private static void cargaInstruccion(String linea) {
        if (linea.trim().length() == 0)
            return;

        String[] palabras = linea.split(" ");
        instrucciones.add(palabras);
    }

    // $ Motor de Ejecución --------------------------------
    private static void ejecutaPrograma() {
        while (ip < instrucciones.size()) {
            String[] instruccion = instrucciones.get(ip);

            if (instruccion[0].equals("push")) {
                pila.push(Integer.parseInt(instruccion[1]));
                ip++;
            } else if (instruccion[0].equals("add")) {
                pila.push(pila.pop() + pila.pop());
                ip++;
            } else if (instruccion[0].equals("sub")) {
                int b = pila.pop();
                int a = pila.pop();
                pila.push(a - b);
                ip++;
            } else if (instruccion[0].equals("mul")) {
                pila.push(pila.pop() * pila.pop());
                ip++;
            } else if (instruccion[0].equals("jmp")) {
                ip = Integer.parseInt(instruccion[1]);
            } else if (instruccion[0].equals("jmpg")) {
                int b = pila.pop();
                int a = pila.pop();
                if (a > b)
                    ip = Integer.parseInt(instruccion[1]);
                else
                    ip++;
            } else if (instruccion[0].equals("load")) {
                int direccion = pila.pop();
                pila.push(memoria.getValor(direccion));
                ip++;
            } else if (instruccion[0].equals("store")) {
                int valor = pila.pop();
                int direccion = pila.pop();
                memoria.setValor(direccion, valor);
                ip++;
            } else if (instruccion[0].equals("input")) {
                System.out.println("Escriba un entero:");
                pila.push(console.nextInt());
                ip++;
            } else if (instruccion[0].equals("output")) {
                System.out.println(pila.pop());
                ip++;
            }
        }
    }
}
```
</details>

Ahora vamos a fijarnos en el método ``ejecutaPrograma()``: tiene muchas sentencias condicionales para saber que se tiene
que ejecutar, si en un futuro queremos añadir una nueva instrucción, deberemos de modificar esta clase (❌ **MAL**).  
Lo que podemos hacer es agrupar todas estas instrucciones en una interfaz `Instrucciones.Instruccion`, de la que hereden todas las instrucciones:
````java
public interface Instruccion {
    void execute(Programa programa);
}
````
Ahora en vez de tener una lista de ``String[]``, tendremos una lista de Instrucciones:

<details>
<summary>Código Programa.Programa</summary>

```java
public class Programa {
    private static List<Instruccion> instrucciones = new ArrayList<Instruccion>();

    //...

    // $ Cargar programa --------------------------------
    private static void cargaInstruccion(String linea) {
        if (linea.trim().length() == 0)
            return;

        String[] palabras = linea.split(" ");
        instrucciones.add(crearInstruccion(linea));
    }

    private static Instruccion crearInstruccion(String linea) {
        String[] palabras = linea.split(" ");

        Instruccion instruccion = null;

        if (palabras[0].equals("push")) {
            instruccion = new Push(Integer.parseInt(palabras[1]));
        } else if (palabras[0].equals("add")) {
            instruccion = new Add();
        } else if (palabras[0].equals("sub")) {
            instruccion = new Sub();
        } else if (palabras[0].equals("mul")) {
            instruccion = new Mul();
        } else if (palabras[0].equals("jmp")) {
            instruccion = new Jmp(Integer.parseInt(palabras[1]));
        } else if (palabras[0].equals("jmpg")) {
            instruccion = new Jmpg(Integer.parseInt(palabras[1]));
        } else if (palabras[0].equals("load")) {
            instruccion = new Load();
        } else if (palabras[0].equals("store")) {
            instruccion = new Store();
        } else if (palabras[0].equals("input")) {
            instruccion = new Input();
        } else if (palabras[0].equals("output")) {
            instruccion = new Output();
        }

        return instruccion;
    }
    //...
}

```
</details>


Para dejar el código más limpio, hemos creado una clase ``Programa.CargaInstrucciones`` que será la que tenga el método 
`crearInstruccion(String linea)`, para que de eso no se tenga que preocupar el `Programa.Programa`

````java
    // Codigo clase Programa
    private static void cargaInstruccion(String linea) {
        if (linea.trim().length() == 0)
            return;

        String[] palabras = linea.split(" ");
        instrucciones.add(CargaInstrucciones.crearInstruccion(linea));
    }
````

Además ahora que ya tenemos nuestra interfaz ``Instrucciones.Instruccion`` con todas las clases concretas (`Instrucciones.Add`, `Instrucciones.Sub`,...) podemos
dejar la clase ``Programa.Programa`` así:

````java
    //...
    private static void ejecutaPrograma() {
    while (ip < instrucciones.size()) {
        Instruccion instruccion = instrucciones.get(ip);
        instruccion.execute();
    }
}
````

Y las Instrucciones quedarían de esta forma:

````java
public class Add implements Instruccion {

    @Override
    public void execute(Programa programa) {
        programa.getPila().push(programa.getPila().pop() + programa.getPila().pop());
        programa.setIp(programa.getIp() + 1);
    }
}
````