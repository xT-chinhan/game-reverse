package com.byazt.f;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.ta.fs;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.byazt.xv.s;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 990, 19})
public class n {
    public static Boolean l;
    public static JSONObject q;
    public static JSONObject s;
    public static boolean w;
    public static n x;
    public int cp;
    public final JSONObject fs;
    public final JSONObject rv;
    public final Boolean tj;
    public static final fs<Integer, n> n = new fs<>(16, 16);
    public static final n qg = new n(null);

    static {
        n();
    }

    public static void n() {
        Boolean boolValueOf;
        JSONObject jSONObjectV = s.v();
        w = jSONObjectV.optInt("disable_task_setting", 0) == 1;
        s = jSONObjectV.optJSONObject("disabled_task_keys");
        JSONObject jSONObjectOptJSONObject = jSONObjectV.optJSONObject("bugfix");
        if (jSONObjectOptJSONObject == null || !jSONObjectOptJSONObject.has("default")) {
            boolValueOf = null;
        } else {
            boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt("default", 0) == 1);
        }
        q = jSONObjectOptJSONObject;
        l = boolValueOf;
    }

    private n(JSONObject jSONObject) {
        Boolean bool;
        this.fs = jSONObject;
        JSONObject jSONObject2 = null;
        boolValueOf = null;
        boolValueOf = null;
        Boolean boolValueOf = null;
        if (jSONObject == null || w("bugfix")) {
            bool = null;
        } else {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("bugfix");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("default") && !w("default")) {
                boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt("default", 0) == 1);
            }
            Boolean bool2 = boolValueOf;
            jSONObject2 = jSONObjectOptJSONObject;
            bool = bool2;
        }
        this.rv = jSONObject2;
        this.tj = bool;
    }

    public static JSONObject qg() {
        return s.v();
    }

    public static void n(String str, boolean z) {
        try {
            if (q == null) {
                q = new JSONObject();
            }
            q.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    public static n s() {
        return qg;
    }

    public static n n(int i) {
        return n(i, (DownloadInfo) null);
    }

    public static n n(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return qg;
        }
        return n(downloadInfo.getId(), downloadInfo);
    }

    private static n n(int i, DownloadInfo downloadInfo) {
        n nVarS;
        n nVar = x;
        if (nVar != null && nVar.cp == i) {
            return nVar;
        }
        fs<Integer, n> fsVar = n;
        synchronized (fsVar) {
            nVarS = fsVar.get(Integer.valueOf(i));
        }
        if (nVarS == null) {
            nVarS = downloadInfo == null ? s(i) : qg(downloadInfo);
            synchronized (fsVar) {
                fsVar.put(Integer.valueOf(i), nVarS);
            }
        }
        nVarS.cp = i;
        x = nVarS;
        return nVarS;
    }

    public boolean n(String str) {
        return qg(str, false);
    }

    public boolean qg(String str, boolean z) {
        if (this.rv != null && !w(str)) {
            if (this.rv.has(str)) {
                return this.rv.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.tj;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = q;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return q.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = l;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    public int qg(String str) {
        return n(str, 0);
    }

    public int n(String str, int i) {
        JSONObject jSONObject = this.fs;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.fs.optInt(str, i);
        }
        return qg().optInt(str, i);
    }

    public long n(String str, long j) {
        JSONObject jSONObject = this.fs;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.fs.optLong(str, j);
        }
        return qg().optLong(str, j);
    }

    public double n(String str, double d) {
        JSONObject jSONObject = this.fs;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.fs.optDouble(str, d);
        }
        return qg().optDouble(str, d);
    }

    public String s(String str) {
        return n(str, "");
    }

    public String n(String str, String str2) {
        JSONObject jSONObject = this.fs;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.fs.optString(str, str2);
        }
        return qg().optString(str, str2);
    }

    public JSONObject q(String str) {
        JSONObject jSONObject = this.fs;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.fs.optJSONObject(str);
        }
        return qg().optJSONObject(str);
    }

    public JSONArray l(String str) {
        JSONObject jSONObject = this.fs;
        if (jSONObject != null && jSONObject.has(str) && !w(str)) {
            return this.fs.optJSONArray(str);
        }
        return qg().optJSONArray(str);
    }

    public static boolean w(String str) {
        JSONObject jSONObject = s;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public static n n(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == qg() || w) {
            return qg;
        }
        n nVar = x;
        if (nVar != null && nVar.fs == jSONObject) {
            return nVar;
        }
        fs<Integer, n> fsVar = n;
        synchronized (fsVar) {
            for (n nVar2 : fsVar.values()) {
                if (nVar2.fs == jSONObject) {
                    x = nVar2;
                    return nVar2;
                }
            }
            n nVar3 = new n(jSONObject);
            x = nVar3;
            return nVar3;
        }
    }

    public static void n(int i, JSONObject jSONObject) {
        n next;
        if (jSONObject == null || jSONObject == qg() || w) {
            return;
        }
        fs<Integer, n> fsVar = n;
        synchronized (fsVar) {
            n nVar = x;
            if (nVar != null && nVar.fs == jSONObject) {
                nVar.cp = i;
            } else {
                Iterator<n> it = fsVar.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next.fs == jSONObject) {
                        next.cp = i;
                        break;
                    }
                }
                if (next == null) {
                    nVar = new n(jSONObject);
                    nVar.cp = i;
                } else {
                    nVar = next;
                }
                x = nVar;
            }
            n.put(Integer.valueOf(i), nVar);
        }
    }

    public static void qg(int i) {
        n nVar = x;
        if (nVar != null && nVar.cp == i) {
            x = null;
        }
        fs<Integer, n> fsVar = n;
        synchronized (fsVar) {
            fsVar.remove(Integer.valueOf(i));
        }
    }

    private static n s(int i) {
        DownloadInfo downloadInfo;
        if (w) {
            return qg;
        }
        Context contextU = s.u();
        if (contextU != null && (downloadInfo = Downloader.getInstance(contextU).getDownloadInfo(i)) != null) {
            return qg(downloadInfo);
        }
        return qg;
    }

    private static n qg(DownloadInfo downloadInfo) {
        if (w) {
            return qg;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new n(new JSONObject(downloadSettingString));
            }
        } catch (Throwable unused) {
        }
        return qg;
    }
}
