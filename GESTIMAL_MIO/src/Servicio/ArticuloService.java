package Servicio;

import Almacen.Articulo;


import java.util.ArrayList;
import java.util.Scanner;

public class ArticuloService {
    private Scanner sc;
    private ArrayList<Articulo> articulos = new ArrayList<>();
    private Articulo articulo;
    public ArticuloService(){
        sc = new Scanner(System.in);
        articulos =new ArrayList<>();
    }

    public void menu(){
        char opcion;
        do {
            System.out.println("\n--- MENÚ DE GESTIÓN DE ALMACÉN ---");
            System.out.println("1. Listado de artículos");
            System.out.println("2. Alta de artículo");
            System.out.println("3. Baja de artículo");
            System.out.println("4. Modificar artículo");
            System.out.println("5. Entrada de mercancía");
            System.out.println("6. Salida de mercancía");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.next().charAt(0);
            sc.nextLine();

            switch (opcion){
                case '1' -> listarArticulos();
                case '2' -> crearArticulo();
                case '3' -> eliminarArticulo();
                case '4' -> modificarArticulo();
                case '5' -> entradaDeMercancia();
                case '6' -> salidaDeMercancia();
             default -> {
                    opcion = '7';
                System.out.println(" GRACIAS POR USAR EL PROGRAMA");
                }
            }
            }while(opcion!='7');
        }
    public void listarArticulos(){
        if(articulos.isEmpty()){
            System.out.println(" No hay articulos :( ");
        }else {
            for (Articulo articulo : articulos) {
                System.out.println(articulo);
            }
        }
    }

    public void crearArticulo(){
        System.out.print(" ESTAS CREANDO TU ARTICULO ");
        System.out.println(" Codigo: ");
        String codigo = sc.nextLine();
        System.out.println(" Descripcion: ");
        String descripcion = sc.nextLine();
        System.out.println(" Precio de compra: ");
        double compra = sc.nextDouble();
        System.out.println(" Precio de venta: ");
        double venta = sc.nextDouble();
        System.out.println(" # de stock ");
        int stock = sc.nextInt();

        articulos.add(new Articulo(codigo,descripcion,compra,venta,stock));
    }
    private int buscarArticulo() {
        System.out.print(" Ingrese el articulo para modificar: ");
        String modificar = sc.next();
        Articulo articuloEncontrado = null;
        for (Articulo articulo : articulos) {
            if (articulo.getCodigo().equals(modificar)) {
                articuloEncontrado = articulo;
                break;
            }
        }
        return articulos.indexOf(articuloEncontrado);
    }
    public void modificarArticulo(){
        System.out.println(" Modificar Articulo: ");
        int posicion = buscarArticulo();
        if (posicion != -1 ){
        articulo =articulos.get(posicion);
            System.out.println("Ingrese el Codigo nuevo: ");
            articulo.setCodigo(sc.next());
            System.out.println("Ingrese la descripcion nueva: ");
            String descripcion = sc.next();
            articulo.setDescripcion(descripcion);
            System.out.println("Ingrese su precio de compra nuevo: ");
            double compra = sc.nextDouble();
            articulo.setCompra(compra);
            System.out.println("Ingrese su precio de venta nuevo: ");
            double venta = sc.nextDouble();
            articulo.setVenta(venta);
            System.out.println("Ingrese su nuevo # de stock: ");
            int stock = sc.nextInt();
            articulo.setStock(stock);
            articulos.set(posicion,articulo);
        }
    }
    public void eliminarArticulo(){
        System.out.println(" Eliminar Articulo: ");
        int posicion = buscarArticulo();
        if (posicion != -1 ){
            articulos.remove(posicion);
            System.out.println(" Se elimino el articulo correctamente ");
        } else {
            System.out.println(" No se encontro el articulo");
        }
    }
    public void entradaDeMercancia(){

       int posicion = buscarArticulo();
       if (posicion != -1){
           articulo = articulos.get(posicion);
           System.out.println(" Ingresa cuanto mas quieres agregar: ");
           int cantidad = sc.nextInt();
           if (cantidad > 0){
               articulo.setStock(articulo.getStock()+cantidad);
               System.out.println(" La cantidad nueva es de: " + articulo.getStock());
           }
       }

    }
    public void salidaDeMercancia(){
        int posicion = buscarArticulo();
        if (posicion != -1){
            articulo = articulos.get(posicion);
            System.out.println(" Cuantos quieres? : ");
            int cantidad = sc.nextInt();
            if (cantidad > 0 && cantidad <= articulo.getStock()){
                articulo.setStock(articulo.getStock()-cantidad);
                System.out.println(" La cantidad nueva es de: " + articulo.getStock());
            } else {
                System.out.println(" No hay suficientes para llevarte =) ");
            }
        }
    }






}

