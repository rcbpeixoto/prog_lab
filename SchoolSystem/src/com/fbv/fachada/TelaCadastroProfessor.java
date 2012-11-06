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

import com.fbv.Class.Disciplina;
import com.fbv.Class.Professor;

public class TelaCadastroProfessor extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private final String btNomes[] = {"Salvar", "Limpar", "Sair"};
	private JPanel buttonJPanel;
	private JPanel panel1, panel2, panel3, panel4;	
	private JList list;
    
    int vCadastra = 0;	
	
	// contrutor TextFieldFrame adiciona JTextFields a JFrame
	public TelaCadastroProfessor(){
		super("Cadastro de Professor");
		layout = new FlowLayout(); // configura o layout de frame		
		container = getContentPane();
		//layout.setAlignment(FlowLayout.LEFT);		
		//setLayout( layout );		
		
		buttons = new JButton[ btNomes.length];
		
		//Criar Panels
		panel1 = new JPanel ();
		panel2 = new JPanel ();
		panel3 = new JPanel ();
		panel4 = new JPanel ();		
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		
		
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
		
		ButtonHandler btnHandler = new ButtonHandler ();
		
		for (int i = 0; i < btNomes.length; i++) {
			buttons[i] = new JButton( btNomes[i]);
			buttonJPanel.add( buttons[i]);
			buttons[i].addActionListener( btnHandler );	
		}
		
		
		//Criar Panel e Buttons
		//buttonJPanel = new JPanel ();		
		//buttonJPanel.setLayout(new GridLayout (1, buttons.length));
		
		setLayout(new GridLayout(2,1));
		add( panel1, BorderLayout.NORTH);
		add( buttonJPanel, BorderLayout.SOUTH);		
		
		layout.layoutContainer(container);
				
		
		// handlers de evento registradores
		TextFieldHandler handler = new TextFieldHandler ();		 
		textField1.addActionListener( handler );
		textField2.addActionListener( handler );
		textField3.addActionListener( handler );						
		
	}
	
	
	
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
						
			if (event.getSource() == buttons[0]) {				
				Professor pro = new Professor();
				Professor[] prof = Professor.listarPessoa();
				try {
					pro.setNome(textField1.getText());								
					pro.setCodigo(textField2.getText());
					pro.setCpf(textField3.getText());
					Disciplina dis = Disciplina.listarDisciplina(list.getSelectedValue().toString());				
					pro.setDis(dis);				
					prof[pro.getIdProfessor()] = pro;				
					string = "Professor "+textField2.getText()+" salvo com sucesso!";				
					textField1.setText("");
					textField2.setText("");
					textField3.setText("");				
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
				textField3.setText("");
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

