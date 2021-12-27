package kr.co.mbest.navernewsxml.data

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "rss")
data class RssFeed (

    @Element(name = "channel")
    var channel: RssChannel? = null
    )