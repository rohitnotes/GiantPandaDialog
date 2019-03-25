package com.nasduck.dialoglib.dialog.classification.base;

import android.support.v4.app.FragmentActivity;

import com.nasduck.dialoglib.builder.dialog.DialogBuilder;
import com.nasduck.dialoglib.builder.dialog.footer.OneButtonFooterBuilder;
import com.nasduck.dialoglib.builder.dialog.footer.ThreeButtonFooterBuilder;
import com.nasduck.dialoglib.builder.dialog.footer.TwoButtonFooterBuilder;
import com.nasduck.dialoglib.builder.dialog.header.TextHeaderBuilder;
import com.nasduck.dialoglib.dialog.classification.TextDialog;
import com.nasduck.dialoglib.dialog.classification.base.ITitleBaseDialog;
import com.nasduck.dialoglib.enums.DialogButtonNumber;
import com.nasduck.dialoglib.enums.GravityWay;
import com.nasduck.dialoglib.interfaces.OnNegativeClickListener;
import com.nasduck.dialoglib.interfaces.OnNormalClickListener;
import com.nasduck.dialoglib.interfaces.OnPositiveClickListener;

public abstract class TitleBaseDialog<T> implements ITitleBaseDialog {

    private FragmentActivity activity;

    private String tag;
    private Integer backgroundColorId;
    private Float cornerRadius;
    private Boolean touchOutsideCancelable;
    private Boolean touchBackCancelable;
    private Boolean hasShade;

    private String title;
    private Integer titleSize;
    private Integer titleColor;
    private GravityWay gravityWay;
    private Integer paddingLeft;
    private Integer paddingTop;
    private Integer paddingRight;
    private Integer paddingBottom;

    private DialogButtonNumber buttonNumber = DialogButtonNumber.ONE;

    private OnNormalClickListener normalClickListener;
    private OnPositiveClickListener positiveClickListener;
    private OnNegativeClickListener negativeClickListener;

    private String normalButtonText;
    private Integer normalButtonTextColor;
    private Integer normalButtonTextSize;

    private String positiveButtonText;
    private Integer positiveButtonTextColor;
    private Integer positiveButtonTextSize;

    private String negativeButtonText;
    private Integer negativeButtonTextColor;
    private Integer negativeButtonTextSize;

    public TitleBaseDialog(FragmentActivity activity) {
        this.activity = activity;
    }

    public void show() {
        DialogBuilder builder = new DialogBuilder(activity);
        // set header config
        TextHeaderBuilder headerBuilder;
        if (title == null) {
            headerBuilder = null;
        } else {
            headerBuilder = new TextHeaderBuilder();
            headerBuilder.setTitle(title)
                    .setTitleSize(titleSize)
                    .setTitleColor(titleColor)
                    .setGravityWay(gravityWay)
                    .setPaddingTop(paddingTop)
                    .setPaddingBottom(paddingBottom)
                    .setPaddingLeft(paddingLeft)
                    .setPaddingRight(paddingRight);
        }
        builder.setHeader(headerBuilder);

        // set body config
        setBodyBuilderConfig(builder);

        // set footer config
        switch (buttonNumber) {
            case ONE:
                OneButtonFooterBuilder oneFooterBuilder = new OneButtonFooterBuilder();
                oneFooterBuilder.setNormalButtonText(normalButtonText)
                        .setNormalButtonTextSize(normalButtonTextSize)
                        .setNormalButtonTextColor(normalButtonTextColor)
                        .setNormalClickListener(normalClickListener);
                builder.setFooter(oneFooterBuilder);
                break;
            case TWO:
                TwoButtonFooterBuilder twoFooterBuilder = new TwoButtonFooterBuilder();
                twoFooterBuilder.setPositiveButtonText(positiveButtonText)
                        .setPositiveButtonTextSize(positiveButtonTextSize)
                        .setPositiveButtonTextColor(positiveButtonTextColor)
                        .setPositiveClickListener(positiveClickListener)
                        .setNegativeButtonText(negativeButtonText)
                        .setNegativeButtonTextSize(negativeButtonTextSize)
                        .setNegativeButtonTextColor(negativeButtonTextColor)
                        .setNegativeClickListener(negativeClickListener);
                builder.setFooter(twoFooterBuilder);
                break;
            case THREE:
                ThreeButtonFooterBuilder threeFooterBuilder = new ThreeButtonFooterBuilder();
                threeFooterBuilder.setNormalButtonText(normalButtonText)
                        .setNormalButtonTextSize(normalButtonTextSize)
                        .setNormalButtonTextColor(normalButtonTextColor)
                        .setNormalClickListener(normalClickListener)
                        .setPositiveButtonText(positiveButtonText)
                        .setPositiveButtonTextSize(positiveButtonTextSize)
                        .setPositiveButtonTextColor(positiveButtonTextColor)
                        .setPositiveClickListener(positiveClickListener)
                        .setNegativeButtonText(negativeButtonText)
                        .setNegativeButtonTextSize(negativeButtonTextSize)
                        .setNegativeButtonTextColor(negativeButtonTextColor)
                        .setNegativeClickListener(negativeClickListener);
                builder.setFooter(threeFooterBuilder);
                break;
        }

        // set dialog config
        builder.setDialogTag(tag)
                .setCornerRadius(cornerRadius)
                .setBackgroundColor(backgroundColorId)
                .setCancelOnTouchBack(touchBackCancelable)
                .setTouchOutsideCancelable(touchOutsideCancelable)
                .setHasShade(hasShade)
                .show();
    }

    public T setTag(String tag) {
        this.tag = tag;
        return (T)this;
    }

    public T setBackgroundColor(Integer colorId) {
        this.backgroundColorId = colorId;
        return (T)this;
    }

    public T setCornerRadius(Float cornerRadius) {
        this.cornerRadius = cornerRadius;
        return (T)this;
    }

    public T setCanceledOnTouchOutside(Boolean cancelable) {
        this.touchOutsideCancelable = cancelable;
        return (T)this;
    }

    public T setCancelOnTouchBack(Boolean cancelable) {
        this.touchBackCancelable = cancelable;
        return (T)this;
    }

    public T setHasShade(Boolean hasShade) {
        this.hasShade = hasShade;
        return (T)this;
    }

    public T setTitle(String title) {
        this.title = title;
        return (T)this;
    }

    public T setTitleSize(Integer titleSize) {
        this.titleSize = titleSize;
        return (T)this;
    }

    public T setTitleColor(Integer titleColor) {
        this.titleColor = titleColor;
        return (T)this;
    }

    public T setTitleGravity(GravityWay gravityWay) {
        this.gravityWay = gravityWay;
        return (T)this;
    }

    public T setTitlePadding(Integer left, Integer top, Integer right, Integer bottom) {
        this.paddingLeft = left;
        this.paddingTop = top;
        this.paddingRight = right;
        this.paddingBottom = bottom;
        return (T)this;
    }

    public T setButtonNumber(DialogButtonNumber number) {
        buttonNumber = number;
        return (T)this;
    }

    public T setNormalClickListener(OnNormalClickListener normalClickListener) {
        this.normalClickListener = normalClickListener;
        return (T)this;
    }

    public T setNormalButtonText(String normalButtonText) {
        this.normalButtonText = normalButtonText;
        return (T)this;
    }

    public T setNormalButtonTextColor(Integer normalButtonTextColor) {
        this.normalButtonTextColor = normalButtonTextColor;
        return (T)this;
    }

    public T setNormalButtonTextSize(Integer normalButtonTextSize) {
        this.normalButtonTextSize = normalButtonTextSize;
        return (T)this;
    }

    public T setPositiveClickListener(OnPositiveClickListener positiveClickListener) {
        this.positiveClickListener = positiveClickListener;
        return (T)this;
    }

    public T setNegativeClickListener(OnNegativeClickListener negativeClickListener) {
        this.negativeClickListener = negativeClickListener;
        return (T)this;
    }

    public T setPositiveButtonText(String positiveButtonText) {
        this.positiveButtonText = positiveButtonText;
        return (T)this;
    }

    public T setPositiveButtonTextColor(Integer positiveButtonTextColor) {
        this.positiveButtonTextColor = positiveButtonTextColor;
        return (T)this;
    }

    public T setPositiveButtonTextSize(Integer positiveButtonTextSize) {
        this.positiveButtonTextSize = positiveButtonTextSize;
        return (T)this;
    }

    public T setNegativeButtonText(String negativeButtonText) {
        this.negativeButtonText = negativeButtonText;
        return (T)this;
    }

    public T setNegativeButtonTextColor(Integer negativeButtonTextColor) {
        this.negativeButtonTextColor = negativeButtonTextColor;
        return (T)this;
    }

    public T setNegativeButtonTextSize(Integer negativeButtonTextSize) {
        this.negativeButtonTextSize = negativeButtonTextSize;
        return (T)this;
    }


}
