package br.fbv.rcbop.calc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
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
		ImageIcon img = new ImageIcon("assets/icon.png");
        this.setIconImage(img.getImage());
		this.setResizable(true);
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
		Dimension d = new Dimension(100, 50);
		Font font = new Font("Verdana", Font.BOLD, 20);
		
		txtField = new JTextArea(1, 10);
		txtField.setFont(font);
		txtField.setPreferredSize(d);
		txtField.setEditable(false);
		
		this.add(txtField, BorderLayout.NORTH);
	}

	private void createFunctionsArea() {
		new FunctionPanel(panelBtnArea ,txtField);
	}

	private void createNumericArea() {
		new NumericPanel(panelBtnArea, txtField);
	}
}
