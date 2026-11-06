package com.byazt.qn;

import android.content.SharedPreferences;
import com.byazt.zq.fw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 467, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements fw {
    public final com.byazt.cr.c pr;

    public c(com.byazt.cr.c cVar) {
        this.pr = cVar;
    }

    @Override // com.byazt.zq.pr
    public void pr(String str, int i) {
        com.byazt.hm.hw.pr(str, Integer.valueOf(i), this.pr);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str, long j) {
        com.byazt.hm.hw.pr(str, Long.valueOf(j), this.pr);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str, float f) {
        com.byazt.hm.hw.pr(str, Float.valueOf(f), this.pr);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str, boolean z) {
        com.byazt.hm.hw.pr(str, Boolean.valueOf(z), this.pr);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str, String str2) {
        com.byazt.hm.hw.pr(str, str2, this.pr);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str, Set<String> set) {
        com.byazt.hm.hw.pr(str, set, this.pr);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str) {
        com.byazt.hm.hw.hw(str, this.pr);
    }

    @Override // com.byazt.zq.pr
    public int hw(String str, int i) {
        return com.byazt.hm.hw.pr(str, this.pr, i);
    }

    @Override // com.byazt.zq.pr
    public long hw(String str, long j) {
        return com.byazt.hm.hw.pr(str, this.pr, j);
    }

    @Override // com.byazt.zq.pr
    public float hw(String str, float f) {
        return com.byazt.hm.hw.pr(str, this.pr, f);
    }

    @Override // com.byazt.zq.pr
    public boolean hw(String str, boolean z) {
        return com.byazt.hm.hw.pr(str, this.pr, z);
    }

    @Override // com.byazt.zq.pr
    public String hw(String str, String str2) {
        return com.byazt.hm.hw.pr(str, this.pr, str2);
    }

    @Override // com.byazt.zq.pr
    public Set<String> hw(String str, Set<String> set) {
        return com.byazt.hm.hw.pr(str, this.pr, set);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return com.byazt.hm.hw.pr(str, this.pr, str2);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return com.byazt.hm.hw.pr(str, this.pr, set);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return com.byazt.hm.hw.pr(str, this.pr, i);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return com.byazt.hm.hw.pr(str, this.pr, j);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return com.byazt.hm.hw.pr(str, this.pr, f);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return com.byazt.hm.hw.pr(str, this.pr, z);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public Map<String, String> getAll() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.pr.getAll().entrySet()) {
            map.put((String) entry.getKey(), com.byazt.hm.hw.pr((String) entry.getValue()));
        }
        return map;
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public boolean contains(String str) {
        return this.pr.contains(str);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new pr(this.pr.edit(), this.pr);
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

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.pr.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.pr.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 467, 169})
    private static class pr implements SharedPreferences.Editor {
        public final com.byazt.cr.c hw;
        public final SharedPreferences.Editor pr;

        public pr(SharedPreferences.Editor editor, com.byazt.cr.c cVar) {
            this.pr = editor;
            this.hw = cVar;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            com.byazt.hm.hw.pr(str, Integer.valueOf(i), this.hw);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            com.byazt.hm.hw.pr(str, Long.valueOf(j), this.hw);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            com.byazt.hm.hw.pr(str, Float.valueOf(f), this.hw);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            com.byazt.hm.hw.pr(str, Boolean.valueOf(z), this.hw);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            com.byazt.hm.hw.pr(str, str2, this.hw);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            com.byazt.hm.hw.pr(str, set, this.hw);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            com.byazt.hm.hw.hw(str, this.hw);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.pr.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return this.pr.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            this.pr.apply();
        }
    }
}
