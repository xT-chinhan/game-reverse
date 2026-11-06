package com.byazt.gwu;

import android.content.SharedPreferences;
import android.util.SparseArray;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1228, 26})
public class qg implements n, Function {
    public volatile Function n;
    public volatile n qg;

    public qg(n nVar) {
        this.qg = nVar;
    }

    public qg(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                this.qg.n((String) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
                return null;
            case 2:
                this.qg.n((String) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue());
                return null;
            case 3:
                this.qg.n((String) sparseArray.get(1), ((Float) sparseArray.get(2)).floatValue());
                return null;
            case 4:
                this.qg.n((String) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue());
                return null;
            case 5:
                this.qg.n((String) sparseArray.get(1), (String) sparseArray.get(2));
                return null;
            case 6:
                this.qg.n((String) sparseArray.get(1), (Set<String>) sparseArray.get(2));
                return null;
            case 7:
                this.qg.n((String) sparseArray.get(1));
                return null;
            case 8:
                this.qg.n();
                return null;
            case 9:
                this.qg.qg();
                return null;
            case 10:
                this.qg.s();
                return null;
            case 11:
                return Integer.valueOf(this.qg.qg((String) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue()));
            case 12:
                return Long.valueOf(this.qg.qg((String) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue()));
            case 13:
                return Float.valueOf(this.qg.qg((String) sparseArray.get(1), ((Float) sparseArray.get(2)).floatValue()));
            case 14:
                return Boolean.valueOf(this.qg.qg((String) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue()));
            case 15:
                return this.qg.qg((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 16:
                return this.qg.qg((String) sparseArray.get(1), (Set<String>) sparseArray.get(2));
            case 17:
                return this.qg.getAll();
            case 18:
                return this.qg.getString((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 19:
                return this.qg.getStringSet((String) sparseArray.get(1), (Set) sparseArray.get(2));
            case 20:
                return Integer.valueOf(this.qg.getInt((String) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue()));
            case 21:
                return Long.valueOf(this.qg.getLong((String) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue()));
            case 22:
                return Float.valueOf(this.qg.getFloat((String) sparseArray.get(1), ((Float) sparseArray.get(2)).floatValue()));
            case 23:
                return Boolean.valueOf(this.qg.getBoolean((String) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue()));
            case 24:
                return Boolean.valueOf(this.qg.contains((String) sparseArray.get(1)));
            case 25:
                return this.qg.edit();
            case 26:
                this.qg.registerOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener) sparseArray.get(1));
                return null;
            case 27:
                this.qg.unregisterOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener) sparseArray.get(1));
                return null;
            default:
                return null;
        }
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public boolean contains(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        sparseArray.put(1, str);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        return (SharedPreferences.Editor) this.n.apply(sparseArray);
    }

    public boolean equals(Object obj) {
        Object obj2;
        if (obj == null) {
            return false;
        }
        if (this.n != null) {
            obj2 = this.n;
        } else {
            if (this.qg == null) {
                return super.equals(obj);
            }
            obj2 = this.qg;
        }
        return obj.equals(obj2);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public Map getAll() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        return (Map) this.n.apply(sparseArray);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        sparseArray.put(1, str);
        sparseArray.put(2, Boolean.valueOf(z));
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        sparseArray.put(1, str);
        sparseArray.put(2, Float.valueOf(f));
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Float) objApply).floatValue();
        }
        return 0.0f;
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public int getInt(String str, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        sparseArray.put(1, str);
        sparseArray.put(2, Integer.valueOf(i));
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public long getLong(String str, long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        sparseArray.put(1, str);
        sparseArray.put(2, Long.valueOf(j));
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public String getString(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public Set getStringSet(String str, Set set) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        sparseArray.put(1, str);
        sparseArray.put(2, set);
        return (Set) this.n.apply(sparseArray);
    }

    public int hashCode() {
        Object obj;
        if (this.n != null) {
            obj = this.n;
        } else {
            if (this.qg == null) {
                return super.hashCode();
            }
            obj = this.qg;
        }
        return obj.hashCode();
    }

    @Override // com.byazt.gwu.n
    public void n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.gwu.n
    public void n(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.gwu.n
    public void n(String str, float f) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        sparseArray.put(2, Float.valueOf(f));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.gwu.n
    public void n(String str, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        sparseArray.put(2, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.gwu.n
    public void n(String str, long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        sparseArray.put(2, Long.valueOf(j));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.gwu.n
    public void n(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.gwu.n
    public void n(String str, Set set) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        sparseArray.put(2, set);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.gwu.n
    public void n(String str, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        sparseArray.put(2, Boolean.valueOf(z));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.gwu.n
    public float qg(String str, float f) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        sparseArray.put(1, str);
        sparseArray.put(2, Float.valueOf(f));
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Float) objApply).floatValue();
        }
        return 0.0f;
    }

    @Override // com.byazt.gwu.n
    public int qg(String str, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, str);
        sparseArray.put(2, Integer.valueOf(i));
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.gwu.n
    public long qg(String str, long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, str);
        sparseArray.put(2, Long.valueOf(j));
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.gwu.n
    public String qg(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.gwu.n
    public Set qg(String str, Set set) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, str);
        sparseArray.put(2, set);
        return (Set) this.n.apply(sparseArray);
    }

    @Override // com.byazt.gwu.n
    public void qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.gwu.n
    public boolean qg(String str, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, str);
        sparseArray.put(2, Boolean.valueOf(z));
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        sparseArray.put(1, onSharedPreferenceChangeListener);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.gwu.n
    public void s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.gwu.n, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 27);
        sparseArray.put(1, onSharedPreferenceChangeListener);
        this.n.apply(sparseArray);
    }
}
