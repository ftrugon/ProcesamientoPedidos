data class Pedido(val id:Int,val tipo:String,val detalles:String)

interface ProcesadorPedido{
    fun procesar(pedido:Pedido)
}

class ProcesadorPedidoDigital: ProcesadorPedido{
    override fun procesar(pedido: Pedido) {
        println("Procesando pedido ${pedido.tipo}: ${pedido.detalles}")
    }
}
class ProcesadorPedidoFisico: ProcesadorPedido{
    override fun procesar(pedido: Pedido) {
        println("Procesando pedido ${pedido.tipo}: ${pedido.detalles}")
    }
}
class ProcesadorPedidoSuscripcion: ProcesadorPedido{
    override fun procesar(pedido: Pedido) {
        println("Procesando ${pedido.tipo}: ${pedido.detalles}")
    }
}


class GestorPedidos(val procesadores: Map<String, ProcesadorPedido>){
    fun gestionarPedidos(pedido: Pedido){
        val procesadorPedido = procesadores[pedido.tipo]
        if (procesadorPedido != null){
            procesadorPedido.procesar(pedido)
        }else println("Tipo de pedido 'desconocido' no soportado")
    }
}


fun main() {

    //TODO: Crear un diccionario con la clave del tipo de pedido y el procesador que lo va a gestionar  Map<String, ProcesadorPedido>

    val tipoPedidos = mapOf<String, ProcesadorPedido>(
        "digital" to ProcesadorPedidoDigital(),
        "fisico" to ProcesadorPedidoFisico(),
        "suscripcion" to ProcesadorPedidoSuscripcion()
    )

    //TODO: Crear una variable gestorPedidos para gestionar los pedidos

    val gestorPedidos = GestorPedidos(tipoPedidos)
    // Procesar pedidos...

    //TODO: Crear una variable que contenga un pedido 1 de tipo "digital" para un "E-book de Kotlin"

    val pedidoDigital = Pedido(1,"digital","E-book de kotlin")


    //TODO: Utilizar gestorPedidos para procesar este pedido
    gestorPedidos.gestionarPedidos(pedidoDigital)


    //Hacer lo mismo para un pedido "fisico" ("Libro impreso de Kotlin") y procesarlo

    val pedidoFisico = Pedido(2,"fisico","Libro impreso de kotlin")
    gestorPedidos.gestionarPedidos(pedidoFisico)

    //Hacer lo mismo para una "suscripción" ("Suscripción a curso de Kotlin") y procesarlo

    val pedidoSuscripcion = Pedido(3,"suscripcion","suscripcion a curso de kotlin")
    gestorPedidos.gestionarPedidos(pedidoSuscripcion)

    //TODO: Hacer lo mismo para un tipo "desconocido" ("Producto misterioso") y procesarlo

    val pedidoDesconocido = Pedido(4,"desconocido","Producto misterioso")
    gestorPedidos.gestionarPedidos(pedidoDesconocido)

    //TODO: Al procesar este pedido mostrará un mensaje de tipo de pedido no soportado.
}