package com.creartec.googlecourse

open class Item(val name: String, val price: Int){

}

class Noodles : Item("Noodles", 10){
    override fun toString():String{
        return name
    }
}

class Vegetables(vararg val toppings:String,) : Item("Vegetables", 5){
    override fun toString():String{
        if (toppings.isEmpty()){
            return "$name Chef's Choice"
        }
        return name+" "+ toppings.joinToString(",")
    }
}
class order(val orderNumber:Int){
    private val itemList = mutableListOf<Item>()
    fun addItem(newItem:Item):order{
        itemList.add(newItem)
        return this
    }
    fun addAll(newItems:List<Item>):order{
        itemList.addAll(newItems)
        return this
    }
    fun print(){
        println("order ${orderNumber}")
        var total=0
        for(item in itemList){
            println("${item}:$${item.price}")
            total+=item.price
        }
        println("Total:$${total}")
    }
}
fun main() {
    val orderList= mutableListOf<order>()
    val order1 = order(1)
    order1.addItem(Noodles())
    orderList.add(order1)

    val order2 = order(2)
    order2.addItem(Noodles())
    order2.addItem(Vegetables())
    orderList.add(order2)


    val order3 = order(3)
    val items = listOf(Noodles(), Vegetables("Carrots", "Beans", "Celery"))
    order3.addAll(items)
    orderList.add(order3)

    val order4 = order(4).addItem(Noodles()).addItem(Vegetables("Cabbage", "Onion"))
    orderList.add(order4)

    orderList.add(
        order(5)
            .addItem(Noodles())
            .addItem(Noodles())
            .addItem(Vegetables("Spinach")))

    for (order in orderList){
        order.print()
        println()
    }


}
/*8. Resumen
Kotlin brinda funcionalidades que te ayudan a administrar y manipular colecciones de datos
con mayor facilidad mediante la biblioteca estándar de Kotlin. Se puede definir una colección
como una cantidad de objetos del mismo tipo de datos. Existen diferentes tipos de colecciones básicas en
Kotlin: listas, conjuntos y mapas. En particular, este codelab se enfocó en listas. Obtendrás más información sobre conjuntos
y mapas en codelabs futuros.

Una lista es una colección ordenada de elementos de un tipo específico, como una lista de Strings.
El índice es la posición de número entero que refleja la posición del elemento (p. ej., myList[2]).
En una lista, el primer elemento está en el índice 0 (p. ej., myList[0]) y el último elemento es myList.size-1 (p. ej., myList[myList.size-1]
o myList.last()).
Existen dos tipos de listas: List y MutableList.
Una List es de solo lectura y no se puede modificar una vez inicializada. Sin embargo, puedes aplicar operaciones
como sorted() y reversed(), que muestran una lista nueva sin cambiar la original.
Una MutableList se puede modificar después de su creación, por ejemplo, agregando, quitando o modificando elementos.
Puedes agregar una lista de elementos a una lista mutable con addAll().
Usa un bucle while para ejecutar un bloque de código hasta que la expresión resulte falsa y salgas del bucle.
while (expression) {

// While the expression is true, execute this code block

}

Usa un bucle for para iterar a través de todos los elementos de una lista:
for (item in myList) {

// Execute this code block for each element of the list

}

El modificador vararg te permite pasar una cantidad variable de argumentos a una función o constructor*/