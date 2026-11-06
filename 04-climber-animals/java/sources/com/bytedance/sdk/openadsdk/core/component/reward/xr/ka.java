package com.bytedance.sdk.openadsdk.core.component.reward.xr;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl;
import com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl;
import com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.widget.TopProxyLayout;
import com.tapsdk.tapad.e.a;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    private com.bytedance.sdk.openadsdk.core.component.reward.top.c ab;
    private com.bytedance.sdk.openadsdk.core.component.reward.top.ms ah;
    private com.bytedance.sdk.openadsdk.core.xr.xr c;
    private TextView d;
    private UgenBanner ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final TTBaseVideoActivity f2303ms;
    private com.bytedance.sdk.openadsdk.core.component.reward.top.ka ny;
    private com.bytedance.sdk.openadsdk.core.component.reward.top.d x;
    private lm xr;

    public ka(TTBaseVideoActivity tTBaseVideoActivity) {
        this.f2303ms = tTBaseVideoActivity;
    }

    public void ms(lm lmVar, xr xrVar, boolean z, com.bytedance.sdk.openadsdk.core.xr.xr xrVar2) {
        this.xr = lmVar;
        this.c = xrVar2;
        x();
        this.ab = new com.bytedance.sdk.openadsdk.core.component.reward.top.c(this.f2303ms, this.xr, xrVar, this, z);
        this.ny = new com.bytedance.sdk.openadsdk.core.component.reward.top.ka(this.f2303ms, this.xr, xrVar, this, z);
        this.x = new com.bytedance.sdk.openadsdk.core.component.reward.top.d(this.f2303ms, this.xr, xrVar, this, z);
        ms(1);
    }

    private void x() {
        TopProxyLayout topProxyLayout = (TopProxyLayout) this.f2303ms.findViewById(2114387727);
        if (topProxyLayout != null) {
            ms(topProxyLayout);
        }
        this.d = (TextView) this.f2303ms.findViewById(2114387807);
        this.ka = (UgenBanner) this.f2303ms.findViewById(2114387907);
    }

    public void ms(TopProxyLayout topProxyLayout) {
        View viewMs;
        if (t.hi(this.xr)) {
            viewMs = new RewardBrowserMixTopLayoutImpl(topProxyLayout.getContext()).ms(this.xr);
        } else {
            viewMs = new TopLayoutImpl(topProxyLayout.getContext()).ms(this.xr);
        }
        if (viewMs != null) {
            this.ah = (com.bytedance.sdk.openadsdk.core.component.reward.top.ms) viewMs;
        } else {
            sl.d("RewardFullTopProxyManager", "view not implements ITopLayout interface");
        }
        ViewParent parent = topProxyLayout.getParent();
        if (parent instanceof ViewGroup) {
            ms(topProxyLayout, viewMs, (ViewGroup) parent);
        }
    }

    private void ms(TopProxyLayout topProxyLayout, View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(topProxyLayout);
        viewGroup.removeViewInLayout(topProxyLayout);
        ViewGroup.LayoutParams layoutParams = topProxyLayout.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }

    public void ms(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.ms msVar = this.ah;
        if (msVar != null) {
            msVar.setVisible(z);
        }
    }

    public void xr(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.ms msVar = this.ah;
        if (msVar != null) {
            msVar.setShowDislike(z);
        }
    }

    public void ah(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.ms msVar = this.ah;
        if (msVar != null) {
            msVar.setDislikeLeft(z);
        }
    }

    public void d(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.ms msVar = this.ah;
        if (msVar != null) {
            msVar.setSoundMute(z);
        }
    }

    public void ka(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.ms msVar = this.ah;
        if (msVar != null) {
            msVar.setShowSound(z);
        }
    }

    public void c(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.ms msVar = this.ah;
        if (msVar != null) {
            msVar.setShowBack(z);
        }
    }

    public void ms(boolean z, String str, String str2, boolean z2, boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.ms msVar = this.ah;
        if (msVar != null) {
            msVar.ms(z, str, str2, z2, z3);
        }
    }

    public void ms() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.ms msVar = this.ah;
        if (msVar != null) {
            msVar.ms();
        }
    }

    public void xr() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.ms msVar = this.ah;
        if (msVar != null) {
            msVar.xr();
        }
    }

    public void ah() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.ms msVar = this.ah;
        if (msVar != null) {
            msVar.ah();
        }
    }

    public View d() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.ms msVar = this.ah;
        if (msVar != null) {
            return msVar.getCloseButton();
        }
        return null;
    }

    public boolean ka() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.ms msVar = this.ah;
        if (msVar != null) {
            return msVar.getSkipOrCloseVisible();
        }
        return false;
    }

    public void ms(int i) {
        if (i == 2) {
            ms(this.x);
        } else if (i == 4) {
            ms(this.ny);
        } else {
            ms(this.ab);
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.core.component.reward.top.xr xrVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.ms msVar = this.ah;
        if (msVar != null) {
            msVar.setListener(xrVar);
        }
    }

    public void ab(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.ms msVar = this.ah;
        if (msVar != null) {
            msVar.setShowAgain(z);
        }
    }

    public void ms(String str) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.ms msVar = this.ah;
        if (msVar != null) {
            msVar.setPlayAgainEntranceText(str);
        }
    }

    public void xr(String str) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(str);
            this.d.setVisibility(0);
            this.d.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xr.ka.1
                @Override // java.lang.Runnable
                public void run() {
                    ka.this.d.setVisibility(8);
                }
            }, a.f);
        }
    }

    public void c() {
        UgenBanner ugenBanner = this.ka;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.ms(this.xr, this.c);
    }

    public void ab() {
        UgenBanner ugenBanner = this.ka;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.ms();
    }
}
