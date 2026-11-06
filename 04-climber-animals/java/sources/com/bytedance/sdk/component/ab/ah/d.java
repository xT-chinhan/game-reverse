package com.bytedance.sdk.component.ab.ah;

import android.content.SharedPreferences;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.bytedance.sdk.component.d.ms.xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    SharedPreferences f742ms;

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void xr() {
    }

    public d(SharedPreferences sharedPreferences) {
        this.f742ms = sharedPreferences;
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(com.bytedance.sdk.component.d.ms.xr.ms<Map<String, ?>> msVar) {
        if (msVar != null) {
            msVar.ms(getAll());
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, int i) {
        try {
            this.f742ms.edit().putInt(str, i).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, long j) {
        try {
            this.f742ms.edit().putLong(str, j).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, float f) {
        try {
            this.f742ms.edit().putFloat(str, f).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, boolean z) {
        try {
            this.f742ms.edit().putBoolean(str, z).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, String str2) {
        try {
            this.f742ms.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, Set<String> set) {
        try {
            this.f742ms.edit().putStringSet(str, set).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str) {
        try {
            this.f742ms.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms() {
        try {
            this.f742ms.edit().clear().apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public int xr(String str, int i) {
        try {
            return this.f742ms.getInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public long xr(String str, long j) {
        try {
            return this.f742ms.getLong(str, j);
        } catch (Exception unused) {
            return j;
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public float xr(String str, float f) {
        try {
            return this.f742ms.getFloat(str, f);
        } catch (Exception unused) {
            return f;
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public boolean xr(String str, boolean z) {
        try {
            return this.f742ms.getBoolean(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public String xr(String str, String str2) {
        try {
            return this.f742ms.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public Set<String> xr(String str, Set<String> set) {
        try {
            return this.f742ms.getStringSet(str, set);
        } catch (Exception unused) {
            return set;
        }
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        try {
            return this.f742ms.getAll();
        } catch (Exception unused) {
            return Collections.emptyMap();
        }
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        try {
            return this.f742ms.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        try {
            return this.f742ms.getStringSet(str, set);
        } catch (Exception unused) {
            return set;
        }
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        try {
            return this.f742ms.getInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        try {
            return this.f742ms.getLong(str, j);
        } catch (Exception unused) {
            return j;
        }
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        try {
            return this.f742ms.getFloat(str, f);
        } catch (Exception unused) {
            return f;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        try {
            return this.f742ms.getBoolean(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f742ms.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f742ms.edit();
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f742ms.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f742ms.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
