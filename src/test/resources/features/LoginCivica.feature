#Author: JVR
@LoginCivica
Feature: Login Civica
  Escenarios que permiten realizar login controlado

  @CP0001M
  Scenario Outline: CP0001M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - CC.
    #Given Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    #And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | subtipo | numCelularUsuario |
      | "CC"   | "999837" | "1234"     | "MET"   | "3142045585"      |

  @CP0002M
  Scenario Outline: CP0002M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - TI.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario      | contrasena | subtipo | numCelularUsuario |
      | "TI"   | "1080406492" | "2589"     | "MET"   | "3142045552"      |

  @CP0003M
  Scenario Outline: CP0003M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - CE.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario   | contrasena | subtipo | numCelularUsuario |
      | "CE"   | "9999814" | "2589"     | "MET"   | "3142045551"      |

  @CP0004M
  Scenario Outline: CP0004M_SYS_Validar el ingreso a la APP Cívica con un usuario MIGRADO.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario     | contrasena | subtipo  | numCelularUsuario |
      | "CC"   | "215333181" | "4568"     | "MET"    | "3142045554"      |

  @CP0005M
  Scenario Outline: CP0005M_SYS_Validar el ingreso a la APP Cívica con un usuario BMO.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario    | contrasena | subtipo | numCelularUsuario |
      | "CC"   | "10305051" | "2589"     | "BMO"   | "3004005051"      |

  @CP0005IM
  Scenario Outline: CP0005IM_SYS_Validar el ingreso a la APP Cívica con un usuario DAVIPLATA BMO.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario   | contrasena | subtipo | numCelularUsuario |
      | "CE"   | "9999814" | "2589"     | "MET"   | "3142045551"      |

  @CP0006M
  Scenario Outline: CP0006M_SYS_Ingreso con clave errónea.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And ingreso nuevamente clave de manera errónea <tipoId> <usuario> <contrasena>
    And Valido que el usuario al ingresar por 4 vez la clave incorrecta del ingreso en APP Cívica se debe inhabilitar el campo “Clave” y se debe mostrar al usuario el mensaje “Algo salió mal

    Examples: 
      | tipoId | usuario  | contrasena |
      | "CC"   | "999798" | "0000"     |
