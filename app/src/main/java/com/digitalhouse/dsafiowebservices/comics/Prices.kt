package br.com.digitalhouse.dsafiowebservices.comics
import com.google.gson.annotations.SerializedName

data class Prices (

	@SerializedName("type") val type : String,
	@SerializedName("price") val price : String
)