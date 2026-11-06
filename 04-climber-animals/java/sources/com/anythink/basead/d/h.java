package com.anythink.basead.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bf;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.w;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class h extends bf {
    String a;
    String b;
    com.anythink.core.common.k.c c;

    public h(w wVar, String str, String str2, com.anythink.core.common.k.c cVar) {
        this.a = str;
        this.b = str2;
        this.d = wVar;
        this.c = cVar;
    }

    @Override // com.anythink.core.common.h.bf
    public final void a(Activity activity) {
        try {
            String strAK = this.d instanceof bj ? ((bj) this.d).aK() : "";
            if (TextUtils.isEmpty(strAK)) {
                strAK = this.d.x();
            }
            final Context contextG = t.b().g();
            View viewInflate = LayoutInflater.from(activity).inflate(q.a(contextG, "myoffer_confirm_dialog", "layout"), (ViewGroup) null, false);
            TextView textView = (TextView) viewInflate.findViewById(q.a(contextG, "myoffer_confirm_msg", "id"));
            TextView textView2 = (TextView) viewInflate.findViewById(q.a(contextG, "myoffer_confirm_give_up", "id"));
            TextView textView3 = (TextView) viewInflate.findViewById(q.a(contextG, "myoffer_confirm_continue", "id"));
            String string = contextG.getString(q.a(t.b().g(), "myoffer_confirm_msg", "string"));
            String string2 = contextG.getString(q.a(t.b().g(), "myoffer_give_up", "string"));
            String string3 = contextG.getString(q.a(t.b().g(), "myoffer_continue", "string"));
            textView.setText(string + "\"" + strAK + "\"?");
            textView2.setText(string2);
            textView3.setText(string3);
            final Dialog dialog = new Dialog(activity, q.a(contextG, "style_full_screen_translucent_dialog", "style"));
            dialog.setContentView(viewInflate);
            dialog.setCancelable(false);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.d.h.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.anythink.core.common.u.e.a(h.this.b, h.this.d.v(), h.this.a, 7, (String) null, 0L, 0L, h.this.d.ap(), h.this.d.aq());
                    try {
                        dialog.dismiss();
                    } catch (Throwable unused) {
                    }
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.d.h.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    try {
                        com.anythink.core.common.u.e.a(h.this.b, h.this.d.v(), h.this.a, 8, (String) null, 0L, 0L, h.this.d.ap(), h.this.d.aq());
                        boolean zA = com.anythink.basead.b.b.a(contextG, h.this.d);
                        if (zA) {
                            com.anythink.core.common.u.e.a(h.this.b, h.this.d.v(), h.this.a, 9, (String) null, 0L, 0L, h.this.d.ap(), h.this.d.aq());
                        }
                        dialog.dismiss();
                        if (h.this.c != null) {
                            h.this.c.a(zA);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
            dialog.show();
        } catch (Throwable unused) {
        }
    }
}
