package com.fbv.fachada;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import com.fbv.Class.Curso;
import com.fbv.Class.Disciplina;


public class TelaCadastroDisciplina extends JFrame{
	
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
	private JPanel panel1, panel2, panel3;	
	private JList list;
	
	
    int vCadastra = 0;	
	
	// contrutor TextFieldFrame adiciona JTextFields a JFrame
	public TelaCadastroDisciplina(){
		super("Cadastro de Disciplina");
		layout = new FlowLayout(); // configura o layout de frame		
		container = getContentPane();
		//layout.setAlignment(FlowLayout.LEFT);		
		//setLayout( layout );		
		
		buttons = new JButton[ btNomes.length];
		
		//Criar Panels
		panel1 = new JPanel ();
		panel2 = new JPanel ();
		panel3 = new JPanel ();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		
		label1 = new JLabel("Codigo:      ",null,SwingConstants.LEFT);
		panel1.add(label1); //adiciona label1 ao jframe		
		
		textField1 = new JTextField(25);		
		panel1.add(textField1, BorderLayout.WEST); //adiciona textField1 ao JFrame
		
		label2 = new JLabel("Disciplina: ",null,SwingConstants.LEFT);		
		panel1.add(label2); //adiciona label1 ao jframe
		
		textField2 = new JTextField(25);
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
		listScroller.setPreferredSize(new Dimension(360, 60));
		panel3.add(listScroller);
		
		
		
		//Criar Panel e Buttons
		buttonJPanel = new JPanel ();
		//buttonJPanel.setLayout(new GridLayout (1, buttons.length));		
		ButtonHandler btnHandler = new ButtonHandler ();
		for (int i = 0; i < btNomes.length; i++) {
			buttons[i] = new JButton( btNomes[i]);
			buttonJPanel.add( buttons[i]);
			buttons[i].addActionListener( btnHandler);	
		}		
		
		setLayout(new GridLayout(3,1));
		add( panel1, BorderLayout.NORTH);
		//add( panel2, BorderLayout.NORTH);
		add( panel3, BorderLayout.NORTH);
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
				Disciplina dis = new Disciplina();
				Disciplina[] disciplinas = Disciplina.listarDisciplinas();
				try {
					dis.setCodigo(textField1.getText());				
					dis.setDescricao(textField2.getText());
					list.setSelectedIndex(list.getFirstVisibleIndex());
					Curso curso = Curso.listarCursos(list.getSelectedValue().toString());				
					dis.setCurso(curso);
					if (!Disciplina.consultaDisciplina(dis)){
						disciplinas[dis.getIdDisciplina()] = dis;				
						string = "Disciplina "+textField2.getText()+" salva com sucesso!";
						textField1.setText("");
						textField2.setText("");				
						textField1.requestFocus();
					} else {
						string = "Aten��o, Esssa Disciplina j� foi cadastrada!";
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

