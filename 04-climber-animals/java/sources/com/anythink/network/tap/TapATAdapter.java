package com.anythink.network.tap;

import android.content.Context;
import android.util.Log;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.tapsdk.tapad.TapAdManager;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapFeedAd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TapATAdapter extends CustomNativeAdapter {
    private static final String a = "TapATAdapter";
    private boolean c;
    private TapAdNative e;
    private final TapATInitManager b = TapATInitManager.getInstance();
    private int d = 0;
    private String f = "0";

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.c = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, Map<String, Object> map, final Map<String, Object> map2) {
        this.d = this.b.getSpaceId(map);
        this.f = ATInitMediation.getStringFromMap(map, "unit_type", "0");
        if (this.d == 0) {
            notifyATLoadFail("", "NativeAd spaceId is null. spaceId:" + this.d);
        } else {
            this.b.initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.tap.TapATAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    TapATAdapter.this.postOnMainThread(new Runnable() { // from class: com.anythink.network.tap.TapATAdapter.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            TapATAdapter.a(TapATAdapter.this, context, map2);
                        }
                    });
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    TapATAdapter.this.notifyATLoadFail("", str);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.tap.TapATAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements TapAdNative.FeedAdListener {
        final /* synthetic */ Context a;
        final /* synthetic */ Map b;

        AnonymousClass2(Context context, Map map) {
            this.a = context;
            this.b = map;
        }

        @Override // com.tapsdk.tapad.TapAdNative.FeedAdListener
        public final void onFeedAdLoad(List<TapFeedAd> list) {
            if (list != null && !list.isEmpty()) {
                if (TapATAdapter.this.f.equals("0")) {
                    if (TapATAdapter.this.c) {
                        TapFeedAd tapFeedAd = list.get(0);
                        TapATAdapter.this.b.handleAdLoadedCallback(true, tapFeedAd, tapFeedAd.getMediaExtraInfo(), TapATAdapter.this.mBiddingListener, TapATAdapter.this.mLoadListener, new TapATNativeAd(this.a, tapFeedAd, TapATAdapter.this.e));
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator<TapFeedAd> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new TapATNativeAd(this.a, it.next(), TapATAdapter.this.e));
                    }
                    if (TapATAdapter.this.mLoadListener != null) {
                        TapATAdapter.this.mLoadListener.onAdCacheLoaded((BaseAd[]) arrayList.toArray(new BaseAd[arrayList.size()]));
                        return;
                    }
                    return;
                }
                if (!TapATAdapter.this.f.equals("1")) {
                    TapATAdapter.this.notifyATLoadFail("", "NativeAd load failed, unitType is not right:" + TapATAdapter.this.f);
                    return;
                } else {
                    TapATAdapter.a(TapATAdapter.this, list, this.b);
                    return;
                }
            }
            TapATAdapter.this.notifyATLoadFail("", "NativeAd load failed, list is null.");
        }

        @Override // com.tapsdk.tapad.internal.CommonListener
        public final void onError(int i, String str) {
            TapATAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }
    }

    private void a(Context context, Map<String, Object> map) {
        TapAdNative tapAdNativeCreateAdNative = TapAdManager.get().createAdNative(context);
        this.e = tapAdNativeCreateAdNative;
        tapAdNativeCreateAdNative.loadFeedAd(this.b.getAdRequest(this.d, map), new AnonymousClass2(context, map));
    }

    private void a(List<TapFeedAd> list, Map<String, Object> map) {
        TapFeedAd tapFeedAd = list.get(0);
        this.b.handleAdDataLoadedCallback(this.c, tapFeedAd.getMediaExtraInfo(), this.mBiddingListener, this.mLoadListener, new BaseAd[0]);
        int[] iArr = {list.size()};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            new TapATExpressAd(list.get(i), this.e, map, new AnonymousClass3(arrayList, iArr, tapFeedAd));
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.tap.TapATAdapter$3, reason: invalid class name */
    final class AnonymousClass3 implements TapATExpressAd.RenderCallback {
        final /* synthetic */ List a;
        final /* synthetic */ int[] b;
        final /* synthetic */ TapFeedAd c;

        AnonymousClass3(List list, int[] iArr, TapFeedAd tapFeedAd) {
            this.a = list;
            this.b = iArr;
            this.c = tapFeedAd;
        }

        @Override // com.anythink.network.tap.TapATExpressAd.RenderCallback
        public final void onRenderSuccess(TapATExpressAd tapATExpressAd) {
            Log.i(TapATAdapter.a, "onRenderSuccess()");
            this.a.add(tapATExpressAd);
            int[] iArr = this.b;
            int i = iArr[0] - 1;
            iArr[0] = i;
            if (i == 0) {
                BaseAd[] baseAdArr = (BaseAd[]) this.a.toArray(new BaseAd[this.a.size()]);
                TapATInitManager tapATInitManager = TapATAdapter.this.b;
                boolean z = TapATAdapter.this.c;
                TapFeedAd tapFeedAd = this.c;
                tapATInitManager.handleAdLoadedCallback(z, tapFeedAd, tapFeedAd.getMediaExtraInfo(), TapATAdapter.this.mBiddingListener, TapATAdapter.this.mLoadListener, baseAdArr);
            }
        }

        @Override // com.anythink.network.tap.TapATExpressAd.RenderCallback
        public final void onRenderFail(String str, int i) {
            Log.e(TapATAdapter.a, String.format("onRenderFail, errorCode: %d, errorMsg: %s", Integer.valueOf(i), str));
            int[] iArr = this.b;
            int i2 = iArr[0] - 1;
            iArr[0] = i2;
            if (i2 == 0) {
                if (this.a.isEmpty()) {
                    TapATAdapter.this.notifyATLoadFail(String.valueOf(i), str);
                    return;
                }
                BaseAd[] baseAdArr = (BaseAd[]) this.a.toArray(new BaseAd[this.a.size()]);
                TapATInitManager tapATInitManager = TapATAdapter.this.b;
                boolean z = TapATAdapter.this.c;
                TapFeedAd tapFeedAd = this.c;
                tapATInitManager.handleAdLoadedCallback(z, tapFeedAd, tapFeedAd.getMediaExtraInfo(), TapATAdapter.this.mBiddingListener, TapATAdapter.this.mLoadListener, baseAdArr);
            }
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return String.valueOf(this.d);
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return this.b.getNetworkVersion();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return this.b.getNetworkName();
    }

    static /* synthetic */ void a(TapATAdapter tapATAdapter, Context context, Map map) {
        TapAdNative tapAdNativeCreateAdNative = TapAdManager.get().createAdNative(context);
        tapATAdapter.e = tapAdNativeCreateAdNative;
        tapAdNativeCreateAdNative.loadFeedAd(tapATAdapter.b.getAdRequest(tapATAdapter.d, map), tapATAdapter.new AnonymousClass2(context, map));
    }

    static /* synthetic */ void a(TapATAdapter tapATAdapter, List list, Map map) {
        TapFeedAd tapFeedAd = (TapFeedAd) list.get(0);
        tapATAdapter.b.handleAdDataLoadedCallback(tapATAdapter.c, tapFeedAd.getMediaExtraInfo(), tapATAdapter.mBiddingListener, tapATAdapter.mLoadListener, new BaseAd[0]);
        int[] iArr = {list.size()};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            new TapATExpressAd((TapFeedAd) list.get(i), tapATAdapter.e, map, tapATAdapter.new AnonymousClass3(arrayList, iArr, tapFeedAd));
        }
    }
}
