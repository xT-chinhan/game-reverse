package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.openliveplugin.process.LiveProcessUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.component.ch.hi;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig;
import com.umeng.ccg.a;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x extends com.bytedance.sdk.openadsdk.api.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final ms f1821ms = new ms();
    private c d;
    private SharedPreferences ka;
    private volatile Initializer xr = ka();
    private volatile Initializer ah = null;
    private boolean c = false;
    private com.bytedance.sdk.openadsdk.ah.ah ab = new com.bytedance.sdk.openadsdk.ah.ah() { // from class: com.bytedance.sdk.openadsdk.api.plugin.x.1
        @Override // com.bytedance.sdk.openadsdk.ah.ah
        public Function<SparseArray<Object>, Object> ms(int i) {
            return x.this.ms(i);
        }
    };

    @Override // com.bytedance.sdk.openadsdk.api.ms
    protected boolean xr(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        super.xr(context, adConfig, initCallback);
        this.d = c.ms("duration");
        try {
            if (LiveProcessUtils.inLiveProcess(TTAppContextHolder.getContext()).booleanValue()) {
                return false;
            }
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.xr("_tt_ad_sdk_", e);
        }
        if (!com.bytedance.sdk.openadsdk.api.c.ms()) {
            return true;
        }
        xr(com.bykv.ms.ms.ms.ms.ms.ms().ms(false).ms(4204).ms("Only support >= 7.0").xr());
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.api.ms
    protected void ms(Result result) {
        super.ms(result);
        ka.ms();
    }

    public boolean d() {
        if (this.ka == null) {
            this.ka = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(TTAppContextHolder.getContext(), "sp_bidding_opt_libra", 0);
        }
        return this.ka.getInt("_use_pl_", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.api.ms
    public boolean ms(Context context, com.bykv.ms.ms.ms.ms.xr xrVar) {
        if (ms(context) && d()) {
            com.bytedance.sdk.openadsdk.api.ab.ah("_tt_ad_sdk_", "use pl Init");
            return false;
        }
        if (this.xr != null) {
            this.c = true;
            ms(this.xr.getManager());
            this.xr.init(context, xrVar.xr());
            return false;
        }
        xr(com.bykv.ms.ms.ms.ms.ms.ms().ms(false).ms(4206).xr());
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.ms
    public void xr(Context context, com.bykv.ms.ms.ms.ms.xr xrVar) {
        com.bytedance.sdk.openadsdk.api.ab.ah("_tt_ad_sdk_", "async init");
        boolean z = this.c;
        this.d.xr("wait_asyn_cost");
        if (!ms(context)) {
            com.bytedance.sdk.openadsdk.api.ab.d("_tt_ad_sdk_", "no pl");
        } else {
            com.bytedance.sdk.openadsdk.api.ab.d("_tt_ad_sdk_", "start pl load");
            ms(this.d, xrVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.ms
    public boolean ms() {
        return (com.bytedance.sdk.openadsdk.api.c.ms() || this.xr == null || !this.xr.isInitSuccess()) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.ms
    public com.bytedance.sdk.openadsdk.api.ms.ah xr() {
        return f1821ms;
    }

    @Override // com.bytedance.sdk.openadsdk.api.ms
    protected com.bytedance.sdk.openadsdk.ah.ah ah() {
        return this.ab;
    }

    private boolean ms(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.xr.d(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Function<SparseArray<Object>, Object> ms(int i) {
        if (i == 2) {
            return com.bytedance.sdk.openadsdk.live.ah.ms();
        }
        if (i == 3) {
            return com.bytedance.sdk.openadsdk.downloadnew.d.ms(TTAppContextHolder.getContext());
        }
        if (i != 4) {
            return null;
        }
        return com.bytedance.sdk.openadsdk.api.plugin.ms.ms.ms();
    }

    private static Initializer ka() {
        try {
            Class<?> clsLoadClass = TTAdSdk.class.getClassLoader().loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
            Bundle bundle = new Bundle();
            bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new ab.ah());
            bundle.putInt("api_sdk_version", 6923);
            return new com.bytedance.sdk.openadsdk.api.d((Function) clsLoadClass.getDeclaredMethod("getNewInstance", Bundle.class).invoke(null, bundle));
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
            com.bytedance.sdk.openadsdk.api.ab.ka("_tt_ad_sdk_", "Get direct initializer failed");
            return null;
        }
    }

    private class xr implements Function<SparseArray<Object>, Object> {
        private xr() {
        }

        public ValueSet ms(int i, Result result) {
            com.bytedance.sdk.openadsdk.api.ab.ah("_tt_ad_sdk_", "Load p_init: " + result.code() + ", message: " + result.message());
            if (result.isSuccess() && x.this.ah != null) {
                if (x.this.c && x.this.xr != null && x.this.xr.isInitSuccess()) {
                    x xVar = x.this;
                    xVar.xr(xVar.xr.getManager());
                }
                x xVar2 = x.this;
                xVar2.xr = xVar2.ah;
                x xVar3 = x.this;
                xVar3.ms(xVar3.xr.getManager());
            }
            if (!x.this.c) {
                x.this.xr(result);
            }
            if (!result.isSuccess() || x.this.ah == null) {
                return null;
            }
            x.this.c();
            return null;
        }

        @Override // java.util.function.Function
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            if (sparseArray == null) {
                return null;
            }
            ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
            ms(valueSetXr.intValue(-99999987), com.bykv.ms.ms.ms.ms.ms.ms().ms(valueSetXr.intValue(-999900)).ms(valueSetXr.stringValue(-999901)).ms(valueSetXr.booleanValue(-999903)).ms(com.bykv.ms.ms.ms.ms.xr.ms((SparseArray<Object>) valueSetXr.objectValue(-999902, SparseArray.class)).xr()).xr());
            return null;
        }
    }

    private void ms(c cVar, com.bykv.ms.ms.ms.ms.xr xrVar) {
        if (this.ah == null || !this.ah.isInitSuccess()) {
            com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(xrVar.xr().sparseArray());
            xrVarMs.ms(15, new xr());
            try {
                if (this.ah == null) {
                    synchronized (ah.class) {
                        if (this.ah == null) {
                            Initializer initializerMs = ah.f1823ms.ms(cVar);
                            this.ah = initializerMs;
                            ms(initializerMs, cVar, xrVarMs);
                        }
                    }
                }
            } catch (com.bytedance.sdk.openadsdk.api.plugin.ah e) {
                com.bytedance.sdk.openadsdk.api.ab.d("_tt_ad_sdk_", "Load p_init failed: " + e.ms() + ", message: " + e.getMessage());
                ka.ms(e.ms(), e.getMessage(), 0L);
            } catch (Exception e2) {
                ka.ms(4206, "Load p_init failed: " + e2.getMessage(), 0L);
                com.bytedance.sdk.openadsdk.api.ab.d("_tt_ad_sdk_", "Load p_init failed: " + e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(Manager manager) {
        if (manager == null || !(manager instanceof com.bytedance.sdk.openadsdk.api.ah)) {
            return;
        }
        Function<SparseArray<Object>, Object> functionMs = ((com.bytedance.sdk.openadsdk.api.ah) manager).ms(1);
        if (functionMs instanceof Function) {
            functionMs.apply(com.bykv.ms.ms.ms.ms.xr.ms(1).ms(-99999987, 16).ms(-99999985, Void.class).ms(17, true).xr().sparseArray());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ExecutorService executorService = (ExecutorService) ms(ExecutorService.class, 1);
        if (executorService != null && (executorService instanceof ThreadPoolExecutor)) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
            hi.xr.ms(threadPoolExecutor);
            com.bytedance.sdk.openadsdk.qv.ms.ms().ms(threadPoolExecutor);
        }
        ExecutorService executorService2 = (ExecutorService) ms(ExecutorService.class, 2);
        if (executorService2 != null) {
            hi.xr.xr((ThreadPoolExecutor) executorService2);
        }
        ExecutorService executorService3 = (ExecutorService) ms(ExecutorService.class, 3);
        if (executorService3 != null) {
            hi.xr.ms((ScheduledExecutorService) executorService3);
        }
    }

    private <T> T ms(Class<T> cls, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(a.z, i);
        return (T) xr().getExtra(cls, bundle);
    }

    private static void ms(Initializer initializer, c cVar, com.bykv.ms.ms.ms.ms.xr xrVar) throws com.bytedance.sdk.openadsdk.api.plugin.ah {
        if (initializer != null) {
            try {
                cVar.ms();
                JSONObject jSONObject = new JSONObject();
                cVar.ms(jSONObject, 20L);
                jSONObject.put("zeus", ab.ms(TTAppContextHolder.getContext()).ms());
                xrVar.ms(17, com.bytedance.sdk.openadsdk.qv.ms.ms().xr());
                xrVar.ms(20, hi.xr.ny());
                xrVar.ms(19, hi.xr.ch());
                xrVar.ms(21, hi.xr.sl());
                initializer.init(TTAppContextHolder.getContext(), xrVar.ms(9, jSONObject).xr());
                if (TTAppContextHolder.getContext() != null) {
                    Zeus.hookHuaWeiVerifier((Application) TTAppContextHolder.getContext().getApplicationContext());
                    return;
                }
                return;
            } catch (Exception e) {
                Zeus.unInstallPlugin("com.byted.pangle");
                throw new com.bytedance.sdk.openadsdk.api.plugin.ah(4207, "Init error: " + e.getMessage());
            }
        }
        throw new com.bytedance.sdk.openadsdk.api.plugin.ah(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED, "3900以上版本仅支持armeabi-v7a,arm64-v8a两种架构，非支持架构会触发40025。确认项目是否支持了com.android.support:appcompat-v7:28.0.0；若项目是 androidX版本, 需要将gradle.properties 中 android.useAndroidX 和 android.enableJetifier 设置为 true");
    }

    private static final class ah {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static final ah f1823ms = new ah();
        private volatile Initializer xr;

        private ah() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Initializer ms(c cVar) throws com.bytedance.sdk.openadsdk.api.plugin.ah {
            if (this.xr == null) {
                synchronized (this) {
                    if (this.xr == null) {
                        this.xr = xr(cVar);
                    }
                }
            }
            return this.xr;
        }

        private static Initializer xr(c cVar) throws com.bytedance.sdk.openadsdk.api.plugin.ah {
            try {
                cVar.xr("call_create_initializer");
                BaseDexClassLoader baseDexClassLoaderMs = ab.ms(TTAppContextHolder.getContext()).ms(cVar, 600000);
                if (baseDexClassLoaderMs == null) {
                    throw new com.bytedance.sdk.openadsdk.api.plugin.ah(4205, "3900以上版本仅支持armeabi-v7a,arm64-v8a两种架构，非支持架构会触发40025。确认项目是否支持了com.android.support:appcompat-v7:28.0.0；若项目是 androidX版本, 需要将gradle.properties 中 android.useAndroidX 和 android.enableJetifier 设置为 true");
                }
                Class<?> clsLoadClass = baseDexClassLoaderMs.loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
                cVar.xr("get_init_class_cost");
                Bundle bundle = new Bundle();
                bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new ab.ah());
                bundle.putInt("api_sdk_version", 6923);
                cVar.xr("create_bundle_cost");
                Method declaredMethod = clsLoadClass.getDeclaredMethod("getNewInstance", Bundle.class);
                cVar.xr("get_init_method_cost");
                try {
                    com.bytedance.sdk.openadsdk.api.d dVar = new com.bytedance.sdk.openadsdk.api.d((Function) declaredMethod.invoke(null, bundle));
                    cVar.xr("get_init_instance_cost");
                    com.bytedance.sdk.openadsdk.api.ab.xr("TTPluginManager", "Create initializer success");
                    return dVar;
                } catch (Throwable th) {
                    Zeus.unInstallPlugin("com.byted.pangle");
                    throw th;
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.openadsdk.api.ab.d("TTPluginManager", "Create initializer failed");
                if (th2 instanceof com.bytedance.sdk.openadsdk.api.plugin.ah) {
                    throw new com.bytedance.sdk.openadsdk.api.plugin.ah(4205, "3900以上版本仅支持armeabi-v7a,arm64-v8a两种架构，非支持架构会触发40025。确认项目是否支持了com.android.support:appcompat-v7:28.0.0；若项目是 androidX版本, 需要将gradle.properties 中 android.useAndroidX 和 android.enableJetifier 设置为 true");
                }
                com.bytedance.sdk.openadsdk.api.ab.ms(th2);
                throw new com.bytedance.sdk.openadsdk.api.plugin.ah(4206, th2.getMessage());
            }
        }
    }

    private static final class ms extends com.bytedance.sdk.openadsdk.api.ms.ah {
        private ms() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.ms.ah
        protected void ms(Throwable th) {
            ab.ms(th);
        }

        @Override // com.bytedance.sdk.openadsdk.api.ms.ah
        protected Object ms(Object obj) {
            boolean z = obj instanceof TTPluginListener;
            if (z) {
                ab.ms(TTAppContextHolder.getContext()).ms((TTPluginListener) obj);
            }
            if (!z) {
                return obj instanceof ILiveAdCustomConfig ? com.bytedance.sdk.openadsdk.live.ah.ms((ILiveAdCustomConfig) obj) : obj;
            }
            TTPluginListener tTPluginListener = (TTPluginListener) obj;
            return ab.ms(TTAppContextHolder.getContext()).ms(tTPluginListener.packageName(), tTPluginListener.config());
        }
    }
}
