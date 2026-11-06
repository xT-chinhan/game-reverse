package com.anythink.core.c.d;

import android.util.Pair;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdFilter;
import com.anythink.core.api.ATSDKUtils;
import com.anythink.core.api.ATWaterfallFilter;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.by;
import com.anythink.core.common.t.f;
import com.anythink.core.common.u.aj;
import com.anythink.core.common.u.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String a = "b";

    public static void a(JSONObject jSONObject, String str, by byVar, com.anythink.core.common.h.a aVar) {
        if (jSONObject != null) {
            try {
                if (byVar.ak() == -1) {
                    jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.FORMAT, str);
                } else {
                    jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.FORMAT, String.valueOf(byVar.ak()));
                }
                jSONObject.put("ad_source_id", byVar.G());
                jSONObject.put("nw_firm_id", byVar.n());
                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BIDDING_FLOOR, a(aVar, byVar));
                if (s.b().z()) {
                    jSONObject.put("test", 1);
                }
                jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.P_BIDFLOOR, byVar.aq());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00ac A[Catch: all -> 0x011e, TryCatch #1 {all -> 0x011e, blocks: (B:18:0x0052, B:20:0x0058, B:22:0x0060, B:24:0x0066, B:26:0x0070, B:28:0x0078, B:30:0x007e, B:32:0x0092, B:34:0x009c, B:36:0x00a4, B:55:0x00e1, B:58:0x00f1, B:60:0x00f5, B:61:0x00fa, B:63:0x00fe, B:39:0x00ac, B:41:0x00b6, B:43:0x00be, B:46:0x00c5, B:48:0x00cf, B:50:0x00d7), top: B:89:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b6 A[Catch: all -> 0x011e, TryCatch #1 {all -> 0x011e, blocks: (B:18:0x0052, B:20:0x0058, B:22:0x0060, B:24:0x0066, B:26:0x0070, B:28:0x0078, B:30:0x007e, B:32:0x0092, B:34:0x009c, B:36:0x00a4, B:55:0x00e1, B:58:0x00f1, B:60:0x00f5, B:61:0x00fa, B:63:0x00fe, B:39:0x00ac, B:41:0x00b6, B:43:0x00be, B:46:0x00c5, B:48:0x00cf, B:50:0x00d7), top: B:89:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00c5 A[Catch: all -> 0x011e, TryCatch #1 {all -> 0x011e, blocks: (B:18:0x0052, B:20:0x0058, B:22:0x0060, B:24:0x0066, B:26:0x0070, B:28:0x0078, B:30:0x007e, B:32:0x0092, B:34:0x009c, B:36:0x00a4, B:55:0x00e1, B:58:0x00f1, B:60:0x00f5, B:61:0x00fa, B:63:0x00fe, B:39:0x00ac, B:41:0x00b6, B:43:0x00be, B:46:0x00c5, B:48:0x00cf, B:50:0x00d7), top: B:89:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00cf A[Catch: all -> 0x011e, TryCatch #1 {all -> 0x011e, blocks: (B:18:0x0052, B:20:0x0058, B:22:0x0060, B:24:0x0066, B:26:0x0070, B:28:0x0078, B:30:0x007e, B:32:0x0092, B:34:0x009c, B:36:0x00a4, B:55:0x00e1, B:58:0x00f1, B:60:0x00f5, B:61:0x00fa, B:63:0x00fe, B:39:0x00ac, B:41:0x00b6, B:43:0x00be, B:46:0x00c5, B:48:0x00cf, B:50:0x00d7), top: B:89:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00d7 A[Catch: all -> 0x011e, TryCatch #1 {all -> 0x011e, blocks: (B:18:0x0052, B:20:0x0058, B:22:0x0060, B:24:0x0066, B:26:0x0070, B:28:0x0078, B:30:0x007e, B:32:0x0092, B:34:0x009c, B:36:0x00a4, B:55:0x00e1, B:58:0x00f1, B:60:0x00f5, B:61:0x00fa, B:63:0x00fe, B:39:0x00ac, B:41:0x00b6, B:43:0x00be, B:46:0x00c5, B:48:0x00cf, B:50:0x00d7), top: B:89:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00ef  */
    private static Pair<Double, ATWaterfallFilter.PriceInterval> b(com.anythink.core.common.h.a aVar, by byVar) {
        double d;
        ATWaterfallFilter.PriceInterval priceInterval;
        ATAdFilter aTAdFilter;
        Stack<Map<String, Object>> stack;
        Object obj;
        Object obj2;
        boolean z;
        List list;
        List list2;
        double rmbChangeToUsdRate;
        double d2;
        try {
            Map<String, ATAdFilter> mapZ = s.b().Z();
            if (mapZ != null && !mapZ.isEmpty() && (aTAdFilter = mapZ.get(aVar.e)) != null && (stack = aTAdFilter.getStack()) != null && !stack.isEmpty()) {
                String strValueOf = String.valueOf(byVar.n());
                String strValueOf2 = String.valueOf(o.e(byVar.k()));
                String strA = aj.a(byVar, null);
                ArrayList arrayList = new ArrayList(stack);
                d = 0.0d;
                priceInterval = null;
                for (int i = 0; i < arrayList.size(); i++) {
                    try {
                        Map map = (Map) arrayList.get(i);
                        if (map != null && !map.isEmpty()) {
                            Object obj3 = map.get(ATAdFilter.KEY_E_CPM);
                            if (obj3 instanceof ATWaterfallFilter.PriceInterval) {
                                ATWaterfallFilter.PriceInterval priceInterval2 = (ATWaterfallFilter.PriceInterval) obj3;
                                if (priceInterval2.getLessPrice() != null && (priceInterval2.getMorePrice() == null || priceInterval2.getLessPrice().doubleValue() >= priceInterval2.getMorePrice().doubleValue())) {
                                    Object obj4 = map.get(ATAdFilter.KEY_NETWORK_ID);
                                    if (obj4 instanceof List) {
                                        List list3 = (List) obj4;
                                        if (list3.isEmpty() || list3.contains(strValueOf)) {
                                            obj = map.get(ATAdFilter.KEY_BIDDING_TYPE);
                                            if (obj instanceof List) {
                                                list2 = (List) obj;
                                                if (!list2.isEmpty() || list2.contains(strValueOf2)) {
                                                    obj2 = map.get(ATAdFilter.KEY_NETWORK_PLACEMENT_ID);
                                                    if (obj2 instanceof List) {
                                                        list = (List) obj2;
                                                        if (!list.isEmpty() || list.contains(strA)) {
                                                        }
                                                    }
                                                    z = true;
                                                }
                                                z = false;
                                            } else {
                                                obj2 = map.get(ATAdFilter.KEY_NETWORK_PLACEMENT_ID);
                                                if (obj2 instanceof List) {
                                                    list = (List) obj2;
                                                    if (!list.isEmpty()) {
                                                    }
                                                }
                                                z = true;
                                            }
                                        } else {
                                            z = false;
                                        }
                                    } else {
                                        obj = map.get(ATAdFilter.KEY_BIDDING_TYPE);
                                        if (obj instanceof List) {
                                            list2 = (List) obj;
                                            if (!list2.isEmpty()) {
                                                obj2 = map.get(ATAdFilter.KEY_NETWORK_PLACEMENT_ID);
                                                if (obj2 instanceof List) {
                                                    list = (List) obj2;
                                                    if (!list.isEmpty()) {
                                                    }
                                                }
                                                z = true;
                                            } else {
                                                obj2 = map.get(ATAdFilter.KEY_NETWORK_PLACEMENT_ID);
                                                if (obj2 instanceof List) {
                                                    list = (List) obj2;
                                                    if (!list.isEmpty()) {
                                                    }
                                                }
                                                z = true;
                                            }
                                        } else {
                                            obj2 = map.get(ATAdFilter.KEY_NETWORK_PLACEMENT_ID);
                                            if (obj2 instanceof List) {
                                                list = (List) obj2;
                                                if (!list.isEmpty()) {
                                                }
                                            }
                                            z = true;
                                        }
                                    }
                                    if (z) {
                                        double dDoubleValue = priceInterval2.getLessPrice().doubleValue();
                                        ATAdConst.CURRENCY scurrency = priceInterval2.getScurrency();
                                        if (scurrency != null) {
                                            if (scurrency == ATAdConst.CURRENCY.RMB) {
                                                rmbChangeToUsdRate = ATSDKUtils.getRmbChangeToUsdRate();
                                            } else {
                                                rmbChangeToUsdRate = scurrency == ATAdConst.CURRENCY.RMB_CENT ? ATSDKUtils.getRmbChangeToUsdRate() / 100.0d : 1.0d;
                                            }
                                            if (rmbChangeToUsdRate == 0.0d) {
                                                d2 = 0.0d;
                                            } else {
                                                d2 = dDoubleValue * rmbChangeToUsdRate;
                                            }
                                        } else {
                                            d2 = 0.0d;
                                        }
                                        if (d2 > 0.0d && d2 > d) {
                                            priceInterval = priceInterval2;
                                            d = d2;
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                    }
                }
                if (d > 0.0d) {
                    return new Pair<>(Double.valueOf(d), priceInterval);
                }
                return null;
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            d = 0.0d;
            priceInterval = null;
        }
    }

    private static boolean a(Map<String, Object> map, String str, String str2, String str3) {
        Object obj = map.get(ATAdFilter.KEY_NETWORK_ID);
        if (obj instanceof List) {
            List list = (List) obj;
            if (!list.isEmpty() && !list.contains(str)) {
                return false;
            }
        }
        Object obj2 = map.get(ATAdFilter.KEY_BIDDING_TYPE);
        if (obj2 instanceof List) {
            List list2 = (List) obj2;
            if (!list2.isEmpty() && !list2.contains(str2)) {
                return false;
            }
        }
        Object obj3 = map.get(ATAdFilter.KEY_NETWORK_PLACEMENT_ID);
        if (!(obj3 instanceof List)) {
            return true;
        }
        List list3 = (List) obj3;
        return list3.isEmpty() || list3.contains(str3);
    }

    private static double a(double d, ATAdConst.CURRENCY currency) {
        double rmbChangeToUsdRate;
        if (currency == null) {
            return 0.0d;
        }
        if (currency == ATAdConst.CURRENCY.RMB) {
            rmbChangeToUsdRate = ATSDKUtils.getRmbChangeToUsdRate();
        } else {
            rmbChangeToUsdRate = currency == ATAdConst.CURRENCY.RMB_CENT ? ATSDKUtils.getRmbChangeToUsdRate() / 100.0d : 1.0d;
        }
        if (rmbChangeToUsdRate == 0.0d) {
            return 0.0d;
        }
        return d * rmbChangeToUsdRate;
    }

    public static double a(com.anythink.core.common.h.a aVar, by byVar) {
        if (aVar.t == 8) {
            Double d = aVar.u != null ? aVar.u.get(byVar.G()) : null;
            if (d == null) {
                return 0.0d;
            }
            double dDoubleValue = d.doubleValue();
            byVar.d(dDoubleValue);
            return dDoubleValue;
        }
        double dAz = byVar.az();
        if (aVar.C > 0.0d && byVar.ba() == 1) {
            double dMax = Math.max(dAz, aVar.C);
            byVar.d(dMax);
            return dMax;
        }
        Pair<Double, ATWaterfallFilter.PriceInterval> pairB = b(aVar, byVar);
        if (pairB == null) {
            return dAz;
        }
        double dDoubleValue2 = ((Double) pairB.first).doubleValue();
        byVar.d(dDoubleValue2);
        f.a(aVar.s, byVar, (ATWaterfallFilter.PriceInterval) pairB.second);
        return dDoubleValue2;
    }
}
