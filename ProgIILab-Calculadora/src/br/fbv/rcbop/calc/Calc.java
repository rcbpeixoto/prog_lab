package br.fbv.rcbop.calc;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Calc extends JFrame implements ActionListener {

	private static final long	serialVersionUID	= 1L;

	// Layouts
	private BorderLayout		rootBorderLayout;
	private GridLayout			gridLayout;

	// Components
	private JPanel				panelBtnArea;
	private JTextArea			txtField;

	// Buttons
	private JButton				btnSen;
	private JButton				btnCos;
	private JButton				btnTan;
	private JButton				btnExp;
	private JButton				btnPlusMinus;
	private JButton				btnPercent;
	private JButton				btnMr;
	private JButton				btnMem;
	private JButton				btnPlus;
	private JButton				btnMinus;
	private JButton				btnMultiply;
	private JButton				btnDot;
	private JButton				btnDiv;
	private JButton				btnEquals;
	private JButton				btnClear;

	// Numeric
	private JButton				btn1;
	private JButton				btn2;
	private JButton				btn3;
	private JButton				btn4;
	private JButton				btn5;
	private JButton				btn6;
	private JButton				btn7;
	private JButton				btn8;
	private JButton				btn9;
	private JButton				btn0;

	private static final int	MINUS				= 1;
	private static final int	PLUS				= 2;
	private static final int	DIV					= 3;
	private static final int	MULTIPLY			= 4;

	private int					op					= -1;

	private double				memoriaTermo1		= Double.NEGATIVE_INFINITY;
	private double				memoriaTermo2		= Double.NEGATIVE_INFINITY;

	public Calc() {
		initLayout();
		initGui();
		initFrame();
		this.pack();
	}

	private void initFrame() {
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void initLayout() {
		rootBorderLayout = new BorderLayout();
		gridLayout = new GridLayout(5, 5);
		this.setLayout(rootBorderLayout);
	}

	private void initGui() {
		panelBtnArea = new JPanel(gridLayout);
		this.add(panelBtnArea, BorderLayout.SOUTH);

		txtField = new JTextArea(1, 10);
		this.add(txtField, BorderLayout.NORTH);
		txtField.setEditable(false);

		btnSen = new JButton("Sen");
		btnSen.addActionListener(this);
		panelBtnArea.add(btnSen);

		btnCos = new JButton("Cos");
		btnCos.addActionListener(this);
		panelBtnArea.add(btnCos);

		btnTan = new JButton("Tan");
		btnTan.addActionListener(this);
		panelBtnArea.add(btnTan);

		btnExp = new JButton("EXP");
		btnExp.addActionListener(this);
		panelBtnArea.add(btnExp);

		btnPlusMinus = new JButton("+-");
		btnPlusMinus.addActionListener(this);
		panelBtnArea.add(btnPlusMinus);

		btnPercent = new JButton("%");
		btnPercent.addActionListener(this);
		panelBtnArea.add(btnPercent);

		btn7 = new JButton("7");
		btn7.addActionListener(this);
		panelBtnArea.add(btn7);

		btn8 = new JButton("8");
		btn8.addActionListener(this);
		panelBtnArea.add(btn8);

		btn9 = new JButton("9");
		btn9.addActionListener(this);
		panelBtnArea.add(btn9);

		btnDiv = new JButton("/");
		btnDiv.addActionListener(this);
		panelBtnArea.add(btnDiv);

		btnMr = new JButton("MR");
		btnMr.addActionListener(this);
		panelBtnArea.add(btnMr);

		btn4 = new JButton("4");
		btn4.addActionListener(this);
		panelBtnArea.add(btn4);

		btn5 = new JButton("5");
		btn5.addActionListener(this);
		panelBtnArea.add(btn5);

		btn6 = new JButton("6");
		btn6.addActionListener(this);
		panelBtnArea.add(btn6);

		btnMultiply = new JButton("*");
		btnMultiply.addActionListener(this);
		panelBtnArea.add(btnMultiply);

		btnMem = new JButton("MEM");
		btnMem.addActionListener(this);
		panelBtnArea.add(btnMem);

		btn1 = new JButton("1");
		btn1.addActionListener(this);
		panelBtnArea.add(btn1);

		btn2 = new JButton("2");
		btn2.addActionListener(this);
		panelBtnArea.add(btn2);

		btn3 = new JButton("3");
		btn3.addActionListener(this);
		panelBtnArea.add(btn3);

		btnMinus = new JButton("-");
		btnMinus.addActionListener(this);
		panelBtnArea.add(btnMinus);

		btnClear = new JButton("CE");
		btnClear.addActionListener(this);
		panelBtnArea.add(btnClear);

		btn0 = new JButton("0");
		btn0.addActionListener(this);
		panelBtnArea.add(btn0);

		btnDot = new JButton(".");
		btnDot.addActionListener(this);
		panelBtnArea.add(btnDot);

		btnEquals = new JButton("=");
		btnEquals.addActionListener(this);
		panelBtnArea.add(btnEquals);

		btnPlus = new JButton("+");
		btnPlus.addActionListener(this);
		panelBtnArea.add(btnPlus);
	}

	public static void main(String[] args) {
		Calc newCalc = new Calc();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnPlus) {
			op = PLUS;
			memoriaTermo1 = Double.valueOf(txtField.getText());
			txtField.setText("");
		} else if (event.getSource() == btnMinus) {
			op = MINUS;
			memoriaTermo1 = Double.valueOf(txtField.getText());
			txtField.setText("");
		} else if (event.getSource() == btnMultiply) {
			op = MULTIPLY;
			memoriaTermo1 = Double.valueOf(txtField.getText());
			txtField.setText("");
		} else if (event.getSource() == btnDiv) {
			op = DIV;
			memoriaTermo1 = Double.valueOf(txtField.getText());
			txtField.setText("");
		} else if (event.getSource() == btnEquals) {
			calcOperation();
		} else if (event.getSource() == btn0) {
			txtField.append("0");
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
		}
		else if (event.getSource() == btnClear) {
			display("");
			memoriaTermo1 = Double.NEGATIVE_INFINITY;
			memoriaTermo2 = Double.NEGATIVE_INFINITY;
		}
	}

	private void calcOperation() {
		memoriaTermo2 = Double.valueOf(txtField.getText());
		switch (op) {
		case MINUS:
			memoriaTermo1 = memoriaTermo1 - memoriaTermo2;
			display(memoriaTermo1);
			break;
		case PLUS:
			memoriaTermo1 = memoriaTermo1 + memoriaTermo2;
			display(memoriaTermo1);
			break;
		case DIV:
			if (memoriaTermo2 != 0) {
				memoriaTermo1 = memoriaTermo1 / memoriaTermo2;
				display(memoriaTermo1);
			} else {
				display("ERROR");
			}
			break;
		case MULTIPLY:
			memoriaTermo1 = memoriaTermo1 * memoriaTermo2;
			display(memoriaTermo1);
			break;
		default:
			break;
		}

	}

	private void display(double d) {
		txtField.setText(d + "");
	}

	private void display(String s) {
		txtField.setText(s);
	}
}
