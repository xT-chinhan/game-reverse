package com.byazt.mty;

import android.content.SharedPreferences;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 669, 5})
public class q implements com.byazt.eau.l {
    public SharedPreferences n;

    @Override // com.byazt.eau.l
    public void qg() {
    }

    @Override // com.byazt.eau.l
    public void s() {
    }

    public q(SharedPreferences sharedPreferences) {
        this.n = sharedPreferences;
    }

    @Override // com.byazt.eau.l
    public void n(String str, int i) {
        try {
            this.n.edit().putInt(str, i).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.eau.l
    public void n(String str, long j) {
        try {
            this.n.edit().putLong(str, j).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.eau.l
    public void n(String str, float f) {
        try {
            this.n.edit().putFloat(str, f).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.eau.l
    public void n(String str, boolean z) {
        try {
            this.n.edit().putBoolean(str, z).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.eau.l
    public void n(String str, String str2) {
        try {
            this.n.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.eau.l
    public void n(String str, Set<String> set) {
        try {
            this.n.edit().putStringSet(str, set).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.eau.l
    public void n(String str) {
        try {
            this.n.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.eau.l
    public void n() {
        try {
            this.n.edit().clear().apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.eau.l
    public int qg(String str, int i) {
        try {
            return this.n.getInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    @Override // com.byazt.eau.l
    public long qg(String str, long j) {
        try {
            return this.n.getLong(str, j);
        } catch (Exception unused) {
            return j;
        }
    }

    @Override // com.byazt.eau.l
    public float qg(String str, float f) {
        try {
            return this.n.getFloat(str, f);
        } catch (Exception unused) {
            return f;
        }
    }

    @Override // com.byazt.eau.l
    public boolean qg(String str, boolean z) {
        try {
            return this.n.getBoolean(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // com.byazt.eau.l
    public String qg(String str, String str2) {
        try {
            return this.n.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // com.byazt.eau.l
    public Set<String> qg(String str, Set<String> set) {
        try {
            return this.n.getStringSet(str, set);
        } catch (Exception unused) {
            return set;
        }
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        try {
            return this.n.getAll();
        } catch (Exception unused) {
            return Collections.emptyMap();
        }
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public String getString(String str, String str2) {
        try {
            return this.n.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        try {
            return this.n.getStringSet(str, set);
        } catch (Exception unused) {
            return set;
        }
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public int getInt(String str, int i) {
        try {
            return this.n.getInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public long getLong(String str, long j) {
        try {
            return this.n.getLong(str, j);
        } catch (Exception unused) {
            return j;
        }
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        try {
            return this.n.getFloat(str, f);
        } catch (Exception unused) {
            return f;
        }
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        try {
            return this.n.getBoolean(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public boolean contains(String str) {
        return this.n.contains(str);
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.n.edit();
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.n.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.n.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
