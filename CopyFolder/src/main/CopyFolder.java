package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CopyFolder extends JFrame {

	private JPanel contentPane;
	private JTextField srcPath;
	private JTextField targetPath;

	/**
	 * Launch the application.
	 */
	private static String srcPathFolder = "";
	private static String targetPathFolder = "";
	
	public static void main(String[] args) {
		try {
			if(args[0] != null && args[1] != null)
			{
				srcPathFolder = args[0];
				targetPathFolder = args[1];
				File sourceFolder = new File(srcPathFolder);
				File targetFolder = new File(targetPathFolder);
				copyFolder(sourceFolder, targetFolder);
				return;
			}
		}catch(Exception ex)
		{
			System.out.println("Error in Cmd! Loi khi copy, xem lai cu phap!");
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopyFolder frame = new CopyFolder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void copyFolder(File sourceFolder, File targetFolder) 
            throws IOException {
        if (sourceFolder.isDirectory()) {
            if (!targetFolder.exists()) {
                targetFolder.mkdir();
                System.out.println("Thu muc da duoc tao " + targetFolder);
            }
            String files[] = sourceFolder.list();
            for (String file : files) {
                File srcFile = new File(sourceFolder, file);
                File tarFile = new File(targetFolder, file);
                copyFolder(srcFile, tarFile);
            }
        } else {
            Files.copy(sourceFolder.toPath(), targetFolder.toPath(), 
                    StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File da duoc copy " + targetFolder);
        }
    }

	/**
	 * Create the frame.
	 */
	public CopyFolder() {
		setTitle("Copy Very Easy @tranphuquy19");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSourceFolder = new JLabel("Source Folder");
		lblSourceFolder.setBounds(10, 11, 98, 14);
		contentPane.add(lblSourceFolder);
		
		srcPath = new JTextField();
		srcPath.setBounds(129, 8, 242, 20);
		contentPane.add(srcPath);
		srcPath.setColumns(10);
		
		targetPath = new JTextField();
		targetPath.setBounds(129, 39, 242, 20);
		contentPane.add(targetPath);
		targetPath.setColumns(10);
		
		JLabel lblTargetFolder = new JLabel("Target Folder");
		lblTargetFolder.setBounds(10, 42, 98, 14);
		contentPane.add(lblTargetFolder);
		
		JButton btnCopy = new JButton("Copy");
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ahihi");
				File srcFolder = new File(srcPath.getText().trim().toString());
				File targetFolder = new File(targetPath.getText().trim().toString());
				try {
					copyFolder(srcFolder, targetFolder);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnCopy.setBounds(282, 70, 89, 23);
		contentPane.add(btnCopy);
	}
}
