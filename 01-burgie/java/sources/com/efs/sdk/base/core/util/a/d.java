package com.efs.sdk.base.core.util.a;

import android.support.annotation.NonNull;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpEnv;
import com.efs.sdk.base.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public b a = new b();
    private List<com.efs.sdk.base.core.util.concurrent.b<HttpResponse>> b;

    public d(@NonNull String str) {
        this.a.a = str;
    }

    public final d a(@NonNull Map<String, String> map) {
        this.a.b = map;
        return this;
    }

    public final d a(String str, String str2) {
        if (this.a.f == null) {
            this.a.f = new HashMap(5);
        }
        this.a.f.put(str, str2);
        return this;
    }

    public final d a(@NonNull AbsHttpListener absHttpListener) {
        if (this.b == null) {
            this.b = new ArrayList(5);
        }
        this.b.add(absHttpListener);
        return this;
    }

    public final c a() {
        c cVar = new c(this.a);
        if (this.b != null && this.b.size() > 0) {
            cVar.a(this.b);
        }
        List<com.efs.sdk.base.core.util.concurrent.b<HttpResponse>> httpListenerList = HttpEnv.getInstance().getHttpListenerList();
        if (httpListenerList != null && httpListenerList.size() > 0) {
            cVar.a(httpListenerList);
        }
        return cVar;
    }
}
