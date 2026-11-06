package com.byazt.mh;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.fi.BaseConstants;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.wt.ve;
import com.byazt.zr.fw;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1152, 37})
public class pr implements Function<SparseArray<Object>, Object> {
    public final fw pr;

    public pr(fw fwVar) {
        this.pr = fwVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Object pr(PluginValueSet pluginValueSet) {
        byte b = 0;
        String strStringValue = pluginValueSet.stringValue(0);
        if (TextUtils.isEmpty(strStringValue)) {
            return null;
        }
        switch (strStringValue.hashCode()) {
            case -1828730287:
                b = !strStringValue.equals("sendGoldExchangeCoupon") ? (byte) -1 : (byte) 5;
                break;
            case -955478604:
                if (!strStringValue.equals("getBiddingToken")) {
                    b = -1;
                }
                break;
            case -366799433:
                b = !strStringValue.equals("onTaskFinish") ? (byte) -1 : (byte) 4;
                break;
            case 862273347:
                b = !strStringValue.equals("onLiveFakeInitFinish") ? (byte) -1 : (byte) 6;
                break;
            case 1186389324:
                b = !strStringValue.equals("getPanglePluginVersion") ? (byte) -1 : (byte) 1;
                break;
            case 1388496268:
                b = !strStringValue.equals("onAuthCallback") ? (byte) -1 : (byte) 2;
                break;
            case 1562160023:
                b = !strStringValue.equals("getPangleApiVersion") ? (byte) -1 : (byte) 7;
                break;
            case 1979487267:
                b = !strStringValue.equals("reportPangleEvent") ? (byte) -1 : (byte) 3;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                return c(pluginValueSet);
            case 1:
                return 7714;
            case 2:
                fw(pluginValueSet);
                return null;
            case 3:
                uc(pluginValueSet);
                return null;
            case 4:
                x(pluginValueSet);
                return null;
            case 5:
                hn(pluginValueSet);
                return null;
            case 6:
                hw(pluginValueSet);
                return null;
            case 7:
                return String.valueOf(iu.x);
            default:
                return null;
        }
    }

    private void hw(PluginValueSet pluginValueSet) {
        int i = -3;
        String message = null;
        try {
            String str = (String) ((Map) pluginValueSet.objectValue(1, Map.class)).get(TrackAction.SUCCESS);
            if (str != null) {
                if (Boolean.parseBoolean(str)) {
                    i = 2;
                } else {
                    message = "fake init failed";
                }
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        this.pr.pr(i, message, false, true);
    }

    private void hn(PluginValueSet pluginValueSet) {
        try {
            this.pr.hn((Map<String, String>) pluginValueSet.objectValue(1, Map.class));
        } catch (Exception e) {
        }
    }

    private void x(PluginValueSet pluginValueSet) {
        try {
            this.pr.hw((Map<String, String>) pluginValueSet.objectValue(1, Map.class));
        } catch (Exception e) {
        }
    }

    private Object c(PluginValueSet pluginValueSet) {
        try {
            Integer numZo = zo(pluginValueSet);
            if (numZo == null) {
                return null;
            }
            return a.pr().pr(ve.pr(numZo.intValue(), com.byazt.zb.pr.hw()));
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    private void uc(PluginValueSet pluginValueSet) {
        Map<String, String> map = (Map) pluginValueSet.objectValue(1, Map.class);
        if (map == null) {
            return;
        }
        this.pr.pr(map);
    }

    private void fw(PluginValueSet pluginValueSet) {
        try {
            boolean z = true;
            Map map = (Map) pluginValueSet.objectValue(1, Map.class);
            String str = (String) map.get("is_auth");
            fw fwVar = this.pr;
            if (Integer.valueOf(str).intValue() == 0) {
                z = false;
            }
            fwVar.pr(z, (String) map.get("open_uid"));
        } catch (Exception e) {
        }
    }

    private Integer zo(PluginValueSet pluginValueSet) {
        String strFw = com.byazt.eg.hw.pr().fw();
        if (strFw == null) {
            return null;
        }
        if (strFw.replaceAll(".", "").startsWith("2112")) {
            Object[] objArrArrayValue = pluginValueSet.arrayValue(1, Object[].class);
            if (objArrArrayValue == null || objArrArrayValue.length == 0) {
                return null;
            }
            return (Integer) objArrArrayValue[0];
        }
        Map map = (Map) pluginValueSet.objectValue(1, Map.class);
        if (map == null || map.size() == 0) {
            return null;
        }
        return Integer.valueOf((String) map.get("adType"));
    }

    public void pr(boolean z, String str, String str2, Map<String, String> map) {
        final JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (!jSONObject.has(entry.getKey())) {
                            jSONObject.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
            } catch (Exception e) {
                return;
            }
        }
        com.byazt.pj.pr.pr(str2, str, BaseConstants.CATEGORY_UMENG, jSONObject.optString("log_extra"), jSONObject.optString(Constants.VALUE_FIELD), (String) null, (String) null, (JSONObject) null, new com.byazt.ttf.pr() { // from class: com.byazt.mh.pr.1
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                if (!TextUtils.isEmpty(jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA))) {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("is_other_channel"))) {
                    jSONObject2.put("is_other_channel", jSONObject.optString("is_other_channel"));
                }
                if (!jSONObject2.has(BaseConstants.EVENT_LABEL_IS_AD_EVENT)) {
                    jSONObject2.putOpt(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    return null;
                }
                return null;
            }
        });
    }

    private boolean pr(PluginValueSet pluginValueSet, int i) {
        try {
            Map map = (Map) pluginValueSet.objectValue(i, Map.class);
            return map != null && map.containsKey("onlyUpdateState") && Boolean.parseBoolean(String.valueOf(map.get("onlyUpdateState")));
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
        switch (pluginValueSetHw.intValue(-99999987)) {
            case 0:
                return pr(pluginValueSetHw);
            case 1:
                pr(pluginValueSetHw.booleanValue(0), pluginValueSetHw.stringValue(1), pluginValueSetHw.stringValue(2), (Map) pluginValueSetHw.objectValue(3, Map.class));
                return null;
            case 2:
                this.pr.pr(pluginValueSetHw.intValue(0), pluginValueSetHw.stringValue(1), pr(pluginValueSetHw, 2), false);
                return null;
            case 3:
                int iIntValue = pluginValueSetHw.intValue(0);
                boolean zPr = pr(pluginValueSetHw, 4);
                if (1000 == iIntValue) {
                    this.pr.pr(5, (String) null, zPr, false);
                    if (!zPr) {
                        this.pr.pr();
                    }
                } else if (1001 == iIntValue) {
                    this.pr.pr(-2, pluginValueSetHw.stringValue(1), zPr, false);
                }
                return null;
            default:
                return null;
        }
    }
}
