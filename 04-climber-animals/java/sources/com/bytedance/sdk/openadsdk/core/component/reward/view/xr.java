package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.xn;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.res.ka;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends AlertDialog implements le.ms {
    private final String ab;
    private Context ah;
    private TextView c;
    private boolean ch;
    private TextView d;
    private TextView ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.xr.xr f2289ms;
    private long ny;
    private final ms x;
    protected final le xr;

    public interface ms {
        void ms(Dialog dialog);

        void xr(Dialog dialog);
    }

    public xr(Context context, lm lmVar, ms msVar) {
        super(context);
        this.xr = new le(Looper.getMainLooper(), this);
        this.ch = false;
        this.ah = context;
        if (context == null) {
            this.ah = re.getContext();
        }
        this.ab = xn.c(lmVar);
        this.x = msVar;
        if (xn.ka(lmVar) == 3) {
            this.ch = true;
            this.ny = 5L;
        } else {
            this.ny = xn.x(lmVar);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ka.jw(this.ah));
        setCanceledOnTouchOutside(false);
        ms();
        this.xr.sendEmptyMessageDelayed(101, 1000L);
    }

    private void ms() {
        this.d = (TextView) findViewById(2114387832);
        this.ka = (TextView) findViewById(2114387644);
        this.c = (TextView) findViewById(2114387839);
        if (this.x == null) {
            return;
        }
        ul.ms((View) this.ka, (View.OnClickListener) this.f2289ms, "goLiveListener");
        ul.ms(this.c, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.xr.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xr.this.x.ms(xr.this);
            }
        }, "cancelTv");
    }

    public void ms(com.bytedance.sdk.openadsdk.core.xr.xr xrVar) {
        this.f2289ms = xrVar;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        ul.ms(this.d, this.ab);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.xr.removeMessages(101);
            this.xr.sendEmptyMessageDelayed(101, 1000L);
        } else {
            this.xr.removeMessages(101);
        }
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        ms msVar;
        if (message.what == 101) {
            long j = this.ny - 1;
            this.ny = j;
            if (j <= 0) {
                if (this.ch && (msVar = this.x) != null) {
                    msVar.xr(this);
                }
                ms msVar2 = this.x;
                if (msVar2 != null) {
                    msVar2.ms(this);
                    return;
                }
                return;
            }
            if (this.ch) {
                ul.ms(this.c, t.ms(this.ah, "tt_reward_live_dialog_cancel_text"));
            } else {
                ul.ms(this.c, String.format(t.ms(this.ah, "tt_reward_live_dialog_cancel_count_down_text"), String.valueOf(j)));
            }
            this.xr.sendEmptyMessageDelayed(101, 1000L);
        }
    }
}
