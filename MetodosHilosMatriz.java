/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilosmatriz;

/**
 *
 * @author alexa
 */
public class MetodosHilosMatriz extends Thread {

    public int indice;
    public int[][] X;
    public int sumaFila;
    public int sumaTotal;

    public MetodosHilosMatriz() {
    }

    public MetodosHilosMatriz(int indice, int[][] X) {
        this.indice = indice;
        this.X = X;
        this.sumaFila = 0;
    }

    public int getSumaFilas() {
        return sumaFila;
    }
    
    public int getSumaTotal() {
        return sumaTotal;
    }

    public void llenarMatriz(int[][] X) {
        for (int i = 0; i < X.length; i++) {
            for (int j = 0; j < X[0].length; j++) {
                X[i][j] = (int) (Math.random() * 100 + 1);
            }
        }
    }

//    public void presentarMatriz(int[][] X) {
//        for (int i = 0; i < X.length; i++) {
//            for (int j = 0; j < X[0].length; j++) {
//                System.out.println(X[i][j]);
//            }
//        }
//    }

    @Override
    public void run() {
        for (int j = 0; j < X[0].length; j++) {
            sumaFila += X[indice][j];
            sumaTotal += sumaFila;
        }
    }

}
