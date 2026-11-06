package com.byazt.fvm;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 464, 210})
public abstract class k extends fs {
    public static final String REWARD_EXTRA_KEY_ERROR_CODE = "reward_extra_key_error_code";
    public static final String REWARD_EXTRA_KEY_ERROR_MSG = "reward_extra_key_error_msg";
    public static final String REWARD_EXTRA_KEY_HAS_VIDEO_COMPLETE_REWARD = "reward_extra_key_has_video_complete_reward";
    public static final String REWARD_EXTRA_KEY_IS_SERVER_VERIFY = "reward_extra_key_is_server_verify";
    public static final String REWARD_EXTRA_KEY_REWARD_AMOUNT = "reward_extra_key_reward_amount";
    public static final String REWARD_EXTRA_KEY_REWARD_NAME = "reward_extra_key_reward_name";
    public static final String REWARD_EXTRA_KEY_REWARD_PROPOSE = "reward_extra_key_reward_propose";
    public static final int REWARD_TYPE_CLICK_LANDING = 4;
    public static final int REWARD_TYPE_DEFAULT = 0;
    public static final int REWARD_TYPE_INTERACT = 1;
    public static final int REWARD_TYPE_PLAYABLE = 3;
    public static final int REWARD_TYPE_VIDEO_COMPLETE = 2;
    public PluginValueSet n;

    public abstract com.byazt.nq.w l();

    public abstract int n();

    public abstract void n(Activity activity);

    public abstract void n(Activity activity, Object obj, String str);

    public abstract void n(com.byazt.mi.s sVar);

    public abstract void n(com.byazt.tmn.n nVar);

    public abstract void n(com.byazt.tmn.qg qgVar);

    public abstract long q();

    public abstract Map<String, Object> qg();

    public abstract void qg(com.byazt.tmn.n nVar);

    public abstract int s();

    public PluginValueSet rv() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetW = w();
        this.n = pluginValueSetW;
        return pluginValueSetW;
    }

    private PluginValueSet w() {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
        nVarN.n(120001, new Supplier<Integer>() { // from class: com.byazt.fvm.k.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(k.this.n());
            }
        });
        nVarN.n(120002, new Supplier<Map<String, Object>>() { // from class: com.byazt.fvm.k.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return k.this.qg();
            }
        });
        nVarN.n(120003, new Supplier<Integer>() { // from class: com.byazt.fvm.k.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(k.this.s());
            }
        });
        nVarN.n(120004, new Supplier<Long>() { // from class: com.byazt.fvm.k.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Long get() {
                return Long.valueOf(k.this.q());
            }
        });
        return nVarN.qg();
    }

    @Override // com.byazt.fvm.fs, java.util.function.Function
    /* JADX INFO: renamed from: n */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        if (iIntValue == -99999986) {
            return rv().sparseArray();
        }
        if (iIntValue != 121109) {
            switch (iIntValue) {
                case 120101:
                    n(new com.byazt.tmn.n((Function) pluginValueSetQg.objectValue(0, Function.class)));
                    return null;
                case 120102:
                    qg(new com.byazt.tmn.n((Function) pluginValueSetQg.objectValue(0, Function.class)));
                    return null;
                case 120103:
                    n(new com.byazt.tmn.qg((Function) pluginValueSetQg.objectValue(0, Function.class)));
                    return null;
                case 120104:
                    n(new com.byazt.mi.s((Function) pluginValueSetQg.objectValue(0, Function.class)));
                    return null;
                case 120105:
                    n((Activity) pluginValueSetQg.objectValue(0, Activity.class));
                    return null;
                case 120106:
                    n((Activity) pluginValueSetQg.objectValue(0, Activity.class), pluginValueSetQg.objectValue(1, Object.class), (String) pluginValueSetQg.objectValue(2, String.class));
                    return null;
                default:
                    return super.apply(sparseArray);
            }
        }
        return l();
    }
}
