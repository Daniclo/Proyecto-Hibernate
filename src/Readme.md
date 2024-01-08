# Gestor de base de datos de discográfica

## Introducción:

Esta aplicación se utiliza para manejar la base de datos de una discográfica. En este manual se pretende explicar
de forma precisa su funcionamiento y como poner en marcha tanto la misma como la base de datos que gestiona.

## Base de datos:
El script de la base de datos se encuentra en la carpeta del proyecto en forma de archivo de texto.sql. Esta base
de datos cuenta con 6 tablas que representan 5 entidades diferentes más una entidad de relación muchos a muchos.
Las entidades que se van a almacenar son las siguientes: artista, grupo, canción, álbum y productor, además de 
la relación muchos a muchos entre artista y grupo.

## Estructura del proyecto:
El proyecto está estructurado de tal forma que toda la interacción con la base de datos y todas las operaciones
relacionadas ocurren por medio de objetos DAO (Data Access Object) que implementan una serie de interfaces. Además,
todas estas operaciones que vienen de los objetos DAO se centralizan por medio de una capa de servicios que facilita su
uso para hacer pruebas.

Estos objetos DAO trabajan con unas clases que mapean las entidades de la base de datos por medio de Hibernate, además
de un wrapper que sirve para almacenar datos de la relación muchos a muchos entre artista y grupo.

Toda esta lógica de interacción con la base de datos que viene de los DAO, se une por medio de la capa de servicios con
la lógica de menú y aplicación con la que interactua el usuario, que viene dada por la clase MenuUtil del paquete util.
Este paquete además contiene un enum con todos los argumentos posibles que pueden recibir los métodos del menú, que he
decidido organizar de esta forma para que el código sea más intuitivo y para reducir el número de métodos distintos que
ha de contener la clase, separando dentro de cada método diferentes acciones según los argumentos que se reciban. Además,
este paquete contiene también una clase Validator que sirve para hacer verificaciones con la base de datos y comprobar que
los datos existen, y por último una clase que permite la conexión con la base de datos por medio de Hibernate.

## Como usar:
Para iniciar la aplicación, abrimos un terminal en la ubicación en la que se encuentre el jar de la app. Una vez hecho esto,
ejecutaremos el siguiente comando: java -jar nombreAplicacion.

Al ejecutarlo, se abrirá en el terminal el menú de la aplicación, que se maneja mediante números (y ocasionalmente por texto)
y permite realizar todas las operaciones posibles sobre todas las tablas de la base de datos de forma intuitiva.

