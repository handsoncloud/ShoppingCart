package com.retail.shopping.core;

/**
 * @author Naresh Podichetty
 *
 */
public class Slab {

    private final float lowerAmount;
    private final float upperAmount;
    private final float percentDiscount;

    /**
     *
     * @param lowerAmount
     * @param upperAmount
     * @param percentDiscount
     */
    public Slab(float lowerAmount,
                float upperAmount,
                float percentDiscount) {
        this.lowerAmount = lowerAmount;
        this.upperAmount = upperAmount;
        this.percentDiscount = percentDiscount;
    }

    /**
     * Returns true if the discount is applied
     *
     * @param amount
     * @return
     */
    public boolean isDiscountApplied(float amount) {
        return (lowerAmount < amount);
    }

    /**
     * Calculate the discount based on the purchase amount
     *
     * @param amount
     * @return
     */
    public float calculateDiscount(float amount) {
        if (amount > upperAmount) {
            return (upperAmount - lowerAmount) * percentDiscount;
        } else {
            return (amount - lowerAmount) * percentDiscount;
        }
    }

}