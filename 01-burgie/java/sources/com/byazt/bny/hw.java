package com.byazt.bny;

import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1753, 13})
public class hw implements uc {
    @Override // com.byazt.bny.uc
    public x pr(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(TapHttp.METHOD_GET);
        httpURLConnection.connect();
        return new pr(httpURLConnection);
    }
}
