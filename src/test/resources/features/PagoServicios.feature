#Author: JVR
@PagoServicios
Feature: Pago servicios publicos y privados
  Escenarios que permiten realizar el pago de los servicios públicos

  @CP0056M
  Scenario Outline: Hacer_pagos_CP0056M_SYS_Validar secciones en Hacer Pagos
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    When Ingreso al modulo Hacer pagos
    And Valido secciones del modulo Hacer pagos
    And Valido solicitud permisos para escanear códigos    
    
    Examples: 
      | tipoId | usuario     | contrasena |
      | "CC"   | "215333181" | "4568"     |

  @CP0057M
  Scenario Outline: Hacer_pagos_CP0057M_SYS_Validar solicitud de permisos para acceder a la cámara del dispositivo
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    When Ingreso al modulo Hacer pagos
    And Valido secciones del modulo Hacer pagos
    And Valido solicitud permisos para escanear códigos    
    
    Examples: 
      | tipoId | usuario     | contrasena |
      | "CC"   | "215333181" | "4568"     |

  @CP0058M
  Scenario Outline: Hacer_pagos_CP0058M_SYS_Validar el pago de servicios privados (DNR y BDI) con un usuario en estado NORMAL
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    When ingreso al modulo 'Hacer pagos' <servicio> <referencia>
    And ingreso valor a pagar <valor> <contrasena>
    And Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | servicio             | referencia | valor  | subtipo | numCelularUsuario |
      | "CC"   | "999837" | "1112"     | "DNR UNO A UNO JHON" | "1234"     | "1000" | "MET"   | "3142045585"      |

  @CP0059M
  Scenario Outline: Hacer_pagos_CP0059M_SYS_Validar el pago de servicios publicos (ETB, Gas Natural, etc) con un usuario en estado NORMAL
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    When ingreso al modulo 'Hacer pagos' <servicio> <referencia>
    And ingreso valor a pagar <valor> <contrasena>
    And Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | servicio             | referencia | valor  | subtipo | numCelularUsuario |
      | "CC"   | "999837" | "1112"     | "DNR UNO A UNO JHON" | "1234"     | "1000" | "MET"   | "3142045585"      |

  @CP0060M
  Scenario Outline: Hacer_pagos_CP0060M_SYS_Validar el pago de servicios privados (DNR y BDI) con un usuario GMF
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    When ingreso al modulo 'Hacer pagos' <servicio> <referencia>
    And ingreso valor a pagar <valor> <contrasena>
    And Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario   | contrasena | servicio             | referencia | valor  | subtipo | numCelularUsuario |
      | "CC"   | "1031041" | "2587"     | "DNR UNO A UNO JHON" | "1234"     | "1000" | "GMF"   | "3178909090"      |

  @CP0061M
  Scenario Outline: Hacer_pagos_CP0061M_SYS_Validar el pago de servicios publicos (ETB, Gas Natural, etc) GMF
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    When ingreso al modulo 'Hacer pagos' <servicio> <referencia>
    And ingreso valor a pagar <valor> <contrasena>
    And Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario   | contrasena | servicio             | referencia | valor  | subtipo | numCelularUsuario |
      | "CC"   | "1031041" | "2587"     | "DNR UNO A UNO JHON" | "1234"     | "1000" | "GMF"   | "3178909090"      |

  @CP0062M
  Scenario Outline: Hacer_pagos_CP0062M_SYS_Validar el pago de servicios publicos (ETB, Gas Natural, etc) con usuario Migrado
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    When ingreso al modulo 'Hacer pagos' <servicio> <referencia>
    And ingreso valor a pagar <valor> <contrasena>
    And Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario     | contrasena | servicio             | referencia | valor  | subtipo | numCelularUsuario |
      | "CC"   | "215333181" | "4568"     | "DNR UNO A UNO JHON" | "1234"     | "1000" | "MET"   | "3142045554"      |
     
  @CP0063M
  Scenario Outline: Hacer_pagos_CP0063M_SYS_Validar el rechazo de un pago de servicios privados (DNR y BDI) cuando la referenica no existe
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido el saldo inicial civica sin redeban
    When ingreso referencia no existente <servicio> <referencia>

    Examples: 
      | tipoId | usuario  | contrasena | servicio             | referencia | valor  | 
      | "CC"   | "999837" | "1112"     | "DNR UNO A UNO JHON" | "1234"     | "1000" |
   
  @CP0064M
  Scenario Outline: Hacer_pagos_CP0064M_SYS_Validar el rechazo de pago de servicios publicos (ETB, Gas Natural, etc) cuando la referencia ya fue cancelada
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido el saldo inicial civica sin redeban
    When ingreso referencia no existente <servicio> <referencia>
    And ingreso flujo valor a pagar con ref invalida <valor> <contrasena>

    Examples: 
      | tipoId | usuario  | contrasena | servicio             | referencia | valor  | 
      | "CC"   | "999837" | "1112"     | "DNR UNO A UNO JHON" | "00000000" | "1000" |
          
  @CP0065M
  Scenario Outline: Hacer_pagos_CP0065M_SYS_Validar que se pueda realizar una transacción por $1.000 de manera exitosa (DNR y BDI)
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    When ingreso al modulo 'Hacer pagos' <servicio> <referencia>
    And ingreso valor a pagar <valor> <contrasena>
    And Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | servicio             | referencia | valor  | subtipo | numCelularUsuario |
      | "CC"   | "999837" | "1112"     | "DNR UNO A UNO JHON" | "1234"     | "1000" | "MET"   | "3142045585"      |
   
  @CP0066M
  Scenario Outline: Hacer_pagos_CP0066M_SYS_Validar que al realizar un pago y digitar erradamente la clave en la App, se rechace la transacción (3 intentos errados)
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    When ingreso al modulo 'Hacer pagos' <servicio> <referencia>
    And ingreso clave erronea <valor> <contrasena>

    Examples: 
      | tipoId | usuario  | contrasena | servicio             | referencia | valor  | 
      | "CC"   | "999837" | "1112"     | "DNR UNO A UNO JHON" | "1234"     | "1000" |
   
  @CP0067M
  Scenario Outline: Hacer_pagos_CP0067M_SYS_Validar que al intentar hacer un pago y no cuenta con el saldo completo suficiente en el monedero, se rechace la transacción
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    When ingreso al modulo 'Hacer pagos' <servicio> <referencia>
    And ingreso valor a pagar <valor> <contrasena>
    And Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | servicio             | referencia | valor  | subtipo | numCelularUsuario |
      | "CC"   | "999837" | "1112"     | "DNR UNO A UNO JHON" | "1234"     | "1000" | "MET"   | "3142045585"      |
   
  @CP0068M
  Scenario Outline: Hacer_pagos_CP0068M_SYS_Validar que se afecten los saldos y movimientos en la web de Redeban
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    When ingreso al modulo 'Hacer pagos' <servicio> <referencia>
    And ingreso valor a pagar <valor> <contrasena>
    And Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | servicio             | referencia | valor  | numCelularUsuario |
      | "CC"   | "999837" | "1112"     | "DNR UNO A UNO JHON" | "1234"     | "1000" | "3142045585"      |
   
  @CP0069M
  Scenario Outline: Hacer_pagos_CP0069M_SYS_Validar que se afecten los saldos y movimientos en la APP Cívica
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    When ingreso al modulo 'Hacer pagos' <servicio> <referencia>
    And ingreso valor a pagar <valor> <contrasena>
    And Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | servicio             | referencia | valor  | numCelularUsuario |
      | "CC"   | "999837" | "1112"     | "DNR UNO A UNO JHON" | "1234"     | "1000" | "3142045585"      |
   