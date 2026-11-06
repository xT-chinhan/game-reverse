package com.byazt.zn;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 94, 62})
public class fw extends pr {
    public com.byazt.mr.hw aj;
    public String c;
    public int fw;
    public boolean uc;
    public long vk;
    public int w;
    public int x;
    public boolean zo;

    public fw() {
        this.x = -1;
        this.c = "unknown";
        this.uc = false;
        this.zo = false;
        this.w = -1;
    }

    public fw(int i, String str, boolean z) {
        this.x = -1;
        this.c = "unknown";
        this.uc = false;
        this.zo = false;
        this.w = -1;
        this.x = i;
        this.c = str;
        this.zo = z;
    }

    public int x() {
        return this.x;
    }

    public void hw(int i) {
        this.x = i;
    }

    public void hn(int i) {
        this.w = i;
    }

    public String c() {
        if (TextUtils.isEmpty(this.c)) {
            return "unknown";
        }
        return this.c;
    }

    public void pr(String str) {
        this.c = str;
    }

    public boolean uc() {
        return this.uc;
    }

    public void pr(boolean z) {
        this.uc = z;
    }

    public int fw() {
        return this.fw;
    }

    public void x(int i) {
        this.fw = i;
    }

    public boolean zo() {
        return this.zo;
    }

    public void hw(boolean z) {
        this.zo = z;
    }

    public com.byazt.mr.hw aj() {
        return this.aj;
    }

    public void pr(com.byazt.mr.hw hwVar) {
        this.aj = hwVar;
    }

    @Override // com.byazt.zn.pr
    public long hn() {
        return this.vk;
    }

    @Override // com.byazt.zn.pr
    public void pr(long j) {
        this.vk = j;
    }
}
