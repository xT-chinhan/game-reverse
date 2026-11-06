package com.byazt.xt;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.of;
import com.byazt.mq.g;
import com.byazt.pg.FullRewardExpressView;
import com.byazt.qx.NativeExpressView;
import com.byazt.qx.w;
import com.byazt.sd.EmptyView;
import com.byazt.sd.nl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public FullRewardExpressView aj;
    public final TTBaseVideoActivity c;
    public String fw;
    public com.byazt.nv.hn pr;
    public of uc;
    public ViewGroup zo;
    public boolean hw = false;
    public boolean hn = false;
    public boolean x = false;

    public c(TTBaseVideoActivity tTBaseVideoActivity) {
        this.c = tTBaseVideoActivity;
    }

    public void pr(of ofVar, com.byazt.qe.hw hwVar, String str, boolean z, String str2) {
        if (this.x) {
            return;
        }
        this.x = true;
        this.uc = ofVar;
        this.fw = str;
        this.aj = new FullRewardExpressView(this.c, ofVar, hwVar, str, z, str2);
        FrameLayout expressFrameContainer = this.c.e().getExpressFrameContainer();
        this.zo = expressFrameContainer;
        expressFrameContainer.addView(this.aj, new FrameLayout.LayoutParams(-2, -1));
        this.aj.setEasyPlayableContainer(this.c.e().getEasyPlayableContainer());
    }

    public void pr(CharSequence charSequence, int i, int i2, boolean z) {
        if (this.aj != null && c()) {
            this.aj.pr(charSequence, i, i2, z);
        }
    }

    public FrameLayout pr() {
        FullRewardExpressView fullRewardExpressView = this.aj;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getVideoFrameLayout();
        }
        return null;
    }

    public boolean hw() {
        return this.hw;
    }

    public void pr(boolean z) {
        this.hw = z;
    }

    public boolean hn() {
        return this.hn;
    }

    public void hw(boolean z) {
        this.hn = z;
    }

    public void pr(com.byazt.qx.uc ucVar, com.byazt.qx.c cVar) {
        of ofVar;
        if (this.aj == null || (ofVar = this.uc) == null) {
            return;
        }
        com.byazt.nv.hn hnVarPr = pr(ofVar);
        this.pr = hnVarPr;
        if (hnVarPr instanceof com.byazt.ri.pr) {
            ((com.byazt.ri.pr) hnVarPr).fw().pr(new com.byazt.rx.pr() { // from class: com.byazt.xt.c.1
                @Override // com.byazt.rx.pr
                public void pr() {
                    c.this.c.x(true);
                }

                @Override // com.byazt.rx.pr
                public void hw() {
                    c.this.c.x(false);
                }

                @Override // com.byazt.rx.pr
                public void hn() {
                }
            });
        }
        com.byazt.nv.hn hnVar = this.pr;
        if (hnVar != null) {
            hnVar.hw();
            if (this.aj.getContext() != null && (this.aj.getContext() instanceof Activity)) {
                this.pr.pr((Activity) this.aj.getContext(), false);
            }
        }
        EmptyView emptyViewPr = pr((ViewGroup) this.aj);
        if (emptyViewPr == null) {
            int iOv = 1000;
            of ofVar2 = this.uc;
            if (ofVar2 != null) {
                iOv = ofVar2.ov();
            }
            EmptyView emptyView = new EmptyView(this.c, this.aj, iOv);
            emptyView.pr(this.uc, this.fw);
            this.aj.addView(emptyView);
            emptyViewPr = emptyView;
        }
        emptyViewPr.setNeedCheckingShow(false);
        emptyViewPr.setCallback(new EmptyView.pr() { // from class: com.byazt.xt.c.2
            @Override // com.byazt.sd.EmptyView.pr
            public void pr(boolean z) {
                if (c.this.pr != null && z) {
                    c.this.pr.hw();
                }
            }

            @Override // com.byazt.sd.EmptyView.pr
            public void pr() {
                if (c.this.pr != null) {
                    c.this.pr.pr();
                }
            }

            @Override // com.byazt.sd.EmptyView.pr
            public void hw() {
                if (c.this.pr != null) {
                    c.this.pr.hn();
                }
            }

            @Override // com.byazt.sd.EmptyView.pr
            public void pr(View view, Map<String, Object> map) {
            }
        });
        ucVar.pr(this.aj);
        ((com.byazt.dl.pr) ucVar.pr(com.byazt.dl.pr.class)).pr(this.pr);
        this.aj.setClickListener(ucVar);
        cVar.pr(this.aj);
        ((com.byazt.dl.pr) cVar.pr(com.byazt.dl.pr.class)).pr(this.pr);
        this.aj.setClickCreativeListener(cVar);
        emptyViewPr.setNeedCheckingShow(false);
        pr(this.pr, this.aj);
    }

    private void pr(com.byazt.nv.hn hnVar, NativeExpressView nativeExpressView) {
        final String strX;
        if (hnVar == null || nativeExpressView == null) {
            return;
        }
        of ofVar = this.uc;
        if (ofVar == null) {
            strX = "";
        } else {
            strX = ofVar.x();
        }
        hnVar.pr(new com.byazt.nv.pr() { // from class: com.byazt.xt.c.3
            @Override // com.byazt.nv.pr
            public void pr() {
                c.this.c.pr("点击开始下载");
                com.byazt.dp.pr.pr(strX);
            }

            @Override // com.byazt.nv.pr
            public void pr(long j, long j2, String str, String str2) {
                if (j > 0) {
                    c.this.c.pr("已下载" + ((int) ((100 * j2) / j)) + "%");
                }
                com.byazt.dp.pr.pr(strX, j, j2);
            }

            @Override // com.byazt.nv.pr
            public void hw(long j, long j2, String str, String str2) {
                c.this.c.pr("下载暂停");
                com.byazt.dp.pr.hw(strX, j, j2);
            }

            @Override // com.byazt.nv.pr
            public void hn(long j, long j2, String str, String str2) {
                c.this.c.pr("下载失败");
                com.byazt.dp.pr.hn(strX, j, j2);
            }

            @Override // com.byazt.nv.pr
            public void pr(long j, String str, String str2) {
                c.this.c.pr("点击安装");
                com.byazt.dp.pr.hw(strX);
            }

            @Override // com.byazt.nv.pr
            public void pr(String str, String str2) {
                c.this.c.pr("点击打开");
                com.byazt.dp.pr.hn(strX);
            }
        });
    }

    private com.byazt.nv.hn pr(of ofVar) {
        if (ofVar.aj() == 4) {
            return com.byazt.jx.zo.pr(this.c, ofVar, this.fw);
        }
        return null;
    }

    private EmptyView pr(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void pr(w wVar) {
        FullRewardExpressView fullRewardExpressView = this.aj;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressVideoListenerProxy(wVar);
    }

    public void pr(com.byazt.qx.pr prVar) {
        FullRewardExpressView fullRewardExpressView = this.aj;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressInteractionListener(prVar);
    }

    public void hn(boolean z) {
        FullRewardExpressView fullRewardExpressView = this.aj;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.x(z);
        }
    }

    public void x() {
        FullRewardExpressView fullRewardExpressView = this.aj;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.yb();
        }
    }

    public boolean c() {
        FullRewardExpressView fullRewardExpressView = this.aj;
        return (fullRewardExpressView == null || fullRewardExpressView.cz()) ? false : true;
    }

    public void uc() {
        FullRewardExpressView fullRewardExpressView = this.aj;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.ho();
    }

    public void fw() {
        FullRewardExpressView fullRewardExpressView = this.aj;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.nt();
            this.aj.yb();
        }
    }

    public int zo() {
        FullRewardExpressView fullRewardExpressView = this.aj;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getDynamicShowType();
        }
        return 0;
    }

    public byte aj() {
        FullRewardExpressView fullRewardExpressView = this.aj;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getShowDLFactorsEventParams();
        }
        return (byte) -1;
    }

    public void pr(com.byazt.w.hn hnVar) {
        FullRewardExpressView fullRewardExpressView = this.aj;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.setVideoController(hnVar);
        }
    }

    public void x(boolean z) {
        ViewGroup viewGroup = this.zo;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 8);
        }
    }

    public void pr(String str, JSONObject jSONObject) {
        nl jsObject;
        FullRewardExpressView fullRewardExpressView = this.aj;
        if (fullRewardExpressView == null || (jsObject = fullRewardExpressView.getJsObject()) == null || this.c.isFinishing()) {
            return;
        }
        jsObject.hw(str, jSONObject);
    }

    public void pr(com.byazt.mm.pr.InterfaceC0136pr interfaceC0136pr) {
        com.byazt.nv.hn hnVar = this.pr;
        if (hnVar != null) {
            hnVar.pr(interfaceC0136pr);
        }
    }

    public boolean vk() {
        FullRewardExpressView fullRewardExpressView = this.aj;
        if (fullRewardExpressView == null) {
            return true;
        }
        return fullRewardExpressView.m();
    }

    public g w() {
        FullRewardExpressView fullRewardExpressView = this.aj;
        if (fullRewardExpressView == null) {
            return null;
        }
        return fullRewardExpressView.getRenderResult();
    }

    public FullRewardExpressView k() {
        return this.aj;
    }

    public void pr(com.byazt.hf.hn hnVar) {
        if (this.aj != null) {
            this.aj.pr((int) (hnVar.pr() / 1000), hnVar.c(), hnVar.hw(), hnVar.x());
        }
    }

    public void m() {
        FullRewardExpressView fullRewardExpressView = this.aj;
        if (fullRewardExpressView != null && fullRewardExpressView.getJsObject() != null) {
            this.aj.getJsObject().fw(true);
        }
        pr("isVerifyReward", (JSONObject) null);
    }

    public void g() {
        FullRewardExpressView fullRewardExpressView = this.aj;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.lb();
        }
    }

    public void c(boolean z) {
        FullRewardExpressView fullRewardExpressView = this.aj;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.hn(z);
        }
    }

    public void pr(com.byazt.cy.pr prVar) {
        FullRewardExpressView fullRewardExpressView = this.aj;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.pr(prVar);
        }
    }
}
