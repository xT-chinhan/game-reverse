package com.byazt.xk;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.byazt.gct.e;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.okk.s;
import com.byazt.tk.t;
import com.byazt.vf.wo;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 92, 26})
public class qg extends AlertDialog implements wo.n {
    public final n fs;
    public TextView l;
    public com.byazt.ys.qg n;
    public TextView q;
    public final t qg;
    public long rv;
    public Context s;
    public boolean tj;
    public TextView w;
    public final String x;

    public interface n {
        void n(Dialog dialog);

        void qg(Dialog dialog);
    }

    public qg(Context context, pk pkVar, n nVar) {
        super(context);
        this.qg = new t(Looper.getMainLooper(), this);
        this.tj = false;
        this.s = context;
        if (context == null) {
            this.s = rv.getContext();
        }
        this.x = e.w(pkVar);
        this.fs = nVar;
        if (e.l(pkVar) == 3) {
            this.tj = true;
            this.rv = 5L;
        } else {
            this.rv = e.fs(pkVar);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.byazt.cb.qg.ae(this.s));
        setCanceledOnTouchOutside(false);
        n();
        this.qg.sendEmptyMessageDelayed(101, 1000L);
    }

    private void n() {
        this.q = (TextView) findViewById(2114387826);
        this.l = (TextView) findViewById(2114387638);
        this.w = (TextView) findViewById(2114387833);
        if (this.fs == null) {
            return;
        }
        s.n((View) this.l, (View.OnClickListener) this.n, "goLiveListener");
        s.n(this.w, new View.OnClickListener() { // from class: com.byazt.xk.qg.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                qg.this.fs.n(qg.this);
            }
        }, "cancelTv");
    }

    public void n(com.byazt.ys.qg qgVar) {
        this.n = qgVar;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        s.n(this.q, this.x);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.qg.removeMessages(101);
            this.qg.sendEmptyMessageDelayed(101, 1000L);
        } else {
            this.qg.removeMessages(101);
        }
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        n nVar;
        if (message.what == 101) {
            long j = this.rv - 1;
            this.rv = j;
            if (j <= 0) {
                if (this.tj && (nVar = this.fs) != null) {
                    nVar.qg(this);
                }
                n nVar2 = this.fs;
                if (nVar2 != null) {
                    nVar2.n(this);
                    return;
                }
                return;
            }
            if (this.tj) {
                s.n(this.w, "残忍拒绝");
            } else {
                s.n(this.w, String.format("残忍拒绝(%1$s)", String.valueOf(j)));
            }
            this.qg.sendEmptyMessageDelayed(101, 1000L);
        }
    }
}
