Esse é um sistema de controle de estoque

Foi utilizado spring boot, postgres e o bootstrap 5

Para Rodar localmente é necessário baixar o postgres e utilizar o springboot

Formulário de Cadastro:
- O sistema deve exibir um formulário com campos para Nome do Produto, Preço de venda do Produto, Preço de custo do produto, Código de barras, Unidade de Medida, Lucro e Quantidade em Estoque.
- Cadastro de Estado deve exibir um formulário com Nome do estado e sigla.
- Cadastro da cidade deve exibir um formulário com Nome da cidade e selecionar o estado que ela pertence.
- Cadastro de Fornecedor deve exibir um formulário com Nome do Fornecedor, CNPJ, Telefone, selecionar a cidade, Endereço, Bairro e Email.
- Cadastro de Funcionário deve exibir um formulário com Nome do Funcionário, CPF, Telefone, Cidade, Endereço, Bairro, Email, cargo.
- Cadasstro de Cliente deve exibir um formulário com Nome do Cliente, Cpf, Telefone, Cidade, Endereço, Bairro, Email.
- Todos os campos obrigatórios devem ser claramente indicados.
- 
Validação de Dados:​

- O sistema deve validar que todos os campos obrigatórios estão preenchidos.
- O sistema deve validar que o preço do produto está em um formato numérico válido.
- O sistema deve validar que a quantidade em estoque é um número inteiro não negativo.

Salvar Produto:

- O sistema deve permitir que o usuario clique em "Salvar" para enviar o formulário.
- Se os dados forem válidos, o sistema deve salvar as informações do produto no banco de dados.
  
Confirmação de Cadastro:

- O produto cadastrado deve aparecer na lista de produtos disponível para consulta.
