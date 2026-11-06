package com.mcto.sspsdk.ssp.reward;

import android.app.Dialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import com.mcto.sspsdk.internal.a4;
import com.mcto.sspsdk.internal.b4;
import com.mcto.sspsdk.internal.d;
import com.mcto.sspsdk.internal.gj;
import com.mcto.sspsdk.internal.h6;
import com.mcto.sspsdk.internal.p;
import com.mcto.sspsdk.internal.qe;
import com.mcto.sspsdk.internal.sg;
import com.mcto.sspsdk.internal.vh;
import com.mcto.sspsdk.internal.z3;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.umeng.analytics.pro.o;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Dialog implements View.OnClickListener {
    public qe a;
    public p b;
    public int c;
    public int d;
    public int e;
    public int f;
    public long g;
    public d h;
    public String i;
    public int j;
    public int k;
    public float l;
    public float m;
    public float n;
    public float o;

    public a(AppCompatActivity appCompatActivity) {
        super(appCompatActivity, R.style.qy_custom_dialog_style);
        this.c = 0;
        this.d = 0;
        this.e = 1;
        this.f = R.layout.qy_layout_exit_dialog_no_icon;
        this.i = "edg";
        this.l = -999.0f;
        this.m = -999.0f;
        this.n = -999.0f;
        this.o = -999.0f;
    }

    public final int a() {
        int iL;
        p pVar = this.b;
        int i = pVar.L0.I.c;
        vh vhVar = pVar.c;
        if (vhVar.b == null) {
            iL = 0;
        } else {
            iL = 0;
            for (int i2 = this.e; i2 < vhVar.b.size(); i2++) {
                p pVar2 = (p) vhVar.b.get(i2);
                iL += i == 2 ? pVar2.h / 1000 : pVar2.l();
            }
        }
        return i == 2 ? Math.max((this.b.h / 1000) - this.d, 0) + iL : Math.max(this.b.l() - this.d, 0) + iL;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.l = motionEvent.getX();
            this.m = motionEvent.getY();
            this.n = motionEvent.getX();
            this.o = motionEvent.getY();
            this.j = (int) motionEvent.getRawX();
            this.k = (int) motionEvent.getRawY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.a == null) {
            return;
        }
        int id = view.getId();
        a4 a4Var = new a4();
        a4Var.g = SystemClock.elapsedRealtime() - this.g;
        b4 b4Var = new b4(a4Var);
        if (id == R.id.qy_dialog_positive_btn) {
            b4Var.a = z3.FUNCTIONAL_BTN;
            b4Var.b = this.i + "_close";
            qe qeVar = this.a;
            QYExitDialog$ClickEvent qYExitDialog$ClickEvent = QYExitDialog$ClickEvent.BUTTON_POSITIVE;
            qeVar.a.b(b4Var);
            dismiss();
            if (qYExitDialog$ClickEvent == QYExitDialog$ClickEvent.BUTTON_NEGATIVE) {
                qeVar.a.i();
                return;
            }
            return;
        }
        if (id == R.id.qy_dialog_negative_btn) {
            b4Var.a = z3.FUNCTIONAL_BTN;
            b4Var.b = this.i + "_close_ad";
            qe qeVar2 = this.a;
            QYExitDialog$ClickEvent qYExitDialog$ClickEvent2 = QYExitDialog$ClickEvent.BUTTON_POSITIVE;
            qeVar2.a.b(b4Var);
            dismiss();
            qeVar2.a.i();
            return;
        }
        b4Var.a = z3.REWARD_EXIT_DIALOG;
        b4Var.l = view;
        b4Var.b = this.i + (id == R.id.qy_dialog_conversion_btn ? "_button" : "_graphic");
        b4Var.a(this.l, this.m, this.n, this.o);
        b4Var.c = this.j + "_" + this.k;
        b4Var.d = gj.a(view);
        qe qeVar3 = this.a;
        QYExitDialog$ClickEvent qYExitDialog$ClickEvent3 = QYExitDialog$ClickEvent.BUTTON_CONVERT;
        qeVar3.a.b(b4Var);
        dismiss();
        if (qYExitDialog$ClickEvent3 == QYExitDialog$ClickEvent.BUTTON_NEGATIVE) {
            qeVar3.a.i();
        }
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.g = SystemClock.elapsedRealtime();
        p pVar = this.b;
        if (pVar != null) {
            if (pVar.W == 1) {
                this.c = 2;
                this.f = R.layout.qy_layout_exit_dialog_gold;
            } else if (this.c == 1) {
                this.f = R.layout.qy_layout_exit_dialog_with_icon;
            }
        }
        setContentView(this.f);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            attributes.width = -1;
            attributes.height = -1;
            attributes.dimAmount = 0.8f;
            window.setAttributes(attributes);
            window.addFlags(2);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        TextView textView = (TextView) findViewById(R.id.qy_dialog_positive_btn);
        if (textView != null) {
            textView.setOnClickListener(this);
            String str = this.h.d;
            if (!TextUtils.isEmpty(str)) {
                textView.setText(str);
            }
        }
        TextView textView2 = (TextView) findViewById(R.id.qy_dialog_negative_btn);
        if (textView2 != null) {
            textView2.setOnClickListener(this);
            String str2 = this.h.e;
            if (!TextUtils.isEmpty(str2)) {
                textView2.setText(str2);
            }
        }
        QYNiceImageView qYNiceImageView = (QYNiceImageView) findViewById(R.id.qy_dialog_icon);
        if (qYNiceImageView != null) {
            String str3 = this.b.Q;
            if (!TextUtils.isEmpty(str3)) {
                qYNiceImageView.a(str3);
                qYNiceImageView.setOnClickListener(this);
            }
        }
        TextView textView3 = (TextView) findViewById(R.id.qy_dialog_conversion_btn);
        if (textView3 != null) {
            String str4 = this.h.d;
            if (TextUtils.isEmpty(str4)) {
                textView3.setText(this.b.g());
            } else {
                textView3.setText(str4.replace("%erc", "" + this.b.X));
            }
            textView3.setOnClickListener(this);
        }
        TextView textView4 = (TextView) findViewById(R.id.qy_dialog_detail);
        String strOptString = this.b.i().optString(BundleKey.TITLE);
        if (textView4 != null) {
            textView4.setText(strOptString);
            textView4.setOnClickListener(this);
        }
        if (this.c == 4) {
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.qy_exit_dialog_background);
            if (viewGroup != null) {
                viewGroup.setBackgroundResource(R.drawable.qy_bg_reward_exit_dialog);
            }
            ImageView imageView = (ImageView) findViewById(R.id.qy_dialog_img);
            if (imageView != null) {
                imageView.setImageResource(R.drawable.qy_lg_gift_box_big_2);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            }
        }
        try {
            TextView textView5 = (TextView) findViewById(R.id.qy_dialog_msg);
            p pVar2 = this.b;
            String str5 = !TextUtils.isEmpty(pVar2.L0.I.a) ? pVar2.L0.I.a : pVar2.Y;
            h6.a(getContext(), textView5, this.b.L0.R);
            ArrayList arrayList = this.h.b;
            if (arrayList == null || arrayList.isEmpty()) {
                if (TextUtils.isEmpty(str5)) {
                    return;
                }
                textView5.setText(str5.replace("%cd", "" + a()).replace("%erc", "" + this.b.X));
            } else {
                HashMap map = new HashMap();
                map.put("%cd", "" + a());
                map.put("%erc", "" + this.b.X);
                map.put("%nrt", "0秒");
                textView5.setText(sg.a(this.h.b, map));
            }
        } catch (Exception e) {
        }
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        Window window;
        super.onWindowFocusChanged(z);
        if (!z || (window = getWindow()) == null) {
            return;
        }
        window.getDecorView().setSystemUiVisibility(o.a.f);
    }
}
