# 🎮 Reto Final If – Mini sistema de logros (multijuego)

## 🎯 Objetivo
Implementar un sistema que, a partir de estadísticas de una partida, **calcule y muestre los logros desbloqueados** por el jugador.

---

## ✅ 1) Variables de entrada
Asigna valores fijos para probar:

- `String juego`: `"Fortnite"`, `"LoL"`, `"Minecraft"`, `"Pokemon"`
- `int kills`
- `int muertes`
- `int asistencias`
- `int tiempoMin` → minutos jugados
- `int objetivos` → (torres destruidas, bosses, capturas, construcciones…)
- `boolean desconexion` → `true` si el jugador se desconectó
- `int dañoHecho`
- `int dañoRecibido`
- `int oro` → moneda conseguida

---

## ✅ 2) Normas generales
- 🔴 Si `desconexion == true` y `tiempoMin < 5` → **"Logro NEGATIVO: Rage Quit 😠"**  
  *(IMPORTANTE: si ocurre esto, NO conceder logros de PRO en la misma partida)*

- Calcula **KDA**:
  ```java
  KDA = (kills + asistencias) / Math.max(1, muertes);
  ```

- Clasificación por KDA *(elige SOLO UNA)*:
  - `KDA ≥ 5` → "Jugador PRO"
  - `3 ≤ KDA < 5` → "Jugador BUENO"
  - `1 ≤ KDA < 3` → "Jugador NORMAL"
  - `KDA < 1` → "Jugador NOOB"

- Logros básicos *(independientes, se acumulan)*:
  - `kills >= 10` → "Cazador experto 🏹"
  - `muertes == 0 && kills >= 5` → "Intocable 👑"
  - `tiempoMin > 60` → "Maratón gamer ⏱️"
  - `dañoHecho > dañoRecibido * 2` → "Dominio total 💥"
  - `objetivos >= 3` → "Objetivos de mapa 🎯"

---

## ✅ 3) Reglas específicas por juego

### 🟢 Fortnite
- `kills >= 15 && muertes <= 2` → "Victoria agresiva (Fortnite) 🔫"
- `oro >= 2000` → "Ahorrista de V-Bucks (Fortnite) 💰"

### 🔵 LoL
- `objetivos >= 2 && asistencias >= 10` → "Shotcaller (LoL) 🗣️"
- `dañoHecho >= 30000 && muertes <= 3` → "Carry principal (LoL) 🛡️"

### 🟡 Minecraft
- `tiempoMin >= 45 && dañoRecibido == 0` → "Superviviente pacífico (MC) 🌿"
- `objetivos >= 5` → "Constructor incansable (MC) 🧱"

### 🔴 Pokémon
- `kills >= 6 && dañoRecibido <= 1000` → "Entrenador maestro (PKMN) 🧢"
- `asistencias >= 3` → "Apoyo del equipo (PKMN) 🤝"

---

## ✅ 4) Prioridades y exclusiones
- Si se activa **Rage Quit 😠** → NO mostrar "Jugador PRO".
- Si `muertes == 0 && kills == 0 && asistencias == 0 && tiempoMin < 2` →  
  **"Partida inválida: AFK"** (NO mostrar más logros).

---

## ✅ 5) Salida esperada
- 📊 Resumen de entrada (todas las estadísticas)  
- 📐 KDA calculado  
- 🏷️ Rango por KDA (solo uno)  
- 🏆 Lista de logros desbloqueados (varios posibles)  
- ⚠️ Mensajes de exclusión si corresponde (p. ej., Rage Quit / AFK)  

---

## ✅ 6) Pruebas rápidas
Prueba cambiando las variables en tu código:

- **Caso A:** LoL → `kills=12, muertes=2, asist=15, tiempo=38, obj=3, desc=false, dañoH=32000, dañoR=9000, oro=1500`
- **Caso B:** Fortnite → `kills=16, muertes=2, asist=3, tiempo=25, obj=1, desc=false, dañoH=18000, dañoR=6000, oro=2300`
- **Caso C:** Minecraft → `kills=0, muertes=0, asist=0, tiempo=1, obj=0, desc=false, dañoH=0, dañoR=0, oro=0`
- **Caso D:** Pokémon → `kills=7, muertes=0, asist=4, tiempo=50, obj=2, desc=false, dañoH=5000, dañoR=800, oro=800`
- **Caso E:** (cualquier juego) → `desconexion=true, tiempoMin=3`

---

## ✅ 7) Extensiones opcionales
- Añade un **score total**:  
  `+10` por logro normal, `+20` por logros PRO.
- Si `score ≥ 40` y no hubo Rage Quit → "MVP de la jornada 🏆".
- Si `dañoRecibido == 0 && tiempoMin ≥ 30` → "Perfect Defense 🧱".
- Si `(juego == "LoL" || juego == "Fortnite") && (kills + asistencias) ≥ 25` → "Impacto masivo 🌪️".
- Prioriza validaciones: AFK y Rage Quit antes que el resto.
- Practica **if anidados** para flujo de decisión.

---

## 💡 Pistas técnicas
- Usa `double` para el KDA (decimales).  
- Usa `Math.max(1, muertes)` para evitar dividir por cero.  
- Estructura el código en bloques:  
  1. Validaciones iniciales  
  2. KDA  
  3. Logros básicos  
  4. Logros por juego  
  5. Extras  

---

## 🖥️ Implementación
- Escribe debajo tu solución usando muchos `if/else if/else`.  
- No uses arrays ni bucles *(opcional)*, céntrate en condiciones.  
- Ejecuta varias veces cambiando los valores de entrada.  
