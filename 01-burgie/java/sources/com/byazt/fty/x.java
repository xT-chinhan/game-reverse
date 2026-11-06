package com.byazt.fty;

/* JADX INFO: loaded from: classes.dex */
public enum x {
    LEFT(0),
    TOP(1),
    RIGHT(2),
    BOTTOM(3),
    START(4),
    END(5),
    HORIZONTAL(6),
    VERTICAL(7),
    ALL(8);

    public final int vk;

    x(int i) {
        this.vk = i;
    }

    public int pr() {
        return this.vk;
    }
}
