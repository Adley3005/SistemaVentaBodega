
package tf.bodega_03;

import java.util.HashMap;
import java.util.Map;

public class Venta {
    private Map<Integer, Producto> productosVendidos;
    private double total;

    public Venta() {
        productosVendidos = new HashMap<>();
        total = 0.0;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (productosVendidos.containsKey(producto.getId())) {
            Producto productoExistente = productosVendidos.get(producto.getId());
            int nuevaCantidad = productoExistente.getCantidadEnStock() + cantidad;
            productoExistente.setCantidadEnStock(nuevaCantidad);
            productosVendidos.put(producto.getId(), productoExistente);
        } else {
            productosVendidos.put(producto.getId(), new Producto(producto.getId(), 
                    producto.getNombre(), producto.getPrecio(), cantidad));
        }
        total += producto.getPrecio() * cantidad;
    }

    public double calcularTotal() {
        return total;
    }

    public Map<Integer, Producto> getProductosVendidos() {
        return productosVendidos;
    }
}




