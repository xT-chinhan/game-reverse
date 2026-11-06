package com.byazt.qyu;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import com.byazt.ho.BaseConstants;
import com.byazt.vf.fi;
import com.byazt.vf.hu;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1178, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends com.byazt.vx.n {
    public static final n n = new n();
    public x l;
    public SharedPreferences w;
    public volatile Initializer qg = l();
    public volatile Initializer s = null;
    public volatile Initializer q = null;
    public boolean x = false;
    public int fs = Integer.MIN_VALUE;
    public long rv = -1;
    public com.byazt.ja.s tj = new com.byazt.ja.s() { // from class: com.byazt.qyu.tj.1
        @Override // com.byazt.ja.s
        public Function<SparseArray<Object>, Object> n(int i) {
            return tj.this.n(i);
        }
    };
    public final Object cp = new Object();

    @Override // com.byazt.vx.n
    public boolean qg(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        super.qg(context, adConfig, initCallback);
        this.l = x.n(MediationConstant.EXTRA_DURATION);
        try {
            if (LiveProcessUtils.inLiveProcess(TTAppContextHolder.getContext()).booleanValue()) {
                return false;
            }
        } catch (Exception e) {
            com.byazt.vx.w.n("_tt_ad_sdk_", e);
        }
        if (com.byazt.vx.l.n()) {
            qg(com.byazt.qvu.qg.n().n(false).n(4204).n("Only support >= 7.0").qg());
            return false;
        }
        w.n(adConfig);
        return true;
    }

    @Override // com.byazt.vx.n
    public void n(Result result) {
        super.n(result);
        w.n();
    }

    @Override // com.byazt.vx.n
    public boolean n(Context context, com.byazt.qvu.s sVar) {
        boolean zN = n(context);
        if (zN && w()) {
            com.byazt.vx.w.s("_tt_ad_sdk_", "force pl");
            return false;
        }
        if (com.byazt.eh.s.qg()) {
            com.byazt.vx.w.l("_tt_ad_sdk_", "this device does not support arm64-v8a abi");
            return false;
        }
        if (this.qg != null) {
            this.x = true;
            n(this.qg.getManager(), false);
            n(context, sVar, zN);
            return false;
        }
        qg(com.byazt.qvu.qg.n().n(false).n(4206).qg());
        return true;
    }

    private void n(final Context context, final com.byazt.qvu.s sVar, boolean z) {
        long jN = n(z);
        if (jN > 0) {
            com.byazt.fyy.n.n().s().postDelayed(new Runnable() { // from class: com.byazt.qyu.tj.2
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.fyy.n.n().q().execute(new Runnable() { // from class: com.byazt.qyu.tj.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Initializer initializer = tj.this.qg;
                            if (tj.this.n() || tj.this.q == initializer) {
                                com.byazt.vx.w.s("_tt_ad_sdk_", "skip boost init, plugin already finished");
                                return;
                            }
                            ValueSet valueSetQg = com.byazt.qvu.s.n(sVar.qg().sparseArray()).n(27, SystemClock.elapsedRealtime()).qg();
                            if (initializer != null) {
                                initializer.init(context, valueSetQg);
                            }
                        }
                    });
                }
            }, jN);
        } else {
            this.qg.init(context, sVar.qg());
        }
    }

    @Override // com.byazt.vx.n
    public void qg(Context context, final com.byazt.qvu.s sVar) {
        com.byazt.vx.w.s("_tt_ad_sdk_", "async init");
        if (this.x && Build.VERSION.SDK_INT < 26) {
            com.byazt.vx.w.q("_tt_ad_sdk_", "lower 26");
            return;
        }
        this.l.qg("wait_asyn_cost");
        rv.n(TTAppContextHolder.getContext()).n(new EventListener() { // from class: com.byazt.qyu.tj.3
            @Override // com.bykv.vk.openvk.api.proto.EventListener
            public ValueSet onEvent(int i, Result result) {
                if (i == 0) {
                    if (result.isSuccess() && tj.this.q == null) {
                        com.byazt.vx.w.q("_tt_ad_sdk_", "from event");
                        tj.this.l.qg("wait_pl_install");
                        tj tjVar = tj.this;
                        tjVar.n(tjVar.l, sVar);
                        return null;
                    }
                    com.byazt.vx.w.q("_tt_ad_sdk_", "failed event");
                    return null;
                }
                if (i != 1 || !result.isSuccess() || tj.this.q != null || sVar == null) {
                    return null;
                }
                tj.this.l = x.n(MediationConstant.EXTRA_DURATION);
                sVar.n(1, SystemClock.elapsedRealtime());
                return null;
            }
        });
        if (com.byazt.eh.s.qg()) {
            com.byazt.vx.w.q("_tt_ad_sdk_", "start load pl.");
            n(this.l, sVar);
        } else if (x()) {
            com.byazt.vx.w.q("_tt_ad_sdk_", "force boost, dont load pl");
        } else if (n(context)) {
            com.byazt.vx.w.q("_tt_ad_sdk_", "start load pl..");
            n(this.l, sVar);
        } else {
            com.byazt.vx.w.q("_tt_ad_sdk_", "no pl");
        }
    }

    @Override // com.byazt.vx.n
    public boolean qg() {
        return (com.byazt.vx.l.n() || this.qg == null || !this.qg.isInitSuccess()) ? false : true;
    }

    @Override // com.byazt.vx.n
    public com.byazt.vx.n.s s() {
        return n;
    }

    @Override // com.byazt.vx.n
    public com.byazt.ja.s q() {
        return this.tj;
    }

    private boolean n(Context context) {
        return com.byazt.qyu.qg.l(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Function<SparseArray<Object>, Object> n(int i) {
        if (i == 2) {
            return com.byazt.ea.s.n();
        }
        if (i == 3) {
            return com.byazt.im.s.n(TTAppContextHolder.getContext());
        }
        if (i != 4) {
            return null;
        }
        return com.byazt.bsi.n.n();
    }

    private static Initializer l() {
        String str;
        Object objN;
        try {
            if (com.byazt.vx.l.n()) {
                return null;
            }
            Zeus.setMainService(com.byazt.qp.q.n());
            Bundle bundle = new Bundle();
            bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new rv.s());
            bundle.putInt("api_sdk_version", 7814);
            com.byazt.vf.rv rvVar = (com.byazt.vf.rv) com.byazt.qp.q.n("boost");
            if (rvVar != null) {
                objN = rvVar.n(bundle);
                str = null;
            } else {
                str = "service null";
                objN = null;
            }
            if (objN == null) {
                if (str == null) {
                    str = "getNewInstance null";
                }
                w.n(4206, str, false, null, null);
            }
            return new com.byazt.vx.q((Function) objN);
        } catch (Throwable th) {
            com.byazt.vx.w.n(th);
            w.n(4206, th.getMessage(), false, null, th);
            com.byazt.vx.w.l("_tt_ad_sdk_", "Get direct initializer failed", th);
            return null;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1178, 765})
    private class qg implements Function<SparseArray<Object>, Object> {
        private qg() {
        }

        public ValueSet n(int i, Result result) {
            com.byazt.vx.w.s("bstsdk", "Load p_init: " + result.code() + ", message: " + result.message());
            if (result.isSuccess()) {
                if (tj.this.q != null) {
                    tj tjVar = tj.this;
                    tjVar.s = tjVar.qg;
                    tj tjVar2 = tj.this;
                    tjVar2.qg = tjVar2.q;
                    tj tjVar3 = tj.this;
                    tjVar3.n(tjVar3.qg.getManager(), true);
                    tj.this.n(2, result);
                }
            } else {
                com.byazt.vx.w.l("_tt_ad_sdk_", "pl init failed, code: " + result.code() + ", msg: " + result.message());
                w.n(result.code(), result.message(), !tj.this.x, null, null);
            }
            if (!tj.this.x) {
                com.byazt.vx.w.s("_tt_ad_sdk_", "pl init callback, !isNonPlInit, finishInit");
                tj.this.qg(result);
            } else if (result.isSuccess() && tj.this.n(true) > 0) {
                com.byazt.vx.w.s("_tt_ad_sdk_", "pl init callback, bst delayed, pl finished first, finishInit");
                tj.this.qg(result);
            }
            if (result.isSuccess()) {
                l.n();
            }
            return null;
        }

        @Override // java.util.function.Function
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            if (sparseArray == null) {
                return null;
            }
            ValueSet valueSetQg = com.byazt.qvu.s.n(sparseArray).qg();
            int iIntValue = valueSetQg.intValue(-99999987);
            SparseArray sparseArray2 = (SparseArray) valueSetQg.objectValue(-99999979, SparseArray.class);
            if (sparseArray2 != null) {
                ValueSet valueSetQg2 = com.byazt.qvu.s.n((SparseArray<Object>) sparseArray2).qg();
                n(iIntValue, com.byazt.qvu.qg.n().n(valueSetQg2.intValue(-999900)).n(valueSetQg2.stringValue(-999901)).n(valueSetQg2.booleanValue(-999903)).n(com.byazt.qvu.s.n((SparseArray<Object>) valueSetQg2.objectValue(-999902, SparseArray.class)).qg()).qg());
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(x xVar, com.byazt.qvu.s sVar) {
        fi fiVar;
        if (this.q == null || !this.q.isInitSuccess()) {
            if (!w() && (fiVar = (fi) com.byazt.qp.q.n("strategy")) != null && fiVar.n("com.byted.pangle") == 2) {
                com.byazt.vx.w.q("_tt_ad_sdk_", "loadPlugin, plugin not update, return");
                if (this.x) {
                    return;
                }
                qg(com.byazt.qvu.qg.n().n(false).n(4206).n("plugin not update by strategy").qg());
                return;
            }
            com.byazt.qvu.s sVarN = com.byazt.qvu.s.n(sVar.qg().sparseArray());
            sVarN.n(15, new qg());
            try {
                if (this.q == null) {
                    synchronized (s.class) {
                        if (this.q == null) {
                            Initializer initializerN = s.n.n(xVar);
                            this.q = initializerN;
                            n(initializerN, xVar, sVarN);
                        }
                    }
                }
            } catch (Exception e) {
                int iN = e instanceof q ? ((q) e).n() : 4206;
                com.byazt.vx.w.l("_tt_ad_sdk_", "loadPl failed, code: " + iN + ", msg: " + e.getMessage());
                w.n(iN, e.getMessage(), true, xVar, e);
                if (this.x) {
                    return;
                }
                qg(com.byazt.qvu.qg.n().n(false).n(4206).n(e.getMessage()).qg());
            }
        }
    }

    private void n(Manager manager, Result result) {
        if (manager == null || !(manager instanceof com.byazt.vx.s)) {
            return;
        }
        Function<SparseArray<Object>, Object> functionN = ((com.byazt.vx.s) manager).n(1);
        if (functionN instanceof Function) {
            com.byazt.vx.w.s("_tt_ad_sdk_", "quitWork, notify bst manager to quit");
            functionN.apply(com.byazt.qvu.s.n(1).n(-99999987, 16).n(-99999985, Void.class).n(17, true).n(21, result.values() == null ? null : result.values().sparseArray()).qg().sparseArray());
        }
    }

    private static void n(Initializer initializer, x xVar, com.byazt.qvu.s sVar) throws q {
        if (initializer != null) {
            try {
                xVar.n();
                JSONObject jSONObject = new JSONObject();
                xVar.n(jSONObject, 20L);
                jSONObject.put("zeus", rv.n(TTAppContextHolder.getContext()).n());
                initializer.init(TTAppContextHolder.getContext(), sVar.n(9, jSONObject).qg());
                if (TTAppContextHolder.getContext() != null) {
                    Zeus.hookHuaWeiVerifier((Application) TTAppContextHolder.getContext().getApplicationContext());
                }
                com.byazt.vx.w.qg("_tt_ad_sdk_", "Initialized done");
                return;
            } catch (Exception e) {
                Zeus.unInstallPlugin("com.byted.pangle");
                throw new q(4207, "Init error", e);
            }
        }
        throw new q(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED, "initializer null");
    }

    @com.byazt.cp.n(n = {0, 1, 1178, 1722})
    private static final class s {
        public static final s n = new s();
        public volatile Initializer qg;

        private s() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Initializer n(x xVar) throws q {
            if (this.qg == null) {
                synchronized (this) {
                    if (this.qg == null) {
                        this.qg = qg(xVar);
                    }
                }
            }
            return this.qg;
        }

        private static Initializer qg(x xVar) throws q {
            try {
                Plugin plugin = Zeus.getPlugin("com.byted.pangle");
                xVar.qg("call_create_initializer");
                plugin.setApiBridge(com.byazt.ja.q.n());
                if (rv.n(TTAppContextHolder.getContext()).n(xVar, BaseConstants.Time.MINUTE) == null) {
                    throw new q(4205, "Get ClassLoader failed");
                }
                Function pluginBridge = plugin.getPluginBridge();
                if (pluginBridge == null) {
                    throw new q(4206, "Get Bridge failed");
                }
                xVar.qg("get_bridge_cost");
                SparseArray sparseArray = new SparseArray();
                Bundle bundle = new Bundle();
                bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new rv.s());
                bundle.putInt("api_sdk_version", 7814);
                sparseArray.put(0, bundle);
                sparseArray.put(-99999987, 1);
                xVar.qg("create_bundle_cost");
                Object objApply = pluginBridge.apply(sparseArray);
                if (objApply == null) {
                    throw new q(4206, "Get Initializer null");
                }
                xVar.qg("get_init_method_cost");
                try {
                    com.byazt.vx.q qVar = new com.byazt.vx.q((Function) objApply);
                    xVar.qg("get_init_instance_cost");
                    com.byazt.vx.w.qg("TTPluginManager", "Create initializer success");
                    return qVar;
                } catch (Throwable th) {
                    Zeus.unInstallPlugin("com.byted.pangle");
                    throw th;
                }
            } catch (Throwable th2) {
                if (th2 instanceof q) {
                    throw th2;
                }
                throw new q(4206, "Create initializer failed", th2);
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1178, 855})
    private static final class n extends com.byazt.vx.n.s {
        private n() {
        }

        @Override // com.byazt.vx.n.s
        public void n(Throwable th) {
            rv.n(th);
        }

        @Override // com.byazt.vx.n.s
        public Object n(Object obj) {
            boolean z = obj instanceof TTPluginListener;
            if (z) {
                rv.n(TTAppContextHolder.getContext()).n((TTPluginListener) obj);
            }
            if (z) {
                TTPluginListener tTPluginListener = (TTPluginListener) obj;
                return rv.n(TTAppContextHolder.getContext()).n(tTPluginListener.packageName(), tTPluginListener.config());
            }
            if (obj instanceof ILiveAdCustomConfig) {
                return com.byazt.ea.s.n((ILiveAdCustomConfig) obj);
            }
            if (com.byazt.mp.qg.n(obj)) {
                return new com.byazt.mp.qg(obj);
            }
            return obj instanceof TTAdInteractionListener ? new com.byazt.io.qg((TTAdInteractionListener) obj) : obj;
        }
    }

    private boolean w() {
        fs();
        return this.fs == 1;
    }

    private boolean x() {
        fs();
        return this.fs == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long n(boolean z) {
        fs();
        if (this.fs != 0 || !z) {
            return 0L;
        }
        if (this.rv < 0) {
            try {
                this.rv = this.w.getLong("bstlayer_init_delay_time", 0L);
            } catch (Throwable unused) {
                this.rv = 0L;
            }
        }
        return this.rv;
    }

    private void fs() {
        if (this.fs == Integer.MIN_VALUE) {
            if (this.w == null) {
                this.w = com.byazt.qyu.qg.qg(TTAppContextHolder.getContext(), "sp_bidding_opt_libra", 0);
            }
            int i = this.w.getInt("bst_pl_exec_conf", -1);
            this.fs = i;
            if (i >= 0) {
                return;
            }
            this.fs = this.w.getInt("_use_pl_", 0);
        }
    }

    @Override // com.byazt.vx.n
    public void n(int i, Result result) {
        int iIntValue = -1;
        try {
            hu huVar = (hu) com.byazt.qp.q.n("m_d_s");
            if (huVar != null) {
                synchronized (this.cp) {
                    try {
                        Object objN = huVar.n(3);
                        iIntValue = objN instanceof Integer ? ((Integer) objN).intValue() : -1;
                        if (iIntValue < 0) {
                            huVar.n(3, Integer.valueOf(i));
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable th2) {
            com.byazt.vx.w.q("_tt_ad_sdk_", th2.getMessage());
        }
        if (i == 2 || iIntValue == 2) {
            Initializer initializer = this.s;
            if (this.x && initializer != null && initializer.isInitSuccess()) {
                n(initializer.getManager(), result);
                this.s = null;
            }
        }
    }
}
