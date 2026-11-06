package com.smartdigimkt.s3;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.o4.o;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.api.ISDMAdManager;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.v2.p;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ com.smartdigimkt.h3.b b;
    public final /* synthetic */ ISDMAdManager.S2SBidTokenCallback c;
    public final /* synthetic */ Map d;

    public d(String str, com.smartdigimkt.h3.b bVar, ISDMAdManager.S2SBidTokenCallback s2SBidTokenCallback, Map map) {
        this.a = str;
        this.b = bVar;
        this.c = s2SBidTokenCallback;
        this.d = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2 = this.a;
        if (!TextUtils.isEmpty(str2)) {
            com.smartdigimkt.p4.e eVarB = o.a().b(str2);
            com.smartdigimkt.y3.a aVar = new com.smartdigimkt.y3.a(str2);
            aVar.b = eVarB;
            o.a().a(new com.smartdigimkt.y3.b(aVar));
        }
        synchronized (j.a) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (j.a(j.b, j.c, jCurrentTimeMillis)) {
                str = j.b;
            } else {
                Context contextD = SDKContext.getInstance().d();
                if (contextD == null) {
                    str = "";
                } else {
                    String strC = y.c(contextD, "sdm_adx_rp_sdk", "s2s_buyer_uid_cache");
                    long jB = y.b(contextD, "sdm_adx_rp_sdk", "s2s_buyer_uid_cache_time");
                    if (j.a(strC, jB, jCurrentTimeMillis)) {
                        j.b = strC;
                        j.c = jB;
                        str = strC;
                    } else {
                        str = "";
                    }
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            com.smartdigimkt.o4.e.c().a((com.smartdigimkt.h3.b) null);
            Map map = this.d;
            ISDMAdManager.S2SBidTokenCallback s2SBidTokenCallback = this.c;
            com.smartdigimkt.h3.b bVar = this.b;
            p.c().a(new e(map, bVar, s2SBidTokenCallback), bVar, "s2sToken");
            return;
        }
        com.smartdigimkt.h3.b bVar2 = this.b;
        if (bVar2 != null) {
            bVar2.e();
        }
        com.smartdigimkt.h3.b bVar3 = this.b;
        if (bVar3 != null) {
            bVar3.b();
        }
        com.smartdigimkt.q3.f.a().c(new i(this.c, str));
    }
}
