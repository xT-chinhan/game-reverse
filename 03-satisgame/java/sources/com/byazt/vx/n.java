package com.byazt.vx;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import android.util.SparseArray;
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
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.function.IntSupplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1148, 19})
public abstract class n {
    public static Object s;
    public TTAdSdk.InitCallback n;
    public final AtomicBoolean qg = new AtomicBoolean(false);

    private interface qg<T> {
        void n(T t);
    }

    public void n(int i, Result result) {
    }

    public void n(Result result) {
    }

    public abstract boolean n(Context context, com.byazt.qvu.s sVar);

    public abstract com.byazt.ja.s q();

    public abstract void qg(Context context, com.byazt.qvu.s sVar);

    public abstract boolean qg();

    public boolean qg(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        return false;
    }

    public abstract s s();

    public boolean n() {
        return this.qg.get();
    }

    public void n(final Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        if (com.byazt.vx.l.n()) {
            if (initCallback != null) {
                initCallback.fail(4209, "init csj sdk fail, that only support android os >= android 7.0（API-24）");
                return;
            }
            return;
        }
        com.byazt.ja.q.n().n(q());
        if (qg(context, adConfig, initCallback)) {
            this.n = initCallback;
            this.qg.set(false);
            final com.byazt.qvu.s sVarN = com.byazt.qvu.s.n(com.byazt.jd.n.n(adConfig));
            n(adConfig, sVarN);
            sVarN.n(1, SystemClock.elapsedRealtime());
            sVarN.n(5, "main");
            sVarN.n(4, true);
            sVarN.n(6, 1000);
            sVarN.n(10, 7814);
            sVarN.n(11, "7.8.1.4");
            sVarN.n(12, "com.byted.pangle");
            sVarN.n(14, true);
            sVarN.n(26, com.byazt.eh.s.s());
            sVarN.n(16, com.byazt.ja.q.n());
            sVarN.n(17, com.byazt.fyy.n.n().qg());
            Thread threadCurrentThread = Thread.currentThread();
            sVarN.n(2, threadCurrentThread.getName());
            sVarN.n(3, threadCurrentThread.getPriority());
            sVarN.n(15, new q());
            sVarN.n(8301, new MediationInitCLassLoader());
            if (!n(context, sVarN)) {
                com.byazt.fyy.n.n().n(new Runnable() { // from class: com.byazt.vx.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.qg(context, sVarN);
                    }
                });
            }
            s().n(true);
        }
    }

    private void n(AdConfig adConfig, com.byazt.qvu.s sVar) {
        long j;
        Map<String, Object> initExtra;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (adConfig == null || (initExtra = adConfig.getInitExtra()) == null) {
            j = jElapsedRealtime;
        } else {
            Object obj = initExtra.get("csj_b_st_ts");
            long jLongValue = obj instanceof Long ? ((Long) obj).longValue() : jElapsedRealtime;
            Object obj2 = initExtra.get("csj_c_i_ts");
            if (obj2 instanceof Long) {
                jElapsedRealtime = ((Long) obj2).longValue();
            }
            long j2 = jElapsedRealtime;
            jElapsedRealtime = jLongValue;
            j = j2;
        }
        sVar.n(25, jElapsedRealtime);
        sVar.n(24, j);
    }

    public void n(Manager manager, boolean z) {
        w.qg("_tt_ad_sdk_", "update manager");
        s().n(manager, z);
        s().register(com.byazt.ja.q.n());
        if (s == null || !z) {
            return;
        }
        s().register(s);
        s = null;
    }

    public void qg(Result result) {
        n(result);
        if (!this.qg.compareAndSet(false, true)) {
            w.q("_tt_ad_sdk_", "finishInit callback already invoked, skip");
            return;
        }
        if (result.isSuccess()) {
            w.qg("_tt_ad_sdk_", "init sdk success ");
            TTAdSdk.InitCallback initCallback = this.n;
            if (initCallback != null) {
                initCallback.success();
            }
        } else {
            w.l("_tt_ad_sdk_", "int sdk failed, code: " + result.code() + ", message: " + result.message());
            TTAdSdk.InitCallback initCallback2 = this.n;
            if (initCallback2 != null) {
                initCallback2.fail(result.code(), result.message() != null ? result.message() : "");
            }
        }
        this.n = null;
    }

    @com.byazt.cp.n(n = {0, 1, 1148, 1125})
    private class q implements Function<SparseArray<Object>, Object> {
        private q() {
        }

        @Override // java.util.function.Function
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            SparseArray sparseArray2;
            if (sparseArray == null || (sparseArray2 = (SparseArray) com.byazt.qvu.s.n(sparseArray).qg().objectValue(-99999979, SparseArray.class)) == null) {
                return null;
            }
            ValueSet valueSetQg = com.byazt.qvu.s.n((SparseArray<Object>) sparseArray2).qg();
            Result resultQg = com.byazt.qvu.qg.n().n(valueSetQg.intValue(-999900)).n(valueSetQg.stringValue(-999901)).n(valueSetQg.booleanValue(-999903)).n(com.byazt.qvu.s.n((SparseArray<Object>) valueSetQg.objectValue(-999902, SparseArray.class)).qg()).qg();
            if (resultQg.isSuccess()) {
                n.this.n(1, resultQg);
            }
            n.this.qg(resultQg);
            return null;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1148, 829})
    public static abstract class s implements TTAdManager {
        public Map<qg<Manager>, Object> l = new WeakHashMap();
        public volatile Manager n;
        public volatile boolean q;
        public volatile Manager qg;
        public volatile boolean s;

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getSDKVersion() {
            return "7.8.1.4";
        }

        public Object n(Object obj) {
            return obj;
        }

        public void n(Throwable th) {
        }

        public void n(boolean z) {
            this.s = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(Manager manager, boolean z) {
            ArrayList arrayList;
            if (com.byazt.vx.l.n()) {
                return;
            }
            this.q = z;
            this.n = manager;
            if (!z) {
                this.qg = manager;
            }
            if (this.n == null || !z) {
                return;
            }
            synchronized (this.l) {
                arrayList = new ArrayList(this.l.keySet());
            }
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((qg) it.next()).n(manager);
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(qg<Manager> qgVar) {
            if (com.byazt.vx.l.n() || this.q) {
                return;
            }
            synchronized (this.l) {
                this.l.put(qgVar, null);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public TTAdNative createAdNative(Context context) {
            if (com.byazt.vx.l.n()) {
                return null;
            }
            return new l(new AnonymousClass1(new SoftReference(context))).n();
        }

        /* JADX INFO: renamed from: com.byazt.vx.n$s$1, reason: invalid class name */
        @com.byazt.cp.n(n = {0, 1, 1148, 1194})
        public class AnonymousClass1 extends AbstractC0378n<Loader> {
            public Loader n;
            public final qg<Manager> qg;
            public final /* synthetic */ SoftReference s;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SoftReference softReference) {
                super();
                this.s = softReference;
                this.qg = new qg<Manager>() { // from class: com.byazt.vx.n.s.1.1
                    @Override // com.byazt.vx.n.qg
                    public void n(Manager manager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.n = manager.createLoader((Context) anonymousClass1.s.get());
                    }
                };
            }

            @Override // com.byazt.vx.n.AbstractC0378n
            public void n(final qg<Loader> qgVar, int i) {
                Loader loader = this.n;
                if (loader == null) {
                    s.this.call(new qg<Manager>() { // from class: com.byazt.vx.n.s.1.2
                        @Override // com.byazt.vx.n.qg
                        public void n(Manager manager) {
                            s.this.n(AnonymousClass1.this.qg);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            anonymousClass1.n = manager.createLoader((Context) anonymousClass1.s.get());
                            qgVar.n(AnonymousClass1.this.n);
                        }
                    }, i + 10000);
                } else {
                    qgVar.n(loader);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void register(final Object obj) {
            if (com.byazt.vx.l.n()) {
                return;
            }
            call(new qg<Manager>() { // from class: com.byazt.vx.n.s.2
                @Override // com.byazt.vx.n.qg
                public void n(Manager manager) {
                    Function<SparseArray<Object>, Object> functionN;
                    Object objN = s.this.n(obj);
                    SparseArray<Object> sparseArray = com.byazt.qvu.s.n(2).n(8, objN).n(-99999987, 4).n(-99999985, Void.class).qg().sparseArray();
                    if ((manager instanceof com.byazt.vx.s) && (functionN = ((com.byazt.vx.s) manager).n(1)) != null) {
                        functionN.apply(sparseArray);
                    }
                    s.this.qg(objN);
                }
            }, 4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void qg(Object obj) {
            try {
                if ((obj instanceof IntSupplier) && ((IntSupplier) obj).getAsInt() == 4000001) {
                    Object unused = n.s = obj;
                }
            } catch (Throwable unused2) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void unregister(final Object obj) {
            if (com.byazt.vx.l.n()) {
                return;
            }
            call(new qg<Manager>() { // from class: com.byazt.vx.n.s.3
                @Override // com.byazt.vx.n.qg
                public void n(Manager manager) {
                    Function<SparseArray<Object>, Object> functionN;
                    Object qgVar = obj;
                    if (com.byazt.mp.qg.n(qgVar)) {
                        qgVar = new com.byazt.mp.qg(obj);
                    }
                    SparseArray<Object> sparseArray = com.byazt.qvu.s.n(2).n(8, qgVar).n(-99999987, 5).n(-99999985, Void.class).qg().sparseArray();
                    if (!(manager instanceof com.byazt.vx.s) || (functionN = ((com.byazt.vx.s) manager).n(1)) == null) {
                        return;
                    }
                    functionN.apply(sparseArray);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
            if (com.byazt.vx.l.n()) {
                return null;
            }
            if (this.n != null) {
                return (T) qg(n(bundle), cls, bundle);
            }
            call(new qg<Manager>() { // from class: com.byazt.vx.n.s.4
                @Override // com.byazt.vx.n.qg
                public void n(Manager manager) {
                    s.qg(s.this.n(bundle), cls, bundle);
                }
            }, 6);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Manager n(Bundle bundle) {
            if (((bundle == null || !bundle.containsKey("layerType")) ? 0 : bundle.getInt("layerType")) == 1 && this.qg != null) {
                return this.qg;
            }
            return this.n;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T qg(Manager manager, Class<T> cls, Bundle bundle) {
            Function<SparseArray<Object>, Object> functionN;
            if (com.byazt.vx.l.n()) {
                return null;
            }
            SparseArray<Object> sparseArray = com.byazt.qvu.s.n(3).n(9, cls).n(10, bundle).n(-99999987, 6).n(-99999985, cls).qg().sparseArray();
            if (!(manager instanceof com.byazt.vx.s) || (functionN = ((com.byazt.vx.s) manager).n(1)) == null) {
                return null;
            }
            return (T) functionN.apply(sparseArray);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void requestPermissionIfNecessary(final Context context) {
            if (com.byazt.vx.l.n()) {
                return;
            }
            call(new qg<Manager>() { // from class: com.byazt.vx.n.s.5
                @Override // com.byazt.vx.n.qg
                public void n(Manager manager) {
                    Function<SparseArray<Object>, Object> functionN;
                    SparseArray<Object> sparseArray = com.byazt.qvu.s.n(2).n(7, context).n(-99999987, 3).n(-99999985, Void.class).qg().sparseArray();
                    if (!(manager instanceof com.byazt.vx.s) || (functionN = ((com.byazt.vx.s) manager).n(1)) == null) {
                        return;
                    }
                    functionN.apply(sparseArray);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
            if (com.byazt.vx.l.n()) {
                return false;
            }
            HashMap map = new HashMap();
            map.put("activity", activity);
            map.put("exitInstallListener", new com.byazt.io.n(exitInstallListener));
            Object objApply = com.byazt.im.s.n(TTAppContextHolder.getContext()).apply(com.byazt.qvu.s.n(2).n(0, map).n(-99999987, 0).n(-99999985, Boolean.class).qg().sparseArray());
            if (objApply == null) {
                return false;
            }
            return ((Boolean) objApply).booleanValue();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getPluginVersion() {
            return this.n != null ? this.n.values().stringValue(12) : "";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot) {
            return getBiddingToken(adSlot, false, adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot, boolean z, int i) {
            Function<SparseArray<Object>, Object> functionN;
            if (com.byazt.vx.l.n()) {
                return null;
            }
            if (i <= 0) {
                i = adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType();
            }
            ValueSet valueSetQg = com.byazt.qvu.s.n(com.byazt.jd.qg.n(adSlot)).n(13, z).n(14, i).n(-99999987, 2).n(-99999985, String.class).qg();
            if ((this.n instanceof com.byazt.vx.s) && (functionN = ((com.byazt.vx.s) this.n).n(1)) != null) {
                Object objApply = functionN.apply(valueSetQg.sparseArray());
                if (objApply instanceof String) {
                    return (String) objApply;
                }
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public Bundle handleEvent(Bundle bundle) {
            Function<SparseArray<Object>, Object> functionN;
            ValueSet valueSetQg = com.byazt.qvu.s.n().n(20, bundle).n(-99999987, 19).n(-99999985, Bundle.class).qg();
            if ((this.n instanceof com.byazt.vx.s) && (functionN = ((com.byazt.vx.s) this.n).n(1)) != null) {
                Object objApply = functionN.apply(valueSetQg.sparseArray());
                if (objApply instanceof Bundle) {
                    return (Bundle) objApply;
                }
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void setThemeStatus(final int i) {
            if (com.byazt.vx.l.n()) {
                return;
            }
            call(new qg<Manager>() { // from class: com.byazt.vx.n.s.6
                @Override // com.byazt.vx.n.qg
                public void n(Manager manager) {
                    Function<SparseArray<Object>, Object> functionN;
                    ValueSet valueSetQg = com.byazt.qvu.s.n().n(11, i).n(-99999987, 1).n(-99999985, Void.class).qg();
                    if (!(manager instanceof com.byazt.vx.s) || (functionN = ((com.byazt.vx.s) manager).n(1)) == null) {
                        return;
                    }
                    functionN.apply(valueSetQg.sparseArray());
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public int getThemeStatus() {
            if (this.n != null) {
                return this.n.values().intValue(11);
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(final qg<Manager> qgVar, final int i) {
            if (com.byazt.vx.l.n()) {
                return;
            }
            if (this.n != null) {
                try {
                    qgVar.n(this.n);
                    return;
                } catch (Throwable th) {
                    w.q("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                    n(th);
                    return;
                }
            }
            if (!this.s && i > 10000) {
                throw new IllegalStateException("广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告");
            }
            com.byazt.fyy.n.n().n(new Runnable() { // from class: com.byazt.vx.n.s.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (s.this.n != null) {
                            qgVar.n(s.this.n);
                        } else {
                            w.q("_tt_ad_sdk_", "Not ready, no manager: " + i);
                        }
                    } catch (Throwable th2) {
                        w.q("_tt_ad_sdk_", "Unexpected manager call error: " + th2.getMessage());
                        s.this.n(th2);
                    }
                }
            });
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1148, 1705})
    private static class l extends com.byazt.thx.n {
        public AbstractC0378n<Loader> n;

        public l(AbstractC0378n<Loader> abstractC0378n) {
            this.n = abstractC0378n;
        }

        private void n(qg<Loader> qgVar, int i) {
            w.qg("_tt_ad_sdk_", "load ad slot type: ".concat(String.valueOf(i)));
            this.n.n(qgVar, i);
        }

        @Override // com.byazt.thx.n
        public void n(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            n(new qg<Loader>() { // from class: com.byazt.vx.n.l.1
                @Override // com.byazt.vx.n.qg
                public void n(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(5, com.byazt.csa.n.n(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).n(1, function).n());
                }
            }, 5);
        }

        @Override // com.byazt.thx.n
        public void qg(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            n(new qg<Loader>() { // from class: com.byazt.vx.n.l.4
                @Override // com.byazt.vx.n.qg
                public void n(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(5, com.byazt.csa.n.n(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).n(1, function).n());
                }
            }, 5);
        }

        @Override // com.byazt.thx.n
        public void s(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            n(new qg<Loader>() { // from class: com.byazt.vx.n.l.5
                @Override // com.byazt.vx.n.qg
                public void n(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(6, com.byazt.csa.n.n(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).n(1, function).n());
                }
            }, 6);
        }

        @Override // com.byazt.thx.n
        public void q(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            n(new qg<Loader>() { // from class: com.byazt.vx.n.l.6
                @Override // com.byazt.vx.n.qg
                public void n(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(9, com.byazt.csa.n.n(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).n(1, function).n());
                }
            }, 9);
        }

        @Override // com.byazt.thx.n
        public void l(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            n(new qg<Loader>() { // from class: com.byazt.vx.n.l.7
                @Override // com.byazt.vx.n.qg
                public void n(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(1, com.byazt.csa.n.n(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).n(1, function).n());
                }
            }, 1);
        }

        @Override // com.byazt.thx.n
        public void n(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function, final int i) {
            n(new qg<Loader>() { // from class: com.byazt.vx.n.l.8
                @Override // com.byazt.vx.n.qg
                public void n(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(3, com.byazt.csa.n.n(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).n(3, Integer.valueOf(i)).n(1, function).n());
                }
            }, 3);
        }

        @Override // com.byazt.thx.n
        public void w(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            n(new qg<Loader>() { // from class: com.byazt.vx.n.l.9
                @Override // com.byazt.vx.n.qg
                public void n(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(7, com.byazt.csa.n.n(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).n(1, function).n());
                }
            }, 7);
        }

        @Override // com.byazt.thx.n
        public void x(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            n(new qg<Loader>() { // from class: com.byazt.vx.n.l.10
                @Override // com.byazt.vx.n.qg
                public void n(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(8, com.byazt.csa.n.n(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).n(1, function).n());
                }
            }, 8);
        }

        @Override // com.byazt.thx.n
        public void fs(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            n(new qg<Loader>() { // from class: com.byazt.vx.n.l.11
                @Override // com.byazt.vx.n.qg
                public void n(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(5, com.byazt.csa.n.n(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).n(2, Boolean.TRUE).n(1, function).n());
                }
            }, 5);
        }

        @Override // com.byazt.thx.n
        public void rv(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            n(new qg<Loader>() { // from class: com.byazt.vx.n.l.2
                @Override // com.byazt.vx.n.qg
                public void n(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(9, com.byazt.csa.n.n(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).n(2, Boolean.TRUE).n(1, function).n());
                }
            }, 9);
        }

        @Override // com.byazt.thx.n
        public void tj(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            n(new qg<Loader>() { // from class: com.byazt.vx.n.l.3
                @Override // com.byazt.vx.n.qg
                public void n(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(1, com.byazt.csa.n.n(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).n(2, Boolean.TRUE).n(1, function).n());
                }
            }, 1);
        }

        @Override // com.byazt.thx.n
        public Pair<Integer, String> n(Exception exc) {
            w.q("_tt_ad_sdk_", "Load ad failed: " + exc.getMessage());
            if ((exc instanceof IllegalStateException) && "广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告".equals(exc.getMessage())) {
                return new Pair<>(4208, exc.getMessage());
            }
            return new Pair<>(Integer.valueOf(TTAdConstant.INIT_FAILED_CREATE_INVOKE_FAILED), "Load ad failed: " + exc.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.byazt.vx.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1148, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static abstract class AbstractC0378n<T> {
        public abstract void n(qg<T> qgVar, int i);

        private AbstractC0378n() {
        }
    }
}
