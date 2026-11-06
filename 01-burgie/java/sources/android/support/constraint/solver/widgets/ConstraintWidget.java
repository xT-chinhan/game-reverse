package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.analyzer.ChainRun;
import android.support.constraint.solver.widgets.analyzer.HorizontalWidgetRun;
import android.support.constraint.solver.widgets.analyzer.VerticalWidgetRun;
import android.support.constraint.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    private boolean OPTIMIZE_WRAP;
    private boolean OPTIMIZE_WRAP_ON_RESOLVED;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public HorizontalWidgetRun horizontalRun;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    public ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    public ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtuaLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    private int mLastHorizontalMeasureSpec;
    private int mLastVerticalMeasureSpec;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    private boolean mMeasureRequested;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    protected int mX;
    protected int mY;
    public boolean measured;
    private boolean resolvedHorizontal;
    private boolean resolvedVertical;
    public WidgetRun[] run;
    public ChainRun verticalChainRun;
    public int verticalGroup;
    public VerticalWidgetRun verticalRun;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public WidgetRun getRun(int orientation) {
        if (orientation == 0) {
            return this.horizontalRun;
        }
        if (orientation == 1) {
            return this.verticalRun;
        }
        return null;
    }

    public void setFinalFrame(int left, int top, int right, int bottom, int baseline, int orientation) {
        setFrame(left, top, right, bottom);
        setBaselineDistance(baseline);
        if (orientation == 0) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = false;
        } else if (orientation == 1) {
            this.resolvedHorizontal = false;
            this.resolvedVertical = true;
        } else if (orientation == 2) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = true;
        } else {
            this.resolvedHorizontal = false;
            this.resolvedVertical = false;
        }
    }

    public void setFinalLeft(int x1) {
        this.mLeft.setFinalValue(x1);
        this.mX = x1;
    }

    public void setFinalTop(int y1) {
        this.mTop.setFinalValue(y1);
        this.mY = y1;
    }

    public void setFinalHorizontal(int x1, int x2) {
        this.mLeft.setFinalValue(x1);
        this.mRight.setFinalValue(x2);
        this.mX = x1;
        this.mWidth = x2 - x1;
        this.resolvedHorizontal = true;
    }

    public void setFinalVertical(int y1, int y2) {
        this.mTop.setFinalValue(y1);
        this.mBottom.setFinalValue(y2);
        this.mY = y1;
        this.mHeight = y2 - y1;
        if (this.hasBaseline) {
            this.mBaseline.setFinalValue(this.mBaselineDistance + y1);
        }
        this.resolvedVertical = true;
    }

    public void setFinalBaseline(int baselineValue) {
        if (!this.hasBaseline) {
            return;
        }
        int y1 = baselineValue - this.mBaselineDistance;
        int y2 = this.mHeight + y1;
        this.mY = y1;
        this.mTop.setFinalValue(y1);
        this.mBottom.setFinalValue(y2);
        this.mBaseline.setFinalValue(baselineValue);
        this.resolvedVertical = true;
    }

    public boolean isResolvedHorizontally() {
        return this.resolvedHorizontal || (this.mLeft.hasFinalValue() && this.mRight.hasFinalValue());
    }

    public boolean isResolvedVertically() {
        return this.resolvedVertical || (this.mTop.hasFinalValue() && this.mBottom.hasFinalValue());
    }

    public void resetFinalResolution() {
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        int mAnchorsSize = this.mAnchors.size();
        for (int i = 0; i < mAnchorsSize; i++) {
            ConstraintAnchor anchor = this.mAnchors.get(i);
            anchor.resetFinalResolution();
        }
    }

    public void ensureMeasureRequested() {
        this.mMeasureRequested = true;
    }

    public boolean hasDependencies() {
        int mAnchorsSize = this.mAnchors.size();
        for (int i = 0; i < mAnchorsSize; i++) {
            ConstraintAnchor anchor = this.mAnchors.get(i);
            if (anchor.hasDependents()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDanglingDimension(int orientation) {
        if (orientation == 0) {
            int horizontalTargets = (this.mLeft.mTarget != null ? 1 : 0) + (this.mRight.mTarget != null ? 1 : 0);
            return horizontalTargets < 2;
        }
        int verticalTargets = (this.mTop.mTarget != null ? 1 : 0) + (this.mBottom.mTarget != null ? 1 : 0) + (this.mBaseline.mTarget != null ? 1 : 0);
        return verticalTargets < 2;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
    }

    public void setInVirtualLayout(boolean inVirtualLayout) {
        this.mInVirtuaLayout = inVirtualLayout;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public void setMaxWidth(int maxWidth) {
        this.mMaxDimension[0] = maxWidth;
    }

    public void setMaxHeight(int maxHeight) {
        this.mMaxDimension[1] = maxHeight;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void setHasBaseline(boolean hasBaseline) {
        this.hasBaseline = hasBaseline;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public void setInPlaceholder(boolean inPlaceholder) {
        this.inPlaceholder = inPlaceholder;
    }

    protected void setInBarrier(int orientation, boolean value) {
        this.mIsInBarrier[orientation] = value;
    }

    public void setMeasureRequested(boolean measureRequested) {
        this.mMeasureRequested = measureRequested;
    }

    public boolean isMeasureRequested() {
        return this.mMeasureRequested && this.mVisibility != 8;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.mLastHorizontalMeasureSpec;
    }

    public int getLastVerticalMeasureSpec() {
        return this.mLastVerticalMeasureSpec;
    }

    public void setLastMeasureSpec(int horizontal, int vertical) {
        this.mLastHorizontalMeasureSpec = horizontal;
        this.mLastVerticalMeasureSpec = vertical;
        setMeasureRequested(false);
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mGroupsToSolver = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtuaLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
        this.mMeasureRequested = true;
    }

    public boolean oppositeDimensionDependsOn(int orientation) {
        int oppositeOrientation = orientation == 0 ? 1 : 0;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[orientation];
        DimensionBehaviour oppositeDimensionBehaviour = dimensionBehaviourArr[oppositeOrientation];
        return dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT && oppositeDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean oppositeDimensionsTied() {
        return this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
    }

    public ConstraintWidget(String debugName) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
        setDebugName(debugName);
    }

    public ConstraintWidget(int x, int y, int width, int height) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.mX = x;
        this.mY = y;
        this.mWidth = width;
        this.mHeight = height;
        addAnchors();
    }

    public ConstraintWidget(String debugName, int x, int y, int width, int height) {
        this(x, y, width, height);
        setDebugName(debugName);
    }

    public ConstraintWidget(int width, int height) {
        this(0, 0, width, height);
    }

    public void ensureWidgetRuns() {
        if (this.horizontalRun == null) {
            this.horizontalRun = new HorizontalWidgetRun(this);
        }
        if (this.verticalRun == null) {
            this.verticalRun = new VerticalWidgetRun(this);
        }
    }

    public ConstraintWidget(String debugName, int width, int height) {
        this(width, height);
        setDebugName(debugName);
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public void setParent(ConstraintWidget widget) {
        this.mParent = widget;
    }

    public void setWidthWrapContent(boolean widthWrapContent) {
        this.mIsWidthWrapContent = widthWrapContent;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void setHeightWrapContent(boolean heightWrapContent) {
        this.mIsHeightWrapContent = heightWrapContent;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public void connectCircularConstraint(ConstraintWidget target, float angle, int radius) {
        immediateConnect(ConstraintAnchor.Type.CENTER, target, ConstraintAnchor.Type.CENTER, radius, 0);
        this.mCircleConstraintAngle = angle;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String type) {
        this.mType = type;
    }

    public void setVisibility(int visibility) {
        this.mVisibility = visibility;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public void setDebugName(String name) {
        this.mDebugName = name;
    }

    public void setDebugSolverName(LinearSystem system, String name) {
        this.mDebugName = name;
        SolverVariable left = system.createObjectVariable(this.mLeft);
        SolverVariable top = system.createObjectVariable(this.mTop);
        SolverVariable right = system.createObjectVariable(this.mRight);
        SolverVariable bottom = system.createObjectVariable(this.mBottom);
        left.setName(name + ".left");
        top.setName(name + ".top");
        right.setName(name + ".right");
        bottom.setName(name + ".bottom");
        SolverVariable baseline = system.createObjectVariable(this.mBaseline);
        baseline.setName(name + ".baseline");
    }

    public void createObjectVariables(LinearSystem system) {
        system.createObjectVariable(this.mLeft);
        system.createObjectVariable(this.mTop);
        system.createObjectVariable(this.mRight);
        system.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            system.createObjectVariable(this.mBaseline);
        }
    }

    public String toString() {
        return (this.mType != null ? "type: " + this.mType + " " : "") + (this.mDebugName != null ? "id: " + this.mDebugName + " " : "") + "(" + this.mX + ", " + this.mY + ") - (" + this.mWidth + " x " + this.mHeight + ")";
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
            return ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
        }
        return this.mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
            return ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
        }
        return this.mY;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getOptimizerWrapWidth() {
        int w;
        int w2 = this.mWidth;
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultWidth == 1) {
                w = Math.max(this.mMatchConstraintMinWidth, w2);
            } else if (this.mMatchConstraintMinWidth > 0) {
                w = this.mMatchConstraintMinWidth;
                this.mWidth = w;
            } else {
                w = 0;
            }
            int i = this.mMatchConstraintMaxWidth;
            if (i > 0 && i < w) {
                return this.mMatchConstraintMaxWidth;
            }
            return w;
        }
        return w2;
    }

    public int getOptimizerWrapHeight() {
        int h;
        int h2 = this.mHeight;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (this.mMatchConstraintDefaultHeight == 1) {
                h = Math.max(this.mMatchConstraintMinHeight, h2);
            } else if (this.mMatchConstraintMinHeight > 0) {
                h = this.mMatchConstraintMinHeight;
                this.mHeight = h;
            } else {
                h = 0;
            }
            int i = this.mMatchConstraintMaxHeight;
            if (i > 0 && i < h) {
                return this.mMatchConstraintMaxHeight;
            }
            return h;
        }
        return h2;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public int getLength(int orientation) {
        if (orientation == 0) {
            return getWidth();
        }
        if (orientation == 1) {
            return getHeight();
        }
        return 0;
    }

    protected int getRootX() {
        return this.mX + this.mOffsetX;
    }

    protected int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getLeft() {
        return getX();
    }

    public int getTop() {
        return getY();
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public int getHorizontalMargin() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        int margin = constraintAnchor != null ? 0 + constraintAnchor.mMargin : 0;
        ConstraintAnchor constraintAnchor2 = this.mRight;
        if (constraintAnchor2 != null) {
            return margin + constraintAnchor2.mMargin;
        }
        return margin;
    }

    public int getVerticalMargin() {
        int margin = this.mLeft != null ? 0 + this.mTop.mMargin : 0;
        if (this.mRight != null) {
            return margin + this.mBottom.mMargin;
        }
        return margin;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public float getBiasPercent(int orientation) {
        if (orientation == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (orientation == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public void setX(int x) {
        this.mX = x;
    }

    public void setY(int y) {
        this.mY = y;
    }

    public void setOrigin(int x, int y) {
        this.mX = x;
        this.mY = y;
    }

    public void setOffset(int x, int y) {
        this.mOffsetX = x;
        this.mOffsetY = y;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int goneMargin) {
        switch (AnonymousClass1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[type.ordinal()]) {
            case 1:
                this.mLeft.mGoneMargin = goneMargin;
                break;
            case 2:
                this.mTop.mGoneMargin = goneMargin;
                break;
            case 3:
                this.mRight.mGoneMargin = goneMargin;
                break;
            case 4:
                this.mBottom.mGoneMargin = goneMargin;
                break;
        }
    }

    public void setWidth(int w) {
        this.mWidth = w;
        int i = this.mMinWidth;
        if (w < i) {
            this.mWidth = i;
        }
    }

    public void setHeight(int h) {
        this.mHeight = h;
        int i = this.mMinHeight;
        if (h < i) {
            this.mHeight = i;
        }
    }

    public void setLength(int length, int orientation) {
        if (orientation == 0) {
            setWidth(length);
        } else if (orientation == 1) {
            setHeight(length);
        }
    }

    public void setHorizontalMatchStyle(int horizontalMatchStyle, int min, int max, float percent) {
        this.mMatchConstraintDefaultWidth = horizontalMatchStyle;
        this.mMatchConstraintMinWidth = min;
        this.mMatchConstraintMaxWidth = max == Integer.MAX_VALUE ? 0 : max;
        this.mMatchConstraintPercentWidth = percent;
        if (percent > 0.0f && percent < 1.0f && horizontalMatchStyle == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setVerticalMatchStyle(int verticalMatchStyle, int min, int max, float percent) {
        this.mMatchConstraintDefaultHeight = verticalMatchStyle;
        this.mMatchConstraintMinHeight = min;
        this.mMatchConstraintMaxHeight = max == Integer.MAX_VALUE ? 0 : max;
        this.mMatchConstraintPercentHeight = percent;
        if (percent > 0.0f && percent < 1.0f && verticalMatchStyle == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setDimensionRatio(String ratio) {
        int commaIndex;
        if (ratio == null || ratio.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int dimensionRatioSide = -1;
        float dimensionRatio = 0.0f;
        int len = ratio.length();
        int commaIndex2 = ratio.indexOf(44);
        if (commaIndex2 > 0 && commaIndex2 < len - 1) {
            String dimension = ratio.substring(0, commaIndex2);
            if (dimension.equalsIgnoreCase("W")) {
                dimensionRatioSide = 0;
            } else if (dimension.equalsIgnoreCase("H")) {
                dimensionRatioSide = 1;
            }
            commaIndex = commaIndex2 + 1;
        } else {
            commaIndex = 0;
        }
        int colonIndex = ratio.indexOf(58);
        if (colonIndex >= 0 && colonIndex < len - 1) {
            String nominator = ratio.substring(commaIndex, colonIndex);
            String denominator = ratio.substring(colonIndex + 1);
            if (nominator.length() > 0 && denominator.length() > 0) {
                try {
                    float nominatorValue = Float.parseFloat(nominator);
                    float denominatorValue = Float.parseFloat(denominator);
                    if (nominatorValue > 0.0f && denominatorValue > 0.0f) {
                        dimensionRatio = dimensionRatioSide == 1 ? Math.abs(denominatorValue / nominatorValue) : Math.abs(nominatorValue / denominatorValue);
                    }
                } catch (NumberFormatException e) {
                }
            }
        } else {
            String r = ratio.substring(commaIndex);
            if (r.length() > 0) {
                try {
                    dimensionRatio = Float.parseFloat(r);
                } catch (NumberFormatException e2) {
                }
            }
        }
        if (dimensionRatio > 0.0f) {
            this.mDimensionRatio = dimensionRatio;
            this.mDimensionRatioSide = dimensionRatioSide;
        }
    }

    public void setDimensionRatio(float ratio, int dimensionRatioSide) {
        this.mDimensionRatio = ratio;
        this.mDimensionRatioSide = dimensionRatioSide;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public void setHorizontalBiasPercent(float horizontalBiasPercent) {
        this.mHorizontalBiasPercent = horizontalBiasPercent;
    }

    public void setVerticalBiasPercent(float verticalBiasPercent) {
        this.mVerticalBiasPercent = verticalBiasPercent;
    }

    public void setMinWidth(int w) {
        if (w < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = w;
        }
    }

    public void setMinHeight(int h) {
        if (h < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = h;
        }
    }

    public void setDimension(int w, int h) {
        this.mWidth = w;
        int i = this.mMinWidth;
        if (w < i) {
            this.mWidth = i;
        }
        this.mHeight = h;
        int i2 = this.mMinHeight;
        if (h < i2) {
            this.mHeight = i2;
        }
    }

    public void setFrame(int left, int top, int right, int bottom) {
        int w = right - left;
        int h = bottom - top;
        this.mX = left;
        this.mY = top;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && w < this.mWidth) {
            w = this.mWidth;
        }
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && h < this.mHeight) {
            h = this.mHeight;
        }
        this.mWidth = w;
        this.mHeight = h;
        int i = this.mMinHeight;
        if (h < i) {
            this.mHeight = i;
        }
        int i2 = this.mMinWidth;
        if (w < i2) {
            this.mWidth = i2;
        }
    }

    public void setFrame(int start, int end, int orientation) {
        if (orientation == 0) {
            setHorizontalDimension(start, end);
        } else if (orientation == 1) {
            setVerticalDimension(start, end);
        }
    }

    public void setHorizontalDimension(int left, int right) {
        this.mX = left;
        int i = right - left;
        this.mWidth = i;
        int i2 = this.mMinWidth;
        if (i < i2) {
            this.mWidth = i2;
        }
    }

    public void setVerticalDimension(int top, int bottom) {
        this.mY = top;
        int i = bottom - top;
        this.mHeight = i;
        int i2 = this.mMinHeight;
        if (i < i2) {
            this.mHeight = i2;
        }
    }

    int getRelativePositioning(int orientation) {
        if (orientation == 0) {
            return this.mRelX;
        }
        if (orientation == 1) {
            return this.mRelY;
        }
        return 0;
    }

    void setRelativePositioning(int offset, int orientation) {
        if (orientation == 0) {
            this.mRelX = offset;
        } else if (orientation == 1) {
            this.mRelY = offset;
        }
    }

    public void setBaselineDistance(int baseline) {
        this.mBaselineDistance = baseline;
        this.hasBaseline = baseline > 0;
    }

    public void setCompanionWidget(Object companion) {
        this.mCompanionWidget = companion;
    }

    public void setContainerItemSkip(int skip) {
        if (skip >= 0) {
            this.mContainerItemSkip = skip;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public void setHorizontalWeight(float horizontalWeight) {
        this.mWeight[0] = horizontalWeight;
    }

    public void setVerticalWeight(float verticalWeight) {
        this.mWeight[1] = verticalWeight;
    }

    public void setHorizontalChainStyle(int horizontalChainStyle) {
        this.mHorizontalChainStyle = horizontalChainStyle;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public void setVerticalChainStyle(int verticalChainStyle) {
        this.mVerticalChainStyle = verticalChainStyle;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void immediateConnect(ConstraintAnchor.Type startType, ConstraintWidget target, ConstraintAnchor.Type endType, int margin, int goneMargin) {
        ConstraintAnchor startAnchor = getAnchor(startType);
        ConstraintAnchor endAnchor = target.getAnchor(endType);
        startAnchor.connect(endAnchor, margin, goneMargin, true);
    }

    public void connect(ConstraintAnchor from, ConstraintAnchor to, int margin) {
        if (from.getOwner() == this) {
            connect(from.getType(), to.getOwner(), to.getType(), margin);
        }
    }

    public void connect(ConstraintAnchor.Type constraintFrom, ConstraintWidget target, ConstraintAnchor.Type constraintTo) {
        connect(constraintFrom, target, constraintTo, 0);
    }

    public void connect(ConstraintAnchor.Type constraintFrom, ConstraintWidget target, ConstraintAnchor.Type constraintTo, int margin) {
        if (constraintFrom == ConstraintAnchor.Type.CENTER) {
            if (constraintTo != ConstraintAnchor.Type.CENTER) {
                if (constraintTo == ConstraintAnchor.Type.LEFT || constraintTo == ConstraintAnchor.Type.RIGHT) {
                    connect(ConstraintAnchor.Type.LEFT, target, constraintTo, 0);
                    connect(ConstraintAnchor.Type.RIGHT, target, constraintTo, 0);
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(target.getAnchor(constraintTo), 0);
                    return;
                } else {
                    if (constraintTo == ConstraintAnchor.Type.TOP || constraintTo == ConstraintAnchor.Type.BOTTOM) {
                        connect(ConstraintAnchor.Type.TOP, target, constraintTo, 0);
                        connect(ConstraintAnchor.Type.BOTTOM, target, constraintTo, 0);
                        getAnchor(ConstraintAnchor.Type.CENTER).connect(target.getAnchor(constraintTo), 0);
                        return;
                    }
                    return;
                }
            }
            ConstraintAnchor left = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor right = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor top = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor bottom = getAnchor(ConstraintAnchor.Type.BOTTOM);
            boolean centerX = false;
            boolean centerY = false;
            if ((left == null || !left.isConnected()) && (right == null || !right.isConnected())) {
                connect(ConstraintAnchor.Type.LEFT, target, ConstraintAnchor.Type.LEFT, 0);
                connect(ConstraintAnchor.Type.RIGHT, target, ConstraintAnchor.Type.RIGHT, 0);
                centerX = true;
            }
            if ((top == null || !top.isConnected()) && (bottom == null || !bottom.isConnected())) {
                connect(ConstraintAnchor.Type.TOP, target, ConstraintAnchor.Type.TOP, 0);
                connect(ConstraintAnchor.Type.BOTTOM, target, ConstraintAnchor.Type.BOTTOM, 0);
                centerY = true;
            }
            if (centerX && centerY) {
                getAnchor(ConstraintAnchor.Type.CENTER).connect(target.getAnchor(ConstraintAnchor.Type.CENTER), 0);
                return;
            } else if (centerX) {
                getAnchor(ConstraintAnchor.Type.CENTER_X).connect(target.getAnchor(ConstraintAnchor.Type.CENTER_X), 0);
                return;
            } else {
                if (centerY) {
                    getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(target.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0);
                    return;
                }
                return;
            }
        }
        if (constraintFrom == ConstraintAnchor.Type.CENTER_X && (constraintTo == ConstraintAnchor.Type.LEFT || constraintTo == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor left2 = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor targetAnchor = target.getAnchor(constraintTo);
            ConstraintAnchor right2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            left2.connect(targetAnchor, 0);
            right2.connect(targetAnchor, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(targetAnchor, 0);
            return;
        }
        if (constraintFrom == ConstraintAnchor.Type.CENTER_Y && (constraintTo == ConstraintAnchor.Type.TOP || constraintTo == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor targetAnchor2 = target.getAnchor(constraintTo);
            getAnchor(ConstraintAnchor.Type.TOP).connect(targetAnchor2, 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(targetAnchor2, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(targetAnchor2, 0);
            return;
        }
        if (constraintFrom == ConstraintAnchor.Type.CENTER_X && constraintTo == ConstraintAnchor.Type.CENTER_X) {
            ConstraintAnchor left3 = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor leftTarget = target.getAnchor(ConstraintAnchor.Type.LEFT);
            left3.connect(leftTarget, 0);
            ConstraintAnchor right3 = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor rightTarget = target.getAnchor(ConstraintAnchor.Type.RIGHT);
            right3.connect(rightTarget, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(target.getAnchor(constraintTo), 0);
            return;
        }
        if (constraintFrom == ConstraintAnchor.Type.CENTER_Y && constraintTo == ConstraintAnchor.Type.CENTER_Y) {
            ConstraintAnchor top2 = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor topTarget = target.getAnchor(ConstraintAnchor.Type.TOP);
            top2.connect(topTarget, 0);
            ConstraintAnchor bottom2 = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor bottomTarget = target.getAnchor(ConstraintAnchor.Type.BOTTOM);
            bottom2.connect(bottomTarget, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(target.getAnchor(constraintTo), 0);
            return;
        }
        ConstraintAnchor fromAnchor = getAnchor(constraintFrom);
        ConstraintAnchor toAnchor = target.getAnchor(constraintTo);
        if (fromAnchor.isValidConnection(toAnchor)) {
            if (constraintFrom == ConstraintAnchor.Type.BASELINE) {
                ConstraintAnchor top3 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor bottom3 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                if (top3 != null) {
                    top3.reset();
                }
                if (bottom3 != null) {
                    bottom3.reset();
                }
                margin = 0;
            } else if (constraintFrom == ConstraintAnchor.Type.TOP || constraintFrom == ConstraintAnchor.Type.BOTTOM) {
                ConstraintAnchor baseline = getAnchor(ConstraintAnchor.Type.BASELINE);
                if (baseline != null) {
                    baseline.reset();
                }
                ConstraintAnchor center = getAnchor(ConstraintAnchor.Type.CENTER);
                if (center.getTarget() != toAnchor) {
                    center.reset();
                }
                ConstraintAnchor opposite = getAnchor(constraintFrom).getOpposite();
                ConstraintAnchor centerY2 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                if (centerY2.isConnected()) {
                    opposite.reset();
                    centerY2.reset();
                }
            } else if (constraintFrom == ConstraintAnchor.Type.LEFT || constraintFrom == ConstraintAnchor.Type.RIGHT) {
                ConstraintAnchor center2 = getAnchor(ConstraintAnchor.Type.CENTER);
                if (center2.getTarget() != toAnchor) {
                    center2.reset();
                }
                ConstraintAnchor opposite2 = getAnchor(constraintFrom).getOpposite();
                ConstraintAnchor centerX2 = getAnchor(ConstraintAnchor.Type.CENTER_X);
                if (centerX2.isConnected()) {
                    opposite2.reset();
                    centerX2.reset();
                }
            }
            fromAnchor.connect(toAnchor, margin);
        }
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor anchor) {
        if (getParent() != null && (getParent() instanceof ConstraintWidgetContainer)) {
            ConstraintWidgetContainer parent = (ConstraintWidgetContainer) getParent();
            if (parent.handlesInternalConstraints()) {
                return;
            }
        }
        ConstraintAnchor left = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor right = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor top = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor bottom = getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor center = getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor centerX = getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor centerY = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (anchor == center) {
            if (left.isConnected() && right.isConnected() && left.getTarget() == right.getTarget()) {
                left.reset();
                right.reset();
            }
            if (top.isConnected() && bottom.isConnected() && top.getTarget() == bottom.getTarget()) {
                top.reset();
                bottom.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
            this.mVerticalBiasPercent = 0.5f;
        } else if (anchor == centerX) {
            if (left.isConnected() && right.isConnected() && left.getTarget().getOwner() == right.getTarget().getOwner()) {
                left.reset();
                right.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
        } else if (anchor == centerY) {
            if (top.isConnected() && bottom.isConnected() && top.getTarget().getOwner() == bottom.getTarget().getOwner()) {
                top.reset();
                bottom.reset();
            }
            this.mVerticalBiasPercent = 0.5f;
        } else if (anchor == left || anchor == right) {
            if (left.isConnected() && left.getTarget() == right.getTarget()) {
                center.reset();
            }
        } else if ((anchor == top || anchor == bottom) && top.isConnected() && top.getTarget() == bottom.getTarget()) {
            center.reset();
        }
        anchor.reset();
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof ConstraintWidgetContainer)) {
            ConstraintWidgetContainer parentContainer = (ConstraintWidgetContainer) getParent();
            if (parentContainer.handlesInternalConstraints()) {
                return;
            }
        }
        int mAnchorsSize = this.mAnchors.size();
        for (int i = 0; i < mAnchorsSize; i++) {
            ConstraintAnchor anchor = this.mAnchors.get(i);
            anchor.reset();
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type anchorType) {
        switch (AnonymousClass1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[anchorType.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            case 9:
                return null;
            default:
                throw new AssertionError(anchorType.name());
        }
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public DimensionBehaviour getDimensionBehaviour(int orientation) {
        if (orientation == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (orientation == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour behaviour) {
        this.mListDimensionBehaviors[0] = behaviour;
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour behaviour) {
        this.mListDimensionBehaviors[1] = behaviour;
    }

    public boolean isInHorizontalChain() {
        if (this.mLeft.mTarget != null && this.mLeft.mTarget.mTarget == this.mLeft) {
            return true;
        }
        if (this.mRight.mTarget != null && this.mRight.mTarget.mTarget == this.mRight) {
            return true;
        }
        return false;
    }

    public ConstraintWidget getPreviousChainMember(int orientation) {
        if (orientation == 0) {
            if (this.mLeft.mTarget == null) {
                return null;
            }
            ConstraintAnchor constraintAnchor = this.mLeft.mTarget.mTarget;
            ConstraintAnchor constraintAnchor2 = this.mLeft;
            if (constraintAnchor == constraintAnchor2) {
                return constraintAnchor2.mTarget.mOwner;
            }
            return null;
        }
        if (orientation != 1 || this.mTop.mTarget == null) {
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.mTop.mTarget.mTarget;
        ConstraintAnchor constraintAnchor4 = this.mTop;
        if (constraintAnchor3 == constraintAnchor4) {
            return constraintAnchor4.mTarget.mOwner;
        }
        return null;
    }

    public ConstraintWidget getNextChainMember(int orientation) {
        if (orientation == 0) {
            if (this.mRight.mTarget == null) {
                return null;
            }
            ConstraintAnchor constraintAnchor = this.mRight.mTarget.mTarget;
            ConstraintAnchor constraintAnchor2 = this.mRight;
            if (constraintAnchor == constraintAnchor2) {
                return constraintAnchor2.mTarget.mOwner;
            }
            return null;
        }
        if (orientation != 1 || this.mBottom.mTarget == null) {
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.mBottom.mTarget.mTarget;
        ConstraintAnchor constraintAnchor4 = this.mBottom;
        if (constraintAnchor3 == constraintAnchor4) {
            return constraintAnchor4.mTarget.mOwner;
        }
        return null;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintWidget found = null;
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget tmp = this;
        while (found == null && tmp != null) {
            ConstraintAnchor anchor = tmp.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor targetOwner = anchor == null ? null : anchor.getTarget();
            ConstraintWidget target = targetOwner == null ? null : targetOwner.getOwner();
            if (target == getParent()) {
                ConstraintWidget found2 = tmp;
                return found2;
            }
            ConstraintAnchor targetAnchor = target != null ? target.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget() : null;
            if (targetAnchor != null && targetAnchor.getOwner() != tmp) {
                found = tmp;
            } else {
                tmp = target;
            }
        }
        return found;
    }

    public boolean isInVerticalChain() {
        if (this.mTop.mTarget != null && this.mTop.mTarget.mTarget == this.mTop) {
            return true;
        }
        if (this.mBottom.mTarget != null && this.mBottom.mTarget.mTarget == this.mBottom) {
            return true;
        }
        return false;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintWidget found = null;
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget tmp = this;
        while (found == null && tmp != null) {
            ConstraintAnchor anchor = tmp.getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor targetOwner = anchor == null ? null : anchor.getTarget();
            ConstraintWidget target = targetOwner == null ? null : targetOwner.getOwner();
            if (target == getParent()) {
                ConstraintWidget found2 = tmp;
                return found2;
            }
            ConstraintAnchor targetAnchor = target != null ? target.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget() : null;
            if (targetAnchor != null && targetAnchor.getOwner() != tmp) {
                found = tmp;
            } else {
                tmp = target;
            }
        }
        return found;
    }

    private boolean isChainHead(int orientation) {
        int offset = orientation * 2;
        if (this.mListAnchors[offset].mTarget != null) {
            ConstraintAnchor constraintAnchor = this.mListAnchors[offset].mTarget.mTarget;
            ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
            if (constraintAnchor != constraintAnchorArr[offset] && constraintAnchorArr[offset + 1].mTarget != null && this.mListAnchors[offset + 1].mTarget.mTarget == this.mListAnchors[offset + 1]) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:189:0x033d  */
    /* JADX WARN: Code duplicated, block: B:196:0x034c  */
    /* JADX WARN: Code duplicated, block: B:202:0x035d  */
    /* JADX WARN: Code duplicated, block: B:205:0x0362  */
    /* JADX WARN: Code duplicated, block: B:206:0x0366  */
    /* JADX WARN: Code duplicated, block: B:209:0x0371  */
    /* JADX WARN: Code duplicated, block: B:210:0x0375  */
    /* JADX WARN: Code duplicated, block: B:249:0x04da  */
    /* JADX WARN: Code duplicated, block: B:252:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:270:0x0552  */
    /* JADX WARN: Code duplicated, block: B:274:0x0565  */
    /* JADX WARN: Code duplicated, block: B:275:0x0568  */
    /* JADX WARN: Code duplicated, block: B:277:0x056b  */
    /* JADX WARN: Code duplicated, block: B:316:0x0647  */
    /* JADX WARN: Code duplicated, block: B:318:0x064b  */
    /* JADX WARN: Code duplicated, block: B:320:0x0652  */
    /* JADX WARN: Code duplicated, block: B:321:0x0661  */
    /* JADX WARN: Code duplicated, block: B:324:0x0677  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r37v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r73v0, types: [android.support.constraint.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.support.constraint.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r7v6, types: [android.support.constraint.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.support.constraint.solver.LinearSystem] */
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        boolean z2;
        boolean z3;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        boolean z4;
        boolean z5;
        int i;
        boolean z6;
        int i2;
        int i3;
        int i4;
        boolean z7;
        int i5;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        int i6;
        boolean z12;
        boolean z13;
        boolean z14;
        ?? r7;
        ?? r8;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        int i7;
        int i8;
        int i9;
        ?? r9;
        boolean z15;
        int i10;
        boolean z16;
        ?? r10;
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int i11;
        int i12;
        boolean zIsInHorizontalChain;
        boolean zIsInVerticalChain;
        HorizontalWidgetRun horizontalWidgetRun2;
        SolverVariable solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        SolverVariable solverVariableCreateObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
        ConstraintWidget constraintWidget3 = this.mParent;
        if (constraintWidget3 == null) {
            z2 = false;
            z3 = false;
        } else {
            boolean z17 = constraintWidget3 != null && constraintWidget3.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
            ConstraintWidget constraintWidget4 = this.mParent;
            z2 = z17;
            z3 = constraintWidget4 != null && constraintWidget4.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
        }
        if (this.mVisibility == 8 && !hasDependencies()) {
            boolean[] zArr = this.mIsInBarrier;
            if (!zArr[0] && !zArr[1]) {
                return;
            }
        }
        boolean z18 = this.resolvedHorizontal;
        if (z18 || this.resolvedVertical) {
            if (z18) {
                linearSystem.addEquality(solverVariableCreateObjectVariable, this.mX);
                linearSystem.addEquality(solverVariableCreateObjectVariable2, this.mX + this.mWidth);
                if (z2 && (constraintWidget2 = this.mParent) != null) {
                    if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget2;
                        constraintWidgetContainer.addVerticalWrapMinVariable(this.mLeft);
                        constraintWidgetContainer.addHorizontalWrapMaxVariable(this.mRight);
                    } else {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mRight), solverVariableCreateObjectVariable2, 0, 5);
                    }
                }
            }
            if (this.resolvedVertical) {
                linearSystem.addEquality(solverVariableCreateObjectVariable3, this.mY);
                linearSystem.addEquality(solverVariableCreateObjectVariable4, this.mY + this.mHeight);
                if (this.mBaseline.hasDependents()) {
                    linearSystem.addEquality(solverVariableCreateObjectVariable5, this.mY + this.mBaselineDistance);
                }
                if (z3 && (constraintWidget = this.mParent) != null) {
                    if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                        ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget;
                        constraintWidgetContainer2.addVerticalWrapMinVariable(this.mTop);
                        constraintWidgetContainer2.addVerticalWrapMaxVariable(this.mBottom);
                    } else {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget.mBottom), solverVariableCreateObjectVariable4, 0, 5);
                    }
                }
            }
            if (this.resolvedHorizontal && this.resolvedVertical) {
                this.resolvedHorizontal = false;
                this.resolvedVertical = false;
                return;
            }
        }
        if (LinearSystem.sMetrics != null) {
            LinearSystem.sMetrics.widgets++;
        }
        if (z && (horizontalWidgetRun2 = this.horizontalRun) != null && this.verticalRun != null && horizontalWidgetRun2.start.resolved && this.horizontalRun.end.resolved && this.verticalRun.start.resolved && this.verticalRun.end.resolved) {
            if (LinearSystem.sMetrics != null) {
                LinearSystem.sMetrics.graphSolved++;
            }
            linearSystem.addEquality(solverVariableCreateObjectVariable, this.horizontalRun.start.value);
            linearSystem.addEquality(solverVariableCreateObjectVariable2, this.horizontalRun.end.value);
            linearSystem.addEquality(solverVariableCreateObjectVariable3, this.verticalRun.start.value);
            linearSystem.addEquality(solverVariableCreateObjectVariable4, this.verticalRun.end.value);
            linearSystem.addEquality(solverVariableCreateObjectVariable5, this.verticalRun.baseline.value);
            if (this.mParent != null) {
                if (z2 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable2, 0, 8);
                }
                if (z3 && this.isTerminalWidget[1] && !isInVerticalChain()) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), solverVariableCreateObjectVariable4, 0, 8);
                }
            }
            this.resolvedHorizontal = false;
            this.resolvedVertical = false;
            return;
        }
        if (LinearSystem.sMetrics != null) {
            LinearSystem.sMetrics.linearSolved++;
        }
        if (this.mParent == null) {
            z4 = false;
            z5 = false;
        } else {
            if (isChainHead(0)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
                zIsInHorizontalChain = true;
            } else {
                zIsInHorizontalChain = isInHorizontalChain();
            }
            if (isChainHead(1)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 1);
                zIsInVerticalChain = true;
            } else {
                zIsInVerticalChain = isInVerticalChain();
            }
            if (!zIsInHorizontalChain && z2 && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable2, 0, 1);
            }
            if (!zIsInVerticalChain && z3 != 0 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), solverVariableCreateObjectVariable4, 0, 1);
            }
            z4 = zIsInHorizontalChain;
            z5 = zIsInVerticalChain;
        }
        int i13 = this.mWidth;
        if (i13 < this.mMinWidth) {
            i13 = this.mMinWidth;
        }
        int i14 = this.mHeight;
        if (i14 < this.mMinHeight) {
            i14 = this.mMinHeight;
        }
        boolean z19 = this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z20 = this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z21 = false;
        this.mResolvedDimensionRatioSide = this.mDimensionRatioSide;
        float f = this.mDimensionRatio;
        this.mResolvedDimensionRatio = f;
        int i15 = this.mMatchConstraintDefaultWidth;
        int i16 = this.mMatchConstraintDefaultHeight;
        int i17 = i13;
        if (f <= 0.0f || this.mVisibility == 8) {
            i = i14;
            z6 = z3;
        } else {
            z21 = true;
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && i15 == 0) {
                i15 = 3;
            }
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i16 == 0) {
                i16 = 3;
            }
            i = i14;
            if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT || this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT || i15 != 3 || i16 != 3) {
                boolean z22 = z3;
                if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && i15 == 3) {
                    this.mResolvedDimensionRatioSide = 0;
                    int i18 = (int) (this.mResolvedDimensionRatio * this.mHeight);
                    z6 = z22;
                    if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
                        i5 = i18;
                        i3 = i16;
                        i2 = i15;
                        i4 = i;
                        z7 = true;
                    } else {
                        i5 = i18;
                        i3 = i16;
                        i2 = 4;
                        i4 = i;
                        z7 = false;
                    }
                } else {
                    z6 = z22;
                    if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i16 == 3) {
                        this.mResolvedDimensionRatioSide = 1;
                        if (this.mDimensionRatioSide == -1) {
                            this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                        }
                        int i19 = (int) (this.mResolvedDimensionRatio * this.mWidth);
                        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                            i4 = i19;
                            i3 = i16;
                            i2 = i15;
                            i5 = i17;
                            z7 = true;
                        } else {
                            i4 = i19;
                            i3 = 4;
                            i2 = i15;
                            i5 = i17;
                            z7 = false;
                        }
                    }
                }
                int[] iArr = this.mResolvedMatchConstraintDefault;
                iArr[0] = i2;
                iArr[1] = i3;
                this.mResolvedHasRatio = z7;
                if (z7 || !((i12 = this.mResolvedDimensionRatioSide) == 0 || i12 == -1)) {
                    z8 = false;
                } else {
                    z8 = true;
                }
                if (z7 || !((i11 = this.mResolvedDimensionRatioSide) == 1 || i11 == -1)) {
                    z9 = false;
                } else {
                    z9 = true;
                }
                if (this.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT || !(this instanceof ConstraintWidgetContainer)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                z11 = z10;
                if (z11) {
                    i6 = i5;
                } else {
                    i6 = 0;
                }
                if (this.mCenter.isConnected()) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean[] zArr2 = this.mIsInBarrier;
                boolean z23 = zArr2[0];
                boolean z24 = zArr2[1];
                if (this.mHorizontalResolution != 2 || this.resolvedHorizontal) {
                    z13 = z6;
                } else if (!z || (horizontalWidgetRun = this.horizontalRun) == null || !horizontalWidgetRun.start.resolved || !this.horizontalRun.end.resolved) {
                    char c = '\b';
                    ConstraintWidget constraintWidget5 = this.mParent;
                    SolverVariable solverVariableCreateObjectVariable6 = constraintWidget5 != null ? linearSystem.createObjectVariable(constraintWidget5.mRight) : null;
                    ConstraintWidget constraintWidget6 = this.mParent;
                    SolverVariable solverVariableCreateObjectVariable7 = constraintWidget6 != null ? linearSystem.createObjectVariable(constraintWidget6.mLeft) : null;
                    boolean z25 = this.isTerminalWidget[0];
                    DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
                    z13 = z6;
                    applyConstraints(linearSystem, true, z2, z13, z25, solverVariableCreateObjectVariable7, solverVariableCreateObjectVariable6, dimensionBehaviourArr[0], z11, this.mLeft, this.mRight, this.mX, i6, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z8, dimensionBehaviourArr[1] == DimensionBehaviour.MATCH_CONSTRAINT, z4, z5, z23, i2, i3, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z12);
                } else if (z) {
                    linearSystem.addEquality(solverVariableCreateObjectVariable, this.horizontalRun.start.value);
                    linearSystem.addEquality(solverVariableCreateObjectVariable2, this.horizontalRun.end.value);
                    if (this.mParent == null || !z2 || !this.isTerminalWidget[0] || isInHorizontalChain()) {
                        z13 = z6;
                    } else {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable2, 0, 8);
                        z13 = z6;
                    }
                } else {
                    z13 = z6;
                }
                z14 = true;
                if (z) {
                    r7 = this;
                } else {
                    r10 = this;
                    verticalWidgetRun = r10.verticalRun;
                    if (verticalWidgetRun == null && verticalWidgetRun.start.resolved && r10.verticalRun.end.resolved) {
                        LinearSystem linearSystem2 = linearSystem;
                        solverVariable3 = solverVariableCreateObjectVariable3;
                        linearSystem2.addEquality(solverVariable3, r10.verticalRun.start.value);
                        linearSystem2.addEquality(solverVariable2, r10.verticalRun.end.value);
                        solverVariable = solverVariableCreateObjectVariable5;
                        linearSystem2.addEquality(solverVariable, r10.verticalRun.baseline.value);
                        ConstraintWidget constraintWidget7 = r10.mParent;
                        if (constraintWidget7 == null) {
                            r7 = r10;
                            r7 = r10;
                            r7 = r10;
                            solverVariable2 = solverVariableCreateObjectVariable4;
                            i7 = 8;
                            i8 = 1;
                            i9 = 0;
                        } else {
                            if (z5 || !z13) {
                                i7 = 8;
                                i8 = 1;
                            } else {
                                i8 = 1;
                                if (!r10.isTerminalWidget[1]) {
                                    i7 = 8;
                                } else {
                                    i7 = 8;
                                    i9 = 0;
                                    linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(constraintWidget7.mBottom), solverVariable2, 0, 8);
                                }
                            }
                            i9 = 0;
                        }
                        z14 = false;
                        r9 = r10;
                        r8 = linearSystem2;
                    }
                    if (r9.mVerticalResolution == 2) {
                        z15 = z14;
                    } else {
                        z15 = false;
                    }
                    if (!z15 && !r9.resolvedVertical) {
                        int i20 = (r9.mListDimensionBehaviors[i8] == DimensionBehaviour.WRAP_CONTENT && (r9 instanceof ConstraintWidgetContainer)) ? i8 : i9;
                        if (i20 == 0) {
                            i10 = i4;
                        } else {
                            i10 = 0;
                        }
                        ConstraintWidget constraintWidget8 = r9.mParent;
                        SolverVariable solverVariableCreateObjectVariable8 = constraintWidget8 != null ? r8.createObjectVariable(constraintWidget8.mBottom) : null;
                        ConstraintWidget constraintWidget9 = r9.mParent;
                        SolverVariable solverVariableCreateObjectVariable9 = constraintWidget9 != null ? r8.createObjectVariable(constraintWidget9.mTop) : null;
                        if (r9.mBaselineDistance > 0 || r9.mVisibility == i7) {
                            if (r9.mBaseline.mTarget != null) {
                                r8.addEquality(solverVariable, solverVariable3, getBaselineDistance(), i7);
                                r8.addEquality(solverVariable, r8.createObjectVariable(r9.mBaseline.mTarget), 0, i7);
                                if (z13) {
                                    r8.addGreaterThan(solverVariableCreateObjectVariable8, r8.createObjectVariable(r9.mBottom), i9, 5);
                                }
                                z16 = false;
                            } else {
                                if (r9.mVisibility == i7) {
                                    r8.addEquality(solverVariable, solverVariable3, i9, i7);
                                } else {
                                    r8.addEquality(solverVariable, solverVariable3, getBaselineDistance(), i7);
                                }
                                z16 = z12;
                            }
                        } else {
                            z16 = z12;
                        }
                        boolean z26 = r9.isTerminalWidget[i8];
                        DimensionBehaviour[] dimensionBehaviourArr2 = r9.mListDimensionBehaviors;
                        applyConstraints(linearSystem, false, z13, z2, z26, solverVariableCreateObjectVariable9, solverVariableCreateObjectVariable8, dimensionBehaviourArr2[i8], i20, r9.mTop, r9.mBottom, r9.mY, i10, r9.mMinHeight, r9.mMaxDimension[i8], r9.mVerticalBiasPercent, z9, dimensionBehaviourArr2[0] == DimensionBehaviour.MATCH_CONSTRAINT, z5, z4, z24, i3, i2, r9.mMatchConstraintMinHeight, r9.mMatchConstraintMaxHeight, r9.mMatchConstraintPercentHeight, z16);
                    }
                    if (z7) {
                        if (r9.mResolvedDimensionRatioSide == 1) {
                            linearSystem.addRatio(solverVariable2, solverVariable3, solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable, r9.mResolvedDimensionRatio, 8);
                        } else {
                            linearSystem.addRatio(solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable, solverVariable2, solverVariable3, r9.mResolvedDimensionRatio, 8);
                        }
                    }
                    if (r9.mCenter.isConnected()) {
                        r8.addCenterPoint(r9, r9.mCenter.getTarget().getOwner(), (float) Math.toRadians(r9.mCircleConstraintAngle + 90.0f), r9.mCenter.getMargin());
                    }
                    r9.resolvedHorizontal = false;
                    r9.resolvedVertical = false;
                }
                r7 = r10;
                r7 = r10;
                r7 = r10;
                r7 = r10;
                r7 = r10;
                r7 = r10;
                r8 = linearSystem;
                solverVariable = solverVariableCreateObjectVariable5;
                solverVariable2 = solverVariableCreateObjectVariable4;
                solverVariable3 = solverVariableCreateObjectVariable3;
                i7 = 8;
                i8 = 1;
                i9 = 0;
                r9 = r7;
                if (r9.mVerticalResolution == 2) {
                    z15 = z14;
                } else {
                    z15 = false;
                }
                if (!z15) {
                }
                if (z7) {
                    if (r9.mResolvedDimensionRatioSide == 1) {
                        linearSystem.addRatio(solverVariable2, solverVariable3, solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable, r9.mResolvedDimensionRatio, 8);
                    } else {
                        linearSystem.addRatio(solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable, solverVariable2, solverVariable3, r9.mResolvedDimensionRatio, 8);
                    }
                }
                if (r9.mCenter.isConnected()) {
                    r8.addCenterPoint(r9, r9.mCenter.getTarget().getOwner(), (float) Math.toRadians(r9.mCircleConstraintAngle + 90.0f), r9.mCenter.getMargin());
                }
                r9.resolvedHorizontal = false;
                r9.resolvedVertical = false;
            }
            boolean z27 = z3;
            setupDimensionRatio(z2, z27, z19, z20);
            z6 = z27;
        }
        i3 = i16;
        i2 = i15;
        i5 = i17;
        i4 = i;
        z7 = z21;
        int[] iArr2 = this.mResolvedMatchConstraintDefault;
        iArr2[0] = i2;
        iArr2[1] = i3;
        this.mResolvedHasRatio = z7;
        if (z7) {
            z8 = false;
        } else {
            z8 = false;
        }
        if (z7) {
            z9 = false;
        } else {
            z9 = false;
        }
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT) {
            z10 = false;
        } else {
            z10 = false;
        }
        z11 = z10;
        if (z11) {
            i6 = i5;
        } else {
            i6 = 0;
        }
        if (this.mCenter.isConnected()) {
            z12 = true;
        } else {
            z12 = false;
        }
        boolean[] zArr3 = this.mIsInBarrier;
        boolean z28 = zArr3[0];
        boolean z29 = zArr3[1];
        if (this.mHorizontalResolution != 2) {
            z13 = z6;
        } else {
            z13 = z6;
        }
        z14 = true;
        if (z) {
            r7 = this;
        } else {
            r10 = this;
            verticalWidgetRun = r10.verticalRun;
            if (verticalWidgetRun == null) {
            }
            if (r9.mVerticalResolution == 2) {
                z15 = z14;
            } else {
                z15 = false;
            }
            if (!z15) {
            }
            if (z7) {
                if (r9.mResolvedDimensionRatioSide == 1) {
                    linearSystem.addRatio(solverVariable2, solverVariable3, solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable, r9.mResolvedDimensionRatio, 8);
                } else {
                    linearSystem.addRatio(solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable, solverVariable2, solverVariable3, r9.mResolvedDimensionRatio, 8);
                }
            }
            if (r9.mCenter.isConnected()) {
                r8.addCenterPoint(r9, r9.mCenter.getTarget().getOwner(), (float) Math.toRadians(r9.mCircleConstraintAngle + 90.0f), r9.mCenter.getMargin());
            }
            r9.resolvedHorizontal = false;
            r9.resolvedVertical = false;
        }
        r7 = r10;
        r7 = r10;
        r7 = r10;
        r7 = r10;
        r7 = r10;
        r7 = r10;
        r8 = linearSystem;
        solverVariable = solverVariableCreateObjectVariable5;
        solverVariable2 = solverVariableCreateObjectVariable4;
        solverVariable3 = solverVariableCreateObjectVariable3;
        i7 = 8;
        i8 = 1;
        i9 = 0;
        r9 = r7;
        if (r9.mVerticalResolution == 2) {
            z15 = z14;
        } else {
            z15 = false;
        }
        if (!z15) {
        }
        if (z7) {
            if (r9.mResolvedDimensionRatioSide == 1) {
                linearSystem.addRatio(solverVariable2, solverVariable3, solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable, r9.mResolvedDimensionRatio, 8);
            } else {
                linearSystem.addRatio(solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable, solverVariable2, solverVariable3, r9.mResolvedDimensionRatio, 8);
            }
        }
        if (r9.mCenter.isConnected()) {
            r8.addCenterPoint(r9, r9.mCenter.getTarget().getOwner(), (float) Math.toRadians(r9.mCircleConstraintAngle + 90.0f), r9.mCenter.getMargin());
        }
        r9.resolvedHorizontal = false;
        r9.resolvedVertical = false;
    }

    boolean addFirst() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    public void setupDimensionRatio(boolean hparentWrapContent, boolean vparentWrapContent, boolean horizontalDimensionFixed, boolean verticalDimensionFixed) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (horizontalDimensionFixed && !verticalDimensionFixed) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!horizontalDimensionFixed && verticalDimensionFixed) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            int i = this.mMatchConstraintMinWidth;
            if (i > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (i == 0 && this.mMatchConstraintMinHeight > 0) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:220:0x051e  */
    /* JADX WARN: Code duplicated, block: B:227:0x053a  */
    /* JADX WARN: Code duplicated, block: B:230:0x0561  */
    /* JADX WARN: Code duplicated, block: B:237:0x057b  */
    /* JADX WARN: Code duplicated, block: B:247:0x0590  */
    /* JADX WARN: Code duplicated, block: B:250:0x05a8  */
    /* JADX WARN: Code duplicated, block: B:258:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:260:0x05c8  */
    /* JADX WARN: Code duplicated, block: B:266:0x05d3  */
    /* JADX WARN: Code duplicated, block: B:271:0x05dc  */
    /* JADX WARN: Code duplicated, block: B:276:0x05e5  */
    /* JADX WARN: Code duplicated, block: B:278:0x05e8  */
    /* JADX WARN: Code duplicated, block: B:281:0x05ef  */
    /* JADX WARN: Code duplicated, block: B:289:0x060d  */
    /* JADX WARN: Code duplicated, block: B:291:0x0610  */
    /* JADX WARN: Code duplicated, block: B:293:0x0616  */
    /* JADX WARN: Instruction removed from duplicated block: B:289:0x060d, please report this as an issue */
    private void applyConstraints(LinearSystem system, boolean isHorizontal, boolean parentWrapContent, boolean oppositeParentWrapContent, boolean isTerminal, SolverVariable parentMin, SolverVariable parentMax, DimensionBehaviour dimensionBehaviour, boolean wrapContent, ConstraintAnchor beginAnchor, ConstraintAnchor endAnchor, int beginPosition, int dimension, int minDimension, int maxDimension, float bias, boolean useRatio, boolean oppositeVariable, boolean inChain, boolean oppositeInChain, boolean inBarrier, int matchConstraintDefault, int oppositeMatchConstraintDefault, int matchMinDimension, int matchMaxDimension, float matchPercentDimension, boolean applyPosition) {
        int dimension2;
        boolean variableSize;
        int matchMaxDimension2;
        int i;
        int dimension3;
        boolean variableSize2;
        int matchMinDimension2;
        boolean isTerminal2;
        SolverVariable percentBegin;
        SolverVariable percentEnd;
        int i2;
        SolverVariable beginTarget;
        boolean applyCentering;
        boolean applyCentering2;
        ConstraintWidget beginWidget;
        boolean applyBoundsCheck;
        boolean applyBoundsCheck2;
        SolverVariable solverVariable;
        boolean parentWrapContent2;
        ConstraintWidget beginWidget2;
        SolverVariable begin;
        ConstraintWidget endWidget;
        int rangeCheckStrength;
        int boundsCheckStrength;
        int margin;
        int strength;
        int rangeCheckStrength2;
        int wrapStrength;
        boolean applyBoundsCheck3;
        boolean applyCentering3;
        boolean applyRangeCheck;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        int i3;
        ConstraintWidget constraintWidget3 = this;
        SolverVariable begin2 = system.createObjectVariable(beginAnchor);
        SolverVariable end = system.createObjectVariable(endAnchor);
        SolverVariable beginTarget2 = system.createObjectVariable(beginAnchor.getTarget());
        system.createObjectVariable(endAnchor.getTarget());
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().nonresolvedWidgets++;
        }
        boolean isBeginConnected = beginAnchor.isConnected();
        boolean isEndConnected = endAnchor.isConnected();
        boolean isCenterConnected = constraintWidget3.mCenter.isConnected();
        boolean variableSize3 = false;
        int numConnections = isBeginConnected ? 0 + 1 : 0;
        if (isEndConnected) {
            numConnections++;
        }
        int numConnections2 = isCenterConnected ? numConnections + 1 : numConnections;
        int matchConstraintDefault2 = useRatio ? 3 : matchConstraintDefault;
        switch (AnonymousClass1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour.ordinal()]) {
            case 1:
                variableSize3 = false;
                break;
            case 2:
                variableSize3 = false;
                break;
            case 3:
                variableSize3 = false;
                break;
            case 4:
                variableSize3 = matchConstraintDefault2 != 4;
                break;
        }
        if (constraintWidget3.mVisibility == 8) {
            dimension2 = 0;
            variableSize = false;
        } else {
            dimension2 = dimension;
            variableSize = variableSize3;
        }
        if (applyPosition) {
            if (!isBeginConnected && !isEndConnected && !isCenterConnected) {
                system.addEquality(begin2, beginPosition);
            } else if (isBeginConnected && !isEndConnected) {
                system.addEquality(begin2, beginTarget2, beginAnchor.getMargin(), 8);
            }
        }
        if (!variableSize) {
            if (wrapContent) {
                system.addEquality(end, begin2, 0, 3);
                if (minDimension > 0) {
                    i3 = 8;
                    system.addGreaterThan(end, begin2, minDimension, 8);
                } else {
                    i3 = 8;
                }
                if (maxDimension < Integer.MAX_VALUE) {
                    system.addLowerThan(end, begin2, maxDimension, i3);
                }
            } else {
                system.addEquality(end, begin2, dimension2, 8);
            }
            matchMaxDimension2 = matchMaxDimension;
            variableSize2 = variableSize;
            dimension3 = 8;
            i = 0;
            isTerminal2 = isTerminal;
            matchMinDimension2 = matchMinDimension;
        } else if (numConnections2 == 2 || useRatio || !(matchConstraintDefault2 == 1 || matchConstraintDefault2 == 0)) {
            int matchMinDimension3 = matchMinDimension == -2 ? dimension2 : matchMinDimension;
            int matchMaxDimension3 = matchMaxDimension == -2 ? dimension2 : matchMaxDimension;
            if (dimension2 > 0 && matchConstraintDefault2 != 1) {
                dimension2 = 0;
            }
            if (matchMinDimension3 > 0) {
                system.addGreaterThan(end, begin2, matchMinDimension3, 8);
                dimension2 = Math.max(dimension2, matchMinDimension3);
            }
            if (matchMaxDimension3 > 0) {
                boolean applyLimit = true;
                if (parentWrapContent && matchConstraintDefault2 == 1) {
                    applyLimit = false;
                }
                if (applyLimit) {
                    system.addLowerThan(end, begin2, matchMaxDimension3, 8);
                }
                dimension2 = Math.min(dimension2, matchMaxDimension3);
            }
            if (matchConstraintDefault2 == 1) {
                if (parentWrapContent) {
                    i2 = 8;
                    system.addEquality(end, begin2, dimension2, 8);
                } else {
                    i2 = 8;
                    if (inChain) {
                        system.addEquality(end, begin2, dimension2, 5);
                        system.addLowerThan(end, begin2, dimension2, 8);
                    } else {
                        system.addEquality(end, begin2, dimension2, 5);
                        system.addLowerThan(end, begin2, dimension2, 8);
                    }
                }
                matchMaxDimension2 = matchMaxDimension3;
                variableSize2 = variableSize;
                i = 0;
                isTerminal2 = isTerminal;
                dimension3 = i2;
                matchMinDimension2 = matchMinDimension3;
            } else {
                int matchMinDimension4 = matchMinDimension3;
                if (matchConstraintDefault2 == 2) {
                    if (beginAnchor.getType() == ConstraintAnchor.Type.TOP || beginAnchor.getType() == ConstraintAnchor.Type.BOTTOM) {
                        SolverVariable percentBegin2 = system.createObjectVariable(constraintWidget3.mParent.getAnchor(ConstraintAnchor.Type.TOP));
                        percentBegin = percentBegin2;
                        percentEnd = system.createObjectVariable(constraintWidget3.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                    } else {
                        SolverVariable percentBegin3 = system.createObjectVariable(constraintWidget3.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                        percentBegin = percentBegin3;
                        percentEnd = system.createObjectVariable(constraintWidget3.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                    }
                    matchMaxDimension2 = matchMaxDimension3;
                    dimension3 = 8;
                    i = 0;
                    SolverVariable beginTarget3 = percentBegin;
                    system.addConstraint(system.createRow().createRowDimensionRatio(end, begin2, percentEnd, beginTarget3, matchPercentDimension));
                    variableSize2 = false;
                    matchMinDimension2 = matchMinDimension4;
                    isTerminal2 = isTerminal;
                } else {
                    matchMaxDimension2 = matchMaxDimension3;
                    i = 0;
                    dimension3 = 8;
                    variableSize2 = variableSize;
                    matchMinDimension2 = matchMinDimension4;
                    isTerminal2 = true;
                }
            }
        } else {
            int d = Math.max(matchMinDimension, dimension2);
            if (matchMaxDimension > 0) {
                d = Math.min(matchMaxDimension, d);
            }
            system.addEquality(end, begin2, d, 8);
            matchMaxDimension2 = matchMaxDimension;
            variableSize2 = false;
            dimension3 = 8;
            i = 0;
            isTerminal2 = isTerminal;
            matchMinDimension2 = matchMinDimension;
        }
        if (!applyPosition || inChain) {
            int i4 = 2;
            if (numConnections2 < i4 && parentWrapContent && isTerminal2) {
                system.addGreaterThan(begin2, parentMin, i, 8);
                int i5 = (isHorizontal || constraintWidget3.mBaseline.mTarget == null) ? 1 : i;
                if (!isHorizontal && constraintWidget3.mBaseline.mTarget != null) {
                    ConstraintWidget target = constraintWidget3.mBaseline.mTarget.mOwner;
                    i5 = (target.mDimensionRatio != 0.0f && target.mListDimensionBehaviors[i] == DimensionBehaviour.MATCH_CONSTRAINT && target.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) ? 1 : 0;
                }
                if (i5 != 0) {
                    system.addGreaterThan(parentMax, end, i, 8);
                    return;
                }
                return;
            }
            return;
        }
        int wrapStrength2 = 5;
        if ((isBeginConnected || isEndConnected || isCenterConnected) && (!isBeginConnected || isEndConnected)) {
            if (isBeginConnected || !isEndConnected) {
                if (isBeginConnected && isEndConnected) {
                    boolean applyBoundsCheck4 = true;
                    boolean applyStrongChecks = false;
                    int boundsCheckStrength2 = 4;
                    int centeringStrength = 6;
                    int rangeCheckStrength3 = 5;
                    ConstraintWidget beginWidget3 = beginAnchor.mTarget.mOwner;
                    int matchConstraintDefault3 = matchConstraintDefault2;
                    ConstraintWidget endWidget2 = endAnchor.mTarget.mOwner;
                    ConstraintWidget parent = getParent();
                    if (!variableSize2) {
                        beginTarget = beginTarget2;
                        applyCentering = true;
                        if (beginTarget.isFinalValue && 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r18v1 android.support.constraint.solver.SolverVariable
                            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                            */
                        /*
                            Method dump skipped, instruction units count: 1790
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.applyConstraints(android.support.constraint.solver.LinearSystem, boolean, boolean, boolean, boolean, android.support.constraint.solver.SolverVariable, android.support.constraint.solver.SolverVariable, android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, android.support.constraint.solver.widgets.ConstraintAnchor, android.support.constraint.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
                    }

                    /* JADX INFO: renamed from: android.support.constraint.solver.widgets.ConstraintWidget$1, reason: invalid class name */
                    static /* synthetic */ class AnonymousClass1 {
                        static final /* synthetic */ int[] $SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type;
                        static final /* synthetic */ int[] $SwitchMap$android$support$constraint$solver$widgets$ConstraintWidget$DimensionBehaviour;

                        static {
                            int[] iArr = new int[DimensionBehaviour.values().length];
                            $SwitchMap$android$support$constraint$solver$widgets$ConstraintWidget$DimensionBehaviour = iArr;
                            try {
                                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
                            } catch (NoSuchFieldError e) {
                            }
                            try {
                                $SwitchMap$android$support$constraint$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
                            } catch (NoSuchFieldError e2) {
                            }
                            try {
                                $SwitchMap$android$support$constraint$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
                            } catch (NoSuchFieldError e3) {
                            }
                            try {
                                $SwitchMap$android$support$constraint$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
                            } catch (NoSuchFieldError e4) {
                            }
                            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
                            $SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type = iArr2;
                            try {
                                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
                            } catch (NoSuchFieldError e5) {
                            }
                            try {
                                $SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;
                            } catch (NoSuchFieldError e6) {
                            }
                            try {
                                $SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
                            } catch (NoSuchFieldError e7) {
                            }
                            try {
                                $SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
                            } catch (NoSuchFieldError e8) {
                            }
                            try {
                                $SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
                            } catch (NoSuchFieldError e9) {
                            }
                            try {
                                $SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
                            } catch (NoSuchFieldError e10) {
                            }
                            try {
                                $SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
                            } catch (NoSuchFieldError e11) {
                            }
                            try {
                                $SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
                            } catch (NoSuchFieldError e12) {
                            }
                            try {
                                $SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
                            } catch (NoSuchFieldError e13) {
                            }
                        }
                    }

                    public void updateFromSolver(LinearSystem system, boolean optimize) {
                        VerticalWidgetRun verticalWidgetRun;
                        HorizontalWidgetRun horizontalWidgetRun;
                        int left = system.getObjectVariableValue(this.mLeft);
                        int top = system.getObjectVariableValue(this.mTop);
                        int right = system.getObjectVariableValue(this.mRight);
                        int bottom = system.getObjectVariableValue(this.mBottom);
                        if (optimize && (horizontalWidgetRun = this.horizontalRun) != null && horizontalWidgetRun.start.resolved && this.horizontalRun.end.resolved) {
                            left = this.horizontalRun.start.value;
                            right = this.horizontalRun.end.value;
                        }
                        if (optimize && (verticalWidgetRun = this.verticalRun) != null && verticalWidgetRun.start.resolved && this.verticalRun.end.resolved) {
                            top = this.verticalRun.start.value;
                            bottom = this.verticalRun.end.value;
                        }
                        int w = right - left;
                        int h = bottom - top;
                        if (w < 0 || h < 0 || left == Integer.MIN_VALUE || left == Integer.MAX_VALUE || top == Integer.MIN_VALUE || top == Integer.MAX_VALUE || right == Integer.MIN_VALUE || right == Integer.MAX_VALUE || bottom == Integer.MIN_VALUE || bottom == Integer.MAX_VALUE) {
                            left = 0;
                            top = 0;
                            right = 0;
                            bottom = 0;
                        }
                        setFrame(left, top, right, bottom);
                    }

                    public void copy(ConstraintWidget src, HashMap<ConstraintWidget, ConstraintWidget> map) {
                        this.mHorizontalResolution = src.mHorizontalResolution;
                        this.mVerticalResolution = src.mVerticalResolution;
                        this.mMatchConstraintDefaultWidth = src.mMatchConstraintDefaultWidth;
                        this.mMatchConstraintDefaultHeight = src.mMatchConstraintDefaultHeight;
                        int[] iArr = this.mResolvedMatchConstraintDefault;
                        int[] iArr2 = src.mResolvedMatchConstraintDefault;
                        iArr[0] = iArr2[0];
                        iArr[1] = iArr2[1];
                        this.mMatchConstraintMinWidth = src.mMatchConstraintMinWidth;
                        this.mMatchConstraintMaxWidth = src.mMatchConstraintMaxWidth;
                        this.mMatchConstraintMinHeight = src.mMatchConstraintMinHeight;
                        this.mMatchConstraintMaxHeight = src.mMatchConstraintMaxHeight;
                        this.mMatchConstraintPercentHeight = src.mMatchConstraintPercentHeight;
                        this.mIsWidthWrapContent = src.mIsWidthWrapContent;
                        this.mIsHeightWrapContent = src.mIsHeightWrapContent;
                        this.mResolvedDimensionRatioSide = src.mResolvedDimensionRatioSide;
                        this.mResolvedDimensionRatio = src.mResolvedDimensionRatio;
                        int[] iArr3 = src.mMaxDimension;
                        this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
                        this.mCircleConstraintAngle = src.mCircleConstraintAngle;
                        this.hasBaseline = src.hasBaseline;
                        this.inPlaceholder = src.inPlaceholder;
                        this.mLeft.reset();
                        this.mTop.reset();
                        this.mRight.reset();
                        this.mBottom.reset();
                        this.mBaseline.reset();
                        this.mCenterX.reset();
                        this.mCenterY.reset();
                        this.mCenter.reset();
                        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
                        this.mParent = this.mParent == null ? null : map.get(src.mParent);
                        this.mWidth = src.mWidth;
                        this.mHeight = src.mHeight;
                        this.mDimensionRatio = src.mDimensionRatio;
                        this.mDimensionRatioSide = src.mDimensionRatioSide;
                        this.mX = src.mX;
                        this.mY = src.mY;
                        this.mRelX = src.mRelX;
                        this.mRelY = src.mRelY;
                        this.mOffsetX = src.mOffsetX;
                        this.mOffsetY = src.mOffsetY;
                        this.mBaselineDistance = src.mBaselineDistance;
                        this.mMinWidth = src.mMinWidth;
                        this.mMinHeight = src.mMinHeight;
                        this.mHorizontalBiasPercent = src.mHorizontalBiasPercent;
                        this.mVerticalBiasPercent = src.mVerticalBiasPercent;
                        this.mCompanionWidget = src.mCompanionWidget;
                        this.mContainerItemSkip = src.mContainerItemSkip;
                        this.mVisibility = src.mVisibility;
                        this.mDebugName = src.mDebugName;
                        this.mType = src.mType;
                        this.mDistToTop = src.mDistToTop;
                        this.mDistToLeft = src.mDistToLeft;
                        this.mDistToRight = src.mDistToRight;
                        this.mDistToBottom = src.mDistToBottom;
                        this.mLeftHasCentered = src.mLeftHasCentered;
                        this.mRightHasCentered = src.mRightHasCentered;
                        this.mTopHasCentered = src.mTopHasCentered;
                        this.mBottomHasCentered = src.mBottomHasCentered;
                        this.mHorizontalWrapVisited = src.mHorizontalWrapVisited;
                        this.mVerticalWrapVisited = src.mVerticalWrapVisited;
                        this.mHorizontalChainStyle = src.mHorizontalChainStyle;
                        this.mVerticalChainStyle = src.mVerticalChainStyle;
                        this.mHorizontalChainFixedPosition = src.mHorizontalChainFixedPosition;
                        this.mVerticalChainFixedPosition = src.mVerticalChainFixedPosition;
                        float[] fArr = this.mWeight;
                        float[] fArr2 = src.mWeight;
                        fArr[0] = fArr2[0];
                        fArr[1] = fArr2[1];
                        ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
                        ConstraintWidget[] constraintWidgetArr2 = src.mListNextMatchConstraintsWidget;
                        constraintWidgetArr[0] = constraintWidgetArr2[0];
                        constraintWidgetArr[1] = constraintWidgetArr2[1];
                        ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
                        ConstraintWidget[] constraintWidgetArr4 = src.mNextChainWidget;
                        constraintWidgetArr3[0] = constraintWidgetArr4[0];
                        constraintWidgetArr3[1] = constraintWidgetArr4[1];
                        ConstraintWidget constraintWidget = src.mHorizontalNextWidget;
                        this.mHorizontalNextWidget = constraintWidget == null ? null : map.get(constraintWidget);
                        ConstraintWidget constraintWidget2 = src.mVerticalNextWidget;
                        this.mVerticalNextWidget = constraintWidget2 != null ? map.get(constraintWidget2) : null;
                    }

                    public void updateFromRuns(boolean updateHorizontal, boolean updateVertical) {
                        boolean updateHorizontal2 = updateHorizontal & this.horizontalRun.isResolved();
                        boolean updateVertical2 = updateVertical & this.verticalRun.isResolved();
                        int left = this.horizontalRun.start.value;
                        int top = this.verticalRun.start.value;
                        int right = this.horizontalRun.end.value;
                        int bottom = this.verticalRun.end.value;
                        int h = bottom - top;
                        if (right - left < 0 || h < 0 || left == Integer.MIN_VALUE || left == Integer.MAX_VALUE || top == Integer.MIN_VALUE || top == Integer.MAX_VALUE || right == Integer.MIN_VALUE || right == Integer.MAX_VALUE || bottom == Integer.MIN_VALUE || bottom == Integer.MAX_VALUE) {
                            left = 0;
                            top = 0;
                            right = 0;
                            bottom = 0;
                        }
                        int w = right - left;
                        int h2 = bottom - top;
                        if (updateHorizontal2) {
                            this.mX = left;
                        }
                        if (updateVertical2) {
                            this.mY = top;
                        }
                        if (this.mVisibility == 8) {
                            this.mWidth = 0;
                            this.mHeight = 0;
                            return;
                        }
                        if (updateHorizontal2) {
                            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && w < this.mWidth) {
                                w = this.mWidth;
                            }
                            this.mWidth = w;
                            int i = this.mMinWidth;
                            if (w < i) {
                                this.mWidth = i;
                            }
                        }
                        if (updateVertical2) {
                            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && h2 < this.mHeight) {
                                h2 = this.mHeight;
                            }
                            this.mHeight = h2;
                            int i2 = this.mMinHeight;
                            if (h2 < i2) {
                                this.mHeight = i2;
                            }
                        }
                    }

                    public void addChildrenToSolverByDependency(ConstraintWidgetContainer container, LinearSystem system, HashSet<ConstraintWidget> widgets, int orientation, boolean addSelf) {
                        if (addSelf) {
                            if (!widgets.contains(this)) {
                                return;
                            }
                            Optimizer.checkMatchParent(container, system, this);
                            widgets.remove(this);
                            addToSolver(system, container.optimizeFor(64));
                        }
                        if (orientation == 0) {
                            HashSet<ConstraintAnchor> dependents = this.mLeft.getDependents();
                            if (dependents != null) {
                                for (ConstraintAnchor anchor : dependents) {
                                    anchor.mOwner.addChildrenToSolverByDependency(container, system, widgets, orientation, true);
                                }
                            }
                            HashSet<ConstraintAnchor> dependents2 = this.mRight.getDependents();
                            if (dependents2 != null) {
                                for (ConstraintAnchor anchor2 : dependents2) {
                                    anchor2.mOwner.addChildrenToSolverByDependency(container, system, widgets, orientation, true);
                                }
                                return;
                            }
                            return;
                        }
                        HashSet<ConstraintAnchor> dependents3 = this.mTop.getDependents();
                        if (dependents3 != null) {
                            for (ConstraintAnchor anchor3 : dependents3) {
                                anchor3.mOwner.addChildrenToSolverByDependency(container, system, widgets, orientation, true);
                            }
                        }
                        HashSet<ConstraintAnchor> dependents4 = this.mBottom.getDependents();
                        if (dependents4 != null) {
                            for (ConstraintAnchor anchor4 : dependents4) {
                                anchor4.mOwner.addChildrenToSolverByDependency(container, system, widgets, orientation, true);
                            }
                        }
                        HashSet<ConstraintAnchor> dependents5 = this.mBaseline.getDependents();
                        if (dependents5 != null) {
                            for (ConstraintAnchor anchor5 : dependents5) {
                                anchor5.mOwner.addChildrenToSolverByDependency(container, system, widgets, orientation, true);
                            }
                        }
                    }
                }
