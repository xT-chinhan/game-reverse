package com.mcto.sspsdk.internal;

import android.view.View;
import com.mcto.sspsdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class l5 implements View.OnClickListener {
    public final /* synthetic */ p5 a;

    public l5(p5 p5Var) {
        this.a = p5Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id != R.id.qy_download_confirm_app_btn_download) {
            if (id == R.id.qy_download_confirm_app_btn_detail_page) {
                a4 a4Var = new a4();
                a4Var.a = view;
                a4Var.b = z3.DOWN_CONFIRM_DETAIL_BTN;
                y3.a(view.getContext(), this.a.d, new b4(a4Var));
                return;
            }
            return;
        }
        a4 a4Var2 = new a4();
        a4Var2.a = view;
        int iC = this.a.c.c();
        if (iC == 5 || iC == 7) {
            a4Var2.f = 1;
        } else if (iC != 0) {
            a4Var2.f = 2;
        }
        a4Var2.b = z3.DOWN_CONFIRM_ACTION_BTN;
        b4 b4Var = new b4(a4Var2);
        b4Var.k = this.a.c.a();
        y3.a(view.getContext(), this.a.d, b4Var);
    }
}
