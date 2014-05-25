import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View{

	public JFrame frame;
	public JList<String> listOfGroups, listOfStudentsInGroup;
	public JButton addGroup, addRestrictedGroup, addStudentToGroup, addCatToGroup,addEmployeeToGroup, addHumanToGroup, deleteGroup, deleteStudentFromGroup, saveToFile, readFromFile;
	public JTextField groupName, studentName;
	private JLabel groupsLabel, studentsLabel, studentValueLabel, studentValue;
    private JLabel[] infoLabels;
	public JFileChooser save, read;
	
	public View()
	{
		frame = new JFrame("MVC");
		frame.getContentPane().setLayout(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        frame.setSize(1250,620);        
        frame.setVisible(true);
        frame.setLocation(50, 50);
        infoLabels = new JLabel[4];

        listOfGroups = new JList<String>();
        listOfStudentsInGroup = new JList<String>();
        addGroup = new JButton("Dodaj grupę");
        addRestrictedGroup = new JButton("Dodaj specgrupę");
        addStudentToGroup = new JButton("Dodaj ucznia");
        addCatToGroup = new JButton("Dodaj kota");
        addEmployeeToGroup = new JButton("Dodaj pracownika");
        addHumanToGroup = new JButton("Dodaj osobę");
        deleteGroup = new JButton("Usuń grupę");
        deleteStudentFromGroup = new JButton("Usuń osobę");
        groupName = new JTextField();
        studentName = new JTextField();
        groupsLabel = new JLabel("Lista grup:");
        studentsLabel = new JLabel("Lista osób:");
        studentValueLabel = new JLabel("Wartość osoby:");
        studentValue = new JLabel("0");
        readFromFile = new JButton("Odczytaj z pliku");
        saveToFile = new JButton("Zapisz do pliku");
        save = new JFileChooser();
        read = new JFileChooser();
        infoLabels[0] = new JLabel("class Human");
        infoLabels[1] = new JLabel("class Employee extends Human");
        infoLabels[2] = new JLabel("class Student extends Human");
        infoLabels[3] = new JLabel("class Cat extends Student");

        listOfGroups.setBorder(BorderFactory.createLineBorder(Color.black));
        listOfStudentsInGroup.setBorder(BorderFactory.createLineBorder(Color.black));

        studentValueLabel.setBounds(870, 50, 150, 50);
        studentValue.setBounds(1020, 50, 150, 50);
        groupsLabel.setBounds(40, 10, 150, 30);
        studentsLabel.setBounds(450, 10, 150, 30);
        listOfGroups.setBounds(40, 40, 400, 400);
        listOfStudentsInGroup.setBounds(450, 40, 400, 400);
        addGroup.setBounds(40, 450, 200, 30);
        addRestrictedGroup.setBounds(40, 500, 200, 30);
        addStudentToGroup.setBounds(450, 450, 200, 30);
        addCatToGroup.setBounds(450, 485, 200, 30);
        addEmployeeToGroup.setBounds(450, 520, 200, 30);
        addHumanToGroup.setBounds(450, 555, 200, 30);
        deleteGroup.setBounds(40, 550, 200, 30);
        deleteStudentFromGroup.setBounds(670, 500, 180, 30);
        groupName.setBounds(260, 450, 180, 30);
        studentName.setBounds(670, 450, 180, 30);
        readFromFile.setBounds(950, 450, 180, 50);
        saveToFile.setBounds(950, 510, 180, 50);

        for(int i = 0; i < infoLabels.length; i++)
        {
            infoLabels[i].setBounds(870, 100 + 25*i, 300, 30);
            frame.getContentPane().add(infoLabels[i]);
        }

        frame.getContentPane().add(studentValueLabel);
        frame.getContentPane().add(studentValue);
        frame.getContentPane().add(groupsLabel);
        frame.getContentPane().add(studentsLabel);
        frame.getContentPane().add(listOfGroups);
        frame.getContentPane().add(listOfStudentsInGroup);
        frame.getContentPane().add(addGroup);
        frame.getContentPane().add(addRestrictedGroup);
        frame.getContentPane().add(addStudentToGroup);
        frame.getContentPane().add(addCatToGroup);
        frame.getContentPane().add(addEmployeeToGroup);
        frame.getContentPane().add(addHumanToGroup);
        frame.getContentPane().add(deleteGroup);
        frame.getContentPane().add(deleteStudentFromGroup);
        frame.getContentPane().add(groupName);
        frame.getContentPane().add(studentName);
        frame.getContentPane().add(readFromFile);
        frame.getContentPane().add(saveToFile);
	}
	
	public void setGroupList(String[] listOfGroups)
	{
		this.listOfGroups.setListData(listOfGroups);
	}
	
	public void setStudentsList(String[] listOfStudents)
	{
		this.listOfStudentsInGroup.setListData(listOfStudents);
	}

    public void setStudentData(Number value)
    {
        this.studentValue.setText(Double.toString(value.doubleValue()) + "<" + value.getClass().getSimpleName() + ">");
    }
}
