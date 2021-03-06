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

import com.fbv.Class.Aluno;
import com.fbv.Class.Curso;
import com.fbv.Class.Endereco;


public class TelaCadastroAluno extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
		
	
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textIdentidade;
	private JTextField textRua;
	private JTextField textNumero;
	private JTextField textBairro;	
	private JTextField textCidade;
	private JList listUf;
	private JList listCurso;
	private JTextField textTelefone;
	private JTextField textCelular;	
	private JTextField textEmail;
	
	
	
	private FlowLayout layout;	
	private Container container;	
	private JButton buttons[];	
	private final String btNomes[] = {"Salvar", "Limpar", "Sair"};
	private JPanel buttonJPanel;
	private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;
	
    
    int vCadastra = 0;	
	
	// contrutor TextFieldFrame adiciona JTextFields a JFrame
	public TelaCadastroAluno(){
		super("Cadastro de Aluno");		
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
		panel5 = new JPanel ();
		panel6 = new JPanel ();
		panel7 = new JPanel ();
		panel8 = new JPanel ();
		panel9 = new JPanel ();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel5.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel6.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel7.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel8.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel9.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
			
		/* Codigo */
		label1 = new JLabel("Codigo: ",null,SwingConstants.LEFT);		
		panel1.add(label1);		
		textCodigo = new JTextField(36);
		panel1.add(textCodigo, BorderLayout.WEST);
		
		/* Nome */
		label2 = new JLabel("Nome:   ",null,SwingConstants.LEFT);
		panel2.add(label2);		
		textNome = new JTextField(36);		
		panel2.add(textNome, BorderLayout.WEST);		
		
		/* CPF */
		label3 = new JLabel("CPF:       ",null,SwingConstants.LEFT);		
		panel3.add(label3);		
		textCpf = new JTextField(14);
		panel3.add( textCpf, BorderLayout.WEST);
		
		/* Identidade */
		label4 = new JLabel("  Identidade:  ",null,SwingConstants.LEFT);
		panel3.add(label4);		
		textIdentidade = new JTextField(14);		
		panel3.add(textIdentidade, BorderLayout.WEST);
		
		/* Rua */
		label5 = new JLabel("Rua:       ",null,SwingConstants.LEFT);
		panel4.add(label5);		
		textRua = new JTextField(25);		
		panel4.add(textRua, BorderLayout.WEST);
		
		/* Numero */
		label6 = new JLabel("Numero: ",null,SwingConstants.LEFT);
		panel4.add(label6);		
		textNumero = new JTextField(5);		
		panel4.add(textNumero, BorderLayout.WEST);
		
		/* Bairro */
		label7 = new JLabel("Bairro:  ",null,SwingConstants.LEFT);
		panel5.add(label7);		
		textBairro = new JTextField(36);		
		panel5.add(textBairro, BorderLayout.WEST);
		
		/* Cidade */
		label6 = new JLabel("Cidade: ",null,SwingConstants.LEFT);
		panel6.add(label6);		
		textCidade = new JTextField(25);		
		panel6.add(textCidade, BorderLayout.WEST);
				
		/* UF */
		label6 = new JLabel("  UF: ",null,SwingConstants.LEFT);
		panel6.add(label6);		
		
		DefaultListModel listModel = new DefaultListModel();
		listModel.addElement("PE");
		listModel.addElement("PB");
		listModel.addElement("RJ");
		listModel.addElement("SP");		
		
		listUf = new JList(listModel);		
		listUf.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listUf.setLayoutOrientation(JList.VERTICAL);
		listUf.setVisibleRowCount(1);
		JScrollPane listScroller = new JScrollPane(listUf);
		listScroller.setPreferredSize(new Dimension(80, 20));		
		panel6.add(listScroller, BorderLayout.WEST);
		
		/* Telefone */
		label7 = new JLabel("Fone:     ",null,SwingConstants.LEFT);
		panel7.add(label7);		
		textTelefone = new JTextField(15);		
		panel7.add(textTelefone, BorderLayout.WEST);
		
		/* Celular */
		label8 = new JLabel("   Cel: ",null,SwingConstants.LEFT);
		panel7.add(label8);		
		textCelular = new JTextField(15);		
		panel7.add(textCelular, BorderLayout.WEST);
		
		/* Email */
		label9 = new JLabel("E-mail: ",null,SwingConstants.LEFT);
		panel8.add(label9);		
		textEmail = new JTextField(36);		
		panel8.add(textEmail, BorderLayout.WEST);
		
		label10 = new JLabel("Curso: ",null,SwingConstants.LEFT);
		panel9.add(label10);
		
		Curso[] curso = Curso.listarCursos();
		DefaultListModel listModel1 = new DefaultListModel();
		for (int i = 0; i < curso.length; i++) {
			if (curso[i] != null){
				listModel1.addElement(curso[i].getDescricao());
			}
		}
		
		listCurso = new JList(listModel1);		
		listCurso.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listCurso.setLayoutOrientation(JList.VERTICAL);
		listCurso.setVisibleRowCount(1);
		JScrollPane listScroller1 = new JScrollPane(listCurso);
		listScroller1.setPreferredSize(new Dimension(400, 20));		
		panel9.add(listScroller1, BorderLayout.WEST);
		
		//Criar Panel e Buttons
		buttonJPanel = new JPanel ();
		buttonJPanel.setLayout(new GridLayout (1, buttons.length));		
		ButtonHandler btnHandler = new ButtonHandler ();
		for (int i = 0; i < btNomes.length; i++) {
			buttons[i] = new JButton( btNomes[i]);
			buttonJPanel.add( buttons[i]);
			buttons[i].addActionListener( btnHandler);	
		}		
		
		
		
		
		setLayout(new GridLayout(10,1));
		add( panel1, BorderLayout.NORTH);
		add( panel2, BorderLayout.NORTH);		
		add( panel3, BorderLayout.NORTH);
		add( panel4, BorderLayout.NORTH);		
		add( panel5, BorderLayout.NORTH);
		add( panel6, BorderLayout.NORTH);
		add( panel7, BorderLayout.NORTH);
		add( panel8, BorderLayout.NORTH);
		add( panel9, BorderLayout.NORTH);
		
		add( buttonJPanel, BorderLayout.SOUTH);		
		
		
		layout.layoutContainer(container);
		
		TextFieldHandler handler = new TextFieldHandler ();
		textCodigo.addActionListener( handler );
		textNome.addActionListener( handler );		
		textCpf.addActionListener( handler );				
		textIdentidade.addActionListener( handler );
		textRua.addActionListener( handler );
		textNumero.addActionListener( handler );
		textBairro.addActionListener( handler );
		textCidade.addActionListener( handler );		
		textTelefone.addActionListener( handler );
		textCelular.addActionListener( handler );
		textEmail.addActionListener( handler );
			
				
		
	}//fim do construtor TextFieldFrame
		
	
	//classe interna private para tratamento de evento
	private class TextFieldHandler implements ActionListener{

		//@Override
		public void actionPerformed(ActionEvent event) {
			//String string = ""; //declara string a ser exibida
			
			layout.setAlignment(FlowLayout.LEFT);
			setLayout( layout );
			
			if ( event.getSource()== textNome){
				textCodigo.requestFocus();
			} 
			else if (event.getSource() == textCodigo) {				
				textCpf.requestFocus();
			}
			else if (event.getSource() == textCpf) {
				textIdentidade.requestFocus();
			}
			else if (event.getSource() == textIdentidade) {				
				textRua.requestFocus();
			}
			else if (event.getSource() == textRua) {				
				textNumero.requestFocus();
			}
			else if (event.getSource() == textNumero) {				
				textBairro.requestFocus();
			}
			else if (event.getSource() == textBairro) {				
				textCidade.requestFocus();
			}
			else if (event.getSource() == textCidade) {				
				listUf.requestFocus();
			}
			else if (event.getSource() == listUf) {				
				textTelefone.requestFocus();
			}
			else if (event.getSource() == textTelefone) {				
				textCelular.requestFocus();
			}
			else if (event.getSource() == textCelular) {				
				textEmail.requestFocus();
			}			
			else if (event.getSource() == textEmail) {				
				listCurso.requestFocus();
			}
			else if (event.getSource() == listCurso) {				
				buttons[0].requestFocus();
			}
			
		}//Fim do metodo actionPerformed
		
	}
	
	private class ButtonHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			String string = ""; //declara string a ser exibida
						
			if (event.getSource() == buttons[0]) {				
				Aluno alu = new Aluno();
				Aluno[] aluno = Aluno.listarPessoa();
				try {
					alu.setCodigo(textCodigo.getText());
					alu.setNome(textNome.getText());
					alu.setCpf(textCpf.getText());
					alu.setIdentidade(textIdentidade.getText());
						//Endereco
						Endereco end = new Endereco();
						end.setRua(textRua.getText());
						end.setNumero(textNumero.getText());
						end.setBairro(textBairro.getText());
						end.setCidade(textCidade.getText());
						listUf.setSelectedIndex(listUf.getFirstVisibleIndex());
						end.setUf(listUf.getSelectedIndex());
						end.setFone(textTelefone.getText());
						end.setCel(textCelular.getText());
						end.setEmail(textEmail.getText());						
					alu.setEndereco(end);
					//Curso
					listCurso.setSelectedIndex(listCurso.getFirstVisibleIndex());
					alu.setCurso(Curso.listarCursos( listCurso.getSelectedValue().toString() ));
					
					
					aluno[alu.getIdAluno()] = alu;				
					string = "Aluno "+textNome.getText()+" salvo com sucesso!";
					textNome.setText("");
					textCodigo.setText("");
					textCpf.setText("");				
					textIdentidade.setText("");
					textRua.setText("");
					textNumero.setText("");
					textBairro.setText("");
					textCidade.setText("");		
					textTelefone.setText("");
					textCelular.setText("");
					textEmail.setText("");
					textCodigo.requestFocus();
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
				textNome.setText("");
				textCodigo.setText("");
				textCpf.setText("");				
				textIdentidade.setText("");
				textRua.setText("");
				textNumero.setText("");
				textBairro.setText("");
				textCidade.setText("");		
				textTelefone.setText("");
				textCelular.setText("");
				textEmail.setText("");
				textCodigo.requestFocus();
			}
			else if (event.getSource() == buttons[2]) {
				dispose();				
			}
			
			if (string.equalsIgnoreCase("")){}else{
				JOptionPane.showMessageDialog(null, string);
			}
		}//Fim do metodo actionPerformed
		
	}
	
}

