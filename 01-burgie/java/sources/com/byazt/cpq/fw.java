package com.byazt.cpq;

import android.os.SystemClock;
import android.support.v4.internal.view.SupportMenu;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 405, 62})
public final class fw implements Closeable {
    public final ExecutorService a;
    public final m aj;
    public final String c;
    public Map<Integer, k> cz;
    public int fw;
    public boolean g;
    public final hw hn;
    public final Socket ho;
    public final boolean hw;
    public final Set<Integer> lb;
    public final g m;
    public final vk nt;
    public int ny;
    public int uc;
    public long w;
    public final hn yb;
    public boolean zo;
    public static final /* synthetic */ boolean qa = true;
    public static final ExecutorService pr = new com.byazt.fr.x(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.byazt.xx.hn.pr("OkHttp Http2Connection", true));
    public final Map<Integer, aj> x = new LinkedHashMap();
    public long vk = 0;
    public g k = new g();

    public fw(pr prVar) {
        g gVar = new g();
        this.m = gVar;
        this.g = false;
        this.lb = new LinkedHashSet();
        this.aj = prVar.uc;
        boolean z = prVar.fw;
        this.hw = z;
        this.hn = prVar.c;
        this.fw = prVar.fw ? 1 : 2;
        if (prVar.fw) {
            this.fw += 2;
        }
        this.ny = prVar.fw ? 1 : 2;
        if (prVar.fw) {
            this.k.pr(7, 16777216);
        }
        String str = prVar.hw;
        this.c = str;
        this.a = new com.byazt.fr.x(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.byazt.xx.hn.pr(com.byazt.xx.hn.pr("OkHttp %s Push Observer", str), true));
        gVar.pr(7, SupportMenu.USER_MASK);
        gVar.pr(5, 16384);
        this.w = gVar.x();
        this.ho = prVar.pr;
        this.nt = new vk(prVar.x, z);
        this.yb = new hn(new zo(prVar.hn, z));
    }

    public synchronized aj pr(int i) {
        return this.x.get(Integer.valueOf(i));
    }

    public synchronized aj hw(int i) {
        aj ajVarRemove;
        ajVarRemove = this.x.remove(Integer.valueOf(i));
        notifyAll();
        return ajVarRemove;
    }

    public synchronized int pr() {
        return this.m.hn(Integer.MAX_VALUE);
    }

    public aj pr(List<com.byazt.cpq.hn> list, boolean z) throws IOException {
        return hw(0, list, z);
    }

    private aj hw(int i, List<com.byazt.cpq.hn> list, boolean z) throws IOException {
        int i2;
        aj ajVar;
        boolean z2;
        boolean z3 = !z;
        synchronized (this.nt) {
            synchronized (this) {
                if (this.zo) {
                    throw new com.byazt.cpq.pr();
                }
                i2 = this.fw;
                this.fw = i2 + 2;
                ajVar = new aj(i2, this, z3, false, list);
                z2 = !z || this.w == 0 || ajVar.hw == 0;
                if (ajVar.hw()) {
                    this.x.put(Integer.valueOf(i2), ajVar);
                }
            }
            if (i == 0) {
                this.nt.pr(z3, i2, i, list);
            } else {
                if (this.hw) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
                this.nt.pr(i, i2, list);
            }
        }
        if (z2) {
            this.nt.hw();
        }
        return ajVar;
    }

    public void pr(int i, boolean z, com.byazt.du.hn hnVar, long j) throws IOException {
        long j2;
        int iMin;
        long j3;
        if (j == 0) {
            this.nt.pr(z, i, hnVar, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        j2 = this.w;
                        if (j2 <= 0) {
                            if (!this.x.containsKey(Integer.valueOf(i))) {
                                throw new IOException("stream closed");
                            }
                            wait();
                        }
                    } catch (InterruptedException e) {
                        throw new InterruptedIOException();
                    }
                }
                iMin = Math.min((int) Math.min(j, j2), this.nt.hn());
                j3 = iMin;
                this.w -= j3;
            }
            j -= j3;
            this.nt.pr(z && j == 0, i, hnVar, iMin);
        }
    }

    public void pr(long j) {
        this.w += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void pr(final int i, final com.byazt.cpq.hw hwVar) {
        try {
            pr.execute(new com.byazt.xx.hw("OkHttp %s stream %d", new Object[]{this.c, Integer.valueOf(i)}) { // from class: com.byazt.cpq.fw.1
                @Override // com.byazt.xx.hw
                public void x() {
                    try {
                        fw.this.hw(i, hwVar);
                    } catch (IOException e) {
                    }
                }
            });
        } catch (Throwable th) {
        }
    }

    public void hw(int i, com.byazt.cpq.hw hwVar) throws IOException {
        this.nt.pr(i, hwVar);
    }

    public void pr(final int i, final long j) {
        try {
            pr.execute(new com.byazt.xx.hw("OkHttp Window Update %s stream %d", new Object[]{this.c, Integer.valueOf(i)}) { // from class: com.byazt.cpq.fw.2
                @Override // com.byazt.xx.hw
                public void x() {
                    try {
                        fw.this.nt.pr(i, j);
                    } catch (IOException e) {
                    }
                }
            });
        } catch (Throwable th) {
        }
    }

    public void pr(final boolean z, final int i, final int i2, final k kVar) {
        try {
            pr.execute(new com.byazt.xx.hw("OkHttp %s ping %08x%08x", new Object[]{this.c, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: com.byazt.cpq.fw.3
                @Override // com.byazt.xx.hw
                public void x() {
                    try {
                        fw.this.hw(z, i, i2, kVar);
                    } catch (IOException e) {
                    }
                }
            });
        } catch (Throwable th) {
        }
    }

    public void hw(boolean z, int i, int i2, k kVar) throws IOException {
        synchronized (this.nt) {
            if (kVar != null) {
                kVar.pr();
                this.nt.pr(z, i, i2);
            } else {
                this.nt.pr(z, i, i2);
            }
            throw th;
        }
    }

    public synchronized k hn(int i) {
        Map<Integer, k> map;
        map = this.cz;
        return map != null ? map.remove(Integer.valueOf(i)) : null;
    }

    public void hw() throws IOException {
        this.nt.hw();
    }

    public void pr(com.byazt.cpq.hw hwVar) throws IOException {
        synchronized (this.nt) {
            synchronized (this) {
                if (this.zo) {
                    return;
                }
                this.zo = true;
                this.nt.pr(this.uc, hwVar, com.byazt.xx.hn.pr);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        pr(com.byazt.cpq.hw.NO_ERROR, com.byazt.cpq.hw.CANCEL);
    }

    public void pr(com.byazt.cpq.hw hwVar, com.byazt.cpq.hw hwVar2) throws IOException {
        aj[] ajVarArr;
        if (!qa && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        k[] kVarArr = null;
        try {
            pr(hwVar);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (this.x.isEmpty()) {
                ajVarArr = null;
            } else {
                ajVarArr = (aj[]) this.x.values().toArray(new aj[this.x.size()]);
                this.x.clear();
            }
            Map<Integer, k> map = this.cz;
            if (map != null) {
                k[] kVarArr2 = (k[]) map.values().toArray(new k[this.cz.size()]);
                this.cz = null;
                kVarArr = kVarArr2;
            }
        }
        if (ajVarArr != null) {
            for (aj ajVar : ajVarArr) {
                try {
                    ajVar.pr(hwVar2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        if (kVarArr != null) {
            for (k kVar : kVarArr) {
                kVar.hn();
            }
        }
        try {
            this.nt.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.ho.close();
        } catch (IOException e4) {
            e = e4;
        }
        if (e != null) {
            throw e;
        }
    }

    public void hn() throws IOException {
        pr(true);
    }

    public void pr(boolean z) throws IOException {
        if (z) {
            this.nt.pr();
            this.nt.hw(this.k);
            int iX = this.k.x();
            if (iX != 65535) {
                this.nt.pr(0, iX - SupportMenu.USER_MASK);
            }
        }
        com.byazt.fr.hn hnVar = new com.byazt.fr.hn(this.yb, "Http2Connection");
        hnVar.setName("csj_http2_connection" + SystemClock.uptimeMillis());
        hnVar.start();
    }

    public synchronized boolean x() {
        return this.zo;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 405, 766})
    public static class pr {
        public boolean fw;
        public com.byazt.du.c hn;
        public String hw;
        public Socket pr;
        public com.byazt.du.x x;
        public hw c = hw.uc;
        public m uc = m.pr;

        public pr(boolean z) {
            this.fw = z;
        }

        public pr pr(Socket socket, String str, com.byazt.du.c cVar, com.byazt.du.x xVar) {
            this.pr = socket;
            this.hw = str;
            this.hn = cVar;
            this.x = xVar;
            return this;
        }

        public pr pr(hw hwVar) {
            this.c = hwVar;
            return this;
        }

        public fw pr() {
            return new fw(this);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 405, 1589})
    class hn extends com.byazt.xx.hw implements zo.hw {
        public final zo pr;

        public hn(zo zoVar) {
            super("OkHttp %s", fw.this.c);
            this.pr = zoVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.byazt.cpq.hw] */
        /* JADX WARN: Type inference failed for: r0v10, types: [com.byazt.cpq.hw] */
        /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Exception] */
        /* JADX WARN: Type inference failed for: r0v3, types: [com.byazt.cpq.hw] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.byazt.xx.hw
        public void x() {
            com.byazt.cpq.hw e = com.byazt.cpq.hw.INTERNAL_ERROR;
            com.byazt.cpq.hw hwVar = com.byazt.cpq.hw.INTERNAL_ERROR;
            try {
                try {
                    this.pr.pr(this);
                    while (this.pr.pr(false, (zo.hw) this)) {
                    }
                    e = com.byazt.cpq.hw.NO_ERROR;
                    hwVar = com.byazt.cpq.hw.CANCEL;
                    try {
                        fw.this.pr((com.byazt.cpq.hw) e, hwVar);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    try {
                        fw.this.pr(e, hwVar);
                    } catch (Exception e3) {
                    }
                    com.byazt.xx.hn.pr(this.pr);
                    throw th;
                }
            } catch (IOException e4) {
                e = com.byazt.cpq.hw.PROTOCOL_ERROR;
                hwVar = com.byazt.cpq.hw.PROTOCOL_ERROR;
                try {
                    fw.this.pr((com.byazt.cpq.hw) e, hwVar);
                } catch (Exception e5) {
                }
            } catch (NullPointerException e6) {
                hwVar = com.byazt.cpq.hw.PROTOCOL_ERROR;
                e = com.byazt.cpq.hw.PROTOCOL_ERROR;
                try {
                    fw.this.pr((com.byazt.cpq.hw) e, hwVar);
                } catch (Exception e7) {
                }
            }
            com.byazt.xx.hn.pr(this.pr);
        }

        @Override // com.byazt.cpq.zo.hw
        public void pr(boolean z, int i, com.byazt.du.c cVar, int i2) throws IOException {
            if (fw.this.x(i)) {
                fw.this.pr(i, cVar, i2, z);
                return;
            }
            aj ajVarPr = fw.this.pr(i);
            if (ajVarPr == null) {
                fw.this.pr(i, com.byazt.cpq.hw.PROTOCOL_ERROR);
                cVar.zo(i2);
            } else {
                ajVarPr.pr(cVar, i2);
                if (z) {
                    ajVarPr.aj();
                }
            }
        }

        @Override // com.byazt.cpq.zo.hw
        public void pr(boolean z, int i, int i2, List<com.byazt.cpq.hn> list) {
            if (fw.this.x(i)) {
                fw.this.pr(i, list, z);
                return;
            }
            synchronized (fw.this) {
                aj ajVarPr = fw.this.pr(i);
                if (ajVarPr == null) {
                    if (fw.this.zo) {
                        return;
                    }
                    if (i <= fw.this.uc) {
                        return;
                    }
                    if (i % 2 == fw.this.fw % 2) {
                        return;
                    }
                    final aj ajVar = new aj(i, fw.this, false, z, list);
                    fw.this.uc = i;
                    fw.this.x.put(Integer.valueOf(i), ajVar);
                    try {
                        fw.pr.execute(new com.byazt.xx.hw("OkHttp %s stream %d", new Object[]{fw.this.c, Integer.valueOf(i)}) { // from class: com.byazt.cpq.fw.hn.1
                            @Override // com.byazt.xx.hw
                            public void x() {
                                try {
                                    fw.this.hn.pr(ajVar);
                                } catch (IOException e) {
                                    com.byazt.lp.c.hw().pr(4, "Http2Connection.Listener failure for " + fw.this.c, e);
                                    try {
                                        ajVar.pr(com.byazt.cpq.hw.PROTOCOL_ERROR);
                                    } catch (IOException e2) {
                                    }
                                }
                            }
                        });
                    } catch (Throwable th) {
                    }
                    return;
                }
                ajVarPr.pr(list);
                if (z) {
                    ajVarPr.aj();
                }
            }
        }

        @Override // com.byazt.cpq.zo.hw
        public void pr(int i, com.byazt.cpq.hw hwVar) {
            if (fw.this.x(i)) {
                fw.this.hn(i, hwVar);
                return;
            }
            aj ajVarHw = fw.this.hw(i);
            if (ajVarHw != null) {
                ajVarHw.hn(hwVar);
            }
        }

        @Override // com.byazt.cpq.zo.hw
        public void pr(boolean z, g gVar) {
            aj[] ajVarArr;
            long j;
            int i;
            synchronized (fw.this) {
                int iX = fw.this.m.x();
                if (z) {
                    fw.this.m.pr();
                }
                fw.this.m.pr(gVar);
                pr(gVar);
                int iX2 = fw.this.m.x();
                ajVarArr = null;
                if (iX2 != -1 && iX2 != iX) {
                    j = iX2 - iX;
                    if (!fw.this.g) {
                        fw.this.pr(j);
                        fw.this.g = true;
                    }
                    if (!fw.this.x.isEmpty()) {
                        ajVarArr = (aj[]) fw.this.x.values().toArray(new aj[fw.this.x.size()]);
                    }
                } else {
                    j = 0;
                }
                try {
                    fw.pr.execute(new com.byazt.xx.hw("OkHttp %s settings", fw.this.c) { // from class: com.byazt.cpq.fw.hn.2
                        @Override // com.byazt.xx.hw
                        public void x() {
                            fw.this.hn.pr(fw.this);
                        }
                    });
                } catch (Throwable th) {
                }
            }
            if (ajVarArr != null && j != 0) {
                for (aj ajVar : ajVarArr) {
                    synchronized (ajVar) {
                        ajVar.pr(j);
                    }
                }
            }
        }

        private void pr(final g gVar) {
            try {
                fw.pr.execute(new com.byazt.xx.hw("OkHttp %s ACK Settings", new Object[]{fw.this.c}) { // from class: com.byazt.cpq.fw.hn.3
                    @Override // com.byazt.xx.hw
                    public void x() {
                        try {
                            fw.this.nt.pr(gVar);
                        } catch (IOException e) {
                        }
                    }
                });
            } catch (Throwable th) {
            }
        }

        @Override // com.byazt.cpq.zo.hw
        public void pr(boolean z, int i, int i2) {
            if (z) {
                k kVarHn = fw.this.hn(i);
                if (kVarHn != null) {
                    kVarHn.hw();
                    return;
                }
                return;
            }
            fw.this.pr(true, i, i2, (k) null);
        }

        @Override // com.byazt.cpq.zo.hw
        public void pr(int i, com.byazt.cpq.hw hwVar, com.byazt.du.uc ucVar) {
            aj[] ajVarArr;
            synchronized (fw.this) {
                ajVarArr = (aj[]) fw.this.x.values().toArray(new aj[fw.this.x.size()]);
                fw.this.zo = true;
            }
            for (aj ajVar : ajVarArr) {
                if (ajVar.pr() > i && ajVar.hn()) {
                    ajVar.hn(com.byazt.cpq.hw.REFUSED_STREAM);
                    fw.this.hw(ajVar.pr());
                }
            }
        }

        @Override // com.byazt.cpq.zo.hw
        public void pr(int i, long j) {
            if (i == 0) {
                synchronized (fw.this) {
                    fw.this.w += j;
                    fw.this.notifyAll();
                }
                return;
            }
            aj ajVarPr = fw.this.pr(i);
            if (ajVarPr != null) {
                synchronized (ajVarPr) {
                    ajVarPr.pr(j);
                }
            }
        }

        @Override // com.byazt.cpq.zo.hw
        public void pr(int i, int i2, List<com.byazt.cpq.hn> list) {
            fw.this.pr(i2, list);
        }
    }

    public boolean x(int i) {
        return i != 0 && (i & 1) == 0;
    }

    public void pr(final int i, final List<com.byazt.cpq.hn> list) {
        synchronized (this) {
            if (this.lb.contains(Integer.valueOf(i))) {
                pr(i, com.byazt.cpq.hw.PROTOCOL_ERROR);
            } else {
                this.lb.add(Integer.valueOf(i));
                this.a.execute(new com.byazt.xx.hw("OkHttp %s Push Request[%s]", new Object[]{this.c, Integer.valueOf(i)}) { // from class: com.byazt.cpq.fw.4
                    @Override // com.byazt.xx.hw
                    public void x() {
                        if (fw.this.aj.pr(i, list)) {
                            try {
                                fw.this.nt.pr(i, com.byazt.cpq.hw.CANCEL);
                                synchronized (fw.this) {
                                    fw.this.lb.remove(Integer.valueOf(i));
                                }
                            } catch (IOException e) {
                            }
                        }
                    }
                });
            }
        }
    }

    public void pr(final int i, final List<com.byazt.cpq.hn> list, final boolean z) {
        this.a.execute(new com.byazt.xx.hw("OkHttp %s Push Headers[%s]", new Object[]{this.c, Integer.valueOf(i)}) { // from class: com.byazt.cpq.fw.5
            @Override // com.byazt.xx.hw
            public void x() {
                boolean zPr = fw.this.aj.pr(i, list, z);
                if (zPr) {
                    try {
                        fw.this.nt.pr(i, com.byazt.cpq.hw.CANCEL);
                    } catch (IOException e) {
                        return;
                    }
                }
                if (!zPr && !z) {
                    return;
                }
                synchronized (fw.this) {
                    fw.this.lb.remove(Integer.valueOf(i));
                }
            }
        });
    }

    public void pr(final int i, com.byazt.du.c cVar, final int i2, final boolean z) throws IOException {
        final com.byazt.du.hn hnVar = new com.byazt.du.hn();
        long j = i2;
        cVar.pr(j);
        cVar.pr(hnVar, j);
        if (hnVar.hw() != j) {
            throw new IOException(hnVar.hw() + " != " + i2);
        }
        this.a.execute(new com.byazt.xx.hw("OkHttp %s Push Data[%s]", new Object[]{this.c, Integer.valueOf(i)}) { // from class: com.byazt.cpq.fw.6
            @Override // com.byazt.xx.hw
            public void x() {
                try {
                    boolean zPr = fw.this.aj.pr(i, hnVar, i2, z);
                    if (zPr) {
                        fw.this.nt.pr(i, com.byazt.cpq.hw.CANCEL);
                    }
                    if (!zPr && !z) {
                        return;
                    }
                    synchronized (fw.this) {
                        fw.this.lb.remove(Integer.valueOf(i));
                    }
                } catch (IOException e) {
                }
            }
        });
    }

    public void hn(final int i, final com.byazt.cpq.hw hwVar) {
        this.a.execute(new com.byazt.xx.hw("OkHttp %s Push Reset[%s]", new Object[]{this.c, Integer.valueOf(i)}) { // from class: com.byazt.cpq.fw.7
            @Override // com.byazt.xx.hw
            public void x() {
                synchronized (fw.this) {
                    fw.this.lb.remove(Integer.valueOf(i));
                }
            }
        });
    }

    @com.byazt.vzx.pr(pr = {0, 1, 405, 984})
    public static abstract class hw {
        public static final hw uc = new hw() { // from class: com.byazt.cpq.fw.hw.1
            @Override // com.byazt.cpq.fw.hw
            public void pr(aj ajVar) throws IOException {
                ajVar.pr(com.byazt.cpq.hw.REFUSED_STREAM);
            }
        };

        public abstract void pr(aj ajVar) throws IOException;

        public void pr(fw fwVar) {
        }
    }
}
