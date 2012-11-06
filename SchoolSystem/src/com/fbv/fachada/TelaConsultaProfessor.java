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

import com.fbv.Class.Disciplina;
import com.fbv.Class.Professor;

public class TelaConsultaProfessor extends JFrame{
	
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
	private JLabel label3;
	private JLabel label4;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;		
	private FlowLayout layout;	
	private Container container;	
	private JButton buttons[];	
	private final String btNomes[] = {"Salvar","Excluir", "Limpar", "Sair"};
	private JPanel buttonJPanel;
	private JPanel panel1, panel2, panel3, panel4;	
	private JList list;
    
    int vCadastra = 0;	
	
	// contrutor TextFieldFrame adiciona JTextFields a JFrame
	public TelaConsultaProfessor(){
		super("Consulta de Professor");
		layout = new FlowLayout(); // configura o layout de frame		
		container = getContentPane();
		//layout.setAlignment(FlowLayout.LEFT);		
		//setLayout( layout );		
		
		buttons = new JButton[ btNomes.length];
		btnTop = new JButton[btTopNome.length];
		
		//Criar Panels
		pnTop = new JPanel ();
		pnTop.setBackground(new Color(90, 120, 255));
		panel1 = new JPanel ();
		panel2 = new JPanel ();
		panel3 = new JPanel ();
		panel4 = new JPanel ();		
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		/* INICIO TOPO */
		
		JRadioButton cpfButton = new JRadioButton("Cód.");
		cpfButton.setActionCommand("Código");		
		cpfButton.setBackground(new Color(90, 120, 255));
	    pnTop.add(cpfButton);
	    
	    JRadioButton nomeButton = new JRadioButton("Nome ");	    
	    nomeButton.setActionCommand("Descricao");
	    nomeButton.setBackground(new Color(90, 120, 255));
	    nomeButton.setSelected(true);
	    pnTop.add(nomeButton);
	    
   	    //Groupo do Radio Button
	    ButtonGroup group = new ButtonGroup();
	    group.add(cpfButton);
	    group.add(nomeButton);
	    
	    textFieldNome = new JTextField(20);		
		pnTop.add(textFieldNome, BorderLayout.WEST);
		
		ButtonHandler btnHandler = new ButtonHandler ();
		for (int i = 0; i < btTopNome.length; i++) {
			btnTop[i] = new JButton( btTopNome[i]);
			pnTop.add( btnTop[i]);
			btnTop[i].addActionListener( btnHandler );	
		}
		
		panel1.add(pnTop);
		/* FIM TOPO */
		
		
		label2 = new JLabel("Codigo: ",null,SwingConstants.LEFT);		
		panel1.add(label2);
		
		textField2 = new JTextField(35);
		panel1.add(textField2, BorderLayout.WEST);
		
		
		label1 = new JLabel("Nome:   ",null,SwingConstants.LEFT);
		panel1.add(label1);		
		
		textField1 = new JTextField(35);
		panel1.add(textField1, BorderLayout.WEST);		
		
		label3 = new JLabel("CPF:       ",null,SwingConstants.LEFT);		
		panel1.add(label3);
		
		textField3 = new JTextField(35);
		panel1.add( textField3, BorderLayout.WEST); //adiciona textfield2 ao jframe
		
		buttonJPanel = new JPanel ();
		
		label4 = new JLabel("Disciplinas:                                        "+
		"                                                                   		",null,SwingConstants.CENTER);		
		buttonJPanel.add(label4, BorderLayout.WEST); 
		
		Disciplina[] dis = Disciplina.listarDisciplinas();
		DefaultListModel listModel = new DefaultListModel();
		for (int i = 0; i < dis.length; i++) {
			if (dis[i] != null){
				listModel.addElement(dis[i].getDescricao());
			}
		}
		
		list = new JList(listModel); //data has type Object[]		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(5);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(390, 80));
		//panel1.add(listScroller);
		buttonJPanel.add(listScroller);		
		
		
		//Criar Panel e Buttons
		//buttonJPanel = new JPanel ();		
		//buttonJPanel.setLayout(new GridLayout (1, buttons.length));		
		for (int i = 0; i < btNomes.length; i++) {
			buttons[i] = new JButton( btNomes[i]);
			buttonJPanel.add( buttons[i]);
			buttons[i].addActionListener( btnHandler);	
		}		
		
		setLayout(new GridLayout(2,1));
		add( panel1, BorderLayout.NORTH);
		add( buttonJPanel, BorderLayout.SOUTH);		
		
		layout.layoutContainer(container);
		
		RadioHandler radioHandler = new RadioHandler ();
		nomeButton.addActionListener( radioHandler);
	    nomeButton.addActionListener( radioHandler );
	    vTipoPesquisa = "NOME";
		
		// handlers de evento registradores
		TextFieldHandler handler = new TextFieldHandler ();		 
		textField1.addActionListener( handler );
		textField2.addActionListener( handler );
		textField3.addActionListener( handler );						
		
	}//fim do construtor TextFieldFrame
	
	private class RadioHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Código"){
				vTipoPesquisa = "CODIGO";
			} else if (e.getActionCommand() == "Nome"){
				vTipoPesquisa = "NOME";
			}
		}
	}	
	
	//classe interna private para tratamento de evento
	private class TextFieldHandler implements ActionListener{

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
				//string = String.format("textField2: %s", event.getActionCommand() );
				textField3.requestFocus();
			}
			// usuario pressionou enter no JTextField3
			else if (event.getSource() == textField3) {
				//string = String.format("textField3: %s", event.getActionCommand() );			
				buttons[0].requestFocus();
			}
			
			// exibe o conteudo de jtextfield
			//JOptionPane.showMessageDialog(null, string);
		}//Fim do metodo actionPerformed
		
	}
	
	private class ButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			String string = ""; //declara string a ser exibida			
			Professor prof;
			//Botão Pesquisar
			if (event.getSource() == btnTop[0]) {
				prof =  Professor.consultaProfessor(textFieldNome.getText(),vTipoPesquisa);
				if (prof != null) {
					textField1.setText(prof.getCodigo());
					textField2.setText(prof.getNome());
					textField3.setText(prof.getCpf());
					textField1.requestFocus();
				} else{
					string = "Professor "+textFieldNome.getText()+" não encontrado!";
					textFieldNome.requestFocus();
				}
			}
			//Botão Salvar
			else if (event.getSource() == buttons[0]) {				
				prof =  Professor.consultaProfessor(textFieldNome.getText(),vTipoPesquisa);
				try {
					prof.setCodigo(textField1.getText());
					prof.setNome(textField2.getText());
					prof.setCpf(textField3.getText());					
					if (list.getSelectedIndex() < 0){
						list.setSelectedIndex(list.getFirstVisibleIndex());
					}
					prof.setDis(Disciplina.listarDisciplina( list.getSelectedValue().toString() ));
					string = "Professor "+textField2.getText()+" salvo com sucesso!";
					textField1.setText("");
					textField2.setText("");
					textField3.setText("");
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
					if (Professor.excluirProfessor(textFieldNome.getText(),vTipoPesquisa)){
						string = "Professor "+textField2.getText()+" excluido com sucesso!";
						//Texto Codigo
						textField1.setText("");
						//Texto Descricao
						textField2.setText("");
						//Texto CPF
						textField3.setText("");
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
			//Botão Limpar...
			else if (event.getSource() == buttons[2]) {				
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
				textField1.requestFocus();
			}
			//Botão Sair...
			else if (event.getSource() == buttons[3]) {
				dispose();				
			}
			
			// exibe o conteudo de jtextfield
			if (string.equalsIgnoreCase("")){}else{
				JOptionPane.showMessageDialog(null, string);
			}
		}//Fim do metodo actionPerformed
		
	}
	
}

