package com.orbitalsonic.multiplerecyclerview.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 *  Types of ImageView
 *      -> ImageView
 *      -> ImageFilterView
 *      -> ShapeableImageView
 *
 *  Customize following methods according to your ImageView class.
 */


@BindingAdapter("imageId")
fun ImageView.setImageFromResource(imageId: Int) {
    Glide
        .with(this)
        .load(imageId)
        .into(this)
}
