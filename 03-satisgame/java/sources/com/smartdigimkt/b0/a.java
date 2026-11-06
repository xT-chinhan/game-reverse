package com.smartdigimkt.b0;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.smartdigimkt.sdk.api.ISDMDirectlyOfferSetting;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements ISDMDirectlyOfferSetting {
    public volatile String a;
    public volatile Drawable b;
    public WeakReference c;
    public WeakReference d;
    public Boolean e;

    @Override // com.smartdigimkt.sdk.api.ISDMDirectlyOfferSetting
    public final Drawable getDirectlySplashAdCTAButtongBgDrawable() {
        return this.b;
    }

    @Override // com.smartdigimkt.sdk.api.ISDMDirectlyOfferSetting
    public final String getDirectlySplashAdShakeIconString() {
        return this.a;
    }

    @Override // com.smartdigimkt.sdk.api.ISDMDirectlyOfferSetting
    public final View getDirectlySplashCTAButton() {
        View view;
        WeakReference weakReference = this.c;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return null;
        }
        return view;
    }

    @Override // com.smartdigimkt.sdk.api.ISDMDirectlyOfferSetting
    public final Boolean getDirectlySplashMuteIconVisible() {
        return this.e;
    }

    @Override // com.smartdigimkt.sdk.api.ISDMDirectlyOfferSetting
    public final View getDirectlySplashShakeButton() {
        View view;
        WeakReference weakReference = this.d;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return null;
        }
        return view;
    }

    @Override // com.smartdigimkt.sdk.api.ISDMDirectlyOfferSetting
    public final void setDirectlySplashAdCTAButtongBgDrawable(Drawable drawable) {
        this.b = drawable;
    }

    @Override // com.smartdigimkt.sdk.api.ISDMDirectlyOfferSetting
    public final void setDirectlySplashAdShakeIconString(String str) {
        this.a = str;
    }

    @Override // com.smartdigimkt.sdk.api.ISDMDirectlyOfferSetting
    public final void setDirectlySplashCTAButton(View view) {
        if (view != null) {
            this.c = new WeakReference(view);
        }
    }

    @Override // com.smartdigimkt.sdk.api.ISDMDirectlyOfferSetting
    public final void setDirectlySplashMuteIconVisible(boolean z) {
        this.e = Boolean.valueOf(z);
    }

    @Override // com.smartdigimkt.sdk.api.ISDMDirectlyOfferSetting
    public final void setDirectlySplashShakeButton(View view) {
        if (view != null) {
            this.d = new WeakReference(view);
        }
    }
}
