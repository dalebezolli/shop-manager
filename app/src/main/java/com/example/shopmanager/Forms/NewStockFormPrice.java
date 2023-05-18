package com.example.shopmanager.Forms;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shopmanager.R;
import com.google.android.material.textfield.TextInputEditText;

public class NewStockFormPrice extends Fragment implements NewStock.FormFragment {

    TextInputEditText editTextOriginalPrice;
    TextInputEditText editTextDiscountedPrice;

    ConstraintLayout errorOriginalPrice;
    ConstraintLayout errorDiscountedPrice;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newstock_form_price, container, false);

        editTextOriginalPrice = view.findViewById(R.id.fragment_newstock_form_price_edittext_originalprice);
        editTextDiscountedPrice = view.findViewById(R.id.fragment_newstock_form_price_edittext_discountprice);

        errorOriginalPrice = view.findViewById(R.id.fragment_newstock_form_price_priceerror);
        errorDiscountedPrice = view.findViewById(R.id.fragment_newstock_form_price_discountpriceerror);

        return view;
    }

    @Override
    public boolean validateForm() {
        boolean isValid = true;

        if(editTextOriginalPrice.getText().length() == 0) {
            isValid = false;
            errorOriginalPrice.setVisibility(View.VISIBLE);
        } else {
            errorOriginalPrice.setVisibility(View.GONE);
        }

        if(isValid) {
            float originalPrice = Float.parseFloat(editTextOriginalPrice.getText().toString());
            float discountedPrice = (editTextDiscountedPrice.getText().length() == 0) ?
                    0.0F : Float.parseFloat(editTextDiscountedPrice.getText().toString());

            if(discountedPrice >= originalPrice) {
                isValid = false;
                errorDiscountedPrice.setVisibility(View.VISIBLE);
            } else {
                errorDiscountedPrice.setVisibility(View.GONE);
            }
        }

        return isValid;
    }
}