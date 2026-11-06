package com.tapsdk.tapad.group.adapter;

import com.mar.sdk.IAction;
import com.tapsdk.tapad.constants.Constants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AdapterAdMetadata {
    private static final String ADN_EXTRA_INFO = "adn_extra_info";
    private static final String ADN_PRICE = "adn_price";
    private static final String ADN_TRACK_ID = "adn_track_id";

    private AdapterAdMetadata() {
    }

    public static Map<String, Object> fromProvider(Map<String, Object> map) {
        if (map == null) {
            return Collections.EMPTY_MAP;
        }
        HashMap map2 = new HashMap();
        if (map.containsKey(Constants.Bidding.REQUEST_ID)) {
            map2.put(ADN_TRACK_ID, map.get(Constants.Bidding.REQUEST_ID));
        }
        if (map.containsKey(IAction.PurchaseKey.Price)) {
            map2.put(ADN_PRICE, map.get(IAction.PurchaseKey.Price));
        }
        map2.put(ADN_EXTRA_INFO, new JSONObject(map).toString());
        return map2;
    }
}
