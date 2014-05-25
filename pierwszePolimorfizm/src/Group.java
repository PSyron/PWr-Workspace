import java.io.Serializable;
import java.util.ArrayList;

public class Group<T> implements Serializable {

    private static final long serialVersionUID = 6678900281676242256L;
    protected String name;
    private ArrayList<T> group;

    public Group(String name) {
        this.name = name;
        group = new ArrayList<T>();
    }

    public String getName() {
        return this.name + " <" + this.getClass().getSimpleName() + ">";
    }

    public ArrayList<T> getGroup() {
        return this.group;
    }

    public void addToGroup(T person) {
        this.group.add(person);
    }

    public void removeFormGroup(int id) {
        this.group.remove(id);
    }

    public T getPerson(int personId) {
        return this.group.get(personId);
    }
}
