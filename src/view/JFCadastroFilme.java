package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.filme;
import model.dao.FilmeDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JLayeredPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class JFCadastroFilme extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Titul;
	private JTextField categor;
	private JTextField sinops;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastroFilme frame = new JFCadastroFilme();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFCadastroFilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Filme");
		lblNewLabel.setFont(new Font("Source Serif Pro Semibold", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 125, 26);
		contentPane.add(lblNewLabel);
		
		JLabel titulo = new JLabel("T\u00EDtulo");
		titulo.setFont(new Font("Source Serif Pro Semibold", Font.BOLD, 13));
		titulo.setBounds(10, 46, 46, 14);
		contentPane.add(titulo);
		
		Titul = new JTextField();
		Titul.setBounds(10, 72, 345, 20);
		contentPane.add(Titul);
		Titul.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sinopse");
		lblNewLabel_2.setFont(new Font("Source Serif Pro Semibold", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 107, 57, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Categoria");
		lblNewLabel_3.setFont(new Font("Source Serif Pro Semibold", Font.BOLD, 13));
		lblNewLabel_3.setBounds(121, 46, 57, 14);
		contentPane.add(lblNewLabel_3);
		
		categor = new JTextField();
		categor.setBounds(202, 46, 86, 20);
		contentPane.add(categor);
		categor.setColumns(10);
		
		JRadioButton rdbtn3d = new JRadioButton("3D");
		rdbtn3d.setBounds(319, 11, 109, 23);
		contentPane.add(rdbtn3d);
		
		JRadioButton rdbtn2d = new JRadioButton("2D");
		rdbtn2d.setBounds(319, 37, 109, 23);
		contentPane.add(rdbtn2d);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtn3d);
		imagem.add(rdbtn2d);
		
		JSpinner Duracao = new JSpinner();
		Duracao.setToolTipText("Dura\u00E7\u00E3o");
		Duracao.setBounds(10, 219, 29, 20);
		contentPane.add(Duracao);
		
		JLabel lblNewLabel_4 = new JLabel("Dura\u00E7\u00E3o");
		lblNewLabel_4.setFont(new Font("Source Serif Pro Semibold", Font.BOLD, 13));
		lblNewLabel_4.setBounds(43, 222, 57, 14);
		contentPane.add(lblNewLabel_4);
		
		JRadioButton rdbtnDub = new JRadioButton("Dub");
		rdbtnDub.setFont(new Font("Source Serif Pro Semibold", Font.PLAIN, 12));
		rdbtnDub.setBounds(106, 218, 57, 23);
		contentPane.add(rdbtnDub);
		
		JRadioButton rdbtnLeg = new JRadioButton("Leg");
		rdbtnLeg.setFont(new Font("Source Serif Pro Semibold", Font.BOLD, 12));
		rdbtnLeg.setBounds(179, 218, 57, 23);
		contentPane.add(rdbtnLeg);
		
		ButtonGroup audio = new ButtonGroup();
		audio.add(rdbtnDub);
		audio.add(rdbtnLeg);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(242, 218, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filme f = new filme();
				FilmeDAO dao = new FilmeDAO();
				f.setTitulo(Titul.getText());
				f.setCategoria(categor.getText());
				f.setSinopse(sinops.getText());
				f.setTempo(Integer.parseInt(Duracao.getValue().toString()));
				if (rdbtn2d.isSelected()) {
					f.setImg3d(false);
					
				}else if (rdbtn3d.isSelected()) {
					f.setImg3d(true);
					
				}
				if (rdbtnDub.isSelected()) {
					f.setDublado(true);
					
				}else if (rdbtnLeg.isSelected()) {
					f.setDublado(false);
					
				}
				
				dao.create(f);
			}
		});
		btnNewButton_1.setBounds(341, 218, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(391, 180, -386, -59);
		contentPane.add(scrollPane);
		
		sinops = new JTextField();
		sinops.setBounds(10, 120, 382, 58);
		contentPane.add(sinops);
		sinops.setColumns(10);
	}
}
