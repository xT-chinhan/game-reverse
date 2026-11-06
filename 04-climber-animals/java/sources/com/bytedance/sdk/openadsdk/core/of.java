package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ITTProvider;
import com.bytedance.sdk.openadsdk.TTC;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.live.EcBackUpWebView;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig;
import com.kwad.sdk.api.model.AdnName;
import com.tapsdk.tapad.constants.Constants;
import com.taptap.sdk.kit.internal.p000const.TrackAction;
import com.umeng.ccg.a;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class of implements Bridge, Manager, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ValueSet f3192ms = com.bykv.ms.ms.ms.ms.xr.ms().ms(11, new com.bykv.ms.ms.ms.ms.xr.ah() { // from class: com.bytedance.sdk.openadsdk.core.of.1
        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public Integer get() {
            return Integer.valueOf(ch.ub().l());
        }
    }).ms(12, "6.9.2.3").xr();

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Bridge getBridge(int i) {
        return this;
    }

    public void ms(Object obj) {
        if (obj instanceof TTDownloadEventLogger) {
            ch.ub().ms((TTDownloadEventLogger) obj);
            return;
        }
        if (obj instanceof Bundle) {
            Bundle bundle = (Bundle) obj;
            if (bundle.containsKey(PluginConstants.KEY_PL_CONFIG_INFO)) {
                ch.ub().ms(bundle.getBundle(PluginConstants.KEY_PL_CONFIG_INFO));
                if (ch.ub().of().length() == 0 || com.bytedance.sdk.openadsdk.core.jw.ub.xr()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.yu.ms.ms.ah().d();
                return;
            }
            return;
        }
        if (obj instanceof Bridge) {
            ms((Bridge) obj);
            return;
        }
        if (g.c() && (obj instanceof ILiveAdCustomConfig)) {
            com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(new ms((ILiveAdCustomConfig) obj));
            return;
        }
        if (obj instanceof ValueSet) {
            ValueSet valueSet = (ValueSet) obj;
            try {
                if (valueSet.intValue(0) == 1) {
                    ms((ClassLoader) valueSet.objectValue(2, ClassLoader.class), valueSet.stringValue(1));
                }
            } catch (Throwable unused) {
                Object[] objArr = new Object[1];
            }
        }
        if ((!g.c() && !com.bytedance.sdk.openadsdk.core.jw.f.ch().equals("com.pangolin_demo.toutiao")) || obj == null || ((TTC) obj.getClass().getAnnotation(TTC.class)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.ab.xr.ms(obj);
    }

    private void ms(ClassLoader classLoader, String str) throws Throwable {
        Method method;
        Class<?> clsLoadClass = classLoader.loadClass("com.bytedance.sdk.openadsdk.ats.AutoService");
        if (clsLoadClass == AutoService.class || (method = clsLoadClass.getMethod(TrackAction.INIT, Function.class)) == null) {
            return;
        }
        Function function = (Function) method.invoke(null, AutoService.init(null));
        if (function != null) {
            AutoService.init(function);
        }
        if (TextUtils.equals(str, "com.byted.csj.ext")) {
            com.bytedance.sdk.openadsdk.core.ab.ah.ms(re.xr().bz());
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Loader createLoader(Context context) {
        return new p(context);
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f3192ms;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i != 16) {
            switch (i) {
                case 1:
                    ms((valueSet != null ? Integer.valueOf(valueSet.intValue(11)) : null).intValue());
                    return null;
                case 2:
                    return cls.cast(ms(valueSet, valueSet.booleanValue(13), valueSet.intValue(14)));
                case 3:
                    ms(valueSet != null ? (Context) valueSet.objectValue(7, Context.class) : null);
                    return null;
                case 4:
                    ms(valueSet != null ? valueSet.objectValue(8, Object.class) : null);
                    return null;
                case 5:
                    xr(valueSet != null ? valueSet.objectValue(8, Object.class) : null);
                    return null;
                case 6:
                    return (T) ms(valueSet != null ? (Class) valueSet.objectValue(9, Class.class) : null, valueSet != null ? (Bundle) valueSet.objectValue(10, Bundle.class) : null);
                default:
                    return null;
            }
        }
        ch.ub().c(valueSet != null ? valueSet.booleanValue(17, false) : false);
        return null;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
            int iIntValue = valueSetXr.intValue(-99999987);
            if (iIntValue == -99999986) {
                ValueSet valueSet = this.f3192ms;
                if (valueSet != null) {
                    return valueSet.sparseArray();
                }
            } else {
                if (iIntValue == -999800) {
                    return new p((Context) valueSetXr.objectValue(-998000, Context.class));
                }
                if (iIntValue == 16) {
                    ch.ub().c(valueSetXr.booleanValue(17, false));
                    return null;
                }
                if (iIntValue == 999801) {
                    return this;
                }
                switch (iIntValue) {
                    case 1:
                        ms(valueSetXr != null ? valueSetXr.intValue(11) : -1);
                        break;
                    case 2:
                        return ms(com.bykv.ms.ms.ms.ms.xr.ms(valueSetXr).xr(), valueSetXr.booleanValue(13), valueSetXr.intValue(14));
                    case 3:
                        ms((Context) valueSetXr.objectValue(7, Context.class));
                        break;
                    case 4:
                        Object objObjectValue = valueSetXr.objectValue(8, Object.class);
                        if (objObjectValue instanceof Function) {
                            objObjectValue = new com.bytedance.sdk.openadsdk.core.f.ah(objObjectValue);
                        }
                        ms(objObjectValue);
                        break;
                    case 5:
                        Object objObjectValue2 = valueSetXr.objectValue(8, Object.class);
                        if (objObjectValue2 instanceof Function) {
                            objObjectValue2 = new com.bytedance.sdk.openadsdk.core.f.ah(objObjectValue2);
                        }
                        xr(objObjectValue2);
                        break;
                    case 6:
                        return ms((Class) valueSetXr.objectValue(9, Class.class), (Bundle) valueSetXr.objectValue(10, Bundle.class));
                    default:
                        return null;
                }
            }
        }
        return null;
    }

    public final class ms implements Bridge {
        private ILiveAdCustomConfig xr;

        public ms(ILiveAdCustomConfig iLiveAdCustomConfig) {
            this.xr = iLiveAdCustomConfig;
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return com.bykv.ms.ms.ms.ms.xr.ms().ms(10000, 1).xr();
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (i == 0) {
                return (T) Integer.valueOf(this.xr.openLR(valueSet.stringValue(0)));
            }
            if (i == 1) {
                return (T) this.xr.convertToEnterFromMerge(valueSet.intValue(0));
            }
            if (i == 2) {
                return (T) this.xr.convertToEnterMethod(valueSet.intValue(0), valueSet.booleanValue(1));
            }
            if (i == 3) {
                return (T) this.xr.invoke(valueSet.intValue(0), (Bundle) valueSet.objectValue(1, Bundle.class));
            }
            if (i != 4) {
                return null;
            }
            this.xr.onEventV3(valueSet.stringValue(0), (JSONObject) valueSet.objectValue(1, JSONObject.class));
            return null;
        }
    }

    private void ms(Bridge bridge) {
        if (bridge == null) {
            return;
        }
        ValueSet valueSetValues = bridge.values();
        if (valueSetValues == null) {
            ch.ub().ms(bridge);
        } else {
            if (valueSetValues.intValue(10000) == 1) {
                if (g.c()) {
                    com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(bridge);
                    return;
                }
                return;
            }
            ch.ub().ms(bridge);
        }
    }

    public void xr(Object obj) {
        if (obj instanceof TTDownloadEventLogger) {
            ch.ub().ms((TTDownloadEventLogger) null);
        }
        if ((!g.c() && !com.bytedance.sdk.openadsdk.core.jw.f.ch().equals("com.pangolin_demo.toutiao")) || obj == null || ((TTC) obj.getClass().getAnnotation(TTC.class)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.ab.xr.xr(obj);
    }

    /* JADX WARN: Type inference failed for: r8v13, types: [T, java.util.HashMap, java.util.Map] */
    public <T> T ms(Class<T> cls, Bundle bundle) {
        boolean z = false;
        int i = bundle != null ? bundle.getInt("type") : 0;
        if (cls == ITTProvider.class) {
            return (T) com.bytedance.sdk.openadsdk.core.multipro.c.ms(re.getContext());
        }
        if (cls == ValueSet.class || (cls != null && "com.bytedance.sdk.openadsdk.AdConfig".equals(cls.getName()))) {
            if (bundle != null && !bundle.keySet().isEmpty()) {
                if (bundle.containsKey("is_paid")) {
                    ch.ub().ka(bundle.getBoolean("is_paid"));
                }
                if (bundle.containsKey("extra_data")) {
                    ch.ub().ab(bundle.getString("extra_data"));
                }
                if (bundle.containsKey("keywords")) {
                    ch.ub().x(bundle.getString("keywords"));
                }
                if (bundle.containsKey("quit_work")) {
                    ch.ub().c(bundle.getBoolean("quit_work", false));
                }
            }
        } else {
            if (cls == ITTDownloadVisitor.class && i == 1) {
                return (T) com.bytedance.sdk.openadsdk.core.hi.ms.ms.ms();
            }
            if (cls == Bundle.class) {
                if (bundle == null) {
                    return null;
                }
                int i2 = bundle.getInt(a.z, 0);
                if (i2 == 0) {
                    ch.ub().ms(bundle.getString("plugin_pkg_name"), bundle.getString(PluginConstants.KEY_PLUGIN_VERSION));
                } else if (i2 == 1) {
                    com.bytedance.sdk.openadsdk.core.t.u.ms().xr(bundle.getString("event_name"), bundle.getString("event_extra"));
                } else if (i2 == 2) {
                    ms();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("splash", 0);
                        jSONObject.put(Constants.AdTypeName.REWARD, 0);
                        jSONObject.put("brand", 0);
                        jSONObject.put(AdnName.OTHER, 0);
                        com.bykv.vk.openvk.component.video.ms.ms.ms(jSONObject);
                        com.bytedance.sdk.openadsdk.op.ny.ms(0).ka();
                        com.bykv.vk.openvk.component.video.ms.ms.ms(re.xr().mh());
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.sl.xr(th.getMessage());
                    }
                } else if (i2 == 3) {
                    com.bytedance.sdk.component.ch.ab.ms(-1);
                }
            } else if (cls == ExecutorService.class) {
                if (bundle != null) {
                    int i3 = bundle.getInt(a.z, 0);
                    if (i3 == 1) {
                        return (T) com.bytedance.sdk.component.ch.hi.xr.ch();
                    }
                    if (i3 == 2) {
                        return (T) com.bytedance.sdk.component.ch.hi.xr.ny();
                    }
                    if (i3 == 3) {
                        return (T) com.bytedance.sdk.component.ch.hi.xr.sl();
                    }
                    return (T) com.bytedance.sdk.component.ch.hi.xr.zb();
                }
            } else if (cls == Handler.class) {
                if (bundle != null && bundle.getInt(a.z, 0) == 1) {
                    return (T) com.bytedance.sdk.component.utils.x.ms();
                }
            } else {
                if (cls == View.class) {
                    return (T) new EcBackUpWebView(re.getContext());
                }
                if (cls == Map.class) {
                    ?? r8 = (T) new HashMap();
                    if (bundle != null && bundle.getString("extra_name").equals("use_mediation_map")) {
                        if (AdSdkInitializerHolder.isSdkInitSuccess() && re.xr().pl() && AdSdkInitializerHolder.hasDispatchAdSdkInitializer()) {
                            z = true;
                        }
                        r8.put("use_mediation_map", Boolean.valueOf(z));
                    }
                    return r8;
                }
                if ((cls == Bridge.class || cls == Function.class) && bundle != null && bundle.getInt(a.z, 0) == 4) {
                    return (T) com.bytedance.sdk.openadsdk.tools.ah.ms();
                }
            }
        }
        return null;
    }

    public void ms(Context context) {
        if (context == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.f.ka kaVarQv = ch.ub().qv();
        if (kaVarQv != null) {
            boolean zMs = kaVarQv.ms();
            boolean zAh = kaVarQv.ah();
            boolean zKa = kaVarQv.ka();
            if (!zMs && !zAh && !zKa) {
                return;
            }
        }
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra("type", 2);
        if (context != null) {
            com.bytedance.sdk.component.utils.xr.ms(context, intent, null);
        }
    }

    public String ms(ValueSet valueSet, boolean z, int i) {
        if (valueSet == null || re.ms() == null) {
            return null;
        }
        return re.ms().ms(new com.bytedance.sdk.openadsdk.ao.xr.ah.xr(valueSet), z, i);
    }

    public void ms(int i) {
        if (i != ch.ub().l()) {
            ch.ub().ka(i);
            Intent intent = new Intent();
            intent.setAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
            intent.putExtra("theme_status_change", i);
            re.getContext().sendBroadcast(intent, com.bytedance.sdk.openadsdk.core.jw.f.op());
        }
    }

    public void ms() {
        com.bytedance.sdk.openadsdk.core.jw.g.ms("open_ad_sdk_meta_cache_kv").ms();
        com.bytedance.sdk.openadsdk.core.jw.g.ms("tt_materialMeta").ms();
        com.bytedance.sdk.openadsdk.core.jw.g.ms("tt_splash").ms();
    }
}
