package com.mcto.sspsdk.internal;

import android.content.Intent;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.C;
import com.mcto.sspsdk.QyCustomMade;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.imageview2.QYImageView2;
import com.mcto.sspsdk.component.webview.QyWebViewDataBean;
import com.mcto.sspsdk.ssp.activity.QyDetailPageActivityNew;

/* JADX INFO: loaded from: classes2.dex */
public final class m8 implements j7, View.OnClickListener {
    public final ve a;
    public final c b;
    public final re c;
    public final long d;
    public final ConstraintLayout e;
    public final String f;
    public l8 g;
    public boolean h = false;
    public boolean i = false;
    public long j = 0;

    public m8(ve veVar, p pVar, c cVar, re reVar) {
        this.f = "https://pic1.iqiyipic.com/lequ/20260317/14c036fafcae4974b546fc5c9f751a91.png";
        int i = 0;
        this.a = veVar;
        this.b = cVar;
        this.c = reVar;
        int i2 = pVar.X;
        this.d = cVar.c;
        String str = pVar.L0.R;
        if (!TextUtils.isEmpty(cVar.b)) {
            this.f = cVar.b;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) LayoutInflater.from(veVar.getContext()).inflate(R.layout.qy_layout_reward_extra_dialog, (ViewGroup) null);
        this.e = constraintLayout;
        constraintLayout.setOnClickListener(this);
        ((QYImageView2) constraintLayout.findViewById(R.id.qy_dialog_img)).b(this.f);
        TextView textView = (TextView) constraintLayout.findViewById(R.id.qy_dialog_msg);
        h6.a(veVar.getContext(), textView, str);
        String strReplace = cVar.a.replace("%erc", "" + i2);
        if (strReplace != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= strReplace.length()) {
                    textView.setText(strReplace);
                    break;
                }
                if (Character.isDigit(strReplace.charAt(i3))) {
                    SpannableString spannableString = new SpannableString(strReplace);
                    int length = strReplace.length();
                    while (i < length) {
                        boolean zIsDigit = Character.isDigit(strReplace.charAt(i));
                        int i4 = i + 1;
                        while (i4 < length && Character.isDigit(strReplace.charAt(i4)) == zIsDigit) {
                            i4++;
                        }
                        spannableString.setSpan(new AbsoluteSizeSpan(zIsDigit ? 45 : 24, true), i, i4, 33);
                        i = i4;
                    }
                    textView.setText(spannableString);
                    break;
                }
                i3++;
            }
        } else {
            textView.setText(strReplace);
            break;
        }
        TextView textView2 = (TextView) this.e.findViewById(R.id.qy_dialog_button_left);
        b bVar = this.b.d;
        if (bVar == null || TextUtils.isEmpty(bVar.b)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(this.b.d.b);
            if (this.b.d.a == 1) {
                textView2.setBackgroundResource(R.drawable.qy_gradient_corners_vip_btn);
            }
            textView2.setOnClickListener(this);
        }
        TextView textView3 = (TextView) this.e.findViewById(R.id.qy_dialog_button_right);
        b bVar2 = this.b.e;
        if (bVar2 == null || TextUtils.isEmpty(bVar2.b)) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(this.b.e.b);
            if (this.b.e.a == 0) {
                textView3.setBackgroundResource(R.drawable.qy_gradient_corners_vip_text_hollow_btn);
            }
            textView3.setOnClickListener(this);
        }
        ((ImageView) this.e.findViewById(R.id.qy_reward_interactive_close)).setOnClickListener(this);
    }

    public final void a(int i, String str) {
        a4 a4Var = new a4();
        a4Var.b = z3.FUNCTIONAL_BTN;
        a4Var.g = SystemClock.elapsedRealtime() - this.j;
        b4 b4Var = new b4(a4Var);
        if (i == -2) {
            l8 l8Var = this.g;
            if (l8Var != null) {
                l8Var.a();
            }
            b4Var.b = "rwddg_close_ad";
            this.c.a.b(b4Var);
            this.c.a.i();
            return;
        }
        if (i == -1) {
            b4Var.b = "rwddg_close";
            this.c.a.b(b4Var);
            destroy();
            return;
        }
        if (i != 0) {
            if (i == 14) {
                b4Var.b = "rwddg_ext_btn";
                this.c.a.b(b4Var);
                e1.a(false, jd.a, str, null);
                return;
            } else {
                if (i != 67) {
                    return;
                }
                b4Var.b = "rwddg_ext_btn";
                this.c.a.b(b4Var);
                QyCustomMade qyCustomMade = rd.d;
                if (qyCustomMade != null) {
                    qyCustomMade.registration(str);
                    return;
                }
                return;
            }
        }
        b4Var.b = "rwddg_ext_btn";
        this.c.a.b(b4Var);
        if (lj.b(str)) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(jd.a, QyDetailPageActivityNew.class);
        intent.setAction("android.intent.action.VIEW");
        QyWebViewDataBean qyWebViewDataBean = new QyWebViewDataBean();
        qyWebViewDataBean.a(str);
        qyWebViewDataBean.o();
        intent.putExtra("dataBean", qyWebViewDataBean);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        try {
            jd.a.startActivity(intent);
        } catch (Exception e) {
            r9.a("ssp_clickAction", "open Web view: ", e);
        }
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final d b() {
        return null;
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final boolean c() {
        return this.h;
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final void d() {
        l8 l8Var = this.g;
        if (l8Var != null) {
            l8Var.c();
        }
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final void destroy() {
        if (this.i) {
            return;
        }
        this.i = true;
        l8 l8Var = this.g;
        if (l8Var != null) {
            l8Var.a();
        }
        this.a.removeView(this.e);
        this.h = false;
        re reVar = this.c;
        if (reVar != null) {
            reVar.a(this);
        }
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final void e() {
        l8 l8Var = this.g;
        if (l8Var != null) {
            l8Var.a();
        }
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final void f() {
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final int g() {
        return 1;
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final String h() {
        return "rwddg";
    }

    public final void i() {
        this.j = SystemClock.elapsedRealtime();
        this.a.addView(this.e, new ViewGroup.LayoutParams(-1, -1));
        this.h = true;
        re reVar = this.c;
        if (reVar != null) {
            reVar.b(this);
        }
        long j = this.d;
        if (j > 0) {
            l8 l8Var = new l8(this, j * 1000);
            this.g = l8Var;
            synchronized (l8Var) {
                l8Var.c();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (R.id.qy_reward_interactive_container == id) {
            return;
        }
        if (id == R.id.qy_reward_interactive_close) {
            a4 a4Var = new a4();
            a4Var.b = z3.FUNCTIONAL_BTN;
            a4Var.g = SystemClock.elapsedRealtime() - this.j;
            a4Var.c = "rwddg_close";
            this.c.a.b(new b4(a4Var));
            destroy();
            return;
        }
        if (id == R.id.qy_dialog_button_left) {
            b bVar = this.b.d;
            a(bVar.c, bVar.d);
        } else if (id == R.id.qy_dialog_button_right) {
            b bVar2 = this.b.e;
            a(bVar2.c, bVar2.d);
        }
    }

    @Override // com.mcto.sspsdk.internal.j7
    public final void a() {
        i();
    }
}
