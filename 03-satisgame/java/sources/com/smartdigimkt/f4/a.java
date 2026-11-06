package com.smartdigimkt.f4;

import android.os.SystemClock;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.sdk.core.net.entity.HttpReqEntity;
import com.smartdigimkt.sdk.core.net.entity.HttpRespEntity;
import com.smartdigimkt.sdk.core.net.interceptor.IHttpLoaderInterceptor;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.smartdigimkt.q3.h {
    public final /* synthetic */ int b;
    public final /* synthetic */ b c;

    public a(b bVar, int i) {
        this.c = bVar;
        this.b = i;
    }

    @Override // com.smartdigimkt.q3.h
    public final void b() {
        IHttpLoaderInterceptor iHttpLoaderInterceptor;
        HttpRespEntity httpRespEntityInterceptRequest;
        try {
            com.smartdigimkt.h3.b bVarA = this.c.a();
            if (bVarA != null) {
                b bVar = this.c;
                Math.max(0L, SystemClock.elapsedRealtime() - this.c.j);
                bVar.getClass();
            }
            long jElapsedRealtime = bVarA != null ? SystemClock.elapsedRealtime() : -1L;
            try {
                byte[] bArrH = this.c.d.h();
                if (bVarA != null) {
                    this.c.k = Math.max(0L, SystemClock.elapsedRealtime() - jElapsedRealtime);
                    long j = this.c.k;
                    synchronized (bVarA) {
                        if (!bVarA.b.get()) {
                            Math.max(0L, j);
                        }
                    }
                }
                b bVar2 = this.c;
                b.a(bVar2, bVar2.d, bArrH);
                this.c.getClass();
                b bVar3 = this.c;
                bVar3.h = false;
                bVar3.a = bVar3.d.k();
                com.smartdigimkt.g4.d dVar = this.c.d;
                int iJ = dVar != null ? dVar.j() : 2;
                boolean zM = true;
                String str = ((iJ == 1 || iJ == 2) && iJ != 2) ? TapHttp.METHOD_POST : TapHttp.METHOD_GET;
                this.c.getClass();
                b bVar4 = this.c;
                String str2 = bVar4.a;
                com.smartdigimkt.a4.b bVar5 = bVar4.b;
                if (bVar5 != null) {
                    bVar5.a(this.b);
                }
                b bVar6 = this.c;
                if (bVar6.e == null) {
                    com.smartdigimkt.g4.d dVar2 = bVar6.d;
                    bVar6.e = dVar2 != null ? dVar2.f() : null;
                }
                b bVar7 = this.c;
                HttpReqEntity httpReqEntity = bVar7.e;
                if (httpReqEntity != null && (iHttpLoaderInterceptor = bVar7.c) != null && (httpRespEntityInterceptRequest = iHttpLoaderInterceptor.interceptRequest(httpReqEntity)) != null && httpRespEntityInterceptRequest.isIntercept()) {
                    this.c.getClass();
                    int interceptStatusCode = httpRespEntityInterceptRequest.getInterceptStatusCode();
                    b.a(this.c, interceptStatusCode);
                    String strValueOf = String.valueOf(interceptStatusCode);
                    if (interceptStatusCode == 200) {
                        this.c.a(this.b, httpRespEntityInterceptRequest.getInterceptResult(), false);
                        return;
                    }
                    String str3 = "";
                    if (interceptStatusCode == 699) {
                        str3 = "Your App or Placement has been suspended or deleted and no longer obtains strategy.";
                    } else if (interceptStatusCode == 700) {
                        str3 = "API access restricted due to too many requests. Please reduce requests or try again later.";
                    }
                    this.c.a(this.b, interceptStatusCode, "", com.smartdigimkt.z3.b.a(strValueOf, str3), false, false);
                    return;
                }
                com.smartdigimkt.e4.a aVar = this.c.f;
                if (aVar == null) {
                    int i = com.smartdigimkt.d4.a.d;
                    ArrayList arrayList = new ArrayList();
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    com.smartdigimkt.d4.a aVar2 = new com.smartdigimkt.d4.a();
                    aVar2.b = 60000L;
                    aVar2.a = 60000L;
                    if (!arrayList.isEmpty()) {
                        aVar2.c.addAll(new ArrayList(arrayList));
                    }
                    aVar = new com.smartdigimkt.e4.a(aVar2);
                    this.c.f = aVar;
                }
                b bVar8 = this.c;
                bVar8.getClass();
                try {
                    com.smartdigimkt.g4.d dVar3 = bVar8.d;
                    if (dVar3 instanceof com.smartdigimkt.g4.j) {
                        zM = ((com.smartdigimkt.g4.j) dVar3).m();
                    }
                } catch (Throwable unused) {
                }
                b bVar9 = this.c;
                String str4 = bVar9.a;
                com.smartdigimkt.d4.b bVar10 = new com.smartdigimkt.d4.b();
                bVar10.a = str4;
                bVar10.b = str;
                com.smartdigimkt.g4.d dVar4 = bVar9.d;
                Map mapE = dVar4 != null ? dVar4.e() : new HashMap();
                if (mapE != null && mapE.containsKey(com.anythink.core.common.l.b.g)) {
                }
                bVar10.c = bArrH;
                com.smartdigimkt.g4.d dVar5 = this.c.d;
                Map mapE2 = dVar5 != null ? dVar5.e() : new HashMap();
                if (mapE2 == null) {
                    mapE2 = new HashMap();
                }
                if (!mapE2.containsKey(RequestParamsUtils.USER_AGENT_KEY) && SDKContext.getInstance().a("ua")) {
                    mapE2.put(RequestParamsUtils.USER_AGENT_KEY, com.smartdigimkt.r4.j.a());
                }
                bVar10.d = mapE2;
                bVar10.e = zM;
                com.smartdigimkt.d4.c cVar = new com.smartdigimkt.d4.c(bVar10);
                long jElapsedRealtime2 = bVarA != null ? SystemClock.elapsedRealtime() : -1L;
                if (bVarA != null) {
                    bVarA.a(jElapsedRealtime2);
                }
                try {
                    com.smartdigimkt.d4.e eVarA = aVar.a(cVar, new ArrayList());
                    if (bVarA != null) {
                        long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                        this.c.l = Math.max(0L, jElapsedRealtime3 - jElapsedRealtime2);
                        bVarA.a(jElapsedRealtime2, jElapsedRealtime3);
                    }
                    b bVar11 = this.c;
                    if (bVar11.a() != null && eVarA != null) {
                        bVar11.n = eVarA.h;
                        bVar11.o = eVarA.i;
                    }
                    b.a(this.c, eVarA.b);
                    this.c.m = bVarA != null ? SystemClock.elapsedRealtime() : -1L;
                    int i2 = eVarA.b;
                    if (i2 != 200 && i2 != 201 && i2 != 204 && !this.c.b(i2)) {
                        b.b(this.c, eVarA, this.b);
                        return;
                    }
                    b.a(this.c, eVarA, this.b);
                } catch (Throwable th) {
                    if (bVarA != null) {
                        long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                        this.c.l = Math.max(0L, jElapsedRealtime4 - jElapsedRealtime2);
                        bVarA.a(jElapsedRealtime2, jElapsedRealtime4);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                if (bVarA != null) {
                    this.c.k = Math.max(0L, SystemClock.elapsedRealtime() - jElapsedRealtime);
                    bVarA.b(this.c.k);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            b bVar12 = this.c;
            bVar12.getClass();
            bVar12.a(0, 0, th3.getMessage(), com.smartdigimkt.z3.b.a("90002", "" + th3));
        }
    }
}
