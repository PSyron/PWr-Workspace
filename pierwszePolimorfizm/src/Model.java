import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class Model{

	private ArrayList<Group> listOfGroupsAndStudents;
    public static final int TYPE_EMPLOYEE = 0;
    public static final int TYPE_STUDENT = 1;
    public static final int TYPE_CAT = 2;
    public static final int TYPE_HUMAN = 9;

    public Model()
	{
		listOfGroupsAndStudents = new ArrayList<Group>();
    }
	
	public String[] getGroups()
	{
		String[] listOfGroups = new String[listOfGroupsAndStudents.size()];

		for(int i = 0; i < listOfGroupsAndStudents.size(); i++)
		{
			listOfGroups[i] = listOfGroupsAndStudents.get(i).getName();
		}
		
		return listOfGroups;
	}
	
	public String[] getStudentsForGroup(int id)
	{
        ArrayList<Human> tempListOfStudents = listOfGroupsAndStudents.get(id).getGroup();
		String[] listOfStudents = new String[tempListOfStudents.size()];
		
		for(int i = 0; i < listOfStudents.length; i++)
		{
			listOfStudents[i] = tempListOfStudents.get(i).getName();
		}
		
		return listOfStudents;
	}

    public Number getStudentData(int groupId, int studentId)
    {
        if(studentId > this.listOfGroupsAndStudents.get(groupId).getGroup().size()/2)
            return ((Human)this.listOfGroupsAndStudents.get(groupId).getPerson(studentId)).getValue(studentId);
        else
            return ((Human)this.listOfGroupsAndStudents.get(groupId).getPerson(studentId)).getValue();
    }
	
	public void addGroup(String name)
	{
		if(listOfGroupsAndStudents.size() <= 15)
		{
			Group<Human> group = new Group<Human>(name);
			listOfGroupsAndStudents.add(group);
		}
	}

    public void addRestrictedGroup(String name)
    {
        if(listOfGroupsAndStudents.size() <= 15)
        {
            RestrictedGroup group = new RestrictedGroup(name);
            listOfGroupsAndStudents.add(group);
        }
    }
	
	public void addStudentToGroup(int id, String studentName, int type)
	{
		if(listOfGroupsAndStudents.get(id).getGroup().size() <= 15)
		{
            switch(type) {
                case TYPE_EMPLOYEE:
                    Employee employee = new Employee(studentName, 9);
                    listOfGroupsAndStudents.get(id).addToGroup(employee);
                    break;
                case TYPE_STUDENT:
                    Student student = new Student(studentName, 3.0);
                    listOfGroupsAndStudents.get(id).addToGroup(student);
                    break;
                case TYPE_CAT:
                    Cat cat = new Cat(studentName, 7.0);
                    listOfGroupsAndStudents.get(id).addToGroup(cat);
                    break;
                default:
                    Human human = new Human(studentName, 1);
                    listOfGroupsAndStudents.get(id).addToGroup(human);
                    break;
            }
		}
	}
	
	public void deleteGroup(int id)
	{
		listOfGroupsAndStudents.remove(id);
	}
	
	public void deleteStudent(int groupId, int studentId)
	{
		listOfGroupsAndStudents.get(groupId).removeFormGroup(studentId);
	}
	
	public void saveDataToFile(String path)
	{
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
	
	public void loadDataFromFile(String path)
	{
		try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            listOfGroupsAndStudents = (ArrayList<Group>) in.readObject();
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
