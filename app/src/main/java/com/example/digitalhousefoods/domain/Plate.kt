package com.example.digitalhousefoods.domain

import java.io.Serializable

class Plate (val id: Int, val name: String, val imageId: Int, val restaurantId: Int) : Serializable {

    // Usando uma descrição genérica para testes. Em um app de verdade viria de um banco de dados ou API com as outras informações
    val description =
        "$name: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus rutrum ultricies bibendum. Morbi blandit, sapien a mattis aliquam, ipsum diam rutrum turpis, eget scelerisque urna quam eget nunc. Pellentesque consequat venenatis dui sit amet mollis. Mauris sodales sem a orci ullamcorper, at volutpat urna aliquet. Sed tellus odio, dignissim eget porta ac, convallis vel tortor. Proin fringilla turpis sit amet turpis egestas, nec elementum nisi laoreet. Aenean malesuada erat vitae lorem hendrerit maximus. Aenean commodo non felis quis venenatis. In a ante non metus placerat imperdiet."

    override fun toString(): String {
        return "Plate(id=$id, name='$name', imageId=$imageId, restaurantId=$restaurantId)"
    }
}