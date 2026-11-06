package com.bytedance.sdk.openadsdk.ao.xr.ah;

import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public final ValueSet xr;

    public d(ValueSet valueSet) {
        this.xr = valueSet == null ? com.bykv.ms.ms.ms.ms.xr.f12ms : valueSet;
    }

    public boolean ms() {
        return this.xr.booleanValue(262101);
    }

    public ah x() {
        ValueSet valueSet = (ValueSet) this.xr.objectValue(262102, ValueSet.class);
        if (valueSet != null) {
            return new ah(valueSet);
        }
        return null;
    }

    public boolean xr() {
        return this.xr.booleanValue(262103);
    }

    public boolean ah() {
        return this.xr.booleanValue(262104);
    }

    public String ny() {
        return (String) this.xr.objectValue(262105, String.class);
    }

    public boolean d() {
        return this.xr.booleanValue(262106);
    }

    public String ch() {
        return (String) this.xr.objectValue(262107, String.class);
    }

    public boolean ka() {
        return this.xr.booleanValue(262108);
    }

    public String hi() {
        return (String) this.xr.objectValue(262109, String.class);
    }

    public boolean c() {
        return this.xr.booleanValue(262110);
    }

    public String sl() {
        return (String) this.xr.objectValue(262112, String.class);
    }

    public boolean ab() {
        return this.xr.booleanValue(262111);
    }

    public Map<String, Object> zb() {
        return (Map) this.xr.objectValue(262119, Map.class);
    }
}
