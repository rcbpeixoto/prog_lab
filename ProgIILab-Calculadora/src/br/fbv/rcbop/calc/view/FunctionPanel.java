package br.fbv.rcbop.calc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import br.fbv.rcbop.calc.controller.CalculatorController;
import br.fbv.rcbop.calc.model.Calculator;

public class FunctionPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	// Buttons
	private JButton btnSen;
	private JButton btnCos;
	private JButton btnTan;
	//private JButton btnExp;
	//private JButton btnPlusMinus;
	private JButton btnPercent;
	//private JButton btnMr;
	//private JButton btnMem;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMultiply;
	private JButton btnDiv;
	private JButton btnResultEquals;
	private JButton btnClear;
	
	private JTextArea txtField;

	private JRadioButton degree;
	private JRadioButton radian;

	private JPanel unityPanel;
	private JPanel topPanel;
	
	public FunctionPanel(JPanel panelBtnArea, JTextArea txtField){
		
		this.txtField = txtField;
		panelBtnArea.add(this, BorderLayout.EAST);
		
		this.setLayout(new BorderLayout());
		topPanel = new JPanel(new GridLayout(5, 2));
		this.add(topPanel, BorderLayout.SOUTH);
		
		unityPanel = new JPanel(new FlowLayout());
		unityPanel.setBackground(Color.WHITE);
		this.add(unityPanel, BorderLayout.NORTH);
		
		btnSen = new JButton(new ImageIcon("assets/sin.png"));
		btnSen.setBackground(Color.WHITE);
		btnSen.addActionListener(this);
		topPanel.add(btnSen);

		btnCos = new JButton(new ImageIcon("assets/cos.png"));
		btnCos.setBackground(Color.WHITE);
		btnCos.addActionListener(this);
		topPanel.add(btnCos);

		btnTan = new JButton(new ImageIcon("assets/tan.png"));
		btnTan.setBackground(Color.WHITE);
		btnTan.addActionListener(this);
		topPanel.add(btnTan);

//		btnExp = new JButton("EXP");
//		btnExp.addActionListener(this);
//		this.add(btnExp);

//		btnPlusMinus = new JButton("+-");
//		btnPlusMinus.addActionListener(this);
//		this.add(btnPlusMinus);

		btnPercent = new JButton(new ImageIcon("assets/percent.png"));
		btnPercent.setBackground(Color.WHITE);
		btnPercent.addActionListener(this);
		topPanel.add(btnPercent);

		btnDiv = new JButton(new ImageIcon("assets/divide.png"));
		btnDiv.setBackground(Color.WHITE);
		btnDiv.addActionListener(this);
		topPanel.add(btnDiv);

//		btnMr = new JButton("MR");
//		btnMr.addActionListener(this);
//		this.add(btnMr);

		btnMultiply = new JButton(new ImageIcon("assets/multiply.png"));
		btnMultiply.setBackground(Color.WHITE);
		btnMultiply.addActionListener(this);
		topPanel.add(btnMultiply);

//		btnMem = new JButton("MEM");
//		btnMem.addActionListener(this);
//		this.add(btnMem);

		btnMinus = new JButton(new ImageIcon("assets/minus.png"));
		btnMinus.addActionListener(this);
		btnMinus.setBackground(Color.WHITE);
		topPanel.add(btnMinus);

		btnClear = new JButton(new ImageIcon("assets/ce.png"));
		btnClear.setBackground(Color.WHITE);
		btnClear.addActionListener(this);
		topPanel.add(btnClear);

		btnResultEquals = new JButton(new ImageIcon("assets/equal.png"));
		btnResultEquals.setBackground(Color.WHITE);
		btnResultEquals.addActionListener(this);
		topPanel.add(btnResultEquals);

		btnPlus = new JButton(new ImageIcon("assets/add.png"));
		btnPlus.setBackground(Color.WHITE);
		btnPlus.addActionListener(this);
		topPanel.add(btnPlus);
		
		degree = new JRadioButton("Degree");
		degree.addActionListener(this);
		degree.setBackground(Color.WHITE);

		radian = new JRadioButton("Radian");
		radian.addActionListener(this);
		radian.setBackground(Color.WHITE);

		ButtonGroup group = new ButtonGroup();
		group.add(degree);
		group.add(radian);
		
		unityPanel.add(degree);
		unityPanel.add(radian);
		
		degree.setSelected(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		CalculatorController calcController = new CalculatorController();
		try {
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
			} else if (event.getSource() == btnSen) {
				String result = calcController.trigonometricFunction(getInputValue(), Calculator.SIN)+ "";
				display(result + (calcController.getUnity() == Calculator.RADIAN ? " rad" : " degree"));
			} else if (event.getSource() == btnCos) {
				String result = calcController.trigonometricFunction(getInputValue(), Calculator.COS)+ "";
				display(result + (calcController.getUnity() == Calculator.RADIAN ? " rad" : " degree"));
			} else if (event.getSource() == btnTan) {
				String result = calcController.trigonometricFunction(getInputValue(), Calculator.TAN)+ "";
				display(result + (calcController.getUnity() == Calculator.RADIAN ? " rad" : " degree"));
			} else if (event.getSource() == btnResultEquals) {
				String result = calcController.resultArithmeticOperation(getInputValue()) + "";
				display(result);
			} else if (event.getSource() == btnClear) {
				display("");
				calcController.clear();
			} else if (event.getSource() == degree) {
				calcController.setUnity(Calculator.DEGREE);
			} else if (event.getSource() == radian){
				calcController.setUnity(Calculator.RADIAN);
			}
		} catch (NumberFormatException e) {
			display("ERROR");
		}
	}
	
	private double getInputValue() {
		return Double.valueOf(txtField.getText());
	}
	
	private void display(String s) {
		txtField.setText(s);
	}

}
