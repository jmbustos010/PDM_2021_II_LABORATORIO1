class MainClass(){
    fun main(args: Array<String>){
        do {
            println("1. Cobro ENEE")
            println("2. Cobro SANAA")
            println("3. Recargar Tigo")
            println("4. Recargar Claro")
            println("5. Debitar Cuenta")
            println("6. Acreditar Cuenta")
            println("Ingrese una opcion")
            var opcion = readLine()!!.toInt()

            when(opcion){
                1 -> cobroENEE()
                2 -> cobroSANAA()
                3 -> menuTigo()
                4 -> menuClaro()
                5 -> debitar()
                6 -> acreditar()
                else -> println("Opcion no valida, intete otra vez")
            }

            println("Desea realizar otra opcion (S/N)")
            var seguir = readLine().toString()
        }while (seguir.equals("S")||seguir.equals("s"))

        println("Gracias por usar nuestro sistema!!")

    }

    fun cobroENEE(){
        val pagoEnee1 = PagoENEE()
        var contador = 0
        var contador2 = 0

        println("Cobro ENEE")
        println("Por favor, ingrese el nombre del cliente:")
        pagoEnee1.nombreCliente = readLine().toString()

        do {
            contador2 = 0
            println("Por favor, ingrese el codigo del cliente:")
            pagoEnee1.codigoDeCliente = readLine().toString().toInt()

            if (pagoEnee1.codigoDeCliente <= 0){
                println("Codigo de cliente incorrecto")
                pagoEnee1.codigoDeCliente = 0
                contador2++
            }
        }while (contador2 > 0)

        println("Por favor, ingrese la direccion del cliente")
        pagoEnee1.direccion = readLine().toString()

        do{
            contador = 0
            println("Por favor, ingrese el consumo en kWh del cliente:")
            pagoEnee1.consumo = readLine().toString().toDouble()

            if (pagoEnee1.consumo < 0){
                println("El consumo no puede ser menor a 0")
                pagoEnee1.consumo = 0.0
                contador++
            }
        }while (contador > 0)

        pagoEnee1.totalPagar = pagoEnee1.cobro()
        println("El total a pagar es ${pagoEnee1.totalPagar}")

        println("¿Desea realizar el pago en este momento? (S/N)")
        var opcion = readLine().toString()

        if (opcion.equals("s")||opcion.equals("S")){
            println("Ingrese la fecha actual:")
            pagoEnee1.fechaDePago = readLine().toString()
            println("Cobro realizado con exito, a continuacion su recibo: \n${pagoEnee1.imprimirRecibo()}")
        }else{
            println("Gracias por consultar su saldo, pague antes de la fecha establecida.")
        }
    }
    //-----
    fun cobroSANAA(){
        val pagoSanaa1 = PagoSANAA()
        var contador = 0
        var contador2 = 0

        println("Cobro SANAA")
        println("Por favor, ingrese el nombre del cliente:")
        pagoSanaa1.nombreCliente = readLine().toString()

        do {
            contador2 = 0
            println("Por favor, ingrese el codigo del cliente:")
            pagoSanaa1.codigoDeCliente = readLine().toString().toInt()

            if (pagoSanaa1.codigoDeCliente <= 0){
                println("Codigo de cliente incorrecto")
                pagoSanaa1.codigoDeCliente = 0
                contador2++
            }
        }while (contador2 > 0)

        println("Por favor, ingrese la direccion del cliente")
        pagoSanaa1.direccion = readLine().toString()

        do{
            contador = 0
            println("Por favor, ingrese el consumo en m^3 del cliente:")
            pagoSanaa1.consumo = readLine().toString().toDouble()

            if (pagoSanaa1.consumo < 0){
                println("El consumo no puede ser menor a 0")
                pagoSanaa1.consumo = 0.0
                contador++
            }
        }while (contador > 0)

        pagoSanaa1.totalPagar = pagoSanaa1.cobro()
        println("El total a pagar es ${pagoSanaa1.totalPagar}")

        println("¿Desea realizar el pago en este momento? (S/N)")
        var opcion = readLine().toString()

        if (opcion.equals("s")||opcion.equals("S")){
            println("Ingrese la fecha actual:")
            pagoSanaa1.fechaDePago = readLine().toString()
            println("Cobro realizado con exito, a continuacion su recibo: \n${pagoSanaa1.imprimirRecibo()}")
        }else{
            println("Gracias por consultar su saldo, pague antes de la fecha establecida.")
        }
    }
    //-----
    var cliente1 = Cliente()
    var cliente2 = Cliente()
    fun menuTigo(){
        var respuesta = ""
        do{
            if (cliente1.numero == 0) {
                println("Ingrese su numero de telefono")
                var numero = readLine().toString().toInt()
                cliente1.numero = numero
            }
            println("========Ingrese una opcion========")
            println("1. Recarga Tigo")
            println("2. Paquetigos")
            println("3. Super Recargas Tigos")
            println("4. Menu Principal")

            var opcion = readLine().toString().toInt()
            when (opcion) {
                1 -> recargas()
                2 -> paquetigos()
                3 -> superRecargas()
                4 -> println("")
                else -> println("Opcion no valida.")
            }
            println("¿Desea seguir usando el servicio de Tigo en este momento? (S/N)")
            var respuesta = readLine().toString()
        }while(respuesta.equals("s")||respuesta.equals("S"))
        println("Gracias por usar nuestro servicio de Tigo")
    }


    fun recargas() {
        println("========Ingrese la cantidad de la recarga========")
        var monto = readLine().toString().toInt()
        cliente1.monto = monto
        if (cliente1.monto <= 0) {
            println("Recarga no puede ser menor a 0")
        } else {
            println("Recarga de Lps.${cliente1.monto} acreditada al numero ${cliente1.numero} con exito!")
        }
    }

    fun paquetigos(){
        println("========Ingrese una opcion========")
        println("1. Whatsapp Chat Ilimitado (L.14 - 1 Dia)")
        println("2. Facebook Ilimitado (L.17 - 1 Dia)")
        println("3. Paquete de Internet 500MB (L.50 - 3 Dias)")
        println("4. Paquete de Internet 1GB (L.55 - 1 Dia)")
        var opcion = readLine().toString().toInt()
        when(opcion){
            1-> println("Paquete de Whatsapp acreditado al numero ${cliente1.numero} con exito!")
            2-> println("Paquete de Facebook Ilimitado acreditado al numero ${cliente1.numero} con exito!")
            3-> println("Paquete de Internet de 500MB acreditada al numero ${cliente1.numero} con exito!")
            4-> println("Paquete de Internet de 1GB acreditada al numero ${cliente1.numero} con exito!")
            else -> println("Opcion no valida.")
        }
    }

    fun superRecargas(){
        println("========Ingrese una opcion========")
        println("1. Super Recarga Tigo de L.25")
        println("2. Super Recarga Tigo de L.50")
        println("3. Super Recarga Tigo de L.100")
        println("4. Super Recarga Tigo de L.220")
        var opcion = readLine().toString().toInt()
        when(opcion){
            1-> println("Super Recarga de Lps.25 acreditada al numero ${cliente1.numero} con exito!")
            2-> println("Super Recarga de Lps.50 acreditada al numero ${cliente1.numero} con exito!")
            3-> println("Super Recarga de Lps.100 acreditada al numero ${cliente1.numero} con exito!")
            4-> println("Super Recarga de Lps.220 acreditada al numero ${cliente1.numero} con exito!")
            else -> println("Opcion no valida.")
        }
    }

    //-----
    fun menuClaro(){
        var respuesta = ""
        do {
            if (cliente2.numero == 0) {
                println("Ingrese su numero de telefono")
                var numero = readLine().toString().toInt()
                cliente2.numero = numero
            }
            println("========Ingrese una opcion========")
            println("1. Recarga Claro")
            println("2. Promocion del Dia")
            println("3. Paquetes Ilimitados")
            println("4. Entretenimientos y Todos")
            var opcion = readLine().toString().toInt()
                when (opcion) {
                    1 -> paquetesClaro()
                    2 -> promocion()
                    3 -> ilimitados()
                    4 -> entretenimientos()
                    else -> println("Opcion no valida.")
                }
                println("¿Desea seguir usando el servicio de Claro en este momento? (S/N)")
                var respuesta = readLine().toString()
            } while (respuesta.equals("s") || respuesta.equals("S"))
            println("Gracias por usar nuestro servicio de Claro")
        }


    fun paquetesClaro(){
        println("========Ingrese la cantidad de la recarga========")
        var monto = readLine().toString().toInt()
        cliente2.monto = monto
        if (cliente2.monto <= 0) {
            println("Recarga no puede ser menor a 0")
        } else {
            println("Recarga de Lps.${cliente2.monto} acreditada al numero ${cliente2.numero} con exito!")
        }
    }

    fun promocion(){
        println("========Ingrese una opcion========")
        println("1. 15GB + llamadas ilimitadas L150(7 Dias)")
        var opcion = readLine().toString().toInt()
        when(opcion){
            1-> println("Paquete de promocion activado al numero ${cliente2.numero} con exito!")
            else -> println("Opcion no valida.")
        }
    }

    fun ilimitados(){
        println("========Ingrese una opcion========")
        println("1. 3 Horas L.15")
        println("2. 2 Dias L.50")
        println("3. 4 Dias L.80")
        println("4. 7 Dias L.150")
        var opcion = readLine().toString().toInt()
        when(opcion){
            1-> println("Paquete de 3 horas ilimitadas comprado al numero ${cliente2.numero} con exito!")
            2-> println("Paquete de 2 dias ilimitadas comprado al numero ${cliente2.numero} con exito!")
            3-> println("Paquete de 4 dias ilimitadas comprado al numero ${cliente2.numero} con exito!")
            4-> println("Paquete de 7 dias ilimitadas comprado al numero ${cliente2.numero} con exito!")
            else -> println("Opcion no valida.")
        }
    }

    fun entretenimientos(){
        println("========Elige tu paquete de entretenimiento========")
        println("1. Claro Drive")
        println("2. Claro Musica")
        var opcion = readLine().toString().toInt()
        when(opcion){
            1-> claroDrive()
            2-> claroMusica()
            else -> println("Opcion no valida.")
        }
    }

    fun claroDrive(){
        println("========Selecciona tu paquete Claro Drive========")
        println("1. 25GB por L12.25 al mes")
        println("2. 75GB por L24.50 al mes")
        var opcion = readLine().toString().toInt()
        when(opcion){
            1-> println("Disfruta tus 25GB de espacio de Claro Drive!")
            2-> println("Disfruta tus 75GB de espacio de Claro Drive!")
            else -> println("Opcion no valida.")
        }
    }

    fun claroMusica() {
        println("========Selecciona tu plan de Claro Musica========")
        println("1. Suscripcion Semanal L.46.98")
        println("2. Suscripcion Mensual L.141.99")
        var opcion = readLine().toString().toInt()
        when (opcion) {
            1 -> println("Disfruta tu Suscripcion Semanal de Claro Musica!")
            2 -> println("Disfruta tu Suscripcion Mensual de Claro Musica!")
            else -> println("Opcion no valida.")
        }
    }
    //-----
    private val c1 = Cuenta()
    private val c2 = Cuenta()

    private fun debitar(){
        c1.numeroCuenta = 123
        c2.numeroCuenta = 456
        var cont   : Int
        var cont2  : Int
        var monto  : Int
        var cuenta : Int

        do {
            cont2 = 0
            println("Ingrese el numero de cuenta al que desea debitar: ")
            cuenta = readLine()!!.toInt()
            if (cuenta != c1.numeroCuenta && cuenta != c2.numeroCuenta){
                println("El numero de cuenta que ingreso es invalido")
                cont2++
            }
        }while (cont2 !=0 )

        do {
            cont = 0
            println("Ingrese el monto que desea debitar: ")
            monto = readLine()!!.toInt()
            if (monto <=0 || monto > 5000 || monto >= c1.saldo || monto >= c2.saldo ){
                println("El monto que ingreso es invalido, o supera el saldo total de la cuenta.")
                cont++
            }else{
                if (cuenta == c1.numeroCuenta){
                    c1.monto = monto
                    c1.saldo = c1.saldo - c1.monto
                    println("Numero de cuenta        : ${c1.numeroCuenta}")
                    println("Monto de la transaccion : ${c1.monto}")
                    println("Saldo total de la cuenta: ${c1.saldo}")
                }else{
                    c2.monto = monto
                    c2.saldo = c2.saldo - c2.monto
                    println("Numero de cuenta        : ${c2.numeroCuenta}")
                    println("Monto de la transaccion : ${c2.monto}")
                    println("Saldo total de la cuenta: ${c2.saldo}")
                }
            }
        }while (cont != 0)
    }
    //-----
    private fun acreditar(){
        c1.numeroCuenta = 123
        c2.numeroCuenta = 456
        var cont  : Int
        var cont2 : Int
        var monto : Int
        var cuenta:Int

        do {
            cont2 = 0
            println("Ingrese el numero de cuenta al que desea acreditar: ")
            cuenta = readLine()!!.toInt()
            if (cuenta != c1.numeroCuenta && cuenta != c2.numeroCuenta){
                println("El numero de cuenta que ingreso es invalido")
                cont2++
            }
        }while (cont2 !=0 )

        do {
            cont = 0
            println("Ingrese el monto que desea acreditar: ")
            monto = readLine()!!.toInt()
            if (monto <=0 || monto > 10000){
                println("El monto que ingreso es invalido")
                cont++
            }else{
                if (cuenta == c1.numeroCuenta){
                    c1.monto = monto
                    c1.saldo = c1.saldo + c1.monto
                    println("Numero de cuenta        : ${c1.numeroCuenta}")
                    println("Monto de la transaccion : ${c1.monto}")
                    println("Saldo total de la cuenta: ${c1.saldo}")
                }else{
                    c2.monto = monto
                    c2.saldo = c2.saldo + c2.monto
                    println("Numero de cuenta        : ${c2.numeroCuenta}")
                    println("Monto de la transaccion : ${c2.monto}")
                    println("Saldo total de la cuenta: ${c2.saldo}")
                }
            }
        }while (cont != 0)
    }
}
MainClass().main(arrayOf(""))


open class PagoPublico{
    var codigoDeCliente: Int = 0
    var nombreCliente  : String = ""
    var totalPagar     : Double = 0.0
    var direccion      : String = ""
    var fechaDePago    : String = ""
    open val tarifa    : Double = 0.0
    var consumo        : Double = 0.0

    constructor()
    constructor(
        codigoDeCliente: Int, nombreCliente: String, totalPagar: Double,
        direccion: String, fechaDePago: String, tarifa: Double, consumo: Double)

    open fun cobro(): Double{
        return tarifa*consumo
    }

    open fun imprimirRecibo(): String{
        return "*Nombre del cliente: $nombreCliente  *Código de cliente: $codigoDeCliente \n*Direccion del cliente: $direccion" +
                "\n*Fecha de Pago: $fechaDePago"
    }

}
//-----
class PagoENEE:PagoPublico{
    override val tarifa: Double = 4.4

    constructor()
    constructor(codigoDeCliente: Int, nombreCliente: String, totalPagar: Double,
                direccion: String, fechaDePago: String, tarifa: Double, consumo: Double):super(codigoDeCliente,
        nombreCliente, totalPagar, direccion, fechaDePago, tarifa, consumo)

    override fun imprimirRecibo(): String {
        return "----------------------\n Recibo de pago ENEE\n----------------------\n"+super.imprimirRecibo()+
                "\nSu consumo en kWh es = $consumo" + "\nEl total a pagar es ${cobro()}"
    }

}
//-----
class PagoSANAA:PagoPublico{
    override val tarifa: Double = 14.1

    constructor()
    constructor(codigoDeCliente: Int, nombreCliente: String, totalPagar: Double,
                direccion: String, fechaDePago: String, tarifa: Double, consumo: Double):super(codigoDeCliente,
        nombreCliente, totalPagar, direccion, fechaDePago, tarifa, consumo)

    override fun cobro(): Double{
        return tarifa*consumo
    }

    override fun imprimirRecibo(): String {
        return "----------------------\n Recibo de pago SANAA\n----------------------\n"+super.imprimirRecibo()+
                "\nSu consumo en Lts es = $consumo" + "\nEl total a pagar es ${cobro()}"
    }

}
//-----
class Cuenta {
    var saldo = 100
    var numeroCuenta = 0
    var monto = 0

    constructor()
    constructor(Saldo: Int, NumeroCuenta: Int, Monto: Int){
        saldo = Saldo
        numeroCuenta = NumeroCuenta
        monto = Monto
    }
}
//-----

class Cliente {
    var numero = 0
    var monto = 0

    constructor()
    constructor(Numero: Int, Monto: Int) {
        numero = Numero
        monto = Monto
    }
}