package com.tapsdk.tapad.constants;

/* JADX INFO: loaded from: classes2.dex */
public class Constants {

    public static class Bidding {
        public static final String ADN_ID = "adn_id";
        public static final String EXPECT_COST_PRICE = "expect_cost_price";
        public static final String HIGHEST_LOSS_PRICE = "highest_loss_price";
        public static final String LOSS_REASON = "lose_reason";
        public static final String REQUEST_ID = "request_id";
        public static final String REQ_UUID = "req_uuid";
        public static final String SPACE_ID = "space_id";
        public static final String WIN_PRICE = "win_price";
    }

    public static class BiddingLossReason {
        public static final int LOW_PRICE = 1;
        public static final int NOT_COMPETITION = 101;
        public static final int NO_AD = 2;
        public static final int OTHER = 10001;
    }

    public static class Personalization {
        public static final String PERSONAL_ADS_TYPE = "personal_ads_type";
        public static final String PERSONAL_ADS_TYPE_ALLOW = "1";
        public static final String PERSONAL_ADS_TYPE_LIMIT = "0";
    }
}
