package com.byazt.qs;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.aa.zo;
import com.byazt.dx.aj;
import com.byazt.dx.x;
import com.byazt.gu.fw;
import com.byazt.llk.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.compliance.internal.TapComplianceSettings;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 670, 13})
public class hw extends com.byazt.ik.hn<UgenLottieView> {
    public HashMap<String, Bitmap> fe;
    public boolean fs;
    public final Map<String, Integer> ks;

    @Deprecated
    public boolean ku;
    public boolean p;
    public String pr;
    public String qx;
    public ImageView.ScaleType sr;
    public float sx;
    public float uk;
    public ImageView.ScaleType wz;
    public String xb;
    public int xg;

    public hw(Context context) {
        super(context);
        this.xb = "images";
        this.uk = 1.0f;
        this.ks = new ConcurrentHashMap();
        this.sr = ImageView.ScaleType.FIT_CENTER;
        this.wz = ImageView.ScaleType.FIT_XY;
        this.fe = new HashMap<>();
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: fw, reason: merged with bridge method [inline-methods] */
    public UgenLottieView pr() {
        UgenLottieView ugenLottieView = new UgenLottieView(this.hw);
        ugenLottieView.pr(this);
        return ugenLottieView;
    }

    @Override // com.byazt.ik.hn
    public void hw() {
        super.hw();
        if (this.aj != null) {
            ((UgenLottieView) this.c).setTriggerScenarioId(this.aj.x());
        }
        ((UgenLottieView) this.c).setProgress(this.sx);
        if (this.uk <= 0.0f) {
            this.uk = 1.0f;
        }
        ((UgenLottieView) this.c).setSpeed(this.uk);
        ((UgenLottieView) this.c).setAutoPlay(this.fs);
        ((UgenLottieView) this.c).setImageAssetDelegate(new AnonymousClass1());
        if (nl()) {
            ((UgenLottieView) this.c).setScaleType(this.wz);
        } else {
            ((UgenLottieView) this.c).setScaleType(this.sr);
        }
        if (nl()) {
            ((UgenLottieView) this.c).setRepeatCount(this.xg);
        } else {
            ((UgenLottieView) this.c).pr(this.ku);
        }
        zo();
    }

    /* JADX INFO: renamed from: com.byazt.qs.hw$1, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, 670, MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK})
    public class AnonymousClass1 implements x {
        public AnonymousClass1() {
        }

        @Override // com.byazt.dx.x
        public Bitmap pr(final aj ajVar) {
            final String strPr;
            if (ajVar == null) {
                return null;
            }
            String strG = ajVar.g();
            String strM = ajVar.m();
            if (!TextUtils.isEmpty(strG) && TextUtils.isEmpty(strM)) {
                strPr = com.byazt.tn.hw.pr(strG, hw.this.x);
            } else if (!TextUtils.isEmpty(strM) && TextUtils.isEmpty(strG)) {
                strPr = com.byazt.tn.hw.pr(strM, hw.this.x);
            } else {
                strPr = (TextUtils.isEmpty(strM) || TextUtils.isEmpty(strG)) ? null : com.byazt.tn.hw.pr(strG, hw.this.x) + com.byazt.tn.hw.pr(strM, hw.this.x);
            }
            if (TextUtils.isEmpty(strPr)) {
                return null;
            }
            Bitmap bitmap = hw.this.fe.get(strPr);
            if (bitmap != null) {
                return bitmap;
            }
            Integer num = hw.this.ks.get(strPr);
            if (num == null || num.intValue() == 2) {
                hw.this.ks.put(strPr, 1);
            } else if (num.intValue() == 1) {
                return null;
            }
            ((UgenLottieView) hw.this.c).pr(strPr, new com.byazt.rwn.aj() { // from class: com.byazt.qs.hw.1.1
                @Override // com.byazt.rwn.aj
                public void pr(Bitmap bitmap2) {
                    hw.this.pr(ajVar, strPr, bitmap2);
                }

                @Override // com.byazt.rwn.aj
                public void pr() {
                    uc.pr().hw().pr(hw.this.aj, strPr, new com.byazt.llk.hw.pr() { // from class: com.byazt.qs.hw.1.1.1
                        @Override // com.byazt.llk.hw.pr
                        public void pr(Bitmap bitmap2) {
                            hw.this.pr(ajVar, strPr, bitmap2);
                        }
                    });
                }
            });
            return hw.this.fe.get(strPr);
        }
    }

    public void lv() {
        if (this.pr.startsWith(TapComplianceSettings.STRATEGY_LOCAL)) {
            ((UgenLottieView) this.c).setAnimation(w(this.pr));
            ((UgenLottieView) this.c).setImageAssetsFolder(this.xb);
            return;
        }
        String str = this.qx;
        if (str == null) {
            ((UgenLottieView) this.c).setAnimationFromUrl(this.pr);
        } else if (TextUtils.equals("", str)) {
            ((UgenLottieView) this.c).hw(this.pr, (String) null);
        } else {
            ((UgenLottieView) this.c).hw(this.pr, this.qx);
        }
    }

    public void zo() {
        lv();
        ((UgenLottieView) this.c).pr();
    }

    public void pr(final aj ajVar, String str, Bitmap bitmap) {
        if (bitmap != null) {
            final Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, ajVar.pr(), ajVar.hw(), false);
            this.fe.put(str, bitmapCreateScaledBitmap);
            this.ks.remove(str);
            zo.pr(new Runnable() { // from class: com.byazt.qs.hw.2
                @Override // java.lang.Runnable
                public void run() {
                    ((UgenLottieView) hw.this.c).pr(ajVar.k(), bitmapCreateScaledBitmap);
                }
            });
            pr(str, true);
            return;
        }
        this.ks.put(str, 2);
        pr(str, false);
    }

    private void pr(String str, boolean z) {
        Map<String, Object> mapHw;
        if (this.aj == null || TextUtils.isEmpty(str) || (mapHw = this.aj.hw()) == null || mapHw.isEmpty()) {
            return;
        }
        Object obj = mapHw.get("ugen_v3_render");
        if (!(obj instanceof WeakReference)) {
            return;
        }
        Object obj2 = ((WeakReference) obj).get();
        if (!(obj2 instanceof fw)) {
            return;
        }
        try {
            ((fw) obj2).pr(str, z);
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.pr(str, str2);
        switch (str) {
            case "src":
                this.pr = str2;
                break;
            case "md5":
                this.qx = str2;
                break;
            case "autoReverse":
                this.p = com.byazt.aa.hn.pr(str2, false);
                break;
            case "progress":
                this.sx = com.byazt.aa.hn.pr(str2, 0.0f);
                break;
            case "speed":
                this.uk = com.byazt.aa.hn.pr(str2, 1.0f);
                break;
            case "imagePath":
                this.xb = str2;
                break;
            case "loop":
                if (nl()) {
                    this.xg = com.byazt.aa.hn.pr(str2, 0);
                    break;
                } else {
                    this.ku = com.byazt.aa.hn.pr(str2, false);
                    break;
                }
                break;
            case "autoPlay":
                this.fs = com.byazt.aa.hn.pr(str2, false);
                break;
            case "autoplay":
                this.fs = com.byazt.aa.hn.pr(str2, true);
                break;
            case "scaleType":
                this.sr = k(str2);
                break;
            case "scaleMode":
                this.wz = m(str2);
                break;
        }
    }

    private String w(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(TapComplianceSettings.STRATEGY_LOCAL)) {
            return "";
        }
        if (str.contains("shake_phone")) {
            return "lottie_json/shake_phone.json";
        }
        return str.contains("swipe_right") ? "lottie_json/swipe_right.json" : "";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    private ImageView.ScaleType k(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        switch (str) {
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "center":
                return ImageView.ScaleType.CENTER;
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            default:
                return scaleType;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003c  */
    private ImageView.ScaleType m(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        switch (str) {
            case "fill":
                return ImageView.ScaleType.FIT_XY;
            case "fit":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
                return ImageView.ScaleType.CENTER_CROP;
            case "none":
            case "center":
                return ImageView.ScaleType.CENTER;
            default:
                return scaleType;
        }
    }

    public void pr(AnimatorListenerAdapter animatorListenerAdapter) {
        ((UgenLottieView) this.c).pr(animatorListenerAdapter);
    }

    public void od() {
        if (this.c != 0) {
            ((UgenLottieView) this.c).pr();
        }
    }
}
