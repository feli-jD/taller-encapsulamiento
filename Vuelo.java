public class Vuelo {

    private String numero;
    private String origen;
    private String destino;
    private int ocupacion;
    private int capacidadMaxima;

    // Constructor
    public Vuelo(String numero, String origen, String destino, int capacidadMaxima) {
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
        this.capacidadMaxima = capacidadMaxima;
        this.ocupacion = 0;
    }

    // Getters y Setters
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public int getCapacidadMaxima() { return capacidadMaxima; }
    public void setCapacidadMaxima(int capacidadMaxima) { this.capacidadMaxima = capacidadMaxima; }

    public int getOcupacion() { return ocupacion; }

    public void setOcupacion(int ocupacion) {
        if (ocupacion < 0) {
            System.out.println("⚠ La ocupación no puede ser negativa.");
        } else if (ocupacion > capacidadMaxima) {
            System.out.println("⚠ La ocupación no puede superar la capacidad máxima (" + capacidadMaxima + ").");
        } else {
            this.ocupacion = ocupacion;
        }
    }

    // Métodos
    public void mostrarInfo() {
        System.out.println("✈ Vuelo: " + numero + "  |  " + origen + " → " + destino);
        System.out.println("  Pasajeros: " + ocupacion + " / " + capacidadMaxima);
        System.out.println("  Asientos libres: " + (capacidadMaxima - ocupacion));
        System.out.println();
    }

    public void embarcar(int pasajeros) {
        int libres = capacidadMaxima - ocupacion;
        if (pasajeros > libres) {
            System.out.println("⚠ No hay espacio para " + pasajeros + " pasajeros en el vuelo " + numero
                    + ". Solo quedan " + libres + " asientos.");
        } else {
            ocupacion += pasajeros;
            System.out.println("✔ " + pasajeros + " pasajeros embarcaron en vuelo " + numero
                    + ". Ocupación actual: " + ocupacion);
        }
    }

    public void desembarcar(int pasajeros) {
        if (pasajeros > ocupacion) {
            System.out.println("⚠ No hay " + pasajeros + " pasajeros a bordo. Se desembarcan todos (" + ocupacion + ").");
            ocupacion = 0;
        } else {
            ocupacion -= pasajeros;
            System.out.println("✔ " + pasajeros + " pasajeros desembarcaron del vuelo " + numero
                    + ". Ocupación actual: " + ocupacion);
        }
    }
}
