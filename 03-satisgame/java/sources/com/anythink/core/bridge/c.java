package com.anythink.core.bridge;

import android.os.Bundle;
import android.util.Log;
import com.anythink.core.bridge.entity.DataField;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final String a = "c";
    private static final Map<Class<?>, List<a>> b = new ConcurrentHashMap();

    public static Bundle a(Object obj) {
        Bundle bundle = new Bundle();
        try {
            for (a aVar : a(obj.getClass())) {
                try {
                    Object obj2 = aVar.a.get(obj);
                    if (obj2 != null) {
                        String str = aVar.b;
                        if (obj2 instanceof String) {
                            bundle.putString(str, (String) obj2);
                        } else if (obj2 instanceof String[]) {
                            bundle.putStringArray(str, (String[]) obj2);
                        } else if (obj2 instanceof Integer) {
                            bundle.putInt(str, ((Integer) obj2).intValue());
                        } else if (obj2 instanceof Boolean) {
                            bundle.putBoolean(str, ((Boolean) obj2).booleanValue());
                        } else if (obj2 instanceof Long) {
                            bundle.putLong(str, ((Long) obj2).longValue());
                        } else if (obj2 instanceof Double) {
                            bundle.putDouble(str, ((Double) obj2).doubleValue());
                        } else if (obj2 instanceof Float) {
                            bundle.putFloat(str, ((Float) obj2).floatValue());
                        } else if (obj2 instanceof Byte) {
                            bundle.putByte(str, ((Byte) obj2).byteValue());
                        } else if (obj2 instanceof Short) {
                            bundle.putShort(str, ((Short) obj2).shortValue());
                        } else if (obj2 instanceof com.anythink.core.bridge.entity.b) {
                            bundle.putBundle(str, a(obj2));
                        } else {
                            Log.e(a, "putToBundle() >>> unsupported type.");
                        }
                    }
                } catch (Throwable th) {
                    Log.e(a, "toBundle() >>> field get failed.", th);
                }
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }

    private static <T extends com.anythink.core.bridge.entity.b> T a(Bundle bundle, Class<T> cls) {
        Object objValueOf;
        try {
            T tNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            for (a aVar : a((Class<?>) cls)) {
                String str = aVar.b;
                Class<?> type = aVar.a.getType();
                if (type == String.class) {
                    objValueOf = bundle.getString(str);
                } else if (type == String[].class) {
                    objValueOf = bundle.getStringArray(str);
                } else if (type == Integer.TYPE || type == Integer.class) {
                    objValueOf = Integer.valueOf(bundle.getInt(str));
                } else if (type == Boolean.TYPE || type == Boolean.class) {
                    objValueOf = Boolean.valueOf(bundle.getBoolean(str));
                } else if (type == Long.TYPE || type == Long.class) {
                    objValueOf = Long.valueOf(bundle.getLong(str));
                } else if (type == Double.TYPE || type == Double.class) {
                    objValueOf = Double.valueOf(bundle.getDouble(str));
                } else if (type == Float.TYPE || type == Float.class) {
                    objValueOf = Float.valueOf(bundle.getFloat(str));
                } else if (type == Byte.TYPE || type == Byte.class) {
                    objValueOf = Byte.valueOf(bundle.getByte(str));
                } else if (type == Short.TYPE || type == Short.class) {
                    objValueOf = Short.valueOf(bundle.getShort(str));
                } else if (type == Bundle.class) {
                    objValueOf = bundle.getBundle(str);
                } else {
                    Log.e(a, "getFromBundle() >>> unsupported type.");
                    objValueOf = null;
                }
                if (objValueOf != null) {
                    try {
                        if (objValueOf instanceof Bundle) {
                            objValueOf = a((Bundle) objValueOf, aVar.a.getType());
                        }
                        aVar.a.set(tNewInstance, objValueOf);
                    } catch (Throwable th) {
                        Log.e(a, "parse() >>> field set failed.", th);
                    }
                }
            }
            return tNewInstance;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static List<a> a(Class<?> cls) {
        List<a> list = b.get(cls);
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
        b.put(cls, arrayList);
        return arrayList;
    }

    private static void a(Bundle bundle, String str, Object obj) {
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return;
        }
        if (obj instanceof String[]) {
            bundle.putStringArray(str, (String[]) obj);
            return;
        }
        if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Byte) {
            bundle.putByte(str, ((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof Short) {
            bundle.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof com.anythink.core.bridge.entity.b) {
            bundle.putBundle(str, a(obj));
        } else {
            Log.e(a, "putToBundle() >>> unsupported type.");
        }
    }

    private static Object a(Bundle bundle, String str, Class<?> cls) {
        if (cls == String.class) {
            return bundle.getString(str);
        }
        if (cls == String[].class) {
            return bundle.getStringArray(str);
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            return Integer.valueOf(bundle.getInt(str));
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return Boolean.valueOf(bundle.getBoolean(str));
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return Long.valueOf(bundle.getLong(str));
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return Double.valueOf(bundle.getDouble(str));
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return Float.valueOf(bundle.getFloat(str));
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return Byte.valueOf(bundle.getByte(str));
        }
        if (cls == Short.TYPE || cls == Short.class) {
            return Short.valueOf(bundle.getShort(str));
        }
        if (cls == Bundle.class) {
            return bundle.getBundle(str);
        }
        Log.e(a, "getFromBundle() >>> unsupported type.");
        return null;
    }

    private static class a {
        final Field a;
        final String b;

        a(Field field, String str) {
            this.a = field;
            this.b = str;
        }
    }
}
