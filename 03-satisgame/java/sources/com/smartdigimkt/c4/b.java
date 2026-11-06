package com.smartdigimkt.c4;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.o4.e;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.core.net.entity.HttpReqEntity;
import com.smartdigimkt.sdk.core.net.entity.HttpRespEntity;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends c {
    public volatile boolean d;
    public volatile long e;
    public volatile long f;

    public b(Context context) {
        super(context);
        this.d = false;
        this.e = 0L;
        this.f = 0L;
    }

    public final void a(HttpRespEntity httpRespEntity, HttpReqEntity httpReqEntity) {
        httpRespEntity.getUrlKey();
        httpRespEntity.getReqNextTime();
        httpRespEntity.getHttpCode();
        try {
            com.smartdigimkt.k4.a aVarA = com.smartdigimkt.k4.c.a().a(this.a, "sdm_adx_rp_app_pl_cl_retry");
            String interceptKey = httpReqEntity.getInterceptKey();
            String strA = a(httpReqEntity);
            String str = interceptKey + "_req_count_limit";
            this.b.put(strA, 0L);
            aVarA.a(0L, strA);
            aVarA.a(24L, str);
            aVarA.a(0L, interceptKey + "_req_count");
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final boolean b(HttpReqEntity httpReqEntity) {
        if (this.a != null && httpReqEntity != null && "app_strategy".equals(httpReqEntity.getUrlType())) {
            String interceptKey = httpReqEntity.getInterceptKey();
            com.smartdigimkt.p4.a aVarA = e.c().a();
            if (this.a != null && !TextUtils.isEmpty(interceptKey) && ((aVarA == null || aVarA.Z != 1) && k.c(this.a))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.smartdigimkt.sdk.core.net.interceptor.IHttpLoaderInterceptor
    public final void handleRespon(HttpRespEntity httpRespEntity, HttpReqEntity httpReqEntity) {
        if (!b(httpReqEntity) || httpRespEntity == null) {
            return;
        }
        synchronized (this.c) {
            a(httpRespEntity, httpReqEntity);
        }
    }

    @Override // com.smartdigimkt.c4.c, com.smartdigimkt.sdk.core.net.interceptor.IHttpLoaderInterceptor
    public final HttpRespEntity interceptRequest(HttpReqEntity httpReqEntity) {
        HttpRespEntity httpRespEntity = null;
        if (!b(httpReqEntity)) {
            return null;
        }
        String interceptKey = httpReqEntity.getInterceptKey();
        String strA = a(httpReqEntity);
        String strA2 = com.smartdigimkt.p.a.a(interceptKey, "_req_count");
        String strA3 = com.smartdigimkt.p.a.a(interceptKey, "_req_count_limit");
        String strA4 = com.smartdigimkt.p.a.a(interceptKey, "_req_first_timestamp");
        try {
            HttpRespEntity httpRespEntityInterceptRequest = super.interceptRequest(httpReqEntity);
            if (httpRespEntityInterceptRequest == null) {
                return null;
            }
            try {
                synchronized (this.c) {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        com.smartdigimkt.k4.a aVarA = com.smartdigimkt.k4.c.a().a(this.a, "sdm_adx_rp_app_pl_cl_retry");
                        long jLongValue = ((Long) aVarA.b(24L, strA3)).longValue();
                        if (!httpRespEntityInterceptRequest.isIntercept()) {
                            long jLongValue2 = this.e;
                            long jLongValue3 = 0;
                            if (jLongValue2 <= 0) {
                                jLongValue2 = ((Long) aVarA.b(0L, strA4)).longValue();
                            }
                            this.e = jLongValue2;
                            if (this.e <= 0 || jCurrentTimeMillis - this.e >= 86400000) {
                                this.e = jCurrentTimeMillis;
                                aVarA.a(Long.valueOf(jCurrentTimeMillis), strA4);
                            } else {
                                jLongValue3 = ((Long) aVarA.b(0L, strA2)).longValue();
                            }
                            long j = 1;
                            if (jLongValue3 >= jLongValue - 1) {
                                long j2 = this.e + 86400000;
                                ConcurrentHashMap concurrentHashMap = this.b;
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(strA, Long.valueOf(j2));
                                }
                                long j3 = jLongValue / 4;
                                if (j3 > 1) {
                                    j = j3;
                                }
                                aVarA.a(Long.valueOf(j), strA3);
                                aVarA.a(Long.valueOf(j2), strA);
                            } else {
                                long j4 = jLongValue3 + 1;
                                this.f = j4;
                                aVarA.a(Long.valueOf(j4), strA2);
                            }
                        } else if (!this.d) {
                            this.d = true;
                            String str = interceptKey + "_agent_event";
                            if (!((Boolean) aVarA.b(Boolean.FALSE, str)).booleanValue()) {
                                long j5 = this.e;
                                long j6 = this.f;
                                com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c("", "");
                                cVar.a = "3000008";
                                cVar.l = String.valueOf(j5);
                                cVar.m = String.valueOf(j6);
                                cVar.n = String.valueOf(jLongValue);
                                com.smartdigimkt.n3.k.a(cVar);
                                aVarA.a(Boolean.TRUE, str);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return httpRespEntityInterceptRequest;
            } catch (Throwable th2) {
                th = th2;
                httpRespEntity = httpRespEntityInterceptRequest;
                th.getMessage();
                return httpRespEntity;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.smartdigimkt.c4.c
    public final String a(HttpReqEntity httpReqEntity) {
        return httpReqEntity != null ? httpReqEntity.getInterceptKey() + "_req_next_time" : "";
    }
}
