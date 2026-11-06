package com.bytedance.adsdk.ugeno.widget.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.c.d;
import com.bytedance.adsdk.ugeno.c.x;
import com.bytedance.adsdk.ugeno.xr.ah;
import com.bytedance.sdk.component.utils.sl;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ah<RoundImageView> {
    private int gs;
    protected boolean kl;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected String f411ms;
    private float nl;
    private float r;
    protected ImageView.ScaleType vf;

    public xr(Context context) {
        super(context);
        this.vf = ImageView.ScaleType.FIT_XY;
        this.gs = -1;
        this.r = -1.0f;
        this.nl = -1.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        x();
        ((RoundImageView) this.ka).setScaleType(this.vf);
        ((RoundImageView) this.ka).setBorderColor(this.s);
        ((RoundImageView) this.ka).setCornerRadius(this.eg);
        ((RoundImageView) this.ka).setBorderWidth(this.ti);
        if (this.gs != -1) {
            ((RoundImageView) this.ka).setColorFilter(this.gs);
        }
    }

    public void ny(String str) {
        this.f411ms = str;
    }

    private void x() {
        if (TextUtils.isEmpty(this.f411ms)) {
            return;
        }
        ((RoundImageView) this.ka).setImageDrawable(null);
        if (this.f411ms.startsWith("local://")) {
            try {
                ((RoundImageView) this.ka).setImageResource(d.ms(this.xr, this.f411ms.replace("local://", "")));
            } catch (Throwable unused) {
            }
        } else {
            if (this.f411ms.startsWith("@")) {
                try {
                    ((RoundImageView) this.ka).setImageResource(Integer.parseInt(this.f411ms.substring(1)));
                    return;
                } catch (Exception e) {
                    sl.ms(e);
                    return;
                }
            }
            am();
        }
    }

    private void am() {
        if (this.r > 0.0f) {
            com.bytedance.adsdk.ugeno.d.ms().xr().ms(this.ny, this.f411ms, new com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms() { // from class: com.bytedance.adsdk.ugeno.widget.image.xr.1
                @Override // com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms
                public void ms(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap bitmapMs = x.ms(xr.this.xr, bitmap, (int) xr.this.r);
                    if (bitmapMs != null) {
                        x.ms(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.xr.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((RoundImageView) xr.this.ka).setImageBitmap(bitmapMs);
                            }
                        });
                    }
                    if (xr.this.kl || xr.this.nl > 0.0f) {
                        Bitmap bitmapMs2 = x.ms(xr.this.xr, bitmap, xr.this.nl > 0.0f ? (int) xr.this.nl : 10);
                        if (bitmapMs2 != null) {
                            final BitmapDrawable bitmapDrawable = new BitmapDrawable(xr.this.xr.getResources(), bitmapMs2);
                            x.ms(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.xr.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((RoundImageView) xr.this.ka).setBackground(bitmapDrawable);
                                }
                            });
                        }
                    }
                }
            });
            return;
        }
        com.bytedance.adsdk.ugeno.d.ms().xr().ms(this.ny, this.f411ms, (ImageView) this.ka, ((RoundImageView) this.ka).getWidth(), ((RoundImageView) this.ka).getHeight());
        if (this.kl || this.nl > 0.0f) {
            com.bytedance.adsdk.ugeno.d.ms().xr().ms(this.ny, this.f411ms, new com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms() { // from class: com.bytedance.adsdk.ugeno.widget.image.xr.2
                @Override // com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms
                public void ms(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap bitmapMs = x.ms(xr.this.xr, bitmap, xr.this.nl > 0.0f ? (int) xr.this.nl : 10);
                    x.ms(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.xr.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (bitmapMs != null) {
                                ((RoundImageView) xr.this.ka).setBackground(new BitmapDrawable(xr.this.xr.getResources(), bitmapMs));
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: ab, reason: merged with bridge method [inline-methods] */
    public RoundImageView ms() {
        RoundImageView roundImageView = new RoundImageView(this.xr);
        roundImageView.ms(this);
        return roundImageView;
    }

    public void xr(Drawable drawable) {
        ((RoundImageView) this.ka).setImageDrawable(drawable);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.ms(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
            case "scaleType":
                this.vf = x(str2);
                break;
            case "imageBlur":
                this.r = com.bytedance.adsdk.ugeno.c.ah.ms(str2, -1.0f);
                break;
            case "isBgGaussianBlur":
                this.kl = com.bytedance.adsdk.ugeno.c.ah.ms(str2, false);
                break;
            case "src":
                this.f411ms = str2;
                break;
            case "tintColor":
                this.gs = com.bytedance.adsdk.ugeno.c.ms.ms(str2);
                break;
            case "imageBgBlur":
                this.nl = com.bytedance.adsdk.ugeno.c.ah.ms(str2, -1.0f);
                break;
        }
    }

    private ImageView.ScaleType x(String str) {
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

    @Override // com.bytedance.adsdk.ugeno.xr.ah, com.bytedance.adsdk.ugeno.ah
    public void ka() {
        super.ka();
        ((RoundImageView) this.ka).post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.image.xr.3
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = ((RoundImageView) xr.this.ka).getDrawable();
                if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
                    return;
                }
                ((AnimatedImageDrawable) drawable).start();
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah, com.bytedance.adsdk.ugeno.ah
    public void c() {
        super.c();
        Drawable drawable = ((RoundImageView) this.ka).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
            return;
        }
        ((AnimatedImageDrawable) drawable).stop();
    }
}
