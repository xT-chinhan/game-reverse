package com.anythink.basead.ui.improveclick.incentivetask;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.anythink.core.common.a.b;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.y;
import com.anythink.core.common.res.e;
import com.anythink.core.common.v.g;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class QAIncentiveTaskView extends BaseIncentiveTaskView {
    long c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private View i;
    private ImageView j;

    public QAIncentiveTaskView(Context context) {
        super(context);
    }

    public QAIncentiveTaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QAIncentiveTaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.anythink.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView
    final void a() {
        String strA;
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_inctask_qa", "layout"), this);
        this.d = (TextView) findViewById(q.a(getContext(), "myoffer_inctask_title", "id"));
        this.e = (TextView) findViewById(q.a(getContext(), "myoffer_inctask_subtitle", "id"));
        this.f = (TextView) findViewById(q.a(getContext(), "myoffer_inctask_answer_hint", "id"));
        this.g = (TextView) findViewById(q.a(getContext(), "myoffer_inctask_answer_right", "id"));
        this.h = (TextView) findViewById(q.a(getContext(), "myoffer_inctask_answer_wrong", "id"));
        this.i = findViewById(q.a(getContext(), "myoffer_inctask_close_view", "id"));
        ImageView imageView = (ImageView) findViewById(q.a(getContext(), "myoffer_inctask_right_hint", "id"));
        this.j = imageView;
        if (imageView != null) {
            if (q.b()) {
                strA = g.a().a(b.d.o);
            } else {
                strA = g.a().a(b.d.n);
            }
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            com.anythink.core.common.res.b.a(t.b().g()).a(new e(3, strA), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.improveclick.incentivetask.QAIncentiveTaskView.1
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (QAIncentiveTaskView.this.j != null) {
                        QAIncentiveTaskView.this.j.setImageBitmap(bitmap);
                    }
                }
            });
        }
    }

    @Override // com.anythink.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView
    public void initSetting(w wVar, y yVar, long j, BaseIncentiveTaskView.a aVar) {
        String strY;
        super.initSetting(wVar, yVar, j, aVar);
        long jBq = yVar.bq();
        long jO = yVar.o();
        long jMin = (j > 0 ? Math.min(jO, j) : jO) - yVar.bp();
        if (jBq > jMin) {
            jBq = jMin;
        }
        if (jBq == 0) {
            if (this.b != null) {
                this.b.a();
                return;
            }
            return;
        }
        this.c = (j < jO ? jO - j : 0L) + jBq;
        double d = jBq / 1000.0d;
        String str = String.format(getContext().getString(q.a(getContext(), "myoffer_inctask_qa_title", "string")), Integer.valueOf((int) Math.ceil(d)));
        String str2 = String.format(getContext().getString(q.a(getContext(), "myoffer_inctask_qa_subtitle", "string")), Integer.valueOf((int) Math.ceil(d)));
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setText(str2);
        }
        if (this.g != null) {
            if (!TextUtils.isEmpty(wVar.x())) {
                strY = wVar.x();
            } else {
                strY = !TextUtils.isEmpty(wVar.y()) ? wVar.y() : "";
            }
            if (!TextUtils.isEmpty(strY)) {
                this.g.setText(strY);
            }
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.improveclick.incentivetask.QAIncentiveTaskView.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QAIncentiveTaskView.this.b.a(1);
                    if (QAIncentiveTaskView.this.j != null) {
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                        alphaAnimation.setDuration(1000L);
                        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.anythink.basead.ui.improveclick.incentivetask.QAIncentiveTaskView.2.1
                            @Override // android.view.animation.Animation.AnimationListener
                            public final void onAnimationRepeat(Animation animation) {
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public final void onAnimationStart(Animation animation) {
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public final void onAnimationEnd(Animation animation) {
                                QAIncentiveTaskView.this.b.a(QAIncentiveTaskView.this.c);
                                QAIncentiveTaskView.this.b.a();
                            }
                        });
                        if (QAIncentiveTaskView.this.f != null) {
                            QAIncentiveTaskView.this.f.setVisibility(8);
                        }
                        if (QAIncentiveTaskView.this.g != null) {
                            QAIncentiveTaskView.this.g.setVisibility(8);
                        }
                        if (QAIncentiveTaskView.this.h != null) {
                            QAIncentiveTaskView.this.h.setVisibility(8);
                        }
                        QAIncentiveTaskView.this.j.setVisibility(0);
                        QAIncentiveTaskView.this.j.startAnimation(alphaAnimation);
                        QAIncentiveTaskView.this.b();
                    }
                }
            });
        }
        if (this.h != null) {
            if (!TextUtils.isEmpty(yVar.av())) {
                this.h.setText(yVar.av());
            }
            this.h.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.improveclick.incentivetask.QAIncentiveTaskView.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Toast.makeText(QAIncentiveTaskView.this.getContext().getApplicationContext(), q.a(QAIncentiveTaskView.this.getContext(), "myoffer_inctask_qa_toast_wrong", "string"), 1).show();
                    if (QAIncentiveTaskView.this.b != null) {
                        QAIncentiveTaskView.this.b.a(2);
                        QAIncentiveTaskView.this.b.a();
                    }
                }
            });
        }
        View view = this.i;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.improveclick.incentivetask.QAIncentiveTaskView.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    if (QAIncentiveTaskView.this.b != null) {
                        QAIncentiveTaskView.this.b.a();
                    }
                }
            });
        }
    }
}
