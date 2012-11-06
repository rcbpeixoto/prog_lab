package br.fbv.rcbop.calc;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calc extends JFrame implements ActionListener {

	private static final long	serialVersionUID	= 1L;
	
	// Layouts
	private BorderLayout	rootBorderLayout;
	private GridLayout		gridLayout;

	// Components
	private JPanel			panelBtnArea;
	private JTextField		txtField;

	// Buttons
	private JButton			btnSen;
	private JButton			btnCos;
	private JButton			btnTan;
	private JButton			btnExp;
	private JButton			btnPlusMinus;
	private JButton			btnPercent;
	private JButton			btnMr;
	private JButton			btnMem;
	private JButton			btnPlus;
	private JButton			btnMinus;
	private JButton			btnMultiply;
	private JButton			btnDot;
	private JButton			btnDiv;
	private JButton			btnEquals;
	private JButton			btnClear;

	// Numeric
	private JButton			btn1;
	private JButton			btn2;
	private JButton			btn3;
	private JButton			btn4;
	private JButton			btn5;
	private JButton			btn6;
	private JButton			btn7;
	private JButton			btn8;
	private JButton			btn9;
	private JButton			btn0;

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

		txtField = new JTextField();
		this.add(txtField, BorderLayout.NORTH);

		btnSen = new JButton("Sen");
		panelBtnArea.add(btnSen);
		
		btnCos = new JButton("Cos");
		panelBtnArea.add(btnCos);
		
		btnTan = new JButton("Tan");
		panelBtnArea.add(btnTan);
		
		btnExp = new JButton("EXP");
		panelBtnArea.add(btnExp);
		
		btnPlusMinus = new JButton("+-");
		panelBtnArea.add(btnPlusMinus);
		
		btnPercent = new JButton("%");
		panelBtnArea.add(btnPercent);
		
		btn7 = new JButton("7");
		panelBtnArea.add(btn7);
		
		btn8 = new JButton("8");
		panelBtnArea.add(btn8);
		
		btn9 = new JButton("9");
		panelBtnArea.add(btn9);
		
		btnDiv = new JButton("/");
		panelBtnArea.add(btnDiv);
		
		btnMr = new JButton("MR");
		panelBtnArea.add(btnMr);

		btn4 = new JButton("4");
		panelBtnArea.add(btn4);

		btn5 = new JButton("5");
		panelBtnArea.add(btn5);

		btn6 = new JButton("6");
		panelBtnArea.add(btn6);

		btnMultiply = new JButton("*");
		panelBtnArea.add(btnMultiply);

		btnMem = new JButton("MEM");
		panelBtnArea.add(btnMem);

		btn1 = new JButton("1");
		panelBtnArea.add(btn1);

		btn2 = new JButton("2");
		panelBtnArea.add(btn2);

		btn3 = new JButton("3");
		panelBtnArea.add(btn3);

		btnMinus = new JButton("-");
		panelBtnArea.add(btnMinus);

		btnClear = new JButton("CE");
		panelBtnArea.add(btnClear);

		btn0 = new JButton("0");
		panelBtnArea.add(btn0);

		btnDot = new JButton(".");
		panelBtnArea.add(btnDot);

		btnEquals = new JButton("=");
		panelBtnArea.add(btnEquals);

		btnPlus = new JButton("+");
		panelBtnArea.add(btnPlus);
	}

	public static void main(String[] args) {
		Calc newCalc = new Calc();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
	}

}
