package ec.edu.pucem.facturacion.gui;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ec.edu.pucem.facturacion.models.Cliente;
import ec.edu.pucem.facturacion.models.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class FrmFactura extends JInternalFrame implements ProductoSeleccionadoListener {

    private static final long serialVersionUID = 1L;
    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JTextField txtCedula;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JTextField txtNumFactura;
    private JTable table;
    private DefaultTableModel model;
    private JTextField txtSubtotal;
    private JTextField txtIva;
    private JTextField txtTotal;
    private static ArrayList<Producto> productos = new ArrayList<Producto>();
    private static int numeroFactura = 1; // Variable estática para el próximo número de factura

    public FrmFactura() {
        setClosable(true); // Activar que sea posible cerrar la ventana
        setTitle("Nueva factura"); // Titulo del JInternalFrame
        setBounds(100, 100, 600, 500);
        getContentPane().setLayout(null);

        // Texto "Nombres:"
        JLabel lblNombre = new JLabel("Nombres:");
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblNombre.setBounds(28, 37, 72, 20);
        getContentPane().add(lblNombre);

        // Ingreso de texto para "Nombres"
        txtNombre = new JTextField();
        txtNombre.setBounds(100, 38, 200, 20);
        getContentPane().add(txtNombre);

        // Botón "Buscar cliente"
        JButton btnBuscarCliente = new JButton("Buscar Cliente");
        btnBuscarCliente.setBounds(310, 151, 120, 20);
        getContentPane().add(btnBuscarCliente);

        // Texto "Cédula"
        JLabel lblCedula = new JLabel("Cédula/RUC:");
        lblCedula.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblCedula.setBounds(28, 10, 72, 20);
        getContentPane().add(lblCedula);

        // Ingreso de texto para "Cédula"
        txtCedula = new JTextField();
        txtCedula.setBounds(100, 10, 200, 20);
        getContentPane().add(txtCedula);

        // Texto "Email"
        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblDireccion.setBounds(28, 93, 72, 20);
        getContentPane().add(lblDireccion);

        // Ingreso de texto para "Direccion"
        txtDireccion = new JTextField();
        txtDireccion.setBounds(100, 94, 200, 20);
        getContentPane().add(txtDireccion);

        // Texto "Teléfono"
        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblTelefono.setBounds(28, 123, 72, 20);
        getContentPane().add(lblTelefono);

        // Ingreso de texto "Teléfono"
        txtTelefono = new JTextField();
        txtTelefono.setBounds(100, 123, 200, 20);
        getContentPane().add(txtTelefono);
        
        // Texto "Email"
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblEmail.setBounds(28, 155, 72, 13);
        getContentPane().add(lblEmail);
        
        // Campo para el email
        txtEmail = new JTextField();
        txtEmail.setBounds(100, 152, 200, 19);
        getContentPane().add(txtEmail);
        txtEmail.setColumns(10);

        // Texto "Apellidos"
        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblApellidos.setBounds(28, 70, 57, 13);
        getContentPane().add(lblApellidos);

        // Campo para apellidos
        txtApellidos = new JTextField();
        txtApellidos.setBounds(100, 67, 200, 20);
        getContentPane().add(txtApellidos);
        txtApellidos.setColumns(10);

        // Texto para el número de factura
        JLabel lblNumFactura = new JLabel("Num. Factura:");
        lblNumFactura.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblNumFactura.setBounds(426, 10, 80, 20);
        getContentPane().add(lblNumFactura);

        // Campo para el número de factura
        txtNumFactura = new JTextField();
        txtNumFactura.setBounds(505, 11, 65, 20);
        txtNumFactura.setEditable(false); // Campo no editable
        txtNumFactura.setText(String.valueOf(getNumeroFactura())); // Asignar el próximo número de factura
        getContentPane().add(txtNumFactura);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 181, 560, 177);
        getContentPane().add(scrollPane);

        // Tabla con los datos de los productos
        table = new JTable();
        model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Cod", "Producto", "Precio", "Cantidad", "IVA", "Total IVA", "Total"}
        );
        table.setModel(model);
        scrollPane.setViewportView(table);

        // Botón "Añadir"
        JButton btnAddProducto = new JButton("Añadir");
        btnAddProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirListaProductos(); // Función para abrir el JInternalFrame de "Lista productos"
            }
        });
        btnAddProducto.setBounds(10, 366, 120, 20);
        getContentPane().add(btnAddProducto);

        // Botón "Quitar"
        JButton btnQuitarProducto = new JButton("Quitar");
        btnQuitarProducto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				quitarProducto();
			}
        
        });
        btnQuitarProducto.setBounds(139, 366, 120, 20);
        getContentPane().add(btnQuitarProducto);

        // Texto "Subtotal"
        JLabel lblSubtotal = new JLabel("SUBTOTAL:");
        lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblSubtotal.setBounds(426, 365, 65, 20);
        getContentPane().add(lblSubtotal);

        // Campo para el subtotal
        txtSubtotal = new JTextField();
        txtSubtotal.setBounds(490, 366, 80, 20);
        getContentPane().add(txtSubtotal);
        txtSubtotal.setEditable(false); // No es editable

        // Texto "IVA"
        JLabel lblIva = new JLabel("I.V.A:");
        lblIva.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblIva.setBounds(426, 389, 65, 20);
        getContentPane().add(lblIva);

        // Campo para el IVA
        txtIva = new JTextField();
        txtIva.setBounds(490, 390, 80, 20);
        getContentPane().add(txtIva);
        txtIva.setEditable(false); // No es editable

        // Texto "Total"
        JLabel lblTotal = new JLabel("TOTAL:");
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 10));
        lblTotal.setBounds(426, 414, 65, 20);
        getContentPane().add(lblTotal);

        // Campo para el total
        txtTotal = new JTextField();
        txtTotal.setBounds(490, 414, 80, 20);
        getContentPane().add(txtTotal);
        txtTotal.setEditable(false); // No es editable

        // Menú superior
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Opción "Nuevo" en el menú superior
        JMenu mnNewMenu = new JMenu("Nuevo");
        mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
        menuBar.add(mnNewMenu);

        // Subítem dentro de "Nuevo" de nombre "Nueva factura"
        JMenuItem mntmNewFactura = new JMenuItem("Nueva factura");
        mntmNewFactura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearNuevaFactura(); // Función crear nueva factura
            }
        });
        mnNewMenu.add(mntmNewFactura);

        // Agregar acción al botón de búsqueda de cliente
        btnBuscarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirListaClientes();
            }
        });
    }

    // Método para obtener el próximo número de factura
    private static int getNumeroFactura() {
        return numeroFactura++;
    }

    // Método para abrir el frame de lista de clientes
    private void abrirListaClientes() {
        FrmListaCliente frmListaCliente = new FrmListaCliente(this);
        getParent().add(frmListaCliente);
        frmListaCliente.setVisible(true);
    }

    // Método para actualizar los campos de cliente
    public void setCliente(Cliente cliente) {
        txtCedula.setText(cliente.getCedula());
        txtNombre.setText(cliente.getNombre());
        txtApellidos.setText(cliente.getApellido());
        txtDireccion.setText(cliente.getDireccion());
        txtTelefono.setText(cliente.getTelefono());
        txtEmail.setText(cliente.getEmail());
    }

    // Método para crear una nueva factura
    private void crearNuevaFactura() {
        FrmFactura nuevaFactura = new FrmFactura();
        getParent().add(nuevaFactura);
        nuevaFactura.setVisible(true);
    }

    // Método para abrir la lista de productos
    private void abrirListaProductos() {
        FrmListaProductos frmListaProductos = new FrmListaProductos(this);
        getParent().add(frmListaProductos);
        frmListaProductos.setVisible(true);
    }

    // Implementación de la interfaz ProductoSelectionListener
    @Override
    public void productoSeleccionado(Producto producto) { // Método con un parámetro con objeto de tipo "Producto"
        model.addRow(new Object[]{ // agregar a la tabla los datos los datos del nuevo objeto producto 
                producto.getCodigo(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getCantidad(),
                producto.getIva(),
                producto.getTotalIva(),
                producto.getTotal()
        });
        actualizarTotales(); // Cada que termine de agregarse los datos a la tabla model, 
        // los valores de subtotal, iva y total a pagar se actualizarán
    }

    // método para actualizar los valores totales de la factura
    private void actualizarTotales() {
        double subtotal = 0.0; // variables iniciadas en 0
        double iva = 0.0;
        double total = 0.0;

        for (int i = 0; i < model.getRowCount(); i++) { // ciclo for que recorre la cantidad de filas de la tabla
            subtotal += (double) model.getValueAt(i, 2); // almacenar en la variable subtotal los precios de tipo double (posicion 2)
            iva += (double) model.getValueAt(i, 5); // almacenar en la variable iva el total iva por producto de tipo double (posicion 5)
            total += (double) model.getValueAt(i, 6); // almacenar en la variable el total (subtotal + iva) de tipo double (posicion 6)
        }

        txtSubtotal.setText(String.valueOf(subtotal)); // obtener los resultados que almacenan las variables creadas en los Jlabel
        txtIva.setText(String.valueOf(iva));
        txtTotal.setText(String.valueOf(total));
    }
    
    // Método para quitar un producto de la factura
    private void quitarProducto() {
        int filaSeleccionada = table.getSelectedRow(); // La fila seleccionada de la tabla se almacena como entero 
        if (filaSeleccionada >= 0) { // si la fila seleccionada es mayor o igual a 0
            model.removeRow(filaSeleccionada); // se elimina de la tabla la fila seleccionada
            actualizarTotales(); // Actualizar los totales después de quitar el producto
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el producto a eliminar."); // si no existe fila seleccionada, aparece un mensaje
        }
    }
}


