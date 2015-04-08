import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.SetChangeListener;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import weka.associations.Apriori;
import weka.associations.AssociationRule;
import weka.core.*;
import weka.filters.Filter;
import weka.filters.supervised.attribute.Discretize;
import weka.gui.CheckBoxList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class Main implements ActionListener {

	private JFrame frame;
	private JMenuItem mOpenFile;
	File mLoadedFile;
	Instances readedInstances;
	private JLabel mlabel;
	private CheckBoxList mlist;
	private JTextArea mtextArea;
	private JTextField mtfMinMetric;
	private JTextField mtfNumRules;
	private JTextField mtfDelta;
	private JTextField mtfMinLowSupp;
	private JTextField mtfMinUpSupp;
	JButton btnStart;
	JCheckBox cbCar;
	private JPanel mpanel;
	JButton btnBestRules;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	
	public void loadWekaFile() {
		
		try{
		JFileChooser fc = new JFileChooser();
		if(fc.showOpenDialog(null)== JFileChooser.APPROVE_OPTION){
			mLoadedFile = fc.getSelectedFile();
			
			BufferedReader bfReader = new BufferedReader(new FileReader(mLoadedFile.getPath()));
			
			readedInstances = new Instances(bfReader);
			readedInstances.setClassIndex(readedInstances.numAttributes() -1);
			bfReader.close();
			mlabel.setText("Wczytany zestaw danych: "+mLoadedFile.getName());
			String[] checkBoxList = new String[readedInstances.numAttributes()];
			
			for(int i = 0; i< checkBoxList.length ; i++){
				checkBoxList[i] = readedInstances.attribute(i).name();
			}
			mlist.setListData(checkBoxList);
			for(int i = 0; i< readedInstances.numAttributes() ; i++){
				mlist.setChecked(i, true);
			}
		}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu menuPlik = new JMenu("Plik");
		menuBar.add(menuPlik);
		mOpenFile = new JMenuItem("Otwórz",'O');
		menuPlik.add(mOpenFile);
		frame.getContentPane().setLayout(null);
		
		mlist = new CheckBoxList();
		mlist.setToolTipText("Atrybuty");
		mlist.setLocation(10, 36);
		mlist.setForeground(Color.BLACK);
		mlist.setBackground(Color.WHITE);
		mlist.setSize(246, 248);
		frame.getContentPane().add(mlist);
		
		mlabel = new JLabel("Wczytaj plik");
		mlabel.setBounds(47, 11, 414, 14);
		mlabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(mlabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(266, 36, 258, 248);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Algorytm Apriori");
		
		 cbCar = new JCheckBox("CAR");
		 cbCar.setEnabled(false);
		 cbCar.setToolTipText("Tylko regu\u0142y z kt\u00F3rych wynikaj\u0105 klasy");
		
		JPanel panel_1 = new JPanel();
		
		mpanel = new JPanel();
		mpanel.setLayout(null);
		
		JLabel lblMinmetric = new JLabel("minMetric");
		lblMinmetric.setBounds(9, 11, 111, 14);
		mpanel.add(lblMinmetric);
		lblMinmetric.setToolTipText("Minimalna warto\u015B\u0107 pewno\u015Bci");
		
		JLabel lblNumrules = new JLabel("numRules");
		lblNumrules.setBounds(9, 47, 111, 14);
		mpanel.add(lblNumrules);
		lblNumrules.setToolTipText("Liczba poszukiwanych regu\u0142");
		
		JLabel lblDelta = new JLabel("delta");
		lblDelta.setBounds(9, 72, 111, 14);
		mpanel.add(lblDelta);
		lblDelta.setToolTipText("Zmniejszanie wsparcia do osi\u0105gniecia minSupport lub ilo\u015Bci regu\u0142");
		
		JLabel lblLowerboundminsupport = new JLabel("lowerBoundMinSupport");
		lblLowerboundminsupport.setBounds(10, 108, 120, 14);
		mpanel.add(lblLowerboundminsupport);
		lblLowerboundminsupport.setToolTipText("Dolna granica wsparcia");
		
		JLabel lblUpperboundminsupport = new JLabel("upperBoundMinSupport");
		lblUpperboundminsupport.setBounds(10, 136, 120, 14);
		mpanel.add(lblUpperboundminsupport);
		lblUpperboundminsupport.setToolTipText("G\u00F3rna granica wsparcia");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(cbCar)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(mpanel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(39))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(22, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cbCar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(mpanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
					.addGap(14))
		);
		panel_1.setLayout(null);
		
		mtfMinMetric = new JTextField();
		mtfMinMetric.setBounds(10, 11, 62, 20);
		panel_1.add(mtfMinMetric);
		mtfMinMetric.setText("0.9");
		mtfMinMetric.setColumns(10);
		
		mtfNumRules = new JTextField();
		mtfNumRules.setBounds(10, 42, 62, 20);
		panel_1.add(mtfNumRules);
		mtfNumRules.setText("10");
		mtfNumRules.setColumns(10);
		
		mtfDelta = new JTextField();
		mtfDelta.setBounds(10, 73, 62, 20);
		panel_1.add(mtfDelta);
		mtfDelta.setText("0.05");
		mtfDelta.setColumns(10);
		
		mtfMinLowSupp = new JTextField();
		mtfMinLowSupp.setBounds(10, 104, 62, 20);
		panel_1.add(mtfMinLowSupp);
		mtfMinLowSupp.setText("0.1");
		mtfMinLowSupp.setColumns(10);
		
		mtfMinUpSupp = new JTextField();
		mtfMinUpSupp.setBounds(10, 135, 62, 20);
		panel_1.add(mtfMinUpSupp);
		mtfMinUpSupp.setText("1.0");
		mtfMinUpSupp.setColumns(10);
		panel.setLayout(gl_panel);
		
		 btnStart = new JButton("Wyznacz regu\u0142y ");
		btnStart.addActionListener(this);
		btnStart.setBounds(97, 295, 159, 23);
		frame.getContentPane().add(btnStart);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 329, 514, 150);
		frame.getContentPane().add(scrollPane);
		
		mtextArea = new JTextArea();
		mtextArea.setBackground(Color.BLACK);
		mtextArea.setForeground(Color.BLACK);
		mtextArea.setWrapStyleWord(true);
		scrollPane.setViewportView(mtextArea);
		mtextArea.setEnabled(false);
		mtextArea.setEditable(false);
		
		 btnBestRules = new JButton("Wyznacz najlepsze regu\u0142y");
		btnBestRules.addActionListener(this);
		btnBestRules.setBounds(266, 295, 169, 23);
		frame.getContentPane().add(btnBestRules);
		mOpenFile.addActionListener(this);
	}
	
	public void getRulesFromApriori(){
		Discretize disc = new Discretize();
		String[] discOptions = new String[2];
		
		discOptions[0] = "-R";
		discOptions[1] = "first-last";
		Instances tempInstance = null;
		try {
			disc.setOptions(discOptions);
			disc.setInputFormat(readedInstances);
			tempInstance = Filter.useFilter(readedInstances, disc);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Instances currentInstances = new Instances(tempInstance);
		int a = 0;
		for (int i = 0; i < tempInstance.numAttributes(); i++) {
			if (!((Boolean) mlist.getChecked(i))) {
				currentInstances.deleteAttributeAt(i - a);
				a++;
			}
		}
		
		Apriori associator = new Apriori();
		associator.setCar(cbCar.isSelected());
		associator.setDelta(Double.parseDouble(mtfDelta.getText()));
		associator.setLowerBoundMinSupport(Double.parseDouble(mtfMinLowSupp.getText()));
		associator.setUpperBoundMinSupport(Double.parseDouble(mtfMinUpSupp.getText()));
		associator.setNumRules(Integer.parseInt(mtfNumRules.getText()));
		associator.setMinMetric(Double.parseDouble(mtfMinMetric.getText()));
		try {
			
			associator.buildAssociations(currentInstances);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mtextArea.setText(e.getMessage());
		e.printStackTrace();
		}
		mtextArea.setText("");
	//	System.out.println(associator);
	
		for( AssociationRule rule : associator.getAssociationRules().getRules()){
		//	mtextArea.append(rule.toString());
		
			mtextArea.append(rule.getPremise().toString() + " => " +	rule.getConsequence().toString()+"\n");
		}
	
		
		
	}
	
	public void getBestRules(){
		Apriori associator = new Apriori();
		associator.setCar(true);
		associator.setDelta(Double.parseDouble(mtfDelta.getText()));
		associator.setLowerBoundMinSupport(0.15);
		associator.setUpperBoundMinSupport(1.0);
		associator.setNumRules(50);
		associator.setMinMetric(1.0);
		
		try {
			associator.buildAssociations(readedInstances);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mtextArea.setText(e.getMessage());
		}
		
		mtextArea.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object comingFrom = e.getSource();
		
		if(comingFrom == mOpenFile){
			loadWekaFile();
		}else if(comingFrom == btnStart){
			if(readedInstances != null)
				getRulesFromApriori();
		}else if(comingFrom == btnBestRules){
			
		}
		
	}
}
