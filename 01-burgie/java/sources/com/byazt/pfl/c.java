package com.byazt.pfl;

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
import com.byazt.mr.uc;
import com.byazt.pi.FlowLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_DNS_PARSE_TIMEOUT, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends BaseAdapter {
    public boolean c;
    public final Context hn;
    public final List<uc> hw;
    public com.byazt.pfl.pr pr;
    public pr x;

    public interface pr {
        void pr(int i, uc ucVar);
    }

    public c(Context context, List<uc> list, boolean z, com.byazt.pfl.pr prVar) {
        this.c = z;
        this.pr = prVar;
        this.hw = list == null ? new ArrayList(0) : new ArrayList(list);
        this.hn = context != null ? context.getApplicationContext() : context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<uc> list = this.hw;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.hw.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View viewHw;
        hw hwVar;
        String str;
        if (view == null) {
            hwVar = new hw();
            viewHw = com.byazt.sdv.hn.hw(this.hn, this.c);
            hwVar.hw = (TextView) viewHw.findViewById(2047279094);
            hwVar.hn = (FlowLayout) viewHw.findViewById(2047279092);
            if (this.c) {
                hwVar.pr = (ImageView) viewHw.findViewById(2047279093);
                hwVar.x = (FrameLayout) viewHw.findViewById(2047279091);
            }
            viewHw.setTag(hwVar);
        } else {
            viewHw = view;
            hwVar = (hw) view.getTag();
        }
        uc ucVar = this.hw.get(i);
        String strPr = ucVar.pr();
        if (hwVar.pr != null && strPr != null && this.pr != null) {
            switch (strPr) {
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
            this.pr.pr(hwVar.pr, "dislike/" + str + ".png");
        }
        if (hwVar.x != null) {
            hwVar.x.setVisibility(8);
        }
        hwVar.hw.setText(ucVar.hw());
        if (ucVar.fw()) {
            hwVar.hn.removeAllViews();
            List<uc> listX = ucVar.x();
            for (int i2 = 0; i2 < listX.size(); i2++) {
                final uc ucVar2 = listX.get(i2);
                TextView textViewHw = hw();
                textViewHw.setText(ucVar2.hw());
                textViewHw.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.pfl.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c.this.x != null) {
                            c.this.x.pr(i, ucVar2);
                        }
                    }
                });
                hwVar.hn.addView(textViewHw);
            }
            hwVar.hn.setVisibility(0);
        } else if ("99:1".equals(ucVar.pr()) && this.c && hwVar.x != null) {
            hwVar.x.removeAllViews();
            hwVar.x.setVisibility(0);
            hwVar.x.addView(pr(i, ucVar));
            hwVar.hn.setVisibility(8);
        } else {
            hwVar.hw.setBackground(pr());
            hwVar.hn.setVisibility(8);
        }
        return viewHw;
    }

    private StateListDrawable pr() {
        GradientDrawable gradientDrawablePr = pr(Color.parseColor("#FDE6E6E6"));
        GradientDrawable gradientDrawablePr2 = pr(Color.parseColor("#FDFFFFFF"));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawablePr);
        stateListDrawable.addState(new int[0], gradientDrawablePr2);
        return stateListDrawable;
    }

    private GradientDrawable pr(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    private View pr(final int i, final uc ucVar) {
        com.byazt.rc.x xVarHw = com.byazt.rc.pr.hw();
        LinearLayout linearLayout = new LinearLayout(this.hn);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        TextView textView = new TextView(this.hn);
        textView.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        textView.setTextSize(14.0f);
        textView.setText("无法关闭、展示异常等问题，需复制广告ID，在应用内反馈上报问题");
        textView.setTextColor(Color.parseColor("#80161823"));
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(this.hn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.pfl.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.x != null) {
                    c.this.x.pr(i, ucVar);
                }
            }
        });
        textView2.setText("点击复制广告ID");
        textView2.setTextColor(Color.parseColor("#161823"));
        textView2.setTextSize(14.0f);
        textView2.setGravity(17);
        GradientDrawable gradientDrawablePr = pr(Color.parseColor("#0A161823"));
        gradientDrawablePr.setCornerRadius(xVarHw.pr(this.hn, 4.0f));
        textView2.setBackground(gradientDrawablePr);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, xVarHw.pr(this.hn, 32.0f));
        layoutParams.setMargins(0, xVarHw.pr(this.hn, 12.0f), 0, xVarHw.pr(this.hn, 12.0f));
        linearLayout.addView(textView2, layoutParams);
        linearLayout.setClickable(false);
        return linearLayout;
    }

    private TextView hw() {
        TextView textView = new TextView(this.hn);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        com.byazt.rc.x xVarHw = com.byazt.rc.pr.hw();
        marginLayoutParams.setMargins(0, 0, xVarHw.pr(this.hn, 8.0f), xVarHw.pr(this.hn, 8.0f));
        textView.setLayoutParams(marginLayoutParams);
        int iPr = xVarHw.pr(this.hn, 21.0f);
        int iPr2 = xVarHw.pr(this.hn, 6.0f);
        textView.setPadding(iPr, iPr2, iPr, iPr2);
        GradientDrawable gradientDrawablePr = pr(Color.parseColor("#0A161823"));
        gradientDrawablePr.setCornerRadius(xVarHw.pr(this.hn, 4.0f));
        textView.setBackground(gradientDrawablePr);
        textView.setTextColor(Color.parseColor("#BF161823"));
        textView.setTextSize(14.0f);
        textView.setAlpha(0.75f);
        return textView;
    }

    public void pr(pr prVar) {
        this.x = prVar;
    }

    public void pr(List<uc> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.hw.clear();
        this.hw.addAll(list);
        notifyDataSetChanged();
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_DNS_PARSE_TIMEOUT, 401})
    private class hw {
        public FlowLayout hn;
        public TextView hw;
        public ImageView pr;
        public FrameLayout x;

        private hw() {
        }
    }
}
