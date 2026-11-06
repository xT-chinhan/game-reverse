package com.byazt.jn;

import com.anythink.core.common.l.b;
import com.byazt.vx.w;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1490, 8})
public class s {
    private s() {
    }

    @com.byazt.cp.n(n = {0, 1, 1490, 546})
    private static final class n {
        public static final s n = new s();
    }

    public static s n() {
        return n.n;
    }

    public void n(String str, String str2, String str3, EventListener eventListener) throws Throwable {
        q qVar;
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                URL url = new URL(str);
                HttpsURLConnection.setDefaultSSLSocketFactory(n(qg()));
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                try {
                    httpsURLConnection2.setConnectTimeout(5000);
                    httpsURLConnection2.setHostnameVerifier(com.byazt.jn.n.n);
                    httpsURLConnection2.setRequestMethod(TapHttp.METHOD_GET);
                    if (httpsURLConnection2.getResponseCode() == 200 && n(httpsURLConnection2.getInputStream(), str2, str3, eventListener)) {
                        eventListener.onEvent(0, new q(str2 + "/" + str3));
                    }
                    if (httpsURLConnection2 != null) {
                        try {
                            httpsURLConnection2.disconnect();
                        } catch (Exception e) {
                            qVar = new q(e.getMessage());
                            eventListener.onEvent(2, qVar);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    httpsURLConnection = httpsURLConnection2;
                    w.n(e);
                    eventListener.onEvent(1, new q(e.getMessage()));
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.disconnect();
                        } catch (Exception e3) {
                            qVar = new q(e3.getMessage());
                            eventListener.onEvent(2, qVar);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    httpsURLConnection = httpsURLConnection2;
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.disconnect();
                        } catch (Exception e4) {
                            eventListener.onEvent(2, new q(e4.getMessage()));
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    public boolean n(InputStream inputStream, String str, String str2, EventListener eventListener) throws Throwable {
        if (inputStream == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists() && !file.mkdirs()) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, str2));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                    }
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    inputStream.close();
                    if (inputStream == null) {
                        return true;
                    }
                    try {
                        inputStream.close();
                        return true;
                    } catch (Exception unused2) {
                        return true;
                    }
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (inputStream == null) {
                        throw th;
                    }
                    try {
                        inputStream.close();
                        throw th;
                    } catch (Exception unused4) {
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        eventListener.onEvent(3, new q(e.getMessage()));
        w.qg("NetApi", "save error: ", e);
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception unused5) {
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused6) {
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x007c A[EXC_TOP_SPLITTER, PHI: r5
      0x007c: PHI (r5v4 javax.net.ssl.HttpsURLConnection) = (r5v3 javax.net.ssl.HttpsURLConnection), (r5v8 javax.net.ssl.HttpsURLConnection) binds: [B:30:0x0089, B:20:0x007a] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public String n(boolean z, String str, byte[] bArr) throws Throwable {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            URL url = new URL(str);
            HttpsURLConnection.setDefaultSSLSocketFactory(n(qg()));
            httpsURLConnection = (HttpsURLConnection) url.openConnection();
            try {
                try {
                    httpsURLConnection.setConnectTimeout(5000);
                    httpsURLConnection.setHostnameVerifier(com.byazt.jn.n.n);
                    if (z && bArr != null && bArr.length != 0) {
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setFixedLengthStreamingMode(bArr.length);
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpsURLConnection.getOutputStream());
                        bufferedOutputStream.write(bArr);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        httpsURLConnection.setRequestMethod(TapHttp.METHOD_POST);
                    } else {
                        httpsURLConnection.setRequestMethod(TapHttp.METHOD_GET);
                    }
                    int responseCode = httpsURLConnection.getResponseCode();
                    if (responseCode >= 200 && responseCode < 300) {
                        String str2 = new String(n(httpsURLConnection.getInputStream(), 1024), n(httpsURLConnection.getHeaderField(b.g), "utf-8"));
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.disconnect();
                            } catch (Exception unused) {
                            }
                        }
                        return str2;
                    }
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.disconnect();
                        } catch (Exception unused2) {
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    w.n(e);
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                }
            } catch (Throwable th) {
                th = th;
                httpsURLConnection2 = httpsURLConnection;
                if (httpsURLConnection2 != null) {
                    try {
                        httpsURLConnection2.disconnect();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            httpsURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            if (httpsURLConnection2 != null) {
                httpsURLConnection2.disconnect();
            }
            throw th;
        }
        return null;
    }

    private static byte[] n(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            return null;
        }
        if (i <= 0) {
            i = 1;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 != -1) {
                byteArrayOutputStream.write(bArr, 0, i2);
            } else {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private static String n(String str, String str2) {
        if (str != null) {
            String[] strArrSplit = str.split(";", 0);
            for (int i = 1; i < strArrSplit.length; i++) {
                String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
        }
        return str2;
    }

    private SSLSocketFactory n(X509TrustManager x509TrustManager) throws IOException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new IOException("No System TLS", e);
        }
    }

    private X509TrustManager qg() throws IOException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw new IOException("No System TLS", e);
        }
    }
}
