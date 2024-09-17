#Author: JVR
@RecargarPseCivicaPay
Feature: Recargar por PSE
  Escenarios que permiten realizar una recarga por PSE a Cívica Pay

  #READY
  @CP00471M
  Scenario Outline: CP00471M_SYS_Realizar una recarga por PSE Civicapay a un usuario MET - CC.
    Given Obtener numero celular actual en redeban <destinationUser>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <destinationUser> <subtipo> <destinationUserCell>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales CivicaPay
    Then ingreso al modulo 'Recargar CivicaPay' <destinationUserCell> <monto> <banco>
    And Ingreso clave en PSE <clave>
    And Validar saldo final civica
    And Validar movimiento recarga CiviPay en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <destinationUser>
    And Consultar saldos en redeban
    And Validar en redeban Recarga CiviPay <destinationUser>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos CivicaPay

    Examples: 
      | tipoId | usuario  | contrasena | destinationUserCell | monto   | banco                    | clave | destinationUser | subtipo |
      | "CC"   | "999837" | "1112"     | "3142045584"        | "10000" | "BANCO UNION COLOMBIANO" | "123" | "999836"        | "MET"   |

  @CP00472M
  Scenario Outline: CP00472M_SYS_Realizar una recarga por PSE Civicapay a un usuario MET - CE.
    #Given Obtener numero celular actual en redeban <destinationUser>
    #And Consultar saldos en redeban
    #And Validar en redeban subtipo <destinationUser> <subtipo> <destinationUserCell>
    #And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales CivicaPay
    Then ingreso al modulo 'Recargar CivicaPay' <destinationUserCell> <monto> <banco>
    And Ingreso clave en PSE <clave>
    And Validar saldo final civica
    And Validar movimiento recarga CiviPay en el aplicativo
    And Cerrar sesion desde el home
    #And Obtener numero celular actual en redeban <destinationUser>
    #And Consultar saldos en redeban
    #And Validar en redeban Recarga CiviPay <destinationUser>
    #And Entre a detalles de usuario
    #And Logout redeban
    And Validar afectacion de saldos CivicaPay

    Examples: 
      | tipoId | usuario  | contrasena | destinationUserCell | monto   | banco                    | clave | destinationUser | subtipo |
      | "CE"   | "999829" | "2580"     | "3142045585"        | "10000" | "BANCO UNION COLOMBIANO" | "123" | "999836"        | "MET"   |

  @CP00473M
  Scenario Outline: CP00473M_SYS_Realizar una recarga por PSE Civicapay a un usuario MET - TI.
    Given Obtener numero celular actual en redeban <destinationUser>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <destinationUser> <subtipo> <destinationUserCell>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales CivicaPay
    Then ingreso al modulo 'Recargar CivicaPay' <destinationUserCell> <monto> <banco>
    And Ingreso clave en PSE <clave>
    And Validar saldo final civica
    And Validar movimiento recarga CiviPay en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <destinationUser>
    And Consultar saldos en redeban
    And Validar en redeban Recarga CiviPay <destinationUser>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos CivicaPay

    Examples: 
      | tipoId | usuario  | contrasena | destinationUserCell | monto   | banco                    | clave | destinationUser | subtipo |
      | "CC"   | "999837" | "1112"     | "3142045584"        | "10000" | "BANCO UNION COLOMBIANO" | "123" | "999836"        | "MET"   |

  @CP00474M
  Scenario Outline: CP00474M_SYS_Realizar una recarga por PSE Civicapay a un usuario GMF.
    Given Obtener numero celular actual en redeban <destinationUser>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <destinationUser> <subtipo> <destinationUserCell>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales CivicaPay
    Then ingreso al modulo 'Recargar CivicaPay' <destinationUserCell> <monto> <banco>
    And Ingreso clave en PSE <clave>
    And Validar saldo final civica
    And Validar movimiento recarga CiviPay en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <destinationUser>
    And Consultar saldos en redeban
    And Validar en redeban Recarga CiviPay <destinationUser>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos CivicaPay

    Examples: 
      | tipoId | usuario  | contrasena | destinationUserCell | monto   | banco                    | clave | destinationUser | subtipo |
      | "CC"   | "999837" | "1112"     | "3142045584"        | "10000" | "BANCO UNION COLOMBIANO" | "123" | "999836"        | "GMF"   |

  @CP00475M
  Scenario Outline: CP00475M_SYS_Realizar una recarga por PSE Civicapay a un usuario DAVIPLATA.
    Given Obtener numero celular actual en redeban <destinationUser>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <destinationUser> <subtipo> <destinationUserCell>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales CivicaPay
    Then ingreso al modulo 'Recargar CivicaPay' <destinationUserCell> <monto> <banco>
    And Ingreso clave en PSE <clave>
    And Validar saldo final civica
    And Validar movimiento recarga CiviPay en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <destinationUser>
    And Consultar saldos en redeban
    And Validar en redeban Recarga CiviPay <destinationUser>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos CivicaPay

    Examples: 
      | tipoId | usuario  | contrasena | destinationUserCell | monto   | banco                    | clave | destinationUser | subtipo |
      | "CC"   | "999837" | "1112"     | "3142045584"        | "10000" | "BANCO UNION COLOMBIANO" | "123" | "999836"        | "BMO"   |

  @CP00476M
  Scenario Outline: CP00476M_SYS_Realizar una recarga por PSE Civicapay a un usuario RAPPI.
    Given Obtener numero celular actual en redeban <destinationUser>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <destinationUser> <subtipo> <destinationUserCell>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales CivicaPay
    Then ingreso al modulo 'Recargar CivicaPay' <destinationUserCell> <monto> <banco>
    And Ingreso clave en PSE <clave>
    And Validar saldo final civica
    And Validar movimiento recarga CiviPay en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <destinationUser>
    And Consultar saldos en redeban
    And Validar en redeban Recarga CiviPay <destinationUser>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos CivicaPay

    Examples: 
      | tipoId | usuario  | contrasena | destinationUserCell | monto   | banco                    | clave | destinationUser | subtipo |
      | "CC"   | "999837" | "1112"     | "3142045584"        | "10000" | "BANCO UNION COLOMBIANO" | "123" | "999836"        | "RAP"   |

  @CP00477M
  Scenario Outline: CP00477M_SYS_Realizar una recarga por PSE Civicapay a un usuario MIGRADO.
    Given Obtener numero celular actual en redeban <destinationUser>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <destinationUser> <subtipo> <destinationUserCell>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales CivicaPay
    Then ingreso al modulo 'Recargar CivicaPay' <destinationUserCell> <monto> <banco>
    And Ingreso clave en PSE <clave>
    And Validar saldo final civica
    And Validar movimiento recarga CiviPay en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <destinationUser>
    And Consultar saldos en redeban
    And Validar en redeban Recarga CiviPay <destinationUser>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos CivicaPay

    Examples: 
      | tipoId | usuario  | contrasena | destinationUserCell | monto   | banco                    | clave | destinationUser | subtipo |
      | "CC"   | "999837" | "1112"     | "3142045584"        | "10000" | "BANCO UNION COLOMBIANO" | "123" | "999836"        | "MET"   |

  @CP00478M
  Scenario Outline: CP00478M_SYS_Valido Pop up al intentar ingresar al módulo Recargar Civica en el home público
    Given ingreso al aplicativo
    And Valido estoy en el home publico
    And Doy clic en el boton Recargar CiviPay desde home publico
    And Valido Pop up Ingresa a la app
    When Pop up direge a la interfaz de ingreso de credenciales
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Logout app

    Examples: 
      | tipoId | usuario  | contrasena |
      | "CC"   | "999837" | "1112"     |
