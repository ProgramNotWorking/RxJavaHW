package com.example.rxjavahw.tasks.recycler_and_fragment

data class Item(
    val itemName: String,
    val itemDescription: String
)

object ItemsUtil {
    fun getItemsList(): List<Item> {
        return listOf(
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description"),
            Item("Item name", "Item description")
        )
    }
}