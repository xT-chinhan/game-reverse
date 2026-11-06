package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.core.t.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class RewardBrowserMixTopLayoutImpl extends FrameLayout implements ms<RewardBrowserMixTopLayoutImpl> {
    private xr ah;
    private lm d;
    private Context ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private View f2241ms;
    private View xr;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void ms(boolean z, String str, String str2, boolean z2, boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void setDislikeLeft(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void setPlayAgainEntranceText(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void setShowAgain(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void setShowBack(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void setShowDislike(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void setShowSound(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void setSoundMute(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void xr() {
    }

    public RewardBrowserMixTopLayoutImpl(Context context) {
        this(context, null);
    }

    public RewardBrowserMixTopLayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardBrowserMixTopLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ka = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void setVisible(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public RewardBrowserMixTopLayoutImpl ms(lm lmVar) {
        this.d = lmVar;
        addView(com.bytedance.sdk.openadsdk.res.ka.ab(getContext()));
        this.f2241ms = findViewById(2114387875);
        View viewFindViewById = findViewById(2114387459);
        this.xr = findViewById(2114387460);
        if (t.zb(lmVar)) {
            this.f2241ms = findViewById(2114387875);
            this.xr.setVisibility(8);
            viewFindViewById.setVisibility(8);
            com.bytedance.sdk.component.utils.t.ms(this.ka, "tt_ad_skip_btn_bg", this.f2241ms);
        } else if (t.u(lmVar)) {
            findViewById(2114387744).setVisibility(8);
            this.f2241ms = findViewById(2114387875);
        } else {
            this.f2241ms = findViewById(2114387719);
            this.xr.setVisibility(8);
            viewFindViewById.setVisibility(8);
        }
        if (this.f2241ms != null) {
            if (lmVar.zb()) {
                this.f2241ms.setVisibility(8);
            } else {
                this.f2241ms.setVisibility(0);
                this.f2241ms.setEnabled(true);
                this.f2241ms.setClickable(true);
            }
        }
        d();
        return this;
    }

    private void d() {
        ul.ms(this.f2241ms, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("topListener", RewardBrowserMixTopLayoutImpl.this.ah);
                    jSONObject.put("topImpl", 2);
                } catch (Throwable unused) {
                }
                u.ms().ms(RewardBrowserMixTopLayoutImpl.this.d, "stats_reward_full_click_native_close", jSONObject);
                if (RewardBrowserMixTopLayoutImpl.this.ah != null) {
                    RewardBrowserMixTopLayoutImpl.this.ah.ms(view);
                }
            }
        }, "top_skip_border");
        ul.ms(this.xr, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RewardBrowserMixTopLayoutImpl.this.ah != null) {
                    RewardBrowserMixTopLayoutImpl.this.ah.ah(view);
                }
            }
        }, "top_dislike_button");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void setListener(xr xrVar) {
        this.ah = xrVar;
    }

    public xr getTopListener() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void ms() {
        View view = this.f2241ms;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void ah() {
        View view = this.xr;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public View getCloseButton() {
        return this.f2241ms;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public boolean getSkipOrCloseVisible() {
        return ul.d(this.f2241ms);
    }
}
