package com.byazt.gr;

/* JADX INFO: loaded from: classes.dex */
public enum q {
    LEFT(0),
    TOP(1),
    RIGHT(2),
    BOTTOM(3),
    START(4),
    END(5),
    HORIZONTAL(6),
    VERTICAL(7),
    ALL(8);

    public final int tj;

    q(int i) {
        this.tj = i;
    }

    public int n() {
        return this.tj;
    }
}
