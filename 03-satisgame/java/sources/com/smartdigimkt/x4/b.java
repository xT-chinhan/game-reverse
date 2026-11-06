package com.smartdigimkt.x4;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.SDMAdRequest;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.smartdigimkt.v4.c {
    public static void f(com.smartdigimkt.v4.a aVar) {
        com.smartdigimkt.h3.b bVar = aVar.x;
        if (bVar == null || bVar.a("offer")) {
            return;
        }
        bVar.a("resource");
    }

    /* JADX WARN: Code duplicated, block: B:160:0x03ba A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:161:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:164:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:166:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:168:0x03f5  */
    /* JADX WARN: Code duplicated, block: B:174:0x0405  */
    /* JADX WARN: Code duplicated, block: B:177:0x040d  */
    /* JADX WARN: Code duplicated, block: B:180:0x0423  */
    /* JADX WARN: Code duplicated, block: B:182:0x0429 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:183:0x042b  */
    /* JADX WARN: Code duplicated, block: B:185:0x042e  */
    /* JADX WARN: Code duplicated, block: B:187:0x0431  */
    /* JADX WARN: Code duplicated, block: B:189:0x0434  */
    /* JADX WARN: Code duplicated, block: B:191:0x0437  */
    /* JADX WARN: Code duplicated, block: B:192:0x0439  */
    /* JADX WARN: Code duplicated, block: B:193:0x0441  */
    /* JADX WARN: Code duplicated, block: B:194:0x0449  */
    /* JADX WARN: Code duplicated, block: B:195:0x0451  */
    /* JADX WARN: Code duplicated, block: B:196:0x0459  */
    /* JADX WARN: Code duplicated, block: B:198:0x0462 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:199:0x0464  */
    /* JADX WARN: Code duplicated, block: B:200:0x0469  */
    /* JADX WARN: Code duplicated, block: B:202:0x046c  */
    /* JADX WARN: Code duplicated, block: B:222:0x0535 A[Catch: all -> 0x0542, TRY_LEAVE, TryCatch #0 {all -> 0x0542, blocks: (B:214:0x04d1, B:216:0x04d5, B:218:0x04dd, B:221:0x04e8, B:222:0x0535), top: B:235:0x04d1 }] */
    /* JADX WARN: Code duplicated, block: B:226:0x0555  */
    /* JADX WARN: Code duplicated, block: B:227:0x0575  */
    /* JADX WARN: Code duplicated, block: B:229:0x0583  */
    /* JADX WARN: Code duplicated, block: B:230:0x0585  */
    @Override // com.smartdigimkt.v4.c
    public final boolean b(com.smartdigimkt.v4.a aVar) {
        String str;
        Map map;
        String str2;
        com.smartdigimkt.e1.e eVar;
        boolean z;
        com.smartdigimkt.e1.d gVar;
        Map<String, Object> map2;
        com.smartdigimkt.e1.b bVar;
        Map map3;
        com.smartdigimkt.a3.a aVar2;
        String strA;
        com.smartdigimkt.p4.a aVarA;
        HashMap map4;
        JSONArray jSONArrayA;
        int adHeight;
        int i;
        com.smartdigimkt.e1.e eVar2;
        int iJ;
        int iK;
        int adHeight2;
        int i2;
        char c;
        Object obj;
        boolean z2;
        int iIntValue;
        com.smartdigimkt.h3.b bVar2 = aVar.x;
        if (bVar2 != null) {
            bVar2.d("offer");
        }
        com.smartdigimkt.r4.w.a(aVar.v, "request", "start", "");
        SDMAdRequest sDMAdRequest = aVar.b;
        int i3 = aVar.c;
        com.smartdigimkt.a3.a aVar3 = aVar.p;
        com.smartdigimkt.d3.c cVar = aVar.r;
        if (cVar == null) {
            str = "bidding result is null";
        } else if (aVar.n == null) {
            str = "place strategy is null";
        } else if (aVar.o == null) {
            str = "unit group info is null";
        } else {
            str = aVar3 == null ? "ad request info is null" : "";
        }
        String str3 = "10010";
        if (!TextUtils.isEmpty(str)) {
            aVar.a(com.smartdigimkt.z3.b.a("10010", "load fail:".concat(str)));
            f(aVar);
            return false;
        }
        if (cVar != null && !cVar.a) {
            aVar.a(com.smartdigimkt.z3.b.a("10008", "bidding fail:" + cVar.f));
            f(aVar);
            return false;
        }
        com.smartdigimkt.t2.e eVarA = com.smartdigimkt.t2.e.a();
        String str4 = aVar.e;
        eVarA.getClass();
        com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t2.a(eVarA, str4, cVar));
        com.smartdigimkt.r4.b0.a(aVar.v, aVar);
        com.smartdigimkt.n3.e.a(SDKContext.getInstance().d()).a(1, aVar.v, -1L);
        com.smartdigimkt.p4.g gVar2 = aVar.o;
        if (!TextUtils.equals(cVar.A, gVar2.r)) {
            aVar.a(com.smartdigimkt.z3.b.a("10008", "bidding fail:bid result adsource(" + cVar.A + ") id not match unitgroup adsource(" + gVar2.r + ")"));
            f(aVar);
            return false;
        }
        if (aVar.a()) {
            map = gVar2.e;
            Map<String, Object> extraMap = sDMAdRequest != null ? sDMAdRequest.getExtraMap() : null;
            if (map == null || map.isEmpty()) {
                map = (extraMap == null || extraMap.isEmpty()) ? null : extraMap;
            } else if (extraMap != null && !extraMap.isEmpty()) {
                HashMap map5 = new HashMap(map);
                map5.putAll(extraMap);
                map = map5;
            }
        } else {
            map = gVar2.e;
        }
        Context context = aVar.a;
        int i4 = aVar.c;
        String str5 = "1";
        if (map != null && !map.isEmpty()) {
            if (i4 != 0) {
                str2 = "";
                if (i4 == 1) {
                    int iIntValue2 = ((Integer) com.smartdigimkt.r4.k.a(map, "v_m", (Object) 0)).intValue();
                    int iIntValue3 = ((Integer) com.smartdigimkt.r4.k.a(map, "s_c_t", (Object) (-1))).intValue();
                    eVar2 = new com.smartdigimkt.e1.e();
                    eVar2.a = iIntValue2;
                    eVar2.b = iIntValue3;
                    eVar2.c = 0;
                    eVar2.d = null;
                    eVar2.e = 0;
                    eVar2.f = 0;
                    eVar2.g = 0;
                    eVar2.i = 0;
                    eVar2.h = 0;
                    eVar2.j = null;
                    eVar2.k = false;
                    eVar2.l = 0;
                    eVar2.m = null;
                    eVar2.n = null;
                } else if (i4 == 2) {
                    str3 = "10010";
                    String str6 = (String) com.smartdigimkt.r4.k.a(map, "size", com.anythink.core.common.h.y.a);
                    int iIntValue4 = ((Integer) com.smartdigimkt.r4.k.a(map, com.anythink.core.common.k.aN, (Object) 0)).intValue();
                    if (sDMAdRequest != null) {
                        int adWidth = sDMAdRequest.getAdWidth();
                        adHeight2 = sDMAdRequest.getAdHeight();
                        i2 = adWidth;
                    } else {
                        adHeight2 = 0;
                        i2 = 0;
                    }
                    com.smartdigimkt.e1.e eVar3 = new com.smartdigimkt.e1.e();
                    eVar3.a = 0;
                    eVar3.b = 0;
                    eVar3.c = iIntValue4;
                    eVar3.d = str6;
                    eVar3.e = 0;
                    eVar3.f = 0;
                    eVar3.g = 0;
                    eVar3.i = adHeight2;
                    eVar3.h = i2;
                    eVar3.j = null;
                    eVar3.k = false;
                    eVar3.l = 0;
                    eVar3.m = null;
                    eVar3.n = null;
                    bVar2 = bVar2;
                    eVar2 = eVar3;
                } else if (i4 == 3) {
                    int iIntValue5 = ((Integer) com.smartdigimkt.r4.k.a(map, "v_m", (Object) 0)).intValue();
                    int iIntValue6 = ((Integer) com.smartdigimkt.r4.k.a(map, "s_c_t", (Object) (-1))).intValue();
                    String str7 = (String) com.smartdigimkt.r4.k.a(map, com.anythink.core.common.k.aG, "1");
                    if (aVar3 == null || aVar3.k != 67) {
                        c = 0;
                    } else {
                        c = (!(map == gVar2.e && (z2 = gVar2.g)) ? !(!map.containsKey("unit_type") || (obj = map.get("unit_type")) == null || Integer.parseInt(obj.toString()) == 0) : !(!z2 || gVar2.h == 0)) ? (char) 2 : (char) 1;
                    }
                    boolean z3 = c > 0 && c == 1;
                    eVar2 = new com.smartdigimkt.e1.e();
                    eVar2.a = iIntValue5;
                    eVar2.b = iIntValue6;
                    eVar2.c = 0;
                    eVar2.d = null;
                    eVar2.e = 0;
                    eVar2.f = 0;
                    eVar2.g = 0;
                    eVar2.i = 0;
                    eVar2.h = 0;
                    eVar2.j = str7;
                    eVar2.k = z3;
                    eVar2.l = 0;
                    eVar2.m = null;
                    eVar2.n = null;
                } else if (i4 == 4) {
                    int iIntValue7 = ((Integer) com.smartdigimkt.r4.k.a(map, "orientation", (Object) 1)).intValue();
                    int iIntValue8 = ((Integer) com.smartdigimkt.r4.k.a(map, "countdown", (Object) 5)).intValue();
                    int iIntValue9 = ((Integer) com.smartdigimkt.r4.k.a(map, "end_cls", (Object) 1)).intValue();
                    int i5 = (map.containsKey("allows_skip") && (iIntValue = ((Integer) com.smartdigimkt.r4.k.a(map, "allows_skip", (Object) 0)).intValue()) != 0 && iIntValue == 1) ? 0 : 1;
                    eVar2 = new com.smartdigimkt.e1.e();
                    eVar2.a = 0;
                    eVar2.b = 0;
                    eVar2.c = 0;
                    eVar2.d = null;
                    eVar2.e = iIntValue7;
                    eVar2.f = iIntValue8 * 1000;
                    eVar2.g = i5;
                    eVar2.i = 0;
                    eVar2.h = 0;
                    eVar2.j = null;
                    eVar2.k = false;
                    eVar2.l = iIntValue9;
                    eVar2.m = null;
                    eVar2.n = null;
                }
                bVar2 = bVar2;
            } else {
                str2 = "";
                str3 = "10010";
                int iIntValue10 = ((Integer) com.smartdigimkt.r4.k.a(map, com.anythink.core.common.k.aN, (Object) 0)).intValue();
                int iIntValue11 = ((Integer) com.smartdigimkt.r4.k.a(map, "v_m", (Object) 0)).intValue();
                String nativeVideoAutoPlay = (String) com.smartdigimkt.r4.k.a(map, "video_autoplay", "1");
                String strA2 = (map != gVar2.e || TextUtils.isEmpty(gVar2.i)) ? str2 : gVar2.i;
                if (TextUtils.isEmpty(strA2)) {
                    strA2 = com.smartdigimkt.r4.k.a("layout_type", map);
                }
                boolean zEquals = TextUtils.equals("1", strA2);
                if (zEquals) {
                    com.smartdigimkt.x.j.a().getClass();
                    jSONArrayA = com.smartdigimkt.x.j.a(map);
                } else {
                    jSONArrayA = null;
                }
                if (!zEquals) {
                    if (sDMAdRequest != null && !TextUtils.isEmpty(sDMAdRequest.getNativeVideoAutoPlay())) {
                        nativeVideoAutoPlay = sDMAdRequest.getNativeVideoAutoPlay();
                    }
                    iIntValue11 = 0;
                }
                if (sDMAdRequest != null) {
                    int adWidth2 = sDMAdRequest.getAdWidth() != 0 ? sDMAdRequest.getAdWidth() : -1;
                    adHeight = sDMAdRequest.getAdHeight() != 0 ? sDMAdRequest.getAdHeight() : -2;
                    i = adWidth2;
                } else {
                    adHeight = -2;
                    i = -1;
                }
                if (i > 0 && i > (iK = com.smartdigimkt.r4.h.k(context))) {
                    i = iK;
                }
                if (adHeight > 0 && adHeight > (iJ = com.smartdigimkt.r4.h.j(context))) {
                    adHeight = iJ;
                }
                com.smartdigimkt.e1.e eVar4 = new com.smartdigimkt.e1.e();
                eVar4.a = iIntValue11;
                eVar4.b = 0;
                eVar4.c = iIntValue10;
                eVar4.d = null;
                eVar4.e = 0;
                eVar4.f = 0;
                eVar4.g = 0;
                eVar4.i = adHeight;
                eVar4.h = i;
                eVar4.j = null;
                eVar4.k = false;
                eVar4.l = 0;
                eVar4.m = jSONArrayA;
                eVar4.n = nativeVideoAutoPlay;
                eVar2 = eVar4;
            }
            eVar = eVar2;
            aVar.q = eVar;
            if (aVar3 != null) {
                if (i3 != 0) {
                    if (map == gVar2.e || TextUtils.isEmpty(gVar2.i)) {
                        strA = str2;
                    } else {
                        strA = gVar2.i;
                    }
                    if (TextUtils.isEmpty(strA)) {
                        strA = com.smartdigimkt.r4.k.a("layout_type", map);
                    }
                    aVar3.w = TextUtils.equals(str5, strA);
                    aVarA = com.smartdigimkt.o4.e.c().a();
                    if (aVarA != null) {
                        aVar3.v = aVarA.L;
                    }
                } else if (i3 == 4) {
                    Integer num = (Integer) com.smartdigimkt.r4.k.a(map, "orientation", (Object) 1);
                    num.getClass();
                    map4 = new HashMap();
                    map4.put("orientation", num);
                    if (sDMAdRequest != null) {
                        map4.put(ATAdConst.KEY.AD_WIDTH, Integer.valueOf(sDMAdRequest.getAdWidth()));
                        map4.put(ATAdConst.KEY.AD_HEIGHT, Integer.valueOf(sDMAdRequest.getAdHeight()));
                    }
                    aVar3.u = map4;
                }
            }
            if (aVar3 != null) {
                String str8 = str3;
                StringBuilder sb = new StringBuilder("loadContext is not valid param1:true,param2:");
                if (aVar3 != null) {
                    z = true;
                } else {
                    z = false;
                }
                aVar.a(com.smartdigimkt.z3.b.a(str8, sb.append(z).toString()));
                f(aVar);
                return false;
            }
            if (i3 != 0) {
                gVar = new com.smartdigimkt.e1.g(aVar.a, aVar3, gVar2);
            } else if (i3 != 1) {
                gVar = new com.smartdigimkt.e1.h(aVar.a, aVar3, gVar2);
            } else if (i3 != 2) {
                gVar = new com.smartdigimkt.e1.a(aVar.a, aVar3, gVar2);
            } else if (i3 != 3) {
                gVar = new com.smartdigimkt.e1.f(aVar.a, aVar3, gVar2);
            } else if (i3 != 4) {
                gVar = null;
            } else {
                gVar = new com.smartdigimkt.e1.j(aVar.a, aVar3, gVar2);
            }
            if (gVar != null) {
                aVar.a(com.smartdigimkt.z3.b.a(str3, "not support format:" + aVar3.c));
                f(aVar);
                return false;
            }
            if (sDMAdRequest != null) {
                map2 = sDMAdRequest.getCustomEventMap();
            } else {
                map2 = null;
            }
            if (map2 == null) {
                map2 = new HashMap<>();
            }
            gVar.h = map2;
            gVar.a(aVar.q);
            gVar.l = aVar.v;
            bVar = new com.smartdigimkt.e1.b(gVar, new a(this, bVar2, aVar, gVar));
            map3 = gVar.h;
            if (map3 == null && !map3.isEmpty() && ((Integer) com.smartdigimkt.r4.k.a(gVar.h, SDMAdConst.EXTRA_PARAMS.E_L_PARAMS, (Object) 0)).intValue() == 1) {
                boolean zA = gVar.a(gVar.b());
                com.smartdigimkt.i1.a.a(gVar.c, gVar.e, gVar.d);
                if (zA) {
                    bVar.b();
                    return false;
                }
                bVar.a(new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.m, "Cached offer is not ready."));
                return false;
            }
            try {
                aVar2 = gVar.c;
                if (aVar2 != null || TextUtils.isEmpty(aVar2.b) || TextUtils.isEmpty(gVar.c.j)) {
                    bVar.a(new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.i, com.anythink.core.common.inner.b.b.B));
                } else {
                    gVar.m = null;
                    gVar.n = -1;
                    com.smartdigimkt.n3.b bVarA = com.smartdigimkt.n3.b.a();
                    com.smartdigimkt.a3.a aVar4 = gVar.c;
                    bVarA.getClass();
                    String str9 = aVar4.g + "_ " + aVar4.f;
                    com.smartdigimkt.n3.b.a().a(str9).a = System.currentTimeMillis();
                    com.smartdigimkt.f1.d.a(gVar.b).a(gVar.c, gVar.k, gVar.d, new com.smartdigimkt.e1.c(gVar, str9, bVar));
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                bVar.a(new com.smartdigimkt.h0.g("-9999", th.getMessage()));
                return false;
            }
        }
        str2 = "";
        str3 = "10010";
        str5 = "1";
        eVar = null;
        aVar.q = eVar;
        if (aVar3 != null) {
            if (i3 != 0) {
                if (map == gVar2.e) {
                    strA = str2;
                } else {
                    strA = str2;
                }
                if (TextUtils.isEmpty(strA)) {
                    strA = com.smartdigimkt.r4.k.a("layout_type", map);
                }
                aVar3.w = TextUtils.equals(str5, strA);
                aVarA = com.smartdigimkt.o4.e.c().a();
                if (aVarA != null) {
                    aVar3.v = aVarA.L;
                }
            } else if (i3 == 4) {
                Integer num2 = (Integer) com.smartdigimkt.r4.k.a(map, "orientation", (Object) 1);
                num2.getClass();
                map4 = new HashMap();
                map4.put("orientation", num2);
                if (sDMAdRequest != null) {
                    map4.put(ATAdConst.KEY.AD_WIDTH, Integer.valueOf(sDMAdRequest.getAdWidth()));
                    map4.put(ATAdConst.KEY.AD_HEIGHT, Integer.valueOf(sDMAdRequest.getAdHeight()));
                }
                aVar3.u = map4;
            }
        }
        if (aVar3 != null) {
            String str10 = str3;
            StringBuilder sb2 = new StringBuilder("loadContext is not valid param1:true,param2:");
            if (aVar3 != null) {
                z = true;
            } else {
                z = false;
            }
            aVar.a(com.smartdigimkt.z3.b.a(str10, sb2.append(z).toString()));
            f(aVar);
            return false;
        }
        if (i3 != 0) {
            gVar = new com.smartdigimkt.e1.g(aVar.a, aVar3, gVar2);
        } else if (i3 != 1) {
            gVar = new com.smartdigimkt.e1.h(aVar.a, aVar3, gVar2);
        } else if (i3 != 2) {
            gVar = new com.smartdigimkt.e1.a(aVar.a, aVar3, gVar2);
        } else if (i3 != 3) {
            gVar = new com.smartdigimkt.e1.f(aVar.a, aVar3, gVar2);
        } else if (i3 != 4) {
            gVar = null;
        } else {
            gVar = new com.smartdigimkt.e1.j(aVar.a, aVar3, gVar2);
        }
        if (gVar != null) {
            aVar.a(com.smartdigimkt.z3.b.a(str3, "not support format:" + aVar3.c));
            f(aVar);
            return false;
        }
        if (sDMAdRequest != null) {
            map2 = sDMAdRequest.getCustomEventMap();
        } else {
            map2 = null;
        }
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        gVar.h = map2;
        gVar.a(aVar.q);
        gVar.l = aVar.v;
        bVar = new com.smartdigimkt.e1.b(gVar, new a(this, bVar2, aVar, gVar));
        map3 = gVar.h;
        if (map3 == null) {
        }
        aVar2 = gVar.c;
        if (aVar2 != null) {
            bVar.a(new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.i, com.anythink.core.common.inner.b.b.B));
        } else {
            bVar.a(new com.smartdigimkt.h0.g(com.anythink.core.common.inner.b.b.i, com.anythink.core.common.inner.b.b.B));
        }
        return false;
    }
}
