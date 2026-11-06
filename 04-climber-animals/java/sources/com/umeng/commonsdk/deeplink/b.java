package com.umeng.commonsdk.deeplink;

import com.umeng.analytics.pro.ay;
import com.umeng.analytics.pro.bv;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

/* JADX INFO: compiled from: AttributionResultRequest.java */
/* JADX INFO: loaded from: classes4.dex */
final class b {

    /* JADX INFO: compiled from: AttributionResultRequest.java */
    interface a {
        void a(int i, JSONObject jSONObject);

        void a(Throwable th);
    }

    private b() {
    }

    static void a(String str, String str2, long j, a aVar) {
        if (aVar == null) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [attribution] request start: url=https://one.umops.com/api/attributionResult");
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appkey", str);
                jSONObject.put(bv.g, str2);
                jSONObject.put("firstLaunchTime", j);
                byte[] bytes = jSONObject.toString().getBytes("UTF-8");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ay.a(bytes, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byte[] bytes2 = UMConfigure.sAppkey.getBytes("UTF-8");
                byte[] bArrA = ay.a(byteArray, bytes2);
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL("https://one.umops.com/api/attributionResult").openConnection();
                try {
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(null, null, new SecureRandom());
                    httpsURLConnection2.setSSLSocketFactory(sSLContext.getSocketFactory());
                    httpsURLConnection2.setRequestMethod("POST");
                    httpsURLConnection2.setConnectTimeout(15000);
                    httpsURLConnection2.setReadTimeout(15000);
                    httpsURLConnection2.setDoOutput(true);
                    httpsURLConnection2.setDoInput(true);
                    httpsURLConnection2.addRequestProperty("Content-Type", "application/json");
                    httpsURLConnection2.addRequestProperty("appkey", UMConfigure.sAppkey);
                    httpsURLConnection2.connect();
                    OutputStream outputStream = httpsURLConnection2.getOutputStream();
                    outputStream.write(bArrA);
                    outputStream.flush();
                    outputStream.close();
                    int responseCode = httpsURLConnection2.getResponseCode();
                    if (responseCode == 200) {
                        InputStream inputStream = httpsURLConnection2.getInputStream();
                        try {
                            String str3 = new String(ay.a(HelperUtils.readStreamToByteArray(inputStream), bytes2), "UTF-8");
                            JSONObject jSONObject2 = new JSONObject(str3);
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [attribution] response: ".concat(str3));
                            aVar.a(jSONObject2.optInt("status", 0), jSONObject2.optJSONObject("data"));
                            HelperUtils.safeClose(inputStream);
                        } catch (Throwable th) {
                            HelperUtils.safeClose(inputStream);
                            throw th;
                        }
                    } else {
                        aVar.a(new Exception("HTTP error code: " + responseCode));
                    }
                    if (httpsURLConnection2 != null) {
                        httpsURLConnection2.disconnect();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    httpsURLConnection = httpsURLConnection2;
                    try {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [attribution] request error: " + th.getMessage());
                        aVar.a(th);
                        if (httpsURLConnection == null) {
                        } else {
                            httpsURLConnection.disconnect();
                        }
                    } catch (Throwable th3) {
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.disconnect();
                            } catch (Throwable unused) {
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
