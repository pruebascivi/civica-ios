#Author: JVR
@CambioClaveOlvido
Feature: Cambio de clave por olvido
  Escenarios que permiten realizar el cambio de clave por olvido

  @CP0024M @Passed
  Scenario Outline: Cambio_clave_olvido_CP0024M_SYS_Realizar el cambio de clave para un usuario MET - CC.
    #Given Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    #And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | newPass | correo                     | subtipo |
      | "CC"   | "999821" | "1004"  | "pruebaslabcivi@gmail.com" | "MET"   |

  @CP0025M @Passed
  Scenario Outline: Cambio_clave_olvido_CP0025M_SYS_Realizar el cambio de clave para un usuario MET - CE.
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
      | "CE"   | "9999814" | "1235"  | "pruebaslabcivi@gmail.com" | "MET"   |

  @CP0026M @Passed
  Scenario Outline: Cambio_clave_olvido_CP0026M_SYS_Realizar el cambio de clave para un usuario MET - TI.
    #Given Obtener numero celular actual en redeban <usuario>
    #And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    #And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario      | newPass | correo                     | subtipo |
      | "TI"   | "1080406492" | "1234"  | "pruebaslabcivi@gmail.com" | "MET"   |

  @CP0027M @Passed
  Scenario Outline: Cambio_clave_olvido_CP0027M_SYS_Realizar el cambio de clave para un usuario BMO.
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
      | tipoId | usuario    | newPass | correo                     | subtipo |
      | "CC"   | "10337953" | "2499"  | "pruebaslabcivi@gmail.com" | "BMO"   |

  @CP0028M @Passed
  Scenario Outline: Cambio_clave_olvido_CP0028M_SYS_Realizar el cambio de clave para un usuario RAP.
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
      | "CC"   | "999832" | "2597"  | "pruebaslabcivi@gmail.com" | "RAP"   |

  @CP0029M @Passed
  Scenario Outline: Cambio_clave_olvido_CP0029M_SYS_Realizar el cambio de clave para un usuario MIGRADO.
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
      | tipoId | usuario    | newPass | correo                     | subtipo   |
      | "CC"   | "10305051" | "2597"  | "pruebaslabcivi@gmail.com" | "MIGRADO" |
      
  @CP0030M @Passed
  Scenario Outline: Cambio_clave_olvido_CP0030M_SYS_Validar el mensaje de rechazo cuando se ingresa mal el correo.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And ingreso correo erróneo y valido mensaje error <correoErroneo> <newPass> <tipoId> <usuario> <correo>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home
    
    Examples: 
      | tipoId | usuario  | newPass | correo                     | correoErroneo   |
      | "CC"   | "999821" | "2589"  | "pruebaslabcivi@gmail.com" | "xxx@gmail.com" |
      
  @CP0031M @Passed
  Scenario Outline: Cambio_clave_olvido_CP0031M_SYS_Validar el pop up de rechazo cuando ingresas una clave que inicia por 19 ó 20.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario    | newPass | correo                     |
      | "CC"   | "10305051" | "2597"  | "pruebaslabcivi@gmail.com" |
