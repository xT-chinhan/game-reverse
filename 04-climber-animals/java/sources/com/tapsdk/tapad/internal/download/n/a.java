package com.tapsdk.tapad.internal.download.n;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.tapsdk.tapad.R;

/* JADX INFO: loaded from: classes3.dex */
public class a extends Dialog {
    e a;
    f b;

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.download.n.a$a, reason: collision with other inner class name */
    class ViewOnClickListenerC0614a implements View.OnClickListener {
        ViewOnClickListenerC0614a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.b.b();
            a.this.dismiss();
        }
    }

    class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            f fVar = a.this.b;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    class d implements DialogInterface.OnCancelListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            f fVar = a.this.b;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    public static class e {
        String a;
        String b;

        /* JADX INFO: renamed from: com.tapsdk.tapad.internal.download.n.a$e$a, reason: collision with other inner class name */
        public static final class C0615a {
            private String a;
            private String b;

            public C0615a a(String str) {
                this.b = str;
                return this;
            }

            public e a() {
                return new e(this, null);
            }

            public C0615a b(String str) {
                this.a = str;
                return this;
            }
        }

        private e(C0615a c0615a) {
            this.a = c0615a.b;
            this.b = c0615a.a;
        }

        /* synthetic */ e(C0615a c0615a, ViewOnClickListenerC0614a viewOnClickListenerC0614a) {
            this(c0615a);
        }
    }

    public interface f {
        void a();

        void b();
    }

    public a(Context context) {
        super(context);
    }

    public a(Context context, int i) {
        super(context, i);
    }

    public a(Context context, e eVar, f fVar) {
        super(context);
        this.a = eVar;
        this.b = fVar;
    }

    protected a(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.a == null) {
            dismiss();
        }
        setContentView(R.layout.tapad_apk_open_dialog);
        ((TextView) findViewById(R.id.tapad_open_dialog_app_name)).setText(this.a.b);
        ImageView imageView = (ImageView) findViewById(R.id.tapad_open_dialog_app_icon);
        if (!TextUtils.isEmpty(this.a.a)) {
            Glide.with(imageView).load(this.a.a).into(imageView);
        }
        findViewById(R.id.tapad_open_dialog_exit).setOnClickListener(new ViewOnClickListenerC0614a());
        findViewById(R.id.tapad_open_dialog_btn).setOnClickListener(new b());
        setOnDismissListener(new c());
        setOnCancelListener(new d());
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }
}
