package com.anythink.network.baidu;

import android.util.Log;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATIBiddingResultListener;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.d.j;
import com.anythink.core.common.m.o;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BaiduATBiddingNotice implements ATBiddingNotice {
    private static final String c = "adn";
    private static final String d = "ad_t";
    private static final String e = "ad_time";
    private static final String f = "bid_t";
    private static final String g = "is_s";
    private static final String h = "is_c";
    Object a;
    ATIBiddingResultListener b = null;

    private static int a(int i) {
        if (i == 15) {
            return 1;
        }
        if (i == 22) {
            return 9;
        }
        if (i == 66) {
            return 5;
        }
        if (i == 78) {
            return 8;
        }
        if (i != 28) {
            return i != 29 ? 10 : 4;
        }
        return 3;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public void notifyBidDisplay(boolean z, double d2) {
    }

    protected BaiduATBiddingNotice(Object obj) {
        this.a = obj;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public synchronized void notifyBidWin(double d2, double d3, Map<String, Object> map) {
        LinkedHashMap<String, Object> linkedHashMapA = a(map);
        int iRound = (int) Math.round(d3);
        String strValueOf = String.valueOf(iRound);
        linkedHashMapA.put("ecpm", Integer.valueOf(iRound));
        StringBuilder sb = new StringBuilder();
        Object obj = this.a;
        b(sb.append(obj != null ? obj.toString() : "").append(": notifyBidWin : second price:").append(strValueOf).toString());
        BiddingListener biddingListener = new BiddingListener() { // from class: com.anythink.network.baidu.BaiduATBiddingNotice.1
            @Override // com.baidu.mobads.sdk.api.BiddingListener
            public final void onBiddingResult(boolean z, String str, HashMap<String, Object> map2) {
                BaiduATBiddingNotice.b("onBiddingResult-win: " + z + " msg信息：" + str);
            }
        };
        Object obj2 = this.a;
        if (obj2 != null && (obj2 instanceof RewardVideoAd)) {
            ((RewardVideoAd) obj2).biddingSuccess(linkedHashMapA, biddingListener);
            return;
        }
        Object obj3 = this.a;
        if (obj3 != null && (obj3 instanceof SplashAd)) {
            ((SplashAd) obj3).biddingSuccess(linkedHashMapA, biddingListener);
            return;
        }
        Object obj4 = this.a;
        if (obj4 != null && (obj4 instanceof NativeResponse)) {
            ((NativeResponse) obj4).biddingSuccess(linkedHashMapA, biddingListener);
            return;
        }
        Object obj5 = this.a;
        if (obj5 != null && (obj5 instanceof ExpressResponse)) {
            ((ExpressResponse) obj5).biddingSuccess(linkedHashMapA, biddingListener);
            return;
        }
        Object obj6 = this.a;
        if (obj6 != null && (obj6 instanceof ExpressInterstitialAd)) {
            ((ExpressInterstitialAd) obj6).biddingSuccess(linkedHashMapA, biddingListener);
            return;
        }
        try {
            Object obj7 = this.a;
            if (obj7 != null && (obj7 instanceof FullScreenVideoAd)) {
                ((FullScreenVideoAd) obj7).biddingSuccess(linkedHashMapA, biddingListener);
                return;
            }
        } catch (Throwable unused) {
        }
        this.a = null;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.anythink.core.api.ATBiddingNotice
    public synchronized void notifyBidLoss(String str, double d2, Map<String, Object> map) {
        byte b;
        int i;
        int iHashCode = str.hashCode();
        if (iHashCode != 50) {
            if (iHashCode != 53) {
                switch (iHashCode) {
                    case 48627:
                        if (!str.equals("102")) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case 48628:
                        if (!str.equals("103")) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case 48629:
                        if (!str.equals(ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_FLOOR)) {
                            b = -1;
                        } else {
                            b = 4;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
            } else if (str.equals("5")) {
                b = 3;
            } else {
                b = -1;
            }
        } else if (str.equals("2")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            i = 100;
        } else if (b == 1 || b == 2) {
            i = 203;
        } else {
            i = 900;
            if (b != 3 && b == 4) {
                i = 202;
            }
        }
        int iRound = (int) Math.round(d2);
        StringBuilder sb = new StringBuilder();
        Object obj = this.a;
        b(sb.append(obj != null ? obj.toString() : "").append(": notifyBidLoss winPrice: ").append(iRound).append(", lossCode:").append(str).append(", lossReason:").append(i).toString());
        LinkedHashMap<String, Object> linkedHashMapA = a(str, map);
        linkedHashMapA.put("ecpm", Integer.valueOf(iRound));
        linkedHashMapA.put(MediationConstant.KEY_REASON, Integer.valueOf(i));
        Object obj2 = map.get(ATBiddingNotice.ADN_BID_LISTENER_OBJECT);
        if (obj2 instanceof ATIBiddingResultListener) {
            ATIBiddingResultListener aTIBiddingResultListener = (ATIBiddingResultListener) obj2;
            this.b = aTIBiddingResultListener;
            aTIBiddingResultListener.setNeedWait(true);
        }
        BiddingListener biddingListener = new BiddingListener() { // from class: com.anythink.network.baidu.BaiduATBiddingNotice.2
            @Override // com.baidu.mobads.sdk.api.BiddingListener
            public final void onBiddingResult(boolean z, String str2, HashMap<String, Object> map2) {
                BaiduATBiddingNotice.b("onBiddingResult-loss: " + z + " msg信息：" + str2);
                if (BaiduATBiddingNotice.this.b != null) {
                    if (z) {
                        BaiduATBiddingNotice.this.b.reportSuccess(map2);
                    } else {
                        BaiduATBiddingNotice.this.b.reportFailed(o.l, str2, map2);
                    }
                }
            }
        };
        Object obj3 = this.a;
        if (obj3 != null && (obj3 instanceof RewardVideoAd)) {
            ((RewardVideoAd) obj3).biddingFail(linkedHashMapA, biddingListener);
            return;
        }
        Object obj4 = this.a;
        if (obj4 != null && (obj4 instanceof SplashAd)) {
            ((SplashAd) obj4).biddingFail(linkedHashMapA, biddingListener);
            return;
        }
        Object obj5 = this.a;
        if (obj5 != null && (obj5 instanceof NativeResponse)) {
            ((NativeResponse) obj5).biddingFail(linkedHashMapA, biddingListener);
            return;
        }
        Object obj6 = this.a;
        if (obj6 != null && (obj6 instanceof ExpressResponse)) {
            ((ExpressResponse) obj6).biddingFail(linkedHashMapA, biddingListener);
            return;
        }
        Object obj7 = this.a;
        if (obj7 != null && (obj7 instanceof ExpressInterstitialAd)) {
            ((ExpressInterstitialAd) obj7).biddingFail(linkedHashMapA, biddingListener);
            return;
        }
        try {
            Object obj8 = this.a;
            if (obj8 != null && (obj8 instanceof FullScreenVideoAd)) {
                ((FullScreenVideoAd) obj8).biddingFail(linkedHashMapA, biddingListener);
                return;
            }
        } catch (Throwable unused) {
        }
        this.a = null;
    }

    @Override // com.anythink.core.api.ATBiddingNotice
    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB_CENT;
    }

    private static LinkedHashMap<String, Object> a(Map<String, Object> map) {
        int iA;
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>(4);
        int intFromMap = BaiduATInitManager.getIntFromMap(map, "adn_id");
        int intFromMap2 = BaiduATInitManager.getIntFromMap(map, ATBiddingNotice.ADN_TYPE);
        int intFromMap3 = 0;
        int intFromMap4 = BaiduATInitManager.getIntFromMap(map, ATBiddingNotice.ADN_EXTRA_NW_FIRM_ID, 0);
        if (intFromMap4 > 0) {
            iA = a(intFromMap4);
        } else {
            iA = intFromMap == 5 ? 9 : 10;
        }
        int i = intFromMap2 == 101 ? 3 : 1;
        linkedHashMap.put("adn", Integer.valueOf(iA));
        linkedHashMap.put(e, Long.valueOf(System.currentTimeMillis() / 1000));
        linkedHashMap.put(f, Integer.valueOf(i));
        Object obj = map.get(ATBiddingNotice.ADN_EXTRA_NATIVE_MATERIAL_INFO);
        if (obj != null) {
            try {
                intFromMap3 = BaiduATInitManager.getIntFromMap((Map) obj, j.w.z, 0);
            } catch (Throwable unused) {
            }
        }
        if (intFromMap3 > 0 && intFromMap3 <= 7) {
            linkedHashMap.put(d, Integer.valueOf(intFromMap3));
        } else {
            linkedHashMap.put(d, 7);
        }
        a((Map<String, Object>) linkedHashMap, true);
        return linkedHashMap;
    }

    private static LinkedHashMap<String, Object> a(String str, Map<String, Object> map) {
        int iA;
        int intFromMap;
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>(8);
        int intFromMap2 = BaiduATInitManager.getIntFromMap(map, "adn_id");
        int intFromMap3 = BaiduATInitManager.getIntFromMap(map, ATBiddingNotice.ADN_EXTRA_NW_FIRM_ID, 0);
        int i = 1;
        if (intFromMap3 > 0) {
            iA = a(intFromMap3);
        } else {
            iA = (intFromMap2 == 1 || intFromMap2 == 2) ? 9 : 10;
        }
        str.hashCode();
        if (str.equals("102")) {
            i = 3;
        } else if (!str.equals("103")) {
            i = 4;
        }
        linkedHashMap.put("adn", Integer.valueOf(iA));
        linkedHashMap.put(e, Long.valueOf(System.currentTimeMillis() / 1000));
        linkedHashMap.put(f, Integer.valueOf(i));
        linkedHashMap.put("is_s", 2);
        linkedHashMap.put(h, 2);
        Object obj = map.get(ATBiddingNotice.ADN_EXTRA_NATIVE_MATERIAL_INFO);
        if (obj != null) {
            try {
                intFromMap = BaiduATInitManager.getIntFromMap((Map) obj, j.w.z, 0);
            } catch (Throwable unused) {
                intFromMap = 0;
            }
        } else {
            intFromMap = 0;
        }
        if (intFromMap > 0 && intFromMap <= 7) {
            linkedHashMap.put(d, Integer.valueOf(intFromMap));
        } else {
            linkedHashMap.put(d, 7);
        }
        a((Map<String, Object>) linkedHashMap, false);
        return linkedHashMap;
    }

    private static void a(Map<String, Object> map, boolean z) {
        if (map.size() != 0 && ATSDK.isNetworkLogDebug()) {
            for (String str : map.keySet()) {
                Object[] objArr = new Object[3];
                Boolean.valueOf(z);
                map.get(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        if (ATSDK.isNetworkLogDebug()) {
            Log.d("BaiduATBiddingNotice", str);
        }
    }
}
