package com.byazt.tv;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.ec.TTEncryptUtils;
import com.byazt.vlj.zo;
import com.byazt.wf.vk;
import com.efs.sdk.base.Constants;
import com.taptap.sdk.kit.internal.http.TapHttp;
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
@com.byazt.vzx.pr(pr = {0, 1, 1488, 13})
public class hw {
    public static hn hw;
    public static boolean pr = false;

    public static uc pr(long j, String str, byte[] bArr, pr prVar, String str2, boolean z) throws IOException {
        String str3;
        byte[] bArrPr;
        String str4;
        String str5;
        if (str == null) {
            return new uc(201);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        if (pr.GZIP == prVar && length > 128) {
            byte[] bArrHw = hw(bArr);
            str3 = Constants.CP_GZIP;
            bArrPr = bArrHw;
        } else if (pr.DEFLATER == prVar && length > 128) {
            str3 = "deflate";
            bArrPr = pr(bArr);
        } else {
            str3 = null;
            bArrPr = bArr;
        }
        if (bArrPr == null) {
            return new uc(202);
        }
        if (z) {
            byte[] bArrA = TTEncryptUtils.a(bArrPr, bArrPr.length);
            if (bArrA != null) {
                if (TextUtils.isEmpty(new URL(str).getQuery())) {
                    if (!str.endsWith("?")) {
                        str = str + "?";
                    }
                } else if (!str.endsWith("&")) {
                    str = str + "&";
                }
                bArrPr = bArrA;
                str4 = str + "encrypt=true";
                str5 = "application/octet-stream;tt-data=a";
            } else {
                str4 = str;
                str5 = str2;
            }
            return pr(str4, bArrPr, str5, str3, TapHttp.METHOD_POST, true, true);
        }
        return pr(str, bArrPr, str2, str3, TapHttp.METHOD_POST, true, false);
    }

    private static byte[] pr(byte[] bArr) {
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

    private static byte[] hw(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                vk.hw(th);
                return null;
            } finally {
                gZIPOutputStream.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0113 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    private static uc pr(String str, byte[] bArr, String str2, String str3, String str4, boolean z, boolean z2) {
        InputStream inputStream;
        byte[] bArrPr;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection = null;
        GZIPInputStream gZIPInputStream = null;
        try {
            hn hnVar = hw;
            if (hnVar != null) {
                str = hnVar.pr(str, bArr);
            }
            LinkedList<Pair> linkedList = new LinkedList();
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) (z2 ? new URL(com.byazt.asx.pr.pr(str, linkedList)) : new URL(str)).openConnection();
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
                        vk.hw(th);
                        return new uc(207, th);
                    } finally {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception e) {
                            }
                        }
                        com.byazt.wf.uc.pr(inputStream);
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
                        com.byazt.wf.uc.pr(dataOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        com.byazt.wf.uc.pr(dataOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataOutputStream = null;
                }
            }
            int responseCode = httpURLConnection2.getResponseCode();
            if (responseCode != 200) {
                uc ucVar = new uc(206, "http response code " + responseCode);
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception e2) {
                    }
                }
                com.byazt.wf.uc.pr(null);
                return ucVar;
            }
            inputStream = httpURLConnection2.getInputStream();
            try {
                if (Constants.CP_GZIP.equalsIgnoreCase(httpURLConnection2.getContentEncoding())) {
                    try {
                        GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
                        try {
                            bArrPr = pr(gZIPInputStream2);
                            com.byazt.wf.uc.pr(gZIPInputStream2);
                        } catch (Throwable th4) {
                            th = th4;
                            gZIPInputStream = gZIPInputStream2;
                            com.byazt.wf.uc.pr(gZIPInputStream);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } else {
                    bArrPr = pr(inputStream);
                }
                uc ucVarHn = hn(bArrPr);
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception e3) {
                    }
                }
                com.byazt.wf.uc.pr(inputStream);
                return ucVarHn;
            } catch (Throwable th6) {
                httpURLConnection = httpURLConnection2;
                th = th6;
                vk.hw(th);
                return new uc(207, th);
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
        }
    }

    private static uc hn(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new uc(203);
        }
        String str = new String(bArr, Charset.forName("utf-8"));
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() > 0) {
                return new uc(0, jSONObject);
            }
            return new uc(204, str);
        } catch (JSONException e) {
            return new uc(204, str);
        }
    }

    public static uc pr(String str, String str2) {
        return pr(str, str2, pr());
    }

    public static boolean pr() {
        return true;
    }

    public static boolean hw() {
        return true;
    }

    public static String pr(Map map) {
        return zo.c().pr();
    }

    public static String hw(Map map) {
        return zo.c().hw();
    }

    public static uc pr(c cVar) {
        if (cVar == null) {
            return new uc(201);
        }
        try {
            return pr(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, cVar.pr(), cVar.hn(), pr.GZIP, "application/json; charset=utf-8", cVar.hw());
        } catch (Throwable th) {
            vk.hw(th);
            return new uc(207, th);
        }
    }

    public static uc pr(String str, String str2, boolean z) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                return pr(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, str, str2.getBytes(), pr.GZIP, "application/json; charset=utf-8", z);
            }
            return new uc(201);
        } catch (Throwable th) {
            vk.hw(th);
            return new uc(207, th);
        }
    }

    private static byte[] pr(InputStream inputStream) throws IOException {
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
                    com.byazt.wf.uc.pr(byteArrayOutputStream);
                }
            }
        }
    }

    public enum pr {
        NONE(0),
        GZIP(1),
        DEFLATER(2);

        public final int x;

        pr(int i) {
            this.x = i;
        }
    }

    /* JADX INFO: renamed from: com.byazt.tv.hw$hw, reason: collision with other inner class name */
    public enum EnumC0202hw {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);

        public final int fw;

        EnumC0202hw(int i) {
            this.fw = i;
        }
    }
}
