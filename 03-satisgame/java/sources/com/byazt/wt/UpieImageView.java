package com.byazt.wt;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.ej.oa;
import com.byazt.pp.LottieAnimationView;
import com.byazt.pp.py;
import com.byazt.pp.q;
import com.byazt.pp.rv;
import com.byazt.ts.qg;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2, 1421})
public class UpieImageView extends FrameLayout {
    public long cp;
    public int fs;
    public Bitmap l;
    public final Context n;
    public String q;
    public ImageView qg;
    public int rv;
    public volatile LottieAnimationView s;
    public n tj;
    public final Map<String, Bitmap> w;
    public final Map<String, Integer> x;

    public static /* synthetic */ int fs(UpieImageView upieImageView) {
        int i = upieImageView.fs;
        upieImageView.fs = i + 1;
        return i;
    }

    public static /* synthetic */ int s(UpieImageView upieImageView) {
        int i = upieImageView.rv;
        upieImageView.rv = i + 1;
        return i;
    }

    public UpieImageView(Context context, com.byazt.ts.n nVar, oa oaVar, n nVar2) {
        super(context);
        this.w = new HashMap();
        this.x = new HashMap();
        this.fs = 0;
        this.rv = 0;
        this.n = context;
        this.tj = nVar2;
        n(nVar, oaVar, nVar2);
    }

    public synchronized void n(final com.byazt.ts.n nVar, oa oaVar, n nVar2) {
        if (nVar == null) {
            return;
        }
        if (this.s != null) {
            return;
        }
        this.tj = nVar2;
        final String strS = nVar.s();
        String strN = nVar.n();
        if (!TextUtils.isEmpty(strN)) {
            boolean z = !qg.n().n(strN);
            this.s = new LottieAnimationView(this.n);
            this.s.setVideoStats(oaVar);
            this.s.setRepeatCount(-1);
            this.s.setRepeatMode(1);
            this.s.setClickable(false);
            this.s.setMaintainOriginalImageBounds(z);
            this.s.setImageAssetDelegate(new q() { // from class: com.byazt.wt.UpieImageView.1
                @Override // com.byazt.pp.q
                public Bitmap n(rv rvVar) {
                    if (rvVar != null) {
                        String strOa = rvVar.oa();
                        if (!TextUtils.isEmpty(strOa)) {
                            if (strOa.startsWith("${") && strOa.endsWith("}")) {
                                strOa = com.byazt.oa.n.n(strOa, nVar.x());
                                if (TextUtils.isEmpty(strOa)) {
                                    return null;
                                }
                                if (TextUtils.equals(strS, strOa)) {
                                    return UpieImageView.this.l;
                                }
                            }
                            Bitmap bitmap = (Bitmap) UpieImageView.this.w.get(strOa);
                            if (bitmap != null) {
                                return bitmap;
                            }
                            UpieImageView.this.n(strOa, rvVar.n(), rvVar.qg());
                        }
                    }
                    return null;
                }
            });
            this.s.setTextDelegate(new py(this.s) { // from class: com.byazt.wt.UpieImageView.2
                @Override // com.byazt.pp.py
                public String n(String str) {
                    return com.byazt.oa.n.n(str, nVar.x());
                }
            });
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        ImageView imageView = new ImageView(this.n);
        this.qg = imageView;
        addView(imageView, layoutParams);
        if (this.s != null) {
            addView(this.s, layoutParams);
        }
        this.cp = SystemClock.elapsedRealtime();
        n(strN);
        qg(strS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final String str) {
        if (TextUtils.isEmpty(str)) {
            n(10000, "lottieJsonUrl为空");
        } else {
            com.byazt.oa.qg.s(new Runnable() { // from class: com.byazt.wt.UpieImageView.3
                @Override // java.lang.Runnable
                public void run() {
                    String strQg = qg.n().qg(str);
                    if (!TextUtils.isEmpty(strQg)) {
                        UpieImageView.this.n(strQg, str);
                    } else {
                        qg.n().n(str, new qg.n<String>() { // from class: com.byazt.wt.UpieImageView.3.1
                            @Override // com.byazt.ts.qg.n
                            public void n(String str2) {
                                UpieImageView.this.n(str2, str);
                            }

                            @Override // com.byazt.ts.qg.n
                            public void n(int i, String str2) {
                                if (i == 10006) {
                                    UpieImageView.this.n(i, str2);
                                    return;
                                }
                                UpieImageView.s(UpieImageView.this);
                                if (UpieImageView.this.rv <= 3) {
                                    UpieImageView.this.n(str);
                                } else {
                                    UpieImageView.this.n(i, str2);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(final String str) {
        if (TextUtils.isEmpty(str)) {
            new com.byazt.zsl.qg(60008, 10002, "广告主图url为空");
        } else {
            qg.n().qg(str, new qg.n<Bitmap>() { // from class: com.byazt.wt.UpieImageView.4
                @Override // com.byazt.ts.qg.n
                public void n(Bitmap bitmap) {
                    UpieImageView.this.l = bitmap;
                    final Bitmap bitmapN = com.byazt.cq.qg.n(UpieImageView.this.n, UpieImageView.this.l, 25);
                    com.byazt.oa.qg.qg(new Runnable() { // from class: com.byazt.wt.UpieImageView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (UpieImageView.this.s != null) {
                                UpieImageView.this.s.invalidate();
                            }
                            UpieImageView.this.qg.setImageBitmap(UpieImageView.this.l);
                            UpieImageView.this.qg.setScaleType(ImageView.ScaleType.FIT_CENTER);
                            if (bitmapN != null) {
                                UpieImageView.this.qg.setBackground(new BitmapDrawable(bitmapN));
                            }
                        }
                    });
                }

                @Override // com.byazt.ts.qg.n
                public void n(int i, String str2) {
                    UpieImageView.fs(UpieImageView.this);
                    if (UpieImageView.this.fs <= 3) {
                        UpieImageView.this.qg(str);
                    } else {
                        new com.byazt.zsl.qg(60008, 10003, "广告主图url加载失败");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final String str, final int i, final int i2) {
        Integer num = this.x.get(str);
        if (num == null || num.intValue() != 1) {
            this.x.put(str, 1);
            this.s.n(str, new com.byazt.vk.rv() { // from class: com.byazt.wt.UpieImageView.5
                @Override // com.byazt.vk.rv
                public void n(Bitmap bitmap) {
                    UpieImageView.this.n(bitmap, str, i, i2);
                }

                @Override // com.byazt.vk.rv
                public void n() {
                    qg.n().n(UpieImageView.this.n, str, new qg.n<Bitmap>() { // from class: com.byazt.wt.UpieImageView.5.1
                        @Override // com.byazt.ts.qg.n
                        public void n(Bitmap bitmap) {
                            UpieImageView.this.n(bitmap, str, i, i2);
                        }

                        @Override // com.byazt.ts.qg.n
                        public void n(int i3, String str2) {
                            UpieImageView.this.x.put(str, 2);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Bitmap bitmap, String str, int i, int i2) {
        if (bitmap != null) {
            this.w.put(str, bitmap);
            com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.wt.UpieImageView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (UpieImageView.this.s != null) {
                        UpieImageView.this.s.invalidate();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str) {
        n nVar = this.tj;
        if (nVar != null) {
            nVar.n(i, str);
        }
        com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.wt.UpieImageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (UpieImageView.this.s != null) {
                    UpieImageView upieImageView = UpieImageView.this;
                    upieImageView.removeView(upieImageView.s);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j) {
        if (this.tj != null) {
            HashMap map = new HashMap();
            map.put(MediationConstant.EXTRA_DURATION, Long.valueOf(j - this.cp));
            this.tj.n(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final String str, final String str2) {
        this.q = str;
        com.byazt.oa.qg.n(new Runnable() { // from class: com.byazt.wt.UpieImageView.8
            @Override // java.lang.Runnable
            public void run() {
                if (UpieImageView.this.s != null) {
                    UpieImageView.this.s.n(str, str2);
                    UpieImageView.this.s.n(new Animator.AnimatorListener() { // from class: com.byazt.wt.UpieImageView.8.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            UpieImageView.this.s.qg(this);
                            UpieImageView.this.n(SystemClock.elapsedRealtime());
                        }
                    });
                    UpieImageView.this.s.n();
                }
            }
        });
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            if (this.s != null) {
                this.s.setScaleType(scaleType);
                return;
            }
            ImageView imageView = this.qg;
            if (imageView != null) {
                imageView.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.s == null || this.q == null) {
            return;
        }
        this.s.n();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.s != null) {
            this.s.w();
        }
    }
}
