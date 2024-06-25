package ec.edu.pucem.facturacion.gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Color;

public class FrmMenuPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JDesktopPane desktopPane;
    private JMenuItem menuItmCrearNuevo;
    private FrmCrearCliente frmCrearCliente;
    private FrmCrearProducto frmCrearProducto;
    private FrmListaCliente frmListaCliente;
    private FrmListaProductos frmListaProductos;

    public FrmMenuPrincipal() {
        setTitle("Sistema de Facturación Electrónica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 803, 614);

        // Menú de la barra superior
        JMenuBar menuBar = new JMenuBar(); 
        setJMenuBar(menuBar);

        // Menú "Archivo" de la barra superior
        JMenu menuArchivo = new JMenu("Archivo"); 
        menuArchivo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(menuArchivo);
        
        // Menú subítem "Salir" perteneciente al menú "Archivo"
        JMenuItem menuItmSalir = new JMenuItem("Salir"); 
        menuItmSalir.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuItmSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Salir del formulario.
            }
        });
        menuArchivo.add(menuItmSalir);

        // Menú "Clientes" de la barra superior
        JMenu menuClientes = new JMenu("Clientes"); 
        menuClientes.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(menuClientes);

        // Menú subítem "Nuevo cliente" perteneciente al menú "Clientes"
        menuItmCrearNuevo = new JMenuItem("Nuevo cliente"); 
        menuItmCrearNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frmCrearCliente == null || frmCrearCliente.isClosed()) { // Si el formulario de "Crear Cliente" no existe, crear uno
                    frmCrearCliente = new FrmCrearCliente(); // y agregarlo al desktopPane.
                    desktopPane.add(frmCrearCliente);
                    frmCrearCliente.setVisible(true);
                    
                    // Bloque de código para centrar el formulario "Crear Cliente"
                    Dimension desktopSize = desktopPane.getSize();
                    Dimension frameSize = frmCrearCliente.getSize();
                    frmCrearCliente.setLocation((desktopSize.width - frameSize.width) / 2,
                                                (desktopSize.height - frameSize.height) / 2);
                }
            }
        });
        menuItmCrearNuevo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuClientes.add(menuItmCrearNuevo);
        
        // Menú subítem "Lista clientes" perteneciente al menú "Clientes"
        JMenuItem menuItemListaClientes = new JMenuItem("Lista clientes");
        menuItemListaClientes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				  if (frmListaCliente == null || frmListaCliente.isClosed()) { // Si el formulario de "Lista clientes" no existe, crear uno
	                    frmListaCliente = new FrmListaCliente(null); // y agregarlo al desktopPane.
	                    desktopPane.add(frmListaCliente);
	                    frmListaCliente.setVisible(true);
	                    
	                    // Bloque de código para centrar el formulario "Lista clientes"
	                    Dimension desktopSize = desktopPane.getSize();
	                    Dimension frameSize = frmListaCliente.getSize();
	                    frmListaCliente.setLocation((desktopSize.width - frameSize.width) / 2,
	                                                (desktopSize.height - frameSize.height) / 2);
				}				
			}
        });
        menuItemListaClientes.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuClientes.add(menuItemListaClientes);

        // Menú "Productos" de la barra superior
        JMenu mnProductos = new JMenu("Productos");
        mnProductos.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(mnProductos);
        
        // Menú subítem "Nuevo producto" perteneciente al menú "Productos"
        JMenuItem menuItmProducto = new JMenuItem("Nuevo producto");
        menuItmProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  if (frmCrearProducto == null || frmCrearProducto.isClosed()) { // Si el formulario de "Nuevo producto" no existe, crear uno
	                    frmCrearProducto = new FrmCrearProducto(); // y agregarlo al desktopPane.
	                    desktopPane.add(frmCrearProducto);
	                    frmCrearProducto.setVisible(true);
	                    
	                    // Bloque de código para centrar el formulario "Nuevo producto"
	                    Dimension desktopSize = desktopPane.getSize();
	                    Dimension frameSize = frmCrearProducto.getSize();
	                    frmCrearProducto.setLocation((desktopSize.width - frameSize.width) / 2,
	                                                (desktopSize.height - frameSize.height) / 2);
				}
	       }   	
        });
        menuItmProducto.setFont(new Font("Segoe UI", Font.BOLD, 16));
        mnProductos.add(menuItmProducto);

        // Menú subítem "Lista productos" perteneciente al menú "Productos"
        JMenuItem menuItmnListaProductos = new JMenuItem("Lista productos");
        menuItmnListaProductos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (frmListaProductos == null || frmListaProductos.isClosed()) { // Si el formulario de "Nuevo producto" no existe, crear uno
                    frmListaProductos = new FrmListaProductos(null); // y agregarlo al desktopPane.
                    desktopPane.add(frmListaProductos);
                    frmListaProductos.setVisible(true);
                    
                    // Bloque de código para centrar el formulario "Nuevo producto"
                    Dimension desktopSize = desktopPane.getSize();
                    Dimension frameSize = frmListaProductos.getSize();
                    frmListaProductos.setLocation((desktopSize.width - frameSize.width) / 2,
                                                (desktopSize.height - frameSize.height) / 2);
			  }				
			}
        });
        
        menuItmnListaProductos.setFont(new Font("Segoe UI", Font.BOLD, 16));
        mnProductos.add(menuItmnListaProductos);

        // Menú "Facturar" de la barra superior
        JMenu menuFacturas = new JMenu("Facturas");
        menuFacturas.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(menuFacturas);

        // Menú subítem "Facturar" del menú "Facturar" 
        JMenuItem menuItmFacturar = new JMenuItem("Facturar");
        menuItmFacturar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrmFactura frmFactura = new FrmFactura();
                desktopPane.add(frmFactura);
                frmFactura.setVisible(true);
                
             // Bloque de código para centrar el formulario "Facturar"
                Dimension desktopSize = desktopPane.getSize();
                Dimension frameSize = frmFactura.getSize();
                frmFactura.setLocation((desktopSize.width - frameSize.width) / 2,
                                       (desktopSize.height - frameSize.height) / 2);
            }
        });
        menuItmFacturar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuItmFacturar.setIcon(null);
        menuFacturas.add(menuItmFacturar);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        desktopPane = new JDesktopPane();
        contentPane.add(desktopPane, "name_100347437736100");
    }
}
