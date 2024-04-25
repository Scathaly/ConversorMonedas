import javax.swing.JOptionPane;

public class ConversorMonedas {

    // Tasas de conversión basadas en 1 Colón
    private static final double TASA_DOLAR = 500;
    private static final double TASA_EURO = 536.10;
    private static final double TASA_LIBRA = 624.13;
    private static final double TASA_YEN = 3.22;
    private static final double TASA_WON = 0.36;

    public static double colonesADolares(double colones) {
        return colones / TASA_DOLAR;
    }

    public static double dolaresAColones(double dolares) {
        return dolares * TASA_DOLAR;
    }

    public static double colonesAEuros(double colones) {
        return colones / TASA_EURO;
    }

    public static double eurosAColones(double euros) {
        return euros * TASA_EURO;
    }

    public static double colonesALibras(double colones) {
        return colones / TASA_LIBRA;
    }

    public static double librasAColones(double libras) {
        return libras * TASA_LIBRA;
    }

    public static double colonesAYen(double colones) {
        return colones / TASA_YEN;
    }

    public static double yenAColones(double yen) {
        return yen * TASA_YEN;
    }

    public static double colonesAWon(double colones) {
        return colones / TASA_WON;
    }

    public static double wonAColones(double won) {
        return won * TASA_WON;
    }

    public static void main(String[] args) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, "Ingrese el monto y la moneda de origen (ejemplo: 100 Colones):");
            if (input == null) break;  // Cancelar cerrará la aplicación

            String[] parts = input.split(" ");
            if (parts.length != 2) {
                JOptionPane.showMessageDialog(null, "Formato incorrecto, use 'monto Moneda'");
                continue;
            }

            try {
                double cantidad = Double.parseDouble(parts[0]);
                String moneda = parts[1];
                double resultado = 0;
                String mensaje = "";

                switch (moneda) {
                    case "Colones":
                        mensaje = String.format("Dólares: %.2f\nEuros: %.2f\nLibras: %.2f\nYen: %.2f\nWon: %.2f",
                                colonesADolares(cantidad),
                                colonesAEuros(cantidad),
                                colonesALibras(cantidad),
                                colonesAYen(cantidad),
                                colonesAWon(cantidad));
                        break;
                    case "Dólares":
                        resultado = dolaresAColones(cantidad);
                        mensaje = "Colones: " + resultado;
                        break;
                    case "Euros":
                        resultado = eurosAColones(cantidad);
                        mensaje = "Colones: " + resultado;
                        break;
                    case "Libras":
                        resultado = librasAColones(cantidad);
                        mensaje = "Colones: " + resultado;
                        break;
                    case "Yen":
                        resultado = yenAColones(cantidad);
                        mensaje = "Colones: " + resultado;
                        break;
                    case "Won":
                        resultado = wonAColones(cantidad);
                        mensaje = "Colones: " + resultado;
                        break;
                    default:
                        mensaje = "Moneda desconocida. Use 'Colones', 'Dólares', 'Euros', 'Libras', 'Yen', o 'Won'.";
                        break;
                }

                JOptionPane.showMessageDialog(null, mensaje);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
            }
        }
    }
}
