/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2p1_byronlemuz;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lesly
 */
public class Gusanito {
    private ArrayList<String> instrucciones;
    private char[][] tablero;
    private int gusX, gusY, manX, manY;

    public Gusanito(int N, int M) {
        if (N < 4 || N > 10 || M < 4 || M > 10) {
            throw new IllegalArgumentException("Las dimensiones del tablero deben estar entre 4 y 10.");
        }
        this.tablero = new char[N][M];
        this.instrucciones = new ArrayList<>();
        Random rand = new Random();
        this.gusX = rand.nextInt(N);
        this.gusY = rand.nextInt(M);
        do {
            this.manX = rand.nextInt(N);
            this.manY = rand.nextInt(M);
        } while (this.manX == this.gusX && this.manY == this.gusY);
        // Inicializar el tablero con espacios vacíos y colocar al gusanito y la manzana
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == this.gusX && j == this.gusY) {
                    this.tablero[i][j] = '§';
                } else if (i == this.manX && j == this.manY) {
                    this.tablero[i][j] = 'Ó';
                } else {
                    this.tablero[i][j] = ' ';
                }
            }
        }
    }

    Gusanito() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void agregarInstruccion(String instruccion) {
        this.instrucciones.add(instruccion);
    }
    public void mover() {
    Scanner scanner = new Scanner(System.in);
    String respuesta = "s";
    while (respuesta.equals("s")) {
        System.out.print("Ingrese una instrucción: ");
        String instruccion = scanner.nextLine().toUpperCase();
        ejecutarInstruccion(instruccion);
        imprimirTablero();
        if (gusX == manX && gusY == manY) {
            System.out.println("¡Lograste llegar a la manzana!");
            break;
        }
        System.out.print("¿Desea ingresar otra instrucción? [s/n]: ");
        respuesta = scanner.nextLine();
    }
}

public void ejecutarInstruccion(String instruccion) {
    int magnitud = Integer.parseInt(instruccion.substring(0, instruccion.length() - 2));
    char direccion = instruccion.charAt(instruccion.length() - 2);
    switch (direccion) {
        case 'U':
            moverArriba(magnitud);
            break;
        case 'D':
            moverAbajo(magnitud);
            break;
        case 'R':
            moverDerecha(magnitud);
            break;
        case 'L':
            moverIzquierda(magnitud);
            break;
        default:
            System.out.println("Instrucción no válida.");
            break;
    }
}

public void imprimirTablero() {
    for (char[] fila : tablero) {
        for (char celda : fila) {
            System.out.print("[" + celda + "]");
        }
        System.out.println();
    }
}

// métodos de movimiento del gusanito

public void moverArriba(int n) {
    int nuevaPosicion = gusY - n;
    if (nuevaPosicion < 0) {
        nuevaPosicion = 0;
    }
    for (int i = gusY; i > nuevaPosicion; i--) {
        tablero[i][gusX] = '§';
        tablero[i-1][gusX] = ' ';
    }
    gusY = nuevaPosicion;
}

public void moverAbajo(int n) {
    int nuevaPosicion = gusY + n;
    if (nuevaPosicion >= tablero.length) {
        nuevaPosicion = tablero.length - 1;
    }
    for (int i = gusY; i < nuevaPosicion; i++) {
        tablero[i][gusX] = '§';
        tablero[i+1][gusX] = ' ';
    }
    gusY = nuevaPosicion;
}

public void moverDerecha(int n) {
    int nuevaPosicion = gusX + n;
    if (nuevaPosicion >= tablero[0].length) {
        nuevaPosicion = tablero[0].length - 1;
    }
    for (int i = gusX; i < nuevaPosicion; i++) {
        tablero[gusY][i] = '§';
        tablero[gusY][i+1] = ' ';
    }
    gusX = nuevaPosicion;
}

public void moverIzquierda(int n) {
    int nuevaPosicion = gusX - n;
    if (nuevaPosicion < 0) {
        nuevaPosicion = 0;
    }
    for (int i = gusX; i > nuevaPosicion; i--) {
        tablero[gusY][i] = '§';
        tablero[gusY][i-1] = ' ';
    }
    gusX = nuevaPosicion;
}

    void ejecutarinstruccion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
