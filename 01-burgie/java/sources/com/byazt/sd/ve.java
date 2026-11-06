package com.byazt.sd;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import com.byazt.eg.EcBackUpWebView;
import com.byazt.mg.PluginConstants;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM})
public class ve implements Function<SparseArray<Object>, Object> {
    public final PluginValueSet pr = com.byazt.ij.pr.pr().pr(11, new Supplier<Integer>() { // from class: com.byazt.sd.ve.1
        @Override // java.util.function.Supplier
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public Integer get() {
            return Integer.valueOf(zo.nt().nw());
        }
    }).pr(12, "7.7.1.4").hw();

    public void pr(Object obj) {
        if (zo.nt().i()) {
            x(obj);
        }
        if (obj instanceof Bundle) {
            Bundle bundle = (Bundle) obj;
            if (bundle.containsKey(PluginConstants.KEY_PL_CONFIG_INFO)) {
                zo.nt().pr(bundle.getBundle(PluginConstants.KEY_PL_CONFIG_INFO));
                if (zo.nt().e().length() != 0 && !com.byazt.wt.g.hw()) {
                    com.byazt.gc.hw.hw().hn();
                    return;
                }
                return;
            }
            return;
        }
        if (obj instanceof Function) {
            Function<SparseArray<Object>, Object> function = (Function) obj;
            Object objApply = function.apply(com.byazt.xi.hw.pr().pr(-2147483647).pr(String.class).hw());
            if ((objApply instanceof String) && "TTAdInteractionListener".equals(objApply)) {
                hn(new com.byazt.rkl.hw(function));
                return;
            } else if (!com.byazt.nq.pr.hw(obj)) {
                pr(function);
                return;
            }
        }
        if ((iu.fw() || ls.zo().equals("com.pangolin_demo.toutiao")) && obj != null) {
            com.byazt.nq.pr.pr(obj);
        }
        if (iu.x < 7400 && (obj instanceof TTAdInteractionListener)) {
            hn(new com.byazt.rkl.hw(new com.byazt.qp.c((TTAdInteractionListener) obj)));
        }
    }

    private void hn(Object obj) {
        zo.nt().ls().apply(com.byazt.xi.hw.pr().pr(162).pr(0, new com.byazt.wt.ww().pr("listener", obj)).pr(Void.class).hw());
    }

    @DungeonFlag
    private void x(Object obj) {
        if (obj instanceof Function) {
            Function function = (Function) obj;
            if (pr(function, "qa_common_tool")) {
                com.byazt.pr.hn.pr((Function<SparseArray<Object>, Object>) function);
                com.byazt.xi.hw hwVarPr = com.byazt.xi.hw.pr();
                hwVarPr.pr(AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS).pr(Void.class);
                hwVarPr.pr(20002, com.byazt.pr.hn.pr());
                function.apply(hwVarPr.hw());
            }
        }
    }

    private boolean pr(Function function, String str) {
        com.byazt.xi.hw hwVarPr = com.byazt.xi.hw.pr();
        hwVarPr.pr(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1).pr(String.class);
        return str.equals(function.apply(hwVarPr.hw()));
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
            switch (pluginValueSetHw.intValue(-99999987)) {
                case -99999986:
                    PluginValueSet pluginValueSet = this.pr;
                    if (pluginValueSet != null) {
                        return pluginValueSet.sparseArray();
                    }
                    return null;
                case -999800:
                    return new gz((Context) pluginValueSetHw.objectValue(-998000, Context.class));
                case 1:
                    pr(pluginValueSetHw != null ? pluginValueSetHw.intValue(11) : -1);
                    break;
                case 2:
                    return pr(com.byazt.ij.pr.pr(pluginValueSetHw).hw(), pluginValueSetHw.booleanValue(13), pluginValueSetHw.intValue(14));
                case 3:
                    pr((Context) pluginValueSetHw.objectValue(7, Context.class));
                    break;
                case 4:
                    pr(pluginValueSetHw.objectValue(8, Object.class));
                    break;
                case 5:
                    hw(pluginValueSetHw.objectValue(8, Function.class));
                    break;
                case 6:
                    return pr((Class) pluginValueSetHw.objectValue(9, Class.class), (Bundle) pluginValueSetHw.objectValue(10, Bundle.class));
                case 16:
                    zo.nt().pr(pluginValueSetHw.booleanValue(17, false), (SparseArray<Object>) pluginValueSetHw.objectValue(21, SparseArray.class));
                    return null;
                case 19:
                    Bundle bundle = (Bundle) pluginValueSetHw.objectValue(20, Bundle.class);
                    if (bundle != null) {
                        int i = bundle.getInt("event_id", -1);
                        int i2 = bundle.getInt("event_type", -1);
                        String string = bundle.getString("package_name");
                        String strX = ((com.byazt.vkw.nt) com.byazt.zs.uc.pr("encrypt_service")).x(bundle.getString("event_token"));
                        com.byazt.vo.pr prVar = new com.byazt.vo.pr();
                        try {
                            JSONObject jSONObject = new JSONObject(strX);
                            prVar.uc(jSONObject.optString("tag"));
                            prVar.fw(jSONObject.optString(Constants.VALUE_FIELD));
                            prVar.x(jSONObject.optString("log_extra"));
                            prVar.aj(jSONObject.optString("download_url"));
                            prVar.zo(jSONObject.optString("save_path"));
                            break;
                        } catch (JSONException e) {
                        }
                        prVar.pr(i);
                        prVar.hn(string);
                        return com.byazt.lm.ho.pr(prVar, i2);
                    }
                    return new Bundle();
                case 999801:
                    return this;
                default:
                    return null;
            }
        }
        return null;
    }

    private void pr(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
        }
        switch (com.byazt.ij.pr.pr(com.byazt.xi.pr.pr(function)).hw().intValue(10000)) {
            case 1:
                if (iu.fw()) {
                    com.byazt.eg.hw.pr().pr(function);
                }
                break;
        }
    }

    public void hw(Object obj) {
        if ((iu.fw() || ls.zo().equals("com.pangolin_demo.toutiao")) && obj != null) {
            com.byazt.nq.pr.hn(obj);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Type inference failed for: r5v13, types: [T, java.util.HashMap, java.util.Map] */
    public <T> T pr(Class<T> cls, Bundle bundle) {
        if (bundle != null) {
            bundle.getInt("type");
        }
        if (com.byazt.nq.hw.pr(cls, bundle)) {
            return (T) com.byazt.nq.hw.pr(com.byazt.iy.uc.pr(a.getContext()), cls, bundle);
        }
        boolean z = false;
        if (cls == SparseArray.class || (cls != null && "com.bytedance.sdk.openadsdk.AdConfig".equals(cls.getName()))) {
            if (bundle != null && !bundle.keySet().isEmpty()) {
                if (bundle.containsKey("is_paid")) {
                    zo.nt().c(bundle.getBoolean("is_paid"));
                }
                if (bundle.containsKey("extra_data")) {
                    zo.nt().fw(bundle.getString("extra_data"));
                }
                if (bundle.containsKey("keywords")) {
                    zo.nt().zo(bundle.getString("keywords"));
                }
                if (bundle.containsKey("quit_work")) {
                    zo.nt().pr(bundle.getBoolean("quit_work", false), (SparseArray<Object>) null);
                }
            }
        } else {
            if (cls != Bundle.class) {
                if (cls == View.class) {
                    return (T) new EcBackUpWebView(a.getContext());
                }
                if (cls == Map.class) {
                    ?? r5 = (T) new HashMap();
                    if (bundle != null && bundle.getString("extra_name").equals("use_mediation_map")) {
                        if (com.byazt.b.pr.hw() && a.hw().id() && com.byazt.b.pr.pr()) {
                            z = true;
                        }
                        r5.put("use_mediation_map", Boolean.valueOf(z));
                    }
                    return r5;
                }
                if (cls != Function.class || bundle == null) {
                    return null;
                }
                switch (bundle.getInt("action", 0)) {
                    case 4:
                        return (T) com.byazt.hs.x.pr();
                }
            }
            if (bundle == null) {
                return null;
            }
            switch (bundle.getInt("action", 0)) {
                case 0:
                    zo.nt().pr(bundle.getString("plugin_pkg_name"), bundle.getString(PluginConstants.KEY_PLUGIN_VERSION));
                    break;
                case 1:
                    com.byazt.xk.hw.pr().hw(bundle.getString("event_name"), bundle.getString("event_extra"));
                    break;
                case 2:
                    pr();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(MediationConstant.RIT_TYPE_SPLASH, 0);
                        jSONObject.put("reward", 0);
                        jSONObject.put("brand", 0);
                        jSONObject.put("other", 0);
                        com.byazt.s.pr.pr(jSONObject);
                        com.byazt.zp.w.pr(0).c();
                        com.byazt.s.pr.pr(a.hw().tp());
                    } catch (Throwable th) {
                        com.byazt.ca.ho.pr(th.getMessage());
                    }
                    break;
            }
        }
        return null;
    }

    public void pr(Context context) {
        if (context == null) {
            return;
        }
        com.byazt.qe.x xVarA = zo.nt().a();
        if (xVarA != null) {
            boolean zPr = xVarA.pr();
            boolean zHn = xVarA.hn();
            boolean zC = xVarA.c();
            if (!zPr && !zHn && !zC) {
                return;
            }
        }
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 2);
        if (context != null) {
            com.byazt.ca.pr.pr(context, intent, null);
        }
    }

    public String pr(PluginValueSet pluginValueSet, boolean z, int i) {
        if (pluginValueSet == null || a.pr() == null) {
            return null;
        }
        return a.pr().pr(new com.byazt.qe.hw(pluginValueSet.sparseArray(), com.byazt.zb.pr.hw()), z, i);
    }

    public void pr(int i) {
        if (i != zo.nt().nw()) {
            zo.nt().c(i);
            Intent intent = new Intent();
            intent.setAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
            intent.putExtra("theme_status_change", i);
            a.getContext().sendBroadcast(intent, ls.iu());
        }
    }

    public void pr() {
        com.byazt.wt.y.pr("open_ad_sdk_union_meta_cache_kv").pr();
        com.byazt.wt.y.pr("tt_materialMeta").pr();
        com.byazt.wt.y.pr("tt_splash").pr();
    }
}
