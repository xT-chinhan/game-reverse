package com.byazt.xdp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.gct.cd;
import com.byazt.gct.pk;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1162, 1430})
public class RewardBrowserMixTopLayoutImpl extends FrameLayout implements n<RewardBrowserMixTopLayoutImpl> {
    public Context l;
    public View n;
    public pk q;
    public View qg;
    public qg s;

    @Override // com.byazt.xdp.n
    public void n(String str, String str2, boolean z) {
    }

    @Override // com.byazt.xdp.n
    public void n(boolean z, String str, String str2, boolean z2, boolean z3) {
    }

    @Override // com.byazt.xdp.n
    public void qg() {
    }

    @Override // com.byazt.xdp.n
    public void setDislikeLeft(boolean z) {
    }

    @Override // com.byazt.xdp.n
    public void setPlayAgainEntranceText(String str) {
    }

    @Override // com.byazt.xdp.n
    public void setShowAgain(boolean z) {
    }

    @Override // com.byazt.xdp.n
    public void setShowBack(boolean z) {
    }

    @Override // com.byazt.xdp.n
    public void setShowDislike(boolean z) {
    }

    @Override // com.byazt.xdp.n
    public void setShowSound(boolean z) {
    }

    @Override // com.byazt.xdp.n
    public void setSoundMute(boolean z) {
    }

    public RewardBrowserMixTopLayoutImpl(Context context) {
        this(context, null);
    }

    public RewardBrowserMixTopLayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardBrowserMixTopLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = context;
    }

    @Override // com.byazt.xdp.n
    public void setVisible(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public RewardBrowserMixTopLayoutImpl n(pk pkVar) {
        this.q = pkVar;
        addView(com.byazt.cb.qg.fs(getContext()));
        this.n = findViewById(2114387869);
        View viewFindViewById = findViewById(2114387453);
        this.qg = findViewById(2114387454);
        if (cd.k(pkVar)) {
            this.n = findViewById(2114387869);
            this.qg.setVisibility(8);
            viewFindViewById.setVisibility(8);
            this.n.setBackground(com.byazt.cb.qg.cx(this.l));
        } else if (cd.cy(pkVar)) {
            findViewById(2114387738).setVisibility(8);
            this.n = findViewById(2114387869);
        } else {
            this.n = findViewById(2114387713);
            this.qg.setVisibility(8);
            viewFindViewById.setVisibility(8);
        }
        if (this.n != null) {
            if (pkVar.dg()) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
                this.n.setEnabled(true);
                this.n.setClickable(true);
            }
        }
        q();
        return this;
    }

    private void q() {
        com.byazt.okk.s.n(this.n, new View.OnClickListener() { // from class: com.byazt.xdp.RewardBrowserMixTopLayoutImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("topListener", RewardBrowserMixTopLayoutImpl.this.s);
                    jSONObject.put("topImpl", 2);
                } catch (Throwable unused) {
                }
                com.byazt.eji.s.n().n(RewardBrowserMixTopLayoutImpl.this.q, "stats_reward_full_click_native_close", jSONObject);
                if (RewardBrowserMixTopLayoutImpl.this.s != null) {
                    RewardBrowserMixTopLayoutImpl.this.s.n(view);
                }
            }
        }, "top_skip_border");
        com.byazt.okk.s.n(this.qg, new View.OnClickListener() { // from class: com.byazt.xdp.RewardBrowserMixTopLayoutImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RewardBrowserMixTopLayoutImpl.this.s != null) {
                    RewardBrowserMixTopLayoutImpl.this.s.s(view);
                }
            }
        }, "top_dislike_button");
    }

    @Override // com.byazt.xdp.n
    public void setListener(qg qgVar) {
        this.s = qgVar;
    }

    public qg getTopListener() {
        return this.s;
    }

    @Override // com.byazt.xdp.n
    public void n() {
        View view = this.n;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.byazt.xdp.n
    public void s() {
        View view = this.qg;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.byazt.xdp.n
    public View getCloseButton() {
        return this.n;
    }

    @Override // com.byazt.xdp.n
    public boolean getSkipOrCloseVisible() {
        return com.byazt.okk.s.q(this.n);
    }
}
