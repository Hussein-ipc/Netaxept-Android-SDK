package eu.nets.pia.sample;

import android.app.Application;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TextAppearanceSpan;

import eu.nets.pia.PiaInterfaceConfiguration;
import eu.nets.pia.data.model.PiaLanguage;
import eu.nets.pia.sample.data.PiaSampleSharedPreferences;

/**
 * MIT License
 * <p>
 * Copyright (c) 2020 Nets Denmark A/S
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy  of this software
 * and associated documentation files (the "Software"), to deal  in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is  furnished to do so,
 * subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //init the preference file from Application Class
        PiaSampleSharedPreferences.initPrefs(this);

        //set the SDK configuration related to CardIo at runtime
        PiaInterfaceConfiguration.getInstance().setDisableCardIO(PiaSampleSharedPreferences.isDisableCardIo());
        PiaInterfaceConfiguration.getInstance().setDisableSaveCardOption(PiaSampleSharedPreferences.isDisableSaveCardOption());

        //apply custom UI elements to SDK such as colors, fonts and icons
        //uncomment the method call to test the customization
        //customizeSDK();
    }

    /**
     * As colors, pass only resolved colors (ColorInt): ContextCompat.getColor() or Color objects, as below
     */
    private void customizeSDK() {
        //SDK Configuration
        PiaInterfaceConfiguration.getInstance().setLabelTextColor(ContextCompat.getColor(this, R.color.custom_orange_color));
        PiaInterfaceConfiguration.getInstance().setFieldTextColor(Color.BLUE);
        PiaInterfaceConfiguration.getInstance().setFieldBackgroundColor(ContextCompat.getColor(this, R.color.accent));
        PiaInterfaceConfiguration.getInstance().setButtonTextColor(Color.WHITE);
        PiaInterfaceConfiguration.getInstance().setSwitchThumbColor(ContextCompat.getColor(this, R.color.pia_green_color));
        PiaInterfaceConfiguration.getInstance().setButtonBackgroundColor(R.drawable.pia_save_card_button);
        PiaInterfaceConfiguration.getInstance().setToolbarActionButtonTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        PiaInterfaceConfiguration.getInstance().setLabelFont(Typeface.SANS_SERIF);
        PiaInterfaceConfiguration.getInstance().setButtonFont(Typeface.SERIF);
        PiaInterfaceConfiguration.getInstance().setFieldFont(Typeface.MONOSPACE);
        PiaInterfaceConfiguration.getInstance().setSaveCardSwitchDefault(true);
        PiaInterfaceConfiguration.getInstance().setLogoDrawable(ContextCompat.getDrawable(this, R.drawable.pia_digital_payment_by_nets));
        PiaInterfaceConfiguration.getInstance().setErrorFieldBorderColor(Color.YELLOW);
        PiaInterfaceConfiguration.getInstance().setValidFieldBorderColor(Color.BLUE);
        PiaInterfaceConfiguration.getInstance().setToolbarBackgroundColor(ContextCompat.getColor(this, R.color.light_gray));
        PiaInterfaceConfiguration.getInstance().setToolbarTitleColor(ContextCompat.getColor(this, R.color.pia_black_color));
        PiaInterfaceConfiguration.getInstance().setBodyBackgroundColor(Color.WHITE);
        PiaInterfaceConfiguration.getInstance().setTokenCardCVCLayoutBackgroundColor(ContextCompat.getColor(this, R.color.light_gray));

        //Scan Card UI configuration
        PiaInterfaceConfiguration.getInstance().setCardIOBackgroundColor(ContextCompat.getColor(this, R.color.custom_orange_color));
        PiaInterfaceConfiguration.getInstance().setCardIOButtonTextColor(Color.RED);
        PiaInterfaceConfiguration.getInstance().setCardIOButtonTextFont(Typeface.SERIF);
        PiaInterfaceConfiguration.getInstance().setCardIOTextColor(Color.YELLOW);
        PiaInterfaceConfiguration.getInstance().setCardIOPreviewFrameColor(Color.RED);
        PiaInterfaceConfiguration.getInstance().setCardIOTextFont(Typeface.MONOSPACE);

        //PiaSDK localization language
        PiaInterfaceConfiguration.getInstance().setPiaLanguage(PiaLanguage.SWEDISH);

        //Manual entry text adjacent to save card switch
        String text = this.getResources().getString(R.string.use_save_card_text);
        TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(this, R.style.UICustomizationTextViewStyle);
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(textAppearanceSpan, 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        PiaInterfaceConfiguration.getInstance().setSpannableSaveCardText(spannableString);

        PiaInterfaceConfiguration.getInstance().setActionButtonLeftMargin(50);
        PiaInterfaceConfiguration.getInstance().setActionButtonRightMargin(50);
        PiaInterfaceConfiguration.getInstance().setActionButtonBottomMargin(50);
        PiaInterfaceConfiguration.getInstance().setFieldRoundCorner(50);
        PiaInterfaceConfiguration.getInstance().setSwitchTurnOffColor(ContextCompat.getColor(this, R.color.custom_orange_color));
        PiaInterfaceConfiguration.getInstance().setButtonRoundCorner((int) getResources().getDimension(R.dimen.custom_button_radius));
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(ContextCompat.getColor(this, R.color.light_gray));
        drawable.setCornerRadius(8);
        PiaInterfaceConfiguration.getInstance().setCardIOButtonBackgroundSelector(drawable);
        PiaInterfaceConfiguration.getInstance().setInputTextHintColor(ContextCompat.getColor(this, R.color.custom_orange_color));
        PiaInterfaceConfiguration.getInstance().setSwitchOnTrackColor(ContextCompat.getColor(this, R.color.light_gray));
    }
}
