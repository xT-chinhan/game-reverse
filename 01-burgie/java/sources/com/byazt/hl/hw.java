package com.byazt.hl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.byazt.aa.x;
import com.byazt.aa.zo;
import com.byazt.ch.fw;
import com.byazt.ik.hn;
import com.byazt.llk.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_REQ_FINSIH_TIME, 13})
public class hw extends hn<RoundImageView> {
    public boolean fe;
    public String ks;
    public float ku;
    public int p;
    public String pr;
    public ImageView.ScaleType qx;
    public int sr;
    public float wz;
    public float xb;

    public hw(Context context) {
        super(context);
        this.qx = ImageView.ScaleType.FIT_XY;
        this.sr = -1;
        this.wz = -1.0f;
        this.xb = -1.0f;
        this.p = 0;
        this.ku = 50.0f;
    }

    @Override // com.byazt.ik.hn
    public void hw() {
        super.hw();
        lv();
        ((RoundImageView) this.c).setScaleType(this.qx);
        ((RoundImageView) this.c).setBorderColor(this.l);
        ((RoundImageView) this.c).setCornerRadius(this.ii);
        ((RoundImageView) this.c).setBorderWidth(this.jn);
        if (this.sr != -1) {
            ((RoundImageView) this.c).setColorFilter(this.sr);
        }
        ((RoundImageView) this.c).setEraseEnabled(this.p == 1);
        ((RoundImageView) this.c).setEraseRadius(this.ku);
    }

    public void k(String str) {
        this.pr = str;
    }

    private void lv() {
        if (TextUtils.isEmpty(this.pr)) {
            return;
        }
        ((RoundImageView) this.c).setImageDrawable(null);
        if (this.pr.startsWith("local://")) {
            try {
                String strReplace = this.pr.replace("local://", "");
                if (TextUtils.equals(fw(), "raw")) {
                    ((RoundImageView) this.c).setImageResource(x.pr(this.hw, strReplace));
                    return;
                } else {
                    pr((ImageView) this.c, strReplace);
                    return;
                }
            } catch (Throwable th) {
                return;
            }
        }
        if (this.pr.startsWith("@")) {
            try {
                ((RoundImageView) this.c).setImageResource(Integer.parseInt(this.pr.substring(1)));
                return;
            } catch (Exception e) {
                return;
            }
        }
        od();
    }

    public void pr(ImageView imageView, String str) {
        imageView.setImageResource(x.hw(this.hw, str));
    }

    private void od() {
        if (this.wz > 0.0f) {
            if (this.eh != null) {
                this.eh.pr();
            }
            uc.pr().hw().pr(this.aj, this.pr, new com.byazt.llk.hw.pr() { // from class: com.byazt.hl.hw.1
                @Override // com.byazt.llk.hw.pr
                public void pr(Bitmap bitmap) {
                    if (bitmap == null) {
                        if (hw.this.eh != null) {
                            fw fwVar = hw.this.eh;
                            hw hwVar = hw.this;
                            fwVar.hw(hwVar, hwVar.pr);
                            return;
                        }
                        return;
                    }
                    if (hw.this.eh != null) {
                        fw fwVar2 = hw.this.eh;
                        hw hwVar2 = hw.this;
                        fwVar2.pr(hwVar2, hwVar2.pr);
                    }
                    final Bitmap bitmapPr = zo.pr(hw.this.hw, bitmap, (int) hw.this.wz);
                    if (bitmapPr != null) {
                        zo.pr(new Runnable() { // from class: com.byazt.hl.hw.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((RoundImageView) hw.this.c).setImageBitmap(bitmapPr);
                            }
                        });
                    }
                    if (hw.this.fe || hw.this.xb > 0.0f) {
                        Bitmap bitmapPr2 = zo.pr(hw.this.hw, bitmap, hw.this.xb > 0.0f ? (int) hw.this.xb : 10);
                        if (bitmapPr2 != null) {
                            final BitmapDrawable bitmapDrawable = new BitmapDrawable(hw.this.hw.getResources(), bitmapPr2);
                            zo.pr(new Runnable() { // from class: com.byazt.hl.hw.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((RoundImageView) hw.this.c).setBackground(bitmapDrawable);
                                }
                            });
                        }
                    }
                }
            });
            return;
        }
        if (this.eh != null) {
            this.eh.pr();
        }
        uc.pr().hw().pr(this.aj, this.pr, (ImageView) this.c, ((RoundImageView) this.c).getWidth(), ((RoundImageView) this.c).getHeight(), new com.byazt.llk.hw.pr() { // from class: com.byazt.hl.hw.2
            @Override // com.byazt.llk.hw.pr
            public void pr(Bitmap bitmap) {
                if (bitmap == null) {
                    if (hw.this.eh != null) {
                        fw fwVar = hw.this.eh;
                        hw hwVar = hw.this;
                        fwVar.hw(hwVar, hwVar.pr);
                        return;
                    }
                    return;
                }
                if (hw.this.eh != null) {
                    fw fwVar2 = hw.this.eh;
                    hw hwVar2 = hw.this;
                    fwVar2.pr(hwVar2, hwVar2.pr);
                }
            }
        });
        if (this.fe || this.xb > 0.0f) {
            uc.pr().hw().pr(this.aj, this.pr, new com.byazt.llk.hw.pr() { // from class: com.byazt.hl.hw.3
                @Override // com.byazt.llk.hw.pr
                public void pr(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap bitmapPr = zo.pr(hw.this.hw, bitmap, hw.this.xb > 0.0f ? (int) hw.this.xb : 10);
                    zo.pr(new Runnable() { // from class: com.byazt.hl.hw.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (bitmapPr != null) {
                                ((RoundImageView) hw.this.c).setBackground(new BitmapDrawable(hw.this.hw.getResources(), bitmapPr));
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: zo, reason: merged with bridge method [inline-methods] */
    public RoundImageView pr() {
        RoundImageView roundImageView = new RoundImageView(this.hw);
        roundImageView.pr(this);
        return roundImageView;
    }

    public void hw(Drawable drawable) {
        ((RoundImageView) this.c).setImageDrawable(drawable);
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
            case "scaleType":
            case "scaleMode":
                this.qx = w(str2);
                break;
            case "isBgGaussianBlur":
                this.fe = com.byazt.aa.hn.pr(str2, false);
                break;
            case "tintColor":
                this.sr = com.byazt.aa.pr.pr(str2);
                break;
            case "imageBlur":
                this.wz = com.byazt.aa.hn.pr(str2, -1.0f);
                break;
            case "imageBgBlur":
                this.xb = com.byazt.aa.hn.pr(str2, -1.0f);
                break;
            case "erase":
                int iPr = com.byazt.aa.hn.pr(str2, 0);
                this.p = iPr;
                if (iPr == 1 && this.c != 0) {
                    ((RoundImageView) this.c).setEraseEnabled(true);
                    break;
                }
                break;
            case "eraseRadius":
                this.ku = com.byazt.aa.hn.pr(str2, 50.0f);
                if (this.c != 0) {
                    ((RoundImageView) this.c).setEraseRadius(this.ku);
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:35:0x0071  */
    private ImageView.ScaleType w(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        switch (str) {
            case "fitXY":
            case "fill":
                return ImageView.ScaleType.FIT_XY;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "fitCenter":
            case "fit":
                return ImageView.ScaleType.FIT_CENTER;
            case "center":
                return ImageView.ScaleType.CENTER;
            case "centerCrop":
            case "crop":
                return ImageView.ScaleType.CENTER_CROP;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            default:
                return scaleType;
        }
    }

    @Override // com.byazt.ik.hn, com.byazt.llk.c
    public void c() {
        super.c();
        ((RoundImageView) this.c).post(new Runnable() { // from class: com.byazt.hl.hw.4
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = ((RoundImageView) hw.this.c).getDrawable();
                if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
                    ((AnimatedImageDrawable) drawable).start();
                }
            }
        });
    }

    @Override // com.byazt.ik.hn, com.byazt.llk.c
    public void uc() {
        super.uc();
        Drawable drawable = ((RoundImageView) this.c).getDrawable();
        if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
            ((AnimatedImageDrawable) drawable).stop();
        }
    }

    @Override // com.byazt.ik.hn, com.byazt.llk.c
    public void pr(String str, Map<String, Object> map) {
        this.fw = (com.byazt.ik.pr) hw((hn) this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ww());
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        pr(this.fw, str, arrayList.toArray());
    }

    private void pr(hn hnVar, String str, Object... objArr) {
        List<hn<View>> listFw;
        if (hnVar == null) {
            return;
        }
        hnVar.pr(str, objArr);
        if (!(hnVar instanceof com.byazt.ik.pr) || (listFw = ((com.byazt.ik.pr) hnVar).fw()) == null || listFw.isEmpty()) {
            return;
        }
        Iterator<hn<View>> it = listFw.iterator();
        while (it.hasNext()) {
            pr(it.next(), str, objArr);
        }
    }

    public String fw() {
        return this.ks;
    }
}
