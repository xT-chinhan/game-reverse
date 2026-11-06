package com.byazt.lew;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 423, 26})
public class qg {
    public Uri n;
    public String qg;
    public Map<String, String> s;

    public qg(WebResourceRequest webResourceRequest, String str) {
        if (webResourceRequest != null) {
            this.n = webResourceRequest.getUrl();
            this.qg = webResourceRequest.getMethod();
            this.s = webResourceRequest.getRequestHeaders();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.n = Uri.parse(str);
        this.qg = TapHttp.METHOD_GET;
    }

    public Uri n() {
        return this.n;
    }

    public String qg() {
        return this.qg;
    }

    public Map<String, String> s() {
        return this.s;
    }
}
