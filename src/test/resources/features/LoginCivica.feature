#Author: JVR
@LoginCivica
Feature: Login Civica
  Escenarios que permiten realizar login controlado

  @CP0001M
  Scenario Outline: Login_CP0001M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - CC.
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
      | tipoId | usuario  | contrasena | subtipo | numCelularUsuario |
      | "CC"   | "999837" | "1112"     | "MET"   | "3142045565"      |

  @CP0002M
  Scenario Outline: Login_CP0002M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - TI.
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
      | tipoId | usuario      | contrasena | subtipo | numCelularUsuario |
      | "TI"   | "1080406492" | "1234"     | "MET"   | "3142045552"      |

  @CP0003M
  Scenario Outline: Login_CP0003M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - CE.
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
      | "CE"   | "999829" | "2580"     | "MET"   | "3142045551"      |

  @CP0004M
  Scenario Outline: Login_CP0004M_SYS_Validar el ingreso a la APP Cívica con un usuario DaviPlata.
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
      | "CC"   | "999798" | "1111"     | "DAV"   | "3004005051"      |

  @CP0005M
  Scenario Outline: Login_CP0005M_SYS_Validar el ingreso a la APP Cívica con un usuario BMO.
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
      | "CC"   | "999842" | "1111"     | "BMO"   | "3142045595"      |
      
  @CP0006M
  Scenario Outline: Login_CP0006M_SYS_Validar que el usuario al ingresar por 4 vez la clave incorrecta.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono ingresar opcion erronea
    And ingreso nuevamente clave de manera errónea <tipoId> <usuario> <contrasena>
    And Valido que el usuario al ingresar por 4 vez la clave incorrecta del ingreso en APP Cívica se debe inhabilitar el campo “Clave” y se debe mostrar al usuario el mensaje “Algo salió mal

      | tipoId | usuario  | contrasena |
      | "CE"   | "999829" | "2589"     |

  @CP0007M
  Scenario Outline: Login_CP0007M_SYS_Validar un usuario bloqueado por intentos fallidos en Cívica App.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When Validar el mensaje de rechazo cuando se ingresa mal la clave de ingreso por num de intentos <tipoId> <usuario> <badPass>
	
    Examples: 
      | tipoId | usuario  | badPass |
      | "CE"   | "999829" | "2589"  |

