package com.anythink.core.common.inner.ui.thirdparty;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.u.p;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    public interface a {
        void a(View view, View view2, View view3);
    }

    public static void a(ViewGroup viewGroup, BaseAd baseAd, a aVar) {
        if (baseAd == null || viewGroup == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.leftMargin = p.a(viewGroup.getContext(), 10.0f);
        String domain = baseAd.getDomain();
        String warning = baseAd.getWarning();
        String adFrom = baseAd.getAdFrom();
        if (!(TextUtils.isEmpty(domain) && TextUtils.isEmpty(warning) && TextUtils.isEmpty(adFrom)) && (viewGroup instanceof RelativeLayout)) {
            ThirdPartyNativeExtView thirdPartyNativeExtView = new ThirdPartyNativeExtView(viewGroup.getContext());
            thirdPartyNativeExtView.initView(domain, warning, adFrom);
            viewGroup.addView(thirdPartyNativeExtView, layoutParams);
            aVar.a(thirdPartyNativeExtView.getDomainView(), thirdPartyNativeExtView.getWarningView(), thirdPartyNativeExtView.getAdFromView());
        }
    }

    private static void a(ViewGroup viewGroup, BaseAd baseAd, a aVar, RelativeLayout.LayoutParams layoutParams) {
        String domain = baseAd.getDomain();
        String warning = baseAd.getWarning();
        String adFrom = baseAd.getAdFrom();
        if (!(TextUtils.isEmpty(domain) && TextUtils.isEmpty(warning) && TextUtils.isEmpty(adFrom)) && (viewGroup instanceof RelativeLayout)) {
            ThirdPartyNativeExtView thirdPartyNativeExtView = new ThirdPartyNativeExtView(viewGroup.getContext());
            thirdPartyNativeExtView.initView(domain, warning, adFrom);
            viewGroup.addView(thirdPartyNativeExtView, layoutParams);
            if (aVar != null) {
                aVar.a(thirdPartyNativeExtView.getDomainView(), thirdPartyNativeExtView.getWarningView(), thirdPartyNativeExtView.getAdFromView());
            }
        }
    }
}
