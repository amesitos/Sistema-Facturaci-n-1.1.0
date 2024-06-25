package ec.edu.pucem.facturacion.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ec.edu.pucem.facturacion.models.Producto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmListaProductos extends JInternalFrame {

    	private static final long serialVersionUID = 1L;
        private JTable table;
        private DefaultTableModel model;
        private ProductoSeleccionadoListener listener; // Agregar un listener para la selección de productos

        public FrmListaProductos(ProductoSeleccionadoListener listener) { // Parámetro que llama al listener ProductoSeleccionado
            this.listener = listener;
            setClosable(true); // Ventana que se cierra
            setTitle("Lista de productos");
            setBounds(100, 100, 520, 500);
            getContentPane().setLayout(null);

            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(21, 20, 470, 430);
            getContentPane().add(scrollPane);

            // crear una tabla con los objetos que son los datos de los productos
            table = new JTable();
            model = new DefaultTableModel(
                    new Object[][]{},
                    new String[]{"Código", "Nombre", "Precio", "Cantidad", "IVA", "Total IVA", "Total"}
            );
            table.setModel(model);
            scrollPane.setViewportView(table);

            // Llenar la tabla con los productos existentes
            llenarTabla();

            // Mouse listener para manejar la selección de productos
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) { // Si se hace un click en una fila
                        int selectedRow = table.getSelectedRow(); // se selecciona esa fila
                        if (selectedRow != -1) { 
                            Producto producto = FrmCrearProducto.productos.get(selectedRow);
                            if (listener != null) {
                                listener.productoSeleccionado(producto);
                            }
                            dispose(); // Cerrar la ventana después de seleccionar un producto
                        }
                    }
                }
            });
        }

        private void llenarTabla() { // Método para llenar la tabla
            for (Producto producto : FrmCrearProducto.productos) { // for que recorre la lista de los productos en FrmCrearProducto
                model.addRow(new Object[]{ // Almacenar los datos de los getters en Producto en la tabla
                        producto.getCodigo(),
                        producto.getNombre(),
                        producto.getPrecio(),
                        producto.getCantidad(),
                        producto.getIva(),
                        producto.getTotalIva(),
                        producto.getTotal()
                });
            }
        }
}
