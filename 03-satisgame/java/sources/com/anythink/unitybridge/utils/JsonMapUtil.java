package com.anythink.unitybridge.utils;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdFilter;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATRequestingInfo;
import com.anythink.core.api.ATSharedPlacementConfig;
import com.anythink.core.api.ATWaterfallFilter;
import com.anythink.core.basead.adx.api.ATAdxBidFloorInfo;
import com.anythink.core.common.d.i;
import com.anythink.core.mg.api.MgPreLoadAdRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class JsonMapUtil {
    private JsonMapUtil() {
    }

    public static Map<String, Object> stringObjectMapFromJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return objectMapFromJsonObject(new JSONObject(str));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Map<String, Object> objectMapFromJsonObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (objOpt == null) {
                map.put(next, null);
            } else if (objOpt instanceof JSONObject) {
                map.put(next, objectMapFromJsonObject((JSONObject) objOpt));
            } else {
                map.put(next, objOpt);
            }
        }
        return map;
    }

    public static ATAdRequest atAdRequestFromJson(JSONObject jSONObject) {
        MgPreLoadAdRequest mgPreLoadAdRequestMgPreLoadAdRequestFromJson;
        ATAdxBidFloorInfo aTAdxBidFloorInfoAtAdxBidFloorInfoFromJson;
        if (jSONObject == null) {
            return null;
        }
        try {
            ATAdRequest.Builder builder = new ATAdRequest.Builder();
            if (jSONObject.has("channelSource")) {
                builder.setChannelSource(jSONObject.optInt("channelSource"));
            }
            if (jSONObject.has("adxBidFloorInfo") && (aTAdxBidFloorInfoAtAdxBidFloorInfoFromJson = atAdxBidFloorInfoFromJson(jSONObject.optJSONObject("adxBidFloorInfo"))) != null) {
                builder.setATAdxBidFloorInfo(aTAdxBidFloorInfoAtAdxBidFloorInfoFromJson);
            }
            if (jSONObject.has("preLoadInfo") && (mgPreLoadAdRequestMgPreLoadAdRequestFromJson = mgPreLoadAdRequestFromJson(jSONObject.optJSONObject("preLoadInfo"))) != null) {
                builder.setPreLoadInfo(mgPreLoadAdRequestMgPreLoadAdRequestFromJson);
            }
            return builder.build();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static ATAdxBidFloorInfo atAdxBidFloorInfoFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            double dOptDouble = jSONObject.optDouble("bidFloor", 0.0d);
            ATAdConst.CURRENCY currency = parseCurrency(jSONObject.optString("currency", i.k.a));
            if (jSONObject.has("extraMap") && (jSONObject.opt("extraMap") instanceof JSONObject)) {
                return new ATAdxBidFloorInfo(dOptDouble, currency, objectMapFromJsonObject(jSONObject.optJSONObject("extraMap")));
            }
            return new ATAdxBidFloorInfo(dOptDouble, currency);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003c  */
    private static ATAdConst.CURRENCY parseCurrency(String str) {
        byte b;
        if (str == null) {
            return ATAdConst.CURRENCY.USD;
        }
        String upperCase = str.toUpperCase();
        int iHashCode = upperCase.hashCode();
        if (iHashCode != -1520810624) {
            if (iHashCode != 81255) {
                if (iHashCode == 84326 && upperCase.equals(i.k.a)) {
                    b = 2;
                } else {
                    b = -1;
                }
            } else if (upperCase.equals("RMB")) {
                b = 0;
            } else {
                b = -1;
            }
        } else if (upperCase.equals("RMB_CENT")) {
            b = 1;
        } else {
            b = -1;
        }
        if (b == 0) {
            return ATAdConst.CURRENCY.RMB;
        }
        if (b == 1) {
            return ATAdConst.CURRENCY.RMB_CENT;
        }
        return ATAdConst.CURRENCY.USD;
    }

    private static MgPreLoadAdRequest mgPreLoadAdRequestFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            MgPreLoadAdRequest.Builder builder = new MgPreLoadAdRequest.Builder();
            if (jSONObject.has("requestId")) {
                builder.setRequestId(jSONObject.optString("requestId", null));
            }
            if (jSONObject.has("psId")) {
                builder.setPsId(jSONObject.optString("psId", null));
            }
            if (jSONObject.has("placementId")) {
                builder.setPlacementId(jSONObject.optString("placementId", null));
            }
            if (jSONObject.has("cpEcpmSwitch")) {
                builder.setCpEcpmSwitch(jSONObject.optInt("cpEcpmSwitch"));
            }
            if (jSONObject.has("cpEcpmTimeout")) {
                builder.setCpEcpmTimeout(jSONObject.optLong("cpEcpmTimeout", 1000L));
            }
            return builder.build();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static ATSharedPlacementConfig sharedPlacementConfigFromJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return sharedPlacementConfigFromJson(new JSONObject(str));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static ATSharedPlacementConfig sharedPlacementConfigFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            ATSharedPlacementConfig.Builder builder = new ATSharedPlacementConfig.Builder();
            if (jSONObject.has("rewardVideoLocalExtra")) {
                builder.rewardVideoLocalExtra(objectMapFromJsonObject(jSONObject.optJSONObject("rewardVideoLocalExtra")));
            }
            if (jSONObject.has("interstitialLocalExtra")) {
                builder.interstitialLocalExtra(objectMapFromJsonObject(jSONObject.optJSONObject("interstitialLocalExtra")));
            }
            if (jSONObject.has("splashLocalExtra")) {
                builder.splashLocalExtra(objectMapFromJsonObject(jSONObject.optJSONObject("splashLocalExtra")));
            }
            if (jSONObject.has("bannerLocalExtra")) {
                builder.bannerLocalExtra(objectMapFromJsonObject(jSONObject.optJSONObject("bannerLocalExtra")));
            }
            if (jSONObject.has("nativeLocalExtra")) {
                builder.nativeLocalExtra(objectMapFromJsonObject(jSONObject.optJSONObject("nativeLocalExtra")));
            }
            return builder.build();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static JSONArray adInfoListToJsonArray(List<ATAdInfo> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        for (ATAdInfo aTAdInfo : list) {
            if (aTAdInfo == null) {
                jSONArray.put(JSONObject.NULL);
            } else {
                try {
                    jSONArray.put(new JSONObject(aTAdInfo.toString()));
                } catch (Exception unused) {
                    jSONArray.put(aTAdInfo.toString());
                }
            }
        }
        return jSONArray;
    }

    public static String requestingInfoToJson(ATRequestingInfo aTRequestingInfo) {
        if (aTRequestingInfo == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("biddingAttemptAdInfoList", adInfoListToJsonArray(aTRequestingInfo.getBiddingAttemptAdInfoList()));
            jSONObject.put("loadingAdInfoList", adInfoListToJsonArray(aTRequestingInfo.getLoadingAdInfoList()));
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static ATWaterfallFilter waterfallFilterFromGroupsJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return waterfallFilterFromGroupsJson(new JSONObject(str));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static ATWaterfallFilter waterfallFilterFromGroupsJson(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("groups")) == null || jSONArrayOptJSONArray.length() == 0) {
            return null;
        }
        ATWaterfallFilter aTWaterfallFilter = new ATWaterfallFilter();
        boolean z = false;
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && groupHasWaterfallConditions(jSONObjectOptJSONObject)) {
                if (z) {
                    aTWaterfallFilter.orFilter();
                }
                applyWaterfallGroup(aTWaterfallFilter, jSONObjectOptJSONObject);
                z = true;
            }
        }
        if (z) {
            return aTWaterfallFilter;
        }
        return null;
    }

    private static boolean groupHasWaterfallConditions(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        if (readStringListFromGroup(jSONObject, ATAdFilter.KEY_NETWORK_ID) != null || readBiddingTypeValues(jSONObject) != null || readStringListFromGroup(jSONObject, ATAdFilter.KEY_NETWORK_PLACEMENT_ID) != null) {
            return true;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(ATAdFilter.KEY_E_CPM);
        if (jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject.has("currency") || jSONObjectOptJSONObject.has("moreThanPrice") || jSONObjectOptJSONObject.has("lessThanPrice");
        }
        return false;
    }

    private static void applyWaterfallGroup(ATWaterfallFilter aTWaterfallFilter, JSONObject jSONObject) {
        ATWaterfallFilter.PriceInterval priceIntervalPriceIntervalFromJson;
        List<String> stringListFromGroup = readStringListFromGroup(jSONObject, ATAdFilter.KEY_NETWORK_ID);
        if (stringListFromGroup != null && !stringListFromGroup.isEmpty()) {
            aTWaterfallFilter.filterNetworkIds(stringListFromGroup);
        }
        List<String> biddingTypeValues = readBiddingTypeValues(jSONObject);
        if (biddingTypeValues != null && !biddingTypeValues.isEmpty()) {
            aTWaterfallFilter.filterBidTypes(biddingTypeValues);
        }
        List<String> stringListFromGroup2 = readStringListFromGroup(jSONObject, ATAdFilter.KEY_NETWORK_PLACEMENT_ID);
        if (stringListFromGroup2 != null && !stringListFromGroup2.isEmpty()) {
            aTWaterfallFilter.filterNetworkPlacementIds(stringListFromGroup2);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(ATAdFilter.KEY_E_CPM);
        if (jSONObjectOptJSONObject == null || (priceIntervalPriceIntervalFromJson = priceIntervalFromJson(jSONObjectOptJSONObject)) == null) {
            return;
        }
        aTWaterfallFilter.filterAdPrice(priceIntervalPriceIntervalFromJson);
    }

    private static List<String> readStringListFromGroup(JSONObject jSONObject, String str) {
        Object objOpt;
        if (jSONObject == null || !jSONObject.has(str) || (objOpt = jSONObject.opt(str)) == null || objOpt == JSONObject.NULL) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (objOpt instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) objOpt;
            for (int i = 0; i < jSONArray.length(); i++) {
                Object objOpt2 = jSONArray.opt(i);
                if (objOpt2 != null && objOpt2 != JSONObject.NULL) {
                    arrayList.add(String.valueOf(objOpt2));
                }
            }
        } else if (objOpt instanceof String) {
            String str2 = (String) objOpt;
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(str2);
            }
        } else {
            arrayList.add(String.valueOf(objOpt));
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    private static List<String> readBiddingTypeValues(JSONObject jSONObject) {
        String strMapBiddingTypeNameToFilterValue;
        if (jSONObject == null || !jSONObject.has(ATAdFilter.KEY_BIDDING_TYPE)) {
            return null;
        }
        Object objOpt = jSONObject.opt(ATAdFilter.KEY_BIDDING_TYPE);
        ArrayList arrayList = new ArrayList();
        if (objOpt instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) objOpt;
            for (int i = 0; i < jSONArray.length(); i++) {
                String strMapBiddingTypeNameToFilterValue2 = mapBiddingTypeNameToFilterValue(jSONArray.optString(i, null));
                if (strMapBiddingTypeNameToFilterValue2 != null) {
                    arrayList.add(strMapBiddingTypeNameToFilterValue2);
                }
            }
        } else if ((objOpt instanceof String) && (strMapBiddingTypeNameToFilterValue = mapBiddingTypeNameToFilterValue((String) objOpt)) != null) {
            arrayList.add(strMapBiddingTypeNameToFilterValue);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    private static String mapBiddingTypeNameToFilterValue(String str) {
        if (str == null) {
            return null;
        }
        String upperCase = str.trim().toUpperCase();
        upperCase.hashCode();
        switch (upperCase) {
            case "NORMAL":
                return ATWaterfallFilter.NORMAL;
            case "C2S":
                return ATWaterfallFilter.C2S;
            case "S2S":
                return ATWaterfallFilter.S2S;
            default:
                return str.trim();
        }
    }

    private static ATWaterfallFilter.PriceInterval priceIntervalFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            ATWaterfallFilter.PriceInterval priceInterval = new ATWaterfallFilter.PriceInterval(parseCurrency(jSONObject.optString("currency", i.k.a)));
            if (jSONObject.has("moreThanPrice")) {
                priceInterval.moreThanPrice(jSONObject.optDouble("moreThanPrice"));
            }
            if (jSONObject.has("lessThanPrice")) {
                priceInterval.lessThanPrice(jSONObject.optDouble("lessThanPrice"));
            }
            return priceInterval;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
