package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.basead.j.e;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class MraidEndCardView extends BaseEndCardView {
    private static String h = "MraidEndCardView";
    MraidContainerView e;
    a f;
    e g;

    public interface a {
        void a();

        void a(String str);

        void b();

        void c();
    }

    public MraidEndCardView(Context context, w wVar, x xVar, e eVar) {
        super(context, wVar, xVar);
        this.g = eVar;
        setId(q.a(getContext(), "myoffer_end_card_id", "id"));
    }

    public void setEndCardListener(a aVar) {
        this.f = aVar;
    }

    public void init(boolean z) {
        if (this.c.o.H() == 0) {
            setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.MraidEndCardView.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (MraidEndCardView.this.f != null) {
                        MraidEndCardView.this.f.a(MraidEndCardView.this.b.H());
                    }
                }
            });
        }
        this.e = new MraidContainerView(getContext(), this.b, this.c, this.g, new MraidContainerView.a() { // from class: com.anythink.basead.ui.MraidEndCardView.2
            @Override // com.anythink.basead.ui.MraidContainerView.a
            public final void b() {
            }

            @Override // com.anythink.basead.ui.MraidContainerView.a
            public final void a(String str) {
                if (MraidEndCardView.this.f != null) {
                    MraidEndCardView.this.f.a(str);
                }
            }

            @Override // com.anythink.basead.ui.MraidContainerView.a
            public final void a() {
                if (MraidEndCardView.this.f != null) {
                    MraidEndCardView.this.f.a();
                }
            }

            @Override // com.anythink.basead.ui.MraidContainerView.a
            public final void c() {
                if (MraidEndCardView.this.f != null) {
                    MraidEndCardView.this.f.c();
                }
            }
        });
        this.e.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.e);
        this.e.setNeedRegisterVolumeChangeReceiver(true);
        this.e.init();
        if (z) {
            this.e.loadMraidWebView(1);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        MraidContainerView mraidContainerView = this.e;
        if (mraidContainerView != null) {
            mraidContainerView.fireMraidIsViewable(z);
        }
    }

    @Override // com.anythink.basead.ui.BaseEndCardView
    protected final void a() {
        MraidContainerView mraidContainerView = this.e;
        if (mraidContainerView != null) {
            mraidContainerView.release();
        }
    }

    @Override // com.anythink.basead.ui.BaseEndCardView
    protected final Drawable b() {
        return new com.anythink.basead.ui.b.a();
    }
}
