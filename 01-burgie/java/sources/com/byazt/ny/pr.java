package com.byazt.ny;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.byazt.aa.zo;
import com.byazt.ch.fw;
import com.byazt.ik.hn;
import com.byazt.llk.hw;
import com.byazt.llk.uc;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 36, 37})
public class pr extends hn<BrokenImage> {
    public volatile boolean fe;
    public String pr;
    public float qx;

    public pr(Context context) {
        super(context);
        this.fe = false;
    }

    @Override // com.byazt.ik.hn
    public void hw() {
        super.hw();
        zo();
    }

    private void zo() {
        if (this.eh != null) {
            this.eh.pr();
        }
        uc.pr().hw().pr(this.aj, this.pr, new hw.pr() { // from class: com.byazt.ny.pr.1
            @Override // com.byazt.llk.hw.pr
            public void pr(final Bitmap bitmap) {
                if (bitmap == null) {
                    if (pr.this.eh != null) {
                        fw fwVar = pr.this.eh;
                        pr prVar = pr.this;
                        fwVar.hw(prVar, prVar.pr);
                        return;
                    }
                    return;
                }
                final Bitmap[] bitmapArr = new Bitmap[1];
                if (pr.this.qx > 0.0f) {
                    bitmapArr[0] = zo.pr(pr.this.hw, bitmap, (int) pr.this.qx);
                }
                zo.pr(new Runnable() { // from class: com.byazt.ny.pr.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BrokenImage brokenImage = (BrokenImage) pr.this.c;
                        Bitmap bitmap2 = bitmapArr[0];
                        if (bitmap2 == null) {
                            bitmap2 = bitmap;
                        }
                        brokenImage.setBitmap(bitmap2);
                    }
                });
                if (pr.this.eh != null) {
                    fw fwVar2 = pr.this.eh;
                    pr prVar2 = pr.this;
                    fwVar2.pr(prVar2, prVar2.pr);
                }
            }
        });
    }

    public void pr(final int i, final int i2, final int i3) {
        if (this.fe) {
            return;
        }
        this.fe = true;
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.ny.pr.2
            @Override // java.lang.Runnable
            public void run() {
                ((BrokenImage) pr.this.c).pr(i, i2);
                ((BrokenImage) pr.this.c).pr(i3);
            }
        });
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: fw, reason: merged with bridge method [inline-methods] */
    public BrokenImage pr() {
        BrokenImage brokenImage = new BrokenImage(this.hw);
        brokenImage.pr(this);
        return brokenImage;
    }

    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            super.pr(str, str2);
            switch (str) {
                case "src":
                    this.pr = str2;
                    break;
                case "imageBlur":
                    this.qx = com.byazt.aa.hn.pr(str2, -1.0f);
                    break;
            }
        }
    }

    @Override // com.byazt.ik.hn, com.byazt.llk.c
    public void c() {
        super.c();
    }

    @Override // com.byazt.ik.hn, com.byazt.llk.c
    public void uc() {
        super.uc();
    }
}
