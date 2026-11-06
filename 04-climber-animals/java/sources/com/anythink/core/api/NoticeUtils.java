package com.anythink.core.api;

import com.anythink.core.common.d.r;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NoticeUtils {
    public static final String BIDDER_NAME = "bidding_name";
    public static final String ORIGIN_ILRD = "origin_irld";
    public static final String SECOND_PRICE = "second_price";
    public static final String WATERFALL_INFO = "waterfall_info";

    public static class LossReason {
        public static final String LOSS_TO_AUCTION_FLOOR = "100";
        public static final String LOSS_TO_HIGHER_BID = "102";
        public static final String LOSS_TO_NORMAL = "103";
    }

    public static void notifyWin(String str, String str2, Map<String, Object> map) {
        r.a(str, str2, map);
    }

    public static void notifyLoss(String str, String str2, String str3, double d, Map<String, Object> map) {
        r.a(str, str2, str3, d, map);
    }
}
