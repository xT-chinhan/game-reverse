package com.byazt.vzj;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import com.byazt.ej.k;
import com.byazt.ej.l;
import com.byazt.ej.oa;
import com.byazt.ej.x;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.LongCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX, 19})
public class n implements x {
    public long cp;
    public boolean fs;
    public final long[] l;
    public final x n;
    public int oa;
    public final List<k> q;
    public int rv;
    public final Map<k, oa> s;
    public final x.n sz;
    public long tj;
    public final long w;
    public boolean x;
    public final Set<x.n> qg = new CopyOnWriteArraySet();
    public int d = 0;

    @Override // com.byazt.ej.x
    public void n(k kVar) {
    }

    @Override // com.byazt.ej.x
    public void n(oa oaVar) {
    }

    public n(x xVar, Map<k, oa> map, List<k> list) {
        x.n nVar = new x.n() { // from class: com.byazt.vzj.n.1
            @Override // com.byazt.ej.x.n
            public void n(x xVar2) {
                com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.vzj.n.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.ur();
                    }
                });
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar2, final long j) {
                com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.vzj.n.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.s(j);
                    }
                });
            }

            @Override // com.byazt.ej.x.n
            public void s(x xVar2) {
                com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.vzj.n.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.rv();
                    }
                });
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar2, final com.byazt.ej.s sVar) {
                com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.vzj.n.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.n(sVar);
                    }
                });
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar2, boolean z) {
                Iterator it = n.this.qg.iterator();
                while (it.hasNext()) {
                    ((x.n) it.next()).n(n.this, z);
                }
            }

            @Override // com.byazt.ej.x.n
            public void q(x xVar2) {
                com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.vzj.n.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.d = 6;
                        Iterator it = n.this.qg.iterator();
                        while (it.hasNext()) {
                            ((x.n) it.next()).q(n.this);
                        }
                    }
                });
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar2, int i, int i2) {
                Iterator it = n.this.qg.iterator();
                while (it.hasNext()) {
                    ((x.n) it.next()).n((x) n.this, i, i2);
                }
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar2, final int i, final int i2, final int i3) {
                com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.vzj.n.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.n(i, i2, i3);
                    }
                });
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar2, final int i) {
                com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.vzj.n.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.s(i);
                    }
                });
            }

            @Override // com.byazt.ej.x.n
            public void qg(x xVar2, int i) {
                Iterator it = n.this.qg.iterator();
                while (it.hasNext()) {
                    ((x.n) it.next()).qg(n.this, i);
                }
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar2, final long j, long j2) {
                com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.vzj.n.1.8
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.q(j);
                    }
                });
            }

            @Override // com.byazt.ej.x.n
            public void n(x xVar2, JSONObject jSONObject, String str) {
                Iterator it = n.this.qg.iterator();
                while (it.hasNext()) {
                    ((x.n) it.next()).n(n.this, jSONObject, str);
                }
            }

            @Override // com.byazt.ej.x.n
            public void l(x xVar2) {
                Iterator it = n.this.qg.iterator();
                while (it.hasNext()) {
                    ((x.n) it.next()).l(n.this);
                }
            }

            @Override // com.byazt.ej.x.n
            public void w(x xVar2) {
                Iterator it = n.this.qg.iterator();
                while (it.hasNext()) {
                    ((x.n) it.next()).w(n.this);
                }
            }

            @Override // com.byazt.ej.x.n
            public void qg(x xVar2) {
                com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.vzj.n.1.9
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.t();
                    }
                });
            }
        };
        this.sz = nVar;
        if (xVar == null || map == null || list == null || list.size() <= 1) {
            throw new IllegalArgumentException("invalid multi video player arguments");
        }
        this.n = xVar;
        this.s = map;
        this.q = list;
        long[] jArrN = n(list);
        this.l = jArrN;
        this.w = jArrN[jArrN.length - 1];
        this.rv = 0;
        k kVar = list.get(0);
        xVar.n(map.get(kVar));
        xVar.n(kVar);
        xVar.n(nVar);
    }

    @Override // com.byazt.ej.x
    public void qg(boolean z) {
        this.x = z;
        this.n.qg(z);
    }

    @Override // com.byazt.ej.x
    public void qg(int i) {
        this.n.qg(i);
    }

    @Override // com.byazt.ej.x
    public void n(boolean z, long j, boolean z2) {
        this.x = z2;
        this.d = 1;
        if (j <= 0) {
            this.tj = 0L;
            this.n.n(z, 0L, z2);
        } else {
            n(j, z);
        }
    }

    @Override // com.byazt.ej.x
    public void qg() {
        com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.vzj.n.2
            @Override // java.lang.Runnable
            public void run() {
                n.this.q(true);
            }
        });
    }

    @Override // com.byazt.ej.x
    public void s() {
        int i = this.d;
        if (i == 3 || i == 4 || i == 5 || i == 6) {
            return;
        }
        if (i == 2) {
            this.oa &= -17;
        } else {
            this.d = 1;
            this.n.s();
        }
    }

    @Override // com.byazt.ej.x
    public void q() {
        if (this.d == 2) {
            this.oa |= 16;
        } else {
            this.n.q();
        }
    }

    @Override // com.byazt.ej.x
    public void x() {
        this.d = 3;
        this.n.x();
    }

    @Override // com.byazt.ej.x
    public void l() {
        if (this.d == 6) {
            return;
        }
        this.d = 0;
        this.tj = 0L;
        this.cp = 0L;
        this.rv = 0;
        this.oa = 0;
        lh();
        this.n.l();
        k kVar = this.q.get(0);
        this.n.n(this.s.get(kVar));
        this.n.n(kVar);
        this.n.s(false);
    }

    @Override // com.byazt.ej.x
    public void w() {
        this.d = 6;
        this.n.w();
    }

    @Override // com.byazt.ej.x
    public void n(final long j) {
        com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.vzj.n.3
            @Override // java.lang.Runnable
            public void run() {
                n.this.qg(j);
            }
        });
    }

    @Override // com.byazt.ej.x
    public boolean fs() {
        return (this.oa & 4) != 0;
    }

    @Override // com.byazt.ej.x
    public void n(boolean z) {
        this.n.n(z);
    }

    @Override // com.byazt.ej.x
    public void n(SurfaceHolder surfaceHolder) {
        this.n.n(surfaceHolder);
    }

    @Override // com.byazt.ej.x
    public SurfaceHolder m() {
        return this.n.m();
    }

    @Override // com.byazt.ej.x
    public void n(SurfaceTexture surfaceTexture) {
        this.n.n(surfaceTexture);
    }

    @Override // com.byazt.ej.x
    public SurfaceTexture hu() {
        return this.n.hu();
    }

    @Override // com.byazt.ej.x
    public boolean k() {
        return this.d == 4;
    }

    @Override // com.byazt.ej.x
    public boolean sz() {
        return (this.oa & 1) != 0;
    }

    @Override // com.byazt.ej.x
    public boolean cp() {
        int i = this.d;
        return (i == 1 || i == 2) && (this.oa & 2) != 0;
    }

    @Override // com.byazt.ej.x
    public int hd() {
        return this.n.hd();
    }

    @Override // com.byazt.ej.x
    public int cd() {
        return this.n.cd();
    }

    @Override // com.byazt.ej.x
    public boolean tj() {
        int i = this.d;
        if (i == 2) {
            return (this.oa & 16) == 0;
        }
        return i == 1 && this.n.tj();
    }

    @Override // com.byazt.ej.x
    public boolean d() {
        return (this.d == 2 && (this.oa & 16) != 0) || this.n.d();
    }

    @Override // com.byazt.ej.x
    public boolean oa() {
        return this.d == 6;
    }

    @Override // com.byazt.ej.x
    public long cy() {
        return this.n.cy();
    }

    @Override // com.byazt.ej.x
    public int um() {
        return this.n.um();
    }

    @Override // com.byazt.ej.x
    public long a() {
        return this.w;
    }

    @Override // com.byazt.ej.x
    public long py() {
        return this.tj;
    }

    public long n() {
        return this.cp;
    }

    @Override // com.byazt.ej.x
    public void s(boolean z) {
        this.fs = z;
        this.n.s(false);
    }

    @Override // com.byazt.ej.x
    public boolean ou() {
        return this.fs;
    }

    @Override // com.byazt.ej.x
    public void n(x.n nVar) {
        if (nVar != null) {
            this.qg.add(nVar);
        }
    }

    @Override // com.byazt.ej.x
    public void qg(x.n nVar) {
        if (nVar != null) {
            this.qg.remove(nVar);
        }
    }

    @Override // com.byazt.ej.x
    public void n(int i) {
        this.n.n(i);
    }

    @Override // com.byazt.ej.x
    public int wm() {
        return this.n.wm();
    }

    @Override // com.byazt.ej.x
    public void n(float f) {
        this.n.n(f);
    }

    @Override // com.byazt.ej.x
    public String h() {
        return this.n.h();
    }

    private void n(long j, boolean z) {
        long jW = w(j);
        int iL = l(jW);
        long jQ = jW - q(iL);
        this.tj = jW;
        qg(iL, jQ);
        if (iL == this.rv) {
            this.n.n(z, jQ, this.x);
        } else {
            n(iL, jQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(long j) {
        if (v()) {
            return;
        }
        long jW = w(j);
        int iL = l(jW);
        long jQg = qg(this.q.get(iL));
        long[] jArr = this.l;
        boolean z = jArr[iL] < jQg;
        if (z) {
            jArr[iL] = jQg;
        }
        long jQ = jW - q(iL);
        this.tj = jW;
        qg(iL, jQ);
        if (iL == this.rv && !z) {
            this.n.n(jQ);
        } else {
            n(iL, jQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z) {
        if (this.d == 6) {
            return;
        }
        lh();
        this.rv = 0;
        this.tj = 0L;
        this.cp = 0L;
        this.d = 0;
        if (z) {
            this.oa = 0;
        } else {
            this.oa &= 7;
        }
        n(0, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        if (v()) {
            return;
        }
        int i = this.oa;
        if ((i & 1) != 0) {
            return;
        }
        this.oa = i | 1;
        Iterator<x.n> it = this.qg.iterator();
        while (it.hasNext()) {
            it.next().s(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (v()) {
            return;
        }
        this.d = 1;
        int i = this.oa;
        if ((i & 16) != 0) {
            this.oa = i & (-17);
            this.n.q();
        }
        int i2 = this.oa;
        if ((i2 & 2) != 0) {
            return;
        }
        this.oa = i2 | 2;
        Iterator<x.n> it = this.qg.iterator();
        while (it.hasNext()) {
            it.next().qg(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(long j) {
        if (v()) {
            return;
        }
        this.d = 1;
        int i = this.oa;
        if ((i & 4) == 0) {
            this.oa = i | 4;
            Iterator<x.n> it = this.qg.iterator();
            while (it.hasNext()) {
                it.next().n(this, j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2, int i3) {
        if (this.d == 2) {
            this.oa |= 8;
            return;
        }
        this.oa &= -9;
        Iterator<x.n> it = this.qg.iterator();
        while (it.hasNext()) {
            it.next().n(this, i, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i) {
        int i2 = this.oa;
        if ((i2 & 8) != 0) {
            this.oa = i2 & (-9);
            return;
        }
        Iterator<x.n> it = this.qg.iterator();
        while (it.hasNext()) {
            it.next().n((x) this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(long j) {
        if (v()) {
            return;
        }
        qg(this.rv, j);
        this.tj = Math.min(q(this.rv) + Math.max(0L, j), this.w);
        ln();
        if (this.tj >= this.w) {
            bb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ur() {
        if (v()) {
            return;
        }
        this.tj = Math.min(q(this.rv) + this.l[this.rv], this.w);
        ln();
        if (this.tj >= this.w || this.rv >= this.q.size() - 1) {
            bb();
        } else {
            n(this.rv + 1, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.ej.s sVar) {
        if (v()) {
            return;
        }
        if ((this.rv == this.q.size() - 1) || sVar.n() == 100) {
            this.d = 5;
            Iterator<x.n> it = this.qg.iterator();
            while (it.hasNext()) {
                it.next().n(this, sVar);
            }
            return;
        }
        this.l[this.rv] = Math.min(Math.max(0L, this.tj - q(this.rv)), qg(this.q.get(this.rv)));
        n(this.rv + 1, 0L);
    }

    private void n(int i, long j) {
        if (v() || i < 0 || i >= this.q.size()) {
            return;
        }
        this.d = 2;
        this.rv = i;
        this.tj = Math.min(q(i) + Math.max(0L, j), this.w);
        qg(i, j);
        this.n.l();
        k kVar = this.q.get(i);
        this.n.n(this.s.get(kVar));
        this.n.n(kVar);
        this.n.s(false);
        this.n.n(true, j, this.x);
    }

    private void bb() {
        if (v()) {
            return;
        }
        long j = this.tj;
        long j2 = this.w;
        boolean z = j < j2;
        this.tj = j2;
        this.d = 4;
        if (!this.n.k()) {
            this.n.x();
        }
        if (z) {
            ln();
        }
        if (this.fs) {
            q(false);
            return;
        }
        Iterator<x.n> it = this.qg.iterator();
        while (it.hasNext()) {
            it.next().n(this);
        }
    }

    private void ln() {
        Iterator<x.n> it = this.qg.iterator();
        while (it.hasNext()) {
            it.next().n(this, this.tj, this.w);
        }
    }

    private long q(int i) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += this.l[i2];
        }
        return j;
    }

    private void qg(int i, long j) {
        this.cp = l(i) ? Math.max(0L, Math.min(j, this.w)) : 0L;
    }

    private boolean l(int i) {
        return i == this.q.size() - 1;
    }

    private int l(long j) {
        int i = 0;
        long j2 = 0;
        while (true) {
            long[] jArr = this.l;
            if (i < jArr.length) {
                long j3 = jArr[i];
                long j4 = j2 + j3;
                if (j < j4 || ((j3 == 0 && j == j2) || i == jArr.length - 1)) {
                    return i;
                }
                i++;
                j2 = j4;
            } else {
                return jArr.length - 1;
            }
        }
    }

    private long w(long j) {
        return Math.max(0L, Math.min(j, this.w));
    }

    private void lh() {
        int i = 0;
        while (true) {
            long[] jArr = this.l;
            if (i >= jArr.length) {
                return;
            }
            jArr[i] = qg(this.q.get(i));
            i++;
        }
    }

    private boolean v() {
        int i = this.d;
        return i == 3 || i == 4 || i == 5 || i == 6;
    }

    private static long[] n(List<k> list) {
        long[] jArr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            long jQg = qg(list.get(i));
            if (jQg <= 0) {
                throw new IllegalArgumentException("video duration must be greater than 0");
            }
            jArr[i] = jQg;
        }
        return jArr;
    }

    private static long qg(k kVar) {
        l lVarV = kVar == null ? null : kVar.v();
        if (lVarV == null || lVarV.w() <= 0.0d) {
            return 0L;
        }
        double dW = lVarV.w() * 1000.0d;
        return dW >= 9.223372036854776E18d ? LongCompanionObject.MAX_VALUE : Math.round(dW);
    }
}
