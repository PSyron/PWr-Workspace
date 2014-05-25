import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class View {

    public JFrame frame;
    public JList<String> listOfGroups, listOfStudentsInGroup;
    public JButton addGroup, addStudentToGroup, deleteGroup, deleteStudentFromGroup, saveToFile,
            readFromFile;
    public JTextField groupName, studentName;
    private JLabel groupsLabel, studentsLabel;
    public JFileChooser save, read;

    public View() {
        frame = new JFrame("MVC. Cyroń");
        frame.getContentPane().setLayout(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1250, 620);
        frame.setVisible(true);
        frame.setLocation(50, 50);

        listOfGroups = new JList<String>();
        listOfStudentsInGroup = new JList<String>();
        addGroup = new JButton("Dodaj grupę");
        addStudentToGroup = new JButton("Dodaj ucznia do grupy");
        deleteGroup = new JButton("Usuń grupę");
        deleteStudentFromGroup = new JButton("Usuń ucznia z grupy");
        groupName = new JTextField();
        studentName = new JTextField();
        groupsLabel = new JLabel("Lista grup:");
        studentsLabel = new JLabel("Lista uczniów:");
        readFromFile = new JButton("Odczytaj z pliku");
        saveToFile = new JButton("Zapisz do pliku");
        save = new JFileChooser();
        read = new JFileChooser();

        listOfGroups.setBorder(BorderFactory.createLineBorder(Color.black));
        listOfStudentsInGroup.setBorder(BorderFactory.createLineBorder(Color.black));

        groupsLabel.setBounds(40, 10, 150, 30);
        studentsLabel.setBounds(450, 10, 150, 30);
        listOfGroups.setBounds(40, 40, 400, 400);
        listOfStudentsInGroup.setBounds(450, 40, 400, 400);
        addGroup.setBounds(40, 450, 200, 30);
        addStudentToGroup.setBounds(450, 450, 200, 30);
        deleteGroup.setBounds(40, 510, 200, 30);
        deleteStudentFromGroup.setBounds(450, 510, 200, 30);
        groupName.setBounds(260, 450, 180, 30);
        studentName.setBounds(670, 450, 180, 30);
        readFromFile.setBounds(860, 510, 180, 50);
        saveToFile.setBounds(1050, 510, 180, 50);

        frame.getContentPane().add(groupsLabel);
        frame.getContentPane().add(studentsLabel);
        frame.getContentPane().add(listOfGroups);
        frame.getContentPane().add(listOfStudentsInGroup);
        frame.getContentPane().add(addGroup);
        frame.getContentPane().add(addStudentToGroup);
        frame.getContentPane().add(deleteGroup);
        frame.getContentPane().add(deleteStudentFromGroup);
        frame.getContentPane().add(groupName);
        frame.getContentPane().add(studentName);
        frame.getContentPane().add(readFromFile);
        frame.getContentPane().add(saveToFile);
    }

    public void setGroupList(String[] listOfGroups) {
        this.listOfGroups.setListData(listOfGroups);
    }

    public void setStudentsList(String[] listOfStudents) {
        this.listOfStudentsInGroup.setListData(listOfStudents);
    }
}
