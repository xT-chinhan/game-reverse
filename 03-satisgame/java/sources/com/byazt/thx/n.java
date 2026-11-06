package com.byazt.thx;

import android.util.Pair;
import android.util.SparseArray;
import com.byazt.qvu.s;
import com.byazt.yhl.l;
import com.byazt.yhl.q;
import com.byazt.yhl.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1380, 19})
public abstract class n {
    public abstract void fs(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void l(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract Pair<Integer, String> n(Exception exc);

    public abstract void n(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void n(ValueSet valueSet, Function<SparseArray<Object>, Object> function, int i);

    public abstract void q(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void qg(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void rv(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void s(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void tj(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void w(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void x(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public TTAdNative n() {
        return new C0351n(this);
    }

    /* JADX INFO: renamed from: com.byazt.thx.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1380, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0351n implements TTAdNative {
        public final n n;

        public C0351n(n nVar) {
            this.n = nVar;
        }

        private ValueSet n(AdSlot adSlot) {
            s sVarN = s.n(com.byazt.jd.qg.n(adSlot));
            sVarN.n(8302, MediationAdClassLoader.getInstance());
            return sVarN.qg();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.n.n(n(adSlot), new com.byazt.yhl.qg(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> pairN = this.n.n(e);
                    feedAdListener.onError(((Integer) pairN.first).intValue(), (String) pairN.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadIncentiveAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.n.qg(n(adSlot), new com.byazt.yhl.qg(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> pairN = this.n.n(e);
                    feedAdListener.onError(((Integer) pairN.first).intValue(), (String) pairN.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.n.s(n(adSlot), new com.byazt.yhl.qg(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> pairN = this.n.n(e);
                    feedAdListener.onError(((Integer) pairN.first).intValue(), (String) pairN.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            try {
                this.n.q(n(adSlot), new com.byazt.yhl.n(drawFeedAdListener));
            } catch (Exception e) {
                if (drawFeedAdListener != null) {
                    Pair<Integer, String> pairN = this.n.n(e);
                    drawFeedAdListener.onError(((Integer) pairN.first).intValue(), (String) pairN.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            try {
                this.n.l(n(adSlot), new q(nativeAdListener));
            } catch (Exception e) {
                if (nativeAdListener != null) {
                    Pair<Integer, String> pairN = this.n.n(e);
                    nativeAdListener.onError(((Integer) pairN.first).intValue(), (String) pairN.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.CSJSplashAdListener cSJSplashAdListener, int i) {
            try {
                this.n.n(n(adSlot), new qg(cSJSplashAdListener), i);
            } catch (Exception e) {
                if (cSJSplashAdListener != null) {
                    final Pair<Integer, String> pairN = this.n.n(e);
                    cSJSplashAdListener.onSplashLoadFail(new CSJAdError() { // from class: com.byazt.thx.n.n.1
                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public int getCode() {
                            return ((Integer) pairN.first).intValue();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public String getMsg() {
                            return (String) pairN.second;
                        }
                    });
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            try {
                this.n.w(n(adSlot), new w(rewardVideoAdListener));
            } catch (Exception e) {
                if (rewardVideoAdListener != null) {
                    Pair<Integer, String> pairN = this.n.n(e);
                    rewardVideoAdListener.onError(((Integer) pairN.first).intValue(), (String) pairN.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            try {
                this.n.x(n(adSlot), new com.byazt.yhl.s(fullScreenVideoAdListener));
            } catch (Exception e) {
                if (fullScreenVideoAdListener != null) {
                    Pair<Integer, String> pairN = this.n.n(e);
                    fullScreenVideoAdListener.onError(((Integer) pairN.first).intValue(), (String) pairN.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.n.fs(n(adSlot), new l(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairN = this.n.n(e);
                    nativeExpressAdListener.onError(((Integer) pairN.first).intValue(), (String) pairN.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.n.rv(n(adSlot), new l(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairN = this.n.n(e);
                    nativeExpressAdListener.onError(((Integer) pairN.first).intValue(), (String) pairN.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.n.tj(n(adSlot), new l(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> pairN = this.n.n(e);
                    nativeExpressAdListener.onError(((Integer) pairN.first).intValue(), (String) pairN.second);
                }
            }
        }
    }
}
