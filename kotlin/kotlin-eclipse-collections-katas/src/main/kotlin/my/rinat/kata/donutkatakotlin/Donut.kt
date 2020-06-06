package my.rinat.kata.donutkatakotlin

class Donut(val type: DonutType, val price: Double) {
    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val donut = other as Donut?
        return java.lang.Double.compare(donut!!.price, this.price) == 0 && this.type == donut.type
    }

    override fun hashCode(): Int {
        var result: Int = this.type.hashCode()
        val temp: Long = java.lang.Double.doubleToLongBits(this.price)
        result = 31 * result + (temp xor temp.ushr(32)).toInt()
        return result
    }

    override fun toString(): String {
        return "Donut(" +
                "type=" + this.type +
                ", price=" + this.price +
                ')'
    }
}
