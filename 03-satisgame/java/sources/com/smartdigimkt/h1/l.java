package com.smartdigimkt.h1;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.smartdigimkt.sdk.basead.ui.OwnNativeATView;
import com.smartdigimkt.sdk.basead.ui.SimpleMediaATView;
import com.smartdigimkt.sdk.basead.ui.SimplePlayerMediaView;
import com.smartdigimkt.t4.v;
import com.smartdigimkt.z.c0;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends k {
    public FrameLayout E;

    public l(Context context, com.smartdigimkt.b3.l lVar, com.smartdigimkt.a3.a aVar, boolean z) {
        super(context, lVar, aVar, z);
    }

    @Override // com.smartdigimkt.h1.p
    public final View a(Context context, v vVar) {
        View view;
        SimpleMediaATView simpleMediaATView;
        com.smartdigimkt.b3.e eVar;
        HashMap map;
        SimplePlayerMediaView simplePlayerMediaView;
        if (this.i == 1 && !TextUtils.isEmpty(this.b.i)) {
            simplePlayerMediaView = new SimplePlayerMediaView(context);
            this.s = simplePlayerMediaView;
            simplePlayerMediaView.initPlayerView(this.b, this.c, this.t);
            this.s.setIsMuted(this.g);
            this.s.setAutoPlay(this.h);
            this.s.setVideoListener(vVar);
            this.s.setPlayerOnClickListener(new a(this));
        } else if (TextUtils.isEmpty(this.b.f)) {
            view = null;
        } else {
            simpleMediaATView = new SimpleMediaATView(context);
            simpleMediaATView.initView(this.b);
            com.smartdigimkt.a3.a aVar = this.c;
            if (aVar != null && (eVar = aVar.s) != null && eVar.e != 1) {
                view = simpleMediaATView;
                view = simpleMediaATView;
                view = simpleMediaATView;
                simpleMediaATView.setOnClickListener(this.B);
                view = simpleMediaATView;
            }
        }
        if (view != null && (map = this.y) != null) {
            map.put("native_media_view", view);
            i iVar = this.v;
            if (iVar != null) {
                view = simplePlayerMediaView;
                iVar.a(this.y);
            }
        }
        view = simplePlayerMediaView;
        view = simplePlayerMediaView;
        view = simplePlayerMediaView;
        return view;
    }

    @Override // com.smartdigimkt.h1.p
    public final View b() {
        if (!c0.d(this.c)) {
            return null;
        }
        if (this.E == null) {
            FrameLayout frameLayout = new FrameLayout(this.a.getApplicationContext());
            this.E = frameLayout;
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            this.y.put("shake_view_extra_container", this.E);
        }
        return this.E;
    }

    @Override // com.smartdigimkt.h1.p
    public final ViewGroup c() {
        OwnNativeATView ownNativeATView = this.q;
        if (ownNativeATView != null) {
            ownNativeATView.releaseAllCallback();
        }
        OwnNativeATView ownNativeATView2 = new OwnNativeATView(this.a);
        ownNativeATView2.setClickRecordHelper(this.w);
        this.A = false;
        this.q = ownNativeATView2;
        return ownNativeATView2;
    }

    @Override // com.smartdigimkt.h1.k
    public final View f() {
        View[] viewArr = new View[1];
        a(this.q, viewArr);
        if (viewArr[0] == null) {
            return this.q;
        }
        this.r = new WeakReference(viewArr[0]);
        return viewArr[0];
    }

    @Override // com.smartdigimkt.h1.k
    public final void a(View view, List list, List list2, FrameLayout.LayoutParams layoutParams, View view2) {
        super.a(view, list, list2, layoutParams, view2);
    }

    public final void a(View view, View[] viewArr) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), viewArr);
            }
            return;
        }
        if ((view instanceof TextView) && TextUtils.equals(((TextView) view).getText().toString(), this.b.h)) {
            viewArr[0] = view;
        }
    }
}
