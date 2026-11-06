package com.anythink.core.common.r.a;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: com.anythink.core.common.r.a.b$b, reason: collision with other inner class name */
    static abstract class AbstractC0042b {
        int a;

        abstract byte a();

        abstract boolean a(AbstractC0042b abstractC0042b);

        AbstractC0042b() {
        }
    }

    b() {
    }

    static class c extends AbstractC0042b {
        boolean b;

        @Override // com.anythink.core.common.r.a.b.AbstractC0042b
        final byte a() {
            return (byte) 1;
        }

        c(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        @Override // com.anythink.core.common.r.a.b.AbstractC0042b
        final boolean a(AbstractC0042b abstractC0042b) {
            return abstractC0042b.a() == 1 && ((c) abstractC0042b).b == this.b;
        }
    }

    static class f extends AbstractC0042b {
        int b;

        @Override // com.anythink.core.common.r.a.b.AbstractC0042b
        final byte a() {
            return (byte) 2;
        }

        f(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // com.anythink.core.common.r.a.b.AbstractC0042b
        final boolean a(AbstractC0042b abstractC0042b) {
            return abstractC0042b.a() == 2 && ((f) abstractC0042b).b == this.b;
        }
    }

    static class e extends AbstractC0042b {
        float b;

        @Override // com.anythink.core.common.r.a.b.AbstractC0042b
        final byte a() {
            return (byte) 3;
        }

        e(int i, float f) {
            this.a = i;
            this.b = f;
        }

        @Override // com.anythink.core.common.r.a.b.AbstractC0042b
        final boolean a(AbstractC0042b abstractC0042b) {
            return abstractC0042b.a() == 3 && ((e) abstractC0042b).b == this.b;
        }
    }

    static class g extends AbstractC0042b {
        long b;

        @Override // com.anythink.core.common.r.a.b.AbstractC0042b
        final byte a() {
            return (byte) 4;
        }

        g(int i, long j) {
            this.a = i;
            this.b = j;
        }

        @Override // com.anythink.core.common.r.a.b.AbstractC0042b
        final boolean a(AbstractC0042b abstractC0042b) {
            return abstractC0042b.a() == 4 && ((g) abstractC0042b).b == this.b;
        }
    }

    static class d extends AbstractC0042b {
        double b;

        @Override // com.anythink.core.common.r.a.b.AbstractC0042b
        final byte a() {
            return (byte) 5;
        }

        d(int i, double d) {
            this.a = i;
            this.b = d;
        }

        @Override // com.anythink.core.common.r.a.b.AbstractC0042b
        final boolean a(AbstractC0042b abstractC0042b) {
            return abstractC0042b.a() == 5 && ((d) abstractC0042b).b == this.b;
        }
    }

    static abstract class j extends AbstractC0042b {
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
        @Override // com.anythink.core.common.r.a.b.AbstractC0042b
        final byte a() {
            return (byte) 6;
        }

        i(int i, int i2, String str, int i3, boolean z) {
            super(i, i2, str, i3, z);
        }

        @Override // com.anythink.core.common.r.a.b.AbstractC0042b
        final boolean a(AbstractC0042b abstractC0042b) {
            if (abstractC0042b.a() != 6) {
                return false;
            }
            i iVar = (i) abstractC0042b;
            return iVar.f == this.f && Objects.equals(iVar.c, this.c);
        }
    }

    static class a extends j {
        @Override // com.anythink.core.common.r.a.b.AbstractC0042b
        final byte a() {
            return (byte) 7;
        }

        a(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }

        @Override // com.anythink.core.common.r.a.b.AbstractC0042b
        final boolean a(AbstractC0042b abstractC0042b) {
            if (abstractC0042b.a() != 7) {
                return false;
            }
            Object obj = ((a) abstractC0042b).c;
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
        com.anythink.core.common.r.a.a.b b;

        @Override // com.anythink.core.common.r.a.b.AbstractC0042b
        final byte a() {
            return (byte) 8;
        }

        h(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }

        @Override // com.anythink.core.common.r.a.b.AbstractC0042b
        final boolean a(AbstractC0042b abstractC0042b) {
            return abstractC0042b.a() == 8 && Objects.equals(((h) abstractC0042b).c, this.c);
        }
    }
}
