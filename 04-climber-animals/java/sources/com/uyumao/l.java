package com.uyumao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SingleThreadUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public class l {
    public static l a;
    public ExecutorService b;

    public static l a() {
        if (a == null) {
            synchronized (l.class) {
                if (a == null) {
                    a = new l();
                }
            }
        }
        return a;
    }

    public ExecutorService b() {
        if (this.b == null) {
            synchronized (l.class) {
                if (this.b == null) {
                    this.b = Executors.newSingleThreadExecutor();
                }
            }
        }
        return this.b;
    }
}
