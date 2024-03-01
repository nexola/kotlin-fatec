import java.util.Scanner

fun main() {
    val scan = Scanner(System.`in`)

    val lista : MutableList<Item> = gerarLista()
    val itens = HashMap<String, Int>()

    var total: Double = 0.0
    do {
        clear()
        for (item in lista) println("${item.nome} - ${item.codigo} ---- ${item.preco.format(2)}")
        println(
            """
                
            1 - Adicionar item
            2 - Mostrar itens
            3 - Sair
            
            Total -> ${total.format(2)}
        """.trimIndent()
        )
        var res = scan.nextLine().trim().toInt()

        when (res) {

            1 -> {
                print("Código do produto: ")
                var cod: Int = scan.nextLine().trim().toInt()
                print("Quantidade: ")
                var quant: Int = scan.nextLine().trim().toInt()
                for (item in lista) {
                    if (item.codigo == cod) {
                        total += item.preco * quant
                        if (itens.containsKey(item.nome)) itens[item.nome] = itens[item.nome]!! + quant
                        if (itens[item.nome] == null) itens[item.nome] = quant
                    }
                }

            }

            2 -> {
                itens.forEach { entry -> println("${entry.key} x${entry.value}") }
                println(total.format(2))
                print("Pressione enter para continuar")
                scan.nextLine()
            }

        }
    } while (res != 3)


}

fun gerarLista() : MutableList<Item> {
    val lista : MutableList<Item> = mutableListOf()
    lista.add(Item("Cachorro quente", 100, 1.2))
    lista.add(Item("Bauru Simples", 101, 1.3))
    lista.add(Item("Bauru com ovo", 102, 1.5))
    lista.add(Item("Hamburger", 103, 1.2))
    lista.add(Item("Cheeseburger", 104, 1.3))
    lista.add(Item("Refrigerante", 105, 1.0))
    return lista
}

fun clear() {
    for (i in 1..100) println()
}

fun Double.format(digits: Int) = "R$ %.${digits}f".format(this)