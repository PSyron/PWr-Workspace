import java.io.Serializable;

public class Student extends Human implements Serializable {

    private static final long serialVersionUID = 5870543504715475514L;
    protected Double value;

    public Student(String name, double value) {
        super(name, (int) value);
        this.value = value;
    }

    public Double getValue() {
        return value + 999;
    }
}
