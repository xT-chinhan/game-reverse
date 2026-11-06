package com.byazt.dea;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import android.util.SparseArray;
import com.byazt.ol.TTDownloadField;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ExitInstallListener;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitCLassLoader;
import com.mar.sdk.MARCode;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 84, 37})
public abstract class pr {
    public final AtomicBoolean hw = new AtomicBoolean(false);
    public TTAdSdk.InitCallback pr;

    private interface hw<T> {
        void pr(T t);
    }

    public abstract hn hn();

    public abstract void hw(Context context, com.byazt.ij.hn hnVar);

    public abstract boolean hw();

    public abstract boolean pr(Context context, com.byazt.ij.hn hnVar);

    public abstract com.byazt.bw.hn x();

    public boolean pr() {
        return this.hw.get();
    }

    public void pr(final Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        if (com.byazt.dea.c.pr()) {
            if (initCallback != null) {
                initCallback.fail(4209, "init csj sdk fail, that only support android os >= android 7.0（API-24）");
                return;
            }
            return;
        }
        com.byazt.bw.x.pr().pr(x());
        if (!hw(context, adConfig, initCallback)) {
            return;
        }
        this.pr = initCallback;
        this.hw.set(false);
        final com.byazt.ij.hn hnVarPr = com.byazt.ij.hn.pr(com.byazt.bm.pr.pr(adConfig));
        pr(adConfig, hnVarPr);
        hnVarPr.pr(1, SystemClock.elapsedRealtime());
        hnVarPr.pr(5, "main");
        hnVarPr.pr(4, true);
        hnVarPr.pr(6, 1000);
        hnVarPr.pr(10, 7714);
        hnVarPr.pr(11, "7.7.1.4");
        hnVarPr.pr(12, "com.byted.pangle");
        hnVarPr.pr(14, true);
        hnVarPr.pr(26, com.byazt.ud.hn.hn());
        hnVarPr.pr(16, com.byazt.bw.x.pr());
        hnVarPr.pr(17, com.byazt.as.pr.pr().hw());
        Thread threadCurrentThread = Thread.currentThread();
        hnVarPr.pr(2, threadCurrentThread.getName());
        hnVarPr.pr(3, threadCurrentThread.getPriority());
        hnVarPr.pr(15, new x());
        hnVarPr.pr(8301, new MediationInitCLassLoader());
        if (!pr(context, hnVarPr)) {
            com.byazt.as.pr.pr().pr(new Runnable() { // from class: com.byazt.dea.pr.1
                @Override // java.lang.Runnable
                public void run() {
                    pr.this.hw(context, hnVarPr);
                }
            });
        }
        hn().pr(true);
    }

    private void pr(AdConfig adConfig, com.byazt.ij.hn hnVar) {
        long j;
        Map<String, Object> initExtra;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (adConfig != null && (initExtra = adConfig.getInitExtra()) != null) {
            Object obj = initExtra.get("csj_b_st_ts");
            long jLongValue = obj instanceof Long ? ((Long) obj).longValue() : jElapsedRealtime;
            Object obj2 = initExtra.get("csj_c_i_ts");
            if (obj2 instanceof Long) {
                jElapsedRealtime = ((Long) obj2).longValue();
            }
            long j2 = jElapsedRealtime;
            jElapsedRealtime = jLongValue;
            j = j2;
        } else {
            j = jElapsedRealtime;
        }
        hnVar.pr(25, jElapsedRealtime);
        hnVar.pr(24, j);
    }

    public void pr(Manager manager, boolean z) {
        uc.hw("_tt_ad_sdk_", "update manager");
        hn().pr(manager, z);
        hn().register(com.byazt.bw.x.pr());
    }

    public boolean hw(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        return false;
    }

    public void pr(Result result) {
    }

    public void hw(Result result) {
        pr(result);
        if (!this.hw.compareAndSet(false, true)) {
            uc.x("_tt_ad_sdk_", "finishInit callback already invoked, skip");
            return;
        }
        if (result.isSuccess()) {
            uc.hw("_tt_ad_sdk_", "init sdk success ");
            TTAdSdk.InitCallback initCallback = this.pr;
            if (initCallback != null) {
                initCallback.success();
            }
        } else {
            uc.c("_tt_ad_sdk_", "int sdk failed, code: " + result.code() + ", message: " + result.message());
            TTAdSdk.InitCallback initCallback2 = this.pr;
            if (initCallback2 != null) {
                initCallback2.fail(result.code(), result.message() != null ? result.message() : "");
            }
        }
        this.pr = null;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 84, 100})
    private class x implements Function<SparseArray<Object>, Object> {
        private x() {
        }

        @Override // java.util.function.Function
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            SparseArray sparseArray2;
            if (sparseArray != null && (sparseArray2 = (SparseArray) com.byazt.ij.hn.pr(sparseArray).hw().objectValue(-99999979, SparseArray.class)) != null) {
                ValueSet valueSetHw = com.byazt.ij.hn.pr((SparseArray<Object>) sparseArray2).hw();
                Result resultHw = com.byazt.ij.hw.pr().pr(valueSetHw.intValue(-999900)).pr(valueSetHw.stringValue(-999901)).pr(valueSetHw.booleanValue(-999903)).pr(com.byazt.ij.hn.pr((SparseArray<Object>) valueSetHw.objectValue(-999902, SparseArray.class)).hw()).hw();
                if (resultHw.isSuccess()) {
                    pr.this.pr(1, resultHw);
                }
                pr.this.hw(resultHw);
                return null;
            }
            return null;
        }
    }

    public void pr(int i, Result result) {
    }

    @com.byazt.vzx.pr(pr = {0, 1, 84, MediaPlayer.MEDIA_PLAYER_OPTION_ADVANCE_CHECK_BUFFERING_END})
    public static abstract class hn implements TTAdManager {
        public Map<hw<Manager>, Object> c = new WeakHashMap();
        public volatile boolean hn;
        public volatile Manager hw;
        public volatile Manager pr;
        public volatile boolean x;

        public void pr(boolean z) {
            this.hn = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pr(Manager manager, boolean z) {
            if (com.byazt.dea.c.pr()) {
                return;
            }
            this.x = z;
            this.pr = manager;
            if (!z) {
                this.hw = manager;
            }
            if (this.pr != null && z) {
                try {
                    Iterator<hw<Manager>> it = this.c.keySet().iterator();
                    while (it.hasNext()) {
                        it.next().pr(this.pr);
                    }
                } catch (Exception e) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pr(hw<Manager> hwVar) {
            if (com.byazt.dea.c.pr() || this.x) {
                return;
            }
            this.c.put(hwVar, null);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public TTAdNative createAdNative(Context context) {
            if (com.byazt.dea.c.pr()) {
                return null;
            }
            return new c(new AnonymousClass1(new SoftReference(context))).pr();
        }

        /* JADX INFO: renamed from: com.byazt.dea.pr$hn$1, reason: invalid class name */
        @com.byazt.vzx.pr(pr = {0, 1, 84, 2247})
        public class AnonymousClass1 extends AbstractC0040pr<Loader> {
            public final /* synthetic */ SoftReference hn;
            public final hw<Manager> hw;
            public Loader pr;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SoftReference softReference) {
                super();
                this.hn = softReference;
                this.hw = new hw<Manager>() { // from class: com.byazt.dea.pr.hn.1.1
                    @Override // com.byazt.dea.pr.hw
                    public void pr(Manager manager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.pr = manager.createLoader((Context) anonymousClass1.hn.get());
                    }
                };
            }

            @Override // com.byazt.dea.pr.AbstractC0040pr
            public void pr(final hw<Loader> hwVar, int i) {
                Loader loader = this.pr;
                if (loader == null) {
                    hn.this.call(new hw<Manager>() { // from class: com.byazt.dea.pr.hn.1.2
                        @Override // com.byazt.dea.pr.hw
                        public void pr(Manager manager) {
                            hn.this.pr(AnonymousClass1.this.hw);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            anonymousClass1.pr = manager.createLoader((Context) anonymousClass1.hn.get());
                            hwVar.pr(AnonymousClass1.this.pr);
                        }
                    }, i + 10000);
                } else {
                    hwVar.pr(loader);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void register(final Object obj) {
            if (com.byazt.dea.c.pr()) {
                return;
            }
            call(new hw<Manager>() { // from class: com.byazt.dea.pr.hn.2
                @Override // com.byazt.dea.pr.hw
                public void pr(Manager manager) {
                    Function<SparseArray<Object>, Object> functionPr;
                    SparseArray<Object> sparseArray = com.byazt.ij.hn.pr(2).pr(8, hn.this.pr(obj)).pr(-99999987, 4).pr(-99999985, Void.class).hw().sparseArray();
                    if ((manager instanceof com.byazt.dea.hn) && (functionPr = ((com.byazt.dea.hn) manager).pr(1)) != null) {
                        functionPr.apply(sparseArray);
                    }
                }
            }, 4);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void unregister(final Object obj) {
            if (com.byazt.dea.c.pr()) {
                return;
            }
            call(new hw<Manager>() { // from class: com.byazt.dea.pr.hn.3
                @Override // com.byazt.dea.pr.hw
                public void pr(Manager manager) {
                    Function<SparseArray<Object>, Object> functionPr;
                    Object hwVar = obj;
                    if (com.byazt.ul.hw.pr(hwVar)) {
                        hwVar = new com.byazt.ul.hw(obj);
                    }
                    SparseArray<Object> sparseArray = com.byazt.ij.hn.pr(2).pr(8, hwVar).pr(-99999987, 5).pr(-99999985, Void.class).hw().sparseArray();
                    if ((manager instanceof com.byazt.dea.hn) && (functionPr = ((com.byazt.dea.hn) manager).pr(1)) != null) {
                        functionPr.apply(sparseArray);
                    }
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
            if (com.byazt.dea.c.pr()) {
                return null;
            }
            if (this.pr != null) {
                return (T) hw(pr(bundle), cls, bundle);
            }
            call(new hw<Manager>() { // from class: com.byazt.dea.pr.hn.4
                @Override // com.byazt.dea.pr.hw
                public void pr(Manager manager) {
                    hn.hw(hn.this.pr(bundle), cls, bundle);
                }
            }, 6);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Manager pr(Bundle bundle) {
            int i;
            if (bundle != null && bundle.containsKey("layerType")) {
                i = bundle.getInt("layerType");
            } else {
                i = 0;
            }
            if (i == 1 && this.hw != null) {
                return this.hw;
            }
            return this.pr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T hw(Manager manager, Class<T> cls, Bundle bundle) {
            Function<SparseArray<Object>, Object> functionPr;
            if (com.byazt.dea.c.pr()) {
                return null;
            }
            SparseArray<Object> sparseArray = com.byazt.ij.hn.pr(3).pr(9, cls).pr(10, bundle).pr(-99999987, 6).pr(-99999985, cls).hw().sparseArray();
            if (!(manager instanceof com.byazt.dea.hn) || (functionPr = ((com.byazt.dea.hn) manager).pr(1)) == null) {
                return null;
            }
            return (T) functionPr.apply(sparseArray);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void requestPermissionIfNecessary(final Context context) {
            if (com.byazt.dea.c.pr()) {
                return;
            }
            call(new hw<Manager>() { // from class: com.byazt.dea.pr.hn.5
                @Override // com.byazt.dea.pr.hw
                public void pr(Manager manager) {
                    Function<SparseArray<Object>, Object> functionPr;
                    SparseArray<Object> sparseArray = com.byazt.ij.hn.pr(2).pr(7, context).pr(-99999987, 3).pr(-99999985, Void.class).hw().sparseArray();
                    if ((manager instanceof com.byazt.dea.hn) && (functionPr = ((com.byazt.dea.hn) manager).pr(1)) != null) {
                        functionPr.apply(sparseArray);
                    }
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
            if (com.byazt.dea.c.pr()) {
                return false;
            }
            HashMap map = new HashMap();
            map.put(TTDownloadField.TT_ACTIVITY, activity);
            map.put(TTDownloadField.TT_EXIT_INSTALL_LISTENER, new com.byazt.ve.pr(exitInstallListener));
            Object objApply = com.byazt.me.hn.pr(TTAppContextHolder.getContext()).apply(com.byazt.ij.hn.pr(2).pr(0, map).pr(-99999987, 0).pr(-99999985, Boolean.class).hw().sparseArray());
            if (objApply == null) {
                return false;
            }
            return ((Boolean) objApply).booleanValue();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getSDKVersion() {
            return "7.7.1.4";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getPluginVersion() {
            return this.pr != null ? this.pr.values().stringValue(12) : "";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot) {
            return getBiddingToken(adSlot, false, adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot, boolean z, int i) {
            Function<SparseArray<Object>, Object> functionPr;
            if (com.byazt.dea.c.pr()) {
                return null;
            }
            if (i <= 0) {
                i = adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType();
            }
            ValueSet valueSetHw = com.byazt.ij.hn.pr(com.byazt.bm.hw.pr(adSlot)).pr(13, z).pr(14, i).pr(-99999987, 2).pr(-99999985, String.class).hw();
            if (!(this.pr instanceof com.byazt.dea.hn) || (functionPr = ((com.byazt.dea.hn) this.pr).pr(1)) == null) {
                return null;
            }
            Object objApply = functionPr.apply(valueSetHw.sparseArray());
            if (objApply instanceof String) {
                return (String) objApply;
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public Bundle handleEvent(Bundle bundle) {
            Function<SparseArray<Object>, Object> functionPr;
            ValueSet valueSetHw = com.byazt.ij.hn.pr().pr(20, bundle).pr(-99999987, 19).pr(-99999985, Bundle.class).hw();
            if (!(this.pr instanceof com.byazt.dea.hn) || (functionPr = ((com.byazt.dea.hn) this.pr).pr(1)) == null) {
                return null;
            }
            Object objApply = functionPr.apply(valueSetHw.sparseArray());
            if (objApply instanceof Bundle) {
                return (Bundle) objApply;
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void setThemeStatus(final int i) {
            if (com.byazt.dea.c.pr()) {
                return;
            }
            call(new hw<Manager>() { // from class: com.byazt.dea.pr.hn.6
                @Override // com.byazt.dea.pr.hw
                public void pr(Manager manager) {
                    Function<SparseArray<Object>, Object> functionPr;
                    ValueSet valueSetHw = com.byazt.ij.hn.pr().pr(11, i).pr(-99999987, 1).pr(-99999985, Void.class).hw();
                    if ((manager instanceof com.byazt.dea.hn) && (functionPr = ((com.byazt.dea.hn) manager).pr(1)) != null) {
                        functionPr.apply(valueSetHw.sparseArray());
                    }
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public int getThemeStatus() {
            if (this.pr != null) {
                return this.pr.values().intValue(11);
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(final hw<Manager> hwVar, final int i) {
            if (com.byazt.dea.c.pr()) {
                return;
            }
            if (this.pr != null) {
                try {
                    hwVar.pr(this.pr);
                    return;
                } catch (Throwable th) {
                    uc.x("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                    pr(th);
                    return;
                }
            }
            if (!this.hn && i > 10000) {
                throw new IllegalStateException("广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告");
            }
            com.byazt.as.pr.pr().pr(new Runnable() { // from class: com.byazt.dea.pr.hn.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (hn.this.pr != null) {
                            hwVar.pr(hn.this.pr);
                        } else {
                            uc.x("_tt_ad_sdk_", "Not ready, no manager: " + i);
                        }
                    } catch (Throwable th2) {
                        uc.x("_tt_ad_sdk_", "Unexpected manager call error: " + th2.getMessage());
                        hn.this.pr(th2);
                    }
                }
            });
        }

        public void pr(Throwable th) {
        }

        public Object pr(Object obj) {
            return obj;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 84, 103})
    private static class c extends com.byazt.nx.pr {
        public AbstractC0040pr<Loader> pr;

        public c(AbstractC0040pr<Loader> abstractC0040pr) {
            this.pr = abstractC0040pr;
        }

        private void pr(hw<Loader> hwVar, int i) {
            uc.hw("_tt_ad_sdk_", "load ad slot type: ".concat(String.valueOf(i)));
            this.pr.pr(hwVar, i);
        }

        @Override // com.byazt.nx.pr
        public void pr(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            pr(new hw<Loader>() { // from class: com.byazt.dea.pr.c.1
                @Override // com.byazt.dea.pr.hw
                public void pr(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(5, com.byazt.h.pr.pr(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).pr(1, function).pr());
                }
            }, 5);
        }

        @Override // com.byazt.nx.pr
        public void hw(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            pr(new hw<Loader>() { // from class: com.byazt.dea.pr.c.3
                @Override // com.byazt.dea.pr.hw
                public void pr(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(6, com.byazt.h.pr.pr(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).pr(1, function).pr());
                }
            }, 6);
        }

        @Override // com.byazt.nx.pr
        public void hn(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            pr(new hw<Loader>() { // from class: com.byazt.dea.pr.c.4
                @Override // com.byazt.dea.pr.hw
                public void pr(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(9, com.byazt.h.pr.pr(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).pr(1, function).pr());
                }
            }, 9);
        }

        @Override // com.byazt.nx.pr
        public void x(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            pr(new hw<Loader>() { // from class: com.byazt.dea.pr.c.5
                @Override // com.byazt.dea.pr.hw
                public void pr(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(1, com.byazt.h.pr.pr(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).pr(1, function).pr());
                }
            }, 1);
        }

        @Override // com.byazt.nx.pr
        public void pr(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function, final int i) {
            pr(new hw<Loader>() { // from class: com.byazt.dea.pr.c.6
                @Override // com.byazt.dea.pr.hw
                public void pr(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(3, com.byazt.h.pr.pr(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).pr(3, Integer.valueOf(i)).pr(1, function).pr());
                }
            }, 3);
        }

        @Override // com.byazt.nx.pr
        public void c(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            pr(new hw<Loader>() { // from class: com.byazt.dea.pr.c.7
                @Override // com.byazt.dea.pr.hw
                public void pr(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(7, com.byazt.h.pr.pr(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).pr(1, function).pr());
                }
            }, 7);
        }

        @Override // com.byazt.nx.pr
        public void uc(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            pr(new hw<Loader>() { // from class: com.byazt.dea.pr.c.8
                @Override // com.byazt.dea.pr.hw
                public void pr(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(8, com.byazt.h.pr.pr(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).pr(1, function).pr());
                }
            }, 8);
        }

        @Override // com.byazt.nx.pr
        public void fw(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            pr(new hw<Loader>() { // from class: com.byazt.dea.pr.c.9
                @Override // com.byazt.dea.pr.hw
                public void pr(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(5, com.byazt.h.pr.pr(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).pr(2, Boolean.TRUE).pr(1, function).pr());
                }
            }, 5);
        }

        @Override // com.byazt.nx.pr
        public void zo(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            pr(new hw<Loader>() { // from class: com.byazt.dea.pr.c.10
                @Override // com.byazt.dea.pr.hw
                public void pr(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(9, com.byazt.h.pr.pr(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).pr(2, Boolean.TRUE).pr(1, function).pr());
                }
            }, 9);
        }

        @Override // com.byazt.nx.pr
        public void aj(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            pr(new hw<Loader>() { // from class: com.byazt.dea.pr.c.2
                @Override // com.byazt.dea.pr.hw
                public void pr(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(1, com.byazt.h.pr.pr(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).pr(2, Boolean.TRUE).pr(1, function).pr());
                }
            }, 1);
        }

        @Override // com.byazt.nx.pr
        public Pair<Integer, String> pr(Exception exc) {
            uc.x("_tt_ad_sdk_", "Load ad failed: " + exc.getMessage());
            if ((exc instanceof IllegalStateException) && "广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告".equals(exc.getMessage())) {
                return new Pair<>(4208, exc.getMessage());
            }
            return new Pair<>(Integer.valueOf(TTAdConstant.INIT_FAILED_CREATE_INVOKE_FAILED), "Load ad failed: " + exc.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.byazt.dea.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 84, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static abstract class AbstractC0040pr<T> {
        public abstract void pr(hw<T> hwVar, int i);

        private AbstractC0040pr() {
        }
    }
}
