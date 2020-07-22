package com.retail.shopping.core;

import com.retail.shopping.enums.CustomerType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Naresh Podichetty
 *
 */
public class DiscountFactory {

    private List<Discount> discounts;

    public DiscountFactory() {
        this.discounts = new ArrayList<>();
        createRewards();
    }

    public void createRewards() {
        discounts.add(getRegularDiscounts());
        discounts.add(getPremiumDiscounts());
    }

    /**
     * Calculate discount
     *
     * @param customerType
     * @param amount
     * @return
     */
    public float calculateDiscount(String customerType, float amount) {
        float reward = 0f;

        for (Discount discount : discounts) {
            if (discount.isDiscountApplied(customerType)) {
                reward += discount.calculateDiscount(amount);
            }
        }
        return reward;
    }


    private Discount getRegularDiscounts() {
        Discount discount = new Discount(CustomerType.REGULAR.name());
        Slab slab = new Slab(0f, 5000f, 0.00f);
        discount.addSlab(slab);

        slab =  new Slab(5000f, 10000f, 0.10f);
        discount.addSlab(slab);

        slab =  new Slab(10000f, Float.MAX_VALUE, 0.20f);
        discount.addSlab(slab);
        return discount;
    }

    private Discount getPremiumDiscounts() {
        Discount discount = new Discount(CustomerType.PREMIUM.name());
        Slab slab = new Slab(0f, 4000f, 0.10f);
        discount.addSlab(slab);

        slab = new Slab(4000f, 8000f, 0.15f);
        discount.addSlab(slab);

        slab = new Slab(8000f, 12000f, 0.20f);
        discount.addSlab(slab);

        slab = new Slab(12000f, Float.MAX_VALUE, 0.30f);
        discount.addSlab(slab);
        return discount;
    }
}
