package com.smartdigimkt.c4;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.core.net.entity.HttpReqEntity;
import com.smartdigimkt.sdk.core.net.entity.HttpRespEntity;
import com.smartdigimkt.sdk.core.net.interceptor.IHttpLoaderInterceptor;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements IHttpLoaderInterceptor {
    public final Context a;
    public final Object c = new Object();
    public final ConcurrentHashMap b = new ConcurrentHashMap(1);

    public c(Context context) {
        this.a = context;
    }

    public String a(HttpReqEntity httpReqEntity) {
        return httpReqEntity != null ? httpReqEntity.getInterceptKey() : "";
    }

    @Override // com.smartdigimkt.sdk.core.net.interceptor.IHttpLoaderInterceptor
    public HttpRespEntity interceptRequest(HttpReqEntity httpReqEntity) {
        String strA = a(httpReqEntity);
        if (this.b == null || TextUtils.isEmpty(strA)) {
            return null;
        }
        HttpRespEntity httpRespEntityCreate = HttpRespEntity.create();
        synchronized (this.c) {
            Long lValueOf = (Long) this.b.get(strA);
            if (lValueOf == null) {
                lValueOf = Long.valueOf(y.b(this.a, "sdm_adx_rp_app_pl_cl_retry", strA));
                this.b.put(strA, lValueOf);
            }
            if (lValueOf.longValue() == 0) {
                httpRespEntityCreate.setIntercept(false);
            } else if (lValueOf.longValue() == -1) {
                httpRespEntityCreate.setIntercept(true);
                httpRespEntityCreate.setInterceptStatusCode(700);
            } else {
                boolean z = System.currentTimeMillis() - lValueOf.longValue() < 0;
                if (z) {
                    httpRespEntityCreate.setInterceptStatusCode(700);
                }
                httpRespEntityCreate.setIntercept(z);
            }
        }
        return httpRespEntityCreate;
    }
}
