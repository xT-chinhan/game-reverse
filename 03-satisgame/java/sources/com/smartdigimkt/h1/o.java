package com.smartdigimkt.h1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.smartdigimkt.n1.i3;
import com.smartdigimkt.sdk.basead.ui.MediaATView;
import com.smartdigimkt.sdk.basead.ui.OwnNativeATView;
import com.smartdigimkt.t4.v;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends k {
    public MediaATView E;
    public List F;

    public o(Context context, com.smartdigimkt.b3.l lVar, com.smartdigimkt.a3.a aVar, boolean z) {
        super(context, lVar, aVar, z);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0058  */
    @Override // com.smartdigimkt.h1.p
    public final View a(Context context, v vVar) {
        if (!this.d) {
            return null;
        }
        OwnNativeATView ownNativeATView = this.q;
        if (ownNativeATView == null) {
            if (ownNativeATView != null) {
                ownNativeATView.releaseAllCallback();
            }
            OwnNativeATView ownNativeATView2 = new OwnNativeATView(this.a);
            ownNativeATView2.setClickRecordHelper(this.w);
            this.A = false;
            this.q = ownNativeATView2;
        }
        this.E = new MediaATView(context, this.b, this.c, new m(this, vVar));
        int iOptInt = this.c.s.F0;
        if (iOptInt <= 0) {
            JSONArray jSONArray = this.l;
            if (jSONArray != null) {
                try {
                    iOptInt = this.l.optInt(new Random().nextInt(jSONArray.length()));
                    if (iOptInt > 0) {
                        this.l.toString();
                    } else {
                        iOptInt = 6;
                    }
                } catch (Throwable unused) {
                }
            } else {
                iOptInt = 6;
            }
        }
        this.c.s.F0 = iOptInt;
        this.E.init(this.j, this.k, iOptInt);
        MediaATView mediaATView = this.E;
        if (mediaATView instanceof i3) {
            this.s = mediaATView;
            mediaATView.initPlayerView(this.b, this.c, this.t);
            this.s.setIsMuted(this.g);
            this.s.setAutoPlay(this.h);
            this.s.setVideoListener(vVar);
            this.s.setPlayerOnClickListener(new a(this));
        }
        this.q.addView(this.E, new FrameLayout.LayoutParams(this.E.getMediaViewWidth(), this.E.getLayoutParamsHeight()));
        this.F = this.E.getContainerClickViews();
        a(this.q, this.E.getClickViews(), null, null, null);
        return this.q;
    }

    @Override // com.smartdigimkt.h1.p
    public final ViewGroup c() {
        return null;
    }

    @Override // com.smartdigimkt.h1.k
    public final void d() {
        MediaATView mediaATView = this.E;
        if (mediaATView != null) {
            mediaATView.changeCloseViewSizeAfterClick();
        }
    }

    @Override // com.smartdigimkt.h1.k
    public final void e() {
        super.e();
        MediaATView mediaATView = this.E;
        if (mediaATView != null) {
            mediaATView.destroy();
        }
    }

    @Override // com.smartdigimkt.h1.k
    public final View f() {
        OwnNativeATView ownNativeATView = this.q;
        MediaATView mediaATView = this.E;
        if (mediaATView == null || mediaATView.getMonitorClickView() == null) {
            return ownNativeATView;
        }
        View monitorClickView = this.E.getMonitorClickView();
        this.r = new WeakReference(monitorClickView);
        return monitorClickView;
    }

    @Override // com.smartdigimkt.h1.k
    public final List g() {
        return this.F;
    }

    @Override // com.smartdigimkt.h1.k
    public final void h() {
        super.h();
    }
}
