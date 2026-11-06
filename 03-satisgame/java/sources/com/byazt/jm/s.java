package com.byazt.jm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.byazt.gu.w;
import com.byazt.hb.fs;
import com.byazt.hb.q;
import com.byazt.vh.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 918, 8})
public class s extends com.byazt.ih.s<RoundImageView> {
    public int bz;
    public String dm;
    public boolean ei;
    public float il;
    public String n;
    public float nk;
    public float o;
    public n.C0224n qn;
    public ImageView.ScaleType sq;
    public int vo;
    public String ze;

    public s(Context context) {
        super(context);
        this.sq = ImageView.ScaleType.FIT_XY;
        this.vo = -1;
        this.o = -1.0f;
        this.nk = -1.0f;
        this.bz = 0;
        this.il = 50.0f;
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
        cx();
        ((RoundImageView) this.l).setScaleType(this.sq);
        ((RoundImageView) this.l).setBorderColor(this.e);
        ((RoundImageView) this.l).setCornerRadius(this.pk);
        ((RoundImageView) this.l).setBorderWidth(this.pe);
        if (this.vo != -1) {
            ((RoundImageView) this.l).setColorFilter(this.vo);
        }
        ((RoundImageView) this.l).setEraseEnabled(this.bz == 1);
        ((RoundImageView) this.l).setEraseRadius(this.il);
    }

    public void oa(String str) {
        this.n = str;
    }

    private void cx() {
        if (TextUtils.isEmpty(this.n)) {
            return;
        }
        ((RoundImageView) this.l).setImageDrawable(null);
        if (this.n.startsWith("local://")) {
            try {
                String strReplace = this.n.replace("local://", "");
                if (TextUtils.equals(x(), "raw")) {
                    ((RoundImageView) this.l).setImageResource(q.n(this.qg, strReplace));
                    return;
                } else {
                    n((ImageView) this.l, strReplace);
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (this.n.startsWith("@")) {
            try {
                ((RoundImageView) this.l).setImageResource(Integer.parseInt(this.n.substring(1)));
            } catch (Exception unused2) {
            }
        } else if (!TextUtils.isEmpty(this.ze) || this.qn != null) {
            ic();
        } else {
            lq();
        }
    }

    public void n(ImageView imageView, String str) {
        imageView.setImageResource(q.qg(this.qg, str));
    }

    private void lq() {
        if (this.o > 0.0f) {
            if (this.wv != null) {
                this.wv.n();
            }
            w.n().qg().n(this.rv, this.n, new com.byazt.gu.qg.n() { // from class: com.byazt.jm.s.1
                @Override // com.byazt.gu.qg.n
                public void n(Bitmap bitmap) {
                    if (bitmap == null) {
                        if (s.this.wv != null) {
                            x xVar = s.this.wv;
                            s sVar = s.this;
                            xVar.qg(sVar, sVar.n);
                            return;
                        }
                        return;
                    }
                    if (s.this.wv != null) {
                        x xVar2 = s.this.wv;
                        s sVar2 = s.this;
                        xVar2.n(sVar2, sVar2.n);
                    }
                    final Bitmap bitmapN = fs.n(s.this.qg, bitmap, (int) s.this.o);
                    if (bitmapN != null) {
                        fs.n(new Runnable() { // from class: com.byazt.jm.s.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((RoundImageView) s.this.l).setImageBitmap(bitmapN);
                            }
                        });
                    }
                    if (s.this.ei || s.this.nk > 0.0f) {
                        Bitmap bitmapN2 = fs.n(s.this.qg, bitmap, s.this.nk > 0.0f ? (int) s.this.nk : 10);
                        if (bitmapN2 != null) {
                            final BitmapDrawable bitmapDrawable = new BitmapDrawable(s.this.qg.getResources(), bitmapN2);
                            fs.n(new Runnable() { // from class: com.byazt.jm.s.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((RoundImageView) s.this.l).setBackground(bitmapDrawable);
                                }
                            });
                        }
                    }
                }
            });
            return;
        }
        if (this.wv != null) {
            this.wv.n();
        }
        w.n().qg().n(this.rv, this.n, (ImageView) this.l, ((RoundImageView) this.l).getWidth(), ((RoundImageView) this.l).getHeight(), new com.byazt.gu.qg.n() { // from class: com.byazt.jm.s.2
            @Override // com.byazt.gu.qg.n
            public void n(Bitmap bitmap) {
                if (bitmap == null) {
                    if (s.this.wv != null) {
                        x xVar = s.this.wv;
                        s sVar = s.this;
                        xVar.qg(sVar, sVar.n);
                        return;
                    }
                    return;
                }
                if (s.this.wv != null) {
                    x xVar2 = s.this.wv;
                    s sVar2 = s.this;
                    xVar2.n(sVar2, sVar2.n);
                }
            }
        });
        if (this.ei || this.nk > 0.0f) {
            w.n().qg().n(this.rv, this.n, new com.byazt.gu.qg.n() { // from class: com.byazt.jm.s.3
                @Override // com.byazt.gu.qg.n
                public void n(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap bitmapN = fs.n(s.this.qg, bitmap, s.this.nk > 0.0f ? (int) s.this.nk : 10);
                    fs.n(new Runnable() { // from class: com.byazt.jm.s.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (bitmapN != null) {
                                ((RoundImageView) s.this.l).setBackground(new BitmapDrawable(s.this.qg.getResources(), bitmapN));
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final Bitmap bitmap, final String str) {
        fs.n(new Runnable() { // from class: com.byazt.jm.s.4
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap2;
                if (s.this.l == null || (bitmap2 = bitmap) == null || bitmap2.isRecycled() || !TextUtils.equals(s.this.n, str)) {
                    return;
                }
                ((RoundImageView) s.this.l).setImageBitmap(bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final Bitmap bitmap) {
        if ((!this.ei && this.nk <= 0.0f) || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        final String str = this.n;
        n.n().post(new Runnable() { // from class: com.byazt.jm.s.5
            @Override // java.lang.Runnable
            public void run() {
                final Bitmap bitmapN = fs.n(s.this.qg, bitmap, s.this.nk > 0.0f ? (int) s.this.nk : 10);
                if (bitmapN == null) {
                    return;
                }
                fs.n(new Runnable() { // from class: com.byazt.jm.s.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (s.this.l == null || !TextUtils.equals(s.this.n, str)) {
                            return;
                        }
                        ((RoundImageView) s.this.l).setBackground(new BitmapDrawable(s.this.qg.getResources(), bitmapN));
                    }
                });
            }
        });
    }

    private void ic() {
        if (this.wv != null) {
            this.wv.n();
        }
        final String str = this.n;
        String str2 = this.ze;
        final n.C0224n c0224n = this.qn;
        final boolean z = !TextUtils.isEmpty(str2);
        final int i = z ? 2 : 1;
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = new AtomicReference();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Runnable runnable = new Runnable() { // from class: com.byazt.jm.s.6
            @Override // java.lang.Runnable
            public void run() {
                if (atomicInteger.get() >= i && atomicBoolean.compareAndSet(false, true)) {
                    final Bitmap bitmap = (Bitmap) atomicReference.get();
                    Bitmap bitmap2 = (Bitmap) atomicReference2.get();
                    if (bitmap == null) {
                        if (s.this.wv != null) {
                            s.this.wv.qg(s.this, str);
                            return;
                        }
                        return;
                    }
                    if (s.this.wv != null) {
                        s.this.wv.n(s.this, str);
                    }
                    s.this.n(bitmap);
                    if (z && bitmap2 == null) {
                        s.this.n(bitmap, str);
                    } else {
                        n.n(bitmap, bitmap2, c0224n, new n.qg() { // from class: com.byazt.jm.s.6.1
                            @Override // com.byazt.jm.n.qg
                            public void n(Bitmap bitmap3) {
                                if (bitmap3 == null) {
                                    s.this.n(bitmap, str);
                                } else if (s.this.l != null && TextUtils.equals(s.this.n, str)) {
                                    ((RoundImageView) s.this.l).setImageBitmap(bitmap3);
                                } else {
                                    bitmap3.recycle();
                                }
                            }
                        });
                    }
                }
            }
        };
        w.n().qg().n(this.rv, str, new com.byazt.gu.qg.n() { // from class: com.byazt.jm.s.7
            @Override // com.byazt.gu.qg.n
            public void n(Bitmap bitmap) {
                atomicReference.set(bitmap);
                atomicInteger.incrementAndGet();
                runnable.run();
            }
        });
        if (z) {
            w.n().qg().n(this.rv, str2, new com.byazt.gu.qg.n() { // from class: com.byazt.jm.s.8
                @Override // com.byazt.gu.qg.n
                public void n(Bitmap bitmap) {
                    atomicReference2.set(bitmap);
                    atomicInteger.incrementAndGet();
                    runnable.run();
                }
            });
        }
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: fs, reason: merged with bridge method [inline-methods] */
    public RoundImageView n() {
        RoundImageView roundImageView = new RoundImageView(this.qg);
        roundImageView.n(this);
        return roundImageView;
    }

    public void qg(Drawable drawable) {
        ((RoundImageView) this.l).setImageDrawable(drawable);
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
            case "scaleType":
                this.sq = d(str2);
                break;
            case "imageBlur":
                this.o = com.byazt.hb.s.n(str2, -1.0f);
                break;
            case "eraseRadius":
                this.il = com.byazt.hb.s.n(str2, 50.0f);
                if (this.l != 0) {
                    ((RoundImageView) this.l).setEraseRadius(this.il);
                    break;
                }
                break;
            case "isBgGaussianBlur":
                this.ei = com.byazt.hb.s.n(str2, false);
                break;
            case "src":
                this.n = str2;
                break;
            case "erase":
                int iN = com.byazt.hb.s.n(str2, 0);
                this.bz = iN;
                if (iN == 1 && this.l != 0) {
                    ((RoundImageView) this.l).setEraseEnabled(true);
                    break;
                }
                break;
            case "maskImageSrc":
                this.ze = str2;
                break;
            case "tintColor":
                this.vo = com.byazt.hb.n.n(str2);
                break;
            case "imageBgBlur":
                this.nk = com.byazt.hb.s.n(str2, -1.0f);
                break;
            case "cropRect":
                this.qn = n.n(str2);
                break;
        }
    }

    private ImageView.ScaleType d(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fit":
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            default:
                return scaleType;
        }
    }

    @Override // com.byazt.ih.s, com.byazt.gu.l
    public void l() {
        super.l();
        ((RoundImageView) this.l).post(new Runnable() { // from class: com.byazt.jm.s.9
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = ((RoundImageView) s.this.l).getDrawable();
                if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
                    return;
                }
                ((AnimatedImageDrawable) drawable).start();
            }
        });
    }

    @Override // com.byazt.ih.s, com.byazt.gu.l
    public void w() {
        super.w();
        Drawable drawable = ((RoundImageView) this.l).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
            return;
        }
        ((AnimatedImageDrawable) drawable).stop();
    }

    @Override // com.byazt.ih.s, com.byazt.gu.l
    public void n(String str, Map<String, Object> map) {
        this.x = (com.byazt.ih.n) qg((com.byazt.ih.s) this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(v());
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        n(this.x, str, arrayList.toArray());
    }

    private void n(com.byazt.ih.s sVar, String str, Object... objArr) {
        List<com.byazt.ih.s<View>> listX;
        if (sVar == null) {
            return;
        }
        sVar.n(str, objArr);
        if (!(sVar instanceof com.byazt.ih.n) || (listX = ((com.byazt.ih.n) sVar).x()) == null || listX.isEmpty()) {
            return;
        }
        Iterator<com.byazt.ih.s<View>> it = listX.iterator();
        while (it.hasNext()) {
            n(it.next(), str, objArr);
        }
    }

    public String x() {
        return this.dm;
    }
}
