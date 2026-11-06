package com.byazt.xud;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.cq.qg;
import com.byazt.ih.s;
import com.byazt.jm.RoundImageView;
import com.byazt.qit.x;
import com.byazt.si.cy;
import com.byazt.si.m;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1617, 19})
public class n extends s<RoundImageView> {
    public String n;
    public int sq;

    public n(Context context) {
        super(context);
        this.sq = 25;
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
        fs();
        ((RoundImageView) this.l).setScaleType(ImageView.ScaleType.FIT_XY);
        ((RoundImageView) this.l).setBorderColor(this.e);
        ((RoundImageView) this.l).setCornerRadius(this.pk);
        ((RoundImageView) this.l).setBorderWidth(this.pe);
    }

    private void fs() {
        if (TextUtils.isEmpty(this.n)) {
            return;
        }
        ((RoundImageView) this.l).setImageDrawable(null);
        if (this.n.startsWith("local://")) {
            sz.n(this.qg, this.n.replace("local://", ""), new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.xud.n.1
                @Override // com.byazt.qyj.n
                public void n(Bitmap bitmap) {
                    n.this.qg(bitmap);
                }
            }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        } else {
            com.byazt.imu.s.n(this.n).s(2).n(new m() { // from class: com.byazt.xud.n.2
                @Override // com.byazt.si.m
                public void n(int i, String str, Throwable th) {
                }

                @Override // com.byazt.si.m
                public void n(cy cyVar) {
                    Object objS = cyVar.s();
                    if (objS == null || !(objS instanceof Bitmap)) {
                        return;
                    }
                    n.this.n((Bitmap) objS);
                }
            }, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Bitmap bitmap) {
        final Bitmap bitmapN = qg.n(this.qg, bitmap, 25);
        if (bitmapN != null) {
            com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.xud.n.3
                @Override // java.lang.Runnable
                public void run() {
                    if (n.this.l != null) {
                        ((RoundImageView) n.this.l).setImageBitmap(bitmapN);
                    }
                }
            });
        }
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public RoundImageView n() {
        RoundImageView roundImageView = new RoundImageView(this.qg);
        roundImageView.n(this);
        return roundImageView;
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.n(str, str2);
        str.hashCode();
        if (str.equals("blurRate")) {
            try {
                this.sq = Integer.parseInt(str2);
            } catch (Exception unused) {
            }
        } else if (str.equals("src")) {
            this.n = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(final Bitmap bitmap) {
        com.byazt.ag.qg.n(new x("UG_decode_img") { // from class: com.byazt.xud.n.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 != null) {
                        n.this.n(bitmap2);
                    }
                } catch (Exception unused) {
                }
            }
        });
    }
}
