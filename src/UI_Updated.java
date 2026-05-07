import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class UI_Updated {

	// ==================== INSTANCE VARIABLES (WindowBuilder Format) ====================
	
	private JFrame frame;
	//private CardLayout cardlay = new CardLayout(0, 0);

	// Panels
	private JPanel panelSavedData;
	private JPanel panelNewData;
	private JPanel headerPanel;
	private JPanel detailsPanel;

	// Text Fields
	private JTextField textUsername;
	private JSpinner spinAge;
	private JTextField textContact;
	private JTextField textSavedName;
	private JTextField textSavedContact;
	private JTextField textSavedAge;

	// Labels
	private JLabel lblUsername;
	private JLabel lblAge;
	private JLabel lblContact;
	private JLabel lblPrice1;
	private JLabel lblPrice6;
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
	private JTable tableNewData;
	private JTable tableSavedData;
	private JList<String> listDisplayTables;
	
	// Scroll Panes
	private JScrollPane scrollNewData;
	private JScrollPane scrollSavedData;
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
	private JMenuItem mItemSaved;
	private JMenuItem mItemEdit;
	private JMenuItem mItemRemove;
	
	// Data Models
	private DefaultTableModel dataInputModel = new DefaultTableModel(0, 2);
	private DefaultListModel<String> savedTableDisplay = new DefaultListModel<>();
	private DefaultTableModel savedTables[] = new DefaultTableModel[30];

	// Data Storage
	private int usedTableSlots = 0;
	private String savedCustomerDetails[][] = new String[30][4];
	private double servicePrices[] = { 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000 };
	private int selectedServices = 0;
	private int editIndex = -1;

	// ==================== MAIN METHOD ====================
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Updated window = new UI_Updated();
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
	public UI_Updated() {
		initialize();
	}

	// ==================== INITIALIZE METHOD ====================
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// ==================== FRAME SETUP ====================
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 815, 749);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// ==================== MENU BAR ====================
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 799, 22);
		frame.getContentPane().add(menuBar);

		menuFILE = new JMenu("FILE");
		menuBar.add(menuFILE);
		
		mItemSaved = new JMenuItem("Records");
		mItemSaved.addActionListener(e -> viewRecords());
		menuFILE.add(mItemSaved);

		mItemNew = new JMenuItem("New Record");
		mItemNew.addActionListener(e -> newForm(true));
		menuFILE.add(mItemNew);
		
		mItemEdit = new JMenuItem("Edit Record");
		mItemEdit.addActionListener(editRecord);
		menuFILE.add(mItemEdit);
		
		mItemRemove = new JMenuItem("Delete Record");
		mItemRemove.addActionListener(deleteRecord);
		menuFILE.add(mItemRemove);
		
		JSeparator mSeparator = new JSeparator();
		menuFILE.add(mSeparator);
		
		JMenuItem mnItemExit = new JMenuItem("Exit");
		mnItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
				
			}
		});
		menuFILE.add(mnItemExit);

		// ==================== HEADER PANEL ====================
		headerPanel = new JPanel();
		headerPanel.setBackground(new Color(100, 149, 237));
		headerPanel.setBounds(10, 32, 781, 77);
		frame.getContentPane().add(headerPanel);

		lblDentalClinic = new JLabel("Dental Clinic Management V1.0");
		lblDentalClinic.setForeground(new Color(255, 255, 255));
		lblDentalClinic.setFont(new Font("Segoe UI Black", Font.PLAIN, 40));
		headerPanel.add(lblDentalClinic);

		// ==================== LABELS ====================
		// Panel New Data Labels
		lblUsername = new JLabel("Name");
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblContact = new JLabel("Contact No.");
		lblContact.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblPrice1 = new JLabel("₱1000");
		lblPrice1.setForeground(new Color(34, 139, 34));
		lblPrice1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblPrice6 = new JLabel("₱6000");
		lblPrice6.setForeground(new Color(34, 139, 34));
		lblPrice6.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTotalValue = new JLabel("0");
		lblTotalValue.setForeground(new Color(34, 139, 34));
		lblTotalValue.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		
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
		spinAge = new JSpinner();
		spinAge.setModel(new SpinnerNumberModel(0,0,Integer.MAX_VALUE,1));
		textContact = new JTextField();
		textContact.addKeyListener(ignoreLetters);
		textSavedName = new JTextField();
		textSavedContact = new JTextField();
		textSavedAge = new JTextField();

		// ==================== CHECKBOXES ====================
		chckbxOption1 = new JCheckBox("Dental Check-up & Oral Exam");
		chckbxOption2 = new JCheckBox("Teeth Cleaning");
		chckbxOption2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		chckbxOption3 = new JCheckBox("Dental Fillings");
		chckbxOption3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		chckbxOption4 = new JCheckBox("Tooth Extraction");
		chckbxOption4.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		chckbxOption5 = new JCheckBox("Root Canal Treatment");
		chckbxOption5.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		chckbxOption6 = new JCheckBox("Bridges, Dentures & Tooth Replacement");
		chckbxOption7 = new JCheckBox("Dental Crowns");
		chckbxOption7.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		chckbxOption8 = new JCheckBox("Orthodontics (Braces / Aligners)");
		chckbxOption9 = new JCheckBox("Teeth Whitening");
		chckbxOption9.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		chckbxOption10 = new JCheckBox("Gum Treatment");
		chckbxOption10.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		// ==================== SCROLL PANES ====================
		scrollNewData = new JScrollPane();
		scrollSavedData = new JScrollPane();
		scrollPane = new JScrollPane();

		// ==================== SEPARATORS ====================
		separatorDentalService = new JSeparator();
		separatorDentalService.setForeground(new Color(30, 144, 255));
		separator = new JSeparator();
		separator_1 = new JSeparator();
		separator_2 = new JSeparator();
		separator_3 = new JSeparator();

		// ==================== CREATE TABLES ====================
		tableNewData = new JTable(dataInputModel) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		
		tableSavedData = new JTable() {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};

		// ==================== CREATE LIST ====================
		listDisplayTables = new JList<>(savedTableDisplay);

		// ==================== CREATE BUTTONS ====================
		btnCalculateBill = new JButton("Calculate Bill");
		btnCalculateBill.setBackground(new Color(34, 139, 34));
		btnCalculateBill.setForeground(new Color(255, 255, 255));
		btnCalculateBill.setToolTipText("Finalise and Save Record.");
		btnClear = new JButton("Clear Form");
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setBackground(new Color(220, 20, 60));
		btnClear.setToolTipText("Reset Record to the default, empty state.");
		btnNewEntry = new JButton("New Record");
		btnNewEntry.setToolTipText("Create New Customer Record.");
		JButton btnRemoveCustomer = new JButton("Delete Record");
		btnRemoveCustomer.setToolTipText("Delete Selected Customer Record.");
		btnRemoveCustomer.addActionListener(deleteRecord);
		JButton btnEditForm = new JButton("Edit Record");
		btnEditForm.setToolTipText("Edit Selected Customer Record.");
		btnEditForm.addActionListener(editRecord);

		// ==================== CREATE DETAILS PANEL ====================
		detailsPanel = new JPanel();

		// ==================== SETUP PANEL NEW DATA (Patient Entry Form) ====================
		panelNewData = new JPanel();
		panelNewData.setBounds(10, 106, 781, 596);
		panelNewData.setLayout(null);

		// Add Labels to Panel New Data
		lblUsername.setBounds(11, 50, 46, 14);
		panelNewData.add(lblUsername);
		
		lblAge.setBounds(11, 170, 46, 23);
		panelNewData.add(lblAge);
		
		lblContact.setBounds(11, 109, 97, 23);
		panelNewData.add(lblContact);
		
		lblPrice1.setBounds(276, 404, 80, 22);
		panelNewData.add(lblPrice1);
		
		lblPrice6.setBounds(709, 407, 70, 20);
		panelNewData.add(lblPrice6);
		
		lblTotal.setBounds(11, 232, 65, 21);
		panelNewData.add(lblTotal);
		
		lblTotalValue.setBounds(151, 230, 108, 23);
		panelNewData.add(lblTotalValue);

		// Add Text Fields to Panel New Data
		textUsername.setColumns(10);
		textUsername.setBounds(10, 74, 249, 25);
		panelNewData.add(textUsername);
		spinAge.setBounds(11, 197, 97, 25);
		panelNewData.add(spinAge);
		
		textContact.setColumns(10);
		textContact.setBounds(11, 135, 248, 25);
		panelNewData.add(textContact);

		// Add JCheckboxes to Panel New Data
		chckbxOption1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		chckbxOption1.setBounds(0, 404, 271, 23);
		panelNewData.add(chckbxOption1);
		serviceBoxes[0] = chckbxOption1;
		
		chckbxOption2.setBounds(61, 441, 216, 23);
		panelNewData.add(chckbxOption2);
		serviceBoxes[1] = chckbxOption2;
		
		chckbxOption3.setBounds(61, 481, 216, 25);
		panelNewData.add(chckbxOption3);
		serviceBoxes[2] = chckbxOption3;
		
		chckbxOption4.setBounds(60, 517, 216, 23);
		panelNewData.add(chckbxOption4);
		serviceBoxes[3] = chckbxOption4;
		
		chckbxOption5.setBounds(61, 552, 216, 23);
		panelNewData.add(chckbxOption5);
		serviceBoxes[4] = chckbxOption5;
		
		chckbxOption6.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		chckbxOption6.setBounds(348, 406, 361, 23);
		panelNewData.add(chckbxOption6);
		serviceBoxes[5] = chckbxOption6;
		
		chckbxOption7.setBounds(429, 441, 199, 23);
		panelNewData.add(chckbxOption7);
		serviceBoxes[6] = chckbxOption7;
		
		chckbxOption8.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		chckbxOption8.setBounds(350, 482, 353, 23);
		panelNewData.add(chckbxOption8);
		serviceBoxes[7] = chckbxOption8;
		
		chckbxOption9.setBounds(429, 517, 199, 23);
		panelNewData.add(chckbxOption9);
		serviceBoxes[8] = chckbxOption9;
		
		chckbxOption10.setBounds(429, 552, 205, 23);
		panelNewData.add(chckbxOption10);
		serviceBoxes[9] = chckbxOption10;

		// Add Separator to Panel New Data
		separatorDentalService.setBounds(11, 38, 248, 2);
		panelNewData.add(separatorDentalService);

		// Add Scroll Pane to Panel New Data
		scrollNewData.setBounds(269, 11, 502, 322);
		panelNewData.add(scrollNewData);
		tableNewData.setFillsViewportHeight(true);
		scrollNewData.setViewportView(tableNewData);

		// ===== SETUP PANEL SAVED DATA (Transaction Log View) =====
		panelSavedData = new JPanel();
		panelSavedData.setBounds(10, 106, 781, 596);
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
		lblServicesAndPricing.setBounds(406, 0, 251, 56);
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
		textSavedAge.setBounds(10, 233, 90, 30);
		panelSavedData.add(textSavedAge);

		// Separators
		separator.setForeground(new Color(100, 149, 237));
		separator.setBounds(10, 61, 238, 6);
		panelSavedData.add(separator);
		
		separator_1.setForeground(new Color(100, 149, 237));
		separator_1.setBounds(10, 273, 238, 6);
		panelSavedData.add(separator_1);

		// Scroll Panes 
		scrollSavedData.setBounds(271, 61, 500, 408);
		panelSavedData.add(scrollSavedData);
		tableSavedData.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tableSavedData.setFillsViewportHeight(true);
		scrollSavedData.setViewportView(tableSavedData);
		
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

		frame.getContentPane().add(panelSavedData);
		frame.getContentPane().add(panelNewData);
		
		viewRecords();
		

		// ==================== TABLE MODEL SETUP ====================
		dataInputModel.setColumnIdentifiers(new String[] { "Service", "Price" });

		// ==================== BUTTONS SECTION (All buttons at the bottom) ====================
		
		btnCalculateBill.addActionListener(calculate);
		btnCalculateBill.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnCalculateBill.setBounds(11, 263, 248, 30);
		panelNewData.add(btnCalculateBill);
		
		btnClear.addActionListener(e -> clearInput());
		btnClear.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnClear.setBounds(11, 303, 248, 30);
		panelNewData.add(btnClear);
		
		lblNewForm = new JLabel("Create Form");
		lblNewForm.setForeground(new Color(30, 144, 255));
		lblNewForm.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblNewForm.setBounds(62, 1, 127, 39);
		panelNewData.add(lblNewForm);
		lblDentalService.setForeground(new Color(30, 144, 255));
		lblDentalService.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		lblDentalService.setBounds(279, 343, 199, 47);
		
		panelNewData.add(lblDentalService);
		separatorDentalService_1.setForeground(new Color(30, 144, 255));
		separatorDentalService_1.setBounds(0, 342, 800, 3);
		
		panelNewData.add(separatorDentalService_1);
		
		separatorDentalService_2 = new JSeparator();
		separatorDentalService_2.setForeground(new Color(30, 144, 255));
		separatorDentalService_2.setBounds(0, 388, 797, 2);
		panelNewData.add(separatorDentalService_2);
		
		lblPrice1_1 = new JLabel("₱2000");
		lblPrice1_1.setForeground(new Color(34, 139, 34));
		lblPrice1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblPrice1_1.setBounds(276, 442, 80, 22);
		panelNewData.add(lblPrice1_1);
		
		lblPrice1_2 = new JLabel("₱3000");
		lblPrice1_2.setForeground(new Color(34, 139, 34));
		lblPrice1_2.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblPrice1_2.setBounds(275, 480, 80, 22);
		panelNewData.add(lblPrice1_2);
		
		lblPrice1_3 = new JLabel("₱4000");
		lblPrice1_3.setForeground(new Color(34, 139, 34));
		lblPrice1_3.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblPrice1_3.setBounds(276, 516, 80, 22);
		panelNewData.add(lblPrice1_3);
		
		lblPrice1_4 = new JLabel("₱5000");
		lblPrice1_4.setForeground(new Color(34, 139, 34));
		lblPrice1_4.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblPrice1_4.setBounds(276, 553, 80, 22);
		panelNewData.add(lblPrice1_4);
		
		lblPrice6_1 = new JLabel("₱7000");
		lblPrice6_1.setForeground(new Color(34, 139, 34));
		lblPrice6_1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblPrice6_1.setBounds(709, 444, 70, 20);
		panelNewData.add(lblPrice6_1);
		
		lblPrice6_2 = new JLabel("₱8000");
		lblPrice6_2.setForeground(new Color(34, 139, 34));
		lblPrice6_2.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblPrice6_2.setBounds(709, 482, 70, 20);
		panelNewData.add(lblPrice6_2);
		
		lblPrice6_3 = new JLabel("₱9000");
		lblPrice6_3.setForeground(new Color(34, 139, 34));
		lblPrice6_3.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblPrice6_3.setBounds(709, 521, 70, 20);
		panelNewData.add(lblPrice6_3);
		
		lblPrice6_4 = new JLabel("₱10000");
		lblPrice6_4.setForeground(new Color(34, 139, 34));
		lblPrice6_4.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		lblPrice6_4.setBounds(698, 554, 81, 20);
		panelNewData.add(lblPrice6_4);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(new Color(30, 144, 255));
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(11, 433, 20, 131);
		panelNewData.add(separator_4);
		
		separator_5 = new JSeparator();
		separator_5.setForeground(new Color(30, 144, 255));
		separator_5.setBounds(11, 452, 46, 20);
		panelNewData.add(separator_5);
		
		separator_6 = new JSeparator();
		separator_6.setForeground(new Color(30, 144, 255));
		separator_6.setBounds(13, 491, 46, 20);
		panelNewData.add(separator_6);
		
		separator_7 = new JSeparator();
		separator_7.setForeground(new Color(30, 144, 255));
		separator_7.setBounds(13, 528, 46, 20);
		panelNewData.add(separator_7);
		
		separator_8 = new JSeparator();
		separator_8.setForeground(new Color(30, 144, 255));
		separator_8.setBounds(13, 562, 46, 20);
		panelNewData.add(separator_8);
		
		separator_9 = new JSeparator();
		separator_9.setOrientation(SwingConstants.VERTICAL);
		separator_9.setForeground(new Color(30, 144, 255));
		separator_9.setBounds(362, 432, 20, 22);
		panelNewData.add(separator_9);
		
		separator_10 = new JSeparator();
		separator_10.setForeground(new Color(30, 144, 255));
		separator_10.setBounds(362, 454, 58, 20);
		panelNewData.add(separator_10);
		
		separator_11 = new JSeparator();
		separator_11.setOrientation(SwingConstants.VERTICAL);
		separator_11.setForeground(new Color(30, 144, 255));
		separator_11.setBounds(364, 506, 20, 53);
		panelNewData.add(separator_11);
		
		separator_12 = new JSeparator();
		separator_12.setForeground(new Color(30, 144, 255));
		separator_12.setBounds(364, 528, 58, 20);
		panelNewData.add(separator_12);
		
		separator_13 = new JSeparator();
		separator_13.setForeground(new Color(30, 144, 255));
		separator_13.setBounds(364, 560, 58, 20);
		panelNewData.add(separator_13);

		btnNewEntry.setForeground(new Color(255, 255, 255));
		btnNewEntry.setBackground(new Color(107, 142, 35));
		btnNewEntry.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		btnNewEntry.addActionListener(e -> newForm(true));
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
		spinAge.setValue(0);
		textContact.setText("");
		deselectBoxes();
		dataInputModel.setRowCount(0);
		lblTotalValue.setText("0");
		editIndex = -1;
		listDisplayTables.setSelectedIndex(-1);
	}

	void deselectBoxes() {
		for (JCheckBox cb : serviceBoxes) {
			if (cb != null) {
				cb.setSelected(false);
			}
		}
	}
	
	void newForm(Boolean clear) {
		
		if(clear)clearInput();
		//cardlay.next(null);
		panelSavedData.setVisible(false);
		panelNewData.setVisible(true);
		mItemEdit.setEnabled(false);
		mItemRemove.setEnabled(false);
		
	}
	
	void viewRecords() {
		
		clearInput();
		clearOutput();
		//cardlay.next(null)
		mItemEdit.setEnabled(true);
		mItemRemove.setEnabled(true);
		panelSavedData.setVisible(true);
		panelNewData.setVisible(false);
		
	}
	
	void clearOutput() {
		textSavedName.setText("");
		textSavedContact.setText("");
		textSavedAge.setText("");
		lblSavedTotalVal.setText("0");
		listDisplayTables.clearSelection();
		DefaultTableModel model = (DefaultTableModel) tableSavedData.getModel();
		model.setColumnIdentifiers(new String[] {"Service", "Price"});
		tableSavedData.setModel(model);
	}
	
	void verifyCapacity() {
		
		if(usedTableSlots >= savedTables.length) {
			btnNewEntry.setEnabled(false);
			btnNewEntry.setToolTipText("Cannot create new Entry, Database is full.");
		} else {
			btnNewEntry.setEnabled(true);
			btnNewEntry.setToolTipText("Create New Customer Record.");
		}
	}
	
	private String validateInputs(String username, String age, String contactNo) {

	    if (username.trim().isEmpty()) {
	        return "Customer name cannot be empty.";
	    }
	    if (age.trim().isEmpty()) {
	        return "Age cannot be empty.";
	    }
	    if (contactNo.trim().isEmpty()) {
	        return "Contact number cannot be empty.";
	    }

	    if (!username.trim().matches("[a-zA-Z\\s]+")) {
	        return "Name must contain letters only.";
	    }

	    int parsedAge;
	    try {
	        parsedAge = Integer.parseInt(age.trim());
	    } catch (NumberFormatException ex) {
	        return "Age must be a whole number (e.g. 25).";
	    }
	    if (parsedAge < 1 || parsedAge > 120) {
	        return "Age must be between 1 and 120.";
	    }

	    if (!contactNo.trim().matches("\\d{7,15}")) {
	        return "Contact number must contain 7 to 15 digits only (no spaces or dashes).";
	    }

	    if (dataInputModel.getRowCount() == 0) {
	        return "Please select at least one dental service.";
	    }

	    if (usedTableSlots >= savedTables.length) {
	        return "Maximum number of records (30) has been reached.";
	    }

	    return null;
	}


	MouseAdapter selectView = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int target = listDisplayTables.getSelectedIndex();
			System.out.print("list index: " + target + "\n");
			if (target == -1)
				return;
			tableSavedData.setModel(savedTables[target]);
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
	        String age = String.valueOf(spinAge.getValue());
	        String contactNo = textContact.getText();
	        
	        String validate = validateInputs(username, age, contactNo);
	        if(validate != null) {
	        	JOptionPane.showMessageDialog(null, validate, "Missing Customer Details", 0);
	        	return;
	        }

	        String totalBill = lblTotalValue.getText();

	        JOptionPane.showMessageDialog(null, "Total Bill: ₱" + totalBill);
	        
	        int targetIndex;
	        
	        if (editIndex != -1) {
	        	targetIndex = editIndex;
	        	savedTableDisplay.set(targetIndex, username);
	        } else {
	        	targetIndex = usedTableSlots;
	        	savedTableDisplay.addElement(username);
	        	usedTableSlots++;
	        	lblTotalCustomers.setText(String.valueOf(usedTableSlots));
	        }

	        savedCustomerDetails[targetIndex][0] = username;
	        savedCustomerDetails[targetIndex][1] = age;
	        savedCustomerDetails[targetIndex][2] = contactNo;
	        savedCustomerDetails[targetIndex][3] = totalBill;
	        
	        savedTables[targetIndex] = new DefaultTableModel(0, 2);
	        savedTables[targetIndex].setColumnIdentifiers(new String[] {"Service", "Price"} );
	        for(int row = 0; row < dataInputModel.getRowCount(); row++) {
	            String service = dataInputModel.getValueAt(row, 0).toString();
	            String price = dataInputModel.getValueAt(row, 1).toString();
	            
	            savedTables[targetIndex].addRow(new String[] {service, price});
	        }
	        editIndex = -1;
	        clearOutput();
            viewRecords();
            verifyCapacity();
	    }
	};
	
	ActionListener deleteRecord = new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        
	    	int query = listDisplayTables.getSelectedIndex();
	    	
	    	if(query == -1) {
	    		
	    		JOptionPane.showMessageDialog(panelSavedData, "No entry selected.", "No Selection", JOptionPane.WARNING_MESSAGE);
	    		return;
	    	}
	    	
	    	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this entry?");
	    	if(!(confirm == JOptionPane.YES_OPTION)) return;
	    	
	    	savedTableDisplay.remove(query);
	    	
	    	savedTables[query].setRowCount(0);
	    	for(int i = query; i < usedTableSlots; i++) {
	    		if(!(i == usedTableSlots)) {
	    			int next = i + 1;
	    		savedTables[i] = savedTables[next];
	    		savedCustomerDetails[i][0] = savedCustomerDetails[next][0];
		        savedCustomerDetails[i][1] = savedCustomerDetails[next][1];
		        savedCustomerDetails[i][2] = savedCustomerDetails[next][2];
		        savedCustomerDetails[i][3] = savedCustomerDetails[next][3];
	    		} else {
	    			savedTables[i] = null;
		    		savedCustomerDetails[i][0] = null;
			        savedCustomerDetails[i][1] = null;
			        savedCustomerDetails[i][2] = null;
			        savedCustomerDetails[i][3] = null;
	    		}
	    		
	    		usedTableSlots--;
	    		lblTotalCustomers.setText(String.valueOf(usedTableSlots));
	    		clearOutput();
	    	}
	    	
	    	verifyCapacity();
	    	
	    }
	};
	
	ActionListener editRecord = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedIndex = listDisplayTables.getSelectedIndex();
			
			if (selectedIndex == -1) {
				JOptionPane.showMessageDialog(panelSavedData, "No entry selected.", "No Selection", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			clearInput();
			
			editIndex = selectedIndex;
			
			textUsername.setText(savedCustomerDetails[selectedIndex][0]);
			spinAge.setValue(Integer.parseInt(savedCustomerDetails[selectedIndex][1]));
			textContact.setText(savedCustomerDetails[selectedIndex][2]);
			
			DefaultTableModel savModel = savedTables[selectedIndex];
			for (int row = 0; row < savModel.getRowCount(); row++) {
				String savedService = savModel.getValueAt(row, 0).toString();
				
				for (JCheckBox cb : serviceBoxes) {
					if (cb != null && cb.getText().equals(savedService)) {
						cb.setSelected(true);
						break;
					}
				}
			}
			
			newForm(false);
		}};
	
	KeyAdapter ignoreLetters = new KeyAdapter() {
		@Override
		public void keyTyped(KeyEvent e) {
			if(!Character.isDigit(e.getKeyChar())) e.consume();
		}
	};
	
	
	private JLabel lblNewForm;
	private final JLabel lblDentalService = new JLabel("Dental Services");
	private final JSeparator separatorDentalService_1 = new JSeparator();
	private JSeparator separatorDentalService_2;
	private JLabel lblPrice1_1;
	private JLabel lblPrice1_2;
	private JLabel lblPrice1_3;
	private JLabel lblPrice1_4;
	private JLabel lblPrice6_1;
	private JLabel lblPrice6_2;
	private JLabel lblPrice6_3;
	private JLabel lblPrice6_4;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JSeparator separator_8;
	private JSeparator separator_9;
	private JSeparator separator_10;
	private JSeparator separator_11;
	private JSeparator separator_12;
	private JSeparator separator_13;
}