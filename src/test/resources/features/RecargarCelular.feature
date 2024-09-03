#Author: JVR
@RecargarCelularCivica
Feature: Recargar Celular Cívica
  Escenarios que permiten ealizar una recarga de celular

  # FALTA DATA GMF
  @CP0043M
  Scenario Outline: CP0043M_SYS_Realizar una recarga de celular de un usuario con cualquier tipo de identificación 
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Recargar Celular'
    And selecciono operador del celular e ingreso datos de la recarga <numCelular> <valor>
    And valido datos ingresados y finalizo el proceso <contrasena>
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban el tipo de transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario   | contrasena | numCelular   | valor  | numCelularUsuario | subtipo |
      | "CC"   | "1031041" | "2587"     | "3142045530" | "1000" | "3178909090"      | "GMF"   |

	#READY
  @CP0044M @incluido
  Scenario Outline: CP0044M_SYS_Realizar una recarga de celular con un usuario CE.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Recargar Celular'
    And selecciono operador del celular e ingreso datos de la recarga <numCelular> <valor>
    And valido datos ingresados y finalizo el proceso <contrasena>
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban el tipo de transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario   | contrasena | numCelular   | valor  | numCelularUsuario | subtipo |
      | "CE"   | "999829"  | "2580"     | "3142045530" | "1000" | "3142045551"      | "MET"   |

  @CP0045M @incluido
  Scenario Outline: CP0045M_SYS_Realizar una recarga de celular con un usuario TI.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Recargar Celular'
    And selecciono operador del celular e ingreso datos de la recarga <numCelular> <valor>
    And valido datos ingresados y finalizo el proceso <contrasena>
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban el tipo de transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario      | contrasena | numCelular   | valor  | numCelularUsuario | subtipo |
      | "TI"   | "1080406492" | "1234"     | "3142045530" | "1000" | "3142045577"      | "MET"   |

  @CP004601M
  Scenario Outline: CP004601M_SYS_Validaciones en monto mayor al permitido, error al ingresar clave errónea y saldo insuficiente.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Recargar Celular'
    And selecciono operador del celular e ingreso datos de la recarga con valor erroneo <numCelularDestino> <valor> <badValue>
    And valido datos ingresados y finalizo el proceso <contrasena>
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban el tipo de transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | numCelularDestino | valor  | numCelularUsuario | subtipo | badValue |
      | "CC"   | "999842" | "1111"     | "3142045595"      | "1000" | "3142045595"      | "BMO"   | "100002" |
