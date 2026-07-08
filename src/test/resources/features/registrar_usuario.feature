Feature: Registrar usuario
  @HappyPath
  Scenario Outline: Registrar un usuario
    Given el usuario está en la página de inicio
    When  se registra con un nombre de usuario "<username>" y contrasenia "<password>"
    Then se realiza el registro de manera exitosa
    Examples:
    |username     |password    |
    |mariDev |mlSC1606        |