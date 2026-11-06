package com.byazt.ia;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_STRENGTH_OPTION, 1719})
public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {
    public boolean n;
    public int qg;

    public NativeDrawVideoTsView(Context context, pk pkVar) {
        super(context, pkVar);
        this.n = false;
        setOnClickListener(this);
        this.qg = getResources().getConfiguration().orientation;
    }

    public NativeDrawVideoTsView(Context context, pk pkVar, String str, boolean z, boolean z2) {
        super(context, pkVar, str, z, z2);
        this.n = false;
        setOnClickListener(this);
        this.qg = getResources().getConfiguration().orientation;
    }

    @Override // com.byazt.ia.NativeVideoTsView
    public void r_() {
        this.k = "draw_ad";
        super.r_();
    }

    @Override // com.byazt.ia.NativeVideoTsView
    public void qg() {
        if (this.n) {
            super.qg();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.n = z;
    }

    public void n(Bitmap bitmap, int i) {
        com.byazt.vyf.s.cy().n(bitmap);
        this.cy = i;
    }

    @Override // com.byazt.ia.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        if (this.d != null && this.d.getVisibility() == 0) {
            w();
        } else {
            super.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.byazt.ia.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.d != null && this.d.getVisibility() == 0) {
            w();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    private void l() {
        com.byazt.okk.s.n((View) this.tj, 0);
        com.byazt.okk.s.n((View) this.cp, 0);
        com.byazt.okk.s.n((View) this.oa, 8);
    }

    private void w() {
        d();
        if (this.tj != null) {
            if (this.tj.getVisibility() == 0) {
                return;
            }
            com.byazt.imu.s.n(ta.qg(this.q)).n(this.cp);
            n(this.cp, ta.qg(this.q));
        }
        l();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.d != null && this.d.getVisibility() == 0) {
            com.byazt.okk.s.l(this.tj);
        }
        qg();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (this.qg == configuration.orientation) {
            return;
        }
        this.qg = configuration.orientation;
        com.byazt.okk.s.n(this, new com.byazt.okk.s.n() { // from class: com.byazt.ia.NativeDrawVideoTsView.1
            @Override // com.byazt.okk.s.n
            public void n(View view) {
                if (NativeDrawVideoTsView.this.l == null) {
                    return;
                }
                NativeDrawVideoTsView.this.n(NativeDrawVideoTsView.this.getWidth(), NativeDrawVideoTsView.this.getHeight());
            }
        });
    }

    @Override // com.byazt.ia.NativeVideoTsView
    public void q() {
        int i = getResources().getConfiguration().orientation;
        if (this.qg != i) {
            this.qg = i;
            com.byazt.okk.s.n(this, new com.byazt.okk.s.n() { // from class: com.byazt.ia.NativeDrawVideoTsView.2
                @Override // com.byazt.okk.s.n
                public void n(View view) {
                    if (NativeDrawVideoTsView.this.l == null) {
                        return;
                    }
                    NativeDrawVideoTsView.this.n(NativeDrawVideoTsView.this.getWidth(), NativeDrawVideoTsView.this.getHeight());
                    NativeDrawVideoTsView.super.q();
                }
            });
        } else {
            super.q();
        }
    }

    @Override // com.byazt.ia.NativeVideoTsView
    public com.byazt.iag.s n(Context context, ViewGroup viewGroup, pk pkVar, String str, boolean z, boolean z2, boolean z3) {
        return new s(context, viewGroup, pkVar, str, z, z2, z3);
    }
}
