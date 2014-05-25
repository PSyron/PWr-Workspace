import java.io.Serializable;

public class Cat extends Student implements Serializable {

    private static final long serialVersionUID = -859770006610924663L;

    public Cat(String name, double value) {
        super(name, value);
    }
}
