package com.byazt.sl;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.ca.ho;
import com.byazt.ld.a;
import com.byazt.ld.g;
import com.byazt.ld.k;
import com.byazt.ld.n;
import com.byazt.ld.nt;
import com.byazt.ld.rc;
import com.byazt.ld.vk;
import com.byazt.wgd.aj;
import com.taptap.sdk.update.download.DownloadTask;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 4, 20})
public final class hn implements k {
    public boolean a;
    public int aj;
    public int b;
    public rc c;
    public com.byazt.ld.zo cz;
    public uc fo;
    public Bitmap.Config fw;
    public boolean g;
    public ExecutorService gz;
    public String hn;
    public boolean ho;
    public String hw;
    public int iu;
    public WeakReference<ImageView> k;
    public Queue<aj> lb;
    public volatile boolean m;
    public boolean nl;
    public n nt;
    public int ny;
    public Future<?> pr;
    public final Handler qa;
    public com.byazt.sl.pr rc;
    public ImageView.ScaleType uc;
    public boolean ve;
    public vk vk;
    public int w;
    public boolean ww;
    public String x;
    public a y;
    public int yb;
    public com.byazt.ld.hw z;
    public int zo;

    private hn(hw hwVar) {
        this.lb = new LinkedBlockingQueue();
        this.qa = new Handler(Looper.getMainLooper());
        this.a = true;
        this.hw = hwVar.x;
        this.c = new pr(hwVar.pr);
        this.k = new WeakReference<>(hwVar.hw);
        this.uc = hwVar.c;
        this.fw = hwVar.uc;
        this.zo = hwVar.fw;
        this.aj = hwVar.zo;
        this.w = hwVar.aj;
        this.yb = hwVar.vk;
        this.nt = hwVar.w;
        this.z = pr(hwVar);
        if (!TextUtils.isEmpty(hwVar.hn)) {
            hw(hwVar.hn);
            pr(hwVar.hn);
        }
        this.g = hwVar.k;
        this.ho = hwVar.m;
        this.fo = hwVar.nt;
        this.vk = hwVar.yb;
        this.iu = hwVar.qa;
        this.b = hwVar.lb;
        this.gz = hwVar.cz;
        this.ve = hwVar.a;
        this.nl = hwVar.ny;
        this.y = hwVar.fo;
        this.ww = hwVar.rc;
        this.lb.add(new com.byazt.wgd.hn());
    }

    private com.byazt.ld.hw pr(hw hwVar) {
        if (hwVar.ho != null) {
            return hwVar.ho;
        }
        if (!TextUtils.isEmpty(hwVar.g)) {
            return com.byazt.bbo.pr.pr(new File(hwVar.g));
        }
        return com.byazt.bbo.pr.aj();
    }

    public int aj() {
        return this.b;
    }

    public int vk() {
        return this.iu;
    }

    @Override // com.byazt.ld.k
    public String hw() {
        return this.hw;
    }

    public rc w() {
        return this.c;
    }

    @Override // com.byazt.ld.k
    public String uc() {
        return this.x;
    }

    public void pr(String str) {
        this.x = str;
    }

    @Override // com.byazt.ld.k
    public String fw() {
        return this.hn;
    }

    @Override // com.byazt.ld.k
    public Bitmap.Config zo() {
        return this.fw;
    }

    public void hw(String str) {
        WeakReference<ImageView> weakReference = this.k;
        if (weakReference != null && weakReference.get() != null) {
            this.k.get().setTag(1094453505, str);
        }
        this.hn = str;
    }

    @Override // com.byazt.ld.k
    public ImageView.ScaleType c() {
        return this.uc;
    }

    public Bitmap.Config k() {
        return this.fw;
    }

    @Override // com.byazt.ld.k
    public int hn() {
        return this.zo;
    }

    @Override // com.byazt.ld.k
    public int x() {
        return this.aj;
    }

    public int m() {
        return this.w;
    }

    public boolean g() {
        return this.g;
    }

    public boolean ho() {
        return this.ho;
    }

    public void pr(boolean z) {
        this.a = z;
    }

    public boolean nt() {
        return this.a;
    }

    public boolean yb() {
        return this.ww;
    }

    public com.byazt.ld.zo lb() {
        return this.cz;
    }

    public void pr(com.byazt.ld.zo zoVar) {
        this.cz = zoVar;
    }

    public int qa() {
        return this.ny;
    }

    public void pr(int i) {
        this.ny = i;
    }

    public com.byazt.sl.pr a() {
        return this.rc;
    }

    public void pr(com.byazt.sl.pr prVar) {
        this.rc = prVar;
    }

    public uc cz() {
        return this.fo;
    }

    public com.byazt.ld.hw ny() {
        return this.z;
    }

    public boolean pr(aj ajVar) {
        if (this.m) {
            return false;
        }
        return this.lb.add(ajVar);
    }

    public boolean fo() {
        return this.ve;
    }

    public a rc() {
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public k b() {
        try {
            uc ucVar = this.fo;
            if (ucVar == null) {
                rc rcVar = this.c;
                if (rcVar != null) {
                    rcVar.pr(1005, "not init !", null);
                }
                return this;
            }
            ExecutorService executorServiceUc = this.gz == null ? ucVar.uc() : null;
            Runnable runnable = new Runnable() { // from class: com.byazt.sl.hn.1
                @Override // java.lang.Runnable
                public void run() {
                    aj ajVar;
                    while (!hn.this.m && (ajVar = (aj) hn.this.lb.poll()) != null) {
                        try {
                            if (hn.this.nt != null) {
                                hn.this.nt.pr(ajVar.pr(), hn.this);
                            }
                            ajVar.pr(hn.this);
                            if (hn.this.nt != null) {
                                hn.this.nt.hw(ajVar.pr(), hn.this);
                            }
                        } catch (Throwable th) {
                            hn.this.pr(DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS, th.getMessage(), th);
                            if (hn.this.nt != null) {
                                hn.this.nt.hw("exception", hn.this);
                                return;
                            }
                            return;
                        }
                    }
                    if (hn.this.m) {
                        hn.this.pr(1003, "canceled", null);
                    }
                }
            };
            if (this.nl) {
                runnable.run();
            } else {
                ExecutorService executorService = this.gz;
                if (executorService != null) {
                    this.pr = executorService.submit(runnable);
                } else if (executorServiceUc != null) {
                    this.pr = executorServiceUc.submit(runnable);
                }
            }
            return this;
        } catch (Exception e) {
            ho.hw("ImageRequest", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, String str, Throwable th) {
        new com.byazt.wgd.zo(i, str, th).pr(this);
        this.lb.clear();
    }

    @Override // com.byazt.ld.k
    public boolean pr() {
        this.m = true;
        Future<?> future = this.pr;
        if (future == null) {
            return true;
        }
        return future.cancel(true);
    }

    public String z() {
        return uc();
    }

    @com.byazt.vzx.pr(pr = {0, 1, 4, 506})
    public static class hw implements g {
        public boolean a;
        public ImageView.ScaleType c;
        public ExecutorService cz;
        public a fo;
        public int fw;
        public String g;
        public String hn;
        public com.byazt.ld.hw ho;
        public ImageView hw;
        public boolean k;
        public int lb;
        public boolean m;
        public uc nt;
        public boolean ny;
        public rc pr;
        public int qa;
        public boolean rc;
        public Bitmap.Config uc;
        public n w;
        public String x;
        public vk yb;
        public int zo;
        public int aj = 1;
        public int vk = 5;

        public hw(uc ucVar) {
            this.nt = ucVar;
        }

        @Override // com.byazt.ld.g
        public g pr(String str) {
            this.x = str;
            return this;
        }

        @Override // com.byazt.ld.g
        public g hw(String str) {
            this.hn = str;
            return this;
        }

        @Override // com.byazt.ld.g
        public g pr(com.byazt.ld.hw hwVar) {
            this.ho = hwVar;
            return this;
        }

        @Override // com.byazt.ld.g
        public g pr(ImageView.ScaleType scaleType) {
            this.c = scaleType;
            return this;
        }

        @Override // com.byazt.ld.g
        public g pr(Bitmap.Config config) {
            this.uc = config;
            return this;
        }

        @Override // com.byazt.ld.g
        public g pr(int i) {
            this.fw = i;
            return this;
        }

        @Override // com.byazt.ld.g
        public g hw(int i) {
            this.zo = i;
            return this;
        }

        @Override // com.byazt.ld.g
        public g hn(int i) {
            this.aj = i;
            return this;
        }

        @Override // com.byazt.ld.g
        public g pr(n nVar) {
            this.w = nVar;
            return this;
        }

        @Override // com.byazt.ld.g
        public g pr(boolean z) {
            this.k = z;
            return this;
        }

        @Override // com.byazt.ld.g
        public g hw(boolean z) {
            this.m = z;
            return this;
        }

        @Override // com.byazt.ld.g
        public g pr(ExecutorService executorService) {
            this.cz = executorService;
            return this;
        }

        @Override // com.byazt.ld.g
        public g hn(String str) {
            this.g = str;
            return this;
        }

        @Override // com.byazt.ld.g
        public k pr(rc rcVar, int i) {
            this.vk = i;
            return pr(rcVar);
        }

        @Override // com.byazt.ld.g
        public k pr(rc rcVar) {
            this.pr = rcVar;
            return new hn(this).b();
        }

        @Override // com.byazt.ld.g
        public k pr(ImageView imageView) {
            this.hw = imageView;
            return new hn(this).b();
        }

        @Override // com.byazt.ld.g
        public g pr(vk vkVar) {
            this.yb = vkVar;
            return this;
        }

        @Override // com.byazt.ld.g
        public g x(int i) {
            this.lb = i;
            return this;
        }

        @Override // com.byazt.ld.g
        public g c(int i) {
            this.qa = i;
            return this;
        }

        @Override // com.byazt.ld.g
        public g hn(boolean z) {
            this.ny = z;
            return this;
        }

        @Override // com.byazt.ld.g
        public g pr(a aVar) {
            this.fo = aVar;
            return this;
        }

        @Override // com.byazt.ld.g
        public g x(boolean z) {
            this.rc = z;
            return this;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 4, 116})
    private class pr implements rc {
        public rc hw;

        public pr(rc rcVar) {
            this.hw = rcVar;
        }

        @Override // com.byazt.ld.rc
        public void pr(final nt ntVar) {
            final ImageView imageView = (ImageView) hn.this.k.get();
            if (imageView != null && hn.this.w != 3 && pr(imageView) && (ntVar.hn() instanceof Bitmap)) {
                final Bitmap bitmap = (Bitmap) ntVar.hn();
                hn.this.qa.post(new Runnable() { // from class: com.byazt.sl.hn.pr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
            try {
                if (hn.this.vk != null && (ntVar.hn() instanceof Bitmap)) {
                    vk vkVar = hn.this.vk;
                    Bitmap bitmap2 = (Bitmap) ntVar.hn();
                    Bitmap bitmapPr = vkVar.pr(bitmap2);
                    if (bitmapPr != null) {
                        ntVar.setResult(bitmapPr);
                    }
                }
            } catch (Throwable th) {
            }
            if (hn.this.yb == 5) {
                hn.this.qa.postAtFrontOfQueue(new Runnable() { // from class: com.byazt.sl.hn.pr.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (pr.this.hw != null) {
                            pr.this.hw.pr(ntVar);
                        }
                    }
                });
                return;
            }
            rc rcVar = this.hw;
            if (rcVar != null) {
                rcVar.pr(ntVar);
            }
        }

        private boolean pr(ImageView imageView) {
            Object tag;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(hn.this.hn)) ? false : true;
        }

        @Override // com.byazt.ld.rc
        public void pr(final int i, final String str, final Throwable th) {
            if (hn.this.yb == 5) {
                hn.this.qa.post(new Runnable() { // from class: com.byazt.sl.hn.pr.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (pr.this.hw != null) {
                            pr.this.hw.pr(i, str, th);
                        }
                    }
                });
                return;
            }
            rc rcVar = this.hw;
            if (rcVar != null) {
                rcVar.pr(i, str, th);
            }
        }
    }
}
