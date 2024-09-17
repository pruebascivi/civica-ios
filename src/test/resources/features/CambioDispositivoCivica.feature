#Author: JVR
@CambioDispositivoCivica
Feature: Cambio de dispositivo Cívica.
  Escenarios que permiten realizar cambio de dispositivo

  @CP0008M
  Scenario Outline: Cambio_de_dispositivo_CP0008M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - CC.
    #Given Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    #And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | subtipo |
      | "CC"   | "999837" | "1112"     | "MET"   |

  @CP0009M
  Scenario Outline: Cambio_de_dispositivo_CP0009M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - CE.
    #Given Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    #And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena  | subtipo |
      | "CE"   | "999829" | "2580"      | "MET"   |

  @CP0010M
  Scenario Outline: Cambio_de_dispositivo_CP0010M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - TI.
    #Given Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    #And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario      | contrasena | subtipo |
      | "TI"   | "1080406492" | "1234"     | "MET"   |

  @CP0011M
  Scenario Outline: Cambio_de_dispositivo_CP0011M_SYS_Validar el ingreso a la APP Cívica con un usuario DAVIPLATA.
    #Given Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    #And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | subtipo |
      | "CC"   | "999906" | "1234"     | "DAV"   |

  @CP0012M
  Scenario Outline: Cambio_de_dispositivo_CP0012M_SYS_Validar el ingreso a la APP Cívica con un usuario RAPPI.
    #Given Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    #And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario   | contrasena | subtipo |
      | "CC"   | "9999815" | "1234"     | "RAP"   |

  @CP0013M
  Scenario Outline: Cambio_de_dispositivo_CP0013M_SYS_Validar el ingreso a la APP Cívica con un usuario BMO.
    #Given Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    #And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena  | subtipo |
      | "CC"   | "999842" | "1111"      | "BMO"   |
      
  @CP0014M 
  Scenario Outline: Cambio_de_dispositivo_CP0014M_SYS_Validar el mensaje de rechazo cuando se ingresa mal la clave de ingreso.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When Validar el mensaje de rechazo cuando se ingresa mal la clave de ingreso <tipoId> <usuario> <contrasena>

    Examples: 
      | tipoId | usuario   | contrasena |
      | "CC"   | "9999815" | "2589"     |
