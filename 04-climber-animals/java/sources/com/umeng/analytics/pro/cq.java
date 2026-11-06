package com.umeng.analytics.pro;

/* JADX INFO: compiled from: EnableCondition.java */
/* JADX INFO: loaded from: classes4.dex */
public class cq implements cp {
    private int a;

    @Override // com.umeng.analytics.pro.cp
    public long c() {
        return 0L;
    }

    public cq(int i) {
        this.a = i;
    }

    @Override // com.umeng.analytics.pro.cp
    public boolean a() {
        return this.a == 0;
    }

    @Override // com.umeng.analytics.pro.cp
    public boolean b() {
        return !a();
    }
}
