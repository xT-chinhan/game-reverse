package com.bytedance.sdk.openadsdk.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.downloadnew.core.DownloadBridgeFactory;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitCLassLoader;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private TTAdSdk.InitCallback f1778ms;

    private interface xr<T> {
        void ms(T t);
    }

    protected abstract com.bytedance.sdk.openadsdk.ah.ah ah();

    protected void ms(Result result) {
    }

    public abstract boolean ms();

    public abstract boolean ms(Context context, com.bykv.ms.ms.ms.ms.xr xrVar);

    public abstract ah xr();

    public abstract void xr(Context context, com.bykv.ms.ms.ms.ms.xr xrVar);

    protected boolean xr(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        return false;
    }

    public void ms(final Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        com.bytedance.sdk.openadsdk.ah.d.ms().ms(ah());
        if (xr(context, adConfig, initCallback)) {
            this.f1778ms = initCallback;
            final com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(com.bytedance.sdk.openadsdk.ao.ms.ah.ms.ms(adConfig));
            xrVarMs.ms(1, SystemClock.elapsedRealtime());
            xrVarMs.ms(5, "main");
            xrVarMs.ms(4, true);
            xrVarMs.ms(6, 999);
            xrVarMs.ms(10, 6923);
            xrVarMs.ms(11, "6.9.2.3");
            xrVarMs.ms(12, "com.byted.pangle");
            xrVarMs.ms(14, true);
            xrVarMs.ms(16, com.bytedance.sdk.openadsdk.ah.d.ms());
            xrVarMs.ms(17, com.bytedance.sdk.openadsdk.qv.ms.ms().xr());
            Thread threadCurrentThread = Thread.currentThread();
            xrVarMs.ms(2, threadCurrentThread.getName());
            xrVarMs.ms(3, threadCurrentThread.getPriority());
            xrVarMs.ms(15, new d());
            xrVarMs.ms(8301, new MediationInitCLassLoader());
            if (adConfig != null) {
                MediationApiLog.setDebug(Boolean.valueOf(adConfig.isDebug()));
            }
            if (!ms(context, xrVarMs)) {
                com.bytedance.sdk.openadsdk.qv.ms.ms().ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.ms.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ms.this.xr(context, xrVarMs);
                    }
                });
            }
            xr().ms(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ms(Manager manager) {
        ab.xr("_tt_ad_sdk_", "update manager");
        xr().ms(manager);
        xr().register(com.bytedance.sdk.openadsdk.ah.d.ms());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xr(Result result) {
        ms(result);
        if (result.isSuccess()) {
            ab.xr("_tt_ad_sdk_", "init sdk success ");
            TTAdSdk.InitCallback initCallback = this.f1778ms;
            if (initCallback != null) {
                initCallback.success();
            }
        } else {
            ab.ka("_tt_ad_sdk_", "int sdk failed, code: " + result.code() + ", message: " + result.message());
            TTAdSdk.InitCallback initCallback2 = this.f1778ms;
            if (initCallback2 != null) {
                initCallback2.fail(result.code(), result.message() != null ? result.message() : "");
            }
        }
        this.f1778ms = null;
    }

    private class d implements Function<SparseArray<Object>, Object> {
        private d() {
        }

        @Override // java.util.function.Function
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            if (sparseArray == null) {
                return null;
            }
            ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
            ms.this.xr(com.bykv.ms.ms.ms.ms.ms.ms().ms(valueSetXr.intValue(-999900)).ms(valueSetXr.stringValue(-999901)).ms(valueSetXr.booleanValue(-999903)).ms(com.bykv.ms.ms.ms.ms.xr.ms((SparseArray<Object>) valueSetXr.objectValue(-999902, SparseArray.class)).xr()).xr());
            return null;
        }
    }

    public static abstract class ah implements TTAdManager {
        private List<WeakReference<xr<Manager>>> ah = new CopyOnWriteArrayList();

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private volatile Manager f1780ms;
        private volatile boolean xr;

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getSDKVersion() {
            return "6.9.2.3";
        }

        protected Object ms(Object obj) {
            return obj;
        }

        protected void ms(Throwable th) {
        }

        public void ms(boolean z) {
            this.xr = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ms(Manager manager) {
            if (c.ms()) {
                return;
            }
            this.f1780ms = manager;
            if (this.f1780ms != null) {
                Iterator<WeakReference<xr<Manager>>> it = this.ah.iterator();
                while (it.hasNext()) {
                    WeakReference<xr<Manager>> next = it.next();
                    xr<Manager> xrVar = next != null ? next.get() : null;
                    if (xrVar != null) {
                        xrVar.ms(manager);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ms(xr<Manager> xrVar) {
            if (c.ms()) {
                return;
            }
            this.ah.add(new WeakReference<>(xrVar));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public TTAdNative createAdNative(Context context) {
            if (c.ms()) {
                return null;
            }
            return new ka(new AnonymousClass1(new SoftReference(context))).ms();
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.api.ms$ah$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractC0263ms<Loader> {
            final /* synthetic */ SoftReference ah;

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            Loader f1781ms;
            final xr<Manager> xr;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SoftReference softReference) {
                super();
                this.ah = softReference;
                this.xr = new xr<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ms.ah.1.1
                    @Override // com.bytedance.sdk.openadsdk.api.ms.xr
                    public void ms(Manager manager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.f1781ms = manager.createLoader((Context) anonymousClass1.ah.get());
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.api.ms.AbstractC0263ms
            public void ms(final xr<Loader> xrVar, int i) {
                Loader loader = this.f1781ms;
                if (loader == null) {
                    ah.this.call(new xr<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ms.ah.1.2
                        @Override // com.bytedance.sdk.openadsdk.api.ms.xr
                        public void ms(Manager manager) {
                            ah.this.ms(AnonymousClass1.this.xr);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            anonymousClass1.f1781ms = manager.createLoader((Context) anonymousClass1.ah.get());
                            xrVar.ms(AnonymousClass1.this.f1781ms);
                        }
                    }, i + 10000);
                } else {
                    xrVar.ms(loader);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void register(final Object obj) {
            if (c.ms()) {
                return;
            }
            call(new xr<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ms.ah.2
                @Override // com.bytedance.sdk.openadsdk.api.ms.xr
                public void ms(Manager manager) {
                    Function<SparseArray<Object>, Object> functionMs;
                    SparseArray<Object> sparseArray = com.bykv.ms.ms.ms.ms.xr.ms(2).ms(8, ah.this.ms(obj)).ms(-99999987, 4).ms(-99999985, Void.class).xr().sparseArray();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.ah) || (functionMs = ((com.bytedance.sdk.openadsdk.api.ah) manager).ms(1)) == null) {
                        return;
                    }
                    functionMs.apply(sparseArray);
                }
            }, 4);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void unregister(final Object obj) {
            if (c.ms()) {
                return;
            }
            call(new xr<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ms.ah.3
                @Override // com.bytedance.sdk.openadsdk.api.ms.xr
                public void ms(Manager manager) {
                    Function<SparseArray<Object>, Object> functionMs;
                    SparseArray<Object> sparseArray = com.bykv.ms.ms.ms.ms.xr.ms(2).ms(8, obj).ms(-99999987, 5).ms(-99999985, Void.class).xr().sparseArray();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.ah) || (functionMs = ((com.bytedance.sdk.openadsdk.api.ah) manager).ms(1)) == null) {
                        return;
                    }
                    functionMs.apply(sparseArray);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
            if (c.ms()) {
                return null;
            }
            if (this.f1780ms != null) {
                return (T) xr(this.f1780ms, cls, bundle);
            }
            call(new xr<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ms.ah.4
                @Override // com.bytedance.sdk.openadsdk.api.ms.xr
                public void ms(Manager manager) {
                    ah.xr(ah.this.f1780ms, cls, bundle);
                }
            }, 6);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T xr(Manager manager, Class<T> cls, Bundle bundle) {
            Function<SparseArray<Object>, Object> functionMs;
            if (c.ms()) {
                return null;
            }
            SparseArray<Object> sparseArray = com.bykv.ms.ms.ms.ms.xr.ms(3).ms(9, cls).ms(10, bundle).ms(-99999987, 6).ms(-99999985, cls).xr().sparseArray();
            if (!(manager instanceof com.bytedance.sdk.openadsdk.api.ah) || (functionMs = ((com.bytedance.sdk.openadsdk.api.ah) manager).ms(1)) == null) {
                return null;
            }
            return (T) functionMs.apply(sparseArray);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void requestPermissionIfNecessary(final Context context) {
            if (c.ms()) {
                return;
            }
            call(new xr<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ms.ah.5
                @Override // com.bytedance.sdk.openadsdk.api.ms.xr
                public void ms(Manager manager) {
                    Function<SparseArray<Object>, Object> functionMs;
                    SparseArray<Object> sparseArray = com.bykv.ms.ms.ms.ms.xr.ms(2).ms(7, context).ms(-99999987, 3).ms(-99999985, Void.class).xr().sparseArray();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.ah) || (functionMs = ((com.bytedance.sdk.openadsdk.api.ah) manager).ms(1)) == null) {
                        return;
                    }
                    functionMs.apply(sparseArray);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
            if (c.ms()) {
                return false;
            }
            HashMap map = new HashMap();
            map.put(TTDownloadField.TT_ACTIVITY, activity);
            map.put(TTDownloadField.TT_EXIT_INSTALL_LISTENER, exitInstallListener);
            return ((Boolean) DownloadBridgeFactory.getDownloadBridge(TTAppContextHolder.getContext()).apply(com.bykv.ms.ms.ms.ms.xr.ms(2).ms(0, map).ms(-99999987, 0).ms(-99999985, Boolean.class).xr().sparseArray())).booleanValue();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getPluginVersion() {
            return this.f1780ms != null ? this.f1780ms.values().stringValue(12) : "";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot) {
            return getBiddingToken(adSlot, false, adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot, boolean z, int i) {
            Function<SparseArray<Object>, Object> functionMs;
            if (c.ms()) {
                return null;
            }
            if (i <= 0) {
                i = adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType();
            }
            ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(com.bytedance.sdk.openadsdk.ao.ms.ah.xr.ms(adSlot)).ms(13, z).ms(14, i).ms(-99999987, 2).ms(-99999985, String.class).xr();
            if ((this.f1780ms instanceof com.bytedance.sdk.openadsdk.api.ah) && (functionMs = ((com.bytedance.sdk.openadsdk.api.ah) this.f1780ms).ms(1)) != null) {
                Object objApply = functionMs.apply(valueSetXr.sparseArray());
                if (objApply instanceof String) {
                    return (String) objApply;
                }
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void setThemeStatus(final int i) {
            if (c.ms()) {
                return;
            }
            call(new xr<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.ms.ah.6
                @Override // com.bytedance.sdk.openadsdk.api.ms.xr
                public void ms(Manager manager) {
                    Function<SparseArray<Object>, Object> functionMs;
                    ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms().ms(11, i).ms(-99999987, 1).ms(-99999985, Void.class).xr();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.ah) || (functionMs = ((com.bytedance.sdk.openadsdk.api.ah) manager).ms(1)) == null) {
                        return;
                    }
                    functionMs.apply(valueSetXr.sparseArray());
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public int getThemeStatus() {
            if (this.f1780ms != null) {
                return this.f1780ms.values().intValue(11);
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(final xr<Manager> xrVar, final int i) {
            if (c.ms()) {
                return;
            }
            if (this.f1780ms != null) {
                try {
                    xrVar.ms(this.f1780ms);
                    return;
                } catch (Throwable th) {
                    ab.d("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                    ms(th);
                    return;
                }
            }
            if (!this.xr && i > 10000) {
                throw new IllegalStateException("广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告");
            }
            com.bytedance.sdk.openadsdk.qv.ms.ms().ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.ms.ah.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ah.this.f1780ms != null) {
                            xrVar.ms(ah.this.f1780ms);
                        } else {
                            ab.d("_tt_ad_sdk_", "Not ready, no manager: " + i);
                        }
                    } catch (Throwable th2) {
                        ab.d("_tt_ad_sdk_", "Unexpected manager call error: " + th2.getMessage());
                        ah.this.ms(th2);
                    }
                }
            });
        }
    }

    private static class ka extends com.bytedance.sdk.openadsdk.ao.ms.ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private AbstractC0263ms<Loader> f1791ms;

        ka(AbstractC0263ms<Loader> abstractC0263ms) {
            this.f1791ms = abstractC0263ms;
        }

        private void ms(xr<Loader> xrVar, int i) {
            ab.xr("_tt_ad_sdk_", "load ad slot type: ".concat(String.valueOf(i)));
            this.f1791ms.ms(xrVar, i);
        }

        @Override // com.bytedance.sdk.openadsdk.ao.ms.ms
        public void ms(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            ms(new xr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ms.ka.1
                @Override // com.bytedance.sdk.openadsdk.api.ms.xr
                public void ms(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(5, com.bykv.ms.ms.ms.ms.xr.ms(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).ms(1, function).xr(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.ao.ms.ms
        public void xr(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            ms(new xr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ms.ka.3
                @Override // com.bytedance.sdk.openadsdk.api.ms.xr
                public void ms(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(6, com.bykv.ms.ms.ms.ms.xr.ms(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).ms(1, function).xr(), null);
                }
            }, 6);
        }

        @Override // com.bytedance.sdk.openadsdk.ao.ms.ms
        public void ah(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            ms(new xr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ms.ka.4
                @Override // com.bytedance.sdk.openadsdk.api.ms.xr
                public void ms(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(9, com.bykv.ms.ms.ms.ms.xr.ms(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).ms(1, function).xr(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.ao.ms.ms
        public void d(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            ms(new xr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ms.ka.5
                @Override // com.bytedance.sdk.openadsdk.api.ms.xr
                public void ms(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(1, com.bykv.ms.ms.ms.ms.xr.ms(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).ms(1, function).xr(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.ao.ms.ms
        public void ms(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function, final int i) {
            ms(new xr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ms.ka.6
                @Override // com.bytedance.sdk.openadsdk.api.ms.xr
                public void ms(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(3, com.bykv.ms.ms.ms.ms.xr.ms(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).ms(3, i).ms(1, function).xr(), null);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.ao.ms.ms
        public void ka(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            ms(new xr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ms.ka.7
                @Override // com.bytedance.sdk.openadsdk.api.ms.xr
                public void ms(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(7, com.bykv.ms.ms.ms.ms.xr.ms(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).ms(1, function).xr(), null);
                }
            }, 7);
        }

        @Override // com.bytedance.sdk.openadsdk.ao.ms.ms
        public void c(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            ms(new xr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ms.ka.8
                @Override // com.bytedance.sdk.openadsdk.api.ms.xr
                public void ms(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(8, com.bykv.ms.ms.ms.ms.xr.ms(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).ms(1, function).xr(), null);
                }
            }, 8);
        }

        @Override // com.bytedance.sdk.openadsdk.ao.ms.ms
        public void ab(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            ms(new xr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ms.ka.9
                @Override // com.bytedance.sdk.openadsdk.api.ms.xr
                public void ms(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(5, com.bykv.ms.ms.ms.ms.xr.ms(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).ms(2, true).ms(1, function).xr(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.ao.ms.ms
        public void x(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            ms(new xr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ms.ka.10
                @Override // com.bytedance.sdk.openadsdk.api.ms.xr
                public void ms(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(9, com.bykv.ms.ms.ms.ms.xr.ms(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).ms(2, true).ms(1, function).xr(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.ao.ms.ms
        public void ny(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            ms(new xr<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.ms.ka.2
                @Override // com.bytedance.sdk.openadsdk.api.ms.xr
                public void ms(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    loader.load(1, com.bykv.ms.ms.ms.ms.xr.ms(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>()).ms(2, true).ms(1, function).xr(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.ao.ms.ms
        public Pair<Integer, String> ms(Exception exc) {
            ab.d("_tt_ad_sdk_", "Load ad failed: " + exc.getMessage());
            if ((exc instanceof IllegalStateException) && "广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告".equals(exc.getMessage())) {
                return new Pair<>(4208, exc.getMessage());
            }
            return new Pair<>(Integer.valueOf(TTAdConstant.INIT_FAILED_CREATE_INVOKE_FAILED), "Load ad failed: " + exc.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.api.ms$ms, reason: collision with other inner class name */
    private static abstract class AbstractC0263ms<T> {
        abstract void ms(xr<T> xrVar, int i);

        private AbstractC0263ms() {
        }
    }
}
