package com.smartdigimkt.r4;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.smartdigimkt.sdk.api.SDMSDK;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class w {
    public static final ThreadPoolExecutor a;

    static {
        ThreadPoolExecutor threadPoolExecutor;
        com.smartdigimkt.q3.b bVar = com.smartdigimkt.q3.f.a().a;
        if (bVar != null) {
            if (bVar.k == null) {
                synchronized (com.smartdigimkt.q3.b.class) {
                    if (bVar.k == null) {
                        bVar.k = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.smartdigimkt.q3.g());
                    }
                }
            }
            threadPoolExecutor = bVar.k;
        } else {
            threadPoolExecutor = null;
        }
        a = threadPoolExecutor;
    }

    public static void a(String str) {
        int length;
        String property = System.getProperty("line.separator");
        try {
            if (str.startsWith("{")) {
                JSONObject jSONObject = new JSONObject(str);
                a(jSONObject);
                str = jSONObject.toString(4);
            } else if (str.startsWith("[")) {
                str = new JSONArray(str).toString(4);
            }
        } catch (JSONException unused) {
        }
        int i = 0;
        String str2 = "╔═══════════════════════════════════════════════════════════════════════════════════════";
        for (String str3 : str.split(property)) {
            str2 = com.smartdigimkt.p.a.a(str2, "\n") + "║ " + str3;
        }
        String strA = com.smartdigimkt.p.a.a(str2, "\n╚═══════════════════════════════════════════════════════════════════════════════════════");
        SDKContext.getInstance().getClass();
        String str4 = " \n" + strA;
        if (!TextUtils.isEmpty(str4) && (length = str4.length()) > 3970) {
            int i2 = (length + 3969) / 3970;
            int i3 = 1;
            while (i3 <= i2) {
                int iMin = Math.min(i + 3970, length);
                str4.substring(i, iMin);
                i3++;
                i = iMin;
            }
        }
    }

    public static void a(JSONObject jSONObject) {
        JSONArray jSONArrayNames = jSONObject.names();
        if (jSONArrayNames == null) {
            return;
        }
        for (int i = 0; i < jSONArrayNames.length(); i++) {
            String strOptString = jSONArrayNames.optString(i, null);
            if (strOptString != null && strOptString.startsWith(NotificationCompat.CATEGORY_MESSAGE)) {
                Object objOpt = jSONObject.opt(strOptString);
                if (objOpt instanceof String) {
                    String str = (String) objOpt;
                    if (str.length() > 2000) {
                        try {
                            jSONObject.put(strOptString, str.substring(0, 2000) + "...<truncated, total=" + str.length() + ">");
                        } catch (JSONException unused) {
                        }
                    }
                }
            }
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        ThreadPoolExecutor threadPoolExecutor;
        if (!SDMSDK.getInstance().isNetworkLogDebug() || (threadPoolExecutor = a) == null) {
            return;
        }
        threadPoolExecutor.execute(new u(str, str2, str3, str4, str5));
    }

    public static void a(com.smartdigimkt.f3.a aVar, String str, String str2, String str3) {
        ThreadPoolExecutor threadPoolExecutor;
        if (!SDMSDK.getInstance().isNetworkLogDebug() || (threadPoolExecutor = a) == null) {
            return;
        }
        threadPoolExecutor.execute(new v(aVar, str, str2, str3));
    }
}
