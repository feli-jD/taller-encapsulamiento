public class Libro {

    private String titulo;
    private String autor;
    private boolean disponible;

    // Constructor
    public Libro(String titulo, String autor) {
        setTitulo(titulo);
        this.autor = autor;
        this.disponible = true;
    }

    // Getters y Setters
    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            System.out.println("⚠ El título no puede estar vacío.");
            return;
        }
        this.titulo = titulo;
    }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    // Métodos
    public void mostrarInfo() {
        System.out.println("📖 Libro: " + titulo);
        System.out.println("   Autor: " + autor);
        System.out.println("   Estado: " + (disponible ? "Disponible" : "Prestado"));
        System.out.println();
    }

    public void prestar() {
        if (!disponible) {
            System.out.println("⚠ \"" + titulo + "\" ya está prestado.");
        } else {
            disponible = false;
            System.out.println("✔ \"" + titulo + "\" prestado con éxito.");
        }
    }

    public void devolver() {
        disponible = true;
        System.out.println("✔ \"" + titulo + "\" devuelto. Ya está disponible.");
    }
}
