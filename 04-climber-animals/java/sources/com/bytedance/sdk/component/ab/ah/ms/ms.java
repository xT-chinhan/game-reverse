package com.bytedance.sdk.component.ab.ah.ms;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements com.bytedance.sdk.component.d.ms.xr {
    private static final Map<String, com.bytedance.sdk.component.d.ms.xr> xr = new ConcurrentHashMap();

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f747ms;

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

    public static com.bytedance.sdk.component.d.ms.xr xr(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_multi_sp";
        }
        Map<String, com.bytedance.sdk.component.d.ms.xr> map = xr;
        com.bytedance.sdk.component.d.ms.xr xrVar = map.get(str);
        if (xrVar != null) {
            return xrVar;
        }
        ms msVar = new ms(str);
        map.put(str, msVar);
        return msVar;
    }

    private ms(String str) {
        this.f747ms = str;
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(com.bytedance.sdk.component.d.ms.xr.ms<Map<String, ?>> msVar) {
        msVar.ms(getAll());
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, int i) {
        xr.ms(this.f747ms, str, Integer.valueOf(i));
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, long j) {
        xr.ms(this.f747ms, str, Long.valueOf(j));
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, float f) {
        xr.ms(this.f747ms, str, Float.valueOf(f));
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, boolean z) {
        xr.ms(this.f747ms, str, Boolean.valueOf(z));
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, String str2) {
        xr.ms(this.f747ms, str, str2);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, Set<String> set) {
        xr.ms(this.f747ms, str, set);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return xr.xr(this.f747ms);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return xr.xr(this.f747ms, str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return xr.xr(this.f747ms, str, set);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return xr.ms(this.f747ms, str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return xr.ms(this.f747ms, str, j);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return xr.ms(this.f747ms, str, f);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return xr.ms(this.f747ms, str, z);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return xr.ms(this.f747ms, str);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str) {
        xr.xr(this.f747ms, str);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms() {
        xr.ms(this.f747ms);
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
}
