package com.byazt.gx;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.byazt.ca.ho;
import com.byazt.jt.AnimationText;
import com.byazt.rk.zo;
import com.byazt.uko.w;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.taptap.sdk.compliance.constants.BundleKey;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 1132})
public class DynamicTextView extends DynamicBaseWidgetImp {
    public DynamicTextView(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        this.zo += 6;
        if (this.k.er()) {
            this.ho = new AnimationText(context, this.k.fw(), this.k.c(), 1, this.k.zo());
            ((AnimationText) this.ho).setMaxLines(1);
        } else {
            this.ho = new TextView(context);
            ((TextView) this.ho).setIncludeFontPadding(false);
        }
        this.ho.setTag(Integer.valueOf(getClickArea()));
        addView(this.ho, getWidgetLayoutParams());
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        int i;
        super.zo();
        if (TextUtils.isEmpty(getText())) {
            this.ho.setVisibility(4);
            return true;
        }
        if (this.k.er()) {
            w();
            return true;
        }
        ((TextView) this.ho).setText(this.k.uc());
        if (Build.VERSION.SDK_INT >= 17) {
            ((TextView) this.ho).setTextDirection(5);
            this.ho.setTextAlignment(this.k.zo());
        }
        ((TextView) this.ho).setTextColor(this.k.fw());
        ((TextView) this.ho).setTextSize(this.k.c());
        if (!this.k.ny()) {
            ((TextView) this.ho).setMaxLines(1);
            ((TextView) this.ho).setGravity(17);
            ((TextView) this.ho).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int iFo = this.k.fo();
            if (iFo > 0) {
                ((TextView) this.ho).setLines(iFo);
                ((TextView) this.ho).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        if (this.m == null || this.m.vk() == null) {
            return true;
        }
        if (com.byazt.dj.x.pr() && aj() && (TextUtils.equals(this.m.vk().getType(), "text_star") || TextUtils.equals(this.m.vk().getType(), "score-count") || TextUtils.equals(this.m.vk().getType(), "score-count-type-1") || TextUtils.equals(this.m.vk().getType(), "score-count-type-2"))) {
            setVisibility(8);
            return true;
        }
        if (TextUtils.equals(this.m.vk().getType(), "score-count") || TextUtils.equals(this.m.vk().getType(), "score-count-type-2")) {
            try {
                try {
                    i = Integer.parseInt(getText());
                } catch (Exception e) {
                }
            } catch (NumberFormatException e2) {
                i = -1;
            }
            if (i < 0) {
                if (com.byazt.dj.x.pr()) {
                    setVisibility(8);
                    return true;
                }
                this.ho.setVisibility(0);
            }
            if (TextUtils.equals(this.m.vk().getType(), "score-count-type-2")) {
                ((TextView) this.ho).setText(String.format(new DecimalFormat("(###,###,###)").format(i), Integer.valueOf(i)));
                ((TextView) this.ho).setGravity(17);
                return true;
            }
            pr((TextView) this.ho, i);
        } else if (TextUtils.equals(this.m.vk().getType(), "text_star")) {
            double d = -1.0d;
            try {
                d = Double.parseDouble(getText());
            } catch (Exception e3) {
                ho.hw("DynamicStarView applyNativeStyle", e3.toString());
            }
            if (d < 0.0d || d > 5.0d) {
                if (com.byazt.dj.x.pr()) {
                    setVisibility(8);
                    return true;
                }
                this.ho.setVisibility(0);
            }
            ((TextView) this.ho).setIncludeFontPadding(false);
            ((TextView) this.ho).setText(String.format("%.1f", Double.valueOf(d)));
        } else if (TextUtils.equals("privacy-detail", this.m.vk().getType())) {
            ((TextView) this.ho).setText("功能 | 权限 | 隐私");
        } else if (TextUtils.equals(this.m.vk().getType(), "development-name")) {
            ((TextView) this.ho).setText("开发者：" + getText());
        } else if (TextUtils.equals(this.m.vk().getType(), "app-version")) {
            ((TextView) this.ho).setText("版本号：V" + getText());
        } else {
            ((TextView) this.ho).setText(getText());
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.ho.setTextAlignment(this.k.zo());
            ((TextView) this.ho).setGravity(this.k.aj());
        }
        if (com.byazt.dj.x.pr()) {
            vk();
        }
        return true;
    }

    private boolean aj() {
        return (this.g == null || this.g.getRenderRequest() == null || this.g.getRenderRequest().k() == 4) ? false : true;
    }

    private void vk() {
        int iPr;
        if (TextUtils.equals(this.m.vk().getType(), "source") || TextUtils.equals(this.m.vk().getType(), BundleKey.TITLE) || TextUtils.equals(this.m.vk().getType(), "text_star")) {
            int[] iArrHw = w.hw(this.k.uc(), this.k.c(), true);
            int iPr2 = (int) com.byazt.js.zo.pr(getContext(), this.k.hw());
            int iPr3 = (int) com.byazt.js.zo.pr(getContext(), this.k.hn());
            int iPr4 = (int) com.byazt.js.zo.pr(getContext(), this.k.x());
            int iPr5 = (int) com.byazt.js.zo.pr(getContext(), this.k.pr());
            int iMin = Math.min(iPr2, iPr5);
            if (TextUtils.equals(this.m.vk().getType(), "source") && (iPr = ((this.zo - ((int) com.byazt.js.zo.pr(getContext(), this.k.c()))) - iPr2) - iPr5) > 1 && iPr <= iMin * 2) {
                int i = iPr / 2;
                this.ho.setPadding(iPr3, iPr2 - i, iPr4, iPr5 - (iPr - i));
                return;
            }
            int i2 = (((iArrHw[1] + iPr2) + iPr5) - this.zo) - 2;
            if (i2 <= 1) {
                return;
            }
            if (i2 <= iMin * 2) {
                int i3 = i2 / 2;
                this.ho.setPadding(iPr3, iPr2 - i3, iPr4, iPr5 - (i2 - i3));
            } else if (i2 <= iPr2 + iPr5) {
                if (iPr2 > iPr5) {
                    this.ho.setPadding(iPr3, iPr2 - (i2 - iMin), iPr4, iPr5 - iMin);
                } else {
                    this.ho.setPadding(iPr3, iPr2 - iMin, iPr4, iPr5 - (i2 - iMin));
                }
            } else {
                final int i4 = (i2 - iPr2) - iPr5;
                this.ho.setPadding(iPr3, 0, iPr4, 0);
                if (i4 <= ((int) com.byazt.js.zo.pr(getContext(), 1.0f)) + 1) {
                    ((TextView) this.ho).setTextSize(this.k.c() - 1.0f);
                } else if (i4 <= (((int) com.byazt.js.zo.pr(getContext(), 1.0f)) + 1) * 2) {
                    ((TextView) this.ho).setTextSize(this.k.c() - 2.0f);
                } else {
                    post(new Runnable() { // from class: com.byazt.gx.DynamicTextView.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ViewGroup.LayoutParams layoutParams = DynamicTextView.this.ho.getLayoutParams();
                                layoutParams.height = DynamicTextView.this.zo + i4;
                                DynamicTextView.this.ho.setLayoutParams(layoutParams);
                                DynamicTextView.this.ho.setTranslationY(-i4);
                                ViewGroup viewGroup = (ViewGroup) DynamicTextView.this.ho.getParent();
                                viewGroup.setClipChildren(false);
                                ViewGroup viewGroup2 = (ViewGroup) DynamicTextView.this.ho.getParent().getParent();
                                viewGroup2.setClipChildren(false);
                            } catch (Throwable th) {
                            }
                        }
                    });
                }
            }
        }
        if (TextUtils.equals(this.m.vk().getType(), "fillButton") && Build.VERSION.SDK_INT >= 17) {
            this.ho.setTextAlignment(2);
            ((TextView) this.ho).setGravity(17);
        }
    }

    public String getText() {
        String strUc = this.k.uc();
        if (TextUtils.isEmpty(strUc)) {
            if (!com.byazt.dj.x.pr() && TextUtils.equals(this.m.vk().getType(), "text_star")) {
                strUc = GlobalSetting.REWARD_VIDEO_AD;
            }
            if (!com.byazt.dj.x.pr() && TextUtils.equals(this.m.vk().getType(), "score-count")) {
                strUc = "6870";
            }
        }
        if (TextUtils.equals(this.m.vk().getType(), BundleKey.TITLE) || TextUtils.equals(this.m.vk().getType(), MediaFormat.KEY_SUBTITLE)) {
            return strUc.replace("\n", "");
        }
        return strUc;
    }

    public void pr(TextView textView, int i) {
        textView.setText("(" + String.format("%1$s个评分", Integer.valueOf(i)) + ")");
        if (i == -1) {
            textView.setVisibility(8);
        }
    }

    private void w() {
        if (!(this.ho instanceof AnimationText)) {
            return;
        }
        String text = getText();
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(text);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.optString(i));
            }
        } catch (JSONException e) {
            arrayList.add(text);
        }
        ((AnimationText) this.ho).setMaxLines(1);
        ((AnimationText) this.ho).setTextColor(this.k.fw());
        ((AnimationText) this.ho).setTextSize(this.k.c());
        ((AnimationText) this.ho).setAnimationText(arrayList);
        ((AnimationText) this.ho).setAnimationType(this.k.qi());
        ((AnimationText) this.ho).setAnimationDuration(this.k.v() * 1000);
        ((AnimationText) this.ho).pr();
    }
}
