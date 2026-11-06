package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: HttpClient.java */
/* JADX INFO: loaded from: classes4.dex */
public class cc {
    private static final String a = "HttpClient";
    private static HostnameVerifier f;
    private String b;
    private a c;
    private Map<String, String> d;
    private cd e;

    /* JADX INFO: compiled from: HttpClient.java */
    public enum a {
        POST,
        GET
    }

    public cc(String str, a aVar, Map<String, String> map, cd cdVar) {
        this.b = str;
        this.c = aVar;
        this.d = map;
        this.e = cdVar;
    }

    private static HostnameVerifier a() {
        if (f == null) {
            f = new HostnameVerifier() { // from class: com.umeng.analytics.pro.cc.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return !TextUtils.isEmpty(str) && ca.a.equalsIgnoreCase(str);
                }
            };
        }
        return f;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00e4 A[PHI: r1
      0x00e4: PHI (r1v12 javax.net.ssl.HttpsURLConnection) = 
      (r1v6 javax.net.ssl.HttpsURLConnection)
      (r1v7 javax.net.ssl.HttpsURLConnection)
      (r1v8 javax.net.ssl.HttpsURLConnection)
      (r1v9 javax.net.ssl.HttpsURLConnection)
      (r1v10 javax.net.ssl.HttpsURLConnection)
      (r1v11 javax.net.ssl.HttpsURLConnection)
      (r1v15 javax.net.ssl.HttpsURLConnection)
     binds: [B:42:0x00ce, B:45:0x00d2, B:48:0x00d6, B:51:0x00da, B:54:0x00de, B:57:0x00e2, B:39:0x00ca] A[DONT_GENERATE, DONT_INLINE]] */
    public String a(int i, String str) {
        HttpsURLConnection httpsURLConnection;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(this.b).openConnection();
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, new SecureRandom());
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection.setHostnameVerifier(a());
                Map<String, String> map = this.d;
                if (map != null && !map.isEmpty()) {
                    for (String str2 : this.d.keySet()) {
                        if (!TextUtils.isEmpty(str2)) {
                            httpsURLConnection.setRequestProperty(str2, this.d.get(str2));
                        }
                    }
                }
                httpsURLConnection.setConnectTimeout(i);
                httpsURLConnection.setReadTimeout(i);
                if (this.c == a.POST) {
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setDefaultUseCaches(false);
                    if (!TextUtils.isEmpty(str)) {
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpsURLConnection.getOutputStream());
                        outputStreamWriter.write(str);
                        outputStreamWriter.flush();
                        outputStreamWriter.close();
                    }
                    httpsURLConnection.connect();
                } else {
                    httpsURLConnection.setRequestMethod("GET");
                }
                if (httpsURLConnection.getResponseCode() != 200) {
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    return null;
                }
                InputStream inputStream = httpsURLConnection.getInputStream();
                byte[] streamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                String str3 = "";
                if (streamToByteArray != null) {
                    try {
                        if (streamToByteArray.length > 1) {
                            str3 = new String(streamToByteArray);
                        }
                    } catch (Throwable th) {
                        HelperUtils.safeClose(inputStream);
                        throw th;
                    }
                }
                cd cdVar = this.e;
                if (cdVar != null) {
                    cdVar.a(str3);
                }
                HelperUtils.safeClose(inputStream);
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                return str3;
            } catch (MalformedURLException unused) {
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
            } catch (SocketTimeoutException unused2) {
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
            } catch (UnknownHostException unused3) {
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
            } catch (SSLHandshakeException unused4) {
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
            } catch (IOException unused5) {
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
            } catch (Throwable unused6) {
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
            }
        } catch (MalformedURLException unused7) {
            httpsURLConnection = null;
        } catch (SocketTimeoutException unused8) {
            httpsURLConnection = null;
        } catch (UnknownHostException unused9) {
            httpsURLConnection = null;
        } catch (SSLHandshakeException unused10) {
            httpsURLConnection = null;
        } catch (IOException unused11) {
            httpsURLConnection = null;
        } catch (Throwable unused12) {
            httpsURLConnection = null;
        }
    }
}
