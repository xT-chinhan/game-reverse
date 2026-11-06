package com.bytedance.sdk.component.ab.xr.ms;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.keva.KevaMonitor;
import com.bytedance.sdk.component.d.ms.xr;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Keva f750ms;
    private static final Map<String, xr> xr = new HashMap();
    private static volatile boolean ah = false;
    private static volatile boolean d = true;

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return null;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void xr() {
    }

    public static xr ms(Context context, String str, boolean z, int i) {
        if (!d) {
            return null;
        }
        try {
            if (!ah) {
                ah = ms(context);
            }
            if (TextUtils.isEmpty(str)) {
                str = "tt_ad_sdk_keva";
            }
            if (!d) {
                return null;
            }
            Map<String, xr> map = xr;
            xr msVar = map.get(str);
            if (msVar == null) {
                msVar = new ms(str, z, i);
                if (d) {
                    map.put(str, msVar);
                }
            }
            if (d) {
                return msVar;
            }
            return null;
        } catch (Throwable unused) {
            d = false;
            return null;
        }
    }

    private static boolean ms(Context context) {
        if (context == null) {
            return false;
        }
        KevaBuilder kevaBuilder = KevaBuilder.getInstance();
        kevaBuilder.setMonitor(new KevaMonitor() { // from class: com.bytedance.sdk.component.ab.xr.ms.ms.1
        });
        kevaBuilder.setContext(context);
        return true;
    }

    private ms(String str, boolean z, int i) {
        if (i == 1) {
            ah(str, z);
        } else {
            d(str, z);
        }
    }

    private void ah(String str, boolean z) {
        if (z) {
            this.f750ms = Keva.getRepo(str, 1);
        } else {
            this.f750ms = Keva.getRepo(str, 0);
        }
    }

    private void d(String str, boolean z) {
        if (z) {
            this.f750ms = Keva.getRepoSync(str, 1);
        } else {
            this.f750ms = Keva.getRepoSync(str, 0);
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(xr.ms<Map<String, ?>> msVar) {
        msVar.ms(getAll());
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, int i) {
        this.f750ms.storeInt(str, i);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, long j) {
        this.f750ms.storeLong(str, j);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, float f) {
        this.f750ms.storeFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, boolean z) {
        this.f750ms.storeBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, String str2) {
        this.f750ms.storeString(str, str2);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, Set<String> set) {
        this.f750ms.getStringSet(str, set);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str) {
        this.f750ms.erase(str);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms() {
        this.f750ms.clear();
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public int xr(String str, int i) {
        return getInt(str, i);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public long xr(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public float xr(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public boolean xr(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public String xr(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public Set<String> xr(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.f750ms.getAll();
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.f750ms.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return this.f750ms.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.f750ms.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.f750ms.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.f750ms.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.f750ms.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f750ms.contains(str);
    }
}
