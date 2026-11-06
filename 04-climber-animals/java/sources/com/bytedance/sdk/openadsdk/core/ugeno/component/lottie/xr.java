package com.bytedance.sdk.openadsdk.core.ugeno.component.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.d;
import com.bytedance.adsdk.lottie.ny;
import com.bytedance.adsdk.ugeno.c.x;
import com.bytedance.adsdk.ugeno.xr.ah;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ah<UgenLottieView> {
    private int cc;
    private boolean cj;
    protected ImageView.ScaleType gs;
    protected ImageView.ScaleType kl;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected String f3472ms;
    private boolean nl;

    @Deprecated
    private boolean qo;
    private String r;
    private float si;
    protected HashMap<String, Bitmap> vf;
    private float wq;

    public xr(Context context) {
        super(context);
        this.r = "images";
        this.si = 1.0f;
        this.kl = ImageView.ScaleType.FIT_CENTER;
        this.gs = ImageView.ScaleType.FIT_XY;
        this.vf = new HashMap<>();
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: ab, reason: merged with bridge method [inline-methods] */
    public UgenLottieView ms() {
        UgenLottieView ugenLottieView = new UgenLottieView(this.xr);
        ugenLottieView.ms(this);
        return ugenLottieView;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        ((UgenLottieView) this.ka).setProgress(this.wq);
        if (this.si <= 0.0f) {
            this.si = 1.0f;
        }
        ((UgenLottieView) this.ka).setSpeed(this.si);
        if (this.f3472ms.startsWith("local")) {
            ((UgenLottieView) this.ka).setAnimation(x(this.f3472ms));
            ((UgenLottieView) this.ka).setImageAssetsFolder(this.r);
        } else {
            ((UgenLottieView) this.ka).setAnimationFromUrl(this.f3472ms);
        }
        ((UgenLottieView) this.ka).setImageAssetDelegate(new AnonymousClass1());
        if (cv()) {
            ((UgenLottieView) this.ka).setScaleType(this.gs);
        } else {
            ((UgenLottieView) this.ka).setScaleType(this.kl);
        }
        if (cv()) {
            ((UgenLottieView) this.ka).setRepeatCount(this.cc);
        } else {
            ((UgenLottieView) this.ka).ms(this.qo);
        }
        x();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xr$1, reason: invalid class name */
    class AnonymousClass1 implements d {
        AnonymousClass1() {
        }

        @Override // com.bytedance.adsdk.lottie.d
        public Bitmap ms(final ny nyVar) {
            final String strMs;
            if (nyVar == null) {
                return null;
            }
            String strZb = nyVar.zb();
            String strSl = nyVar.sl();
            if (!TextUtils.isEmpty(strZb) && TextUtils.isEmpty(strSl)) {
                strMs = com.bytedance.adsdk.ugeno.d.xr.ms(strZb, xr.this.d);
            } else if (!TextUtils.isEmpty(strSl) && TextUtils.isEmpty(strZb)) {
                strMs = com.bytedance.adsdk.ugeno.d.xr.ms(strSl, xr.this.d);
            } else {
                strMs = (TextUtils.isEmpty(strSl) || TextUtils.isEmpty(strZb)) ? null : com.bytedance.adsdk.ugeno.d.xr.ms(strZb, xr.this.d) + com.bytedance.adsdk.ugeno.d.xr.ms(strSl, xr.this.d);
            }
            if (TextUtils.isEmpty(strMs)) {
                return null;
            }
            Bitmap bitmap = xr.this.vf.get(strMs);
            if (bitmap != null) {
                return bitmap;
            }
            com.bytedance.adsdk.ugeno.d.ms().xr().ms(xr.this.ny, strMs, new com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xr.1.1
                @Override // com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms
                public void ms(Bitmap bitmap2) {
                    if (bitmap2 != null) {
                        final Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, nyVar.ms(), nyVar.xr(), false);
                        xr.this.vf.put(strMs, bitmapCreateScaledBitmap);
                        x.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xr.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((UgenLottieView) xr.this.ka).ms(nyVar.hi(), bitmapCreateScaledBitmap);
                            }
                        });
                    }
                }
            });
            return xr.this.vf.get(strMs);
        }
    }

    protected void x() {
        ((UgenLottieView) this.ka).ms();
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.ms(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
                this.gs = ch(str2);
                break;
            case "scaleType":
                this.kl = ny(str2);
                break;
            case "progress":
                this.wq = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                break;
            case "imagePath":
                this.r = str2;
                break;
            case "autoReverse":
                this.nl = com.bytedance.adsdk.ugeno.c.ah.ms(str2, false);
                break;
            case "src":
                this.f3472ms = str2;
                break;
            case "loop":
                if (cv()) {
                    this.cc = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0);
                    break;
                } else {
                    this.qo = com.bytedance.adsdk.ugeno.c.ah.ms(str2, false);
                    break;
                }
                break;
            case "speed":
                this.si = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 1.0f);
                break;
            case "autoPlay":
                this.cj = com.bytedance.adsdk.ugeno.c.ah.ms(str2, false);
                break;
            case "autoplay":
                this.cj = com.bytedance.adsdk.ugeno.c.ah.ms(str2, true);
                break;
        }
    }

    private String x(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("local")) {
            return "";
        }
        if (str.contains("shake_phone")) {
            return "lottie_json/shake_phone.json";
        }
        return str.contains("swipe_right") ? "lottie_json/swipe_right.json" : "";
    }

    private ImageView.ScaleType ny(String str) {
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
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    private ImageView.ScaleType ch(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
            case "none":
                return ImageView.ScaleType.CENTER;
            case "fit":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
                return ImageView.ScaleType.FIT_XY;
            default:
                return scaleType;
        }
    }
}
