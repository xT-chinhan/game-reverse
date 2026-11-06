package com.byazt.nu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.byazt.aa.x;
import com.byazt.aa.zo;
import com.byazt.id.UGTextView;
import com.byazt.id.hw;
import com.byazt.llk.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR, 37})
public class pr extends hw {
    public boolean fs;
    public String ks;
    public com.byazt.aa.pr.C0005pr ku;
    public int p;
    public String sr;
    public boolean sx;
    public String wz;
    public String xb;
    public int xg;

    public pr(Context context) {
        super(context);
        this.sr = "row";
    }

    @Override // com.byazt.id.hw, com.byazt.ik.hn
    public void hw() {
        super.hw();
        zo();
        ((UGTextView) this.c).setGravity(17);
    }

    @Override // com.byazt.ik.hn
    public void qn() {
        super.qn();
        if (this.fs) {
            ((UGTextView) this.c).setTextColor(this.xg);
        }
        if (this.sx) {
            if (this.rk) {
                pr(this.ku);
            } else {
                hn(this.p);
            }
        }
    }

    @Override // com.byazt.ik.hn
    public void of() {
        super.of();
        if (this.fs) {
            ((UGTextView) this.c).setTextColor(this.qx);
        }
        if (this.sx) {
            if (this.rk) {
                pr(this.mr);
            } else {
                hn(this.ls);
            }
        }
    }

    public void hw(Drawable drawable) {
        if (drawable == null) {
        }
        switch (this.sr) {
            case "row_reverse":
                ((UGTextView) this.c).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                break;
            case "column":
                ((UGTextView) this.c).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
                break;
            case "column_reverse":
                ((UGTextView) this.c).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
                break;
            case "row":
            default:
                ((UGTextView) this.c).setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                break;
        }
    }

    public void w(String str) {
        hw(zo.pr(this.hw, x.hw(this.hw, str)));
    }

    private void zo() {
        if (TextUtils.isEmpty(this.ks)) {
            return;
        }
        ((UGTextView) this.c).setCompoundDrawables(null, null, null, null);
        if (this.ks.startsWith("local://")) {
            try {
                w(this.ks.replace("local://", ""));
            } catch (Throwable th) {
            }
        } else {
            uc.pr().hw().pr(this.aj, this.ks, new com.byazt.llk.hw.pr() { // from class: com.byazt.nu.pr.1
                @Override // com.byazt.llk.hw.pr
                public void pr(final Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    zo.pr(new Runnable() { // from class: com.byazt.nu.pr.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            pr.this.hw(new BitmapDrawable(pr.this.hw.getResources(), bitmap));
                        }
                    });
                }
            });
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x0053  */
    @Override // com.byazt.id.hw, com.byazt.ik.hn
    public void pr(String str, String str2) {
        super.pr(str, str2);
        switch (str) {
            case "image":
                this.ks = str2;
                break;
            case "direction":
                this.sr = str2;
                break;
            case "highlightImage":
                this.wz = str2;
                break;
            case "highlightBackgroundImage":
                this.xb = str2;
                break;
            case "highlightBackgroundColor":
                if (com.byazt.aa.pr.hn(str2)) {
                    this.rk = true;
                    this.ku = com.byazt.aa.pr.hw(str2);
                } else {
                    this.p = com.byazt.aa.pr.pr(str2);
                    this.rk = false;
                }
                this.sx = true;
                break;
            case "highlightedTextColor":
            case "highlightTextColor":
                this.xg = com.byazt.aa.pr.pr(str2);
                this.fs = true;
                break;
        }
    }
}
