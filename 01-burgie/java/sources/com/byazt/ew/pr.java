package com.byazt.ew;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.lj.Downloader;
import com.byazt.lj.hn;
import com.byazt.tuy.zo;
import com.uc.crashsdk.export.LogType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, LogType.UNEXP_LOW_MEMORY, 37})
public class pr {
    public static Boolean c;
    public static pr fw;
    public static JSONObject hn;
    public static boolean uc;
    public static JSONObject x;
    public final JSONObject aj;
    public final Boolean vk;
    public int w;
    public final JSONObject zo;
    public static final zo<Integer, pr> pr = new zo<>(16, 16);
    public static final pr hw = new pr(null);

    static {
        pr();
    }

    public static void pr() {
        JSONObject jSONObjectWw = hn.ww();
        uc = jSONObjectWw.optInt("disable_task_setting", 0) == 1;
        hn = jSONObjectWw.optJSONObject("disabled_task_keys");
        JSONObject jSONObjectOptJSONObject = jSONObjectWw.optJSONObject("bugfix");
        Boolean boolValueOf = null;
        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("default")) {
            boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt("default", 0) == 1);
        }
        x = jSONObjectOptJSONObject;
        c = boolValueOf;
    }

    private pr(JSONObject jSONObject) {
        Boolean boolValueOf;
        this.zo = jSONObject;
        JSONObject jSONObject2 = null;
        if (jSONObject == null || uc("bugfix")) {
            boolValueOf = null;
        } else {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("bugfix");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("default") && !uc("default")) {
                jSONObject2 = jSONObjectOptJSONObject;
                boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt("default", 0) == 1);
            } else {
                jSONObject2 = jSONObjectOptJSONObject;
                boolValueOf = null;
            }
        }
        this.aj = jSONObject2;
        this.vk = boolValueOf;
    }

    public static JSONObject hw() {
        return hn.ww();
    }

    public static void pr(String str, boolean z) {
        try {
            if (x == null) {
                x = new JSONObject();
            }
            x.put(str, z ? 1 : 0);
        } catch (JSONException e) {
        }
    }

    public static pr hn() {
        return hw;
    }

    public static pr pr(int i) {
        return pr(i, (DownloadInfo) null);
    }

    public static pr pr(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return hw;
        }
        return pr(downloadInfo.getId(), downloadInfo);
    }

    private static pr pr(int i, DownloadInfo downloadInfo) {
        pr prVarHn;
        pr prVar = fw;
        if (prVar != null && prVar.w == i) {
            return prVar;
        }
        zo<Integer, pr> zoVar = pr;
        synchronized (zoVar) {
            prVarHn = zoVar.get(Integer.valueOf(i));
        }
        if (prVarHn == null) {
            prVarHn = downloadInfo == null ? hn(i) : hw(downloadInfo);
            synchronized (zoVar) {
                zoVar.put(Integer.valueOf(i), prVarHn);
            }
        }
        prVarHn.w = i;
        fw = prVarHn;
        return prVarHn;
    }

    public boolean pr(String str) {
        return hw(str, false);
    }

    public boolean hw(String str, boolean z) {
        if (this.aj != null && !uc(str)) {
            if (this.aj.has(str)) {
                return this.aj.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.vk;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = x;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return x.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = c;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    public int hw(String str) {
        return pr(str, 0);
    }

    public int pr(String str, int i) {
        JSONObject jSONObject = this.zo;
        if (jSONObject != null && jSONObject.has(str) && !uc(str)) {
            return this.zo.optInt(str, i);
        }
        return hw().optInt(str, i);
    }

    public long pr(String str, long j) {
        JSONObject jSONObject = this.zo;
        if (jSONObject != null && jSONObject.has(str) && !uc(str)) {
            return this.zo.optLong(str, j);
        }
        return hw().optLong(str, j);
    }

    public double pr(String str, double d) {
        JSONObject jSONObject = this.zo;
        if (jSONObject != null && jSONObject.has(str) && !uc(str)) {
            return this.zo.optDouble(str, d);
        }
        return hw().optDouble(str, d);
    }

    public String hn(String str) {
        return pr(str, "");
    }

    public String pr(String str, String str2) {
        JSONObject jSONObject = this.zo;
        if (jSONObject != null && jSONObject.has(str) && !uc(str)) {
            return this.zo.optString(str, str2);
        }
        return hw().optString(str, str2);
    }

    public JSONObject x(String str) {
        JSONObject jSONObject = this.zo;
        if (jSONObject != null && jSONObject.has(str) && !uc(str)) {
            return this.zo.optJSONObject(str);
        }
        return hw().optJSONObject(str);
    }

    public JSONArray c(String str) {
        JSONObject jSONObject = this.zo;
        if (jSONObject != null && jSONObject.has(str) && !uc(str)) {
            return this.zo.optJSONArray(str);
        }
        return hw().optJSONArray(str);
    }

    public static boolean uc(String str) {
        JSONObject jSONObject = hn;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public static pr pr(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == hw() || uc) {
            return hw;
        }
        pr prVar = fw;
        if (prVar != null && prVar.zo == jSONObject) {
            return prVar;
        }
        zo<Integer, pr> zoVar = pr;
        synchronized (zoVar) {
            for (pr prVar2 : zoVar.values()) {
                if (prVar2.zo == jSONObject) {
                    fw = prVar2;
                    return prVar2;
                }
            }
            pr prVar3 = new pr(jSONObject);
            fw = prVar3;
            return prVar3;
        }
    }

    public static void pr(int i, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == hw() || uc) {
            return;
        }
        zo<Integer, pr> zoVar = pr;
        synchronized (zoVar) {
            pr prVar = fw;
            if (prVar != null && prVar.zo == jSONObject) {
                prVar.w = i;
            } else {
                prVar = null;
                for (pr prVar2 : zoVar.values()) {
                    if (prVar2.zo == jSONObject) {
                        prVar2.w = i;
                        prVar = prVar2;
                        break;
                    }
                }
                if (prVar == null) {
                    prVar = new pr(jSONObject);
                    prVar.w = i;
                }
                fw = prVar;
            }
            pr.put(Integer.valueOf(i), prVar);
        }
    }

    public static void hw(int i) {
        pr prVar = fw;
        if (prVar != null && prVar.w == i) {
            fw = null;
        }
        zo<Integer, pr> zoVar = pr;
        synchronized (zoVar) {
            zoVar.remove(Integer.valueOf(i));
        }
    }

    private static pr hn(int i) {
        DownloadInfo downloadInfo;
        if (uc) {
            return hw;
        }
        Context contextOf = hn.of();
        if (contextOf != null && (downloadInfo = Downloader.getInstance(contextOf).getDownloadInfo(i)) != null) {
            return hw(downloadInfo);
        }
        return hw;
    }

    private static pr hw(DownloadInfo downloadInfo) {
        if (uc) {
            return hw;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new pr(new JSONObject(downloadSettingString));
            }
        } catch (Throwable th) {
        }
        return hw;
    }
}
