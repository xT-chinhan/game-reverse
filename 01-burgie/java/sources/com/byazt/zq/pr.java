package com.byazt.zq;

import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public interface pr extends SharedPreferences {
    @Override // android.content.SharedPreferences
    boolean contains(String str);

    @Override // android.content.SharedPreferences
    SharedPreferences.Editor edit();

    @Override // android.content.SharedPreferences
    Map getAll();

    @Override // android.content.SharedPreferences
    boolean getBoolean(String str, boolean z);

    @Override // android.content.SharedPreferences
    float getFloat(String str, float f);

    @Override // android.content.SharedPreferences
    int getInt(String str, int i);

    @Override // android.content.SharedPreferences
    long getLong(String str, long j);

    @Override // android.content.SharedPreferences
    String getString(String str, String str2);

    @Override // android.content.SharedPreferences
    Set<String> getStringSet(String str, Set<String> set);

    void hn();

    float hw(String str, float f);

    int hw(String str, int i);

    long hw(String str, long j);

    String hw(String str, String str2);

    Set<String> hw(String str, Set<String> set);

    void hw();

    boolean hw(String str, boolean z);

    void pr();

    void pr(String str);

    void pr(String str, float f);

    void pr(String str, int i);

    void pr(String str, long j);

    void pr(String str, String str2);

    void pr(String str, Set<String> set);

    void pr(String str, boolean z);

    @Override // android.content.SharedPreferences
    void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);

    @Override // android.content.SharedPreferences
    void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);
}
