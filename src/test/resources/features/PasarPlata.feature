#Author: JVR
@PasarPlataCore
Feature: Pasar Plata
  Escenarios que permiten pasar plata

  #READY
  @CP0030M
  Scenario Outline: CP0030M_SYS_Realizar un pasar plata exitoso con un usuario MET - CC a un monedero MET Civica.
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

  @CP0031M
  Scenario Outline: CP0031M_SYS_Realizar un pasar plata exitoso con un usuario MET - CE a un monedero MET Civica.
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
      | tipoId | usuario   | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo | usuarioDestino | subtipoDestino |
      | "CE"   | "9999814" | "4568"     | "3142045551"      | "3142045591"      | "100" | "MET"   | "9999814"      | "MET"        |

  @CP0032M
  Scenario Outline: CP0032M_SYS_Realizar un pasar plata exitoso con un usuario COMUN - TI a un monedero MET Civica.
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
      | "TI"   | "1080406492" | "4568"     | "3142045552"      | "3142045591"      | "100" | "MET"   | "9999814"      | "MET"          |

  @CP0033M
  Scenario Outline: CP0033M_SYS_Realizar un pasar plata exitoso con un usuario Migrado a un monedero MET Civica.
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

  @CP0034M
  Scenario Outline: CP0034M_SYS_Realizar un pasar plata exitoso con un usuario RAP a un monedero MET Civica.
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

  @CP0035M
  Scenario Outline: CP0035M_SYS_Realizar un pasar plata exitoso con un usuario BMO a un monedero MET Civica.
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
      | "CC"   | "999842" | "4568"     | "3142045595"      | "3142045591"      | "100" | "BMO"   | "9999814"      | "MET"          |

  @CP0036M
  Scenario Outline: CP0036M_SYS_Realizar un pasar plata exitoso con un usuario MET a un usuario OnHold.
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

  @CP003601M
  Scenario Outline: CP003601M_SYS_Realizar un pasar plata exitoso con un usuario GMF a un monedero Met Civica.
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

  @CP003602M
  Scenario Outline: CP003602M_SYS_Realizar un pasar plata exitoso con un usuario GMF a un OnHold
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
      | "CC"   | "807127" | "1234"     | "3138524527"      | "3142045591"      | "100" | "GMF"   | "9999814"      | "MET"          |

  @CP003603M
  Scenario Outline: CP003603M_SYS_Validar que al intentar realizar un pasar plata sin contar con el saldo completo en el monedero, se rechace la transacción.
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
      | tipoId | usuario   | contrasena | numCelularDestino | valor | subtipo | valorErroneo |
      | "CE"   | "9999814" | "4568"     | "3142045591"      | "100" | "MET"   | "1000000"    |
