package com.byazt.qz;

import android.content.SharedPreferences;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1192, 121})
public class x implements com.byazt.cr.c {
    public SharedPreferences pr;

    public x(SharedPreferences sharedPreferences) {
        this.pr = sharedPreferences;
    }

    @Override // com.byazt.cr.c
    public void pr(String str, int i) {
        try {
            this.pr.edit().putInt(str, i).apply();
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.cr.c
    public void pr(String str, long j) {
        try {
            this.pr.edit().putLong(str, j).apply();
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.cr.c
    public void pr(String str, float f) {
        try {
            this.pr.edit().putFloat(str, f).apply();
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.cr.c
    public void pr(String str, boolean z) {
        try {
            this.pr.edit().putBoolean(str, z).apply();
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.cr.c
    public void pr(String str, String str2) {
        try {
            this.pr.edit().putString(str, str2).apply();
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.cr.c
    public void pr(String str, Set<String> set) {
        try {
            this.pr.edit().putStringSet(str, set).apply();
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.cr.c
    public void pr(String str) {
        try {
            this.pr.edit().remove(str).apply();
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.cr.c
    public void pr() {
        try {
            this.pr.edit().clear().apply();
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.cr.c
    public void hw() {
    }

    @Override // com.byazt.cr.c
    public void hn() {
    }

    @Override // com.byazt.cr.c
    public int hw(String str, int i) {
        try {
            return this.pr.getInt(str, i);
        } catch (Exception e) {
            return i;
        }
    }

    @Override // com.byazt.cr.c
    public long hw(String str, long j) {
        try {
            return this.pr.getLong(str, j);
        } catch (Exception e) {
            return j;
        }
    }

    @Override // com.byazt.cr.c
    public float hw(String str, float f) {
        try {
            return this.pr.getFloat(str, f);
        } catch (Exception e) {
            return f;
        }
    }

    @Override // com.byazt.cr.c
    public boolean hw(String str, boolean z) {
        try {
            return this.pr.getBoolean(str, z);
        } catch (Exception e) {
            return z;
        }
    }

    @Override // com.byazt.cr.c
    public String hw(String str, String str2) {
        try {
            return this.pr.getString(str, str2);
        } catch (Exception e) {
            return str2;
        }
    }

    @Override // com.byazt.cr.c
    public Set<String> hw(String str, Set<String> set) {
        try {
            return this.pr.getStringSet(str, set);
        } catch (Exception e) {
            return set;
        }
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        try {
            return this.pr.getAll();
        } catch (Exception e) {
            return Collections.emptyMap();
        }
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public String getString(String str, String str2) {
        try {
            return this.pr.getString(str, str2);
        } catch (Exception e) {
            return str2;
        }
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        try {
            return this.pr.getStringSet(str, set);
        } catch (Exception e) {
            return set;
        }
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public int getInt(String str, int i) {
        try {
            return this.pr.getInt(str, i);
        } catch (Exception e) {
            return i;
        }
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public long getLong(String str, long j) {
        try {
            return this.pr.getLong(str, j);
        } catch (Exception e) {
            return j;
        }
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        try {
            return this.pr.getFloat(str, f);
        } catch (Exception e) {
            return f;
        }
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        try {
            return this.pr.getBoolean(str, z);
        } catch (Exception e) {
            return z;
        }
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public boolean contains(String str) {
        return this.pr.contains(str);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.pr.edit();
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.pr.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.pr.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
