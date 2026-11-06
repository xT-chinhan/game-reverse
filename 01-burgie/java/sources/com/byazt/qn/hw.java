package com.byazt.qn;

import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 467, 13})
public class hw implements com.byazt.zq.c {
    public final com.byazt.cr.c pr;

    public hw(com.byazt.cr.c cVar) {
        this.pr = cVar;
    }

    @Override // com.byazt.zq.pr
    public void pr(String str, int i) {
        this.pr.pr(str, i);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str, long j) {
        this.pr.pr(str, j);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str, float f) {
        this.pr.pr(str, f);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str, boolean z) {
        this.pr.pr(str, z);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str, String str2) {
        this.pr.pr(str, str2);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str, Set<String> set) {
        this.pr.pr(str, set);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str) {
        this.pr.pr(str);
    }

    @Override // com.byazt.zq.pr
    public void pr() {
        this.pr.pr();
    }

    @Override // com.byazt.zq.pr
    public void hw() {
        this.pr.hw();
    }

    @Override // com.byazt.zq.pr
    public void hn() {
        this.pr.hn();
    }

    @Override // com.byazt.zq.pr
    public int hw(String str, int i) {
        return this.pr.getInt(str, i);
    }

    @Override // com.byazt.zq.pr
    public long hw(String str, long j) {
        return this.pr.getLong(str, j);
    }

    @Override // com.byazt.zq.pr
    public float hw(String str, float f) {
        return this.pr.getFloat(str, f);
    }

    @Override // com.byazt.zq.pr
    public boolean hw(String str, boolean z) {
        return this.pr.getBoolean(str, z);
    }

    @Override // com.byazt.zq.pr
    public String hw(String str, String str2) {
        return this.pr.getString(str, str2);
    }

    @Override // com.byazt.zq.pr
    public Set<String> hw(String str, Set<String> set) {
        return this.pr.getStringSet(str, set);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.pr.getAll();
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.pr.getString(str, str2);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return this.pr.getStringSet(str, set);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.pr.getInt(str, i);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.pr.getLong(str, j);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.pr.getFloat(str, f);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.pr.getBoolean(str, z);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public boolean contains(String str) {
        return this.pr.contains(str);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.pr.edit();
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.pr.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.pr.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
