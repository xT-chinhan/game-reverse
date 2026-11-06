package com.byazt.bj;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.eau.l;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.keva.KevaMonitor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1143, 19})
public class n implements l {
    public Keva n;
    public static final Map<String, l> qg = new HashMap();
    public static volatile boolean s = false;
    public static volatile boolean q = true;

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return null;
    }

    @Override // com.byazt.eau.l
    public void qg() {
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.byazt.eau.l
    public void s() {
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    public static l n(Context context, String str, boolean z, int i) {
        if (!q) {
            return null;
        }
        try {
            if (!s) {
                s = n(context);
            }
            if (TextUtils.isEmpty(str)) {
                str = "tt_ad_sdk_keva";
            }
            if (!q) {
                return null;
            }
            Map<String, l> map = qg;
            l nVar = map.get(str);
            if (nVar == null) {
                nVar = new n(str, z, i);
                if (q) {
                    map.put(str, nVar);
                }
            }
            if (q) {
                return nVar;
            }
            return null;
        } catch (Throwable unused) {
            q = false;
            return null;
        }
    }

    private static boolean n(Context context) {
        if (context == null) {
            return false;
        }
        KevaBuilder kevaBuilder = KevaBuilder.getInstance();
        kevaBuilder.setMonitor(new KevaMonitor() { // from class: com.byazt.bj.n.1
        });
        kevaBuilder.setContext(context);
        return true;
    }

    private n(String str, boolean z, int i) {
        if (i == 1) {
            s(str, z);
        } else {
            q(str, z);
        }
    }

    private void s(String str, boolean z) {
        if (z) {
            this.n = Keva.getRepo(str, 1);
        } else {
            this.n = Keva.getRepo(str, 0);
        }
    }

    private void q(String str, boolean z) {
        if (z) {
            this.n = Keva.getRepoSync(str, 1);
        } else {
            this.n = Keva.getRepoSync(str, 0);
        }
    }

    @Override // com.byazt.eau.l
    public void n(String str, int i) {
        this.n.storeInt(str, i);
    }

    @Override // com.byazt.eau.l
    public void n(String str, long j) {
        this.n.storeLong(str, j);
    }

    @Override // com.byazt.eau.l
    public void n(String str, float f) {
        this.n.storeFloat(str, f);
    }

    @Override // com.byazt.eau.l
    public void n(String str, boolean z) {
        this.n.storeBoolean(str, z);
    }

    @Override // com.byazt.eau.l
    public void n(String str, String str2) {
        this.n.storeString(str, str2);
    }

    @Override // com.byazt.eau.l
    public void n(String str, Set<String> set) {
        this.n.getStringSet(str, set);
    }

    @Override // com.byazt.eau.l
    public void n(String str) {
        this.n.erase(str);
    }

    @Override // com.byazt.eau.l
    public void n() {
        this.n.clear();
    }

    @Override // com.byazt.eau.l
    public int qg(String str, int i) {
        return getInt(str, i);
    }

    @Override // com.byazt.eau.l
    public long qg(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.byazt.eau.l
    public float qg(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.byazt.eau.l
    public boolean qg(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.byazt.eau.l
    public String qg(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.byazt.eau.l
    public Set<String> qg(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.n.getAll();
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.n.getString(str, str2);
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return this.n.getStringSet(str, set);
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.n.getInt(str, i);
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.n.getLong(str, j);
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.n.getFloat(str, f);
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.n.getBoolean(str, z);
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public boolean contains(String str) {
        return this.n.contains(str);
    }
}
