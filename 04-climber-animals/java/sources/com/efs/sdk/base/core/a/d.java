package com.efs.sdk.base.core.a;

import android.os.Message;
import android.text.TextUtils;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends AbsHttpListener {
    /* synthetic */ d(byte b) {
        this();
    }

    @Override // com.efs.sdk.base.core.util.concurrent.b
    public final /* synthetic */ void a(com.efs.sdk.base.core.util.concurrent.c<HttpResponse> cVar, HttpResponse httpResponse) {
        HttpResponse httpResponse2 = httpResponse;
        if (httpResponse2 != null) {
            com.efs.sdk.base.core.util.a.b bVar = (com.efs.sdk.base.core.util.a.b) cVar;
            ((Map) httpResponse2.extra).putAll(bVar.f);
            bVar.f.clear();
            com.efs.sdk.base.core.a.a.a();
            com.efs.sdk.base.core.a.a.a(httpResponse2);
        }
    }

    private d() {
    }

    static class a {
        private static final d a = new d(0);
    }

    public static d a() {
        return a.a;
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onError(HttpResponse httpResponse) {
        a(httpResponse);
        if (httpResponse == null) {
            return;
        }
        b(httpResponse);
        c(httpResponse);
    }

    private static void a(HttpResponse httpResponse) {
        if (ControllerCenter.getGlobalEnvStruct().isDebug()) {
            Log.i("efs.px.api", httpResponse == null ? "upload result : false" : "upload result : " + httpResponse.succ + ", resp is " + httpResponse.toString());
        }
    }

    private static void c(HttpResponse httpResponse) {
        int i;
        if (((Map) httpResponse.extra).containsKey("cver")) {
            String str = (String) ((Map) httpResponse.extra).get("cver");
            if (!TextUtils.isEmpty(str) && (i = Integer.parseInt(str)) > com.efs.sdk.base.core.config.remote.b.a().d.mConfigVersion) {
                com.efs.sdk.base.core.config.remote.b.a().a(i);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005b  */
    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onSuccess(HttpResponse httpResponse) {
        int i;
        if (!((Map) httpResponse.extra).containsKey("flow_limit") || !Boolean.FALSE.toString().equals(((Map) httpResponse.extra).get("flow_limit"))) {
            String str = ((Map) httpResponse.extra).containsKey("type") ? (String) ((Map) httpResponse.extra).get("type") : "";
            if (((Map) httpResponse.extra).containsKey("size")) {
                String str2 = (String) ((Map) httpResponse.extra).get("size");
                if (TextUtils.isEmpty(str2)) {
                    i = 0;
                } else {
                    i = Integer.parseInt(str2);
                }
            } else {
                i = 0;
            }
            com.efs.sdk.base.core.b.c cVarA = com.efs.sdk.base.core.b.c.a();
            Message messageObtain = Message.obtain();
            messageObtain.what = 0;
            messageObtain.obj = str;
            messageObtain.arg1 = i;
            cVarA.sendMessage(messageObtain);
        }
        b(httpResponse);
        f.a.a.c.b.incrementAndGet();
        c(httpResponse);
        a(httpResponse);
    }

    private static void b(HttpResponse httpResponse) {
        f.a.a.a(String.valueOf(httpResponse.getHttpCode()), httpResponse.getBizCode(), httpResponse.getReqUrl());
    }
}
