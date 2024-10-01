package projeto1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {
    private JTextArea textArea;
    private FileOperations fileOperations;

    public MainWindow() {
        setTitle("Project 1");
        fileOperations = new FileOperations(this);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

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

        JMenuItem StandardItem = new JMenuItem("Standard");
        JMenuItem ColorItem = new JMenuItem("Color");
        JMenuItem VelocityItem = new JMenuItem("Velocity");
        configMenu.add(StandardItem);
        configMenu.add(ColorItem);
        configMenu.add(VelocityItem);

        JMenuItem HelpItem = new JMenuItem("Help");
        JMenuItem InfoItem = new JMenuItem("Information");
        helpMenu.add(HelpItem);
        helpMenu.add(InfoItem);

        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileOperations.openFile(textArea);
            }
        });

        closeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        HelpItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HelpDialog(MainWindow.this).showDialog();
            }
        });

        InfoItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new InfoDialog(MainWindow.this).showDialog();
            }
        });

        menuBar.add(fileMenu);
        menuBar.add(configMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainWindow();
            }
        });
    }
}
