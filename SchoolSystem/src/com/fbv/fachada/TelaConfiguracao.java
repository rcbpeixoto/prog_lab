package com.fbv.fachada;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.fbv.Class.Configuracao;

public class TelaConfiguracao extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label1; //Campo costruioido com texto
	private JLabel label2; //Campo costruioido com texto	
	private JTextField textField1; //Campo de texto com tamanho configurado	
	private FlowLayout layout;	
	private Container container;	
	private JButton buttons[];	
	private final String btNomes[] = {"Salvar", "Sair"};
	private JPanel buttonJPanel;
	private JPanel panel1, panel2;	
	private static Configuracao Conf[] = Configuracao.retornaConf();
	 	
    
    int vCadastra = 0;	
	

	public TelaConfiguracao(){
		super("Configuração");
		layout = new FlowLayout(); // configura o layout de frame		
		container = getContentPane();
		
		buttons = new JButton[ btNomes.length];
		
		//Criar Panels
		panel1 = new JPanel ();
		panel2 = new JPanel ();		
		buttonJPanel = new JPanel ();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		buttonJPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
				
		
		label1 = new JLabel("Configurações Gerais ");//,null,SwingConstants.CENTER);
		panel1.add(label1,BorderLayout.CENTER); //adiciona label1 ao jframe		
		
		label2 = new JLabel("  Media:  ",null,SwingConstants.LEFT);		
		panel2.add(label2); //adiciona label1 ao jframe
		
		textField1 = new JTextField(8);		
		panel2.add(textField1, BorderLayout.WEST); //adiciona textField1 ao JFrame
		
		
		if (Conf[0] != null){
			textField1.setText(Conf[0].getMedia()+"");
		}
		/*try {
			Conf = Configuracao.retornaConf();
			textField1.setText(Conf[0].getMedia()+"");
		} catch (NullPointerException e){
			System.out.println(e);			
		}*/		
		
		//Criar Panel e Buttons		
		ButtonHandler btnHandler = new ButtonHandler ();
		for (int i = 0; i < btNomes.length; i++) {
			buttons[i] = new JButton( btNomes[i]);
			buttonJPanel.add( buttons[i]);
			buttons[i].addActionListener( btnHandler);	
		}		
		
		
		setLayout(new GridLayout(3,1));
		add( panel1, BorderLayout.CENTER);		
		add( panel2, BorderLayout.NORTH);
		add( buttonJPanel);//, BorderLayout.WEST);
		
		layout.layoutContainer(container);
		
	}//fim do construtor TextFieldFrame
	
	
	
	private class ButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			String string = ""; //declara string a ser exibida
						
			if (event.getSource() == buttons[0]) {
				try {
					//Configuracao conf = new Configuracao(Double.parseDouble(textField1.getText()));
					Configuracao conf = new Configuracao();				
					conf.setMedia( Double.parseDouble(textField1.getText()));
					Conf[0] = conf;
					
					string = "Configurações salva com sucesso!";				
					textField1.requestFocus();
					
				} catch (NumberFormatException e){
					System.out.println(e);					
					JOptionPane.showMessageDialog(null, " Média invalida!");
				}
				
			}			
			else if (event.getSource() == buttons[1]) {
				dispose();				
			}
			
			// exibe o conteudo de jtextfield
			if (string.equalsIgnoreCase("")){}else{
				JOptionPane.showMessageDialog(null, string);
			}
		}//Fim do metodo actionPerformed
		
	}
	
}

