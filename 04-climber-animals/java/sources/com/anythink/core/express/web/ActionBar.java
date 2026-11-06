package com.anythink.core.express.web;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class ActionBar extends LinearLayout implements View.OnClickListener {
    private WebView a;

    public interface a {
        void a();

        View b();
    }

    public ActionBar(Context context) {
        super(context);
    }

    public ActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getTag();
    }

    public WebView getWebView() {
        return this.a;
    }

    public void setWebView(WebView webView) {
        this.a = webView;
    }

    public void addAction(a aVar) {
        addAction(aVar, getChildCount());
    }

    public void removeAllActions() {
        removeAllViews();
    }

    public void removeActionAt(int i) {
        if (i < 0 || i >= getChildCount()) {
            return;
        }
        removeViewAt(i);
    }

    public boolean removeAction(a aVar) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                Object tag = childAt.getTag();
                if ((tag instanceof a) && tag.equals(aVar)) {
                    removeView(childAt);
                    return true;
                }
            }
        }
        return false;
    }

    public int getActionCount() {
        return getChildCount();
    }

    private View a(a aVar) {
        View viewB = aVar.b();
        if (viewB == null) {
            return null;
        }
        View viewNewActionItem = newActionItem();
        ((ViewGroup) ((ViewGroup) viewNewActionItem).getChildAt(0)).addView(viewB);
        viewB.setTag(aVar);
        viewB.setOnClickListener(this);
        return viewNewActionItem;
    }

    public View newActionItem() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        linearLayout.setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        frameLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(frameLayout);
        return linearLayout;
    }

    public void addAction(a aVar, int i) {
        View viewNewActionItem;
        View viewB = aVar.b();
        if (viewB != null) {
            viewNewActionItem = newActionItem();
            ((ViewGroup) ((ViewGroup) viewNewActionItem).getChildAt(0)).addView(viewB);
            viewB.setTag(aVar);
            viewB.setOnClickListener(this);
        } else {
            viewNewActionItem = null;
        }
        addView(viewNewActionItem, i);
    }
}
