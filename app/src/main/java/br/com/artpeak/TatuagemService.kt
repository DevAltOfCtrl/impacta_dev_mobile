package br.com.artpeak

import android.content.Context

object TatuagemService  {

    fun getTatuagem(context: Context): List<Tatuagem>{

        val tatuagens = mutableListOf<Tatuagem>()

        for(i in 1..8){
            var tattoo = Tatuagem()
            var id = "$i"
            when (id) {
                "1" -> {
                    tattoo.estilo = "Estilo Aquarela"
                    tattoo.imagem = "https://i0.wp.com/www.depoisdosquinze.com/app/uploads/2016/05/tatuagem-aquarela.jpg?ssl=1"
                }
                "2" -> {
                    tattoo.estilo = "Estilo Geométrico"
                    tattoo.imagem = "https://i.ytimg.com/vi/lh7JwPUMEa8/maxresdefault.jpg"
                }
                "3" -> {
                    tattoo.estilo = "Estilo Tribal"
                    tattoo.imagem = "https://t1.uc.ltmcdn.com/pt/images/6/5/0/14_tatuagens_tribais_e_seus_significados_29056_paso_2_600.jpg"
                }
                "4" -> {
                    tattoo.estilo = "Estilo Minimalista"
                    tattoo.imagem = "https://i.pinimg.com/originals/10/27/94/1027941c69cc3d2f0c94a1d92ed5cc15.png"
                }
                "5" -> {
                    tattoo.estilo = "Estilo Realista"
                    tattoo.imagem = "https://u5r8j6b9.rocketcdn.me/wp-content/uploads/2021/01/tatuagens-realistas-desenhos-impressionantes-para-te-inspirar-960x658.jpg"
                }
                "6" -> {
                    tattoo.estilo = "Estilo Pontilhismo"
                    tattoo.imagem = "https://amotatuagem.com/wp-content/uploads/2018/09/Tatuagem-pontilhismo.jpg"
                }
                "7" -> {
                    tattoo.estilo = "Estilo OldSchool"
                    tattoo.imagem = "https://a4a6q3i4.rocketcdn.me/wp-content/uploads/2020/09/tatuagem-old-school-para-mulheres-origem-e-modelos-para-escolher-1.jpg"
                }
                "8" -> {
                    tattoo.estilo = "Estilo NewSchool"
                    tattoo.imagem = "https://www.guiadasemana.com.br/contentFiles/system/pictures/2014/5/282961/original/capa.jpg"
                }
            }
            tatuagens.add(tattoo)
        }
        return tatuagens
    }
}