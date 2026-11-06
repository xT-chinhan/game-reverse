package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class MediationValueSetBuilder {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final SparseArray<Object> f3971ms;

    public interface BooleanGetter extends ValueSet.ValueGetter<Boolean> {
    }

    public interface DoubleGetter extends ValueSet.ValueGetter<Double> {
    }

    public interface FloatGetter extends ValueSet.ValueGetter<Float> {
    }

    public interface IntGetter extends ValueSet.ValueGetter<Integer> {
    }

    public interface LongGetter extends ValueSet.ValueGetter<Long> {
    }

    public interface ObjectGetter extends ValueSet.ValueGetter<Object> {
    }

    public interface StringGetter extends ValueSet.ValueGetter<String> {
    }

    private MediationValueSetBuilder(SparseArray<Object> sparseArray) {
        this.f3971ms = sparseArray;
    }

    public static final MediationValueSetBuilder create() {
        return new MediationValueSetBuilder(new SparseArray());
    }

    public static final MediationValueSetBuilder create(SparseArray<Object> sparseArray) {
        return new MediationValueSetBuilder(sparseArray);
    }

    public static final MediationValueSetBuilder create(ValueSet valueSet) {
        if (valueSet == null || valueSet.isEmpty()) {
            return new MediationValueSetBuilder(new SparseArray());
        }
        SparseArray sparseArray = new SparseArray();
        for (Integer num : valueSet.keys()) {
            sparseArray.put(num.intValue(), valueSet.objectValue(num.intValue(), Object.class));
        }
        return new MediationValueSetBuilder(sparseArray);
    }

    public <T> MediationValueSetBuilder addArray(int i, T[] tArr) {
        this.f3971ms.put(i, tArr);
        return this;
    }

    public MediationValueSetBuilder add(int i, Object obj) {
        this.f3971ms.put(i, obj);
        return this;
    }

    public MediationValueSetBuilder add(int i, String str) {
        this.f3971ms.put(i, str);
        return this;
    }

    public MediationValueSetBuilder add(int i, int i2) {
        this.f3971ms.put(i, Integer.valueOf(i2));
        return this;
    }

    public MediationValueSetBuilder add(int i, double d) {
        this.f3971ms.put(i, Double.valueOf(d));
        return this;
    }

    public MediationValueSetBuilder add(int i, boolean z) {
        this.f3971ms.put(i, Boolean.valueOf(z));
        return this;
    }

    public MediationValueSetBuilder add(int i, long j) {
        this.f3971ms.put(i, Long.valueOf(j));
        return this;
    }

    public MediationValueSetBuilder add(int i, float f) {
        this.f3971ms.put(i, Float.valueOf(f));
        return this;
    }

    public MediationValueSetBuilder add(int i, ObjectGetter objectGetter) {
        this.f3971ms.put(i, objectGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i, StringGetter stringGetter) {
        this.f3971ms.put(i, stringGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i, DoubleGetter doubleGetter) {
        this.f3971ms.put(i, doubleGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i, IntGetter intGetter) {
        this.f3971ms.put(i, intGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i, BooleanGetter booleanGetter) {
        this.f3971ms.put(i, booleanGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i, LongGetter longGetter) {
        this.f3971ms.put(i, longGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i, FloatGetter floatGetter) {
        this.f3971ms.put(i, floatGetter);
        return this;
    }

    public ValueSet build() {
        return new ValueSetImpl(this.f3971ms);
    }

    private static final class ValueSetImpl implements ValueSet {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final SparseArray<Object> f3972ms;

        private ValueSetImpl(SparseArray<Object> sparseArray) {
            this.f3972ms = sparseArray;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.f3972ms.get(i);
            if (obj == null) {
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            ValueSet.ValueGetter valueGetter = (T) this.f3972ms.get(i);
            if (valueGetter instanceof ValueSet.ValueGetter) {
                valueGetter = (T) valueGetter.get();
            }
            if (cls.isInstance(valueGetter)) {
                return (T) valueGetter;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i) {
            return stringValue(i, null);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i) {
            return intValue(i, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i) {
            return booleanValue(i, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i) {
            return longValue(i, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i) {
            return floatValue(i, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i) {
            Object obj = this.f3972ms.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            return 0.0d;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i, String str) {
            Object obj = this.f3972ms.get(i);
            return (obj instanceof ValueSet.ValueGetter ? ((ValueSet.ValueGetter) obj).get() : obj) instanceof String ? obj.toString() : str;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i, int i2) {
            Object obj = this.f3972ms.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i, boolean z) {
            Object obj = this.f3972ms.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i, long j) {
            Object obj = this.f3972ms.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i, float f) {
            Object obj = this.f3972ms.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i) {
            return this.f3972ms.indexOfKey(i) >= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.f3972ms.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(i));
            }
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            SparseArray<Object> sparseArray = this.f3972ms;
            if (sparseArray == null) {
                return 0;
            }
            return sparseArray.size();
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public SparseArray<Object> sparseArray() {
            SparseArray<Object> sparseArray = this.f3972ms;
            return sparseArray != null ? sparseArray : new SparseArray<>();
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public void remove(int i) {
            this.f3972ms.remove(i);
        }
    }
}
