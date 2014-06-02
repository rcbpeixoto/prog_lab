package br.fbv.rcbop.calc.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class NumericPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	private JTextArea txtField;
	
	// Numeric
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn0;
	private JButton btn00;
	private JButton btnDot;
	
	public NumericPanel(JPanel panelBtnArea, JTextArea txtField){
		
		this.txtField = txtField;
		
		this.setLayout(new GridLayout(4,3));
		panelBtnArea.add(this, BorderLayout.WEST);
		
		btn1 = new JButton("1");
		btn1.addActionListener(this);
		this.add(btn1);
		
		btn2 = new JButton("2");
		btn2.addActionListener(this);
		this.add(btn2);

		btn3 = new JButton("3");
		btn3.addActionListener(this);
		this.add(btn3);

		btn4 = new JButton("4");
		btn4.addActionListener(this);
		this.add(btn4);

		btn5 = new JButton("5");
		btn5.addActionListener(this);
		this.add(btn5);

		btn6 = new JButton("6");
		btn6.addActionListener(this);
		this.add(btn6);
		
		btn7 = new JButton("7");
		btn7.addActionListener(this);
		this.add(btn7);

		btn8 = new JButton("8");
		btn8.addActionListener(this);
		this.add(btn8);

		btn9 = new JButton("9");
		btn9.addActionListener(this);
		this.add(btn9);
		
		btn0 = new JButton("0");
		btn0.addActionListener(this);
		this.add(btn0);
		
		btn00 = new JButton("00");
		btn00.addActionListener(this);
		this.add(btn00);
		
		btnDot = new JButton(".");
		btnDot.addActionListener(this);
		this.add(btnDot);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btn0) {
			txtField.append("0");
		} else if (event.getSource() == btn00) {
			txtField.append("00");
		} else if (event.getSource() == btn1) {
			txtField.append("1");
		} else if (event.getSource() == btn2) {
			txtField.append("2");
		} else if (event.getSource() == btn3) {
			txtField.append("3");
		} else if (event.getSource() == btn4) {
			txtField.append("4");
		} else if (event.getSource() == btn5) {
			txtField.append("5");
		} else if (event.getSource() == btn6) {
			txtField.append("6");
		} else if (event.getSource() == btn7) {
			txtField.append("7");
		} else if (event.getSource() == btn8) {
			txtField.append("8");
		} else if (event.getSource() == btn9) {
			txtField.append("9");
		}  else if (event.getSource() == btnDot) {
			txtField.append(".");
		}
	}
	
}
