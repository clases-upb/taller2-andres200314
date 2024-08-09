/*
 * Este es el segundo taller de lógica de programación. En este taller deben comenzar a prácticar hacer las validaciones
 * de los datos que va a recibir la función usando los condicionales if. 
 * 
 * Como en el anterior, tenga en cuenta la siguiente rúbrica para cada ejercicio la cual, 
 * se basa en los mandamientos del programador. El taller es una herramienta para comenzar a preparar la evaluación 
 * donde los descuentos si van a ser tenidos en cuenta. 
 * Con este taller, usted irá aprendiendo a aplicar buenas prácticas en la programación.
 * 
 * La siguiente rúbrica se descuenta en cada ejercicio y es acumulativa:
 * Descuento por quemar valores en el código y no usar constantes: -0.5
 * Descuento por no implementar control de errores con trycatch: -0.8
 * Descuento por no escribir el código ordenado, identado: -0.4
 * 
 * RÉTESE, PÓNGASE A PRUEBA!!!
 * 
 */
package taller2;


public class App {

    public static void main(String[] args) {
        try {
            
        } 
        
        catch (Exception e) {
            System.out.println(e.toString());
        }


    }


    /*
     * 1. Diseñe un algoritmo e implemente la función Calcular_saldo que reciba
     * tres enteros: la base de dinero en la taquilla, el total de recaudos y
     * el total de retiros, y retorne un entero que represente el saldo final
     * en la taquilla.
     * 
     * Valide que la base sea igual a 2.000.000. Si no es así, retorne -1.
     * 
     * saldo_taquilla = base + total recaudos - total_retiros
     * Si hay algún error, retorne -1.
     */

    public static int Calcular_saldo(int base, int recaudos, int retiros) {
        int MINIMO_BASE = 2_000_000;
        if (base != MINIMO_BASE) return -1;
        try {
            int saldo_taquilla;
            saldo_taquilla = base + recaudos - retiros;
            return saldo_taquilla;
        } catch (Exception e) {
            return  -1;
        }
    }


    /*
     * 2. Diseñe un algoritmo e implemente la función Calcular_tip que reciba
     * un float representando el valor del consumo de un cliente, y devuelva
     * un string que contenga el valor de la propina (10%), el impuesto al
     * consumo (8%) y el valor total a pagar.
     * 
     * MUY IMPORTANTE:
     * 
     * El formato del string debe ser: valor comida: $### - valor propina $### -
     * valor impoconsumo $### - total a pagar $###.
     * 
     * Si hay algún error, retorne "Error en la función Calcular_tip".
     * 
     * Ademas de esto, primero valide que el valor del consumo sea mayor a 0. Si no
     * es así, retorne "Error calculando consumo".
     * 
     */

    public static String Calcular_tip(float consumo_cliente){
        final byte MINIMO_CONSUMO = 0;
        try {
            if (consumo_cliente <= MINIMO_CONSUMO) return "Error calculando consumo";

            float propina, total, impo_consumo;
            final float PORCENTAJE_IMP_CONSUMO = (float) 8/100;
            final float PORCENTAJE_PROPINA = (float) 10/100;

            propina = consumo_cliente * PORCENTAJE_PROPINA;
            impo_consumo = consumo_cliente * PORCENTAJE_IMP_CONSUMO;
            total = consumo_cliente + propina + impo_consumo;

            return "valor comida: $" + consumo_cliente + " - valor propina $" + propina +
                    " - valor impoconsumo $" + impo_consumo + " - total a pagar $" + total;

        } catch (Exception e) {
            return "Error en la función Calcular_tip";
        }

    }

    /*
     * 3. Diseñe un algoritmo e implemente la función Obtener_puntos que reciba
     * tres enteros representando el número de partidos ganados, perdidos y
     * empatados de un equipo de fútbol, y devuelva un entero que represente
     * los puntos totales del equipo. La puntuación sigue los lineamientos
     * de la FIFA: 3 puntos por partido ganado, 1 punto por partido empatado y
     * 0 puntos por partido perdido. Si hay algún error, retorne -1.
     * 
     * Valide ademas que los partidos ganados, perdidos y empatados sean mayores o
     * iguales a 0. Si no es así, retorne -1.
     * 
     */

    public static int Obtener_puntos(int ganados, int perdidos, int empatados){
        try {
            final byte CERO = 0;
            if (ganados < CERO || perdidos < CERO || empatados < CERO) return -1;

            int puntos_totales;
            final byte PUNTOS_POR_GANADO = 3;
            final byte PUNTOS_POR_EMPATE = 1;


            puntos_totales = (ganados * PUNTOS_POR_GANADO) + (empatados * PUNTOS_POR_EMPATE);
            return puntos_totales;
        } catch (Exception e) {
           return -1;
        }
    }



    /*
     * 4. Diseñe un algoritmo e implemente la función Calcular_definitiva que
     * reciba cinco floats representando las notas (entre 0 y 5) y cinco floats
     * representando los porcentajes (que entre todos deberán sumar 1 y cada uno
     * estar entre 0 y 1),
     * y devuelva un float que represente la nota definitiva. Si algo está mal
     * con los porcentajes o con las notas, retorne -1.
     */

    public static float Calcular_definitiva(float n1, float n2, float n3, float n4, float n5, float por_n1, float por_n2, float por_n3, float por_n4, float por_n5 ){
        try {
            float definitiva = 0;
            final byte SUM_TOTAL = 1;
            final byte NOTA_MAX = 5;
            final byte NOTA_MIN = 0;
            final byte POR_MAX = 1;
            final byte POR_MIN = 0;

            float suma_porcentajes = por_n1 + por_n2 + por_n3 + por_n4 + por_n5;
            if (suma_porcentajes != SUM_TOTAL) return -1;

            float[] lista_notas = {n1, n2, n3, n4, n5};
            float[] lista_porcentajes = {por_n1, por_n2, por_n3, por_n4, por_n5};

            // Validar rangos de notas y porcentajes
            for (int i = 0; i < lista_notas.length; i++) {
                if (lista_notas[i] < NOTA_MIN || lista_notas[i] > NOTA_MAX ||
                    lista_porcentajes[i] < POR_MIN || lista_porcentajes[i] > POR_MAX) return -1;
            }

            // Calcular definitiva
            for (int i = 0; i < lista_notas.length; i++){
                definitiva += lista_notas[i] * lista_porcentajes[i];
            }

            return definitiva;

        } catch (Exception e) {
            return -1;
        }
    }



    /*
     * 5. Diseñe un algoritmo e implemente la función Calcular_para_ganar que
     * reciba cinco floats representando los porcentajes de una materia (que
     * deberán sumar 1 y estar entre 0 y 1) y cuatro floats representando las
     * primeras notas (entre 0 y 5), y devuelva un float que represente la
     * nota que deberá sacar para ganar si el puntaje mínimo es 3. Si algo
     * está mal con los porcentajes o con las notas, retorne -1.
     */

    public static float Calcular_para_ganar(float n1, float n2, float n3, float n4, float por_n1, float por_n2, float por_n3, float por_n4, float por_n5){
        try {
            float nota_necesaria = 0;

            final byte SUM_TOTAL = 1;
            final byte NOTA_MAX = 5;
            final byte NOTA_MIN = 0;
            final byte POR_MAX = 1;
            final byte POR_MIN = 0;
            final byte NOTA_MIN_GANAR = 3;

            float suma_porcentajes = por_n1 + por_n2 + por_n3 + por_n4 + por_n5;
            if (suma_porcentajes != SUM_TOTAL) return -1;

            float[] lista_notas = {n1, n2, n3, n4};
            float[] lista_porcentajes = {por_n1, por_n2, por_n3, por_n4, por_n5};

            // validar notas
            for (int i = 0; i < lista_notas.length; i++) {
                if (lista_notas[i] < NOTA_MIN || lista_notas[i] > NOTA_MAX) return -1;
            }

            // validar porcentajes
            for (int i = 0; i < lista_porcentajes.length; i++) {
                if (lista_porcentajes[i] < POR_MIN || lista_porcentajes[i] > POR_MAX) return -1;
            }

            // calcular nota
            for (int i = 0; i < lista_notas.length; i++) {
                nota_necesaria += lista_notas[i] * lista_porcentajes[i];
            }
            nota_necesaria = (NOTA_MIN_GANAR - nota_necesaria) / por_n5;
            return  nota_necesaria;

        } catch (Exception e) {
            return 0;
        }
    }


    /*
     * 6. Diseñe un algoritmo e implemente la función Calcular_salario que
     * reciba cuatro enteros: cantidad de horas normales laboradas, cantidad
     * de horas extras diurnas laboradas, cantidad de horas extras nocturnas
     * laboradas, y el valor de la hora normal como un float. La función debe
     * retornar un float con el salario total. Las horas extras diurnas tienen
     * un recargo adicional del 15% sobre la hora normal, y las horas extras
     * nocturnas tienen un recargo adicional del 35% sobre la hora normal.
     * 
     * Valide que el valor de la hora normal sea mayor a 0. Si no es así, retorne
     * -1.
     * 
     * Si hay algún error, retorne -1.
     */

    public static float Calcular_salario(int horas_normales, int horas_ext_diurnas, int horas_ext_nocturnas, float valor_hora){
        try {
            final byte CERO = 0;
            if (valor_hora <= CERO) return -1;

            float salario_total;
            final float VALOR_EXTRA_DIURNA = (valor_hora * ((float) 15 / 100));
            final float VALOR_EXTRA_NOCTURNA = (valor_hora * ((float) 35 / 100));;

            salario_total = horas_normales*valor_hora + horas_ext_diurnas*VALOR_EXTRA_DIURNA + horas_ext_nocturnas*VALOR_EXTRA_NOCTURNA;
            return salario_total;

        } catch (Exception e) {
            return -1;
        }
    }


    /*
     * 7. Diseñe un algoritmo e implemente la función Calcular_area_triangulo
     * que reciba dos floats representando la base y la altura de un triángulo
     * rectángulo, y devuelva un float que represente el área del triángulo.
     * 
     * Valide que la base y la altura sean mayores a 0. Si no es así, retorne -1.
     * 
     * La fórmula del área es: área = 1/2 * base * altura.
     * 
     * Si hay algún error, retorne -1.
     */

    public static float Calcular_area_triangulo(float base, float altura){
        try {
            final byte MIN = 0;
            if (base <= MIN || altura <= MIN) return -1;

            float area;
            final byte DOS = 2;

            area = (base * altura) / DOS;
            return area;
        } catch (Exception e) {
            return -1;
        }

    }



    /*
     * 8. Diseñe un algoritmo e implemente la función Calcular_perimetro_cuadrado
     * que reciba un float representando el lado de un cuadrado, y devuelva un
     * float que represente el perímetro del cuadrado.
     * 
     * Valide que el lado sea mayor a 0. Si no es así, retorne -1.
     * 
     * La fórmula del perímetro es: perímetro = lado * 4.
     * 
     * Si hay algún error, retorne -1.
     */

    public static float Calcular_perimetro_cuadrado(float lado){
        try {
            final byte MIN = 0;
            if (lado <= MIN) return -1;

            float perimetro;
            final byte NUMERO_LADOS = 4;

            perimetro = lado * NUMERO_LADOS;
            return perimetro;
        } catch (Exception e) {
            return -1;
        }
    }


    /*
     * 9. Diseñe un algoritmo e implemente la función Calcular_volumen_cilindro
     * que reciba dos floats representando el radio de la base y la altura de
     * un cilindro, y devuelva un float que represente el volumen del cilindro.
     * 
     * Valide que el radio y la altura sean mayores a 0. Si no es así, retorne -1.
     * 
     * La fórmula del volumen es: V = pi * radio^2 * altura, usando pi con
     * precisión de 7 decimales (3.1415927).
     * 
     * Si hay algún error, retorne -1.
     */

    public static float Calcular_volumen_cilindro(float radio_base, float altura){
        try {
            final byte CERO = 0;
            final byte DOS = 2;
            if (radio_base <= CERO || altura <= CERO) return -1;

            final float PI = (float) Math.PI;
            float volumen = (float) ( PI * Math.pow(radio_base, DOS) * altura );

            return volumen;
        } catch (Exception e) {
            return -1;
        }
    }





    /*
     * 10. Diseñe un algoritmo e implemente la función Calcular_area_circulo
     * que reciba un float representando el radio de un círculo, y devuelva un
     * float que represente el área del círculo.
     * 
     * Valide que el radio sea mayor a 0. Si no es así, retorne -1.
     * 
     * La fórmula del área es: área = pi * radio^2, usando pi con precisión
     * de 7 decimales (3.1415927).
     * 
     * Si hay algún error, retorne -1.
     */

    public static float Calcular_area_circulo(float radio){
        try {
            final byte CERO = 0;
            if (radio <= CERO) return -1;

            final float PI = (float) Math.PI;
            float area = (float) (PI * Math.pow(radio, 2));

            return area;
        } catch (Exception e) {
            return -1;
        }
    }




}

