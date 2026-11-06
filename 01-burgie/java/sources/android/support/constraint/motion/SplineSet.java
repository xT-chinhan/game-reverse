package android.support.constraint.motion;

import android.os.Build;
import android.support.constraint.ConstraintAttribute;
import android.support.constraint.motion.utils.CurveFit;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.umeng.analytics.pro.cc;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class SplineSet {
    private static final String TAG = "SplineSet";
    private int count;
    protected CurveFit mCurveFit;
    private String mType;
    protected int[] mTimePoints = new int[10];
    protected float[] mValues = new float[10];

    public abstract void setProperty(View view, float f);

    public String toString() {
        String str = this.mType;
        DecimalFormat df = new DecimalFormat("##.##");
        for (int i = 0; i < this.count; i++) {
            str = str + "[" + this.mTimePoints[i] + " , " + df.format(this.mValues[i]) + "] ";
        }
        return str;
    }

    public void setType(String type) {
        this.mType = type;
    }

    public float get(float t) {
        return (float) this.mCurveFit.getPos(t, 0);
    }

    public float getSlope(float t) {
        return (float) this.mCurveFit.getSlope(t, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    static SplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> attrList) {
        return new CustomSet(str, attrList);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:53:0x00b8  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static SplineSet makeSpline(String str) {
        byte b;
        switch (str.hashCode()) {
            case -1249320806:
                if (!str.equals("rotationX")) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            case -1249320805:
                if (!str.equals("rotationY")) {
                    b = -1;
                } else {
                    b = 4;
                }
                break;
            case -1225497657:
                if (!str.equals("translationX")) {
                    b = -1;
                } else {
                    b = 12;
                }
                break;
            case -1225497656:
                if (!str.equals("translationY")) {
                    b = -1;
                } else {
                    b = cc.k;
                }
                break;
            case -1225497655:
                if (!str.equals("translationZ")) {
                    b = -1;
                } else {
                    b = cc.l;
                }
                break;
            case -1001078227:
                if (!str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                    b = -1;
                } else {
                    b = cc.m;
                }
                break;
            case -908189618:
                if (!str.equals("scaleX")) {
                    b = -1;
                } else {
                    b = 8;
                }
                break;
            case -908189617:
                if (!str.equals("scaleY")) {
                    b = -1;
                } else {
                    b = 9;
                }
                break;
            case -797520672:
                if (!str.equals("waveVariesBy")) {
                    b = -1;
                } else {
                    b = 11;
                }
                break;
            case -760884510:
                if (!str.equals("transformPivotX")) {
                    b = -1;
                } else {
                    b = 5;
                }
                break;
            case -760884509:
                if (!str.equals("transformPivotY")) {
                    b = -1;
                } else {
                    b = 6;
                }
                break;
            case -40300674:
                if (!str.equals("rotation")) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case -4379043:
                if (!str.equals("elevation")) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case 37232917:
                if (!str.equals("transitionPathRotate")) {
                    b = -1;
                } else {
                    b = 7;
                }
                break;
            case 92909918:
                if (!str.equals("alpha")) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            case 156108012:
                if (!str.equals("waveOffset")) {
                    b = -1;
                } else {
                    b = 10;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                return new AlphaSet();
            case 1:
                return new ElevationSet();
            case 2:
                return new RotationSet();
            case 3:
                return new RotationXset();
            case 4:
                return new RotationYset();
            case 5:
                return new PivotXset();
            case 6:
                return new PivotYset();
            case 7:
                return new PathRotate();
            case 8:
                return new ScaleXset();
            case 9:
                return new ScaleYset();
            case 10:
                return new AlphaSet();
            case 11:
                return new AlphaSet();
            case 12:
                return new TranslationXset();
            case 13:
                return new TranslationYset();
            case 14:
                return new TranslationZset();
            case 15:
                return new ProgressSet();
            default:
                return null;
        }
    }

    public void setPoint(int position, float value) {
        int[] iArr = this.mTimePoints;
        if (iArr.length < this.count + 1) {
            this.mTimePoints = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValues;
            this.mValues = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTimePoints;
        int i = this.count;
        iArr2[i] = position;
        this.mValues[i] = value;
        this.count = i + 1;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0048  */
    public void setup(int curveType) {
        int i = this.count;
        if (i == 0) {
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i - 1);
        int unique = 1;
        for (int i2 = 1; i2 < this.count; i2++) {
            int[] iArr = this.mTimePoints;
            if (iArr[i2 - 1] != iArr[i2]) {
                unique++;
            }
        }
        double[] time = new double[unique];
        double[][] values = (double[][]) Array.newInstance((Class<?>) double.class, unique, 1);
        int k = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            if (i3 > 0) {
                int[] iArr2 = this.mTimePoints;
                if (iArr2[i3] != iArr2[i3 - 1]) {
                    time[k] = ((double) this.mTimePoints[i3]) * 0.01d;
                    values[k][0] = this.mValues[i3];
                    k++;
                }
            } else {
                time[k] = ((double) this.mTimePoints[i3]) * 0.01d;
                values[k][0] = this.mValues[i3];
                k++;
            }
        }
        this.mCurveFit = CurveFit.get(curveType, time, values);
    }

    static class ElevationSet extends SplineSet {
        ElevationSet() {
        }

        @Override // android.support.constraint.motion.SplineSet
        public void setProperty(View view, float t) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(get(t));
            }
        }
    }

    static class AlphaSet extends SplineSet {
        AlphaSet() {
        }

        @Override // android.support.constraint.motion.SplineSet
        public void setProperty(View view, float t) {
            view.setAlpha(get(t));
        }
    }

    static class RotationSet extends SplineSet {
        RotationSet() {
        }

        @Override // android.support.constraint.motion.SplineSet
        public void setProperty(View view, float t) {
            view.setRotation(get(t));
        }
    }

    static class RotationXset extends SplineSet {
        RotationXset() {
        }

        @Override // android.support.constraint.motion.SplineSet
        public void setProperty(View view, float t) {
            view.setRotationX(get(t));
        }
    }

    static class RotationYset extends SplineSet {
        RotationYset() {
        }

        @Override // android.support.constraint.motion.SplineSet
        public void setProperty(View view, float t) {
            view.setRotationY(get(t));
        }
    }

    static class PivotXset extends SplineSet {
        PivotXset() {
        }

        @Override // android.support.constraint.motion.SplineSet
        public void setProperty(View view, float t) {
            view.setPivotX(get(t));
        }
    }

    static class PivotYset extends SplineSet {
        PivotYset() {
        }

        @Override // android.support.constraint.motion.SplineSet
        public void setProperty(View view, float t) {
            view.setPivotY(get(t));
        }
    }

    static class PathRotate extends SplineSet {
        PathRotate() {
        }

        @Override // android.support.constraint.motion.SplineSet
        public void setProperty(View view, float t) {
        }

        public void setPathRotate(View view, float t, double dx, double dy) {
            view.setRotation(get(t) + ((float) Math.toDegrees(Math.atan2(dy, dx))));
        }
    }

    static class ScaleXset extends SplineSet {
        ScaleXset() {
        }

        @Override // android.support.constraint.motion.SplineSet
        public void setProperty(View view, float t) {
            view.setScaleX(get(t));
        }
    }

    static class ScaleYset extends SplineSet {
        ScaleYset() {
        }

        @Override // android.support.constraint.motion.SplineSet
        public void setProperty(View view, float t) {
            view.setScaleY(get(t));
        }
    }

    static class TranslationXset extends SplineSet {
        TranslationXset() {
        }

        @Override // android.support.constraint.motion.SplineSet
        public void setProperty(View view, float t) {
            view.setTranslationX(get(t));
        }
    }

    static class TranslationYset extends SplineSet {
        TranslationYset() {
        }

        @Override // android.support.constraint.motion.SplineSet
        public void setProperty(View view, float t) {
            view.setTranslationY(get(t));
        }
    }

    static class TranslationZset extends SplineSet {
        TranslationZset() {
        }

        @Override // android.support.constraint.motion.SplineSet
        public void setProperty(View view, float t) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(get(t));
            }
        }
    }

    static class CustomSet extends SplineSet {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String attribute, SparseArray<ConstraintAttribute> attrList) {
            this.mAttributeName = attribute.split(",")[1];
            this.mConstraintAttributeList = attrList;
        }

        @Override // android.support.constraint.motion.SplineSet
        public void setup(int curveType) {
            int size = this.mConstraintAttributeList.size();
            int dimensionality = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] time = new double[size];
            this.mTempValues = new float[dimensionality];
            double[][] values = (double[][]) Array.newInstance((Class<?>) double.class, size, dimensionality);
            for (int i = 0; i < size; i++) {
                int key = this.mConstraintAttributeList.keyAt(i);
                ConstraintAttribute ca = this.mConstraintAttributeList.valueAt(i);
                time[i] = ((double) key) * 0.01d;
                ca.getValuesToInterpolate(this.mTempValues);
                int k = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (k < fArr.length) {
                        values[i][k] = fArr[k];
                        k++;
                    }
                }
            }
            this.mCurveFit = CurveFit.get(curveType, time, values);
        }

        @Override // android.support.constraint.motion.SplineSet
        public void setPoint(int position, float value) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setPoint(int position, ConstraintAttribute value) {
            this.mConstraintAttributeList.append(position, value);
        }

        @Override // android.support.constraint.motion.SplineSet
        public void setProperty(View view, float t) {
            this.mCurveFit.getPos(t, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mTempValues);
        }
    }

    static class ProgressSet extends SplineSet {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        @Override // android.support.constraint.motion.SplineSet
        public void setProperty(View view, float t) throws NoSuchMethodException {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(t));
                return;
            }
            if (this.mNoMethod) {
                return;
            }
            Method method = null;
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException e) {
                this.mNoMethod = true;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(get(t)));
                } catch (IllegalAccessException e2) {
                    Log.e(SplineSet.TAG, "unable to setProgress", e2);
                } catch (InvocationTargetException e3) {
                    Log.e(SplineSet.TAG, "unable to setProgress", e3);
                }
            }
        }
    }

    private static class Sort {
        private Sort() {
        }

        static void doubleQuickSort(int[] key, float[] value, int low, int hi) {
            int[] stack = new int[key.length + 10];
            int count = 0 + 1;
            stack[0] = hi;
            int count2 = count + 1;
            stack[count] = low;
            while (count2 > 0) {
                int count3 = count2 - 1;
                int low2 = stack[count3];
                count2 = count3 - 1;
                int hi2 = stack[count2];
                if (low2 < hi2) {
                    int p = partition(key, value, low2, hi2);
                    int count4 = count2 + 1;
                    stack[count2] = p - 1;
                    int count5 = count4 + 1;
                    stack[count4] = low2;
                    int count6 = count5 + 1;
                    stack[count5] = hi2;
                    count2 = count6 + 1;
                    stack[count6] = p + 1;
                }
            }
        }

        private static int partition(int[] array, float[] value, int low, int hi) {
            int pivot = array[hi];
            int i = low;
            for (int j = low; j < hi; j++) {
                if (array[j] <= pivot) {
                    swap(array, value, i, j);
                    i++;
                }
            }
            swap(array, value, i, hi);
            return i;
        }

        private static void swap(int[] array, float[] value, int a, int b) {
            int tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
            float tmpv = value[a];
            value[a] = value[b];
            value[b] = tmpv;
        }
    }
}
