package com.byakv.k;

import com.byazt.fty.c;
import com.byazt.fty.fw;
import com.byazt.fty.g;
import com.byazt.fty.hn;
import com.byazt.fty.hw;
import com.byazt.fty.m;
import com.byazt.fty.pr;
import com.byazt.fty.uc;
import com.byazt.fty.vk;
import com.byazt.fty.x;
import com.byazt.fty.zo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class YogaNodeJNIBase extends vk implements Cloneable {
    public float[] arr;
    public hw c;
    public boolean fw;
    public List<YogaNodeJNIBase> hn;
    public YogaNodeJNIBase hw;
    public int mLayoutDirection;
    public long pr;
    public Object uc;
    public fw x;

    private YogaNodeJNIBase(long j) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.fw = true;
        if (j == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.pr = j;
    }

    public YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    @Override // com.byazt.fty.vk
    public int pr() {
        List<YogaNodeJNIBase> list = this.hn;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.byazt.fty.vk
    /* JADX INFO: renamed from: hn, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase pr(int i) {
        List<YogaNodeJNIBase> list = this.hn;
        if (list == null) {
            throw new IllegalStateException("YogaNode does not have children");
        }
        return list.get(i);
    }

    @Override // com.byazt.fty.vk
    public void pr(vk vkVar, int i) {
        if (!(vkVar instanceof YogaNodeJNIBase)) {
            return;
        }
        YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) vkVar;
        if (yogaNodeJNIBase.hw != null) {
            throw new IllegalStateException("Child already has a parent, it must be removed first.");
        }
        if (this.hn == null) {
            this.hn = new ArrayList(4);
        }
        this.hn.add(i, yogaNodeJNIBase);
        yogaNodeJNIBase.hw = this;
        YogaNative.jni_YGNodeInsertChildJNI(this.pr, yogaNodeJNIBase.pr, i);
    }

    @Override // com.byazt.fty.vk
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase hw(int i) {
        List<YogaNodeJNIBase> list = this.hn;
        if (list == null) {
            throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
        }
        YogaNodeJNIBase yogaNodeJNIBaseRemove = list.remove(i);
        yogaNodeJNIBaseRemove.hw = null;
        YogaNative.jni_YGNodeRemoveChildJNI(this.pr, yogaNodeJNIBaseRemove.pr);
        return yogaNodeJNIBaseRemove;
    }

    @Override // com.byazt.fty.vk
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase hw() {
        return this.hw;
    }

    @Override // com.byazt.fty.vk
    public int pr(vk vkVar) {
        List<YogaNodeJNIBase> list = this.hn;
        if (list == null) {
            return -1;
        }
        return list.indexOf(vkVar);
    }

    @Override // com.byazt.fty.vk
    public void pr(float f, float f2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i = 0; i < arrayList.size(); i++) {
            List<YogaNodeJNIBase> list = ((YogaNodeJNIBase) arrayList.get(i)).hn;
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
            jArr[i2] = yogaNodeJNIBaseArr[i2].pr;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.pr, f, f2, jArr, yogaNodeJNIBaseArr);
    }

    @Override // com.byazt.fty.vk
    public void pr(hn hnVar) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.pr, hnVar.pr());
    }

    @Override // com.byazt.fty.vk
    public void pr(c cVar) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.pr, cVar.pr());
    }

    @Override // com.byazt.fty.vk
    public void pr(uc ucVar) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.pr, ucVar.pr());
    }

    @Override // com.byazt.fty.vk
    public void pr(pr prVar) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.pr, prVar.pr());
    }

    @Override // com.byazt.fty.vk
    public void hw(pr prVar) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.pr, prVar.pr());
    }

    @Override // com.byazt.fty.vk
    public void hn(pr prVar) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.pr, prVar.pr());
    }

    @Override // com.byazt.fty.vk
    public void pr(m mVar) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.pr, mVar.pr());
    }

    @Override // com.byazt.fty.vk
    public void pr(g gVar) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.pr, gVar.pr());
    }

    @Override // com.byazt.fty.vk
    public void pr(float f) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.pr, f);
    }

    @Override // com.byazt.fty.vk
    public void hw(float f) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.pr, f);
    }

    @Override // com.byazt.fty.vk
    public void hn(float f) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.pr, f);
    }

    @Override // com.byazt.fty.vk
    public void hn() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.pr);
    }

    @Override // com.byazt.fty.vk
    public void pr(x xVar, float f) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.pr, xVar.pr(), f);
    }

    @Override // com.byazt.fty.vk
    public void hw(x xVar, float f) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.pr, xVar.pr(), f);
    }

    @Override // com.byazt.fty.vk
    public void hn(x xVar, float f) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.pr, xVar.pr(), f);
    }

    @Override // com.byazt.fty.vk
    public void x(float f) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.pr, f);
    }

    @Override // com.byazt.fty.vk
    public void c(float f) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.pr, f);
    }

    @Override // com.byazt.fty.vk
    public void x() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.pr);
    }

    @Override // com.byazt.fty.vk
    public void uc(float f) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.pr, f);
    }

    @Override // com.byazt.fty.vk
    public void fw(float f) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.pr, f);
    }

    @Override // com.byazt.fty.vk
    public void c() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.pr);
    }

    @Override // com.byazt.fty.vk
    public void zo(float f) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.pr, f);
    }

    @Override // com.byazt.fty.vk
    public void aj(float f) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.pr, f);
    }

    @Override // com.byazt.fty.vk
    public void vk(float f) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.pr, f);
    }

    @Override // com.byazt.fty.vk
    public void w(float f) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.pr, f);
    }

    @Override // com.byazt.fty.vk
    public void k(float f) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.pr, f);
    }

    @Override // com.byazt.fty.vk
    public void pr(fw fwVar) {
        this.x = fwVar;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.pr, fwVar != null);
    }

    @Override // com.byazt.fty.vk
    public void pr(boolean z) {
        YogaNative.jni_YGNodeSetAlwaysFormsContainingBlockJNI(this.pr, z);
    }

    public final long measure(float f, int i, float f2, int i2) {
        if (!k()) {
            throw new RuntimeException("Measure function isn't defined!");
        }
        return this.x.pr(this, f, zo.pr(i), f2, zo.pr(i2));
    }

    public final float baseline(float f, float f2) {
        return this.c.pr(this, f, f2);
    }

    public boolean k() {
        return this.x != null;
    }

    @Override // com.byazt.fty.vk
    public void pr(Object obj) {
        this.uc = obj;
    }

    @Override // com.byazt.fty.vk
    public Object vk() {
        return this.uc;
    }

    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i) {
        List<YogaNodeJNIBase> list = this.hn;
        if (list == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        list.remove(i);
        this.hn.add(i, yogaNodeJNIBase);
        yogaNodeJNIBase.hw = this;
        return yogaNodeJNIBase.pr;
    }

    @Override // com.byazt.fty.vk
    public float uc() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    @Override // com.byazt.fty.vk
    public float fw() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    @Override // com.byazt.fty.vk
    public float zo() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    @Override // com.byazt.fty.vk
    public float aj() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }
}
