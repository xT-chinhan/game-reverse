package com.smartdigimkt.j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.smartdigimkt.sdk.api.IExHandlerBaseAd;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        com.smartdigimkt.b3.c baseAdContent;
        String action = intent.getAction();
        if (("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REPLACED".equals(action)) && intent.getData() != null) {
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            u uVarA = u.a(context);
            ConcurrentHashMap concurrentHashMap = uVarA.j;
            if (concurrentHashMap != null) {
                concurrentHashMap.size();
            }
            ConcurrentHashMap concurrentHashMap2 = uVarA.g;
            if (concurrentHashMap2 != null) {
                concurrentHashMap2.size();
            }
            try {
                ConcurrentHashMap concurrentHashMap3 = uVarA.j;
                if (concurrentHashMap3 != null && concurrentHashMap3.containsKey(schemeSpecificPart)) {
                    com.smartdigimkt.b3.c cVar = (com.smartdigimkt.b3.c) uVarA.j.remove(schemeSpecificPart);
                    uVarA.a();
                    if (cVar != null) {
                        String str = cVar.a;
                        com.smartdigimkt.k.o oVar = uVarA.o;
                        if (oVar != null) {
                            oVar.a(str);
                        }
                        com.smartdigimkt.n3.k.a(cVar.x, cVar.a, cVar.k, 5, (String) null, 0L, 0L, cVar, 0, 0L);
                    }
                }
            } catch (Throwable unused) {
            }
            CopyOnWriteArrayList copyOnWriteArrayList = uVarA.k;
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                for (IExHandlerBaseAd.DataFetchListener dataFetchListener : uVarA.k) {
                    if (dataFetchListener != null && (baseAdContent = dataFetchListener.getBaseAdContent()) != null && TextUtils.equals(baseAdContent.m, schemeSpecificPart)) {
                        dataFetchListener.onStatusChanged(2, com.smartdigimkt.n.b.a(SDKContext.getInstance().d(), com.smartdigimkt.k.c.INSTALLED));
                    }
                }
            }
            try {
                if (uVarA.g.containsKey(schemeSpecificPart)) {
                    com.smartdigimkt.k.r rVar = (com.smartdigimkt.k.r) uVarA.g.remove(schemeSpecificPart);
                    uVarA.a();
                    if (rVar == null) {
                        return;
                    }
                    com.smartdigimkt.b3.c cVar2 = rVar.j;
                    if (cVar2 != null) {
                        cVar2.D = 2;
                    }
                    rVar.s = com.smartdigimkt.k.c.INSTALLED;
                    uVarA.e(rVar);
                    if (uVarA.h == null) {
                        uVarA.h = new ConcurrentHashMap();
                    }
                    uVarA.h.put(rVar.o, rVar);
                    ConcurrentHashMap concurrentHashMap4 = uVarA.f;
                    if (concurrentHashMap4 != null) {
                        concurrentHashMap4.remove(rVar.o);
                    }
                    com.smartdigimkt.m.j jVarA = com.smartdigimkt.m.j.a(uVarA.a);
                    jVarA.getClass();
                    com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.m.f(jVarA, rVar));
                    com.smartdigimkt.k.o oVar2 = uVarA.o;
                    if (oVar2 != null) {
                        oVar2.a(rVar, "at_offer_action_4");
                    }
                    com.smartdigimkt.n3.k.a(rVar.a, rVar.f, rVar.b, 5, (String) null, 0L, 0L, rVar.j, 0, 0L);
                    if (rVar.G != 1) {
                        String str2 = rVar.a;
                        com.smartdigimkt.a3.a aVar = rVar.k;
                        String str3 = rVar.t;
                        String str4 = rVar.v;
                        String str5 = rVar.u;
                        com.smartdigimkt.b3.c cVar3 = rVar.j;
                        String str6 = cVar3 instanceof com.smartdigimkt.b3.l ? ((com.smartdigimkt.b3.l) cVar3).c0 : "";
                        String str7 = rVar.f;
                        String str8 = rVar.e;
                        long jCurrentTimeMillis = rVar.B > 0 ? System.currentTimeMillis() - rVar.B : 0L;
                        com.smartdigimkt.f3.c cVar4 = new com.smartdigimkt.f3.c(null, null);
                        cVar4.a = "1004713";
                        cVar4.b = str2;
                        cVar4.c = str3;
                        cVar4.a(aVar);
                        cVar4.l = str4;
                        cVar4.m = str5;
                        cVar4.n = str6;
                        cVar4.o = str7;
                        cVar4.p = str8;
                        cVar4.q = String.valueOf(jCurrentTimeMillis);
                        cVar4.r = String.valueOf(1);
                        cVar4.s = String.valueOf(1);
                        com.smartdigimkt.n3.k.a(cVar4);
                        rVar.G = 1;
                    }
                    uVarA.f(rVar);
                    uVarA.b(rVar, 1);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
