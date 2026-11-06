package com.bytedance.sdk.openadsdk.core.component.splash.countdown;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class TTCountdownViewForBtn extends LinearLayout implements le.ms, d {
    private int ab;
    private TextView ah;
    private AtomicBoolean c;
    private TextView d;
    private ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final le f2377ms;
    private boolean ny;
    private int x;
    private Context xr;

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.d
    public View getView() {
        return this;
    }

    public TTCountdownViewForBtn(Context context) {
        super(context);
        this.c = new AtomicBoolean(true);
        this.f2377ms = new le(Looper.getMainLooper(), this);
        this.ab = 5;
        this.x = 1;
        this.ny = false;
        this.xr = context;
        d();
    }

    private void d() {
        setOrientation(0);
        setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#99333333"));
        int iAh = ul.ah(this.xr, 14.0f);
        gradientDrawable.setCornerRadius(iAh);
        int i = iAh * 2;
        gradientDrawable.setSize(i, i);
        setBackground(gradientDrawable);
        this.ah = new TextView(this.xr);
        int iAh2 = ul.ah(this.xr, 6.0f);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.ah.setTextColor(-1);
        this.ah.setTextSize(2, 14.0f);
        addView(this.ah, layoutParams);
        View view = new View(this.xr);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = ul.ah(this.xr, 1.0f);
        layoutParams2.height = ul.ah(this.xr, 12.0f);
        layoutParams2.leftMargin = iAh2;
        layoutParams2.rightMargin = iAh2;
        view.setBackgroundColor(-1);
        addView(view, layoutParams2);
        this.d = new TextView(this.xr);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.d.setTextColor(-1);
        this.d.setTextSize(2, 14.0f);
        this.d.setText("跳过");
        addView(this.d, layoutParams3);
    }

    private void ka() {
        le leVar = this.f2377ms;
        if (leVar != null) {
            leVar.removeMessages(1);
        }
        this.x = 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ka();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.c.set(z);
        if (this.ny) {
            return;
        }
        if (!this.c.get()) {
            xr();
        } else {
            ah();
        }
    }

    public void xr() {
        try {
            le leVar = this.f2377ms;
            if (leVar != null) {
                leVar.removeMessages(1);
            }
        } catch (Throwable unused) {
        }
    }

    public void ah() {
        try {
            c();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.d
    public void ms() {
        if (this.ny) {
            return;
        }
        ka();
        c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.d
    public void ms(boolean z) {
        this.ny = z;
        if (z) {
            ka();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.d
    public void setCountdownListener(ms msVar) {
        this.ka = msVar;
        this.c.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.d
    public void setCountDownTime(int i) {
        this.ab = i;
        ab();
        ka();
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        if (message.what == 1) {
            c();
        }
    }

    private void c() {
        try {
            if (this.ny || this.ah == null) {
                return;
            }
            ab();
            int i = this.x;
            if (i >= this.ab + 1) {
                ms msVar = this.ka;
                if (msVar != null) {
                    msVar.ms();
                    return;
                }
                return;
            }
            this.x = i + 1;
            this.f2377ms.sendEmptyMessageDelayed(1, 1000L);
        } catch (Exception unused) {
        }
    }

    private void ab() {
        if (this.ah != null) {
            StringBuilder sb = new StringBuilder();
            int i = this.x;
            int i2 = this.ab;
            sb.append(i <= i2 ? i2 - i : 0).append("s");
            this.ah.setText(sb.toString());
        }
    }
}
