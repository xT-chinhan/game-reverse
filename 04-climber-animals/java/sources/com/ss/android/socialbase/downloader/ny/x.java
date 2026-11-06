package com.ss.android.socialbase.downloader.ny;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class x<K, T> extends LinkedHashMap<K, T> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f4791ms;

    public x() {
        this(4, 4);
    }

    public x(int i, int i2) {
        this(i, i2, true);
    }

    public x(int i, int i2, boolean z) {
        super(i, 0.75f, z);
        ms(i2);
    }

    public void ms(int i) {
        this.f4791ms = i;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.f4791ms;
    }
}
