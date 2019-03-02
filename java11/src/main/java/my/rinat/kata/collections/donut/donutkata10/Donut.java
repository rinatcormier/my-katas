package my.rinat.kata.collections.donut.donutkata10;

public class Donut {
    private final DonutType type;
    private final double price;

    public Donut(DonutType type, double price) {
        this.type = type;
        this.price = price;
    }

    public DonutType getType() {
        return this.type;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        var donut = (Donut) o;
        return Double.compare(donut.price, this.price) == 0 &&
                this.type == donut.type;
    }

    @Override
    public int hashCode() {
        int result = this.type.hashCode();
        long temp = Double.doubleToLongBits(this.price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Donut(" +
                "type=" + this.type +
                ", price=" + this.price +
                ')';
    }
}
