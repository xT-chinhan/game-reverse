package com.smartdigimkt.c4;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.core.net.entity.HttpReqEntity;
import com.smartdigimkt.sdk.core.net.entity.HttpRespEntity;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends c {
    public a(Context context) {
        super(context);
    }

    public final boolean b(HttpReqEntity httpReqEntity) {
        if (this.a == null || httpReqEntity == null) {
            return false;
        }
        String urlType = httpReqEntity.getUrlType();
        return ("app_strategy".equals(urlType) || "placement_strategy".equals(urlType) || "get_plugin".equals(urlType)) && !TextUtils.isEmpty(httpReqEntity.getInterceptKey());
    }

    @Override // com.smartdigimkt.sdk.core.net.interceptor.IHttpLoaderInterceptor
    public final void handleRespon(HttpRespEntity httpRespEntity, HttpReqEntity httpReqEntity) {
        if (!b(httpReqEntity) || httpRespEntity == null) {
            return;
        }
        int httpCode = httpRespEntity.getHttpCode();
        String urlKey = httpRespEntity.getUrlKey();
        long reqNextTime = httpRespEntity.getReqNextTime();
        if (httpCode != 699 || reqNextTime <= 0) {
            return;
        }
        synchronized (this.c) {
            ConcurrentHashMap concurrentHashMap = this.b;
            if (concurrentHashMap != null) {
                concurrentHashMap.put(urlKey, Long.valueOf(reqNextTime));
            }
            y.a(this.a, "sdm_adx_rp_app_pl_cl_retry", urlKey, reqNextTime);
        }
    }

    @Override // com.smartdigimkt.c4.c, com.smartdigimkt.sdk.core.net.interceptor.IHttpLoaderInterceptor
    public final HttpRespEntity interceptRequest(HttpReqEntity httpReqEntity) {
        if (!b(httpReqEntity)) {
            return null;
        }
        HttpRespEntity httpRespEntityInterceptRequest = super.interceptRequest(httpReqEntity);
        if (httpRespEntityInterceptRequest != null && httpRespEntityInterceptRequest.isIntercept()) {
            httpRespEntityInterceptRequest.setInterceptStatusCode(com.anythink.core.common.l.b.d);
        }
        return httpRespEntityInterceptRequest;
    }
}
