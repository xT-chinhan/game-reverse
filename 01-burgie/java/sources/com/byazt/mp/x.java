package com.byazt.mp;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.mg.PluginConstants;
import com.byazt.sd.a;
import com.byazt.vkw.nt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 168, 121})
public class x {
    public volatile String a;
    public volatile String aj;
    public volatile String c;
    public volatile String cz;
    public volatile String fo;
    public volatile String fw;
    public volatile String g;
    public volatile String hn;
    public volatile String ho;
    public volatile String hw;
    public volatile String lb;
    public volatile JSONArray ny;
    public volatile String pr;
    public volatile String qa;
    public volatile String uc;
    public volatile String vk;
    public volatile String x;
    public volatile String zo;
    public volatile int k = -1;
    public volatile int m = -1;
    public volatile int nt = -1;
    public volatile int yb = -1;
    public volatile int rc = -1;
    public volatile SharedPreferences w = com.byazt.mg.hw.hw(a.getContext(), qa(), 0);

    @com.byazt.vzx.pr(pr = {0, 1, 168, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    private static class pr {
        public static x pr = new x();
    }

    public static x pr() {
        return pr.pr;
    }

    public SharedPreferences hw() {
        return this.w;
    }

    public int hn() {
        if (this.k == -1) {
            this.k = hw("live_ad_clk_cnt", 0);
        }
        return this.k;
    }

    public void pr(int i) {
        if (this.k == i) {
            return;
        }
        this.k = i;
        pr("live_ad_clk_cnt", i);
    }

    public String pr(String str) {
        if (this.g == null) {
            this.g = hw("dev03", str);
        }
        return this.g;
    }

    public void hw(String str) {
        this.g = str;
        pr("dev03", str);
    }

    public void hn(String str) {
        if (str != null && str.equals(this.ho)) {
            return;
        }
        this.ho = str;
        pr("keywords", str);
    }

    public String x(String str) {
        if (this.ho == null) {
            this.ho = hw("keywords", str);
        }
        return this.ho;
    }

    public void hw(int i) {
        if (i == this.nt) {
            return;
        }
        this.nt = i;
        pr("age_group", i);
    }

    public int x() {
        if (this.nt == -1) {
            this.nt = hw("age_group", Integer.MIN_VALUE);
        }
        return this.nt;
    }

    public void hn(int i) {
        if (i == this.yb) {
            return;
        }
        this.yb = i;
        pr("sdk_theme_status", i);
    }

    public int x(int i) {
        if (this.yb == -1) {
            this.yb = hw("sdk_theme_status", i);
        }
        return this.yb;
    }

    public void c(String str) {
        if (str != null && str.equals(this.lb)) {
            return;
        }
        this.lb = str;
        pr("extra_data", str);
    }

    public String uc(String str) {
        if (this.lb == null) {
            this.lb = hw("extra_data", str);
        }
        return this.lb;
    }

    public void fw(String str) {
        if (str != null && str.equals(this.qa)) {
            return;
        }
        this.qa = str;
        pr("extra_internal_data", str);
    }

    public String zo(String str) {
        if (this.qa == null) {
            this.qa = hw("extra_internal_data", str);
        }
        return this.qa;
    }

    public String c(int i) {
        if (TextUtils.isEmpty(this.a)) {
            try {
                String strHw = hw("logsdk_version", "");
                if (!TextUtils.isEmpty(strHw)) {
                    JSONObject jSONObject = new JSONObject(strHw);
                    int iOptInt = jSONObject.optInt(PluginConstants.KEY_PLUGIN_VERSION);
                    this.a = jSONObject.optString("log_version");
                    if (iOptInt != 7714 || TextUtils.isEmpty(this.a)) {
                        a();
                    }
                } else {
                    a();
                }
            } catch (Exception e) {
            }
        }
        return this.a;
    }

    private void a() {
        try {
            this.a = com.byazt.sd.uc.pr().x();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, 7714);
            jSONObject.put("log_version", this.a);
            pr("logsdk_version", jSONObject.toString());
        } catch (JSONException e) {
        }
    }

    public String aj(String str) {
        if (this.pr == null) {
            this.pr = hw("dev01", str);
        }
        return this.pr;
    }

    public String c() {
        if (this.hw == null) {
            this.hw = ((nt) com.byazt.zs.uc.pr("encrypt_service")).x(hw("dev02", (String) null));
        }
        return this.hw;
    }

    public String uc() {
        if (this.hn == null) {
            this.hn = hw("dev04", (String) null);
        }
        return this.hn;
    }

    public String fw() {
        if (this.x == null) {
            this.x = hw("dev05", (String) null);
        }
        return this.x;
    }

    public String zo() {
        if (this.c == null) {
            this.c = hw("dev07", (String) null);
        }
        return this.c;
    }

    public String aj() {
        if (this.uc == null) {
            this.uc = hw("dev08", (String) null);
        }
        return this.uc;
    }

    public String vk() {
        if (this.fw == null) {
            this.fw = hw("dev17", (String) null);
        }
        return this.fw;
    }

    public String w() {
        if (this.zo == null) {
            this.zo = hw("dev18", (String) null);
        }
        return this.zo;
    }

    public String k() {
        if (this.aj == null) {
            this.aj = hw("dev09", (String) null);
        }
        return this.aj;
    }

    public void vk(String str) {
        if (str == null || str.equals(this.cz)) {
            return;
        }
        this.cz = str;
        pr("dev10", str);
    }

    public String m() {
        if (this.cz == null) {
            this.cz = hw("dev10", (String) null);
        }
        return this.cz;
    }

    public String g() {
        if (this.vk == null) {
            this.vk = hw("dev11", (String) null);
        }
        return this.vk;
    }

    public void pr(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        String string = this.ny == null ? null : this.ny.toString();
        String string2 = jSONArray.toString();
        if (string2.equals(string)) {
            return;
        }
        this.ny = jSONArray;
        pr("dev12", string2);
    }

    public JSONArray ho() {
        String strHw;
        if (this.ny == null && (strHw = hw("dev12", (String) null)) != null) {
            try {
                this.ny = new JSONArray(strHw);
            } catch (JSONException e) {
            }
        }
        return this.ny;
    }

    public int nt() {
        return hw("sp_device_app_direction", -1);
    }

    public void uc(int i) {
        pr("sp_device_app_direction", i);
    }

    public boolean fw(int i) {
        return i == 3 || i == 4;
    }

    public String yb() {
        if (this.fo == null) {
            this.fo = hw("dev16", "");
        }
        return this.fo;
    }

    public void w(String str) {
        if (str != null && str.equals(this.fo)) {
            return;
        }
        this.fo = str;
        pr("dev16", str);
    }

    public boolean pr(boolean z) {
        if (this.m == -1) {
            this.m = hw("is_use_mediation", z ? 1 : 2);
        }
        return this.m == 1;
    }

    public void hw(boolean z) {
        int i = z ? 1 : 2;
        if (this.m != i) {
            this.m = i;
            pr("is_use_mediation", i);
        }
    }

    public void zo(int i) {
        if (this.rc == i) {
            return;
        }
        this.rc = i;
        pr("dev_level", i);
    }

    public void pr(String str, long j) {
        try {
            if (hn.pr().hw()) {
                com.byazt.jc.hw.pr(qa(), str, Long.valueOf(j));
                return;
            }
            SharedPreferences.Editor editorEdit = hw().edit();
            editorEdit.putLong(str, j);
            editorEdit.apply();
        } catch (Throwable th) {
        }
    }

    public long hw(String str, long j) {
        try {
            if (hn.pr().hw()) {
                return com.byazt.jc.hw.pr(qa(), str, j);
            }
            return hw().getLong(str, j);
        } catch (Throwable th) {
            return j;
        }
    }

    public void pr(String str, int i) {
        try {
            if (hn.pr().hw()) {
                com.byazt.jc.hw.pr(qa(), str, Integer.valueOf(i));
                return;
            }
            SharedPreferences.Editor editorEdit = hw().edit();
            editorEdit.putInt(str, i);
            editorEdit.apply();
        } catch (Throwable th) {
        }
    }

    public int hw(String str, int i) {
        try {
            if (hn.pr().hw()) {
                return com.byazt.jc.hw.pr(qa(), str, i);
            }
            return hw().getInt(str, i);
        } catch (Throwable th) {
            return i;
        }
    }

    public void pr(String str, String str2) {
        try {
            if (hn.pr().hw()) {
                com.byazt.jc.hw.pr(qa(), str, str2);
                return;
            }
            SharedPreferences.Editor editorEdit = hw().edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Throwable th) {
        }
    }

    public String hw(String str, String str2) {
        try {
            if (hn.pr().hw()) {
                return com.byazt.jc.hw.hw(qa(), str, str2);
            }
            return hw().getString(str, str2);
        } catch (Throwable th) {
            return str2;
        }
    }

    public String hn(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strHw = hw(str, "");
            if (TextUtils.isEmpty(strHw)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strHw);
            if (System.currentTimeMillis() - jSONObject.getLong("time") <= j) {
                return jSONObject.getString(Constants.VALUE_FIELD);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void hn(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.VALUE_FIELD, str2);
            jSONObject.put("time", System.currentTimeMillis());
            jSONObject.put("p_version", 7714);
            pr(str, jSONObject.toString());
        } catch (JSONException e) {
        }
    }

    public void lb() {
        try {
            SharedPreferences.Editor editorEdit = hw().edit();
            editorEdit.clear();
            editorEdit.apply();
        } catch (Throwable th) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 168, 759})
    public static class hw {
        public Map<String, Object> pr = new HashMap();

        public hw pr(String str) {
            if (str == null || str.equals(x.pr().pr)) {
                return this;
            }
            x.pr().pr = str;
            this.pr.put("dev01", str);
            return this;
        }

        public hw hw(String str) {
            if (str == null || str.equals(x.pr().hw)) {
                return this;
            }
            x.pr().hw = str;
            this.pr.put("dev02", ((nt) com.byazt.zs.uc.pr("encrypt_service")).hn(str));
            return this;
        }

        public hw hn(String str) {
            if (str == null || str.equals(x.pr().hn)) {
                return this;
            }
            x.pr().hn = str;
            this.pr.put("dev04", str);
            return this;
        }

        public hw x(String str) {
            if (str == null || str.equals(x.pr().x)) {
                return this;
            }
            x.pr().x = str;
            this.pr.put("dev05", str);
            return this;
        }

        public hw c(String str) {
            if (str == null || str.equals(x.pr().vk)) {
                return this;
            }
            x.pr().vk = str;
            this.pr.put("dev11", str);
            return this;
        }

        public hw uc(String str) {
            if (str == null || str.equals(x.pr().c)) {
                return this;
            }
            x.pr().c = str;
            this.pr.put("dev07", str);
            return this;
        }

        public hw fw(String str) {
            if (str == null || str.equals(x.pr().uc)) {
                return this;
            }
            x.pr().uc = str;
            this.pr.put("dev08", str);
            return this;
        }

        public hw zo(String str) {
            if (str == null || str.equals(x.pr().fw)) {
                return this;
            }
            x.pr().fw = str;
            this.pr.put("dev17", str);
            return this;
        }

        public hw aj(String str) {
            if (str == null || str.equals(x.pr().zo)) {
                return this;
            }
            x.pr().zo = str;
            this.pr.put("dev18", str);
            return this;
        }

        public hw vk(String str) {
            if (str == null || str.equals(x.pr().aj)) {
                return this;
            }
            x.pr().aj = str;
            this.pr.put("dev09", str);
            return this;
        }

        public void pr() {
            try {
                if (hn.pr().hw()) {
                    String strQa = x.pr().qa();
                    for (Map.Entry<String, Object> entry : this.pr.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            com.byazt.jc.hw.pr(strQa, key, (Boolean) value);
                        } else if (value instanceof Long) {
                            com.byazt.jc.hw.pr(strQa, key, (Long) value);
                        } else if (value instanceof Float) {
                            com.byazt.jc.hw.pr(strQa, key, (Float) value);
                        } else if (value instanceof Integer) {
                            com.byazt.jc.hw.pr(strQa, key, (Integer) value);
                        } else if (value instanceof String) {
                            com.byazt.jc.hw.pr(strQa, key, (String) value);
                        }
                    }
                    return;
                }
                SharedPreferences.Editor editorEdit = x.pr().hw().edit();
                for (Map.Entry<String, Object> entry2 : this.pr.entrySet()) {
                    String key2 = entry2.getKey();
                    Object value2 = entry2.getValue();
                    if (value2 instanceof Boolean) {
                        editorEdit.putBoolean(key2, ((Boolean) value2).booleanValue());
                    } else if (value2 instanceof Long) {
                        editorEdit.putLong(key2, ((Long) value2).longValue());
                    } else if (value2 instanceof Float) {
                        editorEdit.putFloat(key2, ((Float) value2).floatValue());
                    } else if (value2 instanceof Integer) {
                        editorEdit.putInt(key2, ((Integer) value2).intValue());
                    } else if (value2 instanceof String) {
                        editorEdit.putString(key2, (String) value2);
                    }
                }
                editorEdit.apply();
            } catch (Exception e) {
            }
        }
    }

    public String qa() {
        return "sp_exec_getad_config";
    }
}
