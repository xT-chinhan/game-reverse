package com.bytedance.sdk.openadsdk.upie.image.lottie;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.d;
import com.bytedance.adsdk.lottie.ny;
import com.bytedance.adsdk.lottie.t;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.upie.ms.xr;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UpieImageView extends FrameLayout {
    private final Map<String, Integer> ab;
    private volatile LottieAnimationView ah;
    private final Map<String, Bitmap> c;
    private ms ch;
    private String d;
    private long hi;
    private Bitmap ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Context f4223ms;
    private int ny;
    private int x;
    private ImageView xr;

    static /* synthetic */ int ah(UpieImageView upieImageView) {
        int i = upieImageView.ny;
        upieImageView.ny = i + 1;
        return i;
    }

    static /* synthetic */ int x(UpieImageView upieImageView) {
        int i = upieImageView.x;
        upieImageView.x = i + 1;
        return i;
    }

    public UpieImageView(Context context, com.bytedance.sdk.openadsdk.upie.ms msVar, ms msVar2) {
        super(context);
        this.c = new HashMap();
        this.ab = new HashMap();
        this.x = 0;
        this.ny = 0;
        this.f4223ms = context;
        this.ch = msVar2;
        ms(msVar, msVar2);
    }

    public synchronized void ms(final com.bytedance.sdk.openadsdk.upie.ms msVar, ms msVar2) {
        if (msVar == null) {
            return;
        }
        if (this.ah != null) {
            return;
        }
        this.ch = msVar2;
        final String strAh = msVar.ah();
        String strMs = msVar.ms();
        if (!TextUtils.isEmpty(strMs)) {
            this.ah = new LottieAnimationView(this.f4223ms);
            this.ah.setRepeatCount(-1);
            this.ah.setRepeatMode(1);
            this.ah.setClickable(false);
            this.ah.setImageAssetDelegate(new d() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.1
                @Override // com.bytedance.adsdk.lottie.d
                public Bitmap ms(ny nyVar) {
                    if (nyVar != null) {
                        String strSl = nyVar.sl();
                        if (!TextUtils.isEmpty(strSl)) {
                            if (strSl.startsWith("${") && strSl.endsWith("}")) {
                                strSl = com.bytedance.sdk.openadsdk.upie.ms.ms.ms(strSl, msVar.ab());
                                if (TextUtils.isEmpty(strSl)) {
                                    return null;
                                }
                                if (TextUtils.equals(strAh, strSl)) {
                                    Bitmap bitmap = UpieImageView.this.ka;
                                    if (bitmap != null && (bitmap.getWidth() != nyVar.ms() || bitmap.getHeight() != nyVar.xr())) {
                                        UpieImageView.this.ka = Bitmap.createScaledBitmap(bitmap, nyVar.ms(), nyVar.xr(), false);
                                    }
                                    return UpieImageView.this.ka;
                                }
                            }
                            Bitmap bitmap2 = (Bitmap) UpieImageView.this.c.get(strSl);
                            if (bitmap2 != null) {
                                return bitmap2;
                            }
                            UpieImageView.this.ms(strSl, nyVar.ms(), nyVar.xr());
                        }
                    }
                    return null;
                }
            });
            this.ah.setTextDelegate(new t(this.ah) { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.2
                @Override // com.bytedance.adsdk.lottie.t
                public String ms(String str) {
                    return com.bytedance.sdk.openadsdk.upie.ms.ms.ms(str, msVar.ab());
                }
            });
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        ImageView imageView = new ImageView(this.f4223ms);
        this.xr = imageView;
        addView(imageView, layoutParams);
        if (this.ah != null) {
            addView(this.ah, layoutParams);
        }
        this.hi = SystemClock.elapsedRealtime();
        ms(strMs);
        xr(strAh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final String str) {
        if (TextUtils.isEmpty(str)) {
            ms(10000, "lottieJsonUrl为空");
        } else {
            xr.ah(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.3
                @Override // java.lang.Runnable
                public void run() {
                    String strMs = com.bytedance.sdk.openadsdk.upie.xr.ms().ms(str);
                    if (!TextUtils.isEmpty(strMs)) {
                        UpieImageView.this.ms(strMs, str);
                    } else {
                        com.bytedance.sdk.openadsdk.upie.xr.ms().ms(str, new com.bytedance.sdk.openadsdk.upie.xr.ms<String>() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.3.1
                            @Override // com.bytedance.sdk.openadsdk.upie.xr.ms
                            public void ms(String str2) {
                                sl.ms("UpieImageView", "--==-- lottie jsonStr ok");
                                UpieImageView.this.ms(str2, str);
                            }

                            @Override // com.bytedance.sdk.openadsdk.upie.xr.ms
                            public void ms(int i, String str2) {
                                sl.ms("UpieImageView", "--==-- lottie jsonStr load fail: " + i + ", " + str2);
                                if (i == 10006) {
                                    UpieImageView.this.ms(i, str2);
                                    return;
                                }
                                UpieImageView.ah(UpieImageView.this);
                                if (UpieImageView.this.ny <= 3) {
                                    UpieImageView.this.ms(str);
                                } else {
                                    UpieImageView.this.ms(i, str2);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(final String str) {
        if (TextUtils.isEmpty(str)) {
            new com.bykv.vk.openvk.component.video.api.ah.xr(60008, AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS, "广告主图url为空");
        } else {
            com.bytedance.sdk.openadsdk.upie.xr.ms().xr(str, new com.bytedance.sdk.openadsdk.upie.xr.ms<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.4
                @Override // com.bytedance.sdk.openadsdk.upie.xr.ms
                public void ms(Bitmap bitmap) {
                    UpieImageView.this.ka = bitmap;
                    final Bitmap bitmapMs = com.bytedance.sdk.component.adexpress.d.xr.ms(UpieImageView.this.f4223ms, UpieImageView.this.ka, 25);
                    xr.xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (UpieImageView.this.ah != null) {
                                UpieImageView.this.ah.invalidate();
                            }
                            UpieImageView.this.xr.setImageBitmap(UpieImageView.this.ka);
                            UpieImageView.this.xr.setScaleType(ImageView.ScaleType.FIT_CENTER);
                            if (bitmapMs != null) {
                                UpieImageView.this.xr.setBackground(new BitmapDrawable(bitmapMs));
                            }
                        }
                    });
                }

                @Override // com.bytedance.sdk.openadsdk.upie.xr.ms
                public void ms(int i, String str2) {
                    UpieImageView.x(UpieImageView.this);
                    if (UpieImageView.this.x <= 3) {
                        UpieImageView.this.xr(str);
                    } else {
                        new com.bykv.vk.openvk.component.video.api.ah.xr(60008, AVMDLDataLoader.KeyIsStoRingBufferSizeKB, "广告主图url加载失败");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final String str, final int i, final int i2) {
        Integer num = this.ab.get(str);
        if (num == null || num.intValue() != 1) {
            this.ab.put(str, 1);
            com.bytedance.sdk.openadsdk.upie.xr.ms().ms(this.f4223ms, str, new com.bytedance.sdk.openadsdk.upie.xr.ms<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.5
                @Override // com.bytedance.sdk.openadsdk.upie.xr.ms
                public void ms(Bitmap bitmap) {
                    if (bitmap != null) {
                        if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                            bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                        }
                        UpieImageView.this.c.put(str, bitmap);
                        xr.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UpieImageView.this.ah != null) {
                                    UpieImageView.this.ah.invalidate();
                                }
                            }
                        });
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.upie.xr.ms
                public void ms(int i3, String str2) {
                    UpieImageView.this.ab.put(str, 2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, String str) {
        ms msVar = this.ch;
        if (msVar != null) {
            msVar.ms(i, str);
        }
        xr.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.6
            @Override // java.lang.Runnable
            public void run() {
                if (UpieImageView.this.ah != null) {
                    UpieImageView upieImageView = UpieImageView.this;
                    upieImageView.removeView(upieImageView.ah);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(long j) {
        if (this.ch != null) {
            HashMap map = new HashMap();
            map.put("duration", Long.valueOf(j - this.hi));
            this.ch.ms(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final String str, final String str2) {
        this.d = str;
        xr.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (UpieImageView.this.ah != null) {
                    UpieImageView.this.ah.ms(str, str2);
                    UpieImageView.this.ah.ms(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView.7.1
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
                            UpieImageView.this.ah.xr(this);
                            UpieImageView.this.ms(SystemClock.elapsedRealtime());
                        }
                    });
                    UpieImageView.this.ah.ms();
                }
            }
        });
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            if (this.ah != null) {
                this.ah.setScaleType(scaleType);
                return;
            }
            ImageView imageView = this.xr;
            if (imageView != null) {
                imageView.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ah == null || this.d == null) {
            return;
        }
        this.ah.ms();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ah != null) {
            this.ah.c();
        }
    }
}
