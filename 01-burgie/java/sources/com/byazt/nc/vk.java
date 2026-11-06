package com.byazt.nc;

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
import com.byazt.wt.er;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 52, 50})
public class vk extends AlertDialog {
    public String aj;
    public Context c;
    public String fw;
    public Button hn;
    public TextView hw;
    public TextView pr;
    public String uc;
    public Drawable vk;
    public pr w;
    public Button x;
    public String zo;

    public interface pr {
        void hw(Dialog dialog);

        void pr(Dialog dialog);
    }

    public vk(Context context) {
        super(context, R.style.Theme.Dialog);
        com.byazt.sdv.uc.pr(this);
        this.c = context;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.byazt.sdv.c.l(this.c));
        setCanceledOnTouchOutside(true);
        pr();
    }

    private void pr() {
        this.pr = (TextView) findViewById(2114387852);
        this.hw = (TextView) findViewById(2114387654);
        this.hn = (Button) findViewById(2114387751);
        this.x = (Button) findViewById(2114387889);
        this.hn.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.vk.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                vk.this.dismiss();
                if (vk.this.w != null) {
                    vk.this.w.pr(vk.this);
                }
            }
        });
        this.x.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.vk.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                vk.this.dismiss();
                if (vk.this.w != null) {
                    vk.this.w.hw(vk.this);
                }
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        hw();
    }

    private void hw() {
        TextView textView = this.pr;
        if (textView != null) {
            textView.setText(this.uc);
            Drawable drawable = this.vk;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.vk.getIntrinsicHeight();
                int iHn = er.hn(this.c, 45.0f);
                if (intrinsicWidth > iHn || intrinsicWidth < iHn) {
                    intrinsicWidth = iHn;
                }
                if (intrinsicHeight > iHn || intrinsicHeight < iHn) {
                    intrinsicHeight = iHn;
                }
                this.vk.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                this.pr.setCompoundDrawables(this.vk, null, null, null);
                this.pr.setCompoundDrawablePadding(er.hn(this.c, 10.0f));
            }
        }
        TextView textView2 = this.hw;
        if (textView2 != null) {
            textView2.setText(this.fw);
        }
        Button button = this.hn;
        if (button != null) {
            button.setText(this.zo);
        }
        Button button2 = this.x;
        if (button2 != null) {
            button2.setText(this.aj);
        }
    }

    public vk pr(String str) {
        this.uc = str;
        return this;
    }

    public vk hw(String str) {
        this.fw = str;
        return this;
    }

    public vk hn(String str) {
        this.zo = str;
        return this;
    }

    public vk x(String str) {
        this.aj = str;
        return this;
    }

    public vk pr(Drawable drawable) {
        this.vk = drawable;
        return this;
    }

    public vk pr(pr prVar) {
        this.w = prVar;
        return this;
    }

    public vk pr(DialogInterface.OnCancelListener onCancelListener) {
        setOnCancelListener(onCancelListener);
        return this;
    }
}
