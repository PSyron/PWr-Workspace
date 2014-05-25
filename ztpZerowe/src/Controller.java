import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Controller{
	
	private View view;
	private Model model;
	private ActionListener 	addGroupListener, addStudentToGroupListener,
							deleteGroupListener, deleteStudentFromGroupListener,
							saveToFileListener, readFromFileListener;
	private ListSelectionListener listOfGroupsListener;
							
	
	public Controller(View view, Model model)
	{
		this.view = view;
		this.model = model;
	}
	
	public void control()
	{
		view.setGroupList(model.getGroups());
		
		initAddGroupListener();
		initAddStudentToGroupListener();
		initDeleteGroupListener();
		initDeleteStudentFromGroupListener();
		initListOfGroupsListener();
		initSaveToFileListener();
		initReadFromFileListener();
	}
	
	private void initAddGroupListener()
	{
		addGroupListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent actionEvent)
			{
				if((view.groupName.getText().trim()).length() > 0)
				{
					model.addGroup(view.groupName.getText().trim());
					view.setGroupList(model.getGroups());
					view.groupName.setText("");
				}
			}
		};
		view.addGroup.addActionListener(addGroupListener);
	}
	
	private void initAddStudentToGroupListener()
	{
		addStudentToGroupListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent actionEvent)
			{
				if(!view.listOfGroups.isSelectionEmpty() && (view.studentName.getText().trim()).length() > 0)
				{
					model.addStudentToGroup(view.listOfGroups.getSelectedIndex(), view.studentName.getText().trim());
					view.setStudentsList(model.getStudentsFromGroup(view.listOfGroups.getSelectedIndex()));
					view.studentName.setText("");
				}
			}
		};
		view.addStudentToGroup.addActionListener(addStudentToGroupListener);
	}
	
	private void initDeleteGroupListener()
	{
		deleteGroupListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent actionEvent)
			{
				if(!view.listOfGroups.isSelectionEmpty())
				{
					model.deleteGroup(view.listOfGroups.getSelectedIndex());
					view.setGroupList(model.getGroups());
					view.setStudentsList(new String[0]);
					view.listOfGroups.clearSelection();
				}
			}
		};
		view.deleteGroup.addActionListener(deleteGroupListener);
	}
	
	private void initDeleteStudentFromGroupListener()
	{
		deleteStudentFromGroupListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent actionEvent)
			{
				if(!view.listOfGroups.isSelectionEmpty() && !view.listOfStudentsInGroup.isSelectionEmpty())
				{
					model.deleteStudent(
							view.listOfGroups.getSelectedIndex(), 
							view.listOfStudentsInGroup.getSelectedIndex()+1
							);
					view.setStudentsList(model.getStudentsFromGroup(view.listOfGroups.getSelectedIndex()));
				}
			}
		};
		view.deleteStudentFromGroup.addActionListener(deleteStudentFromGroupListener);
	}
	
	private void initListOfGroupsListener()
	{
		listOfGroupsListener = new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent listSelectionEvent)
			{
				if(!view.listOfGroups.isSelectionEmpty())
				{
					view.setStudentsList(model.getStudentsFromGroup(view.listOfGroups.getSelectedIndex()));
				}
			}
		};
		view.listOfGroups.addListSelectionListener(listOfGroupsListener);
	}
	
	private void initSaveToFileListener()
	{
		saveToFileListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent actionEvent)
			{
				int returnVal = view.save.showSaveDialog(view.frame);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	model.saveDataToFile(view.save.getSelectedFile().getAbsolutePath());
			    }
			}
		};
		view.saveToFile.addActionListener(saveToFileListener);
	}
	
	private void initReadFromFileListener()
	{
		readFromFileListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent actionEvent)
			{
				int returnVal = view.read.showOpenDialog(view.frame);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	model.loadDataFromFile(view.read.getSelectedFile().getAbsolutePath());
			    }
				view.setGroupList(model.getGroups());
				view.listOfGroups.clearSelection();
			}
		};
		view.readFromFile.addActionListener(readFromFileListener);
	}
}
