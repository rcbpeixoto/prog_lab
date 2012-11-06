package com.fbv.fachada;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import com.fbv.Class.Curso;


public class TelaConsultaCurso extends JFrame{
	
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnTop;
	private JButton btnTop[];
	private String vTipoPesquisa;
	private JTextField textFieldNome;
	private final String btTopNome[] = {"Pesquisar"};
	
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
	public TelaConsultaCurso(){
		super("Consulta de Curso");
		layout = new FlowLayout(); // configura o layout de frame		
		container = getContentPane();
		//layout.setAlignment(FlowLayout.LEFT);		
		//setLayout( layout );		
		
		buttons = new JButton[btNomes.length];
		btnTop = new JButton[btTopNome.length];
		
		//Criar Panels
		pnTop = new JPanel ();
		pnTop.setBackground(new Color(90, 120, 255));
				
		panel1 = new JPanel ();
		panel2 = new JPanel ();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		/* INICIO TOPO */
		
		JRadioButton codButton = new JRadioButton("Código");
		codButton.setActionCommand("Código");		
		codButton.setBackground(new Color(90, 120, 255));
	    pnTop.add(codButton);
	    
	    JRadioButton nomeButton = new JRadioButton("Nome");	    
	    nomeButton.setActionCommand("Nome");
	    nomeButton.setBackground(new Color(90, 120, 255));
	    nomeButton.setSelected(true);
	    pnTop.add(nomeButton);
	    
	    //Groupo do Radio Button
	    ButtonGroup group = new ButtonGroup();
	    group.add(codButton);
	    group.add(nomeButton);
	    
	    textFieldNome = new JTextField(20);		
		pnTop.add(textFieldNome, BorderLayout.WEST);
		
		ButtonHandler btnHandler = new ButtonHandler ();
		for (int i = 0; i < btTopNome.length; i++) {
			btnTop[i] = new JButton( btTopNome[i]);
			pnTop.add( btnTop[i]);
			btnTop[i].addActionListener( btnHandler );	
		}
		
		/* FIM TOPO */
	    
		
		label1 = new JLabel("Codigo: ",null,SwingConstants.LEFT);
		panel1.add(label1); //adiciona label1 ao jframe		
		
		textField1 = new JTextField(35);		
		panel1.add(textField1, BorderLayout.WEST); //adiciona textField1 ao JFrame
		
		label2 = new JLabel("Nome:   ",null,SwingConstants.LEFT);		
		panel2.add(label2); //adiciona label1 ao jframe
		
		textField2 = new JTextField(35);
		panel2.add(textField2, BorderLayout.WEST); //adiciona textfield2 ao jframe
				
		
		//Criar Panel e Buttons
		buttonJPanel = new JPanel ();
		buttonJPanel.setLayout(new GridLayout (1, buttons.length));
		for (int i = 0; i < btNomes.length; i++) {
			buttons[i] = new JButton( btNomes[i]);
			buttonJPanel.add( buttons[i]);
			buttons[i].addActionListener( btnHandler);	
		}		
		
		setLayout(new GridLayout(4,1));
		add( pnTop, BorderLayout.NORTH);
		add( panel1, BorderLayout.NORTH);
		add( panel2, BorderLayout.NORTH);
		add( buttonJPanel, BorderLayout.SOUTH);		
		
		layout.layoutContainer(container);
		
		RadioHandler radioHandler = new RadioHandler ();
		codButton.addActionListener( radioHandler);
	    nomeButton.addActionListener( radioHandler );
	    vTipoPesquisa = "DESCRICAO";
		
		TextFieldHandler handler = new TextFieldHandler ();		 
		textField1.addActionListener( handler );
		textField2.addActionListener( handler );			
		
	}//fim do construtor TextFieldFrame
	
	private class RadioHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Código"){
				vTipoPesquisa = "codigo";
			} else if (e.getActionCommand() == "Nome"){
				vTipoPesquisa = "DESCRICAO";
			}
		}
	}
	
	
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
			Curso curso;
			//Botão Pesquisar
			if (event.getSource() == btnTop[0]) {
				curso =  Curso.consultaCurso(textFieldNome.getText(),vTipoPesquisa);
				if (curso != null) {
					textField1.setText(curso.getCodigo());
					textField2.setText(curso.getDescricao());
					textField1.requestFocus();
				} else{
					string = "Curso "+textFieldNome.getText()+" não encontrado!";
					textFieldNome.requestFocus();
				}
			  //Botão Salvar
			} else if (event.getSource() == buttons[0]) {
				curso =  Curso.consultaCurso(textFieldNome.getText(),vTipoPesquisa);
				try {
					curso.setCodigo(textField1.getText());
					curso.setDescricao(textField2.getText());					
					string = "Curso "+textField2.getText()+" salvo com sucesso!";
					textField1.setText("");
					textField2.setText("");
					textFieldNome.setText("");
					textFieldNome.requestFocus();
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					JOptionPane.showMessageDialog(null, "Preenchar os Campos Obrigatorios");
				
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					JOptionPane.showMessageDialog(null, "Preenchar os Campos Obrigatorios");
				}
			}
			//Botão Limpar
			else if (event.getSource() == buttons[1]) {
				textField1.setText("");
				textField2.setText("");
				textField1.requestFocus();
			}
			//Botão Sair
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

