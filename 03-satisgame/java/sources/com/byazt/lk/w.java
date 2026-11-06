package com.byazt.lk;

import android.content.SharedPreferences;
import com.byazt.gwu.x;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1266, 13})
public class w implements x {
    public final com.byazt.eau.l n;

    public w(com.byazt.eau.l lVar) {
        this.n = lVar;
    }

    @Override // com.byazt.gwu.n
    public void n(String str, int i) {
        com.byazt.sl.qg.n(str, Integer.valueOf(i), this.n);
    }

    @Override // com.byazt.gwu.n
    public void n(String str, long j) {
        com.byazt.sl.qg.n(str, Long.valueOf(j), this.n);
    }

    @Override // com.byazt.gwu.n
    public void n(String str, float f) {
        com.byazt.sl.qg.n(str, Float.valueOf(f), this.n);
    }

    @Override // com.byazt.gwu.n
    public void n(String str, boolean z) {
        com.byazt.sl.qg.n(str, Boolean.valueOf(z), this.n);
    }

    @Override // com.byazt.gwu.n
    public void n(String str, String str2) {
        com.byazt.sl.qg.n(str, str2, this.n);
    }

    @Override // com.byazt.gwu.n
    public void n(String str, Set<String> set) {
        com.byazt.sl.qg.n(str, set, this.n);
    }

    @Override // com.byazt.gwu.n
    public void n(String str) {
        com.byazt.sl.qg.qg(str, this.n);
    }

    @Override // com.byazt.gwu.n
    public int qg(String str, int i) {
        return com.byazt.sl.qg.n(str, this.n, i);
    }

    @Override // com.byazt.gwu.n
    public long qg(String str, long j) {
        return com.byazt.sl.qg.n(str, this.n, j);
    }

    @Override // com.byazt.gwu.n
    public float qg(String str, float f) {
        return com.byazt.sl.qg.n(str, this.n, f);
    }

    @Override // com.byazt.gwu.n
    public boolean qg(String str, boolean z) {
        return com.byazt.sl.qg.n(str, this.n, z);
    }

    @Override // com.byazt.gwu.n
    public String qg(String str, String str2) {
        return com.byazt.sl.qg.n(str, this.n, str2);
    }

    @Override // com.byazt.gwu.n
    public Set<String> qg(String str, Set<String> set) {
        return com.byazt.sl.qg.n(str, this.n, set);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return com.byazt.sl.qg.n(str, this.n, str2);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return com.byazt.sl.qg.n(str, this.n, set);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return com.byazt.sl.qg.n(str, this.n, i);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return com.byazt.sl.qg.n(str, this.n, j);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return com.byazt.sl.qg.n(str, this.n, f);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return com.byazt.sl.qg.n(str, this.n, z);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public Map<String, String> getAll() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.n.getAll().entrySet()) {
            map.put((String) entry.getKey(), com.byazt.sl.qg.n((String) entry.getValue()));
        }
        return map;
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public boolean contains(String str) {
        return this.n.contains(str);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new n(this.n.edit(), this.n);
    }

    @Override // com.byazt.gwu.n
    public void n() {
        this.n.n();
    }

    @Override // com.byazt.gwu.n
    public void qg() {
        this.n.qg();
    }

    @Override // com.byazt.gwu.n
    public void s() {
        this.n.s();
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.n.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.n.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @com.byazt.cp.n(n = {0, 1, 1266, 108})
    private static class n implements SharedPreferences.Editor {
        public final SharedPreferences.Editor n;
        public final com.byazt.eau.l qg;

        public n(SharedPreferences.Editor editor, com.byazt.eau.l lVar) {
            this.n = editor;
            this.qg = lVar;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            com.byazt.sl.qg.n(str, Integer.valueOf(i), this.qg);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            com.byazt.sl.qg.n(str, Long.valueOf(j), this.qg);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            com.byazt.sl.qg.n(str, Float.valueOf(f), this.qg);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            com.byazt.sl.qg.n(str, Boolean.valueOf(z), this.qg);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            com.byazt.sl.qg.n(str, str2, this.qg);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            com.byazt.sl.qg.n(str, set, this.qg);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            com.byazt.sl.qg.qg(str, this.qg);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.n.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return this.n.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            this.n.apply();
        }
    }
}
