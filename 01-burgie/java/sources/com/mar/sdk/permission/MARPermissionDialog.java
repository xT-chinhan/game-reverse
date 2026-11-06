package com.mar.sdk.permission;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mar.sdk.permission.utils.PermissionGridAdapter;
import com.mar.sdk.utils.ResourceHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MARPermissionDialog extends Dialog {
    private final String TAG;
    private final AlertDialog ad;
    private final Activity context;
    private IProtocolListener listener;
    private String orientation;
    private List<PermissionGridAdapter.PermissionItemData> permissionLst;
    private List<MARPermissionInfo> permissions;
    private String protocolUrl;
    private boolean showProcol;
    private String userAgreementUrl;

    public MARPermissionDialog(Activity context, int theme) {
        super(context, theme);
        this.TAG = "MARSDK";
        this.userAgreementUrl = "";
        this.context = context;
        this.ad = new AlertDialog.Builder(context).create();
        this.ad.setCancelable(false);
        this.ad.setCanceledOnTouchOutside(false);
        this.ad.getWindow().setType(2);
    }

    private void doShow() {
        this.ad.show();
        WindowManager.LayoutParams attrs = this.ad.getWindow().getAttributes();
        WindowManager wm = (WindowManager) this.context.getSystemService("window");
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        float ratio = 0.9f;
        if ("landscape".equalsIgnoreCase(this.orientation)) {
            ratio = 0.6f;
        }
        attrs.width = (int) (dm.widthPixels * ratio);
        this.ad.getWindow().setAttributes(attrs);
        Window window = this.ad.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setContentView(ResourceHelper.getIdentifier(this.context, "R.layout.mar_permission_dialog_layout"));
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = -1;
        layoutParams.height = -1;
        window.setAttributes(layoutParams);
        initGrid(window);
    }

    private void initGrid(Window view) {
        try {
            Button btnOK = (Button) ResourceHelper.getViewByWindow(view, "R.id.mar_protocol_ok");
            btnOK.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.permission.MARPermissionDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    MARPermissionDialog.this.doRequestPermission();
                }
            });
            Button bntNO = (Button) ResourceHelper.getViewByWindow(view, "R.id.mar_protocol_cancel");
            bntNO.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.permission.MARPermissionDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    MARPermissionDialog.this.dismiss();
                    ResourceHelper.showTip(MARPermissionDialog.this.context, "R.string.mar_permission_exit_tip");
                    MARPermissionDialog.this.exitGame();
                }
            });
            TextView title = (TextView) ResourceHelper.getViewByWindow(view, "R.id.mar_permission_title");
            LinearLayout protocolLayout = (LinearLayout) ResourceHelper.getViewByWindow(view, "R.id.mar_protocol_tip_layout");
            if (!this.showProcol && protocolLayout != null) {
                title.setText(ResourceHelper.getString(this.context, "R.string.mar_permission_title"));
                protocolLayout.setVisibility(8);
                Log.d("MARSDK", "initGrid: not show procol,exchange title");
            } else {
                title.setText(ResourceHelper.getString(this.context, "R.string.mar_permission_confirm_title"));
                Log.d("MARSDK", "initGrid: show procol");
            }
            TextView desc = (TextView) ResourceHelper.getViewByWindow(view, "R.id.txt_permission_desc");
            RelativeLayout content = (RelativeLayout) ResourceHelper.getViewByWindow(view, "R.id.mar_permission_content");
            if (this.permissions == null || this.permissions.size() <= 0) {
                desc.setVisibility(8);
                content.setVisibility(8);
                Log.d("MARSDK", "initGrid: permission is null,not show permission list");
            } else {
                Log.d("MARSDK", "initGrid: show permission");
                desc.setVisibility(0);
                content.setVisibility(0);
                this.permissionLst = new ArrayList();
                PermissionGridAdapter permissionGridAdapter = new PermissionGridAdapter(getContext(), this.permissionLst);
                generateData();
                GridView grid = (GridView) ResourceHelper.getViewByWindow(view, "R.id.mar_permission_gridview");
                doScreenAdaptation(grid);
                grid.setAdapter((ListAdapter) permissionGridAdapter);
            }
            TextView protocolName = (TextView) ResourceHelper.getViewByWindow(view, "R.id.mar_protocol_tip_text");
            protocolName.setMovementMethod(LinkMovementMethod.getInstance());
            if (this.userAgreementUrl == null || this.userAgreementUrl.isEmpty()) {
                Log.d("MARSDK", "initGrid: only show protocol");
                SpannableString spannableString = new SpannableString(ResourceHelper.getString(this.context, "R.string.mar_permission_confirm_txt4"));
                spannableString.setSpan(new ProtocolClickableSpan(this.context, this.protocolUrl.trim()), spannableString.toString().indexOf("《"), spannableString.toString().indexOf("》") + 1, 18);
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#4EADE7")), spannableString.toString().indexOf("《"), spannableString.toString().indexOf("》") + 1, 18);
                protocolName.setText(spannableString);
                return;
            }
            Log.d("MARSDK", "initGrid: show protocol and userAgreement");
            SpannableStringBuilder builder = new SpannableStringBuilder(ResourceHelper.getString(this.context, "R.string.mar_permission_confirm_txt3"));
            int start = builder.length();
            builder.append((CharSequence) "《用户协议》");
            int end = builder.length();
            builder.setSpan(new UserClickableSpan(this.context, this.userAgreementUrl.trim()), start, end, 17);
            builder.setSpan(new ForegroundColorSpan(Color.parseColor("#4EADE7")), start, end, 17);
            builder.append((CharSequence) "和");
            int start1 = builder.length();
            builder.append((CharSequence) "《隐私政策》");
            int end1 = builder.length();
            builder.setSpan(new ProtocolClickableSpan(this.context, this.protocolUrl.trim()), start1, end1, 17);
            builder.setSpan(new ForegroundColorSpan(Color.parseColor("#4EADE7")), start1, end1, 17);
            builder.append((CharSequence) "。");
            protocolName.setText(builder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class ProtocolClickableSpan extends ClickableSpan {
        private Activity activity;
        private String url;

        public ProtocolClickableSpan(Activity activity, String url) {
            this.activity = activity;
            this.url = url;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            MARProtocolActivity.showProtocol(this.activity, this.url);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
        }
    }

    private static class UserClickableSpan extends ClickableSpan {
        private Activity activity;
        private String url;

        public UserClickableSpan(Activity activity, String url) {
            this.activity = activity;
            this.url = url;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            MARProtocolActivity.showUserAgreement(this.activity, this.url);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitGame() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.mar.sdk.permission.MARPermissionDialog.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MARPermissionDialog.this.context.finish();
                    System.exit(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRequestPermission() {
        dismiss();
        if (this.listener != null) {
            this.listener.onAgreed();
        }
    }

    private void generateData() {
        for (MARPermissionInfo permission : this.permissions) {
            PermissionGridAdapter.PermissionItemData itemData = new PermissionGridAdapter.PermissionItemData("R.drawable.mar_" + permission.getGroup().toLowerCase(), permission.getCname());
            this.permissionLst.add(itemData);
        }
    }

    private void doScreenAdaptation(GridView grid) {
        int size = this.permissionLst.size();
        DisplayMetrics dm = new DisplayMetrics();
        this.context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        int gridviewWidth = (int) (size * 84 * density);
        int itemWidth = (int) (80 * density);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(gridviewWidth, -2);
        grid.setLayoutParams(params);
        grid.setColumnWidth(itemWidth);
        grid.setHorizontalSpacing(3);
        grid.setStretchMode(0);
        grid.setNumColumns(size);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.ad != null) {
            try {
                this.ad.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void showDialog(Activity context, boolean showProtocol, String protocolUrl, String userAgreementUrl, String orientation, List<MARPermissionInfo> permissions, IProtocolListener listener) {
        MARPermissionDialog dialog = new MARPermissionDialog(context, ResourceHelper.getIdentifier(context, "R.style.mar_permission_dialog"));
        dialog.listener = listener;
        dialog.permissions = permissions;
        dialog.protocolUrl = protocolUrl;
        dialog.userAgreementUrl = userAgreementUrl;
        dialog.orientation = orientation;
        dialog.showProcol = showProtocol;
        dialog.doShow();
    }
}
