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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.fbv.Class.Aluno;
import com.fbv.Class.Disciplina;
import com.fbv.Class.HistoricoAluno;


public class TelaHistoricoAluno extends JFrame{
	
	/**
	 * Cadastrar Historico Aluno 
	 **/
	private static final long serialVersionUID = 1L;	
	private String vTipoPesquisa;
	private JLabel label1;
	private JLabel label3;
	private JLabel label4;	
	private JTextField textFieldNome;
	private JTextField textNota1;
	private JTextField textNota2;
	
	
	private FlowLayout layout;	
	private Container container;
	private JButton btnTop[];	
	private final String btTopNome[] = {"Pesquisar"};
	private JButton buttons[];	
	private final String btNomes[] = {"Salvar", "Limpar", "Sair"};
	private JPanel buttonJPanel;
	private JPanel pnTop, panel3;
	
	private JList list;
	JScrollPane listScroller;
	DefaultListModel listModel;
	Aluno alu;
	Disciplina disciplina;	
	HistoricoAluno historicoAlu;
	
	
    int vCadastra = 0;	
	
	// contrutor TextFieldFrame adiciona JTextFields a JFrame
	public TelaHistoricoAluno(){
		super("Consulta de Aluno");		
		layout = new FlowLayout(); // configura o layout de frame		
		container = getContentPane();
		//layout.setAlignment(FlowLayout.LEFT);		
		//setLayout( layout );		
		
		buttons = new JButton[ btNomes.length];
		btnTop = new JButton[ btTopNome.length];
		
		//Criar Panels		
		pnTop = new JPanel ();
		pnTop.setBackground(new Color(90, 120, 255));		
		panel3 = new JPanel ();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
				
				
		JRadioButton cpfButton = new JRadioButton("Codigo");
		cpfButton.setActionCommand("Codigo");		
		cpfButton.setBackground(new Color(90, 120, 255));
	    pnTop.add(cpfButton);
	    
	    JRadioButton nomeButton = new JRadioButton("Nome");	    
	    nomeButton.setActionCommand("Nome");
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
		
			
		/* Codigo */
		label1 = new JLabel("    ",null,SwingConstants.LEFT);		
		pnTop.add(label1, BorderLayout.WEST);
		label1.setLocation(0, 20);
		
		listModel = new DefaultListModel();
		
		list = new JList(listModel);				
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(5);
		
		ClickJList clickJlist = new ClickJList();
		list.addListSelectionListener( clickJlist );
		
		listScroller = new JScrollPane(list);		
		listScroller.setPreferredSize(new Dimension(460, 100));
		panel3.add(listScroller);	
		
		//Criar Panel e Buttons
		buttonJPanel = new JPanel ();		
		
		label3 = new JLabel("   Nota 1: ",null,SwingConstants.CENTER);		
		buttonJPanel.add(label3);
		textNota1 = new JTextField(10);
		buttonJPanel.add(textNota1, BorderLayout.WEST);
		label4 = new JLabel("                    Nota 2: ",null,SwingConstants.CENTER);		
		buttonJPanel.add(label4);
		textNota2 = new JTextField(10);		
		buttonJPanel.add(textNota2, BorderLayout.WEST);
		
		//buttonJPanel.setLayout(new GridLayout (1, buttons.length));		
		//ButtonHandler btnHandler = new ButtonHandler ();
		for (int i = 0; i < btNomes.length; i++) {
			buttons[i] = new JButton( btNomes[i]);
			buttonJPanel.add( buttons[i]);
			buttons[i].addActionListener( btnHandler);	
		}		
		
		//layout.layoutContainer(container);
		
		setLayout(new GridLayout(3,1));
		add( pnTop, BorderLayout.NORTH );
		//add( panel1, BorderLayout.NORTH );
		add( panel3, BorderLayout.CENTER );
		//add( panel4, BorderLayout.SOUTH);
		
		add( buttonJPanel, BorderLayout.SOUTH);
		
		layout.layoutContainer(container);
		
		RadioHandler radioHandler = new RadioHandler ();
		cpfButton.addActionListener( radioHandler );
	    nomeButton.addActionListener( radioHandler );
	    vTipoPesquisa = "nome";
		
		textFieldNome.requestFocus();
		
	}//fim do construtor TextFieldFrame
		
	private class ClickJList implements ListSelectionListener{
		
		public void valueChanged(ListSelectionEvent e) {
			String vDisciplina = null;
			HistoricoAluno histAluno;
			double nota = 0;
			if (list.getSelectedIndex() >= 0){
				vDisciplina = list.getSelectedValue().toString();
				disciplina = Disciplina.listarDisciplina(vDisciplina);
				if (alu != null && disciplina != null) {
					//vDisciplina = list.getSelectedValue().toString();
					histAluno = HistoricoAluno.listarHistorico(alu,disciplina);
					if (histAluno != null){
						nota = histAluno.getNota1();
						textNota1.setText(nota+"");
						nota = 0;
						nota = histAluno.getNota2();
						textNota2.setText(nota+"");
					} else {
						textNota1.setText("");						
						textNota2.setText("");
					} 
				}
			}
		}
	}
	
	
	private class RadioHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Codigo"){
				vTipoPesquisa = "codigo";
			} else if (e.getActionCommand() == "Nome"){
				vTipoPesquisa = "nome";
			}
		}
	}
	
	private class ButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			String string = ""; //declara string a ser exibida
			//Botão Pesquisar
			if (event.getSource() == btnTop[0]) {				

				alu =  Aluno.consultaAluno(textFieldNome.getText(),vTipoPesquisa);
				if (alu != null) {
					
					label1.setText("Codigo: "+alu.getCodigo()+"      Nome: "+alu.getNome());					
					
					Disciplina[] dis = Disciplina.listarDisciplina(alu.getCurso());
					//DefaultListModel listModel = new DefaultListModel();
					
					if (listModel.getSize() > 0){
						for (int i = listModel.getSize() - 1; i >= 0 ; i--) {
							listModel.removeElementAt(i);
							//((DefaultListModel)list.getModel()).removeElement(i-1);
						}
					}
					
					//historicoAlu = HistoricoAluno.listarHistorico(alu);
								
					for (int i = 0; i < dis.length; i++) {
						if (dis[i] != null){
							listModel.addElement(dis[i].getDescricao());
							listModel.set(i, dis[i].getDescricao()); 
						}
					}					
															
					textFieldNome.requestFocus();
				} else{
					string = "Aluno não encontrado!";
					label1.setText("    ");
					textFieldNome.requestFocus();
				}
								
			}
			//Botão Salvar
			else if (event.getSource() == buttons[0]) {				
				alu =  Aluno.consultaAluno(textFieldNome.getText(),vTipoPesquisa);
				int vCadastro = 0;
				try {
					historicoAlu = HistoricoAluno.listarHistorico(alu,disciplina);
					if (historicoAlu == null) {
						historicoAlu = new HistoricoAluno();
						vCadastro = 0;
					} else if ((historicoAlu.getAluno() != alu) &&
						(historicoAlu.getDisciplina() != disciplina)){
						
						historicoAlu = new HistoricoAluno();
						vCadastro = 0;
						
					} else if ((historicoAlu.getAluno() == alu) &&
						(historicoAlu.getDisciplina() != disciplina)){
						
						historicoAlu = new HistoricoAluno();
						vCadastro = 0;
						
					} else {
						
						vCadastro = 1;
						
					}
					
					
					HistoricoAluno[] historicoAlunos = HistoricoAluno.listarHistorico();
					historicoAlu.setAluno(alu);
					
					if (list.getSelectedIndex() >= 0){					
						list.setSelectedIndex(list.getSelectedIndex());						
					} else {
						list.setSelectedIndex(0);
					}
					
					historicoAlu.setDisciplina(Disciplina.listarDisciplina(list.getSelectedValue().toString()));
					historicoAlu.setNota1(Double.parseDouble(textNota1.getText()));
					historicoAlu.setNota2(Double.parseDouble(textNota2.getText()));
					
					if (vCadastro == 0){
						historicoAlunos[historicoAlu.getIdHistorico()] = historicoAlu;
					}
					string = "Histórico salvo com sucesso!";
					textNota1.setText("");
					textNota2.setText("");
					
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					JOptionPane.showMessageDialog(null, "Preenchar os Campos Obrigatórios");
				
				} catch (IllegalArgumentException er) {
					// TODO Auto-generated catch block
					System.out.println(er);
					JOptionPane.showMessageDialog(null, "Preenchar os Campos Obrigatorios");
				}
			}			
			else if (event.getSource() == buttons[1]) {				
				textNota1.setText("");
				textNota2.setText("");
				textFieldNome.setText("");
				textFieldNome.requestFocus();			
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

