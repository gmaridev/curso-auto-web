Feature: Agregar producto al carrito
  @PruebaAgregarProducto
  Scenario: Seleccionar y verificar un producto en el carrito de compras
    Given el usuario se encuentra en la pagina de inicio
    When selecciona un producto de la tienda
    Then visualiza la informacion del producto
    And agrega el producto a su carrito de compras
    Then se muestra el producto en la lista del carrito