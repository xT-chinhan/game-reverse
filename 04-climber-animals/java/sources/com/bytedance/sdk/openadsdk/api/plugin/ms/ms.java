package com.bytedance.sdk.openadsdk.api.plugin.ms;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.ms.ms.ms.ms.xr;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.plugin.ab;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final class ms implements Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ms f1820ms;

    public static ms ms() {
        if (f1820ms == null) {
            synchronized (ms.class) {
                if (f1820ms == null) {
                    f1820ms = new ms();
                }
            }
        }
        return f1820ms;
    }

    private Plugin ms(ValueSet valueSet) {
        if (valueSet == null) {
            return null;
        }
        String strStringValue = valueSet.stringValue(0);
        if (TextUtils.isEmpty(strStringValue)) {
            return null;
        }
        return Zeus.getPlugin(strStringValue);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0097  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a4  */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        String strMs;
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetXr = xr.ms(sparseArray).xr();
        int iIntValue = valueSetXr.intValue(-99999987);
        if (iIntValue != -99999986) {
            if (iIntValue != 13) {
                switch (iIntValue) {
                    case 4:
                        return Zeus.getPlugin(valueSetXr.stringValue(0)).mClassLoader;
                    case 5:
                        return Boolean.valueOf(Zeus.loadPlugin(valueSetXr.stringValue(0)));
                    case 6:
                        return Boolean.valueOf(Zeus.isPluginInstalled(valueSetXr.stringValue(0)));
                    case 7:
                        return Boolean.valueOf(Zeus.isPluginLoaded(valueSetXr.stringValue(0)));
                    case 8:
                        String strStringValue = valueSetXr.stringValue(0);
                        if (TextUtils.isEmpty(strStringValue)) {
                            strMs = "";
                        } else {
                            strMs = ab.ms(strStringValue);
                            if (TextUtils.isEmpty(strMs)) {
                                strMs = ab.xr(strStringValue);
                            }
                        }
                        return TextUtils.isEmpty(strMs) ? "0.0.0.0" : strMs;
                    default:
                        switch (iIntValue) {
                            case 100:
                                Zeus.unInstallPlugin(valueSetXr.stringValue(0));
                                return null;
                            case 101:
                                Plugin pluginMs = ms(valueSetXr);
                                if (pluginMs != null) {
                                    return Integer.valueOf(pluginMs.getApiVersionCode());
                                }
                                return null;
                            case 102:
                                Plugin pluginMs2 = ms(valueSetXr);
                                if (pluginMs2 != null) {
                                    return Integer.valueOf(pluginMs2.getInternalVersionCode());
                                }
                                return null;
                            case 103:
                                Plugin pluginMs3 = ms(valueSetXr);
                                if (pluginMs3 != null) {
                                    return Integer.valueOf(pluginMs3.getVersion());
                                }
                                return null;
                            case 104:
                                return Boolean.valueOf(Zeus.isPluginLoaded(valueSetXr.stringValue(0)));
                            case 105:
                                return Boolean.valueOf(Zeus.isPluginInstalled(valueSetXr.stringValue(0)));
                            case 106:
                                TTPluginListener tTPluginListener = (TTPluginListener) valueSetXr.objectValue(0, TTPluginListener.class);
                                if (tTPluginListener != null) {
                                    ab.ms(TTAppContextHolder.getContext()).xr(tTPluginListener);
                                }
                                return null;
                            default:
                                return null;
                        }
                }
            }
            Plugin pluginMs4 = ms(valueSetXr);
            if (pluginMs4 != null) {
                return pluginMs4.getJsonConfig();
            }
        }
        return xr.ms().ms(10000, 4).xr().sparseArray();
    }
}
