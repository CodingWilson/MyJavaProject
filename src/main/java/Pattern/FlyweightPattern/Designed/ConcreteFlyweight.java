package Pattern.FlyweightPattern.Designed;

public class ConcreteFlyweight implements Flyweight {
    private String intrinsicState;

    @Override
    public void operation(String extrinsicState) {
    }

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }
}
