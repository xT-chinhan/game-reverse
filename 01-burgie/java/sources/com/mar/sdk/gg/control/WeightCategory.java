package com.mar.sdk.gg.control;

/* JADX INFO: loaded from: classes2.dex */
public class WeightCategory {
    private String category;
    private Integer weight;

    public WeightCategory() {
    }

    public WeightCategory(String category, Integer weight) {
        setCategory(category);
        setWeight(weight);
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
