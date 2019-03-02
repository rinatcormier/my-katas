package my.rinat.kata.collections.donut.donutkata10;

import org.eclipse.collections.impl.utility.ArrayIterate;

public enum DonutType {
    BOSTON_CREAM("BC"),
    GLAZED("G"),
    OLD_FASHIONED("OF"),
    CHOCOLATE_GLAZED("CG"),
    VANILLA_FROSTED("VF"),
    PUMPKIN("P"),
    BLUEBERRY("B"),
    JELLY("J"),
    BAVARIAN_CREAM("BA");

    private String abbreviation;

    DonutType(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    private boolean abbreviationEquals(String abbreviation) {
        return abbreviation.equals(this.abbreviation);
    }

    public static DonutType forAbbreviation(String abbreviation) {
        return ArrayIterate.detectWith(DonutType.values(), DonutType::abbreviationEquals, abbreviation);
    }
}
