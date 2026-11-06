package com.bytedance.adsdk.ugeno.widget.ms;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.c.d;
import com.bytedance.adsdk.ugeno.c.x;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;
import com.bytedance.adsdk.ugeno.widget.text.xr;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends xr {
    private com.bytedance.adsdk.ugeno.c.ms.C0192ms cc;
    private int cj;
    private String gs;
    private String kl;
    private String nl;
    private int qo;
    private String r;
    private boolean si;
    private boolean wq;

    public ms(Context context) {
        super(context);
        this.gs = "row";
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.xr, com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        x();
        ((UGTextView) this.ka).setGravity(17);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    protected void lm() {
        super.lm();
        if (this.wq) {
            ((UGTextView) this.ka).setTextColor(this.cj);
        }
        if (this.si) {
            if (this.o) {
                ms(this.cc);
            } else {
                ah(this.qo);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    protected void e() {
        super.e();
        if (this.wq) {
            ((UGTextView) this.ka).setTextColor(this.vf);
        }
        if (this.si) {
            if (this.o) {
                ms(this.n);
            } else {
                ah(this.ul);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x0037  */
    public void xr(Drawable drawable) {
        byte b;
        if (drawable == null) {
            return;
        }
        switch (this.gs) {
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
            ((UGTextView) this.ka).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            return;
        }
        if (b == 1) {
            ((UGTextView) this.ka).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        } else if (b == 2) {
            ((UGTextView) this.ka).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
        } else {
            ((UGTextView) this.ka).setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    private void x() {
        if (TextUtils.isEmpty(this.kl)) {
            return;
        }
        ((UGTextView) this.ka).setCompoundDrawables(null, null, null, null);
        if (this.kl.startsWith("local://")) {
            try {
                xr(x.ms(this.xr, d.ms(this.xr, this.kl.replace("local://", ""))));
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        com.bytedance.adsdk.ugeno.d.ms().xr().ms(this.ny, this.kl, new com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms() { // from class: com.bytedance.adsdk.ugeno.widget.ms.ms.1
            @Override // com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms
            public void ms(final Bitmap bitmap) {
                if (bitmap == null) {
                    return;
                }
                x.ms(new Runnable() { // from class: com.bytedance.adsdk.ugeno.widget.ms.ms.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.this.xr(new BitmapDrawable(ms.this.xr.getResources(), bitmap));
                    }
                });
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.xr, com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        super.ms(str, str2);
        str.hashCode();
        switch (str) {
            case "direction":
                this.gs = str2;
                break;
            case "highlightTextColor":
            case "highlightedTextColor":
                this.cj = com.bytedance.adsdk.ugeno.c.ms.ms(str2);
                this.wq = true;
                break;
            case "image":
                this.kl = str2;
                break;
            case "highlightImage":
                this.r = str2;
                break;
            case "highlightBackgroundColor":
                if (com.bytedance.adsdk.ugeno.c.ms.ah(str2)) {
                    this.o = true;
                    this.cc = com.bytedance.adsdk.ugeno.c.ms.xr(str2);
                } else {
                    this.qo = com.bytedance.adsdk.ugeno.c.ms.ms(str2);
                    this.o = false;
                }
                this.si = true;
                break;
            case "highlightBackgroundImage":
                this.nl = str2;
                break;
        }
    }
}
