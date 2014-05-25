import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Controller{
	
	private View view;
	private Model model;
	private ActionListener 	addGroupListener, addRestrictedGroupListener, addStudentToGroupListener, addEmployeeToGroupListener, addHumanToGroupListener,
							deleteGroupListener, deleteStudentFromGroupListener, addCatToGroupListener,
							saveToFileListener, readFromFileListener;
	private ListSelectionListener listOfGroupsListener, listOfStudentsInGroupListener;

	
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
        initListOfStudentsInGroupListener();
        initSaveToFileListener();
		initReadFromFileListener();
        initAddEmployeeToGroupListener();
        initAddHumanToGroupListener();
        initAddRestrictedGroupListener();
        initAddCatToGroupListener();
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

    private void initAddRestrictedGroupListener()
    {
        addRestrictedGroupListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                if((view.groupName.getText().trim()).length() > 0)
                {
                    model.addRestrictedGroup(view.groupName.getText().trim());
                    view.setGroupList(model.getGroups());
                    view.groupName.setText("");
                }
            }
        };
        view.addRestrictedGroup.addActionListener(addRestrictedGroupListener);
    }
	
	private void initAddStudentToGroupListener()
	{
		addStudentToGroupListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent actionEvent)
			{
				if(!view.listOfGroups.isSelectionEmpty() && (view.studentName.getText().trim()).length() > 0)
				{
					model.addStudentToGroup(view.listOfGroups.getSelectedIndex(), view.studentName.getText().trim(), Model.TYPE_STUDENT);
					view.setStudentsList(model.getStudentsForGroup(view.listOfGroups.getSelectedIndex()));
					view.studentName.setText("");
				}
			}
		};
		view.addStudentToGroup.addActionListener(addStudentToGroupListener);
	}

    private void initAddCatToGroupListener()
    {
        addCatToGroupListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                if(!view.listOfGroups.isSelectionEmpty() && (view.studentName.getText().trim()).length() > 0)
                {
                    model.addStudentToGroup(view.listOfGroups.getSelectedIndex(), view.studentName.getText().trim(), Model.TYPE_CAT);
                    view.setStudentsList(model.getStudentsForGroup(view.listOfGroups.getSelectedIndex()));
                    view.studentName.setText("");
                }
            }
        };
        view.addCatToGroup.addActionListener(addCatToGroupListener);
    }

    private void initAddEmployeeToGroupListener()
    {
        addEmployeeToGroupListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                if(!view.listOfGroups.isSelectionEmpty() && (view.studentName.getText().trim()).length() > 0)
                {
                    model.addStudentToGroup(view.listOfGroups.getSelectedIndex(), view.studentName.getText().trim(), Model.TYPE_EMPLOYEE);
                    view.setStudentsList(model.getStudentsForGroup(view.listOfGroups.getSelectedIndex()));
                    view.studentName.setText("");
                }
            }
        };
        view.addEmployeeToGroup.addActionListener(addEmployeeToGroupListener);
    }

    private void initAddHumanToGroupListener()
    {
        addHumanToGroupListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                if(!view.listOfGroups.isSelectionEmpty() && (view.studentName.getText().trim()).length() > 0)
                {
                    model.addStudentToGroup(view.listOfGroups.getSelectedIndex(), view.studentName.getText().trim(), Model.TYPE_HUMAN);
                    view.setStudentsList(model.getStudentsForGroup(view.listOfGroups.getSelectedIndex()));
                    view.studentName.setText("");
                }
            }
        };
        view.addHumanToGroup.addActionListener(addHumanToGroupListener);
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
							view.listOfStudentsInGroup.getSelectedIndex()
							);
					view.setStudentsList(model.getStudentsForGroup(view.listOfGroups.getSelectedIndex()));
				}
			}
		};
		view.deleteStudentFromGroup.addActionListener(deleteStudentFromGroupListener);
	}
	
	private void initListOfStudentsInGroupListener()
	{
		listOfStudentsInGroupListener = new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent listSelectionEvent)
			{
				if(!view.listOfStudentsInGroup.isSelectionEmpty())
				{
					view.setStudentData(model.getStudentData(view.listOfGroups.getSelectedIndex(), view.listOfStudentsInGroup.getSelectedIndex()));
				}
                else
                {
                    view.setStudentData(0);
                }
			}
		};
		view.listOfStudentsInGroup.addListSelectionListener(listOfStudentsInGroupListener);
	}

    private void initListOfGroupsListener()
    {
        listOfGroupsListener = new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent listSelectionEvent)
            {
                if(!view.listOfGroups.isSelectionEmpty())
                {
                    view.setStudentsList(model.getStudentsForGroup(view.listOfGroups.getSelectedIndex()));
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
                view.setStudentsList(model.getStudentsForGroup(view.listOfGroups.getSelectedIndex()));
                view.listOfGroups.clearSelection();
			}
		};
		view.readFromFile.addActionListener(readFromFileListener);
	}
}
