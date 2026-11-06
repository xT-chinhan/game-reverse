package com.anythink.core.common.m.a;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class n {
    public static final int a = 60;
    public static final int b = -1;
    public static final int c = 1;
    public static final int d = 28;
    public static final int e = 5;
    public static final int f = 16;
    public final String g;
    public final int h;
    public final int i;
    public final long j;
    public final int k;
    public final String l;

    public static class a {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
        public static final int f = 5;
    }

    public n(String str, int i, int i2, long j, int i3, String str2) {
        this.g = str;
        this.h = i;
        this.i = i2 <= 0 ? i2 == -1 ? -1 : 60 : i2;
        this.j = j;
        this.k = i3;
        this.l = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof n)) {
            n nVar = (n) obj;
            if (this.g.equals(nVar.g) && this.h == nVar.h && this.i == nVar.i && this.j == nVar.j) {
                return true;
            }
        }
        return false;
    }

    public final boolean a() {
        return this.h == 1;
    }

    public final boolean b() {
        return this.h == 28;
    }

    private boolean c() {
        return this.h == 5;
    }

    private boolean d() {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        int i = this.i;
        return i != -1 && this.j + ((long) i) <= jCurrentTimeMillis;
    }

    private boolean a(long j) {
        int i = this.i;
        return i != -1 && this.j + ((long) i) <= j;
    }

    public final String toString() {
        return String.format(Locale.getDefault(), "{type:%s, value:%s, source:%s, server:%s, timestamp:%d, ttl:%d}", Integer.valueOf(this.h), this.g, Integer.valueOf(this.k), this.l, Long.valueOf(this.j), Integer.valueOf(this.i));
    }
}
