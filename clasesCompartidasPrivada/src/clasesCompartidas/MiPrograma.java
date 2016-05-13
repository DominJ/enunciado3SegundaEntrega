package clasesCompartidas;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MiPrograma {
	public static void main (String[] args) {
		javax.swing.SwingUtilities.invokeLater (new Runnable() {
			public void run() {
					//CtrlPresentacion ctrlPresentacion = new CtrlPresentacion();
					//ctrlPresentacion.inicializarPresentacion();
					
					JFrame ventana = new JFrame("MENU PRINCIPAL");
				    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 5, 25);
				    ventana.setLayout(layout);
				  
				    
				    JLabel etiqueta = new JLabel("MENU PRINCIPAL");
				    etiqueta.setForeground(Color.RED);
				    ventana.add(etiqueta);
				    
				    // DEFINIMOS ESCUCHADOR DE EVENTOS PARA CUANDO HAGAMOS CLICK SOBRE LOS BOTONES
				    ActionListener escuchador = new ActionListener() {
				        @Override
				        public void actionPerformed(ActionEvent ae) {
				             JButton boton = (JButton) ae.getSource();
				             String nombreBoton = boton.getText();
				 
				             switch (nombreBoton) {
				                 case "Modificar base de datos":
				 					//llamar a funciones
				                   JFrame ventana = new JFrame("Modificar base de datos");
				 				   ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE );
				 					
				 				   FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 5, 25);
				 				   ventana.setLayout(layout);
				 				    
				 				   ventana.setSize(800, 200);
								   ventana.setVisible(true);
				 				  
				                    break;
				                 case "Realizar una consulta":
				                	//llamar a funciones
				                    break;
				                 case "Buscar en el historial":
				                	//llamar a funciones
				                    break;
				                 case "Salir":
				                    System.exit(0);
				                    break;
				             }
				         }

						public void actionPerformed2(ActionEvent e) {
							// TODO Auto-generated method stub
							
						}
				     };
				     
				     // BOTONES
				     String titulosBotones[] = {"Modificar base de datos", "Realizar una consulta", "Buscar en el historial", "Salir"};
				 
				     for (String tituloBoton : titulosBotones) {
				         JButton boton = new JButton(tituloBoton);
				         boton.setSize(new Dimension(150, 80));
				         ventana.add(boton);
				         boton.addActionListener(escuchador);
				     }
				     
				  // END
				     ventana.setSize(800, 200);
				     ventana.setVisible(true);
				 
			}
		});
	}
}





