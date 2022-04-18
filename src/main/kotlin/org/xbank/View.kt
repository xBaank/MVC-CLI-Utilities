package org.xbank

/**
 * @param T es el modelo
 * @param K es el valor retornado
 */
abstract class View<T, K>() {
    protected var model: T? = null

    constructor(model: T) : this() {
        this.model = model
    }

    abstract fun invoke(): K

}
