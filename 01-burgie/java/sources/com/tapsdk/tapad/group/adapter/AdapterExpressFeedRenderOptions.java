package com.tapsdk.tapad.group.adapter;

/* JADX INFO: loaded from: classes2.dex */
public final class AdapterExpressFeedRenderOptions {
    private final boolean autoPlayAlways;
    private final int expressHeight;
    private final int expressWidth;

    public AdapterExpressFeedRenderOptions(int i, int i2, boolean z) {
        this.expressWidth = i;
        this.expressHeight = i2;
        this.autoPlayAlways = z;
    }

    public int getExpressHeight() {
        return this.expressHeight;
    }

    public int getExpressWidth() {
        return this.expressWidth;
    }

    public boolean isAutoPlayAlways() {
        return this.autoPlayAlways;
    }
}
