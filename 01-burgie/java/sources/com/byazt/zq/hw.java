package com.byazt.zq;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, AVMDLDataLoader.KeyIsGetCustomHttpHeader, 13})
public class hw implements pr, Function {
    public volatile pr hw;
    public volatile Function pr;

    public hw(pr prVar) {
        this.hw = prVar;
    }

    public hw(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                this.hw.pr((String) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
                return null;
            case 2:
                this.hw.pr((String) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue());
                return null;
            case 3:
                this.hw.pr((String) sparseArray.get(1), ((Float) sparseArray.get(2)).floatValue());
                return null;
            case 4:
                this.hw.pr((String) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue());
                return null;
            case 5:
                this.hw.pr((String) sparseArray.get(1), (String) sparseArray.get(2));
                return null;
            case 6:
                this.hw.pr((String) sparseArray.get(1), (Set<String>) sparseArray.get(2));
                return null;
            case 7:
                this.hw.pr((String) sparseArray.get(1));
                return null;
            case 8:
                this.hw.pr();
                return null;
            case 9:
                this.hw.hw();
                return null;
            case 10:
                this.hw.hn();
                return null;
            case 11:
                return Integer.valueOf(this.hw.hw((String) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue()));
            case 12:
                return Long.valueOf(this.hw.hw((String) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue()));
            case 13:
                return Float.valueOf(this.hw.hw((String) sparseArray.get(1), ((Float) sparseArray.get(2)).floatValue()));
            case 14:
                return Boolean.valueOf(this.hw.hw((String) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue()));
            case 15:
                return this.hw.hw((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 16:
                return this.hw.hw((String) sparseArray.get(1), (Set<String>) sparseArray.get(2));
            case 17:
                return this.hw.getAll();
            case 18:
                return this.hw.getString((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 19:
                return this.hw.getStringSet((String) sparseArray.get(1), (Set) sparseArray.get(2));
            case 20:
                return Integer.valueOf(this.hw.getInt((String) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue()));
            case 21:
                return Long.valueOf(this.hw.getLong((String) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue()));
            case 22:
                return Float.valueOf(this.hw.getFloat((String) sparseArray.get(1), ((Float) sparseArray.get(2)).floatValue()));
            case 23:
                return Boolean.valueOf(this.hw.getBoolean((String) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue()));
            case 24:
                return Boolean.valueOf(this.hw.contains((String) sparseArray.get(1)));
            case 25:
                return this.hw.edit();
            case 26:
                this.hw.registerOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener) sparseArray.get(1));
                return null;
            case 27:
                this.hw.unregisterOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener) sparseArray.get(1));
                return null;
            default:
                return null;
        }
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public boolean contains(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        sparseArray.put(1, str);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        return (SharedPreferences.Editor) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public Map getAll() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        return (Map) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        sparseArray.put(1, str);
        sparseArray.put(2, Boolean.valueOf(z));
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        sparseArray.put(1, str);
        sparseArray.put(2, Float.valueOf(f));
        return ((Float) this.pr.apply(sparseArray)).floatValue();
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public int getInt(String str, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        sparseArray.put(1, str);
        sparseArray.put(2, Integer.valueOf(i));
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public long getLong(String str, long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        sparseArray.put(1, str);
        sparseArray.put(2, Long.valueOf(j));
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public String getString(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public Set getStringSet(String str, Set set) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        sparseArray.put(1, str);
        sparseArray.put(2, set);
        return (Set) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.zq.pr
    public void hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.zq.pr
    public float hw(String str, float f) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        sparseArray.put(1, str);
        sparseArray.put(2, Float.valueOf(f));
        return ((Float) this.pr.apply(sparseArray)).floatValue();
    }

    @Override // com.byazt.zq.pr
    public int hw(String str, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, str);
        sparseArray.put(2, Integer.valueOf(i));
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.zq.pr
    public long hw(String str, long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, str);
        sparseArray.put(2, Long.valueOf(j));
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.zq.pr
    public String hw(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.zq.pr
    public Set hw(String str, Set set) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, str);
        sparseArray.put(2, set);
        return (Set) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.zq.pr
    public void hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.zq.pr
    public boolean hw(String str, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, str);
        sparseArray.put(2, Boolean.valueOf(z));
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.zq.pr
    public void pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str, float f) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        sparseArray.put(2, Float.valueOf(f));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        sparseArray.put(2, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str, long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        sparseArray.put(2, Long.valueOf(j));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str, Set set) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        sparseArray.put(2, set);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.zq.pr
    public void pr(String str, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        sparseArray.put(2, Boolean.valueOf(z));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        sparseArray.put(1, onSharedPreferenceChangeListener);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.zq.pr, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 27);
        sparseArray.put(1, onSharedPreferenceChangeListener);
        this.pr.apply(sparseArray);
    }
}
