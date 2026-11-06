package com.anythink.core.common.inner.ui.thirdparty;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.api.ATNativeAdInfo;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.inner.ui.BaseMediaATView;
import com.anythink.core.common.inner.ui.MediaATView;
import com.anythink.core.common.k.e.a.d;
import com.anythink.core.common.u.al;
import com.anythink.core.common.u.p;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ThirdPartyNativeTemplateView extends MediaATView implements d {
    ATNativeAdInfo.AdPrepareInfo r;
    private BaseAd s;

    @Override // com.anythink.core.common.k.e.a.d
    public void destroyNativeAd() {
    }

    public ThirdPartyNativeTemplateView(Context context, w wVar, x xVar, boolean z, BaseMediaATView.a aVar, BaseAd baseAd) {
        super(context, wVar, xVar, z, aVar);
        this.s = baseAd;
    }

    @Override // com.anythink.core.common.inner.ui.MediaATView, com.anythink.core.common.inner.ui.BaseMediaATView
    public void init(int i, int i2, int i3) {
        super.init(i, i2, i3);
        ATNativeAdInfo.AdPrepareInfo adPrepareInfo = new ATNativeAdInfo.AdPrepareInfo();
        this.r = adPrepareInfo;
        adPrepareInfo.setTitleView(this.j);
        this.r.setDescView(this.o);
        this.r.setIconView(this.n);
        this.r.setMainImageView(this.m);
        this.r.setCtaView(this.k);
        this.r.setParentView(this);
        this.r.setCloseView(this.g);
        this.r.setAdLogoView(this.p);
        this.r.getClickViewList().clear();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.k);
        if (this.c.t.q() == 0) {
            arrayList.add(this.j);
            arrayList.add(this.o);
            arrayList.add(this.n);
            arrayList.add(this.m);
            arrayList.add(this);
        }
        this.r.setClickViewList(arrayList);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(p.a(getContext(), 32.0f), p.a(getContext(), 12.0f));
        layoutParams.gravity = 85;
        this.r.setChoiceViewLayoutParams(layoutParams);
        View adIconView = this.s.getAdIconView();
        if (this.n != null && adIconView != null) {
            if (this.n.getParent() != null && (this.n.getParent() instanceof ViewGroup)) {
                al.a(adIconView);
                this.n.setVisibility(0);
                ((ViewGroup) this.n.getParent()).addView(adIconView, this.n.getLayoutParams());
            }
            if (this.c.t.q() != 0) {
                c.a(adIconView);
            }
        }
        View adLogoView = this.s.getAdLogoView();
        if (this.p != null && adLogoView != null && this.p.getParent() != null && (this.p.getParent() instanceof ViewGroup)) {
            al.a(adLogoView);
            this.p.setVisibility(4);
            ((ViewGroup) this.p.getParent()).addView(adLogoView, this.p.getLayoutParams());
        }
        if (this.i != null) {
            com.anythink.core.basead.b.b bVar = new com.anythink.core.basead.b.b();
            this.i.a(this.s, bVar, true);
            this.r.setDomainView(bVar.h());
            this.r.setWarningView(bVar.i());
            this.r.setAdFromView(bVar.f());
        }
    }

    @Override // com.anythink.core.common.inner.ui.MediaATView
    protected final void a(int i, int i2) {
        ViewGroup viewGroup = (ViewGroup) findViewById(p.a(getContext(), "myoffer_media_ad_main_image_container", "id"));
        View adMediaView = this.s.getAdMediaView(viewGroup);
        if (viewGroup != null && adMediaView != null) {
            if (this.c.t.q() != 0) {
                c.a(adMediaView);
            }
            al.a(adMediaView);
            viewGroup.addView(adMediaView, new ViewGroup.LayoutParams(-1, -1));
        } else {
            super.a(i, i2);
        }
        this.s.setVideoMute(true);
        View viewFindViewById = findViewById(p.a(getContext(), "myoffer_ad_lable", "id"));
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
        }
    }

    @Override // com.anythink.core.common.inner.ui.MediaATView
    protected final boolean a() {
        return this.s.getAdIconView() == null && super.a();
    }

    public ATNativeAdInfo.AdPrepareInfo getAdPrepareInfo() {
        return this.r;
    }
}
