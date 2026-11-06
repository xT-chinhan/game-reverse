package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;

/* JADX INFO: loaded from: classes2.dex */
public class ch extends AlertDialog {
    private String ab;
    private Button ah;
    private String c;
    private Drawable ch;
    private Button d;
    private ms hi;
    private Context ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private TextView f3710ms;
    private String ny;
    private String x;
    private TextView xr;

    public interface ms {
        void ms(Dialog dialog);

        void xr(Dialog dialog);
    }

    public ch(Context context) {
        super(context, t.ab(context, "tt_custom_dialog"));
        this.ka = context;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.ka.ti(this.ka));
        setCanceledOnTouchOutside(true);
        ms();
    }

    private void ms() {
        this.f3710ms = (TextView) findViewById(2114387858);
        this.xr = (TextView) findViewById(2114387660);
        this.ah = (Button) findViewById(2114387757);
        this.d = (Button) findViewById(2114387895);
        this.ah.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ch.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ch.this.dismiss();
                if (ch.this.hi != null) {
                    ch.this.hi.ms(ch.this);
                }
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ch.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ch.this.dismiss();
                if (ch.this.hi != null) {
                    ch.this.hi.xr(ch.this);
                }
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        xr();
    }

    private void xr() {
        TextView textView = this.f3710ms;
        if (textView != null) {
            textView.setText(this.c);
            Drawable drawable = this.ch;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.ch.getIntrinsicHeight();
                int iAh = ul.ah(this.ka, 45.0f);
                if (intrinsicWidth > iAh || intrinsicWidth < iAh) {
                    intrinsicWidth = iAh;
                }
                if (intrinsicHeight > iAh || intrinsicHeight < iAh) {
                    intrinsicHeight = iAh;
                }
                this.ch.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                this.f3710ms.setCompoundDrawables(this.ch, null, null, null);
                this.f3710ms.setCompoundDrawablePadding(ul.ah(this.ka, 10.0f));
            }
        }
        TextView textView2 = this.xr;
        if (textView2 != null) {
            textView2.setText(this.ab);
        }
        Button button = this.ah;
        if (button != null) {
            button.setText(this.x);
        }
        Button button2 = this.d;
        if (button2 != null) {
            button2.setText(this.ny);
        }
    }

    public ch ms(String str) {
        this.c = str;
        return this;
    }

    public ch xr(String str) {
        this.ab = str;
        return this;
    }

    public ch ah(String str) {
        this.x = str;
        return this;
    }

    public ch d(String str) {
        this.ny = str;
        return this;
    }

    public ch ms(Drawable drawable) {
        this.ch = drawable;
        return this;
    }

    public ch ms(ms msVar) {
        this.hi = msVar;
        return this;
    }

    public ch ms(DialogInterface.OnCancelListener onCancelListener) {
        setOnCancelListener(onCancelListener);
        return this;
    }
}
