package com.anythink.basead.exoplayer.b;

import android.media.AudioAttributes;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b a = new a().a();
    public final int b;
    public final int c;
    public final int d;
    private AudioAttributes e;

    /* synthetic */ b(int i, int i2, int i3, byte b) {
        this(i, i2, i3);
    }

    public static final class a {
        private int a = 0;
        private int b = 0;
        private int c = 1;

        public final a a(int i) {
            this.a = i;
            return this;
        }

        private a c(int i) {
            this.b = i;
            return this;
        }

        public final a b(int i) {
            this.c = i;
            return this;
        }

        public final b a() {
            return new b(this.a, this.b, this.c, (byte) 0);
        }
    }

    private b(int i, int i2, int i3) {
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    final AudioAttributes a() {
        if (this.e == null) {
            this.e = new AudioAttributes.Builder().setContentType(this.b).setFlags(this.c).setUsage(this.d).build();
        }
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.b == bVar.b && this.c == bVar.c && this.d == bVar.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.b + 527) * 31) + this.c) * 31) + this.d;
    }
}
