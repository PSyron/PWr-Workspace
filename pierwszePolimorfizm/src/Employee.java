import java.io.Serializable;

public class Employee extends Human implements Serializable {

    private static final long serialVersionUID = -3087078519066952819L;
    public Integer value;

    public Employee(String name, int value) {
        super(name, value);
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
