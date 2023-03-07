
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

/**Dada la función:

public static String reverse(String texto) { }

       1 Escribe el código que devuelva una cadena al revés. Por ejemplo, la cadena "hola mundo", debe retornar "odnum aloh".

       2 Crea un array unidimensional de Strings y recórrelo, mostrando únicamente sus valores.

       3 Crea un array bidimensional de enteros y recórrelo, mostrando la posición y el valor de cada elemento en ambas
        dimensiones.

       4 Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos. Elimina el 2o y 3er elemento y muestra
         el resultado final.

       5 Indica cuál es el problema de utilizar un Vector con la capacidad por defecto si tuviésemos 1000 elementos para
         ser añadidos al mismo.

       6 Crea un ArrayList de tipo String, con 4 elementos. Cópialo en una LinkedList. Recorre ambos mostrando únicamente
         el valor de cada elemento.

       7 Crea un ArrayList de tipo int, y, utilizando un bucle rellénalo con elementos 1..10. A continuación,
         con otro bucle, recórrelo y elimina los numeros pares. Por último, vuelve a recorrerlo y muestra el ArrayList final.
         Si te atreves, puedes hacerlo en menos pasos, siempre y cuando cumplas el primer "for" de relleno.

       8 Crea una función DividePorCero. Esta, debe generar una excepción ("throws") a su llamante del tipo
         ArithmeticException que será capturada por su llamante (desde "main", por ejemplo).
         Si se dispara la excepción, mostraremos el mensaje "Esto no puede hacerse".
         Finalmente, mostraremos en cualquier caso: "Demo de código".

       9 Utilizando InputStream y PrintStream, crea una función que reciba dos parámetros:
         "fileIn" y "fileOut". La tarea de la función será realizar la copia del fichero
          dado en el parámetro "fileIn" al fichero dado en "fileOut".

       10 Sorpréndenos creando un programa de tu elección que utilice InputStream,
          PrintStream, excepciones, un HashMap y un ArrayList, LinkedList o array.

*/

public class ReverseText {
    public static void main(String[] args) {
        //uso de la función que devuelve la cadena de texto al revés
        System.out.println( reverse ("hola mundo"));

        //Crear array unidimensional y recorrerlo

        String [] array1 =  {"juan","paco","ernesto","Ana"};
        System.out.println("estos son los parámetros de el array1:  ");
        for (String e : array1){
            System.out.println(e);
        }

        //crear array bidimensional y recorrerlo dando también la posición

        int [][] array2 = {{1,2,3},{4,5,6}};
        for (int i = 0; i<array2.length;i++){
            for (int j = 0; j<array2[i].length; j++){
                System.out.print("["+i+"]"+"["+j+"]: ");
                System.out.println(array2[i][j]);
            }
        }

        //Creación de un vector (tipo de dato integer)

        Vector<Integer> vector1 = new Vector();
        vector1.add(1);
        vector1.add(2);
        vector1.add(3);
        vector1.add(4);
        vector1.add(5);

        //elimino el segundo y tercer elemento e imprimo el vector en pantalla
        vector1.remove(1);
        vector1.remove(1);
        System.out.println(vector1);

        //indicar problema con capacidad por defecto
        System.out.println("El problema es que para llegar a esos 1000 elementos se tendrían que crear varios " +
                "arrais subyacentes de manera consecutiva doblando su capacidad, de forma que se harían muchas operaciones " +
                "de copia muy costosas");

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("pan");
        arrayList1.add("leche");
        arrayList1.add("huevos");
        arrayList1.add("nueces");

        //Crear Araylist, pasarlo a linked list y recorrer ambos

        LinkedList<String> linkedList1 = new LinkedList<>(arrayList1);

        for (String e : arrayList1) {
            System.out.println(e);
        }
        for (String f : linkedList1) {
            System.out.println(f);
        }

        ArrayList<Integer> arrayList2 =new ArrayList<>();
        for (int i = 0; i<10; i++){
            arrayList2.add(i+1);
        }

        ArrayList<Integer> arrayFinal = new ArrayList<>();

        for (int i = 0; i<arrayList2.size() ; i++){
            if (arrayList2.get(i)%2!=0){
            arrayFinal.add(arrayList2.get(i));}
        }

        for (int i = 0; i<arrayFinal.size(); i++){
            System.out.println(arrayFinal.get(i));
        }
        try{
        DivedePorCero(2);}
        catch (ArithmeticException e){
        System.out.println("Esto no puede hacerse");
    }finally{
        System.out.println("Demo de código");
    }












    }
    //Función que toma una cadena de texto y la devuelve al revés
    public static String reverse (String texto) {
        char [] normal = texto.toCharArray();
        char [] reverse = new char [normal.length];
        for(int i = 0; i<normal.length; i++ ){
            reverse [i] = normal [(normal.length-1)-i];
        }
        return new String (reverse);
    }
    //función DividePorCero. Esta, debe generar una excepción ("throws") a su llamante del tipo
    //ArithmeticException que será capturada por su llamante (desde "main", por ejemplo).
   // Si se dispara la excepción, mostraremos el mensaje "Esto no puede hacerse".
    //Finalmente, mostraremos en cualquier caso: "Demo de código"
    public static int DivedePorCero (int num) throws ArithmeticException {
        int result = 0;
        try {
            result = num / 0;
        } catch (ArithmeticException e) {
            throw new ArithmeticException();
        }
        return result;
    }

    /*9 Utilizando InputStream y PrintStream, crea una función que reciba dos parámetros:
            "fileIn" y "fileOut". La tarea de la función será realizar la copia del fichero
    dado en el parámetro "fileIn" al fichero dado en "fileOut".*/
    public static void copiaFicheros (String fileIn,String fileOut){
        try {
            InputStream in = new FileInputStream(fileIn);
            byte[] datos = in.readAllBytes();
            in.close();

            PrintStream out = new PrintStream(fileOut);
            out.write(datos);
            out.close();
        } catch (Exception e) {
            System.out.println("Excepcion: " + e.getMessage());
        }
    }

    }

