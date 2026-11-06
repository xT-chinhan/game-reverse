package com.byazt.kn;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.km.sz;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1411, 19})
public class n {
    public final SharedPreferences.Editor q;
    public final SharedPreferences s;
    public final ReentrantReadWriteLock n = new ReentrantReadWriteLock();
    public final Map<String, String> qg = new HashMap();

    public n(Context context) {
        SharedPreferences sharedPreferencesQg = sz.qg(context);
        this.s = sharedPreferencesQg;
        this.q = sharedPreferencesQg.edit();
    }

    public void n(String str, String str2) {
        this.n.writeLock().lock();
        try {
            this.qg.put(str, str2);
            com.byazt.nt.n.n("__kite", "updateMemoryCacheBySync# update mem success, key: ".concat(String.valueOf(str)));
        } finally {
            this.n.writeLock().unlock();
        }
    }

    public void qg(String str, String str2) {
        try {
            this.q.putString(str, str2);
            this.q.commit();
        } catch (Exception e) {
            com.byazt.nt.n.qg("__kiteupdateDiskCache# error " + e.getMessage());
        }
    }

    public String n(String str) {
        String str2 = this.qg.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        this.n.readLock().lock();
        try {
            String string = this.qg.get(str);
            if (TextUtils.isEmpty(string)) {
                string = this.s.getString(str, "");
                if (!TextUtils.isEmpty(string)) {
                    this.qg.put(str, string);
                    if (com.byazt.nt.n.qg()) {
                        com.byazt.nt.n.n("__kitegetCacheOrFromDisk# check cache: " + str + " is empty, read from sp and update cache.");
                    }
                }
            }
            return string != null ? string : "";
        } finally {
            this.n.readLock().unlock();
        }
    }
}
