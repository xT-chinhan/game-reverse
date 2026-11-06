package com.byazt.ty;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.byazt.gu.qg;
import com.byazt.gu.w;
import com.byazt.hb.fs;
import com.byazt.ih.s;
import com.byazt.vh.x;
import com.taptap.sdk.compilance.constants.ComplianceMessage;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, ComplianceMessage.OPEN_ALERT_TIP, 19})
public class n extends s<BrokenImage> {
    public volatile boolean ei;
    public String n;
    public float sq;

    public n(Context context) {
        super(context);
        this.ei = false;
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
        fs();
    }

    private void fs() {
        if (this.wv != null) {
            this.wv.n();
        }
        w.n().qg().n(this.rv, this.n, new qg.n() { // from class: com.byazt.ty.n.1
            @Override // com.byazt.gu.qg.n
            public void n(final Bitmap bitmap) {
                if (bitmap == null) {
                    if (n.this.wv != null) {
                        x xVar = n.this.wv;
                        n nVar = n.this;
                        xVar.qg(nVar, nVar.n);
                        return;
                    }
                    return;
                }
                final Bitmap[] bitmapArr = new Bitmap[1];
                if (n.this.sq > 0.0f) {
                    bitmapArr[0] = fs.n(n.this.qg, bitmap, (int) n.this.sq);
                }
                fs.n(new Runnable() { // from class: com.byazt.ty.n.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BrokenImage brokenImage = (BrokenImage) n.this.l;
                        Bitmap bitmap2 = bitmapArr[0];
                        if (bitmap2 == null) {
                            bitmap2 = bitmap;
                        }
                        brokenImage.setBitmap(bitmap2);
                    }
                });
                if (n.this.wv != null) {
                    x xVar2 = n.this.wv;
                    n nVar2 = n.this;
                    xVar2.n(nVar2, nVar2.n);
                }
            }
        });
    }

    public void n(final int i, final int i2, final int i3) {
        if (this.ei) {
            return;
        }
        this.ei = true;
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.ty.n.2
            @Override // java.lang.Runnable
            public void run() {
                ((BrokenImage) n.this.l).n(i, i2);
                ((BrokenImage) n.this.l).n(i3);
            }
        });
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public BrokenImage n() {
        BrokenImage brokenImage = new BrokenImage(this.qg);
        brokenImage.n(this);
        return brokenImage;
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.n(str, str2);
        str.hashCode();
        if (str.equals("imageBlur")) {
            this.sq = com.byazt.hb.s.n(str2, -1.0f);
        } else if (str.equals("src")) {
            this.n = str2;
        }
    }

    @Override // com.byazt.ih.s, com.byazt.gu.l
    public void l() {
        super.l();
    }

    @Override // com.byazt.ih.s, com.byazt.gu.l
    public void w() {
        super.w();
    }
}
