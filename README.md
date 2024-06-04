## Objetivos del Proyecto
En este proyecto los objetivos son los siguientes:
1. Crear un menú en el cual se pueda seleccionar si cargar una partida, generar una de nueva o salir del programa.
2. Generar un menú en el cual el usuario pueda seleccionar contra qué especie de monstruo quiere combatir.
3. Cada monstruo tiene unas características **únicas de su especie**.
4. Un menú donde el jugador dé nombre a su personaje y pueda seleccionar un arma de las 4 que están creadas.
5. Un menú de combate donde el jugador pueda: _Atacar, esquivar o curarse (usando un objeto que es limitado)_.
6. El monstruo actuará haciendo una de estas 3 acciones: _Atacar, enfadarse (Rage) o esperar. En caso de atacar, seleccionará a un jugador aleatorio (en caso de ser más de 1)_.
7. Al ganar al monstruo existe la posibilidad de encontrar una poción **(5%)** o de encontrar 2 pociones **(3%)**.
8. Al finalizar el combate el usuario podrá guardar **la partida (.txt), seguir jugando o salir sin guardar**.


## Plan de Implementación

1. **Crear un menú principal**  
   Este menú permitirá al usuario:
   - Cargar una partida
   - Generar una nueva partida
   - Salir del programa

2. **Crear un menú de selección de monstruo**  
   El usuario podrá seleccionar contra qué especie de monstruo quiere combatir. Cada monstruo tendrá características únicas.

3. **Definir las características únicas de cada monstruo**  
   Cada especie de monstruo tendrá sus propios atributos (fuerza, resistencia, etc.) y habilidades especiales.

4. **Crear un menú para la creación de personajes**  
   El usuario podrá:
   - Dar un nombre a su personaje
   - Seleccionar un arma de entre cuatro opciones disponibles

5. **Crear un menú de combate**  
   El jugador podrá elegir entre las siguientes acciones:
   - Atacar
   - Esquivar
   - Curarse (usando un objeto limitado)

6. **Definir las acciones del monstruo en combate**  
   El monstruo podrá:
   - Atacar
   - Enfadarse (Rage)
   - Esperar

7. **Implementar el sistema de recompensas**  
   Al ganar, existe la posibilidad de encontrar pociones:
   - 5% de encontrar una poción
   - 3% de encontrar dos pociones

8. **Crear el sistema de guardado de partidas**  
   El usuario podrá:
   - Guardar la partida en un archivo .txt
   - Seguir jugando
   - Salir sin guardar
