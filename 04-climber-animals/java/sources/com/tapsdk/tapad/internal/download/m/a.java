package com.tapsdk.tapad.internal.download.m;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final String a = "";
    public static final File b = new File("");

    public abstract String a();

    public boolean a(a aVar) {
        if (d().equals(aVar.d())) {
            return true;
        }
        if (!c().equals(aVar.c())) {
            return false;
        }
        String strA = a();
        String strA2 = aVar.a();
        return (strA2 == null || strA == null || !strA2.equals(strA)) ? false : true;
    }

    public abstract int b();

    public abstract File c();

    protected abstract File d();

    public abstract String e();
}
