# Rato Mutante — mod Fabric 1.21.1

Um rato mutante tóxico com cristais verdes nas costas que brilham no escuro.
Feito com Fabric + GeckoLib a partir do modelo criado no Claude Design.

## O que o mod faz

- **Mob hostil**: 30 de vida, 5 de dano, pula em cima do alvo e a mordida dá **Veneno** por 5 s.
- **Onde aparece**: à noite / no escuro em todo o Overworld (raro) e bem mais comum em **pântanos e manguezais**.
- **Animações**: andar (trote), parado (respirando, mastigando, cauda balançando, partículas orbitando) e mordida (abre a mandíbula).
- **Brilho**: cristais, rachaduras, olhos e baba ficam acesos no escuro.
- **Drops**: slime ball, carne podre e, às vezes, pó de glowstone.
- **Ovo gerador** na aba de ovos do modo criativo.

## Compilar

Precisa do **Java 21** (JDK). No Windows: instale o *Temurin 21 LTS* em https://adoptium.net.

**Windows:** dê dois cliques em `compilar.bat`.
**Linux/macOS:** `./gradlew build`

Na primeira vez demora alguns minutos (baixa o Minecraft e as dependências).
O mod sai em `build/libs/mutant-rat-1.0.0.jar`.

**Sem instalar nada:** suba esta pasta para um repositório no GitHub. O workflow em
`.github/workflows/build.yml` compila sozinho; o `.jar` aparece em
*Actions → última execução → Artifacts*.

## Instalar e jogar

1. Instale o **Fabric Loader** para 1.21.1 (https://fabricmc.net/use/installer).
2. Coloque na pasta `mods`:
   - `mutant-rat-1.0.0.jar`
   - **Fabric API** para 1.21.1
   - **GeckoLib** (Fabric, 1.21.1, versão 4.7 ou mais nova)
3. Abra o jogo com o perfil do Fabric. Para testar: `/summon mutantrat:mutant_rat`.

## Testar direto do código

`./gradlew runClient` abre o Minecraft já com o mod carregado.

## Editar o modelo e as animações

- `blockbench/mutant_rat.bbmodel` abre no Blockbench (instale o plugin **GeckoLib Animation Utils**).
- Ao exportar, substitua:
  - `src/main/resources/assets/mutantrat/geo/entity/mutant_rat.geo.json`
  - `src/main/resources/assets/mutantrat/animations/entity/mutant_rat.animation.json`
- Mantenha os nomes das animações: `move.walk`, `misc.idle`, `attack.bite`.
- Ossos do modelo: `root`, `body`, `head`, `jaw`, `tail`, `leg_front_right`, `leg_front_left`, `leg_hind_right`, `leg_hind_left`, `particles`.

## Ajustar o comportamento

Tudo em `src/main/java/dev/mutantrat/`:
- `entity/MutantRatEntity.java`: vida, dano, velocidade, veneno, sons, IA.
- `MutantRatMod.java`: tamanho da hitbox, biomas e frequência de spawn, cores do ovo.
