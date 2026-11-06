package com.byazt.kg;

/* JADX INFO: loaded from: classes2.dex */
public enum l {
    TRANSLATE("translate", "translation", "point"),
    TRANSLATE_X("translateX", "translationX", "float"),
    TRANSLATE_Y("translateY", "translationY", "float"),
    ROTATE_X("rotateX", "rotationX", "float"),
    ROTATE_Y("rotateY", "rotationY", "float"),
    ROTATE_Z("rotateZ", "rotation", "float"),
    SCALE("scale", "scale", "point"),
    SCALE_X("scaleX", "scaleX", "float"),
    SCALE_Y("scaleY", "scaleY", "float"),
    ALPHA("opacity", "alpha", "float"),
    BACKGROUND_COLOR("backgroundColor", "backgroundColor", "int"),
    BORDER_RADIUS("borderRadius", "borderRadius", "float"),
    RIPPLE("ripple", "ripple", "float"),
    SHINE("shine", "shine", "float");

    public final String cy;
    public final String hd;
    public final String k;

    l(String str, String str2, String str3) {
        this.k = str;
        this.cy = str2;
        this.hd = str3;
    }

    public String n() {
        return this.k;
    }

    public String qg() {
        return this.cy;
    }

    public String s() {
        return this.hd;
    }

    public static l n(String str) {
        str.hashCode();
        switch (str) {
            case "translateX":
                return TRANSLATE_X;
            case "translateY":
                return TRANSLATE_Y;
            case "opacity":
                return ALPHA;
            case "ripple":
                return RIPPLE;
            case "scaleX":
                return SCALE_X;
            case "scaleY":
                return SCALE_Y;
            case "scale":
                return SCALE;
            case "translate":
                return TRANSLATE;
            case "backgroundColor":
                return BACKGROUND_COLOR;
            case "borderRadius":
                return BORDER_RADIUS;
            case "rotateX":
                return ROTATE_X;
            case "rotateY":
                return ROTATE_Y;
            case "rotateZ":
                return ROTATE_Z;
            default:
                return TRANSLATE_X;
        }
    }
}
