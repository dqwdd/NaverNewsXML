package kr.co.mbest.navernewsxml.data

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml


@Xml(name = "channel")
data class RssChannel (

    @PropertyElement(name="lastBuildDate")
    val lastBuildDate: String? = null,

    @PropertyElement(name="total")
    val total: String? = null,

    @PropertyElement(name="start")
    val start: String? = null,

    @PropertyElement(name="display")
    val display: String? = null,

    @Element(name = "item")
    var item: List<Item>? = null
)

