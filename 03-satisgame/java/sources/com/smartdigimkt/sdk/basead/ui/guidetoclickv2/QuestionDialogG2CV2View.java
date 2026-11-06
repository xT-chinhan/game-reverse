package com.smartdigimkt.sdk.basead.ui.guidetoclickv2;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.y1.a1;
import com.smartdigimkt.y1.b1;
import com.smartdigimkt.y1.z0;

/* JADX INFO: loaded from: classes3.dex */
public class QuestionDialogG2CV2View extends BaseG2CV2View {
    public TextView h;
    public TextView i;
    public String j;
    public String k;

    public QuestionDialogG2CV2View(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void initView(int i, int i2) {
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_g2c_v2_question_dialog", "layout"), this);
        TextView textView = (TextView) findViewById(k.a(getContext(), "myoffer_g2c_question_answer1", "id"));
        this.h = textView;
        textView.setOnClickListener(new z0(this));
        TextView textView2 = (TextView) findViewById(k.a(getContext(), "myoffer_g2c_question_answer2", "id"));
        this.i = textView2;
        textView2.setOnClickListener(new a1(this));
        if (!TextUtils.isEmpty(this.j)) {
            this.h.setText(this.j);
        }
        if (!TextUtils.isEmpty(this.k)) {
            this.i.setText(this.k);
        }
        setOnClickListener(new b1());
    }

    public void setQuestionAnswer(String str, String str2) {
        this.j = str;
        this.k = str2;
    }
}
