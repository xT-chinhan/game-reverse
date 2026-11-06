package com.byazt.cz;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 213, 121})
public class x {
    public float hw;
    public float pr;

    public x(float f, float f2) {
        this.pr = f;
        this.hw = f2;
    }

    public x() {
        this(1.0f, 1.0f);
    }

    public float pr() {
        return this.pr;
    }

    public float hw() {
        return this.hw;
    }

    public void pr(float f, float f2) {
        this.pr = f;
        this.hw = f2;
    }

    public boolean hw(float f, float f2) {
        return this.pr == f && this.hw == f2;
    }

    public String toString() {
        return pr() + "x" + hw();
    }
}
