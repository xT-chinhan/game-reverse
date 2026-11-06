package com.anythink.basead.ui.guidetoclickv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class JumpConfirmG2CV2View extends BaseG2CV2View {
    private TextView d;
    private LinearLayout e;

    public JumpConfirmG2CV2View(Context context) {
        super(context);
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    final void a(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_g2c_v2_jump_confirm", "layout"), this);
        setBackgroundResource(q.a(getContext(), "myoffer_g2c_jump_confirm_bg", "drawable"));
        this.e = (LinearLayout) findViewById(q.a(getContext(), "myoffer_ll_jump_confirm_container", "id"));
        TextView textView = (TextView) findViewById(q.a(getContext(), "myoffer_g2c_jump_confirm_ignore", "id"));
        this.d = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.guidetoclickv2.JumpConfirmG2CV2View.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (JumpConfirmG2CV2View.this.c != null) {
                    JumpConfirmG2CV2View.this.c.a(11, 19);
                }
            }
        });
        if (i != 2) {
            this.e.setPadding(q.a(getContext(), 18.0f), 0, 0, 0);
        }
    }
}
