package com.fbv.main;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import com.fbv.fachada.TelaPrincipal;

public class TelaMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TelaPrincipal framePrincipal = new TelaPrincipal();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();		
		int width = 640;
		int height = 500;
		int left = (d.width-width)/2;
		int top = (d.height-height)/2;
		framePrincipal.setBounds(left, top, width, height);		
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		framePrincipal.setVisible(true);
	}

}
