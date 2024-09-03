#Author: JVR
@SacarPlataCivica
Feature: Sacar Plata Civica
  Escenarios que permiten sacar plata desde Civica

  @CP0039M
  Scenario Outline: CP0039M_SYS_Realizar un sacar plata exitoso con un usuario MET - CC
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
    And ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
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
      | tipoId | usuario  | contrasena | monto   | numCelularUsuario | subtipo |
      | "CC"   | "999812" | "0852"     | "10000" | "3142045549"      | "MET"   |

  @CP0040M
  Scenario Outline: CP0040M_SYS_Realizar un sacar plata exitoso con un usuario MET - CE
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
    And ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
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
      | tipoId | usuario   | contrasena | monto   | numCelularUsuario | subtipo |
      | "CE"   | "999829"  | "2580"     | "10000" | "3142045551"      | "MET"   |

  @CP0041M
  Scenario Outline: CP0041M_SYS_Realizar un sacar plata exitoso con un usuario MET - TI
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
    And ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
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
      | tipoId | usuario      | contrasena | monto   | numCelularUsuario | subtipo |
      | "TI"   | "1080406492" | "1234"     | "10000" | "3142045552"      | "MET"   |

  @CP0042M
  Scenario Outline: CP0042M_SYS_Realizar un sacar plata exitoso con un usuario COMUN
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
    And ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
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
      | tipoId | usuario  | contrasena | monto   | numCelularUsuario | subtipo |
      | "CC"   | "999812" | "0852"     | "10000" | "3142045549"      | "MET"   |

  @CP004201M
  Scenario Outline: CP004201M_SYS_Realizar un sacar plata exitoso con un usuario MIGRADO.
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
    And ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
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
      | tipoId | usuario  | contrasena | monto   | numCelularUsuario | subtipo |
      | "CC"   | "999812" | "0852"     | "10000" | "3142045549"      | "MET"   |

  @CP004202M
  Scenario Outline: CP004202MM_SYS_Validar ingresos de montos diferentes a los permitidos.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <montoConUno> <montoConDosOConCuatro> <montoConTres> <montoExitoso> <contrasena> <contraseniaErronea>
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | montoExitoso | montoConUno | montoConDosOConCuatro | montoConTres | numCelularUsuario | subtipo | contraseniaErronea|
      | "CE"   | "999829" | "2580"     | "20000"      | "720000"    | "725000"              | "9000"       | "3142045551"      | "MET"   |  "2580"           |
