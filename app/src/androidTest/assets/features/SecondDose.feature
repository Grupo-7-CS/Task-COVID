Feature: Segunda Dosis
  As

  un usuario

  I want

  poder pulsar el botón de la segunda dosis de la vacuna y que mis puntos de experiencia aumenten en 150.

  Scenario: Subir de nivel si se ha alcanzado la experiencia necesaria al ponerse la segunda dosis
    Given el usuario es nivel 1
    And tiene 0 puntos de experiencia
    When pulsa el boton de ponerse la segunda dosis
    Then el usuario sube a nivel 2
    And se queda con 50 puntos de experiencia.

  Scenario: No subir de nivel al ponerse la segunda dosis ya que no se ha alcanzado la experiencia necesaria
    Given el usuario es nivel 4
    And tiene 0 puntos de experiencia
    When pulsa el boton de ponerse la segunda dosis
    Then el usuario permanece a nivel 4
    And tiene 150 puntos de experiencia