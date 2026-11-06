package com.bytedance.sdk.openadsdk.core.p;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms extends SSLSocketFactory {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected SSLSocketFactory f3245ms = HttpsURLConnection.getDefaultSSLSocketFactory();
}
