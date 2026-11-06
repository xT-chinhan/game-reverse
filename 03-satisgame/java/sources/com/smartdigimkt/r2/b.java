package com.smartdigimkt.r2;

import android.os.Bundle;
import com.smartdigimkt.sdk.core.bridge.entity.BaseInfoEntity;
import com.smartdigimkt.sdk.core.bridge.entity.BiddingResultInfoEntity;
import com.smartdigimkt.sdk.core.bridge.entity.DataField;
import com.smartdigimkt.sdk.core.bridge.entity.OfferInfoEntity;
import com.smartdigimkt.sdk.core.bridge.entity.RequestInfoEntity;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final ConcurrentHashMap a = new ConcurrentHashMap();

    public static BaseInfoEntity a(Bundle bundle, Class cls) {
        try {
            BaseInfoEntity baseInfoEntity = (BaseInfoEntity) cls.getDeclaredConstructor(null).newInstance(null);
            for (a aVar : a(cls)) {
                Object objA = a(bundle, aVar.b, aVar.a.getType());
                if (objA != null) {
                    try {
                        if (objA instanceof Bundle) {
                            objA = a((Bundle) objA, aVar.a.getType());
                        }
                        aVar.a.set(baseInfoEntity, objA);
                    } catch (Throwable unused) {
                    }
                }
            }
            return baseInfoEntity;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static List a(Class cls) {
        List list = (List) a.get(cls);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Field field : cls.getDeclaredFields()) {
            DataField dataField = (DataField) field.getAnnotation(DataField.class);
            if (dataField != null) {
                field.setAccessible(true);
                arrayList.add(new a(field, dataField.value()));
            }
        }
        a.put(cls, arrayList);
        return arrayList;
    }

    public static Object a(Bundle bundle, String str, Class cls) {
        if (cls == String.class) {
            return bundle.getString(str);
        }
        if (cls == String[].class) {
            return bundle.getStringArray(str);
        }
        if (cls != Integer.TYPE && cls != Integer.class) {
            if (cls != Boolean.TYPE && cls != Boolean.class) {
                if (cls != Long.TYPE && cls != Long.class) {
                    if (cls != Double.TYPE && cls != Double.class) {
                        if (cls != Float.TYPE && cls != Float.class) {
                            if (cls != Byte.TYPE && cls != Byte.class) {
                                if (cls != Short.TYPE && cls != Short.class) {
                                    if (cls != Bundle.class && cls != RequestInfoEntity.class && cls != OfferInfoEntity.class) {
                                        if (cls == BiddingResultInfoEntity.class) {
                                            return bundle.getBundle(str);
                                        }
                                        Objects.toString(cls);
                                        return null;
                                    }
                                    return bundle.getBundle(str);
                                }
                                return Short.valueOf(bundle.getShort(str));
                            }
                            return Byte.valueOf(bundle.getByte(str));
                        }
                        return Float.valueOf(bundle.getFloat(str));
                    }
                    return Double.valueOf(bundle.getDouble(str));
                }
                return Long.valueOf(bundle.getLong(str));
            }
            return Boolean.valueOf(bundle.getBoolean(str));
        }
        return Integer.valueOf(bundle.getInt(str));
    }
}
