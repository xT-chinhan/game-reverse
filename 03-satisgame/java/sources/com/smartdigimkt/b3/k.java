package com.smartdigimkt.b3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public long a;
    public long b;
    public long c;
    public long d;
    public long e;
    public String f;
    public int g;
    public String h;
    public boolean i;
    public int j = -1;
    public int k = -1;
    public final List l = Collections.synchronizedList(new ArrayList());

    public static long a(long j, long j2) {
        if (j <= 0 || j2 <= 0 || j2 < j) {
            return -1L;
        }
        return j2 - j;
    }
}
