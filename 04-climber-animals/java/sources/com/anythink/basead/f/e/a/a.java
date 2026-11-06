package com.anythink.basead.f.e.a;

import android.net.Uri;
import com.anythink.basead.d.e;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    /* JADX WARN: Code duplicated, block: B:27:0x00a0 A[PHI: r1
      0x00a0: PHI (r1v3 java.net.HttpURLConnection) = (r1v2 java.net.HttpURLConnection), (r1v6 java.net.HttpURLConnection) binds: [B:26:0x009e, B:17:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:32:0x00a8  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00a5: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:30:0x00a5 */
    public static e a(x xVar, w wVar, String str) throws Throwable {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        HttpURLConnection httpURLConnection3 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                        }
                        JSONObject jSONObjectOptJSONObject = new JSONObject(sb.toString()).optJSONObject("data");
                        e eVar = new e(jSONObjectOptJSONObject.optString("dstlink"), "", jSONObjectOptJSONObject.optString("clickid"));
                        bufferedReader.close();
                        inputStreamReader.close();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return eVar;
                    }
                    com.anythink.core.common.u.e.a(xVar, wVar, wVar.H(), str, String.valueOf(responseCode), "");
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                } catch (Exception e) {
                    e = e;
                    com.anythink.core.common.u.e.a(xVar, wVar, wVar.H(), str, "", e.getMessage());
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            } catch (Throwable th) {
                th = th;
                httpURLConnection3 = httpURLConnection2;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            if (httpURLConnection3 != null) {
                httpURLConnection3.disconnect();
            }
            throw th;
        }
    }

    public static String a(String str) {
        try {
            return Uri.parse(str).getQueryParameter("qz_gdt");
        } catch (Throwable unused) {
            return null;
        }
    }
}
