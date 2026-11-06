package com.anythink.network.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GDTATNativeExpressAd extends CustomNativeAd {
    NativeExpressAD a;
    NativeExpressADView b;
    com.anythink.network.gdt.a c;
    String d;
    private Boolean e = Boolean.FALSE;

    class a implements NativeExpressAD.NativeExpressADListener {

        /* JADX INFO: renamed from: com.anythink.network.gdt.GDTATNativeExpressAd$a$a, reason: collision with other inner class name */
        class C0069a implements NativeExpressMediaListener {
            C0069a() {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoCached(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoComplete(NativeExpressADView nativeExpressADView) {
                GDTATNativeExpressAd.this.notifyAdVideoEnd();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoError(NativeExpressADView nativeExpressADView, AdError adError) {
                GDTATNativeExpressAd.this.notifyAdVideoVideoPlayFail("" + adError.getErrorCode(), adError.getErrorMsg());
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoInit(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoLoading(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPageClose(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPageOpen(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPause(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoReady(NativeExpressADView nativeExpressADView, long j) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoStart(NativeExpressADView nativeExpressADView) {
                GDTATNativeExpressAd.this.notifyAdVideoStart();
            }
        }

        a() {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            GDTATNativeExpressAd.this.notifyAdClicked();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            GDTATNativeExpressAd.this.notifyAdDislikeClick();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            GDTATInitManager.getInstance().a(GDTATNativeExpressAd.this.getShowId(), new WeakReference(GDTATNativeExpressAd.this.b));
            GDTATNativeExpressAd.this.notifyAdImpression();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            try {
                if (list.size() <= 0) {
                    com.anythink.network.gdt.a aVar = GDTATNativeExpressAd.this.c;
                    if (aVar != null) {
                        aVar.notifyError("", "GDT Ad request success but no Ad return.");
                    }
                    GDTATNativeExpressAd.this.c = null;
                    return;
                }
                NativeExpressADView nativeExpressADView = list.get(0);
                GDTATNativeExpressAd.this.setNetworkInfoMap(GDTATInitManager.getInstance().a(nativeExpressADView.getExtraInfo(), (Map<String, Object>) null));
                GDTATNativeExpressAd.this.b = nativeExpressADView;
                AdData boundData = nativeExpressADView.getBoundData();
                if (boundData != null) {
                    if (boundData.getAdPatternType() == 2) {
                        ((CustomNativeAd) GDTATNativeExpressAd.this).mAdSourceType = "1";
                    } else {
                        ((CustomNativeAd) GDTATNativeExpressAd.this).mAdSourceType = "2";
                    }
                }
                GDTATNativeExpressAd.this.setVideoDuration(boundData != null ? boundData.getVideoDuration() / 1000 : 0.0d);
                GDTATNativeExpressAd.this.b.setMediaListener(new C0069a());
                GDTATNativeExpressAd gDTATNativeExpressAd = GDTATNativeExpressAd.this;
                com.anythink.network.gdt.a aVar2 = gDTATNativeExpressAd.c;
                if (aVar2 != null) {
                    aVar2.notifyLoaded(gDTATNativeExpressAd);
                }
                GDTATNativeExpressAd.this.c = null;
            } catch (Throwable th) {
                com.anythink.network.gdt.a aVar3 = GDTATNativeExpressAd.this.c;
                if (aVar3 != null) {
                    aVar3.notifyError("", "GDT Ad request fail:" + th.getMessage());
                }
                GDTATNativeExpressAd.this.c = null;
                th.printStackTrace();
            }
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            com.anythink.network.gdt.a aVar = GDTATNativeExpressAd.this.c;
            if (aVar != null) {
                aVar.notifyError(adError.getErrorCode() + "", adError.getErrorMsg());
            }
            GDTATNativeExpressAd.this.c = null;
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            com.anythink.network.gdt.a aVar = GDTATNativeExpressAd.this.c;
            if (aVar != null) {
                aVar.notifyError("", "GDT onRenderFail");
            }
            GDTATNativeExpressAd.this.c = null;
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                NativeExpressADView nativeExpressADView = GDTATNativeExpressAd.this.b;
                if (nativeExpressADView != null) {
                    nativeExpressADView.render();
                }
            } catch (Throwable unused) {
            }
        }
    }

    class c implements DownloadConfirmListener {
        c() {
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmListener
        public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
            GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
            gDTDownloadFirmInfo.appInfoUrl = str;
            gDTDownloadFirmInfo.scenes = i;
            gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
            GDTATNativeExpressAd.this.notifyDownloadConfirm(activity, null, gDTDownloadFirmInfo);
        }
    }

    protected GDTATNativeExpressAd(Context context, String str, int i, int i2, int i3, int i4, int i5, String str2) {
        this.d = str2;
        a aVar = new a();
        int iA = i > 0 ? GDTATInitManager.getInstance().a(context, i) : -1;
        int iA2 = i2 > 0 ? GDTATInitManager.getInstance().a(context, i2) : -2;
        if (TextUtils.isEmpty(str2)) {
            this.a = new NativeExpressAD(context, new ADSize(iA, iA2), str, aVar);
        } else {
            this.a = new NativeExpressAD(context, new ADSize(iA, iA2), str, aVar, str2);
        }
        boolean zIsPlayMute = GDTATInitManager.getInstance().isPlayMute(i3);
        this.a.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(zIsPlayMute).setDetailPageMuted(zIsPlayMute).setAutoPlayPolicy(i4).build());
        if (i5 != -1) {
            this.a.setMaxVideoDuration(i5);
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        NativeExpressADView nativeExpressADView = this.b;
        if (nativeExpressADView != null) {
            nativeExpressADView.setMediaListener(null);
            this.b.destroy();
        }
        this.b = null;
        this.c = null;
        this.a = null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (!this.e.booleanValue() && this.b != null) {
            synchronized (this.e) {
                if (!this.e.booleanValue()) {
                    this.e = Boolean.TRUE;
                    try {
                        this.b.post(new b());
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return this.b;
    }

    @Override // com.anythink.nativead.unitgroup.a
    public Object getObject() {
        return this.a;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void registerDownloadConfirmListener() {
        NativeExpressADView nativeExpressADView = this.b;
        if (nativeExpressADView != null) {
            nativeExpressADView.setDownloadConfirmListener(new c());
        }
    }

    protected void a(com.anythink.network.gdt.a aVar, LoadAdParams loadAdParams) {
        this.c = aVar;
        if (!TextUtils.isEmpty(this.d)) {
            this.a.loadAD(1);
        } else if (loadAdParams != null) {
            this.a.loadAD(1, loadAdParams);
        } else {
            this.a.loadAD(1);
        }
    }
}
