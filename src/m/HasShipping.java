package m;

public class HasShipping implements Shippable {
    private double weight;

    public HasShipping(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean isShippable() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}