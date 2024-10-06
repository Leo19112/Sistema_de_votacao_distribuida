package dev.application.core;

import dev.application.file.TextFilePanel;
import dev.application.ui.dialog.DialogManager;
import dev.application.file.FileManager;
import dev.application.ui.AnimationManager;
import dev.application.ui.AnimationPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private JTextArea textArea;
    private FileManager fileManager;
    private DialogManager dialogManager;
    private AnimationManager animationManager;
    private AnimationPanel animationPanel;

    public MainWindow(ApplicationConfig config) {
        // Configurações iniciais da janela
        setTitle(config.getWindowTitle());
        setSize(config.getWindowSize());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        // Inicializa o AnimationPanel
        this.animationPanel = new AnimationPanel();
    
        // Inicializa o AnimationManager
        this.animationManager = new AnimationManager(this.animationPanel);
    
        // Inicializa os componentes da interface
        initComponents();
    
        // Inicializa o FileManager
        this.fileManager = new FileManager(this, null);
    
        // Inicializa o DialogManager
        this.dialogManager = new DialogManager(this);
    
        // Inicia a animação
        this.animationManager.startAnimation();
    
        // Configura o JMenuBar
        setupMenuBar();
    
        // Torna a janela visível
        setVisible(true);
    }

    private void initComponents() {
        // Inicializando área de texto
        this.textArea = new JTextArea();
        this.textArea.setEditable(false);
        this.textArea.setOpaque(false); // Torna o JTextArea transparente
    
        JScrollPane scrollPane = new JScrollPane(this.textArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
    
        // Cria um painel com OverlayLayout para sobrepor componentes
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new OverlayLayout(contentPanel));
    
        // Adiciona os componentes ao painel de conteúdo
        contentPanel.add(scrollPane);
        contentPanel.add(this.animationPanel);
    
        // Define o painel de conteúdo como o content pane da janela
        this.setContentPane(contentPanel);
    }
    

    private void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = createFileMenu();
        menuBar.add(fileMenu);

        JMenu configMenu = createConfigMenu();
        menuBar.add(configMenu);

        JMenu helpMenu = createHelpMenu();
        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);
    }

    private JMenu createFileMenu() {
        JMenu fileMenu = new JMenu("File");

        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileManager.setFilePanel(new TextFilePanel());
                fileManager.readFile(textArea);
            }
        });

        JMenuItem closeItem = new JMenuItem("Close");
        closeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        fileMenu.add(openItem);
        fileMenu.add(closeItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        return fileMenu;
    }

    private JMenu createConfigMenu() {
        JMenu configMenu = new JMenu("Config");
    
        JMenuItem standardItem = new JMenuItem("Pattern");
        standardItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Solicita ao usuário um novo tipo de padrão
                String input = JOptionPane.showInputDialog(MainWindow.this, "Enter the animation pattern type (0-2):\n0 - Diagonal\n1 - Horizontal\n2 - Vertical", "Pattern", JOptionPane.PLAIN_MESSAGE);
                try {
                    int patternType = Integer.parseInt(input);
                    if (patternType >= 0 && patternType <= 2) {
                        animationManager.setPattern(patternType);
                    } else {
                        JOptionPane.showMessageDialog(MainWindow.this, "Please, insert a number between 0 and 2.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainWindow.this, "Invalid input.");
                }
            }
        });
    
        JMenuItem colorItem = new JMenuItem("Colors");
        colorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abre um seletor de cores
                Color newColor = JColorChooser.showDialog(MainWindow.this, "Choose a color", Color.BLUE);
                if (newColor != null) {
                    animationManager.setColor(newColor);
                }
            }
        });
    
        JMenuItem velocityItem = new JMenuItem("Velocity");
        velocityItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Solicita ao usuário uma nova velocidade
                String input = JOptionPane.showInputDialog(MainWindow.this, "Enter the animation speed (1-100):", "Speed", JOptionPane.PLAIN_MESSAGE);
                try {
                    int speed = Integer.parseInt(input);
                    if (speed >= 1 && speed <= 100) {
                        animationManager.setSpeed(speed);
                    } else {
                        JOptionPane.showMessageDialog(MainWindow.this, "Please, insert a number between 1 and 100.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainWindow.this, "Invalid input.");
                }
            }
        });
    
        configMenu.add(standardItem);
        configMenu.add(colorItem);
        configMenu.add(velocityItem);
    
        return configMenu;
    }

    private JMenu createHelpMenu() {
        JMenu helpMenu = new JMenu("Help");

        JMenuItem helpItem = new JMenuItem("Help");
        helpItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialogManager.showHelpDialog();
            }
        });

        JMenuItem infoItem = new JMenuItem("Information");
        infoItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialogManager.showInfoDialog();
            }
        });

        helpMenu.add(helpItem);
        helpMenu.add(infoItem);

        return helpMenu;
    }
}