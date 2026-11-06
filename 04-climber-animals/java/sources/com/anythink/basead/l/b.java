package com.anythink.basead.l;

/* JADX INFO: loaded from: classes.dex */
public final class b extends Exception {
    protected static final int a = -1;
    protected static final int b = -2;
    public static final int c = -3;
    private String d;

    private void a(String str) {
        this.d = str;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.d;
    }

    private b(String str) {
        this.d = "-1: ".concat(String.valueOf(str));
    }

    public b(String str, String str2) {
        this.d = str + ": " + str2;
    }
}
