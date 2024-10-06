package dev.application;

import dev.application.core.ApplicationConfig;
import dev.application.core.MainWindow;

import javax.swing.SwingUtilities;

public class MainApplication {

    public static void main(String[] args) {
        // Iniciando o programa na thread do Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Cria a configuração inicial da aplicação
                ApplicationConfig config = new ApplicationConfig();

                // Inicializa a MainWindow usando as configurações fornecidas
                new MainWindow(config);
            }
        });
    }
}