package com.anythink.core.common.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.NoticeUtils;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.u.ai;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class q {
    public static final String a = "anythink_notice_handler";

    public static void a(com.anythink.core.common.f fVar, String str, Map<String, Object> map) {
        try {
            com.anythink.core.common.h.n nVarA = a(str, fVar);
            if (nVarA != null) {
                if (ATSDK.isNetworkLogDebug()) {
                    Log.i(a, "notifyWin, placementId: " + str + ", extra: " + map);
                }
                if (map != null) {
                    Object obj = map.get("second_price");
                    if (obj instanceof Double) {
                        nVarA.b(((Double) obj).doubleValue());
                    }
                    Object obj2 = map.get("bidding_name");
                    if (obj2 instanceof String) {
                        nVarA.b((String) obj2);
                    }
                    Object obj3 = map.get(NoticeUtils.ORIGIN_ILRD);
                    if (obj3 instanceof String) {
                        nVarA.c((String) obj3);
                    }
                    Object obj4 = map.get("waterfall_info");
                    if (obj4 instanceof String) {
                        com.anythink.core.common.d.a().a(str, (String) obj4);
                    }
                }
                com.anythink.core.common.t.e.a(s.b().g());
                com.anythink.core.common.t.e.a(22, nVarA);
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(com.anythink.core.common.f fVar, String str, Map<String, Object> map) {
        try {
            com.anythink.core.common.h.n nVarA = a(str, fVar);
            if (nVarA != null) {
                if (map != null) {
                    String str2 = (String) map.get(NoticeUtils.LOSS_REASON);
                    Object obj = map.get(NoticeUtils.WINNER_PRICE);
                    double dDoubleValue = obj != null ? ((Double) obj).doubleValue() : -1.0d;
                    if (ATSDK.isNetworkLogDebug()) {
                        Log.i(a, "notifyLoss, placementId: " + str + ", lossCode: " + str2 + ", winnerPrice: " + dDoubleValue + ", extra: " + map);
                    }
                    nVarA.a(dDoubleValue);
                    try {
                        nVarA.c(Integer.parseInt(str2));
                    } catch (Throwable unused) {
                    }
                    Object obj2 = map.get("bidding_name");
                    if (obj2 instanceof String) {
                        nVarA.a((String) obj2);
                    }
                    Object obj3 = map.get(NoticeUtils.ORIGIN_ILRD);
                    if (obj3 instanceof String) {
                        nVarA.c((String) obj3);
                    }
                    Object obj4 = map.get("waterfall_info");
                    if (obj4 instanceof String) {
                        com.anythink.core.common.d.a().a(str, (String) obj4);
                    }
                }
                com.anythink.core.common.t.e.a(s.b().g());
                com.anythink.core.common.t.e.a(23, nVarA);
            }
            fVar.i();
        } catch (Throwable unused2) {
        }
    }

    private static com.anythink.core.common.h.n a(String str, com.anythink.core.common.f fVar) {
        if (!s.b().d) {
            Log.e(a, "SDK should be inited first!");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(a, "Please put placementId!");
            return null;
        }
        if (fVar == null) {
            Log.e(a, "The \"" + str + "\" object has not been created yet!");
            return null;
        }
        Context contextG = s.b().g();
        com.anythink.core.common.h.c cVarA = fVar.a(contextG, false, false, (ae) null);
        if (cVarA != null) {
            return cVarA.i().ah();
        }
        com.anythink.core.e.l lVarA = com.anythink.core.e.n.a(contextG).a(str);
        String strM = fVar.m();
        if (TextUtils.isEmpty(strM)) {
            strM = "";
        }
        com.anythink.core.common.h.n nVarA = ai.a(strM, str, lVarA, 0, 0, null, null, 0, fVar.n(), fVar);
        if (lVarA != null) {
            return nVarA;
        }
        nVarA.K(fVar.b());
        return nVarA;
    }
}
