package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.umeng.analytics.pro.an;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: UMSLNetWorkSenderHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    private String a = "10.0.0.172";
    private int b = 80;
    private Context c;

    public c(Context context) {
        this.c = context;
    }

    private void a() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "sl_domain_p", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            a.i = DataHelper.assembleStatelessURL(strImprintProperty);
        }
    }

    private void b() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "sl_domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            a.h = DataHelper.assembleStatelessURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            a.k = DataHelper.assembleStatelessURL(strImprintProperty2);
        }
        a.i = a.k;
        if (!TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.b)) {
            if (com.umeng.commonsdk.statistics.b.b.startsWith("460") || com.umeng.commonsdk.statistics.b.b.startsWith("461")) {
                a.i = a.h;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v10, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v16, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [javax.net.ssl.HttpsURLConnection] */
    public boolean a(byte[] bArr, String str, String str2, String str3) throws Throwable {
        boolean z = false;
        if (bArr == null || str == null) {
            ULog.i("walle", "[stateless] sendMessage, envelopeByte == null || path == null ");
            return false;
        }
        if (SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            a.h = a.k;
            b();
        }
        String str4 = a.i;
        ?? r9 = str2;
        if (!com.umeng.commonsdk.vchannel.a.c.equalsIgnoreCase(str)) {
            r9 = str4;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 无状态收数域名：" + r9);
        ?? r2 = 0;
        r2 = 0;
        r2 = 0;
        r2 = 0;
        r2 = 0;
        r2 = 0;
        r2 = 0;
        try {
            try {
                try {
                    r9 = (HttpsURLConnection) new URL(r9 + File.separator + str).openConnection();
                    try {
                        r9.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, new SecureRandom());
                        r9.setSSLSocketFactory(sSLContext.getSocketFactory());
                        r9.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                        r9.setRequestProperty("Msg-Type", "envelope/json");
                        r9.setRequestProperty("Content-Type", an.aQ + str3);
                        r9.setRequestProperty("SM-IMP", "1");
                        r9.setConnectTimeout(30000);
                        r9.setReadTimeout(30000);
                        r9.setRequestMethod(TapHttp.METHOD_POST);
                        r9.setDoOutput(true);
                        r9.setDoInput(true);
                        r9.setUseCaches(false);
                        OutputStream outputStream = r9.getOutputStream();
                        try {
                            outputStream.write(bArr);
                            outputStream.flush();
                            r9.connect();
                            r2 = 200;
                            if (r9.getResponseCode() == 200) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("--->>> send stateless message success : ");
                                sb.append(a.i);
                                sb.append("/");
                                sb.append(str);
                                UMRTLog.i(UMRTLog.RTLOG_TAG, sb.toString());
                                z = true;
                                r2 = sb;
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Exception e) {
                                }
                            }
                            if (r9 != 0) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
                                r9.disconnect();
                                r2 = r2;
                                r9 = r9;
                            }
                        } catch (SSLHandshakeException e2) {
                            e = e2;
                            r2 = outputStream;
                            MLog.e("SSLHandshakeException, Failed to send message.", e);
                            if (r2 != 0) {
                                try {
                                    r2.close();
                                } catch (Exception e3) {
                                }
                            }
                            if (r9 != 0) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
                                r9.disconnect();
                                r2 = r2;
                                r9 = r9;
                            }
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            r2 = outputStream;
                            if (r2 != 0) {
                                try {
                                    r2.close();
                                } catch (Exception e4) {
                                }
                            }
                            if (r9 == 0) {
                                throw th;
                            }
                            try {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
                                r9.disconnect();
                                throw th;
                            } catch (Throwable th2) {
                                throw th;
                            }
                        }
                    } catch (SSLHandshakeException e5) {
                        e = e5;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                }
            } catch (SSLHandshakeException e6) {
                e = e6;
                r9 = 0;
            } catch (Throwable th5) {
                th = th5;
                r9 = 0;
            }
            return z;
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
