
package tf.bodega_03;

public class ControladorVentas {
    private Inventario inventario;
    private Venta venta;
    private VistaVentas vistaVentas;

    public ControladorVentas(Inventario inventario, VistaVentas vistaVentas) {
        this.inventario = inventario;
        this.vistaVentas = vistaVentas;
        this.venta = new Venta();
        this.inventario.agregarObserver(this.vistaVentas); // Registrar vistaVentas como observador
    }

    public void realizarVenta(Integer idProducto, int cantidad) {
        Producto producto = inventario.buscarProducto(idProducto);
        if (producto != null && producto.getCantidadEnStock() >= cantidad) {
            producto.setCantidadEnStock(producto.getCantidadEnStock() - cantidad);
            inventario.actualizarProducto(producto);
            venta.agregarProducto(producto, cantidad);
            vistaVentas.actualizarEstado("Se agregó " + cantidad + " producto(s) al carrito con éxito." );
        } else {
            vistaVentas.actualizarEstado("Producto no disponible o cantidad insuficiente.");
        }
    }
    public void mostrarTotalVenta() {
        vistaVentas.mostrarTotal(venta.calcularTotal());
    }   
}

