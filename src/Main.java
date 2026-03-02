//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca( 10);

        Libro libro1 = new Libro(1, "El Quijote", "Miguel de Cervantes", 678);
        Libro libro2 = new Libro(2, "El gato con botas", " Charles Perrault", 100);

        System.out.println(biblioteca.findLibro(1) ) ;  // null

        System.out.println(biblioteca.addLibro(libro1)); // true
        System.out.println(biblioteca.addLibro(libro2)); // true

        System.out.println(biblioteca.obtainCatalogo());

    }
}