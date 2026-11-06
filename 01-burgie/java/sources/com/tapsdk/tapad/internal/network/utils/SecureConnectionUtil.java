package com.tapsdk.tapad.internal.network.utils;

import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes2.dex */
public final class SecureConnectionUtil {

    public static final class StrictHostnameVerifier implements HostnameVerifier {
        static final StrictHostnameVerifier INSTANCE = new StrictHostnameVerifier();

        private StrictHostnameVerifier() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }

    private SecureConnectionUtil() {
    }

    public static void enforceHostnameVerification(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(StrictHostnameVerifier.INSTANCE);
        }
    }

    public static HttpURLConnection openConnection(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        enforceHostnameVerification(httpURLConnection);
        return httpURLConnection;
    }
}
