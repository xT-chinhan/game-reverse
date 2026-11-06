package com.anythink.basead.ui.improveclick.incentivetask;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.basead.ui.SimpleGuideToClickView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.y;
import com.anythink.core.common.res.b;
import com.anythink.core.common.res.e;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.core.common.v.g;
import com.anythink.core.common.v.q;
import com.anythink.core.common.v.s;

/* JADX INFO: loaded from: classes.dex */
public class CountDownSkipIncentiveTaskView extends BaseIncentiveTaskView {
    SimpleGuideToClickView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private RoundImageView g;
    private ImageView h;
    private s i;
    private boolean j;

    static /* synthetic */ boolean c(CountDownSkipIncentiveTaskView countDownSkipIncentiveTaskView) {
        countDownSkipIncentiveTaskView.j = true;
        return true;
    }

    public CountDownSkipIncentiveTaskView(Context context) {
        super(context);
        this.j = false;
    }

    public CountDownSkipIncentiveTaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = false;
    }

    public CountDownSkipIncentiveTaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = false;
    }

    @Override // com.anythink.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView
    final void a() {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_inctask_count_down_skip", "layout"), this);
        this.d = (TextView) findViewById(q.a(getContext(), "myoffer_inctask_title", "id"));
        this.e = (TextView) findViewById(q.a(getContext(), "myoffer_inctask_desc", "id"));
        this.f = (TextView) findViewById(q.a(getContext(), "myoffer_inctask_cta", "id"));
        this.g = (RoundImageView) findViewById(q.a(getContext(), "myoffer_inctask_icon", "id"));
        this.h = (ImageView) findViewById(q.a(getContext(), "myoffer_inctask_close_view", "id"));
        this.c = (SimpleGuideToClickView) findViewById(q.a(getContext(), "myoffer_g2c_item_g2c_fingerview", "id"));
    }

    @Override // com.anythink.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView
    public void initSetting(w wVar, y yVar, long j, BaseIncentiveTaskView.a aVar) {
        TextView textView;
        RoundImageView roundImageView;
        super.initSetting(wVar, yVar, j, aVar);
        if (j <= 0 || j >= yVar.o()) {
            j = yVar.o();
        }
        long jBp = j - yVar.bp();
        long jBq = yVar.bq();
        if (jBq < jBp) {
            String str = String.format(getContext().getString(q.a(getContext(), "myoffer_inctask_cts_hint", "string")), Integer.valueOf((int) Math.ceil(jBq / 1000.0d)));
            TextView textView2 = this.d;
            if (textView2 != null) {
                textView2.setText(str);
            }
            this.i = new s(jBq) { // from class: com.anythink.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView.1
                @Override // com.anythink.core.common.v.s
                public final void a(long j2) {
                    if (CountDownSkipIncentiveTaskView.this.f != null) {
                        CountDownSkipIncentiveTaskView.this.f.setText(String.format(CountDownSkipIncentiveTaskView.this.getContext().getString(q.a(CountDownSkipIncentiveTaskView.this.getContext(), "myoffer_inctask_cts_time", "string")), Integer.valueOf((int) Math.ceil(j2 / 1000.0d))));
                    }
                }

                @Override // com.anythink.core.common.v.s
                public final void a() {
                    if (CountDownSkipIncentiveTaskView.this.j) {
                        CountDownSkipIncentiveTaskView.this.c();
                    } else {
                        CountDownSkipIncentiveTaskView.c(CountDownSkipIncentiveTaskView.this);
                    }
                }
            };
        } else {
            String string = getContext().getString(q.a(getContext(), "myoffer_inctask_cts_hint2", "string"));
            TextView textView3 = this.d;
            if (textView3 != null) {
                textView3.setText(string);
            }
        }
        final String strZ = wVar.z();
        if (!TextUtils.isEmpty(strZ) && (roundImageView = this.g) != null) {
            roundImageView.setNeedRadiu(true);
            this.g.setRadiusInDip(20);
            b.a(getContext()).a(new e(1, strZ), new b.a() { // from class: com.anythink.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView.2
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str2, String str3) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str2, Bitmap bitmap) {
                    if (!TextUtils.equals(str2, strZ) || CountDownSkipIncentiveTaskView.this.g == null) {
                        return;
                    }
                    CountDownSkipIncentiveTaskView.this.g.setImageBitmap(bitmap);
                }
            });
        }
        if (!TextUtils.isEmpty(wVar.x()) && (textView = this.e) != null) {
            textView.setText(wVar.x());
            this.e.setVisibility(0);
        }
        TextView textView4 = this.f;
        if (textView4 != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    view.setOnClickListener(null);
                    CountDownSkipIncentiveTaskView.this.b();
                    if (CountDownSkipIncentiveTaskView.this.b != null) {
                        CountDownSkipIncentiveTaskView.this.b.b();
                    }
                    CountDownSkipIncentiveTaskView.c(CountDownSkipIncentiveTaskView.this);
                    if (CountDownSkipIncentiveTaskView.this.i != null) {
                        CountDownSkipIncentiveTaskView.this.i.b();
                    } else {
                        CountDownSkipIncentiveTaskView.this.c();
                    }
                    if (CountDownSkipIncentiveTaskView.this.c != null) {
                        CountDownSkipIncentiveTaskView.this.c.setVisibility(8);
                    }
                }
            });
        }
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (CountDownSkipIncentiveTaskView.this.b != null) {
                        CountDownSkipIncentiveTaskView.this.b.a();
                    }
                }
            });
        }
        SimpleGuideToClickView simpleGuideToClickView = this.c;
        if (simpleGuideToClickView != null) {
            simpleGuideToClickView.init(q.a(getContext(), "myoffer_simple_guide_to_click_s", "layout"), q.a(getContext(), 4.0f), q.a(getContext(), 6.0f), q.a(getContext(), 8.0f), q.a(getContext(), 12.0f));
            final ImageView imageView2 = (ImageView) this.c.findViewById(q.a(getContext(), "myoffer_guide_to_click_finger", "id"));
            if (imageView2 != null) {
                String strA = g.a().a(com.anythink.core.common.a.b.d.k);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                b.a(t.b().g()).a(new e(3, strA), new b.a() { // from class: com.anythink.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView.5
                    @Override // com.anythink.core.common.res.b.a
                    public final void onFail(String str2, String str3) {
                    }

                    @Override // com.anythink.core.common.res.b.a
                    public final void onSuccess(String str2, Bitmap bitmap) {
                        ImageView imageView3 = imageView2;
                        if (imageView3 != null) {
                            imageView3.setImageBitmap(bitmap);
                        }
                    }
                });
            }
        }
    }

    @Override // com.anythink.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView
    public void onResume() {
        super.onResume();
        if (!this.j) {
            this.j = true;
        } else {
            c();
        }
    }

    @Override // com.anythink.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView
    public void onPause() {
        super.onPause();
        this.j = false;
    }

    @Override // com.anythink.basead.ui.improveclick.incentivetask.BaseIncentiveTaskView
    public void release() {
        super.release();
        s sVar = this.i;
        if (sVar != null) {
            sVar.c();
            this.i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(getContext().getString(q.a(getContext(), "myoffer_inctask_cts_completed", "string")));
        }
        TextView textView2 = this.f;
        if (textView2 != null) {
            textView2.setText(getContext().getString(q.a(getContext(), "myoffer_inctask_cts_completed_cta", "string")));
            this.f.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView.6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (CountDownSkipIncentiveTaskView.this.b != null) {
                        CountDownSkipIncentiveTaskView.this.b.a(-1L);
                        CountDownSkipIncentiveTaskView.this.b.a();
                    }
                }
            });
        }
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView.7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (CountDownSkipIncentiveTaskView.this.b != null) {
                        CountDownSkipIncentiveTaskView.this.b.a(-1L);
                        CountDownSkipIncentiveTaskView.this.b.a();
                    }
                }
            });
        }
    }
}
