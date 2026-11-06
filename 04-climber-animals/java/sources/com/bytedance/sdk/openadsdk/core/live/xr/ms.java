package com.bytedance.sdk.openadsdk.core.live.xr;

import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.core.common.d.j;
import com.anythink.core.common.e.f;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.op;
import com.bytedance.sdk.openadsdk.core.live.ms.ab;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final ab f2850ms;

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public ms(ab abVar) {
        this.f2850ms = abVar;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (valueSet == null) {
            return null;
        }
        if (i == 0) {
            return (T) ms(valueSet);
        }
        if (i == 1) {
            ms(valueSet.booleanValue(0), valueSet.stringValue(1), valueSet.stringValue(2), (Map) valueSet.objectValue(3, Map.class));
        } else if (i == 2) {
            this.f2850ms.ms(valueSet.intValue(0), valueSet.stringValue(1), ms(valueSet, 2));
        } else if (i == 3) {
            int iIntValue = valueSet.intValue(0);
            boolean zMs = ms(valueSet, 4);
            if (1000 == iIntValue) {
                this.f2850ms.ms(5, (String) null, zMs);
                if (!zMs) {
                    this.f2850ms.ms();
                }
            } else if (1001 == iIntValue) {
                this.f2850ms.ms(-2, valueSet.stringValue(1), zMs);
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Object ms(ValueSet valueSet) {
        byte b = 0;
        String strStringValue = valueSet.stringValue(0);
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
            case 1979487267:
                b = !strStringValue.equals("reportPangleEvent") ? (byte) -1 : (byte) 6;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                ah(valueSet);
                return null;
            case 1:
                return ka(valueSet);
            case 2:
                d(valueSet);
                return null;
            case 3:
                xr(valueSet);
                return null;
            case 4:
                return 6923;
            case 5:
                ab(valueSet);
                return null;
            case 6:
                c(valueSet);
                return null;
            default:
                return null;
        }
    }

    private void xr(ValueSet valueSet) {
        String message;
        int i = -3;
        try {
            String str = (String) ((Map) valueSet.objectValue(1, Map.class)).get("success");
            message = null;
            if (str != null) {
                if (Boolean.parseBoolean(str)) {
                    i = 2;
                } else {
                    message = "fake init failed";
                }
            }
        } catch (Exception e) {
            sl.xr("LiveServiceBridge", e);
            message = e.getMessage();
        }
        this.f2850ms.ms(i, message, true);
    }

    private void ah(ValueSet valueSet) {
        try {
            this.f2850ms.ah((Map<String, String>) valueSet.objectValue(1, Map.class));
        } catch (Exception e) {
            sl.xr("LiveServiceBridge", e);
        }
    }

    private void d(ValueSet valueSet) {
        try {
            this.f2850ms.xr((Map<String, String>) valueSet.objectValue(1, Map.class));
        } catch (Exception e) {
            sl.xr("LiveServiceBridge", e);
        }
    }

    private Object ka(ValueSet valueSet) {
        try {
            Integer numX = x(valueSet);
            if (numX == null) {
                return null;
            }
            return re.ms().ms(op.ms(numX.intValue()));
        } catch (Throwable th) {
            sl.xr("TTLiveSDkBridge", "invokeGetBiddingToken failed:" + th.getMessage());
            return null;
        }
    }

    private void c(ValueSet valueSet) {
        Map<String, String> map = (Map) valueSet.objectValue(1, Map.class);
        if (map == null) {
            return;
        }
        this.f2850ms.ms(map);
    }

    private void ab(ValueSet valueSet) {
        try {
            Map map = (Map) valueSet.objectValue(1, Map.class);
            this.f2850ms.ms(Integer.valueOf((String) map.get("is_auth")).intValue() != 0, (String) map.get("open_uid"));
        } catch (Exception e) {
            sl.xr("LiveServiceBridge", e);
        }
    }

    private Integer x(ValueSet valueSet) {
        String strAb = com.bytedance.sdk.openadsdk.core.live.xr.ms().ab();
        if (strAb == null) {
            return null;
        }
        if (strAb.replaceAll(j.z, "").startsWith("2112")) {
            Object[] objArrArrayValue = valueSet.arrayValue(1, Object[].class);
            if (objArrArrayValue == null || objArrArrayValue.length == 0) {
                return null;
            }
            return (Integer) objArrArrayValue[0];
        }
        Map map = (Map) valueSet.objectValue(1, Map.class);
        if (map == null || map.size() == 0) {
            return null;
        }
        return Integer.valueOf((String) map.get("adType"));
    }

    public void ms(boolean z, String str, String str2, Map<String, String> map) {
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
                sl.ms(e);
                return;
            }
        }
        new com.bytedance.sdk.openadsdk.core.zb.ms.C0332ms().ms(str).xr(str2).ah("umeng").ka(jSONObject.optString(f.a.d)).d(jSONObject.optString("log_extra")).ms(new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.live.xr.ms.1
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject2) throws JSONException {
                if (!TextUtils.isEmpty(jSONObject.optString("ad_extra_data"))) {
                    jSONObject2.put("ad_extra_data", jSONObject.optString("ad_extra_data"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("is_other_channel"))) {
                    jSONObject2.put("is_other_channel", jSONObject.optString("is_other_channel"));
                }
                if (jSONObject2.has("is_ad_event")) {
                    return;
                }
                jSONObject2.putOpt("is_ad_event", "1");
            }
        });
    }

    private boolean ms(ValueSet valueSet, int i) {
        try {
            Map map = (Map) valueSet.objectValue(i, Map.class);
            return map != null && map.containsKey("onlyUpdateState") && Boolean.parseBoolean(String.valueOf(map.get("onlyUpdateState")));
        } catch (Throwable unused) {
        }
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        int iIntValue = valueSetXr.intValue(-99999987);
        if (iIntValue == 0) {
            return ms(valueSetXr);
        }
        if (iIntValue == 1) {
            ms(valueSetXr.booleanValue(0), valueSetXr.stringValue(1), valueSetXr.stringValue(2), (Map) valueSetXr.objectValue(3, Map.class));
        } else if (iIntValue == 2) {
            this.f2850ms.ms(valueSetXr.intValue(0), valueSetXr.stringValue(1), ms(valueSetXr, 2));
        } else if (iIntValue == 3) {
            int iIntValue2 = valueSetXr.intValue(0);
            boolean zMs = ms(valueSetXr, 4);
            if (1000 == iIntValue2) {
                this.f2850ms.ms(5, (String) null, zMs);
                if (!zMs) {
                    this.f2850ms.ms();
                }
            } else if (1001 == iIntValue2) {
                this.f2850ms.ms(-2, valueSetXr.stringValue(1), zMs);
            }
        }
        return null;
    }
}
