package com.byazt.gz;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.sd.zo;
import com.byazt.wt.er;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 672, 1801})
public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {
    public int hw;
    public boolean pr;

    public NativeDrawVideoTsView(Context context, of ofVar) {
        super(context, ofVar);
        this.pr = false;
        setOnClickListener(this);
        this.hw = getResources().getConfiguration().orientation;
    }

    public NativeDrawVideoTsView(Context context, of ofVar, String str, boolean z, boolean z2) {
        super(context, ofVar, str, z, z2);
        this.pr = false;
        setOnClickListener(this);
        this.hw = getResources().getConfiguration().orientation;
    }

    @Override // com.byazt.gz.NativeVideoTsView
    public void fw() {
        this.ho = "draw_ad";
        super.fw();
    }

    @Override // com.byazt.gz.NativeVideoTsView
    public void hw() {
        if (this.pr) {
            super.hw();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.pr = z;
    }

    public void pr(Bitmap bitmap, int i) {
        zo.nt().pr(bitmap);
        this.nt = i;
    }

    @Override // com.byazt.gz.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        if (this.k != null && this.k.getVisibility() == 0) {
            cz();
        } else {
            super.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.byazt.gz.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.k != null && this.k.getVisibility() == 0) {
            cz();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    private void zo() {
        er.pr((View) this.vk, 0);
        er.pr((View) this.w, 0);
        er.pr((View) this.m, 8);
    }

    private void cz() {
        k();
        if (this.vk != null) {
            if (this.vk.getVisibility() == 0) {
                return;
            }
            com.byazt.ub.hw.pr(qv.hw(this.x)).pr(this.w);
            pr(this.w, qv.hw(this.x));
        }
        zo();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.k != null && this.k.getVisibility() == 0) {
            er.c(this.vk);
        }
        hw();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (this.hw == configuration.orientation) {
            return;
        }
        this.hw = configuration.orientation;
        er.pr(this, new er.pr() { // from class: com.byazt.gz.NativeDrawVideoTsView.1
            @Override // com.byazt.wt.er.pr
            public void pr(View view) {
                if (NativeDrawVideoTsView.this.c == null) {
                    return;
                }
                NativeDrawVideoTsView.this.pr(NativeDrawVideoTsView.this.getWidth(), NativeDrawVideoTsView.this.getHeight());
            }
        });
    }

    @Override // com.byazt.gz.NativeVideoTsView
    public void x() {
        int i = getResources().getConfiguration().orientation;
        if (this.hw != i) {
            this.hw = i;
            er.pr(this, new er.pr() { // from class: com.byazt.gz.NativeDrawVideoTsView.2
                @Override // com.byazt.wt.er.pr
                public void pr(View view) {
                    if (NativeDrawVideoTsView.this.c == null) {
                        return;
                    }
                    NativeDrawVideoTsView.this.pr(NativeDrawVideoTsView.this.getWidth(), NativeDrawVideoTsView.this.getHeight());
                    NativeDrawVideoTsView.super.x();
                }
            });
        } else {
            super.x();
        }
    }

    @Override // com.byazt.gz.NativeVideoTsView
    public com.byazt.w.hn pr(Context context, ViewGroup viewGroup, of ofVar, String str, boolean z, boolean z2, boolean z3) {
        return new hn(context, viewGroup, ofVar, str, z, z2, z3);
    }
}
