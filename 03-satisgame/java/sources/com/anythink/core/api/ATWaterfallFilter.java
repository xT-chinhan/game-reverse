package com.anythink.core.api;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ATWaterfallFilter extends ATAdFilter {
    public static String C2S = "2";
    public static String NORMAL = "0";
    public static String S2S = "1";

    public static class PriceInterval {
        private Double lessPrice;
        private Double morePrice;
        private final ATAdConst.CURRENCY scurrency;

        public PriceInterval(ATAdConst.CURRENCY currency) {
            this.scurrency = currency;
        }

        public PriceInterval lessThanPrice(double d) {
            this.lessPrice = Double.valueOf(d);
            return this;
        }

        public PriceInterval moreThanPrice(double d) {
            this.morePrice = Double.valueOf(d);
            return this;
        }

        public Double getLessPrice() {
            return this.lessPrice;
        }

        public Double getMorePrice() {
            return this.morePrice;
        }

        public ATAdConst.CURRENCY getScurrency() {
            return this.scurrency;
        }

        public JSONObject getJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("lessPrice", this.lessPrice);
                jSONObject.put("morePrice", this.morePrice);
                ATAdConst.CURRENCY currency = this.scurrency;
                if (currency != null) {
                    jSONObject.put("currency", currency.name());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return jSONObject;
        }
    }
}
