/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hilosmatriz;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexa
 */
public class HilosMatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int matriz[][] = new int[4][10000];
        int numeroHilos = 4;
        List<MetodosHilosMatriz> hilos = new ArrayList<>();
        MetodosHilosMatriz obj = new MetodosHilosMatriz();

        obj.llenarMatriz(matriz);
        for (int i = 0; i < numeroHilos; i++) {
            int hiloIndice = i;
            hilos.add(new MetodosHilosMatriz(hiloIndice, matriz));
        }

        for (MetodosHilosMatriz hilo : hilos) {
            hilo.start();
        }

        for (MetodosHilosMatriz hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int totalFilas;
        int totalMatriz = 0;
        for (MetodosHilosMatriz hilo : hilos) {
            totalFilas = hilo.getSumaFilas();
            totalMatriz += hilo.getSumaTotal();
            System.out.println("El total de la fila " +hilo.getName()+ " es: " + totalFilas);
        }

        System.out.println("El total de la matriz es: " + totalMatriz);
    }

}
