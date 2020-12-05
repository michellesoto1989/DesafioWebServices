package br.com.digitalhouse.dsafiowebservices.comics
import com.google.gson.annotations.SerializedName

data class Date (

	@SerializedName("type") val type : String,
	@SerializedName("date") val date : String
)