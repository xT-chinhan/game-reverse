package com.anythink.basead.exoplayer.e;

/* JADX INFO: loaded from: classes.dex */
public interface k {
    a a(long j);

    boolean a();

    long b();

    public static final class b implements k {
        private final long a;
        private final a b;

        @Override // com.anythink.basead.exoplayer.e.k
        public final boolean a() {
            return false;
        }

        private b(long j) {
            this(j, 0L);
        }

        public b(long j, long j2) {
            this.a = j;
            this.b = new a(j2 == 0 ? l.a : new l(0L, j2));
        }

        @Override // com.anythink.basead.exoplayer.e.k
        public final long b() {
            return this.a;
        }

        @Override // com.anythink.basead.exoplayer.e.k
        public final a a(long j) {
            return this.b;
        }
    }

    public static final class a {
        public final l a;
        public final l b;

        public a(l lVar) {
            this(lVar, lVar);
        }

        public a(l lVar, l lVar2) {
            this.a = (l) com.anythink.basead.exoplayer.k.a.a(lVar);
            this.b = (l) com.anythink.basead.exoplayer.k.a.a(lVar2);
        }

        public final String toString() {
            return "[" + this.a + (this.a.equals(this.b) ? "" : ", " + this.b) + "]";
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                a aVar = (a) obj;
                if (this.a.equals(aVar.a) && this.b.equals(aVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }
    }
}
