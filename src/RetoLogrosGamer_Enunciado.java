import java.util.Scanner;
import static java.lang.Math.max;

public class RetoLogrosGamer_Enunciado {


    public static void main(String[] args) {


        // ============================================================

        // RETO FINAL – Mini sistema de logros (multijuego)

        // ============================================================

        // OBJETIVO:

        // Implementa un sistema que, a partir de estadísticas de una partida,

        // calcule y muestre los LOGROS desbloqueados por el jugador.

        //

        // ------------------------------------------------------------

        // ✔️ 1) DECLARA ESTAS VARIABLES DE ENTRADA (asigna valores fijos para probar):

        //    - String juego: "Fortnite", "LoL", "Minecraft", "Pokemon"

        //    - int kills

        //    - int muertes

        //    - int asistencias

        //    - int tiempoMin: minutos jugados

        //    - int objetivos: (torres destruidas, bosses, capturas, construcciones…)

        //    - boolean desconexion: true si el jugador se desconectó en mitad

        //    - int dañoHecho

        //    - int dañoRecibido

        //    - int oro: moneda conseguida

        //

        // ------------------------------------------------------------

        //✔️  2) NORMAS GENERALES (usa if / else if / else y condiciones compuestas):

        //   ✔️ - Si desconexion es true y tiempoMin < 5 → imprimir:

        //         "Logro NEGATIVO: Rage Quit 😠"

        //      IMPORTANTE: si ocurre esto, NO concedas otros logros de "PRO"

        //      en la misma partida (prioridad negativa).

        //

        //   ✔️ - Calcula KDA = (kills + asistencias) / max(1, muertes)

        //      (evita división por 0 usando Math.max).

        //

        //   ✔️ - Clasificación por KDA (elige SOLO UNA, la primera que cumpla):

        //        KDA ≥ 5          → "Jugador PRO"

        //        3 ≤ KDA < 5      → "Jugador BUENO"

        //        1 ≤ KDA < 3      → "Jugador NORMAL"

        //        KDA < 1          → "Jugador NOOB"

        //

        //  ✔️  - Logros básicos independientes (pueden acumularse):

        //        kills >= 10                    → "Logro: Cazador experto 🏹"

        //        muertes == 0 && kills >= 5     → "Logro: Intocable 👑"

        //        tiempoMin > 60                 → "Logro: Maratón gamer ⏱️"

        //        dañoHecho > dañoRecibido*2     → "Logro: Dominio total 💥"

        //        objetivos >= 3                 → "Logro: Objetivos de mapa 🎯"

        //

        // ------------------------------------------------------------

        // ✔️ 3) REGLAS ESPECÍFICAS POR JUEGO (selecciona por valor de 'juego'):

        //    - Fortnite:

        //        si kills >= 15 && muertes <= 2 → "Victoria agresiva (Fortnite) 🔫"

        //        si oro >= 2000                 → "Ahorrista de V-Bucks (Fortnite) 💰"

        //

        //    - LoL:

        //        si objetivos >= 2 && asistencias >= 10 → "Shotcaller (LoL) 🗣️"

        //        si dañoHecho >= 30000 && muertes <= 3  → "Carry principal (LoL) 🛡️"

        //

        //    - Minecraft:

        //        si tiempoMin >= 45 && dañoRecibido == 0 → "Superviviente pacífico (MC) 🌿"

        //        si objetivos >= 5                        → "Constructor incansable (MC) 🧱"

        //

        //    - Pokemon:

        //        si kills >= 6 && dañoRecibido <= 1000 → "Entrenador maestro (PKMN) 🧢"

        //        si asistencias >= 3                   → "Apoyo del equipo (PKMN) 🤝"

        //

        // ------------------------------------------------------------

        // 4) PRIORIDADES Y EXCLUSIONES (orden y anidación de if):

        //    - Si se activa "Rage Quit 😠", NO mostrar "Jugador PRO".

        //    - Si muertes == 0 && kills == 0 && asistencias == 0 && tiempoMin < 2:

        //        imprimir "Partida inválida: AFK" y NO mostrar más logros.

        //

        // ------------------------------------------------------------

        // 5) SALIDA (impresiones sugeridas):

        //    - Resumen de entrada (todas las estadísticas)

        //    - KDA calculado

        //    - Rango por KDA (solo uno)

        //    - Lista de logros desbloqueados (varios posibles)

        //    - Mensajes de exclusión si corresponde (p. ej., Rage Quit / AFK)

        //

        // ------------------------------------------------------------

        // 6) PRUEBAS RÁPIDAS (cambia las variables y ejecuta varias veces):

        //    CASO A: LoL, kills=12, muertes=2, asist=15, tiempo=38, obj=3, desc=false, dañoH=32000, dañoR=9000, oro=1500

        //    CASO B: Fortnite, kills=16, muertes=2, asist=3, tiempo=25, obj=1, desc=false, dañoH=18000, dañoR=6000, oro=2300

        //    CASO C: Minecraft, kills=0, muertes=0, asist=0, tiempo=1, obj=0, desc=false, dañoH=0, dañoR=0, oro=0

        //    CASO D: Pokemon, kills=7, muertes=0, asist=4, tiempo=50, obj=2, desc=false, dañoH=5000, dañoR=800, oro=800

        //    CASO E: (cualquier juego), desconexion=true, tiempoMin=3

        //

        // ------------------------------------------------------------

        // 7) EXTENSIONES OPCIONALES (sube dificultad):

        //    - Suma un "score" total: +10 por logro normal, +20 por logros PRO.

        //    - Si score ≥ 40 y no hubo Rage Quit → "MVP de la jornada 🏆".

        //    - Si dañoRecibido == 0 y tiempoMin ≥ 30 → "Perfect Defense 🧱".

        //    - Si (juego == "LoL" || juego == "Fortnite") && (kills + asistencias) ≥ 25 → "Impacto masivo 🌪️".

        //    - Prioriza validaciones: AFK y Rage Quit antes que el resto.

        //    - Usa if anidados para practicar flujo de decisión.

        //

        // ------------------------------------------------------------

        // PISTAS TÉCNICAS:

        //    - Usa double para KDA (decimales).

        //    - Usa Math.max(1, muertes) para evitar dividir por cero.

        //    - Estructura tu código por bloques: validaciones iniciales → KDA → logros básicos → logros por juego → extras.

        //

        // ------------------------------------------------------------

        // IMPLEMENTACIÓN:

        //  - Escribe debajo tu solución con muchos if/else if/else.

        //  - No uses arrays ni bucles (opcional), céntrate en condiciones.

        //  - Ejecuta varias veces cambiando los valores de entrada.


        // ======= TU CÓDIGO AQUÍ =======

        //DESCOMENTAR CADA CASO PARA PROBAR

        String gameTitle = "CualquierJuego";
        int kills = 0;
        int deaths = 0;
        int assists = 0;
        int minutes = 0;
        int targets = 0;
        boolean disconnected = false;
        int outgoingDamage = 0;
        int incomingDamage = 0;
        int gold = 0;
        boolean RageQuit = false;


        /*

        // CASO A

        String gameTitle = "LoL";
        int kills = 12;
        int deaths = 2;
        int assists = 15;
        int minutes = 38;
        int targets = 3;
        boolean disconnected = false;
        int outgoingDamage = 32000;
        int incomingDamage = 9000;
        int gold = 1500;
        boolean RageQuit = false;

        */

        /*

        // CASO B

        String gameTitle = "Fortnite";
        int kills = 16;
        int deaths = 2;
        int assists = 3;
        int minutes = 25;
        int targets = 1;
        boolean disconnected = false;
        int outgoingDamage = 18000;
        int incomingDamage = 6000;
        int gold = 2300;
        boolean RageQuit = false;

        */

        /*

        // CASO C

        String gameTitle = "Minecraft";
        int kills = 0;
        int deaths = 0;
        int assists = 0;
        int minutes = 1;
        int targets = 0;
        boolean disconnected = false;
        int outgoingDamage = 0;
        int incomingDamage = 0;
        int gold = 0;
        boolean RageQuit = false;

        */


        /*

        // CASO D

        String gameTitle = "Pokemon";
        int kills = 7;
        int deaths = 0;
        int assists = 4;
        int minutes = 50;
        int targets = 2;
        boolean disconnected = false;
        int outgoingDamage = 5000;
        int incomingDamage = 800;
        int gold = 800;
        boolean RageQuit = false;

        */

        /*

        // CASO E

        String gameTitle = "Fortnite";
        int kills = 0;
        int deaths = 0;
        int assists = 0;
        int minutes = 3;
        int targets = 0;
        boolean disconnected = true;
        int outgoingDamage = 0;
        int incomingDamage = 0;
        int gold = 0;
        boolean RageQuit = true; // opcional: si desconexión implica rage quit

        */

        /*
        System.out.println("Introduzca el titulo de su juego (Fortnite, LoL, Minecraft o Pokemon) o pulse X para salir: ");
        gameTitle = sc.nextLine();
        */

        if (disconnected && minutes < 5) {
            RageQuit = true;
        }

        if (deaths == 0 && kills == 0 && assists == 0 && minutes < 2) {
            if (RageQuit) {
                disconnected = false;
            } else {
                disconnected = true;
            }
        }


        double KDA = (kills + assists) / max(1, deaths);


        String rank = "rank";
        if (KDA >= 5) {
            rank = "Jugador PRO";
        } else if (KDA >= 3 && KDA < 5) {
            rank = "Jugador BUENO";
        } else if (KDA >= 1 && KDA < 3) {
            rank = "Jugador NORMAL";
        } else if (KDA < 1) {
            rank = "Jugador NOOB";
        }



        // LOGROS GENERALES

        boolean cazadorExperto = false;
        boolean intocable = false;
        boolean maratonGamer = false;
        boolean dominioTotal = false;
        boolean objetivosMapa = false;


        if (kills >= 10) {
            cazadorExperto = true;
        }
        if (deaths == 0 && kills >= 5){
            intocable = true;
        }
        if (minutes > 60){
            maratonGamer = true;
        }
        if (outgoingDamage > incomingDamage * 2){
            dominioTotal = true;
        }
        if (targets >= 3){
            objetivosMapa = true;
        }



        // LOGROS DE CADA JUEGO

        boolean fortniteAchievement1 = false;
        boolean fortniteAchievement2 = false;
        boolean LoLAchievement1 = false;
        boolean LoLAchievement2 = false;
        boolean MinecraftAchievement1 = false;
        boolean MinecraftAchievement2 = false;
        boolean PokemonAchievement1 = false;
        boolean PokemonAchievement2 = false;

        switch (gameTitle) {
            case "Fortnite":

                if (kills >= 15 && deaths <= 2) {
                    fortniteAchievement1 = true;
                }
                if (gold >= 2000) {
                    fortniteAchievement2 = true;
                }
                break;

            case "LoL":

                if (targets >= 2 && assists >= 10) {
                    LoLAchievement1 = true;
                }
                if (outgoingDamage >= 30000 && deaths <= 3) {
                    LoLAchievement2 = true;
                }
                break;

            case "Minecraft":

                if (minutes >= 45 && incomingDamage == 0) {
                    MinecraftAchievement1 = true;
                }
                if (targets >= 5) {
                    MinecraftAchievement2 = true;
                }
                break;

            case "Pokemon":

                if (kills >= 6 && incomingDamage <= 1000) {
                    PokemonAchievement1 = true;
                }
                if (assists >= 3) {
                    PokemonAchievement2 = true;
                }
                break;

        }



        // Logros comunes

        int score = 0;

        if (cazadorExperto) score += 10;
        if (intocable) score += 10;
        if (maratonGamer) score += 10;
        if (dominioTotal) score += 10;
        if (objetivosMapa) score += 10;

        // Logros por juego
        if (fortniteAchievement1 || fortniteAchievement2 || LoLAchievement1 || LoLAchievement2 || MinecraftAchievement1 || MinecraftAchievement2 || PokemonAchievement1 || PokemonAchievement2) {
            score += 20;
        }

        // Logro PRO
        if (KDA >= 5) score += 20;

        // Evaluar extensiones opcionales
        boolean mvp = false;
        boolean defense = false;
        boolean impact = false;
        if (!RageQuit && score >= 40) {
            mvp = true;
        }
        if (incomingDamage == 0 && minutes >= 30) {
            defense = true;
        }
        if ((gameTitle.equals("LoL") || gameTitle.equals("Fortnite")) && (kills + assists) >= 25) {
            impact = true;

        }




        // =============== SALIDA DEL PROGRAMA ================

        System.out.println(" ");

        System.out.println("===== RESUMEN DE PARTIDA =====");
        System.out.println("Juego: " + gameTitle);
        System.out.println("Kills: " + kills);
        System.out.println("Muertes: " + deaths);
        System.out.println("Asistencias: " + assists);
        System.out.println("Minutos jugados: " + minutes);
        System.out.println("Objetivos: " + targets);
        System.out.println("Desconexion: " + disconnected);
        System.out.println("Daño hecho: " + outgoingDamage);
        System.out.println("Daño recibido: " + incomingDamage);
        System.out.println("Oro: " + gold);

        System.out.println("KDA: " + KDA);
        if (RageQuit) {
            System.out.println("⚠️ NO HAS CLASIFICADO DEBIDO A QUE HAS HECHO RAGEQUIT ⚠️");
        } else if (disconnected) {
            System.out.println("⚠️ NO HAS CLASIFICADO DEBIDO A QUE TE HAS IDO AFK ⚠️");
        } else {
            System.out.println("Clasificación: " + rank);
        }

        System.out.println("Score: " + score);

        if (mvp){
            System.out.println("MVP de la jornada 🏆");
        }

        if (defense){
            System.out.println("Perfect Defense 🧱");
        }

        if (impact){
            System.out.println("Impacto masivo 🌪️");
        }

        System.out.println(" ");

        if (!RageQuit && !disconnected) {
            System.out.println("===== LOGROS COMUNES DESBLOQUEADOS =====");
            boolean algunLogro = false;

            if (cazadorExperto) {
                System.out.println("Logro: Cazador experto 🏹");
                algunLogro = true;
            }
            if (intocable) {
                System.out.println("Logro: Intocable 👑");
                algunLogro = true;
            }
            if (maratonGamer) {
                System.out.println("Logro: Maratón gamer ⏱️");
                algunLogro = true;
            }
            if (dominioTotal) {
                System.out.println("Logro: Dominio total 💥");
                algunLogro = true;
            }
            if (objetivosMapa) {
                System.out.println("Logro: Objetivos de mapa 🎯");
                algunLogro = true;
            }

            if (!algunLogro) {
                System.out.println("No has desbloqueado logros comunes");
            }

            System.out.println("========================================");
            System.out.println(" ");
        }


        if (RageQuit) {
            System.out.println("Logro NEGATIVO: Rage Quit 😠");
            System.out.println(" ");
        }


        if (disconnected && !RageQuit) {
            System.out.println("Partida inválida: AFK");
            System.out.println(" ");
        }

        if (!RageQuit && !disconnected) {

            System.out.println("===== LOGROS ESPECIFICOS DESBLOQUEADOS =====");
            if (gameTitle.equals("Fortnite")) {
                if (fortniteAchievement1) {
                    System.out.println("Victoria agresiva (Fortnite) 🔫");
                }
                if (fortniteAchievement2) {
                    System.out.println("Ahorrista de V-Bucks (Fortnite) 💰");
                }
                System.out.println("============================================");
            }
            if (gameTitle.equals("LoL")) {
                if (LoLAchievement1) {
                    System.out.println("Shotcaller (LoL) 🗣️");
                }
                if (LoLAchievement2) {
                    System.out.println("Carry principal (LoL) 🛡️");
                }
                System.out.println("============================================");
            }
            if (gameTitle.equals("Minecraft")) {
                if (MinecraftAchievement1) {
                    System.out.println("Superviviente pacífico (MC) 🌿");
                }
                if (MinecraftAchievement2) {
                    System.out.println("Constructor incansable (MC) 🧱");
                }
                System.out.println("============================================");
            }
            if (gameTitle.equals("Pokemon")) {
                if (PokemonAchievement1) {
                    System.out.println("Entrenador maestro (PKMN) 🧢");
                }
                if (PokemonAchievement2) {
                    System.out.println("Apoyo del equipo (PKMN) 🤝");
                }
                System.out.println("============================================");
            }
        }



        System.out.println(" ");

        System.out.println("Saliendo...");
        //sc.close();


    }

}

