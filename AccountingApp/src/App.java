
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;


import java.io.File;
 
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class App {
	private final String ID  = "Isacc";
	private final String PW  = "1234";
	private JFrame frame;
	private JTextField idField;
	private JPasswordField passwordField;
	private JPanel panel;
	private JPanel currPanel;
	private JTextField nameInput;
	private JTextField amountInput;
	private JTextField noteInput;
	private JTextField searchInput;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		TableData td = new TableData();
			frame = new JFrame();
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.getContentPane().setLayout(null);
			ImagePanel loginPanel = new ImagePanel(new ImageIcon("./image/loginVer1.png").getImage());
			loginPanel.setBounds(0, 0, loginPanel.getWidth(), loginPanel.getHeight()+50);
			frame.setSize(new Dimension(loginPanel.getWidth(), loginPanel.getHeight()));
			
			ImagePanel sumPanel = new ImagePanel(new ImageIcon("./image/themeMade.png").getImage());
			sumPanel.setBounds(0, 0,loginPanel.getWidth(), loginPanel.getHeight()+50);
			sumPanel.setVisible(false);
			
			ImagePanel tranPanel = new ImagePanel(new ImageIcon("./image/themeMade.png").getImage());
			tranPanel.setBounds(0, 0, loginPanel.getWidth(), loginPanel.getHeight()+50);
			frame.getContentPane().add(tranPanel);
			tranPanel.setVisible(false);
			tranPanel.setLayout(null);
			tranPanel.setBounds(0, 0, loginPanel.getWidth(), loginPanel.getHeight()+50);
			frame.getContentPane().add(tranPanel);
			tranPanel.setVisible(false);
			tranPanel.setLayout(null);
			frame.getContentPane().add(sumPanel);
			sumPanel.setLayout(null);

			currPanel = loginPanel;
			frame.getContentPane().add(loginPanel);
			frame.setPreferredSize(loginPanel.getDim());
			
			// login panel
			
			// 1) login panel_ID
			idField = new JTextField();
			idField.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			idField.setBounds(1139, 400, 317, 45);
			loginPanel.add(idField);	
			idField.setColumns(10);
			idField.setBorder(null);
			
			// 2)login panel_PassWord
			passwordField = new JPasswordField();
			passwordField.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			passwordField.setBounds(1139, 503, 317, 45);
			loginPanel.add(passwordField);
			passwordField.setBorder(null);
			// 3) login panel_Check Box
			JCheckBox reCheckBox = new JCheckBox("");
			reCheckBox.setBounds(1079, 568, 21, 15);
			loginPanel.add(reCheckBox);
			reCheckBox.addActionListener(new ActionListener() {					
				public void actionPerformed(ActionEvent e) {
					idField.setText(ID);
					passwordField.setText(PW);			
					}
			});
			
			// 4) login panel_Submit 
			JButton loginBtn = new JButton("");
			loginBtn.setBorder(null);
			
			loginBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ID.equals(idField.getText()) && PW.equals(PW)) {
						System.out.println("hello "+ID);
						currPanel.setVisible(false);
						sumPanel.setVisible(true);							
						currPanel = sumPanel;
					}
					else {
						JOptionPane.showMessageDialog(null, "Yout Failed to Log in");
					}
				}
			});
			loginBtn.setIcon(new ImageIcon("./image/button.jpeg"));
			loginBtn.setPressedIcon(new ImageIcon("./image/btnClicked.jpg")); //��ư �������� ����ȯ
			loginBtn.setBounds(1148, 628, 257, 45);
			loginPanel.add(loginBtn);

			
			
			
			// sum panel
			// sumPanel_Search
			JLabel searchLabel = new JLabel("Search:");
			searchLabel.setForeground(new Color(255, 255, 255));
			searchLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
			searchLabel.setBounds(519, 83, 94, 42);
			sumPanel.add(searchLabel);
			
			// sumPanel_Tale
			JPanel tp = new JPanel();
			tp.setBounds(337, 140, 1175, 467);
			sumPanel.add(tp);
			tp.setLayout(null);
			
			table = new JTable(td);
			table.setBounds(337, 140, 1151, 447);
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(191, 65, 1034, 475);
			tp.add(scrollPane);
			
			table.setRowHeight(30);
			table.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			table.setPreferredScrollableViewportSize(new Dimension(1155,447));
			tp.setOpaque(false);	 // ������ ������
			
			//// sumPanel_SearchField
			searchInput = new JTextField();
			searchInput.setBounds(619, 74, 893, 57);
			sumPanel.add(searchInput);
			searchInput.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
			searchInput.setColumns(10);
			
			searchInput.addKeyListener(new KeyAdapter(){
				@Override
				public void keyReleased(KeyEvent e){
					String search = searchInput.getText();
					TableRowSorter<AbstractTableModel> trs = new TableRowSorter<>(td);
					table.setRowSorter(trs);
					trs.setRowFilter(RowFilter.regexFilter(search));
				}
			});
			// tran panel 
			// panel change
			JButton sumBtn = new JButton("Summary");
			sumBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currPanel.setVisible(false);
					currPanel = sumPanel;
					currPanel.setVisible(true);
				}
			});
			
			JButton tranBtn = new JButton("Transactions");
			tranBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currPanel.setVisible(false);
					currPanel = tranPanel;
					tranPanel.setVisible(true);
				}
			});
			tranBtn.setForeground(Color.BLACK);
			tranBtn.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 28));
			tranBtn.setBackground(Color.WHITE);
			tranBtn.setBounds(108, 254, 304, 117);
			
			sumPanel.add(tranBtn);
				


			sumBtn.setForeground(Color.BLACK);
			sumBtn.setBackground(new Color(255, 255, 255));
			sumBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
			sumBtn.setBounds(108, 112, 305, 117);
			tranPanel.add(sumBtn);
			
			nameInput = new JTextField();
			nameInput.setBounds(733, 178, 745, 51);
			tranPanel.add(nameInput);
			nameInput.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Name");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
			lblNewLabel.setBounds(574, 173, 128, 51);
			tranPanel.add(lblNewLabel);
			
			JLabel lblType = new JLabel("Type");
			lblType.setForeground(new Color(255, 255, 255));
			lblType.setHorizontalAlignment(SwingConstants.CENTER);
			lblType.setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
			lblType.setBounds(574, 249, 128, 51);
			tranPanel.add(lblType);
			
			JLabel lblAmount = new JLabel("Amount");
			lblAmount.setForeground(new Color(255, 255, 255));
			lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
			lblAmount.setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
			lblAmount.setBounds(574, 324, 128, 51);
			tranPanel.add(lblAmount);
			
			JLabel lblNewLabel_1_1 = new JLabel("Note");
			lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
			lblNewLabel_1_1.setBounds(574, 400, 128, 51);
			tranPanel.add(lblNewLabel_1_1);
			
			amountInput = new JTextField();
			amountInput.setColumns(10);
			amountInput.setBounds(733, 324, 745, 51);
			tranPanel.add(amountInput);
			
			noteInput = new JTextField();
			noteInput.setColumns(10);
			noteInput.setBounds(733, 400, 745, 51);
			tranPanel.add(noteInput);
			
			String[] typeArr = new String [] {"Deposit","Widthdraw"};
			JComboBox typeInput = new JComboBox(typeArr);
			typeInput.setBounds(733, 255, 745, 49);
			tranPanel.add(typeInput);
			typeInput.setBackground(Color.WHITE);
					
			JButton submitBtn = new JButton("Submit");
			submitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						boolean fileExists = new File("./data.csv").exists(); //파일이 존재 할 경우true return
						FileWriter fw = new FileWriter("./data.csv",true); 
						if(!fileExists) {
							fw.append("Name,Type,Amount,Note\n"); // header; 
						}
						String name = nameInput.getText();
						String type = (String)typeInput.getSelectedItem(); //return value  us object tpye so casitng is needed
						String amount = amountInput.getText();
						String note = noteInput.getText();
						fw.append(name+","+type+","+amount+","+note+"\n");
						nameInput.setText("");
						amountInput.setText("");
						typeInput.setSelectedIndex(0);
						noteInput.setText("");  
						JOptionPane.showMessageDialog(null,"Data Saved Successfully");
						fw.close();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "There was an error while writing the data");
							}
						}
					});
									
			submitBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
			submitBtn.setBounds(963, 479, 226, 51);
			tranPanel.add(submitBtn);
			
			JLabel tranLabel = new JLabel("  Transaction  ");
			tranLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			tranLabel.setForeground(Color.WHITE);
			tranLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
			tranLabel.setBounds(25, 173, 265, 51);
			tranPanel.add(tranLabel);
			
			JTableHeader header = table.getTableHeader();

			header.setBackground(new Color(92,179, 255));
			header.setForeground(new Color(255,255,255));
			header.setFont(new Font("Comic Sans MS", Font.BOLD,15));	
			
			frame.setJMenuBar(menuBar());
	}
	
		public JMenuBar menuBar() {
			JMenuBar bar = new JMenuBar();
			JMenu fileMenu = new JMenu("File");
			JMenu aboutMenu = new JMenu("About");
			
			bar.add(fileMenu);
			bar.add(aboutMenu);
			
			JMenuItem openFile = new JMenuItem("About");
			JMenuItem exit = new JMenuItem("Exit");
			fileMenu.add(openFile);
			fileMenu.addSeparator();
			fileMenu.add(exit);
			
			JMenuItem about = new JMenuItem("About");
	
			aboutMenu.add(about);
			exit.addActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
				
			});
			return bar;
		}
	}





