package com.byazt.yj;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.byakv.z.TTEncryptUtils;
import com.byazt.ca.ho;
import com.byazt.ec.g;
import com.byazt.ec.w;
import com.byazt.ec.x;
import com.byazt.xa.zo;
import com.efs.sdk.base.Constants;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
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
@com.byazt.vzx.pr(pr = {0, 1, 2298, 37})
public class pr {
    public static volatile boolean aj;
    public static JSONObject pr;
    public static volatile boolean uc;
    public static volatile int zo;
    public static final String[] x = {TapHttp.METHOD_GET, TapHttp.METHOD_POST};
    public static final String[] c = {"aid", "app_version", "tt_data"};
    public static final String[] hw = {"aid", "version_code", "ab_client", "ab_version", "ab_feature", "ab_group", "iid", "device_platform"};
    public static final String[] hn = {"tt_data", "device_platform"};
    public static Object fw = new Object();

    private static String pr(String str) {
        if (TextUtils.isEmpty(str) || !com.byazt.zrg.pr.zo()) {
            return str;
        }
        Uri uri = Uri.parse(str);
        String query = uri.getQuery();
        ArrayList<Pair> arrayList = new ArrayList();
        for (String str2 : c) {
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
        builderBuildUpon.appendQueryParameter("tt_info", new String(Base64.encode(x.pr(query), 8)));
        return builderBuildUpon.build().toString();
    }

    public static String pr(String str, String[] strArr) {
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

    /* JADX WARN: Code duplicated, block: B:101:0x021c  */
    /* JADX WARN: Code duplicated, block: B:128:0x020d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x0214 A[Catch: IOException -> 0x01e0, TRY_ENTER, TRY_LEAVE, TryCatch #10 {IOException -> 0x01e0, blocks: (B:80:0x01dc, B:97:0x0214), top: B:134:0x000e }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.HashMap, java.util.HashMap<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v33 */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.byazt.yj.hn] */
    public static hn pr(int i, String str, HashMap<String, String> map, byte[] bArr) {
        DataOutputStream dataOutputStream;
        BufferedReader bufferedReader;
        DataOutputStream dataOutputStream2;
        String string;
        ?? hnVar = new hn(null, null);
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                if (i == 0) {
                    httpURLConnection.setDoOutput(false);
                } else if (i == 1) {
                    httpURLConnection.setDoOutput(true);
                } else {
                    w.hw((Throwable) null);
                }
                httpURLConnection.setRequestMethod(x[i]);
                if (map != 0 && !map.isEmpty()) {
                    for (Map.Entry entry : map.entrySet()) {
                        if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                            httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        } else {
                            w.hw((Throwable) null);
                        }
                    }
                }
                httpURLConnection.setRequestProperty("Accept-Encoding", Constants.CP_GZIP);
                if (bArr != null && bArr.length > 0) {
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
                } else {
                    dataOutputStream2 = null;
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
                                    jSONObject.put(key, pr(value));
                                }
                            }
                            hnVar.pr(jSONObject);
                        }
                    } catch (Exception e) {
                        ho.hw("csj_log", "error:" + e.getMessage());
                    }
                }
                if (responseCode == 200) {
                    if (httpURLConnection.getContentLength() < 10240) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        if (Constants.CP_GZIP.equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
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
                                    map = string;
                                    try {
                                        com.byazt.wx.pr.hn("__kite", "error:" + th.getMessage());
                                        w.hw(th);
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (IOException e2) {
                                            }
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                            map = map;
                                        }
                                        if (w.hw) {
                                            w.pr("http response: " + map, null);
                                        }
                                        hnVar.pr(map);
                                        return hnVar;
                                    } catch (Throwable th3) {
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (IOException e3) {
                                            }
                                        }
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                                throw th3;
                                            } catch (IOException e4) {
                                                throw th3;
                                            }
                                        }
                                        throw th3;
                                    }
                                }
                                JSONObject jSONObject2 = new JSONObject(string);
                                jSONObject2.put("http_code", 200);
                                string = jSONObject2.toString();
                                map = string;
                                if (com.byazt.wx.pr.hw()) {
                                    com.byazt.wx.pr.pr("__kite", "response:" + string + " X-Tt-Logid:" + httpURLConnection.getHeaderField("X-Tt-Logid"));
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                Throwable th5 = th;
                                dataOutputStream = dataOutputStream2;
                                th = th5;
                                map = string;
                                com.byazt.wx.pr.hn("__kite", "error:" + th.getMessage());
                                w.hw(th);
                                if (dataOutputStream != null) {
                                    dataOutputStream.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                    map = map;
                                }
                                if (w.hw) {
                                    w.pr("http response: " + map, null);
                                }
                                hnVar.pr(map);
                                return hnVar;
                            }
                            string = sb.toString();
                        } catch (Throwable th6) {
                            th = th6;
                            string = null;
                        }
                    } else {
                        w.hw((Throwable) null);
                        map = 0;
                        bufferedReader = null;
                    }
                } else {
                    if (com.byazt.wx.pr.hw()) {
                        com.byazt.wx.pr.pr("__kite", "error code:" + responseCode + " id:" + httpURLConnection.getHeaderField("X-Tt-Logid"));
                    }
                    String string2 = new JSONObject().put("http_code", responseCode).toString();
                    try {
                        new RuntimeException("HttpCode:" + responseCode);
                        map = string2;
                        bufferedReader = null;
                    } catch (Throwable th7) {
                        bufferedReader = null;
                        dataOutputStream = dataOutputStream2;
                        th = th7;
                        map = string2;
                        com.byazt.wx.pr.hn("__kite", "error:" + th.getMessage());
                        w.hw(th);
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                            map = map;
                        }
                        if (w.hw) {
                            w.pr("http response: " + map, null);
                        }
                        hnVar.pr(map);
                        return hnVar;
                    }
                }
                if (dataOutputStream2 != null) {
                    try {
                        map = string;
                        dataOutputStream2.close();
                    } catch (IOException e5) {
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                    map = map;
                }
            } catch (Throwable th8) {
                th = th8;
                dataOutputStream = null;
                map = 0;
                bufferedReader = null;
            }
        } catch (IOException e6) {
        }
        if (w.hw) {
            w.pr("http response: " + map, null);
        }
        hnVar.pr(map);
        return hnVar;
    }

    private static String pr(List<String> list) {
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

    public static hn pr(String str, JSONObject jSONObject) {
        HashMap map = new HashMap(2);
        if (com.byazt.zrg.pr.zo()) {
            map.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            map.put("Content-Type", "application/json; charset=utf-8");
        }
        return pr(1, pr(str), map, x.pr(jSONObject.toString()));
    }

    public static String pr(Context context, String str, byte[] bArr, String str2, boolean z, boolean z2) {
        byte[] bArrPr;
        try {
            try {
                HashMap map = new HashMap();
                if (z) {
                    try {
                        bArrPr = pr(bArr);
                        map.put("Content-Encoding", Constants.CP_GZIP);
                    } catch (Exception e) {
                        return null;
                    }
                } else {
                    bArrPr = pr(context, bArr);
                    map.put("log-encode-type", Constants.CP_GZIP);
                    str = str + "&tt_data=a";
                    if (z2) {
                        str = str + "&config_retry=b";
                    }
                    map.remove("Content-Encoding");
                    map.put("Content-Type", "application/octet-stream;tt-data=a");
                }
                if (!TextUtils.isEmpty(str2)) {
                    map.put("Content-Type", str2);
                }
                hn hnVarPr = pr(1, str, map, bArrPr);
                if (hnVarPr != null) {
                    return hnVarPr.pr();
                }
                return null;
            } catch (RuntimeException e2) {
                com.byazt.wx.pr.hn("__kite", e2.getMessage());
                return "";
            }
        } catch (Exception e3) {
            com.byazt.wx.pr.hn("__kite", e3.getMessage());
            return "";
        }
    }

    public static byte[] pr(byte[] bArr) throws Exception {
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

    private static byte[] pr(Context context, byte[] bArr) throws Exception {
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
                pr(context);
                if (zo >= 3) {
                    return null;
                }
                byte[] bArrPr = TTEncryptUtils.pr(byteArray, byteArray.length);
                hw(context);
                return bArrPr;
            }
            return TTEncryptUtils.pr(byteArray, byteArray.length);
        } catch (Throwable th) {
            try {
                com.byazt.wx.pr.hn("__kite", "gzip " + th);
                return null;
            } finally {
                gZIPOutputStream.close();
            }
        }
    }

    private static void pr(Context context) {
        if (uc || context == null) {
            return;
        }
        synchronized (fw) {
            try {
                SharedPreferences sharedPreferencesHw = g.hw(context);
                zo = sharedPreferencesHw.getInt("app_log_encrypt_faild_count", 0);
                SharedPreferences.Editor editorEdit = sharedPreferencesHw.edit();
                editorEdit.putInt("app_log_encrypt_faild_count", zo + 1);
                editorEdit.apply();
                uc = true;
            } catch (Throwable th) {
            }
        }
    }

    private static void hw(Context context) {
        if (aj || context == null) {
            return;
        }
        synchronized (fw) {
            try {
                SharedPreferences.Editor editorEdit = g.hw(context).edit();
                if (zo > 2) {
                    zo -= 2;
                } else {
                    zo = 0;
                }
                editorEdit.putInt("app_log_encrypt_faild_count", zo);
                editorEdit.apply();
                aj = true;
            } catch (Throwable th) {
            }
        }
    }

    public static int pr(String[] strArr, byte[] bArr, zo zoVar) {
        JSONObject jSONObject;
        int iOptInt;
        HashMap map = new HashMap(2);
        if (com.byazt.zrg.pr.zo()) {
            map.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            map.put("Content-Type", "application/json; charset=utf-8");
        }
        String strPr = null;
        for (String str : strArr) {
            hn hnVarPr = pr(1, str, map, bArr);
            strPr = hnVarPr != null ? hnVarPr.pr() : null;
            if (!TextUtils.isEmpty(strPr)) {
                break;
            }
        }
        try {
            if (TextUtils.isEmpty(strPr)) {
                jSONObject = null;
                iOptInt = 0;
            } else {
                jSONObject = new JSONObject(strPr);
                try {
                    iOptInt = jSONObject.optInt("http_code");
                    if (iOptInt == 200) {
                        if ("ss_app_log".equals(jSONObject.optString("magic_tag"))) {
                            if (TrackAction.SUCCESS.equals(jSONObject.optString("message"))) {
                                iOptInt = 200;
                            } else {
                                iOptInt = Integer.valueOf("101").intValue();
                            }
                        } else {
                            iOptInt = Integer.valueOf("102").intValue();
                        }
                    }
                } catch (JSONException e) {
                    e = e;
                    w.hw(e);
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
                    pr = jSONObject2;
                }
            } catch (Exception e3) {
                w.hw(e3);
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

    public static JSONObject hw(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        HashMap map = new HashMap(2);
        if (com.byazt.zrg.pr.zo()) {
            map.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            map.put("Content-Type", "application/json; charset=utf-8");
        }
        hn hnVarPr = pr(1, str, map, x.pr(jSONObject.toString()));
        if (hnVarPr != null && hnVarPr.pr() != null) {
            try {
                jSONObject2 = new JSONObject(hnVarPr.pr());
            } catch (JSONException e) {
                jSONObject2 = null;
            }
        } else {
            jSONObject2 = null;
        }
        if (!(jSONObject2 != null && "ss_app_log".equals(jSONObject2.optString("magic_tag", "")))) {
            return null;
        }
        return jSONObject2.optJSONObject("config");
    }

    public static JSONObject hn(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        hn hnVarPr = pr(1, str, null, x.pr(jSONObject.toString()));
        if (hnVarPr != null && hnVarPr.pr() != null) {
            try {
                jSONObject2 = new JSONObject(hnVarPr.pr());
            } catch (JSONException e) {
                jSONObject2 = null;
            }
        } else {
            jSONObject2 = null;
        }
        if (jSONObject2 != null && TrackAction.SUCCESS.equals(jSONObject2.optString("message", ""))) {
            return jSONObject2.optJSONObject("data");
        }
        return null;
    }

    public static boolean pr(int i) {
        return i >= 500 && i < 600;
    }
}
