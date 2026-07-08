Feature: Iniciar sesion
  @PruebaLogin
  Scenario Outline: Iniciar sesion con credenciales validas
    Given el usuario se encuentra en la pagina de inicio
    When ingresa su nombre de usuario "<username>" y contrasenia "<password>"
    Then visualiza un mensaje de bienvenida para el usuario "<username>" en el menu
    Examples:
      |username     |password    |
      |mariDev      |mlSC1606    |