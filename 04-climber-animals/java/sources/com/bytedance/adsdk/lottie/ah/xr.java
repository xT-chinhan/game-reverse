package com.bytedance.adsdk.lottie.ah;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements c {
    @Override // com.bytedance.adsdk.lottie.ah.c
    public d ms(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new ms(httpURLConnection);
    }
}
