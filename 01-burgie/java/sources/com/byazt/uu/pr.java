package com.byazt.uu;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.ca.g;
import com.byazt.hl.RoundImageView;
import com.byazt.ik.hn;
import com.byazt.ld.nt;
import com.byazt.ld.rc;
import com.byazt.ub.hw;
import com.byazt.xlm.fw;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1700, 37})
public class pr extends hn<RoundImageView> {
    public String pr;
    public int qx;

    public pr(Context context) {
        super(context);
        this.qx = 25;
    }

    @Override // com.byazt.ik.hn
    public void hw() {
        super.hw();
        zo();
        ((RoundImageView) this.c).setScaleType(ImageView.ScaleType.FIT_XY);
        ((RoundImageView) this.c).setBorderColor(this.l);
        ((RoundImageView) this.c).setCornerRadius(this.ii);
        ((RoundImageView) this.c).setBorderWidth(this.jn);
    }

    private void zo() {
        if (TextUtils.isEmpty(this.pr)) {
            return;
        }
        ((RoundImageView) this.c).setImageDrawable(null);
        if (this.pr.startsWith("local://")) {
            g.pr(this.hw, this.pr.replace("local://", ""), new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.uu.pr.1
                @Override // com.byazt.ezf.pr
                public void pr(Bitmap bitmap) {
                    pr.this.hw(bitmap);
                }
            }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        } else {
            hw.pr(this.pr).hn(2).pr(new rc() { // from class: com.byazt.uu.pr.2
                @Override // com.byazt.ld.rc
                public void pr(nt ntVar) {
                    Object objHn = ntVar.hn();
                    if (objHn != null && (objHn instanceof Bitmap)) {
                        pr.this.pr((Bitmap) objHn);
                    }
                }

                @Override // com.byazt.ld.rc
                public void pr(int i, String str, Throwable th) {
                }
            }, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Bitmap bitmap) {
        final Bitmap bitmapPr = com.byazt.js.hw.pr(this.hw, bitmap, 25);
        if (bitmapPr != null) {
            zo.pr(new Runnable() { // from class: com.byazt.uu.pr.3
                @Override // java.lang.Runnable
                public void run() {
                    if (pr.this.c != null) {
                        ((RoundImageView) pr.this.c).setImageBitmap(bitmapPr);
                    }
                }
            });
        }
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: fw, reason: merged with bridge method [inline-methods] */
    public RoundImageView pr() {
        RoundImageView roundImageView = new RoundImageView(this.hw);
        roundImageView.pr(this);
        return roundImageView;
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
            case "blurRate":
                try {
                    this.qx = Integer.parseInt(str2);
                    break;
                } catch (Exception e) {
                    return;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(final Bitmap bitmap) {
        zo.pr(new fw("UG_decode_img") { // from class: com.byazt.uu.pr.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 != null) {
                        pr.this.pr(bitmap2);
                    }
                } catch (Exception e) {
                }
            }
        });
    }
}
