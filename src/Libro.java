/**
 * Representa un libro dentro del catálogo de una biblioteca.
 *
 * Cada libro está identificado de manera única mediante un {@code id}
 * y contiene información básica como título, autor y número de páginas.
 *
 * Esta clase actúa como entidad del dominio y encapsula sus datos,
 * permitiendo el acceso únicamente a través de métodos públicos.
 *
 * @author Luis García Sánchez
 * @version 1.0
 */
public class Libro {

    // atributos de la clase
    private int id;
    private String titulo;
    private String autor;
    private int numPaginas;

    /**
     * Metodo constructor de objetos tipo {@code Libro}
     * @param id identificador del libro
     * @param titulo título del libro
     * @param autor autor del libro
     * @param numPaginas número de páginas del libro
     */
    public Libro(int id, String titulo, String autor, int numPaginas){  // parámetros del metodo
        int numHojas;  // variable del metodo

        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;

        numHojas = numPaginas/2;
    }

    /**
     * Devuelve el id del libro
     * @return id del libro
     */
    public int getId() {
        return id;
    }

    /**
     * Devuelve el título del libro
     * @return el título del libro
     */
    public String getTitulo(){
        return titulo;
    }

    /**
     * Devuelve el autor del libro
     * @return el autor del libro
     */
    public String getAutor(){
        return autor;
    }
    /**
     * Devuelve el número de páginas del libro
     * @return el número de páginas del libro
     */
    public int getNumPaginas(){
        return numPaginas;
    }

    /**
     * Devuelve una representación textual del libro con todos sus atributos.
     *
     * @return cadena de texto formateada con la información del libro.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Libro: {");

        sb.append(String.format("\n id: %d;", id));
        sb.append(String.format(" titulo: %s;", titulo));
        sb.append(String.format(" autor: %s;", autor));
        sb.append(String.format(" num. páginas: %d;", numPaginas));
        sb.append("}");

        return sb.toString();
    }

    /**
     * Actualiza el número de páginas que tiene el libro. Comprueba que el número recibido sea mayor que 0
     * @param numPaginas nueva cantidad de páginas
     * @return true si ha podido cambiarse, false si no ha podido cambiarse
     */
    public boolean updateNumPaginas(int numPaginas) {
        boolean resultado;

        if( numPaginas <= 0 ){
            resultado = false;
        } else {
            this.numPaginas = numPaginas;
            resultado = true;
        }
        return resultado;
    }
}
