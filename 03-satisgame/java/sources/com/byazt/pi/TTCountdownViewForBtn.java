package com.byazt.pi;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.tk.t;
import com.byazt.vf.wo;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 743, 744})
public class TTCountdownViewForBtn extends LinearLayout implements wo.n, q {
    public int fs;
    public n l;
    public final t n;
    public TextView q;
    public Context qg;
    public int rv;
    public TextView s;
    public boolean tj;
    public AtomicBoolean w;
    public final AtomicBoolean x;

    @Override // com.byazt.pi.q
    public View getView() {
        return this;
    }

    public TTCountdownViewForBtn(Context context) {
        super(context);
        this.w = new AtomicBoolean(true);
        this.x = new AtomicBoolean(false);
        this.n = new t(Looper.getMainLooper(), this);
        this.fs = 5;
        this.rv = 1;
        this.tj = false;
        this.qg = context;
        w();
    }

    private void w() {
        setOrientation(0);
        setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#99333333"));
        int iS = com.byazt.okk.s.s(this.qg, 14.0f);
        gradientDrawable.setCornerRadius(iS);
        int i = iS * 2;
        gradientDrawable.setSize(i, i);
        setBackground(gradientDrawable);
        this.s = new TextView(this.qg);
        int iS2 = com.byazt.okk.s.s(this.qg, 6.0f);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.s.setTextColor(-1);
        this.s.setTextSize(2, 14.0f);
        addView(this.s, layoutParams);
        View view = new View(this.qg);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = com.byazt.okk.s.s(this.qg, 1.0f);
        layoutParams2.height = com.byazt.okk.s.s(this.qg, 12.0f);
        layoutParams2.leftMargin = iS2;
        layoutParams2.rightMargin = iS2;
        view.setBackgroundColor(-1);
        addView(view, layoutParams2);
        this.q = new TextView(this.qg);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.q.setTextColor(-1);
        this.q.setTextSize(2, 14.0f);
        this.q.setText("跳过");
        addView(this.q, layoutParams3);
    }

    private void x() {
        t tVar = this.n;
        if (tVar != null) {
            tVar.removeMessages(1);
        }
        this.rv = 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        x();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.w.set(z);
        if (this.tj) {
            return;
        }
        if (!this.w.get()) {
            q();
        } else {
            if (this.x.get()) {
                return;
            }
            l();
        }
    }

    @Override // com.byazt.pi.q
    public void qg() {
        this.x.set(true);
        q();
    }

    @Override // com.byazt.pi.q
    public void s() {
        this.x.set(false);
        if (this.w.get()) {
            l();
        }
    }

    public void q() {
        try {
            t tVar = this.n;
            if (tVar != null) {
                tVar.removeMessages(1);
            }
        } catch (Throwable unused) {
        }
    }

    public void l() {
        try {
            fs();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.pi.q
    public void n() {
        if (this.tj) {
            return;
        }
        x();
        fs();
    }

    @Override // com.byazt.pi.q
    public void n(boolean z) {
        this.tj = z;
        if (z) {
            x();
        }
    }

    @Override // com.byazt.pi.q
    public void setCountdownListener(n nVar) {
        this.l = nVar;
        this.w.get();
    }

    @Override // com.byazt.pi.q
    public void setCountDownTime(int i) {
        this.fs = i;
        rv();
        x();
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        if (message.what == 1) {
            fs();
        }
    }

    private void fs() {
        try {
            if (this.tj || this.s == null) {
                return;
            }
            rv();
            int i = this.rv;
            if (i >= this.fs + 1) {
                n nVar = this.l;
                if (nVar != null) {
                    nVar.n();
                    return;
                }
                return;
            }
            this.rv = i + 1;
            this.n.sendEmptyMessageDelayed(1, 1000L);
        } catch (Exception unused) {
        }
    }

    private void rv() {
        if (this.s != null) {
            StringBuilder sb = new StringBuilder();
            int i = this.rv;
            int i2 = this.fs;
            sb.append(i <= i2 ? i2 - i : 0).append(com.anythink.core.common.s.a);
            this.s.setText(sb.toString());
        }
    }
}
