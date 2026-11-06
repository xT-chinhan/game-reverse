package com.anythink.basead.exoplayer.h.b;

import android.util.SparseArray;
import com.anythink.basead.exoplayer.e.k;
import com.anythink.basead.exoplayer.k.s;
import com.anythink.basead.exoplayer.m;

/* JADX INFO: loaded from: classes.dex */
public final class d implements com.anythink.basead.exoplayer.e.g {
    public final com.anythink.basead.exoplayer.e.e a;
    private final int b;
    private final m c;
    private final SparseArray<a> d = new SparseArray<>();
    private boolean e;
    private b f;
    private k g;
    private m[] h;

    public interface b {
        com.anythink.basead.exoplayer.e.m a(int i);
    }

    private d(com.anythink.basead.exoplayer.e.e eVar, int i, m mVar) {
        this.a = eVar;
        this.b = i;
        this.c = mVar;
    }

    private k b() {
        return this.g;
    }

    private m[] c() {
        return this.h;
    }

    public final void a(b bVar, long j) {
        this.f = bVar;
        if (!this.e) {
            this.a.a(this);
            if (j != -9223372036854775807L) {
                this.a.a(0L, j);
            }
            this.e = true;
            return;
        }
        com.anythink.basead.exoplayer.e.e eVar = this.a;
        if (j == -9223372036854775807L) {
            j = 0;
        }
        eVar.a(0L, j);
        for (int i = 0; i < this.d.size(); i++) {
            this.d.valueAt(i).a(bVar);
        }
    }

    @Override // com.anythink.basead.exoplayer.e.g
    public final com.anythink.basead.exoplayer.e.m a(int i, int i2) {
        a aVar = this.d.get(i);
        if (aVar == null) {
            com.anythink.basead.exoplayer.k.a.b(this.h == null);
            aVar = new a(i, i2, i2 == this.b ? this.c : null);
            aVar.a(this.f);
            this.d.put(i, aVar);
        }
        return aVar;
    }

    @Override // com.anythink.basead.exoplayer.e.g
    public final void c_() {
        m[] mVarArr = new m[this.d.size()];
        for (int i = 0; i < this.d.size(); i++) {
            mVarArr[i] = this.d.valueAt(i).a;
        }
        this.h = mVarArr;
    }

    @Override // com.anythink.basead.exoplayer.e.g
    public final void a(k kVar) {
        this.g = kVar;
    }

    private static final class a implements com.anythink.basead.exoplayer.e.m {
        public m a;
        private final int b;
        private final int c;
        private final m d;
        private com.anythink.basead.exoplayer.e.m e;

        public a(int i, int i2, m mVar) {
            this.b = i;
            this.c = i2;
            this.d = mVar;
        }

        public final void a(b bVar) {
            if (bVar == null) {
                this.e = new com.anythink.basead.exoplayer.e.d();
                return;
            }
            com.anythink.basead.exoplayer.e.m mVarA = bVar.a(this.c);
            this.e = mVarA;
            m mVar = this.a;
            if (mVar != null) {
                mVarA.a(mVar);
            }
        }

        @Override // com.anythink.basead.exoplayer.e.m
        public final void a(m mVar) {
            m mVar2 = this.d;
            if (mVar2 != null) {
                mVar = mVar.a(mVar2);
            }
            this.a = mVar;
            this.e.a(mVar);
        }

        @Override // com.anythink.basead.exoplayer.e.m
        public final int a(com.anythink.basead.exoplayer.e.f fVar, int i, boolean z) {
            return this.e.a(fVar, i, z);
        }

        @Override // com.anythink.basead.exoplayer.e.m
        public final void a(s sVar, int i) {
            this.e.a(sVar, i);
        }

        @Override // com.anythink.basead.exoplayer.e.m
        public final void a(long j, int i, int i2, int i3, com.anythink.basead.exoplayer.e.m.a aVar) {
            this.e.a(j, i, i2, i3, aVar);
        }
    }
}
