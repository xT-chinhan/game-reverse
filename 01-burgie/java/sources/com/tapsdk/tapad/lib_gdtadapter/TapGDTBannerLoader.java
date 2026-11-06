package com.tapsdk.tapad.lib_gdtadapter;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.tapsdk.tapad.group.adapter.AdapterBannerLoader;
import com.tapsdk.tapad.group.adapter.AdapterBannerSession;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterLoadRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class TapGDTBannerLoader implements AdapterBannerLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterBannerLoader
    public void load(Context context, AdapterLoadRequest request, AdapterLoadCallback<AdapterBannerSession> callback) {
        if (!TapGDTManagerHolder.initSuccess.get()) {
            callback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "gdt sdk not init");
        } else if (!(context instanceof Activity)) {
            callback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "context 上下文错误，请传入 activity");
        } else {
            new TapGDTBannerSession((Activity) context, request, callback).load();
        }
    }
}
