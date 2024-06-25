package ec.edu.pucem.facturacion.formulario;

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

public class FrmMenuPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JDesktopPane desktopPane;
    private JMenuItem mtmnCrearNuevo;
    private FrmCrearCliente frmCrearCliente;

    public FrmMenuPrincipal() {
        setTitle("Sistema de Facturación Electrónica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 803, 614);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnArchivo = new JMenu("Archivo");
        mnArchivo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(mnArchivo);

        JMenuItem mntmNewMenuItem = new JMenuItem("Nuevo");
        mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 16));
        mnArchivo.add(mntmNewMenuItem);

        JMenuItem mntmSalir = new JMenuItem("Salir");
        mntmSalir.setFont(new Font("Segoe UI", Font.BOLD, 16));
        mntmSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnArchivo.add(mntmSalir);

        JMenu mnClientes = new JMenu("Clientes");
        mnClientes.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(mnClientes);

        mtmnCrearNuevo = new JMenuItem("Crear nuevo");
        mtmnCrearNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (frmCrearCliente == null || frmCrearCliente.isClosed()) {
		            frmCrearCliente = new FrmCrearCliente();
		            desktopPane.add(frmCrearCliente);
		            frmCrearCliente.setVisible(true);
		        } else {
		            frmCrearCliente.toFront();
		        }
            }
        });

        mtmnCrearNuevo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        mnClientes.add(mtmnCrearNuevo);
        
        JMenuItem mntmListaClientes = new JMenuItem("Lista Clientes");
        mntmListaClientes.setFont(new Font("Segoe UI", Font.BOLD, 16));
        mnClientes.add(mntmListaClientes);

        JMenu mnProductos = new JMenu("Productos");
        mnProductos.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(mnProductos);

        JMenu mnRedes = new JMenu("Redes");
        mnRedes.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(mnRedes);

        JMenuItem FrmFacebook = new JMenuItem("Facebook");
        FrmFacebook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	FrmFacebook frmFacebook = new FrmFacebook();
            	desktopPane.add(frmFacebook);
            	frmFacebook.setVisible(true);
            }
        });
        FrmFacebook.setFont(new Font("Segoe UI", Font.BOLD, 16));
        FrmFacebook.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/ec/edu/pucem/facturacion/imagen/facebook.png")));
        mnRedes.add(FrmFacebook);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        desktopPane = new JDesktopPane();
        contentPane.add(desktopPane, "name_100347437736100");
    }
}