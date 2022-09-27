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