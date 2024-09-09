
package tf.bodega_03;


public class Main {

    public static void main(String[] args) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Inventario inventario = new Inventario(); // Crear una instancia de Inventario
                new GUI_BODEGA(inventario).setVisible(true); // Pasar la instancia al constructor
            }
        });
    }
}
