package com.byazt.mn;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 403, 13})
public class hw {
    public int c;
    public long hn;
    public String hw;
    public String pr;
    public int x;

    public hw(String str, String str2, long j) {
        this.x = -1;
        this.c = -1;
        this.pr = str;
        this.hw = str2;
        this.hn = j;
    }

    public hw(String str, String str2, long j, int i) {
        this.x = -1;
        this.c = -1;
        this.pr = str;
        this.hw = str2;
        this.hn = j;
        this.x = i;
    }

    public String pr() {
        return this.hw;
    }

    public String hw() {
        return this.pr;
    }

    public long hn() {
        return this.hn;
    }

    public int x() {
        return this.x;
    }

    public int c() {
        return this.c;
    }

    public void pr(int i) {
        this.c = i;
    }
}
