package br.fbv.rcbop.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.fbv.rcbop.controller.Facade;
import br.fbv.rcbop.model.Client;
import br.fbv.rcbop.model.ClientNotFoundException;

public class RegistryWindow extends JFrame implements ActionListener {

	private static final long	serialVersionUID	= 3594532824160913197L;
	private JButton				btnSearch;
	private JButton				btnNew;
	private JButton				btnClear;
	private JTextField			codeTextField;
	private JTextField			cityTxtField;
	private JTextField			addressTxtField;
	private JTextField			nameTxtField;
	private JTextField			stateTxtField;
	private JTextField			zipCodeTxtField;
	private JTextField			emailTxtField;
	private JLabel				label1;
	private JLabel				label2;
	private JButton				btnSave;
	private JButton				btnRemove;

	private JPanel				bottomPanel;
	private JPanel				centerPanel;

	private long				actualCode			= 100000;

	public RegistryWindow() {
		getContentPane().setLayout(new BorderLayout());

		initUpperPanel();
		initCenterPanel();
		initBottomPanel();

		this.setSize(550, 270);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Janela de Cadastro");
		this.setVisible(true);
	}

	private void initBottomPanel() {
		bottomPanel = new JPanel(new FlowLayout());
		btnSave = new JButton("Gravar");
		btnSave.addActionListener(this);
		bottomPanel.add(btnSave);
		btnRemove = new JButton("Remover");
		btnRemove.addActionListener(this);
		bottomPanel.add(btnRemove);
		bottomPanel.setEnabled(false);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
	}

	private void initCenterPanel() {
		centerPanel = new JPanel(new FlowLayout());
		centerPanel.add(new JLabel("Nome:"));
		nameTxtField = new JTextField(40);
		centerPanel.add(nameTxtField);
		centerPanel.add(new JLabel("          "));
		centerPanel.add(new JLabel("Endereço:"));
		addressTxtField = new JTextField(40);
		centerPanel.add(addressTxtField);

		label2 = new JLabel("                 ");
		centerPanel.add(label2);
		centerPanel.add(new JLabel("Cidade:"));
		cityTxtField = new JTextField(10);
		centerPanel.add(cityTxtField);
		centerPanel.add(new JLabel("Estado:"));
		stateTxtField = new JTextField(10);
		centerPanel.add(stateTxtField);
		centerPanel.add(new JLabel("                                                       "));
		centerPanel.add(new JLabel("CEP:"));
		zipCodeTxtField = new JTextField(7);
		centerPanel.add(zipCodeTxtField);
		centerPanel.add(new JLabel("E-mail:"));
		emailTxtField = new JTextField(15);
		centerPanel.add(emailTxtField);
		
		label1 = new JLabel("                                      ");
		centerPanel.add(label1);
		disableEditArea();
		getContentPane().add(centerPanel, BorderLayout.CENTER);
	}

	private void initUpperPanel() {
		JPanel upperPanel = new JPanel(new FlowLayout());
		upperPanel.add(new JLabel("Código"));
		codeTextField = new JTextField();
		codeTextField.setColumns(10);
		upperPanel.add(codeTextField);
		btnSearch = new JButton("Buscar");
		btnSearch.addActionListener(this);
		upperPanel.add(btnSearch);
		btnNew = new JButton("Novo");
		btnNew.addActionListener(this);
		upperPanel.add(btnNew);
		btnClear = new JButton("Limpar");
		btnClear.addActionListener(this);
		upperPanel.add(btnClear);

		getContentPane().add(upperPanel, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			searchClient();
		} else if (e.getSource() == btnNew) {
			clearInputField();
			enableEditArea();
			disableCodeField();
			codeTextField.setText("" + actualCode++);
		} else if (e.getSource() == btnClear) {
			clearInputField();
			disableEditArea();
			enableCodeField();
		} else if (e.getSource() == btnSave) {
			saveClient();
			clearInputField();
			disableEditArea();
			enableCodeField();
		} else if (e.getSource() == btnRemove) {
			removeClient();
			clearInputField();
			enableCodeField();
			disableEditArea();
		}

	}

	private void removeClient() {
		if (!codeTextField.getText().equals("")) {
			Facade.getInstance().remove(Long.parseLong(codeTextField.getText()));
			JOptionPane.showMessageDialog(this, "Cliente removido", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void saveClient() {
		Client client = new Client();
		client.setCode(Long.parseLong(codeTextField.getText()));
		client.setName(nameTxtField.getText());
		client.setAddress(addressTxtField.getText());
		client.setState(stateTxtField.getText());
		client.setCity(cityTxtField.getText());
		client.setZipCode(zipCodeTxtField.getText());
		client.setEmail(emailTxtField.getText());
		Facade.getInstance().insert(client);
	}

	private void searchClient() {
		if (!codeTextField.getText().equals("")) {
			try {
				Client client = Facade.getInstance().search(Long.parseLong(codeTextField.getText()));
				codeTextField.setText(client.getCode()+"");
				cityTxtField.setText(client.getCity());
				addressTxtField.setText(client.getAddress());
				nameTxtField.setText(client.getName());
				stateTxtField.setText(client.getState());
				zipCodeTxtField.setText(client.getZipCode());
				emailTxtField.setText(client.getEmail());
				enableEditArea();
				disableCodeField();
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "O código é composto apenas por dígitos", "ERRO",
						JOptionPane.ERROR_MESSAGE);
			} catch (ClientNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "Cliente não encontrado", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void enableCodeField(){
		codeTextField.setEditable(true);
	}
	
	private void disableCodeField(){
		codeTextField.setEditable(false);
	}

	private void disableEditArea() {
		cityTxtField.setEditable(false);
		addressTxtField.setEditable(false);
		nameTxtField.setEditable(false);
		stateTxtField.setEditable(false);
		zipCodeTxtField.setEditable(false);
		emailTxtField.setEditable(false);
	}

	private void enableEditArea() {
		cityTxtField.setEditable(true);
		addressTxtField.setEditable(true);
		nameTxtField.setEditable(true);
		stateTxtField.setEditable(true);
		zipCodeTxtField.setEditable(true);
		emailTxtField.setEditable(true);
	}

	private void clearInputField() {
		codeTextField.setText("");
		cityTxtField.setText("");
		addressTxtField.setText("");
		nameTxtField.setText("");
		stateTxtField.setText("");
		zipCodeTxtField.setText("");
		emailTxtField.setText("");
	}
}