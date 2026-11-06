package com.byazt.ud;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.ih.s;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 106, 19})
public class n extends s<RichTextView> {
    public String dm;
    public float ei;
    public String n;
    public String nk;
    public int o;
    public int sq;
    public int vo;
    public int ze;

    public n(Context context) {
        super(context);
        this.vo = Integer.MAX_VALUE;
        this.ze = 2;
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public RichTextView n() {
        RichTextView richTextView = new RichTextView(this.qg);
        richTextView.n(this);
        return richTextView;
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
        ((RichTextView) this.l).setRichText(this.n);
        ((RichTextView) this.l).setTextSize(1, this.ei);
        ((RichTextView) this.l).setTextColor(this.sq);
        ((RichTextView) this.l).setLines(this.o);
        ((RichTextView) this.l).setMaxLines(this.vo);
        ((RichTextView) this.l).setGravity(this.ze);
    }

    public void w(int i) {
        this.sq = i;
        ((RichTextView) this.l).setTextColor(this.sq);
    }

    @Override // com.byazt.ih.s
    public void n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "textAlign":
                this.ze = d(str2);
                break;
            case "textColor":
                this.sq = com.byazt.hb.n.n(str2);
                break;
            case "textStyle":
                this.dm = str2;
                break;
            case "textSize":
                this.ei = Float.parseFloat(str2);
                break;
            case "text":
                this.n = str2;
                break;
            case "lines":
                this.o = Integer.parseInt(str2);
                break;
            case "maxLines":
                this.vo = Integer.parseInt(str2);
                break;
            case "ellipsize":
                this.nk = str2;
                break;
        }
    }

    private int d(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 17;
            case "left":
                return 3;
            case "right":
                return 5;
            default:
                return 2;
        }
    }
}
