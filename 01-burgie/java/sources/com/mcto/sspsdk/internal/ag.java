package com.mcto.sspsdk.internal;

import com.byazt.fi.BaseConstants;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ag {
    public final int a;
    public final String b;
    public final String c;
    public String d;
    public int e = BaseConstants.Time.MINUTE;
    public int f = 0;

    public ag(int i, String str, String str2) {
        this.c = str;
        this.b = str2;
        this.a = i;
    }

    public abstract boolean a();

    public final String toString() {
        return "ReminderTask{mIndex=" + this.f + ", mAppName='" + this.c + "', mPackageName='" + this.b + "'}";
    }
}
