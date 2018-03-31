package Pattern.FlyweightPattern.Designed;

public class UnshareedConcreteFlyweight implements Flyweight {
    private String allState;

    @Override
    public void operation(String extrinsicState) {

    }

    public UnshareedConcreteFlyweight(String allState) {
        this.allState = allState;
    }
}
