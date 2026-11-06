package com.smartdigimkt.r4;

import android.text.TextUtils;
import com.smartdigimkt.sdk.api.SDMSDK;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b0 {
    public static com.smartdigimkt.f3.a a(com.smartdigimkt.v4.a aVar) {
        com.smartdigimkt.f3.a aVar2 = new com.smartdigimkt.f3.a();
        int i = aVar.m;
        aVar2.v = i == 1;
        aVar2.b = aVar.e;
        aVar2.c = aVar.g;
        aVar2.h = aVar.w;
        aVar2.Y = aVar.A;
        aVar2.i = 0;
        aVar2.j = 2;
        aVar2.k = 0;
        com.smartdigimkt.w4.a aVar3 = aVar.i;
        if (aVar3 != null) {
            aVar2.s = aVar3.a;
            aVar2.t = aVar3.b;
            aVar2.u = aVar3.c;
        }
        if (i == 1) {
            com.smartdigimkt.a3.a aVar4 = aVar.p;
            if (aVar4 != null) {
                aVar2.d = String.valueOf(aVar4.c);
            }
        } else {
            aVar2.d = String.valueOf(aVar.c);
            a(aVar2, aVar.n);
        }
        aVar2.l = 0;
        return aVar2;
    }

    public static void a(com.smartdigimkt.f3.a aVar, com.smartdigimkt.p4.e eVar) {
        if (aVar == null || eVar == null) {
            return;
        }
        Integer.parseInt("1");
        aVar.e = eVar.C;
        aVar.d = String.valueOf(eVar.m);
        if (eVar.x != null) {
            aVar.m = aVar.m;
        }
    }

    public static void a(com.smartdigimkt.f3.a aVar, com.smartdigimkt.v4.a aVar2) {
        com.smartdigimkt.p4.g gVar;
        com.smartdigimkt.d3.c cVar;
        int i;
        if (aVar == null || aVar2 == null || aVar2.n == null || (gVar = aVar2.o) == null || (cVar = gVar.a) == null) {
            return;
        }
        aVar.c0 = gVar.F;
        aVar.d0 = cVar.b;
        try {
            aVar.L = SDMSDK.getInstance().getSDKVersion();
        } catch (Throwable unused) {
        }
        aVar.N = gVar.w;
        aVar.P = gVar.b;
        aVar.Q = gVar.r;
        aVar.O = gVar.d;
        if (gVar.t == 2) {
            aVar.R = gVar.m;
            aVar.T = gVar.A;
            aVar.S = gVar.K;
        } else {
            aVar.R = 0.0d;
            aVar.T = 0.0d;
            aVar.S = 0.0d;
        }
        if (gVar.n == 1) {
            if (gVar.x != 2) {
                TextUtils.isEmpty(cVar.N == 3 ? "ecpm_api" : cVar.E);
            }
        } else {
            TextUtils.isEmpty(gVar.s);
        }
        aVar.a0 = gVar.n;
        try {
            Map map = gVar.e;
            JSONObject jSONObject = new JSONObject();
            if ("0".equals(aVar.d) && (3 == (i = gVar.u) || 7 == i)) {
                String strA = "";
                if (!TextUtils.isEmpty(gVar.i)) {
                    strA = gVar.i;
                }
                if (TextUtils.isEmpty(strA)) {
                    strA = k.a("layout_type", map);
                }
                if (TextUtils.isEmpty(strA) || strA.equals("0")) {
                    strA = "2";
                }
                jSONObject.put("tpl_type", strA);
            }
            jSONObject.toString();
            int iIntValue = gVar.j;
            if (iIntValue == 0) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = ((Integer) k.a(map, "render_type", (Object) 0)).intValue();
            }
            int iIntValue2 = gVar.k;
            if (iIntValue2 == 0) {
                iIntValue2 = 0;
            }
            if (iIntValue2 == 0) {
                iIntValue2 = ((Integer) k.a(map, "template_type", (Object) 0)).intValue();
            }
            aVar.D = iIntValue;
            aVar.E = iIntValue2;
        } catch (Throwable unused2) {
        }
        aVar.X = cVar.s;
        aVar.M = gVar.c;
        aVar.Z = gVar.E;
        com.smartdigimkt.p4.c cVar2 = gVar.L;
        if (cVar2 != null) {
            aVar.U = cVar2.b;
            aVar.V = cVar2.f;
            aVar.W = cVar2.d;
            aVar.b0 = cVar2.a;
        }
        if (cVar.N > 0) {
            aVar.J = cVar.M;
        }
        aVar.K = cVar.O;
        aVar.n = cVar.Q;
        aVar.r = cVar.j;
    }
}
