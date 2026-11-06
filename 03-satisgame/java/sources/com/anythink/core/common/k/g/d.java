package com.anythink.core.common.k.g;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.core.api.ATAdAppInfo;
import com.anythink.core.api.ATCompViewListener;
import com.anythink.core.api.ATCustomVideo;
import com.anythink.core.api.ATNativeAdInfo;
import com.anythink.core.api.ATShakeViewListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.IATAdvertiserInfoOperate;
import com.anythink.core.common.h.n;
import com.anythink.core.common.inner.ui.thirdparty.ThirdPartyMediaView;
import com.anythink.core.common.k;
import com.anythink.core.common.u.p;
import com.anythink.core.e.l;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d extends BaseAd implements a, Serializable {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private BaseAd f;
    private Map<String, Object> g;
    private View h;
    private int i;
    private int j;
    private int k;
    private volatile ThirdPartyMediaView l;
    private final Object m = new Object();
    private int n;

    private static void t() {
    }

    public d(BaseAd baseAd, Map<String, Object> map) {
        this.a = 1;
        this.b = 5;
        this.c = 1;
        this.e = 5;
        this.n = 1;
        this.f = baseAd;
        this.g = map;
        this.a = p.a(map, "orientation", 1);
        this.b = p.a(map, "countdown", 5);
        this.c = p.a(map, "allows_skip", 1);
        this.n = p.a(map, k.aI, 1);
        this.d = ((Integer) p.a(this.g, k.aK, 3)).intValue();
        int iA = p.a(map, "s_c_t", 0);
        if (iA >= 0) {
            this.e = iA;
        }
        this.k = p.a(map, "c_b_i_r", 0);
        this.i = 1;
        try {
            Object obj = map.get("render_type");
            if (obj != null) {
                this.i = Integer.parseInt(obj.toString());
            }
            Object obj2 = map.get("template_type");
            if (obj != null) {
                this.j = Integer.parseInt(obj2.toString());
            }
        } catch (Throwable unused) {
        }
    }

    private void a(Map<String, Object> map) {
        this.a = p.a(map, "orientation", 1);
        this.b = p.a(map, "countdown", 5);
        this.c = p.a(map, "allows_skip", 1);
        this.n = p.a(map, k.aI, 1);
        this.d = ((Integer) p.a(this.g, k.aK, 3)).intValue();
        int iA = p.a(map, "s_c_t", 0);
        if (iA >= 0) {
            this.e = iA;
        }
        this.k = p.a(map, "c_b_i_r", 0);
        this.i = 1;
        try {
            Object obj = map.get("render_type");
            if (obj != null) {
                this.i = Integer.parseInt(obj.toString());
            }
            Object obj2 = map.get("template_type");
            if (obj != null) {
                this.j = Integer.parseInt(obj2.toString());
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.common.k.g.a
    public final int a() {
        return this.a;
    }

    @Override // com.anythink.core.common.k.g.a
    public final long b() {
        return this.b;
    }

    @Override // com.anythink.core.common.k.g.a
    public final int c() {
        int i = this.c;
        return (i != 1 && i == 0) ? 1 : 0;
    }

    @Override // com.anythink.core.common.k.g.a
    public final int d() {
        int i = this.d;
        if (i != 1) {
            return i != 2 ? 2 : 1;
        }
        return 0;
    }

    @Override // com.anythink.core.common.k.g.a
    public final int e() {
        return this.k;
    }

    @Override // com.anythink.core.common.k.g.a
    public final int f() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    @Override // com.anythink.core.common.k.g.a
    public final int g() {
        ?? r0;
        Object obj;
        boolean zEquals;
        BaseAd baseAd = this.f;
        if (baseAd == null || baseAd.getDetail() == null || this.f.getDetail().Z() != 8 || (obj = this.g.get("video_muted")) == null) {
            r0 = -1;
        } else {
            zEquals = TextUtils.equals(obj.toString(), "0");
        }
        if (r0 == -1) {
            r0 = zEquals;
            return p.a(this.g, "video_muted", 0);
        }
        r0 = zEquals;
        return r0;
    }

    @Override // com.anythink.core.api.BaseAd
    public final void setTrackingInfo(n nVar) {
        this.f.setTrackingInfo(nVar);
    }

    @Override // com.anythink.core.api.BaseAd
    public final n getDetail() {
        return this.f.getDetail();
    }

    @Override // com.anythink.core.api.BaseAd
    public final void setNetworkInfoMap(Map<String, Object> map) {
        this.f.setNetworkInfoMap(map);
    }

    @Override // com.anythink.core.api.BaseAd, com.anythink.core.api.IATThirdPartyMaterial
    public final Map<String, Object> getNetworkInfoMap() {
        return this.f.getNetworkInfoMap();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final View getCallToActionButton() {
        return this.f.getCallToActionButton();
    }

    @Override // com.anythink.core.api.BaseAd
    public final void destroy() {
        this.f.destroy();
    }

    @Override // com.anythink.core.api.BaseAd
    public final void setNativeEventListener(com.anythink.core.common.d.n nVar) {
        this.f.setNativeEventListener(nVar);
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final View getAdIconView() {
        BaseAd baseAd;
        if (this.h == null && (baseAd = this.f) != null) {
            this.h = baseAd.getAdIconView();
        }
        return this.h;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getTitle() {
        return this.f.getTitle();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getDescriptionText() {
        return this.f.getDescriptionText();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getMainImageUrl() {
        return this.f.getMainImageUrl();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getIconImageUrl() {
        return this.f.getIconImageUrl();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getCallToActionText() {
        return this.f.getCallToActionText();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final Double getStarRating() {
        return this.f.getStarRating();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getVideoUrl() {
        return this.f.getVideoUrl();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getAdChoiceIconUrl() {
        return this.f.getAdChoiceIconUrl();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getAdFrom() {
        return this.f.getAdFrom();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final View getAdLogoView() {
        return this.f.getAdLogoView();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final List<String> getImageUrlList() {
        return this.f.getImageUrlList();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final ATAdAppInfo getAdAppInfo() {
        return this.f.getAdAppInfo();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final Bitmap getAdLogo() {
        return this.f.getAdLogo();
    }

    @Override // com.anythink.core.api.BaseAd
    public final ViewGroup getCustomAdContainer() {
        return this.f.getCustomAdContainer();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getMainImageHeight() {
        return this.f.getMainImageHeight();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getMainImageWidth() {
        return this.f.getMainImageWidth();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getNativeExpressWidth() {
        return this.f.getNativeExpressWidth();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getNativeExpressHeight() {
        return this.f.getNativeExpressHeight();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getVideoWidth() {
        return this.f.getVideoWidth();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getVideoHeight() {
        return this.f.getVideoHeight();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final double getAppPrice() {
        return this.f.getAppPrice();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getAppCommentNum() {
        return this.f.getAppCommentNum();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getAdvertiserName() {
        return this.f.getAdvertiserName();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getNativeType() {
        return this.f.getNativeType();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getNativeAdInteractionType() {
        return this.f.getNativeAdInteractionType();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final double getVideoDuration() {
        return this.f.getVideoDuration();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final double getVideoProgress() {
        return this.f.getVideoProgress();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getAdType() {
        return this.f.getAdType();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final ATCustomVideo getNativeCustomVideo() {
        BaseAd baseAd = this.f;
        if (baseAd != null) {
            return baseAd.getNativeCustomVideo();
        }
        return null;
    }

    @Override // com.anythink.core.api.BaseAd
    public final void registerListener(View view, List<View> list, FrameLayout.LayoutParams layoutParams) {
        BaseAd baseAd = this.f;
        if (baseAd != null) {
            baseAd.registerListener(view, list, layoutParams);
        }
    }

    @Override // com.anythink.core.api.BaseAd
    public final void registerListener(View view, List<View> list, FrameLayout.LayoutParams layoutParams, com.anythink.core.basead.b.b bVar) {
        BaseAd baseAd = this.f;
        if (baseAd != null) {
            baseAd.registerListener(view, list, layoutParams, bVar);
        }
    }

    @Override // com.anythink.core.api.BaseAd
    public final void registerListener(View view, ATNativeAdInfo.AdPrepareInfo adPrepareInfo) {
        BaseAd baseAd = this.f;
        if (baseAd != null) {
            baseAd.registerListener(view, adPrepareInfo);
        }
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getDomain() {
        BaseAd baseAd = this.f;
        return baseAd != null ? baseAd.getDomain() : "";
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final String getWarning() {
        BaseAd baseAd = this.f;
        return baseAd != null ? baseAd.getWarning() : "";
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final View getShakeView(int i, int i2, ATShakeViewListener aTShakeViewListener) {
        BaseAd baseAd = this.f;
        if (baseAd != null) {
            return baseAd.getShakeView(i, i2, aTShakeViewListener);
        }
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final View getSlideView(int i, int i2, int i3, ATShakeViewListener aTShakeViewListener) {
        BaseAd baseAd = this.f;
        if (baseAd != null) {
            return baseAd.getSlideView(i, i2, i3, aTShakeViewListener);
        }
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final View getRoateView(Map<String, Object> map, ATCompViewListener aTCompViewListener) {
        BaseAd baseAd = this.f;
        if (baseAd != null) {
            return baseAd.getRoateView(map, aTCompViewListener);
        }
        return null;
    }

    @Override // com.anythink.core.api.BaseAd
    public final void setVideoMute(boolean z) {
        BaseAd baseAd = this.f;
        if (baseAd != null) {
            baseAd.setVideoMute(z);
        }
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final IATAdvertiserInfoOperate getAdvertiserInfoOperate() {
        BaseAd baseAd = this.f;
        if (baseAd != null) {
            return baseAd.getAdvertiserInfoOperate();
        }
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final boolean supportSetPermissionClickViewList() {
        BaseAd baseAd = this.f;
        return baseAd != null && baseAd.supportSetPermissionClickViewList();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getDownloadStatus() {
        return this.f.getDownloadStatus();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final int getDownloadProgress() {
        return this.f.getDownloadProgress();
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final boolean supportSetPrivacyClickViewList() {
        BaseAd baseAd = this.f;
        return baseAd != null && baseAd.supportSetPrivacyClickViewList();
    }

    @Override // com.anythink.core.common.k.g.a
    public final int h() {
        Map<String, Object> map = this.g;
        if (map != null && map.containsKey(l.a.aq)) {
            Object obj = this.g.get(l.a.aq);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
        }
        return 1;
    }

    @Override // com.anythink.core.common.k.g.a
    public final int[] i() {
        int[] iArr = {1, 2, 3, 4, 5};
        Map<String, Object> map = this.g;
        if (map == null || !map.containsKey(l.a.ar)) {
            return iArr;
        }
        Object obj = this.g.get(l.a.ar);
        return obj instanceof int[] ? (int[]) obj : iArr;
    }

    @Override // com.anythink.core.common.k.g.a
    public final int j() {
        return ((Integer) p.a(this.g, k.aN, 0)).intValue();
    }

    public final boolean r() {
        return j() == 0;
    }

    @Override // com.anythink.core.api.BaseAd
    public final void clear(View view) {
        BaseAd baseAd = this.f;
        if (baseAd != null) {
            baseAd.clear(view);
        }
    }

    @Override // com.anythink.core.api.BaseAd
    public final void resumeVideo() {
        BaseAd baseAd = this.f;
        if (baseAd != null) {
            baseAd.resumeVideo();
        }
    }

    @Override // com.anythink.core.api.BaseAd
    public final void pauseVideo() {
        BaseAd baseAd = this.f;
        if (baseAd != null) {
            baseAd.pauseVideo();
        }
    }

    @Override // com.anythink.core.api.BaseAd
    public final void setDevParams(Map<String, Object> map) {
        BaseAd baseAd = this.f;
        if (baseAd != null) {
            baseAd.setDevParams(map);
        }
    }

    @Override // com.anythink.core.api.BaseAd
    public final boolean isNativeExpress() {
        BaseAd baseAd = this.f;
        if (baseAd != null) {
            return baseAd.isNativeExpress();
        }
        return false;
    }

    @Override // com.anythink.core.common.k.g.a
    public final int k() {
        return ((Integer) p.a(this.g, k.aL, 1)).intValue();
    }

    @Override // com.anythink.core.common.k.g.a
    public final int l() {
        return ((Integer) p.a(this.g, k.aO, 1)).intValue();
    }

    @Override // com.anythink.core.common.k.g.a
    public final int n() {
        return ((Integer) p.a(this.g, k.aK, 3)).intValue();
    }

    @Override // com.anythink.core.common.k.g.a
    public final int m() {
        return ((Integer) p.a(this.g, k.aG, 1)).intValue();
    }

    @Override // com.anythink.core.common.k.g.a
    public final int o() {
        return ((Integer) p.a(this.g, k.aH, 2)).intValue();
    }

    @Override // com.anythink.core.common.k.g.a
    public final String p() {
        return (String) p.a(this.g, "size", "");
    }

    private boolean a(Object... objArr) {
        return getAdMediaView(objArr) == null && TextUtils.isEmpty(getMainImageUrl());
    }

    @Override // com.anythink.core.common.k.g.a
    public final int q() {
        if (this.i == 1) {
            return 3;
        }
        return this.j;
    }

    private boolean u() {
        return (d() == 0 || isNativeExpress()) ? false : true;
    }

    public final boolean s() {
        return this.n == 2;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final View getAdMediaView(Object... objArr) {
        if ((d() == 0 || isNativeExpress()) ? false : true) {
            if (this.l == null) {
                synchronized (this.m) {
                    if (this.l == null) {
                        try {
                            BaseAd baseAd = this.f;
                            View adMediaView = baseAd != null ? baseAd.getAdMediaView(objArr) : null;
                            if (adMediaView != null) {
                                if (adMediaView.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) adMediaView.getParent()).removeView(adMediaView);
                                }
                                this.l = new ThirdPartyMediaView(adMediaView.getContext());
                                this.l.setInterceptTouchEvent(true);
                                this.l.addView(adMediaView);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
            return this.l;
        }
        BaseAd baseAd2 = this.f;
        if (baseAd2 != null) {
            return baseAd2.getAdMediaView(objArr);
        }
        return null;
    }
}
