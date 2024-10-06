package dev.application.core;

import dev.application.file.TextFilePanel;
import dev.application.ui.dialog.DialogManager;
import dev.application.file.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private JTextArea textArea;
    private FileManager fileManager;
    private DialogManager dialogManager;
    // private AnimationManager animationManager;

    public MainWindow(ApplicationConfig config) {
        // Aplica as configurações iniciais da janela
        setTitle(config.getWindowTitle());
        setSize(config.getWindowSize());

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializa os componentes da interface
        initComponents();

        // Inicializa o FileManager para manipulação de arquivos
        this.fileManager = new FileManager(this, null);

        // Inicializa o DialogManager para gerenciar os diálogos
        this.dialogManager = new DialogManager(this);

        // Inicializa o AnimationManager para gerenciar a animação de fundo
        // this.aimationManager = new AnimationManager(this);

        // Configura o JMenuBar e seus itens
        setupMenuBar();

        // Torna a janela visível
        setVisible(true);
    }

    private void initComponents() {
        // Inicializando área de texto
        this.textArea = new JTextArea();
        this.textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(this.textArea);
        this.add(scrollPane, BorderLayout.CENTER);
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
        JMenu configMenu = new JMenu("Configuration");

        JMenuItem standardItem = new JMenuItem("Standard");
        standardItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO - Adicione aqui a lógica de configuração padrão
            }
        });

        JMenuItem colorItem = new JMenuItem("Color");
        colorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO - Adicione aqui a lógica para alterar as cores do fundo
            }
        });

        JMenuItem velocityItem = new JMenuItem("Velocity");
        velocityItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO - Adicione aqui a lógica para ajustar a velocidade da animação
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