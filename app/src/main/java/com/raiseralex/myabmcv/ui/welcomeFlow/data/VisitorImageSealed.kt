package com.raiseralex.myabmcv.ui.welcomeFlow.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.raiseralex.myabmcv.R

sealed class VisitorImageSealed(
    @DrawableRes open val id: Int,
    @StringRes open val title: Int,
    @StringRes open val description: Int,
) {
    data class RhImageModel(
        @DrawableRes override val id: Int,
        @StringRes override val title: Int,
        @StringRes override val description: Int,
    ) : VisitorImageSealed(id, title, description)

    data class DevImageModel(
        @DrawableRes override val id: Int,
        @StringRes override val title: Int,
        @StringRes override val description: Int,
    ) : VisitorImageSealed(id, title, description)

    data class AnonymousImageModel(
        @DrawableRes override val id: Int,
        @StringRes override val title: Int,
        @StringRes override val description: Int,
    ) : VisitorImageSealed(id, title, description)
}

fun getMockupList(): List<VisitorImageSealed> {
    return listOf(
        VisitorImageSealed.RhImageModel(
            id = R.drawable.rh_image,
            title = R.string.rh_visitor_title,
            description = R.string.rh_image_description,
        ),
        VisitorImageSealed.DevImageModel(
            id = R.drawable.dev_image,
            title = R.string.developer_visitor_title,
            description = R.string.dev_image_description,
        ),
        VisitorImageSealed.AnonymousImageModel(
            id = R.drawable.anonymous_image,
            title = R.string.anonymous_visitor_title,
            description = R.string.anonymous_image_description,
        ),
    )
}
