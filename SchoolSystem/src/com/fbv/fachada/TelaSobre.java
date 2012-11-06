package com.fbv.fachada;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaSobre extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlowLayout layout;	
	private Container container;	
	private JPanel panel1;	
			   
	public TelaSobre(){
		super("Sobre");	
		layout = new FlowLayout(); // configura o layout de frame		
		container = getContentPane();		
				
		panel1 = new JPanel ();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));		
			
		//ImageIcon img = new ImageIcon("src\\com\\fbv\\fachada\\BemVindo.jpg");
		ImageIcon img = new ImageIcon("BemVindo.jpg");
				
		JLabel label = new JLabel(img);
		
		label.setPreferredSize(new Dimension(640, 480));
		panel1.add(label);		
		
		add( panel1, BorderLayout.CENTER);		
		
		layout.layoutContainer(container);			
	}
	
	
}

