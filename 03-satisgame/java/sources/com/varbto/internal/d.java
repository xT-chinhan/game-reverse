package com.varbto.internal;

import android.os.Process;
import android.os.SystemClock;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static long a;
    public static long b = SystemClock.uptimeMillis();
    public static final File c = new File(e.a("L3Byb2Mv") + Process.myPid() + e.a("L3N0YXQ="));
}
