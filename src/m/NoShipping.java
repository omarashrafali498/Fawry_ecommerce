package m;

public class NoShipping implements Shippable {
    @Override
    public boolean isShippable() {
        return false;
    }

    @Override
    public double getWeight() {
        return 0;
    }
}