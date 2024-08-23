#Author: JVR
@CambioDispositivoCivica
Feature: Cambio de dispositivo Cívica.
  Escenarios que permiten realizar cambio de dispositivo

  @CP0007M
  Scenario Outline: CP0007M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - CC.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario    | contrasena | subtipo |
      | "CC"   | "10305051" | "2589"     | "MET"   |

  @CP0008M
  Scenario Outline: CP0008M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - CE.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario   | contrasena  | subtipo |
      | "CE"   | "9999814" | "2589"      | "MET"   |

  @CP0009M
  Scenario Outline: CP0009M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - TI.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario      | contrasena | subtipo |
      | "TI"   | "1080406492" | "2589"     | "MET"   |

  @CP0010M
  Scenario Outline: CP0010M_SYS_Validar el ingreso a la APP Cívica con un usuario MIGRADO.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario    | contrasena | subtipo   |
      | "CC"   | "10305051" | "2589"     | "MIGRADO" |

  @CP0011M
  Scenario Outline: CP0011M_SYS_Validar el ingreso a la APP Cívica con un usuario BMO.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario    | contrasena | subtipo |
      | "CC"   | "10305051" | "2589"     | "BMO"   |

  @CP00111M
  Scenario Outline: CP00111M_SYS_Validar el ingreso a la APP Cívica con un usuario DAVIPLATA.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario   | contrasena  | subtipo    |
      | "CE"   | "9999814" | "2589"      | "DAVIPLATA"|
	
	#FALTA DATA
  @CP00112M 
  Scenario Outline: CP00112M_SYS_Validar el ingreso a la APP Cívica con un usuario RAPPI.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario   | contrasena  | subtipo |
      | "CE"   | "9999814" | "2589"      | "RAPPI" |
      
  @CP0012M
  Scenario Outline: CP0012M_SYS_Ingreso con clave errónea.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When Validar el mensaje de rechazo cuando se ingresa mal la clave de ingreso <tipoId> <usuario> <badPass> <contrasena>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario   | badPass | contrasena | subtipo |
      | "CE"   | "9999814" | "0000"  |  "2589"    | "MET"   |
