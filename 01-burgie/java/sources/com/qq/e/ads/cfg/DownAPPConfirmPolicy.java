package com.qq.e.ads.cfg;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public enum DownAPPConfirmPolicy {
    Default(0),
    NOConfirm(2);

    private final int a;

    DownAPPConfirmPolicy(int i) {
        this.a = i;
    }

    public int value() {
        return this.a;
    }
}
