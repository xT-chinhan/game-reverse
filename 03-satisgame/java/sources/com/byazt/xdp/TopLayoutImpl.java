package com.byazt.xdp;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.byazt.gct.cd;
import com.byazt.gct.pe;
import com.byazt.gct.pk;
import com.byazt.gct.ur;
import com.byazt.tk.sz;
import com.byazt.wd.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1162, 1163})
public class TopLayoutImpl extends FrameLayout implements n<TopLayoutImpl> {
    public boolean a;
    public View cd;
    public TextView cp;
    public TextView cy;
    public View d;
    public View fs;
    public View hd;
    public View k;
    public TextView l;
    public View n;
    public View oa;
    public pk ou;
    public qg py;
    public View q;
    public ImageView qg;
    public TextView rv;
    public View s;
    public View sz;
    public View tj;
    public TextView um;
    public View w;
    public View x;

    public TopLayoutImpl(Context context) {
        this(context, null);
    }

    public TopLayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.byazt.xdp.n
    public void setVisible(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public TopLayoutImpl n(pk pkVar) {
        this.ou = pkVar;
        if (cd.oa(pkVar)) {
            addView(com.byazt.cb.qg.fs(getContext()));
        } else if (pe.fs(this.ou)) {
            addView(com.byazt.cb.qg.x(getContext()));
        } else {
            addView(com.byazt.cb.qg.w(getContext()));
        }
        this.n = findViewById(2114387845);
        this.qg = (ImageView) findViewById(2114387758);
        this.s = findViewById(2114387819);
        this.q = findViewById(2114387673);
        this.l = (TextView) findViewById(2114387632);
        this.w = findViewById(2114387713);
        this.x = findViewById(2114387951);
        this.fs = findViewById(2114387725);
        this.rv = (TextView) findViewById(2114387606);
        this.tj = findViewById(2114387635);
        this.cp = (TextView) findViewById(2114387785);
        this.d = findViewById(2114387738);
        this.oa = findViewById(2114387924);
        this.sz = findViewById(2114387950);
        this.k = findViewById(2114387949);
        this.cy = (TextView) findViewById(2114387948);
        this.hd = findViewById(2114387947);
        this.cd = findViewById(2114387946);
        this.um = (TextView) findViewById(2114387945);
        View view = this.tj;
        if (view != null) {
            view.setEnabled(false);
            this.tj.setClickable(false);
        }
        q();
        return this;
    }

    private void q() {
        com.byazt.okk.s.n(this.n, new View.OnClickListener() { // from class: com.byazt.xdp.TopLayoutImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.py != null) {
                    TopLayoutImpl.this.py.s(view);
                }
            }
        }, "top_dislike_button");
        com.byazt.okk.s.n(this.qg, new View.OnClickListener() { // from class: com.byazt.xdp.TopLayoutImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopLayoutImpl topLayoutImpl = TopLayoutImpl.this;
                topLayoutImpl.a = !topLayoutImpl.a;
                sz.n(TopLayoutImpl.this.getContext(), TopLayoutImpl.this.a ? "tt_mute" : "tt_unmute", TopLayoutImpl.this.qg, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                if (TopLayoutImpl.this.py != null) {
                    TopLayoutImpl.this.py.qg(view);
                }
            }
        }, "top_mute_button");
        com.byazt.okk.s.n(this.x, new View.OnClickListener() { // from class: com.byazt.xdp.TopLayoutImpl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "top_before_button");
        com.byazt.okk.s.n(this.tj, new View.OnClickListener() { // from class: com.byazt.xdp.TopLayoutImpl.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("topListener", TopLayoutImpl.this.py);
                    jSONObject.put("topImpl", 1);
                } catch (Throwable unused) {
                }
                if (!ur.n(TopLayoutImpl.this.ou) || x.n(String.valueOf(com.byazt.vgx.w.cy(TopLayoutImpl.this.ou)))) {
                    com.byazt.eji.s.n().n(TopLayoutImpl.this.ou, "stats_reward_full_click_native_close", jSONObject);
                }
                if (TopLayoutImpl.this.py != null) {
                    TopLayoutImpl.this.py.n(view);
                }
            }
        }, "top_skip_button");
        com.byazt.okk.s.n(this.s, new View.OnClickListener() { // from class: com.byazt.xdp.TopLayoutImpl.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.py != null) {
                    TopLayoutImpl.this.py.q(view);
                }
            }
        }, "top_back_button");
        com.byazt.okk.s.n(this.q, new View.OnClickListener() { // from class: com.byazt.xdp.TopLayoutImpl.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.py != null) {
                    TopLayoutImpl.this.py.l(view);
                }
            }
        }, "top_again_button");
        com.byazt.okk.s.n(this.w, new View.OnClickListener() { // from class: com.byazt.xdp.TopLayoutImpl.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.py != null) {
                    TopLayoutImpl.this.py.w(view);
                }
            }
        }, "top_skip_border");
        com.byazt.okk.s.n(this.cd, new View.OnClickListener() { // from class: com.byazt.xdp.TopLayoutImpl.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.py != null) {
                    TopLayoutImpl.this.py.x(view);
                }
            }
        }, "top_next_video_cancel");
    }

    @Override // com.byazt.xdp.n
    public void setShowSound(boolean z) {
        ImageView imageView = this.qg;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.byazt.xdp.n
    public void setSoundMute(boolean z) {
        this.a = z;
        sz.n(getContext(), this.a ? "tt_mute" : "tt_unmute", this.qg, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }

    @Override // com.byazt.xdp.n
    public void setShowBack(boolean z) {
        View view = this.s;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.byazt.xdp.n
    public void n(boolean z, String str, String str2, boolean z2, boolean z3) {
        com.byazt.okk.s.n(this.w, 0);
        boolean z4 = z || !TextUtils.isEmpty(str);
        boolean z5 = z2 || !TextUtils.isEmpty(str2);
        boolean z6 = z4 && z5;
        com.byazt.okk.s.n(this.w, (z4 || z5) ? 0 : 4);
        com.byazt.okk.s.n(this.x, z4 ? 0 : 8);
        com.byazt.okk.s.n(this.tj, z5 ? 0 : 8);
        com.byazt.okk.s.n(this.oa, z6 ? 0 : 8);
        com.byazt.okk.s.n(this.fs, z ? 0 : 8);
        com.byazt.okk.s.n((View) this.rv, !TextUtils.isEmpty(str) ? 0 : 8);
        com.byazt.okk.s.n(this.d, z2 ? 0 : 8);
        com.byazt.okk.s.n((View) this.cp, TextUtils.isEmpty(str2) ? 8 : 0);
        if (!TextUtils.isEmpty(str)) {
            com.byazt.okk.s.n(this.rv, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            com.byazt.okk.s.n(this.cp, str2);
        }
        View view = this.tj;
        if (view != null) {
            view.setEnabled(z3);
            this.tj.setClickable(z3);
        }
    }

    @Override // com.byazt.xdp.n
    public void n(String str, String str2, boolean z) {
        boolean z2 = !TextUtils.isEmpty(str);
        boolean z3 = !TextUtils.isEmpty(str2);
        boolean z4 = z2 && z3;
        com.byazt.okk.s.n(this.sz, (z2 || z3) ? 0 : 4);
        com.byazt.okk.s.n(this.k, z2 ? 0 : 8);
        com.byazt.okk.s.n(this.cd, z3 ? 0 : 8);
        com.byazt.okk.s.n(this.hd, z4 ? 0 : 8);
        com.byazt.okk.s.n((View) this.cy, !TextUtils.isEmpty(str) ? 0 : 8);
        com.byazt.okk.s.n((View) this.um, TextUtils.isEmpty(str2) ? 8 : 0);
        if (!TextUtils.isEmpty(str)) {
            com.byazt.okk.s.n(this.cy, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            com.byazt.okk.s.n(this.um, str2);
        }
        View view = this.tj;
        if (view != null) {
            view.setEnabled(z);
            this.tj.setClickable(z);
        }
    }

    @Override // com.byazt.xdp.n
    public void setShowDislike(boolean z) {
        View view = this.n;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.byazt.xdp.n
    public void setListener(qg qgVar) {
        this.py = qgVar;
    }

    public qg getTopListener() {
        return this.py;
    }

    @Override // com.byazt.xdp.n
    public void n() {
        View view = this.tj;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.byazt.xdp.n
    public void qg() {
        ImageView imageView = this.qg;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    @Override // com.byazt.xdp.n
    public void s() {
        View view = this.n;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.byazt.xdp.n
    public View getCloseButton() {
        return this.tj;
    }

    @Override // com.byazt.xdp.n
    public boolean getSkipOrCloseVisible() {
        return com.byazt.okk.s.q(this.tj) || (this.w != null && com.byazt.okk.s.q(this.cp) && !TextUtils.isEmpty(this.cp.getText()));
    }

    @Override // com.byazt.xdp.n
    public void setShowAgain(boolean z) {
        com.byazt.okk.s.n(this.q, z ? 0 : 8);
    }

    @Override // com.byazt.xdp.n
    public void setPlayAgainEntranceText(String str) {
        com.byazt.okk.s.n(this.l, str);
    }

    @Override // com.byazt.xdp.n
    public void setDislikeLeft(boolean z) {
        if (this.n.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.gravity = z ? GravityCompat.START : GravityCompat.END;
            this.n.setLayoutParams(layoutParams);
        }
    }
}
