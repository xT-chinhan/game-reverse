package com.byazt.ko;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.gc.AbsServerManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static final String[] w = {"channel", AbsServerManager.PACKAGE_QUERY_BINDER, "app_version"};
    public boolean n;
    public final Context qg;
    public final fs s;
    public final SharedPreferences x;
    public final ArrayList<s> l = new ArrayList<>(32);
    public int fs = 0;
    public JSONObject q = new JSONObject();

    public rv(Context context, fs fsVar) {
        this.qg = context;
        this.s = fsVar;
        this.x = fsVar.l();
        if (com.byazt.wv.n.qg) {
            com.byazt.yb.x.n(context);
        }
    }

    public JSONObject n() {
        if (this.n) {
            return k();
        }
        return null;
    }

    public <T> T n(String str, T t) {
        Object objOpt;
        JSONObject jSONObjectK = k();
        if (jSONObjectK == null || (objOpt = jSONObjectK.opt(str)) == null) {
            objOpt = null;
        }
        return objOpt == null ? t : (T) objOpt;
    }

    private JSONObject k() {
        return this.q;
    }

    public int qg() {
        int iOptInt = this.n ? k().optInt("version_code", -1) : -1;
        for (int i = 0; i < 3 && iOptInt == -1; i++) {
            w();
            iOptInt = this.n ? k().optInt("version_code", -1) : -1;
        }
        return iOptInt;
    }

    public String s() {
        String strOptString = this.n ? k().optString("app_version", null) : null;
        for (int i = 0; i < 3 && strOptString == null; i++) {
            w();
            strOptString = this.n ? k().optString("app_version", null) : null;
        }
        return strOptString;
    }

    public void q() {
        com.byazt.fo.q.l().fs();
    }

    public void l() {
        try {
            new sz(this.qg, this.s).n(this.q);
        } catch (Exception e) {
            com.byazt.tk.k.n("od", "e:" + e.getMessage(), e);
        }
    }

    public boolean w() {
        synchronized (this.l) {
            if (this.l.size() == 0) {
                this.l.add(new q(this.qg, this.s));
                this.l.add(new w(this.qg));
                this.l.add(new x(this.qg, this.s));
                this.l.add(new tj(this.qg));
                this.l.add(new cp(this.qg));
                this.l.add(new d(this.qg, this.s));
                this.l.add(new oa(this.qg));
                this.l.add(new k(this.qg, this.s));
                this.l.add(new cy(this.qg, this.s));
                this.l.add(new hd());
                this.l.add(new cd(this.s));
                this.l.add(new um(this.qg));
                this.l.add(new a(this.qg));
                this.l.add(new py(this.qg, this.s));
                this.l.add(new n(this.qg, this.s));
                this.l.add(new sz(this.qg, this.s));
                this.l.add(new l(this.qg, this.s));
            }
        }
        JSONObject jSONObjectK = k();
        JSONObject jSONObject = new JSONObject();
        com.byazt.km.sz.s(jSONObject, jSONObjectK);
        int i = 0;
        int i2 = 0;
        boolean z = true;
        for (s sVar : this.l) {
            if (!sVar.n || sVar.s || n(sVar)) {
                try {
                    sVar.n = sVar.n(jSONObject);
                } catch (SecurityException e) {
                    if (!sVar.qg) {
                        i++;
                        com.byazt.km.cp.qg("loadHeader, " + this.fs, e);
                        if (!sVar.n && this.fs > 10) {
                            sVar.n = true;
                        }
                    }
                } catch (JSONException e2) {
                    com.byazt.km.cp.qg(e2);
                }
                if (!sVar.n && !sVar.qg) {
                    i2++;
                }
            }
            z &= sVar.n || sVar.qg;
        }
        if (z) {
            for (String str : w) {
                z &= !TextUtils.isEmpty(jSONObject.optString(str));
            }
            String strOptString = jSONObject.optString("user_unique_id", null);
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    jSONObject.put("user_unique_id", strOptString);
                } catch (JSONException unused) {
                }
            }
        }
        this.q = jSONObject;
        this.n = z;
        if (com.byazt.km.cp.qg) {
            com.byazt.km.cp.n("loadHeader, " + this.n + ", " + this.fs + ", " + this.q.toString(), null);
        } else {
            com.byazt.km.cp.q("loadHeader, " + this.n + ", " + this.fs, null);
        }
        if (i > 0 && i == i2) {
            this.fs++;
            if (d() != 0) {
                this.fs += 10;
            }
        }
        if (this.n) {
            com.byazt.wv.n.d().n(x(), rv(), tj());
        }
        return this.n;
    }

    private boolean n(s sVar) {
        boolean z = !this.s.hd() && sVar.q;
        if (com.byazt.km.cp.qg) {
            com.byazt.km.cp.n("needSyncFromSub " + sVar + " " + z, null);
        }
        return z;
    }

    public void n(JSONObject jSONObject) {
        this.s.s(jSONObject);
        qg(jSONObject);
    }

    private synchronized void qg(JSONObject jSONObject) {
        if (jSONObject == null) {
            com.byazt.km.cp.qg("null abconfig", null);
            return;
        }
        String strOptString = k().optString("ab_version");
        if (!TextUtils.isEmpty(strOptString)) {
            String[] strArrSplit = strOptString.split(",");
            Set<String> hashSet = new HashSet<>();
            for (String str : strArrSplit) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            Iterator<String> itKeys = jSONObject.keys();
            HashSet hashSet2 = new HashSet();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next instanceof String) {
                    String str2 = next;
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            hashSet2.add(jSONObject.getJSONObject(str2).optString("vid"));
                        } catch (JSONException e) {
                            com.byazt.km.cp.qg(e);
                        }
                    }
                }
            }
            hashSet.retainAll(hashSet2);
            qg("ab_version", n(hashSet));
        }
    }

    private String n(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public void n(HashMap<String, Object> map) {
        JSONObject jSONObjectOptJSONObject = null;
        if (map != null && !map.isEmpty()) {
            try {
                jSONObjectOptJSONObject = k().optJSONObject("custom");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                }
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObjectOptJSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (JSONException e) {
                com.byazt.km.cp.qg(e);
            }
        }
        if (qg("custom", jSONObjectOptJSONObject)) {
            this.s.qg(jSONObjectOptJSONObject);
        }
    }

    public String x() {
        return k().optString(TapEventParamConstants.PARAM_DEVICE_ID, "");
    }

    public String fs() {
        return k().optString("aid", "");
    }

    public String rv() {
        return k().optString("install_id", "");
    }

    public String tj() {
        return k().optString("ssid", "");
    }

    public String cp() {
        return k().optString("user_unique_id", "");
    }

    private boolean qg(String str, Object obj) {
        boolean z;
        Object objOpt = k().opt(str);
        if ((obj == null || obj.equals(objOpt)) && (obj != null || objOpt == null)) {
            z = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.q;
                    JSONObject jSONObject2 = new JSONObject();
                    com.byazt.km.sz.s(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.q = jSONObject2;
                } catch (JSONException e) {
                    com.byazt.km.cp.qg(e);
                }
            }
            z = true;
        }
        com.byazt.km.cp.n("updateHeader, " + str + ", " + objOpt + ", " + obj, null);
        return z;
    }

    public static void n(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    public static boolean n(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'f') && ((cCharAt < 'A' || cCharAt > 'F') && cCharAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002f A[RETURN] */
    public static boolean qg(String str) {
        boolean z;
        if (!TextUtils.isEmpty(str) && !"unknown".equalsIgnoreCase(str) && !"Null".equalsIgnoreCase(str)) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '0') {
                    z = false;
                    if (!z) {
                        return true;
                    }
                }
            }
            z = true;
            if (!z) {
                return true;
            }
        }
        return false;
    }

    public int d() {
        String strOptString = k().optString(TapEventParamConstants.PARAM_DEVICE_ID, "");
        k().optString("install_id", "");
        if (qg(strOptString)) {
            return this.x.getInt("version_code", 0) == k().optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public long oa() {
        return k().optLong("register_time", 0L);
    }

    public boolean n(JSONObject jSONObject, String str, String str2, String str3) {
        boolean z;
        boolean z2;
        if (com.byazt.km.cp.qg) {
            com.byazt.km.cp.n("saveRegisterInfo, " + str + ", " + str2 + ", " + str3 + ", " + jSONObject, null);
        }
        boolean zQg = qg(str);
        boolean zQg2 = qg(str2);
        try {
            boolean zQg3 = qg(str3);
            int i = this.x.getInt("version_code", 0);
            int iOptInt = k().optInt("version_code", 0);
            SharedPreferences.Editor editorEdit = this.x.edit();
            if (i != iOptInt) {
                editorEdit.putInt("version_code", iOptInt);
            }
            if (zQg) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                editorEdit.putLong("register_time", jCurrentTimeMillis);
                qg("register_time", Long.valueOf(jCurrentTimeMillis));
            } else if (!zQg) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("response", jSONObject);
                com.byazt.wv.n.n("tt_fetch_did_error", jSONObject2);
            }
            String strOptString = k().optString(TapEventParamConstants.PARAM_DEVICE_ID, "");
            if (zQg && qg(TapEventParamConstants.PARAM_DEVICE_ID, str)) {
                editorEdit.putString(TapEventParamConstants.PARAM_DEVICE_ID, str);
                z = true;
            } else {
                z = false;
            }
            String strOptString2 = k().optString("install_id", "");
            if (zQg2 && qg("install_id", str2)) {
                editorEdit.putString("install_id", str2);
                z = true;
            }
            String strOptString3 = k().optString("ssid", "");
            if (zQg3 && qg("ssid", str3)) {
                editorEdit.putString("ssid", str3);
                z2 = true;
            } else {
                z2 = z;
            }
            com.byazt.wv.n.d().n(z2, strOptString, str, strOptString2, str2, strOptString3, str3);
            editorEdit.apply();
        } catch (JSONException e) {
            com.byazt.km.cp.qg(e);
        }
        return zQg && zQg2;
    }

    public String sz() {
        return k().optString("ab_sdk_version", "");
    }
}
