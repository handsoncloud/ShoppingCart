package com.retail.shopping.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Naresh Podichetty
 *
 */
public class Discount {

    private final String discountType;

    private List<Slab> slabs;

    /**
     *
     * @param rewardType
     */
    public Discount(String discountType) {
        this.discountType = discountType;
        this.slabs = new ArrayList<>();
    }

    public void addSlab(Slab slab) {
        this.slabs.add(slab);
    }

    public boolean isDiscountApplied(String type) {
        return discountType.equalsIgnoreCase(type);
    }

    /**
     *
     * @param amount
     * @return
     */
    public float calculateDiscount(float amount) {
        float discount = 0f;

        for (Slab slab : slabs) {
            if (slab.isDiscountApplied(amount)) {
                discount += slab.calculateDiscount(amount);
            }
        }
        return discount;
    }
}
