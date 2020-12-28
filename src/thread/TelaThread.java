package thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

	// Criando os botões.
	private JButton jButton = new JButton("Star");
	private JButton jButton2 = new JButton("Stop");

	private Runnable thread1 = new Runnable() {

		@Override
		public void run() {

			while (true) {

				jTextField
						.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").format(Calendar.getInstance().getTime()));

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	};
	
	private Runnable thread2 = new Runnable() {

		@Override
		public void run() {

			while (true) {

				jTextField2
						.setText(new SimpleDateFormat("yyy/MM/dd hh:mm:ss").format(Calendar.getInstance().getTime()));

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	};

	private Thread threadTime1 = new Thread(thread1);
	private Thread threadTime2 = new Thread(thread2);

	// O que está dentro do método construtor é o que é mostrado na tela.
	public TelaThread() {

		// Criando a base da tela com swing.
		// Criando Título, tamanho, local.
		setTitle("Tela de Time Thread");
		setSize(new Dimension(300, 250));
		setLocationRelativeTo(null);
		setResizable(false);

		// Definindo as posições da grid.
		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		// Definindo o local dos objetos na primeira célula.
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;

		// Definindo quantas colunas vai usar cada elemento.
		gridBagConstraints.gridwidth = 2;

		// Definindo o espaçamento entre cada elemento.
		gridBagConstraints.insets = new Insets(2, 2, 2, 2);

		// Ancorando o elemento a uma posição.
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

		// Definindo cada que cada botão vai usar uma única célula.
		gridBagConstraints.gridwidth = 1;

		// Definindo o tamanho do botão e adicionando ao painel.
		gridBagConstraints.gridy++;
		jButton.setPreferredSize(new Dimension(92, 25));

		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				threadTime1.start();
				threadTime2.start();
				
				jButton.setEnabled(false);
				jButton2.setEnabled(true);
			}
		});

		jPanel.add(jButton, gridBagConstraints);

		gridBagConstraints.gridx++;
		jButton2.setPreferredSize(new Dimension(92, 25));

		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				threadTime1.stop();
				threadTime2.stop();
				
				jButton.setEnabled(true);
				jButton2.setEnabled(false);

			}
		});

		jButton2.setEnabled(false);
		jPanel.add(jButton2, gridBagConstraints);

		// Adicional o painel dentro da tela.
		add(jPanel, BorderLayout.PAGE_START);

		// Torna a tela visivel para o usuário.
		// Sempre será o último a ser executado.
		setVisible(true);
	}

}
