package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class jw {
    private static final String[] c = {"channel", "package", "app_version"};
    private final SharedPreferences ab;
    private final pc ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f495ms;
    private final Context xr;
    private final ArrayList<le> ka = new ArrayList<>(32);
    private int x = 0;
    private JSONObject d = new JSONObject();

    public jw(Context context, pc pcVar) {
        this.xr = context;
        this.ah = pcVar;
        this.ab = pcVar.d();
        if (ms.xr) {
            vf.ms(context);
        }
    }

    public JSONObject ms() {
        if (this.f495ms) {
            return u();
        }
        return null;
    }

    public <T> T ms(String str, T t) {
        Object objOpt;
        JSONObject jSONObjectU = u();
        if (jSONObjectU == null || (objOpt = jSONObjectU.opt(str)) == null) {
            objOpt = null;
        }
        return objOpt == null ? t : (T) objOpt;
    }

    private JSONObject u() {
        return this.d;
    }

    public int xr() {
        int iOptInt = this.f495ms ? u().optInt("version_code", -1) : -1;
        for (int i = 0; i < 3 && iOptInt == -1; i++) {
            c();
            iOptInt = this.f495ms ? u().optInt("version_code", -1) : -1;
        }
        return iOptInt;
    }

    public String ah() {
        String strOptString = this.f495ms ? u().optString("app_version", null) : null;
        for (int i = 0; i < 3 && strOptString == null; i++) {
            c();
            strOptString = this.f495ms ? u().optString("app_version", null) : null;
        }
        return strOptString;
    }

    public void d() {
        b.c().ny();
    }

    public void ka() {
        try {
            new e(this.xr, this.ah).ms(this.d);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ah("od", "e:" + e.getMessage(), e);
        }
    }

    public boolean c() {
        synchronized (this.ka) {
            if (this.ka.size() == 0) {
                this.ka.add(new cv(this.xr, this.ah));
                this.ka.add(new of(this.xr));
                this.ka.add(new p(this.xr, this.ah));
                this.ka.add(new f(this.xr));
                this.ka.add(new az(this.xr));
                this.ka.add(new m(this.xr, this.ah));
                this.ka.add(new lm(this.xr));
                this.ka.add(new k(this.xr, this.ah));
                this.ka.add(new eg(this.xr, this.ah));
                this.ka.add(new fm());
                this.ka.add(new xn(this.ah));
                this.ka.add(new il(this.xr));
                this.ka.add(new qf(this.xr));
                this.ka.add(new l(this.xr, this.ah));
                this.ka.add(new yu(this.xr, this.ah));
                this.ka.add(new e(this.xr, this.ah));
                this.ka.add(new g(this.xr, this.ah));
            }
        }
        JSONObject jSONObjectU = u();
        JSONObject jSONObject = new JSONObject();
        zd.xr(jSONObject, jSONObjectU);
        int i = 0;
        int i2 = 0;
        boolean z = true;
        for (le leVar : this.ka) {
            if (!leVar.f502ms || leVar.ah || ms(leVar)) {
                try {
                    leVar.f502ms = leVar.ms(jSONObject);
                } catch (SecurityException e) {
                    if (!leVar.xr) {
                        i++;
                        oh.xr("loadHeader, " + this.x, e);
                        if (!leVar.f502ms && this.x > 10) {
                            leVar.f502ms = true;
                        }
                    }
                } catch (JSONException e2) {
                    oh.xr(e2);
                }
                if (!leVar.f502ms && !leVar.xr) {
                    i2++;
                }
            }
            z &= leVar.f502ms || leVar.xr;
        }
        if (z) {
            for (String str : c) {
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
        this.d = jSONObject;
        this.f495ms = z;
        if (oh.xr) {
            oh.ms("loadHeader, " + this.f495ms + ", " + this.x + ", " + this.d.toString(), null);
        } else {
            oh.d("loadHeader, " + this.f495ms + ", " + this.x, null);
        }
        if (i > 0 && i == i2) {
            this.x++;
            if (hi() != 0) {
                this.x += 10;
            }
        }
        if (this.f495ms) {
            ms.hi().ms(ab(), x(), ny());
        }
        return this.f495ms;
    }

    private boolean ms(le leVar) {
        boolean z = !this.ah.h() && leVar.d;
        if (oh.xr) {
            oh.ms("needSyncFromSub " + leVar + " " + z, null);
        }
        return z;
    }

    public void ms(JSONObject jSONObject) {
        this.ah.ah(jSONObject);
        xr(jSONObject);
    }

    private synchronized void xr(JSONObject jSONObject) {
        if (jSONObject == null) {
            oh.xr("null abconfig", null);
            return;
        }
        String strOptString = u().optString("ab_version");
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
                            oh.xr(e);
                        }
                    }
                }
            }
            hashSet.retainAll(hashSet2);
            xr("ab_version", ms(hashSet));
        }
    }

    private String ms(Set<String> set) {
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

    public void ms(HashMap<String, Object> map) {
        JSONObject jSONObjectOptJSONObject = null;
        if (map != null && !map.isEmpty()) {
            try {
                jSONObjectOptJSONObject = u().optJSONObject("custom");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                }
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObjectOptJSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (JSONException e) {
                oh.xr(e);
            }
        }
        if (xr("custom", jSONObjectOptJSONObject)) {
            this.ah.xr(jSONObjectOptJSONObject);
        }
    }

    public String ab() {
        return u().optString("device_id", "");
    }

    public String x() {
        return u().optString("install_id", "");
    }

    public String ny() {
        return u().optString("ssid", "");
    }

    public String ch() {
        return u().optString("user_unique_id", "");
    }

    private boolean xr(String str, Object obj) {
        boolean z;
        Object objOpt = u().opt(str);
        if ((obj == null || obj.equals(objOpt)) && (obj != null || objOpt == null)) {
            z = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.d;
                    JSONObject jSONObject2 = new JSONObject();
                    zd.xr(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.d = jSONObject2;
                } catch (JSONException e) {
                    oh.xr(e);
                }
            }
            z = true;
        }
        oh.ms("updateHeader, " + str + ", " + objOpt + ", " + obj, null);
        return z;
    }

    static void ms(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    static boolean ms(String str) {
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
    public static boolean xr(String str) {
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

    public int hi() {
        String strOptString = u().optString("device_id", "");
        u().optString("install_id", "");
        if (xr(strOptString)) {
            return this.ab.getInt("version_code", 0) == u().optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public long sl() {
        return u().optLong(DeepLinkPresetEvent.UMEventParamRegisterTime, 0L);
    }

    public boolean ms(JSONObject jSONObject, String str, String str2, String str3) {
        boolean z;
        boolean z2;
        if (oh.xr) {
            oh.ms("saveRegisterInfo, " + str + ", " + str2 + ", " + str3 + ", " + jSONObject, null);
        }
        boolean zXr = xr(str);
        boolean zXr2 = xr(str2);
        try {
            boolean zXr3 = xr(str3);
            int i = this.ab.getInt("version_code", 0);
            int iOptInt = u().optInt("version_code", 0);
            SharedPreferences.Editor editorEdit = this.ab.edit();
            if (i != iOptInt) {
                editorEdit.putInt("version_code", iOptInt);
            }
            if (zXr) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                editorEdit.putLong(DeepLinkPresetEvent.UMEventParamRegisterTime, jCurrentTimeMillis);
                xr(DeepLinkPresetEvent.UMEventParamRegisterTime, Long.valueOf(jCurrentTimeMillis));
            } else if (!zXr) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("response", jSONObject);
                ms.ms("tt_fetch_did_error", jSONObject2);
            }
            String strOptString = u().optString("device_id", "");
            if (zXr && xr("device_id", str)) {
                editorEdit.putString("device_id", str);
                z = true;
            } else {
                z = false;
            }
            String strOptString2 = u().optString("install_id", "");
            if (zXr2 && xr("install_id", str2)) {
                editorEdit.putString("install_id", str2);
                z = true;
            }
            String strOptString3 = u().optString("ssid", "");
            if (zXr3 && xr("ssid", str3)) {
                editorEdit.putString("ssid", str3);
                z2 = true;
            } else {
                z2 = z;
            }
            ms.hi().ms(z2, strOptString, str, strOptString2, str2, strOptString3, str3);
            editorEdit.apply();
        } catch (JSONException e) {
            oh.xr(e);
        }
        return zXr && zXr2;
    }

    public String zb() {
        return u().optString("ab_sdk_version", "");
    }
}
