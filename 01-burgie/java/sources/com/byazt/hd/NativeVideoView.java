package com.byazt.hd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.ca.ho;
import com.byazt.gz.NativeVideoTsView;
import com.byazt.gz.x;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.llk.c;
import com.byazt.n.uc;
import com.byazt.w.hn;
import com.byazt.wt.er;
import com.byazt.zp.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.INTERACTION_TYPE_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_OPTIMIZE})
public class NativeVideoView extends NativeVideoTsView implements hn.pr {
    public c cz;
    public pr hw;
    public boolean ny;
    public int pr;

    public NativeVideoView(Context context) {
        super(context);
        if (this.c != null) {
            this.c.pr(true);
        }
        this.a.set(true);
        setNeedNativeVideoPlayBtnVisible(false);
        setEnableBlur(true);
    }

    @Override // com.byazt.gz.NativeVideoTsView
    public void M_() {
        super.M_();
    }

    @Override // com.byazt.gz.NativeVideoTsView
    public hn pr(Context context, ViewGroup viewGroup, of ofVar, String str, boolean z, boolean z2, boolean z3) {
        pr prVar = new pr(context, viewGroup, ofVar, str, z, z2, z3);
        this.hw = prVar;
        return prVar;
    }

    public void setPlayerType(int i) {
        this.pr = i;
    }

    @Override // com.byazt.gz.NativeVideoTsView
    public void x() {
        if (this.c == null) {
            M_();
        } else if ((this.c instanceof x) && !yb()) {
            ((x) this.c).qi();
        }
        if (this.c != null && this.a.get()) {
            this.a.set(false);
            fw();
            if (ho()) {
                er.pr((View) this.vk, 0);
                if (this.k != null) {
                    er.pr((View) this.k, 8);
                }
                if (qv.ho(this.x) != null) {
                    uc ucVarPr = qv.pr(4, this.x);
                    ucVarPr.hw(this.x.x());
                    ucVarPr.hw(this.uc.getWidth());
                    ucVarPr.hn(this.uc.getHeight());
                    ucVarPr.hn(this.x.B_());
                    this.x.l(this.pr);
                    ucVarPr.c(this.pr);
                    ucVarPr.pr(k.pr(this.x));
                    ucVarPr.pr(this.c.w());
                    ucVarPr.hw(this.c.qa());
                    ((x) this.c).x(this.pr);
                    ((x) this.c).hw(this.x);
                    pr(ucVarPr);
                    this.c.hn(false);
                    return;
                }
                ho.hw("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                return;
            }
            if (this.c.a()) {
                er.pr((View) this.vk, 0);
            } else {
                k();
                er.pr((View) this.vk, 0);
            }
        }
    }

    @Override // com.byazt.gz.NativeVideoTsView
    public void c() {
        super.c();
        er.pr((View) this.vk, 0);
    }

    @Override // com.byazt.gz.NativeVideoTsView
    public void setIsAutoPlay(boolean z) {
        super.setIsAutoPlay(z);
        er.pr((View) this.vk, 0);
    }

    public void pr(boolean z, boolean z2) {
        k();
        er.pr((View) this.vk, 0);
        er.pr((View) this.m, z ? 0 : 8);
        er.pr((View) this.w, z2 ? 0 : 8);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        c cVar = this.cz;
        if (cVar != null) {
            int[] iArrPr = cVar.pr(i, i2);
            super.onMeasure(iArrPr[0], iArrPr[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // com.byazt.gz.NativeVideoTsView
    public boolean pr(long j, boolean z, boolean z2) {
        this.uc.setVisibility(0);
        if (this.c == null) {
            this.c = new x(getContext(), this.fw, this.x, this.ho, false, false);
        }
        if (m() || this.aj) {
            pr(this.hn, 25, qv.hw(this.x));
        }
        return false;
    }

    @Override // com.byazt.gz.NativeVideoTsView, com.byazt.gz.x.pr
    public void N_() {
        er.pr((View) this.vk, 8);
        super.N_();
    }

    @Override // com.byazt.gz.NativeVideoTsView, com.byazt.w.hn.pr
    public void hw(long j, int i) {
        super.hw(j, i);
        er.pr((View) this.vk, 0);
    }

    @Override // com.byazt.gz.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.ny && i == 8) {
            c();
        }
    }

    public void setExtraMap(Map<String, Object> map) {
        if (this.c != null) {
            this.c.hw(map);
        }
    }

    public void Y_() {
        pr prVar = this.hw;
        if (prVar != null) {
            prVar.zo();
            er.pr((View) this.vk, 8);
        }
    }

    public void zo() {
        pr prVar = this.hw;
        if (prVar != null) {
            prVar.uc();
        }
    }

    public void setLp(boolean z) {
        this.ny = z;
    }

    public void pr(c cVar) {
        this.cz = cVar;
    }
}
