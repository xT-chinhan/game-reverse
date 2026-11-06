package com.ss.android.downloadlib.addownload.xr;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class xr {
    public String ab;
    public String ah;
    public String c;
    public String d;
    public String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public long f4460ms;
    public String ny;
    public final List<Pair<String, String>> x = new ArrayList();
    public long xr;

    public static long ms(long j, long j2) {
        return j > 0 ? j : j2;
    }

    public long ms() {
        return ms(this.f4460ms, this.xr);
    }
}
