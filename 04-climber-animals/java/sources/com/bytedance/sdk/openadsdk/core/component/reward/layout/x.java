package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.hi;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.xn;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class x extends xr {
    private TextView ao;
    private boolean b;
    private ImageView h;
    private RelativeLayout nw;
    private TextView qv;
    private RelativeLayout t;
    private RelativeLayout u;
    private TextView ub;
    private TextView y;
    private RoundImageView zb;

    public x(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, boolean z) {
        super(tTBaseVideoActivity, lmVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void ms() {
        super.ms();
        this.x = (RelativeLayout) this.xr.findViewById(2114387668);
        this.ny = (FrameLayout) this.xr.findViewById(2114387760);
        this.ch = (TextView) this.xr.findViewById(2114387664);
        this.zb = (RoundImageView) this.xr.findViewById(2114387888);
        this.u = (RelativeLayout) this.xr.findViewById(2114387917);
        this.ub = (TextView) this.xr.findViewById(2114387927);
        this.ao = (TextView) this.xr.findViewById(2114387856);
        this.h = (ImageView) this.xr.findViewById(2114387887);
        this.qv = (TextView) this.xr.findViewById(2114387787);
        this.y = (TextView) this.xr.findViewById(2114387646);
        this.t = (RelativeLayout) this.xr.findViewById(2114387669);
        this.nw = (RelativeLayout) this.xr.findViewById(2114387841);
        this.hi = (RelativeLayout) this.xr.findViewById(2114387723);
        ul.ms(this.ch, this.ah);
        hi();
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.ah)) {
            String strNy = com.bytedance.sdk.openadsdk.core.nw.ul.ny(this.ah);
            if (!TextUtils.isEmpty(strNy) && this.zb != null) {
                ul.ms((View) this.u, 0);
                com.bytedance.sdk.openadsdk.x.xr.ms(strNy).ms(this.zb);
            } else {
                ul.ms((View) this.u, 8);
            }
            if (this.ub != null) {
                this.ub.setText(com.bytedance.sdk.openadsdk.core.nw.ul.ah(this.ah));
            }
            if (this.ao != null) {
                int iD = com.bytedance.sdk.openadsdk.core.nw.ul.d(this.ah);
                if (iD < 0) {
                    this.ao.setVisibility(4);
                    ul.ms((View) this.h, 4);
                } else {
                    this.ao.setText(String.format(t.ms(this.xr, "tt_live_fans_text"), iD > 10000 ? (iD / 10000.0f) + IAdInterListener.AdReqParam.WIDTH : String.valueOf(iD)));
                }
            }
            if (this.qv != null) {
                int iKa = com.bytedance.sdk.openadsdk.core.nw.ul.ka(this.ah);
                if (iKa < 0) {
                    this.qv.setVisibility(4);
                    ul.ms((View) this.h, 4);
                } else {
                    this.qv.setText(String.format(t.ms(this.xr, "tt_live_watch_text"), iKa > 10000 ? (iKa / 10000.0f) + IAdInterListener.AdReqParam.WIDTH : String.valueOf(iKa)));
                }
            }
            if (this.y != null) {
                this.y.setText(com.bytedance.sdk.openadsdk.core.nw.ul.c(this.ah));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void ms(com.bytedance.sdk.openadsdk.core.xr.xr xrVar, com.bytedance.sdk.openadsdk.core.xr.xr xrVar2) {
        ms(xrVar);
        ms((View.OnTouchListener) xrVar);
    }

    private void ms(View.OnTouchListener onTouchListener) {
        ul.ms(this.x, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
        ul.ms(this.ny, onTouchListener, "TTBaseVideoActivity#mVideoNativeFrame");
        ul.ms(this.y, onTouchListener, (String) null);
        ul.ms(this.ao, onTouchListener, (String) null);
        ul.ms(this.qv, onTouchListener, (String) null);
        ul.ms(this.ub, onTouchListener, (String) null);
        ul.ms(this.zb, onTouchListener, (String) null);
        ul.ms(this.hi, onTouchListener, "TTBaseVideoActivity#mLiveBtnLayout");
    }

    private void ms(com.bytedance.sdk.openadsdk.core.xr.xr xrVar) {
        ms(this.ny, xrVar, "click_live_feed");
        ms(this.y, xrVar, "click_live_author_description");
        ms(this.ao, xrVar, "click_live_author_follower_count");
        ms(this.qv, xrVar, "click_live_author_following_count");
        ms(this.ub, xrVar, "click_live_author_nickname");
        ms(this.zb, xrVar, "click_live_avata");
        ms(this.x, xrVar, "click_live_button");
        ms(this.hi, xrVar, "click_live_btn_layout");
    }

    private void ms(View view, final com.bytedance.sdk.openadsdk.core.xr.xr xrVar, final String str) {
        if (view == null || xrVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        view.setOnClickListener(new com.bytedance.sdk.openadsdk.core.xr.xr(this.xr, this.ah, this.c ? "rewarded_video" : "fullscreen_interstitial_ad", this.c ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.x.1
            @Override // com.bytedance.sdk.openadsdk.core.xr.xr, com.bytedance.sdk.openadsdk.core.xr.d
            public void ms(View view2, hi hiVar) {
                HashMap map = new HashMap();
                map.put("click_live_element", str);
                ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) xrVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(map);
                xrVar.ms(view2, hiVar);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void ah(int i) {
        ul.ms((View) this.t, i);
        ul.ms((View) this.nw, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xr
    public void d(int i) {
        if (this.b) {
            return;
        }
        ul.ms((View) this.hi, i);
    }

    public void ms(int i, int i2) {
        TextView textView;
        if (i != 0) {
            this.b = true;
            ul.ms((View) this.hi, 8);
            return;
        }
        ul.ms((View) this.hi, 0);
        if (i2 >= 0 && com.bytedance.sdk.openadsdk.core.live.xr.ms().xr(this.ah) && xn.ms(this.ah) && xn.ka(this.ah) == 3 && (textView = (TextView) this.xr.findViewById(2114387722)) != null) {
            textView.setText(String.format(t.ms(this.xr, "tt_reward_auto_jump_live"), i2 + "s"));
        }
    }
}
