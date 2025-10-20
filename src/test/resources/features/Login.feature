Feature: Login

  Scenario: Tentar logar sem ativar o email
    Given que eu crio um usuario no backend sem ativar o email
    And que eu tento realizar login
    Then deve retornar status code 403
    And deve retornar a mensagem de erro "E-mail do usuário não foi confirmado."



