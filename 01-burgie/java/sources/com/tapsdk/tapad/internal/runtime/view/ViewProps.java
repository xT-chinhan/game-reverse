package com.tapsdk.tapad.internal.runtime.view;

/* JADX INFO: loaded from: classes3.dex */
public class ViewProps {
    public Boolean animateLayoutChanges;
    public String backgroundColor;
    public String borderColor;
    public Float borderRadius;
    public Float borderRadiusBottomLeft;
    public Float borderRadiusBottomRight;
    public Float borderRadiusTopLeft;
    public Float borderRadiusTopRight;
    public Float borderWidth;
    public Boolean breathingAnimation;
    public Integer breathingDuration;
    public Boolean clipChildren;
    public Boolean clipToOutline;
    public Float elevation;
    public String gradientDirection;
    public String gradientEndColor;
    public String gradientStartColor;
    public String heightAnimate;
    public Float opacity;

    public boolean hasGradient() {
        return (this.gradientStartColor == null || this.gradientEndColor == null) ? false : true;
    }

    public boolean hasIndividualCorners() {
        return (this.borderRadiusTopLeft == null && this.borderRadiusTopRight == null && this.borderRadiusBottomRight == null && this.borderRadiusBottomLeft == null) ? false : true;
    }
}
