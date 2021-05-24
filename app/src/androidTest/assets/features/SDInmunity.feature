Feature: Inmunidad
  As

  un usuario

  I want

  ganar inmunidad después de recibir la segunda dosis

  So that

  pueda tener inmunidad a tres acciones erróneas

  Scenario:Inmunidad activa
    Given el usuario se ha puesto la segunda dosis de la vacuna (gana 3 puntos de inmunidad)
    And tiene 100 puntos de vida
    When pulsa el boton de 'olvidarse la mascarilla'
    Then el usuario sigue teniendo 100 puntos de vida
    And le quedan 2 puntos de inmunidad.

  Scenario: Inmunidad consumida
    Given el usuario se ha puesto la segunda dosis de la vacuna (gana 3 puntos de inmunidad)
    And tiene 80 puntos de vida
    And tiene 1 punto de resistencia
    When pulsa 4 veces el boton de 'Salir de fiesta'
    Then la vida del usuario se reduce a 55 puntos
    And tiene 0 puntos de inmunidad.

