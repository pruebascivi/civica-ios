#Author: JVR
@PasarPlataCore
Feature: Pasar Plata
  Escenarios que permiten pasar plata

  @CP0044M
  Scenario Outline: Pasar_plata_CP0044M_SYS_Realizar un pasar plata exitoso con un usuario MET a un monedero MET
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    Given Obtener numero celular destino en redeban <usuarioDestino>
    And Consultar saldos usuario destino en redeban
    And Validar en redeban subtipo destino <usuario> <subtipo> <numCelularDestino>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    And Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    Given Obtener numero celular destino en redeban <usuarioDestino>
    And Consultar saldos usuario destino en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | numCelularUsuario | numCelularDestino | valor  | subtipo | usuarioDestino | subtipoDestino |
      | "CC"   | "999793" | "2587"     | "3142045523"      | "3004005051"      | "1000" | "MET"   | "9999814"      | "MET"          |

  @CP0045M
  Scenario Outline: Pasar_plata_CP0045M_SYS_Realizar un pasar plata exitoso con un usuario MET a un monedero COMUN
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    Given Obtener numero celular destino en redeban <usuarioDestino>
    And Consultar saldos usuario destino en redeban
    And Validar en redeban subtipo destino <usuario> <subtipo> <numCelularDestino>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    And Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    Given Obtener numero celular destino en redeban <usuarioDestino>
    And Consultar saldos usuario destino en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo | usuarioDestino | subtipoDestino |
      | "CE"   | "999829" | "2580"      | "3142045551"      | "3142045591"      | "100" | "MET"   | "9999814"      | "MET"        |

  @CP0046M
  Scenario Outline: Pasar_plata_CP0046M_SYS_Realizar un pasar plata exitoso con un usuario COMUN a un monedero MET
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    Given Obtener numero celular destino en redeban <usuarioDestino>
    And Consultar saldos usuario destino en redeban
    And Validar en redeban subtipo destino <usuario> <subtipo> <numCelularDestino>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    And Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    Given Obtener numero celular destino en redeban <usuarioDestino>
    And Consultar saldos usuario destino en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario      | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo | usuarioDestino | subtipoDestino |
      | "TI"   | "1080406492" | "1234"     | "3142045552"      | "3142045591"      | "100" | "MET"   | "9999814"      | "MET"          |

  @CP0047M
  Scenario Outline: Pasar_plata_CP0047M_SYS_Realizar un pasar plata exitoso con un usuario COMUN a un monedero COMUN
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    Given Obtener numero celular destino en redeban <usuarioDestino>
    And Consultar saldos usuario destino en redeban
    And Validar en redeban subtipo destino <usuario> <subtipo> <numCelularDestino>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    And Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    Given Obtener numero celular destino en redeban <usuarioDestino>
    And Consultar saldos usuario destino en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario     | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo | usuarioDestino | subtipoDestino |
      | "CC"   | "215333181" | "4568"     | "3142045554"      | "3142045591"      | "100" | "MET"   | "9999814"      | "MET"          |

  @CP0048M
  Scenario Outline: Pasar_plata_CP0048M_SYS_Realizar un pasar plata exitoso con un usuario MET a un monedero OnHold
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    Given Obtener numero celular destino en redeban <usuarioDestino>
    And Consultar saldos usuario destino en redeban
    And Validar en redeban subtipo destino <usuario> <subtipo> <numCelularDestino>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    And Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    Given Obtener numero celular destino en redeban <usuarioDestino>
    And Consultar saldos usuario destino en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo | usuarioDestino | subtipoDestino |
      | "CC"   | "999806" | "2580"     | "3142045538"      | "3142045591"      | "100" | "RAP"   | "9999814"      | "MET"          |

  @CP0049M
  Scenario Outline: Pasar_plata_CP0049M_SYS_Realizar un pasar plata exitoso con un usuario COMUN a un monedero OnHold
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    Given Obtener numero celular destino en redeban <usuarioDestino>
    And Consultar saldos usuario destino en redeban
    And Validar en redeban subtipo destino <usuario> <subtipo> <numCelularDestino>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    And Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    Given Obtener numero celular destino en redeban <usuarioDestino>
    And Consultar saldos usuario destino en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo | usuarioDestino | subtipoDestino |
      | "CC"   | "999842" | "1111"     | "3142045595"      | "3142045591"      | "100" | "BMO"   | "9999814"      | "MET"          |

  @CP0050M
  Scenario Outline: Pasar_plata_CP0050M_SYS_Realizar un pasar plata exitoso con un usuario GMF a un monedero
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    Given Obtener numero celular destino en redeban <usuarioDestino>
    And Consultar saldos usuario destino en redeban
    And Validar en redeban subtipo destino <usuario> <subtipo> <numCelularDestino>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    And Validar saldo final civica
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    Given Obtener numero celular destino en redeban <usuarioDestino>
    And Consultar saldos usuario destino en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo | usuarioDestino | subtipoDestino |
      | "CC"   | "999793" | "2587"     | "3142045523"      | "3126258207"      | "100" | "MET"   | "9999814"      | "MET"          |

  @CP0051M
  Scenario Outline: Pasar_plata_CP0051M_SYS_Realizar un pasar plata exitoso con un usuario GMF a un OnHold
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    Given Obtener numero celular destino en redeban <usuarioDestino>
    And Consultar saldos usuario destino en redeban
    And Validar en redeban subtipo destino <usuario> <subtipo> <numCelularDestino>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    And Validar saldo final civica
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    Given Obtener numero celular destino en redeban <usuarioDestino>
    And Consultar saldos usuario destino en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario   | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo | usuarioDestino | subtipoDestino |
      | "CC"   | "1031041" | "2587"     | "3178909090"      | "3142045591"      | "100" | "GMF"   | "9999814"      | "MET"          |

  @CP0052M
  Scenario Outline: Pasar_plata_CP0052M_SYS_Realizar un pasar plata exitoso con un usuario Migrado
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
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    And Validar saldo final civica
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | numCelularUsuario | numCelularDestino | valor  | subtipo | 
      | "CC"   | "999793" | "2587"     | "3142045523"      | "3004005051"      | "1000" | "MET"   | 

  @CP0053M
  Scenario Outline: Pasar_plata_CP0053M_SYS_Validar que al intentar realizar un pasar plata sin contar con el saldo completo en el monedero, se rechace la transacción
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar valor erroneo <valorErroneo> <valor> <numCelularDestino>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    And Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | numCelularDestino | valor | valorErroneo |
      | "CE"   | "999829" | "2580"     | "3142045591"      | "100" | "1000000"    |
      
  @CP0054M
  Scenario Outline: Pasar_plata_CP0054M_SYS_Validar que se afecten los saldos y movimientos en la web redeban
   Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    And Validar saldo final civica
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

   Examples: 
      | tipoId | usuario  | contrasena | numCelularUsuario | numCelularDestino | valor  | 
      | "CC"   | "999793" | "2587"     | "3142045523"      | "3004005051"      | "1000" |  
    
  @CP0055M
  Scenario Outline: Pasar_plata_CP0055M_SYS_Validar que se afecten los saldos y movimientos en la APP Cívica
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    And Validar saldo final civica
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

   Examples: 
      | tipoId | usuario  | contrasena | numCelularUsuario | numCelularDestino | valor  | 
      | "CC"   | "999793" | "2587"     | "3142045523"      | "3004005051"      | "1000" |
      
