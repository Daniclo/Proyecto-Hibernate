package org.daniel.util;

import org.daniel.entity.*;
import org.daniel.service.RecordCompanyService;

import java.sql.Date;
import java.util.Optional;
import java.util.Scanner;

public class MenuUtil {
    private final static Scanner sc = new Scanner(System.in);
    private final static RecordCompanyService rcs = new RecordCompanyService();
    public static void iniciarMenu() {
        System.out.println("Bienvenido al GDD (Gestor de Datos de Discográfica)");
        while (true) {
            System.out.println("\nElige una opción:" +
                    "\n1. Opciones de búsqueda." +
                    "\n2. Opciones de inserción." +
                    "\n3. Opciones de borrado." +
                    "\n4. Salir de la aplicación.");
            switch (sc.nextLine()){
                case "1" -> mostrarOpcionesBusqueda();
                case "2" -> mostrarOpcionesInsercion();
                case "3" -> mostrarOpcionesBorrado();
                case "4" -> {
                    System.out.println("Cerrando programa...");
                    System.exit(0);
                }
                default -> System.err.println("Introduce una opción válida (1-4)");
            }
        }
    }
    private static void mostrarOpcionesBusqueda() {
        boolean exit = false;
        while (!exit){
            System.out.println("\nElige una tabla sobre la que realizar operaciones de búsqueda:" +
                    "\n1. Toda la base de datos." +
                    "\n2. Artistas." +
                    "\n3. Grupos." +
                    "\n4. Canciones." +
                    "\n5. Álbumes." +
                    "\n6. Productores." +
                    "\n7. Volver.");
            switch (sc.nextLine()){
                case "1" -> mostrarDB();
                case "2" -> mostrarOpcionesArtistas(Args.BUSCAR);
                case "3" -> mostrarOpcionesGrupos(Args.BUSCAR);
                case "4" -> mostrarOpcionesCanciones(Args.BUSCAR);
                case "5" -> mostrarOpcionesAlbumes(Args.BUSCAR);
                case "6" -> mostrarOpcionesProductores(Args.BUSCAR);
                case "7" -> exit = true;
                default -> System.err.println("Introduce una opción válida (1-7)");
            }
        }
    }
    private static void mostrarOpcionesInsercion() {
        boolean exit = false;
        while (!exit){
            System.out.println("\nElige una tabla sobre la que realizar operaciones de inserción:" +
                    "\n1. Artistas." +
                    "\n2. Grupos." +
                    "\n3. Canciones." +
                    "\n4. Álbumes." +
                    "\n5. Productores." +
                    "\n6. Volver.");
            switch (sc.nextLine()){
                case "1" -> mostrarOpcionesArtistas(Args.INSERTAR);
                case "2" -> mostrarOpcionesGrupos(Args.INSERTAR);
                case "3" -> mostrarOpcionesCanciones(Args.INSERTAR);
                case "4" -> mostrarOpcionesAlbumes(Args.INSERTAR);
                case "5" -> mostrarOpcionesProductores(Args.INSERTAR);
                case "6" -> exit = true;
                default -> System.err.println("Introduce una opción válida (1-6)");
            }
        }
    }
    private static void mostrarOpcionesBorrado() {
        boolean exit = false;
        while (!exit){
            System.out.println("\nElige una tabla sobre la que realizar operaciones de borrado:" +
                    "\n1. Toda la base de datos." +
                    "\n2. Artistas." +
                    "\n3. Grupos." +
                    "\n4. Canciones." +
                    "\n5. Álbumes." +
                    "\n6. Productores." +
                    "\n7. Volver.");
            switch (sc.nextLine()){
                case "1" -> eliminarDB();
                case "2" -> mostrarOpcionesArtistas(Args.ELIMINAR);
                case "3" -> mostrarOpcionesGrupos(Args.ELIMINAR);
                case "4" -> mostrarOpcionesCanciones(Args.ELIMINAR);
                case "5" -> mostrarOpcionesAlbumes(Args.ELIMINAR);
                case "6" -> mostrarOpcionesProductores(Args.ELIMINAR);
                case "7" -> exit = true;
                default -> System.err.println("Introduce una opción válida (1-7)");
            }
        }
    }
    private static void eliminarDB() {
        rcs.deleteAllArtistas();
        rcs.deleteAllAlbumes();
        rcs.deleteAllCanciones();
        rcs.deleteAllGrupos();
        rcs.deleteAllProductores();
        System.out.println("\nTodos los datos de la base de datos han sido eliminados");
    }
    private static void mostrarDB() {
        System.out.println("\nCanciones: "+rcs.getAllCanciones());
        System.out.println("Álbumes: "+rcs.getAllAlbumes());
        System.out.println("Artistas: "+rcs.getAllArtistas());
        System.out.println("Grupos: "+rcs.getAllGrupos());
        System.out.println("Productores: "+rcs.getAllProductores());
    }
    private static void mostrarOpcionesArtistas(Args args) {
        switch (args){
            case BUSCAR -> {
                boolean exit = false;
                while (!exit){
                    System.out.println("\nOperaciones de búsqueda sobre la tabla artistas:" +
                            "\n1. Obtener todos los artistas." +
                            "\n2. Obtener un artista mediante id." +
                            "\n3. Obtener un artista mediante nombre." +
                            "\n4. Volver.");
                    switch (sc.nextLine()){
                        case "1" -> obtenerArtistas();
                        case "2" -> obtenerArtista(Args.ID);
                        case "3" -> obtenerArtista(Args.NOMBRE);
                        case "4" -> exit = true;
                        default -> System.err.println("Introduce una opción válida (1-4)");
                    }
                }
            }
            case ELIMINAR -> {
                boolean exit = false;
                while (!exit){
                    System.out.println("\nOperaciones de borrado sobre la tabla artistas:" +
                            "\n1. Eliminar todos los artistas." +
                            "\n2. Eliminar un artista mediante id." +
                            "\n3. Eliminar un artista mediante nombre." +
                            "\n4. Volver.");
                    switch (sc.nextLine()){
                        case "1" -> eliminarArtistas();
                        case "2" -> eliminarArtista(Args.ID);
                        case "3" -> eliminarArtista(Args.NOMBRE);
                        case "4" -> exit = true;
                        default -> System.err.println("Introduce una opción válida (1-4)");
                    }
                }
            }
            case INSERTAR -> {
                boolean exit = false;
                while (!exit){
                    System.out.println("\nOperaciones de inserción sobre la tabla artistas:" +
                            "\n1. Añadir artista." +
                            "\n2. Modificar artistas existentes." +
                            "\n3. Añadir artista existente a un grupo." +
                            "\n4. Eliminar artista existente de un grupo." +
                            "\n5. Volver.");
                    switch (sc.nextLine()){
                        case "1" -> insertarArtista();
                        case "2" -> modificarArtista();
                        case "3" -> asociacionArtistaGrupo(Args.INSERTAR);
                        case "4" -> asociacionArtistaGrupo(Args.ELIMINAR);
                        case "5" -> exit = true;
                        default -> System.err.println("Introduce una opción válida (1-5)");
                    }
                }
            }
        }
    }
    private static void mostrarOpcionesGrupos(Args args) {
        switch (args){
            case BUSCAR -> {
                boolean exit = false;
                while (!exit){
                    System.out.println("\nOperaciones de búsqueda sobre la tabla grupos:" +
                            "\n1. Obtener todos los grupos." +
                            "\n2. Obtener un grupo mediante id." +
                            "\n3. Obtener un grupo mediante nombre." +
                            "\n4. Obtener los miembros de un grupo" +
                            "\n5. Obtener todos los miembros en activo de un grupo" +
                            "\n6. Volver.");
                    switch (sc.nextLine()){
                        case "1" -> obtenerGrupos();
                        case "2" -> obtenerGrupo(Args.ID);
                        case "3" -> obtenerGrupo(Args.NOMBRE);
                        case "4" -> obtenerMiembrosGrupo(Args.HISTORICO);
                        case "5" -> obtenerMiembrosGrupo(Args.ACTIVO);
                        case "6" -> exit = true;
                        default -> System.err.println("Introduce una opción válida (1-6)");
                    }
                }
            }
            case ELIMINAR -> {
                boolean exit = false;
                while (!exit){
                    System.out.println("\nOperaciones de borrado sobre la tabla grupos:" +
                            "\n1. Eliminar todos los grupos." +
                            "\n2. Eliminar un grupo mediante id." +
                            "\n3. Eliminar un grupo mediante nombre." +
                            "\n4. Volver.");
                    switch (sc.nextLine()){
                        case "1" -> eliminarGrupos();
                        case "2" -> eliminarGrupo(Args.ID);
                        case "3" -> eliminarGrupo(Args.NOMBRE);
                        case "4" -> exit = true;
                        default -> System.err.println("Introduce una opción válida (1-4)");
                    }
                }
            }
            case INSERTAR -> {
                boolean exit = false;
                while (!exit){
                    System.out.println("\nOperaciones de inserción sobre la tabla grupos:" +
                            "\n1. Añadir grupo." +
                            "\n2. Modificar grupos existentes." +
                            "\n3. Volver.");
                    switch (sc.nextLine()){
                        case "1" -> insertarGrupo();
                        case "2" -> modificarGrupo();
                        case "3" -> exit = true;
                        default -> System.err.println("Introduce una opción válida (1-3)");
                    }
                }
            }
        }
    }
    private static void mostrarOpcionesCanciones(Args args) {
        switch (args){
            case BUSCAR -> {
                boolean exit = false;
                while (!exit){
                    System.out.println("\nOperaciones de búsqueda sobre la tabla canciones:" +
                            "\n1. Obtener todas las canciones." +
                            "\n2. Obtener una canción mediante id." +
                            "\n3. Obtener una canción mediante nombre." +
                            "\n4. Volver.");
                    switch (sc.nextLine()){
                        case "1" -> obtenerCanciones();
                        case "2" -> obtenerCancion(Args.ID);
                        case "3" -> obtenerCancion(Args.NOMBRE);
                        case "4" -> exit = true;
                        default -> System.err.println("Introduce una opción válida (1-4)");
                    }
                }
            }
            case ELIMINAR -> {
                boolean exit = false;
                while (!exit){
                    System.out.println("\nOperaciones de borrado sobre la tabla canciones:" +
                            "\n1. Eliminar todas las canciones." +
                            "\n2. Eliminar una canción mediante id." +
                            "\n3. Eliminar una canción mediante nombre." +
                            "\n4. Volver.");
                    switch (sc.nextLine()){
                        case "1" -> eliminarCanciones();
                        case "2" -> eliminarCancion(Args.ID);
                        case "3" -> eliminarCancion(Args.NOMBRE);
                        case "4" -> exit = true;
                        default -> System.err.println("Introduce una opción válida (1-4)");
                    }
                }
            }
            case INSERTAR -> {
                boolean exit = false;
                while (!exit){
                    System.out.println("\nOperaciones de inserción sobre la tabla canciones:" +
                            "\n1. Añadir canción." +
                            "\n2. Modificar canciones existentes." +
                            "\n3. Volver.");
                    switch (sc.nextLine()){
                        case "1" -> insertarCancion();
                        case "2" -> modificarCancion();
                        case "3" -> exit = true;
                        default -> System.err.println("Introduce una opción válida (1-3)");
                    }
                }
            }
        }
    }
    private static void mostrarOpcionesAlbumes(Args args) {
        switch (args){
            case BUSCAR -> {
                boolean exit = false;
                while (!exit){
                    System.out.println("\nOperaciones de búsqueda sobre la tabla álbumes:" +
                            "\n1. Obtener todos los álbumes." +
                            "\n2. Obtener un álbum mediante id." +
                            "\n3. Obtener un álbum mediante nombre." +
                            "\n4. Obtener lista de canciones de un álbum" +
                            "\n5. Volver.");
                    switch (sc.nextLine()){
                        case "1" -> obtenerAlbumes();
                        case "2" -> obtenerAlbum(Args.ID);
                        case "3" -> obtenerAlbum(Args.NOMBRE);
                        case "4" -> obtenerListaDeCancionesAlbum();
                        case "5" -> exit = true;
                        default -> System.err.println("Introduce una opción válida (1-5)");
                    }
                }
            }
            case ELIMINAR -> {
                boolean exit = false;
                while (!exit){
                    System.out.println("\nOperaciones de borrado sobre la tabla álbumes:" +
                            "\n1. Eliminar todos los álbumes." +
                            "\n2. Eliminar un álbum mediante id." +
                            "\n3. Eliminar un álbum mediante nombre." +
                            "\n4. Volver.");
                    switch (sc.nextLine()){
                        case "1" -> eliminarAlbumes();
                        case "2" -> eliminarAlbum(Args.ID);
                        case "3" -> eliminarAlbum(Args.NOMBRE);
                        case "4" -> exit = true;
                        default -> System.err.println("Introduce una opción válida (1-4)");
                    }
                }
            }
            case INSERTAR -> {
                boolean exit = false;
                while (!exit){
                    System.out.println("\nOperaciones de inserción sobre la tabla álbumes:" +
                            "\n1. Añadir álbum." +
                            "\n2. Modificar álbumes existentes." +
                            "\n3. Volver.");
                    switch (sc.nextLine()){
                        case "1" -> insertarAlbum();
                        case "2" -> modificarAlbum();
                        case "3" -> exit = true;
                        default -> System.err.println("Introduce una opción válida (1-3)");
                    }
                }
            }
        }
    }
    private static void mostrarOpcionesProductores(Args args) {
        switch (args){
            case BUSCAR -> {
                boolean exit = false;
                while (!exit){
                    System.out.println("\nOperaciones de búsqueda sobre la tabla productores:" +
                            "\n1. Obtener todos los productores." +
                            "\n2. Obtener un productor mediante id." +
                            "\n3. Obtener un productor mediante nombre." +
                            "\n4. Volver.");
                    switch (sc.nextLine()){
                        case "1" -> obtenerProductores();
                        case "2" -> obtenerProductor(Args.ID);
                        case "3" -> obtenerProductor(Args.NOMBRE);
                        case "4" -> exit = true;
                        default -> System.err.println("Introduce una opción válida (1-4)");
                    }
                }
            }
            case ELIMINAR -> {
                boolean exit = false;
                while (!exit){
                    System.out.println("\nOperaciones de borrado sobre la tabla productores:" +
                            "\n1. Eliminar todos los productores." +
                            "\n2. Eliminar un productor mediante id." +
                            "\n3. Eliminar un productor mediante nombre." +
                            "\n4. Volver.");
                    switch (sc.nextLine()){
                        case "1" -> eliminarProductores();
                        case "2" -> eliminarProductor(Args.ID);
                        case "3" -> eliminarProductor(Args.NOMBRE);
                        case "4" -> exit = true;
                        default -> System.err.println("Introduce una opción válida (1-4)");
                    }
                }
            }
            case INSERTAR -> {
                boolean exit = false;
                while (!exit){
                    System.out.println("\nOperaciones de inserción sobre la tabla productores:" +
                            "\n1. Añadir productores." +
                            "\n2. Modificar productores existentes." +
                            "\n3. Volver.");
                    switch (sc.nextLine()){
                        case "1" -> insertarProductor();
                        case "2" -> modificarProductor();
                        case "3" -> exit = true;
                        default -> System.err.println("Introduce una opción válida (1-3)");
                    }
                }
            }
        }
    }
    public static void obtenerArtistas(){
        System.out.println("\nTodos los artistas:" +
                "\n" + rcs.getAllArtistas());
    }
    public static void obtenerArtista(Args args){
        switch (args){
            case ID -> {
                System.out.println("\nIntroduce una id de artista:");
                System.out.println(rcs.getArtistaById(Long.parseLong(sc.nextLine())));
            }
            case NOMBRE -> {
                System.out.println("\nIntroduce un nombre de artista:");
                System.out.println(rcs.getArtistaByName(sc.nextLine()));
            }
        }
    }
    public static void obtenerGrupos(){
        System.out.println("\nTodos los grupos:" +
                "\n" + rcs.getAllGrupos());
    }
    public static void obtenerGrupo(Args args){
        switch (args){
            case ID -> {
                System.out.println("\nIntroduce una id de grupo:");
                System.out.println(rcs.getGrupoById(Long.parseLong(sc.nextLine())));
            }
            case NOMBRE -> {
                System.out.println("\nIntroduce un nombre de grupo:");
                System.out.println(rcs.getGrupoByName(sc.nextLine()));
            }
        }
    }
    public static void obtenerMiembrosGrupo(Args args){
        System.out.println("\nIntroduce un nombre de grupo:");
        Optional<Grupo> opGrupo = rcs.getGrupoByName(sc.nextLine());
        if (opGrupo.isPresent()){
            switch (args){
                case HISTORICO -> {
                    System.out.println("\nTodos los miembros del grupo " + opGrupo.get().getNombre() + " en su historia:");
                    System.out.println(rcs.getAllGroupMembers(opGrupo.get()));
                }
                case ACTIVO -> {
                    System.out.println("\nTodos los miembros del grupo " + opGrupo.get().getNombre() + " actualmente:");
                    System.out.println(rcs.getActiveGroupMembers(opGrupo.get()));
                }
            }
        }else System.err.println("El grupo introducido no existe");
    }
    public static void obtenerListaDeCancionesAlbum(){
        System.out.println("\nIntroduce un nombre de álbum:");
        Optional<Album> opAlbum = rcs.getAlbumByName(sc.nextLine());
        opAlbum.ifPresent(album -> System.out.println(rcs.getSongListFromAlbum(album)));
    }
    public static void obtenerCanciones(){
        System.out.println("\nTodas las canciones:" +
                "\n" + rcs.getAllCanciones());
    }
    public static void obtenerCancion(Args args){
        switch (args){
            case ID -> {
                System.out.println("\nIntroduce una id de canción:");
                System.out.println(rcs.getCancionById(Long.parseLong(sc.nextLine())));
            }
            case NOMBRE -> {
                System.out.println("\nIntroduce un nombre de canción:");
                System.out.println(rcs.getCancionByName(sc.nextLine()));
            }
        }
    }
    public static void obtenerAlbumes(){
        System.out.println("\nTodos los álbumes:" +
                "\n" + rcs.getAllAlbumes());
    }
    public static void obtenerAlbum(Args args){
        switch (args){
            case ID -> {
                System.out.println("\nIntroduce una id de álbum:");
                System.out.println(rcs.getAlbumById(Long.parseLong(sc.nextLine())));
            }
            case NOMBRE -> {
                System.out.println("\nIntroduce un nombre de álbum:");
                System.out.println(rcs.getAlbumByName(sc.nextLine()));
            }
        }
    }
    public static void obtenerProductores(){
        System.out.println("\nTodos los productores:" +
                "\n" + rcs.getAllProductores());
    }
    public static void obtenerProductor(Args args){
        switch (args){
            case ID -> {
                System.out.println("\nIntroduce una id de productor:");
                System.out.println(rcs.getProductorById(Long.parseLong(sc.nextLine())));
            }
            case NOMBRE -> {
                System.out.println("\nIntroduce un nombre de productor:");
                System.out.println(rcs.getProductorByName(sc.nextLine()));
            }
        }
    }
    public static void eliminarArtistas(){
        rcs.deleteAllArtistas();
        System.err.println("\nTodos los artistas han sido eliminados.");
    }
    public static void eliminarArtista(Args args){
        switch (args){
            case ID -> {
                System.out.println("\nIntroduce un id de artista:");
                rcs.deleteArtistaById(Long.parseLong(sc.nextLine()));
            }
            case NOMBRE -> {
                System.out.println("\nIntroduce un nombre de artista:");
                Optional<Artista> opArtista = rcs.getArtistaByName(sc.nextLine());
                opArtista.ifPresent(rcs::deleteArtista);
            }
        }
    }
    public static void eliminarGrupos(){
        rcs.deleteAllGrupos();
        System.err.println("\nTodos los grupos han sido eliminados.");
    }
    public static void eliminarGrupo(Args args){
        switch (args){
            case ID -> {
                System.out.println("\nIntroduce un id de grupo:");
                rcs.deleteGrupoById(Long.parseLong(sc.nextLine()));
            }
            case NOMBRE -> {
                System.out.println("\nIntroduce un nombre de grupo:");
                Optional<Grupo> opGrupo = rcs.getGrupoByName(sc.nextLine());
                opGrupo.ifPresent(rcs::deleteGrupo);
            }
        }
    }
    public static void eliminarCanciones(){
        rcs.deleteAllCanciones();
        System.err.println("\nTodas las canciones han sido eliminados.");
    }
    public static void eliminarCancion(Args args){
        switch (args){
            case ID -> {
                System.out.println("\nIntroduce un id de canción:");
                rcs.deleteCancionById(Long.parseLong(sc.nextLine()));
            }
            case NOMBRE -> {
                System.out.println("\nIntroduce un nombre de canción:");
                Optional<Cancion> opCancion = rcs.getCancionByName(sc.nextLine());
                opCancion.ifPresent(rcs::deleteCancion);
            }
        }
    }
    public static void eliminarAlbumes(){
        rcs.deleteAllAlbumes();
        System.err.println("\nTodos los álbumes han sido eliminados.");
    }
    public static void eliminarAlbum(Args args){
        switch (args){
            case ID -> {
                System.out.println("\nIntroduce un id de álbum:");
                rcs.deleteAlbumById(Long.parseLong(sc.nextLine()));
            }
            case NOMBRE -> {
                System.out.println("\nIntroduce un nombre de álbum:");
                Optional<Album> opAlbum = rcs.getAlbumByName(sc.nextLine());
                opAlbum.ifPresent(rcs::deleteAlbum);
            }
        }
    }
    public static void eliminarProductores(){
        rcs.deleteAllProductores();
        System.err.println("\nTodos los productores han sido eliminados.");
    }
    public static void eliminarProductor(Args args){
        switch (args){
            case ID -> {
                System.out.println("\nIntroduce un id de productor:");
                rcs.deleteProductorById(Long.parseLong(sc.nextLine()));
            }
            case NOMBRE -> {
                System.out.println("\nIntroduce un nombre de productor:");
                Optional<Productor> opProductor = rcs.getProductorByName(sc.nextLine());
                opProductor.ifPresent(rcs::deleteProductor);
            }
        }
    }
    public static void insertarArtista(){
        System.out.println("\nIntroduce un nombre:");
        String nombre = sc.nextLine();
        System.out.println("Introduce una edad:");
        int edad = Integer.parseInt(sc.nextLine());
        Artista artista = new Artista(nombre,edad);
        rcs.createArtist(artista);
    }
    public static void insertarGrupo(){
        System.out.println("\nIntroduce un nombre:");
        String nombre = sc.nextLine();
        System.out.println("Introduce un año de creación (formato yyyy-mm-dd)");
        Date anyoCreacion = Date.valueOf(sc.nextLine());
        Grupo grupo = new Grupo(nombre,anyoCreacion);
        rcs.createGrupo(grupo);
    }
    public static void insertarCancion(){
        System.out.println("\nIntroduce un nombre:");
        String nombre = sc.nextLine();
        System.out.println("Introduce una duración:");
        double duracion = Double.parseDouble(sc.nextLine());
        System.out.println("Introduce un género:");
        String genero = sc.nextLine();
        System.out.println("Introduce un nombre de álbum:");
        Optional<Album> opAlbum = rcs.getAlbumByName(sc.nextLine());
        if (opAlbum.isPresent()){
            Cancion cancion = new Cancion(nombre,duracion,genero,opAlbum.get());
            rcs.createCancion(cancion);
        }else System.err.println("Error: el álbum indicado no existe, una canción debe pertenecer a un álbum" +
                "existente.");
    }
    public static void insertarAlbum(){
        System.out.println("\nIntroduce un nombre:");
        String nombre = sc.nextLine();
        System.out.println("Introduce un número de canciones:");
        int numeroCanciones = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce un año de creación:");
        int anyo = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce un productor:");
        Optional<Productor> opProductor = rcs.getProductorByName(sc.nextLine());
        System.out.println("¿Quieres asignar como creador a un artista o a un grupo?");
        switch (sc.nextLine().toLowerCase()){
            case "artista" -> {
                System.out.println("Introduce un artista:");
                Optional<Artista> opArtista = rcs.getArtistaByName(sc.nextLine());
                if (opArtista.isPresent() && opProductor.isPresent()){
                    Artista artista = opArtista.get();
                    Productor productor = opProductor.get();
                    Album album = new Album(nombre,numeroCanciones,anyo,artista,productor);
                    rcs.createAlbum(album);
                }
            }
            case "grupo" -> {
                System.out.println("Introduce un grupo:");
                Optional<Grupo> opGrupo = rcs.getGrupoByName(sc.nextLine());
                if (opGrupo.isPresent() && opProductor.isPresent()){
                    Grupo grupo = opGrupo.get();
                    Productor productor = opProductor.get();
                    Album album = new Album(nombre,numeroCanciones,anyo,grupo,productor);
                    rcs.createAlbum(album);
                }
            }
        }
    }
    public static void insertarProductor(){
        System.out.println("\nIntroduce un nombre:");
        String nombre = sc.nextLine();
        System.out.println("Introduce una edad:");
        int edad = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce años de experiencia:");
        int anyosExperiencia = Integer.parseInt(sc.nextLine());
        Productor productor = new Productor(nombre,edad,anyosExperiencia);
        rcs.createProductor(productor);
    }
    public static void modificarArtista(){
        System.out.println("\nIntroduce un nombre de artista:");
        Optional<Artista> opArtista = rcs.getArtistaByName(sc.nextLine());
        if (opArtista.isPresent()){
            long id = opArtista.get().getId();
            System.out.println("Escribe un nuevo valor para cada atributo. Para mantener el valor actual, no escribas nada.");
            System.out.println("Introduce un nuevo nombre de artista:");
            String nombre = sc.nextLine();
            if (nombre.isEmpty()) {
                nombre = opArtista.get().getNombre();
            }
            System.out.println("Introduce una nueva edad:");
            String edad = sc.nextLine();
            if (edad.isEmpty()){
                edad = String.valueOf(opArtista.get().getEdad());
            }
            rcs.saveArtista(new Artista(id,nombre,Integer.parseInt(edad)));
        }
    }
    public static void modificarGrupo(){
        System.out.println("\nIntroduce un nombre de grupo:");
        Optional<Grupo> opGrupo = rcs.getGrupoByName(sc.nextLine());
        if (opGrupo.isPresent()){
            long id = opGrupo.get().getId();
            System.out.println("Escribe un nuevo valor para cada atributo. Para mantener el valor actual, no escribas nada.");
            System.out.println("Introduce un nuevo nombre de grupo:");
            String nombre = sc.nextLine();
            if (nombre.isEmpty()) {
                nombre = opGrupo.get().getNombre();
            }
            System.out.println("Introduce un nuevo año de creación:");
            String anyo = sc.nextLine();
            if (anyo.equals("")){
                anyo = String.valueOf(opGrupo.get().getAnyoCreacion());
            }
            rcs.saveGrupo(new Grupo(id,nombre,Date.valueOf(anyo)));
        }
    }
    public static void modificarCancion(){
        System.out.println("\nIntroduce un nombre de canción:");
        Optional<Cancion> opCancion = rcs.getCancionByName(sc.nextLine());
        if (opCancion.isPresent()){
            long id = opCancion.get().getId();
            System.out.println("Escribe un nuevo valor para cada atributo. Para mantener el valor actual, no escribas nada.");
            System.out.println("Introduce un nuevo nombre de canción:");
            String nombre = sc.nextLine();
            if (nombre.isEmpty()) {
                nombre = opCancion.get().getNombre();
            }
            System.out.println("Introduce una nueva duración:");
            String duracion = sc.nextLine();
            if (duracion.isEmpty()){
                duracion = String.valueOf(opCancion.get().getDuracion());
            }
            System.out.println("Introduce un nuevo género:");
            String genero = sc.nextLine();
            if (genero.isEmpty()){
                genero = opCancion.get().getGenero();
            }
            System.out.println("Introduce un nuevo álbum");
            String nombreAlbum = sc.nextLine();
            Optional<Album> opAlbum = rcs.getAlbumByName(nombreAlbum);
            Album album;
            if (opAlbum.isEmpty() || nombreAlbum.isEmpty()){
                album = opCancion.get().getAlbum();
            }else {
                album = opAlbum.get();
            }
            rcs.saveCancion(new Cancion(id,nombre,Double.parseDouble(duracion),genero,album));
        }
    }
    public static void modificarAlbum(){
        System.out.println("\nIntroduce un nombre de álbum:");
        Optional<Album> opAlbum = rcs.getAlbumByName(sc.nextLine());
        if (opAlbum.isPresent()){
            long id = opAlbum.get().getId();
            System.out.println("Escribe un nuevo valor para cada atributo. Para mantener el valor actual, no escribas nada.");
            System.out.println("Introduce un nuevo nombre de álbum:");
            String nombre = sc.nextLine();
            if (nombre.isEmpty()) {
                nombre = opAlbum.get().getNombre();
            }
            System.out.println("Introduce un nuevo número de canciones:");
            String numCanciones = sc.nextLine();
            if (numCanciones.isEmpty()){
                numCanciones = String.valueOf(opAlbum.get().getNumCanciones());
            }
            System.out.println("Introduce un nuevo año:");
            String anyo = sc.nextLine();
            if (anyo.isEmpty()){
                anyo = String.valueOf(opAlbum.get().getAnyo());
            }

            System.out.println("Introduce un nuevo productor");
            String nombreProductor = sc.nextLine();
            Optional<Productor> opProductor = rcs.getProductorByName(nombreProductor);
            Productor productor;
            if (opProductor.isEmpty() || nombreProductor.isEmpty()){
                productor = opAlbum.get().getProductor();
            }else {
                productor = opProductor.get();
            }

            boolean hasGrupo = false;
            boolean hasArtista = false;
            Optional<Grupo> opGrupo;
            Optional<Artista> opArtista;
            Artista artista = new Artista();
            Grupo grupo = new Grupo();
            System.out.println("¿Quieres introducir un artista o un grupo?");
            String respuesta = sc.nextLine().toLowerCase();
            switch (respuesta){
                case "grupo" -> {
                    hasGrupo = true;
                    System.out.println("Introduce un nuevo grupo:");
                    String nombreGrupo = sc.nextLine();
                    if (nombreGrupo.isEmpty() && opAlbum.get().getGrupo() != null){
                        opGrupo = Optional.ofNullable(opAlbum.get().getGrupo());
                    }else {
                        opGrupo = rcs.getGrupoByName(nombreGrupo);
                    }
                    if (opGrupo.isPresent()){
                        grupo = opGrupo.get();
                    }
                    rcs.saveAlbum(new Album(id,nombre,Integer.parseInt(numCanciones),Integer.parseInt(anyo),null,grupo,productor));
                }
                case "artista" -> {
                    hasArtista = true;
                    System.out.println("Introduce un nuevo artista:");
                    String nombreArtista = sc.nextLine();
                    if (nombreArtista.isEmpty() && opAlbum.get().getArtista() != null){
                        opArtista = Optional.ofNullable(opAlbum.get().getArtista());
                    }else {
                        opArtista = rcs.getArtistaByName(nombreArtista);
                    }
                    if (opArtista.isPresent()){
                        artista = opArtista.get();
                    }
                    rcs.saveAlbum(new Album(id,nombre,Integer.parseInt(numCanciones),Integer.parseInt(anyo),artista,null,productor));
                }
            }
        }
    }
    public static void modificarProductor(){
        System.out.println("\nIntroduce un nombre de productor:");
        Optional<Productor> opProductor = rcs.getProductorByName(sc.nextLine());
        if (opProductor.isPresent()){
            long id = opProductor.get().getId();
            System.out.println("Escribe un nuevo valor para cada atributo. Para mantener el valor actual, no escribas nada.");
            System.out.println("Introduce un nuevo nombre de productor:");
            String nombre = sc.nextLine();
            if (nombre.isEmpty()) {
                nombre = opProductor.get().getNombre();
            }
            System.out.println("Introduce una nueva edad:");
            String edad = sc.nextLine();
            if (edad.isEmpty()){
                edad = String.valueOf(opProductor.get().getEdad());
            }
            System.out.println("Introduce un nuevo valor de años de experiencia:");
            String anyos = sc.nextLine();
            if (anyos.isEmpty()){
                anyos = String.valueOf(opProductor.get().getAnyosExperiencia());
            }
            rcs.saveProductor(new Productor(id,nombre,Integer.parseInt(edad),Integer.parseInt(anyos)));
        }
    }
    public static void asociacionArtistaGrupo(Args args){
        switch (args){
            case INSERTAR -> {
                System.out.println("\nIntroduce un nombre de grupo: ");
                Optional<Grupo> grupo = rcs.getGrupoByName(sc.nextLine());
                System.out.println("Introduce un nombre de artista: ");
                Optional<Artista> artista = rcs.getArtistaByName(sc.nextLine());
                if (artista.isPresent() && grupo.isPresent()) rcs.addArtistToGroup(artista.get(),grupo.get());
            }
            case ELIMINAR -> {
                System.out.println("\nIntroduce un nombre de grupo: ");
                Optional<Grupo> grupo = rcs.getGrupoByName(sc.nextLine());
                System.out.println("Introduce un nombre de artista: ");
                Optional<Artista> artista = rcs.getArtistaByName(sc.nextLine());
                if (artista.isPresent() && grupo.isPresent()) rcs.deleteArtistFromGroup(artista.get(),grupo.get());
            }
        }
    }
}