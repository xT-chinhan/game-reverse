package com.byazt.iza;

/* JADX INFO: loaded from: classes.dex */
public enum c {
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

    public final String ho;
    public final String nt;
    public final String yb;

    c(String str, String str2, String str3) {
        this.ho = str;
        this.nt = str2;
        this.yb = str3;
    }

    public String pr() {
        return this.ho;
    }

    public String hw() {
        return this.nt;
    }

    public String hn() {
        return this.yb;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:44:0x0093  */
    public static c pr(String str) {
        switch (str) {
            case "translate":
                return TRANSLATE;
            case "translateY":
                return TRANSLATE_Y;
            case "rotateX":
                return ROTATE_X;
            case "rotateY":
                return ROTATE_Y;
            case "rotateZ":
                return ROTATE_Z;
            case "scale":
                return SCALE;
            case "scaleX":
                return SCALE_X;
            case "scaleY":
                return SCALE_Y;
            case "opacity":
                return ALPHA;
            case "backgroundColor":
                return BACKGROUND_COLOR;
            case "borderRadius":
                return BORDER_RADIUS;
            case "ripple":
                return RIPPLE;
            case "translateX":
                return TRANSLATE_X;
            default:
                return TRANSLATE_X;
        }
    }
}
