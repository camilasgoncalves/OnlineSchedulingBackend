Feature: User

  @Test @Usuario @Regressao
  Scenario: Criação de usuario sem ativação de e-mail
    Given que eu crio os dados de um usuario
    When chamo a api de criação de usuario
    Then deve retornar status code 201
    And deve retornar a mensagem "Usuário registrado."

  @Test @Usuario
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