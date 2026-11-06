package com.byazt.kru;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.gu.w;
import com.byazt.hb.fs;
import com.byazt.pp.q;
import com.byazt.pp.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME, 26})
public class qg extends com.byazt.ih.s<UgenLottieView> {
    public int bz;
    public final Map<String, Integer> dm;
    public HashMap<String, Bitmap> ei;
    public boolean il;
    public float la;
    public String n;
    public String nk;
    public ImageView.ScaleType o;
    public float qh;

    @Deprecated
    public boolean qn;
    public String sq;
    public ImageView.ScaleType vo;
    public boolean ze;

    public qg(Context context) {
        super(context);
        this.nk = "images";
        this.qh = 1.0f;
        this.dm = new ConcurrentHashMap();
        this.vo = ImageView.ScaleType.FIT_CENTER;
        this.o = ImageView.ScaleType.FIT_XY;
        this.ei = new HashMap<>();
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public UgenLottieView n() {
        UgenLottieView ugenLottieView = new UgenLottieView(this.qg);
        ugenLottieView.n(this);
        return ugenLottieView;
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
        if (this.rv != null) {
            ((UgenLottieView) this.l).setTriggerScenarioId(this.rv.q());
        }
        ((UgenLottieView) this.l).setProgress(this.la);
        if (this.qh <= 0.0f) {
            this.qh = 1.0f;
        }
        ((UgenLottieView) this.l).setSpeed(this.qh);
        ((UgenLottieView) this.l).setAutoPlay(this.il);
        ((UgenLottieView) this.l).setMaintainOriginalImageBounds(true);
        ((UgenLottieView) this.l).setImageAssetDelegate(new AnonymousClass1());
        if (ln()) {
            ((UgenLottieView) this.l).setScaleType(this.o);
        } else {
            ((UgenLottieView) this.l).setScaleType(this.vo);
        }
        if (ln()) {
            ((UgenLottieView) this.l).setRepeatCount(this.bz);
        } else {
            ((UgenLottieView) this.l).n(this.qn);
        }
        fs();
    }

    /* JADX INFO: renamed from: com.byazt.kru.qg$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME, 51})
    public class AnonymousClass1 implements q {
        public AnonymousClass1() {
        }

        @Override // com.byazt.pp.q
        public Bitmap n(final rv rvVar) {
            final String strN;
            if (rvVar == null) {
                return null;
            }
            String strSz = rvVar.sz();
            String strOa = rvVar.oa();
            if (!TextUtils.isEmpty(strSz) && TextUtils.isEmpty(strOa)) {
                strN = com.byazt.mcb.qg.n(strSz, qg.this.q);
            } else if (!TextUtils.isEmpty(strOa) && TextUtils.isEmpty(strSz)) {
                strN = com.byazt.mcb.qg.n(strOa, qg.this.q);
            } else {
                strN = (TextUtils.isEmpty(strOa) || TextUtils.isEmpty(strSz)) ? null : com.byazt.mcb.qg.n(strSz, qg.this.q) + com.byazt.mcb.qg.n(strOa, qg.this.q);
            }
            if (TextUtils.isEmpty(strN)) {
                return null;
            }
            Bitmap bitmap = qg.this.ei.get(strN);
            if (bitmap != null) {
                return bitmap;
            }
            Integer num = qg.this.dm.get(strN);
            if (num == null || num.intValue() == 2) {
                qg.this.dm.put(strN, 1);
            } else if (num.intValue() == 1) {
                return null;
            }
            ((UgenLottieView) qg.this.l).n(strN, new com.byazt.vk.rv() { // from class: com.byazt.kru.qg.1.1
                @Override // com.byazt.vk.rv
                public void n(Bitmap bitmap2) {
                    qg.this.n(rvVar, strN, bitmap2);
                }

                @Override // com.byazt.vk.rv
                public void n() {
                    w.n().qg().n(qg.this.rv, strN, new com.byazt.gu.qg.n() { // from class: com.byazt.kru.qg.1.1.1
                        @Override // com.byazt.gu.qg.n
                        public void n(Bitmap bitmap2) {
                            qg.this.n(rvVar, strN, bitmap2);
                        }
                    });
                }
            });
            return qg.this.ei.get(strN);
        }
    }

    public void cx() {
        if (this.n.startsWith("local")) {
            ((UgenLottieView) this.l).setAnimation(d(this.n));
            ((UgenLottieView) this.l).setImageAssetsFolder(this.nk);
            return;
        }
        String str = this.sq;
        if (str == null) {
            ((UgenLottieView) this.l).setAnimationFromUrl(this.n);
        } else if (TextUtils.equals("", str)) {
            ((UgenLottieView) this.l).qg(this.n, (String) null);
        } else {
            ((UgenLottieView) this.l).qg(this.n, this.sq);
        }
    }

    public void fs() {
        cx();
        ((UgenLottieView) this.l).n();
    }

    public void n(final rv rvVar, String str, final Bitmap bitmap) {
        if (bitmap != null) {
            this.ei.put(str, bitmap);
            this.dm.remove(str);
            fs.n(new Runnable() { // from class: com.byazt.kru.qg.2
                @Override // java.lang.Runnable
                public void run() {
                    ((UgenLottieView) qg.this.l).n(rvVar.d(), bitmap);
                }
            });
            n(str, true);
            return;
        }
        this.dm.put(str, 2);
        n(str, false);
    }

    private void n(String str, boolean z) {
        Map<String, Object> mapQg;
        if (this.rv == null || TextUtils.isEmpty(str) || (mapQg = this.rv.qg()) == null || mapQg.isEmpty()) {
            return;
        }
        Object obj = mapQg.get("ugen_v3_render");
        if (obj instanceof WeakReference) {
            Object obj2 = ((WeakReference) obj).get();
            if (obj2 instanceof com.byazt.gn.fs) {
                try {
                    ((com.byazt.gn.fs) obj2).n(str, z);
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
                this.o = sz(str2);
                break;
            case "scaleType":
                this.vo = oa(str2);
                break;
            case "progress":
                this.la = com.byazt.hb.s.n(str2, 0.0f);
                break;
            case "imagePath":
                this.nk = str2;
                break;
            case "autoReverse":
                this.ze = com.byazt.hb.s.n(str2, false);
                break;
            case "md5":
                this.sq = str2;
                break;
            case "src":
                this.n = str2;
                break;
            case "loop":
                if (ln()) {
                    this.bz = com.byazt.hb.s.n(str2, 0);
                    break;
                } else {
                    this.qn = com.byazt.hb.s.n(str2, false);
                    break;
                }
                break;
            case "speed":
                this.qh = com.byazt.hb.s.n(str2, 1.0f);
                break;
            case "autoPlay":
                this.il = com.byazt.hb.s.n(str2, false);
                break;
            case "autoplay":
                this.il = com.byazt.hb.s.n(str2, true);
                break;
        }
    }

    private String d(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("local")) {
            return "";
        }
        if (str.contains("shake_phone")) {
            return "lottie_json/shake_phone.json";
        }
        return str.contains("swipe_right") ? "lottie_json/swipe_right.json" : "";
    }

    private ImageView.ScaleType oa(String str) {
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

    private ImageView.ScaleType sz(String str) {
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

    public void n(AnimatorListenerAdapter animatorListenerAdapter) {
        ((UgenLottieView) this.l).n(animatorListenerAdapter);
    }

    public void lq() {
        if (this.l != 0) {
            ((UgenLottieView) this.l).n();
        }
    }
}
