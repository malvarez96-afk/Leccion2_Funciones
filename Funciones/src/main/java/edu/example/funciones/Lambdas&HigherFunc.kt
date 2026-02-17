package edu.example.funciones

fun main(){
    var dirtyLevel = 20
    val waterFilter = { dirty : Int -> dirty / 2}
    println(waterFilter(dirtyLevel))

    val waterFilter2: (Int) -> Int = { dirty -> dirty / 2 }
    println(waterFilter2(dirtyLevel))

    fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
        return operation(dirty)
    }

    val waterFilter3: (Int) -> Int = { dirty -> dirty / 2 }
    println(updateDirty(30, waterFilter3))

    fun increaseDirty( start: Int ) = start + 1

    println(updateDirty(15, ::increaseDirty))

    dirtyLevel = 19
    dirtyLevel = updateDirty(dirtyLevel) { dirtyLevel -> dirtyLevel + 23}
    println(dirtyLevel)
}

