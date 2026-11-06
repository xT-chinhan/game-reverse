package com.byazt.tf;

import com.byazt.nzn.w;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1049, 121})
public class x {
    public final long c;
    public w fw;
    public final Map<String, String> hn;
    public final String hw;
    public String k;
    public final int pr;
    public final long uc;
    public final boolean vk;
    public final String x;
    public Throwable zo;
    public File aj = null;
    public byte[] w = null;

    public x(boolean z, int i, String str, Map<String, String> map, String str2, long j, long j2) {
        this.vk = z;
        this.pr = i;
        this.hw = str;
        this.hn = map;
        this.x = str2;
        this.c = j;
        this.uc = j2;
    }

    public x(boolean z, int i, String str, Map<String, String> map, String str2, long j, long j2, Throwable th) {
        this.vk = z;
        this.pr = i;
        this.hw = str;
        this.hn = map;
        this.x = str2;
        this.c = j;
        this.uc = j2;
        this.zo = th;
    }

    public Throwable pr() {
        return this.zo;
    }

    public int hw() {
        return this.pr;
    }

    public String hn() {
        return this.hw;
    }

    public Map<String, String> x() {
        return this.hn;
    }

    public String c() {
        return this.x;
    }

    public long uc() {
        return this.c;
    }

    public long fw() {
        return this.uc;
    }

    public File zo() {
        return this.aj;
    }

    public void pr(File file) {
        this.aj = file;
    }

    public boolean aj() {
        return this.vk;
    }

    public long vk() {
        return this.c - this.uc;
    }

    public byte[] w() {
        return this.w;
    }

    public void pr(byte[] bArr) {
        this.w = bArr;
    }

    public w k() {
        return this.fw;
    }

    public void pr(w wVar) {
        this.fw = wVar;
    }

    public String m() {
        return this.k;
    }

    public void pr(String str) {
        this.k = str;
    }
}
