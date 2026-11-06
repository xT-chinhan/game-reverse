package com.byazt.vyf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import com.anythink.core.common.f.e;
import com.byazt.ms.rv;
import com.byazt.nf.tj;
import com.byazt.qyu.PluginConstants;
import com.byazt.vf.k;
import com.byazt.wq.EcBackUpWebView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kwad.sdk.api.model.AdnName;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 21})
public class x implements Function<SparseArray<Object>, Object> {
    public final PluginValueSet n = com.byazt.qvu.n.n().n(11, new Supplier<Integer>() { // from class: com.byazt.vyf.x.1
        @Override // java.util.function.Supplier
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public Integer get() {
            return Integer.valueOf(s.cy().dh());
        }
    }).n(12, "7.8.1.4").qg();

    public void n(Object obj) {
        if (s.cy().sh()) {
            q(obj);
        }
        if (obj instanceof Bundle) {
            Bundle bundle = (Bundle) obj;
            if (bundle.containsKey(PluginConstants.KEY_PL_CONFIG_INFO)) {
                s.cy().n(bundle.getBundle(PluginConstants.KEY_PL_CONFIG_INFO));
                if (s.cy().ae().length() == 0 || com.byazt.jc.n.qg()) {
                    return;
                }
                com.byazt.ph.qg.n().qg();
                return;
            }
            return;
        }
        if (obj instanceof Function) {
            Function<SparseArray<Object>, Object> function = (Function) obj;
            Object objApply = function.apply(com.byazt.of.qg.n().n(-2147483647).n(String.class).qg());
            if ((objApply instanceof String) && "TTAdInteractionListener".equals(objApply)) {
                s(new com.byazt.mi.qg(function));
                return;
            } else if (!com.byazt.lpr.s.qg(obj)) {
                n(function);
                return;
            }
        }
        if ((tj.fs() || com.byazt.vgx.w.fs().equals("com.pangolin_demo.toutiao")) && obj != null) {
            com.byazt.lpr.s.n(obj);
        }
        if (tj.l >= 7400 || !(obj instanceof TTAdInteractionListener)) {
            return;
        }
        s(new com.byazt.mi.qg(new com.byazt.myr.l((TTAdInteractionListener) obj)));
    }

    private void s(Object obj) {
        s.cy().fi().apply(com.byazt.of.qg.n().n(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPENED_TIME).n(0, new com.byazt.ikv.s().n(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, obj)).n(Void.class).qg());
    }

    @DungeonFlag
    private void q(Object obj) {
        if (obj instanceof Function) {
            Function function = (Function) obj;
            if (n(function, "qa_common_tool")) {
                com.byazt.twu.q.n((Function<SparseArray<Object>, Object>) function);
                com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
                qgVarN.n(10002).n(Void.class);
                qgVarN.n(20002, com.byazt.twu.q.n());
                function.apply(qgVarN.qg());
            }
        }
    }

    private boolean n(Function function, String str) {
        com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
        qgVarN.n(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1).n(String.class);
        return str.equals(function.apply(qgVarN.qg()));
    }

    public com.byazt.yn.n n(Context context) {
        return new com.byazt.yn.n(context);
    }

    public SparseArray<Object> n() {
        return this.n.sparseArray();
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
            int iIntValue = pluginValueSetQg.intValue(-99999987);
            if (iIntValue == -99999986) {
                PluginValueSet pluginValueSet = this.n;
                if (pluginValueSet != null) {
                    return pluginValueSet.sparseArray();
                }
            } else {
                if (iIntValue == -999800) {
                    return new com.byazt.yn.n((Context) pluginValueSetQg.objectValue(-998000, Context.class));
                }
                if (iIntValue == 16) {
                    s.cy().n(pluginValueSetQg.booleanValue(17, false), (SparseArray<Object>) pluginValueSetQg.objectValue(21, SparseArray.class));
                    return null;
                }
                if (iIntValue == 19) {
                    Bundle bundle = (Bundle) pluginValueSetQg.objectValue(20, Bundle.class);
                    if (bundle != null) {
                        int i = bundle.getInt("event_id", -1);
                        int i2 = bundle.getInt("event_type", -1);
                        String string = bundle.getString("package_name");
                        String strQ = ((k) com.byazt.qp.q.n("encrypt_service")).q(bundle.getString("event_token"));
                        com.byazt.esa.n nVar = new com.byazt.esa.n();
                        try {
                            JSONObject jSONObject = new JSONObject(strQ);
                            nVar.w(jSONObject.optString("tag"));
                            nVar.x(jSONObject.optString(e.a.d));
                            nVar.q(jSONObject.optString("log_extra"));
                            nVar.rv(jSONObject.optString(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL));
                            nVar.fs(jSONObject.optString("save_path"));
                        } catch (JSONException unused) {
                        }
                        nVar.n(i);
                        nVar.s(string);
                        return rv.n(nVar, i2);
                    }
                    return new Bundle();
                }
                if (iIntValue == 999801) {
                    return this;
                }
                switch (iIntValue) {
                    case 1:
                        n(pluginValueSetQg != null ? pluginValueSetQg.intValue(11) : -1);
                        break;
                    case 2:
                        return n(com.byazt.qvu.n.n(pluginValueSetQg).qg(), pluginValueSetQg.booleanValue(13), pluginValueSetQg.intValue(14));
                    case 3:
                        qg((Context) pluginValueSetQg.objectValue(7, Context.class));
                        break;
                    case 4:
                        n(pluginValueSetQg.objectValue(8, Object.class));
                        break;
                    case 5:
                        qg(pluginValueSetQg.objectValue(8, Function.class));
                        break;
                    case 6:
                        return n((Class) pluginValueSetQg.objectValue(9, Class.class), (Bundle) pluginValueSetQg.objectValue(10, Bundle.class));
                    default:
                        return null;
                }
            }
        }
        return null;
    }

    private void n(Function<SparseArray<Object>, Object> function) {
        if (function != null && com.byazt.qvu.n.n(com.byazt.of.n.n(function)).qg().intValue(10000) == 1 && tj.fs()) {
            com.byazt.wq.qg.n().n(function);
        }
    }

    public void qg(Object obj) {
        if ((tj.fs() || com.byazt.vgx.w.fs().equals("com.pangolin_demo.toutiao")) && obj != null) {
            com.byazt.lpr.s.s(obj);
        }
    }

    /* JADX WARN: Type inference failed for: r6v13, types: [T, java.util.HashMap, java.util.Map] */
    public <T> T n(Class<T> cls, Bundle bundle) {
        if (bundle != null) {
            bundle.getInt("type");
        }
        if (com.byazt.lpr.q.n(cls, bundle)) {
            return (T) com.byazt.lpr.q.n(com.byazt.byp.w.n(com.byazt.nf.rv.getContext()), cls, bundle);
        }
        boolean z = false;
        if (cls == SparseArray.class || (cls != null && "com.bytedance.sdk.openadsdk.AdConfig".equals(cls.getName()))) {
            if (bundle != null && !bundle.keySet().isEmpty()) {
                if (bundle.containsKey("is_paid")) {
                    s.cy().l(bundle.getBoolean("is_paid"));
                }
                if (bundle.containsKey("extra_data")) {
                    s.cy().x(bundle.getString("extra_data"));
                }
                if (bundle.containsKey("keywords")) {
                    s.cy().fs(bundle.getString("keywords"));
                }
                if (bundle.containsKey("quit_work")) {
                    s.cy().n(bundle.getBoolean("quit_work", false), (SparseArray<Object>) null);
                }
            }
        } else if (cls == Bundle.class) {
            if (bundle == null) {
                return null;
            }
            int i = bundle.getInt("action", 0);
            if (i == 0) {
                s.cy().n(bundle.getString("plugin_pkg_name"), bundle.getString(PluginConstants.KEY_PLUGIN_VERSION));
            } else if (i == 1) {
                com.byazt.eji.s.n().qg(bundle.getString("event_name"), bundle.getString("event_extra"));
            } else if (i == 2) {
                qg();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(MediationConstant.RIT_TYPE_SPLASH, 0);
                    jSONObject.put("reward", 0);
                    jSONObject.put("brand", 0);
                    jSONObject.put(AdnName.OTHER, 0);
                    com.byazt.lhs.n.n(jSONObject);
                    com.byazt.ql.qg.n(0).l();
                    com.byazt.lhs.n.n(com.byazt.nf.rv.qg().ev());
                } catch (Throwable th) {
                    com.byazt.tk.k.n(th.getMessage());
                }
            }
        } else {
            if (cls == View.class) {
                return (T) new EcBackUpWebView(com.byazt.nf.rv.getContext());
            }
            if (cls == Map.class) {
                ?? r6 = (T) new HashMap();
                if (bundle != null && bundle.getString("extra_name").equals("use_mediation_map")) {
                    if (com.byazt.bfv.n.qg() && com.byazt.nf.rv.qg().vg() && com.byazt.bfv.n.n()) {
                        z = true;
                    }
                    r6.put("use_mediation_map", Boolean.valueOf(z));
                }
                return r6;
            }
            if (cls == Function.class && bundle != null && bundle.getInt("action", 0) == 4) {
                return (T) com.byazt.lq.q.n();
            }
        }
        return null;
    }

    public void qg(Context context) {
        if (context == null) {
            return;
        }
        com.byazt.zq.q qVarA = s.cy().a();
        if (qVarA != null) {
            boolean zN = qVarA.n();
            boolean zQ = qVarA.q();
            boolean zFs = qVarA.fs();
            if (!zN && !zQ && !zFs) {
                return;
            }
        }
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 2);
        if (context != null) {
            com.byazt.tk.n.n(context, intent, null);
        }
    }

    public String n(PluginValueSet pluginValueSet, boolean z, int i) {
        if (pluginValueSet == null || com.byazt.nf.rv.n() == null) {
            return null;
        }
        return com.byazt.nf.rv.n().n(new com.byazt.zq.qg(pluginValueSet.sparseArray(), com.byazt.vgx.s.qg()), z, i);
    }

    public void n(int i) {
        if (i != s.cy().dh()) {
            s.cy().l(i);
            Intent intent = new Intent();
            intent.setAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
            intent.putExtra("theme_status_change", i);
            com.byazt.nf.rv.getContext().sendBroadcast(intent, com.byazt.vgx.w.t());
        }
    }

    public void qg() {
        com.byazt.lk.l.n(com.byazt.vgx.s.q(), "open_ad_sdk_union_meta_cache_kv", 0, null).n();
        com.byazt.mz.q.q();
    }
}
