package com.byazt.id;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.ik.hn;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 92, 37})
public class pr extends hn<RichTextView> {
    public float fe;
    public String ks;
    public int p;
    public String pr;
    public int qx;
    public int sr;
    public int wz;
    public String xb;

    public pr(Context context) {
        super(context);
        this.sr = Integer.MAX_VALUE;
        this.p = 2;
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: fw, reason: merged with bridge method [inline-methods] */
    public RichTextView pr() {
        RichTextView richTextView = new RichTextView(this.hw);
        richTextView.pr(this);
        return richTextView;
    }

    @Override // com.byazt.ik.hn
    public void hw() {
        super.hw();
        ((RichTextView) this.c).setRichText(this.pr);
        ((RichTextView) this.c).setTextSize(1, this.fe);
        ((RichTextView) this.c).setTextColor(this.qx);
        ((RichTextView) this.c).setLines(this.wz);
        ((RichTextView) this.c).setMaxLines(this.sr);
        ((RichTextView) this.c).setGravity(this.p);
    }

    @Override // com.byazt.ik.hn
    public void pr(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.pr(str, str2);
        switch (str) {
            case "text":
                this.pr = str2;
                break;
            case "textColor":
                this.qx = com.byazt.aa.pr.pr(str2);
                break;
            case "textSize":
                this.fe = Float.parseFloat(str2);
                break;
            case "textStyle":
                this.ks = str2;
                break;
            case "lines":
                this.wz = Integer.parseInt(str2);
                break;
            case "maxLines":
                this.sr = Integer.parseInt(str2);
                break;
            case "ellipsize":
                this.xb = str2;
                break;
            case "textAlign":
                this.p = w(str2);
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0028  */
    private int w(String str) {
        switch (str) {
            case "left":
                return 3;
            case "right":
                return 5;
            case "center":
                return 17;
            default:
                return 2;
        }
    }
}
