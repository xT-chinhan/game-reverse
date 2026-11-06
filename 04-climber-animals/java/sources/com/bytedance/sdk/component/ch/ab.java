package com.bytedance.sdk.component.ch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends c {
    public static ms xr;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final int f1196ms = Runtime.getRuntime().availableProcessors();
    public static boolean ah = true;
    public static int d = 120;

    public static void ms(ny nyVar) {
        nyVar.ms(10);
        hi.xr.ch().execute(nyVar);
    }

    public static ExecutorService ms() {
        return hi.xr.zb();
    }

    public static void xr(ny nyVar) {
        ms().execute(nyVar);
    }

    public static void ms(ny nyVar, int i) {
        nyVar.ms(i);
        hi.xr.zb().execute(nyVar);
    }

    public static ThreadPoolExecutor xr() {
        return hi.xr.ny();
    }

    public static void ah(ny nyVar) {
        xr().execute(nyVar);
    }

    public static void d(ny nyVar) {
        hi.xr.zb().execute(nyVar);
    }

    public static void xr(ny nyVar, int i) {
        nyVar.ms(i);
        hi.xr.zb().execute(nyVar);
    }

    public static ExecutorService ah() {
        return ms();
    }

    public static ScheduledExecutorService d() {
        return hi.xr.sl();
    }

    public static boolean ka() {
        return ah;
    }

    public static void ms(boolean z) {
        ah = z;
    }

    public static void ms(ms msVar) {
        xr = msVar;
    }

    public static void ka(ny nyVar) {
        hi.xr.ch().execute(nyVar);
    }

    public static void ms(int i) {
        d = i;
    }
}
