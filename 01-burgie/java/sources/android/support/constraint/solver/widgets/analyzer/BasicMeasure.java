package android.support.constraint.solver.widgets.analyzer;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.Metrics;
import android.support.constraint.solver.widgets.Barrier;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.ConstraintWidgetContainer;
import android.support.constraint.solver.widgets.Guideline;
import android.support.constraint.solver.widgets.Helper;
import android.support.constraint.solver.widgets.Optimizer;
import android.support.constraint.solver.widgets.VirtualLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();
    private Measure mMeasure = new Measure();

    public static class Measure {
        public static int SELF_DIMENSIONS = 0;
        public static int TRY_GIVEN_DIMENSIONS = 1;
        public static int USE_GIVEN_DIMENSIONS = 2;
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measureStrategy;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public void updateHierarchy(ConstraintWidgetContainer layout) {
        this.mVariableDimensionsWidgets.clear();
        int childCount = layout.mChildren.size();
        for (int i = 0; i < childCount; i++) {
            ConstraintWidget widget = layout.mChildren.get(i);
            if (widget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || widget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                this.mVariableDimensionsWidgets.add(widget);
            }
        }
        layout.invalidateGraph();
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.constraintWidgetContainer = constraintWidgetContainer;
    }

    private void measureChildren(ConstraintWidgetContainer layout) {
        int childCount = layout.mChildren.size();
        boolean optimize = layout.optimizeFor(64);
        Measurer measurer = layout.getMeasurer();
        for (int i = 0; i < childCount; i++) {
            ConstraintWidget child = layout.mChildren.get(i);
            if (!(child instanceof Guideline) && !(child instanceof Barrier) && !child.isInVirtualLayout() && (!optimize || child.horizontalRun == null || child.verticalRun == null || !child.horizontalRun.dimension.resolved || !child.verticalRun.dimension.resolved)) {
                boolean skip = false;
                ConstraintWidget.DimensionBehaviour widthBehavior = child.getDimensionBehaviour(0);
                ConstraintWidget.DimensionBehaviour heightBehavior = child.getDimensionBehaviour(1);
                if (widthBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && child.mMatchConstraintDefaultWidth != 1 && heightBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && child.mMatchConstraintDefaultHeight != 1) {
                    skip = true;
                }
                if (!skip && layout.optimizeFor(1) && !(child instanceof VirtualLayout)) {
                    if (widthBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && child.mMatchConstraintDefaultWidth == 0 && heightBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && !child.isInHorizontalChain()) {
                        skip = true;
                    }
                    if (heightBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && child.mMatchConstraintDefaultHeight == 0 && widthBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && !child.isInHorizontalChain()) {
                        skip = true;
                    }
                    if ((widthBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || heightBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && child.mDimensionRatio > 0.0f) {
                        skip = true;
                    }
                }
                if (!skip) {
                    measure(measurer, child, Measure.SELF_DIMENSIONS);
                    if (layout.mMetrics != null) {
                        layout.mMetrics.measuredWidgets++;
                    }
                }
            }
        }
        measurer.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer layout, String reason, int w, int h) {
        int minWidth = layout.getMinWidth();
        int minHeight = layout.getMinHeight();
        layout.setMinWidth(0);
        layout.setMinHeight(0);
        layout.setWidth(w);
        layout.setHeight(h);
        layout.setMinWidth(minWidth);
        layout.setMinHeight(minHeight);
        this.constraintWidgetContainer.layout();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0168  */
    /* JADX WARN: Code duplicated, block: B:101:0x0170  */
    /* JADX WARN: Code duplicated, block: B:103:0x0174  */
    /* JADX WARN: Code duplicated, block: B:105:0x017f  */
    /* JADX WARN: Code duplicated, block: B:106:0x0181  */
    /* JADX WARN: Code duplicated, block: B:109:0x018a  */
    /* JADX WARN: Code duplicated, block: B:110:0x018d  */
    /* JADX WARN: Code duplicated, block: B:113:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:115:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:116:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:118:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:119:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:122:0x020d  */
    /* JADX WARN: Code duplicated, block: B:124:0x0212  */
    /* JADX WARN: Code duplicated, block: B:127:0x022f  */
    /* JADX WARN: Code duplicated, block: B:129:0x0233  */
    /* JADX WARN: Code duplicated, block: B:131:0x0239  */
    /* JADX WARN: Code duplicated, block: B:133:0x023e  */
    /* JADX WARN: Code duplicated, block: B:136:0x025b  */
    /* JADX WARN: Code duplicated, block: B:138:0x025f  */
    /* JADX WARN: Code duplicated, block: B:143:0x0286  */
    /* JADX WARN: Code duplicated, block: B:145:0x0289  */
    /* JADX WARN: Code duplicated, block: B:147:0x0295  */
    /* JADX WARN: Code duplicated, block: B:149:0x0299  */
    /* JADX WARN: Code duplicated, block: B:166:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:167:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:170:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:171:0x030b  */
    /* JADX WARN: Code duplicated, block: B:174:0x031b  */
    /* JADX WARN: Code duplicated, block: B:176:0x0320  */
    /* JADX WARN: Code duplicated, block: B:179:0x033c  */
    /* JADX WARN: Code duplicated, block: B:181:0x0342  */
    /* JADX WARN: Code duplicated, block: B:183:0x0346  */
    /* JADX WARN: Code duplicated, block: B:185:0x034b  */
    /* JADX WARN: Code duplicated, block: B:191:0x036e  */
    /* JADX WARN: Code duplicated, block: B:194:0x0377  */
    /* JADX WARN: Code duplicated, block: B:198:0x0399 A[LOOP:2: B:142:0x0284->B:198:0x0399, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:202:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:204:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:207:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:209:0x03de  */
    /* JADX WARN: Code duplicated, block: B:210:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:223:0x03af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:61:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:73:0x0108  */
    /* JADX WARN: Code duplicated, block: B:75:0x010e  */
    /* JADX WARN: Code duplicated, block: B:76:0x0118  */
    /* JADX WARN: Code duplicated, block: B:78:0x011b  */
    /* JADX WARN: Code duplicated, block: B:79:0x0125  */
    /* JADX WARN: Code duplicated, block: B:81:0x0128 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x012b  */
    /* JADX WARN: Code duplicated, block: B:85:0x012e  */
    /* JADX WARN: Code duplicated, block: B:86:0x0130  */
    /* JADX WARN: Code duplicated, block: B:89:0x0136  */
    /* JADX WARN: Code duplicated, block: B:95:0x0154  */
    /* JADX WARN: Code duplicated, block: B:97:0x015a  */
    public long solverMeasure(ConstraintWidgetContainer layout, int optimizationLevel, int paddingX, int paddingY, int widthMode, int widthSize, int heightMode, int heightSize, int lastMeasureWidth, int lastMeasureHeight) {
        boolean optimize;
        boolean ratio;
        boolean allSolved;
        boolean optimize2;
        int computations;
        int widthSize2;
        int heightSize2;
        int optimizations;
        int sizeDependentWidgetsCount;
        int optimizations2;
        boolean containerWrapWidth;
        boolean z;
        boolean containerWrapHeight;
        boolean needSolverPass;
        int widthSize3;
        int minWidth;
        int minHeight;
        Measurer measurer;
        int startingWidth;
        int maxIterations;
        int j;
        boolean needSolverPass2;
        int i;
        boolean containerWrapWidth2;
        int maxIterations2;
        int j2;
        boolean optimize3;
        int sizeDependentWidgetsCount2;
        Measurer measurer2;
        ConstraintWidget widget;
        int preWidth;
        int preHeight;
        boolean optimize4;
        int measureStrategy;
        int sizeDependentWidgetsCount3;
        int measureStrategy2;
        int maxIterations3;
        Measurer measurer3;
        boolean needSolverPass3;
        int measuredWidth;
        int measuredHeight;
        ConstraintWidget widget2;
        int preWidth2;
        int preHeight2;
        boolean needSolverPass4;
        int measuredWidth2;
        int measuredHeight2;
        boolean needSolverPass5;
        boolean z2;
        boolean z3;
        Measurer measurer4 = layout.getMeasurer();
        int childCount = layout.mChildren.size();
        int startingWidth2 = layout.getWidth();
        int startingHeight = layout.getHeight();
        boolean optimizeWrap = Optimizer.enabled(optimizationLevel, 128);
        boolean optimize5 = optimizeWrap || Optimizer.enabled(optimizationLevel, 64);
        if (!optimize5) {
            optimize = optimize5;
        } else {
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    optimize = optimize5;
                } else {
                    ConstraintWidget child = layout.mChildren.get(i2);
                    boolean matchWidth = child.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    boolean optimize6 = optimize5;
                    boolean matchHeight = child.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    boolean ratio2 = matchWidth && matchHeight && child.getDimensionRatio() > 0.0f;
                    if (child.isInHorizontalChain() && ratio2) {
                        ratio = false;
                        break;
                    }
                    if (child.isInVerticalChain() && ratio2) {
                        ratio = false;
                        break;
                    }
                    boolean matchWidth2 = child instanceof VirtualLayout;
                    if (matchWidth2) {
                        ratio = false;
                        break;
                    }
                    if (!child.isInHorizontalChain() && !child.isInVerticalChain()) {
                        i2++;
                        optimize5 = optimize6;
                    } else {
                        ratio = false;
                        break;
                    }
                }
            }
            if (!ratio && LinearSystem.sMetrics != null) {
                Metrics metrics = LinearSystem.sMetrics;
                long layoutTime = metrics.measures;
                metrics.measures = layoutTime + 1;
            }
            allSolved = false;
            optimize2 = ((widthMode != 1073741824 && heightMode == 1073741824) || optimizeWrap) & ratio;
            computations = 0;
            if (optimize2) {
                widthSize2 = widthSize;
                heightSize2 = heightSize;
            } else {
                widthSize2 = Math.min(layout.getMaxWidth(), widthSize);
                heightSize2 = Math.min(layout.getMaxHeight(), heightSize);
                if (widthMode == 1073741824 && layout.getWidth() != widthSize2) {
                    layout.setWidth(widthSize2);
                    layout.invalidateGraph();
                }
                if (heightMode == 1073741824 && layout.getHeight() != heightSize2) {
                    layout.setHeight(heightSize2);
                    layout.invalidateGraph();
                }
                if (widthMode != 1073741824 && heightMode == 1073741824) {
                    allSolved = layout.directMeasure(optimizeWrap);
                    computations = 2;
                    z2 = true;
                } else {
                    allSolved = layout.directMeasureSetup(optimizeWrap);
                    if (widthMode == 1073741824) {
                        allSolved &= layout.directMeasureWithOrientation(optimizeWrap, 0);
                        computations = 0 + 1;
                    }
                    if (heightMode != 1073741824) {
                        z2 = true;
                    } else {
                        z2 = true;
                        allSolved &= layout.directMeasureWithOrientation(optimizeWrap, 1);
                        computations++;
                    }
                }
                if (allSolved) {
                    if (widthMode != 1073741824) {
                        z2 = false;
                    }
                    if (heightMode == 1073741824) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    layout.updateFromRuns(z2, z3);
                }
            }
            if (allSolved || computations != 2) {
                optimizations = layout.getOptimizationLevel();
                if (childCount > 0) {
                    measureChildren(layout);
                }
                updateHierarchy(layout);
                sizeDependentWidgetsCount = this.mVariableDimensionsWidgets.size();
                if (childCount > 0) {
                    solveLinearSystem(layout, "First pass", startingWidth2, startingHeight);
                }
                if (sizeDependentWidgetsCount > 0) {
                    if (layout.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        containerWrapWidth = true;
                    } else {
                        containerWrapWidth = false;
                    }
                    if (layout.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        z = true;
                    } else {
                        z = false;
                    }
                    containerWrapHeight = z;
                    int minWidth2 = Math.max(layout.getWidth(), this.constraintWidgetContainer.getMinWidth());
                    int minHeight2 = Math.max(layout.getHeight(), this.constraintWidgetContainer.getMinHeight());
                    needSolverPass = false;
                    widthSize3 = 0;
                    minWidth = minWidth2;
                    minHeight = minHeight2;
                    while (widthSize3 < sizeDependentWidgetsCount) {
                        int heightSize3 = heightSize2;
                        widget2 = this.mVariableDimensionsWidgets.get(widthSize3);
                        int computations2 = computations;
                        if (!(widget2 instanceof VirtualLayout)) {
                            measurer4 = measurer4;
                        } else {
                            preWidth2 = widget2.getWidth();
                            preHeight2 = widget2.getHeight();
                            needSolverPass4 = needSolverPass | measure(measurer4, widget2, Measure.TRY_GIVEN_DIMENSIONS);
                            if (layout.mMetrics != null) {
                                layout.mMetrics.measuredMatchWidgets++;
                            }
                            measuredWidth2 = widget2.getWidth();
                            measuredHeight2 = widget2.getHeight();
                            if (measuredWidth2 != preWidth2) {
                                widget2.setWidth(measuredWidth2);
                                if (!containerWrapWidth && widget2.getRight() > minWidth) {
                                    int w = widget2.getRight() + widget2.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin();
                                    minWidth = Math.max(minWidth, w);
                                }
                                needSolverPass5 = true;
                            }
                            if (measuredHeight2 != preHeight2) {
                                needSolverPass5 = needSolverPass4;
                                widget2.setHeight(measuredHeight2);
                                if (!containerWrapHeight && widget2.getBottom() > minHeight) {
                                    int h = widget2.getBottom() + widget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin();
                                    minHeight = Math.max(minHeight, h);
                                }
                                needSolverPass5 = true;
                            } else {
                                needSolverPass5 = needSolverPass4;
                            }
                            VirtualLayout virtualLayout = (VirtualLayout) widget2;
                            needSolverPass = needSolverPass5 | virtualLayout.needSolverPass();
                        }
                        widthSize3++;
                        heightSize2 = heightSize3;
                        computations = computations2;
                        optimizations = optimizations;
                        startingWidth2 = startingWidth2;
                        measurer4 = measurer4;
                    }
                    measurer = measurer4;
                    optimizations2 = optimizations;
                    startingWidth = startingWidth2;
                    maxIterations = 2;
                    j = 0;
                    while (j < maxIterations) {
                        i = 0;
                        while (i < sizeDependentWidgetsCount) {
                            widget = this.mVariableDimensionsWidgets.get(i);
                            if ((!(widget instanceof Helper) && !(widget instanceof VirtualLayout)) || (widget instanceof Guideline) || widget.getVisibility() == 8 || ((optimize2 && widget.horizontalRun.dimension.resolved && widget.verticalRun.dimension.resolved) || (widget instanceof VirtualLayout))) {
                                containerWrapWidth = containerWrapWidth;
                                maxIterations3 = maxIterations;
                                j = j;
                                optimize4 = optimize2;
                                sizeDependentWidgetsCount3 = sizeDependentWidgetsCount;
                                measurer3 = measurer;
                            } else {
                                preWidth = widget.getWidth();
                                preHeight = widget.getHeight();
                                optimize4 = optimize2;
                                int preBaselineDistance = widget.getBaselineDistance();
                                measureStrategy = Measure.TRY_GIVEN_DIMENSIONS;
                                sizeDependentWidgetsCount3 = sizeDependentWidgetsCount;
                                if (j != maxIterations - 1) {
                                    measureStrategy2 = measureStrategy;
                                } else {
                                    int measureStrategy3 = Measure.USE_GIVEN_DIMENSIONS;
                                    measureStrategy2 = measureStrategy3;
                                }
                                maxIterations3 = maxIterations;
                                measurer3 = measurer;
                                boolean hasMeasure = measure(measurer3, widget, measureStrategy2);
                                needSolverPass3 = needSolverPass | hasMeasure;
                                if (layout.mMetrics != null) {
                                    layout.mMetrics.measuredMatchWidgets++;
                                }
                                measuredWidth = widget.getWidth();
                                measuredHeight = widget.getHeight();
                                if (measuredWidth == preWidth) {
                                    containerWrapWidth = containerWrapWidth;
                                } else {
                                    widget.setWidth(measuredWidth);
                                    if (!containerWrapWidth && widget.getRight() > minWidth) {
                                        int w2 = widget.getRight() + widget.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin();
                                        minWidth = Math.max(minWidth, w2);
                                    }
                                    needSolverPass3 = true;
                                }
                                if (measuredHeight != preHeight) {
                                    widget.setHeight(measuredHeight);
                                    if (containerWrapHeight && widget.getBottom() > minHeight) {
                                        int h2 = widget.getBottom() + widget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin();
                                        minHeight = Math.max(minHeight, h2);
                                    }
                                    needSolverPass3 = true;
                                }
                                if (widget.hasBaseline() || preBaselineDistance == widget.getBaselineDistance()) {
                                    needSolverPass = needSolverPass3;
                                } else {
                                    needSolverPass = true;
                                }
                            }
                            i++;
                            optimize2 = optimize4;
                            maxIterations = maxIterations3;
                            sizeDependentWidgetsCount = sizeDependentWidgetsCount3;
                            j = j;
                            measurer = measurer3;
                            containerWrapWidth = containerWrapWidth;
                        }
                        containerWrapWidth2 = containerWrapWidth;
                        maxIterations2 = maxIterations;
                        j2 = j;
                        optimize3 = optimize2;
                        sizeDependentWidgetsCount2 = sizeDependentWidgetsCount;
                        measurer2 = measurer;
                        if (!needSolverPass) {
                            break;
                        }
                        solveLinearSystem(layout, "intermediate pass", startingWidth, startingHeight);
                        needSolverPass = false;
                        j = j2 + 1;
                        optimize2 = optimize3;
                        maxIterations = maxIterations2;
                        sizeDependentWidgetsCount = sizeDependentWidgetsCount2;
                        measurer = measurer2;
                        containerWrapWidth = containerWrapWidth2;
                    }
                    if (needSolverPass) {
                        solveLinearSystem(layout, "2nd pass", startingWidth, startingHeight);
                        needSolverPass2 = false;
                        if (layout.getWidth() < minWidth) {
                            layout.setWidth(minWidth);
                            needSolverPass2 = true;
                        }
                        if (layout.getHeight() < minHeight) {
                            layout.setHeight(minHeight);
                            needSolverPass2 = true;
                        }
                        if (needSolverPass2) {
                            solveLinearSystem(layout, "3rd pass", startingWidth, startingHeight);
                        }
                    }
                } else {
                    optimizations2 = optimizations;
                }
                layout.setOptimizationLevel(optimizations2);
            }
            return 0;
        }
        ratio = optimize;
        if (!ratio) {
        }
        allSolved = false;
        optimize2 = ((widthMode != 1073741824 && heightMode == 1073741824) || optimizeWrap) & ratio;
        computations = 0;
        if (optimize2) {
            widthSize2 = widthSize;
            heightSize2 = heightSize;
        } else {
            widthSize2 = Math.min(layout.getMaxWidth(), widthSize);
            heightSize2 = Math.min(layout.getMaxHeight(), heightSize);
            if (widthMode == 1073741824) {
                layout.setWidth(widthSize2);
                layout.invalidateGraph();
            }
            if (heightMode == 1073741824) {
                layout.setHeight(heightSize2);
                layout.invalidateGraph();
            }
            if (widthMode != 1073741824) {
                allSolved = layout.directMeasureSetup(optimizeWrap);
                if (widthMode == 1073741824) {
                    allSolved &= layout.directMeasureWithOrientation(optimizeWrap, 0);
                    computations = 0 + 1;
                }
                if (heightMode != 1073741824) {
                    z2 = true;
                } else {
                    z2 = true;
                    allSolved &= layout.directMeasureWithOrientation(optimizeWrap, 1);
                    computations++;
                }
            } else {
                allSolved = layout.directMeasureSetup(optimizeWrap);
                if (widthMode == 1073741824) {
                    allSolved &= layout.directMeasureWithOrientation(optimizeWrap, 0);
                    computations = 0 + 1;
                }
                if (heightMode != 1073741824) {
                    z2 = true;
                } else {
                    z2 = true;
                    allSolved &= layout.directMeasureWithOrientation(optimizeWrap, 1);
                    computations++;
                }
            }
            if (allSolved) {
                if (widthMode != 1073741824) {
                    z2 = false;
                }
                if (heightMode == 1073741824) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                layout.updateFromRuns(z2, z3);
            }
        }
        if (allSolved) {
            optimizations = layout.getOptimizationLevel();
            if (childCount > 0) {
                measureChildren(layout);
            }
            updateHierarchy(layout);
            sizeDependentWidgetsCount = this.mVariableDimensionsWidgets.size();
            if (childCount > 0) {
                solveLinearSystem(layout, "First pass", startingWidth2, startingHeight);
            }
            if (sizeDependentWidgetsCount > 0) {
                if (layout.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    containerWrapWidth = true;
                } else {
                    containerWrapWidth = false;
                }
                if (layout.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    z = true;
                } else {
                    z = false;
                }
                containerWrapHeight = z;
                int minWidth3 = Math.max(layout.getWidth(), this.constraintWidgetContainer.getMinWidth());
                int minHeight3 = Math.max(layout.getHeight(), this.constraintWidgetContainer.getMinHeight());
                needSolverPass = false;
                widthSize3 = 0;
                minWidth = minWidth3;
                minHeight = minHeight3;
                while (widthSize3 < sizeDependentWidgetsCount) {
                    int heightSize4 = heightSize2;
                    widget2 = this.mVariableDimensionsWidgets.get(widthSize3);
                    int computations3 = computations;
                    if (!(widget2 instanceof VirtualLayout)) {
                        measurer4 = measurer4;
                    } else {
                        preWidth2 = widget2.getWidth();
                        preHeight2 = widget2.getHeight();
                        needSolverPass4 = needSolverPass | measure(measurer4, widget2, Measure.TRY_GIVEN_DIMENSIONS);
                        if (layout.mMetrics != null) {
                            layout.mMetrics.measuredMatchWidgets++;
                        }
                        measuredWidth2 = widget2.getWidth();
                        measuredHeight2 = widget2.getHeight();
                        if (measuredWidth2 != preWidth2) {
                            widget2.setWidth(measuredWidth2);
                            if (!containerWrapWidth) {
                            }
                            needSolverPass5 = true;
                        }
                        if (measuredHeight2 != preHeight2) {
                            needSolverPass5 = needSolverPass4;
                            widget2.setHeight(measuredHeight2);
                            if (!containerWrapHeight) {
                            }
                            needSolverPass5 = true;
                        } else {
                            needSolverPass5 = needSolverPass4;
                        }
                        VirtualLayout virtualLayout2 = (VirtualLayout) widget2;
                        needSolverPass = needSolverPass5 | virtualLayout2.needSolverPass();
                    }
                    widthSize3++;
                    heightSize2 = heightSize4;
                    computations = computations3;
                    optimizations = optimizations;
                    startingWidth2 = startingWidth2;
                    measurer4 = measurer4;
                }
                measurer = measurer4;
                optimizations2 = optimizations;
                startingWidth = startingWidth2;
                maxIterations = 2;
                j = 0;
                while (j < maxIterations) {
                    i = 0;
                    while (i < sizeDependentWidgetsCount) {
                        widget = this.mVariableDimensionsWidgets.get(i);
                        if (!(widget instanceof Helper)) {
                            preWidth = widget.getWidth();
                            preHeight = widget.getHeight();
                            optimize4 = optimize2;
                            int preBaselineDistance2 = widget.getBaselineDistance();
                            measureStrategy = Measure.TRY_GIVEN_DIMENSIONS;
                            sizeDependentWidgetsCount3 = sizeDependentWidgetsCount;
                            if (j != maxIterations - 1) {
                                measureStrategy2 = measureStrategy;
                            } else {
                                int measureStrategy4 = Measure.USE_GIVEN_DIMENSIONS;
                                measureStrategy2 = measureStrategy4;
                            }
                            maxIterations3 = maxIterations;
                            measurer3 = measurer;
                            boolean hasMeasure2 = measure(measurer3, widget, measureStrategy2);
                            needSolverPass3 = needSolverPass | hasMeasure2;
                            if (layout.mMetrics != null) {
                                layout.mMetrics.measuredMatchWidgets++;
                            }
                            measuredWidth = widget.getWidth();
                            measuredHeight = widget.getHeight();
                            if (measuredWidth == preWidth) {
                                containerWrapWidth = containerWrapWidth;
                            } else {
                                widget.setWidth(measuredWidth);
                                if (!containerWrapWidth) {
                                }
                                needSolverPass3 = true;
                            }
                            if (measuredHeight != preHeight) {
                                widget.setHeight(measuredHeight);
                                if (containerWrapHeight) {
                                    int h3 = widget.getBottom() + widget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin();
                                    minHeight = Math.max(minHeight, h3);
                                }
                                needSolverPass3 = true;
                            }
                            if (widget.hasBaseline()) {
                                needSolverPass = needSolverPass3;
                            } else {
                                needSolverPass = needSolverPass3;
                            }
                        } else {
                            preWidth = widget.getWidth();
                            preHeight = widget.getHeight();
                            optimize4 = optimize2;
                            int preBaselineDistance3 = widget.getBaselineDistance();
                            measureStrategy = Measure.TRY_GIVEN_DIMENSIONS;
                            sizeDependentWidgetsCount3 = sizeDependentWidgetsCount;
                            if (j != maxIterations - 1) {
                                measureStrategy2 = measureStrategy;
                            } else {
                                int measureStrategy5 = Measure.USE_GIVEN_DIMENSIONS;
                                measureStrategy2 = measureStrategy5;
                            }
                            maxIterations3 = maxIterations;
                            measurer3 = measurer;
                            boolean hasMeasure3 = measure(measurer3, widget, measureStrategy2);
                            needSolverPass3 = needSolverPass | hasMeasure3;
                            if (layout.mMetrics != null) {
                                layout.mMetrics.measuredMatchWidgets++;
                            }
                            measuredWidth = widget.getWidth();
                            measuredHeight = widget.getHeight();
                            if (measuredWidth == preWidth) {
                                containerWrapWidth = containerWrapWidth;
                            } else {
                                widget.setWidth(measuredWidth);
                                if (!containerWrapWidth) {
                                }
                                needSolverPass3 = true;
                            }
                            if (measuredHeight != preHeight) {
                                widget.setHeight(measuredHeight);
                                if (containerWrapHeight) {
                                    int h4 = widget.getBottom() + widget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin();
                                    minHeight = Math.max(minHeight, h4);
                                }
                                needSolverPass3 = true;
                            }
                            if (widget.hasBaseline()) {
                                needSolverPass = needSolverPass3;
                            } else {
                                needSolverPass = needSolverPass3;
                            }
                        }
                        i++;
                        optimize2 = optimize4;
                        maxIterations = maxIterations3;
                        sizeDependentWidgetsCount = sizeDependentWidgetsCount3;
                        j = j;
                        measurer = measurer3;
                        containerWrapWidth = containerWrapWidth;
                    }
                    containerWrapWidth2 = containerWrapWidth;
                    maxIterations2 = maxIterations;
                    j2 = j;
                    optimize3 = optimize2;
                    sizeDependentWidgetsCount2 = sizeDependentWidgetsCount;
                    measurer2 = measurer;
                    if (!needSolverPass) {
                        break;
                        break;
                    }
                    solveLinearSystem(layout, "intermediate pass", startingWidth, startingHeight);
                    needSolverPass = false;
                    j = j2 + 1;
                    optimize2 = optimize3;
                    maxIterations = maxIterations2;
                    sizeDependentWidgetsCount = sizeDependentWidgetsCount2;
                    measurer = measurer2;
                    containerWrapWidth = containerWrapWidth2;
                }
                if (needSolverPass) {
                    solveLinearSystem(layout, "2nd pass", startingWidth, startingHeight);
                    needSolverPass2 = false;
                    if (layout.getWidth() < minWidth) {
                        layout.setWidth(minWidth);
                        needSolverPass2 = true;
                    }
                    if (layout.getHeight() < minHeight) {
                        layout.setHeight(minHeight);
                        needSolverPass2 = true;
                    }
                    if (needSolverPass2) {
                        solveLinearSystem(layout, "3rd pass", startingWidth, startingHeight);
                    }
                }
            } else {
                optimizations2 = optimizations;
            }
            layout.setOptimizationLevel(optimizations2);
        } else {
            optimizations = layout.getOptimizationLevel();
            if (childCount > 0) {
                measureChildren(layout);
            }
            updateHierarchy(layout);
            sizeDependentWidgetsCount = this.mVariableDimensionsWidgets.size();
            if (childCount > 0) {
                solveLinearSystem(layout, "First pass", startingWidth2, startingHeight);
            }
            if (sizeDependentWidgetsCount > 0) {
                if (layout.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    containerWrapWidth = true;
                } else {
                    containerWrapWidth = false;
                }
                if (layout.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    z = true;
                } else {
                    z = false;
                }
                containerWrapHeight = z;
                int minWidth4 = Math.max(layout.getWidth(), this.constraintWidgetContainer.getMinWidth());
                int minHeight4 = Math.max(layout.getHeight(), this.constraintWidgetContainer.getMinHeight());
                needSolverPass = false;
                widthSize3 = 0;
                minWidth = minWidth4;
                minHeight = minHeight4;
                while (widthSize3 < sizeDependentWidgetsCount) {
                    int heightSize5 = heightSize2;
                    widget2 = this.mVariableDimensionsWidgets.get(widthSize3);
                    int computations4 = computations;
                    if (!(widget2 instanceof VirtualLayout)) {
                        measurer4 = measurer4;
                    } else {
                        preWidth2 = widget2.getWidth();
                        preHeight2 = widget2.getHeight();
                        needSolverPass4 = needSolverPass | measure(measurer4, widget2, Measure.TRY_GIVEN_DIMENSIONS);
                        if (layout.mMetrics != null) {
                            layout.mMetrics.measuredMatchWidgets++;
                        }
                        measuredWidth2 = widget2.getWidth();
                        measuredHeight2 = widget2.getHeight();
                        if (measuredWidth2 != preWidth2) {
                            widget2.setWidth(measuredWidth2);
                            if (!containerWrapWidth) {
                            }
                            needSolverPass5 = true;
                        }
                        if (measuredHeight2 != preHeight2) {
                            needSolverPass5 = needSolverPass4;
                            widget2.setHeight(measuredHeight2);
                            if (!containerWrapHeight) {
                            }
                            needSolverPass5 = true;
                        } else {
                            needSolverPass5 = needSolverPass4;
                        }
                        VirtualLayout virtualLayout3 = (VirtualLayout) widget2;
                        needSolverPass = needSolverPass5 | virtualLayout3.needSolverPass();
                    }
                    widthSize3++;
                    heightSize2 = heightSize5;
                    computations = computations4;
                    optimizations = optimizations;
                    startingWidth2 = startingWidth2;
                    measurer4 = measurer4;
                }
                measurer = measurer4;
                optimizations2 = optimizations;
                startingWidth = startingWidth2;
                maxIterations = 2;
                j = 0;
                while (j < maxIterations) {
                    i = 0;
                    while (i < sizeDependentWidgetsCount) {
                        widget = this.mVariableDimensionsWidgets.get(i);
                        if (!(widget instanceof Helper)) {
                            preWidth = widget.getWidth();
                            preHeight = widget.getHeight();
                            optimize4 = optimize2;
                            int preBaselineDistance4 = widget.getBaselineDistance();
                            measureStrategy = Measure.TRY_GIVEN_DIMENSIONS;
                            sizeDependentWidgetsCount3 = sizeDependentWidgetsCount;
                            if (j != maxIterations - 1) {
                                measureStrategy2 = measureStrategy;
                            } else {
                                int measureStrategy6 = Measure.USE_GIVEN_DIMENSIONS;
                                measureStrategy2 = measureStrategy6;
                            }
                            maxIterations3 = maxIterations;
                            measurer3 = measurer;
                            boolean hasMeasure4 = measure(measurer3, widget, measureStrategy2);
                            needSolverPass3 = needSolverPass | hasMeasure4;
                            if (layout.mMetrics != null) {
                                layout.mMetrics.measuredMatchWidgets++;
                            }
                            measuredWidth = widget.getWidth();
                            measuredHeight = widget.getHeight();
                            if (measuredWidth == preWidth) {
                                containerWrapWidth = containerWrapWidth;
                            } else {
                                widget.setWidth(measuredWidth);
                                if (!containerWrapWidth) {
                                }
                                needSolverPass3 = true;
                            }
                            if (measuredHeight != preHeight) {
                                widget.setHeight(measuredHeight);
                                if (containerWrapHeight) {
                                    int h5 = widget.getBottom() + widget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin();
                                    minHeight = Math.max(minHeight, h5);
                                }
                                needSolverPass3 = true;
                            }
                            if (widget.hasBaseline()) {
                                needSolverPass = needSolverPass3;
                            } else {
                                needSolverPass = needSolverPass3;
                            }
                        } else {
                            preWidth = widget.getWidth();
                            preHeight = widget.getHeight();
                            optimize4 = optimize2;
                            int preBaselineDistance5 = widget.getBaselineDistance();
                            measureStrategy = Measure.TRY_GIVEN_DIMENSIONS;
                            sizeDependentWidgetsCount3 = sizeDependentWidgetsCount;
                            if (j != maxIterations - 1) {
                                measureStrategy2 = measureStrategy;
                            } else {
                                int measureStrategy7 = Measure.USE_GIVEN_DIMENSIONS;
                                measureStrategy2 = measureStrategy7;
                            }
                            maxIterations3 = maxIterations;
                            measurer3 = measurer;
                            boolean hasMeasure5 = measure(measurer3, widget, measureStrategy2);
                            needSolverPass3 = needSolverPass | hasMeasure5;
                            if (layout.mMetrics != null) {
                                layout.mMetrics.measuredMatchWidgets++;
                            }
                            measuredWidth = widget.getWidth();
                            measuredHeight = widget.getHeight();
                            if (measuredWidth == preWidth) {
                                containerWrapWidth = containerWrapWidth;
                            } else {
                                widget.setWidth(measuredWidth);
                                if (!containerWrapWidth) {
                                }
                                needSolverPass3 = true;
                            }
                            if (measuredHeight != preHeight) {
                                widget.setHeight(measuredHeight);
                                if (containerWrapHeight) {
                                    int h6 = widget.getBottom() + widget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin();
                                    minHeight = Math.max(minHeight, h6);
                                }
                                needSolverPass3 = true;
                            }
                            if (widget.hasBaseline()) {
                                needSolverPass = needSolverPass3;
                            } else {
                                needSolverPass = needSolverPass3;
                            }
                        }
                        i++;
                        optimize2 = optimize4;
                        maxIterations = maxIterations3;
                        sizeDependentWidgetsCount = sizeDependentWidgetsCount3;
                        j = j;
                        measurer = measurer3;
                        containerWrapWidth = containerWrapWidth;
                    }
                    containerWrapWidth2 = containerWrapWidth;
                    maxIterations2 = maxIterations;
                    j2 = j;
                    optimize3 = optimize2;
                    sizeDependentWidgetsCount2 = sizeDependentWidgetsCount;
                    measurer2 = measurer;
                    if (!needSolverPass) {
                        break;
                        break;
                    }
                    solveLinearSystem(layout, "intermediate pass", startingWidth, startingHeight);
                    needSolverPass = false;
                    j = j2 + 1;
                    optimize2 = optimize3;
                    maxIterations = maxIterations2;
                    sizeDependentWidgetsCount = sizeDependentWidgetsCount2;
                    measurer = measurer2;
                    containerWrapWidth = containerWrapWidth2;
                }
                if (needSolverPass) {
                    solveLinearSystem(layout, "2nd pass", startingWidth, startingHeight);
                    needSolverPass2 = false;
                    if (layout.getWidth() < minWidth) {
                        layout.setWidth(minWidth);
                        needSolverPass2 = true;
                    }
                    if (layout.getHeight() < minHeight) {
                        layout.setHeight(minHeight);
                        needSolverPass2 = true;
                    }
                    if (needSolverPass2) {
                        solveLinearSystem(layout, "3rd pass", startingWidth, startingHeight);
                    }
                }
            } else {
                optimizations2 = optimizations;
            }
            layout.setOptimizationLevel(optimizations2);
        }
        return 0;
    }

    private boolean measure(Measurer measurer, ConstraintWidget widget, int measureStrategy) {
        this.mMeasure.horizontalBehavior = widget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = widget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = widget.getWidth();
        this.mMeasure.verticalDimension = widget.getHeight();
        this.mMeasure.measuredNeedsSolverPass = false;
        this.mMeasure.measureStrategy = measureStrategy;
        boolean horizontalMatchConstraints = this.mMeasure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean verticalMatchConstraints = this.mMeasure.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean horizontalUseRatio = horizontalMatchConstraints && widget.mDimensionRatio > 0.0f;
        boolean verticalUseRatio = verticalMatchConstraints && widget.mDimensionRatio > 0.0f;
        if (horizontalUseRatio && widget.mResolvedMatchConstraintDefault[0] == 4) {
            this.mMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (verticalUseRatio && widget.mResolvedMatchConstraintDefault[1] == 4) {
            this.mMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(widget, this.mMeasure);
        widget.setWidth(this.mMeasure.measuredWidth);
        widget.setHeight(this.mMeasure.measuredHeight);
        widget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        widget.setBaselineDistance(this.mMeasure.measuredBaseline);
        this.mMeasure.measureStrategy = Measure.SELF_DIMENSIONS;
        return this.mMeasure.measuredNeedsSolverPass;
    }
}
