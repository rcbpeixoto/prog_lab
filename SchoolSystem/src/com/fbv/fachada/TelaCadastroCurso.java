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

import com.fbv.Class.Curso;


public class TelaCadastroCurso extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label1;
	private JLabel label2;	
	private JTextField textField1;
	private JTextField textField2;	
	private FlowLayout layout;	
	private Container container;	
	private JButton buttons[];	
	private final String btNomes[] = {"Salvar", "Limpar", "Sair"};
	private JPanel buttonJPanel;
	private JPanel panel1, panel2;	
    
    int vCadastra = 0;	
	
	// contrutor TextFieldFrame adiciona JTextFields a JFrame
	public TelaCadastroCurso(){
		super("Cadastro de Curso");
		layout = new FlowLayout(); // configura o layout de frame		
		container = getContentPane();
		//layout.setAlignment(FlowLayout.LEFT);		
		//setLayout( layout );		
		
		buttons = new JButton[ btNomes.length];
		
		//Criar Panels
		panel1 = new JPanel ();
		panel2 = new JPanel ();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		label1 = new JLabel("Codigo:      ",null,SwingConstants.LEFT);
		panel1.add(label1); //adiciona label1 ao jframe		
		
		textField1 = new JTextField(25);		
		panel1.add(textField1, BorderLayout.WEST); //adiciona textField1 ao JFrame
		
		label2 = new JLabel("Disciplina: ",null,SwingConstants.LEFT);		
		panel2.add(label2); //adiciona label1 ao jframe
		
		textField2 = new JTextField(25);
		panel2.add(textField2, BorderLayout.WEST); //adiciona textfield2 ao jframe
				
		
		//Criar Panel e Buttons
		buttonJPanel = new JPanel ();
		buttonJPanel.setLayout(new GridLayout (1, buttons.length));		
		ButtonHandler btnHandler = new ButtonHandler ();
		for (int i = 0; i < btNomes.length; i++) {
			buttons[i] = new JButton( btNomes[i]);
			buttonJPanel.add( buttons[i]);
			buttons[i].addActionListener( btnHandler);	
		}		
		
		setLayout(new GridLayout(3,1));
		add( panel1, BorderLayout.NORTH);
		add( panel2, BorderLayout.NORTH);
		add( buttonJPanel, BorderLayout.SOUTH);		
		
		layout.layoutContainer(container);
		
		TextFieldHandler handler = new TextFieldHandler ();		 
		textField1.addActionListener( handler );
		textField2.addActionListener( handler );
				
		
	}//fim do construtor TextFieldFrame
	
	
	//classe interna private para tratamento de evento
	private class TextFieldHandler implements ActionListener{

		//@Override
		public void actionPerformed(ActionEvent event) {
			//String string = ""; //declara string a ser exibida
			
			layout.setAlignment(FlowLayout.LEFT);
			setLayout( layout );
			
			//usuario pressionou Enter no JTextField textField1
			if ( event.getSource()== textField1){
				//string = String.format( "textField1: %s", event.getActionCommand());
				textField2.requestFocus();
			} 
			// usuario pressionou enter no JTextField2
			else if (event.getSource() == textField2) {			
				buttons[0].requestFocus();
			}
		}//Fim do metodo actionPerformed
		
	}
	
	private class ButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			String string = ""; //declara string a ser exibida						
			if (event.getSource() == buttons[0]) {				
				Curso curso = new Curso();
				Curso[] disciplinas = Curso.listarCursos();
				try {
					curso.setCodigo(textField1.getText());				
					curso.setDescricao(textField2.getText());				
					disciplinas[curso.getIdCurso()] = curso;				
					string = "Curso "+textField2.getText()+" salvo com sucesso!";
					textField1.setText("");
					textField2.setText("");				
					textField1.requestFocus();					
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					JOptionPane.showMessageDialog(null, "Preenchar os Campos Obrigatorios");
			
				} catch (IllegalArgumentException er) {
					// TODO Auto-generated catch block
					System.out.println(er);
					JOptionPane.showMessageDialog(null, "Preenchar os Campos Obrigatorios");
				}	
				
			}
			else if (event.getSource() == buttons[1]) {
				textField1.setText("");
				textField2.setText("");
				textField1.requestFocus();
			}
			else if (event.getSource() == buttons[2]) {
				dispose();				
			}
			
			// exibe o conteudo de jtextfield
			if (string.equalsIgnoreCase("")){}else{
				JOptionPane.showMessageDialog(null, string);
			}
		}//Fim do metodo actionPerformed
		
	}
	
}

