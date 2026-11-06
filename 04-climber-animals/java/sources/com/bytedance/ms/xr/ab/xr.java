package com.bytedance.ms.xr.ab;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.ms.xr.x;
import com.bytedance.ms.xr.x.ch;
import com.efs.sdk.base.Constants;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static boolean f554ms = false;
    private static ah xr;

    public static boolean ms() {
        return true;
    }

    public static boolean xr() {
        return true;
    }

    public static c ms(long j, String str, byte[] bArr, ms msVar, String str2, boolean z) throws IOException {
        String str3;
        if (str == null) {
            return new c(201);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        if (ms.GZIP == msVar && length > 128) {
            bArr = xr(bArr);
            str3 = Constants.CP_GZIP;
        } else if (ms.DEFLATER != msVar || length <= 128) {
            str3 = null;
        } else {
            bArr = ms(bArr);
            str3 = "deflate";
        }
        String str4 = str3;
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return new c(202);
        }
        if (z) {
            byte[] bArrA = TTEncryptUtils.a(bArr2, bArr2.length);
            if (bArrA != null) {
                if (TextUtils.isEmpty(new URL(str).getQuery())) {
                    if (!str.endsWith("?")) {
                        str = str + "?";
                    }
                } else if (!str.endsWith("&")) {
                    str = str + "&";
                }
                str = str + "encrypt=true";
                str2 = "application/octet-stream;tt-data=a";
                bArr2 = bArrA;
            }
            return ms(str, bArr2, str2, str4, "POST", true, true);
        }
        return ms(str, bArr2, str2, str4, "POST", true, false);
    }

    private static byte[] ms(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] xr(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                ch.xr(th);
                return null;
            } finally {
                gZIPOutputStream.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:88:0x010c A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    private static c ms(String str, byte[] bArr, String str2, String str3, String str4, boolean z, boolean z2) {
        InputStream inputStream;
        byte[] bArrMs;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection = null;
        GZIPInputStream gZIPInputStream = null;
        try {
            ah ahVar = xr;
            if (ahVar != null) {
                str = ahVar.ms(str, bArr);
            }
            LinkedList<Pair> linkedList = new LinkedList();
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) (z2 ? new URL(com.bytedance.ms.ah.ms.ms.ms.ms(str, linkedList)) : new URL(str)).openConnection();
            if (z2) {
                try {
                    if (!linkedList.isEmpty()) {
                        for (Pair pair : linkedList) {
                            if (pair != null) {
                                httpURLConnection2.setRequestProperty((String) pair.first, (String) pair.second);
                            }
                        }
                    }
                } catch (Throwable th) {
                    httpURLConnection = httpURLConnection2;
                    th = th;
                    inputStream = null;
                    try {
                        ch.xr(th);
                        return new c(207, th);
                    } finally {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused) {
                            }
                        }
                        com.bytedance.ms.xr.x.c.ms(inputStream);
                    }
                }
            }
            if (z) {
                httpURLConnection2.setDoOutput(true);
            } else {
                httpURLConnection2.setDoOutput(false);
            }
            if (str2 != null) {
                httpURLConnection2.setRequestProperty("Content-Type", str2);
            }
            if (str3 != null) {
                httpURLConnection2.setRequestProperty("Content-Encoding", str3);
            }
            httpURLConnection2.setRequestProperty("Accept-Encoding", Constants.CP_GZIP);
            if (str4 == null) {
                throw new IllegalArgumentException("request method is not null");
            }
            httpURLConnection2.setRequestMethod(str4);
            if (bArr != null && bArr.length > 0) {
                try {
                    dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                    try {
                        dataOutputStream.write(bArr);
                        dataOutputStream.flush();
                        com.bytedance.ms.xr.x.c.ms(dataOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        com.bytedance.ms.xr.x.c.ms(dataOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataOutputStream = null;
                }
            }
            int responseCode = httpURLConnection2.getResponseCode();
            if (responseCode != 200) {
                c cVar = new c(206, "http response code " + responseCode);
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception unused2) {
                    }
                }
                com.bytedance.ms.xr.x.c.ms(null);
                return cVar;
            }
            inputStream = httpURLConnection2.getInputStream();
            try {
                if (Constants.CP_GZIP.equalsIgnoreCase(httpURLConnection2.getContentEncoding())) {
                    try {
                        GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
                        try {
                            bArrMs = ms(gZIPInputStream2);
                            com.bytedance.ms.xr.x.c.ms(gZIPInputStream2);
                        } catch (Throwable th4) {
                            th = th4;
                            gZIPInputStream = gZIPInputStream2;
                            com.bytedance.ms.xr.x.c.ms(gZIPInputStream);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } else {
                    bArrMs = ms(inputStream);
                }
                c cVarAh = ah(bArrMs);
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception unused3) {
                    }
                }
                com.bytedance.ms.xr.x.c.ms(inputStream);
                return cVarAh;
            } catch (Throwable th6) {
                httpURLConnection = httpURLConnection2;
                th = th6;
                ch.xr(th);
                return new c(207, th);
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
        }
    }

    private static c ah(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new c(203);
        }
        String str = new String(bArr, Charset.forName("utf-8"));
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() > 0) {
                return new c(0, jSONObject);
            }
            return new c(204, str);
        } catch (JSONException unused) {
            return new c(204, str);
        }
    }

    public static c ms(String str, String str2) {
        return ms(str, str2, ms());
    }

    public static String ms(Map map) {
        return x.ka().ms();
    }

    public static String xr(Map map) {
        return x.ka().xr();
    }

    public static c ms(ka kaVar) {
        if (kaVar == null) {
            return new c(201);
        }
        try {
            return ms(com.anythink.basead.exoplayer.j.a.c.a, kaVar.ms(), kaVar.ah(), ms.GZIP, "application/json; charset=utf-8", kaVar.xr());
        } catch (Throwable th) {
            ch.xr(th);
            return new c(207, th);
        }
    }

    public static c ms(String str, String str2, boolean z) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                return ms(com.anythink.basead.exoplayer.j.a.c.a, str, str2.getBytes(), ms.GZIP, "application/json; charset=utf-8", z);
            }
            return new c(201);
        } catch (Throwable th) {
            ch.xr(th);
            return new c(207, th);
        }
    }

    private static byte[] ms(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 != i) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    com.bytedance.ms.xr.x.c.ms(byteArrayOutputStream);
                }
            }
        }
    }

    public enum ms {
        NONE(0),
        GZIP(1),
        DEFLATER(2);

        final int d;

        ms(int i) {
            this.d = i;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ms.xr.ab.xr$xr, reason: collision with other inner class name */
    public enum EnumC0216xr {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);

        final int ab;

        EnumC0216xr(int i) {
            this.ab = i;
        }
    }
}
