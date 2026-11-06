package com.bytedance.adsdk.lottie.ah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final HttpURLConnection f140ms;

    public ms(HttpURLConnection httpURLConnection) {
        this.f140ms = httpURLConnection;
    }

    @Override // com.bytedance.adsdk.lottie.ah.d
    public boolean ms() {
        try {
            return this.f140ms.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.bytedance.adsdk.lottie.ah.d
    public InputStream xr() throws IOException {
        return this.f140ms.getInputStream();
    }

    @Override // com.bytedance.adsdk.lottie.ah.d
    public String ah() {
        return this.f140ms.getContentType();
    }

    @Override // com.bytedance.adsdk.lottie.ah.d
    public String d() {
        try {
            if (ms()) {
                return null;
            }
            return "Unable to fetch " + this.f140ms.getURL() + ". Failed with " + this.f140ms.getResponseCode() + "\n" + ms(this.f140ms);
        } catch (IOException e) {
            com.bytedance.adsdk.lottie.ka.ka.ms("get error failed ", e);
            return e.getMessage();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f140ms.disconnect();
    }

    private String ms(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line).append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }
}
