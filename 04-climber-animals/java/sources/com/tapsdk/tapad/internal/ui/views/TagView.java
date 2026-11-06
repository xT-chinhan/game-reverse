package com.tapsdk.tapad.internal.ui.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.t;
import com.tapsdk.tapad.model.entities.TagDetail;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TagView extends LinearLayout {
    private int a;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            TagView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            TagView.this.a(this.a);
        }
    }

    public TagView(Context context) {
        super(context);
        this.a = 5;
    }

    public TagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 5;
    }

    public TagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 5;
    }

    public TagView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = 5;
    }

    private int a(TextView textView) {
        return (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
    }

    public void a(int i) {
        float fA = t.a(getContext(), 16.0f);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            TextView textView = (TextView) childAt.findViewById(R.id.tag_id);
            if (textView != null) {
                float fMeasureText = textView.getPaint().measureText(textView.getText().toString());
                if (!childAt.isShown() || childAt.getRight() > getWidth() || fMeasureText > a(textView)) {
                    childAt.setVisibility(8);
                    if (i2 <= 1) {
                        setVisibility(8);
                        return;
                    }
                }
                if (i > 0) {
                    fA += fMeasureText + t.a(getContext(), 6.0f);
                    TapADLogger.d("finalSize:" + fA + "   :width:" + i + " " + textView.getText().toString());
                    if (fA > i) {
                        TapADLogger.d("finalSize:" + fA + "  " + textView.getText().toString());
                        childAt.setVisibility(8);
                    }
                }
            }
        }
    }

    public void a(List<String> list, int i, int i2, int i3) {
        TapADLogger.d("width:" + t.a(getContext(), 320.0f));
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return;
        }
        int iA = t.a(getContext(), 6.0f);
        setGravity(i2);
        setOrientation(0);
        int size = list.size();
        int size2 = list.size();
        int i4 = this.a;
        if (size2 > i4) {
            size = i4;
        }
        for (int i5 = 0; i5 < size; i5++) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.tapad_view_tag, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tag_id);
            textView.setText(list.get(i5));
            textView.setTextSize(i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i5 == 0) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.firstTag);
                layoutParams.setMargins(0, 0, 0, 0);
                layoutParams.gravity = 17;
                linearLayout.addView(viewInflate, layoutParams);
            } else {
                layoutParams.setMargins(iA, 0, 0, 0);
                addView(viewInflate, layoutParams);
                layoutParams.gravity = 17;
                layoutParams.height = t.a(getContext(), 20.0f);
            }
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new a(i3));
    }

    public void b(List<TagDetail> list, int i, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.size() < 1) {
            setVisibility(8);
            return;
        }
        for (TagDetail tagDetail : list) {
            String tagText = tagDetail.getTagText();
            if (!TextUtils.isEmpty(tagText) && tagText.length() > 1 && tagText.length() <= 30) {
                arrayList.add(tagDetail.getTagText());
            }
        }
        a(arrayList, i, i2, i3);
    }
}
