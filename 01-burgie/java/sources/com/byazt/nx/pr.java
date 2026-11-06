package com.byazt.nx;

import android.util.Pair;
import android.util.SparseArray;
import com.byazt.ij.hn;
import com.byazt.qvl.c;
import com.byazt.qvl.uc;
import com.byazt.qvl.x;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import com.mar.sdk.MARCode;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1122, 37})
public abstract class pr {
    public abstract void aj(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void c(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void fw(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void hn(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void hw(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract Pair<Integer, String> pr(Exception exc);

    public abstract void pr(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void pr(ValueSet valueSet, Function<SparseArray<Object>, Object> function, int i);

    public abstract void uc(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void x(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void zo(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public TTAdNative pr() {
        return new C0147pr(this);
    }

    /* JADX INFO: renamed from: com.byazt.nx.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1122, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class C0147pr implements TTAdNative {
        public final pr pr;

        public C0147pr(pr prVar) {
            this.pr = prVar;
        }

        private ValueSet pr(AdSlot adSlot) {
            hn hnVarPr = hn.pr(com.byazt.bm.hw.pr(adSlot));
            hnVarPr.pr(8302, MediationAdClassLoader.getInstance());
            return hnVarPr.hw();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.pr.pr(pr(adSlot), new com.byazt.qvl.hw(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> pairPr = this.pr.pr(e);
                    feedAdListener.onError(((Integer) pairPr.first).intValue(), (String) pairPr.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.pr.hw(pr(adSlot), new com.byazt.qvl.hw(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> pairPr = this.pr.pr(e);
                    feedAdListener.onError(((Integer) pairPr.first).intValue(), (String) pairPr.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            try {
                this.pr.hn(pr(adSlot), new com.byazt.qvl.pr(drawFeedAdListener));
            } catch (Exception e) {
                if (drawFeedAdListener != null) {
                    Pair<Integer, String> pairPr = this.pr.pr(e);
                    drawFeedAdListener.onError(((Integer) pairPr.first).intValue(), (String) pairPr.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            try {
                this.pr.x(pr(adSlot), new x(nativeAdListener));
            } catch (Exception e) {
                if (nativeAdListener != null) {
                    Pair<Integer, String> pairPr = this.pr.pr(e);
                    nativeAdListener.onError(((Integer) pairPr.first).intValue(), (String) pairPr.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.CSJSplashAdListener cSJSplashAdListener, int i) {
            try {
                this.pr.pr(pr(adSlot), new hw(cSJSplashAdListener), i);
            } catch (Exception e) {
                if (cSJSplashAdListener != null) {
                    final Pair<Integer, String> pairPr = this.pr.pr(e);
                    cSJSplashAdListener.onSplashLoadFail(new CSJAdError() { // from class: com.byazt.nx.pr.pr.1
                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public int getCode() {
                            return ((Integer) pairPr.first).intValue();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public String getMsg() {
                            return (String) pairPr.second;
                        }
                    });
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            try {
                this.pr.c(pr(adSlot), new uc(rewardVideoAdListener));
            } catch (Exception e) {
                if (rewardVideoAdListener != null) {
                    Pair<Integer, String> pairPr = this.pr.pr(e);
                    rewardVideoAdListener.onError(((Integer) pairPr.first).intValue(), (String) pairPr.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            try {
                this.pr.uc(pr(adSlot), new com.byazt.qvl.hn(fullScreenVideoAdListener));
            } catch (Exception e) {
                if (fullScreenVideoAdListener != null) {
                    Pair<Integer, String> pairPr = this.pr.pr(e);
                    fullScreenVideoAdListener.onError(((Integer) pairPr.first).intValue(), (String) pairPr.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.pr.fw(pr(adSlot), new c(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairPr = this.pr.pr(e);
                    nativeExpressAdListener.onError(((Integer) pairPr.first).intValue(), (String) pairPr.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.pr.zo(pr(adSlot), new c(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairPr = this.pr.pr(e);
                    nativeExpressAdListener.onError(((Integer) pairPr.first).intValue(), (String) pairPr.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.pr.aj(pr(adSlot), new c(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairPr = this.pr.pr(e);
                    nativeExpressAdListener.onError(((Integer) pairPr.first).intValue(), (String) pairPr.second);
                }
            }
        }
    }
}
