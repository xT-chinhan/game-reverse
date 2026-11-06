package com.byazt.mr;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 25, 19})
public abstract class ho extends zo {
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
    public PluginValueSet pr;

    public abstract com.byazt.wd.c c();

    public abstract Map<String, Object> fw();

    public abstract int hn();

    public abstract int hw();

    public abstract void hw(com.byazt.yg.pr prVar);

    public abstract void pr(Activity activity);

    public abstract void pr(Activity activity, Object obj, String str);

    public abstract void pr(com.byazt.rkl.hn hnVar);

    public abstract void pr(com.byazt.yg.hw hwVar);

    public abstract void pr(com.byazt.yg.pr prVar);

    public abstract long x();

    public PluginValueSet aj() {
        PluginValueSet pluginValueSet = this.pr;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetPr = pr();
        this.pr = pluginValueSetPr;
        return pluginValueSetPr;
    }

    private PluginValueSet pr() {
        com.byazt.ij.pr prVarPr = com.byazt.ij.pr.pr();
        prVarPr.pr(120001, new Supplier<Integer>() { // from class: com.byazt.mr.ho.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(ho.this.hw());
            }
        });
        prVarPr.pr(120002, new Supplier<Map<String, Object>>() { // from class: com.byazt.mr.ho.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return ho.this.fw();
            }
        });
        prVarPr.pr(120003, new Supplier<Integer>() { // from class: com.byazt.mr.ho.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(ho.this.hn());
            }
        });
        prVarPr.pr(120004, new Supplier<Long>() { // from class: com.byazt.mr.ho.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Long get() {
                return Long.valueOf(ho.this.x());
            }
        });
        return prVarPr.hw();
    }

    @Override // com.byazt.mr.zo, java.util.function.Function
    /* JADX INFO: renamed from: pr */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
        switch (pluginValueSetHw.intValue(-99999987)) {
            case -99999986:
                return aj().sparseArray();
            case 120101:
                pr(new com.byazt.yg.pr((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            case 120102:
                hw(new com.byazt.yg.pr((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            case 120103:
                pr(new com.byazt.yg.hw((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            case 120104:
                pr(new com.byazt.rkl.hn((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            case 120105:
                pr((Activity) pluginValueSetHw.objectValue(0, Activity.class));
                return null;
            case 120106:
                pr((Activity) pluginValueSetHw.objectValue(0, Activity.class), pluginValueSetHw.objectValue(1, Object.class), (String) pluginValueSetHw.objectValue(2, String.class));
                return null;
            case 121109:
                return c();
            default:
                return super.apply(sparseArray);
        }
    }
}
