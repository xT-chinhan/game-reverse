package com.anythink.basead.ui.guidetoclickv2;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class QuestionDialogG2CV2View extends BaseG2CV2View {
    private TextView d;
    private TextView e;
    private String f;
    private String g;

    public QuestionDialogG2CV2View(Context context) {
        super(context);
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    final void a(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_g2c_v2_question_dialog", "layout"), this);
        TextView textView = (TextView) findViewById(q.a(getContext(), "myoffer_g2c_question_answer1", "id"));
        this.d = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.guidetoclickv2.QuestionDialogG2CV2View.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (QuestionDialogG2CV2View.this.c != null) {
                    QuestionDialogG2CV2View.this.c.a(11, 17);
                }
            }
        });
        TextView textView2 = (TextView) findViewById(q.a(getContext(), "myoffer_g2c_question_answer2", "id"));
        this.e = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.guidetoclickv2.QuestionDialogG2CV2View.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (QuestionDialogG2CV2View.this.c != null) {
                    QuestionDialogG2CV2View.this.c.a(11, 17);
                }
            }
        });
        if (!TextUtils.isEmpty(this.f)) {
            this.d.setText(this.f);
        }
        if (!TextUtils.isEmpty(this.g)) {
            this.e.setText(this.g);
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.guidetoclickv2.QuestionDialogG2CV2View.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
            }
        });
    }

    public void setQuestionAnswer(String str, String str2) {
        this.f = str;
        this.g = str2;
    }
}
