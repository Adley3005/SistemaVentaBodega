
package tf.bodega_03;

import java.util.HashMap;
import java.util.Map;

public class Inventario extends Observable {
    private HashMap<Integer, Producto> productos;
    
    public Inventario() {
        productos = new HashMap<>();
        inicializarProductos();
    }
    public void agregarProducto(Producto producto) {
        productos.put(producto.getId(), producto);
        notificarObservers("Producto agregado: " + producto.getNombre());
    }
    public Producto eliminarProducto(int id) {
        Producto productoEliminado = productos.remove(id);
        if (productoEliminado != null) {
            notificarObservers("Producto eliminado: " + productoEliminado.getNombre());
        }
        return productoEliminado; // Devolver el producto eliminado o null si no se encontró
    }
    public Producto buscarProducto(int id) {
        return productos.get(id);
    }
    public void actualizarProducto(Producto producto) {
        productos.put(producto.getId(), producto);
        notificarObservers("Producto actualizado: " + producto.getNombre());
    }
    public HashMap<Integer, Producto> getProductos() {
        return productos;
    }  
    public void restablecerInventario() {
        productos.clear(); 
        // Volver a inicializar los productos originalmente
        inicializarProductos();
    }    
    private void inicializarProductos() {
        Producto producto1 = new Producto(1, "Manzana", 2.5, 10);
        Producto producto2 = new Producto(2, "Gaseosa", 3.5, 15);
        Producto producto3 = new Producto(3, "Vaso", 4.5, 20);

        productos.put(producto1.getId(), producto1);
        productos.put(producto2.getId(), producto2);
        productos.put(producto3.getId(), producto3);
    }
    public Map<Integer, String> obtenerNombresProductos() {
        Map<Integer, String> nombres = new HashMap<>();
        for (Map.Entry<Integer, Producto> entry : productos.entrySet()) {
            nombres.put(entry.getKey(), entry.getValue().getNombre());
        }
        return nombres;
    }
}
