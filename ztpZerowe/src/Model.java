import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Model implements Serializable {

    private static final long serialVersionUID = -2969746444310079878L;
    
    private ArrayList<ArrayList<String>> listOfGroupsAndStudents;

    public Model() {
        listOfGroupsAndStudents = new ArrayList<ArrayList<String>>();
    }

    public String[] getGroups() {
        String[] listOfGroups = new String[listOfGroupsAndStudents.size()];

        for (int i = 0; i < listOfGroupsAndStudents.size(); i++) {
            listOfGroups[i] = listOfGroupsAndStudents.get(i).get(0);
        }

        return listOfGroups;
    }

    public String[] getStudentsFromGroup(int id) {
        ArrayList<String> tempListOfStudents = listOfGroupsAndStudents.get(id);
        String[] listOfStudents = new String[tempListOfStudents.size() - 1];

        for (int i = 0; i < listOfStudents.length; i++) {
            listOfStudents[i] = tempListOfStudents.get(i + 1);
        }

        return listOfStudents;
    }

    public void addGroup(String name) {
        if (listOfGroupsAndStudents.size() <= 15) {
            ArrayList<String> group = new ArrayList<String>();
            group.add(0, name);
            listOfGroupsAndStudents.add(group);
        }
    }

    public void addStudentToGroup(int id, String student) {
        if (listOfGroupsAndStudents.get(id).size() <= 15) {
            listOfGroupsAndStudents.get(id).add(student);
        }
    }

    public void deleteGroup(int id) {
        listOfGroupsAndStudents.remove(id);
    }

    public void deleteStudent(int groupId, int studentId) {
        listOfGroupsAndStudents.get(groupId).remove(studentId);
    }

    public void saveDataToFile(String path) {
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(listOfGroupsAndStudents);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDataFromFile(String path) {
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            listOfGroupsAndStudents = (ArrayList<ArrayList<String>>) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
