package com.byazt.ck;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.ca.iu;
import com.byazt.vkw.qi;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVG_PLAY_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_AVG_DOWNLOAD_BITRATE})
public class TTCountdownViewForBtn extends LinearLayout implements qi.pr, x {
    public boolean aj;
    public pr c;
    public int fw;
    public TextView hn;
    public Context hw;
    public final iu pr;
    public AtomicBoolean uc;
    public TextView x;
    public int zo;

    public TTCountdownViewForBtn(Context context) {
        super(context);
        this.uc = new AtomicBoolean(true);
        this.pr = new iu(Looper.getMainLooper(), this);
        this.fw = 5;
        this.zo = 1;
        this.aj = false;
        this.hw = context;
        x();
    }

    private void x() {
        setOrientation(0);
        setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#99333333"));
        int iHn = er.hn(this.hw, 14.0f);
        gradientDrawable.setCornerRadius(iHn);
        int i = iHn * 2;
        gradientDrawable.setSize(i, i);
        setBackground(gradientDrawable);
        this.hn = new TextView(this.hw);
        int iHn2 = er.hn(this.hw, 6.0f);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.hn.setTextColor(-1);
        this.hn.setTextSize(2, 14.0f);
        addView(this.hn, layoutParams);
        View view = new View(this.hw);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = er.hn(this.hw, 1.0f);
        layoutParams2.height = er.hn(this.hw, 12.0f);
        layoutParams2.leftMargin = iHn2;
        layoutParams2.rightMargin = iHn2;
        view.setBackgroundColor(-1);
        addView(view, layoutParams2);
        this.x = new TextView(this.hw);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.x.setTextColor(-1);
        this.x.setTextSize(2, 14.0f);
        this.x.setText("跳过");
        addView(this.x, layoutParams3);
    }

    private void c() {
        iu iuVar = this.pr;
        if (iuVar != null) {
            iuVar.removeMessages(1);
        }
        this.zo = 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        c();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.uc.set(z);
        if (this.aj) {
            return;
        }
        if (!this.uc.get()) {
            hw();
        } else {
            hn();
        }
    }

    public void hw() {
        try {
            iu iuVar = this.pr;
            if (iuVar != null) {
                iuVar.removeMessages(1);
            }
        } catch (Throwable th) {
        }
    }

    public void hn() {
        try {
            uc();
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.ck.x
    public void pr() {
        if (this.aj) {
            return;
        }
        c();
        uc();
    }

    @Override // com.byazt.ck.x
    public void pr(boolean z) {
        this.aj = z;
        if (z) {
            c();
        }
    }

    @Override // com.byazt.ck.x
    public void setCountdownListener(pr prVar) {
        this.c = prVar;
        this.uc.get();
    }

    @Override // com.byazt.ck.x
    public void setCountDownTime(int i) {
        this.fw = i;
        fw();
        c();
    }

    @Override // com.byazt.ck.x
    public View getView() {
        return this;
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        if (message.what == 1) {
            uc();
        }
    }

    private void uc() {
        try {
            if (this.aj || this.hn == null) {
                return;
            }
            fw();
            int i = this.zo;
            if (i >= this.fw + 1) {
                pr prVar = this.c;
                if (prVar != null) {
                    prVar.pr();
                    return;
                }
                return;
            }
            this.zo = i + 1;
            this.pr.sendEmptyMessageDelayed(1, 1000L);
        } catch (Exception e) {
        }
    }

    private void fw() {
        if (this.hn != null) {
            StringBuilder sb = new StringBuilder();
            int i = this.zo;
            int i2 = this.fw;
            sb.append(i <= i2 ? i2 - i : 0).append(an.aB);
            this.hn.setText(sb.toString());
        }
    }
}
