package com.mcto.sspsdk.internal;

import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.PopupWindowCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.mcto.sspsdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class pd implements View.OnClickListener {
    public final Context a;
    public final PopupWindow b;
    public od c;

    public pd(Context context) {
        this.a = context;
        int iA = hk.a(context, 330.0f);
        int i = (int) ((context.getResources().getDisplayMetrics().density * 110.0f) + 0.5f);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.qy_layout_feedback_popup_window, (ViewGroup) null);
        PopupWindow popupWindow = new PopupWindow(viewInflate, iA, i, true);
        this.b = popupWindow;
        popupWindow.setContentView(viewInflate);
        TextView textView = (TextView) viewInflate.findViewById(R.id.qy_feedback_item1);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.qy_feedback_item2);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
    }

    public final void a(View view) {
        try {
            Activity activityE = hk.e(view.getContext());
            if (activityE != null) {
                Window window = activityE.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.alpha = 0.3f;
                window.setAttributes(attributes);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        this.b.setOnDismissListener(new nd(view));
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        View contentView = this.b.getContentView();
        int width = this.b.getWidth();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(width), width == -2 ? 0 : 1073741824);
        int height = this.b.getHeight();
        contentView.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(height), height == -2 ? 0 : 1073741824));
        if (iArr[1] / view.getContext().getResources().getDisplayMetrics().heightPixels > 0.66d) {
            PopupWindowCompat.showAsDropDown(this.b, view, view.getWidth() + (-this.b.getContentView().getMeasuredWidth()), -(view.getHeight() + this.b.getContentView().getMeasuredHeight()), 17);
        } else {
            PopupWindowCompat.showAsDropDown(this.b, view, view.getWidth() + (-this.b.getContentView().getMeasuredWidth()), 0, 17);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.b.isShowing()) {
            this.b.dismiss();
            fc.a(this.a, "感谢反馈，将减少此类广告推荐");
        }
        od odVar = this.c;
        if (odVar != null) {
            try {
                ((TextView) view).getText().toString();
                odVar.a();
            } catch (Exception e) {
                r9.a("ssp_sdk", "ssp_feedback_view", e);
            }
        }
    }
}
