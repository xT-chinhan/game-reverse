package android.support.constraint.motion;

import android.os.Build;
import android.support.constraint.ConstraintAttribute;
import android.support.constraint.motion.utils.CurveFit;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public abstract class TimeCycleSplineSet {
    private static final int CURVE_OFFSET = 2;
    private static final int CURVE_PERIOD = 1;
    private static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    private static float VAL_2PI = 6.2831855f;
    private int count;
    long last_time;
    protected CurveFit mCurveFit;
    private String mType;
    protected int mWaveShape = 0;
    protected int[] mTimePoints = new int[10];
    protected float[][] mValues = (float[][]) Array.newInstance((Class<?>) float.class, 10, 3);
    private float[] mCache = new float[3];
    protected boolean mContinue = false;
    float last_cycle = Float.NaN;

    public abstract boolean setProperty(View view, float f, long j, KeyCache keyCache);

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

    public float get(float pos, long time, View view, KeyCache cache) {
        this.mCurveFit.getPos(pos, this.mCache);
        float[] fArr = this.mCache;
        boolean z = true;
        float period = fArr[1];
        if (period == 0.0f) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.last_cycle)) {
            float floatValue = cache.getFloatValue(view, this.mType, 0);
            this.last_cycle = floatValue;
            if (Float.isNaN(floatValue)) {
                this.last_cycle = 0.0f;
            }
        }
        long delta_time = time - this.last_time;
        float f = (float) ((((double) this.last_cycle) + ((delta_time * 1.0E-9d) * ((double) period))) % 1.0d);
        this.last_cycle = f;
        cache.setFloatValue(view, this.mType, 0, f);
        this.last_time = time;
        float v = this.mCache[0];
        float wave = calcWave(this.last_cycle);
        float offset = this.mCache[2];
        float value = (v * wave) + offset;
        if (v == 0.0f && period == 0.0f) {
            z = false;
        }
        this.mContinue = z;
        return value;
    }

    protected float calcWave(float period) {
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(VAL_2PI * period);
            case 2:
                return 1.0f - Math.abs(period);
            case 3:
                return (((period * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                return 1.0f - (((period * 2.0f) + 1.0f) % 2.0f);
            case 5:
                return (float) Math.cos(VAL_2PI * period);
            case 6:
                float x = 1.0f - Math.abs(((period * 4.0f) % 4.0f) - 2.0f);
                return 1.0f - (x * x);
            default:
                return (float) Math.sin(VAL_2PI * period);
        }
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    static TimeCycleSplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> attrList) {
        return new CustomSet(str, attrList);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:41:0x0087  */
    static TimeCycleSplineSet makeSpline(String str, long currentTime) {
        TimeCycleSplineSet timeCycle;
        switch (str) {
            case "alpha":
                timeCycle = new AlphaSet();
                break;
            case "elevation":
                timeCycle = new ElevationSet();
                break;
            case "rotation":
                timeCycle = new RotationSet();
                break;
            case "rotationX":
                timeCycle = new RotationXset();
                break;
            case "rotationY":
                timeCycle = new RotationYset();
                break;
            case "transitionPathRotate":
                timeCycle = new PathRotate();
                break;
            case "scaleX":
                timeCycle = new ScaleXset();
                break;
            case "scaleY":
                timeCycle = new ScaleYset();
                break;
            case "translationX":
                timeCycle = new TranslationXset();
                break;
            case "translationY":
                timeCycle = new TranslationYset();
                break;
            case "translationZ":
                timeCycle = new TranslationZset();
                break;
            case "progress":
                timeCycle = new ProgressSet();
                break;
            default:
                return null;
        }
        timeCycle.setStartTime(currentTime);
        return timeCycle;
    }

    protected void setStartTime(long currentTime) {
        this.last_time = currentTime;
    }

    public void setPoint(int position, float value, float period, int shape, float offset) {
        int[] iArr = this.mTimePoints;
        int i = this.count;
        iArr[i] = position;
        float[] fArr = this.mValues[i];
        fArr[0] = value;
        fArr[1] = period;
        fArr[2] = offset;
        this.mWaveShape = Math.max(this.mWaveShape, shape);
        this.count++;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0065  */
    public void setup(int curveType) {
        int i = this.count;
        if (i == 0) {
            Log.e(TAG, "Error no points added to " + this.mType);
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i - 1);
        int unique = 0;
        int i2 = 1;
        while (true) {
            int[] iArr = this.mTimePoints;
            if (i2 >= iArr.length) {
                break;
            }
            if (iArr[i2] != iArr[i2 - 1]) {
                unique++;
            }
            i2++;
        }
        if (unique == 0) {
            unique = 1;
        }
        double[] time = new double[unique];
        double[][] values = (double[][]) Array.newInstance((Class<?>) double.class, unique, 3);
        int k = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            if (i3 > 0) {
                int[] iArr2 = this.mTimePoints;
                if (iArr2[i3] != iArr2[i3 - 1]) {
                    time[k] = ((double) this.mTimePoints[i3]) * 0.01d;
                    double[] dArr = values[k];
                    float[] fArr = this.mValues[i3];
                    dArr[0] = fArr[0];
                    values[k][1] = fArr[1];
                    values[k][2] = fArr[2];
                    k++;
                }
            } else {
                time[k] = ((double) this.mTimePoints[i3]) * 0.01d;
                double[] dArr2 = values[k];
                float[] fArr2 = this.mValues[i3];
                dArr2[0] = fArr2[0];
                values[k][1] = fArr2[1];
                values[k][2] = fArr2[2];
                k++;
            }
        }
        this.mCurveFit = CurveFit.get(curveType, time, values);
    }

    static class ElevationSet extends TimeCycleSplineSet {
        ElevationSet() {
        }

        @Override // android.support.constraint.motion.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(get(t, time, view, cache));
            }
            return this.mContinue;
        }
    }

    static class AlphaSet extends TimeCycleSplineSet {
        AlphaSet() {
        }

        @Override // android.support.constraint.motion.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setAlpha(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    static class RotationSet extends TimeCycleSplineSet {
        RotationSet() {
        }

        @Override // android.support.constraint.motion.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setRotation(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    static class RotationXset extends TimeCycleSplineSet {
        RotationXset() {
        }

        @Override // android.support.constraint.motion.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setRotationX(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    static class RotationYset extends TimeCycleSplineSet {
        RotationYset() {
        }

        @Override // android.support.constraint.motion.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setRotationY(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    static class PathRotate extends TimeCycleSplineSet {
        PathRotate() {
        }

        @Override // android.support.constraint.motion.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            return this.mContinue;
        }

        public boolean setPathRotate(View view, KeyCache cache, float t, long time, double dx, double dy) {
            view.setRotation(get(t, time, view, cache) + ((float) Math.toDegrees(Math.atan2(dy, dx))));
            return this.mContinue;
        }
    }

    static class ScaleXset extends TimeCycleSplineSet {
        ScaleXset() {
        }

        @Override // android.support.constraint.motion.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setScaleX(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    static class ScaleYset extends TimeCycleSplineSet {
        ScaleYset() {
        }

        @Override // android.support.constraint.motion.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setScaleY(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    static class TranslationXset extends TimeCycleSplineSet {
        TranslationXset() {
        }

        @Override // android.support.constraint.motion.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setTranslationX(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    static class TranslationYset extends TimeCycleSplineSet {
        TranslationYset() {
        }

        @Override // android.support.constraint.motion.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            view.setTranslationY(get(t, time, view, cache));
            return this.mContinue;
        }
    }

    static class TranslationZset extends TimeCycleSplineSet {
        TranslationZset() {
        }

        @Override // android.support.constraint.motion.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(get(t, time, view, cache));
            }
            return this.mContinue;
        }
    }

    static class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        float[] mCache;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties = new SparseArray<>();

        public CustomSet(String attribute, SparseArray<ConstraintAttribute> attrList) {
            this.mAttributeName = attribute.split(",")[1];
            this.mConstraintAttributeList = attrList;
        }

        @Override // android.support.constraint.motion.TimeCycleSplineSet
        public void setup(int curveType) {
            int size = this.mConstraintAttributeList.size();
            int dimensionality = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] time = new double[size];
            this.mTempValues = new float[dimensionality + 2];
            this.mCache = new float[dimensionality];
            double[][] values = (double[][]) Array.newInstance((Class<?>) double.class, size, dimensionality + 2);
            for (int i = 0; i < size; i++) {
                int key = this.mConstraintAttributeList.keyAt(i);
                ConstraintAttribute ca = this.mConstraintAttributeList.valueAt(i);
                float[] waveProp = this.mWaveProperties.valueAt(i);
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
                values[i][dimensionality] = waveProp[0];
                values[i][dimensionality + 1] = waveProp[1];
            }
            this.mCurveFit = CurveFit.get(curveType, time, values);
        }

        @Override // android.support.constraint.motion.TimeCycleSplineSet
        public void setPoint(int position, float value, float period, int shape, float offset) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void setPoint(int position, ConstraintAttribute value, float period, int shape, float offset) {
            this.mConstraintAttributeList.append(position, value);
            this.mWaveProperties.append(position, new float[]{period, offset});
            this.mWaveShape = Math.max(this.mWaveShape, shape);
        }

        @Override // android.support.constraint.motion.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            this.mCurveFit.getPos(t, this.mTempValues);
            float[] fArr = this.mTempValues;
            float period = fArr[fArr.length - 2];
            float offset = fArr[fArr.length - 1];
            long delta_time = time - this.last_time;
            if (Float.isNaN(this.last_cycle)) {
                this.last_cycle = cache.getFloatValue(view, this.mAttributeName, 0);
                if (Float.isNaN(this.last_cycle)) {
                    this.last_cycle = 0.0f;
                }
            }
            this.last_cycle = (float) ((((double) this.last_cycle) + ((delta_time * 1.0E-9d) * ((double) period))) % 1.0d);
            this.last_time = time;
            float wave = calcWave(this.last_cycle);
            this.mContinue = false;
            for (int i = 0; i < this.mCache.length; i++) {
                this.mContinue |= ((double) this.mTempValues[i]) != 0.0d;
                this.mCache[i] = (this.mTempValues[i] * wave) + offset;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mCache);
            if (period != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }
    }

    static class ProgressSet extends TimeCycleSplineSet {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        @Override // android.support.constraint.motion.TimeCycleSplineSet
        public boolean setProperty(View view, float t, long time, KeyCache cache) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(t, time, view, cache));
            } else {
                if (this.mNoMethod) {
                    return false;
                }
                try {
                    Method method2 = view.getClass().getMethod("setProgress", Float.TYPE);
                    method = method2;
                } catch (NoSuchMethodException e) {
                    this.mNoMethod = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(get(t, time, view, cache)));
                    } catch (IllegalAccessException e2) {
                        Log.e(TimeCycleSplineSet.TAG, "unable to setProgress", e2);
                    } catch (InvocationTargetException e3) {
                        Log.e(TimeCycleSplineSet.TAG, "unable to setProgress", e3);
                    }
                }
            }
            return this.mContinue;
        }
    }

    private static class Sort {
        private Sort() {
        }

        static void doubleQuickSort(int[] key, float[][] value, int low, int hi) {
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

        private static int partition(int[] array, float[][] value, int low, int hi) {
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

        private static void swap(int[] array, float[][] value, int a, int b) {
            int tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
            float[] tmpv = value[a];
            value[a] = value[b];
            value[b] = tmpv;
        }
    }
}
