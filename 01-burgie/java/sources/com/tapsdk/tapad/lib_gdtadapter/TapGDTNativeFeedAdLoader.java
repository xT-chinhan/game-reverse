package com.tapsdk.tapad.lib_gdtadapter;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.util.AdError;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedLoader;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class TapGDTNativeFeedAdLoader implements AdapterNativeFeedLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedLoader
    public void load(Context context, AdapterLoadRequest request, AdapterLoadCallback<AdapterNativeFeedSession> callback) {
        if (!TapGDTManagerHolder.initSuccess.get()) {
            callback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "gdt sdk not init");
        } else {
            new LoadAttempt(context, request, callback).start();
        }
    }

    private static final class LoadAttempt {
        private final NativeUnifiedAD ad;
        private final AdapterLoadRequest request;

        LoadAttempt(final Context context, final AdapterLoadRequest request, final AdapterLoadCallback<AdapterNativeFeedSession> callback) {
            this.request = request;
            this.ad = new NativeUnifiedAD(context, request.getPlacementId(), new NativeADUnifiedListener() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTNativeFeedAdLoader.LoadAttempt.1
                @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
                public void onADLoaded(List<NativeUnifiedADData> list) {
                    ArrayList arrayList = new ArrayList();
                    if (list != null) {
                        for (NativeUnifiedADData adData : list) {
                            if (adData != null) {
                                arrayList.add(new TapGDTNativeFeedSession(adData, request.getAcceptedWidthPx(), request.getAcceptedHeightPx(), context));
                            }
                        }
                    }
                    callback.onSuccess(arrayList);
                }

                @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
                public void onNoAD(AdError error) {
                    callback.onFailure(error == null ? -1 : error.getErrorCode(), error == null ? "" : error.getErrorMsg());
                }
            });
        }

        void start() {
            LoadAdParams loadAdParams = new LoadAdParams();
            Map<String, String> devExtra = new HashMap<>();
            devExtra.put("query", this.request.getQuery());
            loadAdParams.setDevExtra(devExtra);
            this.ad.loadData(this.request.getAdCount(), loadAdParams);
        }
    }
}
