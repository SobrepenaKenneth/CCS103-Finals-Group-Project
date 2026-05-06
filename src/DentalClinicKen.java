import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JToolBar;

public class DentalClinicKen {

	// ==================== INSTANCE VARIABLES (WindowBuilder Format) ====================
	
	private JFrame frame;
	private CardLayout cardlay = new CardLayout(0, 0);

	// Panels
	private JPanel cardPanel;
	private JPanel panelSavedData;
	private JPanel panelNewData;
	private JPanel headerPanel;
	private JPanel detailsPanel;

	// Text Fields
	private JTextField textUsername;
	private JTextField textAge;
	private JTextField textContact;
	private JTextField textSavedName;
	private JTextField textSavedContact;
	private JTextField textSavedAge;

	// Labels
	private JLabel lblUsername;
	private JLabel lblAge;
	private JLabel lblContact;
	private JLabel lblDentalServices;
	private JLabel lblPrice1;
	private JLabel lblPrice2;
	private JLabel lblPrice3;
	private JLabel lblPrice4;
	private JLabel lblPrice5;
	private JLabel lblPrice6;
	private JLabel lblPrice7;
	private JLabel lblPrice8;
	private JLabel lblPrice9;
	private JLabel lblPrice10;
	private JLabel lblTotal;
	private JLabel lblTotalValue;
	private JLabel lblHeader;
	private JLabel lblDetails;
	private JLabel lblDentalClinic;
	private JLabel lblServicesAndPricing;
	private JLabel lblCustomers;
	private JLabel lblSavedName;
	private JLabel lblSavedContact;
	private JLabel lblSavedAge;
	private JLabel lblSavedTotal;
	private JLabel lblSavedTotalVal;
	private JLabel lblAppointments;
	private JLabel lblTotalCustomers;

	// JCheckboxes
	private JCheckBox chckbxOption1;
	private JCheckBox chckbxOption2;
	private JCheckBox chckbxOption3;
	private JCheckBox chckbxOption4;
	private JCheckBox chckbxOption5;
	private JCheckBox chckbxOption6;
	private JCheckBox chckbxOption7;
	private JCheckBox chckbxOption8;
	private JCheckBox chckbxOption9;
	private JCheckBox chckbxOption10;
	
	// JCheckbox Array
	private JCheckBox serviceBoxes[] = new JCheckBox[10];

	// Buttons
	private JButton btnCalculateBill;
	private JButton btnClear;
	private JButton btnNewEntry;
	

	// Tables and Lists
	private JTable tableInput;
	private JTable tableDisplay;
	private JList<String> listDisplayTables;
	
	// Scroll Panes
	private JScrollPane scrollInput;
	private JScrollPane scrollTable;
	private JScrollPane scrollPane;
	
	// Separators
	private JSeparator separatorDentalService;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	
	// Menu Components
	private JMenuBar menuBar;
	private JMenu menuFILE;
	private JMenuItem mItemNew;

	// Data Models
	private DefaultTableModel dataInputModel = new DefaultTableModel(0, 2);
	private DefaultListModel<String> savedTableDisplay = new DefaultListModel<>();
	private DefaultTableModel savedTables[] = new DefaultTableModel[30];

	// Data Storage
	private int usedTableSlots = 0;
	private String savedCustomerDetails[][] = new String[30][4];
	private double servicePrices[] = { 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000 };
	private int selectedServices = 0;

	// ==================== MAIN METHOD ====================
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DentalClinicKen window = new DentalClinicKen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DentalClinicKen() {
		initialize();
	}

	// ==================== INITIALIZE METHOD ====================
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// ==================== FRAME SETUP ====================
		frame = new JFrame();
		frame.setBounds(100, 100, 815, 749);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// ==================== MENU BAR ====================
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 791, 22);
		frame.getContentPane().add(menuBar);

		menuFILE = new JMenu("FILE");
		menuBar.add(menuFILE);

		mItemNew = new JMenuItem("New Form");
		menuFILE.add(mItemNew);

		// ==================== HEADER PANEL ====================
		headerPanel = new JPanel();
		headerPanel.setBackground(new Color(100, 149, 237));
		headerPanel.setBounds(10, 32, 781, 77);
		frame.getContentPane().add(headerPanel);

		lblDentalClinic = new JLabel("Dental Clinic Management V1.0");
		lblDentalClinic.setForeground(new Color(255, 255, 255));
		lblDentalClinic.setFont(new Font("Segoe UI Black", Font.PLAIN, 40));
		headerPanel.add(lblDentalClinic);

		// ==================== CARD PANEL ====================
		cardPanel = new JPanel();
		cardPanel.setBounds(10, 106, 781, 596);
		frame.getContentPane().add(cardPanel);
		cardPanel.setLayout(cardlay);

		// ==================== LABELS ====================
		// Panel New Data Labels
		lblUsername = new JLabel("Name");
		lblAge = new JLabel("Age");
		lblContact = new JLabel("Contact No.");
		lblDentalServices = new JLabel("Dental Services");
		lblPrice1 = new JLabel("₱1000");
		lblPrice2 = new JLabel("₱2000");
		lblPrice3 = new JLabel("₱3000");
		lblPrice4 = new JLabel("₱4000");
		lblPrice5 = new JLabel("₱5000");
		lblPrice6 = new JLabel("₱6000");
		lblPrice7 = new JLabel("₱7000");
		lblPrice8 = new JLabel("₱8000");
		lblPrice9 = new JLabel("₱9000");
		lblPrice10 = new JLabel("₱10000");
		lblTotal = new JLabel("Total:");
		lblTotalValue = new JLabel("0");
		
		// Panel Saved Data Labels
		lblHeader = new JLabel("Customer Information");
		lblDetails = new JLabel("View and manage customer details");
		lblServicesAndPricing = new JLabel("Services And Pricing");
		lblCustomers = new JLabel("Customers");
		lblSavedName = new JLabel("Customer Name:");
		lblSavedContact = new JLabel("Contact No.");
		lblSavedAge = new JLabel("Age");
		lblSavedTotal = new JLabel("Total:");
		lblSavedTotalVal = new JLabel("0");
		lblAppointments = new JLabel("Appointments:");
		lblTotalCustomers = new JLabel("0");

		// ==================== TEXT FIELDS ====================
		textUsername = new JTextField();
		textAge = new JTextField();
		textContact = new JTextField();
		textSavedName = new JTextField();
		textSavedContact = new JTextField();
		textSavedAge = new JTextField();

		// ==================== CHECKBOXES ====================
		chckbxOption1 = new JCheckBox("Dental Check-up & Oral Exam");
		chckbxOption2 = new JCheckBox("Teeth Cleaning");
		chckbxOption3 = new JCheckBox("Dental Fillings");
		chckbxOption4 = new JCheckBox("Tooth Extraction");
		chckbxOption5 = new JCheckBox("Root Canal Treatment");
		chckbxOption6 = new JCheckBox("Bridges, Dentures & Tooth Replacement");
		chckbxOption7 = new JCheckBox("Dental Crowns");
		chckbxOption8 = new JCheckBox("Orthodontics (Braces / Aligners)");
		chckbxOption9 = new JCheckBox("Teeth Whitening");
		chckbxOption10 = new JCheckBox("Gum Treatment");

		// ==================== SCROLL PANES ====================
		scrollInput = new JScrollPane();
		scrollTable = new JScrollPane();
		scrollPane = new JScrollPane();

		// ==================== SEPARATORS ====================
		separatorDentalService = new JSeparator();
		separator = new JSeparator();
		separator_1 = new JSeparator();
		separator_2 = new JSeparator();
		separator_3 = new JSeparator();

		// ==================== CREATE TABLES ====================
		tableInput = new JTable(dataInputModel) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		
		tableDisplay = new JTable() {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};

		// ==================== CREATE LIST ====================
		listDisplayTables = new JList<>(savedTableDisplay);

		// ==================== CREATE BUTTONS ====================
		btnCalculateBill = new JButton("Calculate Bill");
		btnClear = new JButton("Clear Form");
		btnNewEntry = new JButton("New Form");
		JButton btnRemoveCustomer = new JButton("Remove Customer");
		JButton btnEditForm = new JButton("Edit Form");

		// ==================== CREATE DETAILS PANEL ====================
		detailsPanel = new JPanel();

		// ==================== SETUP PANEL NEW DATA (Patient Entry Form) ====================
		panelNewData = new JPanel();
		panelNewData.setLayout(null);

		// Add Labels to Panel New Data
		lblUsername.setBounds(10, 14, 46, 14);
		panelNewData.add(lblUsername);
		
		lblAge.setBounds(10, 39, 46, 14);
		panelNewData.add(lblAge);
		
		lblContact.setBounds(10, 64, 71, 14);
		panelNewData.add(lblContact);
		
		lblDentalServices.setBounds(10, 89, 92, 14);
		panelNewData.add(lblDentalServices);
		
		lblPrice1.setBounds(220, 114, 80, 14);
		panelNewData.add(lblPrice1);
		
		lblPrice2.setBounds(220, 140, 80, 14);
		panelNewData.add(lblPrice2);
		
		lblPrice3.setBounds(220, 166, 80, 14);
		panelNewData.add(lblPrice3);
		
		lblPrice4.setBounds(220, 192, 80, 14);
		panelNewData.add(lblPrice4);
		
		lblPrice5.setBounds(220, 218, 80, 14);
		panelNewData.add(lblPrice5);
		
		lblPrice6.setBounds(220, 244, 80, 14);
		panelNewData.add(lblPrice6);
		
		lblPrice7.setBounds(220, 270, 80, 14);
		panelNewData.add(lblPrice7);
		
		lblPrice8.setBounds(220, 296, 46, 14);
		panelNewData.add(lblPrice8);
		
		lblPrice9.setBounds(220, 322, 46, 14);
		panelNewData.add(lblPrice9);
		
		lblPrice10.setBounds(220, 348, 46, 14);
		panelNewData.add(lblPrice10);
		
		lblTotal.setBounds(279, 322, 46, 14);
		panelNewData.add(lblTotal);
		
		lblTotalValue.setBounds(464, 322, 46, 14);
		panelNewData.add(lblTotalValue);

		// Add Text Fields to Panel New Data
		textUsername.setColumns(10);
		textUsername.setBounds(84, 11, 175, 20);
		panelNewData.add(textUsername);
		
		textAge.setColumns(10);
		textAge.setBounds(84, 36, 175, 20);
		panelNewData.add(textAge);
		
		textContact.setColumns(10);
		textContact.setBounds(84, 61, 175, 20);
		panelNewData.add(textContact);

		// Add JCheckboxes to Panel New Data
		chckbxOption1.setFont(new Font("Tahoma", Font.BOLD, 10));
		chckbxOption1.setBounds(5, 110, 199, 23);
		panelNewData.add(chckbxOption1);
		serviceBoxes[0] = chckbxOption1;
		
		chckbxOption2.setBounds(5, 136, 199, 23);
		panelNewData.add(chckbxOption2);
		serviceBoxes[1] = chckbxOption2;
		
		chckbxOption3.setBounds(5, 162, 199, 23);
		panelNewData.add(chckbxOption3);
		serviceBoxes[2] = chckbxOption3;
		
		chckbxOption4.setBounds(5, 188, 205, 23);
		panelNewData.add(chckbxOption4);
		serviceBoxes[3] = chckbxOption4;
		
		chckbxOption5.setBounds(5, 214, 205, 23);
		panelNewData.add(chckbxOption5);
		serviceBoxes[4] = chckbxOption5;
		
		chckbxOption6.setFont(new Font("Tahoma", Font.BOLD, 9));
		chckbxOption6.setBounds(5, 240, 205, 23);
		panelNewData.add(chckbxOption6);
		serviceBoxes[5] = chckbxOption6;
		
		chckbxOption7.setBounds(5, 266, 199, 23);
		panelNewData.add(chckbxOption7);
		serviceBoxes[6] = chckbxOption7;
		
		chckbxOption8.setFont(new Font("Tahoma", Font.BOLD, 10));
		chckbxOption8.setBounds(5, 292, 205, 23);
		panelNewData.add(chckbxOption8);
		serviceBoxes[7] = chckbxOption8;
		
		chckbxOption9.setBounds(5, 318, 199, 23);
		panelNewData.add(chckbxOption9);
		serviceBoxes[8] = chckbxOption9;
		
		chckbxOption10.setBounds(5, 344, 205, 23);
		panelNewData.add(chckbxOption10);
		serviceBoxes[9] = chckbxOption10;

		// Add Separator to Panel New Data
		separatorDentalService.setBounds(108, 96, 148, 2);
		panelNewData.add(separatorDentalService);

		// Add Scroll Pane to Panel New Data
		scrollInput.setBounds(269, 11, 375, 300);
		panelNewData.add(scrollInput);
		tableInput.setFillsViewportHeight(true);
		scrollInput.setViewportView(tableInput);

		// ===== SETUP PANEL SAVED DATA (Transaction Log View) =====
		panelSavedData = new JPanel();
		panelSavedData.setLayout(null);

		// Add Labels to Panel Saved Data
		lblHeader.setBackground(new Color(30, 144, 255));
		lblHeader.setForeground(new Color(0, 0, 255));
		lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblHeader.setBounds(10, 10, 210, 23);
		panelSavedData.add(lblHeader);
		
		lblDetails.setForeground(new Color(0, 0, 0));
		lblDetails.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblDetails.setBounds(10, 33, 251, 23);
		panelSavedData.add(lblDetails);
		
		lblServicesAndPricing.setForeground(Color.BLUE);
		lblServicesAndPricing.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblServicesAndPricing.setBackground(new Color(30, 144, 255));
		lblServicesAndPricing.setBounds(406, 0, 238, 56);
		panelSavedData.add(lblServicesAndPricing);
		
		lblCustomers.setForeground(Color.BLUE);
		lblCustomers.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblCustomers.setBackground(new Color(30, 144, 255));
		lblCustomers.setBounds(62, 273, 127, 39);
		panelSavedData.add(lblCustomers);
		
		lblSavedName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblSavedName.setBounds(10, 66, 127, 20);
		panelSavedData.add(lblSavedName);
		
		lblSavedContact.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblSavedContact.setBounds(10, 133, 90, 20);
		panelSavedData.add(lblSavedContact);
		
		lblSavedAge.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblSavedAge.setBounds(10, 203, 39, 20);
		panelSavedData.add(lblSavedAge);

		// Text Fields
		textSavedName.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		textSavedName.setEditable(false);
		textSavedName.setColumns(10);
		textSavedName.setBounds(10, 93, 238, 30);
		panelSavedData.add(textSavedName);
		
		textSavedContact.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		textSavedContact.setEditable(false);
		textSavedContact.setColumns(10);
		textSavedContact.setBounds(10, 163, 238, 30);
		panelSavedData.add(textSavedContact);
		
		textSavedAge.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		textSavedAge.setEditable(false);
		textSavedAge.setColumns(10);
		textSavedAge.setBounds(10, 233, 238, 30);
		panelSavedData.add(textSavedAge);

		// Separators
		separator.setForeground(new Color(100, 149, 237));
		separator.setBounds(10, 61, 238, 6);
		panelSavedData.add(separator);
		
		separator_1.setForeground(new Color(100, 149, 237));
		separator_1.setBounds(10, 273, 238, 6);
		panelSavedData.add(separator_1);

		// Scroll Panes 
		scrollTable.setBounds(271, 61, 500, 408);
		panelSavedData.add(scrollTable);
		tableDisplay.setBorder(new LineBorder(new Color(100, 149, 237), 5, true));
		tableDisplay.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tableDisplay.setFillsViewportHeight(true);
		scrollTable.setViewportView(tableDisplay);
		
		scrollPane.setBounds(10, 315, 238, 225);
		panelSavedData.add(scrollPane);
		listDisplayTables.setBorder(new LineBorder(new Color(100, 149, 237), 5, true));
		listDisplayTables.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		listDisplayTables.addMouseListener(selectView);
		scrollPane.setViewportView(listDisplayTables);

		// ==================== DETAILS PANEL ====================
		detailsPanel.setBounds(271, 479, 500, 69);
		panelSavedData.add(detailsPanel);
		
		lblAppointments.setForeground(new Color(65, 105, 225));
		lblAppointments.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		detailsPanel.add(lblAppointments);
		
		lblTotalCustomers.setForeground(new Color(34, 139, 34));
		lblTotalCustomers.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		detailsPanel.add(lblTotalCustomers);
		
		separator_2 = new JSeparator();
		detailsPanel.add(separator_2);
		
		separator_3 = new JSeparator();
		detailsPanel.add(separator_3);
		
		lblSavedTotal.setForeground(new Color(65, 105, 225));
		lblSavedTotal.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		detailsPanel.add(lblSavedTotal);
		
		lblSavedTotalVal.setForeground(new Color(34, 139, 34));
		lblSavedTotalVal.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		detailsPanel.add(lblSavedTotalVal);

		cardPanel.add(panelSavedData, "1");
		cardPanel.add(panelNewData, "2");
		panelSavedData.setVisible(true);

		// ==================== TABLE MODEL SETUP ====================
		dataInputModel.setColumnIdentifiers(new String[] { "Service", "Price" });

		// ==================== BUTTONS SECTION (All buttons at the bottom) ====================
		
		btnCalculateBill.addActionListener(calculate);
		btnCalculateBill.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCalculateBill.setBounds(286, 364, 168, 23);
		panelNewData.add(btnCalculateBill);
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearInput();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnClear.setBounds(464, 364, 168, 23);
		panelNewData.add(btnClear);

		btnNewEntry.setForeground(new Color(255, 255, 255));
		btnNewEntry.setBackground(new Color(107, 142, 35));
		btnNewEntry.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnNewEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlay.next(cardPanel);
			}
		});
		btnNewEntry.setBounds(10, 550, 238, 36);
		panelSavedData.add(btnNewEntry);
		
		btnRemoveCustomer.setForeground(Color.WHITE);
		btnRemoveCustomer.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnRemoveCustomer.setBackground(new Color(240, 128, 128));
		btnRemoveCustomer.setBounds(271, 550, 238, 36);
		
		panelSavedData.add(btnRemoveCustomer);
		btnEditForm.setForeground(Color.WHITE);
		btnEditForm.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnEditForm.setBackground(new Color(244, 164, 96));
		btnEditForm.setBounds(543, 550, 228, 36);
		
		panelSavedData.add(btnEditForm);

		// ===== EVENT LISTENERS =====
		for (JCheckBox cb : serviceBoxes) {
			cb.addItemListener(service);
		}
	}

	
	void clearInput() {
		textUsername.setText("");
		textAge.setText("");
		textContact.setText("");
		deselectBoxes();
		selectedServices = 0;
		dataInputModel.setRowCount(0);
		lblTotalValue.setText("0");
	}

	void deselectBoxes() {
		for (JCheckBox cb : serviceBoxes) {
			if (cb != null) {
				cb.setSelected(false);
			}
		}
	}

	MouseAdapter selectView = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int target = listDisplayTables.getSelectedIndex();
			if (target == -1)
				return;
			tableDisplay.setModel(savedTables[target]);
			System.out.print("list index: " + target);
			textSavedName.setText(savedCustomerDetails[target][0]);
			textSavedAge.setText(savedCustomerDetails[target][1]);
			textSavedContact.setText(savedCustomerDetails[target][2]);
			lblSavedTotalVal.setText(savedCustomerDetails[target][3]);
		}
	};

	ItemListener service = new ItemListener() {
		@Override
		public void itemStateChanged(ItemEvent e) {
			int state = e.getStateChange();
			JCheckBox origin = (JCheckBox) e.getSource();
			String name = origin.getText();
			double totalBill = Double.parseDouble(lblTotalValue.getText());
			int target = 0;

			if (state == ItemEvent.SELECTED) {
				for (int i = 0; i < serviceBoxes.length; i++) {
					if (serviceBoxes[i] == origin) {
						target = i;
						System.out.println("target is at: " + i);
						break;
					}
				}
				String price = String.valueOf(servicePrices[target]);
				dataInputModel.addRow(new String[] { name, price });
				lblTotalValue.setText(String.valueOf(totalBill + servicePrices[target]));
				selectedServices++;
			} else {
				for (int i = 0; i < dataInputModel.getRowCount(); i++) {
					String valueAt = dataInputModel.getValueAt(i, 0).toString();
					if (valueAt.equals(name)) {
						target = i;
						System.out.println("target is at: " + i);
						break;
					}
				}
				double price = Double.parseDouble(dataInputModel.getValueAt(target, 1).toString());
				dataInputModel.removeRow(target);
				lblTotalValue.setText(String.valueOf(totalBill - price));
				selectedServices--;
			}
		}
	};

	ActionListener calculate = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String username = textUsername.getText();
			String age = textAge.getText();
			String contactNo = textContact.getText();

			if (username.isEmpty() || age.isEmpty() || contactNo.isEmpty()) {
				JOptionPane.showMessageDialog(cardPanel, "Customer Information Fields cannot be empty!",
						"Missing Customer Details", 0);
				return;
			}

			try {
				Integer.parseInt(age);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(cardPanel, "Invalid age!", "Error", 0);
				return;
			}

			if (dataInputModel.getRowCount() == 0) {
				JOptionPane.showMessageDialog(cardPanel, "Please select at least one service!", "Error", 0);
				return;
			}

			String totalBill = lblTotalValue.getText();

			JOptionPane.showMessageDialog(cardPanel, "Total Bill: ₱" + totalBill);

			savedCustomerDetails[usedTableSlots][0] = username;
			savedCustomerDetails[usedTableSlots][1] = age;
			savedCustomerDetails[usedTableSlots][2] = contactNo;
			savedCustomerDetails[usedTableSlots][3] = totalBill;
			savedTableDisplay.addElement(username);

			savedTables[usedTableSlots] = new DefaultTableModel(0, 2);
			savedTables[usedTableSlots].setColumnIdentifiers(new String[] { "Service", "Price" });
			for (int row = 0; row < dataInputModel.getRowCount(); row++) {
				String service = dataInputModel.getValueAt(row, 0).toString();
				String price = dataInputModel.getValueAt(row, 1).toString();
				savedTables[usedTableSlots].addRow(new String[] { service, price });
			}

			lblTotalCustomers.setText(String.valueOf(usedTableSlots + 1));
			
			clearInput();
			usedTableSlots++;

			cardlay.next(cardPanel);
		}
	};
}