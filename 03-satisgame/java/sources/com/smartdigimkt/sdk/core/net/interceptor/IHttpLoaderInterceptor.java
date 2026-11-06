package com.smartdigimkt.sdk.core.net.interceptor;

import com.smartdigimkt.sdk.core.net.entity.HttpReqEntity;
import com.smartdigimkt.sdk.core.net.entity.HttpRespEntity;

/* JADX INFO: loaded from: classes3.dex */
public interface IHttpLoaderInterceptor {
    void handleRespon(HttpRespEntity httpRespEntity, HttpReqEntity httpReqEntity);

    HttpRespEntity interceptRequest(HttpReqEntity httpReqEntity);
}
