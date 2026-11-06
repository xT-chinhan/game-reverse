package com.umeng.analytics.pro;

/* JADX INFO: compiled from: DelayedStartCondition.java */
/* JADX INFO: loaded from: classes4.dex */
public class ag implements ad {
    private long a;

    @Override // com.umeng.analytics.pro.ad
    public boolean a() {
        return true;
    }

    public ag(long j) {
        this.a = j;
    }

    @Override // com.umeng.analytics.pro.ad
    public boolean b() {
        return !a();
    }

    @Override // com.umeng.analytics.pro.ad
    public long c() {
        return this.a;
    }
}
