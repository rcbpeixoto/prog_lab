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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.fbv.Class.Disciplina;


public class TelaListaDisciplina extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private JPanel topPanel;
	private JLabel label1; //Campo costruioido com texto
    private JPanel pnTop;
    private JScrollPane ScrollPnGrid;
    private JTable tabela;
    private FlowLayout layout;
    private Container container;
    private JButton buttons[];	
	private final String btNomes[] = {"Sair"};
	DefaultTableModel modelo;

    
    public TelaListaDisciplina(){
    	super("Listagem de Disciplinas");
    	layout = new FlowLayout();
    	container = getContentPane();
    	setLayout(new GridLayout(1,1));    	

    	buttons = new JButton[ btNomes.length];
    	
        {
        	pnTop = new JPanel();        	
        	pnTop.setLayout(new FlowLayout(FlowLayout.CENTER));        		
        	pnTop.setLayout(new GridLayout(2,1));
        	
        	label1 = new JLabel(" Listagem de Disciplinas ",null,SwingConstants.CENTER);
        	pnTop.add(label1); //adiciona label1 ao jframe
        }
        {
        
        	{
        		ScrollPnGrid = new JScrollPane();
        		pnTop.add(ScrollPnGrid);
        		ScrollPnGrid.setPreferredSize(new java.awt.Dimension(560, 200));
        		{
        			//TableModel gridModel =
        			modelo =
        				new DefaultTableModel(
        						//new String[][] { { "", "", "" }, { "", "", "" }, { "", "", "" } },
        						new String[][] { },
        						new String[] { "Curso", "Cód. Disciplina", "Disciplina"});
        			//modelo = new DefaultTableModel(5,5);
        			tabela = new JTable();        			
        			GridLayout gridLayout = new GridLayout(1, 1);
        			gridLayout.setHgap(1);
        			gridLayout.setVgap(1);
        			gridLayout.setColumns(3);
        			ScrollPnGrid.setViewportView(tabela);
        			tabela.setModel(modelo);
        			tabela.setLayout(null);
        		}
        	}
        }
        
        ButtonHandler btnHandler = new ButtonHandler ();
		for (int i = 0; i < btNomes.length; i++) {
			buttons[i] = new JButton( btNomes[i]);
			pnTop.add( buttons[i]);
			buttons[i].addActionListener( btnHandler);	
		}	
        
        
        pnTop.setLayout(new FlowLayout(FlowLayout.CENTER));
        add( pnTop, BorderLayout.NORTH);
        layout.layoutContainer(container);
        
        
        //Listar Disciplinas
        Disciplina[] dis =  Disciplina.listarDisciplinas();		
		limparTabela();
			
		for (int i = 0; i < dis.length; i++) {
			if (dis[i] != null) {
				adicionar(i,
					dis[i].getCurso().getDescricao(),	
					dis[i].getCodigo(),
					dis[i].getDescricao()							
				);
			}				
		}
		
        
    }
    
    public void limparTabela() {  
    	modelo.setNumRows(0);
    } 
    
    
    public void adicionar(int vLinha, String descCurso, String codDisciplina, String Disciplina) {
    	  
        tabela.removeEditor();  
        if (codDisciplina.equalsIgnoreCase("") == false){
        	modelo.addRow(new Object[modelo.getColumnCount()]);
        	modelo.setValueAt(new String(descCurso),(vLinha),0);
			modelo.setValueAt(new String(codDisciplina),(vLinha),1);
			modelo.setValueAt(new String(Disciplina),(vLinha),2);
						
        }
    }
        
private class ButtonHandler implements ActionListener{		
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == buttons[0]) {			
			dispose();				
		}			
		
	}//Fim do metodo actionPerformed
		
	}

}
