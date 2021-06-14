package src;

import java.util.Scanner;

public class Practica2{
    //CLIENTES
    String[] nombreClientes = new String[1000];
    int[] idClientes = new int[1000];
    int[] telefono = new int[1000];
    boolean[] tienePeliculaPrestado = new boolean[1000];
    int cantidadClientes = 0;

    //PELIS
    int[] idPelis = new int[1000];
    String[] nombrePelis = new String[1000];
    int[] year = new int[100];
    String[] categoria = new String[1000];
    boolean[] disponible = new boolean[1000];
    int[] vecesPrestada = new int[1000];
    int cantidadPelis = 0;

    //PRESTAMO DE PELICULAS
    int[] idClienteP = new int[1000];
    String[] nombreClienteP = new String[1000];
    int[] idPelisP = new int[1000];
    String[] nombrePeliP = new String[1000];
    int[] diasPrestado = new int[1000];
    int cantidadPelisPrestadas = 0;

    //REPORTES
    String[] categoriaSinRepetir = new String [1000];
    int[] cantidadCategoriassinRepetir = new int[1000];
    int cantidadCategoriaSinRepetir = 0;


    Scanner leer = new Scanner(System.in);

    public static void main (String[] args){
        Practica2 practica = new Practica2();
    }

    public Practica2(){
        bienvenida();
        menu();
        
    }

    public void bienvenida(){
        System.out.println("");
        System.out.println("Bienvenido al programa de “Memorabilia”.");
        System.out.println("Un programa desarrollado para el control de las peliculas que tenemos en alquier");
        System.out.println("Esperemos que como usuario difrutes como es y muestranos tu opinion en tz********@gmail.com");
        System.out.println(" :3 ");
        System.out.println("");
    }

    public void menu(){

        int opcion;
        do{
            System.out.println("");
            System.out.println("__________________MENU__________________________________________________________");
            System.out.println(" 1) Préstamo de películas");
            System.out.println(" 2) Devolución de películas");
            System.out.println(" 3) Mostrar las películas");
            System.out.println(" 4) Ordenar las películas de forma ascendente");
            System.out.println(" 5) Ingreso de Películas");
            System.out.println(" 6) Ordenar las películas de forma descendente");
            System.out.println(" 7) Ingresar clientes nuevos");
            System.out.println(" 8) Mostrar clientes");
            System.out.println(" 9) Reportes");
            System.out.println("10) Salir");
            System.out.println("");
            opcion = getInt("Ingresa la opcion que deseas");
            switch(opcion){
                case 1:
                    prestamoPelis();
                    break;
                case 2:
                    devolucionPelis();
                    break;
                case 3:
                    if(this.cantidadPelis > 0){
                        mostrarPelisAscendente();
                    }
                    else{
                        System.out.println("No hay ninguna pelicula para mostrar");
                    }
                    break;
                case 4:
                    if(this.cantidadPelis > 1){
                        int pick = getIntRango("Ordenar por id (1) o alfabeticamente (2) ", 2, 1);
                        if(pick == 1){
                            ordenarPelis();
                            System.out.println("Se ha ordenado ascendentemente las peliculas segun el id");
                        }
                        else{
                            ordenarPelisAlfabeticamenteDescendente();
                            System.out.println("Se ha ordenado ascendentemente las peliculas segun el orden alfabetico");
                        }
                        
                        
                    }
                    else{
                        System.out.println("No hay suficientes peliculas para ordenarlas");
                    }
                    
                    break;
                case 5:
                    System.out.println("");
                    ingresoPelis();               
                    break;
                case 6:
                    if(this.cantidadPelis > 1){
                        int pick = getIntRango("Ordenar por id (1) o alfabeticamente (2) ", 2, 1);
                        if(pick == 1){
                            ordenarPelisDescendente();
                            System.out.println("Se ha ordenado descendentemente las peliculas segun el id");
                        }
                        else if(pick == 2){
                            ordenarPelisAlfabeticamente();
                            System.out.println("Se ha ordenado descendentemente las peliculas segun el orden alfabetico");
                        }
                        
                    }
                    else{
                        System.out.println("No hay suficientes peliculas para ordenarlas");
                    }
                    
                    break;
                case 7:
                    System.out.println("");
                    ingresarClientes();

                    break;
                case 8:
                    if(this.cantidadClientes > 0){
                        mostrarClientes(cantidadClientes, nombreClientes, idClientes, telefono, tienePeliculaPrestado);
                    }
                    else{
                        System.out.println("No hay ningun cliente que mostrar");
                    }
                    break;
                case 9:
                    reportes();
                    break;
                case 10:
                    System.exit(0);
                    break;
            }
        } while(true);

    }
    
    public void prestamoPelis(){
        System.out.println("");
        if(cantidadPelis > 0){
            boolean encontrado = false;
            boolean encontrado1 = false;
            mostrarArreglos(nombrePelis, idPelis, cantidadPelis, "Peliculas Disponibles________________", disponible);
            int idPeli = getInt("Ingresar el id de la pelicula");
            int idCliente = getInt("Ingresar el id del cliente");;
            int diasPrestamo = getInt("Ingresar los dias que prestará la pelicula");
    
            for (int i = 0; i < cantidadPelis; i++) {
                if(idPelis[i] == idPeli){
                    disponible[i] = false;
                    nombrePeliP[cantidadPelisPrestadas] = nombrePelis[i];
                    vecesPrestada[i]++;
                    encontrado = true;
                    break;
                }
            }
    
            for (int i = 0; i < cantidadClientes; i++) {
                if(idCliente == idClientes[i]){
                    tienePeliculaPrestado[i] = true;
                    nombreClienteP[cantidadPelisPrestadas] = nombreClientes[i];

                    encontrado1 = true;
                    break;
                }
            }
    
            if(encontrado && encontrado1){
                idClienteP[cantidadPelisPrestadas] = idCliente;
                idPelisP[cantidadPelisPrestadas] = idPeli;
                diasPrestado[cantidadPelisPrestadas] = diasPrestamo;
    
                cantidadPelisPrestadas++;
    
                System.out.println("Se ha prestado la pelicula con exito");
                encontrado = false;
                encontrado1 = false;
            }
            else{
                System.out.println("No se ha encontrado la pelicula buscada, porfavor verifica que se ingreso bien los datos solicitados");
            }
        }

        else{
            System.out.println("No hay ni una película registrada en el programa, usa la opcion de ingresar peliculas");
        }
        
    }

    public void devolucionPelis(){
        if(cantidadPelisPrestadas > 0){
            int aux;
            boolean encontrado = false;
            mostrarPelisClientes(nombrePeliP, nombreClienteP, cantidadPelisPrestadas, "Peliculas Prestadas________________");
            int idPeli = getInt("Ingresar el id de la pelicula");

    
            for (int i = 0; i < cantidadPelisPrestadas; i++) {
                if(idPelis[i] == idPeli){
                    disponible[i] = true;
                    encontrado = true;
                    break;
                }
            }
            if(encontrado){
                
                for (int i = 0; i < cantidadPelisPrestadas; i++) {
                    if(i >= (idPeli-1)){
                        idPelisP[i] = idPelisP[i+1];
                        idClienteP[i] = idClienteP[i+1];
                        nombreClienteP[i] = nombreClienteP[i+1];
                        diasPrestado[i] = diasPrestado[i+1];
                        nombrePeliP[i] = nombrePeliP[i+1];

                    }   
                }

                cantidadPelisPrestadas--;
    
                System.out.println("Se ha devuelto la pelicula con exito");
                encontrado = false;
            }
            else{
                System.out.println("No se ha encontrado la pelicula buscada, porfavor verifica que se ingreso bien los datos solicitados");
            }
        }
        
        else{
            System.out.println("No hay ni una película prestada en el programa, usa la opcion de prestar peliculas");
        }
    }

    public void mostrarArreglos(int[] arreglo, int length, String titulo, boolean[] disponible){
        if(length>0){
            System.out.println(titulo);
            System.out.println("");
            for (int i = 0; i < length; i++) {
                if(disponible[i]){
                    System.out.println((i+1)+") "+arreglo[i]);
                }
            }
            System.out.println("");
        }
        else{
            System.out.println("No hay ni una película registrada en el programa, usa la opcion de ingresar peliculas");
        }
    }

    public void mostrarPelisClientes(String[] arreglo, String[] arreglo1, int length, String titulo){
        if(length > 0){
            System.out.println(titulo);
            System.out.println("");
            System.out.println("No\tCliente\t\t\tPeli\t\t");
            for (int i = 0; i < length; i++) {
                System.out.println((i+1)+")\t"+arreglo1[i] + "\t\t" + arreglo[i]+"\t"+idPelis[i]);
            }
            System.out.println("");
        }
        
        else{
            System.out.println("No hay ni una película registrada en el programa, usa la opcion de ingresar peliculas");
        }
    }

    public void mostrarArreglos(String[] arreglo, int[] arreglo1, int length, String titulo, boolean[] disponible){
        System.out.println(titulo);
        System.out.println("");
        System.out.println("No\tid\tNombre\t\t\tAño Emisión\tCategoría");
        for (int i = 0; i < length; i++) {
            if(disponible[i]){
                System.out.println((i+1)+")\t"+arreglo1[i] + "\t" + arreglo[i] +"\t\t"+ year[i] + "\t"+ categoria[i]);
            }
        }
    }

    public void mostrarClientes(int cantidadClientes, String[] nombreClientes, int[] idCliente, int[] telefono, boolean[] tienePeliculaPrestado){
        if(cantidadClientes > 0){
            String tiene = "";
            System.out.println("Clientes ____________________________");
            System.out.println("");
            System.out.println("No\tid\tNombre\t\t\tTelefono\tTiene Películas Prestadas");
            for (int i = 0; i < cantidadClientes; i++) {
                if(tienePeliculaPrestado[i]){
                    tiene = " SI ";
                }
                else{
                    tiene = " NO ";
                }
                System.out.println((i+1)+")\t" + idCliente[i] + "\t\t\t" + nombreClientes[i] + "\t" + telefono[i] + "\t" + tiene);
            }
        }

        else{
            System.out.println("No hay ningun cliente ingresado, use la opcion de ingresar cliente");
        }
    }

    public void ingresoPelis(){
        boolean mismoId = false;
        String nombrePeli = getStringNumeros("Ingrese el nombre de la película");
        int id = getInt("Ingrese el id de la película");
        int anio = getInt("Ingrese el año de la película");
        String cate = getString("Ingrese la categoría de la película");

        if(cantidadPelis > 0){
            for (int i = 0; i < cantidadPelis; i++) {
                if(id == idPelis[i]){
                    mismoId = true;
                    break;
                }
            }
        }
        
        if(mismoId == false){
            nombrePelis[cantidadPelis] = nombrePeli;
            idPelis[cantidadPelis] = id;
            year[cantidadPelis] = anio;
            categoria[cantidadPelis] = cate;
            disponible[cantidadPelis] = true;
            vecesPrestada[cantidadPelis] = 0;
            contarCategoria(cate);
            cantidadPelis++;
            System.out.println("");
            System.out.println("Ingreso de la película con exito");
        }
        else{
            mismoId = false;
            System.out.println("Se ha encontrado que el id que intentas usar lo posee otra pelicula, ingresa un id diferente");
        }
        
        System.out.println("");

    }

    public void contarCategoria(String categoria){
        boolean encontrado = false;
        for (int i = 0; i < cantidadCategoriaSinRepetir; i++) {
            if(categoria.equals(categoriaSinRepetir[i])){
                cantidadCategoriassinRepetir[i] += 1;
                encontrado = true;
                break;
            }
        }

        if(!encontrado){
            categoriaSinRepetir[cantidadCategoriaSinRepetir] = categoria;
            cantidadCategoriassinRepetir[cantidadCategoriaSinRepetir] = 1;
            cantidadCategoriaSinRepetir++;
        }
        
    }

    //  METODO BURBUJA
    public void ordenarPelis(){
        int aux;
        String aux0;
        int aux1;
        String aux2;
        boolean aux3;
        int aux4;
        
        for (int i = 0; i < (cantidadPelis - 1); i++) {
            for (int j = 0; j < (cantidadPelis - 1); j++) {
                if(idPelis[j] > idPelis[j+1]){
                    aux = idPelis[j];
                    idPelis[j] = idPelis[j+1];
                    idPelis[j+1] = aux;

                    aux0 = nombrePelis[j];
                    nombrePelis[j] = nombrePelis[j+1];
                    nombrePelis[j+1] = aux0;

                    aux1 = year[j];
                    year[j] = year[j+1];
                    year[j+1] = aux1;

                    aux2 = categoria[j];
                    categoria[j] = categoria[j+1];
                    categoria[j+1] = aux2;

                    aux3 = disponible[j];
                    disponible[j] = disponible[j+1];
                    disponible[j+1] = aux3;

                    aux4 = vecesPrestada[j];
                    vecesPrestada[j] = vecesPrestada[j+1];
                    vecesPrestada[j+1] = aux4;
                }
            }
        }
        
    }

    public void ordenarPelisDescendente(){
        int aux;
        String aux0;
        int aux1;
        String aux2;
        boolean aux3;
        int aux4;
        
        for (int i = 0; i < (cantidadPelis - 1); i++) {
            for (int j = 0; j < (cantidadPelis - 1); j++) {
                if(idPelis[j] < idPelis[j+1]){
                    aux = idPelis[j];
                    idPelis[j] = idPelis[j+1];
                    idPelis[j+1] = aux;

                    aux0 = nombrePelis[j];
                    nombrePelis[j] = nombrePelis[j+1];
                    nombrePelis[j+1] = aux0;

                    aux1 = year[j];
                    year[j] = year[j+1];
                    year[j+1] = aux1;

                    aux2 = categoria[j];
                    categoria[j] = categoria[j+1];
                    categoria[j+1] = aux2;

                    aux3 = disponible[j];
                    disponible[j] = disponible[j+1];
                    disponible[j+1] = aux3;

                    aux4 = vecesPrestada[j];
                    vecesPrestada[j] = vecesPrestada[j+1];
                    vecesPrestada[j+1] = aux4;
                }
            }
        }
        
    }

    public void ordenarPelisAlfabeticamente(){
        int aux;
        String aux0;
        int aux1;
        String aux2;
        boolean aux3;
        int aux4;
        
        for (int i = 0; i < (cantidadPelis - 1); i++) {
            for (int j = 0; j < (cantidadPelis - 1); j++) {

                if(nombrePelis[j].compareTo(nombrePelis[j+1]) < 0){
                    aux = idPelis[j];
                    idPelis[j] = idPelis[j+1];
                    idPelis[j+1] = aux;

                    aux0 = nombrePelis[j];
                    nombrePelis[j] = nombrePelis[j+1];
                    nombrePelis[j+1] = aux0;

                    aux1 = year[j];
                    year[j] = year[j+1];
                    year[j+1] = aux1;

                    aux2 = categoria[j];
                    categoria[j] = categoria[j+1];
                    categoria[j+1] = aux2;

                    aux3 = disponible[j];
                    disponible[j] = disponible[j+1];
                    disponible[j+1] = aux3;

                    aux4 = vecesPrestada[j];
                    vecesPrestada[j] = vecesPrestada[j+1];
                    vecesPrestada[j+1] = aux4;
                }
            }
        }
        
    }
    
    public void ordenarPelisAlfabeticamenteDescendente(){
        int aux;
        String aux0;
        int aux1;
        String aux2;
        boolean aux3;
        int aux4;
        
        for (int i = 0; i < (cantidadPelis - 1); i++) {
            for (int j = 0; j < (cantidadPelis - 1); j++) {

                if(nombrePelis[j].compareTo(nombrePelis[j+1]) > 0){
                    aux = idPelis[j];
                    idPelis[j] = idPelis[j+1];
                    idPelis[j+1] = aux;

                    aux0 = nombrePelis[j];
                    nombrePelis[j] = nombrePelis[j+1];
                    nombrePelis[j+1] = aux0;

                    aux1 = year[j];
                    year[j] = year[j+1];
                    year[j+1] = aux1;

                    aux2 = categoria[j];
                    categoria[j] = categoria[j+1];
                    categoria[j+1] = aux2;

                    aux3 = disponible[j];
                    disponible[j] = disponible[j+1];
                    disponible[j+1] = aux3;

                    aux4 = vecesPrestada[j];
                    vecesPrestada[j] = vecesPrestada[j+1];
                    vecesPrestada[j+1] = aux4;
                }
            }
        }
        
    }
    //

    public void mostrarPelisAscendente(){
        if(cantidadPelis > 0){
            String disponibilidad = "";
            System.out.println("ID\t\tNombre Peli\t\t\tAño\t\tCategoría\t\tDisponible");
            for (int i = 0; i <cantidadPelis; i++) {
                if(disponible[i]){
                    disponibilidad = "SI";
                }
                else{
                    disponibilidad = "NO";
                }
                System.out.print(idPelis[i] + "\t|\t" + nombrePelis[i] + "\t|\t" + year[i] + "\t|\t" + categoria[i] + "\t|\t" + disponibilidad+"\n");
            }
            System.out.println("");
        }

        else{
            System.out.println("No hay ninguna pelicula para mostrar, use la opcion ingresar películas");
        }
    }

    public void mostrarPelisDescendente(int cantidadPelis, int[] idPelis, String[] nombrePelis, int[] year, String[] categoria, boolean[] disponible){
        String disponibilidad = "";
        for (int i = (cantidadPelis - 1); i >= 0; i--) {
            if(disponible[i]){
                disponibilidad = "SI";
            }
            else{
                disponibilidad = "NO";
            }
            System.out.print(idPelis[i] + "\t|\t" + nombrePelis[i] + "\t|\t" + year[i] + "\t|\t" + categoria[i] + "\t|\t" + disponibilidad);
        }
    }

    public void ingresarClientes(){
        boolean mismoId = false;
        String nombreCliente = getString("Ingrese el nombre del cliente");
        int id = getInt("Ingrese el id del cliente");
        int cel = getInt("Ingrese el telefono del cliente");

        for (int i = 0; i < cantidadClientes; i++) {
            if(id == idClientes[i]){
                mismoId = true;
            }
        }

        if(!mismoId){
            nombreClientes[cantidadClientes] = nombreCliente;
            idClientes[cantidadClientes] = id;
            telefono[cantidadClientes] = cel;
            tienePeliculaPrestado[cantidadClientes] = false;
            cantidadClientes++;
        }
        else{
            mismoId = false;
            System.out.println("Se ha encontrado que el id que intentas usar lo posee otra pelicula, ingresa un id diferente");
        }
        
    }

    public void reportes(){
        int opcion;
        do{
            System.out.println("");
            System.out.println("__________________REPORTES__________________________________________________________");
            System.out.println("1) Cantidad de películas por categoría");
            System.out.println("2) Las películas de una categoría en específico");
            System.out.println("3) Reporte de las películas y la cantidad de veces que se presta");
            System.out.println("4) Reporte de la película más prestada");
            System.out.println("5) Reporte de la película menos prestada");
            System.out.println("6) Regresar al menu");
            System.out.println("");
            opcion = getIntRango("Ingresa la opcion que deseas",1);
            switch(opcion){
                case 1:
                    cantidadPelisCategoria();
                    break;
                case 2:
                    peliculasPorCategoria(cantidadPelis, idPelis, nombrePelis, year, categoria, disponible, vecesPrestada);
                    break;
                case 3:
                    peliculasVecesPrestada(cantidadPelis, idPelis, nombrePelis, year, categoria, disponible, vecesPrestada);
                    break;
                case 4:
                    peliculasMasPrestada(cantidadPelis, idPelis, nombrePelis, year, categoria, disponible, vecesPrestada);
                    break;
                case 5:      
                    peliculasMenosPrestada(cantidadPelis, idPelis, nombrePelis, year, categoria, disponible, vecesPrestada);
                    break;
            }
        } while(opcion != 6);
    }

    public void cantidadPelisCategoria(){

        if(cantidadCategoriaSinRepetir > 0){
            System.out.println("Categoría\t\tCantidad Categoria");
            for (int i = 0; i <cantidadCategoriaSinRepetir; i++) {
                System.out.print(categoriaSinRepetir[i] + "\t|\t" + cantidadCategoriassinRepetir[i]);
                System.out.println("");
            }
            
        }

        else{
            System.out.println("No hay ninguna categoría para mostrar, use la opcion ingresar películas");
        }
    }

    public void peliculasPorCategoria(int cantidadPelis, int[] idPelis, String[] nombrePelis, int[] year, String[] categoria, boolean[] disponible, int[] vecesPrestada){
        int xd = 0;
        String categoriaBuscada = getString("Ingrese que categoria quiere usar como filtro para las peliculas");
        if(cantidadPelis > 0){
            String disponibilidad = "";
            System.out.println("ID\tNombre Peli\t\t\tAño\tCategoría\tDisponible");
            for (int i = 0; i <cantidadPelis; i++) {
                if(disponible[i]){
                    disponibilidad = "SI";
                }
                else{
                    disponibilidad = "NO";
                }
                if(categoriaBuscada.equals(categoria[i])){
                    System.out.print(idPelis[i] + "\t|\t" + nombrePelis[i] + "\t|\t" + year[i] + "\t|\t" + categoria[i] + "\t|\t" + disponibilidad);
                    System.out.println("");
                }
                else{
                    xd++;
                }
            }
            if(xd == cantidadPelis){
                System.out.println("No hay ninguna película con esa categoria");
            }
            System.out.println("");
        }

        else{
            System.out.println("No hay ninguna pelicula para mostrar, use la opcion ingresar películas");
        }
    }

    public void peliculasVecesPrestada(int cantidadPelis, int[] idPelis, String[] nombrePelis, int[] year, String[] categoria, boolean[] disponible, int[] vecesPrestada){
        if(cantidadPelis > 0){
            String disponibilidad = "";
            System.out.println("ID\tNombre Peli\t\t\tVeces Prestada\t\tAño\t\tCategoría\tDisponible");
            
            for (int i = 0; i <cantidadPelis; i++) {
                if(disponible[i]){
                    disponibilidad = "SI";
                }
                else{
                    disponibilidad = "NO";
                }
                System.out.print(idPelis[i] + "\t|\t" + nombrePelis[i]  + "\t|\t" + vecesPrestada[i] + "\t|\t" + year[i] + "\t|\t" + categoria[i] + "\t|\t" + disponibilidad);
                System.out.println("");
            }

            System.out.println("");
        }

        else{
            System.out.println("No hay ninguna pelicula para mostrar, use la opcion ingresar películas");
        }
    }

    public void peliculasMasPrestada(int cantidadPelis, int[] idPelis, String[] nombrePelis, int[] year, String[] categoria, boolean[] disponible, int[] vecesPrestada){
        int cantidadVecesPrestada = 0;
        if(cantidadPelis > 0){
            String disponibilidad = "";
            System.out.println("Película más Prestada");
            System.out.println("");
            System.out.println("ID\tNombre Peli\t\t\tAño\tCategoría\tDisponible\tVeces prestada");
            for (int i = 0; i <cantidadPelis; i++) {
                if(vecesPrestada[i] >= cantidadVecesPrestada){
                    cantidadVecesPrestada = vecesPrestada[i]; 
                }
            }
            for (int i = 0; i < cantidadPelis; i++) {
                if(disponible[i]){
                    disponibilidad = "SI";
                }
                else{
                    disponibilidad = "NO";
                }

                if(vecesPrestada[i] == cantidadVecesPrestada){
                    System.out.print(idPelis[i] + "\t|\t" + nombrePelis[i] + "\t|\t" + year[i] + "\t|\t" + categoria[i] + "\t|\t" + disponibilidad + "\t|\t" + vecesPrestada[i]);
                    System.out.println("");
                }
            }
            System.out.println("");
            cantidadVecesPrestada = 0;
        }

        else{
            System.out.println("No hay ninguna pelicula para mostrar, use la opcion ingresar películas");
        }
    }

    public void peliculasMenosPrestada(int cantidadPelis, int[] idPelis, String[] nombrePelis, int[] year, String[] categoria, boolean[] disponible, int[] vecesPrestada){
        int cantidadVecesPrestada = 0;
        if(cantidadPelis > 0){
            String disponibilidad = "";
            System.out.println("Película menos Prestada");
            System.out.println("");
            System.out.println("ID\tNombre Peli\t\t\tAño\tCategoría\tDisponible\tVeces prestada");
            for (int i = 0; i <cantidadPelis; i++) {
                if(vecesPrestada[i] <= cantidadVecesPrestada){
                    cantidadVecesPrestada = vecesPrestada[i]; 
                }
            }
            for (int i = 0; i < cantidadPelis; i++) {
                if(disponible[i]){
                    disponibilidad = "SI";
                }
                else{
                    disponibilidad = "NO";
                }

                if(vecesPrestada[i] == cantidadVecesPrestada){
                    System.out.print(idPelis[i] + "\t|\t" + nombrePelis[i] + "\t|\t" + year[i] + "\t|\t" + categoria[i] + "\t|\t" + disponibilidad + "\t|\t" + vecesPrestada[i]);
                    System.out.println("");
                }
            }
            System.out.println("");
            cantidadVecesPrestada = 0;
        }

        else{
            System.out.println("No hay ninguna pelicula para mostrar, use la opcion ingresar películas");
        }
    }

    public int getInt(String titulo){
        String n = "";

        while(n.equals("")){
            System.out.println(titulo);
            n = leer.nextLine();
            if(!n.matches("[0-9 ]*$")){
                n = "";
            }
        }
        
        return Integer.parseInt(n);
    }

    public int getIntRango(String titulo, int rango){
        String n = "";

        while(n.equals("")){
            System.out.println(titulo);
            n = leer.nextLine();
            if(!n.matches("[0-9]{"+rango+"}")){
                n = "";
            }
        }
        
        return Integer.parseInt(n);
    }

    public String getString(String titulo){
        String n = "";

        while(n.equals("")){
            System.out.println(titulo);
            n = leer.nextLine();
            if(!n.matches("^[A-Za-z ]*$")){
                n = "";
            }
        }
        
        return n;
    }

    public String getStringNumeros(String titulo){
        String n = "";

        while(n.equals("")){
            System.out.println(titulo);
            n = leer.nextLine();
            if(!n.matches("^[A-Za-z 0-9]*$")){
                n = "";
            }
        }
        
        return n;
    }

    public int getIntRango(String titulo, int rango, int tamanio){
        String n = "";

        while(n.equals("")){
            System.out.println(titulo);
            n = leer.nextLine();
            if(!n.matches("[0-"+rango+"]{"+tamanio+"}")){
                n = "";
            }
        }
        
        return Integer.parseInt(n);
    }
}