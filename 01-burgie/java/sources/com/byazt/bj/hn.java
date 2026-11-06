package com.byazt.bj;

import com.byazt.dea.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FEED_PACKET_UNTIL_EMPTY, 20})
public class hn {
    private hn() {
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FEED_PACKET_UNTIL_EMPTY, 116})
    private static final class pr {
        public static final hn pr = new hn();
    }

    public static hn pr() {
        return pr.pr;
    }

    public void pr(String str, String str2, String str3, EventListener eventListener) throws Throwable {
        x xVar;
        HttpsURLConnection httpsURLConnection = null;
        try {
            try {
                URL url = new URL(str);
                HttpsURLConnection.setDefaultSSLSocketFactory(pr(hw()));
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                try {
                    httpsURLConnection2.setConnectTimeout(5000);
                    httpsURLConnection2.setHostnameVerifier(com.byazt.bj.pr.pr);
                    httpsURLConnection2.setRequestMethod(TapHttp.METHOD_GET);
                    if (httpsURLConnection2.getResponseCode() == 200 && pr(httpsURLConnection2.getInputStream(), str2, str3, eventListener)) {
                        eventListener.onEvent(0, new x(str2 + "/" + str3));
                    }
                    if (httpsURLConnection2 != null) {
                        try {
                            httpsURLConnection2.disconnect();
                        } catch (Exception e) {
                            xVar = new x(e.getMessage());
                            eventListener.onEvent(2, xVar);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    httpsURLConnection = httpsURLConnection2;
                    uc.pr(e);
                    eventListener.onEvent(1, new x(e.getMessage()));
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.disconnect();
                        } catch (Exception e3) {
                            xVar = new x(e3.getMessage());
                            eventListener.onEvent(2, xVar);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    httpsURLConnection = httpsURLConnection2;
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.disconnect();
                        } catch (Exception e4) {
                            eventListener.onEvent(2, new x(e4.getMessage()));
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

    public boolean pr(InputStream inputStream, String str, String str2, EventListener eventListener) throws Throwable {
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
                        } catch (Exception e) {
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
                    } catch (Exception e2) {
                        return true;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (inputStream == null) {
                        throw th;
                    }
                    try {
                        inputStream.close();
                        throw th;
                    } catch (Exception e5) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
        eventListener.onEvent(3, new x(e.getMessage()));
        uc.hw("NetApi", "save error: ", e);
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e7) {
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e8) {
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public String pr(boolean z, String str, byte[] bArr) throws Throwable {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2 = 0;
        try {
            try {
                try {
                    URL url = new URL(str);
                    HttpsURLConnection.setDefaultSSLSocketFactory(pr(hw()));
                    httpsURLConnection = (HttpsURLConnection) url.openConnection();
                    try {
                        httpsURLConnection.setConnectTimeout(5000);
                        httpsURLConnection.setHostnameVerifier(com.byazt.bj.pr.pr);
                        if (!z || bArr == null || bArr.length == 0) {
                            httpsURLConnection.setRequestMethod(TapHttp.METHOD_GET);
                        } else {
                            httpsURLConnection.setDoOutput(true);
                            httpsURLConnection.setFixedLengthStreamingMode(bArr.length);
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpsURLConnection.getOutputStream());
                            bufferedOutputStream.write(bArr);
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            httpsURLConnection.setRequestMethod(TapHttp.METHOD_POST);
                        }
                        int responseCode = httpsURLConnection.getResponseCode();
                        if (responseCode < 200 || responseCode >= 300) {
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            return null;
                        }
                        String str2 = new String(pr(httpsURLConnection.getInputStream(), 1024), pr(httpsURLConnection.getHeaderField("Content-Type"), "utf-8"));
                        if (httpsURLConnection != null) {
                            try {
                                httpsURLConnection.disconnect();
                            } catch (Exception e) {
                            }
                        }
                        return str2;
                    } catch (Exception e2) {
                        e = e2;
                        uc.pr(e);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    httpsURLConnection2 = str;
                    if (httpsURLConnection2 != 0) {
                        try {
                            httpsURLConnection2.disconnect();
                        } catch (Exception e3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                httpsURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                if (httpsURLConnection2 != 0) {
                    httpsURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e5) {
        }
        return null;
    }

    private static byte[] pr(InputStream inputStream, int i) throws IOException {
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

    private static String pr(String str, String str2) {
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

    private SSLSocketFactory pr(X509TrustManager x509TrustManager) throws IOException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new IOException("No System TLS", e);
        }
    }

    private X509TrustManager hw() throws IOException {
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
