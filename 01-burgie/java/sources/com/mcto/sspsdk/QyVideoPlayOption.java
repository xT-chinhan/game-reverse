package com.mcto.sspsdk;

/* JADX INFO: loaded from: classes2.dex */
public enum QyVideoPlayOption {
    ALWAYS(0),
    WIFI(1),
    MANUAL(2);

    private final int mValue;

    QyVideoPlayOption(int i) {
        this.mValue = i;
    }

    public int getOption() {
        return this.mValue;
    }
}
