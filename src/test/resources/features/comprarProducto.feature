Feature: Agregar producto al carrito
  @PruebaComprarProducto
  Scenario Outline:
    Given el usuario se encuentra en la pagina de inicio
    When ingresa su nombre de usuario "<username>" y contrasenia "<password>"
    Then visualiza un mensaje de bienvenida para el usuario "<username>" en el menu
    When selecciona un producto de la tienda
    Then visualiza la informacion del producto
    And agrega el producto a su carrito de compras
    Then se muestra el producto en la lista del carrito
    Examples:
      |username  |password    |
      |mariDev     | mlSC1606   |

