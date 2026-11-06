package com.byazt.osx;

import com.byazt.jv.a;
import com.byazt.jv.b;
import com.byazt.jv.gz;
import com.byazt.jv.nt;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 442, 62})
public final class fw implements a.pr {
    public final int aj;
    public final int c;
    public final com.byazt.jv.c fw;
    public final hn hn;
    public final com.byazt.iaw.fw hw;
    public int k;
    public final List<a> pr;
    public final b uc;
    public final int vk;
    public final int w;
    public final com.byazt.iaw.hn x;
    public final nt zo;

    public fw(List<a> list, com.byazt.iaw.fw fwVar, hn hnVar, com.byazt.iaw.hn hnVar2, int i, b bVar, com.byazt.jv.c cVar, nt ntVar, int i2, int i3, int i4) {
        this.pr = list;
        this.x = hnVar2;
        this.hw = fwVar;
        this.hn = hnVar;
        this.c = i;
        this.uc = bVar;
        this.fw = cVar;
        this.zo = ntVar;
        this.aj = i2;
        this.vk = i3;
        this.w = i4;
    }

    public com.byazt.jv.aj c() {
        return this.x;
    }

    @Override // com.byazt.jv.a.pr
    public int hw() {
        return this.aj;
    }

    @Override // com.byazt.jv.a.pr
    public int hn() {
        return this.vk;
    }

    @Override // com.byazt.jv.a.pr
    public int x() {
        return this.w;
    }

    public com.byazt.iaw.fw uc() {
        return this.hw;
    }

    public hn fw() {
        return this.hn;
    }

    @Override // com.byazt.jv.a.pr
    public com.byazt.jv.c call() {
        return this.fw;
    }

    public nt zo() {
        return this.zo;
    }

    @Override // com.byazt.jv.a.pr
    public b pr() {
        return this.uc;
    }

    @Override // com.byazt.jv.a.pr
    public gz pr(b bVar) throws IOException {
        return pr(bVar, this.hw, this.hn, this.x);
    }

    public gz pr(b bVar, com.byazt.iaw.fw fwVar, hn hnVar, com.byazt.iaw.hn hnVar2) throws Exception {
        if (this.c < this.pr.size()) {
            this.k++;
            if (this.hn != null && !this.x.pr(bVar.pr())) {
                throw new IllegalStateException("network interceptor " + this.pr.get(this.c - 1) + " must retain the same host and port");
            }
            if (this.hn != null && this.k > 1) {
                throw new IllegalStateException("network interceptor " + this.pr.get(this.c - 1) + " must call proceed() exactly once");
            }
            fw fwVar2 = new fw(this.pr, fwVar, hnVar, hnVar2, this.c + 1, bVar, this.fw, this.zo, this.aj, this.vk, this.w);
            a aVar = this.pr.get(this.c);
            try {
                gz gzVarPr = aVar.pr(fwVar2);
                if (hnVar != null && this.c + 1 < this.pr.size() && fwVar2.k != 1) {
                    throw new IllegalStateException("network interceptor " + aVar + " must call proceed() exactly once");
                }
                if (gzVarPr == null) {
                    throw new NullPointerException("interceptor " + aVar + " returned a null response");
                }
                if (gzVarPr.aj() == null) {
                    throw new IllegalStateException("interceptor " + aVar + " returned a response with no body");
                }
                return gzVarPr;
            } catch (Exception e) {
                throw e;
            }
        }
        throw new AssertionError();
    }
}
