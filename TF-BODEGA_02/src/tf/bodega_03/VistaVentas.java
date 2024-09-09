
package tf.bodega_03;

public class VistaVentas implements Observer {
    private ControladorVentas controlador;

    public void setControlador(ControladorVentas controlador) {
        this.controlador = controlador;
    }

    public void actualizarEstado(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarTotal(double total) {
        String mensaje = "Total de la venta: " + total;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println(mensaje);
    }
}
