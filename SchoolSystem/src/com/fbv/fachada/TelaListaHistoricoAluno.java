package com.fbv.fachada;
import com.fbv.Class.Aluno;
import com.fbv.Class.Configuracao;
import com.fbv.Class.HistoricoAluno;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


public class TelaListaHistoricoAluno extends JFrame{
    //private JPanel topPanel;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnTop1;
	private JButton btnTop[];
	private String vTipoPesquisa;
	private JTextField textFieldNome;
	private final String btTopNome[] = {"Pesquisar"};
	
	
	private JLabel label1; //Campo costruioido com texto
    private JPanel pnTop;
    private JScrollPane ScrollPnGrid;
    private JTable tabela;
    private FlowLayout layout;
    private Container container;
    private JButton buttons[];	
	private final String btNomes[] = {"Sair"};
	DefaultTableModel modelo;

    
    public TelaListaHistoricoAluno(){
    	super("Listagem de Alunos");
    	layout = new FlowLayout();
    	container = getContentPane();
    	setLayout(new GridLayout(1,1));    	

    	buttons = new JButton[ btNomes.length];
    	
        
        pnTop = new JPanel();        	
        pnTop.setLayout(new FlowLayout(FlowLayout.CENTER));        		
        pnTop.setLayout(new GridLayout(2,1));
        	
        label1 = new JLabel(" Listagem de Alunos ",null,SwingConstants.CENTER);
        pnTop.add(label1); //adiciona label1 ao jframe
        
        
        /* INICIO TOPO */
        btnTop = new JButton[btTopNome.length];
		
		//Criar Panels
		pnTop1 = new JPanel ();
		pnTop1.setBackground(new Color(90, 120, 255));
		
		JRadioButton codButton = new JRadioButton("Codigo");
		codButton.setActionCommand("Codigo");		
		codButton.setBackground(new Color(90, 120, 255));
	    pnTop1.add(codButton);
	    
	    JRadioButton nomeButton = new JRadioButton("Nome");	    
	    nomeButton.setActionCommand("Nome");
	    nomeButton.setBackground(new Color(90, 120, 255));
	    nomeButton.setSelected(true);
	    pnTop1.add(nomeButton);
	    
	    textFieldNome = new JTextField(20);		
	    pnTop1.add(textFieldNome, BorderLayout.WEST);
		
		ButtonHandler btnHandler = new ButtonHandler ();
		for (int i = 0; i < btTopNome.length; i++) {
			btnTop[i] = new JButton( btTopNome[i]);
			pnTop1.add( btnTop[i]);
			btnTop[i].addActionListener( btnHandler );	
		}
		
		pnTop.add(pnTop1);
		/* FIM TOPO */
		
        
        ScrollPnGrid = new JScrollPane();
        pnTop.add(ScrollPnGrid);
        ScrollPnGrid.setPreferredSize(new java.awt.Dimension(560, 200));
        //TableModel gridModel =
        modelo = new DefaultTableModel(
        		 new String[][] { },
        		 new String[] { "Aluno", "Curso", "Disciplina","Nota 1", "Nota 2", "Media", "Status" }
        		);
        tabela = new JTable();        			
        GridLayout gridLayout = new GridLayout(1, 1);
        gridLayout.setHgap(1);
        gridLayout.setVgap(1);
        gridLayout.setColumns(7);
        ScrollPnGrid.setViewportView(tabela);
        tabela.setModel(modelo);
        tabela.setLayout(null);
        
        
        //ButtonHandler btnHandler = new ButtonHandler ();
		for (int i = 0; i < btNomes.length; i++) {
			buttons[i] = new JButton( btNomes[i]);
			pnTop.add( buttons[i]);
			buttons[i].addActionListener( btnHandler);	
		}	
        
        
        pnTop.setLayout(new FlowLayout(FlowLayout.CENTER));
        add( pnTop, BorderLayout.NORTH);
        layout.layoutContainer(container);
        
        RadioHandler radioHandler = new RadioHandler ();
        codButton.addActionListener( radioHandler );
	    nomeButton.addActionListener( radioHandler );
	    vTipoPesquisa = "nome";
	    
    }
    
    public void limparTabela() {  
    	modelo.setNumRows(0);
    } 
    
    
    public void adicionar(int vLinha, String nome, String curso, String disciplina,
    		double nota1, double nota2, double media) {
    	
        tabela.removeEditor();  
        if (nome.equalsIgnoreCase("") == false){
        	modelo.addRow(new Object[modelo.getColumnCount()]);        		
			modelo.setValueAt(new String(nome),(vLinha),0);	
			modelo.setValueAt(new String(curso),(vLinha),1);
			modelo.setValueAt(new String(disciplina),(vLinha),2);
			modelo.setValueAt(new Double(nota1),(vLinha),3);
			modelo.setValueAt(new Double(nota2),(vLinha),4);			
			try {
				Configuracao Conf[] = Configuracao.retornaConf();			 
				modelo.setValueAt(new Double(media),(vLinha),5);
				if (Conf[0].getMedia() > 0){
					if (media >= Conf[0].getMedia()) {
						modelo.setValueAt(new String("Aprovado"),(vLinha),6);					
					} else {
						modelo.setValueAt(new String("Reprovado"),(vLinha),6);					
					}				
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Verifique a média em configuração");
				dispose();
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Verifique a média em configuração");
				dispose();
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
    		//Pesquisar Aluno
    		if (event.getSource() == btnTop[0]) {			
    			Aluno alu =  Aluno.consultaAluno(textFieldNome.getText(),vTipoPesquisa);
    			HistoricoAluno historico[] =  HistoricoAluno.listarHistorico(alu);
    			limparTabela();
			
    			for (int i = 0; i < historico.length; i++) {
    				if (historico[i] != null) {
    					adicionar(i,historico[i].getAluno().getNome(),
    							historico[i].getAluno().getCurso().getDescricao(),						
    							historico[i].getDisciplina().getDescricao(),
    							historico[i].getNota1(),
    							historico[i].getNota2(),
    							historico[i].calcularMedia()						
    					);
    				}				
    			}				
    		}
    		//Fechar a Tela
    		else if (event.getSource() == buttons[0]) {			
    			dispose();				
    		}
			
    		// exibe o conteudo de jtextfield
    		if (string.equalsIgnoreCase("")){}else{
    			JOptionPane.showMessageDialog(null, string);
    		}
    	}//Fim do metodo actionPerformed
		
	}

}
