package com.bytedance.sdk.openadsdk.tools;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ah f4122ms;

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    private ah() {
    }

    public static ah ms() {
        if (f4122ms == null) {
            f4122ms = new ah();
        }
        return f4122ms;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 10001) {
            ch.ub().ch(valueSet.booleanValue(1));
        } else {
            if (i == 10002) {
                return (T) Boolean.valueOf(ch.ub().vm());
            }
            if (i == 10003) {
                re.ms().ms(new com.bytedance.sdk.openadsdk.core.f.ah(valueSet.objectValue(0, Object.class)));
            } else if (i == 10004) {
                com.bytedance.sdk.openadsdk.core.f.ah ahVar = new com.bytedance.sdk.openadsdk.core.f.ah(valueSet.objectValue(0, Object.class));
                String str = (String) valueSet.objectValue(1, String.class);
                String str2 = (String) valueSet.objectValue(2, String.class);
                String str3 = (String) valueSet.objectValue(3, String.class);
                String str4 = (String) valueSet.objectValue(4, String.class);
                HashMap map = new HashMap();
                map.put("adtype", str2);
                map.put("rit", str);
                map.put("image_mode", str3);
                map.put("preview_extra", str4);
                re.ms().ms(map, ahVar);
            } else {
                if (i == 10005) {
                    com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
                    xrVarMs.ms(0, ch.ub().rt());
                    xrVarMs.ms(1, ch.ub().vy());
                    return (T) xrVarMs.xr();
                }
                if (i == 10006) {
                    re.ms().ms((Map<String, Object>) valueSet.objectValue(0, Map.class), new com.bytedance.sdk.openadsdk.core.f.ah(valueSet.objectValue(1, Object.class)));
                } else if (i == 10007) {
                    ch.ub().ms((ch.d) null);
                }
            }
        }
        return null;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        int iIntValue = valueSetXr.intValue(-99999987);
        if (iIntValue == 10001) {
            ch.ub().ch(valueSetXr.booleanValue(1));
            return null;
        }
        if (iIntValue == 10002) {
            return Boolean.valueOf(ch.ub().vm());
        }
        if (iIntValue == 10003) {
            re.ms().ms(new com.bytedance.sdk.openadsdk.core.f.ah(valueSetXr.objectValue(0, Function.class)));
            return null;
        }
        if (iIntValue != 10004) {
            if (iIntValue != 10005) {
                return null;
            }
            com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
            xrVarMs.ms(0, ch.ub().rt());
            xrVarMs.ms(1, ch.ub().vy());
            return xrVarMs.xr().sparseArray();
        }
        com.bytedance.sdk.openadsdk.core.f.ah ahVar = new com.bytedance.sdk.openadsdk.core.f.ah(valueSetXr.objectValue(0, Function.class));
        String str = (String) valueSetXr.objectValue(1, String.class);
        String str2 = (String) valueSetXr.objectValue(2, String.class);
        String str3 = (String) valueSetXr.objectValue(3, String.class);
        String str4 = (String) valueSetXr.objectValue(4, String.class);
        HashMap map = new HashMap();
        map.put("adtype", str2);
        map.put("rit", str);
        map.put("image_mode", str3);
        map.put("preview_extra", str4);
        re.ms().ms(map, ahVar);
        return null;
    }
}
