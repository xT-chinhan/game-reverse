package com.umeng.cconfig.c;

import android.text.TextUtils;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static HostnameVerifier a;

    public static String a(String str, String str2) {
        for (int i = 0; i < 3; i++) {
            try {
                HttpsURLConnection httpsURLConnectionB = b(str, str2);
                if (httpsURLConnectionB == null || httpsURLConnectionB.getResponseCode() != 200) {
                    break;
                }
                InputStreamReader inputStreamReader = new InputStreamReader(httpsURLConnectionB.getInputStream());
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int i2 = inputStreamReader.read();
                    if (i2 == -1) {
                        return stringBuffer.toString();
                    }
                    stringBuffer.append((char) i2);
                }
            } catch (Exception e) {
                if (i == 2) {
                    break;
                }
                try {
                    Thread.sleep(20000L);
                } catch (InterruptedException e2) {
                }
            }
        }
        return null;
    }

    private static HttpsURLConnection b(String str, String str2) {
        HttpsURLConnection httpsURLConnection;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, new SecureRandom());
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                if (a == null) {
                    a = new HostnameVerifier() { // from class: com.umeng.cconfig.c.a.1
                        @Override // javax.net.ssl.HostnameVerifier
                        public final boolean verify(String str3, SSLSession sSLSession) {
                            if (TextUtils.isEmpty(str3)) {
                                return false;
                            }
                            return "ucc.umeng.com".equalsIgnoreCase(str3) || "pslog.umeng.com".equalsIgnoreCase(str3);
                        }
                    };
                }
                httpsURLConnection.setHostnameVerifier(a);
                httpsURLConnection.setRequestMethod(TapHttp.METHOD_POST);
                httpsURLConnection.setConnectTimeout(15000);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setReadTimeout(15000);
                httpsURLConnection.setRequestProperty("Content-Type", "application/json");
                httpsURLConnection.connect();
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                outputStream.write(str2.getBytes());
                outputStream.flush();
                outputStream.close();
                return httpsURLConnection;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return httpsURLConnection;
            }
        } catch (Exception e2) {
            e = e2;
            httpsURLConnection = null;
        }
    }
}
