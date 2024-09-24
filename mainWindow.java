package projeto1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        setTitle("Project 1");

        ImageIcon icon = new ImageIcon("C:\\Users\\emily\\OneDrive\\Área de Trabalho\\logounicamp.png"); // apenas teste
        setIconImage(icon.getImage());

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu configMenu = new JMenu("Configuration");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem closeItem = new JMenuItem("Close");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(openItem);
        fileMenu.add(closeItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        
        JMenuItem StandardItem = new JMenuItem("Standart");
        JMenuItem ColorItem = new JMenuItem("Color");
        JMenuItem VelocityItem = new JMenuItem("Velocity");
        configMenu.add(StandardItem);
        configMenu.add(ColorItem);
        configMenu.add(VelocityItem);

        JMenuItem HelpItem = new JMenuItem("Help");
        JMenuItem InfoItem = new JMenuItem("Information");
        helpMenu.add(HelpItem);
        helpMenu.add(InfoItem);  

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuBar.add(fileMenu);
        menuBar.add(configMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        setSize(600, 500);
        setLocationRelativeTo(null); // Center the window on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create and display the application
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainWindow();
            }
        });
    }
}

