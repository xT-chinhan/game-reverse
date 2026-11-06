package com.byakv.b;

import com.byazt.gr.fs;
import com.byazt.gr.l;
import com.byazt.gr.n;
import com.byazt.gr.oa;
import com.byazt.gr.q;
import com.byazt.gr.qg;
import com.byazt.gr.s;
import com.byazt.gr.sz;
import com.byazt.gr.tj;
import com.byazt.gr.w;
import com.byazt.gr.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class YogaNodeJNIBase extends tj implements Cloneable {
    public float[] arr;
    public qg l;
    public int mLayoutDirection;
    public long n;
    public x q;
    public YogaNodeJNIBase qg;
    public List<YogaNodeJNIBase> s;
    public Object w;
    public boolean x;

    private YogaNodeJNIBase(long j) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.x = true;
        if (j == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.n = j;
    }

    public YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    @Override // com.byazt.gr.tj
    public int n() {
        List<YogaNodeJNIBase> list = this.s;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.byazt.gr.tj
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase n(int i) {
        List<YogaNodeJNIBase> list = this.s;
        if (list == null) {
            throw new IllegalStateException("YogaNode does not have children");
        }
        return list.get(i);
    }

    @Override // com.byazt.gr.tj
    public void n(tj tjVar, int i) {
        if (tjVar instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) tjVar;
            if (yogaNodeJNIBase.qg != null) {
                throw new IllegalStateException("Child already has a parent, it must be removed first.");
            }
            if (this.s == null) {
                this.s = new ArrayList(4);
            }
            this.s.add(i, yogaNodeJNIBase);
            yogaNodeJNIBase.qg = this;
            YogaNative.jni_YGNodeInsertChildJNI(this.n, yogaNodeJNIBase.n, i);
        }
    }

    @Override // com.byazt.gr.tj
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase qg(int i) {
        List<YogaNodeJNIBase> list = this.s;
        if (list == null) {
            throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
        }
        YogaNodeJNIBase yogaNodeJNIBaseRemove = list.remove(i);
        yogaNodeJNIBaseRemove.qg = null;
        YogaNative.jni_YGNodeRemoveChildJNI(this.n, yogaNodeJNIBaseRemove.n);
        return yogaNodeJNIBaseRemove;
    }

    @Override // com.byazt.gr.tj
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase qg() {
        return this.qg;
    }

    @Override // com.byazt.gr.tj
    public int n(tj tjVar) {
        List<YogaNodeJNIBase> list = this.s;
        if (list == null) {
            return -1;
        }
        return list.indexOf(tjVar);
    }

    @Override // com.byazt.gr.tj
    public void n(float f, float f2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i = 0; i < arrayList.size(); i++) {
            List<YogaNodeJNIBase> list = ((YogaNodeJNIBase) arrayList.get(i)).s;
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
            jArr[i2] = yogaNodeJNIBaseArr[i2].n;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.n, f, f2, jArr, yogaNodeJNIBaseArr);
    }

    @Override // com.byazt.gr.tj
    public void s() {
        YogaNative.jni_YGNodeMarkDirtyJNI(this.n);
    }

    @Override // com.byazt.gr.tj
    public void n(s sVar) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.n, sVar.n());
    }

    @Override // com.byazt.gr.tj
    public void n(l lVar) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.n, lVar.n());
    }

    @Override // com.byazt.gr.tj
    public void n(w wVar) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.n, wVar.n());
    }

    @Override // com.byazt.gr.tj
    public void n(n nVar) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.n, nVar.n());
    }

    @Override // com.byazt.gr.tj
    public void qg(n nVar) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.n, nVar.n());
    }

    @Override // com.byazt.gr.tj
    public void s(n nVar) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.n, nVar.n());
    }

    @Override // com.byazt.gr.tj
    public void n(oa oaVar) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.n, oaVar.n());
    }

    @Override // com.byazt.gr.tj
    public void n(sz szVar) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.n, szVar.n());
    }

    @Override // com.byazt.gr.tj
    public void n(float f) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.n, f);
    }

    @Override // com.byazt.gr.tj
    public void qg(float f) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.n, f);
    }

    @Override // com.byazt.gr.tj
    public void s(float f) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.n, f);
    }

    @Override // com.byazt.gr.tj
    public void q() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.n);
    }

    @Override // com.byazt.gr.tj
    public void n(q qVar, float f) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.n, qVar.n(), f);
    }

    @Override // com.byazt.gr.tj
    public void qg(q qVar, float f) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.n, qVar.n(), f);
    }

    @Override // com.byazt.gr.tj
    public void s(q qVar, float f) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.n, qVar.n(), f);
    }

    @Override // com.byazt.gr.tj
    public void q(float f) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.n, f);
    }

    @Override // com.byazt.gr.tj
    public void l(float f) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.n, f);
    }

    @Override // com.byazt.gr.tj
    public void l() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.n);
    }

    @Override // com.byazt.gr.tj
    public void w(float f) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.n, f);
    }

    @Override // com.byazt.gr.tj
    public void x(float f) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.n, f);
    }

    @Override // com.byazt.gr.tj
    public void w() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.n);
    }

    @Override // com.byazt.gr.tj
    public void fs(float f) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.n, f);
    }

    @Override // com.byazt.gr.tj
    public void rv(float f) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.n, f);
    }

    @Override // com.byazt.gr.tj
    public void tj(float f) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.n, f);
    }

    @Override // com.byazt.gr.tj
    public void cp(float f) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.n, f);
    }

    @Override // com.byazt.gr.tj
    public void d(float f) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.n, f);
    }

    @Override // com.byazt.gr.tj
    public void n(x xVar) {
        this.q = xVar;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.n, xVar != null);
    }

    @Override // com.byazt.gr.tj
    public void n(boolean z) {
        YogaNative.jni_YGNodeSetAlwaysFormsContainingBlockJNI(this.n, z);
    }

    public final long measure(float f, int i, float f2, int i2) {
        if (!oa()) {
            throw new RuntimeException("Measure function isn't defined!");
        }
        return this.q.n(this, f, fs.n(i), f2, fs.n(i2));
    }

    public final float baseline(float f, float f2) {
        return this.l.n(this, f, f2);
    }

    public boolean oa() {
        return this.q != null;
    }

    @Override // com.byazt.gr.tj
    public void n(Object obj) {
        this.w = obj;
    }

    @Override // com.byazt.gr.tj
    public Object cp() {
        return this.w;
    }

    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i) {
        List<YogaNodeJNIBase> list = this.s;
        if (list == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        list.remove(i);
        this.s.add(i, yogaNodeJNIBase);
        yogaNodeJNIBase.qg = this;
        return yogaNodeJNIBase.n;
    }

    @Override // com.byazt.gr.tj
    public float x() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    @Override // com.byazt.gr.tj
    public float fs() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    @Override // com.byazt.gr.tj
    public float rv() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    @Override // com.byazt.gr.tj
    public float tj() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }
}
