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

/* JADX INFO: loaded from: classes.dex */
public class GDTATNativeExpressAd extends CustomNativeAd {
    NativeExpressAD a;
    NativeExpressADView b;
    a c;
    String d;
    private Boolean e = Boolean.FALSE;

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public boolean isNativeExpress() {
        return true;
    }

    protected GDTATNativeExpressAd(Context context, String str, int i, int i2, int i3, int i4, int i5, String str2) {
        int iA;
        int iA2;
        this.d = str2;
        NativeExpressAD.NativeExpressADListener nativeExpressADListener = new NativeExpressAD.NativeExpressADListener() { // from class: com.anythink.network.gdt.GDTATNativeExpressAd.1
            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public final void onNoAD(AdError adError) {
                if (GDTATNativeExpressAd.this.c != null) {
                    GDTATNativeExpressAd.this.c.notifyError(new StringBuilder().append(adError.getErrorCode()).toString(), adError.getErrorMsg());
                }
                GDTATNativeExpressAd.this.c = null;
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onADLoaded(List<NativeExpressADView> list) {
                try {
                    if (list.size() > 0) {
                        NativeExpressADView nativeExpressADView = list.get(0);
                        GDTATNativeExpressAd.this.setNetworkInfoMap(nativeExpressADView.getExtraInfo());
                        GDTATNativeExpressAd.this.b = nativeExpressADView;
                        AdData boundData = GDTATNativeExpressAd.this.b.getBoundData();
                        if (boundData != null) {
                            if (boundData.getAdPatternType() == 2) {
                                GDTATNativeExpressAd.this.mAdSourceType = "1";
                            } else {
                                GDTATNativeExpressAd.this.mAdSourceType = "2";
                            }
                        }
                        GDTATNativeExpressAd.this.setVideoDuration(boundData != null ? boundData.getVideoDuration() / 1000 : 0.0d);
                        GDTATNativeExpressAd.this.b.setMediaListener(new NativeExpressMediaListener() { // from class: com.anythink.network.gdt.GDTATNativeExpressAd.1.1
                            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                            public final void onVideoCached(NativeExpressADView nativeExpressADView2) {
                            }

                            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                            public final void onVideoInit(NativeExpressADView nativeExpressADView2) {
                            }

                            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                            public final void onVideoLoading(NativeExpressADView nativeExpressADView2) {
                            }

                            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                            public final void onVideoPageClose(NativeExpressADView nativeExpressADView2) {
                            }

                            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                            public final void onVideoPageOpen(NativeExpressADView nativeExpressADView2) {
                            }

                            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                            public final void onVideoPause(NativeExpressADView nativeExpressADView2) {
                            }

                            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                            public final void onVideoReady(NativeExpressADView nativeExpressADView2, long j) {
                            }

                            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                            public final void onVideoStart(NativeExpressADView nativeExpressADView2) {
                                GDTATNativeExpressAd.this.notifyAdVideoStart();
                            }

                            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                            public final void onVideoComplete(NativeExpressADView nativeExpressADView2) {
                                GDTATNativeExpressAd.this.notifyAdVideoEnd();
                            }

                            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                            public final void onVideoError(NativeExpressADView nativeExpressADView2, AdError adError) {
                                GDTATNativeExpressAd.this.notifyAdVideoVideoPlayFail(new StringBuilder().append(adError.getErrorCode()).toString(), adError.getErrorMsg());
                            }
                        });
                        if (GDTATNativeExpressAd.this.c != null) {
                            GDTATNativeExpressAd.this.c.notifyLoaded(GDTATNativeExpressAd.this);
                        }
                        GDTATNativeExpressAd.this.c = null;
                        return;
                    }
                    if (GDTATNativeExpressAd.this.c != null) {
                        GDTATNativeExpressAd.this.c.notifyError("", "GDT Ad request success but no Ad return.");
                    }
                    GDTATNativeExpressAd.this.c = null;
                } catch (Throwable th) {
                    if (GDTATNativeExpressAd.this.c != null) {
                        GDTATNativeExpressAd.this.c.notifyError("", "GDT Ad request fail:" + th.getMessage());
                    }
                    GDTATNativeExpressAd.this.c = null;
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onRenderFail(NativeExpressADView nativeExpressADView) {
                if (GDTATNativeExpressAd.this.c != null) {
                    GDTATNativeExpressAd.this.c.notifyError("", "GDT onRenderFail");
                }
                GDTATNativeExpressAd.this.c = null;
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onADExposure(NativeExpressADView nativeExpressADView) {
                GDTATInitManager.getInstance().a(GDTATNativeExpressAd.this.getShowId(), new WeakReference(GDTATNativeExpressAd.this.b));
                GDTATNativeExpressAd.this.notifyAdImpression();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onADClicked(NativeExpressADView nativeExpressADView) {
                GDTATNativeExpressAd.this.notifyAdClicked();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public final void onADClosed(NativeExpressADView nativeExpressADView) {
                GDTATNativeExpressAd.this.notifyAdDislikeClick();
            }
        };
        if (i > 0) {
            GDTATInitManager.getInstance();
            iA = GDTATInitManager.a(context, i);
        } else {
            iA = -1;
        }
        if (i2 > 0) {
            GDTATInitManager.getInstance();
            iA2 = GDTATInitManager.a(context, i2);
        } else {
            iA2 = -2;
        }
        if (TextUtils.isEmpty(str2)) {
            this.a = new NativeExpressAD(context, new ADSize(iA, iA2), str, nativeExpressADListener);
        } else {
            this.a = new NativeExpressAD(context, new ADSize(iA, iA2), str, nativeExpressADListener, str2);
        }
        this.a.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(i3 == 1).setDetailPageMuted(i3 == 1).setAutoPlayPolicy(i4).build());
        if (i5 != -1) {
            this.a.setMaxVideoDuration(i5);
        }
    }

    protected final void a(a aVar, LoadAdParams loadAdParams) {
        this.c = aVar;
        if (!TextUtils.isEmpty(this.d)) {
            this.a.loadAD(1);
        } else if (loadAdParams != null) {
            this.a.loadAD(1, loadAdParams);
        } else {
            this.a.loadAD(1);
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (!this.e.booleanValue() && this.b != null) {
            synchronized (this.e) {
                if (!this.e.booleanValue()) {
                    this.e = Boolean.TRUE;
                    try {
                        this.b.post(new Runnable() { // from class: com.anythink.network.gdt.GDTATNativeExpressAd.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    if (GDTATNativeExpressAd.this.b != null) {
                                        GDTATNativeExpressAd.this.b.render();
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        });
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return this.b;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void registerDownloadConfirmListener() {
        NativeExpressADView nativeExpressADView = this.b;
        if (nativeExpressADView != null) {
            nativeExpressADView.setDownloadConfirmListener(new DownloadConfirmListener() { // from class: com.anythink.network.gdt.GDTATNativeExpressAd.3
                @Override // com.qq.e.comm.compliance.DownloadConfirmListener
                public final void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
                    GDTDownloadFirmInfo gDTDownloadFirmInfo = new GDTDownloadFirmInfo();
                    gDTDownloadFirmInfo.appInfoUrl = str;
                    gDTDownloadFirmInfo.scenes = i;
                    gDTDownloadFirmInfo.confirmCallBack = downloadConfirmCallBack;
                    GDTATNativeExpressAd.this.notifyDownloadConfirm(activity, null, gDTDownloadFirmInfo);
                }
            });
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
}
