package clasesCompartidas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FileSamplePanel {
	  private CtrlPresentacion iCtrlPresentacion;
	  private JFrame frame;



public void activar() {
    frame.setEnabled(true);
    hacerVisible();
  }

  public void desactivar() {
    frame.setEnabled(false);
    hacerInvisible();
  }
	
	  public void hacerVisible() {
		    frame.pack();
		    frame.setVisible(true);
		  }

		  public void hacerInvisible() {
		    frame.setVisible(false);
		  }
	
  public void ini() {
	  System.out.println("Hola\n");
    frame = new JFrame("JFileChooser Popup AUXXXXX");
   // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = frame.getContentPane();

    final JLabel directoryLabel = new JLabel(" ");
    directoryLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 36));
    contentPane.add(directoryLabel, BorderLayout.NORTH);

    final JLabel filenameLabel = new JLabel(" ");
    filenameLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 36));
    contentPane.add(filenameLabel, BorderLayout.SOUTH);

    JFileChooser fileChooser = new JFileChooser(".");
    fileChooser.setControlButtonsAreShown(false);
    contentPane.add(fileChooser, BorderLayout.CENTER);

    
    
    frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
        	 iCtrlPresentacion.sincronizacionCD_a_Anadir1();
         }        
      }); 
    
    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser theFileChooser = (JFileChooser) actionEvent
            .getSource();
        String command = actionEvent.getActionCommand();
        System.out.println(command);
        if (command.equals(JFileChooser.APPROVE_SELECTION)) {
          File selectedFile = theFileChooser.getSelectedFile();
          String a = selectedFile.getParent();
          String b = selectedFile.getName();
          String c = a +"/"+ b;
          System.out.println(c+"\n");
          iCtrlPresentacion.sincronizacionCD_a_Anadir11(c);
        } else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
       	 iCtrlPresentacion.sincronizacionCD_a_Anadir1();
        }
      }
    }; 
   fileChooser.addActionListener(actionListener);

  }

	public FileSamplePanel(CtrlPresentacion pCtrlPresentacion) {
	    iCtrlPresentacion = pCtrlPresentacion;
	    ini();
	    
	  }
    
  
}

