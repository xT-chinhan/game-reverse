package com.byazt.eau;

import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface l extends SharedPreferences {
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

    void n();

    void n(String str);

    void n(String str, float f);

    void n(String str, int i);

    void n(String str, long j);

    void n(String str, String str2);

    void n(String str, Set<String> set);

    void n(String str, boolean z);

    float qg(String str, float f);

    int qg(String str, int i);

    long qg(String str, long j);

    String qg(String str, String str2);

    Set<String> qg(String str, Set<String> set);

    void qg();

    boolean qg(String str, boolean z);

    @Override // android.content.SharedPreferences
    void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);

    void s();

    @Override // android.content.SharedPreferences
    void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);
}
