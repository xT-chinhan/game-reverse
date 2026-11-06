package com.byazt.icw;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.hg.lb;
import com.byazt.hg.of;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR, 1316})
public class RewardBrowserMixTopLayoutImpl extends FrameLayout implements pr<RewardBrowserMixTopLayoutImpl> {
    public Context c;
    public hw hn;
    public View hw;
    public View pr;
    public of x;

    public RewardBrowserMixTopLayoutImpl(Context context) {
        this(context, null);
    }

    public RewardBrowserMixTopLayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardBrowserMixTopLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = context;
    }

    @Override // com.byazt.icw.pr
    public void setVisible(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public RewardBrowserMixTopLayoutImpl pr(of ofVar) {
        this.x = ofVar;
        addView(com.byazt.sdv.c.zo(getContext()));
        this.pr = findViewById(2114387869);
        View viewFindViewById = findViewById(2114387453);
        this.hw = findViewById(2114387454);
        if (lb.ho(ofVar)) {
            this.pr = findViewById(2114387869);
            this.hw.setVisibility(8);
            viewFindViewById.setVisibility(8);
            this.pr.setBackground(com.byazt.sdv.c.od(this.c));
        } else if (lb.nt(ofVar)) {
            findViewById(2114387738).setVisibility(8);
            this.pr = findViewById(2114387869);
        } else {
            this.pr = findViewById(2114387713);
            this.hw.setVisibility(8);
            viewFindViewById.setVisibility(8);
        }
        if (this.pr != null) {
            if (ofVar.v()) {
                this.pr.setVisibility(8);
            } else {
                this.pr.setVisibility(0);
                this.pr.setEnabled(true);
                this.pr.setClickable(true);
            }
        }
        x();
        return this;
    }

    private void x() {
        er.pr(this.pr, new View.OnClickListener() { // from class: com.byazt.icw.RewardBrowserMixTopLayoutImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("topListener", RewardBrowserMixTopLayoutImpl.this.hn);
                    jSONObject.put("topImpl", 2);
                } catch (Throwable th) {
                }
                com.byazt.xk.hw.pr().pr(RewardBrowserMixTopLayoutImpl.this.x, "stats_reward_full_click_native_close", jSONObject);
                if (RewardBrowserMixTopLayoutImpl.this.hn != null) {
                    RewardBrowserMixTopLayoutImpl.this.hn.pr(view);
                }
            }
        }, "top_skip_border");
        er.pr(this.hw, new View.OnClickListener() { // from class: com.byazt.icw.RewardBrowserMixTopLayoutImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RewardBrowserMixTopLayoutImpl.this.hn != null) {
                    RewardBrowserMixTopLayoutImpl.this.hn.hn(view);
                }
            }
        }, "top_dislike_button");
    }

    @Override // com.byazt.icw.pr
    public void setShowSound(boolean z) {
    }

    @Override // com.byazt.icw.pr
    public void setSoundMute(boolean z) {
    }

    @Override // com.byazt.icw.pr
    public void setShowBack(boolean z) {
    }

    @Override // com.byazt.icw.pr
    public void pr(boolean z, String str, String str2, boolean z2, boolean z3) {
    }

    @Override // com.byazt.icw.pr
    public void pr(String str, String str2, boolean z) {
    }

    @Override // com.byazt.icw.pr
    public void setShowDislike(boolean z) {
    }

    @Override // com.byazt.icw.pr
    public void setListener(hw hwVar) {
        this.hn = hwVar;
    }

    public hw getTopListener() {
        return this.hn;
    }

    @Override // com.byazt.icw.pr
    public void pr() {
        View view = this.pr;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.byazt.icw.pr
    public void hw() {
    }

    @Override // com.byazt.icw.pr
    public void hn() {
        View view = this.hw;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.byazt.icw.pr
    public View getCloseButton() {
        return this.pr;
    }

    @Override // com.byazt.icw.pr
    public boolean getSkipOrCloseVisible() {
        return er.x(this.pr);
    }

    @Override // com.byazt.icw.pr
    public void setShowAgain(boolean z) {
    }

    @Override // com.byazt.icw.pr
    public void setPlayAgainEntranceText(String str) {
    }

    @Override // com.byazt.icw.pr
    public void setDislikeLeft(boolean z) {
    }
}
