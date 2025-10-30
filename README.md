# 🏦 Desafio 1 - Aplicação Bancária

## 🎯 Objetivo
Desenvolver uma aplicação bancária que permita transferências de valores entre contas, com funcionalidades essenciais para gestão bancária.

---

## ⚙️ Funcionalidades Mínimas
- Cadastro de conta bancária (número da conta, número da agência, cliente, saldo, limite, tipo da conta)
- Depósito
- Retirada (saque)
- Alteração de limite
- Transferências (considere limitar o valor de acordo com o horário)
- Exportação de histórico de transações (CSV)

A aplicação deve conter um **menu via terminal** para seleção da operação desejada.

---

## 🧩 Considerações
- A descrição do sistema é propositalmente genérica para encorajar a extensão de funcionalidades.  
- As funcionalidades acima são obrigatórias para o aceite da entrega.  
- Utilize conceitos como **menus com Scanner**, **boas práticas de nomenclatura**, **herança**, **listas**, **interfaces**, **trabalho com arquivos**, etc.  
- Não é necessário persistência em bancos de dados; utilize **listas/mapas em memória**.  
- Os relacionamentos entre as classes ficam a critério do desenvolvedor.  
- Siga o princípio de **baixo acoplamento e alta coesão**.  
- Estruture o código para facilitar futuras evoluções (ex: adicionar banco de dados ou API REST sem afetar o domínio).  
- Considere criar métodos ou classes para operações repetitivas, como apresentação de informações na tela.  

---

## 🧾 Requisitos
- O projeto deve estar em repositório público no **GitHub**.  
- O projeto deve conter um **README.md** com instruções de execução e operação da aplicação.  
- Desenhe um **diagrama de classes** e um **diagrama de sequência** para explicar o funcionamento do sistema (pode ser feito com **MermaidJS**).  

---

# 💻 Bank App

Uma aplicação bancária simples em **Java**, desenvolvida para simular operações básicas de um sistema bancário, com foco em **boas práticas de orientação a objetos, baixo acoplamento e alta coesão**.

---

## 🚀 Funcionalidades

A aplicação roda via **terminal** e permite as seguintes operações:

- ✅ Cadastro de conta bancária  
  - Número da conta (gerado automaticamente com 4 dígitos)  
  - Agência, titular, saldo inicial, limite e tipo de conta (corrente ou Poupança)
- 💰 Depósito
- 💸 Saque
- 🔄 Transferência entre contas (Em desenvolvimento)
- ⚙️ Alteração de limite
- 🕐 Limite de transferência por horário (ex: restrição após 22h)
- 📁 Exportação de histórico de transações em **CSV**

---

## 🧩 Tipos de Conta

| Tipo de Conta | Limite | Origem dos Depósitos | Transferências | Tarifa | Rendimento |
|----------------|------------------|--------|----------------------|----------------|---------|
| **Corrente** | Sim | Qualquer | Sim | Sim | Não |
| **Poupança** | Sim | Qualquer | Sim | Não | Sim |
