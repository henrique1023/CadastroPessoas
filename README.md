**Explicações Técnicas**

Neste projeto, optei por não utilizar a injeção de dependência EJB devido a dificuldades encontradas durante a implementação. Em vez disso, recorri à utilização de um factory para realizar a injeção das configurações do banco de dados. Implementei o design pattern Factory para a camada de persistência do banco e utilizei validators para validações de campos.

**Frameworks**

Utilizei algumas frameworks como Hibernate e PrimeFaces, pois elas facilitam as implementações do banco de dados e a criação de interfaces de forma ágil.

**Instruções para Buildar o Projeto**

Para iniciar o projeto, primeiro execute o seguinte comando no banco de dados PostgreSQL:

```sql
INSERT INTO database bancopessoas;
```

Em seguida, no arquivo persistence.xml, altere os campos "usuario" e "senha" com as configurações do seu banco PostgreSQL:

```xml
<property name="javax.persistence.jdbc.user" value="seu_usuario" />
<property name="javax.persistence.jdbc.password" value="sua_senha" />
```

O projeto foi criado com o gerenciador de pacotes Maven. Após abrir o projeto em sua IDE, atualize os pacotes Maven e, em seguida, implante o projeto no Apache Tomcat e execute o Apache.

**Execução de Testes**

Os testes unitários estão automatizados. Para executá-los, acesse o arquivo de testes localizado em unitestes >>> mockito.services.
