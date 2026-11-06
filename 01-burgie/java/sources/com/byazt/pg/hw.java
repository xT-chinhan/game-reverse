package com.byazt.pg;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.byazt.ca.iu;
import com.byazt.hg.f;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.byazt.sdv.c;
import com.byazt.vkw.qi;
import com.byazt.wt.er;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 90, 13})
public class hw extends AlertDialog implements qi.pr {
    public long aj;
    public TextView c;
    public final String fw;
    public Context hn;
    public final iu hw;
    public com.byazt.az.hw pr;
    public TextView uc;
    public boolean vk;
    public TextView x;
    public final pr zo;

    public interface pr {
        void hw(Dialog dialog);

        void pr(Dialog dialog);
    }

    public hw(Context context, of ofVar, pr prVar) {
        super(context);
        this.hw = new iu(Looper.getMainLooper(), this);
        this.vk = false;
        this.hn = context;
        if (context == null) {
            this.hn = a.getContext();
        }
        this.fw = f.uc(ofVar);
        this.zo = prVar;
        if (f.c(ofVar) == 3) {
            this.vk = true;
            this.aj = 5L;
        } else {
            this.aj = f.zo(ofVar);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(c.s(this.hn));
        setCanceledOnTouchOutside(false);
        pr();
        this.hw.sendEmptyMessageDelayed(101, 1000L);
    }

    private void pr() {
        this.x = (TextView) findViewById(2114387826);
        this.c = (TextView) findViewById(2114387638);
        this.uc = (TextView) findViewById(2114387833);
        if (this.zo == null) {
            return;
        }
        er.pr((View) this.c, (View.OnClickListener) this.pr, "goLiveListener");
        er.pr(this.uc, new View.OnClickListener() { // from class: com.byazt.pg.hw.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hw.this.zo.pr(hw.this);
            }
        }, "cancelTv");
    }

    public void pr(com.byazt.az.hw hwVar) {
        this.pr = hwVar;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        er.pr(this.x, this.fw);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.hw.removeMessages(101);
            this.hw.sendEmptyMessageDelayed(101, 1000L);
        } else {
            this.hw.removeMessages(101);
        }
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        pr prVar;
        if (message.what == 101) {
            long j = this.aj - 1;
            this.aj = j;
            if (j <= 0) {
                if (this.vk && (prVar = this.zo) != null) {
                    prVar.hw(this);
                }
                pr prVar2 = this.zo;
                if (prVar2 != null) {
                    prVar2.pr(this);
                    return;
                }
                return;
            }
            if (this.vk) {
                er.pr(this.uc, "残忍拒绝");
            } else {
                er.pr(this.uc, String.format("残忍拒绝(%1$s)", String.valueOf(j)));
            }
            this.hw.sendEmptyMessageDelayed(101, 1000L);
        }
    }
}
