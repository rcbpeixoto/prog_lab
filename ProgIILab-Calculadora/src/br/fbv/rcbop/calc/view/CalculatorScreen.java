package br.fbv.rcbop.calc.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CalculatorScreen extends JFrame {

	private static final long serialVersionUID = 1L;

	// Layouts
	private BorderLayout rootBorderLayout;

	// Components
	private JPanel panelBtnArea;
	private JTextArea txtField;

	public CalculatorScreen() {
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
		this.setLayout(rootBorderLayout);
	}

	private void initGui() {
		panelBtnArea = new JPanel(new BorderLayout());
		this.add(panelBtnArea, BorderLayout.SOUTH);

		createDisplayField();
		createFunctionsArea();
		createNumericArea();
	}

	private void createDisplayField() {
		txtField = new JTextArea(1, 10);
		this.add(txtField, BorderLayout.NORTH);
		txtField.setEditable(false);
	}

	private void createFunctionsArea() {
		new FunctionPanel(panelBtnArea ,txtField);
	}

	private void createNumericArea() {
		new NumericPanel(panelBtnArea, txtField);
	}
}
