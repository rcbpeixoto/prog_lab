package com.fbv.fachada;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import com.fbv.Class.Curso;
import com.fbv.Class.Disciplina;


public class TelaConsultaDisciplina extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String vTipoPesquisa;
	private JLabel label1;
	private JLabel label2;
	
	private JTextField textFieldNome;
	private JTextField textField1;
	private JTextField textField2;	
	
	private FlowLayout layout;	
	private Container container;
	
	private JButton btnTop[];	
	private final String btTopNome[] = {"Pesquisar"};
	
	private JButton buttons[];
	private final String btNomes[] = {"Salvar","Excluir", "Limpar", "Sair"};
	private JPanel buttonJPanel;
	private JPanel pnTop, panel1, panel2, panel3;	
	private JList list;
	
	
    int vCadastra = 0;	
	
	// contrutor TextFieldFrame adiciona JTextFields a JFrame
	public TelaConsultaDisciplina(){
		super("Consulta de Disciplina");
		layout = new FlowLayout(); // configura o layout de frame		
		container = getContentPane();
		//layout.setAlignment(FlowLayout.LEFT);		
		//setLayout( layout );		
		
		buttons = new JButton[ btNomes.length];
		btnTop = new JButton[ btTopNome.length];
		
		//Criar Panels
		pnTop = new JPanel ();
		pnTop.setBackground(new Color(90, 120, 255));
		
		panel1 = new JPanel ();
		panel2 = new JPanel ();
		panel3 = new JPanel ();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		JRadioButton cpfButton = new JRadioButton("Cód.");
		cpfButton.setActionCommand("Código");		
		cpfButton.setBackground(new Color(90, 120, 255));
	    pnTop.add(cpfButton);
	    
	    JRadioButton nomeButton = new JRadioButton("Descrição");	    
	    nomeButton.setActionCommand("Descricao");
	    nomeButton.setBackground(new Color(90, 120, 255));
	    nomeButton.setSelected(true);
	    pnTop.add(nomeButton);
	    
	    //Groupo do Radio Button
	    ButtonGroup group = new ButtonGroup();
	    group.add(cpfButton);
	    group.add(nomeButton);
		
		//lbNome = new JLabel("Aluno: ",null,SwingConstants.LEFT);
		//pnTop.add(lbNome);
		textFieldNome = new JTextField(20);		
		pnTop.add(textFieldNome, BorderLayout.WEST);
		
		ButtonHandler btnHandler = new ButtonHandler ();
		for (int i = 0; i < btTopNome.length; i++) {
			btnTop[i] = new JButton( btTopNome[i]);
			pnTop.add( btnTop[i]);
			btnTop[i].addActionListener( btnHandler );	
		}
		
		
		label1 = new JLabel("Codigo:      ",null,SwingConstants.LEFT);
		panel1.add(label1); //adiciona label1 ao jframe		
		
		textField1 = new JTextField(35);		
		panel1.add(textField1, BorderLayout.WEST); //adiciona textField1 ao JFrame
		
		label2 = new JLabel("Disciplina: ",null,SwingConstants.LEFT);		
		panel1.add(label2); //adiciona label1 ao jframe
		
		textField2 = new JTextField(35);
		panel1.add(textField2, BorderLayout.WEST); //adiciona textfield2 ao jframe
		
		
		Curso[] curso = Curso.listarCursos();
		DefaultListModel listModel = new DefaultListModel();
		for (int i = 0; i < curso.length; i++) {
			if (curso[i] != null){
				listModel.addElement(curso[i].getDescricao());
			}
		}
		
		list = new JList(listModel); //data has type Object[]		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(5);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(455, 50));
		panel3.add(listScroller);
		
		
		
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
		//add( panel2, BorderLayout.NORTH);
		add( panel3, BorderLayout.NORTH);
		add( buttonJPanel, BorderLayout.SOUTH);		
		
		layout.layoutContainer(container);
		
		TextFieldHandler handler = new TextFieldHandler ();		 
		textField1.addActionListener( handler );
		textField2.addActionListener( handler );
		
		RadioHandler radioHandler = new RadioHandler ();
		cpfButton.addActionListener( radioHandler);
	    nomeButton.addActionListener( radioHandler );
	    vTipoPesquisa = "DESCRICAO";
	    
	    				
		
	}//fim do construtor TextFieldFrame
	
	private class RadioHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Código"){
				vTipoPesquisa = "CODIGO";
			} else if (e.getActionCommand() == "Descricao"){
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
			Disciplina dis;
			//Botão Pesquisar
			if (event.getSource() == btnTop[0]) {
				dis =  Disciplina.consultaDisciplina(textFieldNome.getText(),vTipoPesquisa);
				if (dis != null) {
					textField1.setText(dis.getCodigo());
					textField2.setText(dis.getDescricao());
					textField1.requestFocus();
				} else{
					string = "Disciplina "+textField2.getText()+" não encontrada!";
					textFieldNome.requestFocus();
				}
			//Botão Salvar								
			} else if (event.getSource() == buttons[0]) {
				dis =  Disciplina.consultaDisciplina(textFieldNome.getText(),vTipoPesquisa);
				try {
					dis.setCodigo(textField1.getText());
					dis.setDescricao(textField2.getText());
					if (list.getSelectedIndex() < 0){
						list.setSelectedIndex(list.getFirstVisibleIndex());
					}
					dis.setCurso(Curso.listarCursos( list.getSelectedValue().toString() ));
					string = "Disciplina "+textField2.getText()+" salva com sucesso!";
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
			//Botão Excluir
			else if (event.getSource() == buttons[1]) {
				try {
					if (Disciplina.excluirDisciplina(textFieldNome.getText(),vTipoPesquisa)){
						string = "Aluno "+textField2.getText()+" excluido com sucesso!";
						//Texto Codigo
						textField1.setText("");
						//Texto Descricao
						textField2.setText("");
						textField1.requestFocus();
								
					}
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
			//Botão Limpar
			else if (event.getSource() == buttons[2]) {
				textField1.setText("");
				textField2.setText("");
				textField1.requestFocus();
			}
			//Botão Sair
			else if (event.getSource() == buttons[3]) {
				dispose();				
			}
			
			// exibe o conteudo de jtextfield
			if (string.equalsIgnoreCase("")){}else{
				JOptionPane.showMessageDialog(null, string);
			}
		}
		
	}
	
}

