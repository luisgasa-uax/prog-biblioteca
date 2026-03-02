/**
 * Representa una biblioteca que gestiona un catálogo de libros mediante
 * un array unidimensional de tamaño fijo.
 *
 * La biblioteca permite:
 * <ul>
 *     <li>Registrar libros sin duplicar identificadores.</li>
 *     <li>Buscar libros por su identificador.</li>
 *     <li>Eliminar libros existentes.</li>
 *     <li>Actualizar el número de páginas de un libro.</li>
 *     <li>Obtener una representación textual del catálogo.</li>
 * </ul>
 *
 * La estructura interna utiliza un array estático donde las posiciones
 * libres se representan mediante valores {@code null}.
 *
 * @author Luis García Sánchez
 * @version 1.0
 */
public class Biblioteca {

    private Libro [] catalogo;
    private final int CANT_MAX_LIBROS;

    /**
     * Construye una biblioteca con una capacidad máxima determinada.
     *
     * @param cantidad_maxima_libros número máximo de libros que puede almacenar la biblioteca.
     */
    public Biblioteca(int cantidad_maxima_libros){
        CANT_MAX_LIBROS = cantidad_maxima_libros;
        catalogo = new Libro[CANT_MAX_LIBROS];
    }

    /**
     * Busca el primer libro que encuentre con el id recibido
     * @param idLibro
     *  @return el objeto {@link Libro} si se encuentra en el catálogo;
     *         {@code null} en caso contrario.
     */
    public Libro findLibro(int idLibro){
        boolean seguirBuscando = true;
        Libro libroEncontrado = null;

        for (int i = 0; i < CANT_MAX_LIBROS && seguirBuscando; i++) {
            if( catalogo[i] != null && catalogo[i].getId() == idLibro ){
                seguirBuscando = false;
                libroEncontrado = catalogo[i];
            }
        }

        return libroEncontrado;
    }

    /**
     * Busca la primera posición libre (valor {@code null}) dentro del catálogo.
     *
     * @return el índice de la primera posición libre si existe;
     *         {@code -1} si el catálogo está completo.
     */
    private int buscarPrimerHuecoLibre(){
        int posicionLibre = -1;
        boolean seguirBuscando = true;

        for (int i = 0; i < CANT_MAX_LIBROS && seguirBuscando; i++) {
            if( catalogo[i] == null ){
                posicionLibre = i;
                seguirBuscando = false;
            }
        }

        return posicionLibre;
    }

    /**
     * Añade un libro al catálogo si no existe otro con el mismo identificador
     * y si hay espacio disponible.
     *
     * @param libro libro que se desea añadir.
     * @return {@code true} si el libro se ha añadido correctamente;
     *         {@code false} si ya existía o no hay espacio disponible.
     */
    public boolean addLibro(Libro libro){
        boolean libroAnadido = false;
        int posicion;

        // comprobamos si existe
            // buscar hueco
                // no hay -> libroAnadido = false
                // si hay ->
                    // añadimos
                    // libroAnadido = true

        if( findLibro(libro.getId()) == null ) {  // no lo ha encontrado. no está duplicado
            posicion = buscarPrimerHuecoLibre();
            if(posicion >= 0) {
                catalogo[posicion] = libro;
                libroAnadido = true;
            }
        }

        return libroAnadido;
    }

    /**
     * Elimina del catálogo el libro cuyo identificador coincida con el recibido.
     *
     * @param id identificador del libro a eliminar.
     * @return el libro eliminado si se encontraba en el catálogo;
     *         {@code null} si no existe ningún libro con ese identificador.
     */
    public Libro deleteLibro(int id){
        Libro libroEncontrado = null;
        boolean seguirBuscando = true;

        // comprobamos que existe. Necesitamos el libro y la posición

        for (int i = 0; i < CANT_MAX_LIBROS && seguirBuscando; i++) {
            if (catalogo[i] != null && catalogo[i].getId() == id) {
                libroEncontrado = catalogo[i];  // guardo el libro
                catalogo[i] = null;             // vaciamos la posición
                seguirBuscando = false;         // para que no siga recorriendo
            }
        }

        return libroEncontrado;
    }


    /**
     * Actualiza el número de páginas del libro con el identificador indicado.
     *
     * @param idLibro identificador del libro a actualizar.
     * @param numPaginas nuevo número de páginas.
     * @return {@code true} si el libro existe y se ha actualizado correctamente;
     *         {@code false} si el libro no existe o la actualización no es válida.
     */
    public boolean updateNumPaginas(int idLibro, int numPaginas){
        boolean numPaginasActualizado = false;
        Libro libro;

        libro = findLibro(idLibro);

        if( libro != null ){
            numPaginasActualizado = libro.updateNumPaginas(numPaginas);
        }

        return numPaginasActualizado;
    }

    /**
     * Devuelve una representación textual del catálogo completo.
     *
     * @return una cadena de texto con todos los libros almacenados.
     */
    public String obtainCatalogo(){
        StringBuilder sb = new StringBuilder("Catálogo: { ");

        for (int i = 0; i < CANT_MAX_LIBROS; i++) {
            if( catalogo[i] != null ){
                sb.append( catalogo[i].toString() );
            }
        }
        sb.append("\n}");

        return sb.toString();
    }

}
