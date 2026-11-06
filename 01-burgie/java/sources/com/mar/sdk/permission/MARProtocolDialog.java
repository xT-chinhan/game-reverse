package com.mar.sdk.permission;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.mar.sdk.permission.utils.PermissionGridAdapter;
import com.mar.sdk.utils.ResourceHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MARProtocolDialog extends Dialog {
    private AlertDialog ad;
    private Activity context;
    private IProtocolListener listener;
    private String orientation;
    private PermissionGridAdapter permissionGridAdapter;
    private List<PermissionGridAdapter.PermissionItemData> permissionLst;
    private List<MARPermissionInfo> permissions;
    private String protocolUrl;

    public MARProtocolDialog(Activity context, int theme) {
        super(context, theme);
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
        window.setContentView(ResourceHelper.getIdentifier(this.context, "R.layout.mar_protocol_confirm_layout"));
        initGrid(window);
        Button btnCancel = (Button) ResourceHelper.getViewByWindow(window, "R.id.mar_protocol_cancel");
        Button btnOK = (Button) ResourceHelper.getViewByWindow(window, "R.id.mar_protocol_ok");
        btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.permission.MARProtocolDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MARProtocolDialog.this.dismiss();
                ResourceHelper.showTip(MARProtocolDialog.this.context, "R.string.mar_permission_exit_tip");
                MARProtocolDialog.this.exitGame();
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.permission.MARProtocolDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MARProtocolDialog.this.dismiss();
                if (MARProtocolDialog.this.listener != null) {
                    MARProtocolDialog.this.listener.onAgreed();
                }
            }
        });
        TextView protocolName = (TextView) ResourceHelper.getViewByWindow(window, "R.id.mar_protocol_addr2");
        protocolName.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.permission.MARProtocolDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MARProtocolActivity.showProtocol(MARProtocolDialog.this.context, MARProtocolDialog.this.protocolUrl);
            }
        });
    }

    private void initGrid(Window view) {
        GridView grid = (GridView) ResourceHelper.getViewByWindow(view, "R.id.mar_permission_gridview");
        this.permissionLst = new ArrayList();
        this.permissionGridAdapter = new PermissionGridAdapter(getContext(), this.permissionLst);
        generateData();
        doScreenAdaptation(grid);
        grid.setAdapter((ListAdapter) this.permissionGridAdapter);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void exitGame() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.mar.sdk.permission.MARProtocolDialog.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MARProtocolDialog.this.context.finish();
                    System.exit(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 3000L);
    }

    public static void showDialog(Activity context, String orientation, String protocolUrl, List<MARPermissionInfo> permissions, IProtocolListener listener) {
        MARProtocolDialog dialog = new MARProtocolDialog(context, ResourceHelper.getIdentifier(context, "R.style.mar_permission_dialog"));
        dialog.context = context;
        dialog.protocolUrl = protocolUrl;
        dialog.permissions = permissions;
        dialog.orientation = orientation;
        dialog.listener = listener;
        dialog.doShow();
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
}
