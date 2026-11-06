package com.tapsdk.tapad.internal;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class WasmAdMediaExtraInfo {
    private static final String BID_PRICE = "bid_price";
    private static final String BID_TYPE = "bid_type";
    private static final String PRICE = "price";

    private WasmAdMediaExtraInfo() {
    }

    private static Integer exactInteger(Object obj) {
        if (!(obj instanceof Number)) {
            return null;
        }
        try {
            return Integer.valueOf(new BigDecimal(obj.toString()).intValueExact());
        } catch (ArithmeticException | NumberFormatException e) {
            return null;
        }
    }

    private static Long exactLong(Object obj) {
        if (!(obj instanceof Number)) {
            return null;
        }
        try {
            return Long.valueOf(new BigDecimal(obj.toString()).longValueExact());
        } catch (ArithmeticException | NumberFormatException e) {
            return null;
        }
    }

    public static Map<String, Object> fromLoadPayload(JSONObject jSONObject) {
        HashMap map = new HashMap();
        if (jSONObject == null) {
            return map;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("media_extra_info");
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objOpt = jSONObjectOptJSONObject.opt(next);
                if (objOpt != null && objOpt != JSONObject.NULL) {
                    map.put(next, objOpt);
                }
            }
        }
        normalizeBidPrice(jSONObject, map);
        normalizeBidType(jSONObject, map);
        return map;
    }

    private static void normalizeBidPrice(JSONObject jSONObject, Map<String, Object> map) {
        Long lExactLong = exactLong(map.get(BID_PRICE));
        if (lExactLong == null) {
            lExactLong = exactLong(jSONObject.opt("price"));
        }
        if (lExactLong == null) {
            map.remove(BID_PRICE);
        } else {
            map.put(BID_PRICE, lExactLong);
        }
    }

    private static void normalizeBidType(JSONObject jSONObject, Map<String, Object> map) {
        Integer numExactInteger = exactInteger(map.get(BID_TYPE));
        if (numExactInteger == null) {
            numExactInteger = exactInteger(jSONObject.opt(BID_TYPE));
        }
        if (numExactInteger == null) {
            map.remove(BID_TYPE);
        } else {
            map.put(BID_TYPE, numExactInteger);
        }
    }
}
