package swing_CorrectionAtelier08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Principale extends JFrame {

	private JPanel contentPane;
	private JTextField txt_mnt;
	DefaultListModel<String> modelDebit = new DefaultListModel<String>();
	DefaultListModel<String> modelCredit = new DefaultListModel<String>();
	private JList listDebit;
	private JList list_Credit;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	double totaldebit = 0;
	double totalcredit = 0;
	private JLabel lbl_total_dbt;
	private JPanel panel_1;
	private JLabel lbl_balance;
	private JLabel lbl_total_crd;
	private JButton btn_annuler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principale frame = new Principale();
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
	public Principale() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 20));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 20, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EmptyBorder(10, 10, 10, 10)));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 10, 10));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_2.add(panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] {100, 201};
		gbl_panel_5.rowHeights = new int[] {20, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 1.0};
		gbl_panel_5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblNewLabel = new JLabel("Montant : ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_5.add(lblNewLabel, gbc_lblNewLabel);
		
		txt_mnt = new JTextField();
		txt_mnt.setPreferredSize(new Dimension(500, 20));
		txt_mnt.setDocument(new DoubleValidate());
		GridBagConstraints gbc_txt_mnt = new GridBagConstraints();
		gbc_txt_mnt.fill = GridBagConstraints.BOTH;
		gbc_txt_mnt.insets = new Insets(0, 0, 0, 5);
		gbc_txt_mnt.anchor = GridBagConstraints.NORTH;
		gbc_txt_mnt.gridx = 1;
		gbc_txt_mnt.gridy = 0;
		panel_5.add(txt_mnt, gbc_txt_mnt);
		txt_mnt.setBorder(new EmptyBorder(0, 0, 10, 0));
		txt_mnt.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[] {80, 100};
		gbl_panel_6.rowHeights = new int[]{46, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, 1.0};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JLabel lblNewLabel_1 = new JLabel("Type de commande :");
		lblNewLabel_1.setVerticalTextPosition(SwingConstants.TOP);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_6.add(lblNewLabel_1, gbc_lblNewLabel_1);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 0;
		panel_6.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new GridLayout(2, 0, 0, 0));
		
		JRadioButton rdDebit = new JRadioButton("Debit");
		buttonGroup.add(rdDebit);
		rdDebit.setSelected(true);
		panel_4.add(rdDebit);
		
		JRadioButton rd_credit = new JRadioButton("Credit");
		buttonGroup.add(rd_credit);
		rd_credit.setPreferredSize(new Dimension(100, 23));
		panel_4.add(rd_credit);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EmptyBorder(10, 10, 10, 10)));
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(3, 0, 10, 7));
		
		JButton btnNewButton = new JButton("Ecrire dans le journal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txt_mnt.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Montant vide");
					return;
				}
				double mnt = Double.parseDouble(txt_mnt.getText());
				
				if(rdDebit.isSelected()) {
					modelDebit.addElement(String.format("%.2f",mnt));
					modelCredit.addElement("0.00");
					totaldebit += mnt;
				}else {
					modelCredit.addElement(String.format("%.2f",mnt));
					modelDebit.addElement("0.00");
					totalcredit += mnt;
				} 
				
				lbl_total_dbt.setText(String.format("%.2f", totaldebit));
				lbl_total_crd.setText(String.format("%.2f", totalcredit));
				lbl_balance.setText(String.format("%.2f", totaldebit-totalcredit));
				
				if(modelDebit.size()>0) {
					btn_annuler.setEnabled(true);
				}
			}
		});
		panel_3.add(btnNewButton);
		
		btn_annuler = new JButton("Annuler la derniere saisie");
		btn_annuler.setEnabled(false);
		btn_annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double debit = Double.valueOf(modelDebit.get(modelDebit.size()-1).replace(',', '.'));
				double credit = Double.valueOf(modelCredit.get(modelCredit.size()-1).replace(',', '.'));
				
				modelDebit.remove(modelDebit.size()-1);
				modelCredit.remove(modelCredit.size()-1);
				
				totaldebit -= debit;
				totalcredit -= credit;
				
				lbl_total_dbt.setText(String.format("%.2f", totaldebit));
				lbl_total_crd.setText(String.format("%.2f", totalcredit));
				lbl_balance.setText(String.format("%.2f", totaldebit-totalcredit));
				
				if(modelDebit.size()==0) {
					btn_annuler.setEnabled(false);
				}
				
			}
		});
		panel_3.add(btn_annuler);
		
		JButton btnNewButton_2 = new JButton("Quitter l'application");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_3.add(btnNewButton_2);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Debit : ");
		lblNewLabel_2.setBounds(149, 35, 145, 14);
		panel_1.add(lblNewLabel_2);
		
		listDebit = new JList();
		listDebit.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				list_Credit.setSelectedIndex(listDebit.getSelectedIndex());
			}
		});
		listDebit.setBounds(149, 54, 145, 133);
		listDebit.setModel(modelDebit);
		panel_1.add(listDebit);
		
		lbl_total_dbt = new JLabel("0.00");
		lbl_total_dbt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lbl_total_dbt.setBounds(207, 198, 87, 14);
		panel_1.add(lbl_total_dbt);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Total :");
		lblNewLabel_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_2_1_1.setBounds(33, 198, 87, 14);
		panel_1.add(lblNewLabel_2_1_1);
		
		lbl_total_crd = new JLabel("0.00");
		lbl_total_crd.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lbl_total_crd.setBounds(425, 198, 87, 14);
		panel_1.add(lbl_total_crd);
		
		list_Credit = new JList();
		list_Credit.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				listDebit.setSelectedIndex(list_Credit.getSelectedIndex());
			}
		});
		list_Credit.setBounds(367, 54, 145, 133);
		list_Credit.setModel(modelCredit);
		panel_1.add(list_Credit);
		
		JLabel lblNewLabel_2_2 = new JLabel("Credit : ");
		lblNewLabel_2_2.setBounds(367, 35, 145, 14);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Balance :");
		lblNewLabel_2_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_2_1_1_1.setBounds(607, 173, 87, 14);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		lbl_balance = new JLabel("0.00");
		lbl_balance.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lbl_balance.setBounds(607, 198, 87, 14);
		panel_1.add(lbl_balance);
	}
}
