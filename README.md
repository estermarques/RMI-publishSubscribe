# Paradigma publish/subscribe
Alunos:
- Emerson Teixeira Nogueira Junior
- Ester Rodrigues Marques de Oliveira
- Luiz Gabriel Vieira

## Compilação e Execução
Para compilar o programa basta use o comando:
> javac -d class Ouvinte.java IOuvinte.java INotificador.java Notificador.java Topico.java

inicialiar rmi
> rmiregistry

E para executar o notificador e o ouvinte respectivamente use:

> java -cp ./class -Djava.rmi.server.codebase=file:./class/ -Djava.security.policy=policy pubSub.Notificador

> java -cp ./class -Djava.rmi.server.codebase=file:./class/ -Djava.security.policy=policy pubSub.Ouvinte