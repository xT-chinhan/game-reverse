package com.byazt.wc;

import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.core.common.d.i;
import com.anythink.core.common.f.e;
import com.byazt.ho.BaseConstants;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.op.x;
import com.byazt.vgx.q;
import com.byazt.vgx.s;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_VIDEO_WINDOW_SIZE, 19})
public class n implements Function<SparseArray<Object>, Object> {
    public final x n;

    public n(x xVar) {
        this.n = xVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Object n(PluginValueSet pluginValueSet) {
        byte b = 0;
        String strStringValue = pluginValueSet.stringValue(0);
        if (TextUtils.isEmpty(strStringValue)) {
            return null;
        }
        strStringValue.hashCode();
        switch (strStringValue.hashCode()) {
            case -1828730287:
                if (!strStringValue.equals("sendGoldExchangeCoupon")) {
                    b = -1;
                }
                break;
            case -955478604:
                b = !strStringValue.equals("getBiddingToken") ? (byte) -1 : (byte) 1;
                break;
            case -366799433:
                b = !strStringValue.equals("onTaskFinish") ? (byte) -1 : (byte) 2;
                break;
            case 862273347:
                b = !strStringValue.equals("onLiveFakeInitFinish") ? (byte) -1 : (byte) 3;
                break;
            case 1186389324:
                b = !strStringValue.equals("getPanglePluginVersion") ? (byte) -1 : (byte) 4;
                break;
            case 1388496268:
                b = !strStringValue.equals("onAuthCallback") ? (byte) -1 : (byte) 5;
                break;
            case 1562160023:
                b = !strStringValue.equals("getPangleApiVersion") ? (byte) -1 : (byte) 6;
                break;
            case 1979487267:
                b = !strStringValue.equals("reportPangleEvent") ? (byte) -1 : (byte) 7;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                s(pluginValueSet);
                return null;
            case 1:
                return l(pluginValueSet);
            case 2:
                q(pluginValueSet);
                return null;
            case 3:
                qg(pluginValueSet);
                return null;
            case 4:
                return 7814;
            case 5:
                x(pluginValueSet);
                return null;
            case 6:
                return String.valueOf(tj.l);
            case 7:
                w(pluginValueSet);
                return null;
            default:
                return null;
        }
    }

    private void qg(PluginValueSet pluginValueSet) {
        String message;
        int i = -3;
        try {
            String str = (String) ((Map) pluginValueSet.objectValue(1, Map.class)).get("success");
            message = null;
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
        this.n.n(i, message, false, true);
    }

    private void s(PluginValueSet pluginValueSet) {
        try {
            this.n.s((Map<String, String>) pluginValueSet.objectValue(1, Map.class));
        } catch (Exception unused) {
        }
    }

    private void q(PluginValueSet pluginValueSet) {
        try {
            this.n.qg((Map<String, String>) pluginValueSet.objectValue(1, Map.class));
        } catch (Exception unused) {
        }
    }

    private Object l(PluginValueSet pluginValueSet) {
        try {
            Integer numFs = fs(pluginValueSet);
            if (numFs == null) {
                return null;
            }
            return rv.n().n(q.n(numFs.intValue(), s.qg()));
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    private void w(PluginValueSet pluginValueSet) {
        Map<String, String> map = (Map) pluginValueSet.objectValue(1, Map.class);
        if (map == null) {
            return;
        }
        this.n.n(map);
    }

    private void x(PluginValueSet pluginValueSet) {
        try {
            boolean z = true;
            Map map = (Map) pluginValueSet.objectValue(1, Map.class);
            String str = (String) map.get("is_auth");
            x xVar = this.n;
            if (Integer.valueOf(str).intValue() == 0) {
                z = false;
            }
            xVar.n(z, (String) map.get("open_uid"));
        } catch (Exception unused) {
        }
    }

    private Integer fs(PluginValueSet pluginValueSet) {
        String strX = com.byazt.wq.qg.n().x();
        if (strX == null) {
            return null;
        }
        if (strX.replaceAll(i.E, "").startsWith("2112")) {
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

    public void n(boolean z, String str, String str2, Map<String, String> map) {
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
            } catch (Exception unused) {
                return;
            }
        }
        com.byazt.hm.n.n(str2, str, BaseConstants.CATEGORY_UMENG, jSONObject.optString("log_extra"), jSONObject.optString(e.a.d), (String) null, (String) null, (JSONObject) null, new com.byazt.rs.n() { // from class: com.byazt.wc.n.1
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                if (!TextUtils.isEmpty(jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA))) {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("is_other_channel"))) {
                    jSONObject2.put("is_other_channel", jSONObject.optString("is_other_channel"));
                }
                if (jSONObject2.has(BaseConstants.EVENT_LABEL_IS_AD_EVENT)) {
                    return null;
                }
                jSONObject2.putOpt(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                return null;
            }
        });
    }

    private boolean n(PluginValueSet pluginValueSet, int i) {
        try {
            Map map = (Map) pluginValueSet.objectValue(i, Map.class);
            return map != null && map.containsKey("onlyUpdateState") && Boolean.parseBoolean(String.valueOf(map.get("onlyUpdateState")));
        } catch (Throwable unused) {
        }
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        if (iIntValue == 0) {
            return n(pluginValueSetQg);
        }
        if (iIntValue == 1) {
            n(pluginValueSetQg.booleanValue(0), pluginValueSetQg.stringValue(1), pluginValueSetQg.stringValue(2), (Map) pluginValueSetQg.objectValue(3, Map.class));
        } else if (iIntValue == 2) {
            this.n.n(pluginValueSetQg.intValue(0), pluginValueSetQg.stringValue(1), n(pluginValueSetQg, 2), false);
        } else if (iIntValue == 3) {
            int iIntValue2 = pluginValueSetQg.intValue(0);
            boolean zN = n(pluginValueSetQg, 4);
            if (1000 == iIntValue2) {
                this.n.n(5, (String) null, zN, false);
                if (!zN) {
                    this.n.n();
                }
            } else if (1001 == iIntValue2) {
                this.n.n(-2, pluginValueSetQg.stringValue(1), zN, false);
            }
        }
        return null;
    }
}
