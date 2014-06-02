package br.fbv.rcbop.calc.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import br.fbv.rcbop.calc.controller.CalculatorController;
import br.fbv.rcbop.calc.model.Calculator;

public class FunctionPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	// Buttons
	private JButton btnSen;
	private JButton btnCos;
	private JButton btnTan;
	private JButton btnExp;
	private JButton btnPlusMinus;
	private JButton btnPercent;
	private JButton btnMr;
	private JButton btnMem;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMultiply;
	private JButton btnDiv;
	private JButton btnEquals;
	private JButton btnClear;
	
	private JTextArea txtField;
	
	public FunctionPanel(JPanel panelBtnArea, JTextArea txtField){
		
		this.txtField = txtField;
		
		this.setLayout(new GridLayout(7, 2));
		panelBtnArea.add(this, BorderLayout.EAST);
		
		btnSen = new JButton("Sen");
		btnSen.addActionListener(this);
		this.add(btnSen);

		btnCos = new JButton("Cos");
		btnCos.addActionListener(this);
		this.add(btnCos);

		btnTan = new JButton("Tan");
		btnTan.addActionListener(this);
		this.add(btnTan);

		btnExp = new JButton("EXP");
		btnExp.addActionListener(this);
		this.add(btnExp);

		btnPlusMinus = new JButton("+-");
		btnPlusMinus.addActionListener(this);
		this.add(btnPlusMinus);

		btnPercent = new JButton("%");
		btnPercent.addActionListener(this);
		this.add(btnPercent);

		btnDiv = new JButton("/");
		btnDiv.addActionListener(this);
		this.add(btnDiv);

		btnMr = new JButton("MR");
		btnMr.addActionListener(this);
		this.add(btnMr);

		btnMultiply = new JButton("*");
		btnMultiply.addActionListener(this);
		this.add(btnMultiply);

		btnMem = new JButton("MEM");
		btnMem.addActionListener(this);
		this.add(btnMem);

		btnMinus = new JButton("-");
		btnMinus.addActionListener(this);
		this.add(btnMinus);

		btnClear = new JButton("CE");
		btnClear.addActionListener(this);
		this.add(btnClear);

		btnEquals = new JButton("=");
		btnEquals.addActionListener(this);
		this.add(btnEquals);

		btnPlus = new JButton("+");
		btnPlus.addActionListener(this);
		this.add(btnPlus);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		CalculatorController calcController = new CalculatorController();
		
		if (event.getSource() == btnPlus) {
			calcController.setOperation(Calculator.PLUS);
			calcController.setTerm1(getInputValue());
			display("");
		} else if (event.getSource() == btnMinus) {
			calcController.setOperation(Calculator.MINUS);
			calcController.setTerm1(getInputValue());
			display("");
		} else if (event.getSource() == btnMultiply) {
			calcController.setOperation(Calculator.MULTIPLY);
			calcController.setTerm1(getInputValue());
			display("");
		} else if (event.getSource() == btnDiv) {
			calcController.setOperation(Calculator.DIV);
			calcController.setTerm1(getInputValue());
			display("");
		} else if (event.getSource() == btnEquals) {
			String result = calcController.resultOperation(getInputValue());
			display(result);
		} else if (event.getSource() == btnClear) {
			display("");
			calcController.clear();
		}
	}
	
	private double getInputValue() {
		return Double.valueOf(txtField.getText());
	}
	
	private void display(String s) {
		txtField.setText(s);
	}

}
