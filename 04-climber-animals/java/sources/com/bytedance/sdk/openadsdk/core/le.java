package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;
import java.io.Serializable;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class le extends com.bytedance.sdk.openadsdk.core.f.ka implements Bridge, Serializable, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.f.ka f2824ms;

    @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
    public boolean ab() {
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public le(com.bytedance.sdk.openadsdk.core.f.ka kaVar) {
        super(null);
        this.f2824ms = kaVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
    public boolean ms() {
        com.bytedance.sdk.openadsdk.core.f.ka kaVar = this.f2824ms;
        if (kaVar == null) {
            if (super.ms() && com.bytedance.sdk.openadsdk.core.i.ka.ms().ms(re.getContext(), com.kuaishou.weapon.p0.g.h) && com.bytedance.sdk.openadsdk.core.i.ka.ms().ms(re.getContext(), com.kuaishou.weapon.p0.g.g)) {
                return true;
            }
        } else if (kaVar.ms() && com.bytedance.sdk.openadsdk.core.i.ka.ms().ms(re.getContext(), com.kuaishou.weapon.p0.g.h) && com.bytedance.sdk.openadsdk.core.i.ka.ms().ms(re.getContext(), com.kuaishou.weapon.p0.g.g)) {
            return true;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.f.ka, com.bytedance.sdk.openadsdk.ao.xr.ah.d
    public com.bytedance.sdk.openadsdk.ao.xr.ah.ah x() {
        com.bytedance.sdk.openadsdk.core.f.ka kaVar = this.f2824ms;
        if (kaVar == null) {
            return super.x();
        }
        return kaVar.x();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
    public boolean xr() {
        com.bytedance.sdk.openadsdk.core.f.ka kaVar = this.f2824ms;
        if (kaVar == null) {
            return super.xr();
        }
        return kaVar.xr();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
    public boolean ah() {
        com.bytedance.sdk.openadsdk.core.f.ka kaVar = this.f2824ms;
        if (kaVar == null) {
            return super.ah();
        }
        return kaVar.ah() && com.bytedance.sdk.openadsdk.core.i.ka.ms().ms(re.getContext(), "android.permission.READ_PHONE_STATE");
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
    public String ny() {
        com.bytedance.sdk.openadsdk.core.f.ka kaVar = this.f2824ms;
        if (kaVar == null) {
            return super.ny();
        }
        return kaVar.ny();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
    public boolean d() {
        com.bytedance.sdk.openadsdk.core.f.ka kaVar = this.f2824ms;
        if (kaVar == null) {
            return super.d();
        }
        return kaVar.d() && com.bytedance.sdk.openadsdk.core.i.ka.ms().ms(re.getContext(), com.kuaishou.weapon.p0.g.d);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
    public String ch() {
        com.bytedance.sdk.openadsdk.core.f.ka kaVar = this.f2824ms;
        if (kaVar == null) {
            return super.ch();
        }
        return kaVar.ch();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
    public boolean ka() {
        com.bytedance.sdk.openadsdk.core.f.ka kaVar = this.f2824ms;
        if (kaVar == null) {
            return super.ka();
        }
        return kaVar.ka() && com.bytedance.sdk.openadsdk.core.i.ka.ms().ms(re.getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
    public String hi() {
        com.bytedance.sdk.openadsdk.core.f.ka kaVar = this.f2824ms;
        if (kaVar == null) {
            return super.hi();
        }
        return kaVar.hi();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
    public boolean c() {
        com.bytedance.sdk.openadsdk.core.f.ka kaVar = this.f2824ms;
        if (kaVar == null) {
            return super.c();
        }
        return kaVar.c();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
    public String sl() {
        com.bytedance.sdk.openadsdk.core.f.ka kaVar = this.f2824ms;
        if (kaVar == null) {
            return super.sl();
        }
        return kaVar.sl();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
    public Map<String, Object> zb() {
        if (g.xr < 6408) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.f.ka kaVar = this.f2824ms;
        if (kaVar == null) {
            return super.zb();
        }
        return kaVar.zb();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i != 262119) {
            switch (i) {
                case 262101:
                    return (T) Boolean.valueOf(ms());
                case 262102:
                    final com.bytedance.sdk.openadsdk.ao.xr.ah.ah ahVarX = x();
                    return (T) new LocationProvider() { // from class: com.bytedance.sdk.openadsdk.core.le.1
                        @Override // com.bytedance.sdk.openadsdk.LocationProvider
                        public double getLatitude() {
                            return ahVarX.ms();
                        }

                        @Override // com.bytedance.sdk.openadsdk.LocationProvider
                        public double getLongitude() {
                            return ahVarX.xr();
                        }
                    };
                case 262103:
                    return (T) Boolean.valueOf(xr());
                case 262104:
                    return (T) Boolean.valueOf(ah());
                case 262105:
                    return (T) ny();
                case 262106:
                    return (T) Boolean.valueOf(d());
                case 262107:
                    return (T) ch();
                case 262108:
                    return (T) Boolean.valueOf(ka());
                case 262109:
                    return (T) hi();
                case 262110:
                    return (T) Boolean.valueOf(c());
                case 262111:
                    return (T) Boolean.valueOf(ab());
                case 262112:
                    return (T) sl();
                default:
                    return null;
            }
        }
        return (T) zb();
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        int iIntValue = ((Integer) sparseArray.get(-99999987)).intValue();
        if (iIntValue != 262119) {
            switch (iIntValue) {
                case 262101:
                    return Boolean.valueOf(ms());
                case 262102:
                    com.bytedance.sdk.openadsdk.ao.xr.ah.ah ahVarX = x();
                    if (ahVarX == null) {
                        return null;
                    }
                    double dMs = ahVarX.ms();
                    return com.bykv.ms.ms.ms.ms.xr.ms().ms(262001, dMs).ms(262002, ahVarX.xr()).xr().sparseArray();
                case 262103:
                    return Boolean.valueOf(xr());
                case 262104:
                    return Boolean.valueOf(ah());
                case 262105:
                    return ny();
                case 262106:
                    return Boolean.valueOf(d());
                case 262107:
                    return ch();
                case 262108:
                    return Boolean.valueOf(ka());
                case 262109:
                    return hi();
                case 262110:
                    return Boolean.valueOf(c());
                case 262111:
                    return Boolean.valueOf(ab());
                case 262112:
                    return sl();
                default:
                    return null;
            }
        }
        return zb();
    }
}
