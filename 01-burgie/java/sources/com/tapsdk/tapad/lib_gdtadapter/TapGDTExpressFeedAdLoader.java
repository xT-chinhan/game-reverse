package com.tapsdk.tapad.lib_gdtadapter;

import android.content.Context;
import android.util.Log;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.util.AdError;
import com.tapsdk.tapad.group.adapter.AdapterExpressFeedLoader;
import com.tapsdk.tapad.group.adapter.AdapterExpressFeedSession;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterViewSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class TapGDTExpressFeedAdLoader implements AdapterExpressFeedLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterExpressFeedLoader
    public void load(Context context, AdapterLoadRequest request, AdapterLoadCallback<AdapterExpressFeedSession> callback) {
        if (!TapGDTManagerHolder.initSuccess.get()) {
            callback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "gdt sdk not init");
        } else {
            new LoadAttempt(context, request, callback).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class LoadAttempt {
        private final int adCount;
        private final AdapterLoadCallback<AdapterExpressFeedSession> callback;
        private final NativeExpressAD nativeExpressAd;
        private final ConcurrentHashMap<NativeExpressADView, TapGDTExpressFeedSession> sessions = new ConcurrentHashMap<>();
        private final AtomicBoolean loadFinished = new AtomicBoolean(false);

        LoadAttempt(Context context, AdapterLoadRequest request, AdapterLoadCallback<AdapterExpressFeedSession> callback) {
            this.callback = callback;
            this.adCount = request.getAdCount();
            int width = (int) AdapterViewSupport.pxToDp(context, request.getAcceptedWidthPx());
            int height = (int) AdapterViewSupport.pxToDp(context, request.getAcceptedHeightPx());
            this.nativeExpressAd = new NativeExpressAD(context, new ADSize(width == 0 ? -1 : width, height == 0 ? -2 : height), request.getPlacementId(), new AnonymousClass1(callback));
        }

        /* JADX INFO: renamed from: com.tapsdk.tapad.lib_gdtadapter.TapGDTExpressFeedAdLoader$LoadAttempt$1, reason: invalid class name */
        class AnonymousClass1 implements NativeExpressAD.NativeExpressADListener {
            final /* synthetic */ AdapterLoadCallback val$callback;

            AnonymousClass1(AdapterLoadCallback adapterLoadCallback) {
                this.val$callback = adapterLoadCallback;
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLoaded(List<NativeExpressADView> views) {
                if (LoadAttempt.this.loadFinished.compareAndSet(false, true)) {
                    ArrayList arrayList = new ArrayList();
                    if (views != null) {
                        for (final NativeExpressADView view : views) {
                            if (view != null) {
                                TapGDTExpressFeedSession session = new TapGDTExpressFeedSession(LoadAttempt.this.nativeExpressAd, view, new Runnable() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTExpressFeedAdLoader$LoadAttempt$1$$ExternalSyntheticLambda0
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.m392lambda$onADLoaded$0$comtapsdktapadlib_gdtadapterTapGDTExpressFeedAdLoader$LoadAttempt$1(view);
                                    }
                                });
                                LoadAttempt.this.sessions.put(view, session);
                                arrayList.add(session);
                            }
                        }
                    }
                    this.val$callback.onSuccess(arrayList);
                }
            }

            /* JADX INFO: renamed from: lambda$onADLoaded$0$com-tapsdk-tapad-lib_gdtadapter-TapGDTExpressFeedAdLoader$LoadAttempt$1, reason: not valid java name */
            /* synthetic */ void m392lambda$onADLoaded$0$comtapsdktapadlib_gdtadapterTapGDTExpressFeedAdLoader$LoadAttempt$1(NativeExpressADView view) {
                LoadAttempt.this.sessions.remove(view);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderFail(NativeExpressADView view) {
                TapGDTExpressFeedSession session = (TapGDTExpressFeedSession) LoadAttempt.this.sessions.get(view);
                if (session != null) {
                    session.onRenderFailure();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderSuccess(NativeExpressADView view) {
                TapGDTExpressFeedSession session = (TapGDTExpressFeedSession) LoadAttempt.this.sessions.get(view);
                if (session != null) {
                    session.onRenderSuccess();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADExposure(NativeExpressADView view) {
                TapGDTExpressFeedSession session = (TapGDTExpressFeedSession) LoadAttempt.this.sessions.get(view);
                if (session != null) {
                    session.onShow();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClicked(NativeExpressADView view) {
                TapGDTExpressFeedSession session = (TapGDTExpressFeedSession) LoadAttempt.this.sessions.get(view);
                if (session != null) {
                    session.onClick();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClosed(NativeExpressADView view) {
                TapGDTExpressFeedSession session = (TapGDTExpressFeedSession) LoadAttempt.this.sessions.get(view);
                if (session != null) {
                    session.onClose();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLeftApplication(NativeExpressADView view) {
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError error) {
                if (LoadAttempt.this.loadFinished.compareAndSet(false, true)) {
                    this.val$callback.onFailure(error.getErrorCode(), error.getErrorMsg());
                } else {
                    Log.i("TapADN", "广告渲染失败，失败原因" + error.getErrorCode() + "," + error.getErrorMsg());
                }
            }
        }

        void start() {
            this.nativeExpressAd.loadAD(this.adCount);
        }
    }
}
