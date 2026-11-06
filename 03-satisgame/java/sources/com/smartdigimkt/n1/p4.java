package com.smartdigimkt.n1;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p4 {
    public static void a(Context context, String str, String str2, String str3, final Runnable runnable, final com.smartdigimkt.a3.a aVar, final com.smartdigimkt.b3.c cVar, final o4 o4Var) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        View viewInflate = LayoutInflater.from(context).inflate(com.smartdigimkt.r4.k.a(context, "myoffer_rv_double_task_retention_dialog", "layout"), (ViewGroup) null, false);
        dialog.setContentView(viewInflate);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            int i = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            attributes.width = Math.max(context.getResources().getDisplayMetrics().widthPixels - (i * 2), i);
            attributes.height = -2;
            attributes.gravity = 17;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setDimAmount(0.5f);
        }
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        TextView textView = (TextView) viewInflate.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_rv_double_retention_tv_message", "id"));
        TextView textView2 = (TextView) viewInflate.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_rv_double_retention_btn_accept", "id"));
        TextView textView3 = (TextView) viewInflate.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_rv_double_retention_tv_reject", "id"));
        if (textView != null) {
            textView.setText(str);
        }
        if (textView2 != null) {
            textView2.setText(str2);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.smartdigimkt.n1.p4$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    p4.a(aVar, cVar, o4Var, dialog, view);
                }
            });
        }
        if (textView3 != null) {
            textView3.setText(str3);
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.smartdigimkt.n1.p4$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    p4.a(aVar, cVar, o4Var, dialog, runnable, view);
                }
            });
        }
        dialog.show();
    }

    public static void a(com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar, o4 o4Var, Dialog dialog, View view) {
        com.smartdigimkt.n3.k.b(1, o4Var == o4.PLAYER_CLOSE ? 57 : 55, aVar, cVar, null, false);
        dialog.dismiss();
    }

    public static void a(com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar, o4 o4Var, Dialog dialog, Runnable runnable, View view) {
        com.smartdigimkt.n3.k.b(1, o4Var == o4.PLAYER_CLOSE ? 58 : 56, aVar, cVar, null, false);
        dialog.dismiss();
        if (runnable != null) {
            runnable.run();
        }
    }
}
