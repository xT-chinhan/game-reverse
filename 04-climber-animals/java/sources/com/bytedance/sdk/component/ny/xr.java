package com.bytedance.sdk.component.ny;

import com.bytedance.sdk.component.xr.ms.hi;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    hi ab;
    final Map<String, String> ah;
    final long c;
    final String d;
    final long ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final int f1290ms;
    private final boolean ny;
    final String xr;
    private File x = null;
    private byte[] ch = null;

    public xr(boolean z, int i, String str, Map<String, String> map, String str2, long j, long j2) {
        this.ny = z;
        this.f1290ms = i;
        this.xr = str;
        this.ah = map;
        this.d = str2;
        this.ka = j;
        this.c = j2;
    }

    public int ms() {
        return this.f1290ms;
    }

    public String xr() {
        return this.xr;
    }

    public Map<String, String> ah() {
        return this.ah;
    }

    public String d() {
        return this.d;
    }

    public long ka() {
        return this.ka;
    }

    public long c() {
        return this.c;
    }

    public File ab() {
        return this.x;
    }

    public void ms(File file) {
        this.x = file;
    }

    public boolean x() {
        return this.ny;
    }

    public long ny() {
        return this.ka - this.c;
    }

    public byte[] ch() {
        return this.ch;
    }

    public void ms(byte[] bArr) {
        this.ch = bArr;
    }

    public hi hi() {
        return this.ab;
    }

    public void ms(hi hiVar) {
        this.ab = hiVar;
    }
}
