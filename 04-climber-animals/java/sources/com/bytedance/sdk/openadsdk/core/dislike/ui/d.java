package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.ao.xr.xr.c;
import com.bytedance.sdk.openadsdk.widget.FlowLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d extends BaseAdapter {
    private ms ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final List<c> f2481ms;
    private final Context xr;

    public interface ms {
        void ms(int i, c cVar);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public d(Context context, List<c> list) {
        this.f2481ms = list == null ? new ArrayList(0) : new ArrayList(list);
        this.xr = context != null ? context.getApplicationContext() : context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<c> list = this.f2481ms;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f2481ms.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View viewXr;
        xr xrVar;
        if (view == null) {
            xrVar = new xr();
            viewXr = com.bytedance.sdk.openadsdk.res.d.xr(this.xr);
            xrVar.f2483ms = (TextView) viewXr.findViewById(2047279094);
            xrVar.xr = (FlowLayout) viewXr.findViewById(2047279093);
            viewXr.setTag(xrVar);
        } else {
            viewXr = view;
            xrVar = (xr) view.getTag();
        }
        c cVar = this.f2481ms.get(i);
        xrVar.f2483ms.setText(cVar.xr());
        if (cVar.c()) {
            xrVar.xr.removeAllViews();
            List<c> listD = cVar.d();
            for (int i2 = 0; i2 < listD.size(); i2++) {
                final c cVar2 = listD.get(i2);
                TextView textViewXr = xr();
                textViewXr.setText(cVar2.xr());
                textViewXr.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (d.this.ah != null) {
                            d.this.ah.ms(i, cVar2);
                        }
                    }
                });
                xrVar.xr.addView(textViewXr);
            }
            xrVar.xr.setVisibility(0);
        } else {
            xrVar.f2483ms.setBackground(ms());
            xrVar.xr.setVisibility(8);
        }
        return viewXr;
    }

    private StateListDrawable ms() {
        Drawable drawableMs = ms(Color.parseColor("#FDE6E6E6"));
        Drawable drawableMs2 = ms(Color.parseColor("#FDFFFFFF"));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawableMs);
        stateListDrawable.addState(new int[0], drawableMs2);
        return stateListDrawable;
    }

    private Drawable ms(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    private TextView xr() {
        TextView textView = new TextView(this.xr);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        com.bytedance.sdk.openadsdk.core.dislike.ms.d dVarXr = com.bytedance.sdk.openadsdk.core.dislike.ms.ms.xr();
        marginLayoutParams.setMargins(0, 0, dVarXr.ms(this.xr, 8.0f), dVarXr.ms(this.xr, 8.0f));
        textView.setLayoutParams(marginLayoutParams);
        int iMs = dVarXr.ms(this.xr, 21.0f);
        int iMs2 = dVarXr.ms(this.xr, 6.0f);
        textView.setPadding(iMs, iMs2, iMs, iMs2);
        Drawable drawableMs = ms(Color.parseColor("#0A161823"));
        ((GradientDrawable) drawableMs).setCornerRadius(dVarXr.ms(this.xr, 4.0f));
        textView.setBackground(drawableMs);
        textView.setTextColor(Color.parseColor("#BF161823"));
        textView.setTextSize(14.0f);
        textView.setAlpha(0.75f);
        return textView;
    }

    public void ms(ms msVar) {
        this.ah = msVar;
    }

    public void ms(List<c> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f2481ms.clear();
        this.f2481ms.addAll(list);
        notifyDataSetChanged();
    }

    private class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        TextView f2483ms;
        FlowLayout xr;

        private xr() {
        }
    }
}
