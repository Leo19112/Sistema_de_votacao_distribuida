package projeto1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class mainWindow extends JFrame{
	private JTextArea textArea;
		
	public mainWindow() {
		setTitle("Project 1");
		
		// Create textArea and add a panel with scroll pane
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
		
		openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile();
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
				showHelpDialog();
			}
		});
		
		InfoItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showInfoDialog();
			}
		});
		
		menuBar.add(fileMenu);
		menuBar.add(configMenu);
		menuBar.add(helpMenu);
		setJMenuBar(menuBar);
		
		setSize(600, 500);
		setLocationRelativeTo(null); // center the window on the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void openFile() {
		JFileChooser fileChooser = new JFileChooser();
		int option = fileChooser.showOpenDialog(this);
		if (option == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				textArea.read(reader,  null); // read the file content in the JTextArea
				reader.close();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(this, "File not found: " + file.getName());
			}
			
			
			catch(IOException e) {
				JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage());
			}
		}
	}
	
	private void showHelpDialog() {
		JDialog helpDialog = new JDialog(this, "Help - Project POO", true);
		helpDialog.setSize(400, 300);
		helpDialog.setLayout(new BorderLayout());
		
		JTextArea helpText = new JTextArea();
		helpText.setText("Welcome to the Project of the Discipline SI400\n\n" + 
				"This project is a Java application with graphical interface that allow you to:\n" + 
				"- Open and view text files\n" +
				"- Modify graphical patterns in the background\n" + 
				"- Adjust colors and speeds\n" + 
				"- Customize the interface with different configuration options.\n\n" +
				"Use the menus to explore the featues.\n" + 
				"Thank you for using our application!");
		helpText.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(helpText);
		
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\leona\\Downloads\\Logotipo_UNICAMP.jpg"); // Teste da imagem
		Image image = imageIcon.getImage();
		Image resizedImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(resizedImage);
		JLabel imageLabel = new JLabel(imageIcon);
		
		
		JPanel buttonPanel = new JPanel();
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				helpDialog.dispose();
			}
		});
		buttonPanel.add(closeButton);
		
		helpDialog.add(imageLabel, BorderLayout.NORTH);
		helpDialog.add(scrollPane, BorderLayout.CENTER);
		helpDialog.add(buttonPanel, BorderLayout.SOUTH);
		
		helpDialog.setLocationRelativeTo(this);
		helpDialog.setVisible(true);
	}
	
	private void showInfoDialog() {
		JOptionPane.showMessageDialog(
				this,
				"Project POO\n Version 1.0\nAuthors: Leonardo Basset, Emily Silva, Pedro Evandro, Lucas Gabriel, Gabriel Mendes\n\n" + 
					"This software was developed as part of an academic project for the discipline SI400.",
					"About - Project",
					JOptionPane.INFORMATION_MESSAGE);
	}
	public static void main(String[] args) {
		// create and display the application
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new mainWindow();
			}
		});
	}
}
