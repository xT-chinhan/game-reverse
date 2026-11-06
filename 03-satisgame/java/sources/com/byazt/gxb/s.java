package com.byazt.gxb;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.si.a;
import com.byazt.si.cy;
import com.byazt.si.d;
import com.byazt.si.j;
import com.byazt.si.m;
import com.byazt.si.sz;
import com.byazt.si.tj;
import com.byazt.tk.k;
import com.byazt.war.rv;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 790, 8})
public final class s implements d {
    public boolean a;
    public ExecutorService bb;
    public Queue<rv> cd;
    public int cp;
    public j cy;
    public WeakReference<ImageView> d;
    public int fs;
    public int h;
    public int hd;
    public com.byazt.si.qg hu;
    public boolean k;
    public m l;
    public a lh;
    public boolean ln;
    public com.byazt.gxb.n m;
    public Future<?> n;
    public volatile boolean oa;
    public int ou;
    public com.byazt.si.fs py;
    public String q;
    public String qg;
    public int rv;
    public String s;
    public boolean sz;
    public int t;
    public tj tj;
    public final Handler um;
    public boolean ur;
    public boolean v;
    public ImageView.ScaleType w;
    public w wm;
    public Bitmap.Config x;

    private s(qg qgVar) {
        this.cd = new LinkedBlockingQueue();
        this.um = new Handler(Looper.getMainLooper());
        this.a = true;
        this.qg = qgVar.q;
        this.l = new n(qgVar.n);
        this.d = new WeakReference<>(qgVar.qg);
        this.w = qgVar.l;
        this.x = qgVar.w;
        this.fs = qgVar.x;
        this.rv = qgVar.fs;
        this.cp = qgVar.rv;
        this.hd = qgVar.tj;
        this.cy = qgVar.cp;
        this.hu = n(qgVar);
        if (!TextUtils.isEmpty(qgVar.s)) {
            qg(qgVar.s);
            n(qgVar.s);
        }
        this.sz = qgVar.d;
        this.k = qgVar.oa;
        this.wm = qgVar.cy;
        this.tj = qgVar.hd;
        this.t = qgVar.um;
        this.h = qgVar.cd;
        this.bb = qgVar.py;
        this.ur = qgVar.a;
        this.ln = qgVar.ou;
        this.lh = qgVar.wm;
        this.v = qgVar.m;
        this.cd.add(new com.byazt.war.s());
    }

    private com.byazt.si.qg n(qg qgVar) {
        if (qgVar.k != null) {
            return qgVar.k;
        }
        if (!TextUtils.isEmpty(qgVar.sz)) {
            return com.byazt.dl.n.n(new File(qgVar.sz));
        }
        return com.byazt.dl.n.rv();
    }

    public int rv() {
        return this.h;
    }

    public int tj() {
        return this.t;
    }

    @Override // com.byazt.si.d
    public String qg() {
        return this.qg;
    }

    public m cp() {
        return this.l;
    }

    @Override // com.byazt.si.d
    public String w() {
        return this.q;
    }

    public void n(String str) {
        this.q = str;
    }

    @Override // com.byazt.si.d
    public String x() {
        return this.s;
    }

    @Override // com.byazt.si.d
    public Bitmap.Config fs() {
        return this.x;
    }

    public void qg(String str) {
        WeakReference<ImageView> weakReference = this.d;
        if (weakReference != null && weakReference.get() != null) {
            this.d.get().setTag(1094453505, str);
        }
        this.s = str;
    }

    @Override // com.byazt.si.d
    public ImageView.ScaleType l() {
        return this.w;
    }

    public Bitmap.Config d() {
        return this.x;
    }

    @Override // com.byazt.si.d
    public int s() {
        return this.fs;
    }

    @Override // com.byazt.si.d
    public int q() {
        return this.rv;
    }

    public int oa() {
        return this.cp;
    }

    public boolean sz() {
        return this.sz;
    }

    public boolean k() {
        return this.k;
    }

    public void n(boolean z) {
        this.a = z;
    }

    public boolean cy() {
        return this.a;
    }

    public boolean hd() {
        return this.v;
    }

    public com.byazt.si.fs cd() {
        return this.py;
    }

    public void n(com.byazt.si.fs fsVar) {
        this.py = fsVar;
    }

    public int um() {
        return this.ou;
    }

    public void n(int i) {
        this.ou = i;
    }

    public com.byazt.gxb.n a() {
        return this.m;
    }

    public void n(com.byazt.gxb.n nVar) {
        this.m = nVar;
    }

    public w py() {
        return this.wm;
    }

    public com.byazt.si.qg ou() {
        return this.hu;
    }

    public boolean n(rv rvVar) {
        if (this.oa) {
            return false;
        }
        return this.cd.add(rvVar);
    }

    public boolean wm() {
        return this.ur;
    }

    public a m() {
        return this.lh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d h() {
        try {
            w wVar = this.wm;
            if (wVar == null) {
                m mVar = this.l;
                if (mVar != null) {
                    mVar.n(1005, "not init !", null);
                }
                return this;
            }
            ExecutorService executorServiceW = this.bb == null ? wVar.w() : null;
            Runnable runnable = new Runnable() { // from class: com.byazt.gxb.s.1
                @Override // java.lang.Runnable
                public void run() {
                    rv rvVar;
                    while (!s.this.oa && (rvVar = (rv) s.this.cd.poll()) != null) {
                        try {
                            if (s.this.cy != null) {
                                s.this.cy.n(rvVar.n(), s.this);
                            }
                            rvVar.n(s.this);
                            if (s.this.cy != null) {
                                s.this.cy.qg(rvVar.n(), s.this);
                            }
                        } catch (Throwable th) {
                            s.this.n(2000, th.getMessage(), th);
                            if (s.this.cy != null) {
                                s.this.cy.qg("exception", s.this);
                                return;
                            }
                            return;
                        }
                    }
                    if (s.this.oa) {
                        s.this.n(1003, "canceled", null);
                    }
                }
            };
            if (this.ln) {
                runnable.run();
            } else {
                ExecutorService executorService = this.bb;
                if (executorService != null) {
                    this.n = executorService.submit(runnable);
                } else if (executorServiceW != null) {
                    this.n = executorServiceW.submit(runnable);
                }
            }
            return this;
        } catch (Exception e) {
            k.qg("ImageRequest", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str, Throwable th) {
        new com.byazt.war.fs(i, str, th).n(this);
        this.cd.clear();
    }

    @Override // com.byazt.si.d
    public boolean n() {
        this.oa = true;
        Future<?> future = this.n;
        if (future != null) {
            return future.cancel(true);
        }
        return true;
    }

    public String hu() {
        return w();
    }

    @com.byazt.cp.n(n = {0, 1, 790, 782})
    public static class qg implements sz {
        public boolean a;
        public int cd;
        public j cp;
        public w cy;
        public boolean d;
        public int fs;
        public tj hd;
        public com.byazt.si.qg k;
        public ImageView.ScaleType l;
        public boolean m;
        public m n;
        public boolean oa;
        public boolean ou;
        public ExecutorService py;
        public String q;
        public ImageView qg;
        public String s;
        public String sz;
        public int um;
        public Bitmap.Config w;
        public a wm;
        public int x;
        public int rv = 1;
        public int tj = 5;

        public qg(w wVar) {
            this.cy = wVar;
        }

        @Override // com.byazt.si.sz
        public sz n(String str) {
            this.q = str;
            return this;
        }

        @Override // com.byazt.si.sz
        public sz qg(String str) {
            this.s = str;
            return this;
        }

        @Override // com.byazt.si.sz
        public sz n(com.byazt.si.qg qgVar) {
            this.k = qgVar;
            return this;
        }

        @Override // com.byazt.si.sz
        public sz n(ImageView.ScaleType scaleType) {
            this.l = scaleType;
            return this;
        }

        @Override // com.byazt.si.sz
        public sz n(Bitmap.Config config) {
            this.w = config;
            return this;
        }

        @Override // com.byazt.si.sz
        public sz n(int i) {
            this.x = i;
            return this;
        }

        @Override // com.byazt.si.sz
        public sz qg(int i) {
            this.fs = i;
            return this;
        }

        @Override // com.byazt.si.sz
        public sz s(int i) {
            this.rv = i;
            return this;
        }

        @Override // com.byazt.si.sz
        public sz n(j jVar) {
            this.cp = jVar;
            return this;
        }

        @Override // com.byazt.si.sz
        public sz n(boolean z) {
            this.d = z;
            return this;
        }

        @Override // com.byazt.si.sz
        public sz qg(boolean z) {
            this.oa = z;
            return this;
        }

        @Override // com.byazt.si.sz
        public sz n(ExecutorService executorService) {
            this.py = executorService;
            return this;
        }

        @Override // com.byazt.si.sz
        public sz s(String str) {
            this.sz = str;
            return this;
        }

        @Override // com.byazt.si.sz
        public d n(m mVar, int i) {
            this.tj = i;
            return n(mVar);
        }

        @Override // com.byazt.si.sz
        public d n(m mVar) {
            this.n = mVar;
            return new s(this).h();
        }

        @Override // com.byazt.si.sz
        public d n(ImageView imageView) {
            this.qg = imageView;
            return new s(this).h();
        }

        @Override // com.byazt.si.sz
        public sz n(tj tjVar) {
            this.hd = tjVar;
            return this;
        }

        @Override // com.byazt.si.sz
        public sz q(int i) {
            this.cd = i;
            return this;
        }

        @Override // com.byazt.si.sz
        public sz l(int i) {
            this.um = i;
            return this;
        }

        @Override // com.byazt.si.sz
        public sz s(boolean z) {
            this.ou = z;
            return this;
        }

        @Override // com.byazt.si.sz
        public sz n(a aVar) {
            this.wm = aVar;
            return this;
        }

        @Override // com.byazt.si.sz
        public sz q(boolean z) {
            this.m = z;
            return this;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 790, 546})
    private class n implements m {
        public m qg;

        public n(m mVar) {
            this.qg = mVar;
        }

        @Override // com.byazt.si.m
        public void n(final cy cyVar) {
            final ImageView imageView = (ImageView) s.this.d.get();
            if (imageView != null && s.this.cp != 3 && n(imageView) && (cyVar.s() instanceof Bitmap)) {
                final Bitmap bitmap = (Bitmap) cyVar.s();
                s.this.um.post(new Runnable() { // from class: com.byazt.gxb.s.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
            try {
                if (s.this.tj != null && (cyVar.s() instanceof Bitmap)) {
                    tj tjVar = s.this.tj;
                    Bitmap bitmap2 = (Bitmap) cyVar.s();
                    Bitmap bitmapN = tjVar.n(bitmap2);
                    if (bitmapN != null) {
                        cyVar.setResult(bitmapN);
                    }
                }
            } catch (Throwable unused) {
            }
            if (s.this.hd == 5) {
                s.this.um.postAtFrontOfQueue(new Runnable() { // from class: com.byazt.gxb.s.n.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (n.this.qg != null) {
                            n.this.qg.n(cyVar);
                        }
                    }
                });
                return;
            }
            m mVar = this.qg;
            if (mVar != null) {
                mVar.n(cyVar);
            }
        }

        private boolean n(ImageView imageView) {
            Object tag;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(s.this.s)) ? false : true;
        }

        @Override // com.byazt.si.m
        public void n(final int i, final String str, final Throwable th) {
            if (s.this.hd == 5) {
                s.this.um.post(new Runnable() { // from class: com.byazt.gxb.s.n.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (n.this.qg != null) {
                            n.this.qg.n(i, str, th);
                        }
                    }
                });
                return;
            }
            m mVar = this.qg;
            if (mVar != null) {
                mVar.n(i, str, th);
            }
        }
    }
}
