public class DepositoAgua {

    private double capacidad;
    private double volumenActual;
    private DepositoAgua depositoDesborde;

    
    public DepositoAgua(double capacidad) {
        setCapacidad(capacidad);
        this.volumenActual = 0;
        this.depositoDesborde = null;
    }

    
    public double getCapacidad() { return capacidad; }

    public void setCapacidad(double capacidad) {
        if (capacidad <= 0) {
            System.out.println("⚠ La capacidad debe ser mayor a cero.");
            return;
        }
        this.capacidad = capacidad;
    }

    public double getVolumenActual() { return volumenActual; }
    public void setVolumenActual(double volumenActual) { this.volumenActual = volumenActual; }

    public DepositoAgua getDepositoDesborde() { return depositoDesborde; }
    public void setDepositoDesborde(DepositoAgua depositoDesborde) { this.depositoDesborde = depositoDesborde; }

    
    public void mostrarEstado() {
        System.out.printf(" Capacidad: %.1f L  |  Volumen actual: %.1f L  |  Espacio libre: %.1f L%n",
                capacidad, volumenActual, capacidad - volumenActual);
    }

    public void agregarAgua(double cantidad) {
        double total = volumenActual + cantidad;
        if (total <= capacidad) {
            volumenActual = total;
            System.out.printf("✔ Se agregaron %.1f L. Volumen actual: %.1f L%n", cantidad, volumenActual);
        } else {
            double sobrante = total - capacidad;
            volumenActual = capacidad;
            System.out.printf("⚠ Depósito lleno. Sobrante: %.1f L%n", sobrante);
            if (depositoDesborde != null) {
                System.out.println("  → Enviando agua sobrante al depósito de desborde...");
                depositoDesborde.agregarAgua(sobrante);
            } else {
                System.out.println("  → No hay depósito de desborde conectado. El agua sobrante se pierde.");
            }
        }
    }

    public void quitarAgua(double cantidad) {
        if (cantidad > volumenActual) {
            System.out.printf("⚠ No hay suficiente agua. Solo quedan %.1f L. Se vacía el depósito.%n", volumenActual);
            volumenActual = 0;
        } else {
            volumenActual -= cantidad;
            System.out.printf("✔ Se quitaron %.1f L. Volumen actual: %.1f L%n", cantidad, volumenActual);
        }
    }
}
