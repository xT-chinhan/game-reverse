package com.byazt.mg;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import com.byazt.fi.BaseConstants;
import com.byazt.vkw.rc;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.openliveplugin.process.LiveProcessUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.ILiveAdCustomConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 860, 50})
public class vk extends com.byazt.dea.pr {
    public static final pr pr = new pr();
    public fw c;
    public SharedPreferences uc;
    public volatile Initializer hw = c();
    public volatile Initializer hn = null;
    public volatile Initializer x = null;
    public boolean fw = false;
    public int zo = Integer.MIN_VALUE;
    public long aj = -1;
    public com.byazt.bw.hn vk = new com.byazt.bw.hn() { // from class: com.byazt.mg.vk.1
        @Override // com.byazt.bw.hn
        public Function<SparseArray<Object>, Object> pr(int i) {
            return vk.this.pr(i);
        }
    };
    public final Object w = new Object();

    @Override // com.byazt.dea.pr
    public boolean hw(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        super.hw(context, adConfig, initCallback);
        this.c = fw.pr("duration");
        try {
            if (LiveProcessUtils.inLiveProcess(TTAppContextHolder.getContext()).booleanValue()) {
                return false;
            }
        } catch (Exception e) {
            com.byazt.dea.uc.hw("_tt_ad_sdk_", e);
        }
        if (com.byazt.dea.c.pr()) {
            hw(com.byazt.ij.hw.pr().pr(false).pr(4204).pr("Only support >= 7.0").hw());
            return false;
        }
        uc.pr(adConfig);
        return true;
    }

    @Override // com.byazt.dea.pr
    public void pr(Result result) {
        super.pr(result);
        uc.pr();
    }

    @Override // com.byazt.dea.pr
    public boolean pr(Context context, com.byazt.ij.hn hnVar) {
        boolean zPr = pr(context);
        if (zPr && uc()) {
            com.byazt.dea.uc.hn("_tt_ad_sdk_", "force pl");
            return false;
        }
        if (com.byazt.ud.hn.hw()) {
            com.byazt.dea.uc.c("_tt_ad_sdk_", "this device does not support arm64-v8a abi");
            return false;
        }
        if (this.hw != null) {
            this.fw = true;
            pr(this.hw.getManager(), false);
            pr(context, hnVar, zPr);
            return false;
        }
        hw(com.byazt.ij.hw.pr().pr(false).pr(4206).hw());
        return true;
    }

    private void pr(final Context context, final com.byazt.ij.hn hnVar, boolean z) {
        long jPr = pr(z);
        if (jPr > 0) {
            com.byazt.as.pr.pr().hn().postDelayed(new Runnable() { // from class: com.byazt.mg.vk.2
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.as.pr.pr().x().execute(new Runnable() { // from class: com.byazt.mg.vk.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Initializer initializer = vk.this.hw;
                            if (vk.this.pr() || vk.this.x == initializer) {
                                com.byazt.dea.uc.hn("_tt_ad_sdk_", "skip boost init, plugin already finished");
                                return;
                            }
                            ValueSet valueSetHw = com.byazt.ij.hn.pr(hnVar.hw().sparseArray()).pr(27, SystemClock.elapsedRealtime()).hw();
                            if (initializer != null) {
                                initializer.init(context, valueSetHw);
                            }
                        }
                    });
                }
            }, jPr);
        } else {
            this.hw.init(context, hnVar.hw());
        }
    }

    @Override // com.byazt.dea.pr
    public void hw(Context context, final com.byazt.ij.hn hnVar) {
        com.byazt.dea.uc.hn("_tt_ad_sdk_", "async init");
        if (this.fw && Build.VERSION.SDK_INT < 26) {
            com.byazt.dea.uc.x("_tt_ad_sdk_", "lower 26");
            return;
        }
        this.c.hw("wait_asyn_cost");
        aj.pr(TTAppContextHolder.getContext()).pr(new EventListener() { // from class: com.byazt.mg.vk.3
            @Override // com.bykv.vk.openvk.api.proto.EventListener
            public ValueSet onEvent(int i, Result result) {
                if (i == 0) {
                    if (result.isSuccess() && vk.this.x == null) {
                        com.byazt.dea.uc.x("_tt_ad_sdk_", "from event");
                        vk.this.c.hw("wait_pl_install");
                        vk vkVar = vk.this;
                        vkVar.pr(vkVar.c, hnVar);
                        return null;
                    }
                    com.byazt.dea.uc.x("_tt_ad_sdk_", "failed event");
                    return null;
                }
                if (i == 1 && result.isSuccess() && vk.this.x == null && hnVar != null) {
                    vk.this.c = fw.pr("duration");
                    hnVar.pr(1, SystemClock.elapsedRealtime());
                    return null;
                }
                return null;
            }
        });
        if (com.byazt.ud.hn.hw()) {
            com.byazt.dea.uc.x("_tt_ad_sdk_", "start load pl.");
            pr(this.c, hnVar);
        } else if (fw()) {
            com.byazt.dea.uc.x("_tt_ad_sdk_", "force boost, dont load pl");
        } else if (pr(context)) {
            com.byazt.dea.uc.x("_tt_ad_sdk_", "start load pl..");
            pr(this.c, hnVar);
        } else {
            com.byazt.dea.uc.x("_tt_ad_sdk_", "no pl");
        }
    }

    @Override // com.byazt.dea.pr
    public boolean hw() {
        return (com.byazt.dea.c.pr() || this.hw == null || !this.hw.isInitSuccess()) ? false : true;
    }

    @Override // com.byazt.dea.pr
    public com.byazt.dea.pr.hn hn() {
        return pr;
    }

    @Override // com.byazt.dea.pr
    public com.byazt.bw.hn x() {
        return this.vk;
    }

    private boolean pr(Context context) {
        return com.byazt.mg.hw.x(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Function<SparseArray<Object>, Object> pr(int i) {
        switch (i) {
            case 2:
                return com.byazt.ay.hn.pr();
            case 3:
                return com.byazt.me.hn.pr(TTAppContextHolder.getContext());
            case 4:
                return com.byazt.os.pr.pr();
            default:
                return null;
        }
    }

    private static Initializer c() {
        String str;
        Object objPr;
        try {
            if (com.byazt.dea.c.pr()) {
                return null;
            }
            Zeus.setMainService(com.byazt.zs.uc.pr());
            Bundle bundle = new Bundle();
            bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new aj.hn());
            bundle.putInt("api_sdk_version", 7714);
            com.byazt.vkw.vk vkVar = (com.byazt.vkw.vk) com.byazt.zs.uc.pr("boost");
            if (vkVar != null) {
                objPr = vkVar.pr(bundle);
                str = null;
            } else {
                str = "service null";
                objPr = null;
            }
            if (objPr == null) {
                if (str == null) {
                    str = "getNewInstance null";
                }
                uc.pr(4206, str, false, null, null);
            }
            return new com.byazt.dea.x((Function) objPr);
        } catch (Throwable th) {
            uc.pr(4206, th.getMessage(), false, null, th);
            com.byazt.dea.uc.c("_tt_ad_sdk_", "Get direct initializer failed", th);
            return null;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 860, 2300})
    private class hw implements Function<SparseArray<Object>, Object> {
        private hw() {
        }

        public ValueSet pr(int i, Result result) {
            com.byazt.dea.uc.hn("bstsdk", "Load p_init: " + result.code() + ", message: " + result.message());
            if (result.isSuccess()) {
                if (vk.this.x != null) {
                    vk vkVar = vk.this;
                    vkVar.hn = vkVar.hw;
                    vk vkVar2 = vk.this;
                    vkVar2.hw = vkVar2.x;
                    vk vkVar3 = vk.this;
                    vkVar3.pr(vkVar3.hw.getManager(), true);
                    vk.this.pr(2, result);
                }
            } else {
                com.byazt.dea.uc.c("_tt_ad_sdk_", "pl init failed, code: " + result.code() + ", msg: " + result.message());
                uc.pr(result.code(), result.message(), !vk.this.fw, null, null);
            }
            if (!vk.this.fw) {
                com.byazt.dea.uc.hn("_tt_ad_sdk_", "pl init callback, !isNonPlInit, finishInit");
                vk.this.hw(result);
            } else if (result.isSuccess() && vk.this.pr(true) > 0) {
                com.byazt.dea.uc.hn("_tt_ad_sdk_", "pl init callback, bst delayed, pl finished first, finishInit");
                vk.this.hw(result);
            }
            if (result.isSuccess()) {
                c.pr();
            }
            return null;
        }

        @Override // java.util.function.Function
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            if (sparseArray == null) {
                return null;
            }
            ValueSet valueSetHw = com.byazt.ij.hn.pr(sparseArray).hw();
            int iIntValue = valueSetHw.intValue(-99999987);
            SparseArray sparseArray2 = (SparseArray) valueSetHw.objectValue(-99999979, SparseArray.class);
            if (sparseArray2 != null) {
                ValueSet valueSetHw2 = com.byazt.ij.hn.pr((SparseArray<Object>) sparseArray2).hw();
                pr(iIntValue, com.byazt.ij.hw.pr().pr(valueSetHw2.intValue(-999900)).pr(valueSetHw2.stringValue(-999901)).pr(valueSetHw2.booleanValue(-999903)).pr(com.byazt.ij.hn.pr((SparseArray<Object>) valueSetHw2.objectValue(-999902, SparseArray.class)).hw()).hw());
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(fw fwVar, com.byazt.ij.hn hnVar) {
        int iPr;
        if (this.x != null && this.x.isInitSuccess()) {
            return;
        }
        com.byazt.ij.hn hnVarPr = com.byazt.ij.hn.pr(hnVar.hw().sparseArray());
        hnVarPr.pr(15, new hw());
        try {
            if (this.x == null) {
                synchronized (hn.class) {
                    try {
                        if (this.x == null) {
                            Initializer initializerPr = hn.pr.pr(fwVar);
                            this.x = initializerPr;
                            pr(initializerPr, fwVar, hnVarPr);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Exception e) {
            if (!(e instanceof x)) {
                iPr = 4206;
            } else {
                iPr = ((x) e).pr();
            }
            com.byazt.dea.uc.c("_tt_ad_sdk_", "loadPl failed, code: " + iPr + ", msg: " + e.getMessage());
            uc.pr(iPr, e.getMessage(), true, fwVar, e);
            if (!this.fw) {
                hw(com.byazt.ij.hw.pr().pr(false).pr(4206).pr(e.getMessage()).hw());
            }
        }
    }

    private void pr(Manager manager, Result result) {
        if (manager != null && (manager instanceof com.byazt.dea.hn)) {
            Function<SparseArray<Object>, Object> functionPr = ((com.byazt.dea.hn) manager).pr(1);
            if (functionPr instanceof Function) {
                com.byazt.dea.uc.hn("_tt_ad_sdk_", "quitWork, notify bst manager to quit");
                functionPr.apply(com.byazt.ij.hn.pr(1).pr(-99999987, 16).pr(-99999985, Void.class).pr(17, true).pr(21, result.values() == null ? null : result.values().sparseArray()).hw().sparseArray());
            }
        }
    }

    private static void pr(Initializer initializer, fw fwVar, com.byazt.ij.hn hnVar) throws x {
        if (initializer != null) {
            try {
                fwVar.pr();
                JSONObject jSONObject = new JSONObject();
                fwVar.pr(jSONObject, 20L);
                jSONObject.put("zeus", aj.pr(TTAppContextHolder.getContext()).pr());
                initializer.init(TTAppContextHolder.getContext(), hnVar.pr(9, jSONObject).hw());
                if (TTAppContextHolder.getContext() != null) {
                    Zeus.hookHuaWeiVerifier((Application) TTAppContextHolder.getContext().getApplicationContext());
                }
                com.byazt.dea.uc.hw("_tt_ad_sdk_", "Initialized done");
                return;
            } catch (Exception e) {
                Zeus.unInstallPlugin("com.byted.pangle");
                throw new x(4207, "Init error", e);
            }
        }
        throw new x(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED, "initializer null");
    }

    @com.byazt.vzx.pr(pr = {0, 1, 860, 2302})
    private static final class hn {
        public static final hn pr = new hn();
        public volatile Initializer hw;

        private hn() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Initializer pr(fw fwVar) throws x {
            if (this.hw == null) {
                synchronized (this) {
                    if (this.hw == null) {
                        this.hw = hw(fwVar);
                    }
                }
            }
            return this.hw;
        }

        private static Initializer hw(fw fwVar) throws x {
            try {
                Plugin plugin = Zeus.getPlugin("com.byted.pangle");
                fwVar.hw("call_create_initializer");
                plugin.setApiBridge(com.byazt.bw.x.pr());
                if (aj.pr(TTAppContextHolder.getContext()).pr(fwVar, BaseConstants.Time.MINUTE) == null) {
                    throw new x(4205, "Get ClassLoader failed");
                }
                Function pluginBridge = plugin.getPluginBridge();
                if (pluginBridge == null) {
                    throw new x(4206, "Get Bridge failed");
                }
                fwVar.hw("get_bridge_cost");
                SparseArray sparseArray = new SparseArray();
                Bundle bundle = new Bundle();
                bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new aj.hn());
                bundle.putInt("api_sdk_version", 7714);
                sparseArray.put(0, bundle);
                sparseArray.put(-99999987, 1);
                fwVar.hw("create_bundle_cost");
                Object objApply = pluginBridge.apply(sparseArray);
                if (objApply == null) {
                    throw new x(4206, "Get Initializer null");
                }
                fwVar.hw("get_init_method_cost");
                try {
                    com.byazt.dea.x xVar = new com.byazt.dea.x((Function) objApply);
                    fwVar.hw("get_init_instance_cost");
                    com.byazt.dea.uc.hw("TTPluginManager", "Create initializer success");
                    return xVar;
                } catch (Throwable th) {
                    Zeus.unInstallPlugin("com.byted.pangle");
                    throw th;
                }
            } catch (Throwable th2) {
                if (th2 instanceof x) {
                    throw th2;
                }
                throw new x(4206, "Create initializer failed", th2);
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 860, 590})
    private static final class pr extends com.byazt.dea.pr.hn {
        private pr() {
        }

        @Override // com.byazt.dea.pr.hn
        public void pr(Throwable th) {
            aj.pr(th);
        }

        @Override // com.byazt.dea.pr.hn
        public Object pr(Object obj) {
            boolean z = obj instanceof TTPluginListener;
            if (z) {
                aj.pr(TTAppContextHolder.getContext()).pr((TTPluginListener) obj);
            }
            if (z) {
                TTPluginListener tTPluginListener = (TTPluginListener) obj;
                return aj.pr(TTAppContextHolder.getContext()).pr(tTPluginListener.packageName(), tTPluginListener.config());
            }
            if (obj instanceof ILiveAdCustomConfig) {
                return com.byazt.ay.hn.pr((ILiveAdCustomConfig) obj);
            }
            if (com.byazt.ul.hw.pr(obj)) {
                return new com.byazt.ul.hw(obj);
            }
            if (obj instanceof TTAdInteractionListener) {
                return new com.byazt.ve.hw((TTAdInteractionListener) obj);
            }
            return obj;
        }
    }

    private boolean uc() {
        zo();
        return this.zo == 1;
    }

    private boolean fw() {
        zo();
        return this.zo == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long pr(boolean z) {
        zo();
        if (this.zo != 0 || !z) {
            return 0L;
        }
        if (this.aj < 0) {
            try {
                this.aj = this.uc.getLong("bstlayer_init_delay_time", 0L);
            } catch (Throwable th) {
                this.aj = 0L;
            }
        }
        return this.aj;
    }

    private void zo() {
        if (this.zo == Integer.MIN_VALUE) {
            if (this.uc == null) {
                this.uc = com.byazt.mg.hw.hw(TTAppContextHolder.getContext(), "sp_bidding_opt_libra", 0);
            }
            int i = this.uc.getInt("bst_pl_exec_conf", -1);
            this.zo = i;
            if (i >= 0) {
                return;
            }
            this.zo = this.uc.getInt("_use_pl_", 0);
        }
    }

    @Override // com.byazt.dea.pr
    public void pr(int i, Result result) {
        int iIntValue = -1;
        try {
            rc rcVar = (rc) com.byazt.zs.uc.pr("m_d_s");
            if (rcVar != null) {
                synchronized (this.w) {
                    try {
                        Object objPr = rcVar.pr(3);
                        if (objPr instanceof Integer) {
                            iIntValue = ((Integer) objPr).intValue();
                        }
                        if (iIntValue < 0) {
                            rcVar.pr(3, Integer.valueOf(i));
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable th2) {
            com.byazt.dea.uc.x("_tt_ad_sdk_", th2.getMessage());
        }
        if (i == 2 || iIntValue == 2) {
            Initializer initializer = this.hn;
            if (this.fw && initializer != null && initializer.isInitSuccess()) {
                pr(initializer.getManager(), result);
                this.hn = null;
            }
        }
    }
}
