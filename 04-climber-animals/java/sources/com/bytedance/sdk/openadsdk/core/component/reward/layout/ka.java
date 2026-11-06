package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.xr.u;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.hi;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.pc;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    private String ab;
    private lm c;
    private final TTBaseVideoActivity ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.hi.xr.ah f2199ms;
    private FullRewardExpressView ny;
    private ViewGroup x;
    boolean xr = false;
    boolean ah = false;
    boolean d = false;

    public ka(TTBaseVideoActivity tTBaseVideoActivity) {
        this.ka = tTBaseVideoActivity;
    }

    public void ms(lm lmVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, String str, boolean z) {
        if (this.d) {
            return;
        }
        this.d = true;
        this.c = lmVar;
        this.ab = str;
        this.ny = new FullRewardExpressView(this.ka, lmVar, xrVar, str, z);
        FrameLayout expressFrameContainer = this.ka.jw().getExpressFrameContainer();
        this.x = expressFrameContainer;
        expressFrameContainer.addView(this.ny, new FrameLayout.LayoutParams(-2, -2));
        this.ny.setEasyPlayableContainer(this.ka.jw().getEasyPlayableContainer());
    }

    public void ms(CharSequence charSequence, int i, int i2, boolean z) {
        if (this.ny == null || !c()) {
            return;
        }
        this.ny.ms(charSequence, i, i2, z);
    }

    public FrameLayout ms() {
        FullRewardExpressView fullRewardExpressView = this.ny;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getVideoFrameLayout();
        }
        return null;
    }

    public boolean xr() {
        return this.xr;
    }

    public void ms(boolean z) {
        this.xr = z;
    }

    public boolean ah() {
        return this.ah;
    }

    public void xr(boolean z) {
        this.ah = z;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.nativeexpress.c cVar, com.bytedance.sdk.openadsdk.core.nativeexpress.ka kaVar) {
        lm lmVar;
        if (this.ny == null || (lmVar = this.c) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVarMs = ms(lmVar);
        this.f2199ms = ahVarMs;
        if (ahVarMs != null) {
            ahVarMs.x();
            if (this.ny.getContext() != null && (this.ny.getContext() instanceof Activity)) {
                this.f2199ms.ms((Activity) this.ny.getContext());
            }
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.c);
        EmptyView emptyViewMs = ms((ViewGroup) this.ny);
        if (emptyViewMs == null) {
            lm lmVar2 = this.c;
            EmptyView emptyView = new EmptyView(this.ka, this.ny, lmVar2 != null ? lmVar2.kf() : 1000);
            emptyView.ms(this.c, this.ab);
            this.ny.addView(emptyView);
            emptyViewMs = emptyView;
        }
        emptyViewMs.setNeedCheckingShow(false);
        emptyViewMs.setCallback(new EmptyView.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ka.1
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void ms(View view, Map<String, Object> map) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void ms(boolean z) {
                if (ka.this.f2199ms == null || !z) {
                    return;
                }
                ka.this.f2199ms.x();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void ms() {
                if (ka.this.f2199ms != null) {
                    ka.this.f2199ms.ka(false);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.ms
            public void xr() {
                if (ka.this.f2199ms != null) {
                    ka.this.f2199ms.ny();
                }
            }
        });
        cVar.ms(this.ny);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) cVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.f2199ms);
        this.ny.setClickListener(cVar);
        kaVar.ms(this.ny);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) kaVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.f2199ms);
        this.ny.setClickCreativeListener(kaVar);
        emptyViewMs.setNeedCheckingShow(false);
        ms(this.f2199ms, this.ny);
    }

    private void ms(com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar, NativeExpressView nativeExpressView) {
        if (ahVar == null || nativeExpressView == null) {
            return;
        }
        lm lmVar = this.c;
        final String strDf = lmVar != null ? lmVar.df() : "";
        ahVar.ms(new com.bytedance.sdk.openadsdk.core.hi.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.ka.2
            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms() {
                ka.this.ka.ms("点击开始下载");
                com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 1, 0);
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms(long j, long j2, String str, String str2) {
                if (j > 0) {
                    int i = (int) ((j2 * 100) / j);
                    ka.this.ka.ms("已下载" + i + "%");
                    com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 3, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void xr(long j, long j2, String str, String str2) {
                ka.this.ka.ms("下载暂停");
                if (j > 0) {
                    com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 2, (int) ((j2 * 100) / j));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ah(long j, long j2, String str, String str2) {
                ka.this.ka.ms("下载失败");
                if (j > 0) {
                    com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 4, (int) ((j2 * 100) / j));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms(long j, String str, String str2) {
                ka.this.ka.ms("点击安装");
                com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 5, 100);
            }

            @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
            public void ms(String str, String str2) {
                ka.this.ka.ms("点击打开");
                com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 6, 100);
            }
        });
    }

    private com.bytedance.sdk.openadsdk.core.hi.xr.ah ms(lm lmVar) {
        if (lmVar.jr() == 4) {
            return com.bytedance.sdk.openadsdk.core.hi.ka.ms((Context) this.ka, lmVar, this.ab, false);
        }
        return null;
    }

    private EmptyView ms(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void ms(hi hiVar) {
        FullRewardExpressView fullRewardExpressView = this.ny;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressVideoListenerProxy(hiVar);
    }

    public void ms(com.bytedance.sdk.openadsdk.core.nativeexpress.ms msVar) {
        FullRewardExpressView fullRewardExpressView = this.ny;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressInteractionListener(msVar);
    }

    public void d() {
        FullRewardExpressView fullRewardExpressView = this.ny;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.zb();
        }
    }

    public void ka() {
        FullRewardExpressView fullRewardExpressView = this.ny;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.qv();
        }
    }

    public boolean c() {
        FullRewardExpressView fullRewardExpressView = this.ny;
        return (fullRewardExpressView == null || fullRewardExpressView.nw()) ? false : true;
    }

    public void ab() {
        FullRewardExpressView fullRewardExpressView = this.ny;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.ao();
    }

    public void x() {
        FullRewardExpressView fullRewardExpressView = this.ny;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.h();
            this.ny.qv();
        }
    }

    public int ny() {
        FullRewardExpressView fullRewardExpressView = this.ny;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getDynamicShowType();
        }
        return 0;
    }

    public void ms(com.bykv.vk.openvk.component.video.api.d.ah ahVar) {
        FullRewardExpressView fullRewardExpressView = this.ny;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.setVideoController(ahVar);
        }
    }

    public void ah(boolean z) {
        ViewGroup viewGroup = this.x;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 8);
        }
    }

    public void ms(String str, JSONObject jSONObject) {
        pc jsObject;
        FullRewardExpressView fullRewardExpressView = this.ny;
        if (fullRewardExpressView == null || (jsObject = fullRewardExpressView.getJsObject()) == null || this.ka.isFinishing()) {
            return;
        }
        jsObject.ms(str, jSONObject);
    }

    public void ms(com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms interfaceC0296ms) {
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.f2199ms;
        if (ahVar != null) {
            ahVar.ms(interfaceC0296ms);
        }
    }

    public boolean ch() {
        FullRewardExpressView fullRewardExpressView = this.ny;
        if (fullRewardExpressView == null) {
            return true;
        }
        return fullRewardExpressView.u();
    }

    public u hi() {
        FullRewardExpressView fullRewardExpressView = this.ny;
        if (fullRewardExpressView == null) {
            return null;
        }
        return fullRewardExpressView.getRenderResult();
    }

    public FullRewardExpressView sl() {
        return this.ny;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.component.reward.ka.ah ahVar) {
        if (this.ny != null) {
            this.ny.ms((int) (ahVar.ms() / 1000), ahVar.ah(), ahVar.d(), ahVar.c());
        }
    }

    public void zb() {
        FullRewardExpressView fullRewardExpressView = this.ny;
        if (fullRewardExpressView != null && fullRewardExpressView.getJsObject() != null) {
            this.ny.getJsObject().ab(true);
        }
        ms("isVerifyReward", (JSONObject) null);
    }
}
