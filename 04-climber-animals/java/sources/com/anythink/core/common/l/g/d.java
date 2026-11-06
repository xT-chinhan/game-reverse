package com.anythink.core.common.l.g;

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
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.o;
import com.anythink.core.common.h.n;
import com.anythink.core.common.k;
import com.anythink.core.common.v.q;
import com.anythink.core.d.l;
import com.anythink.network.tap.TapATInitManager;
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

    private static void q() {
    }

    public d(BaseAd baseAd, Map<String, Object> map) {
        this.a = 1;
        this.b = 5;
        this.c = 1;
        this.e = 5;
        this.f = baseAd;
        this.g = map;
        Object obj = map.get(TapATInitManager.ORIENTATION_KEY);
        if (obj != null) {
            this.a = Integer.parseInt(obj.toString());
        }
        Object obj2 = map.get("countdown");
        if (obj2 != null) {
            this.b = Integer.parseInt(obj2.toString());
        }
        Object obj3 = map.get("allows_skip");
        if (obj3 != null) {
            this.c = Integer.parseInt(obj3.toString());
        }
        this.d = ((Integer) q.a(this.g, k.aJ, 3)).intValue();
        Object obj4 = map.get("s_c_t");
        if (obj4 != null) {
            this.e = Integer.parseInt(obj4.toString());
        }
        this.i = 1;
        try {
            Object obj5 = map.get(j.w.E);
            if (obj5 != null) {
                this.i = Integer.parseInt(obj5.toString());
            }
            Object obj6 = map.get(j.w.F);
            if (obj5 != null) {
                this.j = Integer.parseInt(obj6.toString());
            }
        } catch (Throwable unused) {
        }
    }

    private void a(Map<String, Object> map) {
        Object obj = map.get(TapATInitManager.ORIENTATION_KEY);
        if (obj != null) {
            this.a = Integer.parseInt(obj.toString());
        }
        Object obj2 = map.get("countdown");
        if (obj2 != null) {
            this.b = Integer.parseInt(obj2.toString());
        }
        Object obj3 = map.get("allows_skip");
        if (obj3 != null) {
            this.c = Integer.parseInt(obj3.toString());
        }
        this.d = ((Integer) q.a(this.g, k.aJ, 3)).intValue();
        Object obj4 = map.get("s_c_t");
        if (obj4 != null) {
            this.e = Integer.parseInt(obj4.toString());
        }
        this.i = 1;
        try {
            Object obj5 = map.get(j.w.E);
            if (obj5 != null) {
                this.i = Integer.parseInt(obj5.toString());
            }
            Object obj6 = map.get(j.w.F);
            if (obj5 != null) {
                this.j = Integer.parseInt(obj6.toString());
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.common.l.g.a
    public final int a() {
        return this.a;
    }

    @Override // com.anythink.core.common.l.g.a
    public final long b() {
        return this.b;
    }

    @Override // com.anythink.core.common.l.g.a
    public final int c() {
        int i = this.c;
        return (i != 1 && i == 0) ? 1 : 0;
    }

    @Override // com.anythink.core.common.l.g.a
    public final int d() {
        int i = this.d;
        if (i != 1) {
            return i != 2 ? 2 : 1;
        }
        return 0;
    }

    @Override // com.anythink.core.common.l.g.a
    public final int e() {
        return this.e;
    }

    @Override // com.anythink.core.common.l.g.a
    public final int f() {
        if (this.f.getDetail() != null) {
            int iY = this.f.getDetail().Y();
            if (iY == 8) {
                Object obj = this.g.get("video_muted");
                if (obj != null) {
                    return TextUtils.equals(obj.toString(), "0") ? 1 : 0;
                }
            } else if (iY == 22) {
                return 1;
            }
        }
        return 0;
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
    public final void setNativeEventListener(o oVar) {
        this.f.setNativeEventListener(oVar);
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
    public final View getAdMediaView(Object... objArr) {
        return this.f.getAdMediaView(objArr);
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

    @Override // com.anythink.core.common.l.g.a
    public final int g() {
        Map<String, Object> map = this.g;
        if (map != null && map.containsKey(l.a.aq)) {
            Object obj = this.g.get(l.a.aq);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
        }
        return 1;
    }

    @Override // com.anythink.core.common.l.g.a
    public final int[] h() {
        int[] iArr = {1, 2, 3, 4, 5};
        Map<String, Object> map = this.g;
        if (map == null || !map.containsKey(l.a.ar)) {
            return iArr;
        }
        Object obj = this.g.get(l.a.ar);
        return obj instanceof int[] ? (int[]) obj : iArr;
    }

    @Override // com.anythink.core.common.l.g.a
    public final int i() {
        return ((Integer) q.a(this.g, k.aM, 0)).intValue();
    }

    public final boolean p() {
        return i() == 0;
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

    @Override // com.anythink.core.common.l.g.a
    public final int j() {
        return ((Integer) q.a(this.g, k.aK, 1)).intValue();
    }

    @Override // com.anythink.core.common.l.g.a
    public final int l() {
        return ((Integer) q.a(this.g, k.aJ, 3)).intValue();
    }

    @Override // com.anythink.core.common.l.g.a
    public final int k() {
        return ((Integer) q.a(this.g, k.aF, 1)).intValue();
    }

    @Override // com.anythink.core.common.l.g.a
    public final int m() {
        return ((Integer) q.a(this.g, k.aG, 2)).intValue();
    }

    @Override // com.anythink.core.common.l.g.a
    public final String n() {
        return (String) q.a(this.g, "size", "");
    }

    private boolean a(Object... objArr) {
        return getAdMediaView(objArr) == null && TextUtils.isEmpty(getMainImageUrl());
    }

    @Override // com.anythink.core.common.l.g.a
    public final int o() {
        if (this.i == 1) {
            return 3;
        }
        return this.j;
    }
}
