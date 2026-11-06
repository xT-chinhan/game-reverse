package com.bytedance.sdk.openadsdk.ao.ms;

import android.util.Pair;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import com.bytedance.sdk.openadsdk.mediation.xr.ms.ah;
import com.bytedance.sdk.openadsdk.t.ms.ms.ms.c;
import com.bytedance.sdk.openadsdk.t.ms.ms.ms.d;
import com.bytedance.sdk.openadsdk.t.ms.ms.ms.ka;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms {
    public abstract void ab(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void ah(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void c(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void d(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void ka(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract Pair<Integer, String> ms(Exception exc);

    public abstract void ms(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void ms(ValueSet valueSet, Function<SparseArray<Object>, Object> function, int i);

    public abstract void ny(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void x(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void xr(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public TTAdNative ms() {
        return new C0261ms(this);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.ao.ms.ms$ms, reason: collision with other inner class name */
    public static class C0261ms implements TTAdNative {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final ms f1672ms;

        protected C0261ms(ms msVar) {
            this.f1672ms = msVar;
        }

        private ValueSet ms(AdSlot adSlot) {
            com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(com.bytedance.sdk.openadsdk.ao.ms.ah.xr.ms(adSlot));
            xrVarMs.ms(8302, MediationAdClassLoader.getInstance());
            return xrVarMs.xr();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.f1672ms.ms(ms(adSlot), new ah(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> pairMs = this.f1672ms.ms(e);
                    feedAdListener.onError(((Integer) pairMs.first).intValue(), (String) pairMs.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.f1672ms.xr(ms(adSlot), new ah(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> pairMs = this.f1672ms.ms(e);
                    feedAdListener.onError(((Integer) pairMs.first).intValue(), (String) pairMs.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            try {
                this.f1672ms.ah(ms(adSlot), new com.bytedance.sdk.openadsdk.mediation.xr.ms.xr(drawFeedAdListener));
            } catch (Exception e) {
                if (drawFeedAdListener != null) {
                    Pair<Integer, String> pairMs = this.f1672ms.ms(e);
                    drawFeedAdListener.onError(((Integer) pairMs.first).intValue(), (String) pairMs.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            try {
                this.f1672ms.d(ms(adSlot), new d(nativeAdListener));
            } catch (Exception e) {
                if (nativeAdListener != null) {
                    Pair<Integer, String> pairMs = this.f1672ms.ms(e);
                    nativeAdListener.onError(((Integer) pairMs.first).intValue(), (String) pairMs.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.CSJSplashAdListener cSJSplashAdListener, int i) {
            try {
                this.f1672ms.ms(ms(adSlot), new xr(cSJSplashAdListener), i);
            } catch (Exception e) {
                if (cSJSplashAdListener != null) {
                    final Pair<Integer, String> pairMs = this.f1672ms.ms(e);
                    cSJSplashAdListener.onSplashLoadFail(new CSJAdError() { // from class: com.bytedance.sdk.openadsdk.ao.ms.ms.ms.1
                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public int getCode() {
                            return ((Integer) pairMs.first).intValue();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public String getMsg() {
                            return (String) pairMs.second;
                        }
                    });
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            try {
                this.f1672ms.ka(ms(adSlot), new c(rewardVideoAdListener));
            } catch (Exception e) {
                if (rewardVideoAdListener != null) {
                    Pair<Integer, String> pairMs = this.f1672ms.ms(e);
                    rewardVideoAdListener.onError(((Integer) pairMs.first).intValue(), (String) pairMs.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            try {
                this.f1672ms.c(ms(adSlot), new com.bytedance.sdk.openadsdk.mediation.xr.ms.d(fullScreenVideoAdListener));
            } catch (Exception e) {
                if (fullScreenVideoAdListener != null) {
                    Pair<Integer, String> pairMs = this.f1672ms.ms(e);
                    fullScreenVideoAdListener.onError(((Integer) pairMs.first).intValue(), (String) pairMs.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f1672ms.ab(ms(adSlot), new ka(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairMs = this.f1672ms.ms(e);
                    nativeExpressAdListener.onError(((Integer) pairMs.first).intValue(), (String) pairMs.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f1672ms.x(ms(adSlot), new ka(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairMs = this.f1672ms.ms(e);
                    nativeExpressAdListener.onError(((Integer) pairMs.first).intValue(), (String) pairMs.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f1672ms.ny(ms(adSlot), new ka(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairMs = this.f1672ms.ms(e);
                    nativeExpressAdListener.onError(((Integer) pairMs.first).intValue(), (String) pairMs.second);
                }
            }
        }
    }
}
