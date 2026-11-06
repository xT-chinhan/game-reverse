package com.anythink.basead.f.b.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.anythink.basead.ui.BaseMediaATView;
import com.anythink.basead.ui.MediaATView;
import com.anythink.basead.ui.MraidMediaView;
import com.anythink.basead.ui.OwnNativeATView;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.x;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class c extends com.anythink.basead.f.b.a.a {
    BaseMediaATView p;
    List<View> q;

    @Override // com.anythink.basead.f.a
    public final ViewGroup b() {
        return null;
    }

    public c(Context context, bj bjVar, x xVar, boolean z) {
        super(context, bjVar, xVar, z);
    }

    @Override // com.anythink.basead.f.a
    public final View a(Context context, boolean z, BaseMediaATView.a aVar) {
        if (!p()) {
            return null;
        }
        if (this.c == null) {
            this.c = G();
        }
        a aVar2 = new a(aVar);
        if (this.s != null && this.s.n()) {
            MraidMediaView mraidMediaView = new MraidMediaView(context, this.s, this.t, z, aVar2, this.m);
            this.p = mraidMediaView;
            mraidMediaView.setMraidWebViewListener(new MraidMediaView.a() { // from class: com.anythink.basead.f.b.a.c.1
                @Override // com.anythink.basead.ui.MraidMediaView.a
                public final void a(String str) {
                    if (c.this.s != null) {
                        c.this.s.w(str);
                    }
                    c cVar = c.this;
                    cVar.a(cVar.p, 1, 13);
                }

                @Override // com.anythink.basead.ui.MraidMediaView.a
                public final void a() {
                    if (c.this.c != null) {
                        c cVar = c.this;
                        cVar.a(cVar.c);
                    }
                }
            });
        } else {
            this.p = new MediaATView(context, this.s, this.t, z, aVar2);
        }
        int iN = N();
        this.t.o.an(iN);
        this.p.init(this.A, this.B, iN);
        ViewParent viewParent = this.p;
        if (viewParent instanceof com.anythink.basead.ui.a) {
            a((com.anythink.basead.ui.a) viewParent);
        }
        this.c.addView(this.p, new FrameLayout.LayoutParams(this.p.getMediaViewWidth(), this.p.getMediaViewHeight()));
        this.q = this.p.getContainerClickViews();
        a(this.c, this.p.getClickViews(), null, null, null);
        return this.c;
    }

    private int N() {
        int iBg = this.t.o.bg();
        if (iBg > 0) {
            return iBg;
        }
        if (this.C == null) {
            return 6;
        }
        try {
            int iOptInt = this.C.optInt(new Random().nextInt(this.C.length()));
            if (iOptInt <= 0) {
                return 6;
            }
            this.C.toString();
            return iOptInt;
        } catch (Throwable unused) {
            return 6;
        }
    }

    @Override // com.anythink.basead.f.b.a.a
    final View L() {
        OwnNativeATView ownNativeATView = this.c;
        BaseMediaATView baseMediaATView = this.p;
        if (baseMediaATView == null || baseMediaATView.getMonitorClickView() == null) {
            return ownNativeATView;
        }
        View monitorClickView = this.p.getMonitorClickView();
        this.d = new WeakReference<>(monitorClickView);
        return monitorClickView;
    }

    @Override // com.anythink.basead.f.b.a.a, com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final void r() {
        super.r();
        BaseMediaATView baseMediaATView = this.p;
        if (baseMediaATView != null) {
            baseMediaATView.destroy();
        }
    }

    @Override // com.anythink.basead.f.b.a.a
    final void I() {
        super.I();
        if (this.x && this.s.n()) {
            BaseMediaATView baseMediaATView = this.p;
            if (baseMediaATView instanceof MraidMediaView) {
                ((MraidMediaView) baseMediaATView).fireAudioVolumeChange(this.x);
            }
        }
    }

    @Override // com.anythink.basead.f.b.a.a, com.anythink.basead.f.b.a.d
    protected final View H() {
        if (this.s.n()) {
            return this.p;
        }
        return super.H();
    }

    @Override // com.anythink.basead.f.b.a.a
    protected final List<View> J() {
        return this.q;
    }

    @Override // com.anythink.basead.f.b.a.a
    final void K() {
        BaseMediaATView baseMediaATView = this.p;
        if (baseMediaATView != null) {
            baseMediaATView.changeCloseViewSizeAfterClick();
        }
    }

    private static class a implements BaseMediaATView.a {
        private final BaseMediaATView.a a;

        public a(BaseMediaATView.a aVar) {
            this.a = aVar;
        }

        @Override // com.anythink.basead.ui.BaseMediaATView.a
        public final void onClickCloseView() {
            BaseMediaATView.a aVar = this.a;
            if (aVar != null) {
                aVar.onClickCloseView();
            }
        }
    }
}
