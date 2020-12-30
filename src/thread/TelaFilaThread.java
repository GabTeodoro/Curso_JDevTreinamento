package thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaFilaThread extends JDialog {

	JPanel painel = new JPanel(new GridBagLayout());

	JLabel nome = new JLabel("Nome:");
	JTextField entradaNome = new JTextField();

	JLabel email = new JLabel("E-mail:");
	JTextField entradaEmail = new JTextField();

	JButton enviar = new JButton("Adicionar");
	JButton cancelar = new JButton("Cancelar");

	ImplementarFilaThread fila = new ImplementarFilaThread();

	public TelaFilaThread() {

		setTitle("Tela Fila");
		setSize(new Dimension(300, 300));
		setLocationRelativeTo(null);
		setResizable(false);

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(1, 1, 1, 1);
		gridBagConstraints.anchor = gridBagConstraints.WEST;

		nome.setPreferredSize(new Dimension(203, 25));
		painel.add(nome, gridBagConstraints);

		gridBagConstraints.gridy++;
		entradaNome.setPreferredSize(new Dimension(203, 25));
		painel.add(entradaNome, gridBagConstraints);

		gridBagConstraints.gridy++;
		email.setPreferredSize(new Dimension(203, 25));
		painel.add(email, gridBagConstraints);

		gridBagConstraints.gridy++;
		entradaEmail.setPreferredSize(new Dimension(203, 25));
		painel.add(entradaEmail, gridBagConstraints);

		gridBagConstraints.gridwidth = 1;

		gridBagConstraints.gridy++;
		enviar.setPreferredSize(new Dimension(100, 30));
		enviar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Caso eu mate a fila, é necessário instânciar ela novamente
				// Pq não adianta ter o objeto instânciado mas a fila estar como null.
				if (fila == null) {

					fila = new ImplementarFilaThread();
					fila.start();

				}

				for (int i = 1; i <= 100; i++) {

					// Instânciando ObjetoFilaThread.
					ObjetoFilaThread objetoFilaThread = new ObjetoFilaThread();

					// Pegando dados que foram digitados.
					objetoFilaThread.setNome(entradaNome.getText() + " => " + i);
					objetoFilaThread.setEmail(entradaEmail.getText());

					// Chamando o método que adiciona o objeto a fila.
					fila.add(objetoFilaThread);
				}
			}
		});
		painel.add(enviar, gridBagConstraints);

		gridBagConstraints.gridx++;
		cancelar.setPreferredSize(new Dimension(100, 30));
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Parando a fila e mantando o objeto.
				fila.stop();
				fila = null;
			}
		});
		painel.add(cancelar, gridBagConstraints);

		fila.start();
		add(painel, BorderLayout.PAGE_START);
		setVisible(true);

	}

}
