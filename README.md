# Mini-RPG: Polimorfismo em Java

Aula de Programação Orientada a Objetos. Você vai explorar um pequeno RPG em modo texto e descobrir como cada personagem do mapa responde do seu jeito à mesma ação.

Os slides da aula estão em [Polimorfismo em Java Mini-RPG.pdf](Polimorfismo%20em%20Java%20Mini-RPG.pdf).

## Objetivos

- **Entender** o que é polimorfismo e por que ele deixa o código mais simples.
- **Sobrescrever** métodos usando herança, classe abstrata e `@Override`.
- **Criar** novos personagens sem mexer no restante do jogo.

## Como rodar

```bash
javac *.java
java Jogo
```

### Controles

| Tecla | Ação |
|-------|------|
| `W` `A` `S` `D` + Enter | Mover para cima, esquerda, baixo, direita |
| `Q` + Enter | Sair do jogo |

Para interagir com uma entidade, basta andar até a posição dela. O jogo termina com vitória quando todos os monstros forem derrotados, ou com game over se a sua vida chegar a zero.

### Mapa inicial

```
@ . . . . . . . . . . .
. . N . . . . . M . . .
. . . . . B . . . . . .
. . . . . . . . . . . .
. . . . M . . . . . . .
. . . . . . . . . . . .
. . . . . . . . . B . .
. . . . . . . . . . . D
```

| Símbolo | Significado |
|---------|-------------|
| `@` | Você (Jogador) |
| `N` | NPC: conversa com você |
| `B` | Baú: entrega ouro uma única vez |
| `M` | Monstro (Slime): luta até um dos dois cair |
| `D` | Dragão: monstro forte que às vezes cospe fogo |
| `C` | Curandeiro (aparece depois da Atividade 1) |

## Estrutura do código

```
Entidade (abstrata)
├── Npc
├── Bau
├── Curandeiro
└── Monstro
    ├── Slime
    └── Dragao
```

Cada linha indica uma relação "é um": um `Dragao` é um `Monstro`, que é uma `Entidade`.

| Arquivo | Papel |
|---------|-------|
| [Entidade.java](Entidade.java) | Superclasse abstrata. Define o contrato `interagir(Jogador)` e os métodos `simbolo()` e `ativa()`. |
| [Npc.java](Npc.java) | Mostra uma fala. |
| [Bau.java](Bau.java) | Dá ouro e some do mapa depois de aberto. |
| [Monstro.java](Monstro.java) | Contém o laço de batalha. Chama `atacar()`, que as subclasses podem sobrescrever. |
| [Slime.java](Slime.java) | Monstro fraco; herda tudo de `Monstro`. |
| [Dragao.java](Dragao.java) | Sobrescreve `atacar()`: dano dobrado a cada 3 turnos. |
| [Curandeiro.java](Curandeiro.java) | Esqueleto para a Atividade 1. |
| [Jogador.java](Jogador.java) | Vida, ataque, ouro e posição do jogador. |
| [Jogo.java](Jogo.java) | Monta o mundo, lê os comandos e desenha o mapa. |

### O momento do polimorfismo

Em [Jogo.java](Jogo.java), todas as entidades ficam guardadas numa `List<Entidade>`. Quando o jogador pisa numa delas, o jogo faz apenas:

```java
alvo.interagir(jogador);
```

O tipo da variável é `Entidade`, mas quem decide qual `interagir()` roda é o **objeto real**: um `Npc` fala, um `Bau` entrega ouro, um `Dragao` inicia uma batalha. O mesmo vale para `simbolo()` ao desenhar o mapa e para `atacar()` dentro da batalha.

## Atividade 1: o Curandeiro

O Curandeiro cura o jogador de graça na primeira visita e, depois disso, cobra 5 de ouro por cura.

1. Abra [Curandeiro.java](Curandeiro.java).
2. Implemente `interagir()` usando `jogador.curar(...)` e `jogador.gastarOuro(...)`.
3. Sobrescreva `simbolo()` para devolver `'C'`.
4. Descomente a linha do Curandeiro no construtor de [Jogo.java](Jogo.java).
5. Compile, jogue e teste as duas visitas.

> **Pergunta-chave:** você precisou mudar a lógica do `Jogo` para o Curandeiro funcionar?

## Atividade 2: escolha um desafio

| Nível | Desafio | O que fazer |
|-------|---------|-------------|
| Fácil | Armadilha | Causa 5 de dano ao pisar nela |
| Médio | Mercador | Vende +3 de ataque por 10 de ouro |
| Médio | Chefe | Estende `Dragao` e muda `atacar()` |
| Difícil | Interface | Crie a interface `Interagivel` e faça `Entidade` implementá-la |

**Bônus:** um Treinador que luta com 3 monstros em sequência.

Dica: para cada novo personagem, crie uma classe nova, escolha de quem ela herda e adicione uma instância ao `mundo` no construtor de `Jogo`.

## Perguntas para pensar

1. Por que `Entidade` é abstrata?
2. Em `Entidade e = new Dragao(...)`, qual `interagir()` roda, e por quê?
3. Se criarmos 5 novos personagens, o que muda em `Jogo.java`?

## Resumo

- Herança organiza os tipos; a classe abstrata define o contrato.
- `@Override` muda o comportamento em cada subclasse.
- Novos tipos entram no jogo sem alterar o código existente.

Próxima missão: interfaces e novos poderes.
