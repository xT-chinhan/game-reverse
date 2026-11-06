package com.smartdigimkt.c4;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.sdk.core.net.entity.HttpReqEntity;
import com.smartdigimkt.sdk.core.net.entity.HttpRespEntity;
import com.smartdigimkt.sdk.core.net.interceptor.IHttpLoaderInterceptor;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements IHttpLoaderInterceptor {
    public final Context a;
    public final ConcurrentHashMap b;
    public final a c;

    public d(Context context) {
        context = context instanceof Activity ? context.getApplicationContext() : context;
        this.a = context;
        this.b = new ConcurrentHashMap();
        this.c = new a(context);
    }

    public final IHttpLoaderInterceptor a(Context context, HttpReqEntity httpReqEntity) {
        b bVar = null;
        if (httpReqEntity == null || this.b == null) {
            return null;
        }
        String urlType = httpReqEntity.getUrlType();
        IHttpLoaderInterceptor iHttpLoaderInterceptor = (IHttpLoaderInterceptor) this.b.get(urlType);
        if (iHttpLoaderInterceptor != null) {
            return iHttpLoaderInterceptor;
        }
        synchronized (this) {
            if (!TextUtils.isEmpty(urlType)) {
                urlType.getClass();
                if (urlType.equals("app_strategy")) {
                    bVar = new b(context);
                }
                if (bVar != null) {
                    this.b.put(urlType, bVar);
                }
            }
        }
        return bVar;
    }

    @Override // com.smartdigimkt.sdk.core.net.interceptor.IHttpLoaderInterceptor
    public final void handleRespon(HttpRespEntity httpRespEntity, HttpReqEntity httpReqEntity) {
        if (this.a == null || httpRespEntity == null || httpReqEntity == null) {
            return;
        }
        try {
            a aVar = this.c;
            if (aVar != null) {
                aVar.handleRespon(httpRespEntity, httpReqEntity);
            }
            IHttpLoaderInterceptor iHttpLoaderInterceptorA = a(this.a, httpReqEntity);
            if (iHttpLoaderInterceptorA != null) {
                iHttpLoaderInterceptorA.handleRespon(httpRespEntity, httpReqEntity);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.smartdigimkt.sdk.core.net.interceptor.IHttpLoaderInterceptor
    public final HttpRespEntity interceptRequest(HttpReqEntity httpReqEntity) {
        IHttpLoaderInterceptor iHttpLoaderInterceptorA;
        if (this.a == null || httpReqEntity == null) {
            return null;
        }
        try {
            a aVar = this.c;
            HttpRespEntity httpRespEntityInterceptRequest = aVar != null ? aVar.interceptRequest(httpReqEntity) : null;
            return ((httpRespEntityInterceptRequest == null || !httpRespEntityInterceptRequest.isIntercept()) && (iHttpLoaderInterceptorA = a(this.a, httpReqEntity)) != null) ? iHttpLoaderInterceptorA.interceptRequest(httpReqEntity) : httpRespEntityInterceptRequest;
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }
}
