package com.byazt.wg;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.fvm.w;
import com.byazt.ndr.FlowLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 204, 18})
public class l extends BaseAdapter {
    public boolean l;
    public com.byazt.wg.n n;
    public n q;
    public final List<w> qg;
    public final Context s;

    public interface n {
        void n(int i, w wVar);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public l(Context context, List<w> list, boolean z, com.byazt.wg.n nVar) {
        this.l = z;
        this.n = nVar;
        this.qg = list == null ? new ArrayList(0) : new ArrayList(list);
        this.s = context != null ? context.getApplicationContext() : context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<w> list = this.qg;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.qg.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View viewQg;
        qg qgVar;
        String str;
        if (view == null) {
            qgVar = new qg();
            viewQg = com.byazt.xn.s.qg(this.s, this.l);
            qgVar.qg = (TextView) viewQg.findViewById(2047279094);
            qgVar.s = (FlowLayout) viewQg.findViewById(2047279092);
            if (this.l) {
                qgVar.n = (ImageView) viewQg.findViewById(2047279093);
                qgVar.q = (FrameLayout) viewQg.findViewById(2047279091);
            }
            viewQg.setTag(qgVar);
        } else {
            viewQg = view;
            qgVar = (qg) view.getTag();
        }
        w wVar = this.qg.get(i);
        String strN = wVar.n();
        if (qgVar.n != null && strN != null && this.n != null) {
            strN.hashCode();
            switch (strN) {
                case "4:1":
                    str = "bu_fd_no_interest";
                    break;
                case "6:0":
                    str = "bu_fd_report";
                    break;
                case "7:1":
                    str = "bu_fd_no_close";
                    break;
                default:
                    str = "bu_fd_other";
                    break;
            }
            this.n.n(qgVar.n, "dislike/" + str + ".png");
        }
        if (qgVar.q != null) {
            qgVar.q.setVisibility(8);
        }
        qgVar.qg.setText(wVar.qg());
        if (wVar.x()) {
            qgVar.s.removeAllViews();
            List<w> listQ = wVar.q();
            for (int i2 = 0; i2 < listQ.size(); i2++) {
                final w wVar2 = listQ.get(i2);
                TextView textViewQg = qg();
                textViewQg.setText(wVar2.qg());
                textViewQg.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.wg.l.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (l.this.q != null) {
                            l.this.q.n(i, wVar2);
                        }
                    }
                });
                qgVar.s.addView(textViewQg);
            }
            qgVar.s.setVisibility(0);
        } else if ("99:1".equals(wVar.n()) && this.l && qgVar.q != null) {
            qgVar.q.removeAllViews();
            qgVar.q.setVisibility(0);
            qgVar.q.addView(n(i, wVar));
            qgVar.s.setVisibility(8);
        } else {
            qgVar.qg.setBackground(n());
            qgVar.s.setVisibility(8);
        }
        return viewQg;
    }

    private StateListDrawable n() {
        GradientDrawable gradientDrawableN = n(Color.parseColor("#FDE6E6E6"));
        GradientDrawable gradientDrawableN2 = n(Color.parseColor("#FDFFFFFF"));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawableN);
        stateListDrawable.addState(new int[0], gradientDrawableN2);
        return stateListDrawable;
    }

    private GradientDrawable n(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    private View n(final int i, final w wVar) {
        com.byazt.nnl.q qVarQg = com.byazt.nnl.n.qg();
        LinearLayout linearLayout = new LinearLayout(this.s);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        TextView textView = new TextView(this.s);
        textView.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        textView.setTextSize(14.0f);
        textView.setText("无法关闭、展示异常等问题，需复制广告ID，在应用内反馈上报问题");
        textView.setTextColor(Color.parseColor("#80161823"));
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(this.s);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.wg.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (l.this.q != null) {
                    l.this.q.n(i, wVar);
                }
            }
        });
        textView2.setText("点击复制广告ID");
        textView2.setTextColor(Color.parseColor("#161823"));
        textView2.setTextSize(14.0f);
        textView2.setGravity(17);
        GradientDrawable gradientDrawableN = n(Color.parseColor("#0A161823"));
        gradientDrawableN.setCornerRadius(qVarQg.n(this.s, 4.0f));
        textView2.setBackground(gradientDrawableN);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, qVarQg.n(this.s, 32.0f));
        layoutParams.setMargins(0, qVarQg.n(this.s, 12.0f), 0, qVarQg.n(this.s, 12.0f));
        linearLayout.addView(textView2, layoutParams);
        linearLayout.setClickable(false);
        return linearLayout;
    }

    private TextView qg() {
        TextView textView = new TextView(this.s);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        com.byazt.nnl.q qVarQg = com.byazt.nnl.n.qg();
        marginLayoutParams.setMargins(0, 0, qVarQg.n(this.s, 8.0f), qVarQg.n(this.s, 8.0f));
        textView.setLayoutParams(marginLayoutParams);
        int iN = qVarQg.n(this.s, 21.0f);
        int iN2 = qVarQg.n(this.s, 6.0f);
        textView.setPadding(iN, iN2, iN, iN2);
        GradientDrawable gradientDrawableN = n(Color.parseColor("#0A161823"));
        gradientDrawableN.setCornerRadius(qVarQg.n(this.s, 4.0f));
        textView.setBackground(gradientDrawableN);
        textView.setTextColor(Color.parseColor("#BF161823"));
        textView.setTextSize(14.0f);
        textView.setAlpha(0.75f);
        return textView;
    }

    public void n(n nVar) {
        this.q = nVar;
    }

    public void n(List<w> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.qg.clear();
        this.qg.addAll(list);
        notifyDataSetChanged();
    }

    @com.byazt.cp.n(n = {0, 1, 204, 120})
    private class qg {
        public ImageView n;
        public FrameLayout q;
        public TextView qg;
        public FlowLayout s;

        private qg() {
        }
    }
}
