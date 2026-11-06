package com.ss.android.downloadlib.addownload.ms;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.R;

/* JADX INFO: loaded from: classes3.dex */
public class ka extends Dialog {
    private boolean ab;
    private TextView ah;
    private ah c;
    private String ch;
    private TextView d;
    private String hi;
    private d ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private TextView f4427ms;
    private Activity ny;
    private String sl;
    private boolean x;
    private TextView xr;
    private String zb;

    public ka(Activity activity, String str, String str2, String str3, String str4, boolean z, d dVar, ah ahVar) {
        super(activity, R.style.ttdownloader_translucent_dialog);
        this.ny = activity;
        this.ka = dVar;
        this.ch = str;
        this.hi = str2;
        this.sl = str3;
        this.zb = str4;
        this.c = ahVar;
        setCanceledOnTouchOutside(z);
        d();
    }

    private void d() {
        setContentView(LayoutInflater.from(this.ny.getApplicationContext()).inflate(ms(), (ViewGroup) null));
        this.f4427ms = (TextView) findViewById(xr());
        this.xr = (TextView) findViewById(ah());
        this.ah = (TextView) findViewById(R.id.message_tv);
        this.d = (TextView) findViewById(R.id.delete_tv);
        if (!TextUtils.isEmpty(this.hi)) {
            this.f4427ms.setText(this.hi);
        }
        if (!TextUtils.isEmpty(this.sl)) {
            this.xr.setText(this.sl);
        }
        if (!TextUtils.isEmpty(this.zb)) {
            this.d.setText(this.zb);
        } else {
            this.d.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.ch)) {
            this.ah.setText(this.ch);
        }
        this.f4427ms.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.ms.ka.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ka.this.ka();
            }
        });
        this.xr.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.ms.ka.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ka.this.c();
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.ms.ka.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ka.this.delete();
            }
        });
    }

    public int ms() {
        return R.layout.ttdownloader_dialog_select_operation;
    }

    public int xr() {
        return R.id.confirm_tv;
    }

    public int ah() {
        return R.id.cancel_tv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka() {
        this.ab = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        this.x = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.ny.isFinishing()) {
            this.ny.finish();
        }
        if (this.ab) {
            this.ka.ms();
        } else if (this.x) {
            this.c.delete();
        } else {
            this.ka.xr();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public static class ms {
        private d ab;
        private String ah;
        private boolean c;
        private String d;
        private String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private Activity f4431ms;
        private ah x;
        private String xr;

        public ms(Activity activity) {
            this.f4431ms = activity;
        }

        public ms ms(String str) {
            this.xr = str;
            return this;
        }

        public ms xr(String str) {
            this.ah = str;
            return this;
        }

        public ms ah(String str) {
            this.d = str;
            return this;
        }

        public ms d(String str) {
            this.ka = str;
            return this;
        }

        public ms ms(boolean z) {
            this.c = z;
            return this;
        }

        public ms ms(d dVar) {
            this.ab = dVar;
            return this;
        }

        public ms ms(ah ahVar) {
            this.x = ahVar;
            return this;
        }

        public ka ms() {
            return new ka(this.f4431ms, this.xr, this.ah, this.d, this.ka, this.c, this.ab, this.x);
        }
    }
}
