package com.tapsdk.tapad.lib_tapadadapter.utils;

import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.group.AdNetworkType;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class Utils {
    public static Map<String, Object> getLossMap(long j, String str, String str2) {
        HashMap map = new HashMap();
        map.put(Constants.Bidding.WIN_PRICE, Long.valueOf(j));
        map.put(Constants.Bidding.LOSS_REASON, 1);
        map.put(Constants.Bidding.ADN_ID, Integer.valueOf(Objects.equals(str2, AdNetworkType.AD_TAP.getName()) ? 1 : 2));
        return map;
    }

    public static Map<String, Object> getWinMap(long j, long j2) {
        HashMap map = new HashMap();
        map.put(Constants.Bidding.EXPECT_COST_PRICE, Long.valueOf(j2));
        map.put(Constants.Bidding.HIGHEST_LOSS_PRICE, Long.valueOf(j));
        return map;
    }
}
