package thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Chamando a classe JDialog para criar a tela.
public class TelaThread extends JDialog {

	// Iniciando as classes que vamos precisar do swing.
	// Iniciando um painel que vai ficar dentro da tela.
	private JPanel jPanel = new JPanel(new GridBagLayout());

	// Criando um rótulo e passando a mensagem de parâmetro.
	private JLabel jLabel = new JLabel("1° Time Thread");

	// Criando um campo de entrada de dados.
	private JTextField jTextField = new JTextField();

	private JLabel jLabel2 = new JLabel("2° Time Thread");
	private JTextField jTextField2 = new JTextField();
	
	private JButton jButton = new JButton("Star");
	private JButton jButton2 = new JButton("Stop");

	// O que está dentro do método construtor é o que é mostrado na tela.
	public TelaThread() {

		// Criando a base da tela com swing.
		// Criando Título, tamanho, local.
		setTitle("Tela de Time Thread");
		setSize(new Dimension(300, 250));
		setLocationRelativeTo(null);
		setResizable(false);

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(2, 2, 2, 2);
		gridBagConstraints.anchor = GridBagConstraints.WEST;

		// Definindo o tamanho do rótulo e adicionando ao painel.
		jLabel.setPreferredSize(new Dimension(200, 25));
		jPanel.add(jLabel, gridBagConstraints);

		// Descendo uma grid para baixo.
		gridBagConstraints.gridy++;
		// Definindo o tamanho do campo de texto e adicionando ao painel.
		jTextField.setPreferredSize(new Dimension(200, 25));
		jTextField.setEditable(false);
		jPanel.add(jTextField, gridBagConstraints);
		
		gridBagConstraints.gridy++;
		jLabel2.setPreferredSize(new Dimension(200, 25));
		jPanel.add(jLabel2, gridBagConstraints);
		
		gridBagConstraints.gridy++;
		jTextField2.setPreferredSize(new Dimension(200, 25));
		jTextField2.setEditable(false);
		jPanel.add(jTextField2, gridBagConstraints);
		
		gridBagConstraints.gridwidth = 1;
		
		gridBagConstraints.gridy++;
		jButton.setPreferredSize(new Dimension(92,25));
		jPanel.add(jButton, gridBagConstraints);
		
		gridBagConstraints.gridx++;
		jButton2.setPreferredSize(new Dimension(92,25));
		jPanel.add(jButton2, gridBagConstraints);

		// Adicional o painel dentro da tela.
		add(jPanel, BorderLayout.PAGE_START);

		// Torna a tela visivel para o usuário.
		// Sempre será o último a ser executado.
		setVisible(true);
	}

}
