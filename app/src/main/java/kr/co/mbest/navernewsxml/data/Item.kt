package kr.co.mbest.navernewsxml.data

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml
data class Item (

    @PropertyElement(name="title")
    val title: String? = null,

    @PropertyElement(name="originallink")
    val originallink: String? = null,

    @PropertyElement(name="link")
    val link: String? = null,

    @PropertyElement(name="description")
    val description: String? = null,

    @PropertyElement(name="pubDate")
    val pubDate: String? = null,


    /*
    val title: String? = null,

    val originallink: String? = null,

    val link: String? = null,

    val description: String? = null,

    val pubDate: String? = null
    */
)