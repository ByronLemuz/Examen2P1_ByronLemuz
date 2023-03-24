/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2p1_byronlemuz;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author lesly
 */
public class Libreria {
    private ArrayList<String > titulos;
    private ArrayList<String > autores;

    public Libreria() {
        titulos = new ArrayList<String>();
        autores = new ArrayList<String>();
    }

    public void agregarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el nombre del autor: ");
        String autor = scanner.nextLine();
        titulos.add(titulo);
        autores.add(autor);
        System.out.println("El libro se ha agregado correctamente.");
    }

    public void eliminarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el índice del libro que desea eliminar: ");
        int indice = scanner.nextInt();
        if (indice >= 0 && indice < titulos.size()) {
            titulos.remove(indice);
            autores.remove(indice);
            System.out.println("El libro se ha eliminado correctamente.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void listarLibros() {
        if (titulos.size() == 0) {
            System.out.println("No hay libros en inventario.");
        } else {
            for (int i = 0; i < titulos.size(); i++) {
                System.out.println("Libro " + (i + 1));
                System.out.println("Título: " + titulos.get(i));
                System.out.println("Autor: " + autores.get(i));
                System.out.println();
            }
        }
    }

    public void buscarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        int indice = titulos.indexOf(titulo);
        if (indice >= 0) {
            System.out.println("El libro está en inventario.");
        } else {
            System.out.println("Lo sentimos, el libro no está en inventario.");
        }
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("Librería");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Listar");
            System.out.println("4. Buscar por título");
            System.out.println("5. Regresar al menú");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    eliminarLibro();
                    break;
                case 3:
                    listarLibros();
                    break;
                case 4:
                    buscarLibro();
                    break;
                case 5:
                    System.out.println("Saliendo del menú.");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
            System.out.println();
        }
    }
}



