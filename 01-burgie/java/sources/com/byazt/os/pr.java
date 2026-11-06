package com.byazt.os;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.ij.hn;
import com.byazt.mg.aj;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 66, 37})
public final class pr implements Function<SparseArray<Object>, Object> {
    public static volatile pr pr;

    public static pr pr() {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr();
                }
            }
        }
        return pr;
    }

    private Plugin pr(ValueSet valueSet) {
        if (valueSet == null) {
            return null;
        }
        String strStringValue = valueSet.stringValue(0);
        if (TextUtils.isEmpty(strStringValue)) {
            return null;
        }
        return Zeus.getPlugin(strStringValue);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        String strPr;
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetHw = hn.pr(sparseArray).hw();
        switch (valueSetHw.intValue(-99999987)) {
            case -99999986:
                return hn.pr().pr(10000, 4).hw().sparseArray();
            case 4:
                return Zeus.getPlugin(valueSetHw.stringValue(0)).mClassLoader;
            case 5:
                return Boolean.valueOf(Zeus.loadPlugin(valueSetHw.stringValue(0)));
            case 6:
            case 105:
                return Boolean.valueOf(Zeus.isPluginInstalled(valueSetHw.stringValue(0)));
            case 7:
            case 104:
                return Boolean.valueOf(Zeus.isPluginLoaded(valueSetHw.stringValue(0)));
            case 8:
                String strStringValue = valueSetHw.stringValue(0);
                if (TextUtils.isEmpty(strStringValue)) {
                    strPr = "";
                } else {
                    strPr = aj.pr(strStringValue);
                    if (TextUtils.isEmpty(strPr)) {
                        strPr = aj.hw(strStringValue);
                    }
                }
                if (TextUtils.isEmpty(strPr)) {
                    return "0.0.0.0";
                }
                return strPr;
            case 13:
                Plugin pluginPr = pr(valueSetHw);
                if (pluginPr != null) {
                    return pluginPr.getJsonConfig();
                }
                return hn.pr().pr(10000, 4).hw().sparseArray();
            case 100:
                Zeus.unInstallPlugin(valueSetHw.stringValue(0), valueSetHw.intValue(1));
                return null;
            case 101:
                aj.pr(TTAppContextHolder.getContext());
                Plugin pluginPr2 = pr(valueSetHw);
                if (pluginPr2 == null) {
                    return null;
                }
                return Integer.valueOf(pluginPr2.getApiVersionCode());
            case 102:
                Plugin pluginPr3 = pr(valueSetHw);
                if (pluginPr3 == null) {
                    return null;
                }
                return Integer.valueOf(pluginPr3.getInternalVersionCode());
            case 103:
                Plugin pluginPr4 = pr(valueSetHw);
                if (pluginPr4 == null) {
                    return null;
                }
                return Integer.valueOf(pluginPr4.getVersion());
            case 106:
                TTPluginListener tTPluginListener = (TTPluginListener) valueSetHw.objectValue(0, TTPluginListener.class);
                if (tTPluginListener != null) {
                    aj.pr(TTAppContextHolder.getContext()).hw(tTPluginListener);
                }
                return null;
            case 109:
                hw();
                return null;
            case 110:
                Plugin pluginPr5 = pr(valueSetHw);
                if (pluginPr5 != null) {
                    return pluginPr5.getInstalledVersionCodes();
                }
                return null;
            default:
                return null;
        }
    }

    private void hw() {
        if (!Zeus.hasInit()) {
            aj.pr(TTAppContextHolder.getContext());
        }
    }
}
