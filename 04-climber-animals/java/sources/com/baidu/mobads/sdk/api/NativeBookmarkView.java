package com.baidu.mobads.sdk.api;

import android.view.View;
import com.baidu.mobads.sdk.internal.az;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NativeBookmarkView {
    private View bookmarkView;
    private final NativeResponse nativeResponse;
    private final JSONObject params = new JSONObject();

    public NativeBookmarkView(NativeResponse nativeResponse, int i, int i2) {
        this.nativeResponse = nativeResponse;
        putValue("type", "template");
        putValue(IAdInterListener.AdReqParam.WIDTH, Integer.valueOf(i));
        putValue("h", Integer.valueOf(i2));
    }

    public NativeBookmarkView regionClick(boolean z) {
        putValue("region_click", Boolean.valueOf(z));
        return this;
    }

    public NativeBookmarkView bottomCardColor(String str) {
        putValue("bottom_card_color", str);
        return this;
    }

    public NativeBookmarkView mute(boolean z) {
        putValue("mute", Boolean.valueOf(z));
        return this;
    }

    public NativeBookmarkView hideAdLogo(boolean z) {
        putValue("hide_ad_logo", Boolean.valueOf(z));
        return this;
    }

    public NativeBookmarkView hideMuteButton(boolean z) {
        putValue("hide_mute", Boolean.valueOf(z));
        return this;
    }

    public NativeBookmarkView hideDislike(boolean z) {
        putValue("hide_dislike", Boolean.valueOf(z));
        return this;
    }

    public NativeBookmarkView dislikeListener(NativeResponse.AdDislikeListener adDislikeListener) {
        NativeResponse nativeResponse = this.nativeResponse;
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).setAdDislikeListener(adDislikeListener);
        }
        return this;
    }

    public NativeBookmarkView closeListener(NativeResponse.AdCloseListener adCloseListener) {
        NativeResponse nativeResponse = this.nativeResponse;
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).setAdCloseListener(adCloseListener);
        }
        return this;
    }

    public NativeResponse getNativeResponse() {
        return this.nativeResponse;
    }

    public View render() {
        NativeResponse nativeResponse = this.nativeResponse;
        if (!(nativeResponse instanceof XAdNativeResponse)) {
            return null;
        }
        View viewRenderNativeView = ((XAdNativeResponse) nativeResponse).renderNativeView("bookmark", this.params);
        this.bookmarkView = viewRenderNativeView;
        return viewRenderNativeView;
    }

    public View getView() {
        return this.bookmarkView;
    }

    private void putValue(String str, Object obj) {
        try {
            this.params.put(str, obj);
        } catch (JSONException e) {
            az.b(e);
        }
    }
}
