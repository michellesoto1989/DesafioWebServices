package br.com.digitalhouse.dsafiowebservices.comics

import com.digitalhouse.dsafiowebservices.comics.Thumbnail
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Result(

    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("pageCount") val pageCount: Int,
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("dates") val dates: List<Date>,
    @SerializedName("prices") val prices: List<Prices>,
    @SerializedName("thumbnail") val thumbnail: Thumbnail

    ) : Serializable