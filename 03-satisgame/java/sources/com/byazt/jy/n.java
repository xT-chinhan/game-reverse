package com.byazt.jy;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.anythink.core.common.l.b;
import com.anythink.core.common.l.f;
import com.byakv.z.TTEncryptUtils;
import com.byazt.km.cp;
import com.byazt.km.q;
import com.byazt.km.sz;
import com.byazt.ko.fs;
import com.byazt.tk.k;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 995, 19})
public class n {
    public static volatile int fs;
    public static JSONObject n;
    public static volatile boolean rv;
    public static volatile boolean w;
    public static final String[] q = {TapHttp.METHOD_GET, TapHttp.METHOD_POST};
    public static final String[] l = {"aid", "app_version", "tt_data"};
    public static final String[] qg = {"aid", "version_code", "ab_client", "ab_version", "ab_feature", "ab_group", "iid", "device_platform"};
    public static final String[] s = {"tt_data", "device_platform"};
    public static Object x = new Object();

    public static boolean n(int i) {
        return i >= 500 && i < 600;
    }

    private static String n(String str) {
        if (TextUtils.isEmpty(str) || !com.byazt.wv.n.fs()) {
            return str;
        }
        Uri uri = Uri.parse(str);
        String query = uri.getQuery();
        ArrayList<Pair> arrayList = new ArrayList();
        for (String str2 : l) {
            String queryParameter = uri.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                arrayList.add(new Pair(str2, queryParameter));
            }
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (Pair pair : arrayList) {
            builderBuildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
        }
        builderBuildUpon.appendQueryParameter("tt_info", new String(Base64.encode(q.n(query), 8)));
        return builderBuildUpon.build().toString();
    }

    public static String n(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri uri = Uri.parse(str);
        HashMap map = new HashMap(strArr.length);
        for (String str2 : strArr) {
            String queryParameter = uri.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                map.put(str2, queryParameter);
            }
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (String str3 : map.keySet()) {
            builderBuildUpon.appendQueryParameter(str3, (String) map.get(str3));
        }
        return builderBuildUpon.build().toString();
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0205 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:0x01d6 A[EXC_TOP_SPLITTER, PHI: r0 r12
      0x01d6: PHI (r0v3 java.io.BufferedReader) = (r0v2 java.io.BufferedReader), (r0v13 java.io.BufferedReader) binds: [B:87:0x0208, B:74:0x01d4] A[DONT_GENERATE, DONT_INLINE]
      0x01d6: PHI (r12v3 java.lang.String) = (r12v2 java.lang.String), (r12v13 java.lang.String) binds: [B:87:0x0208, B:74:0x01d4] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x020f  */
    public static s n(int i, String str, HashMap<String, String> map, byte[] bArr) {
        DataOutputStream dataOutputStream;
        String string;
        BufferedReader bufferedReader;
        DataOutputStream dataOutputStream2;
        s sVar = new s(null, null);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i == 0) {
                httpURLConnection.setDoOutput(false);
            } else if (i == 1) {
                httpURLConnection.setDoOutput(true);
            } else {
                cp.qg((Throwable) null);
            }
            httpURLConnection.setRequestMethod(q[i]);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                    } else {
                        cp.qg((Throwable) null);
                    }
                }
            }
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (bArr == null || bArr.length <= 0) {
                dataOutputStream2 = null;
            } else {
                dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream2.write(bArr);
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    string = null;
                    bufferedReader = null;
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            if (str != null) {
                try {
                    if (str.contains("device_register_only")) {
                        JSONObject jSONObject = new JSONObject();
                        for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                            String key = entry2.getKey();
                            List<String> value = entry2.getValue();
                            if (key != null) {
                                jSONObject.put(key, n(value));
                            }
                        }
                        sVar.n(jSONObject);
                    }
                } catch (Exception e) {
                    k.qg("csj_log", "error:" + e.getMessage());
                }
            }
            if (responseCode == 200) {
                if (httpURLConnection.getContentLength() < 10240) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                        bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream)));
                    } else {
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    }
                    try {
                        StringBuilder sb = new StringBuilder(inputStream.available());
                        try {
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line).append("\n");
                                Throwable th2 = th;
                                dataOutputStream = dataOutputStream2;
                                th = th2;
                                try {
                                    com.byazt.nt.n.s("__kite", "error:" + th.getMessage());
                                    cp.qg(th);
                                    if (dataOutputStream != null) {
                                        try {
                                            dataOutputStream.close();
                                        } catch (IOException unused) {
                                        }
                                    }
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    if (cp.qg) {
                                        cp.n("http response: " + string, null);
                                    }
                                    sVar.n(string);
                                    return sVar;
                                } catch (Throwable th3) {
                                    if (dataOutputStream != null) {
                                        try {
                                            dataOutputStream.close();
                                        } catch (IOException unused3) {
                                        }
                                    }
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                            throw th3;
                                        } catch (IOException unused4) {
                                            throw th3;
                                        }
                                    }
                                    throw th3;
                                }
                            }
                            JSONObject jSONObject2 = new JSONObject(string);
                            jSONObject2.put("http_code", 200);
                            string = jSONObject2.toString();
                            if (com.byazt.nt.n.qg()) {
                                com.byazt.nt.n.n("__kite", "response:" + string + " X-Tt-Logid:" + httpURLConnection.getHeaderField("X-Tt-Logid"));
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            Throwable th5 = th;
                            dataOutputStream = dataOutputStream2;
                            th = th5;
                            com.byazt.nt.n.s("__kite", "error:" + th.getMessage());
                            cp.qg(th);
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        }
                        string = sb.toString();
                    } catch (Throwable th6) {
                        th = th6;
                        string = null;
                    }
                } else {
                    cp.qg((Throwable) null);
                    string = null;
                    bufferedReader = null;
                }
            } else {
                if (com.byazt.nt.n.qg()) {
                    com.byazt.nt.n.n("__kite", "error code:" + responseCode + " id:" + httpURLConnection.getHeaderField("X-Tt-Logid"));
                }
                String string2 = new JSONObject().put("http_code", responseCode).toString();
                try {
                    new RuntimeException("HttpCode:" + responseCode);
                    string = string2;
                    bufferedReader = null;
                } catch (Throwable th7) {
                    bufferedReader = null;
                    dataOutputStream = dataOutputStream2;
                    th = th7;
                    string = string2;
                    com.byazt.nt.n.s("__kite", "error:" + th.getMessage());
                    cp.qg(th);
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                }
            }
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.close();
                } catch (IOException unused5) {
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (Throwable th8) {
            th = th8;
            dataOutputStream = null;
            string = null;
            bufferedReader = null;
        }
        if (cp.qg) {
            cp.n("http response: " + string, null);
        }
        sVar.n(string);
        return sVar;
    }

    private static String n(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int size = list.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            if (str == null) {
                str = AbstractJsonLexerKt.NULL;
            }
            if (i == 0) {
                sb.append(str);
            } else {
                sb.append(", ").append(str);
            }
        }
        return sb.toString();
    }

    public static s n(String str, JSONObject jSONObject) {
        HashMap map = new HashMap(2);
        if (com.byazt.wv.n.fs()) {
            map.put(b.g, "application/octet-stream;tt-data=a");
        } else {
            map.put(b.g, "application/json; charset=utf-8");
        }
        return n(1, n(str), map, q.n(jSONObject.toString()));
    }

    public static String n(Context context, String str, byte[] bArr, String str2, boolean z, boolean z2) {
        byte[] bArrN;
        try {
            try {
                HashMap map = new HashMap();
                if (z) {
                    try {
                        bArrN = n(bArr);
                        map.put("Content-Encoding", "gzip");
                    } catch (Exception unused) {
                        return null;
                    }
                } else {
                    bArrN = n(context, bArr);
                    map.put("log-encode-type", "gzip");
                    str = str + "&tt_data=a";
                    if (z2) {
                        str = str + "&config_retry=b";
                    }
                    map.remove("Content-Encoding");
                    map.put(b.g, "application/octet-stream;tt-data=a");
                }
                if (!TextUtils.isEmpty(str2)) {
                    map.put(b.g, str2);
                }
                s sVarN = n(1, str, map, bArrN);
                if (sVarN != null) {
                    return sVarN.n();
                }
                return null;
            } catch (RuntimeException e) {
                com.byazt.nt.n.s("__kite", e.getMessage());
                return "";
            }
        } catch (Exception e2) {
            com.byazt.nt.n.s("__kite", e2.getMessage());
            return "";
        }
    }

    public static byte[] n(byte[] bArr) throws Exception {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream2.write(bArr);
                gZIPOutputStream2.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static byte[] n(Context context, byte[] bArr) throws Exception {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (context != null) {
                n(context);
                if (fs >= 3) {
                    return null;
                }
                byte[] bArrN = TTEncryptUtils.n(byteArray, byteArray.length);
                qg(context);
                return bArrN;
            }
            return TTEncryptUtils.n(byteArray, byteArray.length);
        } catch (Throwable th) {
            try {
                com.byazt.nt.n.s("__kite", "gzip " + th);
                return null;
            } finally {
                gZIPOutputStream.close();
            }
        }
    }

    private static void n(Context context) {
        if (w || context == null) {
            return;
        }
        synchronized (x) {
            try {
                SharedPreferences sharedPreferencesQg = sz.qg(context);
                fs = sharedPreferencesQg.getInt("app_log_encrypt_faild_count", 0);
                SharedPreferences.Editor editorEdit = sharedPreferencesQg.edit();
                editorEdit.putInt("app_log_encrypt_faild_count", fs + 1);
                editorEdit.apply();
                w = true;
            } catch (Throwable unused) {
            }
        }
    }

    private static void qg(Context context) {
        if (rv || context == null) {
            return;
        }
        synchronized (x) {
            try {
                SharedPreferences.Editor editorEdit = sz.qg(context).edit();
                if (fs > 2) {
                    fs -= 2;
                } else {
                    fs = 0;
                }
                editorEdit.putInt("app_log_encrypt_faild_count", fs);
                editorEdit.apply();
                rv = true;
            } catch (Throwable unused) {
            }
        }
    }

    public static int n(String[] strArr, byte[] bArr, fs fsVar) {
        JSONObject jSONObject;
        int iOptInt;
        HashMap map = new HashMap(2);
        if (com.byazt.wv.n.fs()) {
            map.put(b.g, "application/octet-stream;tt-data=a");
        } else {
            map.put(b.g, "application/json; charset=utf-8");
        }
        String strN = null;
        for (String str : strArr) {
            s sVarN = n(1, str, map, bArr);
            strN = sVarN != null ? sVarN.n() : null;
            if (!TextUtils.isEmpty(strN)) {
                break;
            }
        }
        try {
            if (TextUtils.isEmpty(strN)) {
                jSONObject = null;
                iOptInt = 0;
            } else {
                jSONObject = new JSONObject(strN);
                try {
                    iOptInt = jSONObject.optInt("http_code");
                    if (iOptInt == 200) {
                        if ("ss_app_log".equals(jSONObject.optString("magic_tag"))) {
                            iOptInt = "success".equals(jSONObject.optString("message")) ? 200 : Integer.valueOf("101").intValue();
                        } else {
                            iOptInt = Integer.valueOf("102").intValue();
                        }
                    }
                } catch (JSONException e) {
                    e = e;
                    cp.qg(e);
                    iOptInt = 0;
                }
            }
        } catch (JSONException e2) {
            e = e2;
            jSONObject = null;
        }
        if (iOptInt == 200) {
            try {
                long jOptLong = jSONObject.optLong("server_time");
                if (jOptLong > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("server_time", jOptLong);
                    jSONObject2.put("local_time", System.currentTimeMillis() / 1000);
                    n = jSONObject2;
                }
            } catch (Exception e3) {
                cp.qg(e3);
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("blacklist");
            if (jSONObjectOptJSONObject != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("v1");
                int length = jSONArrayOptJSONArray != null ? jSONArrayOptJSONArray.length() : 0;
                HashSet hashSet = new HashSet(length);
                for (int i = 0; i < length; i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i, null);
                    if (!TextUtils.isEmpty(strOptString)) {
                        hashSet.add(strOptString);
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("v3");
                int length2 = jSONArrayOptJSONArray2 != null ? jSONArrayOptJSONArray2.length() : 0;
                HashSet hashSet2 = new HashSet(length2);
                for (int i2 = 0; i2 < length2; i2++) {
                    String strOptString2 = jSONArrayOptJSONArray2.optString(i2, null);
                    if (!TextUtils.isEmpty(strOptString2)) {
                        hashSet2.add(strOptString2);
                    }
                }
            }
        }
        return iOptInt;
    }

    public static JSONObject qg(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        HashMap map = new HashMap(2);
        if (com.byazt.wv.n.fs()) {
            map.put(b.g, "application/octet-stream;tt-data=a");
        } else {
            map.put(b.g, "application/json; charset=utf-8");
        }
        s sVarN = n(1, str, map, q.n(jSONObject.toString()));
        if (sVarN == null || sVarN.n() == null) {
            jSONObject2 = null;
        } else {
            try {
                jSONObject2 = new JSONObject(sVarN.n());
            } catch (JSONException unused) {
                jSONObject2 = null;
            }
        }
        if (jSONObject2 != null && "ss_app_log".equals(jSONObject2.optString("magic_tag", ""))) {
            return jSONObject2.optJSONObject("config");
        }
        return null;
    }

    public static JSONObject s(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        s sVarN = n(1, str, null, q.n(jSONObject.toString()));
        if (sVarN == null || sVarN.n() == null) {
            jSONObject2 = null;
        } else {
            try {
                jSONObject2 = new JSONObject(sVarN.n());
            } catch (JSONException unused) {
                jSONObject2 = null;
            }
        }
        if (jSONObject2 != null && "success".equals(jSONObject2.optString("message", ""))) {
            return jSONObject2.optJSONObject(f.R);
        }
        return null;
    }
}
