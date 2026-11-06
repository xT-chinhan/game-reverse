package com.anythink.core.api;

/* JADX INFO: loaded from: classes.dex */
public class NoticeUtils {
    public static final String BIDDER_NAME = "bidding_name";
    public static final String EVENT_TYPE = "event_type";
    public static final String LOSS_REASON = "loss_reason";
    public static final String ORIGIN_ILRD = "origin_irld";
    public static final String SECOND_PRICE = "second_price";
    public static final String WATERFALL_INFO = "waterfall_info";
    public static final String WINNER_PRICE = "winner_price";

    public static class EventType {
        public static final int LOSS = 2;
        public static final int WIN = 1;
    }

    public static class LossReason {
        public static final String LOSS_TO_AUCTION_FLOOR = "100";
        public static final String LOSS_TO_HIGHER_BID = "102";
        public static final String LOSS_TO_NORMAL = "103";
    }
}
