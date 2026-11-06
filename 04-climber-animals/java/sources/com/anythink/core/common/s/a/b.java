package com.anythink.core.common.s.a;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: com.anythink.core.common.s.a.b$b, reason: collision with other inner class name */
    static abstract class AbstractC0101b {
        int a;

        abstract byte a();

        abstract boolean a(AbstractC0101b abstractC0101b);

        AbstractC0101b() {
        }
    }

    b() {
    }

    static class c extends AbstractC0101b {
        boolean b;

        @Override // com.anythink.core.common.s.a.b.AbstractC0101b
        final byte a() {
            return (byte) 1;
        }

        c(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        @Override // com.anythink.core.common.s.a.b.AbstractC0101b
        final boolean a(AbstractC0101b abstractC0101b) {
            return abstractC0101b.a() == 1 && ((c) abstractC0101b).b == this.b;
        }
    }

    static class f extends AbstractC0101b {
        int b;

        @Override // com.anythink.core.common.s.a.b.AbstractC0101b
        final byte a() {
            return (byte) 2;
        }

        f(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // com.anythink.core.common.s.a.b.AbstractC0101b
        final boolean a(AbstractC0101b abstractC0101b) {
            return abstractC0101b.a() == 2 && ((f) abstractC0101b).b == this.b;
        }
    }

    static class e extends AbstractC0101b {
        float b;

        @Override // com.anythink.core.common.s.a.b.AbstractC0101b
        final byte a() {
            return (byte) 3;
        }

        e(int i, float f) {
            this.a = i;
            this.b = f;
        }

        @Override // com.anythink.core.common.s.a.b.AbstractC0101b
        final boolean a(AbstractC0101b abstractC0101b) {
            return abstractC0101b.a() == 3 && ((e) abstractC0101b).b == this.b;
        }
    }

    static class g extends AbstractC0101b {
        long b;

        @Override // com.anythink.core.common.s.a.b.AbstractC0101b
        final byte a() {
            return (byte) 4;
        }

        g(int i, long j) {
            this.a = i;
            this.b = j;
        }

        @Override // com.anythink.core.common.s.a.b.AbstractC0101b
        final boolean a(AbstractC0101b abstractC0101b) {
            return abstractC0101b.a() == 4 && ((g) abstractC0101b).b == this.b;
        }
    }

    static class d extends AbstractC0101b {
        double b;

        @Override // com.anythink.core.common.s.a.b.AbstractC0101b
        final byte a() {
            return (byte) 5;
        }

        d(int i, double d) {
            this.a = i;
            this.b = d;
        }

        @Override // com.anythink.core.common.s.a.b.AbstractC0101b
        final boolean a(AbstractC0101b abstractC0101b) {
            return abstractC0101b.a() == 5 && ((d) abstractC0101b).b == this.b;
        }
    }

    static abstract class j extends AbstractC0101b {
        Object c;
        int d;
        int e;
        boolean f;

        j(int i, int i2, Object obj, int i3, boolean z) {
            this.d = i;
            this.a = i2;
            this.c = obj;
            this.e = i3;
            this.f = z;
        }
    }

    static class i extends j {
        @Override // com.anythink.core.common.s.a.b.AbstractC0101b
        final byte a() {
            return (byte) 6;
        }

        i(int i, int i2, String str, int i3, boolean z) {
            super(i, i2, str, i3, z);
        }

        @Override // com.anythink.core.common.s.a.b.AbstractC0101b
        final boolean a(AbstractC0101b abstractC0101b) {
            if (abstractC0101b.a() != 6) {
                return false;
            }
            i iVar = (i) abstractC0101b;
            return iVar.f == this.f && Objects.equals(iVar.c, this.c);
        }
    }

    static class a extends j {
        @Override // com.anythink.core.common.s.a.b.AbstractC0101b
        final byte a() {
            return (byte) 7;
        }

        a(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }

        @Override // com.anythink.core.common.s.a.b.AbstractC0101b
        final boolean a(AbstractC0101b abstractC0101b) {
            if (abstractC0101b.a() != 7) {
                return false;
            }
            Object obj = ((a) abstractC0101b).c;
            if (this.c == obj) {
                return true;
            }
            if (this.c != null && obj != null) {
                if (this.c instanceof String) {
                    return this.c.equals(obj);
                }
                if ((this.c instanceof byte[]) && (obj instanceof byte[])) {
                    return Arrays.equals((byte[]) this.c, (byte[]) obj);
                }
            }
            return false;
        }
    }

    static class h extends j {
        com.anythink.core.common.s.a.a.b b;

        @Override // com.anythink.core.common.s.a.b.AbstractC0101b
        final byte a() {
            return (byte) 8;
        }

        h(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }

        @Override // com.anythink.core.common.s.a.b.AbstractC0101b
        final boolean a(AbstractC0101b abstractC0101b) {
            return abstractC0101b.a() == 8 && Objects.equals(((h) abstractC0101b).c, this.c);
        }
    }
}
