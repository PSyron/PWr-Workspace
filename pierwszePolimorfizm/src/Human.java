import java.io.Serializable;


public class Human implements Serializable{

	protected String name;
    protected Integer value;
	
	public Human(String name, int value)
	{
		this.name = name;
        this.value = value;
	}
	
	public Number getValue()
	{
		return this.value;
	}

    public Number getValue(int multi)
    {
        return this.value*multi;
    }

    public String getName()
    {
        return this.name + " <" + this.getClass().getSimpleName() + ">";
    }
}
