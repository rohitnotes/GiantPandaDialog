package com.nasduck.dialoglib.builder.dialog;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.nasduck.dialoglib.R;
import com.nasduck.dialoglib.interfaces.IDialogBody;
import com.nasduck.dialoglib.interfaces.IDialogFooter;
import com.nasduck.dialoglib.interfaces.IDialogHeader;
import com.nasduck.dialoglib.base.IDialogView;
import com.nasduck.dialoglib.base.BaseDialog;

public class DialogBuilder {

    private FragmentActivity mActivity;

    private IDialogHeader headerBuilder;
    private IDialogBody bodyBuilder;
    private IDialogFooter footerBuilder;

    private int mBackgroundColorId;
    private float mCornerRadius;
    private boolean mTouchOutsideCancelable;
    private boolean mTouchBackCancelable;
    private boolean mHasShade;

    private String mDialogTag;

    public DialogBuilder(FragmentActivity activity) {
        mActivity = activity;
        mBackgroundColorId = R.color.white;
        mCornerRadius = 0f;
        mDialogTag = "dialog";
        mTouchOutsideCancelable = false;
        mTouchBackCancelable = false;
        mHasShade = true;
    }

    public static DialogBuilder create(FragmentActivity activity) {
        return new DialogBuilder(activity);
    }

    public DialogBuilder setHeader(IDialogHeader builder) {
        this.headerBuilder = builder;
        return this;
    }

    public DialogBuilder setBody(IDialogBody builder) {
        this.bodyBuilder = builder;
        return this;
    }

    public DialogBuilder setFooter(IDialogFooter builder) {
        this.footerBuilder = builder;
        return this;
    }

    public DialogBuilder setDialogTag(String tag) {
        if (tag != null) {
            this.mDialogTag = tag;
        }
        return this;
    }

    public DialogBuilder setBackgroundColor(Integer colorId) {
        if (colorId != null) {
            this.mBackgroundColorId = colorId;
        }
        return this;
    }

    public DialogBuilder setCornerRadius(Float radius) {
        if (radius != null) {
            this.mCornerRadius = radius;
        }
        return this;
    }

    public DialogBuilder setTouchOutsideCancelable(Boolean cancelable) {
        if (cancelable != null) {
            this.mTouchOutsideCancelable = cancelable;
        }
        return this;
    }

    public DialogBuilder setCancelOnTouchBack(Boolean cancelable) {
        if (cancelable != null) {
            this.mTouchBackCancelable = cancelable;
        }
        return this;
    }

    public DialogBuilder setHasShade(Boolean hasShade) {
        if (hasShade != null) {
            this.mHasShade = hasShade;
        }
        return this;
    }

    public void show() {
        BaseDialog.create()
                .setDialogView(new IDialogView() {
                    @Override
                    public View getHeaderLayout(Context context) {
                        if (headerBuilder != null) {
                            headerBuilder.getCornerRadius(mCornerRadius);
                            return headerBuilder.getView(context);
                        } else {
                            return null;
                        }

                    }

                    @Override
                    public View getBodyLayout(Context context) {
                        if (bodyBuilder != null) {
                            return bodyBuilder.getView(context);
                        } else {
                            return null;
                        }

                    }

                    @Override
                    public View getFooterLayout(Context context) {
                        if (footerBuilder != null) {
                            footerBuilder.getCornerRadius(mCornerRadius);
                            footerBuilder.getNormalStatusColor(mBackgroundColorId);
                            return footerBuilder.getView(mActivity, context, mDialogTag);
                        } else {
                            return null;
                        }
                    }
                })
                .setBackgroundColor(mBackgroundColorId)
                .setCornerRadius(mCornerRadius)
                .setCanceledOnTouchOutside(mTouchOutsideCancelable)
                .setCancelOnTouchBack(mTouchBackCancelable)
                .setHasShade(mHasShade)
                .show(mActivity.getSupportFragmentManager(), mDialogTag);
    }

}
