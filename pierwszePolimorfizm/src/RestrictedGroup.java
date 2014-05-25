import java.io.Serializable;
import java.util.ArrayList;


public class RestrictedGroup<T extends Student> extends Group implements Serializable{

    private ArrayList<T> group;

	public RestrictedGroup(String name)
	{
		super(name);
        group = new ArrayList<T>();
	}

}
