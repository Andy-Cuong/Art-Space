package com.example.artspace

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Artwork(
    @DrawableRes val imageResource: Int,
    @StringRes val contentDes: Int,
    @StringRes val title: Int,
    @StringRes val artist: Int,
    @StringRes val publishedYear: Int
)

val artwork1 = Artwork(
    imageResource = R.drawable.eriks_abzinovs_dark_green_fern_plant_2019,
    contentDes = R.string.artwork1_title,
    title = R.string.artwork1_title,
    artist = R.string.artwork1_artist,
    publishedYear = R.string.artwork1_published_year
)

val artwork2 = Artwork(
    imageResource = R.drawable.arthouse_studio_mountain_ridge_and_valley_through_clouds_in_sunny_day_2019,
    contentDes = R.string.artwork2_title,
    title = R.string.artwork2_title,
    artist = R.string.artwork2_artist,
    publishedYear = R.string.artwork2_published_year
)

val artwork3 = Artwork(
    imageResource = R.drawable.valeria_boltneva_brown_and_white_short_coated_puppy_2019,
    contentDes = R.string.artwork3_title,
    title = R.string.artwork3_title,
    artist = R.string.artwork3_artist,
    publishedYear = R.string.artwork3_published_year
)

val artwork4 = Artwork(
    imageResource = R.drawable.valerio_arroja_photo_trees_on_a_grassy_field_2022,
    contentDes = R.string.artwork4_title,
    title = R.string.artwork4_title,
    artist = R.string.artwork4_artist,
    publishedYear = R.string.artwork4_published_year
)