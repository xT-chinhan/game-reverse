package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.le;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.core.t.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TopLayoutImpl extends FrameLayout implements ms<TopLayoutImpl> {
    private View ab;
    private View ah;
    private lm ao;
    private View c;
    private View ch;
    private View d;
    private TextView hi;
    private TextView ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private View f2244ms;
    private TextView ny;
    private View sl;
    private boolean u;
    private xr ub;
    private View x;
    private ImageView xr;
    private View zb;

    public TopLayoutImpl(Context context) {
        this(context, null);
    }

    public TopLayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void setVisible(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public TopLayoutImpl ms(lm lmVar) {
        this.ao = lmVar;
        if (t.hi(lmVar)) {
            addView(com.bytedance.sdk.openadsdk.res.ka.ab(getContext()));
        } else {
            addView(com.bytedance.sdk.openadsdk.res.ka.c(getContext()));
        }
        this.f2244ms = findViewById(2114387851);
        this.xr = (ImageView) findViewById(2114387764);
        this.ah = findViewById(2114387825);
        this.d = findViewById(2114387679);
        this.ka = (TextView) findViewById(2114387638);
        this.c = findViewById(2114387719);
        this.ab = findViewById(2114387951);
        this.x = findViewById(2114387731);
        this.ny = (TextView) findViewById(2114387612);
        this.ch = findViewById(2114387641);
        this.hi = (TextView) findViewById(2114387791);
        this.sl = findViewById(2114387744);
        this.zb = findViewById(2114387930);
        View view = this.ch;
        if (view != null) {
            view.setEnabled(false);
            this.ch.setClickable(false);
        }
        d();
        return this;
    }

    private void d() {
        ul.ms(this.f2244ms, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.ub != null) {
                    TopLayoutImpl.this.ub.ah(view);
                }
            }
        }, "top_dislike_button");
        ul.ms(this.xr, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopLayoutImpl topLayoutImpl = TopLayoutImpl.this;
                topLayoutImpl.u = !topLayoutImpl.u;
                com.bytedance.sdk.component.utils.t.ms(TopLayoutImpl.this.getContext(), TopLayoutImpl.this.u ? "tt_mute" : "tt_unmute", TopLayoutImpl.this.xr);
                if (TopLayoutImpl.this.ub != null) {
                    TopLayoutImpl.this.ub.xr(view);
                }
            }
        }, "top_mute_button");
        ul.ms(this.ab, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "top_before_button");
        ul.ms(this.ch, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("topListener", TopLayoutImpl.this.ub);
                    jSONObject.put("topImpl", 1);
                } catch (Throwable unused) {
                }
                if (!le.ms(TopLayoutImpl.this.ao) || com.bytedance.sdk.openadsdk.core.u.d.ms(String.valueOf(f.ny(TopLayoutImpl.this.ao)))) {
                    u.ms().ms(TopLayoutImpl.this.ao, "stats_reward_full_click_native_close", jSONObject);
                }
                if (TopLayoutImpl.this.ub != null) {
                    TopLayoutImpl.this.ub.ms(view);
                }
            }
        }, "top_skip_button");
        ul.ms(this.ah, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.ub != null) {
                    TopLayoutImpl.this.ub.d(view);
                }
            }
        }, "top_back_button");
        ul.ms(this.d, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.ub != null) {
                    TopLayoutImpl.this.ub.ka(view);
                }
            }
        }, "top_again_button");
        ul.ms(this.c, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.ub != null) {
                    TopLayoutImpl.this.ub.c(view);
                }
            }
        }, "top_skip_border");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void setShowSound(boolean z) {
        ImageView imageView = this.xr;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void setSoundMute(boolean z) {
        this.u = z;
        com.bytedance.sdk.component.utils.t.ms(getContext(), this.u ? "tt_mute" : "tt_unmute", this.xr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void setShowBack(boolean z) {
        View view = this.ah;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void ms(boolean z, String str, String str2, boolean z2, boolean z3) {
        ul.ms(this.c, 0);
        boolean z4 = z || !TextUtils.isEmpty(str);
        boolean z5 = z2 || !TextUtils.isEmpty(str2);
        boolean z6 = z4 && z5;
        ul.ms(this.c, (z4 || z5) ? 0 : 4);
        ul.ms(this.ab, z4 ? 0 : 8);
        ul.ms(this.ch, z5 ? 0 : 8);
        ul.ms(this.zb, z6 ? 0 : 8);
        ul.ms(this.x, z ? 0 : 8);
        ul.ms((View) this.ny, !TextUtils.isEmpty(str) ? 0 : 8);
        ul.ms(this.sl, z2 ? 0 : 8);
        ul.ms((View) this.hi, TextUtils.isEmpty(str2) ? 8 : 0);
        if (!TextUtils.isEmpty(str)) {
            ul.ms(this.ny, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            ul.ms(this.hi, str2);
        }
        View view = this.ch;
        if (view != null) {
            view.setEnabled(z3);
            this.ch.setClickable(z3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void setShowDislike(boolean z) {
        View view = this.f2244ms;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void setListener(xr xrVar) {
        this.ub = xrVar;
    }

    public xr getTopListener() {
        return this.ub;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void ms() {
        View view = this.ch;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void xr() {
        ImageView imageView = this.xr;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void ah() {
        View view = this.f2244ms;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public View getCloseButton() {
        return this.ch;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public boolean getSkipOrCloseVisible() {
        return ul.d(this.ch) || (this.c != null && ul.d(this.hi) && !TextUtils.isEmpty(this.hi.getText()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void setShowAgain(boolean z) {
        ul.ms(this.d, z ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void setPlayAgainEntranceText(String str) {
        ul.ms(this.ka, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.ms
    public void setDislikeLeft(boolean z) {
        if (this.f2244ms.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2244ms.getLayoutParams();
            layoutParams.gravity = z ? GravityCompat.START : GravityCompat.END;
            this.f2244ms.setLayoutParams(layoutParams);
        }
    }
}
