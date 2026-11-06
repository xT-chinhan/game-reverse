package com.byazt.mv;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1166, 13})
public class hw {
    public Map<String, String> hn;
    public String hw;
    public Uri pr;

    public hw(WebResourceRequest webResourceRequest, String str) {
        if (webResourceRequest != null) {
            this.pr = webResourceRequest.getUrl();
            this.hw = webResourceRequest.getMethod();
            this.hn = webResourceRequest.getRequestHeaders();
        }
        if (!TextUtils.isEmpty(str)) {
            this.pr = Uri.parse(str);
            this.hw = TapHttp.METHOD_GET;
        }
    }

    public Uri pr() {
        return this.pr;
    }

    public String hw() {
        return this.hw;
    }

    public Map<String, String> hn() {
        return this.hn;
    }
}
