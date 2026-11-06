package com.byazt.uf;

import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 886, 26})
public class qg implements w {
    @Override // com.byazt.uf.w
    public q n(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(TapHttp.METHOD_GET);
        httpURLConnection.connect();
        return new n(httpURLConnection);
    }
}
