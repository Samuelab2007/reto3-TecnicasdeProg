import java.util.Scanner;

//Realizado por: Samuel Acevedo Bustamante(1001016099)

public class reto3 {

    static float maximo(float[] arraycomparacion){
        int i=0;
        int k=1;
        while(k<=arraycomparacion.length-1){
            if(arraycomparacion[i]<arraycomparacion[k]) {    //Dejo el mayor valor en el i; cuando la k queda outofbounds termina
                i = k;
            }
            k++;
        }
        return arraycomparacion[i];
    }
    static float minimo(float[] arraycomparacion){

            int j=1;
            int k=0;

            while(j<= arraycomparacion.length-1){
                if(arraycomparacion[j]<arraycomparacion[k]){
                    k=j;
                }
                j++;
            }
            return arraycomparacion[k];
    }
    static float promedio(float[] arraycomparacion){

        float numerador=0;
        for (float v : arraycomparacion) {
            numerador += v;
        }
        return numerador/ arraycomparacion.length;

    }
    static double DesviacionEstandar(float[] arraycomparacion){

        double numerador = 0;
        int i=0;
        while(i< arraycomparacion.length){
            numerador+=Math.pow(arraycomparacion[i]-promedio(arraycomparacion),2);
            i++;
        }
        return Math.sqrt(numerador/((arraycomparacion.length)-1));
    }

    public static void main(String[] args){
        System.out.print("Seleccione el ejercicio: ");
        Scanner menu =new Scanner(System.in);
        byte opcion = menu.nextByte();
        switch(opcion){
            case 1:
                punto1();
                break;
            case 2:
                punto2();
                break;
            case 3:
                punto3();
                break;
            case 0:
                System.exit(0);
        }
    }

    public static void punto1(){
        Scanner IngresoNotas = new Scanner(System.in);
        System.out.println("Cuantas notas va a ingresar(expresar en números): ");
        byte cantidad = IngresoNotas.nextByte();

        float[] notas = new float[cantidad];
        System.out.println("En el caso de que sean decimales, por favor ingresar los numeros con coma para evitar errores");
        for(int i=0;i < notas.length;i++){
            System.out.println("Nota número "+(i+1));

            notas[i] = IngresoNotas.nextFloat();  //Guardo las notas en el vector

            if(notas[i]>5 || notas[i]<0){
                System.out.println("Número inválido");
                notas[i] = 0;
                i--;
            }

        }
        System.out.println("Operaciones a realizar: ");
        System.out.println(" 1.Máximo\n 2.Mínimo\n 3.Promedio\n 4.Desviación Estándar");
        byte operacion=IngresoNotas.nextByte();
        switch (operacion){
            case 1:
                System.out.println("El maximo es: ");
                System.out.print(maximo(notas));
                break;
            case 2:
                System.out.println("El minimo es: ");
                System.out.print(minimo(notas));
                break;
            case 3:
                System.out.println("El promedio es: ");
                System.out.print(promedio(notas));
                break;
            case 4:
                System.out.println("La desviacion estándar es: ");
                System.out.print(DesviacionEstandar(notas));
                break;

        }
    }

    public static void punto2(){
        System.out.println("Escoja la dimensión de sus vectores: ");
        Scanner LectorNum = new Scanner(System.in);

        byte dimension= LectorNum.nextByte();

        int[] vector1 = new int[dimension];     //Creo los vectores con la dimensión que pida el usuario, por el momento están vacíos
        int[] vector2 = new int[dimension];

        System.out.println("Para el primer vector");
        for (int i = 0; i < vector1.length; i++) {                  //Estos dos for sirven para llenar cada uno de los vectores.
            System.out.println("Dato de la posición " + i);
            int j = LectorNum.nextInt();
            vector1[i] = j;
        }
        System.out.println("Para el segundo vector");
        for (int i = 0; i < vector2.length; i++) {
            System.out.println("Dato de la posición " + i);
            int j = LectorNum.nextInt();
            vector2[i] = j;
        }//Ya se crearon los dos arrays con la información, ahora necesito extraer la información y presentarla en consola.

        int resultado = 0;
        byte posicion1=0;
        byte posicion2=0;
        StringBuilder cadena = new StringBuilder();
        String operacion;
        String multiplicacion=null;
            while(posicion1<dimension && posicion2<dimension) { //Da el resultado, sería bueno concatenar una cadena con el proceso del producto escalar
                if (multiplicacion==null){
                    operacion="";
                }else{
                    operacion="+";
                }
                multiplicacion = vector1[posicion1]+"*"+vector2[posicion2];
                resultado += vector1[posicion1]*vector2[posicion2];

                cadena.append(operacion).append(multiplicacion);
                posicion1++;
                posicion2++;
            }
        System.out.println("Resultado del producto escalar: "+resultado+"="+cadena);
    }

    public static void punto3(){

        Scanner leer = new Scanner(System.in);
        int N,M;
        System.out.println("Selecciones las dimensiones de la matriz: ");
        System.out.print("#Filas: ");
        N=leer.nextInt();
        System.out.print("#Columnas: ");
        M=leer.nextInt();

        double[][] matriz = new double[N][M];

        for(int i = 0;i<N;i++){
            System.out.println("Datos de la fila "+(i+1));
            for(int j = 0;j<matriz[i].length;j++){ /*Recorre el array que está en la posición i del array multidimensional,
                                                    la ventaja que tiene es que no importa la longitud concreta de cada array
                                                    ya que esta se ejecuta hasta la longitud concreta de cada fila, sin dejar algo por fuera*/
                matriz[i][j] = leer.nextDouble();
            }
        }
    //Ahora imprimo la matriz
        System.out.println("Matriz:\n");
        for(int i = 0;i<N;i++){
            for(int j = 0;j<matriz[i].length;j++){
            System.out.printf("%5.1f",matriz[i][j]);
            }
            System.out.print("\n");
        }
    }
}
