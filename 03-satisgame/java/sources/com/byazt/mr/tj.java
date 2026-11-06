package com.byazt.mr;

import android.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends AlertDialog {
    public n cp;
    public String fs;
    public Context l;
    public TextView n;
    public Button q;
    public TextView qg;
    public String rv;
    public Button s;
    public Drawable tj;
    public String w;
    public String x;

    public interface n {
        void n(Dialog dialog);

        void qg(Dialog dialog);
    }

    public tj(Context context) {
        super(context, R.style.Theme.Dialog);
        com.byazt.cb.s.n(this);
        this.l = context;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.byazt.cb.qg.e(this.l));
        setCanceledOnTouchOutside(true);
        n();
    }

    private void n() {
        this.n = (TextView) findViewById(2114387852);
        this.qg = (TextView) findViewById(2114387654);
        this.s = (Button) findViewById(2114387751);
        this.q = (Button) findViewById(2114387889);
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.tj.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                tj.this.dismiss();
                if (tj.this.cp != null) {
                    tj.this.cp.n(tj.this);
                }
            }
        });
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.tj.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                tj.this.dismiss();
                if (tj.this.cp != null) {
                    tj.this.cp.qg(tj.this);
                }
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        qg();
    }

    private void qg() {
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(this.w);
            Drawable drawable = this.tj;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.tj.getIntrinsicHeight();
                int iS = com.byazt.okk.s.s(this.l, 45.0f);
                if (intrinsicWidth > iS || intrinsicWidth < iS) {
                    intrinsicWidth = iS;
                }
                if (intrinsicHeight > iS || intrinsicHeight < iS) {
                    intrinsicHeight = iS;
                }
                this.tj.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                this.n.setCompoundDrawables(this.tj, null, null, null);
                this.n.setCompoundDrawablePadding(com.byazt.okk.s.s(this.l, 10.0f));
            }
        }
        TextView textView2 = this.qg;
        if (textView2 != null) {
            textView2.setText(this.x);
        }
        Button button = this.s;
        if (button != null) {
            button.setText(this.fs);
        }
        Button button2 = this.q;
        if (button2 != null) {
            button2.setText(this.rv);
        }
    }

    public tj n(String str) {
        this.w = str;
        return this;
    }

    public tj qg(String str) {
        this.x = str;
        return this;
    }

    public tj s(String str) {
        this.fs = str;
        return this;
    }

    public tj q(String str) {
        this.rv = str;
        return this;
    }

    public tj n(Drawable drawable) {
        this.tj = drawable;
        return this;
    }

    public tj n(n nVar) {
        this.cp = nVar;
        return this;
    }

    public tj n(DialogInterface.OnCancelListener onCancelListener) {
        setOnCancelListener(onCancelListener);
        return this;
    }
}
