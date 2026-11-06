package com.bytedance.sdk.openadsdk.sl;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private Map<String, String> ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Uri f4106ms;
    private String xr;

    public xr(WebResourceRequest webResourceRequest, String str) {
        if (webResourceRequest != null) {
            this.f4106ms = webResourceRequest.getUrl();
            this.xr = webResourceRequest.getMethod();
            this.ah = webResourceRequest.getRequestHeaders();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f4106ms = Uri.parse(str);
        this.xr = "GET";
    }

    public Uri ms() {
        return this.f4106ms;
    }

    public String xr() {
        return this.xr;
    }

    public Map<String, String> ah() {
        return this.ah;
    }
}
