package com.kairat.kairotube.data.model


data class VideoInfo(val items:MutableList<Info>) {
    data class Info(
            var id:String? = null,
            var snippet:Snippet? = null
    )
    data class Snippet(
            var channelId:String? = null,
            var title:String? = null,
            var description:String? = null,
            var thumbnails: Thumbnails? = null
    )

    data class Thumbnails(
            var medium: Medium? = null
    )

    class Medium (
            var url:String? = null,
            var width:String? = null,
            var height: String? = null
    )
}