package com.byazt.ny;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.byazt.gu.w;
import com.byazt.hb.fs;
import com.byazt.hb.q;
import com.byazt.ud.UGTextView;
import com.byazt.ud.qg;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1000, 19})
public class n extends qg {
    public int bz;
    public String dm;
    public boolean il;
    public boolean la;
    public String nk;
    public String o;
    public com.byazt.hb.n.C0188n qn;
    public String vo;
    public int ze;

    public n(Context context) {
        super(context);
        this.vo = "row";
    }

    @Override // com.byazt.ud.qg, com.byazt.ih.s
    public void qg() {
        super.qg();
        fs();
        ((UGTextView) this.l).setGravity(17);
    }

    @Override // com.byazt.ih.s
    public void dg() {
        super.dg();
        if (this.il) {
            ((UGTextView) this.l).setTextColor(this.bz);
        }
        if (this.la) {
            if (this.np) {
                n(this.qn);
            } else {
                s(this.ze);
            }
        }
    }

    @Override // com.byazt.ih.s
    public void u() {
        super.u();
        if (this.il) {
            ((UGTextView) this.l).setTextColor(this.sq);
        }
        if (this.la) {
            if (this.np) {
                n(this.r);
            } else {
                s(this.f);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x0037  */
    public void qg(Drawable drawable) {
        byte b;
        if (drawable == null) {
            return;
        }
        switch (this.vo) {
            case "column_reverse":
                b = 2;
                break;
            case "column":
                b = 1;
                break;
            case "row_reverse":
                b = 0;
                break;
            case "row":
                b = 3;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            ((UGTextView) this.l).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            return;
        }
        if (b == 1) {
            ((UGTextView) this.l).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        } else if (b == 2) {
            ((UGTextView) this.l).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
        } else {
            ((UGTextView) this.l).setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void d(String str) {
        qg(fs.n(this.qg, q.qg(this.qg, str)));
    }

    private void fs() {
        if (TextUtils.isEmpty(this.dm)) {
            return;
        }
        ((UGTextView) this.l).setCompoundDrawables(null, null, null, null);
        if (this.dm.startsWith("local://")) {
            try {
                d(this.dm.replace("local://", ""));
            } catch (Throwable unused) {
            }
        } else {
            w.n().qg().n(this.rv, this.dm, new com.byazt.gu.qg.n() { // from class: com.byazt.ny.n.1
                @Override // com.byazt.gu.qg.n
                public void n(final Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    fs.n(new Runnable() { // from class: com.byazt.ny.n.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            n.this.qg(new BitmapDrawable(n.this.qg.getResources(), bitmap));
                        }
                    });
                }
            });
        }
    }

    @Override // com.byazt.ud.qg, com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "direction":
                this.vo = str2;
                break;
            case "highlightTextColor":
            case "highlightedTextColor":
                this.bz = com.byazt.hb.n.n(str2);
                this.il = true;
                break;
            case "image":
                this.dm = str2;
                break;
            case "highlightImage":
                this.o = str2;
                break;
            case "highlightBackgroundColor":
                if (com.byazt.hb.n.s(str2)) {
                    this.np = true;
                    this.qn = com.byazt.hb.n.qg(str2);
                } else {
                    this.ze = com.byazt.hb.n.n(str2);
                    this.np = false;
                }
                this.la = true;
                break;
            case "highlightBackgroundImage":
                this.nk = str2;
                break;
        }
    }
}
