package com.byazt.ax;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.byazt.ca.ho;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.lb;
import com.byazt.hg.of;
import com.byazt.icw.RewardBrowserMixTopLayoutImpl;
import com.byazt.icw.TopLayoutImpl;
import com.byazt.pi.TopProxyLayout;
import com.byazt.ro.UgenBanner;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public com.byazt.icw.c aj;
    public UgenBanner c;
    public com.byazt.icw.uc fw;
    public com.byazt.icw.pr hn;
    public of hw;
    public final TTBaseVideoActivity pr;
    public com.byazt.az.hw uc;
    public TextView x;
    public com.byazt.icw.x zo;

    public c(TTBaseVideoActivity tTBaseVideoActivity) {
        this.pr = tTBaseVideoActivity;
    }

    public void pr(of ofVar, hw hwVar, boolean z, com.byazt.az.hw hwVar2) {
        this.hw = ofVar;
        this.uc = hwVar2;
        zo();
        this.fw = new com.byazt.icw.uc(this.pr, this.hw, hwVar, this, z);
        this.aj = new com.byazt.icw.c(this.pr, this.hw, hwVar, this, z);
        this.zo = new com.byazt.icw.x(this.pr, this.hw, hwVar, this, z);
        pr(1);
    }

    private void zo() {
        TopProxyLayout topProxyLayout = (TopProxyLayout) this.pr.findViewById(2114387721);
        if (topProxyLayout != null) {
            pr(topProxyLayout);
        }
        this.x = (TextView) this.pr.findViewById(2114387801);
        this.c = (UgenBanner) this.pr.findViewById(2114387901);
    }

    public void pr(TopProxyLayout topProxyLayout) {
        View viewPr;
        if (lb.m(this.hw)) {
            viewPr = new RewardBrowserMixTopLayoutImpl(topProxyLayout.getContext()).pr(this.hw);
        } else {
            viewPr = new TopLayoutImpl(topProxyLayout.getContext()).pr(this.hw);
        }
        if (viewPr != null) {
            this.hn = (com.byazt.icw.pr) viewPr;
        } else {
            ho.hw("RewardFullTopProxyManager", "view not implements ITopLayout interface");
        }
        ViewParent parent = topProxyLayout.getParent();
        if (parent instanceof ViewGroup) {
            pr(topProxyLayout, viewPr, (ViewGroup) parent);
        }
    }

    private void pr(TopProxyLayout topProxyLayout, View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(topProxyLayout);
        viewGroup.removeViewInLayout(topProxyLayout);
        ViewGroup.LayoutParams layoutParams = topProxyLayout.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }

    public void pr(boolean z) {
        com.byazt.icw.pr prVar = this.hn;
        if (prVar != null) {
            prVar.setVisible(z);
        }
    }

    public void hw(boolean z) {
        com.byazt.icw.pr prVar = this.hn;
        if (prVar != null) {
            prVar.setShowDislike(z);
        }
    }

    public void hn(boolean z) {
        com.byazt.icw.pr prVar = this.hn;
        if (prVar != null) {
            prVar.setDislikeLeft(z);
        }
    }

    public void x(boolean z) {
        com.byazt.icw.pr prVar = this.hn;
        if (prVar != null) {
            prVar.setSoundMute(z);
        }
    }

    public void c(boolean z) {
        com.byazt.icw.pr prVar = this.hn;
        if (prVar != null) {
            prVar.setShowSound(z);
        }
    }

    public void uc(boolean z) {
        com.byazt.icw.pr prVar = this.hn;
        if (prVar != null) {
            prVar.setShowBack(z);
        }
    }

    public void pr(boolean z, String str, String str2, boolean z2, boolean z3) {
        com.byazt.icw.pr prVar = this.hn;
        if (prVar != null) {
            prVar.pr(z, str, str2, z2, z3);
        }
    }

    public void pr(String str, String str2, boolean z) {
        com.byazt.icw.pr prVar = this.hn;
        if (prVar != null) {
            prVar.pr(str, str2, z);
        }
    }

    public void pr() {
        com.byazt.icw.pr prVar = this.hn;
        if (prVar != null) {
            prVar.pr();
        }
    }

    public void hw() {
        com.byazt.icw.pr prVar = this.hn;
        if (prVar != null) {
            prVar.hw();
        }
    }

    public void hn() {
        com.byazt.icw.pr prVar = this.hn;
        if (prVar != null) {
            prVar.hn();
        }
    }

    public View x() {
        com.byazt.icw.pr prVar = this.hn;
        if (prVar != null) {
            return prVar.getCloseButton();
        }
        return null;
    }

    public boolean c() {
        com.byazt.icw.pr prVar = this.hn;
        if (prVar != null) {
            return prVar.getSkipOrCloseVisible();
        }
        return false;
    }

    public void pr(int i) {
        switch (i) {
            case 2:
                pr(this.zo);
                break;
            case 3:
            default:
                pr(this.fw);
                break;
            case 4:
                pr(this.aj);
                break;
        }
    }

    public void pr(com.byazt.icw.hw hwVar) {
        com.byazt.icw.pr prVar = this.hn;
        if (prVar != null) {
            prVar.setListener(hwVar);
        }
    }

    public void fw(boolean z) {
        com.byazt.icw.pr prVar = this.hn;
        if (prVar != null) {
            prVar.setShowAgain(z);
        }
    }

    public void pr(String str) {
        com.byazt.icw.pr prVar = this.hn;
        if (prVar != null) {
            prVar.setPlayAgainEntranceText(str);
        }
    }

    public void hw(String str) {
        TextView textView = this.x;
        if (textView != null) {
            textView.setText(str);
            this.x.setVisibility(0);
            this.x.postDelayed(new Runnable() { // from class: com.byazt.ax.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.x.setVisibility(8);
                }
            }, 3000L);
        }
    }

    public void uc() {
        UgenBanner ugenBanner = this.c;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.pr(this.hw, this.uc);
    }

    public void fw() {
        UgenBanner ugenBanner = this.c;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.pr();
    }

    public void pr(of ofVar) {
        com.byazt.icw.uc ucVar = this.fw;
        if (ucVar != null) {
            ucVar.pr(ofVar);
        }
        com.byazt.icw.x xVar = this.zo;
        if (xVar != null) {
            xVar.pr(ofVar);
        }
        com.byazt.icw.c cVar = this.aj;
        if (cVar != null) {
            cVar.pr(ofVar);
        }
    }
}
