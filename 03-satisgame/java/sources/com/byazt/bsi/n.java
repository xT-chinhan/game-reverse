package com.byazt.bsi;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.qvu.s;
import com.byazt.qyu.rv;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 755, 19})
public final class n implements Function<SparseArray<Object>, Object> {
    public static volatile n n;

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    private Plugin n(ValueSet valueSet) {
        if (valueSet == null) {
            return null;
        }
        String strStringValue = valueSet.stringValue(0);
        if (TextUtils.isEmpty(strStringValue)) {
            return null;
        }
        return Zeus.getPlugin(strStringValue);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b9  */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        String strN;
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetQg = s.n(sparseArray).qg();
        int iIntValue = valueSetQg.intValue(-99999987);
        if (iIntValue != -99999986) {
            if (iIntValue != 13) {
                if (iIntValue == 109) {
                    qg();
                } else {
                    if (iIntValue != 110) {
                        switch (iIntValue) {
                            case 4:
                                return Zeus.getPlugin(valueSetQg.stringValue(0)).mClassLoader;
                            case 5:
                                return Boolean.valueOf(Zeus.loadPlugin(valueSetQg.stringValue(0)));
                            case 6:
                                return Boolean.valueOf(Zeus.isPluginInstalled(valueSetQg.stringValue(0)));
                            case 7:
                                return Boolean.valueOf(Zeus.isPluginLoaded(valueSetQg.stringValue(0)));
                            case 8:
                                String strStringValue = valueSetQg.stringValue(0);
                                if (TextUtils.isEmpty(strStringValue)) {
                                    strN = "";
                                } else {
                                    strN = rv.n(strStringValue);
                                    if (TextUtils.isEmpty(strN)) {
                                        strN = rv.qg(strStringValue);
                                    }
                                }
                                return TextUtils.isEmpty(strN) ? "0.0.0.0" : strN;
                            default:
                                switch (iIntValue) {
                                    case 100:
                                        Zeus.unInstallPlugin(valueSetQg.stringValue(0), valueSetQg.intValue(1));
                                        return null;
                                    case 101:
                                        rv.n(TTAppContextHolder.getContext());
                                        Plugin pluginN = n(valueSetQg);
                                        if (pluginN != null) {
                                            return Integer.valueOf(pluginN.getApiVersionCode());
                                        }
                                        return null;
                                    case 102:
                                        Plugin pluginN2 = n(valueSetQg);
                                        if (pluginN2 != null) {
                                            return Integer.valueOf(pluginN2.getInternalVersionCode());
                                        }
                                        return null;
                                    case 103:
                                        Plugin pluginN3 = n(valueSetQg);
                                        if (pluginN3 != null) {
                                            return Integer.valueOf(pluginN3.getVersion());
                                        }
                                        return null;
                                    case 104:
                                        return Boolean.valueOf(Zeus.isPluginLoaded(valueSetQg.stringValue(0)));
                                    case 105:
                                        return Boolean.valueOf(Zeus.isPluginInstalled(valueSetQg.stringValue(0)));
                                    case 106:
                                        TTPluginListener tTPluginListener = (TTPluginListener) valueSetQg.objectValue(0, TTPluginListener.class);
                                        if (tTPluginListener != null) {
                                            rv.n(TTAppContextHolder.getContext()).qg(tTPluginListener);
                                        }
                                        return null;
                                }
                        }
                    }
                    Plugin pluginN4 = n(valueSetQg);
                    if (pluginN4 != null) {
                        return pluginN4.getInstalledVersionCodes();
                    }
                }
                return null;
            }
            Plugin pluginN5 = n(valueSetQg);
            if (pluginN5 != null) {
                return pluginN5.getJsonConfig();
            }
        }
        return s.n().n(10000, 4).qg().sparseArray();
    }

    private void qg() {
        if (Zeus.hasInit()) {
            return;
        }
        rv.n(TTAppContextHolder.getContext());
    }
}
