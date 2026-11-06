package com.byazt.icw;

import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.ca.g;
import com.byazt.dt.fw;
import com.byazt.hg.lb;
import com.byazt.hg.o;
import com.byazt.hg.of;
import com.byazt.hg.ve;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR, 1083})
public class TopLayoutImpl extends FrameLayout implements pr<TopLayoutImpl> {
    public boolean a;
    public TextView aj;
    public TextView c;
    public hw cz;
    public View fw;
    public View g;
    public View hn;
    public View ho;
    public ImageView hw;
    public View k;
    public View lb;
    public View m;
    public TextView nt;
    public of ny;
    public View pr;
    public TextView qa;
    public View uc;
    public View vk;
    public TextView w;
    public View x;
    public View yb;
    public View zo;

    public TopLayoutImpl(Context context) {
        this(context, null);
    }

    public TopLayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.byazt.icw.pr
    public void setVisible(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public TopLayoutImpl pr(of ofVar) {
        this.ny = ofVar;
        if (lb.m(ofVar)) {
            addView(com.byazt.sdv.c.zo(getContext()));
        } else if (o.zo(this.ny)) {
            addView(com.byazt.sdv.c.fw(getContext()));
        } else {
            addView(com.byazt.sdv.c.uc(getContext()));
        }
        this.pr = findViewById(2114387845);
        this.hw = (ImageView) findViewById(2114387758);
        this.hn = findViewById(2114387819);
        this.x = findViewById(2114387673);
        this.c = (TextView) findViewById(2114387632);
        this.uc = findViewById(2114387713);
        this.fw = findViewById(2114387951);
        this.zo = findViewById(2114387725);
        this.aj = (TextView) findViewById(2114387606);
        this.vk = findViewById(2114387635);
        this.w = (TextView) findViewById(2114387785);
        this.k = findViewById(2114387738);
        this.m = findViewById(2114387924);
        this.g = findViewById(2114387950);
        this.ho = findViewById(2114387949);
        this.nt = (TextView) findViewById(2114387948);
        this.yb = findViewById(2114387947);
        this.lb = findViewById(2114387946);
        this.qa = (TextView) findViewById(2114387945);
        View view = this.vk;
        if (view != null) {
            view.setEnabled(false);
            this.vk.setClickable(false);
        }
        x();
        return this;
    }

    private void x() {
        er.pr(this.pr, new View.OnClickListener() { // from class: com.byazt.icw.TopLayoutImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.cz != null) {
                    TopLayoutImpl.this.cz.hn(view);
                }
            }
        }, "top_dislike_button");
        er.pr(this.hw, new View.OnClickListener() { // from class: com.byazt.icw.TopLayoutImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopLayoutImpl topLayoutImpl = TopLayoutImpl.this;
                topLayoutImpl.a = !topLayoutImpl.a;
                g.pr(TopLayoutImpl.this.getContext(), TopLayoutImpl.this.a ? "tt_mute" : "tt_unmute", TopLayoutImpl.this.hw, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                if (TopLayoutImpl.this.cz != null) {
                    TopLayoutImpl.this.cz.hw(view);
                }
            }
        }, "top_mute_button");
        er.pr(this.fw, new View.OnClickListener() { // from class: com.byazt.icw.TopLayoutImpl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "top_before_button");
        er.pr(this.vk, new View.OnClickListener() { // from class: com.byazt.icw.TopLayoutImpl.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("topListener", TopLayoutImpl.this.cz);
                    jSONObject.put("topImpl", 1);
                } catch (Throwable th) {
                }
                if (!ve.pr(TopLayoutImpl.this.ny) || fw.pr(String.valueOf(ls.m(TopLayoutImpl.this.ny)))) {
                    com.byazt.xk.hw.pr().pr(TopLayoutImpl.this.ny, "stats_reward_full_click_native_close", jSONObject);
                }
                if (TopLayoutImpl.this.cz != null) {
                    TopLayoutImpl.this.cz.pr(view);
                }
            }
        }, "top_skip_button");
        er.pr(this.hn, new View.OnClickListener() { // from class: com.byazt.icw.TopLayoutImpl.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.cz != null) {
                    TopLayoutImpl.this.cz.x(view);
                }
            }
        }, "top_back_button");
        er.pr(this.x, new View.OnClickListener() { // from class: com.byazt.icw.TopLayoutImpl.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.cz != null) {
                    TopLayoutImpl.this.cz.c(view);
                }
            }
        }, "top_again_button");
        er.pr(this.uc, new View.OnClickListener() { // from class: com.byazt.icw.TopLayoutImpl.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.cz != null) {
                    TopLayoutImpl.this.cz.uc(view);
                }
            }
        }, "top_skip_border");
        er.pr(this.lb, new View.OnClickListener() { // from class: com.byazt.icw.TopLayoutImpl.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.cz != null) {
                    TopLayoutImpl.this.cz.fw(view);
                }
            }
        }, "top_next_video_cancel");
    }

    @Override // com.byazt.icw.pr
    public void setShowSound(boolean z) {
        ImageView imageView = this.hw;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.byazt.icw.pr
    public void setSoundMute(boolean z) {
        this.a = z;
        g.pr(getContext(), this.a ? "tt_mute" : "tt_unmute", this.hw, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }

    @Override // com.byazt.icw.pr
    public void setShowBack(boolean z) {
        View view = this.hn;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.byazt.icw.pr
    public void pr(boolean z, String str, String str2, boolean z2, boolean z3) {
        er.pr(this.uc, 0);
        boolean z4 = z || !TextUtils.isEmpty(str);
        boolean z5 = z2 || !TextUtils.isEmpty(str2);
        boolean z6 = z4 && z5;
        er.pr(this.uc, (z4 || z5) ? 0 : 4);
        er.pr(this.fw, z4 ? 0 : 8);
        er.pr(this.vk, z5 ? 0 : 8);
        er.pr(this.m, z6 ? 0 : 8);
        er.pr(this.zo, z ? 0 : 8);
        er.pr((View) this.aj, !TextUtils.isEmpty(str) ? 0 : 8);
        er.pr(this.k, z2 ? 0 : 8);
        er.pr((View) this.w, TextUtils.isEmpty(str2) ? 8 : 0);
        if (!TextUtils.isEmpty(str)) {
            er.pr(this.aj, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            er.pr(this.w, str2);
        }
        View view = this.vk;
        if (view != null) {
            view.setEnabled(z3);
            this.vk.setClickable(z3);
        }
    }

    @Override // com.byazt.icw.pr
    public void pr(String str, String str2, boolean z) {
        boolean z2 = !TextUtils.isEmpty(str);
        boolean z3 = !TextUtils.isEmpty(str2);
        boolean z4 = z2 && z3;
        er.pr(this.g, (z2 || z3) ? 0 : 4);
        er.pr(this.ho, z2 ? 0 : 8);
        er.pr(this.lb, z3 ? 0 : 8);
        er.pr(this.yb, z4 ? 0 : 8);
        er.pr((View) this.nt, !TextUtils.isEmpty(str) ? 0 : 8);
        er.pr((View) this.qa, TextUtils.isEmpty(str2) ? 8 : 0);
        if (!TextUtils.isEmpty(str)) {
            er.pr(this.nt, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            er.pr(this.qa, str2);
        }
        View view = this.vk;
        if (view != null) {
            view.setEnabled(z);
            this.vk.setClickable(z);
        }
    }

    @Override // com.byazt.icw.pr
    public void setShowDislike(boolean z) {
        View view = this.pr;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.byazt.icw.pr
    public void setListener(hw hwVar) {
        this.cz = hwVar;
    }

    public hw getTopListener() {
        return this.cz;
    }

    @Override // com.byazt.icw.pr
    public void pr() {
        View view = this.vk;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.byazt.icw.pr
    public void hw() {
        ImageView imageView = this.hw;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    @Override // com.byazt.icw.pr
    public void hn() {
        View view = this.pr;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.byazt.icw.pr
    public View getCloseButton() {
        return this.vk;
    }

    @Override // com.byazt.icw.pr
    public boolean getSkipOrCloseVisible() {
        boolean z = (this.uc == null || !er.x(this.w) || TextUtils.isEmpty(this.w.getText())) ? false : true;
        return er.x(this.vk) || z;
    }

    @Override // com.byazt.icw.pr
    public void setShowAgain(boolean z) {
        er.pr(this.x, z ? 0 : 8);
    }

    @Override // com.byazt.icw.pr
    public void setPlayAgainEntranceText(String str) {
        er.pr(this.c, str);
    }

    @Override // com.byazt.icw.pr
    public void setDislikeLeft(boolean z) {
        if (this.pr.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.pr.getLayoutParams();
            layoutParams.gravity = z ? GravityCompat.START : GravityCompat.END;
            this.pr.setLayoutParams(layoutParams);
        }
    }
}
