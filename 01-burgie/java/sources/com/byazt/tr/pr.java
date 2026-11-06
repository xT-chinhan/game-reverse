package com.byazt.tr;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.cr.c;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.keva.KevaMonitor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1642, 37})
public class pr implements c {
    public Keva pr;
    public static final Map<String, c> hw = new HashMap();
    public static volatile boolean hn = false;
    public static volatile boolean x = true;

    public static c pr(Context context, String str, boolean z, int i) {
        if (!x) {
            return null;
        }
        try {
            if (!hn) {
                hn = pr(context);
            }
            if (TextUtils.isEmpty(str)) {
                str = "tt_ad_sdk_keva";
            }
            if (!x) {
                return null;
            }
            Map<String, c> map = hw;
            c prVar = map.get(str);
            if (prVar == null) {
                prVar = new pr(str, z, i);
                if (x) {
                    map.put(str, prVar);
                }
            }
            if (x) {
                return prVar;
            }
            return null;
        } catch (Throwable th) {
            x = false;
            return null;
        }
    }

    private static boolean pr(Context context) {
        if (context == null) {
            return false;
        }
        KevaBuilder kevaBuilder = KevaBuilder.getInstance();
        kevaBuilder.setMonitor(new KevaMonitor() { // from class: com.byazt.tr.pr.1
        });
        kevaBuilder.setContext(context);
        return true;
    }

    private pr(String str, boolean z, int i) {
        switch (i) {
            case 1:
                hn(str, z);
                break;
            default:
                x(str, z);
                break;
        }
    }

    private void hn(String str, boolean z) {
        if (z) {
            this.pr = Keva.getRepo(str, 1);
        } else {
            this.pr = Keva.getRepo(str, 0);
        }
    }

    private void x(String str, boolean z) {
        if (z) {
            this.pr = Keva.getRepoSync(str, 1);
        } else {
            this.pr = Keva.getRepoSync(str, 0);
        }
    }

    @Override // com.byazt.cr.c
    public void pr(String str, int i) {
        this.pr.storeInt(str, i);
    }

    @Override // com.byazt.cr.c
    public void pr(String str, long j) {
        this.pr.storeLong(str, j);
    }

    @Override // com.byazt.cr.c
    public void pr(String str, float f) {
        this.pr.storeFloat(str, f);
    }

    @Override // com.byazt.cr.c
    public void pr(String str, boolean z) {
        this.pr.storeBoolean(str, z);
    }

    @Override // com.byazt.cr.c
    public void pr(String str, String str2) {
        this.pr.storeString(str, str2);
    }

    @Override // com.byazt.cr.c
    public void pr(String str, Set<String> set) {
        this.pr.getStringSet(str, set);
    }

    @Override // com.byazt.cr.c
    public void pr(String str) {
        this.pr.erase(str);
    }

    @Override // com.byazt.cr.c
    public void pr() {
        this.pr.clear();
    }

    @Override // com.byazt.cr.c
    public void hw() {
    }

    @Override // com.byazt.cr.c
    public void hn() {
    }

    @Override // com.byazt.cr.c
    public int hw(String str, int i) {
        return getInt(str, i);
    }

    @Override // com.byazt.cr.c
    public long hw(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.byazt.cr.c
    public float hw(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.byazt.cr.c
    public boolean hw(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.byazt.cr.c
    public String hw(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.byazt.cr.c
    public Set<String> hw(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.pr.getAll();
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.pr.getString(str, str2);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return this.pr.getStringSet(str, set);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.pr.getInt(str, i);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.pr.getLong(str, j);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.pr.getFloat(str, f);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.pr.getBoolean(str, z);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public boolean contains(String str) {
        return this.pr.contains(str);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return null;
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
