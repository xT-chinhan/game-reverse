package com.anythink.core.common.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.NoticeUtils;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.v.aj;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class r {
    public static final String a = "anythink_notice_handler";

    public static void a(String str, String str2, Map<String, Object> map) {
        try {
            com.anythink.core.common.h.n nVarA = a(str, str2);
            if (nVarA != null) {
                if (ATSDK.isNetworkLogDebug()) {
                    Log.i(a, "notifyWin, placementId: " + str + ", format: " + str2 + ", extra: " + map);
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
                com.anythink.core.common.u.c.a(t.b().g()).a(22, nVarA);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, String str3, double d, Map<String, Object> map) {
        try {
            com.anythink.core.common.h.n nVarA = a(str, str2);
            if (nVarA != null) {
                if (ATSDK.isNetworkLogDebug()) {
                    Log.i(a, "notifyLoss, placementId: " + str + ", format: " + str2 + ", lossCode: " + str3 + ", winnerPrice: " + d + ", extra: " + map);
                }
                if (map != null) {
                    nVarA.a(d);
                    try {
                        nVarA.c(Integer.parseInt(str3));
                    } catch (Throwable unused) {
                    }
                    Object obj = map.get("bidding_name");
                    if (obj instanceof String) {
                        nVarA.a((String) obj);
                    }
                    Object obj2 = map.get(NoticeUtils.ORIGIN_ILRD);
                    if (obj2 instanceof String) {
                        nVarA.c((String) obj2);
                    }
                    Object obj3 = map.get("waterfall_info");
                    if (obj3 instanceof String) {
                        com.anythink.core.common.d.a().a(str, (String) obj3);
                    }
                }
                com.anythink.core.common.u.c.a(t.b().g()).a(23, nVarA);
            }
            com.anythink.core.common.f fVarA = com.anythink.core.common.f.a(t.b().g(), str, str2);
            if (fVarA != null) {
                fVarA.d();
            }
        } catch (Throwable unused2) {
        }
    }

    private static com.anythink.core.common.h.n a(String str, String str2) {
        if (!t.b().d) {
            Log.e(a, "SDK should be inited first!");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(a, "Please put placementId!");
            return null;
        }
        com.anythink.core.common.f fVarA = com.anythink.core.common.u.a().a(str, str2);
        if (fVarA == null) {
            Log.e(a, "The \"" + str + "\" object has not been created yet!");
            return null;
        }
        Context contextG = t.b().g();
        com.anythink.core.common.h.c cVarA = fVarA.a(contextG, false, false, (ae) null);
        if (cVarA != null) {
            return cVarA.i().af();
        }
        com.anythink.core.d.l lVarA = com.anythink.core.d.n.a(contextG).a(str);
        String strH = fVarA.h();
        if (TextUtils.isEmpty(strH)) {
            strH = "";
        }
        com.anythink.core.common.h.n nVarA = aj.a(strH, str, lVarA, 0, 0, null, null, 0, fVarA.i());
        if (lVarA != null) {
            return nVarA;
        }
        nVarA.K(str2);
        return nVarA;
    }
}
