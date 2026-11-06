package com.byazt.xg;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.ec.g;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2065, 37})
public class pr {
    public final SharedPreferences hn;
    public final SharedPreferences.Editor x;
    public final ReentrantReadWriteLock pr = new ReentrantReadWriteLock();
    public final Map<String, String> hw = new HashMap();

    public pr(Context context) {
        SharedPreferences sharedPreferencesHw = g.hw(context);
        this.hn = sharedPreferencesHw;
        this.x = sharedPreferencesHw.edit();
    }

    public void pr(String str, String str2) {
        this.pr.writeLock().lock();
        try {
            this.hw.put(str, str2);
            com.byazt.wx.pr.pr("__kite", "updateMemoryCacheBySync# update mem success, key: ".concat(String.valueOf(str)));
        } finally {
            this.pr.writeLock().unlock();
        }
    }

    public void hw(String str, String str2) {
        try {
            this.x.putString(str, str2);
            this.x.commit();
        } catch (Exception e) {
            com.byazt.wx.pr.hw("__kiteupdateDiskCache# error " + e.getMessage());
        }
    }

    public String pr(String str) {
        String str2 = this.hw.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        this.pr.readLock().lock();
        try {
            String string = this.hw.get(str);
            if (TextUtils.isEmpty(string)) {
                string = this.hn.getString(str, "");
                if (!TextUtils.isEmpty(string)) {
                    this.hw.put(str, string);
                    if (com.byazt.wx.pr.hw()) {
                        com.byazt.wx.pr.pr("__kitegetCacheOrFromDisk# check cache: " + str + " is empty, read from sp and update cache.");
                    }
                }
            }
            return string != null ? string : "";
        } finally {
            this.pr.readLock().unlock();
        }
    }
}
