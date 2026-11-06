package com.bytedance.sdk.component.c.ah;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.c.ch;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.component.c.ny;
import com.bytedance.sdk.component.c.t;
import com.bytedance.sdk.component.c.u;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements ny {
    private Bitmap.Config ab;
    private String ah;
    private t ao;
    private int b;
    private ImageView.ScaleType c;
    private com.bytedance.sdk.component.c.x ch;
    private ExecutorService cv;
    private String d;
    private boolean g;
    private int h;
    private int hi;
    private com.bytedance.sdk.component.c.ah.ms i;
    private ao ka;
    private boolean le;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    Future<?> f1153ms;
    private com.bytedance.sdk.component.c.ab nw;
    private int ny;
    private u of;
    private int op;
    private Queue<com.bytedance.sdk.component.c.d.ny> qv;
    private c re;
    private WeakReference<ImageView> sl;
    private boolean t;
    private boolean u;
    private boolean ub;
    private com.bytedance.sdk.component.c.xr w;
    private int x;
    private String xr;
    private final Handler y;
    private int yu;
    private volatile boolean zb;

    private ah(xr xrVar) {
        this.qv = new LinkedBlockingQueue();
        this.y = new Handler(Looper.getMainLooper());
        this.t = true;
        this.xr = xrVar.d;
        this.ka = new ms(xrVar.f1159ms);
        this.sl = new WeakReference<>(xrVar.xr);
        this.c = xrVar.ka;
        this.ab = xrVar.c;
        this.x = xrVar.ab;
        this.ny = xrVar.x;
        this.hi = xrVar.ny;
        this.h = xrVar.ch;
        this.ao = xrVar.hi;
        this.w = ms(xrVar);
        if (!TextUtils.isEmpty(xrVar.ah)) {
            xr(xrVar.ah);
            ms(xrVar.ah);
        }
        this.u = xrVar.sl;
        this.ub = xrVar.zb;
        this.re = xrVar.ao;
        this.ch = xrVar.h;
        this.op = xrVar.y;
        this.yu = xrVar.qv;
        this.cv = xrVar.nw;
        this.le = xrVar.t;
        this.g = xrVar.b;
        this.of = xrVar.re;
        this.qv.add(new com.bytedance.sdk.component.c.d.ah());
    }

    private com.bytedance.sdk.component.c.xr ms(xr xrVar) {
        if (xrVar.ub != null) {
            return xrVar.ub;
        }
        if (!TextUtils.isEmpty(xrVar.u)) {
            return com.bytedance.sdk.component.c.ah.ms.ms.ms(new File(xrVar.u));
        }
        return com.bytedance.sdk.component.c.ah.ms.ms.ny();
    }

    public int ny() {
        return this.yu;
    }

    public int ch() {
        return this.op;
    }

    @Override // com.bytedance.sdk.component.c.ny
    @ATSMethod(2)
    public String xr() {
        return this.xr;
    }

    public ao hi() {
        return this.ka;
    }

    @Override // com.bytedance.sdk.component.c.ny
    @ATSMethod(6)
    public String c() {
        return this.d;
    }

    public void ms(String str) {
        this.d = str;
    }

    @Override // com.bytedance.sdk.component.c.ny
    @ATSMethod(7)
    public String ab() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.component.c.ny
    @ATSMethod(8)
    public Bitmap.Config x() {
        return this.ab;
    }

    public void xr(String str) {
        WeakReference<ImageView> weakReference = this.sl;
        if (weakReference != null && weakReference.get() != null) {
            this.sl.get().setTag(1094453505, str);
        }
        this.ah = str;
    }

    @Override // com.bytedance.sdk.component.c.ny
    @ATSMethod(5)
    public ImageView.ScaleType ka() {
        return this.c;
    }

    public Bitmap.Config sl() {
        return this.ab;
    }

    @Override // com.bytedance.sdk.component.c.ny
    @ATSMethod(3)
    public int ah() {
        return this.x;
    }

    @Override // com.bytedance.sdk.component.c.ny
    @ATSMethod(4)
    public int d() {
        return this.ny;
    }

    public int zb() {
        return this.hi;
    }

    public boolean u() {
        return this.u;
    }

    public boolean ub() {
        return this.ub;
    }

    public void ms(boolean z) {
        this.t = z;
    }

    public boolean ao() {
        return this.t;
    }

    public com.bytedance.sdk.component.c.ab h() {
        return this.nw;
    }

    public void ms(com.bytedance.sdk.component.c.ab abVar) {
        this.nw = abVar;
    }

    public int qv() {
        return this.b;
    }

    public void ms(int i) {
        this.b = i;
    }

    public com.bytedance.sdk.component.c.ah.ms y() {
        return this.i;
    }

    public void ms(com.bytedance.sdk.component.c.ah.ms msVar) {
        this.i = msVar;
    }

    public c t() {
        return this.re;
    }

    public com.bytedance.sdk.component.c.xr nw() {
        return this.w;
    }

    public boolean ms(com.bytedance.sdk.component.c.d.ny nyVar) {
        if (this.zb) {
            return false;
        }
        return this.qv.add(nyVar);
    }

    public boolean b() {
        return this.le;
    }

    public u re() {
        return this.of;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ny w() {
        try {
            c cVar = this.re;
            if (cVar == null) {
                ao aoVar = this.ka;
                if (aoVar != null) {
                    aoVar.ms(1005, "not init !", null);
                }
                return this;
            }
            ExecutorService executorServiceC = this.cv == null ? cVar.c() : null;
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.c.ah.ah.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.c.d.ny nyVar;
                    while (!ah.this.zb && (nyVar = (com.bytedance.sdk.component.c.d.ny) ah.this.qv.poll()) != null) {
                        try {
                            if (ah.this.ao != null) {
                                ah.this.ao.ms(nyVar.ms(), ah.this);
                            }
                            nyVar.ms(ah.this);
                            if (ah.this.ao != null) {
                                ah.this.ao.xr(nyVar.ms(), ah.this);
                            }
                        } catch (Throwable th) {
                            ah.this.ms(2000, th.getMessage(), th);
                            if (ah.this.ao != null) {
                                ah.this.ao.xr("exception", ah.this);
                                return;
                            }
                            return;
                        }
                    }
                    if (ah.this.zb) {
                        ah.this.ms(1003, "canceled", null);
                    }
                }
            };
            if (this.g) {
                runnable.run();
            } else {
                ExecutorService executorService = this.cv;
                if (executorService != null) {
                    this.f1153ms = executorService.submit(runnable);
                } else if (executorServiceC != null) {
                    this.f1153ms = executorServiceC.submit(runnable);
                }
            }
            return this;
        } catch (Exception e) {
            sl.d("ImageRequest", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, String str, Throwable th) {
        new com.bytedance.sdk.component.c.d.x(i, str, th).ms(this);
        this.qv.clear();
    }

    @Override // com.bytedance.sdk.component.c.ny
    @ATSMethod(1)
    public boolean ms() {
        this.zb = true;
        Future<?> future = this.f1153ms;
        if (future != null) {
            return future.cancel(true);
        }
        return true;
    }

    public String i() {
        return c();
    }

    public static class xr implements ch {
        private int ab;
        private String ah;
        private c ao;
        private boolean b;
        private Bitmap.Config c;
        private String d;
        private com.bytedance.sdk.component.c.x h;
        private t hi;
        private ImageView.ScaleType ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private ao f1159ms;
        private ExecutorService nw;
        private int qv;
        private u re;
        private boolean sl;
        private boolean t;
        private String u;
        private com.bytedance.sdk.component.c.xr ub;
        private int x;
        private ImageView xr;
        private int y;
        private boolean zb;
        private int ny = 1;
        private int ch = 5;

        public xr(c cVar) {
            this.ao = cVar;
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(4)
        public ch ms(String str) {
            this.d = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(5)
        public ch xr(String str) {
            this.ah = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(6)
        public ch ms(com.bytedance.sdk.component.c.xr xrVar) {
            this.ub = xrVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(8)
        public ch ms(ImageView.ScaleType scaleType) {
            this.ka = scaleType;
            return this;
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(9)
        public ch ms(Bitmap.Config config) {
            this.c = config;
            return this;
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(10)
        public ch ms(int i) {
            this.ab = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(11)
        public ch xr(int i) {
            this.x = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(12)
        public ch ah(int i) {
            this.ny = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(13)
        public ch ms(t tVar) {
            this.hi = tVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(14)
        public ch ms(boolean z) {
            this.sl = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(15)
        public ch xr(boolean z) {
            this.zb = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(16)
        public ch ms(ExecutorService executorService) {
            this.nw = executorService;
            return this;
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(7)
        public ch ah(String str) {
            this.u = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(1)
        public ny ms(ao aoVar, int i) {
            this.ch = i;
            return ms(aoVar);
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(2)
        public ny ms(ao aoVar) {
            this.f1159ms = aoVar;
            return new ah(this).w();
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(3)
        public ny ms(ImageView imageView) {
            this.xr = imageView;
            return new ah(this).w();
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(17)
        public ch ms(com.bytedance.sdk.component.c.x xVar) {
            this.h = xVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(18)
        public ch d(int i) {
            this.qv = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(19)
        public ch ka(int i) {
            this.y = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(20)
        public ch ah(boolean z) {
            this.b = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.c.ch
        @ATSMethod(21)
        public ch ms(u uVar) {
            this.re = uVar;
            return this;
        }
    }

    private class ms implements ao {
        private ao xr;

        public ms(ao aoVar) {
            this.xr = aoVar;
        }

        @Override // com.bytedance.sdk.component.c.ao
        @ATSMethod(1)
        public void ms(final hi hiVar) {
            final ImageView imageView = (ImageView) ah.this.sl.get();
            if (imageView != null && ah.this.hi != 3 && ms(imageView) && (hiVar.ah() instanceof Bitmap)) {
                final Bitmap bitmap = (Bitmap) hiVar.ah();
                ah.this.y.post(new Runnable() { // from class: com.bytedance.sdk.component.c.ah.ah.ms.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
            try {
                if (ah.this.ch != null && (hiVar.ah() instanceof Bitmap)) {
                    com.bytedance.sdk.component.c.x xVar = ah.this.ch;
                    Bitmap bitmap2 = (Bitmap) hiVar.ah();
                    Bitmap bitmapMs = xVar.ms(bitmap2);
                    if (bitmapMs != null) {
                        hiVar.setResult(bitmapMs);
                    }
                }
            } catch (Throwable unused) {
            }
            if (ah.this.h == 5) {
                ah.this.y.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.component.c.ah.ah.ms.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ms.this.xr != null) {
                            ms.this.xr.ms(hiVar);
                        }
                    }
                });
                return;
            }
            ao aoVar = this.xr;
            if (aoVar != null) {
                aoVar.ms(hiVar);
            }
        }

        private boolean ms(ImageView imageView) {
            Object tag;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(ah.this.ah)) ? false : true;
        }

        @Override // com.bytedance.sdk.component.c.ao
        @ATSMethod(2)
        public void ms(final int i, final String str, final Throwable th) {
            if (ah.this.h == 5) {
                ah.this.y.post(new Runnable() { // from class: com.bytedance.sdk.component.c.ah.ah.ms.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ms.this.xr != null) {
                            ms.this.xr.ms(i, str, th);
                        }
                    }
                });
                return;
            }
            ao aoVar = this.xr;
            if (aoVar != null) {
                aoVar.ms(i, str, th);
            }
        }
    }
}
