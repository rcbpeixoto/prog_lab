package com.fbv.fachada;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class TelaPrincipal extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FlowLayout layout;	
	private Container container;	
	private JPanel panel1;
	private JMenuBar jMenuBar;
	private JMenu jMenus[];	
	private JMenuItem jMenusItens1[];
	private JMenuItem jMenusItens2[];
	private JMenuItem jMenusItens3[];
	private JMenuItem jMenusItens4[];
	private JMenuItem jMenusItens5[];
	private final String jMenuNomes[] = {"Arquivo","Cadastrar", "Consultar","Relatórios", "Sobre"};
	private final String jMenuItens1Nomes[] = {"Configuração", "Sair"};
	private final String jMenuItens2Nomes[] = {"Aluno","Disciplina","Professor","Curso","Notas"};
	private final String jMenuItens3Nomes[] = {"Aluno","Disciplina","Professor", "Curso"};
	private final String jMenuItens4Nomes[] = {"Aluno","Disciplina","Professor","Histórico Alunos"};
	private final String jMenuItens5Nomes[] = {"Ajuda"};
			    
	// contrutor TextFieldFrame adiciona JTextFields a JFrame
	public TelaPrincipal(){
		super("School System");		
		layout = new FlowLayout(); // configura o layout de frame		
		container = getContentPane();
		
		
		jMenus = new JMenu[jMenuNomes.length];
		jMenusItens1 = new JMenuItem[jMenuItens1Nomes.length];
		jMenusItens2 = new JMenuItem[jMenuItens2Nomes.length];
		jMenusItens3 = new JMenuItem[jMenuItens3Nomes.length];
		jMenusItens4 = new JMenuItem[jMenuItens4Nomes.length];
		jMenusItens5 = new JMenuItem[jMenuItens5Nomes.length];

		//Criar Panels
		panel1 = new JPanel ();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));		
			
		//ImageIcon img = new ImageIcon("src\\com\\fbv\\fachada\\school.jpg");
		ImageIcon img = new ImageIcon("school.jpg");
				
		JLabel label = new JLabel(img);
		
		label.setPreferredSize(new Dimension(640, 480));
		panel1.add(label);		
		
		add( panel1, BorderLayout.CENTER);		
		
		layout.layoutContainer(container);			
		
		//Criar Menu
		jMenuBar = new JMenuBar();
		setJMenuBar(jMenuBar);
		
		//Criar Itens Menu		
		for (int i = 0; i < jMenuNomes.length; i++) {			
			jMenus[i] = new JMenu();
			jMenus[i].setText(jMenuNomes[i]);
			jMenuBar.add(getJMenu(i,jMenus[i]));			
		}
	}
	
	private JMenu getJMenu(int i, JMenu jMenu1) {    	
		ButtonHandler btnHandler = new ButtonHandler ();
		ButtonRelHandler btnRelHandler = new ButtonRelHandler ();
    	switch ( i ) {    	
		case 0:
			for (int j = 0; j < jMenuItens1Nomes.length; j++) {
				jMenusItens1[j] = new JMenuItem();
				jMenusItens1[j].setText(jMenuItens1Nomes[j]);
				jMenu1.add(jMenusItens1[j]);
				jMenusItens1[j].addActionListener( btnHandler);
			}
			break;
		case 1:
			for (int j = 0; j < jMenuItens2Nomes.length; j++) {				
				jMenusItens2[j] = new JMenuItem();
				jMenusItens2[j].setText(jMenuItens2Nomes[j]);
				jMenu1.add(jMenusItens2[j]);
				jMenusItens2[j].addActionListener( btnHandler);
			}
			break;
		case 2:
			for (int j = 0; j < jMenuItens3Nomes.length; j++) {
				jMenusItens3[j] = new JMenuItem();
				jMenusItens3[j].setText(jMenuItens3Nomes[j]);
				jMenu1.add(jMenusItens3[j]);
				jMenusItens3[j].addActionListener( btnHandler);
			}
			break;
		case 3:
			for (int j = 0; j < jMenuItens4Nomes.length; j++) {
				jMenusItens4[j] = new JMenuItem();
				jMenusItens4[j].setText(jMenuItens4Nomes[j]);
				jMenu1.add(jMenusItens4[j]);
				jMenusItens4[j].addActionListener( btnRelHandler );
			}
			break;
		case 4:
			for (int j = 0; j < jMenuItens5Nomes.length; j++) {
				jMenusItens5[j] = new JMenuItem();
				jMenusItens5[j].setText(jMenuItens5Nomes[j]);
				jMenu1.add(jMenusItens5[j]);
				jMenusItens5[j].addActionListener( btnHandler );
			}			
			break;
		default:
			break;
		}   		
    	return jMenu1;
    }
	
	
	private class ButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
						
			//Arquivo			
			if (event.getSource() == jMenusItens1[0]) {
				//Configuracao
				TelaConfiguracao frameConf = new TelaConfiguracao();
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();		
				int width = 220;
				int height = 150;
				int left = (d.width-width)/2;
				int top = (d.height-height)/2;
				frameConf.setBounds(left, top, width, height);		
				frameConf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				//textFieldFrame.setSize(450,200);
				frameConf.setVisible(true);
			}
			else if (event.getSource() == jMenusItens1[1]) {
				System.exit(0); 				
			}
			//Cadastros
			else if (event.getSource() == jMenusItens2[0]) {
				//Chama Cadastro Aluno
				TelaCadastroAluno frameCadAluno = new TelaCadastroAluno();
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();		
				int width = 480;
				int height = 380;
				int left = (d.width-width)/2;
				int top = (d.height-height)/2;
				frameCadAluno.setBounds(left, top, width, height);		
				frameCadAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				//textFieldFrame.setSize(450,200);
				frameCadAluno.setVisible(true);
			}
			else if (event.getSource() == jMenusItens2[1]) {
				//Chama Cadastro Disciplina				
				TelaCadastroDisciplina frameCadDisciplina = new TelaCadastroDisciplina();
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();		
				int width = 380;
				int height = 225;
				int left = (d.width-width)/2;
				int top = (d.height-height)/2;
				frameCadDisciplina.setBounds(left, top, width, height);		
				frameCadDisciplina.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				//textFieldFrame.setSize(450,200);
				frameCadDisciplina.setVisible(true);
			}
			else if (event.getSource() == jMenusItens2[2]) {
				//Chama Cadastro Professor						
				TelaCadastroProfessor frameCadProfessor = new TelaCadastroProfessor();
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();		
				int width = 410;
				int height = 310;
				int left = (d.width-width)/2;
				int top = (d.height-height)/2;
				frameCadProfessor.setBounds(left, top, width, height);		
				frameCadProfessor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				//textFieldFrame.setSize(450,200);
				frameCadProfessor.setVisible(true);
			}
			else if (event.getSource() == jMenusItens2[3]) {
				//Chama Cadastro Curso				
				TelaCadastroCurso frameCadCurso = new TelaCadastroCurso();
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();		
				int width = 380;
				int height = 150;
				int left = (d.width-width)/2;
				int top = (d.height-height)/2;
				frameCadCurso.setBounds(left, top, width, height);		
				frameCadCurso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				//textFieldFrame.setSize(450,200);
				frameCadCurso.setVisible(true);
			}
			else if (event.getSource() == jMenusItens2[4]) {
				//Chama Cadastro Notas						
				TelaHistoricoAluno frameHistAluno = new TelaHistoricoAluno();
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();		
				int width = 480;
				int height = 350;
				int left = (d.width-width)/2;
				int top = (d.height-height)/2;
				frameHistAluno.setBounds(left, top, width, height);		
				frameHistAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameHistAluno.setVisible(true);
			}
			
			//Sobre
			else if (event.getSource() == jMenusItens3[0]) {
				//Chama Consulta Aluno
				TelaConsultaAluno frameConsultaAluno = new TelaConsultaAluno();
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();		
				int width = 480;
				int height = 400;
				int left = (d.width-width)/2;
				int top = (d.height-height)/2;
				frameConsultaAluno.setBounds(left, top, width, height);		
				frameConsultaAluno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				//textFieldFrame.setSize(450,200);
				frameConsultaAluno.setVisible(true);			
			}
			else if (event.getSource() == jMenusItens3[1]) {
				//Chama Consulta Disciplina
				TelaConsultaDisciplina frameConsultaDisciplina = new TelaConsultaDisciplina();
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();		
				int width = 480;
				int height = 300;
				int left = (d.width-width)/2;
				int top = (d.height-height)/2;
				frameConsultaDisciplina.setBounds(left, top, width, height);		
				frameConsultaDisciplina.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				//textFieldFrame.setSize(450,200);
				frameConsultaDisciplina.setVisible(true);			
			}
			else if (event.getSource() == jMenusItens3[2]) {
				//Chama Consulta Professor
				TelaConsultaProfessor frameConsultaProf = new TelaConsultaProfessor();
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();		
				int width = 470;
				int height = 310;
				int left = (d.width-width)/2;
				int top = (d.height-height)/2;
				frameConsultaProf.setBounds(left, top, width, height);		
				frameConsultaProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				//textFieldFrame.setSize(450,200);
				frameConsultaProf.setVisible(true);			
			}
			else if (event.getSource() == jMenusItens3[3]) {
				//Chama Consulta Curso
				TelaConsultaCurso frameConsultaCurso = new TelaConsultaCurso();
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();		
				int width = 480;
				int height = 180;
				int left = (d.width-width)/2;
				int top = (d.height-height)/2;
				frameConsultaCurso.setBounds(left, top, width, height);		
				frameConsultaCurso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				//textFieldFrame.setSize(450,200);
				frameConsultaCurso.setVisible(true);			
			}
			else if (event.getSource() == jMenusItens5[0]) {
				//Sobre
				TelaSobre frameBemVindo = new TelaSobre();
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();		
				int width = 580;
				int height = 460;
				int left = (d.width-width)/2;
				int top = (d.height-height)/2;
				frameBemVindo.setBounds(left, top, width, height);		
				frameBemVindo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				//textFieldFrame.setSize(450,200);
				frameBemVindo.setVisible(true);
			}

		}//Fim do metodo actionPerformed
		
	}
	
	private class ButtonRelHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
						
			//Arquivo			
			if (event.getSource() == jMenusItens4[0]) {
				//Chama Listar Aluno
				TelaListaAluno frameLista = new TelaListaAluno();
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();		
				int width = 580;
				int height = 300;
				int left = (d.width-width)/2;
				int top = (d.height-height)/2;
				frameLista.setBounds(left, top, width, height);		
				frameLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				//textFieldFrame.setSize(450,200);
				frameLista.setVisible(true);
			}
			else if (event.getSource() == jMenusItens4[1]) {
				//Chama Listar Disciplina
				TelaListaDisciplina frameLista = new TelaListaDisciplina();
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();		
				int width = 580;
				int height = 300;
				int left = (d.width-width)/2;
				int top = (d.height-height)/2;
				frameLista.setBounds(left, top, width, height);		
				frameLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				//textFieldFrame.setSize(450,200);
				frameLista.setVisible(true);
				
			}
			else if (event.getSource() == jMenusItens4[2]) {
				//Chama Listar Professor
				TelaListaProfessor frameLista = new TelaListaProfessor();
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();		
				int width = 580;
				int height = 300;
				int left = (d.width-width)/2;
				int top = (d.height-height)/2;
				frameLista.setBounds(left, top, width, height);		
				frameLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				//textFieldFrame.setSize(450,200);
				frameLista.setVisible(true);
			}
			else if (event.getSource() == jMenusItens4[3]) {
				//Chama Listar Historico Aluno
				TelaListaHistoricoAluno frameLista = new TelaListaHistoricoAluno();
				Dimension d = Toolkit.getDefaultToolkit().getScreenSize();		
				int width = 580;
				int height = 340;
				int left = (d.width-width)/2;
				int top = (d.height-height)/2;
				frameLista.setBounds(left, top, width, height);		
				frameLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				//textFieldFrame.setSize(450,200);
				frameLista.setVisible(true);
			}			

		}//Fim do metodo actionPerformed
		
	}
	
	
}

