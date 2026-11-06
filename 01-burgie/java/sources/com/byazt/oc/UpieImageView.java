package com.byazt.oc;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.dx.LottieAnimationView;
import com.byazt.dx.aj;
import com.byazt.dx.cz;
import com.byazt.dx.x;
import com.byazt.n.hn;
import com.byazt.n.hw;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2, 1297})
public class UpieImageView extends FrameLayout {
    public int aj;
    public Bitmap c;
    public final Map<String, Integer> fw;
    public volatile LottieAnimationView hn;
    public ImageView hw;
    public final Context pr;
    public final Map<String, Bitmap> uc;
    public pr vk;
    public long w;
    public String x;
    public int zo;

    public static /* synthetic */ int hn(UpieImageView upieImageView) {
        int i = upieImageView.aj;
        upieImageView.aj = i + 1;
        return i;
    }

    public static /* synthetic */ int zo(UpieImageView upieImageView) {
        int i = upieImageView.zo;
        upieImageView.zo = i + 1;
        return i;
    }

    public UpieImageView(Context context, com.byazt.ic.pr prVar, hw hwVar, pr prVar2) {
        super(context);
        this.uc = new HashMap();
        this.fw = new HashMap();
        this.zo = 0;
        this.aj = 0;
        this.pr = context;
        this.vk = prVar2;
        pr(prVar, hwVar, prVar2);
    }

    public synchronized void pr(final com.byazt.ic.pr prVar, hw hwVar, pr prVar2) {
        if (prVar == null) {
            return;
        }
        if (this.hn != null) {
            return;
        }
        this.vk = prVar2;
        final String strHn = prVar.hn();
        String strPr = prVar.pr();
        if (!TextUtils.isEmpty(strPr)) {
            this.hn = new LottieAnimationView(this.pr);
            this.hn.setVideoStats(hwVar);
            this.hn.setRepeatCount(-1);
            this.hn.setRepeatMode(1);
            this.hn.setClickable(false);
            this.hn.setImageAssetDelegate(new x() { // from class: com.byazt.oc.UpieImageView.1
                @Override // com.byazt.dx.x
                public Bitmap pr(aj ajVar) {
                    if (ajVar != null) {
                        String strM = ajVar.m();
                        if (!TextUtils.isEmpty(strM)) {
                            if (strM.startsWith("${") && strM.endsWith("}")) {
                                strM = com.byazt.rhv.pr.pr(strM, prVar.fw());
                                if (TextUtils.isEmpty(strM)) {
                                    return null;
                                }
                                if (TextUtils.equals(strHn, strM)) {
                                    Bitmap bitmap = UpieImageView.this.c;
                                    if (bitmap != null && (bitmap.getWidth() != ajVar.pr() || bitmap.getHeight() != ajVar.hw())) {
                                        UpieImageView.this.c = Bitmap.createScaledBitmap(bitmap, ajVar.pr(), ajVar.hw(), false);
                                    }
                                    return UpieImageView.this.c;
                                }
                            }
                            Bitmap bitmap2 = (Bitmap) UpieImageView.this.uc.get(strM);
                            if (bitmap2 == null) {
                                UpieImageView.this.pr(strM, ajVar.pr(), ajVar.hw());
                            } else {
                                return bitmap2;
                            }
                        }
                    }
                    return null;
                }
            });
            this.hn.setTextDelegate(new cz(this.hn) { // from class: com.byazt.oc.UpieImageView.2
                @Override // com.byazt.dx.cz
                public String pr(String str) {
                    return com.byazt.rhv.pr.pr(str, prVar.fw());
                }
            });
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        ImageView imageView = new ImageView(this.pr);
        this.hw = imageView;
        addView(imageView, layoutParams);
        if (this.hn != null) {
            addView(this.hn, layoutParams);
        }
        this.w = SystemClock.elapsedRealtime();
        pr(strPr);
        hw(strHn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final String str) {
        if (TextUtils.isEmpty(str)) {
            pr(10000, "lottieJsonUrl为空");
        } else {
            com.byazt.rhv.hw.hn(new Runnable() { // from class: com.byazt.oc.UpieImageView.3
                @Override // java.lang.Runnable
                public void run() {
                    String strPr = com.byazt.ic.hw.pr().pr(str);
                    if (!TextUtils.isEmpty(strPr)) {
                        UpieImageView.this.pr(strPr, str);
                    } else {
                        com.byazt.ic.hw.pr().pr(str, new com.byazt.ic.hw.pr<String>() { // from class: com.byazt.oc.UpieImageView.3.1
                            @Override // com.byazt.ic.hw.pr
                            public void pr(String str2) {
                                UpieImageView.this.pr(str2, str);
                            }

                            @Override // com.byazt.ic.hw.pr
                            public void pr(int i, String str2) {
                                if (i == 10006) {
                                    UpieImageView.this.pr(i, str2);
                                    return;
                                }
                                UpieImageView.hn(UpieImageView.this);
                                if (UpieImageView.this.aj <= 3) {
                                    UpieImageView.this.pr(str);
                                } else {
                                    UpieImageView.this.pr(i, str2);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(final String str) {
        if (TextUtils.isEmpty(str)) {
            new hn(60008, AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS, "广告主图url为空");
        } else {
            com.byazt.ic.hw.pr().hw(str, new com.byazt.ic.hw.pr<Bitmap>() { // from class: com.byazt.oc.UpieImageView.4
                @Override // com.byazt.ic.hw.pr
                public void pr(Bitmap bitmap) {
                    UpieImageView.this.c = bitmap;
                    final Bitmap bitmapPr = com.byazt.js.hw.pr(UpieImageView.this.pr, UpieImageView.this.c, 25);
                    com.byazt.rhv.hw.hw(new Runnable() { // from class: com.byazt.oc.UpieImageView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (UpieImageView.this.hn != null) {
                                UpieImageView.this.hn.invalidate();
                            }
                            UpieImageView.this.hw.setImageBitmap(UpieImageView.this.c);
                            UpieImageView.this.hw.setScaleType(ImageView.ScaleType.FIT_CENTER);
                            if (bitmapPr != null) {
                                UpieImageView.this.hw.setBackground(new BitmapDrawable(bitmapPr));
                            }
                        }
                    });
                }

                @Override // com.byazt.ic.hw.pr
                public void pr(int i, String str2) {
                    UpieImageView.zo(UpieImageView.this);
                    if (UpieImageView.this.zo <= 3) {
                        UpieImageView.this.hw(str);
                    } else {
                        new hn(60008, AVMDLDataLoader.KeyIsStoRingBufferSizeKB, "广告主图url加载失败");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final String str, final int i, final int i2) {
        Integer num = this.fw.get(str);
        if (num == null || num.intValue() != 1) {
            this.fw.put(str, 1);
            this.hn.pr(str, new com.byazt.rwn.aj() { // from class: com.byazt.oc.UpieImageView.5
                @Override // com.byazt.rwn.aj
                public void pr(Bitmap bitmap) {
                    UpieImageView.this.pr(bitmap, str, i, i2);
                }

                @Override // com.byazt.rwn.aj
                public void pr() {
                    com.byazt.ic.hw.pr().pr(UpieImageView.this.pr, str, new com.byazt.ic.hw.pr<Bitmap>() { // from class: com.byazt.oc.UpieImageView.5.1
                        @Override // com.byazt.ic.hw.pr
                        public void pr(Bitmap bitmap) {
                            UpieImageView.this.pr(bitmap, str, i, i2);
                        }

                        @Override // com.byazt.ic.hw.pr
                        public void pr(int i3, String str2) {
                            UpieImageView.this.fw.put(str, 2);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Bitmap bitmap, String str, int i, int i2) {
        if (bitmap != null) {
            if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
            }
            this.uc.put(str, bitmap);
            com.byazt.rhv.hw.pr(new Runnable() { // from class: com.byazt.oc.UpieImageView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (UpieImageView.this.hn != null) {
                        UpieImageView.this.hn.invalidate();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, String str) {
        pr prVar = this.vk;
        if (prVar != null) {
            prVar.pr(i, str);
        }
        com.byazt.rhv.hw.pr(new Runnable() { // from class: com.byazt.oc.UpieImageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (UpieImageView.this.hn != null) {
                    UpieImageView upieImageView = UpieImageView.this;
                    upieImageView.removeView(upieImageView.hn);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(long j) {
        if (this.vk != null) {
            HashMap map = new HashMap();
            map.put("duration", Long.valueOf(j - this.w));
            this.vk.pr(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final String str, final String str2) {
        this.x = str;
        com.byazt.rhv.hw.pr(new Runnable() { // from class: com.byazt.oc.UpieImageView.8
            @Override // java.lang.Runnable
            public void run() {
                if (UpieImageView.this.hn != null) {
                    UpieImageView.this.hn.pr(str, str2);
                    UpieImageView.this.hn.pr(new Animator.AnimatorListener() { // from class: com.byazt.oc.UpieImageView.8.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            UpieImageView.this.hn.hw(this);
                            UpieImageView.this.pr(SystemClock.elapsedRealtime());
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    UpieImageView.this.hn.pr();
                }
            }
        });
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            if (this.hn != null) {
                this.hn.setScaleType(scaleType);
                return;
            }
            ImageView imageView = this.hw;
            if (imageView != null) {
                imageView.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.hn != null && this.x != null) {
            this.hn.pr();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.hn != null) {
            this.hn.uc();
        }
    }
}
