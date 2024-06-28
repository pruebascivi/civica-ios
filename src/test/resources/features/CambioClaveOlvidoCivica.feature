#Author: JVR
@CambioClaveOlvido
Feature: Cambio de clave por olvido
  Escenarios que permiten realizar el cambio de clave por olvido

  @CP0018M
  Scenario Outline: CP0018M_SYS_Realizar el cambio de clave para un usuario MET - CC.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And ingreso correo erróneo y valido mensaje error <correoErroneo> <newPass> <tipoId> <usuario> <correo>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario    | newPass | correo                     | correoErroneo   | subtipo | 
      | "CC"   | "10485962" | "1235"  | "pruebaslabcivi@gmail.com" | "xxx@gmail.com" | "MET"   | 

  @CP0019M
  Scenario Outline: CP0019M_SYS_Realizar el cambio de clave para un usuario MET - CE.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario   | newPass | correo                     | subtipo |
      | "CE"   | "9999845" | "2580"  | "pruebaslabcivi@gmail.com" | "MET"   |

  @CP0020M
  Scenario Outline: CP0020M_SYS_Realizar el cambio de clave para un usuario MET - TI.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
		Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home
    
    Examples: 
      | tipoId | usuario      | newPass | correo                     | subtipo |
      | "TI"   | "1080406492" | "0853"  | "pruebaslabcivi@gmail.com" | "MET"   |

  @CP0021M
  Scenario Outline: CP0021M_SYS_Realizar el cambio de clave para un usuario MIGRADO.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
		Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home
    
    Examples: 
      | tipoId | usuario     | newPass | correo                     | subtipo |
      | "CC"   | "215333181" | "1342"  | "pruebaslabcivi@gmail.com" | "MET"   |

  @CP0022M
  Scenario Outline: CP0022M_SYS_Realizar el cambio de clave para un usuario RAP.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
	  Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home
    
    Examples: 
      | tipoId | usuario  | newPass | correo                     | subtipo |
      | "CC"   | "999832" | "2588 " | "pruebaslabcivi@gmail.com" | "RAP"   |

  @CP0023M
  Scenario Outline: CP0023M_SYS_Realizar el cambio de clave para un usuario BMO.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
		Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home
    
    Examples: 
      | tipoId | usuario  | newPass | correo                     | subtipo |
      | "CC"   | "999824" | "1425 " | "pruebaslabcivi@gmail.com" | "BMO"   |

