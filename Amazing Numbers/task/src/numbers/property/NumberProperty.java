package numbers.property;

import numbers.BigNumber;

public interface NumberProperty {
    default String name() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    boolean hasProperty(BigNumber number);
}
