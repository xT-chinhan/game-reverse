package com.taptap.sdk.db.biz.iap.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import com.taptap.sdk.db.TapDB;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import com.umeng.analytics.pro.d;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IAPEventUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0007J\b\u0010+\u001a\u00020,H\u0007J0\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/H\u0002J\u001e\u00101\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001f2\u0006\u0010'\u001a\u00020(2\u0006\u00102\u001a\u00020\u0004H\u0002J\u001e\u00103\u001a\u0004\u0018\u00010\"2\n\u00104\u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u00105\u001a\u00020\u0004H\u0002J0\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\u0006\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u00020\u0004H\u0002J*\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0007J2\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0004H\u0002J*\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0007J*\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0007JF\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040>2\u0006\u0010'\u001a\u00020(2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u0010@\u001a\u00020AH\u0007JF\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040>2\u0006\u0010'\u001a\u00020(2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u0010@\u001a\u00020AH\u0002J\u000e\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020\u0004JA\u0010E\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020(2\u0006\u00102\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u00010\u00012\u000e\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010HH\u0002¢\u0006\u0002\u0010IJ\"\u0010J\u001a\u00020A2\u0006\u0010'\u001a\u00020(2\b\u00107\u001a\u0004\u0018\u00010\u00012\u0006\u00108\u001a\u00020\u0004H\u0002J,\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040L2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00040.j\b\u0012\u0004\u0012\u00020\u0004`/H\u0002J\u001c\u0010M\u001a\u00020,2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040>H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0015*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R2\u0010\u001d\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0\u001ej\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f` X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"0\u001ej\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\"` X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n \u0015*\u0004\u0018\u00010$0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n \u0015*\u0004\u0018\u00010$0$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/taptap/sdk/db/biz/iap/common/IAPEventUtils;", "", "()V", "AS_INTERFACE", "", "CACHE_CLEAR_TIME_LIMIT_SEC", "", IAPEventUtils.DETAILS_LIST, "GET_PURCHASES", "GET_PURCHASE_HISTORY", "GET_SKU_DETAILS", "INAPP", IAPEventUtils.INAPP_CONTINUATION_TOKEN, IAPEventUtils.INAPP_PURCHASE_DATA_LIST, "IN_APP_BILLING_SERVICE", "IN_APP_BILLING_SERVICE_STUB", "IS_BILLING_SUPPORTED", IAPEventUtils.ITEM_ID_LIST, IAPEventUtils.LAST_CLEARED_TIME, "MAX_QUERY_PURCHASE_NUM", "PACKAGE_NAME", "kotlin.jvm.PlatformType", "PURCHASE_EXPIRE_TIME_SEC", "PURCHASE_INAPP_STORE", "PURCHASE_STOP_QUERY_TIME_SEC", IAPEventUtils.RESPONSE_CODE, "SKU_DETAILS_STORE", "SKU_DETAIL_EXPIRE_TIME_SEC", "SUBSCRIPTION", "classMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "methodMap", "Ljava/lang/reflect/Method;", "purchaseInappSharedPrefs", "Landroid/content/SharedPreferences;", "skuDetailSharedPrefs", IAPEventUtils.AS_INTERFACE, d.R, "Landroid/content/Context;", "service", "Landroid/os/IBinder;", "clearSkuDetailsCache", "", "filterPurchases", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "purchases", "getClass", "className", "getMethod", "classObj", "methodName", IAPEventUtils.GET_PURCHASE_HISTORY, "inAppBillingObj", "type", "getPurchaseHistoryInapp", IAPEventUtils.GET_PURCHASES, "getPurchasesInapp", "getPurchasesSubs", IAPEventUtils.GET_SKU_DETAILS, "", "skuList", "isSubscription", "", "getSkuDetailsFromGoogle", "hasFreeTrialPeirod", "skuDetail", "invokeMethod", "obj", "args", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", IAPEventUtils.IS_BILLING_SUPPORTED, "readSkuDetailsFromCache", "", "writeSkuDetailsToCache", "skuDetailsMap", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class IAPEventUtils {
    private static final String AS_INTERFACE = "asInterface";
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    private static final String DETAILS_LIST = "DETAILS_LIST";
    private static final String GET_PURCHASES = "getPurchases";
    private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";
    private static final String GET_SKU_DETAILS = "getSkuDetails";
    private static final String INAPP = "inapp";
    private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String IS_BILLING_SUPPORTED = "isBillingSupported";
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final int MAX_QUERY_PURCHASE_NUM = 30;
    private static final int PURCHASE_EXPIRE_TIME_SEC = 86400;
    private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;
    private static final String RESPONSE_CODE = "RESPONSE_CODE";
    private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;
    private static final String SUBSCRIPTION = "subs";
    public static final IAPEventUtils INSTANCE = new IAPEventUtils();
    private static final HashMap<String, Method> methodMap = new HashMap<>();
    private static final HashMap<String, Class<?>> classMap = new HashMap<>();
    private static final String PACKAGE_NAME = TapDB.INSTANCE.getOptions$tap_db_release().getContext().getPackageName();
    private static final String SKU_DETAILS_STORE = "com.taptap.internal.SKU_DETAILS";
    private static final SharedPreferences skuDetailSharedPrefs = TapDB.INSTANCE.getOptions$tap_db_release().getContext().getSharedPreferences(SKU_DETAILS_STORE, 0);
    private static final String PURCHASE_INAPP_STORE = "com.taptap.internal.PURCHASE";
    private static final SharedPreferences purchaseInappSharedPrefs = TapDB.INSTANCE.getOptions$tap_db_release().getContext().getSharedPreferences(PURCHASE_INAPP_STORE, 0);

    private IAPEventUtils() {
    }

    @JvmStatic
    public static final Object asInterface(Context context, IBinder service) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object[] args = {service};
        return INSTANCE.invokeMethod(context, IN_APP_BILLING_SERVICE_STUB, AS_INTERFACE, null, args);
    }

    @JvmStatic
    public static final Map<String, String> getSkuDetails(Context context, ArrayList<String> skuList, Object inAppBillingObj, boolean isSubscription) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(skuList, "skuList");
        Map<String, String> skuDetailsFromCache = INSTANCE.readSkuDetailsFromCache(skuList);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String sku : skuList) {
            if (!skuDetailsFromCache.containsKey(sku)) {
                arrayList.add(sku);
            }
        }
        skuDetailsFromCache.putAll(INSTANCE.getSkuDetailsFromGoogle(context, arrayList, inAppBillingObj, isSubscription));
        return skuDetailsFromCache;
    }

    private final Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> skuList, Object inAppBillingObj, boolean isSubscription) {
        Map<String, String> skuDetailsMap = new LinkedHashMap<>();
        if (inAppBillingObj == null || skuList.isEmpty()) {
            return skuDetailsMap;
        }
        Bundle querySkus = new Bundle();
        querySkus.putStringArrayList(ITEM_ID_LIST, skuList);
        Object[] args = new Object[4];
        args[0] = 3;
        args[1] = PACKAGE_NAME;
        args[2] = isSubscription ? SUBSCRIPTION : "inapp";
        args[3] = querySkus;
        Object result = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_SKU_DETAILS, inAppBillingObj, args);
        if (result != null) {
            Bundle bundle = (Bundle) result;
            int response = bundle.getInt(RESPONSE_CODE);
            if (response == 0) {
                ArrayList<String> stringArrayList = bundle.getStringArrayList(DETAILS_LIST);
                if (stringArrayList != null && skuList.size() == stringArrayList.size()) {
                    int size = skuList.size();
                    for (int i = 0; i < size; i++) {
                        String str = skuList.get(i);
                        Intrinsics.checkNotNullExpressionValue(str, "skuList[i]");
                        String str2 = stringArrayList.get(i);
                        Intrinsics.checkNotNullExpressionValue(str2, "skuDetailsList[i]");
                        skuDetailsMap.put(str, str2);
                    }
                }
                writeSkuDetailsToCache(skuDetailsMap);
            }
        }
        return skuDetailsMap;
    }

    private final Map<String, String> readSkuDetailsFromCache(ArrayList<String> skuList) {
        Map skuDetailsMap = new LinkedHashMap();
        long nowSec = System.currentTimeMillis() / 1000;
        for (String sku : skuList) {
            String rawString = skuDetailSharedPrefs.getString(sku, null);
            if (rawString != null) {
                List splitted = StringsKt.split$default((CharSequence) rawString, new String[]{";"}, false, 2, 2, (Object) null);
                long timeSec = Long.parseLong((String) splitted.get(0));
                if (nowSec - timeSec < 43200) {
                    Intrinsics.checkNotNullExpressionValue(sku, "sku");
                    skuDetailsMap.put(sku, splitted.get(1));
                }
            }
        }
        return skuDetailsMap;
    }

    private final void writeSkuDetailsToCache(Map<String, String> skuDetailsMap) {
        long nowSec = System.currentTimeMillis() / 1000;
        SharedPreferences.Editor editor = skuDetailSharedPrefs.edit();
        for (Map.Entry<String, String> entry : skuDetailsMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            editor.putString(key, nowSec + ';' + value);
        }
        editor.apply();
    }

    private final boolean isBillingSupported(Context context, Object inAppBillingObj, String type) {
        if (inAppBillingObj == null) {
            return false;
        }
        Object[] args = {3, PACKAGE_NAME, type};
        Object result = invokeMethod(context, IN_APP_BILLING_SERVICE, IS_BILLING_SUPPORTED, inAppBillingObj, args);
        return result != null && ((Integer) result).intValue() == 0;
    }

    @JvmStatic
    public static final ArrayList<String> getPurchasesInapp(Context context, Object inAppBillingObj) {
        Intrinsics.checkNotNullParameter(context, "context");
        IAPEventUtils iAPEventUtils = INSTANCE;
        return iAPEventUtils.filterPurchases(iAPEventUtils.getPurchases(context, inAppBillingObj, "inapp"));
    }

    @JvmStatic
    public static final ArrayList<String> getPurchasesSubs(Context context, Object inAppBillingObj) {
        Intrinsics.checkNotNullParameter(context, "context");
        IAPEventUtils iAPEventUtils = INSTANCE;
        return iAPEventUtils.filterPurchases(iAPEventUtils.getPurchases(context, inAppBillingObj, SUBSCRIPTION));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005a A[PHI: r1 r2
      0x005a: PHI (r1v4 'continuationToken' java.lang.String) = 
      (r1v3 'continuationToken' java.lang.String)
      (r1v3 'continuationToken' java.lang.String)
      (r1v5 'continuationToken' java.lang.String)
     binds: [B:9:0x0032, B:11:0x003d, B:14:0x0047] A[DONT_GENERATE, DONT_INLINE]
      0x005a: PHI (r2v2 'queriedPurchaseNum' int) = (r2v1 'queriedPurchaseNum' int), (r2v1 'queriedPurchaseNum' int), (r2v3 'queriedPurchaseNum' int) binds: [B:9:0x0032, B:11:0x003d, B:14:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:18:0x005e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:20:0x0060 A[EDGE_INSN: B:20:0x0060->B:19:0x0060 BREAK  A[LOOP:0: B:8:0x0010->B:23:?], SYNTHETIC] */
    private final ArrayList<String> getPurchases(Context context, Object inAppBillingObj, String type) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (inAppBillingObj != null && isBillingSupported(context, inAppBillingObj, type)) {
            String continuationToken = null;
            int queriedPurchaseNum = 0;
            do {
                Object[] args = {3, PACKAGE_NAME, type, continuationToken};
                Object result = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_PURCHASES, inAppBillingObj, args);
                continuationToken = null;
                if (result != null) {
                    Bundle purchaseDetails = (Bundle) result;
                    int response = purchaseDetails.getInt(RESPONSE_CODE);
                    if (response == 0) {
                        ArrayList<String> stringArrayList = purchaseDetails.getStringArrayList(INAPP_PURCHASE_DATA_LIST);
                        if (stringArrayList == null) {
                            break;
                        }
                        queriedPurchaseNum += stringArrayList.size();
                        arrayList.addAll(stringArrayList);
                        continuationToken = purchaseDetails.getString(INAPP_CONTINUATION_TOKEN);
                        if (queriedPurchaseNum >= 30) {
                            break;
                            break;
                        }
                    } else if (queriedPurchaseNum >= 30) {
                        break;
                    }
                } else if (queriedPurchaseNum >= 30) {
                    break;
                    break;
                }
            } while (continuationToken != null);
        }
        return arrayList;
    }

    public final boolean hasFreeTrialPeirod(String skuDetail) {
        boolean z;
        Intrinsics.checkNotNullParameter(skuDetail, "skuDetail");
        try {
            JSONObject skuDetailsJson = new JSONObject(skuDetail);
            String freeTrialPeriod = skuDetailsJson.optString("freeTrialPeriod");
            if (freeTrialPeriod == null) {
                return false;
            }
            if (freeTrialPeriod.length() <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                return false;
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    @JvmStatic
    public static final ArrayList<String> getPurchaseHistoryInapp(Context context, Object inAppBillingObj) {
        IAPEventUtils iAPEventUtils;
        Class<?> cls;
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList<String> arrayList = new ArrayList<>();
        return (inAppBillingObj == null || (cls = (iAPEventUtils = INSTANCE).getClass(context, IN_APP_BILLING_SERVICE)) == null || iAPEventUtils.getMethod(cls, GET_PURCHASE_HISTORY) == null) ? arrayList : iAPEventUtils.filterPurchases(iAPEventUtils.getPurchaseHistory(context, inAppBillingObj, "inapp"));
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a4  */
    private final ArrayList<String> getPurchaseHistory(Context context, Object inAppBillingObj, String type) {
        ArrayList<String> stringArrayList;
        long j;
        ArrayList<String> arrayList = new ArrayList<>();
        if (isBillingSupported(context, inAppBillingObj, type)) {
            String continuationToken = null;
            int queriedPurchaseNum = 0;
            boolean reachTimeLimit = false;
            do {
                Object[] args = {6, PACKAGE_NAME, type, continuationToken, new Bundle()};
                Object result = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_PURCHASE_HISTORY, inAppBillingObj, args);
                if (result != null) {
                    long j2 = 1000;
                    long nowSec = System.currentTimeMillis() / 1000;
                    Bundle purchaseDetails = (Bundle) result;
                    int response = purchaseDetails.getInt(RESPONSE_CODE);
                    if (response == 0 && (stringArrayList = purchaseDetails.getStringArrayList(INAPP_PURCHASE_DATA_LIST)) != null) {
                        for (String detail : stringArrayList) {
                            try {
                                JSONObject detailJson = new JSONObject(detail);
                                try {
                                    j = 1000;
                                    try {
                                        long purchaseTimeSec = detailJson.getLong("purchaseTime") / 1000;
                                        if (nowSec - purchaseTimeSec > 1200) {
                                            reachTimeLimit = true;
                                            break;
                                        }
                                        arrayList.add(detail);
                                        queriedPurchaseNum++;
                                        j2 = 1000;
                                    } catch (JSONException e) {
                                        j2 = j;
                                    }
                                } catch (JSONException e2) {
                                    j = 1000;
                                }
                            } catch (JSONException e3) {
                                j = j2;
                            }
                        }
                        continuationToken = purchaseDetails.getString(INAPP_CONTINUATION_TOKEN);
                    } else {
                        continuationToken = null;
                    }
                } else {
                    continuationToken = null;
                }
                if (queriedPurchaseNum >= 30 || continuationToken == null) {
                    break;
                }
            } while (!reachTimeLimit);
        }
        return arrayList;
    }

    private final ArrayList<String> filterPurchases(ArrayList<String> purchases) {
        ArrayList<String> arrayList = new ArrayList<>();
        SharedPreferences.Editor editor = purchaseInappSharedPrefs.edit();
        long nowSec = System.currentTimeMillis() / 1000;
        for (String purchase : purchases) {
            try {
                JSONObject purchaseJson = new JSONObject(purchase);
                String sku = purchaseJson.getString(BillingClientConstants.PRODUCT_ID);
                long purchaseTimeMillis = purchaseJson.getLong("purchaseTime");
                String purchaseToken = purchaseJson.getString("purchaseToken");
                if (nowSec - (purchaseTimeMillis / 1000) <= 86400) {
                    String historyPurchaseToken = purchaseInappSharedPrefs.getString(sku, "");
                    if (!Intrinsics.areEqual(historyPurchaseToken, purchaseToken)) {
                        editor.putString(sku, purchaseToken);
                        arrayList.add(purchase);
                    }
                }
            } catch (JSONException e) {
            }
        }
        editor.apply();
        return arrayList;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Method getMethod(Class<?> classObj, String methodName) {
        HashMap<String, Method> map = methodMap;
        Method method = map.get(methodName);
        if (method != null) {
            return method;
        }
        Class[] paramTypes = null;
        switch (methodName.hashCode()) {
            case -1801122596:
                if (methodName.equals(GET_PURCHASES)) {
                    Class TYPE = Integer.TYPE;
                    Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
                    paramTypes = new Class[]{TYPE, String.class, String.class, String.class};
                }
                break;
            case -1450694211:
                if (methodName.equals(IS_BILLING_SUPPORTED)) {
                    Class TYPE2 = Integer.TYPE;
                    Intrinsics.checkNotNullExpressionValue(TYPE2, "TYPE");
                    paramTypes = new Class[]{TYPE2, String.class, String.class};
                }
                break;
            case -1123215065:
                if (methodName.equals(AS_INTERFACE)) {
                    paramTypes = new Class[]{IBinder.class};
                }
                break;
            case -594356707:
                if (methodName.equals(GET_PURCHASE_HISTORY)) {
                    Class TYPE3 = Integer.TYPE;
                    Intrinsics.checkNotNullExpressionValue(TYPE3, "TYPE");
                    paramTypes = new Class[]{TYPE3, String.class, String.class, String.class, Bundle.class};
                }
                break;
            case -573310373:
                if (methodName.equals(GET_SKU_DETAILS)) {
                    Class TYPE4 = Integer.TYPE;
                    Intrinsics.checkNotNullExpressionValue(TYPE4, "TYPE");
                    paramTypes = new Class[]{TYPE4, String.class, String.class, Bundle.class};
                }
                break;
        }
        Class[] parameterTypes = paramTypes;
        Method method2 = parameterTypes == null ? InAppPurchaseUtils.getDeclaredMethod$tap_db_release(classObj, methodName, null) : InAppPurchaseUtils.getDeclaredMethod$tap_db_release(classObj, methodName, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        if (method2 != null) {
            map.put(methodName, method2);
        }
        return method2;
    }

    private final Class<?> getClass(Context context, String className) {
        HashMap<String, Class<?>> map = classMap;
        Class<?> cls = map.get(className);
        if (cls != null) {
            return cls;
        }
        Class<?> classFromContext$tap_db_release = InAppPurchaseUtils.getClassFromContext$tap_db_release(context, className);
        if (classFromContext$tap_db_release != null) {
            map.put(className, classFromContext$tap_db_release);
        }
        return classFromContext$tap_db_release;
    }

    private final Object invokeMethod(Context context, String className, String methodName, Object obj, Object[] args) {
        Method method;
        Class<?> cls = getClass(context, className);
        if (cls == null || (method = getMethod(cls, methodName)) == null) {
            return null;
        }
        return InAppPurchaseUtils.invokeMethod(cls, method, obj, Arrays.copyOf(args, args.length));
    }

    @JvmStatic
    public static final void clearSkuDetailsCache() {
        long nowSec = System.currentTimeMillis() / 1000;
        SharedPreferences sharedPreferences = skuDetailSharedPrefs;
        long lastClearedTimeSec = sharedPreferences.getLong(LAST_CLEARED_TIME, 0L);
        if (lastClearedTimeSec == 0) {
            sharedPreferences.edit().putLong(LAST_CLEARED_TIME, nowSec).apply();
        } else if (nowSec - lastClearedTimeSec > 604800) {
            sharedPreferences.edit().clear().putLong(LAST_CLEARED_TIME, nowSec).apply();
        }
    }
}
