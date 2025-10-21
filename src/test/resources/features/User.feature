Feature: User

  @Test @Usuario @Regressao
  Scenario: Criação de usuario sem ativação de e-mail
    Given que eu crio os dados de um usuario
    When chamo a api de criação de usuario
    Then deve retornar status code 201
    And deve retornar a mensagem "Usuário registrado."

  @Test @User
  Scenario Outline: Validar erro ao tentar criar conta com e-mail invalido
    Given que eu crio os dados de um usuario com o email "<email>" invalido
    When chamo a api de criação de usuario
    Then deve retornar status code 422
    And deve retornar a mensagem "<mensagemErro>"
    Examples:
      | email                  | mensagemErro                                    |
      | camilagmail.com        | O formato do E-mail está incorreto.             |
      | camila@gmail@gmail.com | O formato do E-mail está incorreto.             |
      | a@aaa.com              | O E-mail deve conter entre 10 e 256 caracteres. |
      | null                   | O E-mail não pode ser vazio ou null.            |
      | camila @gmail.com      | O formato do E-mail está incorreto.             |
      | camila@@gmail.com      | O formato do E-mail está incorreto.             |
      | @gmail.com             | O formato do E-mail está incorreto.             |
      | camila@.com            | O formato do E-mail está incorreto.             |
      | camiddddddddddla@      | O formato do E-mail está incorreto.             |

  @Test @User
  Scenario Outline: Validar erro ao tentar criar conta com senha invalida
    Given que eu crio os dados de um usuario com a senha "<senha>" invalida
    When chamo a api de criação de usuario
    Then deve retornar status code 422
    And deve retornar a mensagem "<mensagemErroSenha>"
    Examples:
      | senha    | mensagemErroSenha                                                                                                                                                                                                              |
      | null     | A senha não pode ser vazia ou null.                                                                                                                                                                                            |
      | senha123 | Sua senha deve conter pelo menos uma letra maiúscula, uma letra minúscula, um caracter especial e um número.                                                                                                                   |
      | SENHA123 | Sua senha deve conter pelo menos uma letra maiúscula, uma letra minúscula, um caracter especial e um número.                                                                                                                   |
      | Senhaabc | Sua senha deve conter pelo menos uma letra maiúscula, uma letra minúscula, um caracter especial e um número.                                                                                                                   |
      | Senha@   | A Senha deve conter entre 10 e 256 caracteres.                                                               \|\| Sua senha deve conter pelo menos uma letra maiúscula, uma letra minúscula, um caracter especial e um número. |
      | 12345678 | Sua senha deve conter pelo menos uma letra maiúscula, uma letra minúscula, um caracter especial e um número.                                                                                                                   |
      | !!!!!!!! | Sua senha deve conter pelo menos uma letra maiúscula, uma letra minúscula, um caracter especial e um número.                                                                                                                   |

  @Test @User
  Scenario Outline: Validar erro ao tentar criar uma conta com a data de nascimento invalida
    Given que eu crio os dados de um usuario com a data de nascimento "<dataNascimento>" invalida
    When chamo a api de criação de usuario
    Then deve retornar status code 422
    And deve retornar a mensagem "<mensagemErroDataNascimento>"
    Examples:
      | dataNascimento | mensagemErroDataNascimento                                                                                            |
      | null           | Birthday não pode ser vazio ou null.                                                                                  |
      | 2025-10-21     | Usuário deve ter mais de 16 anos. \|\|  Data de nascimento deve ser no passado e usuário precisa ter mais de 16 anos. |
      | 2028-01-01     | Data de nascimento deve ser no passado e usuário precisa ter mais de 16 anos.                                         |
      | 25-05-1999     | Birthday deve ter o formato: yyyy-MM-dd                                                                               |
      | 1999-25-05     | Birthday deve ter o formato: yyyy-MM-dd                                                                               |
      | 0000-00-00     | Birthday deve ter o formato: yyyy-MM-dd                                                                               |
      | 1999!-25-05    | Birthday deve ter o formato: yyyy-MM-dd                                                                               |
      | oi             | Birthday deve ter o formato: yyyy-MM-dd                                                                               |

  @Test @User
  Scenario Outline: Validar erro ao tentar criar uma conta com o nome invalido
    Given que eu crio os dados de um usuario com o nome "<nome>" invalido
    When chamo a api de criação de usuario
    Then deve retornar status code 422
    And deve retornar a mensagem "<mensagemErroNome>"
    Examples:
      | nome              | mensagemErroNome                                                                                               |
      | null              | O nome não pode ser vazio ou null.                                                                             |
      | Camila            | O nome deve conter apenas letras, com um espaço entre os nomes e no minimo dois nomes. exemplo: Joao Silveira. |
      | Camila 123        | O nome deve conter apenas letras, com um espaço entre os nomes e no minimo dois nomes. exemplo: Joao Silveira. |
      | Camila_Goncalves  | O nome deve conter apenas letras, com um espaço entre os nomes e no minimo dois nomes. exemplo: Joao Silveira. |
      | Camila  Goncalves | O nome deve conter apenas letras, com um espaço entre os nomes e no minimo dois nomes. exemplo: Joao Silveira. |
      | CamilaGoncalves   | O nome deve conter apenas letras, com um espaço entre os nomes e no minimo dois nomes. exemplo: Joao Silveira. |
      | 1234              | O nome deve conter apenas letras, com um espaço entre os nomes e no minimo dois nomes. exemplo: Joao Silveira. |
      | !@#$%             | O nome deve conter apenas letras, com um espaço entre os nomes e no minimo dois nomes. exemplo: Joao Silveira. |

  @Test @User
  Scenario Outline: Validar erro ao tentar criar conta com provider e specialty inconsistentes
    Given que eu crio os dados de um usuario com provider "<provider>" e specialty "<specialty>"
    When chamo a api de criação de usuario
    Then deve retornar status code 422
    And deve retornar a mensagem "<mensagemErroProvider>"

    Examples:
      | provider | specialty | mensagemErroProvider                                                      |
      | true     | null      | Especialidade deve ser preenchido quando provider for true.               |
      | false    | QA        | Especialidade deve ser null ou não declarado quando o provider for false. |
      | false    | Dev       | Especialidade deve ser null ou não declarado quando o provider for false. |
