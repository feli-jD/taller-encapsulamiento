public class App {
    public static void main(String[] args) {

        

        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez");
        Libro libro2 = new Libro("El amor en los tiempos del cólera", "Gabriel García Márquez");

        libro1.mostrarInfo();
        libro2.mostrarInfo();

        libro1.prestar();          // Préstamo exitoso
        libro1.prestar();          // Ya estaba prestado
        libro1.mostrarInfo();

        libro1.devolver();         // Devolución exitosa
        libro1.mostrarInfo();

        // Setter con validación
        libro2.setTitulo("");      // Debe rechazar título vacío
        libro2.setTitulo("El otoño del patriarca");
        libro2.mostrarInfo();


        

        Vuelo vuelo1 = new Vuelo("AV9401", "Bogotá", "Medellín", 150);
        Vuelo vuelo2 = new Vuelo("LA2315", "Cali", "Cartagena", 80);

        vuelo1.mostrarInfo();
        vuelo2.mostrarInfo();

        vuelo1.embarcar(100);
        vuelo1.embarcar(60);       // No hay espacio suficiente
        vuelo1.embarcar(50);
        vuelo1.mostrarInfo();

        vuelo1.desembarcar(30);
        vuelo1.desembarcar(200);   // Más de lo que hay a bordo
        vuelo1.mostrarInfo();

        // Setter con validación
        vuelo2.setOcupacion(-5);   // Negativo → rechazado
        vuelo2.setOcupacion(100);  // Mayor a capacidad → rechazado
        vuelo2.setOcupacion(40);
        vuelo2.mostrarInfo();



        DepositoAgua principal  = new DepositoAgua(100.0);
        DepositoAgua secundario = new DepositoAgua(50.0);

        // Conectar: el desborde del principal va al secundario
        principal.setDepositoDesborde(secundario);

        System.out.print("Principal  → "); principal.mostrarEstado();
        System.out.print("Secundario → "); secundario.mostrarEstado();
        System.out.println();

        principal.agregarAgua(80);
        System.out.print("Principal  → "); principal.mostrarEstado();
        System.out.println();

        // Desbordamiento: agrega 40 L más, pero solo caben 20
        principal.agregarAgua(40);
        System.out.print("Principal  → "); principal.mostrarEstado();
        System.out.print("Secundario → "); secundario.mostrarEstado();
        System.out.println();

        principal.quitarAgua(30);
        principal.quitarAgua(200);  // Más de lo disponible
        System.out.print("Principal  → "); principal.mostrarEstado();
        System.out.println();

        // Setter de capacidad con validación
        principal.setCapacidad(-10); // Debe rechazarse
    }
}
