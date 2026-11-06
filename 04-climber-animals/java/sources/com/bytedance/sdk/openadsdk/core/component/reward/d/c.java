package com.bytedance.sdk.openadsdk.core.component.reward.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class c extends ms {
    public static int xr(lm lmVar) {
        return 4;
    }

    public c(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar) {
        super(tTBaseVideoActivity, lmVar);
    }

    public static boolean ms(lm lmVar) {
        return (lmVar == null || lmVar.ld() == 100.0f) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean l() {
        return am() && this.xr.fm() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public View ny() {
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.xr)) {
            return com.bytedance.sdk.openadsdk.res.ka.b(this.f2142ms);
        }
        int i = (int) (this.d * 1000.0f);
        if (this.ah == 1) {
            if (i == 666) {
                return com.bytedance.sdk.openadsdk.res.ka.re(this.f2142ms);
            }
            if (i == 1000) {
                return com.bytedance.sdk.openadsdk.res.ka.w(this.f2142ms);
            }
            if (i == 1500) {
                return com.bytedance.sdk.openadsdk.res.ka.i(this.f2142ms);
            }
            if (i == 1777) {
                return com.bytedance.sdk.openadsdk.res.ka.yu(this.f2142ms);
            }
            return com.bytedance.sdk.openadsdk.res.ka.op(this.f2142ms);
        }
        if (i == 562) {
            return com.bytedance.sdk.openadsdk.res.ka.g(this.f2142ms);
        }
        if (i == 666) {
            return com.bytedance.sdk.openadsdk.res.ka.le(this.f2142ms);
        }
        if (i == 1000) {
            return com.bytedance.sdk.openadsdk.res.ka.w(this.f2142ms);
        }
        if (i == 1500) {
            return com.bytedance.sdk.openadsdk.res.ka.cv(this.f2142ms);
        }
        return com.bytedance.sdk.openadsdk.res.ka.of(this.f2142ms);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected void vm() {
        if (this.re != null) {
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.re.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms((Object) this.f2142ms);
        }
        if (this.i != null) {
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.i.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms((Object) this.f2142ms);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.xr ms(boolean z) {
        this.ny = new com.bytedance.sdk.openadsdk.core.component.reward.layout.ab(this.f2142ms, this.xr, z);
        return this.ny;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean am() {
        return zf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean sa() {
        return zf() || rt();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public boolean eg() {
        return this.ah == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public void qk() {
        this.ny.ka(8);
        this.ny.c(8);
        if (c()) {
            this.y.ms(false);
            return;
        }
        this.y.xr(this.xr.rk());
        this.y.ka(zf() || rt());
        if (zf()) {
            return;
        }
        this.y.ms(false, null, null, true, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void x() {
        super.x();
        k();
        try {
            final View decorView = this.f2142ms.getWindow().getDecorView();
            if (decorView != null) {
                decorView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int iHi = (int) (ul.hi((Context) c.this.f2142ms) / 2.0f);
                        int paddingLeft = decorView.getPaddingLeft();
                        int paddingRight = decorView.getPaddingRight();
                        int paddingTop = decorView.getPaddingTop();
                        int paddingBottom = decorView.getPaddingBottom();
                        if (c.this.ah == 1 && !ul.xr()) {
                            paddingTop += iHi;
                            paddingBottom += iHi;
                        }
                        if (c.this.ah == 2 && !ul.xr()) {
                            paddingLeft += iHi;
                            paddingRight += iHi;
                        }
                        decorView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    private boolean zf() {
        return lm.xr(this.xr);
    }

    private boolean rt() {
        return com.bytedance.sdk.openadsdk.op.ch.ms(this.xr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ah(boolean z) {
        super.ah(z);
        if (re.xr().hi(f.ny(this.xr)) || this.u) {
            if (com.bytedance.sdk.openadsdk.core.hi.ah.ah.c.ah && com.bytedance.sdk.openadsdk.core.hi.ah.ah.c.xr && ah(this.xr)) {
                com.bytedance.sdk.openadsdk.core.hi.ah.ah.c.xr = false;
                com.bytedance.sdk.openadsdk.core.hi.ah.ah.c.ah = false;
                this.f2142ms.finish();
            } else if (z && !com.bytedance.sdk.openadsdk.core.hi.ah.ah.c.ah) {
                this.f2142ms.finish();
            } else {
                if (!this.nw.g() || com.bytedance.sdk.openadsdk.core.hi.ah.ah.c.ah) {
                    return;
                }
                this.f2142ms.finish();
            }
        }
    }

    private boolean ah(lm lmVar) {
        return (lmVar.jr() == 4) && !TextUtils.isEmpty(lmVar.zm());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ao() {
        super.ao();
        this.y.xr(this.xr.rk());
        if (zf() || rt()) {
            this.y.ka(true);
        }
        if (!zf()) {
            this.y.ms(false, null, null, true, true);
        }
        if (zf()) {
            this.ny.c(0);
            this.ny.ka(0);
            this.ny.ah(0);
        } else {
            this.ny.c(8);
            this.ny.ka(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void d(boolean z) {
        int i = (int) (this.d * 1000.0f);
        if (this.ah != 1) {
            this.ny.d(8);
            return;
        }
        if (i == 666 || i == 1000 || i == 1500 || i == 1777) {
            this.ny.d(8);
        } else {
            this.ny.d(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public int cv() {
        return xr(this.xr);
    }
}
