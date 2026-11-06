package com.smartdigimkt.h0;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public com.smartdigimkt.b3.c a;
    public final String b;
    public final String c;
    public final com.smartdigimkt.j.g d;
    public final long e;

    public j(com.smartdigimkt.b3.c cVar, String str, String str2, com.smartdigimkt.j.g gVar, long j) {
        this.b = str;
        this.c = str2;
        this.a = cVar;
        this.d = gVar;
        this.e = j;
    }

    public final void a(Activity activity) {
        try {
            com.smartdigimkt.b3.c cVar = this.a;
            String str = cVar instanceof com.smartdigimkt.b3.l ? ((com.smartdigimkt.b3.l) cVar).X : "";
            if (TextUtils.isEmpty(str)) {
                str = this.a.c;
            }
            Context contextD = SDKContext.getInstance().d();
            View viewInflate = LayoutInflater.from(activity).inflate(com.smartdigimkt.r4.k.a(contextD, "myoffer_confirm_dialog", "layout"), (ViewGroup) null, false);
            TextView textView = (TextView) viewInflate.findViewById(com.smartdigimkt.r4.k.a(contextD, "myoffer_confirm_msg", "id"));
            TextView textView2 = (TextView) viewInflate.findViewById(com.smartdigimkt.r4.k.a(contextD, "myoffer_confirm_give_up", "id"));
            TextView textView3 = (TextView) viewInflate.findViewById(com.smartdigimkt.r4.k.a(contextD, "myoffer_confirm_continue", "id"));
            String string = contextD.getString(com.smartdigimkt.r4.k.a(SDKContext.getInstance().d(), "myoffer_confirm_msg", "string"));
            String string2 = contextD.getString(com.smartdigimkt.r4.k.a(SDKContext.getInstance().d(), "myoffer_give_up", "string"));
            String string3 = contextD.getString(com.smartdigimkt.r4.k.a(SDKContext.getInstance().d(), "myoffer_continue", "string"));
            textView.setText(string + "\"" + str + "\"?");
            textView2.setText(string2);
            textView3.setText(string3);
            Dialog dialog = new Dialog(activity, com.smartdigimkt.r4.k.a(contextD, "style_full_screen_translucent_dialog", "style"));
            dialog.setContentView(viewInflate);
            dialog.setCancelable(false);
            textView2.setOnClickListener(new h(this, dialog));
            textView3.setOnClickListener(new i(this, contextD, dialog));
            dialog.show();
        } catch (Throwable unused) {
        }
    }
}
