package com.ss.android.socialbase.downloader.ab;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.express.b.a;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.ah;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.ny.x;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ms {
    private static ms ab;
    private static JSONObject ah;
    private static boolean c;
    private static JSONObject d;
    private static Boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final x<Integer, ms> f4611ms = new x<>(16, 16);
    private static final ms xr = new ms(null);
    private final Boolean ch;
    private int hi;
    private final JSONObject ny;
    private final JSONObject x;

    static {
        ms();
    }

    public static void ms() {
        Boolean boolValueOf;
        JSONObject jSONObjectP = ah.p();
        c = jSONObjectP.optInt("disable_task_setting", 0) == 1;
        ah = jSONObjectP.optJSONObject("disabled_task_keys");
        JSONObject jSONObjectOptJSONObject = jSONObjectP.optJSONObject("bugfix");
        if (jSONObjectOptJSONObject == null || !jSONObjectOptJSONObject.has(a.f)) {
            boolValueOf = null;
        } else {
            boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt(a.f, 0) == 1);
        }
        d = jSONObjectOptJSONObject;
        ka = boolValueOf;
    }

    private ms(JSONObject jSONObject) {
        Boolean bool;
        this.x = jSONObject;
        JSONObject jSONObject2 = null;
        boolValueOf = null;
        boolValueOf = null;
        Boolean boolValueOf = null;
        if (jSONObject == null || c("bugfix")) {
            bool = null;
        } else {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("bugfix");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has(a.f) && !c(a.f)) {
                boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt(a.f, 0) == 1);
            }
            Boolean bool2 = boolValueOf;
            jSONObject2 = jSONObjectOptJSONObject;
            bool = bool2;
        }
        this.ny = jSONObject2;
        this.ch = bool;
    }

    public static JSONObject xr() {
        return ah.p();
    }

    public static void ms(String str, boolean z) {
        try {
            if (d == null) {
                d = new JSONObject();
            }
            d.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    public static ms ah() {
        return xr;
    }

    public static ms ms(int i) {
        return ms(i, (DownloadInfo) null);
    }

    public static ms ms(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return xr;
        }
        return ms(downloadInfo.getId(), downloadInfo);
    }

    private static ms ms(int i, DownloadInfo downloadInfo) {
        ms msVarAh;
        ms msVar = ab;
        if (msVar != null && msVar.hi == i) {
            return msVar;
        }
        x<Integer, ms> xVar = f4611ms;
        synchronized (xVar) {
            msVarAh = xVar.get(Integer.valueOf(i));
        }
        if (msVarAh == null) {
            msVarAh = downloadInfo == null ? ah(i) : xr(downloadInfo);
            synchronized (xVar) {
                xVar.put(Integer.valueOf(i), msVarAh);
            }
        }
        msVarAh.hi = i;
        ab = msVarAh;
        return msVarAh;
    }

    public boolean ms(String str) {
        return xr(str, false);
    }

    public boolean xr(String str, boolean z) {
        if (this.ny != null && !c(str)) {
            if (this.ny.has(str)) {
                return this.ny.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.ch;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = d;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return d.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = ka;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    public int xr(String str) {
        return ms(str, 0);
    }

    public int ms(String str, int i) {
        JSONObject jSONObject = this.x;
        if (jSONObject != null && jSONObject.has(str) && !c(str)) {
            return this.x.optInt(str, i);
        }
        return xr().optInt(str, i);
    }

    public long ms(String str, long j) {
        JSONObject jSONObject = this.x;
        if (jSONObject != null && jSONObject.has(str) && !c(str)) {
            return this.x.optLong(str, j);
        }
        return xr().optLong(str, j);
    }

    public double ms(String str, double d2) {
        JSONObject jSONObject = this.x;
        if (jSONObject != null && jSONObject.has(str) && !c(str)) {
            return this.x.optDouble(str, d2);
        }
        return xr().optDouble(str, d2);
    }

    public String ah(String str) {
        return ms(str, "");
    }

    public String ms(String str, String str2) {
        JSONObject jSONObject = this.x;
        if (jSONObject != null && jSONObject.has(str) && !c(str)) {
            return this.x.optString(str, str2);
        }
        return xr().optString(str, str2);
    }

    public JSONObject d(String str) {
        JSONObject jSONObject = this.x;
        if (jSONObject != null && jSONObject.has(str) && !c(str)) {
            return this.x.optJSONObject(str);
        }
        return xr().optJSONObject(str);
    }

    public JSONArray ka(String str) {
        JSONObject jSONObject = this.x;
        if (jSONObject != null && jSONObject.has(str) && !c(str)) {
            return this.x.optJSONArray(str);
        }
        return xr().optJSONArray(str);
    }

    public static boolean c(String str) {
        JSONObject jSONObject = ah;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public static ms ms(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == xr() || c) {
            return xr;
        }
        ms msVar = ab;
        if (msVar != null && msVar.x == jSONObject) {
            return msVar;
        }
        x<Integer, ms> xVar = f4611ms;
        synchronized (xVar) {
            for (ms msVar2 : xVar.values()) {
                if (msVar2.x == jSONObject) {
                    ab = msVar2;
                    return msVar2;
                }
            }
            ms msVar3 = new ms(jSONObject);
            ab = msVar3;
            return msVar3;
        }
    }

    public static void ms(int i, JSONObject jSONObject) {
        ms next;
        if (jSONObject == null || jSONObject == xr() || c) {
            return;
        }
        x<Integer, ms> xVar = f4611ms;
        synchronized (xVar) {
            ms msVar = ab;
            if (msVar != null && msVar.x == jSONObject) {
                msVar.hi = i;
            } else {
                Iterator<ms> it = xVar.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next.x == jSONObject) {
                        next.hi = i;
                        break;
                    }
                }
                if (next == null) {
                    msVar = new ms(jSONObject);
                    msVar.hi = i;
                } else {
                    msVar = next;
                }
                ab = msVar;
            }
            f4611ms.put(Integer.valueOf(i), msVar);
        }
    }

    public static void xr(int i) {
        ms msVar = ab;
        if (msVar != null && msVar.hi == i) {
            ab = null;
        }
        x<Integer, ms> xVar = f4611ms;
        synchronized (xVar) {
            xVar.remove(Integer.valueOf(i));
        }
    }

    private static ms ah(int i) {
        DownloadInfo downloadInfo;
        if (c) {
            return xr;
        }
        Context contextK = ah.k();
        if (contextK != null && (downloadInfo = Downloader.getInstance(contextK).getDownloadInfo(i)) != null) {
            return xr(downloadInfo);
        }
        return xr;
    }

    private static ms xr(DownloadInfo downloadInfo) {
        if (c) {
            return xr;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new ms(new JSONObject(downloadSettingString));
            }
        } catch (Throwable th) {
            ab.ms(th);
        }
        return xr;
    }
}
