package com.bytedance.adsdk.ugeno.yoga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class YogaNodeJNIBase extends ch implements Cloneable {
    private boolean ab;
    private List<YogaNodeJNIBase> ah;
    private float[] arr;
    private Object c;
    private ab d;
    private xr ka;
    private int mLayoutDirection;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected long f441ms;
    private YogaNodeJNIBase xr;

    private YogaNodeJNIBase(long j) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.ab = true;
        if (j == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.f441ms = j;
    }

    YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public int ms() {
        List<YogaNodeJNIBase> list = this.ah;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    /* JADX INFO: renamed from: ah, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase ms(int i) {
        List<YogaNodeJNIBase> list = this.ah;
        if (list == null) {
            throw new IllegalStateException("YogaNode does not have children");
        }
        return list.get(i);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ms(ch chVar, int i) {
        if (chVar instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) chVar;
            if (yogaNodeJNIBase.xr != null) {
                throw new IllegalStateException("Child already has a parent, it must be removed first.");
            }
            if (this.ah == null) {
                this.ah = new ArrayList(4);
            }
            this.ah.add(i, yogaNodeJNIBase);
            yogaNodeJNIBase.xr = this;
            YogaNative.jni_YGNodeInsertChildJNI(this.f441ms, yogaNodeJNIBase.f441ms, i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase xr(int i) {
        List<YogaNodeJNIBase> list = this.ah;
        if (list == null) {
            throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
        }
        YogaNodeJNIBase yogaNodeJNIBaseRemove = list.remove(i);
        yogaNodeJNIBaseRemove.xr = null;
        YogaNative.jni_YGNodeRemoveChildJNI(this.f441ms, yogaNodeJNIBaseRemove.f441ms);
        return yogaNodeJNIBaseRemove;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    /* JADX INFO: renamed from: hi, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase xr() {
        return this.xr;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public int ms(ch chVar) {
        List<YogaNodeJNIBase> list = this.ah;
        if (list == null) {
            return -1;
        }
        return list.indexOf(chVar);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ms(float f, float f2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i = 0; i < arrayList.size(); i++) {
            List<YogaNodeJNIBase> list = ((YogaNodeJNIBase) arrayList.get(i)).ah;
            if (list != null) {
                Iterator<YogaNodeJNIBase> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i2 = 0; i2 < yogaNodeJNIBaseArr.length; i2++) {
            jArr[i2] = yogaNodeJNIBaseArr[i2].f441ms;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.f441ms, f, f2, jArr, yogaNodeJNIBaseArr);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ms(ah ahVar) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.f441ms, ahVar.ms());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ms(ka kaVar) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.f441ms, kaVar.ms());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ms(c cVar) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.f441ms, cVar.ms());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ms(ms msVar) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.f441ms, msVar.ms());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void xr(ms msVar) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.f441ms, msVar.ms());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ah(ms msVar) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.f441ms, msVar.ms());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ms(zb zbVar) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.f441ms, zbVar.ms());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ms(u uVar) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.f441ms, uVar.ms());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ms(float f) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.f441ms, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void xr(float f) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.f441ms, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ah(float f) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.f441ms, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ah() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.f441ms);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ms(d dVar, float f) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.f441ms, dVar.ms(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void xr(d dVar, float f) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.f441ms, dVar.ms(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ah(d dVar, float f) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.f441ms, dVar.ms(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void d(float f) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.f441ms, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ka(float f) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.f441ms, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void d() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.f441ms);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void c(float f) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.f441ms, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ab(float f) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.f441ms, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ka() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.f441ms);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void x(float f) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.f441ms, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ny(float f) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.f441ms, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ch(float f) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.f441ms, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void hi(float f) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.f441ms, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void sl(float f) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.f441ms, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ms(ab abVar) {
        this.d = abVar;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.f441ms, abVar != null);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ms(boolean z) {
        YogaNative.jni_YGNodeSetAlwaysFormsContainingBlockJNI(this.f441ms, z);
    }

    public final long measure(float f, int i, float f2, int i2) {
        if (!sl()) {
            throw new RuntimeException("Measure function isn't defined!");
        }
        return this.d.ms(this, f, x.ms(i), f2, x.ms(i2));
    }

    public final float baseline(float f, float f2) {
        return this.ka.ms(this, f, f2);
    }

    public boolean sl() {
        return this.d != null;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public void ms(Object obj) {
        this.c = obj;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public Object ch() {
        return this.c;
    }

    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i) {
        List<YogaNodeJNIBase> list = this.ah;
        if (list == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        list.remove(i);
        this.ah.add(i, yogaNodeJNIBase);
        yogaNodeJNIBase.xr = this;
        return yogaNodeJNIBase.f441ms;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public float c() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public float ab() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public float x() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.ch
    public float ny() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }
}
