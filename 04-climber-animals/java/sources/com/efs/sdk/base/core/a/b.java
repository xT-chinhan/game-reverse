package com.efs.sdk.base.core.a;

import android.text.TextUtils;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends AbsHttpListener {
    /* synthetic */ b(byte b) {
        this();
    }

    @Override // com.efs.sdk.base.core.util.concurrent.b
    public final /* bridge */ /* synthetic */ void a(com.efs.sdk.base.core.util.concurrent.c<HttpResponse> cVar, HttpResponse httpResponse) {
        HttpResponse httpResponse2 = httpResponse;
        if (httpResponse2 != null) {
            com.efs.sdk.base.core.a.a.a();
            com.efs.sdk.base.core.a.a.a(httpResponse2);
        }
    }

    private b() {
    }

    static class a {
        private static final b a = new b(0);
    }

    public static b a() {
        return a.a;
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onSuccess(HttpResponse httpResponse) {
        a(httpResponse);
        if (((Map) httpResponse.extra).containsKey("cver")) {
            String str = (String) ((Map) httpResponse.extra).get("cver");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i = Integer.parseInt(str);
            f fVar = f.a.a;
            if (fVar.b == null || !ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                return;
            }
            com.efs.sdk.base.core.d.b bVar = new com.efs.sdk.base.core.d.b("efs_core", "config_coverage", fVar.a.c);
            bVar.put("cver", Integer.valueOf(i));
            fVar.b.send(bVar);
        }
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onError(HttpResponse httpResponse) {
        if (httpResponse == null) {
            return;
        }
        a(httpResponse);
    }

    private static void a(HttpResponse httpResponse) {
        f.a.a.a(String.valueOf(httpResponse.getHttpCode()), httpResponse.getBizCode(), httpResponse.getReqUrl());
    }
}
