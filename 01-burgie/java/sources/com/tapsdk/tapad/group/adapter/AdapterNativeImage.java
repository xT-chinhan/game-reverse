package com.tapsdk.tapad.group.adapter;

/* JADX INFO: loaded from: classes2.dex */
public final class AdapterNativeImage {
    private final int height;
    private final String url;
    private final int width;

    public AdapterNativeImage(String str, int i, int i2) {
        this.url = str == null ? "" : str;
        this.width = i;
        this.height = i2;
    }

    public int getHeight() {
        return this.height;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }
}
