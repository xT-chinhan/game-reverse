package com.anythink.core.b.d;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ac;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.aw;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.cd;
import com.anythink.core.common.v.ah;
import com.anythink.core.common.v.k;
import com.anythink.core.common.v.p;
import com.anythink.core.common.v.q;
import com.anythink.core.d.d;
import com.kwad.sdk.api.model.AdnName;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {
    static final String a = "a";

    private static int a(boolean z, int i, int i2) {
        if (i == i2) {
            return !z ? 1 : 4;
        }
        return (i == 67 || i == 35) ? 3 : 2;
    }

    private static String a(int i) {
        return i == 2 ? "102" : ErrorCode.networkError;
    }

    public static String a(boolean z, int i) {
        if (i == 3) {
            return "-1";
        }
        if (i == 1) {
            return "5";
        }
        if (i == 4) {
            return "2";
        }
        if (i == 6) {
            return ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_FLOOR;
        }
        return z ? "102" : "103";
    }

    public static String a(boolean z, int i, int i2, boolean z2) {
        if (i == 3) {
            return "-1";
        }
        if (i2 == 8) {
            return i == 1 ? "5" : "1";
        }
        if (i2 == 29) {
            return i == 1 ? ErrorCode.adapterNotExistError : "2";
        }
        if (i2 == 34) {
            return i == 2 ? "102" : ErrorCode.networkError;
        }
        if (i2 == 59) {
            return "102";
        }
        if (i2 == 39) {
            return i == 6 ? "103" : "102";
        }
        if (z2) {
            return "103";
        }
        if (i == 1) {
            return "2";
        }
        if (i == 5) {
            return "1";
        }
        return z ? "102" : "103";
    }

    private static int b(boolean z, int i, int i2) {
        if (i == i2) {
            return !z ? 1 : 2;
        }
        return (i == 67 || i == 35) ? 3 : 4;
    }

    public static String a(ad adVar, cd cdVar, double d, double d2) {
        String str = adVar.winNoticeUrl;
        if (TextUtils.isEmpty(str)) {
            String str2 = adVar.token;
            return null;
        }
        int i = adVar.d;
        String strReplace = str.replace(c.f, a(adVar, d2));
        if (i == 28 || i == 8 || i == 81 || i == 11) {
            strReplace = strReplace.replace(c.b, a(adVar, d));
        } else if (i == 66) {
            strReplace = a(strReplace, a(adVar, cdVar, d2));
        } else if (i == 39) {
            strReplace = strReplace.replace(c.h, String.valueOf(d2)).replace(c.g, a(adVar.b));
        }
        String str3 = adVar.token;
        return strReplace;
    }

    public static String a(ad adVar, aw awVar, int i, boolean z, double d, double d2, String str, Map<String, Object> map) {
        String strReplace;
        bv bvVarA;
        double dMax = d2;
        int i2 = adVar.d;
        String str2 = adVar.loseNoticeUrl;
        int i3 = 1;
        if (TextUtils.isEmpty(str2)) {
            String str3 = adVar.token;
            if (awVar != null) {
                str2 = i2 == 8 ? ah.a("kwwsv=22zlq1jgw1tt1frp2zlqbqrwlfh1ifj") + "?viewid=&position_id=" + awVar.C() + "&loss=${AUCTION_LOSS}&win_price=${AUCTION_PRICE}&server_bidding_type=1&win_seat=${AUCTION_SEAT_ID}&mrqid=" + awVar.i() + "&meSrc=299" : "";
            }
            Object[] objArr = new Object[1];
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
        }
        String strReplace2 = str2.replace(c.b, a(adVar, d)).replace(c.c, b(adVar, d)).replace(c.d, str);
        if (i2 == 8) {
            if (i != i2) {
                i3 = (i == 67 || i == 35) ? 3 : 2;
            } else if (z) {
                i3 = 4;
            }
            strReplace = strReplace2.replace(c.e, String.valueOf(i3));
        } else if (i2 == 29) {
            strReplace = strReplace2.replace(c.e, i2 == i ? "1" : "10001");
        } else {
            strReplace = strReplace2.replace(c.e, "");
        }
        if (i2 == 6) {
            strReplace = strReplace.replace(c.g, ATAdConst.CURRENCY.USD.toString());
        } else if (i2 == 39) {
            strReplace = strReplace.replace(c.d, str).replace(c.g, a(adVar.b));
        }
        if (i2 == 66) {
            strReplace = a(strReplace, a(adVar, awVar, d, str));
        }
        if (i2 == 28 && map != null) {
            strReplace = a(strReplace, map, adVar, d);
        }
        if (i2 == 65) {
            bv bvVarA2 = c.a(adVar);
            if (bvVarA2 != null) {
                dMax = Math.max(dMax, p.a(bvVarA2));
            } else if (awVar != null && (bvVarA = awVar.A()) != null && bvVarA.ar() > 0.0d) {
                dMax = Math.max(dMax, bvVarA.ar());
            }
            if (dMax != 0.0d) {
                double d3 = 0.01d + dMax;
                if (d3 < d) {
                    dMax = d3;
                }
                strReplace = strReplace.replace(c.f, String.valueOf(dMax));
            }
        }
        String str4 = adVar.token;
        return strReplace;
    }

    private static String a(String str, Map<String, Object> map, ad adVar, double d) {
        try {
            String strA = a(adVar, d);
            String strReplace = str.replace(c.s, strA).replace(c.t, strA);
            int iA = q.a(map, "adn_id", -1);
            int i = 1;
            if (iA != 1 && iA != 2) {
                i = 3;
                if (iA == 3 || iA == 4) {
                    i = 2;
                }
            }
            String strReplace2 = strReplace.replace(c.l, String.valueOf(i));
            String str2 = AdnName.OTHER;
            int iA2 = q.a(map, ATBiddingNotice.ADN_EXTRA_NW_FIRM_ID, 0);
            if (iA2 > 0) {
                if (iA2 == 15) {
                    str2 = AdnName.CHUANSHANJIA;
                } else if (iA2 == 22) {
                    str2 = "baidu";
                }
            }
            String strReplace3 = strReplace2.replace(c.m, str2);
            Object obj = map.get(ATBiddingNotice.ADN_EXTRA_NATIVE_MATERIAL_INFO);
            if (obj != null) {
                try {
                    String strA2 = q.a((Map<String, Object>) obj, j.w.A, "");
                    if (!TextUtils.isEmpty(strA2)) {
                        strReplace3 = strReplace3.replace(c.o, strA2);
                    }
                    String strA3 = q.a((Map<String, Object>) obj, j.w.B, "");
                    if (!TextUtils.isEmpty(strA3)) {
                        strReplace3 = strReplace3.replace(c.n, strA3);
                    }
                } catch (Throwable unused) {
                }
            }
            String strA4 = q.a(map, ATBiddingNotice.ADN_REQUEST_ID, "");
            if (!TextUtils.isEmpty(strA4)) {
                strReplace3 = strReplace3.replace(c.p, strA4);
            }
            return strReplace3.replace(c.q, String.valueOf(q.a(map, ATBiddingNotice.ADN_REQUEST_IS_SHOW, 2))).replace(c.r, String.valueOf(q.a(map, ATBiddingNotice.ADN_REQUEST_IS_CLICK, 2)));
        } catch (Exception unused2) {
            return str;
        }
    }

    public static String a(ad adVar, double d) {
        int i = adVar.d;
        if (i == 8 || i == 28) {
            return a(i, String.valueOf((int) Math.round(d)));
        }
        if (i == 66 && adVar.j() > 0.0d) {
            return String.valueOf(d / adVar.j());
        }
        return String.valueOf(d);
    }

    private static String b(ad adVar, double d) {
        String strA = a(adVar, d);
        try {
            return String.valueOf((int) Math.round(Double.parseDouble(strA)));
        } catch (Throwable unused) {
            return strA;
        }
    }

    public static Map<String, Object> a(boolean z, int i, int i2, bv bvVar, ad adVar) {
        int i3 = 2;
        HashMap map = new HashMap(2);
        if (i != i2) {
            i3 = (i == 67 || i == 35) ? 3 : 4;
        } else if (!z) {
            i3 = 1;
        }
        map.put("adn_id", Integer.valueOf(i3));
        a(map, adVar);
        a(map, i2, i, bvVar);
        Object[] objArr = new Object[3];
        Boolean.valueOf(z);
        Integer.valueOf(i);
        Integer.valueOf(i2);
        return map;
    }

    private static void a(Map<String, Object> map, ad adVar) {
        if (adVar != null) {
            try {
                String originRequestId = adVar.getOriginRequestId();
                if (TextUtils.isEmpty(originRequestId)) {
                    return;
                }
                map.put(ATBiddingNotice.ADN_REQUEST_ID, originRequestId);
                List<ac> list = adVar.u;
                if (list == null || list.isEmpty()) {
                    return;
                }
                for (int i = 0; i < list.size(); i++) {
                    ac acVar = list.get(i);
                    if (acVar != null && acVar.c().equals(originRequestId)) {
                        int i2 = 1;
                        map.put(ATBiddingNotice.ADN_REQUEST_IS_SHOW, Integer.valueOf(acVar.f() ? 1 : 0));
                        if (!acVar.g()) {
                            i2 = 0;
                        }
                        map.put(ATBiddingNotice.ADN_REQUEST_IS_CLICK, Integer.valueOf(i2));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void a(Map<String, Object> map, int i, int i2, bv bvVar) {
        com.anythink.core.d.b bVarB = d.a(t.b().g()).b(t.b().p());
        if (bVarB == null || bVarB.c() == null || !bVarB.c().contains(Integer.valueOf(i)) || i2 == 8) {
            return;
        }
        map.put(ATBiddingNotice.ADN_EXTRA_NW_FIRM_ID, Integer.valueOf(i2));
        if (bvVar != null) {
            map.put(ATBiddingNotice.ADN_EXTRA_NATIVE_MATERIAL_INFO, bvVar.aX());
        }
    }

    public static Map<String, Object> a(int i, bv bvVar) {
        HashMap map = new HashMap(2);
        if (bvVar != null) {
            int iG = bvVar.g();
            int i2 = iG == i ? 5 : 6;
            int i3 = bvVar.o() ? 101 : 100;
            map.put("adn_id", Integer.valueOf(i2));
            map.put(ATBiddingNotice.ADN_TYPE, Integer.valueOf(i3));
            a(map, i, iG, bvVar);
        }
        Object[] objArr = new Object[2];
        Integer.valueOf(i);
        return map;
    }

    public static Map<String, Object> a(ad adVar, cd cdVar, double d) {
        HashMap map = new HashMap();
        map.put(c.f, a(adVar, d));
        String strB = cdVar.b();
        if (!TextUtils.isEmpty(strB)) {
            map.put(c.i, strB);
        } else {
            map.put(c.i, "");
        }
        return map;
    }

    public static Map<String, Object> a(ad adVar, aw awVar, double d, String str) {
        HashMap map = new HashMap();
        map.put(c.b, a(adVar, d));
        map.put(c.c, b(adVar, d));
        map.put(c.d, str);
        String strD = awVar.d();
        if (!TextUtils.isEmpty(strD)) {
            map.put(c.i, strD);
        } else {
            map.put(c.i, "");
        }
        map.put(c.j, TextUtils.equals(str, "1") ? "900" : TextUtils.equals(str, "2") ? "203" : (TextUtils.equals(str, "102") || TextUtils.equals(str, "103")) ? "203" : "900");
        map.put(c.k, Long.valueOf(System.currentTimeMillis() / 1000));
        return map;
    }

    private static String a(String str, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                str = str.replace(entry.getKey(), entry.getValue().toString());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return str;
    }

    private static String a(String str) {
        return ATAdConst.CURRENCY.RMB.toString().equalsIgnoreCase(str) ? j.C0079j.b : j.C0079j.a;
    }

    public static String a(int i, String str) {
        String strEncode;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strB = i == 8 ? k.b("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZ3d0RRWUpLb1pJaHZjTkFRRUJCUUFEU3dBd1NBSkJBTGpNVCt3QTZEdVViaGZvYTZ5MDQ4czVNWFcrOEY2bgpxNkxzb2FaMWNDdVJ0MDhLU0ZoZ3kwYmp3dWpLVkxLeW1nUVJRUWFGUkhFamF2aTNXd28vUG9jQ0F3RUFBUT09Ci0tLS0tRU5EIFBVQkxJQyBLRVktLS0tLQ==") : "";
        if (TextUtils.isEmpty(strB)) {
            return str;
        }
        try {
            Object[] objArr = new Object[1];
            strEncode = URLEncoder.encode(com.anythink.core.common.q.a.a(strB, str, false).a());
            try {
                Object[] objArr2 = new Object[1];
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            strEncode = null;
        }
        return !TextUtils.isEmpty(strEncode) ? strEncode : str;
    }

    private static String b(int i) {
        return i == 8 ? k.b("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZ3d0RRWUpLb1pJaHZjTkFRRUJCUUFEU3dBd1NBSkJBTGpNVCt3QTZEdVViaGZvYTZ5MDQ4czVNWFcrOEY2bgpxNkxzb2FaMWNDdVJ0MDhLU0ZoZ3kwYmp3dWpLVkxLeW1nUVJRUWFGUkhFamF2aTNXd28vUG9jQ0F3RUFBUT09Ci0tLS0tRU5EIFBVQkxJQyBLRVktLS0tLQ==") : "";
    }

    private static String a(int i, String str, String str2) {
        return i == 8 ? ah.a("kwwsv=22zlq1jgw1tt1frp2zlqbqrwlfh1ifj") + "?viewid=&position_id=" + str + "&loss=${AUCTION_LOSS}&win_price=${AUCTION_PRICE}&server_bidding_type=1&win_seat=${AUCTION_SEAT_ID}&mrqid=" + str2 + "&meSrc=299" : "";
    }
}
