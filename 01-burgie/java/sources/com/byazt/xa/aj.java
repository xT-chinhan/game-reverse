package com.byazt.xa;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.ewn.AbsServerManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, 61})
public class aj {
    public static final String[] uc = {"channel", AbsServerManager.PACKAGE_QUERY_BINDER, "app_version"};
    public final SharedPreferences fw;
    public final zo hn;
    public final Context hw;
    public boolean pr;
    public final ArrayList<hn> c = new ArrayList<>(32);
    public int zo = 0;
    public JSONObject x = new JSONObject();

    public aj(Context context, zo zoVar) {
        this.hw = context;
        this.hn = zoVar;
        this.fw = zoVar.c();
        if (com.byazt.zrg.pr.hw) {
            com.byazt.xev.fw.pr(context);
        }
    }

    public JSONObject pr() {
        if (this.pr) {
            return ho();
        }
        return null;
    }

    public <T> T pr(String str, T t) {
        Object objOpt;
        JSONObject jSONObjectHo = ho();
        if (jSONObjectHo == null || (objOpt = jSONObjectHo.opt(str)) == null) {
            objOpt = null;
        }
        if (objOpt != null) {
            return (T) objOpt;
        }
        return t;
    }

    private JSONObject ho() {
        return this.x;
    }

    public int hw() {
        int iOptInt = this.pr ? ho().optInt("version_code", -1) : -1;
        for (int i = 0; i < 3 && iOptInt == -1; i++) {
            uc();
            iOptInt = this.pr ? ho().optInt("version_code", -1) : -1;
        }
        return iOptInt;
    }

    public String hn() {
        String strOptString = this.pr ? ho().optString("app_version", null) : null;
        for (int i = 0; i < 3 && strOptString == null; i++) {
            uc();
            strOptString = this.pr ? ho().optString("app_version", null) : null;
        }
        return strOptString;
    }

    public void x() {
        com.byazt.gox.x.c().zo();
    }

    public void c() {
        try {
            new g(this.hw, this.hn).pr(this.x);
        } catch (Exception e) {
            com.byazt.ca.ho.pr("od", "e:" + e.getMessage(), e);
        }
    }

    public boolean uc() {
        synchronized (this.c) {
            if (this.c.size() == 0) {
                this.c.add(new x(this.hw, this.hn));
                this.c.add(new uc(this.hw));
                this.c.add(new fw(this.hw, this.hn));
                this.c.add(new vk(this.hw));
                this.c.add(new w(this.hw));
                this.c.add(new k(this.hw, this.hn));
                this.c.add(new m(this.hw));
                this.c.add(new ho(this.hw, this.hn));
                this.c.add(new nt(this.hw, this.hn));
                this.c.add(new yb());
                this.c.add(new lb(this.hn));
                this.c.add(new qa(this.hw));
                this.c.add(new a(this.hw));
                this.c.add(new cz(this.hw, this.hn));
                this.c.add(new pr(this.hw, this.hn));
                this.c.add(new g(this.hw, this.hn));
                this.c.add(new c(this.hw, this.hn));
            }
        }
        JSONObject jSONObjectHo = ho();
        JSONObject jSONObject = new JSONObject();
        com.byazt.ec.g.hn(jSONObject, jSONObjectHo);
        int i = 0;
        int i2 = 0;
        boolean z = true;
        for (hn hnVar : this.c) {
            if (!hnVar.pr || hnVar.hn || pr(hnVar)) {
                try {
                    hnVar.pr = hnVar.pr(jSONObject);
                } catch (SecurityException e) {
                    if (!hnVar.hw) {
                        i++;
                        com.byazt.ec.w.hw("loadHeader, " + this.zo, e);
                        if (!hnVar.pr && this.zo > 10) {
                            hnVar.pr = true;
                        }
                    }
                } catch (JSONException e2) {
                    com.byazt.ec.w.hw(e2);
                }
                if (!hnVar.pr && !hnVar.hw) {
                    i2++;
                }
            }
            z &= hnVar.pr || hnVar.hw;
        }
        if (z) {
            for (String str : uc) {
                z &= !TextUtils.isEmpty(jSONObject.optString(str));
            }
            String strOptString = jSONObject.optString("user_unique_id", null);
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    jSONObject.put("user_unique_id", strOptString);
                } catch (JSONException e3) {
                }
            }
        }
        this.x = jSONObject;
        this.pr = z;
        if (com.byazt.ec.w.hw) {
            com.byazt.ec.w.pr("loadHeader, " + this.pr + ", " + this.zo + ", " + this.x.toString(), null);
        } else {
            com.byazt.ec.w.x("loadHeader, " + this.pr + ", " + this.zo, null);
        }
        if (i > 0 && i == i2) {
            this.zo++;
            if (k() != 0) {
                this.zo += 10;
            }
        }
        if (this.pr) {
            com.byazt.zrg.pr.k().pr(fw(), aj(), vk());
        }
        return this.pr;
    }

    private boolean pr(hn hnVar) {
        boolean z = !this.hn.yb() && hnVar.x;
        if (com.byazt.ec.w.hw) {
            com.byazt.ec.w.pr("needSyncFromSub " + hnVar + " " + z, null);
        }
        return z;
    }

    public void pr(JSONObject jSONObject) {
        this.hn.hn(jSONObject);
        hw(jSONObject);
    }

    private synchronized void hw(JSONObject jSONObject) {
        if (jSONObject == null) {
            com.byazt.ec.w.hw("null abconfig", null);
            return;
        }
        String strOptString = ho().optString("ab_version");
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
                            com.byazt.ec.w.hw(e);
                        }
                    }
                }
            }
            hashSet.retainAll(hashSet2);
            hw("ab_version", pr(hashSet));
        }
    }

    private String pr(Set<String> set) {
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

    public void pr(HashMap<String, Object> map) {
        JSONObject jSONObjectOptJSONObject = null;
        if (map != null && !map.isEmpty()) {
            try {
                jSONObjectOptJSONObject = ho().optJSONObject(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                }
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObjectOptJSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (JSONException e) {
                com.byazt.ec.w.hw(e);
            }
        }
        if (hw(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObjectOptJSONObject)) {
            this.hn.hw(jSONObjectOptJSONObject);
        }
    }

    public String fw() {
        return ho().optString("device_id", "");
    }

    public String zo() {
        return ho().optString("aid", "");
    }

    public String aj() {
        return ho().optString("install_id", "");
    }

    public String vk() {
        return ho().optString("ssid", "");
    }

    public String w() {
        return ho().optString("user_unique_id", "");
    }

    private boolean hw(String str, Object obj) {
        boolean z;
        Object objOpt = ho().opt(str);
        if ((obj != null && !obj.equals(objOpt)) || (obj == null && objOpt != null)) {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.x;
                    JSONObject jSONObject2 = new JSONObject();
                    com.byazt.ec.g.hn(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.x = jSONObject2;
                } catch (JSONException e) {
                    com.byazt.ec.w.hw(e);
                }
            }
            z = true;
        } else {
            z = false;
        }
        com.byazt.ec.w.pr("updateHeader, " + str + ", " + objOpt + ", " + obj, null);
        return z;
    }

    public static void pr(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(str, str2);
        }
    }

    public static boolean pr(String str) {
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

    /* JADX WARN: Code duplicated, block: B:17:0x0031 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:18:0x0032 A[RETURN] */
    public static boolean hw(String str) {
        boolean z;
        if (TextUtils.isEmpty(str) || "unknown".equalsIgnoreCase(str) || "Null".equalsIgnoreCase(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                z = false;
                if (z) {
                    return false;
                }
                return true;
            }
        }
        z = true;
        if (z) {
            return true;
        }
        return false;
    }

    public int k() {
        String strOptString = ho().optString("device_id", "");
        ho().optString("install_id", "");
        if (hw(strOptString)) {
            return this.fw.getInt("version_code", 0) == ho().optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public long m() {
        return ho().optLong("register_time", 0L);
    }

    public boolean pr(JSONObject jSONObject, String str, String str2, String str3) {
        boolean z;
        boolean z2;
        if (com.byazt.ec.w.hw) {
            com.byazt.ec.w.pr("saveRegisterInfo, " + str + ", " + str2 + ", " + str3 + ", " + jSONObject, null);
        }
        boolean zHw = hw(str);
        boolean zHw2 = hw(str2);
        try {
            boolean zHw3 = hw(str3);
            int i = this.fw.getInt("version_code", 0);
            int iOptInt = ho().optInt("version_code", 0);
            SharedPreferences.Editor editorEdit = this.fw.edit();
            if (i != iOptInt) {
                editorEdit.putInt("version_code", iOptInt);
            }
            if (zHw) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                editorEdit.putLong("register_time", jCurrentTimeMillis);
                hw("register_time", Long.valueOf(jCurrentTimeMillis));
            } else if (!zHw) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("response", jSONObject);
                com.byazt.zrg.pr.pr("tt_fetch_did_error", jSONObject2);
            }
            String strOptString = ho().optString("device_id", "");
            if (zHw && hw("device_id", str)) {
                editorEdit.putString("device_id", str);
                z = true;
            } else {
                z = false;
            }
            String strOptString2 = ho().optString("install_id", "");
            if (zHw2 && hw("install_id", str2)) {
                editorEdit.putString("install_id", str2);
                z = true;
            }
            String strOptString3 = ho().optString("ssid", "");
            if (zHw3 && hw("ssid", str3)) {
                editorEdit.putString("ssid", str3);
                z2 = true;
            } else {
                z2 = z;
            }
            com.byazt.zrg.pr.k().pr(z2, strOptString, str, strOptString2, str2, strOptString3, str3);
            editorEdit.apply();
        } catch (JSONException e) {
            com.byazt.ec.w.hw(e);
        }
        return zHw && zHw2;
    }

    public String g() {
        return ho().optString("ab_sdk_version", "");
    }
}
