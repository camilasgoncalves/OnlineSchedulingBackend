Feature: User

  @Test @Usuario @Regressao
  Scenario: Criação de usuario sem ativação de e-mail
    Given que eu crio os dados de um usuario
    When chamo a api de criação de usuario
    Then deve retornar status code 201
    And deve retornar a mensagem "Usuário registrado."
